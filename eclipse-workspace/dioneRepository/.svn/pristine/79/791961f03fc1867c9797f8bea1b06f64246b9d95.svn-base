package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.ModelsDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.ModelsService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.ModelsForm;
import com.globaldenso.dicas.presentation.form.ModelsSearchForm;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/models")
public class ModelsController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ModelsController.class);

  @Autowired
  private ModelsService modelsService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ModelsController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0007")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

	CodeSearchForm searchForm1 = new CodeSearchForm();

	searchForm1.setGrpCds(Arrays.asList(new String[] {
		    DicasConstant.CodeGroupAttribute.USE_YN,
            DicasConstant.CodeGroupAttribute.TIRE_STD,
            DicasConstant.CodeGroupAttribute.MAKER,
            DicasConstant.CodeGroupAttribute.EXHAUS_REG,
            DicasConstant.CodeGroupAttribute.ENGINE_TYPE
	}));
    searchForm1.setUseYn("Y");
	List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
	List<CodeDto> useYnList = codeList1
		.stream()
		.filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN))
        .collect(Collectors.toList());

    List<CodeDto> tireStdList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.TIRE_STD))
            .collect(Collectors.toList());

    List<CodeDto> makerList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.MAKER))
            .collect(Collectors.toList());

    List<CodeDto> exhaustRegList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.EXHAUS_REG))
            .collect(Collectors.toList());

    List<CodeDto> engineTypeList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.ENGINE_TYPE)).collect(Collectors.toList());

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.WCM0007");

    mv.addObject("useYnItems", useYnList);
    mv.addObject("tireStdItems", tireStdList);
    mv.addObject("makerItems", makerList);
    mv.addObject("exhaustRegItems", exhaustRegList);
    mv.addObject("engineTypeItems", engineTypeList);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(ModelsSearchForm criteria, Pageable pageable) throws Exception {

    Page<ModelsDto> modelsItems = modelsService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", modelsItems.getTotalElements());

    retMap.put("contents", modelsItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody ModelsForm modelsForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    modelsService.create(modelsForm);
    mv.addObject("data", modelsForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody ModelsForm modelsForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    modelsService.update(modelsForm);
    mv.addObject("data", modelsForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody ModelsForm modelsForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    modelsService.delete(modelsForm);

    return mv;
  }

}
