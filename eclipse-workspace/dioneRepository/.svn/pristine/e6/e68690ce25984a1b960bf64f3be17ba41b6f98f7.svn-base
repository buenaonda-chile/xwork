/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.message.MessageManager;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.dnkr.business.service.LinkService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.LinkDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAC019SsoManagementForm;




/**
 * [KO] <br>
 * [EN] <br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxLinkSso")
public class AjaxLinkSsoController {

    /**
     * [EN] Field of LinkService.<br>
     * [JP] LinkServiceのフィールド。<br>
     */
    @Autowired
    private LinkService linkService;    
   
    

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxLinkSsoController() {
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
        System.out.println("ajaxLinkSso/init");

        mv.addObject("url", "WAC019SsoManagement.jsp");
        mv.setViewName(".tiles.page.WAC019");
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
     * @param form  WAC017LinkManagementForm
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAC019")
    public void update(@Validated WAC019SsoManagementForm form, HttpServletRequest request, HttpServletResponse response)  
        throws Exception {

        /**
         * <pre>
         * 1.[KO] 링크 정보 수정 처리.<br>
         *   [KO] 입력한 내용으로 링크정보를 수정한다.<br>
         * 1.[EN] <br>
         *   [EN] <br>
         *   [JP] 
         *   [JP] 
         * </pre>
         */

    	 //세션 저장된 데이터 불러오기
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
        String empId        = (String)empJsonObj.get("empId");        //사용자 ID
        
        form.setUpdateUser(empId);
          
        linkService.updateSso(form);
        
        JSONObject jsonObj = new JSONObject();
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
    //@ErrorBack(viewName = "forward:/WAC019SsoManagement/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        /**
         * <pre>
         * 1.[KO] 링크 삭제 처리<br>
         *   [KO]   화면에서 선택된 링크을 DB에서 삭제합니다.<br>
         * 1.[EN] <br>
         *   [EN] <br>
         *   [JP]
         * </pre>
         */        
        //System.out.println("delete start");
    	System.out.println("delete");
        LinkDomain linkDomain = new LinkDomain();
        String delSeq = ServletRequestUtils.getStringParameter(request, "seq");
  
        linkDomain.setSeq(delSeq);
        
        
        int count = linkService.deleteSso(linkDomain);
   
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("result", DnkrConstans.RESULT_OK);
        MessageManager.setInformation("SMPL-I0-0002", new Object[] {
                MessageSources.getInstance().value("info.code"), 
                String.valueOf(count)});
    
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
	}
}
