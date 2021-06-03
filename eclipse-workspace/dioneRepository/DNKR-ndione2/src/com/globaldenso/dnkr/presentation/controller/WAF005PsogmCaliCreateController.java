/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.PsogmService;
import com.globaldenso.dnkr.domain.db2.PsogmDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [EN] The class defines the controls of Menu (WA0000).<br>
 * [JP] WA0000 基本機能メニュー画面の制御を定義するクラス。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAF005PsogmCaliCreate")
@ViewId(value = "WAF005")
public class WAF005PsogmCaliCreateController {

    /**
     * [KR] 설비보전관리 서비스 <br>          
     */
    @Autowired
    private PsogmService psogmService;
    
    /**
     * 종합관리 > 설비보전 > 메뉴코드
     */
    private final String MENU_CODE = "3"; 

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAF005PsogmCaliCreateController() {
        // no process
    }

    /**
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView init(HttpServletRequest request) throws Exception {

        ModelAndView mv = new ModelAndView();
        System.out.println("/WAF005PsogmCaliCreate");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");

        //PsogmDomain domain = new PsogmDomain();
        List<PsogmDomain> list = null; 
        try {
//          list = psogmService.getogm313_cmbprtcd(domain);
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        mv.addObject("list", list);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAF005PsogmCaliCreate.jsp");
        mv.setViewName(".tiles.page.WAF005");
        return mv;
    }

}
