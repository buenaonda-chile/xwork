package com.globaldenso.dicas.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.*;
import com.globaldenso.dicas.business.service.*;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/trainingAppcntView")
public class TrainingAppcntViewController {

  private static final Logger LOGGER = LoggerFactory.getLogger(TrainingAppcntViewController.class);

  @Autowired
  private TrainingAppcntViewService trainingAppcntViewService;

  @Autowired
  private CodeService codeService;

  @Autowired
  private MainCategoryService maincategoryService;

  @Autowired
  private SubCategoryService subcategoryService;

  @Autowired
  private DtcService dtcService;

  @Autowired
  private OfficeService officeService;

  @Autowired
  private UserService userService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public TrainingAppcntViewController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("EDU0002")
  public ModelAndView init(HttpServletRequest request,
	  HttpServletResponse response) throws Exception {
	  
//	  CodeSearchForm searchForm = new CodeSearchForm();
//	  searchForm.setGrpCds(Arrays.asList(new String[] {
//			    DicasConstant.CodeGroupAttribute.EDUCATION
//	          , DicasConstant.CodeGroupAttribute.ONOFFYN
//	  }));
//	  
//	  searchForm.setUseYn("Y");
//	  
//	  List<CodeDto> codeList = codeService.searchCodeByCondition(searchForm);
//
//	  List<CodeDto> educationList = codeList
//	      .stream()
//	      .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.EDUCATION))
//	      .collect(Collectors.toList());
//	  
//	  TrainingAppcntViewSearchForm searchForm2 = new TrainingAppcntViewSearchForm();
//	  searchForm2.setGrpCds(Arrays.asList(new String[] {
//			    DicasConstant.CodeGroupAttribute.EDUCATION
//	  }));
//	  
//	  List<TrainingAppcntViewDto> codeList2 = trainingAppcntViewService.searchServiceByCondition(searchForm2);
//	  
//	  List<TrainingAppcntViewDto> onOffList = codeList2
//            .stream()
//            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.EDUCATION))
//            .collect(Collectors.toList());
//	  
//	  ObjectMapper mapper = new ObjectMapper();
//	  String jsonEducationItems = "";
//	  try {
//		  jsonEducationItems = mapper.writeValueAsString(educationList);
//	  } catch (IOException ex) {
//	    ex.printStackTrace();
//	  }
//	  
//	  mapper = new ObjectMapper();
//	  String jsonOnOffItems = "";
//	  try {
//		  jsonOnOffItems = mapper.writeValueAsString(onOffList);
//	  } catch (IOException ex) {
//	    ex.printStackTrace();
//	  }

	  ModelAndView mv = new ModelAndView();
	  mv.setViewName(".tiles.page.edu.EDU0002");
//	  mv.addObject("educationItems", jsonEducationItems);
//	  mv.addObject("onoffItems", jsonOnOffItems);
	
	  LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	  mv.addObject("loginVO", loginVO);
	
	  return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(TrainingAppcntViewSearchForm criteria, Pageable pageable) throws Exception {

    Page<TrainingAppcntViewDto> trainingAppcntViewItems = trainingAppcntViewService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", trainingAppcntViewItems.getTotalElements());

    retMap.put("contents", trainingAppcntViewItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/download")
  public ModelAndView download(TrainingAppcntViewSearchForm criteria) throws Exception {

    ModelAndView mv = new ModelAndView("trainingAppcntViewFormXlsView");

    Page<TrainingAppcntViewDto> codeItems = trainingAppcntViewService.searchByCondition(criteria, null);

    Map<String, Object> modelMap = new HashMap<>();
    modelMap.put("result", codeItems.getContent());

    mv.addAllObjects(modelMap);

    return mv;
  }
  
  
  @RequestMapping(value = "/list.json/{grpCd}")
  @ResponseBody
  public Map<String, Object> getCodeList(@RequestBody TrainingAppcntViewSearchForm criteria) throws Exception {

//	criteria.setUseYn("Y");
//	criteria.setGrpCd(grpCd);
	  
    List<TrainingAppcntViewDto> codeItems = trainingAppcntViewService.searchServiceByCondition(criteria);

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("data", codeItems);
    retMap.put("total", codeItems.size());

    return retMap;
  }

}
