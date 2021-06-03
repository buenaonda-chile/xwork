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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/trainingAppView")
public class TrainingAppViewController {

  private static final Logger LOGGER = LoggerFactory.getLogger(TrainingAppViewController.class);

  @Autowired
  private TrainingAppViewService trainingAppViewService;

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
  public TrainingAppViewController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("EDU0005")
  public ModelAndView init(HttpServletRequest request,
	  HttpServletResponse response) throws Exception {
	  
	  CodeSearchForm searchForm = new CodeSearchForm();
	  searchForm.setGrpCds(Arrays.asList(new String[] {
			    DicasConstant.CodeGroupAttribute.EDUCATION
	          , DicasConstant.CodeGroupAttribute.ONOFFYN
	          , DicasConstant.CodeGroupAttribute.RANCD
	  }));
	  
	  searchForm.setUseYn("Y");
	  
	  List<CodeDto> codeList = codeService.searchCodeByCondition(searchForm);
	  
	  List<CodeDto> educationList = codeList
	      .stream()
	      .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.EDUCATION))
	      .collect(Collectors.toList());
	  
	  List<CodeDto> onOffList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.ONOFFYN))
            .collect(Collectors.toList());
	  
	  List<CodeDto> rnkList = codeList
	            .stream()
	            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.RANCD))
	            .collect(Collectors.toList());
	  
	  ObjectMapper mapper = new ObjectMapper();
	  String jsonEducationItems = "";
	  try {
		  jsonEducationItems = mapper.writeValueAsString(educationList);
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }
	  
	  mapper = new ObjectMapper();
	  String jsonOnOffItems = "";
	  try {
		  jsonOnOffItems = mapper.writeValueAsString(onOffList);
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }
	  
	  mapper = new ObjectMapper();
	  String jsonRnkItems = "";
	  try {
		  jsonRnkItems = mapper.writeValueAsString(rnkList);
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }

	  ModelAndView mv = new ModelAndView();
	  mv.setViewName(".tiles.page.edu.EDU0005");
	  mv.addObject("educationItems", jsonEducationItems);
	  mv.addObject("onoffItems", jsonOnOffItems);
	  mv.addObject("rnkItems", jsonRnkItems);
	
		/*
		 * LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		 * mv.addObject("loginVO", loginVO);
		 */
	
	  return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(TrainingAppViewSearchForm criteria, Pageable pageable) throws Exception {

    Page<TrainingAppViewDto> trainingAppViewItems = trainingAppViewService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", trainingAppViewItems.getTotalElements());

    retMap.put("contents", trainingAppViewItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  /**
   * 2021-03-17
   * @param criteria
   * @param pageable
   * @return
   * @throws Exception
   */
  @RequestMapping(method = RequestMethod.GET, value = "/searchSd")
  public ModelAndView searchSd(TrainingAppViewSearchForm criteria, Pageable pageable) throws Exception {

    Page<TrainingAppViewDto> trainingAppViewItems = trainingAppViewService.searchBySdCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", trainingAppViewItems.getTotalElements());

    retMap.put("contents", trainingAppViewItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

	/*
	 * @RequestMapping(method = RequestMethod.POST, value="/create") public
	 * ModelAndView create(@RequestBody TrainingAppViewForm trainingAppViewForm)
	 * throws Exception {
	 * 
	 * Long getId; ModelAndView mv = new ModelAndView("jsonView");
	 * 
	 * getId = trainingAppViewService.create(trainingAppViewForm);
	 * TrainingAppViewDto trainingAppViewDto =
	 * trainingAppViewService.searchByKey(trainingAppViewForm); //
	 * trainingInfoBaseForm.setManageNo(trainingInfoBaseDto.getManageNo());
	 * mv.addObject("data", trainingAppViewForm); mv.addObject("result", getId);
	 * 
	 * return mv; }
	 * 
	 * @RequestMapping(method = RequestMethod.POST, value="/create2") public
	 * ModelAndView create2(@RequestBody TrainingAppViewForm trainingAppViewForm)
	 * throws Exception {
	 * 
	 * ModelAndView mv = new ModelAndView("jsonView");
	 * 
	 * trainingAppViewService.create2(trainingAppViewForm); TrainingAppViewDto
	 * trainingAppViewDto = trainingAppViewService.searchByKey(trainingAppViewForm);
	 * // trainingInfoBaseForm.setManageNo(trainingInfoBaseDto.getManageNo());
	 * mv.addObject("data", trainingAppViewForm);
	 * 
	 * return mv; }
	 * 
	 * @RequestMapping(method = RequestMethod.POST, value="/update") public
	 * ModelAndView update(@RequestBody TrainingAppViewForm trainingAppViewForm)
	 * throws Exception {
	 * 
	 * ModelAndView mv = new ModelAndView("jsonView");
	 * 
	 * trainingAppViewService.update(trainingAppViewForm); mv.addObject("data",
	 * trainingAppViewForm);
	 * 
	 * return mv; }
	 * 
	 * @RequestMapping(method = RequestMethod.POST, value="/delete") public
	 * ModelAndView delete(@RequestBody TrainingAppViewForm trainingAppViewForm)
	 * throws Exception {
	 * 
	 * ModelAndView mv = new ModelAndView("jsonView");
	 * trainingAppViewService.delete(trainingAppViewForm);
	 * 
	 * return mv; }
	 */

}
