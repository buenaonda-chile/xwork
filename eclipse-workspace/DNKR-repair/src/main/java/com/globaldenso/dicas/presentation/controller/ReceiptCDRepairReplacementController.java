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
@RequestMapping(value = "/receiptCDRepairReplacement")
public class ReceiptCDRepairReplacementController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiptCDRepairReplacementController.class);

  @Autowired
  private ReceiptCDRepairReplacementService receiptCDRepairReplacementService;

  @Autowired
  private CodeService codeService;

  @Autowired
  private UserService userService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ReceiptCDRepairReplacementController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("CD0007")
  public ModelAndView init(HttpServletRequest request,
	  HttpServletResponse response) throws Exception {
	  
	  CodeSearchForm searchForm = new CodeSearchForm();
	  searchForm.setGrpCds(Arrays.asList(new String[] {
			    DicasConstant.CodeGroupAttribute.RECEIPT_STATUS
	  }));
	  
	  
	  List<CodeDto> codeList = codeService.searchCodeByCondition(searchForm);
	  
	  List<CodeDto> statusList = codeList
	      .stream()
	      .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.RECEIPT_STATUS))
	      .collect(Collectors.toList());
	  
	  
	  ObjectMapper mapper = new ObjectMapper();
	  String jsonStatusItems = "";
	  try {
		  jsonStatusItems = mapper.writeValueAsString(statusList);
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }
	  

	  ModelAndView mv = new ModelAndView();
	  mv.setViewName(".tiles.page.cd.CD0007");
	
	  LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	  mv.addObject("loginVO", loginVO);
	
	  return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(ReceiptCDRepairReplacementSearchForm criteria, Pageable pageable) throws Exception {

	Page<ReceiptCDRepairReplacementDto> ReceiptCDRepairReplacements = receiptCDRepairReplacementService.searchByCondition(criteria, pageable);  
	  
    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", ReceiptCDRepairReplacements.getTotalElements());

    retMap.put("contents", ReceiptCDRepairReplacements.getContent());
    retMap.put("pagination", pageMap);
    
    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	mv.addObject("loginVO", loginVO);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
    
  }
  
  //wijmo?????? ????????????.
  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(ReceiptCDRepairReplacementForm receiptCDRepairReplacementForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    
    receiptCDRepairReplacementService.createMst(receiptCDRepairReplacementForm);
    receiptCDRepairReplacementService.createDtl(receiptCDRepairReplacementForm);
    mv.addObject("result", true);
    
    return mv;
  }
  
  //wijmo?????? ????????????.
  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(ReceiptCDRepairReplacementForm receiptCDRepairReplacementForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    receiptCDRepairReplacementService.updateMst(receiptCDRepairReplacementForm);
    receiptCDRepairReplacementService.updateDtl(receiptCDRepairReplacementForm);
    mv.addObject("result", true);

    return mv;
  }
  
  //wijmo?????? ????????????.
  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(ReceiptCDRepairReplacementForm receiptCDRepairReplacementForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    receiptCDRepairReplacementService.deleteMst(receiptCDRepairReplacementForm);
    receiptCDRepairReplacementService.deleteDtl(receiptCDRepairReplacementForm);
    mv.addObject("result", true);
    
    return mv;
  }

}
