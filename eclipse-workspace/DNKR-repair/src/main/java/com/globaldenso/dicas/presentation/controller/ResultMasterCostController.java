package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.ResultMasterCostDto;
import com.globaldenso.dicas.business.dto.ServiceDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.ResultMasterCostService;
import com.globaldenso.dicas.business.service.ServiceService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.ResultMasterCostForm;
import com.globaldenso.dicas.presentation.form.ResultMasterCostSearchForm;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globaldenso.dicas.presentation.form.ServiceSearchForm;
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
@RequestMapping(value = "/resultMasterCost")
public class ResultMasterCostController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResultMasterCostController.class);

  @Autowired
  private ResultMasterCostService resultmastercostService;

  @Autowired
  private ServiceService serviceService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ResultMasterCostController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("TEMP0099")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {



    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.TEMP0099");



    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(ResultMasterCostSearchForm criteria, Pageable pageable) throws Exception {

    criteria.setDiv("01");
    Page<ResultMasterCostDto> resultmastercostItems = resultmastercostService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", resultmastercostItems.getTotalElements());

    retMap.put("contents", resultmastercostItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search2")
  public ModelAndView search2(ResultMasterCostSearchForm criteria, Pageable pageable) throws Exception {

    criteria.setDiv("03");
    Page<ResultMasterCostDto> resultmastercostItems = resultmastercostService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", resultmastercostItems.getTotalElements());

    retMap.put("contents", resultmastercostItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody ResultMasterCostForm resultmastercostForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    resultmastercostService.create(resultmastercostForm);
    mv.addObject("data", resultmastercostForm);

    ServiceSearchForm criteria = new ServiceSearchForm();
    criteria.setManageNo(resultmastercostForm.getMngNo());
    Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, null);
    List<ServiceDto> list = serviceItems.getContent();

    if (list.size() > 0) {
      ServiceDto dto = list.get(0);
      if ("03".equals(dto.getCondition())) {
        dto.setCondition("04");
        serviceService.update2(dto);
      }
    }

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody ResultMasterCostForm resultmastercostForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    resultmastercostService.update(resultmastercostForm);
    mv.addObject("data", resultmastercostForm);

    ServiceSearchForm criteria = new ServiceSearchForm();
    criteria.setManageNo(resultmastercostForm.getMngNo());
    Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, null);
    List<ServiceDto> list = serviceItems.getContent();

    if (list.size() > 0) {
      ServiceDto dto = list.get(0);
      if ("03".equals(dto.getCondition())) {
        dto.setCondition("04");
        serviceService.update2(dto);
      }
    }

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody ResultMasterCostForm resultmastercostForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    resultmastercostService.delete(resultmastercostForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search3")
  public ModelAndView search3(ResultMasterCostSearchForm criteria, Pageable pageable) throws Exception {

    criteria.setDiv("02");
    Page<ResultMasterCostDto> resultmastercostItems = resultmastercostService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", resultmastercostItems.getTotalElements());

    retMap.put("contents", resultmastercostItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

}
