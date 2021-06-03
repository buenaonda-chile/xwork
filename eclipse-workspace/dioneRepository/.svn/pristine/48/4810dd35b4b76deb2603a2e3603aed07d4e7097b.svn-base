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
import com.globaldenso.dnkr.business.service.PsogmService;
import com.globaldenso.dnkr.business.service.db2.PsogmProdStatusService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.PsogmProdStatusDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [EN] The class defines the controls of Menu (WA0000).<br>
 * [JP] WA0000 基本機能メニュー画面の制御を定義するクラス。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAF008PsogmProdStatus")
@ViewId(value = "WAF008")
public class WAF008PsogmProdStatusController {

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
     * [KR] 생산전광판 현황 서비스 <br>          
     */
    @Autowired
    private PsogmProdStatusService psogmProdStatusService;
    
    /**
     * 종합관리 > 설비보전 > 메뉴코드
     */
    private final String MENU_CODE = "3"; 

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAF008PsogmProdStatusController() {
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
        //System.out.println("/WAF008PsogmProdStatus");
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
      
//        Date today = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String sysDate = sdf.format(today);
//        
//        mv.addObject("SYSDATE", sysDate);
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAF008PsogmProdStatus.jsp");
        mv.setViewName(".tiles.page.WAF008");
        return mv;
    }
    
    /**
     * 
     * @param request   HttpServletRequest
     * @param domain   PsogmProdStatusDb2Domain
     * @return  ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/selectPpmi001M", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView selectPpmi001M(HttpServletRequest request, @ModelAttribute("PsogmProdStatusDb2Domain")PsogmProdStatusDb2Domain domain) throws Exception {

        //System.out.println("/WAF008PsogmProdStatus/selectPpmi001M.do");
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        String result1 = DnkrConstans.RESULT_N;
        String result2 = DnkrConstans.RESULT_N;
        
        String pRowgb = domain.getRowgb();
        String pDate = domain.getOrdat();
        String formatDate = pDate.replace("-", "");
        domain.setOrdat(formatDate);
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        //System.out.println("empInfo.company:" + empInfo.getCompany());

        CodeDb2Domain codeDomain = new CodeDb2Domain();
        codeDomain.setDb2class("PLNT");
        codeDomain.setCoded1(empInfo.getCompany());
        
        List<PsogmProdStatusDb2Domain> searchList = null;
        List<PsogmProdStatusDb2Domain> searchList2 = null;
        domain.setLib2(empInfo.getLib2());
        
        try {
            searchList = psogmProdStatusService.selectOBSE01(domain);       
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("데이터가 없습니다.1");
        }
        //System.out.println("rowgb:" + domain.getRowgb());
        //System.out.println("date:" + domain.getOrdat());
        try {
            domain.setRowgb(Integer.parseInt(domain.getRowgb()) + 1 + "");
            searchList2 = psogmProdStatusService.selectOBSE01(domain);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("데이터가 없습니다.2");
        }
        
        //System.out.println("rowgb:" + domain.getRowgb());
        
        if(searchList != null && searchList.size() > 0) {
            result1 = DnkrConstans.RESULT_Y;
            jsonObj.put("result1", result1);
            jsonObj.put("searchList", searchList);
        }
        
        if(searchList2 != null && searchList2.size() > 0) {
            result2 = DnkrConstans.RESULT_Y;
            jsonObj.put("result2", result2);
            jsonObj.put("searchList2", searchList2);
        }
        if(result1.equals(DnkrConstans.RESULT_Y) || result2.equals(DnkrConstans.RESULT_Y)) {
            result = DnkrConstans.RESULT_Y; 
        }
        
        if(result.equals(DnkrConstans.RESULT_Y)) {
            domain.setRowgb("1");
            PsogmProdStatusDb2Domain sumDomain1 = psogmProdStatusService.selectOBSE01_Sum(domain);
            domain.setRowgb("2");
            PsogmProdStatusDb2Domain sumDomain2 = psogmProdStatusService.selectOBSE01_Sum(domain);
            domain.setRowgb("3");
            PsogmProdStatusDb2Domain sumDomain3 = psogmProdStatusService.selectOBSE01_Sum(domain);
            domain.setRowgb("4");
            PsogmProdStatusDb2Domain sumDomain4 = psogmProdStatusService.selectOBSE01_Sum(domain);
            jsonObj.put("sumDomain1", sumDomain1);
            jsonObj.put("sumDomain2", sumDomain2);
            jsonObj.put("sumDomain3", sumDomain3);
            jsonObj.put("sumDomain4", sumDomain4);
        }
        
        domain.setRowgb(pRowgb);
        domain.setOrdat(pDate);
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
}
