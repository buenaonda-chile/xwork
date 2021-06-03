package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.ConsultingDto;
import com.globaldenso.dicas.business.dto.ServiceDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.ConsultingService;
import com.globaldenso.dicas.business.service.ServiceService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.ConsultingForm;
import com.globaldenso.dicas.presentation.form.ConsultingSearchForm;
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
@RequestMapping(value = "/consulting")
public class ConsultingController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConsultingController.class);

  @Autowired
  private ConsultingService consultingService;

  @Autowired
  private ServiceService serviceService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ConsultingController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("TEMP0003")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.TEMP0003");

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(ConsultingSearchForm criteria, Pageable pageable) throws Exception {

    Page<ConsultingDto> consultingItems = consultingService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", consultingItems.getTotalElements());

    retMap.put("contents", consultingItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody ConsultingForm consultingForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    consultingService.create(consultingForm);
    mv.addObject("data", consultingForm);

    ServiceSearchForm criteria = new ServiceSearchForm();
    criteria.setManageNo(consultingForm.getManageNo());
    Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, null);
    List<ServiceDto> list = serviceItems.getContent();

    if (list.size() > 0) {
      ServiceDto dto = list.get(0);
      if ("01".equals(dto.getCondition())) {
        dto.setCondition("02");
        serviceService.update2(dto);
      }
    }

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody ConsultingForm consultingForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    consultingService.update(consultingForm);
    mv.addObject("data", consultingForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody ConsultingForm consultingForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    consultingService.delete(consultingForm);

    return mv;
  }

}
