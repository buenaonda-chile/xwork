package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.constant.DicasConstant.CodeGroupAttribute;
import com.globaldenso.dicas.presentation.form.CodeForm;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/code")
public class CodeController {

  private static final Logger LOGGER = LoggerFactory.getLogger(CodeController.class);

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public CodeController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0001")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    CodeSearchForm searchForm = new CodeSearchForm();

    List<CodeDto> groupList = codeService.searchGrpCdByCondition(searchForm);

    searchForm.setGrpCds(Arrays.asList(new String[] {
        CodeGroupAttribute.USE_YN
    }));
    List<CodeDto> codeList = codeService.searchCodeByCondition(searchForm);

    List<CodeDto> useYnList = codeList
        .stream()
        .filter(item -> item.getGrpCd().equals(CodeGroupAttribute.USE_YN))
        .collect(Collectors.toList());

    ModelAndView mv = new ModelAndView();

    mv.setViewName(".tiles.page.cmmn.WCM0001");
    mv.addObject("groupItems", groupList);
    mv.addObject("useYnItems", useYnList);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(CodeSearchForm criteria, Pageable pageable) throws Exception {

    // grpCd == null 일경우 ""로 초기화
    if (criteria.getGrpCd() == null) criteria.setGrpCd("");

    Page<CodeDto> codeItems = codeService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", codeItems.getTotalElements());

    retMap.put("contents", codeItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody CodeForm codeForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    codeService.create(codeForm);
    mv.addObject("data", codeForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody CodeForm codeForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    codeService.update(codeForm);
    mv.addObject("data", codeForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody CodeForm codeForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    codeService.delete(codeForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/download")
  public ModelAndView download(CodeSearchForm criteria) throws Exception {

    ModelAndView mv = new ModelAndView("codeFormXlsView");

    // grpCd == null 일경우 ""로 초기화
    if (criteria.getGrpCd() == null) criteria.setGrpCd("");
    Page<CodeDto> codeItems = codeService.searchByCondition(criteria, null);

    Map<String, Object> modelMap = new HashMap<>();
    modelMap.put("result", codeItems.getContent());

    mv.addAllObjects(modelMap);

    return mv;
  }

  @RequestMapping(value="/group/list.json")
  public ModelAndView getGroupCodeList() throws Exception {

    CodeSearchForm criteria = new CodeSearchForm();
    List<CodeDto> codeItems = codeService.searchGrpCdByCondition(criteria);

    ModelAndView mv = new ModelAndView("jsonView");
    mv.addObject("data", codeItems);
    mv.addObject("total", codeItems.size());

    return mv;
  }

  @RequestMapping(value = "/list.json")
  @ResponseBody
  public Map<String, Object> getCodeList(@RequestBody CodeSearchForm criteria) throws Exception {

    List<CodeDto> codeItems = codeService.searchCodeByCondition(criteria);

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("data", codeItems);
    retMap.put("total", codeItems.size());

    return retMap;
  }

  @RequestMapping(value = "/list.json/{grpCd}")
  @ResponseBody
  public Map<String, Object> getCodeList(@RequestBody CodeSearchForm criteria, @PathVariable String grpCd) throws Exception {

    criteria.setUseYn("Y");
    criteria.setGrpCd(grpCd);

    List<CodeDto> codeItems = codeService.searchCodeByCondition(criteria);

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("data", codeItems);
    retMap.put("total", codeItems.size());

    return retMap;
  }
  
  @RequestMapping(value = "/list2.json/{grpCd}")
  @ResponseBody
  public Map<String, Object> getCodeList2(@PathVariable String grpCd) throws Exception {
	
	CodeSearchForm criteria = new CodeSearchForm();
    criteria.setUseYn("Y");
    criteria.setGrpCd(grpCd);

    List<CodeDto> codeItems = codeService.searchCodeByCondition(criteria);

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("data", codeItems);
    retMap.put("total", codeItems.size());

    return retMap;
  }

}
