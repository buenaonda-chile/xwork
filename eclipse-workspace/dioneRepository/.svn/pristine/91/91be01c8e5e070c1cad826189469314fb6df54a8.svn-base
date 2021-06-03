/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.globaldenso.dnkr.business.service.db2.PsogmMonPerformService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.PsogmDomain;
import com.globaldenso.dnkr.domain.db2.PsogmMonPerformDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [EN] The class defines the controls of Menu (WA0000).<br>
 * [JP] WA0000 基本機能メニュー画面の制御を定義するクラス。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAF006PsogmMonPerform")
@ViewId(value = "WAF006")
public class WAF006PsogmMonPerformController {

    /**
     * [KR] 공통코드관리 서비스 <br>          
     */
    @Autowired
    private CodeService codeService;
    
    /**
     * [KR] 설비보전관리 서비스 <br>          
     */
    @Autowired
    private PsogmService psogmService;
    
    /**
     * [KR] 월별계획대실적관리 서비스 <br>          
     */
    @Autowired
    private PsogmMonPerformService psogmMonPerformService;
    
    /**
     * 종합관리 > 설비보전 > 메뉴코드
     */
    private final String MENU_CODE = "3"; 

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAF006PsogmMonPerformController() {
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
        //System.out.println("/WAF006PsogmMonPerform");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");

        /*// 사업부, 사업장 세션에 담는걸로 변경 - 180626 김용균대리님 요청
      //세션 저장된 데이터 불러오기
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
        mv.addObject("url", "WAF006PsogmMonPerform.jsp");
        mv.setViewName(".tiles.page.WAF006");
        return mv;
    }
    
    
    /**
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/getGridVal", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getGridVal(HttpServletRequest request) throws Exception {

//        System.out.println("/WAF006PsogmMonPerform/search.do");
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        
        String comps = ServletRequestUtils.getStringParameter(request, "comps");
        String year = ServletRequestUtils.getStringParameter(request, "year");
        String mon = ServletRequestUtils.getStringParameter(request, "mon");
        String g_gub = ServletRequestUtils.getStringParameter(request, "g_gub");

      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        //기준년월 시작일과 종료일 만들기(ex: 201801, 201901)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(year).append(mon).append("01");
        Date startDate = new SimpleDateFormat("yyyyMMdd").parse(strBuffer.toString());
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.MONTH, 11);
        
        String startYearMon = sdf.format(startDate);
        String endYearMon = sdf.format(cal.getTime());        
        
        //추가 쿼리문 작성
        StringBuffer sqlBuffer = new StringBuffer();
        if(mon.equals("01")){
            
            sqlBuffer.append("'4' as m4,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("01' then b.yedat end) as cnt_yedat_04,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("01' then b.rpdat end) as cnt_rpdat_04,");
            sqlBuffer.append("'5' as m5,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("02' then b.yedat end) as cnt_yedat_05,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("02' then b.rpdat end) as cnt_rpdat_05,");
            sqlBuffer.append("'6' as m6,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("03' then b.yedat end) as cnt_yedat_06,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("03' then b.rpdat end) as cnt_rpdat_06,");
            sqlBuffer.append("'7' as m7,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("04' then b.yedat end) as cnt_yedat_07,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("04' then b.rpdat end) as cnt_rpdat_07,");
            sqlBuffer.append("'8' as m8,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("05' then b.yedat end) as cnt_yedat_08,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("05' then b.rpdat end) as cnt_rpdat_08,");
            sqlBuffer.append("'9' as m9,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("06' then b.yedat end) as cnt_yedat_09,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("06' then b.rpdat end) as cnt_rpdat_09,");
            sqlBuffer.append("'10' as m10,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("07' then b.yedat end) as cnt_yedat_10,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("07' then b.rpdat end) as cnt_rpdat_10,");
            sqlBuffer.append("'11' as m11,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("08' then b.yedat end) as cnt_yedat_11,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("08' then b.rpdat end) as cnt_rpdat_11,");
            sqlBuffer.append("'12' as m12,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("09' then b.yedat end) as cnt_yedat_12,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("09' then b.rpdat end) as cnt_rpdat_12,");
            sqlBuffer.append("'1' as m1,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("10' then b.yedat end) as cnt_yedat_01,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("10'  then b.rpdat end) as cnt_rpdat_01,");
            sqlBuffer.append("'2' as m2,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("11' then b.yedat end) as cnt_yedat_02,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("11' then b.rpdat end) as cnt_rpdat_02,");
            sqlBuffer.append("'3' as m3,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("12' then b.yedat end) as cnt_yedat_03,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("12' then b.rpdat end) as cnt_rpdat_03");
            
        } else if(mon.equals("04")) {
            
            sqlBuffer.append("'4' as m4,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("04' then b.yedat end) as cnt_yedat_04,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("04' then b.rpdat end) as cnt_rpdat_04,");
            sqlBuffer.append("'5' as m5,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("05' then b.yedat end) as cnt_yedat_05,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("05' then b.rpdat end) as cnt_rpdat_05,");
            sqlBuffer.append("'6' as m6,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("06' then b.yedat end) as cnt_yedat_06,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("06' then b.rpdat end) as cnt_rpdat_06,");
            sqlBuffer.append("'7' as m7,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("07' then b.yedat end) as cnt_yedat_07,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("07' then b.rpdat end) as cnt_rpdat_07,");
            sqlBuffer.append("'8' as m8,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("08' then b.yedat end) as cnt_yedat_08,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("08' then b.rpdat end) as cnt_rpdat_08,");
            sqlBuffer.append("'9' as m9,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("09' then b.yedat end) as cnt_yedat_09,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("09' then b.rpdat end) as cnt_rpdat_09,");
            sqlBuffer.append("'10' as m10,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("10' then b.yedat end) as cnt_yedat_10,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("10' then b.rpdat end) as cnt_rpdat_10,");
            sqlBuffer.append("'11' as m11,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("11' then b.yedat end) as cnt_yedat_11,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("11' then b.rpdat end) as cnt_rpdat_11,");
            sqlBuffer.append("'12' as m12,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("12' then b.yedat end) as cnt_yedat_12,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(year);
            sqlBuffer.append("12' then b.rpdat end) as cnt_rpdat_12,");
            sqlBuffer.append("'1' as m1,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(Integer.parseInt(year) + 1);
            sqlBuffer.append("01' then b.yedat end) as cnt_yedat_01,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(Integer.parseInt(year) + 1);
            sqlBuffer.append("01'  then b.rpdat end) as cnt_rpdat_01,");
            sqlBuffer.append("'2' as m2,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(Integer.parseInt(year) + 1);
            sqlBuffer.append("02' then b.yedat end) as cnt_yedat_02,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(Integer.parseInt(year) + 1);
            sqlBuffer.append("02' then b.rpdat end) as cnt_rpdat_02,");
            sqlBuffer.append("'3' as m3,");
            sqlBuffer.append("count(case substr(char(b.yedat),1,6) when '");
            sqlBuffer.append(Integer.parseInt(year) + 1);
            sqlBuffer.append("03' then b.yedat end) as cnt_yedat_03,");
            sqlBuffer.append("count(case substr(char(b.rpdat),1,6) when '");
            sqlBuffer.append(Integer.parseInt(year) + 1);
            sqlBuffer.append("03' then b.rpdat end) as cnt_rpdat_03");
        }
        
        PsogmMonPerformDb2Domain domain = new PsogmMonPerformDb2Domain();
        domain.setComps(comps);
        domain.setLib1(empInfo.getLib1());
        domain.setLib2(empInfo.getLib2());
        domain.setLib2(empInfo.getLib3());
        domain.setG_gub(g_gub);
        domain.setStrval(sqlBuffer.toString());
        domain.setStartYearMon(startYearMon);
        domain.setEndYearMon(endYearMon);
        List<PsogmMonPerformDb2Domain> list = null; 
        try {
            list = psogmMonPerformService.selectOgm401(domain);
        }catch (Exception e) {
            e.printStackTrace();
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
