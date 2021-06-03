package com.globaldenso.dicas.business.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.AtchmnflDao;
import com.globaldenso.dicas.business.domain.AtchmnflDomain;
import com.globaldenso.dicas.business.dto.AtchmnflDto;
import com.globaldenso.dicas.business.dto.FileSaveResultDto;
import com.globaldenso.dicas.business.service.AtchmnflService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.AtchmnflSearchForm;
import com.globaldenso.dicas.security.common.LoginVO;
import com.globaldenso.dicas.util.DicasWebUtil;
import egovframework.rte.fdl.filehandling.EgovFileUtil;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.string.EgovStringUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import javax.annotation.Resource;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("atchmnflService")
public class AtchmnflServiceImpl implements AtchmnflService {

  private static final Logger LOGGER = LoggerFactory.getLogger(AtchmnflServiceImpl.class);

  @Autowired
  private AtchmnflDao atchmnflDao;

  @Resource(name = "propertiesService")
  protected EgovPropertyService propertiesService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public AtchmnflServiceImpl() {
    // no process
  }

  @Override
  public AtchmnflDto searchByKey(AtchmnflDto atchmnflDto) throws ApplicationException {
    return atchmnflDao.searchByKey(atchmnflDto);
  }

  @Override
  public List<AtchmnflDto> searchByCondition(AtchmnflSearchForm criteria)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);

    long start = System.currentTimeMillis(); // 시작하는 시점 계산

    List<AtchmnflDto> atchmnflDtos = atchmnflDao.searchByCondition(searchMap);

    long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
    LOGGER.info("목록 실행 시간 : " + (end - start) / 1000.0 + "초");

    return atchmnflDtos;
  }

  @Override
  public FileSaveResultDto save(MultipartFile file, String metadata) throws ApplicationException {

    ObjectMapper objectMapper = new ObjectMapper();

    long totalChunks = 0, chunkIndex = 0, totalFileSize;
    String uploadUid = null, fileName = null;

    try {
      JsonNode rootNode = objectMapper.readTree(metadata);
      totalChunks = rootNode.path("totalChunks").asLong();
      totalFileSize = rootNode.path("totalFileSize").asLong();
      chunkIndex = rootNode.path("chunkIndex").asLong();
      uploadUid = rootNode.path("uploadUid").asText();
      fileName = rootNode.path("fileName").asText();
    } catch (IOException ex) {
      throw new ApplicationException("AI-90-0002", ex);
    }

    String strePath = propertiesService.getString("streFlpth");

    File saveDir = new File(DicasWebUtil.filePathBlackList(strePath));

    if (!saveDir.exists() || saveDir.isFile()) {
      if (saveDir.mkdirs()) {
        LOGGER.debug("[file.mkdirs] saveFolder : Creation Success ");
      } else {
        LOGGER.error("[file.mkdirs] saveFolder : Creation Fail ");
      }
    }

    File serverFile = new File(saveDir.getAbsolutePath()
        + File.separator + uploadUid);

    try {
      byte[] bytes = file.getBytes();
      BufferedOutputStream stream = new BufferedOutputStream(
          new FileOutputStream(serverFile,true));
      stream.write(bytes);
      stream.close();
    } catch (IOException ex) {
      throw new ApplicationException("AI-90-0002", ex);
    }

    FileSaveResultDto resultDto = new FileSaveResultDto();
    resultDto.setUploaded(totalChunks - 1 <= chunkIndex);
    resultDto.setFileUid(uploadUid);

    if (resultDto.getUploaded()) {

      LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

      String newFileNm = "FILE_" + getTimeStamp() + "_" + loginVO.getUsername();

      try {
        Path source = Paths.get(saveDir.getAbsolutePath()
            + File.separator + uploadUid);
        Files.move(source, source.resolveSibling(newFileNm));
      } catch (IOException ex) {
        throw new ApplicationException("AI-90-0002", ex);
      }

      AtchmnflDto atchmnflDto = new AtchmnflDto();

      atchmnflDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
      atchmnflDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

      atchmnflDto.setAtchmnflNm(fileName);
      atchmnflDto.setFlstreNm(newFileNm);
      atchmnflDto.setFlpth(strePath);
      atchmnflDto.setAtchmnflUid(uploadUid);
      atchmnflDto.setAtchmnflSize(totalFileSize);
      atchmnflDto.setFlext(FilenameUtils.getExtension(fileName));
      atchmnflDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
      atchmnflDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

      create(atchmnflDto);

      resultDto.setAtchmnflId(String.valueOf(atchmnflDto.get_id()));
    }

    return resultDto;
  }

  private void create(AtchmnflDto atchmnflDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    atchmnflDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    atchmnflDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    atchmnflDao.create(atchmnflDto);
  }

  @Override
  public void delete(long atchmnflId) throws ApplicationException {

    AtchmnflDto atchmnflDto = new AtchmnflDto() {{
      set_id(atchmnflId);
    }};

    AtchmnflDto oldAtchmnflDto = searchByKey(atchmnflDto);

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    oldAtchmnflDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
    oldAtchmnflDto.setUpdtDt(null);
    oldAtchmnflDto.setDelYn("Y");

    atchmnflDao.update(oldAtchmnflDto);
  }

  private static String getTimeStamp() {

    String rtnStr = null;

    // 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
    String pattern = "yyyyMMddhhmmssSSS";

    SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
    Timestamp ts = new Timestamp(System.currentTimeMillis());

    rtnStr = sdfCurrent.format(ts.getTime());

    return rtnStr;
  }
}
