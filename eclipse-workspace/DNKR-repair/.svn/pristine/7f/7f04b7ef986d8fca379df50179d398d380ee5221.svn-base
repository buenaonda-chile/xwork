package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.CodeDao;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("codeService")
public class CodeServiceImpl implements CodeService {

  private static final Logger LOGGER = LoggerFactory.getLogger(CodeServiceImpl.class);

  @Autowired
  private CodeDao codeDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public CodeServiceImpl() {
    // no process
  }

  public void setCodeDao(CodeDao codeDao) {
    this.codeDao = codeDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param codeDto CodeDto
   */
  @Override
  public CodeDto searchByKey(CodeDto codeDto) throws ApplicationException {
    return codeDao.searchByKey(codeDto);
  }

  @Override
  public Page<CodeDto> searchByCondition(CodeSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //시작하는 시점 계산

    int totalCount = 0;
    if (pageable != null)
      totalCount = codeDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
    LOGGER.info("카운트 실행 시간 : " + (end - start) / 1000.0 + "초");

    start = System.currentTimeMillis(); //시작하는 시점 계산

    List<CodeDto> codeDtos = codeDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = codeDtos.size();

    end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
    LOGGER.info("목록 실행 시간 : " + (end - start) / 1000.0 + "초");

    return new PageImpl<>(codeDtos, pageable, totalCount);
  }

  @Override
  public List<CodeDto> searchGrpCdByCondition(CodeSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<CodeDto> searchCodeByCondition(CodeSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(CodeDto codeDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    codeDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    codeDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    codeDao.create(codeDto);
  }

  @Override
  public void update(CodeDto codeDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    codeDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    codeDao.update(codeDto);
  }

  @Override
  public void delete(CodeDto codeDto) throws ApplicationException {

    codeDto.setUseYn("N");
    update(codeDto);
  }
}
