package com.globaldenso.dicas.presentation.controller.popup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.*;
import com.globaldenso.dicas.business.service.*;
import com.globaldenso.dicas.presentation.form.*;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("popup.researchController")
@RequestMapping(value = "/popup/research")
public class ResearchPopupController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResearchPopupController.class);

  @Autowired
  private ResearchService researchService;

  @Autowired
  private ResultMasterService resultmasterService;

  @Autowired
  private ResultMasterCostService resultmastercostService;

  @Autowired
  private OfficeService officeService;

  @Autowired
  private ServiceService serviceService;

  @Autowired
  private ConsultingService consultingService;

  @Autowired
  private IncidentCostService incidentCostService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ResearchPopupController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCMP009")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    String manageNo = request.getParameter("manageNo");
    String vinno = request.getParameter("vinno");

    ServiceSearchForm criteria = new ServiceSearchForm();
    criteria.setManageNo(manageNo);
    Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, null);

    String inquiryGubun = "";
    List<ServiceDto> list = serviceItems.getContent();
    for (ServiceDto sto : list) {
      inquiryGubun = sto.getInquiryGubun();
    }

    ModelAndView mv = new ModelAndView();

    if (inquiryGubun.equals("01") || inquiryGubun.equals("03")) {
      mv.setViewName(".tiles.popup.cmmn.WCMP009");
    } else {
      mv.setViewName(".tiles.popup.cmmn.WCMP010");
    }

    ResultMasterSearchForm criteria4 = new ResultMasterSearchForm();
    criteria4.setManageNo(manageNo);

    Page<ResultMasterDto> resultmasterItems = resultmasterService.searchByCondition(criteria4, null);
    ResultMasterDto resultMasterDto = resultmasterItems.getContent().get(0);
    mv.addObject("data", resultMasterDto);
    mv.addObject("dist", resultMasterDto.getDist());
    mv.addObject("submission", resultMasterDto.getSubmission());
    mv.addObject("approval", resultMasterDto.getApproval());
    mv.addObject("reject", resultMasterDto.getReject());

    ResultMasterCostSearchForm form2 = new ResultMasterCostSearchForm();
    form2.setMngNo(manageNo);

    Page<ResultMasterCostDto> resultmasterCostItems = resultmastercostService.searchByCondition(form2, null);
    mv.addObject("data2", resultmasterCostItems.getContent());

    ConsultingSearchForm criteria2 = new ConsultingSearchForm();
    criteria2.setManageNo(resultMasterDto.getManageNo());
    Page<ConsultingDto> consultingItems = consultingService.searchByCondition(criteria2, null);
    ConsultingDto consultingDto = consultingItems.getContent().get(0);

    OfficeSearchForm criteria3 = new OfficeSearchForm();
    criteria3.setOfficeCd(consultingDto.getSdAppoint());
    Page<OfficeDto> officeItems = officeService.searchByCondition(criteria3, null);
    OfficeDto officeDto = officeItems.getContent().get(0);

    mv.addObject("officeLabor", officeDto.getLabor());
    mv.addObject("officeHRate", officeDto.getHRate());
    mv.addObject("officeKm100InRate", officeDto.getKm100InRate());
    mv.addObject("officeKm100outRate", officeDto.getKm100OutRate());
    mv.addObject("materialDiv", officeDto.getMaterialDiv());

    mv.addObject("manageNo", manageNo);
    mv.addObject("vinno", vinno);
    mv.addObject("matDiv", resultMasterDto.getMatDiv());

    //부대비용관리
    IncidentCostSearchForm criteria5 = new IncidentCostSearchForm();
    criteria5.setDiv("03");
    criteria5.setUseYn("Y");
    Page<IncidentCostDto> incidentCostItems = incidentCostService.searchByCondition(criteria5, null);

    ObjectMapper mapper = new ObjectMapper();

    String jsonIncidentCostItems = "";
    try {
      jsonIncidentCostItems = mapper.writeValueAsString(incidentCostItems.getContent());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    mv.addObject("incidentCostItems", jsonIncidentCostItems);

    //부대비용관리
    IncidentCostSearchForm criteria6 = new IncidentCostSearchForm();
    criteria6.setDiv("02");
    criteria6.setUseYn("Y");
    Page<IncidentCostDto> incidentCostItems2 = incidentCostService.searchByCondition(criteria6, null);

    mapper = new ObjectMapper();

    String jsonIncidentCostItems2 = "";
    try {
        jsonIncidentCostItems2 = mapper.writeValueAsString(incidentCostItems2.getContent());
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    mv.addObject("incidentCostItems2", jsonIncidentCostItems2);

    //부대비용관리
    IncidentCostSearchForm criteria7 = new IncidentCostSearchForm();
    criteria7.setDiv("01");
    criteria7.setUseYn("Y");
    Page<IncidentCostDto> incidentCostItems3 = incidentCostService.searchByCondition(criteria7, null);

    mapper = new ObjectMapper();

    String jsonIncidentCostItems3 = "";
    try {
      jsonIncidentCostItems3 = mapper.writeValueAsString(incidentCostItems3.getContent());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    mv.addObject("incidentCostItems3", jsonIncidentCostItems3);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(ResearchSearchForm criteria, Pageable pageable) throws Exception {

    Page<ResearchDto> researchItems = researchService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", researchItems.getTotalElements());

    retMap.put("contents", researchItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

}
