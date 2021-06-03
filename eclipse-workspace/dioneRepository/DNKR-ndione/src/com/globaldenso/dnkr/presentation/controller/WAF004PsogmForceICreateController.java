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

import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.PsogmService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.SpareUnitDb2Domain;
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
@RequestMapping(value = "/WAF004PsogmForceICreate")
@ViewId(value = "WAF004")
public class WAF004PsogmForceICreateController {

    /**
     * [KR] 설비보전관리 서비스 <br>          
     */
    @Autowired
    private PsogmService psogmService;
    
    /**
     * [KR] 공통코드관리 서비스 <br>          
     */
    @Autowired
    private CodeService codeService;
    
    /**
     * 종합관리 > 설비보전 > 메뉴코드
     */
    private final String MENU_CODE = "539"; 

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAF004PsogmForceICreateController() {
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
        
        //System.out.println("/WAF004PsogmForceICreate/init.do");
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        /*// 사업부, 사업장 세션에 담는걸로 변경 - 180626 김용균대리님 요청
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
        
        String firstDay = UxisStringUtil.getTodayYMDString().substring(0, 8) + "01";
        //System.out.println(firstDay);
        mv.addObject("firstDay", firstDay);
        mv.addObject("today", UxisStringUtil.getTodayYMDString());
        mv.addObject("sabun", empInfo.getUserId().substring(1));
        mv.addObject("empName", empInfo.getUserName());
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));        
        mv.addObject("tabId", tabId);
        mv.addObject("menu", menu);
        mv.addObject("url", "WAF004PsogmForceICreate.jsp");
        mv.setViewName(".tiles.page.WAF004");
        return mv;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 강제입고등록 - 돋보기 버튼클릭
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/ficSearchPop", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ficSearchPop(HttpServletRequest request) throws Exception{

      //System.out.println("ficSearchPop");
        ModelAndView mv = new ModelAndView();
        
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String type = ServletRequestUtils.getStringParameter(request, "type");
        String comps = ServletRequestUtils.getStringParameter(request, "comps");
        String group = ServletRequestUtils.getStringParameter(request, "group");
        String pData = ServletRequestUtils.getStringParameter(request, "pData");
        
        mv.addObject("type", type);
        mv.addObject("comps", comps);
        mv.addObject("group", group);
        mv.addObject("pData", pData);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("menu", menu);
        mv.addObject("url", "WAF024PsogmFICSearchPop.jsp");
        mv.setViewName(".tiles.page.WAF024");
        return mv;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 강제입고등록 - 조회(ajax)
     * 
     * @param request   HttpServletRequest
     * @param form   SpareUnitDb2Domain
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/getGridVal", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getGridVal(HttpServletRequest request, SpareUnitDb2Domain form) throws Exception{
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setComps(empInfo.getPlantCd());
        form.setLib2(empInfo.getLib2());
        form.setLib3(empInfo.getLib3());
        
        if(form.getIndatfrom() != null && ! "".equals(form.getIndatfrom())) {
            form.setIndatfrom(form.getIndatfrom().replace("-", ""));
        }
        
        if(form.getIndatto() != null && ! "".equals(form.getIndatto())) {
            form.setIndatto(form.getIndatto().replace("-", ""));
        }
        
        List<SpareUnitDb2Domain> list = null;
        try {
            list = psogmService.selectOGM116(form);    
        } catch(Exception e) {
            //e.printStackTrace();
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
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 강제입고등록 - 등록폼 prtno2로 조회(ajax)
     * 
     * @param request   HttpServletRequest
     * @param form   SpareUnitDb2Domain
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/searchSpareUnit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView searchSpareUnit(HttpServletRequest request, SpareUnitDb2Domain form) throws Exception{
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setComps(empInfo.getPlantCd());
        form.setLib2(empInfo.getLib2());
        
        SpareUnitDb2Domain getDomain = null;
        try {
            getDomain = psogmService.selectOGM116_JG(form);    
        } catch(Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        if(getDomain != null) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("pDomain", getDomain); 
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 강제입고등록 - 입고일자 체크
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/chkClose", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView chkClose(HttpServletRequest request) throws Exception{
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        
        String indat = ServletRequestUtils.getStringParameter(request, "indat");
        indat = indat.replace("-", "").substring(0, 6);
         
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        SpareUnitDb2Domain criteria = new SpareUnitDb2Domain();
        criteria.setComps(empInfo.getPlantCd());
        criteria.setLib2(empInfo.getLib2());
        criteria.setGroup("1"); // 1:예비품
        criteria.setIndat(indat);   //입고일자
        
        SpareUnitDb2Domain getDomain = null;
        try {
            getDomain = psogmService.selectcloseYN(criteria);    
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        if(getDomain != null) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("pDomain", getDomain); 
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 강제입고등록 - 입고일자 체크
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/getSpareUnitMaxInpNo", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getSpareUnitMaxInpNo(HttpServletRequest request) throws Exception{
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
         
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        SpareUnitDb2Domain criteria = new SpareUnitDb2Domain();
        criteria.setComps(empInfo.getPlantCd());
        criteria.setLib2(empInfo.getLib2());
        criteria.setGroup("1"); // 1:예비품
        
        SpareUnitDb2Domain getDomain = null;
        try {
            getDomain = psogmService.selectOGM115_maxNumber(criteria);    
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        if(getDomain != null) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("pDomain", getDomain); 
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 강제입고등록 - 등록
     * 
     * @param request   HttpServletRequest
     * @param form   SpareUnitDb2Domain
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/create", method = {RequestMethod.GET, RequestMethod.POST})
    @Token(check = false, save = true)
    public ModelAndView create(HttpServletRequest request, SpareUnitDb2Domain form) throws Exception{
        
        ModelAndView model = new ModelAndView();
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");        
         
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setComps(empInfo.getPlantCd());
        form.setLib2(empInfo.getLib2());
        form.setLib2("psdiolib");   //test
        form.setGroup("1"); // 1:예비품
        
        if(form.getIndat() != null && ! "".equals(form.getIndat())) {
            form.setIndat(form.getIndat().replace("-", ""));
        }
        
        SpareUnitDb2Domain criteria = null;
        
        try {
            criteria = psogmService.selectOGM115_maxNumber(form);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        //입고번호
        String ino = "";
        if (criteria != null) {
            ino = String.format("%09d", Integer.parseInt(criteria.getInpno()));
        } else {
            ino = String.format("%09d", 1);
        }
        form.setInpno(ino);
        form.setAdusr(empInfo.getUserId().substring(1, 7));
        
        try {
            psogmService.insertOGM115(form);
            psogmService.updateOGM115_1(form);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        jsonObj.put("result", result);
//        model.addObject("jsonString", jsonObj.toString());
        model.addObject("tabId", tabId);
        model.addObject("menu", menu);
        model.setViewName("redirect:init.do");
        return model;
    }
    
    /*    *//**
     * [KO] 종합관리 > 설비보전관리 > 강제입고등록 - 등록(ajax처리)
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception  
     *//*
    @RequestMapping(value = "/create", method = {RequestMethod.GET, RequestMethod.POST})
    @Token(check = false, save = true)
    public ModelAndView create(HttpServletRequest request, SpareUnitDb2Domain form) throws Exception{
    
        System.out.println("create");
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
         
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setComps(empInfo.getPlantCd());
        form.setLib2("psdiolib");
        form.setGroup("1"); // 1:예비품
        
        if(form.getIndat() != null && ! "".equals(form.getIndat())) {
            form.setIndat(form.getIndat().replace("-", ""));
        }
        
        SpareUnitDb2Domain criteria = new SpareUnitDb2Domain();
        
        try {
            criteria = psogmService.selectOGM115_maxNumber(form);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        form.setAdusr(empInfo.getUserId().substring(1,7));
        String ino = String.format("%09d", Integer.parseInt(criteria.getInpno()));
        System.out.println("ino:" + ino);
        form.setInpno(ino);
        
        System.out.println("criteria.getInpno():" + criteria.getInpno());
        try {
            psogmService.insertOGM115(form);
            result = DnkrConstans.RESULT_Y;
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }*/

}
