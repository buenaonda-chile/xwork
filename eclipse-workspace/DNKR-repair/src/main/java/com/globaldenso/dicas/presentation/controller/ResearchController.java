package com.globaldenso.dicas.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.*;
import com.globaldenso.dicas.business.service.*;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.*;
import egovframework.rte.fdl.string.EgovStringUtil;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/research")
public class ResearchController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResearchController.class);

  @Autowired
  private ResearchService researchService;

  @Autowired
  private QualityProblemService qualityProblemService;

  @Autowired
  private CodeService codeService;

  @Autowired
  private ServiceService serviceService;

  @Autowired
  private VehicleService vehicleService;

  @Autowired
  private ConsultingService consultingService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ResearchController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WWK0002")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    String manageNo = request.getParameter("manageNo");
    String masterId = request.getParameter("masterId");
    String vinno = request.getParameter("vinno");

    CodeSearchForm searchForm = new CodeSearchForm();
    searchForm.setGrpCds(Arrays.asList(new String[] {
            DicasConstant.CodeGroupAttribute.RESEARCH_TYPE,    //????????????
            DicasConstant.CodeGroupAttribute.APPROVAL,    //????????????
            DicasConstant.CodeGroupAttribute.MATDIV,    //????????????
            DicasConstant.CodeGroupAttribute.WORK_RESULT,  //TF,NTF
            DicasConstant.CodeGroupAttribute.RECALL_TYPE  //RECALL TYPE
    }));
    searchForm.setUseYn("Y");
    List<CodeDto> codeList = codeService.searchCodeByCondition(searchForm);
    List<CodeDto> researchTypeList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.RESEARCH_TYPE)).collect(Collectors.toList());

    List<CodeDto> approvalList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.APPROVAL)).collect(Collectors.toList());

    List<CodeDto> matDivList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.MATDIV)).collect(Collectors.toList());

    List<CodeDto> workResultList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.WORK_RESULT)).collect(Collectors.toList());

    List<CodeDto> recallTypeList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.RECALL_TYPE)).collect(Collectors.toList());

    //???????????????
    Page<QualityProblemDto> qualityProblemNm = qualityProblemService.searchByCondition(new QualityProblemSearchForm(), null);

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.work.WWK0002");

    List<ResearchDto> fileItems
              = researchService.searchByConditionFile(manageNo);
    mv.addObject("fileItems", fileItems);

    mv.addObject("manageNo", manageNo);
    mv.addObject("masterId", masterId);
    mv.addObject("vinno", vinno);
    mv.addObject("researchTypeItems", researchTypeList);
    mv.addObject("approvalItems", approvalList);
    mv.addObject("matDivItems", matDivList);
    mv.addObject("fieldWorkResultItems", workResultList);    //1????????? fieldWorkResultItems
    mv.addObject("finalResearchResultItems", workResultList);    //???????????? finalResearchResultItems
    mv.addObject("qualityProblemNmItems", qualityProblemNm);
    mv.addObject("recallTypeItems", recallTypeList);

    ServiceSearchForm criteria = new ServiceSearchForm();
    criteria.setManageNo(manageNo);
    Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, null);

    String partDiv = "";

    List<ServiceDto> list = serviceItems.getContent();
    for (ServiceDto sto : list) {
      partDiv = sto.getInquiryGubun();
    }

    VehicleSearchForm criteria2 = new VehicleSearchForm();
    criteria2.setVinno(vinno);
    Page<VehicleDto> vehicleItems = vehicleService.searchByCondition(criteria2, null);
    List<VehicleDto> list2 = vehicleItems.getContent();
    VehicleDto dto = new VehicleDto();
    if (list2.size() > 0) {
      dto = list2.get(0);
    }

    PartNumberSearchForm form = new PartNumberSearchForm();
    form.setMaker(dto.getMaker());
    form.setExhaustReg(dto.getExhaustReg());
    form.setEngineType(dto.getEngineType());
    form.setPartDiv(partDiv);

    mv.addObject("popupParam", form);

    ConsultingSearchForm criteria3 = new ConsultingSearchForm();
    criteria3.setManageNo(manageNo);
    Page<ConsultingDto> consultingItems = consultingService.searchByCondition(criteria3, null);
    List<ConsultingDto> list3 = consultingItems.getContent();
    ConsultingDto dto2 = new ConsultingDto();
    if (list3.size() > 0) {
      dto2 = list3.get(0);
    }
    mv.addObject("auditInfo", dto2.getAuditInfo());

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

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody ResearchForm researchForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    researchService.create(researchForm);
    mv.addObject("data", researchForm);

    ServiceSearchForm criteria = new ServiceSearchForm();
    criteria.setManageNo(researchForm.getManageNo());
    Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, null);
    List<ServiceDto> list = serviceItems.getContent();

    if (list.size() > 0) {
      ServiceDto dto = list.get(0);
      if ("02".equals(dto.getCondition())) {
        dto.setCondition("03");
        serviceService.update2(dto);
      }
    }

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody ResearchForm researchForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    researchService.update(researchForm);
    mv.addObject("data", researchForm);

    ServiceSearchForm criteria = new ServiceSearchForm();
    criteria.setManageNo(researchForm.getManageNo());
    Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, null);
    List<ServiceDto> list = serviceItems.getContent();

    if (list.size() > 0) {
      ServiceDto dto = list.get(0);
      if ("02".equals(dto.getCondition())) {
        dto.setCondition("03");
        serviceService.update2(dto);
      }
    }

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody ResearchForm researchForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    researchService.delete(researchForm);

    return mv;
  }


  @RequestMapping(method = RequestMethod.POST, value="/mobileData")
  public ModelAndView mobileData(@RequestBody ResearchForm researchForm) throws Exception {
    ModelAndView mv = new ModelAndView("jsonView");

    if (researchForm.getId() != null){
      researchService.update(researchForm);
    }else{
      researchForm.setCdsdResearchYn(Long.valueOf(0));
      researchService.create(researchForm);
    }

    mv.addObject("data", researchForm);

    ServiceSearchForm criteria = new ServiceSearchForm();
    criteria.setManageNo(researchForm.getManageNo());
    Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, null);
    List<ServiceDto> list = serviceItems.getContent();

    if (list.size() > 0) {
      ServiceDto dto = list.get(0);
      if ("02".equals(dto.getCondition())) {
        dto.setCondition("03");
        serviceService.update2(dto);
      }
    }

    return mv;
  }

}
