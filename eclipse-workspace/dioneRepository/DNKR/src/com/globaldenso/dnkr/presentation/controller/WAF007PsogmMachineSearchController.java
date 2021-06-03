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
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.library.presentation.paging.utility.PagingUtility;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.PsogmMachineService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.PsogmDomain;
import com.globaldenso.dnkr.domain.PsogmMachineDomain;
import com.globaldenso.dnkr.domain.RelationDb2Domain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.presentation.form.basic.WAF007PsogmMachineSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [EN] The class defines the controls of Menu (WA0000).<br>
 * [JP] WA0000 基本機能メニュー画面の制御を定義するクラス。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAF007PsogmMachineSearch")
@ViewId(value = "WAF007" )
public class WAF007PsogmMachineSearchController {

    /**
     * [KR] 설비보전관리 서비스 <br>          
     */
    @Autowired
    private PsogmMachineService psogmMachineService;
    
    /**
     * [KR] 공통코드관리 서비스 <br>          
     */
    @Autowired
    private CodeService codeService;
    
    /**
     * [KR] 부서 관리 서비스 <br>          
     */
    @Autowired
    private RelationClsService relationClsService;
    
    /**
     * 종합관리 > 설비보전 > 메뉴코드
     */
    private final String MENU_CODE = "537";
    

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAF007PsogmMachineSearchController() {
        // no process
    }

    
    /**
     * 
     * @param request HttpServletRequest
     * @param form WAF007PsogmMachineSearchForm
     * @return mv ModelAndView
     * @throws Exception exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView init(HttpServletRequest request, @ModelAttribute("WAF007PsogmMachineSearchForm") WAF007PsogmMachineSearchForm form) throws Exception {
        
        ModelAndView mv = new ModelAndView();
        //System.out.println("/WAF007PsogmMachineSearch");
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
        mv.addObject("url", "WAF007PsogmMachineSearch.jsp");
        mv.setViewName(".tiles.page.WAF007");
        return mv;
    }
    
    /**
     * 
     * @param request HttpServletRequest
     * @param form WAF007PsogmMachineSearchForm
     * @return mv ModelAndView
     * @throws Exception exception
     */
    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView search(HttpServletRequest request, @ModelAttribute("WAF007PsogmMachineSearchForm") WAF007PsogmMachineSearchForm form) throws Exception {
        
        ModelAndView mv = new ModelAndView();
        //System.out.println("/WAF007PsogmMachineSearch/search.do");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
//        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
        //로그인 사용자 사업부에 따른 데이터베이스
        String LIB2 = (String)request.getSession().getAttribute("LIB2");
        //System.out.println("LIB2:" + LIB2);
//        PsogmMachineDomain domain = new PsogmMachineDomain();
        form.setLib2(LIB2);
        //System.out.println("LIB2:" + LIB2);
        List<PsogmMachineDomain> machineList = null; 
        
        int count = 0;
        
        try {
            count = psogmMachineService.searchCount(form);
            //System.out.println("count:" + count);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("보여줄 데이터가 없습니다.");
        }
        //System.out.println("LIB2:" + form.getLib2());
        
        if(count > 0) {
            // paging process
            PagingUtility.calcPaging(form, count);
            machineList = psogmMachineService.selectogm411ForPaging(form);
        }
        
//        machineList = psogmMachineService.selectogm411(domain);
        
        mv.addObject("machineList", machineList);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAF007PsogmMachineSearch.jsp");
        mv.setViewName(".tiles.page.WAF007");
        return mv;
    }
    
    
    /**
     * [KO] 조직도 조회.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getData", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void getData(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

        /**
         * [KO] 조직도 검색.<br>
         * [EN] <br>
         * [JP] <br>
         * 
         * @return ModelAndView
         * @throws Exception Exception
         */

        JSONObject jsonObj = new JSONObject();
        
//        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String comps = ServletRequestUtils.getStringParameter(request, "comps");
        String group = ServletRequestUtils.getStringParameter(request, "group");
        String disyn = ServletRequestUtils.getStringParameter(request, "disyn");
        String pwhere = ServletRequestUtils.getStringParameter(request, "pwhere");
        //System.out.println("disyn:" + disyn);
        //System.out.println("pwhere:" + pwhere);
        
        //로그인 사용자 사업부에 따른 데이터베이스
      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        List<PsogmMachineDomain> psogmMachineList = null;
        PsogmMachineDomain domain = new PsogmMachineDomain();
        domain.setLib2(empInfo.getLib2());
        domain.setComps(comps);
        domain.setGroup(group);
        domain.setDisyn(disyn);
        domain.setPwhere(pwhere);
        
        try{
          //사업부 정보 가져오기
            psogmMachineList = psogmMachineService.selectogm411(domain);
        }catch(Exception e) {
            e.printStackTrace();
            
        }

        if(psogmMachineList != null) {
            jsonObj.put("list", psogmMachineList);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
    
    /**
     * [KO] 조직도 조회.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/selectOGMgauge_Mst650pf", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void selectOGMgauge_Mst650pf(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

        /**
         * [KO] 조직도 검색.<br>
         * [EN] <br>
         * [JP] <br>
         * 
         * @return ModelAndView
         * @throws Exception Exception
         */

        JSONObject jsonObj = new JSONObject();

        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        List<RelationDb2Domain> relationList = null;
        RelationDb2Domain domain = new RelationDb2Domain();
        domain.setLib2(empInfo.getLib2());
        domain.setDpcomp(empInfo.getPlantCd());
        try{
          //사업부 정보 가져오기
            relationList = relationClsService.selectOGMgauge_Mst650pf(domain);
        }catch(Exception e) {
            e.printStackTrace();
            
        }

        if(relationList != null) {
            jsonObj.put("relationList", relationList);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
    
    /**
     * [KO] 조직도 조회.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/selectOgm411_cmbsel", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void selectOgm411_cmbsel(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

        /**
         * [KO] 조직도 검색.<br>
         * [EN] <br>
         * [JP] <br>
         * 
         * @return ModelAndView
         * @throws Exception Exception
         */
        String grpcd = ServletRequestUtils.getStringParameter(request, "grpcd");
        JSONObject jsonObj = new JSONObject();

        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        List<CommonDb2Domain> relationList = null;
        CommonDb2Domain domain = new CommonDb2Domain();
        domain.setLib2(empInfo.getLib2());
        domain.setComps(empInfo.getPlantCd());
        domain.setGrpcd(grpcd);
        try{
          //사업부 정보 가져오기
            relationList = psogmMachineService.selectOgm411_cmbsel(domain);
        }catch(Exception e) {
            e.printStackTrace();
            
        }

        if(relationList != null) {
            jsonObj.put("list", relationList);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

}
