package com.globaldenso.dicas.presentation.controller.popup;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.service.UserService;
import com.globaldenso.dicas.presentation.form.UserForm;
import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
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

@Controller("popup.ChangePasswordController")
@RequestMapping(value = "/popup/password")
public class ChangePasswordController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ChangePasswordController.class);

  @Autowired
  private UserService userService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public ChangePasswordController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCMP011")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.popup.cmmn.WCMP011");
    mv.addObject("username", loginVO.getUsername());

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/change")
  public ModelAndView change(@RequestBody UserForm userForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

    try {
      userForm.set_id(Long.parseLong(loginVO.getUniqId()));
      userForm.setAcctId(loginVO.getUsername());
      userService.updatePassword(userForm, userForm.getAcctPw());
    } catch (Exception ex) {
      throw new ApplicationException("비밀번호 변경 시 오류가 발생하였습니다.");
    }

    return mv;
  }
}
