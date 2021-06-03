package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.ClaimVehicleDto;
import com.globaldenso.dicas.business.dto.QualityProblemDto;
import com.globaldenso.dicas.business.service.ClaimVehicleService;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.QualityProblemService;
import com.globaldenso.dicas.presentation.form.ClaimVehicleSearchForm;
import com.globaldenso.dicas.presentation.form.QualityProblemSearchForm;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.string.EgovStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.globaldenso.dicas.security.common.LoginVO;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/claimVehicle")
public class ClaimVehicleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClaimVehicleController.class);

    @Autowired
    private ClaimVehicleService claimVehicleService;

    @Autowired
    private CodeService codeService;

    @Autowired
    private QualityProblemService qualityProblemService;

    public ClaimVehicleController() {
    }

    @RequestMapping(method = RequestMethod.GET, value = "/init")
    @ViewId("WWA0001")
    public ModelAndView init(HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        //품질문제명
        Page<QualityProblemDto> qualityProblemNm = qualityProblemService.searchByCondition(new QualityProblemSearchForm(), null);

        ModelAndView mv = new ModelAndView();
        mv.setViewName(".tiles.page.list.WWA0001");

        mv.addObject("qualityProblemNmItems", qualityProblemNm);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ModelAndView search(ClaimVehicleSearchForm criteria, Pageable pageable) throws Exception {

        Page<ClaimVehicleDto> modelsItems = null;
        if (EgovStringUtil.isNull(criteria.getMainType())){
            if (!EgovStringUtil.isNull(criteria.getStatusType())){
                if(criteria.getStatusType().equals("01")){
                    modelsItems = claimVehicleService.searchByMainIngList(criteria,pageable);
                }else{
                    modelsItems = claimVehicleService.searchByMainRsList(criteria,pageable);
                }
            }else{
                LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
                criteria.setStatusUsr(loginVO.getOfficeCd());
                modelsItems = claimVehicleService.searchByConditionRecpDt(criteria, pageable);
            }
        }else{
            modelsItems = claimVehicleService.searchByType(criteria, pageable);
        }

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

    @RequestMapping(method = RequestMethod.GET, value = "/download")
    public ModelAndView download(ClaimVehicleSearchForm criteria) throws Exception {

        Page<ClaimVehicleDto> codeItems = null;
        if (EgovStringUtil.isNull(criteria.getMainType())){
            if (!EgovStringUtil.isNull(criteria.getStatusType())){
                if(criteria.getStatusType().equals("01")){
                    codeItems = claimVehicleService.searchByByMainIngListDownload(criteria,null);
                }else{
                    codeItems = claimVehicleService.searchByMainRsListDownLoad(criteria,null);
                }
            }else{
                codeItems = claimVehicleService.searchByConditionDownload(criteria, null);
            }
        }else{
            codeItems = claimVehicleService.searchByTypeDownload(criteria, null);
        }

        ModelAndView mv = new ModelAndView("claimMstFormXlsView");

//        Page<ClaimVehicleDto> codeItems = claimVehicleService.searchByConditionDownload(criteria, null);

        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("result", codeItems.getContent());

        mv.addAllObjects(modelMap);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/typeSearch")
    public ModelAndView typeSearch(ClaimVehicleSearchForm criteria, Pageable pageable) throws Exception {

        Page<ClaimVehicleDto> modelsItems = claimVehicleService.searchByType(criteria, pageable);

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

    @RequestMapping(method = RequestMethod.GET, value = "/searchByKey")
    public ModelAndView searchByKey(ClaimVehicleSearchForm criteria, Pageable pageable) throws Exception {

        ClaimVehicleDto claimVehicleDto = new ClaimVehicleDto();
        claimVehicleDto.setVinno(criteria.getVinno());

        claimVehicleDto = claimVehicleService.searchByKey(claimVehicleDto);

        ModelAndView mv = new ModelAndView("jsonView");
        mv.addObject("result", true);
        mv.addObject("data", claimVehicleDto);

        return mv;
    }
}
