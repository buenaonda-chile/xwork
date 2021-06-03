package com.globaldenso.dicas.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.*;
import com.globaldenso.dicas.business.service.*;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/trainingAppRegist")
public class TrainingAppRegistController {

  private static final Logger LOGGER = LoggerFactory.getLogger(TrainingAppRegistController.class);

  @Autowired
  private TrainingAppRegistService trainingAppRegistService;

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
  
  @Autowired
  private OfficeDetailService officedetailService;

  @Autowired
  private UserService userService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public TrainingAppRegistController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("EDUMENU")
  public ModelAndView init(HttpServletRequest request,
	  HttpServletResponse response) throws Exception {
	  
	  CodeSearchForm searchForm = new CodeSearchForm();
	  searchForm.setGrpCds(Arrays.asList(new String[] {
			    DicasConstant.CodeGroupAttribute.EDUCATION
	          , DicasConstant.CodeGroupAttribute.ONOFFYN
	          , DicasConstant.CodeGroupAttribute.RANCD
	  }));
	  
	  searchForm.setUseYn("Y");
	  
	  List<CodeDto> codeList = codeService.searchCodeByCondition(searchForm);
	  
	  List<CodeDto> educationList = codeList
	      .stream()
	      .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.EDUCATION))
	      .collect(Collectors.toList());
	  
	  List<CodeDto> onOffList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.ONOFFYN))
            .collect(Collectors.toList());
	  
	  List<CodeDto> rnkList = codeList
	            .stream()
	            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.RANCD))
	            .collect(Collectors.toList());
	  
	  ObjectMapper mapper = new ObjectMapper();
	  String jsonEducationItems = "";
	  try {
		  jsonEducationItems = mapper.writeValueAsString(educationList);
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }
	  
	  mapper = new ObjectMapper();
	  String jsonOnOffItems = "";
	  try {
		  jsonOnOffItems = mapper.writeValueAsString(onOffList);
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }
	  
	  mapper = new ObjectMapper();
	  String jsonRnkItems = "";
	  try {
		  jsonRnkItems = mapper.writeValueAsString(rnkList);
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }

	  ModelAndView mv = new ModelAndView();
	  mv.setViewName(".tiles.page.edu.EDUMENU");
	  mv.addObject("educationItems", jsonEducationItems);
	  mv.addObject("onoffItems", jsonOnOffItems);
	  mv.addObject("rnkItems", jsonRnkItems);
	
		/*
		 * LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		 * mv.addObject("loginVO", loginVO);
		 */
	
	  return mv;
  }
  
  @RequestMapping(method = RequestMethod.GET, value = "/init2")
  @ViewId("EDU0004")
  public ModelAndView init2(HttpServletRequest request,
	  HttpServletResponse response) throws Exception {
	  
	  CodeSearchForm searchForm = new CodeSearchForm();
	  searchForm.setGrpCds(Arrays.asList(new String[] {
			    DicasConstant.CodeGroupAttribute.EDUCATION
	          , DicasConstant.CodeGroupAttribute.ONOFFYN
	          , DicasConstant.CodeGroupAttribute.RANCD
	  }));
	  
	  searchForm.setUseYn("Y");
	  
	  List<CodeDto> codeList = codeService.searchCodeByCondition(searchForm);
	  
	  List<CodeDto> educationList = codeList
	      .stream()
	      .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.EDUCATION))
	      .collect(Collectors.toList());
	  
	  List<CodeDto> onOffList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.ONOFFYN))
            .collect(Collectors.toList());
	  
	  List<CodeDto> rnkList = codeList
	            .stream()
	            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.RANCD))
	            .collect(Collectors.toList());
	  
	  ObjectMapper mapper = new ObjectMapper();
	  String jsonEducationItems = "";
	  try {
		  jsonEducationItems = mapper.writeValueAsString(educationList);
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }
	  
	  mapper = new ObjectMapper();
	  String jsonOnOffItems = "";
	  try {
		  jsonOnOffItems = mapper.writeValueAsString(onOffList);
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }
	  
	  mapper = new ObjectMapper();
	  String jsonRnkItems = "";
	  try {
		  jsonRnkItems = mapper.writeValueAsString(rnkList);
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }

	  ModelAndView mv = new ModelAndView();
	  mv.setViewName(".tiles.page.edu.EDU0004");
	  mv.addObject("educationItems", jsonEducationItems);
	  mv.addObject("onoffItems", jsonOnOffItems);
	  mv.addObject("rnkItems", jsonRnkItems);
	
		/*
		 * LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		 * mv.addObject("loginVO", loginVO);
		 */
	
	  return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(TrainingAppRegistSearchForm criteria, Pageable pageable) throws Exception {

    Page<TrainingAppRegistDto> trainingAppRegistItems = trainingAppRegistService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", trainingAppRegistItems.getTotalElements());

    retMap.put("contents", trainingAppRegistItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  /**
   * 2021-03-17
   * @param criteria
   * @param pageable
   * @return
   * @throws Exception
   */
  @RequestMapping(method = RequestMethod.GET, value = "/searchSd")
  public ModelAndView searchSd(TrainingAppRegistSearchForm criteria, Pageable pageable) throws Exception {

    Page<TrainingAppRegistDto> trainingAppRegistItems = trainingAppRegistService.searchBySdCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", trainingAppRegistItems.getTotalElements());

    retMap.put("contents", trainingAppRegistItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }
  
  @RequestMapping(method = RequestMethod.GET, value = "/searchOffice")
  public ModelAndView search(OfficeSearchForm criteria, Pageable pageable) throws Exception {

    Page<OfficeDto> officeItems = officeService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", officeItems.getTotalElements());

    retMap.put("contents", officeItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }
  
  @RequestMapping(method = RequestMethod.GET, value = "/officeDetailSearch")
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
  public ModelAndView create(@RequestBody TrainingAppRegistForm trainingAppRegistForm) throws Exception {

	Long getId;
    ModelAndView mv = new ModelAndView("jsonView");
    
    TrainingAppRegistSearchForm criteria = new TrainingAppRegistSearchForm();
    criteria.setEduDiv(trainingAppRegistForm.getEduDiv());
    criteria.setEduItem(trainingAppRegistForm.getEduItem());
    criteria.setCustNm(trainingAppRegistForm.getCustNm());
    criteria.setReprNm(trainingAppRegistForm.getReprNm());
    criteria.setOfficeNm(trainingAppRegistForm.getOfficeNm());
    Page<TrainingAppRegistDto> trainingAppRegistItems = trainingAppRegistService.searchBySdCondition(criteria, null);
    List<TrainingAppRegistDto> list = trainingAppRegistItems.getContent();
    
    if (list.size() > 0) {
//	      ServiceDto dto = list.get(0);
//	      if ("02".equals(dto.getCondition())) {
//	        dto.setCondition("03");
//	        serviceService.update2(dto);
//	      }
		/* System.out.println("김준수333 : " + list.size()); */
	    	mv.addObject("data", trainingAppRegistForm);
	    	mv.addObject("dataChk", "fail");
	    	return mv;
    }
    else {

		/*
		 * System.out.println("김준수 : " + criteria.getEduDiv());
		 * System.out.println("김준수 : " + criteria.getEduItem());
		 * System.out.println("김준수 : " + criteria.getCustNm());
		 * System.out.println("김준수 : " + criteria.getReprNm());
		 * System.out.println("김준수 : " + criteria.getOfficeNm());
		 * System.out.println("김준수 : " + list.size());
		 */


        getId = trainingAppRegistService.create(trainingAppRegistForm);
        TrainingAppRegistDto trainingAppRegistDto = trainingAppRegistService.searchByKey(trainingAppRegistForm);  
        
//        trainingInfoBaseForm.setManageNo(trainingInfoBaseDto.getManageNo());
        mv.addObject("data", trainingAppRegistForm);
        mv.addObject("dataChk", "success");
        mv.addObject("result", getId);

    	/* System.out.println("김준수2 : " + getId); */
        
        return mv;
    }
    
  }
  
  @RequestMapping(method = RequestMethod.POST, value="/create2")
  public ModelAndView create2(@RequestBody TrainingAppRegistForm trainingAppRegistForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    trainingAppRegistService.create2(trainingAppRegistForm);
    TrainingAppRegistDto trainingAppRegistDto = trainingAppRegistService.searchByKey(trainingAppRegistForm);
//    trainingInfoBaseForm.setManageNo(trainingInfoBaseDto.getManageNo());
    mv.addObject("data", trainingAppRegistForm);
    
    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody TrainingAppRegistForm trainingAppRegistForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    trainingAppRegistService.update(trainingAppRegistForm);
    mv.addObject("data", trainingAppRegistForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody TrainingAppRegistForm trainingAppRegistForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    trainingAppRegistService.delete(trainingAppRegistForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/popup")
  @ViewId("EDUP002")
  public ModelAndView init(OfficeSearchForm criteria,
          HttpServletRequest request,
           HttpServletResponse response) throws Exception {

      CodeSearchForm searchForm1 = new CodeSearchForm();
      searchForm1.setGrpCds(Arrays.asList(new String[]{
              DicasConstant.CodeGroupAttribute.USE_YN,
              DicasConstant.CodeGroupAttribute.MAKER,
              DicasConstant.CodeGroupAttribute.OFFICE_DIV,
              DicasConstant.CodeGroupAttribute.OFFICE_CITY,
              DicasConstant.CodeGroupAttribute.MATERIAL_DIV,
      }));
      List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
      List<CodeDto> useYnList = codeList1
              .stream()
              .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN)).collect(Collectors.toList());

      List<CodeDto> makerList = codeList1
              .stream()
              .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.MAKER)).collect(Collectors.toList());

      List<CodeDto> officeDivList = codeList1
              .stream()
              .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.OFFICE_DIV)).collect(Collectors.toList());

      List<CodeDto> officeCityList = codeList1
              .stream()
              .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.OFFICE_CITY)).collect(Collectors.toList());

      List<CodeDto> materialDivList = codeList1
              .stream()
              .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.MATERIAL_DIV)).collect(Collectors.toList());

      List<CodeDto> reprYnList = codeList1
              .stream()
              .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN)).collect(Collectors.toList());

      ModelAndView mv = new ModelAndView();
      mv.setViewName(".tiles.popup.edu.EDUP002");

      mv.addObject("useYnItems", useYnList);
      mv.addObject("makerItems", makerList);
      mv.addObject("officeDivItems", officeDivList);
      mv.addObject("officeCityItems", officeCityList);
      mv.addObject("materialDivItems", materialDivList);
      mv.addObject("reprYnItems", reprYnList);

      mv.addObject("officeForm", criteria);

      return mv;
  }
  
  @RequestMapping(value = "/list.json/{grpCd}")
  @ResponseBody
  public Map<String, Object> getCodeList(@RequestBody TrainingAppRegistSearchForm criteria) throws Exception {

//	criteria.setUseYn("Y");
//	criteria.setGrpCd(grpCd);
	  
    List<TrainingAppRegistDto> codeItems = trainingAppRegistService.searchServiceByCondition2(criteria);

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("data", codeItems);
    retMap.put("total", codeItems.size());

    return retMap;
  }
}
