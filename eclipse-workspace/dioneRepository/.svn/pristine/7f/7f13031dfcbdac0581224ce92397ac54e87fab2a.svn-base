package com.globaldenso.dicas.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.MainCategoryDto;
import com.globaldenso.dicas.business.dto.SubCategoryDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.MainCategoryService;
import com.globaldenso.dicas.business.service.SubCategoryService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.MainCategorySearchForm;
import com.globaldenso.dicas.presentation.form.SubCategoryForm;
import com.globaldenso.dicas.presentation.form.SubCategorySearchForm;
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
@RequestMapping(value = "/subCategory")
public class SubCategoryController {

  private static final Logger LOGGER = LoggerFactory.getLogger(SubCategoryController.class);

    @Autowired
    private MainCategoryService maincategoryService;

    @Autowired
    private SubCategoryService subcategoryService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public SubCategoryController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0017")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

	CodeSearchForm searchForm1 = new CodeSearchForm();
	searchForm1.setGrpCds(Arrays.asList(new String[] {
		DicasConstant.CodeGroupAttribute.USE_YN,
		DicasConstant.CodeGroupAttribute.PART_DIV,
	}));
	searchForm1.setUseYn("Y");
	List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
	List<CodeDto> useYnList = codeList1
		.stream()
		.filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN)).collect(Collectors.toList());

	List<CodeDto> partDivList = codeList1
		.stream()
		.filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.PART_DIV)).collect(Collectors.toList());

      // 현상
      Page<MainCategoryDto> mainCategoryItems = maincategoryService.searchByCondition(new MainCategorySearchForm(), null);

      ObjectMapper mapper = new ObjectMapper();
      String jsonMainCategoryItems = "";
      try {
          jsonMainCategoryItems = mapper.writeValueAsString(mainCategoryItems.getContent());
      } catch (IOException ex) {
          ex.printStackTrace();
      }

      Page<SubCategoryDto> subCategoryItems = subcategoryService.searchByCondition(new SubCategorySearchForm(), null);

      mapper = new ObjectMapper();
      String jsonSubCategoryItems = "";
      try {
          jsonSubCategoryItems = mapper.writeValueAsString(subCategoryItems.getContent());
      } catch (IOException ex) {
          ex.printStackTrace();
      }


    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.WCM0017");

	mv.addObject("useYnItems", useYnList);
      mv.addObject("mainCategoryItems", jsonMainCategoryItems);
      mv.addObject("mainCategoryItems2", mainCategoryItems);
      mv.addObject("subCategoryItems", jsonSubCategoryItems);
      mv.addObject("partDivItems", partDivList);


    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(SubCategorySearchForm criteria, Pageable pageable) throws Exception {

    Page<SubCategoryDto> subcategoryItems = subcategoryService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", subcategoryItems.getTotalElements());

    retMap.put("contents", subcategoryItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody SubCategoryForm subcategoryForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    subcategoryService.create(subcategoryForm);
    mv.addObject("data", subcategoryForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody SubCategoryForm subcategoryForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    subcategoryService.update(subcategoryForm);
    mv.addObject("data", subcategoryForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody SubCategoryForm subcategoryForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    subcategoryService.delete(subcategoryForm);

    return mv;
  }

}
