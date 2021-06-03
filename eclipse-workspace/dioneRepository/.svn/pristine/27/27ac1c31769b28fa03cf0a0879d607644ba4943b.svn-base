package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.OfficeDetailDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.OfficeDetailService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.OfficeDetailForm;
import com.globaldenso.dicas.presentation.form.OfficeDetailSearchForm;
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
@RequestMapping(value = "/officedetail")
public class OfficeDetailController {

  private static final Logger LOGGER = LoggerFactory.getLogger(OfficeDetailController.class);

  @Autowired
  private OfficeDetailService officedetailService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public OfficeDetailController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0098")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {



    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.WCM0098");



    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(OfficeDetailSearchForm criteria, Pageable pageable) throws Exception {

    Page<OfficeDetailDto> officedetailItems = officedetailService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", officedetailItems.getTotalElements());

    retMap.put("contents", officedetailItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody OfficeDetailForm officedetailForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    officedetailService.create(officedetailForm);
    mv.addObject("data", officedetailForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody OfficeDetailForm officedetailForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    officedetailService.update(officedetailForm);
    mv.addObject("data", officedetailForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody OfficeDetailForm officedetailForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    officedetailService.delete(officedetailForm);

    return mv;
  }
}
