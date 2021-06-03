package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.ResultMasterCostDto;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ServiceDto;
import com.globaldenso.dicas.business.service.ResultMasterCostService;
import com.globaldenso.dicas.business.service.ResultMasterService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globaldenso.dicas.business.service.ServiceService;
import com.globaldenso.dicas.presentation.form.ResultMasterCostSearchForm;
import com.globaldenso.dicas.presentation.form.ResultMasterForm;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ServiceSearchForm;
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
@RequestMapping(value = "/costApprove")
public class CostApproveController {

  private static final Logger LOGGER = LoggerFactory.getLogger(CostApproveController.class);

  @Autowired
  private ResultMasterService resultmasterService;

  @Autowired
  private ResultMasterCostService resultmastercostService;

  @Autowired
  private ServiceService serviceService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public CostApproveController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WWK0006")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.work.WWK0006");

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(ResultMasterSearchForm criteria, Pageable pageable) throws Exception {

    //Page<ResultMasterDto> resultmasterItems = resultmasterService.searchByCondition(criteria, pageable);
    Page<ResultMasterDto> resultmasterItems = resultmasterService.searchListByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", resultmasterItems.getTotalElements());

    retMap.put("contents", resultmasterItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody ResultMasterForm resultmasterForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    resultmasterService.update3(resultmasterForm);
    mv.addObject("data", resultmasterForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/costSearch")
  public ModelAndView search2(ServiceSearchForm criteria, Pageable pageable) throws Exception {

    Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, null);

    String partDiv = "";
    List<ServiceDto> list = serviceItems.getContent();
    for (ServiceDto sto : list) {
      partDiv = sto.getInquiryGubun();
      break;
    }

    ModelAndView mv = new ModelAndView("jsonView");

    if ("01".equals(partDiv) || "03".equals(partDiv)) {
      //커먼레일
      ResultMasterCostSearchForm criteria2 = new ResultMasterCostSearchForm();
      criteria2.setManageNo(criteria.getManageNo());
      criteria2.setDiv("03");
      Page<ResultMasterCostDto> resultmastercostItems = resultmastercostService.searchByCondition(criteria2, pageable);

      Map<String, Object> retMap = new HashMap<>();

      Map<String, Object> pageMap = new HashMap<>();
      pageMap.put("page", pageable.getPageNumber());
      pageMap.put("totalCount", resultmastercostItems.getTotalElements());

      retMap.put("contents", resultmastercostItems.getContent());
      retMap.put("pagination", pageMap);

      mv.addObject("result", true);
      mv.addObject("data", retMap);

    } else if ("02".equals(partDiv)) {
      //에어컨
      ResultMasterSearchForm criteria2 = new ResultMasterSearchForm();
      criteria2.setManageNo(criteria.getManageNo());
      Page<ResultMasterDto> resultmasterItems = resultmasterService.searchByCondition2(criteria2, pageable);

      List<ResultMasterCostDto> list2 = new ArrayList<ResultMasterCostDto>();
      for (ResultMasterDto dto : resultmasterItems) {
        ResultMasterCostDto dto2 = new ResultMasterCostDto();
        dto2.setCostNm(dto.getReplacePartNm());
        dto2.setCostValue(dto.getWorkHour());
        dto2.setServiceSeq(dto.getServiceDegree());
        dto2.setMngNo(dto.getManageNo());
        list2.add(dto2);
      }

      Map<String, Object> retMap = new HashMap<>();

      Map<String, Object> pageMap = new HashMap<>();
      pageMap.put("page", pageable.getPageNumber());
      pageMap.put("totalCount", resultmasterItems.getTotalElements());

      retMap.put("contents", list2);
      retMap.put("pagination", pageMap);

      mv.addObject("result", true);
      mv.addObject("data", retMap);
    }

    return mv;
  }

}
