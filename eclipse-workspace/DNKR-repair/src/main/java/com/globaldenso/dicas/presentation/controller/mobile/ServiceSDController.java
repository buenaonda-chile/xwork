package com.globaldenso.dicas.presentation.controller.mobile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.*;
import com.globaldenso.dicas.business.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.globaldenso.dicas.presentation.form.ResultMasterForm;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller("mobile.ServiceSDController")
@RequestMapping(value = "/mobile/serviceSD")
public class ServiceSDController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ServiceSDController.class);

  @Autowired
  private ServiceService serviceService;

  @Autowired
  private VehicleService vehicleService;

  @Autowired
  private ConsultingService consultingService;

  @Autowired
  private PhenomenonService phenomenonService;

  @Autowired
  private PhenomenonSubService phenomenonsubService;

  @Autowired
  private ResearchService researchService;

  @Autowired
  private ResultMasterService resultmasterService;

  @Autowired
  private CodeService codeService;

  @Autowired
  private ResultMasterCostService resultmastercostService;

  @Autowired
  private IncidentCostService incidentCostService;

  @Autowired
  private OfficeService officeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public ServiceSDController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WWK0001")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.mobile.work.WWK0001");

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init/{serviceId}/service")
  @ViewId("WWK0002")
  public ModelAndView initService(@PathVariable("serviceId") String serviceId,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.mobile.work.WWK0002");
    mv.addObject("serviceId", serviceId);

    ServiceSearchForm criteria = new ServiceSearchForm();
    criteria.setManageNo(serviceId);

    Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, null);
    List<ServiceDto> list = serviceItems.getContent();
    ServiceDto serviceDto = list.get(0);

    mv.addObject("serviceForm", serviceDto);

    VehicleSearchForm criteria2 = new VehicleSearchForm();
    criteria2.setVinno(serviceDto.getVinno());

    Page<VehicleDto> vehicleItems = vehicleService.searchByCondition(criteria2, null);
    List<VehicleDto> list2 = vehicleItems.getContent();

    mv.addObject("vehicleForm", list2.get(0));

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init/{serviceId}/dtc")
  @ViewId("WWK0003")
  public ModelAndView initDtc(@PathVariable("serviceId") String serviceId,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    PhenomenonSearchForm criteria = new PhenomenonSearchForm();
    criteria.setManageNo(serviceId);
    Page<PhenomenonDto> phenomenonItems = phenomenonService.searchByCondition(criteria, null);

    PhenomenonSubSearchForm criteria2 = new PhenomenonSubSearchForm();
    criteria2.setManageNo(serviceId);
    Page<PhenomenonSubDto> phenomenonsubItems = phenomenonsubService.searchByCondition(criteria2, null);

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.mobile.work.WWK0003");
    mv.addObject("serviceId", serviceId);
    mv.addObject("phenomenonList", phenomenonItems.getContent());
    mv.addObject("phenomenonsubList", phenomenonsubItems.getContent());

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init/{serviceId}/consult")
  @ViewId("WWK0004")
  public ModelAndView initConsult(@PathVariable("serviceId") String serviceId,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    ConsultingSearchForm criteria = new ConsultingSearchForm();
    criteria.setManageNo(serviceId);
    Page<ConsultingDto> consultingItems = consultingService.searchByCondition(criteria, null);

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.mobile.work.WWK0004");
    mv.addObject("serviceId", serviceId);

    List<ConsultingDto> list = consultingItems.getContent();
    if (list.size() > 0) {
      mv.addObject("consultingForm", list.get(0));
    } else {
      mv.addObject("consultingForm", new ConsultingDto());
    }

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init/{serviceId}/research")
  @ViewId("WWK0005")
  public ModelAndView initResearch(@PathVariable("serviceId") String serviceId,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {

    ResearchSearchForm criteria = new ResearchSearchForm();
    criteria.setManageNo(serviceId);
    Page<ResearchDto> researchItems = researchService.searchByCondition(criteria, null);

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.mobile.work.WWK0005");
    mv.addObject("serviceId", serviceId);

    List<ResearchDto> list = researchItems.getContent();
    if (list.size() > 0) {
      mv.addObject("researchForm", list.get(0));
    } else {
      mv.addObject("researchForm", new ResearchDto());
    }

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init/{serviceId}/result")
  @ViewId("WWK0006")
  public ModelAndView initResult(@PathVariable("serviceId") String serviceId,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {
      //코드정보 리스트
      ModelAndView mv = new ModelAndView();
      ObjectMapper mapper = new ObjectMapper();

      CodeSearchForm searchForm = new CodeSearchForm();
      searchForm.setGrpCds(Arrays.asList(new String[] {
              DicasConstant.CodeGroupAttribute.APPROVAL,
              DicasConstant.CodeGroupAttribute.MATDIV
      }));
      searchForm.setUseYn("Y");
      List<CodeDto> codeList = codeService.searchCodeByCondition(searchForm);
      List<CodeDto> matDivList = codeList
              .stream()
              .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.MATDIV)).collect(Collectors.toList());

      List<CodeDto> approvalList = codeList
              .stream()
              .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.APPROVAL)).collect(Collectors.toList());

      ResultMasterSearchForm criteria = new ResultMasterSearchForm();
      criteria.setManageNo(serviceId);
      Page<ResultMasterDto> resultmasterItems = resultmasterService.searchByCondition(criteria, null);
      Page<ResultMasterDto> selectMstInfo = resultmasterService.selectMstInfo(criteria, null);
      mv.setViewName(".tiles.mobile.work.WWK0006");
      mv.addObject("serviceId", serviceId);

      List<ResultMasterDto> list = resultmasterItems.getContent();
      List<ResultMasterDto> mlist = selectMstInfo.getContent();
      mv.addObject("itemList", list);
      mv.addObject("mstInfoForm", mlist.get(0));
      if (list.size() > 0) {
          mv.addObject("resultForm", list.get(0));
      } else {
         mv.addObject("resultForm", new ResultMasterDto());
      }

      mv.addObject("matDivItems", matDivList);    //자재선택
      mv.addObject("approvalItems", approvalList);    //결과구분

      //파일첨부 리스트
      ServiceSearchForm criteria1 = new ServiceSearchForm();
      criteria1.setManageNo(serviceId);

      List<ResearchDto> fileItems = researchService.searchByConditionFile(serviceId);
      mv.addObject("fileItems", fileItems);   //파일목록

      List<ResearchDto> costInfo = researchService.searchByConditionCostApprInfo(serviceId);
      String costApprYn = "N";
      if (costInfo.size() > 0) {
          costApprYn = "Y";
      }
      mv.addObject("costInfo", costApprYn);   //비용신청 정보
      System.out.print("=== costApprYn : "+costApprYn);
      return mv;
  }

    @RequestMapping(method = RequestMethod.GET, value = "/init/{serviceId}/cost")
    @ViewId("WWK0007")
    public ModelAndView initCost(@PathVariable("serviceId") String serviceId,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        ResultMasterSearchForm criteria = new ResultMasterSearchForm();
        criteria.setManageNo(serviceId);
        Page<ResultMasterDto> resultmasterItems = resultmasterService.searchByCondition(criteria, null);

        ServiceSearchForm criteria5 = new ServiceSearchForm();
        criteria5.setManageNo(serviceId);
        Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria5, null);

        String inquiryGubun = "";
        List<ServiceDto> list2 = serviceItems.getContent();
        for (ServiceDto sto : list2) {
            inquiryGubun = sto.getInquiryGubun();
        }

        ModelAndView mv = new ModelAndView();

        if (inquiryGubun.equals("01") || inquiryGubun.equals("03")) {
            mv.setViewName(".tiles.mobile.work.WWK0007");
        } else {
            mv.setViewName(".tiles.mobile.work.WWK0009");
        }
        mv.addObject("serviceId", serviceId);

        List<ResultMasterDto> list = resultmasterItems.getContent();

        ConsultingSearchForm criteria4 = new ConsultingSearchForm();
        criteria4.setManageNo(serviceId);
        Page<ConsultingDto> consultingItems = consultingService.searchByCondition(criteria4, null);
        ConsultingDto consultingDto = consultingItems.getContent().get(0);

        OfficeSearchForm criteria6 = new OfficeSearchForm();
        criteria6.setOfficeCd(consultingDto.getSdAppoint());
        Page<OfficeDto> officeItems = officeService.searchByCondition(criteria6, null);
        OfficeDto officeDto = officeItems.getContent().get(0);

        ResultMasterDto dto = new ResultMasterDto();

        if (list.size() > 0) {
            dto = (ResultMasterDto)list.get(0);
        }
        dto.setLabor(officeDto.getLabor());
        dto.setHRate(officeDto.getHRate());
        dto.setKm100InRate(officeDto.getKm100InRate());
        dto.setKm100OutRate(officeDto.getKm100OutRate());
        dto.setMaterialDiv(officeDto.getMaterialDiv());

        mv.addObject("resultForm", dto);

        //커먼레일
        //작업시간
        IncidentCostSearchForm criteria3 = new IncidentCostSearchForm();
        //criteria1.setManageNo(serviceId);
        criteria3.setDiv("03");
        criteria3.setUseYn("Y");
        Page<IncidentCostDto> incidentCostItems3 = incidentCostService.searchByCondition(criteria3, null);

        //부대비1
        IncidentCostSearchForm criteria2 = new IncidentCostSearchForm();
        criteria2.setDiv("02");
        criteria2.setUseYn("Y");
        Page<IncidentCostDto> incidentCostItems2 = incidentCostService.searchByCondition(criteria2, null);

        //부대비2
        IncidentCostSearchForm criteria1 = new IncidentCostSearchForm();
        //criteria3.setManageNo(serviceId);
        criteria1.setDiv("01");
        criteria1.setUseYn("Y");
        Page<IncidentCostDto> incidentCostItems1 = incidentCostService.searchByCondition(criteria1, null);

        ResultMasterCostSearchForm form2 = new ResultMasterCostSearchForm();
        form2.setMngNo(serviceId);
        form2.setDiv("03");
        Page<ResultMasterCostDto> resultmasterCostItems3 = resultmastercostService.searchByCondition(form2, null);

        //mv.addObject("incidentCostItems1", incidentCostItems1.getContent());
        //mv.addObject("incidentCostItems2", incidentCostItems2.getContent());
        //mv.addObject("incidentCostItems3", incidentCostItems3.getContent());
        //mv.addObject("resultmasterItems", resultmasterItems.getContent());

        ObjectMapper mapper = new ObjectMapper();

        String jsonIncidentCostItems3 = "";
        try {
            jsonIncidentCostItems3 = mapper.writeValueAsString(incidentCostItems3.getContent());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        mv.addObject("jsonIncidentCostItems3", jsonIncidentCostItems3);

        mapper = new ObjectMapper();
        String jsonIncidentCostItems2 = "";
        try {
            jsonIncidentCostItems2 = mapper.writeValueAsString(incidentCostItems2.getContent());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        mv.addObject("jsonIncidentCostItems2", jsonIncidentCostItems2);

        mapper = new ObjectMapper();
        String jsonIncidentCostItems1 = "";
        try {
            jsonIncidentCostItems1 = mapper.writeValueAsString(incidentCostItems1.getContent());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        mv.addObject("jsonIncidentCostItems1", jsonIncidentCostItems1);

        mapper = new ObjectMapper();

        List<ResultMasterCostDto> copyList = new ArrayList<ResultMasterCostDto>();
        List<ResultMasterCostDto> tempList =  resultmasterCostItems3.getContent();
        for (ResultMasterCostDto tempDto : tempList) {
            Map costMap = new HashMap();
            costMap.put("costCd", tempDto.getCostCd());
            costMap.put("costNm", tempDto.getCostNm());
            tempDto.setCostMap(costMap);

            copyList.add(tempDto);
        }

        String jsonResultmasterCostItems3 = "";
        try {
            jsonResultmasterCostItems3 = mapper.writeValueAsString(copyList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        mv.addObject("jsonResultmasterCostItems3", jsonResultmasterCostItems3);

        ResultMasterCostSearchForm form3 = new ResultMasterCostSearchForm();
        form3.setMngNo(serviceId);
        form3.setDiv("02");
        Page<ResultMasterCostDto> resultmasterCostItems2 = resultmastercostService.searchByCondition(form3, null);

        mapper = new ObjectMapper();

        List<ResultMasterCostDto> copyList2 = new ArrayList<ResultMasterCostDto>();
        List<ResultMasterCostDto> tempList2 =  resultmasterCostItems2.getContent();
        for (ResultMasterCostDto tempDto : tempList2) {
            Map costMap = new HashMap();
            costMap.put("costCd", tempDto.getCostCd());
            costMap.put("costNm", tempDto.getCostNm());
            tempDto.setCostMap(costMap);

            copyList2.add(tempDto);
        }

        String jsonResultmasterCostItems2 = "";
        try {
            jsonResultmasterCostItems2 = mapper.writeValueAsString(copyList2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        mv.addObject("jsonResultmasterCostItems2", jsonResultmasterCostItems2);

        ResultMasterCostSearchForm form1 = new ResultMasterCostSearchForm();
        form1.setMngNo(serviceId);
        form1.setDiv("01");
        Page<ResultMasterCostDto> resultmasterCostItems1 = resultmastercostService.searchByCondition(form1, null);

        mapper = new ObjectMapper();

        List<ResultMasterCostDto> copyList3 = new ArrayList<ResultMasterCostDto>();
        List<ResultMasterCostDto> tempList3 =  resultmasterCostItems1.getContent();
        for (ResultMasterCostDto tempDto : tempList3) {
            Map costMap = new HashMap();
            costMap.put("costCd", tempDto.getCostCd());
            costMap.put("costNm", tempDto.getCostNm());
            tempDto.setCostMap(costMap);

            copyList3.add(tempDto);
        }

        String jsonResultmasterCostItems1 = "";
        try {
            jsonResultmasterCostItems1 = mapper.writeValueAsString(copyList3);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        mv.addObject("jsonResultmasterCostItems1", jsonResultmasterCostItems1);

        ResultMasterSearchForm criteria7 = new ResultMasterSearchForm();
        criteria7.setManageNo(serviceId);
        Page<ResultMasterDto> resultmasterItems2 = resultmasterService.searchByCondition2(criteria7, null);

        mapper = new ObjectMapper();

        String jsonResultmasterItems = "";
        try {
            jsonResultmasterItems = mapper.writeValueAsString(resultmasterItems2.getContent());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        mv.addObject("jsonResultmasterItems", jsonResultmasterItems);

        return mv;
    }

  @RequestMapping(method = RequestMethod.GET, value = "/init/partNumberPop")
  @ViewId("WWK0008")
  public ModelAndView initPop(HttpServletRequest request,
          HttpServletResponse response) throws Exception {

    CodeSearchForm searchForm1 = new CodeSearchForm();
    searchForm1.setGrpCds(Arrays.asList(new String[] {
            DicasConstant.CodeGroupAttribute.MAKER,
            DicasConstant.CodeGroupAttribute.PART_DIV,
            DicasConstant.CodeGroupAttribute.EXHAUS_REG,
            DicasConstant.CodeGroupAttribute.ENGINE_TYPE
    }));
    List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
    List<CodeDto> makerList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.MAKER)).collect(Collectors.toList());

    List<CodeDto> partDivList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.PART_DIV)).collect(Collectors.toList());

    List<CodeDto> exhaustRegList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.EXHAUS_REG)).collect(Collectors.toList());

    List<CodeDto> engineTypeList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.ENGINE_TYPE)).collect(Collectors.toList());

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.mobile.work.WWK0008");

    mv.addObject("makerItems", makerList);
    mv.addObject("partDivItems", partDivList);
    mv.addObject("exhaustRegItems", exhaustRegList);
    mv.addObject("engineTypeItems", engineTypeList);

    return mv;
  }

    @RequestMapping(method = RequestMethod.POST, value = "/init/{serviceId}/delete")
    @ResponseBody
    public ModelAndView costDelete(@PathVariable("serviceId") String serviceId,
                                 @RequestBody List<Map<String, Object>> list,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        for(Map<String, Object> m : list) {
            System.out.println("data : " + m);
//data : {rn=1, rgstrAcctNm=null, updtrAcctNm=null, vinno=20190128000002, mngNo=KR_000012090, serviceSeq=1, div=03, seq=1, costCd=HOUR01, costValue=1, regUserId=WWKR0021, regDt=1548774000000, updUserId=WWKR0021, updDt=1548774000000, id=null, costNm=1시간, updtDe=2019-06-06 13:50:17, rgstDe=2019-06-06 13:50:17}
//data : {costValue=1, costCd={itemCd=1, itemNm=1시간}}

                // DELETE
            if (m.get("id") != null) {
                ResultMasterCostForm resultmastercostForm = new ResultMasterCostForm();
                resultmastercostForm.setId(Long.parseLong(String.valueOf(m.get("id"))));
                resultmastercostService.delete(resultmastercostForm);
            }

        }

        ModelAndView mv = new ModelAndView("jsonView");
        return mv;
    }

    //커먼레일 작업시간
    @RequestMapping(method = RequestMethod.POST, value = "/init/{serviceId}/save")
    @ResponseBody
    public ModelAndView costSave(@PathVariable("serviceId") String serviceId,
                                 @RequestBody List<Map<String, Object>> list,
                                     HttpServletRequest request, HttpServletResponse response) throws Exception {

        ServiceSearchForm criteria = new ServiceSearchForm();
        criteria.setManageNo(serviceId);

        Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, null);
        List<ServiceDto> list2 = serviceItems.getContent();
        ServiceDto serviceDto = list2.get(0);
        String vinno = serviceDto.getVinno();

        for(Map<String, Object> m : list) {
            System.out.println("data : " + m);

            // INSERT
            if (m.get("id") == null) {
                ResultMasterCostForm resultmastercostForm = new ResultMasterCostForm();
                resultmastercostForm.setVinno(vinno);
                resultmastercostForm.setMngNo(serviceId);

                resultmastercostForm.setServiceSeq(new Long("1"));
                resultmastercostForm.setDiv("03");

                Map map = (Map) m.get("costMap");
                resultmastercostForm.setCostCd(String.valueOf(map.get("costCd")));
                resultmastercostForm.setCostValue(Double.parseDouble(String.valueOf(m.get("costValue"))));

                resultmastercostService.create(resultmastercostForm);
            } else {
                // UPDATE

                ResultMasterCostForm resultmastercostForm = new ResultMasterCostForm();
                resultmastercostForm.setVinno(String.valueOf(m.get("vinno")));
                resultmastercostForm.setMngNo(String.valueOf(m.get("mngNo")));
                resultmastercostForm.setServiceSeq(Long.parseLong(String.valueOf(m.get("serviceSeq"))));
                resultmastercostForm.setDiv(String.valueOf(m.get("div")));

                Map map = (Map) m.get("costMap");
                resultmastercostForm.setCostCd(String.valueOf(map.get("costCd")));
                resultmastercostForm.setCostValue(Double.parseDouble(String.valueOf(m.get("costValue"))));
                resultmastercostForm.setId(Long.parseLong(String.valueOf(m.get("id"))));

                resultmastercostService.update(resultmastercostForm);
            }

        }

        ModelAndView mv = new ModelAndView("jsonView");
        return mv;
    }

    //부대비용(택배비등)
    @RequestMapping(method = RequestMethod.POST, value = "/init/{serviceId}/save2")
    @ResponseBody
    public ModelAndView costSave2(@PathVariable("serviceId") String serviceId,
                                 @RequestBody List<Map<String, Object>> list,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        ServiceSearchForm criteria = new ServiceSearchForm();
        criteria.setManageNo(serviceId);

        Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, null);
        List<ServiceDto> list2 = serviceItems.getContent();
        ServiceDto serviceDto = list2.get(0);
        String vinno = serviceDto.getVinno();

        for(Map<String, Object> m : list) {
            System.out.println("data : " + m);

            // INSERT
            if (m.get("id") == null) {
                ResultMasterCostForm resultmastercostForm = new ResultMasterCostForm();
                resultmastercostForm.setVinno(vinno);
                resultmastercostForm.setMngNo(serviceId);

                resultmastercostForm.setServiceSeq(new Long("1"));
                resultmastercostForm.setDiv("02");

                Map map = (Map) m.get("costMap");
                resultmastercostForm.setCostCd(String.valueOf(map.get("costCd")));
                resultmastercostForm.setCostValue(Double.parseDouble(String.valueOf(m.get("costValue"))));

                resultmastercostService.create(resultmastercostForm);
            } else {
                // UPDATE

                ResultMasterCostForm resultmastercostForm = new ResultMasterCostForm();
                resultmastercostForm.setVinno(String.valueOf(m.get("vinno")));
                resultmastercostForm.setMngNo(String.valueOf(m.get("mngNo")));
                resultmastercostForm.setServiceSeq(Long.parseLong(String.valueOf(m.get("serviceSeq"))));
                resultmastercostForm.setDiv(String.valueOf(m.get("div")));

                Map map = (Map) m.get("costMap");
                resultmastercostForm.setCostCd(String.valueOf(map.get("costCd")));
                resultmastercostForm.setCostValue(Double.parseDouble(String.valueOf(m.get("costValue"))));
                resultmastercostForm.setId(Long.parseLong(String.valueOf(m.get("id"))));

                resultmastercostService.update(resultmastercostForm);
            }

        }

        ModelAndView mv = new ModelAndView("jsonView");
        return mv;
    }

    //부대비용(에어컨)
    @RequestMapping(method = RequestMethod.POST, value = "/init/{serviceId}/save3")
    @ResponseBody
    public ModelAndView costSave3(@PathVariable("serviceId") String serviceId,
                                  @RequestBody List<Map<String, Object>> list,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {

        ServiceSearchForm criteria = new ServiceSearchForm();
        criteria.setManageNo(serviceId);

        Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, null);
        List<ServiceDto> list2 = serviceItems.getContent();
        ServiceDto serviceDto = list2.get(0);
        String vinno = serviceDto.getVinno();

        for(Map<String, Object> m : list) {
            System.out.println("data : " + m);

            // INSERT
            if (m.get("id") == null) {
                ResultMasterCostForm resultmastercostForm = new ResultMasterCostForm();
                resultmastercostForm.setVinno(vinno);
                resultmastercostForm.setMngNo(serviceId);

                resultmastercostForm.setServiceSeq(new Long("1"));
                resultmastercostForm.setDiv("01");

                Map map = (Map) m.get("costMap");
                resultmastercostForm.setCostCd(String.valueOf(map.get("costCd")));
                resultmastercostForm.setCostValue(Double.parseDouble(String.valueOf(m.get("costValue"))));

                resultmastercostService.create(resultmastercostForm);
            } else {
                // UPDATE

                ResultMasterCostForm resultmastercostForm = new ResultMasterCostForm();
                resultmastercostForm.setVinno(String.valueOf(m.get("vinno")));
                resultmastercostForm.setMngNo(String.valueOf(m.get("mngNo")));
                resultmastercostForm.setServiceSeq(Long.parseLong(String.valueOf(m.get("serviceSeq"))));
                resultmastercostForm.setDiv(String.valueOf(m.get("div")));

                Map map = (Map) m.get("costMap");
                resultmastercostForm.setCostCd(String.valueOf(map.get("costCd")));
                resultmastercostForm.setCostValue(Double.parseDouble(String.valueOf(m.get("costValue"))));
                resultmastercostForm.setId(Long.parseLong(String.valueOf(m.get("id"))));

                resultmastercostService.update(resultmastercostForm);
            }

        }

        ModelAndView mv = new ModelAndView("jsonView");
        return mv;
    }

    //비용저장
    @RequestMapping(method = RequestMethod.POST, value = "/init/{serviceId}/save4")
    @ResponseBody
    public ModelAndView costSave4(@PathVariable("serviceId") String serviceId,
                                  @RequestBody List<Map<String, Object>> list,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map map = list.get(0);

        ResultMasterForm resultmasterForm = new ResultMasterForm();
        resultmasterForm.setLabor(Long.parseLong(String.valueOf(map.get("labor"))));
        resultmasterForm.setDist(Long.parseLong(String.valueOf(map.get("dist"))));
        resultmasterForm.setTravelAmt(Long.parseLong(String.valueOf(map.get("travelAmt"))));
        resultmasterForm.setRepairAmtTot(Long.parseLong(String.valueOf(map.get("repairAmtTot"))));
        resultmasterForm.setPartMarginCulcu(Long.parseLong(String.valueOf(map.get("partMarginCulcu"))));
        resultmasterForm.setTotalAmt(Long.parseLong(String.valueOf(map.get("totalAmt"))));
        resultmasterForm.setTaxAmt(Long.parseLong(String.valueOf(map.get("taxAmt"))));
        resultmasterForm.setEtcAmtTot(Long.parseLong(String.valueOf(map.get("etcAmtTot"))));
        resultmasterForm.setPartAmtTot(Long.parseLong(String.valueOf(map.get("partAmtTot"))));
        resultmasterForm.setManageNo(serviceId);
        resultmasterService.update2(resultmasterForm);

        ModelAndView mv = new ModelAndView("jsonView");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/init/{serviceId}/itemDelete")
    @ResponseBody
    public ModelAndView itemDelete(@PathVariable("serviceId") String serviceId,
                                   @RequestBody List<Map<String, Object>> list,
                                   HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.print("===="+list.size());
        ResultMasterForm resultmasterForm = new ResultMasterForm();
        for(Map<String, Object> m : list) {
            //System.out.println("data : " + m);
            if(m.get("D")!= null && m.get("D") != ""){
                String delIds = m.get("D").toString();
                String delId[] = delIds.split(",");
                if(delId.length>0){
                    for(int i=0; i<delId.length; i++) {
                        resultmasterForm.setId(Long.parseLong(String.valueOf(delId[i])));
                        resultmasterService.delete(resultmasterForm);
                    }
                }
            }
        }

        ModelAndView mv = new ModelAndView("jsonView");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/init/{serviceId}/itemAdd")
    @ResponseBody
    public ModelAndView itemAdd(@PathVariable("serviceId") String serviceId,
                                   @RequestBody List<Map<String, Object>> list,
                                   HttpServletRequest request, HttpServletResponse response) throws Exception {

        ResultMasterForm resultmasterForm = new ResultMasterForm();

        for(Map<String, Object> m : list) {
            if(m.get("IU") != null && m.get("IU") != ""){
                String inIds = m.get("IU").toString();
                String inId[] = inIds.split(",");
                if(inId.length>0){
                    for(int i=0; i<inId.length; i++) {
                        System.out.println("============== " + inId[i]);
                        String addInfo[] = inId[i].split("\\|");
                        resultmasterForm.setManageNo(m.get("manageNo").toString());
                        resultmasterForm.setVinno(m.get("vinno").toString());
                        if(String.valueOf(m.get("serviceDegree")).equals("")){
                            resultmasterForm.setServiceDegree(Long.valueOf(1));
                        }else{
                            resultmasterForm.setServiceDegree(Long.parseLong(String.valueOf(m.get("serviceDegree"))));
                        }
                        resultmasterForm.setHmcPartNo(addInfo[0].toString());
                        resultmasterForm.setReplacePartNm(addInfo[1].toString());
                        resultmasterForm.setReplacePartCnt(Long.parseLong(String.valueOf(addInfo[2])));
                        if(addInfo.length > 3 ){
                            resultmasterForm.setReplacePartNo(addInfo[3].toString());
                        }
                        resultmasterService.create(resultmasterForm);
                    }
                }
            }
        }
        ModelAndView mv = new ModelAndView("jsonView");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/init/{serviceId}/checkSD")
    @ResponseBody
    public ModelAndView checkSD(@PathVariable("serviceId") String serviceId,
                                   HttpServletRequest request, HttpServletResponse response) throws Exception {
       String manageNo = serviceId;
       ModelAndView mv = new ModelAndView("jsonView");
       ResultMasterForm resultmasterForm = new ResultMasterForm();
       if(manageNo != ""){
           ConsultingSearchForm criteria = new ConsultingSearchForm();
           criteria.setManageNo(manageNo);
           Page<ConsultingDto> consultingItems = consultingService.searchByCondition(criteria, null);
           List<ConsultingDto> list3 = consultingItems.getContent();
           ConsultingDto dto2 = new ConsultingDto();
           if (list3.size() > 0) {
               dto2 = list3.get(0);
           }
           mv.addObject("auditInfo", dto2.getAuditInfo());

       }
       return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value="/init/{serviceId}/sdCostApproval")
    public ModelAndView sdCostApproval(@PathVariable("serviceId") String serviceId, HttpServletRequest request, HttpServletResponse respons) throws Exception {
        String manageNo = serviceId;
        ResultMasterForm resultmasterForm = new ResultMasterForm();
        ConsultingSearchForm criteria = new ConsultingSearchForm();
        resultmasterForm.setManageNo(manageNo);
        System.out.print("==== "+resultmasterForm);
        ModelAndView mv = new ModelAndView("jsonView");

        resultmasterService.update4(resultmasterForm);
        mv.addObject("data", resultmasterForm);

        return mv;
    }
}
