package com.globaldenso.dnkr.presentation.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.db2.PsogmImprvDService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.PsogmImprvDDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisStringUtil;

/**
 * [KR] 개선상세 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAF026PsogmImprvD")
@ViewId(value = "WAF026")
public class WAF026PsogmImprvDController {

    /**
     * [KR] 설비보전관리 서비스 <br>          
     */
    @Autowired
    private PsogmImprvDService psogmImprvDService;
    
    /**
     * 종합관리 > 설비보전 > 신규이력등록 메뉴코드
     */
    private final String MENU_CODE = "542"; 
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAF026PsogmImprvDController() {
        // no process
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 신규이력등록 > 개선상세페이지
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView init(HttpServletRequest request) throws Exception{
        //System.out.println("/WAF002PsogmCreate/createSpareUnit.do");
        ModelAndView mv = new ModelAndView();
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String jisno = ServletRequestUtils.getStringParameter(request, "jisno");
        
        PsogmImprvDDomain domain = new PsogmImprvDDomain();
        domain.setJisno(jisno);
//        domain.setJisno("IM1722");//test
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        domain.setComps(empInfo.getPlantCd());
        domain.setLib2(empInfo.getLib2());
        domain.setLib2("psdiolib");   //test
        
        PsogmImprvDDomain imprvDomain = null;
        try {
            imprvDomain = psogmImprvDService.selectOgm204_obj210pf_01(domain);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        mv.addObject("imprvDomain", imprvDomain);        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("menu", menu);
        mv.addObject("jisno", jisno);
//        mv.addObject("jisno", "IM1722");
        mv.addObject("url", "WAF026PsogmImprvCreatePop.jsp");
        mv.setViewName(".tiles.page.WAF026");
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
        String jisno = ServletRequestUtils.getStringParameter(request, "jisno");
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");

        PsogmImprvDDomain criteria = new PsogmImprvDDomain();
        criteria.setLib2(empInfo.getLib2());
        criteria.setLib3(empInfo.getLib3());
        criteria.setComps(empInfo.getPlantCd());
        criteria.setJisno(jisno);  
//        criteria.setJisno("ME1040");  //test
        
        try {
            PsogmImprvDDomain domain = psogmImprvDService.selectOgm220_rep(criteria);
            StringBuffer resultBuf = new StringBuffer();
            
            if(domain != null) {
                resultBuf.append(domain.getKornm() + "§");
                resultBuf.append(domain.getDpdpnm() + "§");
                resultBuf.append(domain.getTeima() + "§");
//                resultBuf.append(domain.getMshno() + "§");
                resultBuf.append(domain.getMshnm() + "§");
                resultBuf.append(domain.getPrtnm() + "§");
                resultBuf.append(domain.getLinnm() + "§");
                resultBuf.append(domain.getKyoru() + "§");
                resultBuf.append(domain.getDaesn() + "§");
                resultBuf.append(domain.getChkan() + "§");
                resultBuf.append(domain.getImgbf() + "§");
                resultBuf.append(domain.getImgaf() + "§");
                
                //개행문자때문에 javascript에서 오류남
                resultBuf.append(domain.getWonin().replaceAll("(\r\n|\r|\n|\n\r)", "\\<br\\>") + "§");
                resultBuf.append(domain.getDaech().replaceAll("(\r\n|\r|\n|\n\r)", "\\<br\\>") + "§");
                
                resultBuf.append(domain.getaSum() + "§");
                resultBuf.append(domain.getbSum() + "§");
                resultBuf.append(domain.getcSum() + "§");
                resultBuf.append(domain.getdSum() + "§");
                resultBuf.append(domain.gettSum() + "§");
                resultBuf.append(domain.getJisno() + "§");
                resultBuf.append(domain.getWndat() + "§");
            
                mv.addObject("resultDomain", domain);
                mv.addObject("result", (resultBuf.toString()).trim());
            }
            //System.out.println("test:" + resultBuf.toString());
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
            //e.printStackTrace();
        }
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("url", "WAF027PsogmImprvUbiRptPop.jsp");
        mv.setViewName(".tiles.page.WAF027");
        return mv;
    }
    
    
    /**
     * [EN] Main processing.<br>
     * [EN] I register and handle it.<br>
     * 
     * [JP] メイン処理。<br>
     * [JP] 登録処理をします。<br>
     * 
     * @param form PsogmImprvDDomain
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ErrorBack(viewName = "forward:init.do")
//    @Token(check = true, save = true)
    public ModelAndView create(PsogmImprvDDomain form, HttpServletRequest request) throws Exception {
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        String status = "insert";

        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        form.setComps(empInfo.getPlantCd());
        form.setLib2(empInfo.getLib2());
        form.setLib2("psdiolib");   //test
        
        form.setAdusr(empInfo.getUserId().substring(1, 7));
        form.setAddat(UxisStringUtil.getTodayYMDString().replace("-", ""));
        form.setAdtim(UxisStringUtil.getNowTimeHMSString().replace(":", ""));

        //jisno 로 개선상세 데이터가 존재하는지 체크

        int cnt = 0;

        try {
            if (isEmptyImprvD(form)) {
                cnt = psogmImprvDService.insertOgm204_obj210pf(form);
            } else {
                status = "update";
                cnt = psogmImprvDService.updateOgm204_obj210pf(form);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        if(cnt > 0) {
            result = DnkrConstans.RESULT_Y;
        }
        
        jsonObj.put("status", status);
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * [KO] 종합관리 > 설비보전관리 > 신규이력등록 > 개선상세 - 도면등록변경
     * 
     * @param request   HttpServletRequest
     * @param domain   FileDb2Domain
     * @param multiRequest   MultipartHttpServletRequest
     * @return  ModelAndView
     * @throws Exception  
     */
    @RequestMapping(value = "/ajaxDrawImgUpdate", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = "forward:init.do")
    public ModelAndView drawImgCreate(HttpServletRequest request, PsogmImprvDDomain domain, 
            MultipartHttpServletRequest multiRequest) throws Exception{
        
        System.out.println("ajaxDrawImgCreate.do");
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        domain.setComps(empInfo.getPlantCd());
        domain.setLib2(empInfo.getLib2());
        domain.setLib2("psdiolib"); //test
        
        try {
            psogmImprvDService.updateImg(domain, multiRequest);
            result = DnkrConstans.RESULT_Y;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * 
     * [KO] 개선상세정보가 존재하면 "Y" 반환, 존재하지 않으면 "N"반환<br>
     * 
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception 
     */
    @RequestMapping(value = "/ajaxGetImprvD", method = RequestMethod.GET)
    public ModelAndView ajaxGetImprvD(HttpServletRequest request) throws Exception{

        System.out.println("/ajaxGetImprvD.do");
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        
        String jisno = ServletRequestUtils.getStringParameter(request, "jisno");
        System.out.println("jisno:" + jisno);
        String result = DnkrConstans.RESULT_N;
        
        PsogmImprvDDomain checkDomain = null;
        
      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        PsogmImprvDDomain domain = new PsogmImprvDDomain();
        domain.setJisno(jisno);
        domain.setComps(empInfo.getPlantCd());
        domain.setLib2(empInfo.getLib2());
        domain.setLib2("psdiolib"); //test
        
        try {
            checkDomain = psogmImprvDService.selectOgm204_obj210pf_01(domain);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("데이터가없습니다.");
        }
        
        if(checkDomain != null) {
            result = DnkrConstans.RESULT_Y;
        }
        
        jsonObj.put("result", result);
        jsonObj.put("pDomain", checkDomain);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * 
     * [KO] 개선상세정보가 존재하면 "Y" 반환, 존재하지 않으면 "N"반환<br>
     * 
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/ajaxDrawImgDelete", method = RequestMethod.GET)
    public ModelAndView ajaxDrawImgDelete(HttpServletRequest request) throws Exception{

        System.out.println("/ajaxDrawImgDelete.do");
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        
        String jisno = ServletRequestUtils.getStringParameter(request, "jisno");
        String dataSort = ServletRequestUtils.getStringParameter(request, "dataSort");
        System.out.println("jisno:" + jisno);
        String result = DnkrConstans.RESULT_N;
        
        PsogmImprvDDomain checkDomain = null;
        
      //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        PsogmImprvDDomain domain = new PsogmImprvDDomain();
        domain.setJisno(jisno);
        domain.setComps(empInfo.getPlantCd());
        domain.setLib2(empInfo.getLib2());
        domain.setLib2("psdiolib"); //test
        
        if(dataSort != null && dataSort.equals("imgbf")) {
            domain.setImgbf("imgDel");
        } else if(dataSort != null && dataSort.equals("imgaf")) {
            domain.setImgaf("imgDel");
        }
        
        int cnt = 0;
        try {
            cnt = psogmImprvDService.deleteImg(domain);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("데이터가없습니다.");
        }
        System.out.println("cnt : "  + cnt);
        
        if(cnt > 0) {
            result = DnkrConstans.RESULT_Y;
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    /**
     * 
     * [KO] 개선상세정보가 존재하면 false 반환, 존재하지 않으면 true반환<br>
     * 
     * @param domain PsogmImprvDDomain
     * @return boolean
     */
    private boolean isEmptyImprvD(PsogmImprvDDomain domain) {

        PsogmImprvDDomain checkDomain = null;
        try {
            checkDomain = psogmImprvDService.selectOgm204_obj210pf_01(domain);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("데이터가없습니다.");
        }
        
        if(checkDomain != null) {
            return false;
        } else {
            return true;    
        }
    }
}
