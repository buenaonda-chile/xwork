/*
 * Project : dicas
 *
 * $Id$
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * [EN] The class defines the controls of Login (WCM0001).<br>
 * [JP] WCM0001 基本機能メニュー画面の制御を定義するクラス。<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
public class LoginController {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public LoginController() {
    // no process
  }

  /**
   * [EN] Display Dicas login page. <br>
   * [JP] Display Dicas login page. <br>
   *
   * @return ModelAndView
   * @throws Exception Exception
   */
  @RequestMapping(method = RequestMethod.GET, value = "/login")
  @ViewId(value = "WCM0001")
  public ModelAndView init(HttpServletRequest request) throws Exception {

    Device currDevice = DeviceUtils.getCurrentDevice(request);

    ModelAndView mv = new ModelAndView();
    if (currDevice.isNormal()) {
      mv.setViewName(".tiles.page.login");
    } else {
      mv.setViewName(".tiles.mobile.login");
    }

    return mv;
  }
}
