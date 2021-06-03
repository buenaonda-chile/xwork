package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.OfficeDto;
import com.globaldenso.dicas.business.dto.UserDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.OfficeService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.OfficeForm;
import com.globaldenso.dicas.presentation.form.OfficeSearchForm;

import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globaldenso.dicas.presentation.form.UserSearchForm;
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
@RequestMapping(value = "/office")
public class OfficeController {

  private static final Logger LOGGER = LoggerFactory.getLogger(OfficeController.class);

  @Autowired
  private OfficeService officeService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public OfficeController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0010")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

	CodeSearchForm searchForm1 = new CodeSearchForm();
	searchForm1.setGrpCds(Arrays.asList(new String[] {
		    DicasConstant.CodeGroupAttribute.USE_YN,
            DicasConstant.CodeGroupAttribute.MAKER,
            DicasConstant.CodeGroupAttribute.OFFICE_DIV,
            DicasConstant.CodeGroupAttribute.OFFICE_CITY,
            DicasConstant.CodeGroupAttribute.MATERIAL_DIV,
            DicasConstant.CodeGroupAttribute.USE_YN
	}));
    searchForm1.setUseYn("Y");
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
    mv.setViewName(".tiles.page.cmmn.WCM0010");

	mv.addObject("useYnItems", useYnList);
    mv.addObject("makerItems", makerList);
    mv.addObject("officeDivItems", officeDivList);
    mv.addObject("officeCityItems", officeCityList);
    mv.addObject("materialDivItems", materialDivList);
    mv.addObject("reprYnItems", reprYnList);

      return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
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

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody OfficeForm officeForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    officeService.create(officeForm);
    mv.addObject("data", officeForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody OfficeForm officeForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    officeService.update(officeForm);
    mv.addObject("data", officeForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody OfficeForm officeForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    officeService.delete(officeForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search2")
  @ResponseBody
  public Map<String, Object> search2(OfficeSearchForm criteria, HttpServletRequest request) throws Exception {

    String str = request.getParameter("filter");
    System.out.println(str);

    //{"filter":{"filters":[{"field":"codeCd","operator":"eq","value":"103"}],"logic":"and"}}

    criteria.setFlag(new Long(1));
    criteria.setOfficeCity(str);
    List<OfficeDto> officeItems = officeService.searchOfficeByCondition(criteria);

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("data", officeItems);
    retMap.put("total", officeItems.size());

    return retMap;
  }

}
