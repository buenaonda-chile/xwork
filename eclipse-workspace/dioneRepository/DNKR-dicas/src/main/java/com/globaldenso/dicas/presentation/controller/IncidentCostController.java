package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.IncidentCostDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.IncidentCostService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.IncidentCostForm;
import com.globaldenso.dicas.presentation.form.IncidentCostSearchForm;
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
@RequestMapping(value = "/incidentCost")
public class IncidentCostController {

  private static final Logger LOGGER = LoggerFactory.getLogger(IncidentCostController.class);

  @Autowired
  private IncidentCostService incidentcostService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public IncidentCostController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0012")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

	CodeSearchForm searchForm1 = new CodeSearchForm();
	searchForm1.setGrpCds(Arrays.asList(new String[] {
		    DicasConstant.CodeGroupAttribute.USE_YN,
            DicasConstant.CodeGroupAttribute.INCIDENT_COST_DIV,
            DicasConstant.CodeGroupAttribute.PART_DIV,
	}));
    searchForm1.setUseYn("Y");
	List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
	List<CodeDto> useYnList = codeList1
		.stream()
		.filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN)).collect(Collectors.toList());

    List<CodeDto> divList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.INCIDENT_COST_DIV)).collect(Collectors.toList());

    List<CodeDto> partDivList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.PART_DIV)).collect(Collectors.toList());

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.WCM0012");

	mv.addObject("useYnItems", useYnList);
    mv.addObject("divItems", divList);
    mv.addObject("partDivItems", partDivList);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(IncidentCostSearchForm criteria, Pageable pageable) throws Exception {

    Page<IncidentCostDto> incidentcostItems = incidentcostService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", incidentcostItems.getTotalElements());

    retMap.put("contents", incidentcostItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody IncidentCostForm incidentcostForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    incidentcostService.create(incidentcostForm);
    mv.addObject("data", incidentcostForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody IncidentCostForm incidentcostForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    incidentcostService.update(incidentcostForm);
    mv.addObject("data", incidentcostForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody IncidentCostForm incidentcostForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    incidentcostService.delete(incidentcostForm);

    return mv;
  }

  @RequestMapping(value="/group/list.json")
  public ModelAndView getGroupIncidentCostList() throws Exception {

    IncidentCostSearchForm criteria = new IncidentCostSearchForm();
    List<IncidentCostDto> incidentcostItems = incidentcostService.searchGrpCdByCondition(criteria);

    ModelAndView mv = new ModelAndView("jsonView");
    mv.addObject("data", incidentcostItems);
    mv.addObject("total", incidentcostItems.size());

    return mv;
  }

  @RequestMapping(value = "/list.json")
  @ResponseBody
  public Map<String, Object> getIncidentCostList(@RequestBody IncidentCostSearchForm criteria) throws Exception {

    List<IncidentCostDto> incidentcostItems = incidentcostService.searchIncidentCostByCondition(criteria);

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("data", incidentcostItems);
    retMap.put("total", incidentcostItems.size());

    return retMap;
  }
}
