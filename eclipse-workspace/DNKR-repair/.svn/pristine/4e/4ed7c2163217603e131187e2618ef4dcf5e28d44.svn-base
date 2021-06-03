package com.globaldenso.dicas.presentation.controller.popup;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.ClaimVehicleDto;
import com.globaldenso.dicas.business.dto.QualityProblemDto;
import com.globaldenso.dicas.business.service.ClaimVehicleService;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.QualityProblemService;
import com.globaldenso.dicas.presentation.form.ClaimVehicleSearchForm;
import com.globaldenso.dicas.presentation.form.QualityProblemSearchForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@Controller("popup.claimVehicleController")
@RequestMapping(value = "/popup/claimVehicle")
public class ClaimVehiclePopupController {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.globaldenso.dicas.presentation.controller.ClaimVehicleController.class);

    @Autowired
    private ClaimVehicleService claimVehicleService;

    @Autowired
    private CodeService codeService;

    @Autowired
    private QualityProblemService qualityProblemService;

    public ClaimVehiclePopupController() {
    }

    @RequestMapping(method = RequestMethod.GET, value = "/init")
    @ViewId("WCMP005")
    public ModelAndView init(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

        //품질문제명
        Page<QualityProblemDto> qualityProblemNm = qualityProblemService.searchByCondition(new QualityProblemSearchForm(), null);

        ModelAndView mv = new ModelAndView();
        mv.setViewName(".tiles.popup.cmmn.WCMP005");

        mv.addObject("qualityProblemNmItems", qualityProblemNm);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ModelAndView search(ClaimVehicleSearchForm criteria, Pageable pageable) throws Exception {

        // Page<ClaimVehicleDto> modelsItems = claimVehicleService.searchByCondition(criteria, pageable);
        Page<ClaimVehicleDto> modelsItems = claimVehicleService.searchByPopupCondition(criteria, pageable);

        ModelAndView mv = new ModelAndView("jsonView");

        Map<String, Object> retMap = new HashMap<>();

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("page", pageable.getPageNumber());
        pageMap.put("totalCount", modelsItems.getTotalElements());

        retMap.put("contents", modelsItems.getContent());
        retMap.put("pagination", pageMap);

        mv.addObject("result", true);
        mv.addObject("data", retMap);

        return mv;
    }

}
