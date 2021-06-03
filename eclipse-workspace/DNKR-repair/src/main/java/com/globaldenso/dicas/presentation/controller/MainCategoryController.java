package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.MainCategoryDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.MainCategoryService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.MainCategoryForm;
import com.globaldenso.dicas.presentation.form.MainCategorySearchForm;
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
@RequestMapping(value = "/mainCategory")
public class MainCategoryController {

  private static final Logger LOGGER = LoggerFactory.getLogger(MainCategoryController.class);

  @Autowired
  private MainCategoryService maincategoryService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public MainCategoryController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0011")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

	CodeSearchForm searchForm1 = new CodeSearchForm();
	searchForm1.setGrpCds(Arrays.asList(new String[] {
		DicasConstant.CodeGroupAttribute.USE_YN,
            DicasConstant.CodeGroupAttribute.PART_DIV
	}));
	searchForm1.setUseYn("Y");
	List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
	List<CodeDto> useYnList = codeList1
		.stream()
		.filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN))		.collect(Collectors.toList());

    List<CodeDto> partDivList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.PART_DIV)).collect(Collectors.toList());

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.WCM0011");

	mv.addObject("useYnItems", useYnList);
	mv.addObject("partDivItems", partDivList);


    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(MainCategorySearchForm criteria, Pageable pageable) throws Exception {

    Page<MainCategoryDto> maincategoryItems = maincategoryService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", maincategoryItems.getTotalElements());

    retMap.put("contents", maincategoryItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody MainCategoryForm maincategoryForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    maincategoryService.create(maincategoryForm);
    mv.addObject("data", maincategoryForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody MainCategoryForm maincategoryForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    maincategoryService.update(maincategoryForm);
    mv.addObject("data", maincategoryForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody MainCategoryForm maincategoryForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    maincategoryService.delete(maincategoryForm);

    return mv;
  }

}
