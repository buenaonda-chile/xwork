package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.MenuRoleDto;
import com.globaldenso.dicas.business.dto.RoleDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.MenuRoleService;
import com.globaldenso.dicas.business.service.MenuService;
import com.globaldenso.dicas.business.service.RoleService;
import com.globaldenso.dicas.presentation.form.MenuRoleForm;
import com.globaldenso.dicas.presentation.form.MenuRoleSearchForm;
import com.globaldenso.dicas.presentation.form.RoleSearchForm;
import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.string.EgovStringUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/menuRole")
public class MenuRoleController {

  private static final Logger LOGGER = LoggerFactory.getLogger(MenuRoleController.class);

  @Autowired
  private MenuRoleService menuroleService;

  @Autowired
  private RoleService roleService;

  @Autowired
  private MenuService menuService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public MenuRoleController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0003")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.WCM0003");

    RoleSearchForm criteria = new RoleSearchForm();
    List<RoleDto> roleItems = roleService.searchByCondition2(criteria);

    mv.addObject("roleItems", roleItems);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(MenuRoleSearchForm criteria) throws Exception {

    if (EgovStringUtil.isEmpty(criteria.getRoleCd()))
      throw new ApplicationException("권한 그룹을 선택한 후 조회하십시오.");

    List<MenuRoleDto> menuroleItems = menuroleService.searchByCondition(criteria);

    ModelAndView mv = new ModelAndView("jsonView");

    mv.addObject("data", menuroleItems);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView create(@RequestBody MenuRoleForm menuroleForm) throws Exception {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    menuroleForm.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    menuroleForm.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    ModelAndView mv = new ModelAndView("jsonView");

    if (menuroleForm.isUse()) {
      menuroleService.create(menuroleForm);
    } else {
      menuroleService.delete(menuroleForm);
    }

    mv.addObject("data", menuroleForm);

    return mv;
  }

}
