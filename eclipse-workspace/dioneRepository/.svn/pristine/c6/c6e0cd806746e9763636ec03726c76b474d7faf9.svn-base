package com.globaldenso.dicas.presentation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.AtchmnflDto;
import com.globaldenso.dicas.business.dto.FileSaveResultDto;
import com.globaldenso.dicas.business.dto.UserDto;
import com.globaldenso.dicas.business.service.AtchmnflService;
import com.globaldenso.dicas.business.service.UserService;
import com.globaldenso.dicas.util.DicasFileMngUtil;
import egovframework.rte.fdl.filehandling.EgovFileUtil;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/api/file")
public class FileApiController {

  private static final Logger LOGGER = LoggerFactory.getLogger(FileApiController.class);

  @Autowired
  private AtchmnflService atchmnflService;

  @Autowired
  private UserService userService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public FileApiController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0000")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    ModelAndView mv = new ModelAndView();

    mv.setViewName(".tiles.page.cmmn.WCM0000");
    mv.addObject("_editor_", "tui");

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/upload", consumes = {"multipart/form-data"})
  public void upload(
      final MultipartHttpServletRequest multipartHttpServletRequest,
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("result", "OK");

//    files.putAll(multipartHttpServletRequest.getFileMap());

    response.setContentType("text/plain");

    ObjectMapper objectMapper = new ObjectMapper();
    String strJson = objectMapper.writeValueAsString(retMap);

    response.getWriter().write(strJson);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public void search(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("result", "OK");

    response.setContentType("text/plain");

    ObjectMapper objectMapper = new ObjectMapper();
    String strJson = objectMapper.writeValueAsString(retMap);

    response.getWriter().write(strJson);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/delete/{atchmnflId}")
  public void delete(@PathVariable("atchmnflId") String atchmnflId,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("result", "OK");
    retMap.put("atchmnflId", atchmnflId);

    atchmnflService.delete(Long.parseLong(atchmnflId));

    response.setContentType("text/plain");

    ObjectMapper objectMapper = new ObjectMapper();
    String strJson = objectMapper.writeValueAsString(retMap);

    response.getWriter().write(strJson);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/chunk")
  public @ResponseBody String chunk(@RequestParam("uploadFile") MultipartFile file, String metadata)
      throws ApplicationException {

    String resultJson = "";

    if (metadata != null) {

      ObjectMapper objectMapper = new ObjectMapper();

      FileSaveResultDto fileResult = atchmnflService.save(file, metadata);

      try {
        resultJson = objectMapper.writeValueAsString(fileResult);
      } catch (JsonProcessingException ex) {
        throw new ApplicationException("AI-90-0001", ex);
      }
    }

    return resultJson;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/download/{atchmnFlId}")
  public void download(@PathVariable("atchmnFlId") String atchmnFlId,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    AtchmnflDto atchmnflDto = new AtchmnflDto();
    atchmnflDto.set_id(Long.parseLong(atchmnFlId));

    atchmnflDto = atchmnflService.searchByKey(atchmnflDto);

    request.setAttribute("downFile", atchmnflDto.getFlpth() + "/" + atchmnflDto.getFlstreNm());
    request.setAttribute("orginFile", atchmnflDto.getAtchmnflNm());

    DicasFileMngUtil.downFile(request, response);
  }
}
