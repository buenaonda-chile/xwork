/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.LoginService;

/**
 * [KR] 로그인 관리 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAI001Login")
@ViewId(value = "WAI001")
public class WAI001LoginController {
    
    /**
     * [EN] Field of EmpService.<br>
     * [JP] EmpServiceのフィールド。<br>
     */
    @Autowired
    private LoginService loginService;    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAI001LoginController() {
        // no process
    }
    
    
    
    /**
     * [EN] Main processing<br>
     * [EN] Display the basic menu screen.<br>
     * [JP] メイン処理<br>
     * [JP] 基本機能メニュー画面を表示します。<br>
     * 
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init()  throws Exception {
        
        ModelAndView mv = new ModelAndView(); 

        mv.addObject("url", "WAI001Login.jsp");
        mv.setViewName(".tiles.page.WAI001");
        return mv;
        
    }
    
}
