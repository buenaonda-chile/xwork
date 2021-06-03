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
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.PsogmService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.RelationDb2Domain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.PsogmDomain;
import com.globaldenso.dnkr.domain.db2.SpareUnitDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 보전이력 검색 컨트롤러.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAF001PsogmSearch")
@ViewId(value = "WAF001")
public class WAF001PsogmSearchController {

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
     * [KR] 사원관리 서비스 <br>          
     */
    @Autowired
    private EmpService empService;
    
    /**
     * [KR] 사업부, 파트관리 서비스 <br>          
     */
    @Autowired
    private RelationClsService relationDb2Service;
    
    /**
     * 종합관리 > 설비보전 > 메뉴코드
     */
    private final String MENU_CODE = "522"; 

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAF001PsogmSearchController() {
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
        //System.out.println("/WAF001PsogmSearch");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");

      //한달 전
        Calendar mon = Calendar.getInstance();
        mon.add(Calendar.MONTH , -1);
        String beforeMonth = new SimpleDateFormat("yyyy-MM-dd").format(mon.getTime());
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        String empComps = empInfo.getPlantCd();
        String lib2 = empInfo.getLib2();
        
        /*// 사업부, 사업장 세션에 담는걸로 변경 - 180626 김용균대리님 요청
        CodeDb2Domain codeDomain = new CodeDb2Domain();
        codeDomain.setDb2class("PLNT");
        codeDomain.setCoded1(empInfo.getCompany());
        List<CodeDb2Domain> codeList = null;
        try {
            codeList = codeService.comCode(codeDomain);
            mv.addObject("codeList", codeList);
        } catch(Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        */
        UxisCmmUtil.getSessionComCode(request, mv);
        
        RelationDb2Domain relationDb2Domain = new RelationDb2Domain();
        relationDb2Domain.setLib2(lib2);
        relationDb2Domain.setComps(empComps);
        
        //파트정보
        try {
            List<RelationDb2Domain> partList = relationDb2Service.searchByConditionForPart(relationDb2Domain);
            mv.addObject("partList", partList);
        } catch(Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        
        //라인정보
        try {
            List<RelationDb2Domain> lineList = relationDb2Service.searchByConditionForLine(relationDb2Domain);
            mv.addObject("lineList", lineList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        
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
        
        //실시부서
        try {
            List<PsogmDomain> sdeptList = psogmService.selectOgm313_obc250pf(psogmDomain);
            mv.addObject("sdeptList", sdeptList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
      //Sub assy
        try {
            List<PsogmDomain> assyList = psogmService.selectOgm203_obc230pf(psogmDomain);
            mv.addObject("assyList", assyList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
      //셋트부품정보
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
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));        
        mv.addObject("beforeMonth", beforeMonth);
        mv.addObject("tabId", tabId);
        mv.addObject("menu", menu);
        mv.addObject("url", "WAF001PsogmSearch.jsp");
        mv.setViewName(".tiles.page.WAF001");
        return mv;
    }

    /**
     * [KO] 종합관리 > 설비보전관리 > 보전이력검색 - 지시no 외의 값으로 조회한 결과팝업
     * 
     * @param request   HttpServletRequest
     * @param form   PsogmDomain
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/searchPop", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView searchPop(HttpServletRequest request, PsogmDomain form) throws Exception{

        ModelAndView mv = new ModelAndView();
        
      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setLib2(empInfo.getLib2());
        form.setLib3(empInfo.getLib3());
        
        if(form.getWndats() != null && ! "".equals(form.getWndats())) {
            form.setWndats(form.getWndats().replace("-", ""));
        }
        
        if(form.getWndate() != null && ! "".equals(form.getWndate())) {
            form.setWndate(form.getWndate().replace("-", ""));
        }
        
        List<PsogmDomain> searchList = null;
        
        try {
            searchList = psogmService.selectOgm314_onload(form);
            mv.addObject("searchList", searchList);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        mv.addObject("comps", form.getComps());
        mv.addObject("paraDomain", form);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("url", "WAF019PsogmSearchPop.jsp");
        mv.setViewName(".tiles.page.WAF019");
        return mv;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 보전이력검색 - 지시no 값으로 조회한 결과팝업
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/resultPop", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView searchJisiPop(HttpServletRequest request) throws Exception{

        ModelAndView mv = new ModelAndView();
        String comps = ServletRequestUtils.getStringParameter(request, "comps");
        String jisno = ServletRequestUtils.getStringParameter(request, "jisno");
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");

        PsogmDomain criteria = new PsogmDomain();
        criteria.setLib2(empInfo.getLib2());
        criteria.setLib3(empInfo.getLib3());
        criteria.setComps(comps);
        criteria.setJisno(jisno);
        try {
            PsogmDomain domain = psogmService.selectOgm313_gms219(criteria);
            mv.addObject("resultDomain", domain);
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
            //e.printStackTrace();
        }
        
        try {
            List<PsogmDomain> replaceProduct = psogmService.select_obj220pf_InqParts(criteria);
            mv.addObject("replaceProduct", replaceProduct);
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
            //e.printStackTrace();
        }
        
        mv.addObject("comps", comps);
        mv.addObject("jisno", jisno);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("url", "WAF018PsogmResultPop.jsp");
        mv.setViewName(".tiles.page.WAF018");
        return mv;
    }
    
    
    /**
     * [KO] 지시번호로 조회한 결과화면에서 발행버튼 눌렀을 때 뜨는 유비레포트 화면
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/ubiReportPop", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ubiReportPop(HttpServletRequest request) throws Exception{

        ModelAndView mv = new ModelAndView();
        String comps = ServletRequestUtils.getStringParameter(request, "comps");
        String jisno = ServletRequestUtils.getStringParameter(request, "jisno");
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");

        PsogmDomain criteria = new PsogmDomain();
        criteria.setLib2(empInfo.getLib2());
        criteria.setLib3(empInfo.getLib3());
        criteria.setComps(comps);
        criteria.setJisno(jisno);
        try {
            PsogmDomain domain = psogmService.selectOgm203_rep(criteria);
            StringBuffer resultBuf = new StringBuffer();
            
            if(domain != null) {
                resultBuf.append(domain.getJisno() + "§");
                resultBuf.append(domain.getMshno() + "§");
                resultBuf.append(domain.getLinnm() + "§");
                resultBuf.append(domain.getMshnm() + "§");
                resultBuf.append(domain.getJobcd() + "§");
                resultBuf.append(domain.getJobnm() + "§");
                resultBuf.append(domain.getKdown() + "§");
                resultBuf.append(domain.getInocd() + "§");
                resultBuf.append(domain.getInonm() + "§");
                resultBuf.append(domain.getEmgcd() + "§");
                resultBuf.append(domain.getEmgry() + "§");
                resultBuf.append(domain.getQorcd() + "§");
                resultBuf.append(domain.getQornm() + "§");
                resultBuf.append(domain.getSubas() + "§");
                resultBuf.append(domain.getAssnm() + "§");
                resultBuf.append(domain.getAssno() + "§");
                resultBuf.append(domain.getComcd() + "§");
                resultBuf.append(domain.getCpart() + "§");
                resultBuf.append(domain.getDeccd() + "§");
                resultBuf.append(domain.getDpart() + "§");
                resultBuf.append(domain.getPrtno() + "§");
                resultBuf.append(domain.getChocd() + "§");
                resultBuf.append(domain.getChonm() + "§");
                resultBuf.append(domain.getHyocd() + "§");
                resultBuf.append(domain.getHyonm() + "§");
                resultBuf.append(domain.getCaucd() + "§");
                resultBuf.append(domain.getCause() + "§");
                resultBuf.append(domain.getTrucd() + "§");
                resultBuf.append(domain.getTrunm() + "§");
                resultBuf.append(domain.getPadat() + "§");
                resultBuf.append(domain.getPatim() + "§");
                resultBuf.append(domain.getUrdat() + "§");
                resultBuf.append(domain.getUrtim() + "§");
                resultBuf.append(domain.getKsdat() + "§");
                resultBuf.append(domain.getKstim() + "§");
                resultBuf.append(domain.getWndat() + "§");
                resultBuf.append(domain.getWntim() + "§");
                resultBuf.append(domain.getWrkm() + "§");
                resultBuf.append(domain.getKornm() + "§");
                resultBuf.append(domain.getSdpnm() + "§");
                resultBuf.append(domain.getWrkm2() + "§");
                resultBuf.append(domain.getKornm2() + "§");
                resultBuf.append(domain.getSdpnm2() + "§");
                resultBuf.append(domain.getSdpcd() + "§");
                resultBuf.append(domain.getSubcn() + "§");
                resultBuf.append(domain.getScost() + "§");
                resultBuf.append(domain.getPcost() + "§");
                resultBuf.append(domain.getRepcd() + "§");
                resultBuf.append(domain.getRepnm() + "§");
                resultBuf.append(domain.getEffcd() + "§");
                resultBuf.append(domain.getEffnm() + "§");
                resultBuf.append(domain.getEcost() + "§");
                //개행문자때문에 javascript에서 오류남
                resultBuf.append(domain.getHyosn().replaceAll("(\r\n|\r|\n|\n\r)", "\\<br\\>") + "§");
                resultBuf.append(domain.getWonin().replaceAll("(\r\n|\r|\n|\n\r)", "\\<br\\>") + "§");
                resultBuf.append(domain.getDaech().replaceAll("(\r\n|\r|\n|\n\r)", "\\<br\\>") + "§");
                resultBuf.append(domain.getJanhr() + "§");
                resultBuf.append(domain.getWathr() + "§");
                resultBuf.append(domain.getStphr() + "§");
                resultBuf.append(domain.getMnthr() + "§");
                resultBuf.append(domain.getBfrhr() + "§");
                resultBuf.append(domain.getTothr() + "§");
                resultBuf.append(domain.getCmplt() + "§");
                resultBuf.append(domain.getCnote() + "§");
                resultBuf.append(domain.getTeima() + "§");
                resultBuf.append(domain.getDaesn() + "§");
                resultBuf.append(domain.getChkan() + "§");
                resultBuf.append(domain.getImgbf() + "§");
                resultBuf.append(domain.getImgaf() + "§^n");
            
                mv.addObject("resultDomain", domain);
                mv.addObject("result", (resultBuf.toString()).trim());
            }
            //System.out.println("test:" + resultBuf.toString());
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
            //e.printStackTrace();
        }
        
        try {
            List<PsogmDomain> replaceProduct = psogmService.select_obj220pf_InqParts(criteria);
            StringBuffer resultBuf2 = new StringBuffer();
            if (replaceProduct != null) {
                for(int i = 0; i < replaceProduct.size(); i++) {
                    resultBuf2.append(replaceProduct.get(i).getPrtno() + "§");
                    resultBuf2.append(replaceProduct.get(i).getPrtnm() + "§");
                    resultBuf2.append(replaceProduct.get(i).getPtype() + "§");
                    resultBuf2.append(replaceProduct.get(i).getMaker() + "§");
                    resultBuf2.append(replaceProduct.get(i).getQuaty() + "§");
                    resultBuf2.append(replaceProduct.get(i).getPrice() + "§");
                    resultBuf2.append(replaceProduct.get(i).getAmont() + "§");
                    resultBuf2.append("0" + "§");
                    resultBuf2.append(replaceProduct.get(i).getSeqno() + "§^n");
                
                }
                mv.addObject("replaceProduct", replaceProduct);
                mv.addObject("result2", resultBuf2.toString());
                //System.out.println("test:" + resultBuf2.toString());
            }
//          PsogmDomain replaceProduct = psogmService.select_obj220pf_InqParts(criteria);
//          mv.addObject("replaceProduct", replaceProduct);
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
            //e.printStackTrace();
        }
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("url", "WAF021PsogmUbiRptPop.jsp");
        mv.setViewName(".tiles.page.WAF021");
        return mv;
    }
    
    /**
     * 
     * [KO] COMPLETE 부품정보 가져오기(ajax) <br>
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception excepiton
     */
    @RequestMapping(value = "/getPartsInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getPartsInfo(HttpServletRequest request) throws Exception {
        
        String result = DnkrConstans.RESULT_N;
        String kndcd = ServletRequestUtils.getStringParameter(request, "kndcd");
        String umhen = ServletRequestUtils.getStringParameter(request, "umhen"); //검색 - 음행
        String typeL = ServletRequestUtils.getStringParameter(request, "typeL"); //셋트부품, 단위부품 구분
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        
      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        PsogmDomain psogmDomain = new PsogmDomain();
        psogmDomain.setLib2(empInfo.getLib2());
        psogmDomain.setComps(empInfo.getPlantCd());
        psogmDomain.setKndcd(kndcd);
        psogmDomain.setUmhen(umhen);
        List<PsogmDomain> partsList = null;
        
        try {
            if(typeL.equals("com")) {
                partsList = psogmService.selectOgm203_obc060pf_01(psogmDomain);
            } else if(typeL.equals("dec")) {
                partsList = psogmService.selectOgm203_obc050pf_01(psogmDomain);
            }
        } catch(Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        if(partsList != null) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("partsList", partsList);
            
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * 
     * [KO] 현상정보 가져오기 <br>
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception excepiton
     */
    @RequestMapping(value = "/getSelectedInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getPhenomenonInfo(HttpServletRequest request) throws Exception {
        String result = DnkrConstans.RESULT_N;
        String param = ServletRequestUtils.getStringParameter(request, "param");
        String typeL = ServletRequestUtils.getStringParameter(request, "typeL"); 
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        
      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        PsogmDomain psogmDomain = new PsogmDomain();
        psogmDomain.setLib2(empInfo.getLib2());
        psogmDomain.setComps(empInfo.getPlantCd()); 
        List<PsogmDomain> list = null;
        
        try {
            if(typeL.equals("hyo")){
                psogmDomain.setHkind(param);
                list = psogmService.selectOgm203_obc180pf(psogmDomain);
            } else if (typeL.equals("cau")){
                psogmDomain.setCkind(param);
                list = psogmService.selectOgm203_obc110pf(psogmDomain);
            } else if (typeL.equals("truC")){
                psogmDomain.setCkind(param);
                list = psogmService.selectOgm203_obc090pf(psogmDomain);
            } else if (typeL.equals("eff")){
                psogmDomain.setEffcd(param);
                list = psogmService.selectOgm203_obc200pf(psogmDomain);
            }
            
        } catch(Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        if(list != null) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("list", list);
            
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * [KO] 사번으로 사원정보 가져오는 메소드(ajax)
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/getEmpInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getEmpName(HttpServletRequest request) throws Exception {
        
        //System.out.println("/getEmpName");
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        
        String sabun = ServletRequestUtils.getStringParameter(request, "sabun");
        
      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        EmpDb2Domain empDomain = new EmpDb2Domain();
        empDomain.setLib2(empInfo.getLib2());
        empDomain.setLib3(empInfo.getLib3());
        empDomain.setSabun(sabun);                     
        
        EmpDb2Domain getDomain = null;
        try {
            getDomain = empService.selectOgm200_hmd020pf(empDomain);
            
        } catch(Exception e) {
            
        }
        
        if(getDomain != null) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("empInfo", getDomain); 
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * [KO] 보전이력검색 - 지시넘버 이외의 값으로로 조회 결과 엑셀파일 만들기 
     * 
     * @param form              WAB001EmpSearchForm
     * @param response          HttpServletResponse
     * @param request           HttpServletRequest
     * @throws Exception 
     */
    @RequestMapping(value = "/psogmExcel.do", method = RequestMethod.POST)
    @ErrorBack(viewName = "forward:init.do")
    public void empExcel(HttpServletResponse response, PsogmDomain form, 
        HttpServletRequest request)  throws Exception {
        
        String filename = "searchList";
        
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setLib2(empInfo.getLib2());
        form.setLib3(empInfo.getLib3());
        
        if(form.getWndats() != null && ! "".equals(form.getWndats())) {
            form.setWndats(form.getWndats().replace("-", ""));
        }
        
        if(form.getWndate() != null && ! "".equals(form.getWndate())) {
            form.setWndate(form.getWndate().replace("-", ""));
        }
        
        List<PsogmDomain> searchExcel = null;
        try {
            searchExcel = psogmService.selectOgm314_onload(form);
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
            //e.printStackTrace();
        }
        
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("보전이력검색");
        Row row = null;
        Cell cell = null;
        int rowNo = 3;
        
        CellStyle headStyle = wb.createCellStyle();
        
        headStyle.setFillForegroundColor(HSSFColorPredefined.GOLD.getIndex());
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headStyle.setBorderTop(BorderStyle.THIN);
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);
        headStyle.setAlignment(HorizontalAlignment.CENTER);
        
        CellStyle bodyStyle = wb.createCellStyle();
        bodyStyle.setBorderTop(BorderStyle.THIN);
        bodyStyle.setBorderBottom(BorderStyle.THIN);
        bodyStyle.setBorderLeft(BorderStyle.THIN);
        bodyStyle.setBorderRight(BorderStyle.THIN);
        
        row = sheet.createRow(1);
        cell = row.createCell(1);
        cell.setCellValue("작업보고 검색결과 List");
        
        row = sheet.createRow(rowNo++);
        cell = row.createCell(1);
        cell.setCellStyle(headStyle);
        cell.setCellValue("설비명칭");
        cell = row.createCell(2);
        cell.setCellStyle(headStyle);
        cell.setCellValue("관리번호");
        cell = row.createCell(3);
        cell.setCellStyle(headStyle);
        cell.setCellValue("고장구분");
        cell = row.createCell(4);
        cell.setCellStyle(headStyle);
        cell.setCellValue("발생년월일");
        cell = row.createCell(5);
        cell.setCellStyle(headStyle);
        cell.setCellValue("의뢰년월일");
        cell = row.createCell(6);
        cell.setCellStyle(headStyle);
        cell.setCellValue("개시년월일");
        cell = row.createCell(7);
        cell.setCellStyle(headStyle);
        cell.setCellValue("완료년월일");
        cell = row.createCell(8);
        cell.setCellStyle(headStyle);
        cell.setCellValue("정지시간");
        cell = row.createCell(9);
        cell.setCellStyle(headStyle);
        cell.setCellValue("성명");
        cell = row.createCell(10);
        cell.setCellStyle(headStyle);
        cell.setCellValue("현상");
        cell = row.createCell(11);
        cell.setCellStyle(headStyle);
        cell.setCellValue("원인");
        cell = row.createCell(12);
        cell.setCellStyle(headStyle);
        cell.setCellValue("대책");
        
        if(searchExcel != null){
            for(int i = 0; i < searchExcel.size(); i++) {
                row = sheet.createRow(rowNo++);
                cell = row.createCell(1);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(searchExcel.get(i).getMshnm());
                
                cell = row.createCell(2);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(searchExcel.get(i).getMshno());
                
                cell = row.createCell(3);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(searchExcel.get(i).getKogub());
                
                cell = row.createCell(4);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(searchExcel.get(i).getPadat());
                
                cell = row.createCell(5);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(searchExcel.get(i).getUrdat());
                
                cell = row.createCell(6);
                cell.setCellStyle(bodyStyle);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                Date date = sdf.parse(searchExcel.get(i).getKsdat());
                cell.setCellValue(sdf.format(date));
                
                cell = row.createCell(7);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(searchExcel.get(i).getWndat2());
                
                cell = row.createCell(8);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(searchExcel.get(i).getStphr());
                
                cell = row.createCell(9);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(searchExcel.get(i).getKornm());
                
                cell = row.createCell(10);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(searchExcel.get(i).getHyosn());
                
                cell = row.createCell(11);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(searchExcel.get(i).getWonin());
                
                cell = row.createCell(12);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(searchExcel.get(i).getDaech());
            }
        }
        
        response.reset();
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + filename + "_excel.xls");
        
        wb.write(response.getOutputStream());
        wb.close();
    }
    
    /**
     * [KO] 품목리스트 가져오는 메소드(ajax)
     * 
     * @param request   HttpServletRequest
     * @param form   SpareUnitDb2Domain
     * @return  ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/getPartList", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getPartList(HttpServletRequest request, SpareUnitDb2Domain form) throws Exception {

        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        
        String pData = ServletRequestUtils.getStringParameter(request, "pData");
        
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        form.setComps(empInfo.getPlantCd());
        form.setLib2(empInfo.getLib2());
        
        form.setPrtno(pData);

        List<SpareUnitDb2Domain> list = null;
        
        try {
            list = psogmService.selectOGMPrtno(form);    
        } catch(Exception e) {
            e.printStackTrace();   
        }
        
        if(list != null) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("list", list); 
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * [KO] 구입선(업체)리스트 가져오는 메소드(ajax)
     * 
     * @param request   HttpServletRequest
     * @param form   SpareUnitDb2Domain
     * @return  ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/getVndnrList", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getVndnrList(HttpServletRequest request, SpareUnitDb2Domain form) throws Exception {

        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        
        String pData = ServletRequestUtils.getStringParameter(request, "pData");
        
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setLib2(empInfo.getLib2());
        
        form.setVndnr(pData);

        List<SpareUnitDb2Domain> list = null;
        
        try {
            list = psogmService.selectOGMVndnr(form);    
        } catch(Exception e) {
            e.printStackTrace();   
        }
        
        if(list != null) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("list", list); 
        }
        //System.out.println(list.size());
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * [KO] 구입선(업체)리스트 가져오는 메소드(ajax)
     * 
     * @param request   HttpServletRequest
     * @param form   SpareUnitDb2Domain
     * @return  ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/getMakerList", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getMakerList(HttpServletRequest request, SpareUnitDb2Domain form) throws Exception {
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        
        String pData = ServletRequestUtils.getStringParameter(request, "pData");
        
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setCode(empInfo.getPlantCd());
        form.setLib2(empInfo.getLib2());
        
        form.setMaker(pData);

        List<SpareUnitDb2Domain> list = null;
        
        try {
            list = psogmService.selectOGMVndnr(form);    
        } catch(Exception e) {
            e.printStackTrace();   
        }
        
        if(list != null) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("list", list); 
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 강제입고등록 - Manager 체크
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/chkManager", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView chkManager(HttpServletRequest request) throws Exception{
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        
        String group = ServletRequestUtils.getStringParameter(request, "group");
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        SpareUnitDb2Domain criteria = new SpareUnitDb2Domain();
        criteria.setComps(empInfo.getPlantCd());
        criteria.setLib2(empInfo.getLib2());
        criteria.setGroup(group); // 1:예비품, 2:
        criteria.setDioid(empInfo.getUserId());
        
        SpareUnitDb2Domain getDomain = null;
        try {
            getDomain = psogmService.selectmanagerYN(criteria);    
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
}
