/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.message.MessageManager;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.dnkr.business.service.AuthService;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.AuthDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAD001AuthCreateForm;

/**
 * [KO] <br>
 * [EN] <br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxAuth")
public class AjaxAuthController {

    /**
     * [EN] Field of AuthService.<br>
     * [JP] EmpServiceのフィールド。<br>
     */
    @Autowired
    private AuthService authService;
    
    /**
     * [KR] 공통코드 서비스 <br>     
     */
    @Autowired
    private CodeService codeService;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxAuthController() {
        //no process
    }
    
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
//    @Token(save = true)
    public ModelAndView init(HttpServletRequest request)  throws Exception {
        
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        
        AuthDomain authDomain = new AuthDomain();
        authDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<AuthDomain> authList = authService.searchByCondition(authDomain);
        
        mv.addObject("authList", authList);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAD001AuthSearch.jsp");
        mv.setViewName(".tiles.page.WAD001");
        return mv;
        
    }
    
    /**
     * [KO] 주 처리과정.<br>
     * [KO] 권한 정보 수정.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] <br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param form  WAD001AuthCreateForm
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAF015")
    public void update(@Validated WAD001AuthCreateForm form, HttpServletResponse response)  
        throws Exception {

        /**
         * <pre>
         * 1.[KO] 권한 정보 수정 처리.<br>
         *   [KO]   입력한 내용으로 권한정보를 수정한다.<br>
         * 1.[EN] <br>
         *   [EN] <br>
         *   [JP] 
         *   [JP] 
         * </pre>
         */

        JSONObject jsonObj = new JSONObject();

        form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        authService.update(form);
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.getWriter().print(jsonObj);
        return;
    }
    
    /**
     * [KO] 공통코드 삭제.<br>
     * [EN] Main processing<br>
     * [EN] Delete from the DB the information displayed on the screen.<br>
     * [JP] 社員削除処理<br>
     * [JP] 画面上で選択された社員情報をDBから削除します。<br>
     * 
     * @param request HttpServletRequest 
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAD001AuthSearch/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        /**
         * <pre>
         * 1.[KO] 권한 삭제 처리<br>
         *   [KO]   화면에서 선택된 권한을 DB에서 삭제합니다.<br>
         * 1.[EN] <br>
         *   [EN] <br>
         *   [JP]
         * </pre>
         */

        //System.out.println("delete start");
        JSONObject jsonObj = new JSONObject();
        AuthDomain delAuthDomain = new AuthDomain();
        
        String delAuthCode = ServletRequestUtils.getStringParameter(request, "authCode");
        
        delAuthDomain.setAuthCode(delAuthCode);
        int count = authService.delete(delAuthDomain);
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);
        MessageManager.setInformation("SMPL-I0-0002", new Object[] {
                MessageSources.getInstance().value("info.code"), 
                String.valueOf(count)});
    
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
    
}
