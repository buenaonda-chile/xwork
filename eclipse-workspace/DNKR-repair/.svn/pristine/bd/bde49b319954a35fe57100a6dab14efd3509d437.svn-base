package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkController {

  private static final Logger LOGGER = LoggerFactory.getLogger(WorkController.class);

  /**
   * [EN] Default constructor.<br> [JP] デフォルトコンストラクタ。<br>
   */
  public WorkController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/work/wwk0001")
  @ViewId("WWK0001")
  public ModelAndView init(HttpServletRequest request) throws Exception {

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.work.WWK0001");
    return mv;
  }
}
