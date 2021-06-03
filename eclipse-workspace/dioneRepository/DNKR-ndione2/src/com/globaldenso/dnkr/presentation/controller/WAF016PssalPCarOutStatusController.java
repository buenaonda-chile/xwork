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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.PsogmService;
import com.globaldenso.dnkr.business.service.db2.PssalPCarOutService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.PssalPCarOutDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisStringUtil;

/**
 * [EN] The class defines the controls of Menu (WA0000).<br>
 * [JP] WA0000 基本機能メニュー画面の制御を定義するクラス。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAF016PssalPCarOutStatus")
@ViewId(value = "WAF016")
public class WAF016PssalPCarOutStatusController {

    /**
     * [KR] 설비보전관리 서비스 <br>          
     */
    @Autowired
    private PsogmService psogmService;
    
    /**
     * [KR] 년업체차종별제품출고집계현황 서비스
     */
    @Autowired
    private PssalPCarOutService psslPCarOutService;
    
    /**
     * [KR] 공통코드관리 서비스 <br>          
     */
    @Autowired
    private CodeService codeService;
    
    /**
     * 종합관리 > 설비보전 > 년업체차종별제품출고집계현황 > 메뉴코드
     */
    private final String MENU_CODE = "549"; 

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAF016PssalPCarOutStatusController() {
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
        //System.out.println("/WAF016PssalPCarOutStatus");
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
        
        
        // s: 오늘 일자
        mv.addObject("year", UxisCmmUtil.getYear());
        mv.addObject("today", UxisStringUtil.getTodayYMDString());
        // e: 오늘 일자
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAF016PssalPCarOutStatus.jsp");
        mv.setViewName(".tiles.page.WAF016");
        return mv;
    }

    /**
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/searchPop", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView searchPop(HttpServletRequest request) throws Exception{

        ModelAndView mv = new ModelAndView();

        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("url", "WAF019PsogmSearchPop.jsp");
        mv.setViewName(".tiles.page.WAF019");
        return mv;
    }
    
    
    /**
     * [KR] 년업체차종별제품출고집계현황 검색 데이터 값 조회
     * @param request HttpServletRequest
     * @param form PssalPCarOutDomain
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/getGridVal", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView getGridVal(HttpServletRequest request, PssalPCarOutDomain form) throws Exception {
        
      //System.out.println("car/getGridVal");
        ModelAndView model = new ModelAndView(new JsonView());
        
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
         
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setLib1(empInfo.getLib1());
        form.setLib2(empInfo.getLib2());
        
        if(form.getJpsdt() != null && ! "".equals(form.getJpsdt())) {
            form.setJpsdt(form.getJpsdt().replace("-", ""));
        }
        
        if(form.getJpyym() != null && ! "".equals(form.getJpyym())) {
            form.setJpyym2((Integer.parseInt(form.getJpyym()) + 1) + "");
        }
        
        List<PssalPCarOutDomain> list = null;
        
     // 검색 조회 결과 리스트
        try {
            list = psslPCarOutService.selectSMDE122Q_gridVal_Obj(form);
        }catch (Exception e) {
            System.out.println("데이터가 없습니다.");
        }
        
        if(list != null) {
            if(list.size() > 0) {
                result = DnkrConstans.RESULT_Y;
            }
        }

        jsonObj.put("result", result);
        jsonObj.put("list", list);
        
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    
}
