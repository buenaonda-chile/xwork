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

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.db2.PsfacService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.PsfacDb2Domain;
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
@RequestMapping(value = "/WAF012PsfacSearch")
@ViewId(value = "WAF012")
public class WAF012PsfacSearchController {

    /**
     * [KR] 설비보전관리 서비스 <br>          
     */
    @Autowired
    private PsfacService psfacService;
    
    /**
     * [KR] 공통코드관리 서비스 <br>          
     */
    @Autowired
    private CodeService codeService;
    
    /**
     * 종합관리 > 설비보전 > 메뉴코드
     */
    private final String MENU_CODE = "3"; 

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAF012PsfacSearchController() {
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

    	//System.out.println("/WAF012PsfacSearch");
        ModelAndView mv = new ModelAndView();
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
        /*// 사업부, 사업장 세션에 담는걸로 변경 - 180626 김용균대리님 요청
      //공통코드
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        CodeDb2Domain codeDomain = new CodeDb2Domain();
        codeDomain.setDb2class("PLNT");
        codeDomain.setCoded1(empInfo.getCompany());
        
        List<CodeDb2Domain> codeList = null;
        try {
            codeList = codeService.comCode(codeDomain);
            mv.addObject("codeList", codeList);
        } catch(Exception e) {
            System.out.println("데이터가 없습니다.");
        }
        */
        UxisCmmUtil.getSessionComCode(request, mv);
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));     
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAF012PsfacSearch.jsp");
        mv.setViewName(".tiles.page.WAF012");
        return mv;
    }
    
    /**
     * 
     * @param request   HttpServletRequest
     * @param form   PsfacDb2Domain
     * @return  ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/getGridVal", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView searchPop(HttpServletRequest request, @ModelAttribute("PsfacForm") PsfacDb2Domain form) throws Exception{
                
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        List<PsfacDb2Domain> list = null;
      
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setLib1(empInfo.getLib1());
        form.setLib2(empInfo.getLib2());
//        form.setLib1("PSRESLIB");
//        form.setLib2("PSCDBLIB");
//        form.setComps("C1");
        try {
            list = psfacService.selectFEP200PF(form);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        if(list != null && list.size() > 0) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("list", list);
        }

        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
}