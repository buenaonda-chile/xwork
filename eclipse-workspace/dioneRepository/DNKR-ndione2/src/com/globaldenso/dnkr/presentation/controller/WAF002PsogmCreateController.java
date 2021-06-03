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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.PsogmService;
import com.globaldenso.dnkr.business.service.db2.PsogmAttachedFileService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.FileDb2Domain;
import com.globaldenso.dnkr.domain.db2.PsogmDomain;
import com.globaldenso.dnkr.domain.db2.SpareUnitDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisFileMngUtil;
import com.globaldenso.dnkr.uxis.UxisStringUtil;

/**
 * [EN] The class defines the controls of Menu (WA0000).<br>
 * [JP] WA0000 基本機能メニュー画面の制御を定義するクラス。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAF002PsogmCreate")
@ViewId(value = "WAF002")
public class WAF002PsogmCreateController {

    /**
     * [KR] 설비보전관리 서비스 <br>          
     */
    @Autowired
    private PsogmService psogmService;
    
    /**
     * [KR] 설비보전관리 서비스 <br>          
     */
    @Autowired
    private PsogmAttachedFileService psogmAttachedFileService;
    
    /**
     * [KR] 공통코드관리 서비스 <br>          
     */
    @Autowired
    private CodeService codeService;
    
    /**
     * 종합관리 > 설비보전 > 신규이력등록 메뉴코드
     */
    private final String MENU_CODE = "542"; 

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAF002PsogmCreateController() {
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
        //System.out.println("/WAF002PsogmCreate");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String errMsg = ServletRequestUtils.getStringParameter(request, "errMsg");

        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        String empComps = empInfo.getPlantCd();
        String lib2 = empInfo.getLib2();
        
        /*// 사업부, 사업장 세션에 담는걸로 변경 - 180626 김용균대리님 요청
        CodeDb2Domain codeDomain = new CodeDb2Domain();
        codeDomain.setDb2class("PLNT");
        codeDomain.setCoded1(empInfo.getCompany());
        
        List<CodeDb2Domain> codeList = null;
        //사업부 정보
        try {
            codeList = codeService.comCode(codeDomain);
            mv.addObject("codeList", codeList);
        } catch(Exception e) {
            System.out.println("데이터가 없습니다.");
        }
        */
        UxisCmmUtil.getSessionComCode(request, mv);
        
        
        PsogmDomain psogmDomain = new PsogmDomain();
        psogmDomain.setLib2(lib2);
        psogmDomain.setComps(empComps);
        
      //보전정보
        try {
            List<PsogmDomain> jobList = psogmService.selectOgm200_method(psogmDomain);
            mv.addObject("jobList", jobList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
      //설비부위분류(Sub assy)
        try {
            List<PsogmDomain> assyList = psogmService.selectOgm203_obc230pf(psogmDomain);
            mv.addObject("assyList", assyList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
      //ASSY부품(셋트부품정보)
        try {
            List<PsogmDomain> kndList = psogmService.selectOgm203_obc220pf(psogmDomain);
            mv.addObject("kndList", kndList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
      //단위부품정보
        try {
            List<PsogmDomain> unitList = psogmService.selectOgm203_obc070pf(psogmDomain);
            mv.addObject("unitList", unitList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
      //처치
        try {
            List<PsogmDomain> choList = psogmService.selectOgm203_obc160pf(psogmDomain);
            mv.addObject("choList", choList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
      //현상
        try {
            List<PsogmDomain> phenomenonList = psogmService.selectOgm203_obc190pf(psogmDomain);
            mv.addObject("phenomenonList", phenomenonList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
      //원인
        try {
            List<PsogmDomain> causeList = psogmService.selectOgm203_obc120pf(psogmDomain);
            mv.addObject("causeList", causeList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
      //실원인
        try {
            List<PsogmDomain> trueCauseList = psogmService.selectOgm203_obc100pf(psogmDomain);
            mv.addObject("trueCauseList", trueCauseList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
      //내외구분
        try {
            List<PsogmDomain> inoutList = psogmService.selectOgm203_obc020pf(psogmDomain);
            mv.addObject("inoutList", inoutList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
      //우선도
        try {
            List<PsogmDomain> emgList = psogmService.selectOgm203_obc010pf(psogmDomain);
            mv.addObject("emgList", emgList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
      //품질확인
        try {
            List<PsogmDomain> qualityList = psogmService.selectOgm203_obc170pf(psogmDomain);
            mv.addObject("qualityList", qualityList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        //효과구분
        try {
            List<PsogmDomain> effectList = psogmService.selectOgm203_obc210pf(psogmDomain);
            mv.addObject("effectList", effectList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
      //재발방지
        try {
            List<PsogmDomain> relapseList = psogmService.selectOgm203_obc150pf(psogmDomain);
            mv.addObject("relapseList", relapseList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        //로그인 사원 관리자체크
        SpareUnitDb2Domain setDomain = new SpareUnitDb2Domain();
        setDomain.setDioid(empInfo.getUserId());
        setDomain.setLib2(lib2);
        setDomain.setComps(empComps);
        setDomain.setGroup("2"); //2:신규이력등록
        
        SpareUnitDb2Domain managerDomain = null;
        try {
            managerDomain = psogmService.selectmanagerYN(setDomain);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        if(managerDomain != null) {
            mv.addObject("manager", "M");
        }
        
        mv.addObject("sabun", empInfo.getUserId().substring(1));
        mv.addObject("empName", empInfo.getUserName());
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("empComps", empComps);
        mv.addObject("errMsg", errMsg);
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAF002PsogmCreate.jsp");
        mv.setViewName(".tiles.page.WAF002");
        return mv;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 신규이력등록 - 등록
     * 
     * @param request   HttpServletRequest
     * @param form   SpareUnitDb2Domain
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/create", method = {RequestMethod.GET, RequestMethod.POST})
    @Token(check = false, save = true)
    public ModelAndView create(HttpServletRequest request, PsogmDomain form) throws Exception{
        
        ModelAndView mv = new ModelAndView();
        String result = DnkrConstans.RESULT_N;
        String managerChk = "";
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
         
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setComps(empInfo.getPlantCd());
        form.setLib2(empInfo.getLib2());
        form.setLib2("psdiolib");   //test
        
        String today = UxisStringUtil.getTodayYMDString().replace("-", "");
        String nowTime = UxisStringUtil.getNowTimeHMString().replace(":", "");
        String empNum = empInfo.getUserId().substring(1); 
        form.setAddat(today);
        form.setAdtim(nowTime);
        form.setAdusr(empNum);
        
        if(! form.getBfrhr().equals("") && ! form.getBfrhr().equals("0")) {
            form.setBfrhr(Float.parseFloat(form.getBfrhr()) / 60 + "");
        } else {
            form.setBfrhr("0");
        }
        
        if(! form.getWrkhr().equals("") && ! form.getWrkhr().equals("0")) {
            form.setWrkhr(Float.parseFloat(form.getWrkhr()) / 60 + "");
        } else {
            form.setWrkhr("0");
        }
        
        form.setTothr((Integer.parseInt(form.getBfrhr()) + Integer.parseInt(form.getWrkhr())) + "");
        
        if(form.getKsdat() != null && ! "".equals(form.getKsdat())) {
            form.setKsdat(form.getKsdat().replace("-", ""));
        }
        
        if(form.getKstim() != null && ! "".equals(form.getKstim())) {
            form.setKstim(form.getKstim().replace(":", ""));
        }
        
        if(form.getJisno() == null || form.getJisno().equals("")) { //jisno 가 없으면
            
            String plantCd = getPlantCd(form.getComps());
            PsogmDomain maxDomain = new PsogmDomain();
            maxDomain.setComps(plantCd);
            String maxJisno = getMaxJisno(maxDomain);
            form.setJisno(maxJisno);
            
            psogmService.insertOgm203(form, plantCd);
        } else {    //jisno가 있으면
            String cmplt = null;
            try {
                cmplt = psogmService.selectOgm203_cmplt(form);
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("데이터가 없습니다.");
            }
            
            if(cmplt == null) {
                cmplt = "0";
            }
            
            //관리자 체크
            SpareUnitDb2Domain managerDomain = new SpareUnitDb2Domain();
            managerDomain.setLib2(empInfo.getLib2());
            managerDomain.setComps(empInfo.getPlantCd());
            managerDomain.setGroup("2");
            managerDomain.setDioid(empInfo.getUserId());
            SpareUnitDb2Domain getDomain = null;
            try{
                getDomain = psogmService.selectmanagerYN(managerDomain);
            } catch (Exception e) {
                //e.printStackTrace();
            }
            
            int updateCnt = 0;
            if (getDomain != null && getDomain.getMager().equals("M") || !cmplt.equals("1")) {  //관리자
                updateCnt = psogmService.updateOgm203(form);
            } else {    //일반사원
                mv.addObject("errMsg", " [알림] 이 작업은 이미 등록되어 있습니다.수정하려면 이력편집을 실행하세요.");
            }
        }

        mv.addObject("tabId", tabId);
        mv.addObject("menu", menu);
        mv.setViewName("redirect:init.do");
        return mv;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 신규이력등록 - 등록
     * 
     * @param request   HttpServletRequest
     * @param form   SpareUnitDb2Domain
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/ajaxCreate", method = {RequestMethod.GET, RequestMethod.POST})
    @Token(check = false, save = true)
    public ModelAndView ajaxCreate(HttpServletRequest request, PsogmDomain form) throws Exception{
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        String managerChk = "";
        
        String status = ServletRequestUtils.getStringParameter(request, "status");
         
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setComps(empInfo.getPlantCd());
        form.setLib2(empInfo.getLib2());
        form.setLib2("psdiolib");   //test
        
        String today = UxisStringUtil.getTodayYMDString().replace("-", "");
        String nowTime = UxisStringUtil.getNowTimeHMString().replace(":", "");
        String empNum = empInfo.getUserId().substring(1); 
        form.setAddat(today);
        form.setAdtim(nowTime);
        form.setAdusr(empNum);
        
        if(! form.getBfrhr().equals("") && ! form.getBfrhr().equals("0")) {
            form.setBfrhr(Float.parseFloat(form.getBfrhr()) / 60 + "");
        } else {
            form.setBfrhr("0");
        }
        
        if(! form.getWrkhr().equals("") && ! form.getWrkhr().equals("0")) {
            form.setWrkhr(Float.parseFloat(form.getWrkhr()) / 60 + "");
        } else {
            form.setWrkhr("0");
        }
        
        form.setTothr((Integer.parseInt(form.getBfrhr()) + Integer.parseInt(form.getWrkhr())) + "");
        
        if(form.getKsdat() != null && ! "".equals(form.getKsdat())) {
            form.setKsdat(form.getKsdat().replace("-", ""));
        }
        
        if(form.getKstim() != null && ! "".equals(form.getKstim())) {
            form.setKstim(form.getKstim().replace(":", ""));
        }
        
        if(form.getJisno() == null || form.getJisno().equals("")) { //jisno 가 없으면
            
            PsogmDomain maxDomain = new PsogmDomain();
            String plantCd = getPlantCd(form.getComps());
            maxDomain.setLib2(empInfo.getLib2());
            maxDomain.setLib2("psdiolib");
            maxDomain.setComps(plantCd);
            String maxJisno = getMaxJisno(maxDomain);
            form.setJisno(maxJisno);
            
            psogmService.insertOgm203(form, plantCd);
            jsonObj.put("pDomain", form);
            jsonObj.put("status", "insert");
            result = DnkrConstans.RESULT_Y;
        } else {    //jisno가 있으면
            String cmplt = null;
            try {
                cmplt = psogmService.selectOgm203_cmplt(form);
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("데이터가 없습니다.");
            }
            
            if(cmplt == null) {
                cmplt = "0";
            }
            
            //관리자 체크
            SpareUnitDb2Domain managerDomain = new SpareUnitDb2Domain();
            managerDomain.setLib2(empInfo.getLib2());
            managerDomain.setComps(empInfo.getPlantCd());
            managerDomain.setGroup("2");
            managerDomain.setDioid(empInfo.getUserId());
            SpareUnitDb2Domain getDomain = null;
            try{
                getDomain = psogmService.selectmanagerYN(managerDomain);
            } catch (Exception e) {
                //e.printStackTrace();
            }
            
            int updateCnt = 0;
            if (getDomain != null && getDomain.getMager().equals("M") || !cmplt.equals("1")) {  //관리자
                form.setChdat(today);
                form.setChtim(nowTime);
                form.setChusr(empNum);
                updateCnt = psogmService.updateOgm203(form);
                if(updateCnt > 0) {
                    jsonObj.put("pDomain", form);
                    jsonObj.put("status", "update");
                    result = DnkrConstans.RESULT_Y;
                }
            } else {    //일반사원
                model.addObject("errMsg", " [알림] 이 작업은 이미 등록되어 있습니다.수정하려면 이력편집을 실행하세요.");
                result = DnkrConstans.RESULT_Y;
            }
            
        }
        
        if(!status.equals("partbfr") && !status.equals("partaft")) {
      //status = 'partbft' 또는 'partaft'인 경우 개선상세나 교환부품에서 부분저장을 요구한 경우임
            if(form.getCmplt().equals("1") && form.getRepcd().equals("1")) {    //cmplt(1) 완료등록, repcd(1) 재발방지가 필요한 수리
                //재발방지추가 등록내역 조회
                PsogmDomain repcdDomain = null;
                form.setLib3(empInfo.getLib3());
                String jisno = form.getJisno();
                form.setJisno(form.getJisno() + "P");
                
                try {
                    repcdDomain = psogmService.selectOgm203_pepcdChk(form);
                } catch(Exception e) {
                    //e.printStackTrace();
                    System.out.println("데이터가 없습니다.");
                }
                
                jsonObj.put("repcdMsg", "계획공사에 재발방지 작업등록 합니다.<br><br>신규지시번호는 " 
                        + form.getJisno() + "입니다. <br><br>진행중작업에서 확인해주세요.");
                if(repcdDomain == null) {
                    //삽입
                    psogmService.insertOgm203_pepcd(form);
                } else {
                    //업데이트  
                    psogmService.updateOgm203_pepcd(form);
                }
                form.setJisno(jisno);
            }
        }
        

        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 신규이력등록 > 부품교환입력페이지
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/changeUnitPop", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView changeUnitPop(HttpServletRequest request) throws Exception{
      //System.out.println("/WAF002PsogmCreate/changeUnitPop.do");
        ModelAndView mv = new ModelAndView();
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String jisno = ServletRequestUtils.getStringParameter(request, "jisno");
        
        PsogmDomain criteria = new PsogmDomain();
        criteria.setJisno(jisno);
        //criteria.setJisno("MM1239"); //test
        
      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        criteria.setComps(empInfo.getPlantCd());
        criteria.setLib2(empInfo.getLib2());
        criteria.setLib2("psdiolib");   //test
        
        List<PsogmDomain> unitList = null;
        try {
            unitList = psogmService.selectOgm205_obj220pf(criteria);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("jisno", jisno);
        mv.addObject("unitList", unitList);
        mv.addObject("menu", menu);
        mv.addObject("url", "WAF022PsogmChangeUnitPop.jsp");
        mv.setViewName(".tiles.page.WAF022");
        return mv;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 신규이력등록 > 교환부품입력 - 등록
     * 
     * @param request   HttpServletRequest
     * @param form   SpareUnitDb2Domain
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/createSpareUnit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView createSpareUnit(HttpServletRequest request, PsogmDomain form) throws Exception{
        //System.out.println("/WAF002PsogmCreate/createSpareUnit.do");
        ModelAndView mv = new ModelAndView();
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String jisno = ServletRequestUtils.getStringParameter(request, "jisno");
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setComps(empInfo.getPlantCd());
        form.setLib2(empInfo.getLib2());
        form.setLib2("psdiolib");   //test
        
        try {
            psogmService.insertOgm205_obj220pf(form);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        
        
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("menu", menu);
        mv.addObject("jisno", jisno);
        mv.addObject("url", "WAF025SpareUnitPop.jsp");
        mv.setViewName("redirect:changeUnitPop.do");
        return mv;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 신규이력등록 > 교환부품입력 - 예비품 No
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/ajaxSpareUnitInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ajaxSpareUnitInfo(HttpServletRequest request) throws Exception{
      
        //System.out.println("/WAF002PsogmCreate/ajaxSpareUnitInfo.do");
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        
        String result = DnkrConstans.RESULT_N;
        
        String prtno = ServletRequestUtils.getStringParameter(request, "prtno");
        SpareUnitDb2Domain domain = new SpareUnitDb2Domain();
        domain.setPrtno(prtno);
        
      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        domain.setComps(empInfo.getPlantCd());
        domain.setLib2(empInfo.getLib2());
        
        SpareUnitDb2Domain getDomain = null;
        try {
            getDomain = psogmService.selectOgm010pf(domain);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        if (getDomain != null) {
            jsonObj.put("pDomain", getDomain);  
            result = DnkrConstans.RESULT_Y;
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 신규이력등록 > 교환부품입력 - 예비품 No 돋보기 버튼
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/spareUnitPop", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView spareUnitPop(HttpServletRequest request) throws Exception{
      //System.out.println("/WAF002PsogmCreate/changeUnitPop.do");
        ModelAndView mv = new ModelAndView();
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("menu", menu);
        mv.addObject("url", "WAF025SpareUnitPop.jsp");
        mv.setViewName(".tiles.page.WAF025");
        return mv;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 신규이력등록 > 교환부품입력 > 부품조회 - 부품명 or maker로 조회
     * 
     * @param request   HttpServletRequest
     * @param form   SpareUnitDb2Domain
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/ajaxSearchUnit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ajaxSearchUnit(HttpServletRequest request, SpareUnitDb2Domain form) throws Exception{
      
        //System.out.println("/WAF002PsogmCreate/ajaxSearchUnit.do");
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        
        String result = DnkrConstans.RESULT_N;
        
      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setComps(empInfo.getPlantCd());
        form.setLib2(empInfo.getLib2());
        
        List<SpareUnitDb2Domain> unitList = null;
        try {
            unitList = psogmService.selectOgm205_pop(form);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        if (unitList != null) {
            jsonObj.put("unitList", unitList);
            result = DnkrConstans.RESULT_Y;
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 신규이력등록 > 교환부품입력 - 교환부품 정보수정
     * 
     * @param request   HttpServletRequest
     * @param form   SpareUnitDb2Domain
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/updateChangeUnit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView updateChangeUnit(HttpServletRequest request, PsogmDomain form) throws Exception{
        //System.out.println("updateChangeUnit.do");
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        
        String result = DnkrConstans.RESULT_N;
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setComps(empInfo.getPlantCd());
        form.setLib2(empInfo.getLib2());
        form.setLib2("psdiolib"); //test
        
        int cnt = 0;
        
        try {
            cnt = psogmService.updateOgm205_obj220pf(form);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        
        if(cnt > 0) {
            result = DnkrConstans.RESULT_Y;
        }
                
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 신규이력등록 > 교환부품입력 - 교환부품 정보삭제
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/deleteChangeUnit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView deleteChangeUnit(HttpServletRequest request) throws Exception{
        //System.out.println("deleteChangeUnit.do");
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        
        String seqno = ServletRequestUtils.getStringParameter(request, "seqno");
        String result = DnkrConstans.RESULT_N;
        
        PsogmDomain domain = new PsogmDomain();
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        domain.setComps(empInfo.getPlantCd());
        domain.setLib2(empInfo.getLib2());
        domain.setLib2("psdiolib"); //test
        domain.setSeqno(seqno);
        
        int cnt = 0;
        
        try {
            cnt = psogmService.deleteOgm205_obj220pf(domain);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        
        if(cnt > 0) {
            result = DnkrConstans.RESULT_Y;
        }
                
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * 
     * @param request   HttpServletRequest
     * @param domain   FileDb2Domain
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/attachedFilePop", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView attachedFilePop(HttpServletRequest request, FileDb2Domain domain) throws Exception{
        
        //System.out.println("/WAF002PsogmCreate/attachedFilePop.do");
        ModelAndView mv = new ModelAndView();
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
        String jisno = domain.getJisno();
        
      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        domain.setComps(empInfo.getPlantCd());
        domain.setLib2(empInfo.getLib2());
        domain.setLib2("psdiolib"); //TEST
//        domain.setJisno("J5192810"); //TEST
        
        List<FileDb2Domain> fileDomain = null;
        
        try {
            fileDomain = psogmService.selectOgm219_obj230pf(domain);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        mv.addObject("jisno", jisno);
        mv.addObject("fileDomain", fileDomain);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("menu", menu);
        mv.addObject("url", "WAF023PsogmAttachedFilePop.jsp");
        mv.setViewName(".tiles.page.WAF023");
        return mv;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 신규이력등록 > 첨부파일등록
     * 
     * @param request   HttpServletRequest
     * @param domain   FileDb2Domain
     * @param multiRequest   MultipartHttpServletRequest
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/attachedFileCreate", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = "forward:init.do")
    public ModelAndView attachedFileCreate(HttpServletRequest request, FileDb2Domain domain, 
            MultipartHttpServletRequest multiRequest) throws Exception{
        
        //System.out.println("attachedFileCreate.do");
        ModelAndView mv = new ModelAndView();
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        domain.setComps(empInfo.getPlantCd());
        domain.setLib2(empInfo.getLib2());
        domain.setLib2("psdiolib");
        
        psogmAttachedFileService.create(domain, multiRequest);
        
        mv.addObject("jisno", domain.getJisno());
        mv.setViewName("redirect:attachedFilePop.do");
        return mv;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 신규이력등록 > 첨부파일삭제
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/attachedFileDelete", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView attachedFileDelete(HttpServletRequest request) throws Exception{
        //System.out.println("attachedFileDelete.do");
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        
        String seqno = ServletRequestUtils.getStringParameter(request, "seqno");
        String result = DnkrConstans.RESULT_N;
        
        FileDb2Domain domain = new FileDb2Domain();
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        domain.setComps(empInfo.getPlantCd());
        domain.setLib2(empInfo.getLib2());
        domain.setLib2("psdiolib"); //test
        domain.setSeqno(seqno);
        
        int cnt = psogmAttachedFileService.delete(domain);
        
        if(cnt > 0) {
            result = DnkrConstans.RESULT_Y;
        }
                
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    
    /**
     * 
     * @param fileDomain        BoardFileDomain
     * @param response          HttpServletResponse
     * @param request           HttpServletRequest
     * @throws Exception 
     */
    @RequestMapping(value = "/downFile", method = {RequestMethod.GET, RequestMethod.POST})
    public void downFile(FileDb2Domain fileDomain, HttpServletResponse response, 
        HttpServletRequest request) throws Exception {

        String rootPath = UxisCmmUtil.getProperty("system.uploadpath");
      
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        fileDomain.setComps(empInfo.getPlantCd());
        fileDomain.setLib2(empInfo.getLib2());
        fileDomain.setLib2("psdiolib"); //test
        fileDomain = psogmAttachedFileService.searchById(fileDomain);
        
        /** 파일 다운로드 처리 */
        try{
            UxisFileMngUtil mngUtil = new UxisFileMngUtil();
            
            //저장 된 파일명에서 폴더와 파일명 분리
            int index = fileDomain.getFilnm().lastIndexOf("/");
            String fileName = fileDomain.getFilnm().substring(index + 1);
            String saveDir = fileDomain.getFilnm().substring(0, index);
            
            //downLoadProcess(response, request, 저장경로(root경로 포암 - ex > c:/customfolder), 저장된 파일명(폴더부분 제외), 실제파일명)
            mngUtil.downLoadProcess(response, request, rootPath + saveDir, fileName, fileName);
        }catch(Exception e){
            //e.printStackTrace();
        }
    }
    
    
    /**
     * [KO] 신규이력등록 시 max 지시no + 1 구하기
     * 
     * @param domain PsogmDomain
     * @return StringBuffer
     */
    private String getMaxJisno(PsogmDomain domain) {
      //max jisno 구하기
        StringBuffer maxNumBf = new StringBuffer();
        String maxNum = null;
        maxNumBf.append(domain.getComps());
        
        try {
            maxNum = psogmService.selectOgm_maxJisiNum(domain);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        if(maxNum != null) {
            maxNumBf.append(maxNum);
        }
        return maxNumBf.toString();
    }
    
    /**
     * [KO] 지시No에 만들 때 필요한 앞문자 구하기
     * 
     * @param comps String
     * @return plantCd String
     */
    private String getPlantCd(String comps) {
        String type = comps.substring(0, 1);
        String plantCd = "";
        if(type.equals("C")) {
            plantCd = "PC";
        } else if (type.equals("H")) {
            plantCd = "PH";
        } else if (type.equals("S")) {
            plantCd = "PS";
        } else if (type.equals("E")) {
            plantCd = "PE";
        }
        return plantCd;
    }
}
