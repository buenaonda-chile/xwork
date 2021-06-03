package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.ResultSubDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.ResultSubService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.ResultSubForm;
import com.globaldenso.dicas.presentation.form.ResultSubSearchForm;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/resultSub")
public class ResultSubController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResultSubController.class);

  @Autowired
  private ResultSubService resultsubService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ResultSubController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("TEMP0098")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {



    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.TEMP0098");



    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(ResultSubSearchForm criteria, Pageable pageable) throws Exception {

    Page<ResultSubDto> resultsubItems = resultsubService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", resultsubItems.getTotalElements());

    retMap.put("contents", resultsubItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody ResultSubForm resultsubForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    resultsubService.create(resultsubForm);
    mv.addObject("data", resultsubForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody ResultSubForm resultsubForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    resultsubService.update(resultsubForm);
    mv.addObject("data", resultsubForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody ResultSubForm resultsubForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    resultsubService.delete(resultsubForm);

    return mv;
  }

}
