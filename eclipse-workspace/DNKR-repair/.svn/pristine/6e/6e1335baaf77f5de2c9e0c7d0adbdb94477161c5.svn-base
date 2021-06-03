package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.PhenomenonDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.PhenomenonService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.PhenomenonForm;
import com.globaldenso.dicas.presentation.form.PhenomenonSearchForm;
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
@RequestMapping(value = "/phenomenon")
public class PhenomenonController {

  private static final Logger LOGGER = LoggerFactory.getLogger(PhenomenonController.class);

  @Autowired
  private PhenomenonService phenomenonService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public PhenomenonController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("TEMP0001")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {



    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.TEMP0001");



    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(PhenomenonSearchForm criteria, Pageable pageable) throws Exception {

    Page<PhenomenonDto> phenomenonItems = phenomenonService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", phenomenonItems.getTotalElements());

    retMap.put("contents", phenomenonItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody PhenomenonForm phenomenonForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    phenomenonService.create(phenomenonForm);
    mv.addObject("data", phenomenonForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody PhenomenonForm phenomenonForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    phenomenonService.update(phenomenonForm);
    mv.addObject("data", phenomenonForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody PhenomenonForm phenomenonForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    phenomenonService.delete(phenomenonForm);

    return mv;
  }

}
