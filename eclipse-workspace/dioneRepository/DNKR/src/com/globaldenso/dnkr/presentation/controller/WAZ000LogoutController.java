/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.constant.AiSampleConstants;

/**
 * [EN] The class defines the controls of Logout (WZ0099).<br>
 * [JP] WZ0099 ログアウト画面の制御を定義するクラス。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/")
@ViewId(value = "WZ0099")
public class WAZ000LogoutController {
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAZ000LogoutController() {
        // no process
    }
    
    
    
    /**
     * [EN] Main processing.<br>
     * [EN] I want logout process.<br>
     * [JP] メイン処理。<br>
     * [JP] ログアウト処理をします。<br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return String
     */
    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        
        // [EN] Destroying a session, delete the Cookie
        // [JP] セッションを破棄し、クッキーを削除します。
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            response.addCookie(this.initCookie(request, AiSampleConstants.SM_KEY_JSESSIONID));
            response.addCookie(this.initCookie(request, AiSampleConstants.SM_KEY_TRY_NO));
            response.addCookie(this.initCookie(request, AiSampleConstants.SM_KEY_AUTHENTICATED));
        }
        
//        return ".tiles.page.WZ0099Logout";
        return "/";
        
    }
    
    /**
     * [EN] I will create a Cookie for initialization.<br>
     * [JP] 初期化用のCookieを作成します。<br>
     * 
     * @param request HTTP request
     * @param name The name of the Cookie
     * @return Cookie object you created
     */
    private Cookie initCookie(HttpServletRequest request, String name) {
        
        Cookie cookie = null;
        
        // [EN] I initialize a cookie.
        // [JP] クッキーを初期化します。
        try {
            cookie = new Cookie(name, URLEncoder.encode("", request.getCharacterEncoding()));
            cookie.setMaxAge(0);
        } catch (UnsupportedEncodingException e) {
            throw new SystemException(e);
        }
        
        return cookie;
        
    }
}
