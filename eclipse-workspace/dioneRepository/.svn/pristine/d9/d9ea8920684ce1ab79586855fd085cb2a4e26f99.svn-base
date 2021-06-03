package com.globaldenso.dicas.presentation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

  private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public IndexController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/index")
  public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Device currDevice = DeviceUtils.getCurrentDevice(request);
    String contextPath = request.getContextPath() + "/";

    if (currDevice.isNormal()) {
      response.sendRedirect(contextPath + "main");
    } else {
      response.sendRedirect(contextPath + "mobile/serviceSD/init");
    }
  }
}
