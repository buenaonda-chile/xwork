package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.RoleDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.RoleService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.RoleForm;
import com.globaldenso.dicas.presentation.form.RoleSearchForm;
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
@RequestMapping(value = "/role")
public class RoleController {

  private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

  @Autowired
  private RoleService roleService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public RoleController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0002")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.WCM0002");

    RoleSearchForm criteria = new RoleSearchForm();
    List<RoleDto> roleItems = roleService.searchByCondition2(criteria);

    mv.addObject("roleItems", roleItems);

    return mv;
  }
  
  
  
  
  
  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search() throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    
    RoleSearchForm criteria = new RoleSearchForm();
    List<RoleDto> roleItems = roleService.searchByCondition2(criteria);
    
    mv.addObject("result", true);
    mv.addObject("data", roleItems);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody RoleForm roleForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    roleService.create(roleForm);
    mv.addObject("data", roleForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody RoleForm roleForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    roleService.update(roleForm);
    mv.addObject("data", roleForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody RoleForm roleForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    roleService.delete(roleForm);

    return mv;
  }

}
