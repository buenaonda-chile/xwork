package com.globaldenso.dicas.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.*;
import com.globaldenso.dicas.business.service.*;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/trainingInfoBase")
public class TrainingInfoBaseController {

  private static final Logger LOGGER = LoggerFactory.getLogger(TrainingInfoBaseController.class);

  @Autowired
  private TrainingInfoBaseService trainingInfoBaseService;

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
  private UserService userService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public TrainingInfoBaseController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("EDU0001")
  public ModelAndView init(HttpServletRequest request,
	  HttpServletResponse response) throws Exception {
	  
	  CodeSearchForm searchForm = new CodeSearchForm();
	  searchForm.setGrpCds(Arrays.asList(new String[] {
			    DicasConstant.CodeGroupAttribute.EDUCATION
	          , DicasConstant.CodeGroupAttribute.ONOFFYN
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

	  ModelAndView mv = new ModelAndView();
	  mv.setViewName(".tiles.page.edu.EDU0001");
	  mv.addObject("educationItems", jsonEducationItems);
	  mv.addObject("onoffItems", jsonOnOffItems);
	
	  LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	  mv.addObject("loginVO", loginVO);
	
	  return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(TrainingInfoBaseSearchForm criteria, Pageable pageable) throws Exception {

    Page<TrainingInfoBaseDto> trainingInfoBaseItems = trainingInfoBaseService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", trainingInfoBaseItems.getTotalElements());

    retMap.put("contents", trainingInfoBaseItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }
  
  
  
  @RequestMapping(method = RequestMethod.GET, value = "/download")
  public ModelAndView download(TrainingInfoBaseSearchForm criteria) throws Exception {

    ModelAndView mv = new ModelAndView("trainingInfoBaseFormXlsView");

    Page<TrainingInfoBaseDto> codeItems = trainingInfoBaseService.searchByCondition(criteria, null);

    Map<String, Object> modelMap = new HashMap<>();
    modelMap.put("result", codeItems.getContent());

    mv.addAllObjects(modelMap);

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
  public ModelAndView searchSd(TrainingInfoBaseSearchForm criteria, Pageable pageable) throws Exception {

    Page<TrainingInfoBaseDto> trainingInfoBaseItems = trainingInfoBaseService.searchBySdCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", trainingInfoBaseItems.getTotalElements());

    retMap.put("contents", trainingInfoBaseItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody TrainingInfoBaseForm trainingInfoBaseForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    //trainingInfoBaseService.create(trainingInfoBaseForm);
    TrainingInfoBaseDto trainingInfoBaseDto = trainingInfoBaseService.searchByKey(trainingInfoBaseForm);
//    trainingInfoBaseForm.setManageNo(trainingInfoBaseDto.getManageNo());
    mv.addObject("data", trainingInfoBaseForm);

    return mv;
  }
  
  
  //wijmo에서 등록할때.
  //데이터 trainingInfoBaseForm 까지 매핑되는거 까지 확인했습니다.
  //trainingInfoBaseService.create(trainingInfoBaseForm) 요부분 수석풀면 기존프로그램데로 insert 될껍니다.
  @RequestMapping(method = RequestMethod.POST, value="/create2")
  public ModelAndView create2(TrainingInfoBaseForm trainingInfoBaseForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    
    trainingInfoBaseService.create(trainingInfoBaseForm);
    //System.out.println("***************아이디값 : "+trainingInfoBaseForm.getId());  //selectKey 아이디값 리턴값으로 들고오기(lot_no 사용할떄 사용)
    
    mv.addObject("result", true);
    
    return mv;
  }
  
  

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody TrainingInfoBaseForm trainingInfoBaseForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    trainingInfoBaseService.update(trainingInfoBaseForm);
    mv.addObject("data", trainingInfoBaseForm);

    return mv;
  }
  
  //wijmo에서 수정할때.
  //데이터 trainingInfoBaseForm 까지 매핑되는거 까지 확인했습니다.
  //trainingInfoBaseService.update(trainingInfoBaseForm) 요부분 수석풀면 기존프로그램데로 update 될껍니다.
  @RequestMapping(method = RequestMethod.POST, value="/update2")
  public ModelAndView update2(TrainingInfoBaseForm trainingInfoBaseForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    //trainingInfoBaseService.update(trainingInfoBaseForm);
    mv.addObject("result", true);

    return mv;
  }

  
  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody TrainingInfoBaseForm trainingInfoBaseForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    trainingInfoBaseService.delete(trainingInfoBaseForm);

    return mv;
  }
  
  //wijmo에서 삭제할때.
  //데이터 trainingInfoBaseForm 까지 매핑되는거 까지 확인했습니다.
  @RequestMapping(method = RequestMethod.POST, value="/delete2")
  public ModelAndView delete2(TrainingInfoBaseForm trainingInfoBaseForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    trainingInfoBaseService.delete(trainingInfoBaseForm);
    mv.addObject("result", true);
    
    return mv;
  }

}
