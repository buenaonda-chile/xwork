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
@RequestMapping(value = "/receiptSDRepairItem")
public class ReceiptSDRepairItemController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiptSDRepairItemController.class);

  @Autowired
  private ReceiptSDRepairItemService receiptSDRepairItemService;

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
  public ReceiptSDRepairItemController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("SD0004")
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
	  mv.setViewName(".tiles.page.sd.SD0004");
	
	  LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	  mv.addObject("loginVO", loginVO);
	
	  return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(ReceiptSDRepairItemSearchForm criteria, Pageable pageable) throws Exception {

	Page<ReceiptSDRepairItemDto> ReceiptSDRepairItems = receiptSDRepairItemService.searchByCondition(criteria, pageable);  
	  
    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", ReceiptSDRepairItems.getTotalElements());

    retMap.put("contents", ReceiptSDRepairItems.getContent());
    retMap.put("pagination", pageMap);
    
    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	mv.addObject("loginVO", loginVO);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
    
  }
  
  //wijmo에서 등록할때.
  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(ReceiptSDRepairItemForm receiptSDRepairItemForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    
    receiptSDRepairItemService.createMst(receiptSDRepairItemForm);
    receiptSDRepairItemService.createDtl(receiptSDRepairItemForm);
    mv.addObject("result", true);
    
    return mv;
  }
  
  //wijmo에서 수정할때.
  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(ReceiptSDRepairItemForm receiptSDRepairItemForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    receiptSDRepairItemService.updateMst(receiptSDRepairItemForm);
    receiptSDRepairItemService.updateDtl(receiptSDRepairItemForm);
    mv.addObject("result", true);

    return mv;
  }
  
  //wijmo에서 삭제할때.
  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(ReceiptSDRepairItemForm receiptSDRepairItemForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    receiptSDRepairItemService.deleteMst(receiptSDRepairItemForm);
    receiptSDRepairItemService.deleteDtl(receiptSDRepairItemForm);
    mv.addObject("result", true);
    
    return mv;
  }

}
