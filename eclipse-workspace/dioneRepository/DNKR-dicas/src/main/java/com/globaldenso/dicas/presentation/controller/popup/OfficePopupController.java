package com.globaldenso.dicas.presentation.controller.popup;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.service.OfficeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("popup.officeController")
@RequestMapping(value = "/popup/office")
public class OfficePopupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OfficePopupController.class);

    @Autowired
    private OfficeService officeService;

    /**
     * [EN] Default constructor.<br>
     * [JP] ?????????????<br>
     */
    public OfficePopupController() {
        // no process
    }

    @RequestMapping(method = RequestMethod.GET, value = "/init")
    @ViewId("WCMP004")
    public ModelAndView init(HttpServletRequest request,
             HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        mv.setViewName(".tiles.popup.cmmn.WCMP004");

        return mv;
    }
}
