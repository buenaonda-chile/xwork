package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.ResultMasterCostDto;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.ResultMasterCostService;
import com.globaldenso.dicas.business.service.ResultMasterService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.ResultMasterForm;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/resultMaster")
public class ResultMasterController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResultMasterController.class);

  @Autowired
  private ResultMasterService resultmasterService;

  @Autowired
  private ResultMasterCostService resultmastercostService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ResultMasterController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WWK0005")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {


    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.work.WWK0005");

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

  @RequestMapping(method = RequestMethod.GET, value = "/download")
  public ModelAndView download(ResultMasterSearchForm criteria) throws Exception {

    ModelAndView mv = new ModelAndView("resultMstFormXlsView");

    Page<ResultMasterDto> codeItems = resultmasterService.searchListByConditionDownload(criteria, null);

    Map<String, Object> modelMap = new HashMap<>();
    modelMap.put("result", codeItems.getContent());

    mv.addAllObjects(modelMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody ResultMasterForm resultmasterForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    resultmasterService.create(resultmasterForm);
    mv.addObject("data", resultmasterForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody ResultMasterForm resultmasterForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    resultmasterService.update(resultmasterForm);
    mv.addObject("data", resultmasterForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/updateManageNo")
  public ModelAndView updateManageNo(@RequestBody ResultMasterForm resultmasterForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    resultmasterService.updateManageNo(resultmasterForm);
    mv.addObject("data", resultmasterForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/gridUpdate")
  public ModelAndView gridUpdate(@RequestBody ResultMasterForm resultmasterForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    resultmasterService.gridUpdate(resultmasterForm);
    mv.addObject("data", resultmasterForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody ResultMasterForm resultmasterForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    resultmasterService.delete(resultmasterForm);

    return mv;
  }

    @RequestMapping(method = RequestMethod.POST, value="/deleteManageNo")
    public ModelAndView deleteManageNo(@RequestBody ResultMasterForm resultmasterForm) throws Exception {

        ModelAndView mv = new ModelAndView("jsonView");
        resultmasterService.deleteManageNo(resultmasterForm);

        return mv;
    }

  @RequestMapping(method = RequestMethod.POST, value="/update2")
  public ModelAndView update2(@RequestBody ResultMasterForm resultmasterForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    resultmasterService.update2(resultmasterForm);
    mv.addObject("data", resultmasterForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search2")
  public ModelAndView search2(ResultMasterSearchForm criteria, Pageable pageable) throws Exception {

    Page<ResultMasterDto> resultmasterItems = resultmasterService.searchByCondition2(criteria, pageable);

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

  // 클레임 조사
  @RequestMapping(method = RequestMethod.GET, value = "/search3")
  public ModelAndView search3(ResultMasterSearchForm criteria, Pageable pageable) throws Exception {

    Page<ResultMasterDto> resultmasterItems = resultmasterService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", resultmasterItems.getTotalElements());

    retMap.put("contents", resultmasterItems.getContent());
    retMap.put("pagination", pageMap);


    /*
    List<ResultMasterDto> fileItems
            = resultmasterService.searchByConditionFile(criteria, pageable);
    mv.addObject("fileItems", fileItems);
    */

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  // 클레임 조사 SD
  @RequestMapping(method = RequestMethod.GET, value = "/search4")
  public ModelAndView search4(ResultMasterSearchForm criteria, Pageable pageable) throws Exception {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    criteria.setSdAppoint(loginVO.getOfficeCd());

    Page<ResultMasterDto> resultmasterItems = resultmasterService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", resultmasterItems.getTotalElements());

    retMap.put("contents", resultmasterItems.getContent());
    retMap.put("pagination", pageMap);


    /*
    List<ResultMasterDto> fileItems
            = resultmasterService.searchByConditionFile(criteria, pageable);

    mv.addObject("fileItems", fileItems);
    */
    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  //비용처리상황
  @RequestMapping(method = RequestMethod.GET, value = "/search5")
  public ModelAndView search5(ResultMasterSearchForm criteria, Pageable pageable) throws Exception {

    //Page<ResultMasterDto> resultmasterItems = resultmasterService.searchByCondition(criteria, pageable);
    Page<ResultMasterDto> resultmasterItems = resultmasterService.searchListByCondition2(criteria, pageable);

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

  @RequestMapping(method = RequestMethod.POST, value="/update4")
  public ModelAndView update4(@RequestBody ResultMasterForm resultmasterForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    resultmasterService.update4(resultmasterForm);
    mv.addObject("data", resultmasterForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update5")
  public ModelAndView update5(@RequestBody ResultMasterForm resultmasterForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    resultmasterService.update5(resultmasterForm);
    mv.addObject("data", resultmasterForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete2")
  public ModelAndView delete2(@RequestBody ResultMasterForm resultmasterForm) throws Exception {

    resultmasterForm.setDist(new Long(0));
    resultmasterForm.setTravelAmt(new Long(0));
    resultmasterForm.setRepairAmtTot(new Long(0));
    resultmasterForm.setPartMarginCulcu(new Long(0));
    resultmasterForm.setTotalAmt(new Long(0));
    resultmasterForm.setTaxAmt(new Long(0));
    resultmasterForm.setEtcAmtTot(new Long(0));
    resultmasterForm.setPartAmtTot(new Long(0));
    ModelAndView mv = new ModelAndView("jsonView");
    resultmasterService.update2(resultmasterForm);

    ResultMasterCostDto resultmastercostDto = new ResultMasterCostDto();
    resultmastercostDto.setMngNo(resultmasterForm.getManageNo());
    resultmastercostService.delete2(resultmastercostDto);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/mobileUpdate")
  public ModelAndView mobileUpdate(@RequestBody ResultMasterForm resultmasterForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    resultmasterService.mobileUpdate(resultmasterForm);
    mv.addObject("data", resultmasterForm);

    return mv;
  }

}
