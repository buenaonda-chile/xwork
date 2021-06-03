package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.PartNumberDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.PartNumberService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.PartNumberForm;
import com.globaldenso.dicas.presentation.form.PartNumberSearchForm;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/partNumber")
public class PartNumberController {

  private static final Logger LOGGER = LoggerFactory.getLogger(PartNumberController.class);

  @Autowired
  private PartNumberService partnumberService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public PartNumberController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0009")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

	CodeSearchForm searchForm1 = new CodeSearchForm();
	searchForm1.setGrpCds(Arrays.asList(new String[] {
		    DicasConstant.CodeGroupAttribute.USE_YN,
            DicasConstant.CodeGroupAttribute.MAKER,
            DicasConstant.CodeGroupAttribute.GROUP_ID,
            DicasConstant.CodeGroupAttribute.PART_DIV,
            DicasConstant.CodeGroupAttribute.EXHAUS_REG,
            DicasConstant.CodeGroupAttribute.ENGINE_TYPE
    }));
    searchForm1.setUseYn("Y");
	List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
	List<CodeDto> useYnList = codeList1
		.stream()
		.filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN)).collect(Collectors.toList());

    List<CodeDto> makerList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.MAKER)).collect(Collectors.toList());

    List<CodeDto> groupIdList = codeList1
        .stream()
        .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.GROUP_ID)).collect(Collectors.toList());

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
    mv.setViewName(".tiles.page.cmmn.WCM0009");

	mv.addObject("useYnItems", useYnList);
    mv.addObject("makerItems", makerList);
    mv.addObject("groupIdItems", groupIdList);
    mv.addObject("partDivItems", partDivList);
    mv.addObject("exhaustRegItems", exhaustRegList);
    mv.addObject("engineTypeItems", engineTypeList);
    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(PartNumberSearchForm criteria, Pageable pageable) throws Exception {

    Page<PartNumberDto> partnumberItems = partnumberService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", partnumberItems.getTotalElements());

    retMap.put("contents", partnumberItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody PartNumberForm partnumberForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    partnumberService.create(partnumberForm);
    mv.addObject("data", partnumberForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody PartNumberForm partnumberForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    partnumberService.update(partnumberForm);
    mv.addObject("data", partnumberForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody PartNumberForm partnumberForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    partnumberService.delete(partnumberForm);

    return mv;
  }

}
