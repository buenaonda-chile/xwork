package com.globaldenso.dicas.presentation.controller.popup;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.ModelsService;
import com.globaldenso.dicas.presentation.form.ModelsSearchForm;
import com.globaldenso.dicas.presentation.form.VehicleSearchForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("popup.modelsController")
@RequestMapping(value = "/popup/models")
public class ModelsPopupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModelsPopupController.class);

    @Autowired
    private ModelsService modelsService;

    @Autowired
    private CodeService codeService;

    /**
     * [EN] Default constructor.<br>
     * [JP] ?????????????<br>
     */

    public ModelsPopupController() {
        // no process
    }

    @RequestMapping(method = RequestMethod.GET, value = "/init")
    @ViewId("WCMP006")
    public ModelAndView init(ModelsSearchForm criteria,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        mv.setViewName(".tiles.popup.cmmn.WCMP006");
        mv.addObject("modelsForm", criteria);

        return mv;
    }
}
