package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.DeptTreeDto;
import com.globaldenso.dicas.business.dto.GroupDto;
import com.globaldenso.dicas.business.dto.RoleDto;
import com.globaldenso.dicas.business.dto.UserDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.GroupService;
import com.globaldenso.dicas.business.service.RoleService;
import com.globaldenso.dicas.business.service.UserService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.GroupSearchForm;
import com.globaldenso.dicas.presentation.form.RoleSearchForm;
import com.globaldenso.dicas.presentation.form.UserForm;
import com.globaldenso.dicas.presentation.form.UserSearchForm;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.fdl.string.EgovStringUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
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
@RequestMapping(value = "/user")
public class UserController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  @Autowired
  private CodeService codeService;

  @Autowired
  private GroupService groupService;

  @Autowired
  private RoleService roleService;

  @Resource(name = "propertiesService")
  protected EgovPropertyService propertiesService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public UserController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0006")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    CodeSearchForm searchForm1 = new CodeSearchForm();
    searchForm1.setGrpCds(Arrays.asList(new String[] {
        DicasConstant.CodeGroupAttribute.USE_YN
    }));
    List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
    List<CodeDto> useYnList = codeList1
        .stream()
        .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN))
        .collect(Collectors.toList());
    searchForm1.setUseYn("Y");

    List<DeptTreeDto> groupList = groupService.searchGroupTreeByCondition(new GroupSearchForm());

    List<RoleDto> roleList = roleService.searchByCondition2(new RoleSearchForm());

    String initPassword = propertiesService.getString("initPassword");

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.WCM0006");

    mv.addObject("useYnItems", useYnList);
    mv.addObject("groupItems", groupList);
    mv.addObject("roleItems", roleList);
    mv.addObject("initPassword", initPassword);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(UserSearchForm criteria, Pageable pageable) throws Exception {

    Page<UserDto> userItems = userService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", userItems.getTotalElements());

    retMap.put("contents", userItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody UserForm userForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    userService.create(userForm);
    mv.addObject("data", userForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody UserForm userForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    userService.update(userForm);
    mv.addObject("data", userForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody UserForm userForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    userService.delete(userForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/password/init")
  public ModelAndView passwordInit(@RequestBody UserForm userForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    if (EgovStringUtil.isEmpty(userForm.getUserId())) {
      throw new ApplicationException("비밀번호 초기화할 대상 선택한 후 실행하십시오.");
    }

    try {
      userService.transactInitPassword(userForm);
    } catch (Exception ex) {
      throw new ApplicationException("비밀번호 초기화 시 오류가 발생하였습니다.");
    }

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/password/init/all")
  public ModelAndView passwordInitAll() throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    try {
      userService.transactInitPasswordAll();
    } catch (Exception ex) {
      throw new ApplicationException("비밀번호 초기화 시 오류가 발생하였습니다.");
    }

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/search2")
  @ResponseBody
  public Map<String, Object> search2(UserSearchForm criteria) throws Exception {

    criteria.setDeptCd("DIKR");
    List<UserDto> userItems = userService.searchUserByCondition(criteria);

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("data", userItems);
    retMap.put("total", userItems.size());

    return retMap;
  }

}