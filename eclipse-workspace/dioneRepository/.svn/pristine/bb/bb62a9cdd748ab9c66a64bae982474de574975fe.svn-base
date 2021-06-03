package com.globaldenso.dicas.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.*;
import com.globaldenso.dicas.business.service.*;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.*;
import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
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
@RequestMapping(value = "/serviceSD")
public class ServiceSDController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ServiceSDController.class);

  @Autowired
  private ServiceService serviceService;

  @Autowired
  private CodeService codeService;

  @Autowired
  private MainCategoryService maincategoryService;

  @Autowired
  private SubCategoryService subcategoryService;

  @Autowired
  private DtcService dtcService;

  @Autowired
  private OfficeService officeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ServiceSDController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WWK0003")
  public ModelAndView init(HttpServletRequest request,
                           HttpServletResponse response) throws Exception {

    CodeSearchForm searchForm = new CodeSearchForm();
    searchForm.setGrpCds(Arrays.asList(new String[] {
            //DicasConstant.CodeGroupAttribute.OFFICE_CITY,
            DicasConstant.CodeGroupAttribute.PART_DIV,
            DicasConstant.CodeGroupAttribute.SERVICE_TYPE,
            DicasConstant.CodeGroupAttribute.MAKER,
            //DicasConstant.CodeGroupAttribute.MODEL,
            //DicasConstant.CodeGroupAttribute.EXHAUS_REG,
            //DicasConstant.CodeGroupAttribute.ENGINE_TYPE,
            DicasConstant.CodeGroupAttribute.TIRE_STD,
            DicasConstant.CodeGroupAttribute.SALE_COUNTRY,
            DicasConstant.CodeGroupAttribute.AUDIT_INFO,
            DicasConstant.CodeGroupAttribute.SERVICE_CONDITION
    }));
    searchForm.setUseYn("Y");
    List<CodeDto> codeList = codeService.searchCodeByCondition(searchForm);

    //List<CodeDto> officeCityList = codeList
    //        .stream()
    //        .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.OFFICE_CITY)).collect(Collectors.toList());

    List<CodeDto> partDivList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.PART_DIV)).collect(Collectors.toList());

    List<CodeDto> divList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.SERVICE_TYPE)).collect(Collectors.toList());

    List<CodeDto> makerList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.MAKER))
            .collect(Collectors.toList());

    //List<CodeDto> modelList = codeList
    //        .stream()
    //        .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.MODEL))
    //        .collect(Collectors.toList());

    //List<CodeDto> exhaustRegList = codeList
    //        .stream()
    //        .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.EXHAUS_REG))
    //        .collect(Collectors.toList());

    //List<CodeDto> engineTypeList = codeList
    //        .stream()
    //        .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.ENGINE_TYPE))
    //        .collect(Collectors.toList());

    List<CodeDto> tireStdList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.TIRE_STD))
            .collect(Collectors.toList());

    List<CodeDto> saleCountryList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.SALE_COUNTRY))
            .collect(Collectors.toList());

    List<CodeDto> auditInfoList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.AUDIT_INFO))
            .collect(Collectors.toList());

    List<CodeDto> conditionList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.SERVICE_CONDITION))
            .collect(Collectors.toList());

    ObjectMapper mapper = new ObjectMapper();
    String jsonConditionItems = "";
    try {
      jsonConditionItems = mapper.writeValueAsString(conditionList);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    // 현상
    List<MainCategoryDto> mainCategoryItems = maincategoryService.searchMainCategoryByCondition(new MainCategorySearchForm());

    mapper = new ObjectMapper();
    String jsonMainCategoryItems = "";
    try {
      jsonMainCategoryItems = mapper.writeValueAsString(mainCategoryItems);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    List<SubCategoryDto> subCategoryItems = subcategoryService.searchSubCategoryByCondition(new SubCategorySearchForm());

    mapper = new ObjectMapper();
    String jsonSubCategoryItems = "";
    try {
      jsonSubCategoryItems = mapper.writeValueAsString(subCategoryItems);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    List<DtcDto> dtcItems = dtcService.searchDtcByCondition2(new DtcSearchForm());

    mapper = new ObjectMapper();
    String jsonDtcItems = "";
    try {
      jsonDtcItems = mapper.writeValueAsString(dtcItems);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    //OfficeSearchForm criteria = new OfficeSearchForm();
    //SD지정업체만 표시
    //criteria.setOfficeDiv("4");
    //List<OfficeDto> officeItems = officeService.searchOfficeByCondition(criteria);

    //mapper = new ObjectMapper();
    //String jsonOfficeItems = "";
    //try {
    //  jsonOfficeItems = mapper.writeValueAsString(officeItems);
    //} catch (IOException ex) {
    //  ex.printStackTrace();
    //}

//    Page<UserDto> userItems = userService.searchByCondition(new UserSearchForm(), null);

    //mapper = new ObjectMapper();
    //String jsonUserItems = "";
    //try {
    //  jsonUserItems = mapper.writeValueAsString(userItems.getContent());
    //} catch (IOException ex) {
    //  ex.printStackTrace();
    //}

    //ModelAndView mv = new ModelAndView("jsonView");
    //Map<String, Object> retMap = new HashMap<>();
    //Map<String, Object> pageMap = new HashMap<>();
    //pageMap.put("page", pageable.getPageNumber());
    //pageMap.put("totalCount", phenomenonItems.getTotalElements());

    //retMap.put("contents", phenomenonItems.getContent());
    //retMap.put("pagination", pageMap);
    //mv.addObject("result", true);
    //mv.addObject("data", retMap);

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.work.WWK0003");
    mv.addObject("partDivItems", partDivList);
    mv.addObject("divItems", divList);
    mv.addObject("makerItems", makerList);
    mv.addObject("tireStdItems", tireStdList);
    mv.addObject("saleCountryItems", saleCountryList);
    mv.addObject("auditInfoItems", auditInfoList);

    mv.addObject("conditionItems", jsonConditionItems);

    mv.addObject("mainCategoryItems", jsonMainCategoryItems);
    mv.addObject("subCategoryItems", jsonSubCategoryItems);
    mv.addObject("dtcItems", jsonDtcItems);

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    mv.addObject("loginVO", loginVO);

//    mv.addObject("engineTypeItems", engineTypeList);
//    mv.addObject("exhaustRegItems", exhaustRegList);
//    mv.addObject("officeCityItems", officeCityList);
//    mv.addObject("officeItems", officeItems.getContent());
//    mv.addObject("userItems", userItems);
//    mv.addObject("modelItems", modelList);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(ServiceSearchForm criteria, Pageable pageable) throws Exception {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    criteria.setSdAppoint(loginVO.getOfficeCd());
    Page<ServiceDto> serviceItems = serviceService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", serviceItems.getTotalElements());

    retMap.put("contents", serviceItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

}
