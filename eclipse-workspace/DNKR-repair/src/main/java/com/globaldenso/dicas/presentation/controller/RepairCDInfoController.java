package com.globaldenso.dicas.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.*;
import com.globaldenso.dicas.business.service.*;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
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

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/repairCDInfo")
public class RepairCDInfoController {

  private static final Logger LOGGER = LoggerFactory.getLogger(RepairCDInfoController.class);

  @Autowired
  private RepairCDInfoService repairCDInfoService;

  @Autowired
  private CodeService codeService;

  @Autowired
  private OfficeService officeService;

  @Autowired
  private UserService userService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public RepairCDInfoController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("CD0002")
  public ModelAndView init(HttpServletRequest request,
	  HttpServletResponse response) throws Exception {
	  
	  CodeSearchForm searchForm = new CodeSearchForm();
	  searchForm.setGrpCds(Arrays.asList(new String[] {
			    DicasConstant.CodeGroupAttribute.REPAIR_STATUS,
			    DicasConstant.CodeGroupAttribute.NG_TYPE
	  }));
	  
	  
	  List<CodeDto> codeList = codeService.searchCodeByCondition(searchForm);
	  
	  List<CodeDto> statusList = codeList
	      .stream()
	      .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.REPAIR_STATUS))
	      .collect(Collectors.toList());
	  
	  List<CodeDto> ngTypeList = codeList
		      .stream()
		      .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.NG_TYPE))
		      .collect(Collectors.toList());
	  
	  ObjectMapper mapper = new ObjectMapper();
	  String jsonStatusItems = "";
	  try {
		  jsonStatusItems = mapper.writeValueAsString(statusList);
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }
	  
	  mapper = new ObjectMapper();
	  String jsonNgTypeItems = "";
	  try {
		  jsonNgTypeItems = mapper.writeValueAsString(ngTypeList);
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }
	  

	  ModelAndView mv = new ModelAndView();
	  mv.setViewName(".tiles.page.cd.CD0002");
	
	  LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	  mv.addObject("loginVO", loginVO);
	
	  return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(RepairCDInfoSearchForm criteria, Pageable pageable) throws Exception {

	Page<RepairCDInfoDto> RepairCDInfoItems = repairCDInfoService.searchByCondition(criteria, pageable);  
	  
    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", RepairCDInfoItems.getTotalElements());

    retMap.put("contents", RepairCDInfoItems.getContent());
    retMap.put("pagination", pageMap);
    
    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	mv.addObject("loginVO", loginVO);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
    
  }
  
  //wijmo?????? ????????????.
  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(RepairCDInfoForm repairCDInfoForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    
    repairCDInfoService.create(repairCDInfoForm);
    mv.addObject("result", true);
    
    return mv;
  }
  
  //wijmo?????? ????????????.
  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(RepairCDInfoForm repairCDInfoForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    repairCDInfoService.update(repairCDInfoForm);
    mv.addObject("result", true);

    return mv;
  }
  
  //wijmo?????? ????????????.
  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(RepairCDInfoForm repairCDInfoForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    repairCDInfoService.delete(repairCDInfoForm);
    mv.addObject("result", true);
    
    return mv;
  }

}
