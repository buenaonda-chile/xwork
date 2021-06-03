package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.MenuDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.MenuService;
import com.globaldenso.dicas.constant.DicasConstant.CodeGroupAttribute;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.MenuForm;
import com.globaldenso.dicas.presentation.form.MenuSearchForm;
import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping(value = "/menu")
public class MenuController {

  private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

  @Autowired
  private MenuService menuService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public MenuController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0004")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    CodeSearchForm searchForm = new CodeSearchForm();

    searchForm.setGrpCds(Arrays.asList(new String[] {
        CodeGroupAttribute.PUB_YN
    }));
    searchForm.setUseYn("Y");
    List<CodeDto> codeList = codeService.searchCodeByCondition(searchForm);

    List<CodeDto> pubYnItems = codeList
        .stream()
        .filter(item -> item.getGrpCd().equals(CodeGroupAttribute.PUB_YN))
        .collect(Collectors.toList());

    List<MenuDto> menuCategoryItems = menuService.searchMenuCategoryByCondition();

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.WCM0004");

    mv.addObject("menuCategoryItems", menuCategoryItems);
    mv.addObject("pubYnItems", pubYnItems);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(MenuSearchForm criteria, Pageable pageable) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    Page<MenuDto> menuDtos = menuService.searchByCondition(criteria, null);
    mv.addObject("data", menuDtos.getContent());

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody MenuForm menuForm) throws Exception {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    menuForm.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    menuForm.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    ModelAndView mv = new ModelAndView("jsonView");

    menuService.create(menuForm);
    mv.addObject("data", menuForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/update")
  public ModelAndView update(@RequestBody MenuForm menuForm) throws Exception {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    menuForm.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    ModelAndView mv = new ModelAndView("jsonView");

    menuService.update(menuForm);
    mv.addObject("data", menuForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/delete")
  public ModelAndView delete(@RequestBody MenuForm menuForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    menuService.delete(menuForm);

    return mv;
  }
}
