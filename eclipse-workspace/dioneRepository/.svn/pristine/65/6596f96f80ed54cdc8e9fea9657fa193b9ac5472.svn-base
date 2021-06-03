/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
import com.globaldenso.dnkr.business.service.PsogmPerSearchService;
import com.globaldenso.dnkr.business.service.PsogmService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.PsogmPerSearchDomain;
import com.globaldenso.dnkr.domain.RelationDb2Domain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.MachineDb2Domain;
import com.globaldenso.dnkr.domain.db2.PsogmDomain;
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
@RequestMapping(value = "/WAF003PsogmPerSearch")
@ViewId(value = "WAF003")
public class WAF003PsogmPerSearchController {

    /**
     * [KR] 설비보전관리 서비스 <br>          
     */
    @Autowired
    private PsogmPerSearchService psogmPerSearchService;

    /**
     * [KR] 공통코드관리 서비스 <br>          
     */
    @Autowired
    private CodeService codeService;
    
    /**
     * [KR] 사업부, 파트관리 서비스 <br>          
     */
    @Autowired
    private RelationClsService relationDb2Service;
    
    /**
     * [KR] 공통코드관리 서비스 <br>          
     */
    @Autowired
    private PsogmService  psogmService;
    
    /**
     * 종합관리 > 설비보전 > 메뉴코드
     */
    private final String MENU_CODE = "3"; 

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAF003PsogmPerSearchController() {
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
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");

        //PsogmDomain domain = new PsogmDomain();
        List<PsogmDomain> list = null; 
        try {
//          list = psogmService.getogm313_cmbprtcd(domain);
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        //오늘날짜
        String ymd = UxisStringUtil.getTodayYMDString();
        
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
        
        mv.addObject("list", list);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));        
        mv.addObject("tabId", tabId);
        mv.addObject("nowYmd", ymd);
        mv.addObject("url", "WAF003PsogmPerSearch.jsp");
        mv.setViewName(".tiles.page.WAF003");
        return mv;
    }
     
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param request get, post
     * @param domain PsogmPerSearchDomain
     * @return jsonString
     * @throws Exception 
     */
    @RequestMapping(value = "/getGridVal", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getGridVal(HttpServletRequest request,
                                @ModelAttribute("PsogmPerSearchDomain")PsogmPerSearchDomain domain) throws Exception {
        ModelAndView model = new ModelAndView(new JsonView());
        
        JSONObject jsonObj = new JSONObject();
        
        String result = "";
        
        //로그인 사용자 사업부에 따른 데이터베이스
        String adb2 = request.getSession().getAttribute("ACCOUNT_DB2").toString();

        JSONParser parser       = new JSONParser();
        Object adb2Obj          = parser.parse(adb2);
        JSONObject adb2JsonObj  = (JSONObject)adb2Obj;
        
        String lib2             = (String)adb2JsonObj.get("lib2");
        //String company          = (String)adb2JsonObj.get("plantCd");
        String comp             = request.getParameter("COMP");
        String txtmshno         = request.getParameter("txtmshno");
        String cmbWnDatS        = request.getParameter("cmbWnDatS");
        String cmbWnDatE        = request.getParameter("cmbWnDatE");
        
        int sdate = Integer.parseInt(cmbWnDatS.replace("-", ""));
        int edate = Integer.parseInt(cmbWnDatE.replace("-", ""));
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("LIB2", lib2);
        map.put("COMPS", comp);
        map.put("MSHNO", txtmshno);
        map.put("WNDATS", sdate);
        map.put("WNDATE", edate);
        
        
        /*domain.setLIB2(lib2);
        domain.setCOMPS(company);
        domain.setMSHNO(txtmshno);
        domain.setWNDATS(Integer.parseInt(cmbWnDatS));
        domain.setWNDATE(Integer.parseInt(cmbWnDatE));*/
        
        //List<PsogmPerSearchDomain> list = psogmPerSearchService.selectOgm312_gridVal(domain);
        List<Object> list = psogmPerSearchService.selectOgm312_gridVal_Obj(map);
                
        HashMap text = (HashMap) psogmPerSearchService.selectOgm312_textVal_Obj(map);
       
        if(list.size() > 0){
            result = "y";
        }else{
            result = "n";
        }
        //System.out.println("list >> " + list.toString());
        //System.out.println("text >> " + text.toString());
        
        //System.out.println("list2 >> " + list2.toString());
        jsonObj.put("result", result);
        jsonObj.put("list", list);
        jsonObj.put("text", text);
                
        //String data = "{ \"result\" : \"ok\",\"list\" : " + jsonObj.toString() + " }";
        model.addObject("jsonString", jsonObj.toString());
        
        return model;
        
    }
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param request HttpServletRequest
     * @param domain PsogmPerSearchDomain
     * @return ModelAndView
     * @throws Exception excepiton
     */
    @RequestMapping(value = "/machineSelectPop", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView machineSelectPop(HttpServletRequest request,
                                @ModelAttribute("PsogmPerSearchDomain")PsogmPerSearchDomain domain) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        RelationDb2Domain partDomain = new RelationDb2Domain();
        partDomain.setLib2(empInfo.getLib2());
        partDomain.setComps(empInfo.getPlantCd());
        List<RelationDb2Domain> partList = null;
        try {
            partList = relationDb2Service.searchByConditionForPart(partDomain);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        mv.addObject("url", "WAF020PsogmMachineSelectPop.jsp");
        mv.addObject("partList", partList);
        mv.setViewName(".tiles.page.WAF020");
        return mv;
    }
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception excepiton
     */
    @RequestMapping(value = "/getMachineInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getMachineInfo(HttpServletRequest request) throws Exception {
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        
        String lincd = ServletRequestUtils.getStringParameter(request, "lincd");
        String result = DnkrConstans.RESULT_N;
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        MachineDb2Domain machineDb2Domain = new MachineDb2Domain();
        machineDb2Domain.setLib2(empInfo.getLib2());
        machineDb2Domain.setComps(empInfo.getPlantCd());
        machineDb2Domain.setLincd(lincd);
        
        List<MachineDb2Domain> machineList = null;
        try {
            machineList = psogmService.selectOgm200_pop(machineDb2Domain);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }

        if (machineList != null && machineList.size() > 0) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("machineList", machineList);
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }   
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception excepiton
     */
    @RequestMapping(value = "/getPrtcdTimcdByMshno", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView GetPrtcdTimcdByMshno(HttpServletRequest request) throws Exception {
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        
        String mshno = ServletRequestUtils.getStringParameter(request, "mshno");
        String result = DnkrConstans.RESULT_N;
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        MachineDb2Domain machineDb2Domain = new MachineDb2Domain();
        machineDb2Domain.setLib2(empInfo.getLib2());
        machineDb2Domain.setComps(empInfo.getPlantCd());
        machineDb2Domain.setMshno(mshno);
        
        MachineDb2Domain getMachineDomain = null;
        try {
            getMachineDomain = psogmService.selectOGM200_chk(machineDb2Domain);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }

        if (getMachineDomain != null) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("machineInfo", getMachineDomain);
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    } 
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception excepiton
     */
    @RequestMapping(value = "/getLineInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getLineInfo(HttpServletRequest request) throws Exception {
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        
        String prtcd = ServletRequestUtils.getStringParameter(request, "prtcd");
        String result = DnkrConstans.RESULT_N;
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        RelationDb2Domain relationDb2Domain = new RelationDb2Domain();
        relationDb2Domain.setLib2(empInfo.getLib2());
        relationDb2Domain.setComps(empInfo.getPlantCd());
        if(prtcd != null && ! prtcd.trim().equals("")){
            relationDb2Domain.setPrtcd(prtcd);
        }
        
        List<RelationDb2Domain> lineList = null;
        try {
            lineList = relationDb2Service.searchByConditionForLine(relationDb2Domain);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }

        if (lineList != null && lineList.size() > 0) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("lineList", lineList);
        }
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toJSONString());
        return model;
    }   
}
