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
@RequestMapping(value = "/customerPopUp")
public class CustomerPopUpController {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerPopUpController.class);

  @Autowired
  private CustomerPopUpService customerPopUpService;
  
  @Autowired
  private UserService userService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public CustomerPopUpController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("POP0002")
  public ModelAndView init(HttpServletRequest request,
	  HttpServletResponse response) throws Exception {
	  
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName(".tiles.page.popup.POP0002");
	
	  LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	  mv.addObject("loginVO", loginVO);
	
	  return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(CustomerPopUpSearchForm criteria, Pageable pageable) throws Exception {

	Page<CustomerPopUpDto> CustomerPopUpItems = customerPopUpService.searchByCondition(criteria, pageable);  

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", CustomerPopUpItems.getTotalElements());

    retMap.put("contents", CustomerPopUpItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
    
  }

}
