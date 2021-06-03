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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/trainingAppcntStat")
public class TrainingAppcntStatController {

  private static final Logger LOGGER = LoggerFactory.getLogger(TrainingAppcntStatController.class);

  @Autowired
  private TrainingAppcntStatService trainingAppcntStatService;

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
  public TrainingAppcntStatController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("EDU0003")
  public ModelAndView init(HttpServletRequest request,
	  HttpServletResponse response) throws Exception {

	  ModelAndView mv = new ModelAndView();
	  mv.setViewName(".tiles.page.edu.EDU0003");

	
	  LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	  mv.addObject("loginVO", loginVO);
	
	  return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(TrainingAppcntStatSearchForm criteria, Pageable pageable) throws Exception {

    Page<TrainingAppcntStatDto> trainingAppcntStatItems = trainingAppcntStatService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", trainingAppcntStatItems.getTotalElements());

    retMap.put("contents", trainingAppcntStatItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }
  
  @RequestMapping(method = RequestMethod.GET, value = "/download")
  public ModelAndView download(TrainingAppcntStatSearchForm criteria) throws Exception {

    ModelAndView mv = new ModelAndView("trainingAppcntStatFormXlsView");

    Page<TrainingAppcntStatDto> codeItems = trainingAppcntStatService.searchByCondition(criteria, null);

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
  public ModelAndView searchSd(TrainingAppcntStatSearchForm criteria, Pageable pageable) throws Exception {

    Page<TrainingAppcntStatDto> trainingAppcntStatItems = trainingAppcntStatService.searchBySdCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", trainingAppcntStatItems.getTotalElements());

    retMap.put("contents", trainingAppcntStatItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody TrainingAppcntStatForm trainingAppcntStatForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    trainingAppcntStatService.create(trainingAppcntStatForm);
    TrainingAppcntStatDto trainingAppcntStatDto = trainingAppcntStatService.searchByKey(trainingAppcntStatForm);
//    trainingInfoBaseForm.setManageNo(trainingInfoBaseDto.getManageNo());
    mv.addObject("data", trainingAppcntStatForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody TrainingAppcntStatForm trainingAppcntStatForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    trainingAppcntStatService.update(trainingAppcntStatForm);
    mv.addObject("data", trainingAppcntStatForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody TrainingAppcntStatForm trainingAppcntStatForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    trainingAppcntStatService.delete(trainingAppcntStatForm);

    return mv;
  }

}
