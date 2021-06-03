package com.globaldenso.dnkr.presentation.controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.PssallibService;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.PssallibDomain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;


/**
 * [KO] 출고관리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls of project (WAK015).<br>
 * [JP] <br>
 * 
 * @author UXIS
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAF015Pssallib")
@ViewId(value = "WAF015")
public class WAF015PssallibController {

    /**
     * [KR] 출고관리 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private PssallibService pssallibService;
    
    /**
     * [KR] 공통코드관리 서비스 <br>          
     */
    @Autowired
    private CodeService codeService;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAF015PssallibController() {
        // no process
    }
    
    /**
     * 
     * @param request HttpServletRequest
     * @param form PssallibDomain
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAF015")
    @Token(save = true)
    public ModelAndView init(HttpServletRequest request, @ModelAttribute("PssallibDomain") PssallibDomain form) throws Exception {
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
        ModelAndView mv = new ModelAndView();
        
       //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        form.setLib1(empInfo.getLib1());
        form.setLib2(empInfo.getLib2());
        form.setLib3(empInfo.getLib3());
        form.setComps(empInfo.getPlantCd());

        //현재시간
        String sysTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        //System.out.println(sysTime);
        
       //today - 4days
        Date today = new Date();
        Date jpsdt1 = new Date();
        jpsdt1.setTime(today.getTime() - ((long) 1000 * 60 * 60 * 24 * 4));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String strjpsdt1 = sdf.format(jpsdt1);
        
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = sdf2.format(today);
        
       //어제날짜
        Date jpsdt2 = new Date();
        jpsdt2.setTime(today.getTime() - ((long) 1000 * 60 * 60 * 24 ));
        String strjpsdt2 = sdf.format(jpsdt2);
        
        form.setJpsdt(strjpsdt1);
        form.setJpsdt2(strjpsdt2);
        
        /*// 사업부, 사업장 세션에 담는걸로 변경 - 180626 김용균대리님 요청
      //공통코드
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
        
        try {
            List<PssallibDomain> pssList = pssallibService.selectSMDZ123P_CHK(form);
            mv.addObject("ds_SMDZ123P_CHK", pssList);
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
        }
        
        String pss = "";
         /*for(int i=0; i<pssForm.size();i++){
             pss += pssForm.get(i).getComps()+"§";
             pss += pssForm.get(i).getJpnno()+"§";
             pss += pssForm.get(i).getSlpno()+"§";
             pss += pssForm.get(i).getJpsdt()+"§";
             
             pss += pssForm.get(i).getPyvnd()+"§";
             pss += pssForm.get(i).getShpto()+"§";
             pss += pssForm.get(i).getCusnm()+"§";
             pss += pssForm.get(i).getShpnm()+"§";
             pss += pssForm.get(i).getMstsm()+"§";
             
             pss += pssForm.get(i).getCarcd()+"§";
             pss += pssForm.get(i).getPspno()+"§";
             pss += pssForm.get(i).getCprtn()+"§";
             pss += pssForm.get(i).getUnmsr()+"§";
             pss += pssForm.get(i).getJpsqy()+"§";
             pss += pssForm.get(i).getPcost()+"§";
             pss += pssForm.get(i).getPfote()+"§";
             pss += pssForm.get(i).getCurcd()+"§";
             pss += pssForm.get(i).getPcsum()+"§^n";
             
         }*/
        
        mv.addObject("SYSDATE", sysDate);
//        mv.addObject("SYSTIME", sysTime);
        mv.addObject("pssForm", pss);
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("url", "WAF015Pssallib.jsp");
        mv.setViewName(".tiles.page.WAF015");
        return mv;  
    }
    
    /**
     * 
     * @param request request
     * @param form form
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAF015")
    @Token(save = true)
    public ModelAndView search(HttpServletRequest request, @ModelAttribute("PssallibDomain") PssallibDomain form) throws Exception {
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        ModelAndView mv = new ModelAndView(); 
        
       //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        form.setLib1(empInfo.getLib1());
        form.setLib2(empInfo.getLib2());
        form.setLib3(empInfo.getLib3());
        form.setComps(empInfo.getPlantCd());
        
      //현재시간
        String sysTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        
       //today - 4days
        Date today = new Date();
        Date jpsdt1 = new Date();
        jpsdt1.setTime(today.getTime() - ((long) 1000 * 60 * 60 * 24 * 4));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String strjpsdt1 = sdf.format(jpsdt1);
        
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String sysDate = sdf2.format(today);
        
       //어제날짜
        Date jpsdt2 = new Date();
        jpsdt2.setTime(today.getTime() - ((long) 1000 * 60 * 60 * 24 ));
        String strjpsdt2 = sdf.format(jpsdt2);
        
        PssallibDomain criteria = new PssallibDomain();
        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        criteria.setLib3(empInfo.getLib3());
        criteria.setComps(empInfo.getPlantCd());
        criteria.setJpsdt(strjpsdt1);
        criteria.setJpsdt2(strjpsdt2);
        
        try {
            List<PssallibDomain> pssList = pssallibService.selectSMDZ123P_CHK(criteria);
            mv.addObject("ds_SMDZ123P_CHK", pssList);
        } catch(Exception e) {
            System.out.println("데이터가 없습니다.");
        }
        
        //System.out.println("strjpsdt1:" + strjpsdt1);
        //System.out.println("strjpsdt2:" + strjpsdt2);
        if("".equals(form.getJpsdt())){
            form.setJpsdt(strjpsdt1);
            form.setJpsdt2(strjpsdt2);
        } else {
            String date1 = form.getJpsdt().replace("-", "");
            String date2 = form.getJpsdt2().replace("-", "");
            form.setJpsdt(date1);
            form.setJpsdt2(date2);
        }
        
        if(!"".equals(form.getJptdt1()) && form.getJptdt1() != null){
            form.setJptdt1(form.getJptdt1().replace("-", ""));
            form.setJptdt2(form.getJptdt2().replace("-", ""));
        }
        
        
        
      //공통코드
        CodeDb2Domain codeDomain = new CodeDb2Domain();
        codeDomain.setDb2class("PLNT");
        codeDomain.setCoded1(empInfo.getCompany());
        
        List<CodeDb2Domain> codeList = null;
        try {
            codeList = codeService.comCode(codeDomain);
            //System.out.println("codeList >> " + codeList);
        } catch(Exception e) {
            System.out.println("데이터가 없습니다.");
        }

        try {
            List<PssallibDomain> pssForm = pssallibService.selectSMDZ123P(form);
            String pss = "";
            for(int i = 0; i < pssForm.size(); i++){
                pss += pssForm.get(i).getComps() + "§";
                pss += pssForm.get(i).getJpnno() + "§";
                pss += pssForm.get(i).getSlpno() + "§";
                pss += pssForm.get(i).getJpsdt() + "§";
                
                pss += pssForm.get(i).getPyvnd() + "§";
                pss += pssForm.get(i).getShpto() + "§";
                pss += pssForm.get(i).getCusnm() + "§";
                pss += pssForm.get(i).getShpnm() + "§";
                
                pss += pssForm.get(i).getCarcd() + "§";
                pss += pssForm.get(i).getMstsm() + "§";
                pss += pssForm.get(i).getPspno() + "§";
                pss += pssForm.get(i).getCprtn() + "§";
                pss += pssForm.get(i).getUnmsr() + "§";
                pss += pssForm.get(i).getJpsqy() + "§";
                pss += pssForm.get(i).getPcost() + "§";
                pss += pssForm.get(i).getPfote() + "§";
                pss += pssForm.get(i).getCurcd() + "§";
                pss += pssForm.get(i).getPcsum() + "§^n";
            }
            mv.addObject("pssForm", pss);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        mv.addObject("SYSDATE", sysDate);
        mv.addObject("SYSTIME", sysTime);
        mv.addObject("codeList", codeList);
        mv.addObject("paramForm", form);
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAF015Pssallib.jsp");
        mv.setViewName(".tiles.page.WAF015");
        return mv;  
    }

    
}
