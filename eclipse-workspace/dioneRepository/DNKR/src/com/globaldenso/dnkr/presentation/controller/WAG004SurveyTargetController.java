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

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.library.presentation.paging.utility.PagingUtility;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.business.service.SurveyService;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;
import com.globaldenso.dnkr.domain.TargetDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 설문관리 대상자 선별 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAG004SurveyTarget")
@ViewId(value = "WAG004")
public class WAG004SurveyTargetController {
    /**
     * [KR] 설문조사 서비스 <br>     
     */
    @Autowired
    private SurveyService surveyService;
    
    /**
     * [KR] 사업부관리 서비스 <br>     
     */
    @Autowired
    private RelationClsService relationClsService;
    
    /**
     * [KR] 사업장관리 서비스 <br>          
     */
    @Autowired
    private RelationLocService relationLocService;
    
    /**
     * [KR] 사업부서(팀)관리 서비스 <br>     
     */
    @Autowired
    private RelationTeamService relationTeamService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAG004SurveyTargetController() {
        // no process
    }
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      TargetDomain
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST} )
    public ModelAndView init(HttpServletRequest request, @ModelAttribute("TargetDomainForm") TargetDomain form)  throws Exception {
        
        ModelAndView mv = new ModelAndView();  
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String mode = ServletRequestUtils.getStringParameter(request, "mode");
        String view = ServletRequestUtils.getStringParameter(request, "view");
        
        form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        
        if(mode != null && mode.equals("view")){
            form.setMode(mode);
        }
        
        int count = 0;
        try {
            count = surveyService.searchEmployCount(form);
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
        }
        
        if(count > 0) {
            // paging process
            PagingUtility.calcPaging(form, count);
            List<TargetDomain> empList = surveyService.searchByConditionEmployForPaging(form);
            mv.addObject("empList", empList);
        }
        
        /*// 사업부, 사업장 세션에 담는걸로 변경 - 180626 김용균대리님 요청
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        clsDomain.setUseYn("Y");
        List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
        
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        locDomain.setUseYn("Y");
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
        */
        
//        UxisCmmUtil.getSessionCls(request, mv);
        UxisCmmUtil.getSessionLoc(request, mv);
        
        RelationTeamDomain teamDomain = new RelationTeamDomain();
        teamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        teamDomain.setUseYn("Y");
        List<RelationTeamDomain> teamList = relationTeamService.searchByCondition(teamDomain);
        
        //mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("paraEmp", form);
        mv.addObject("view", view);
        mv.addObject("menu", menu);
        mv.addObject("mode", mode);
        mv.addObject("totCount", count);
        mv.addObject("teamList", teamList);
        mv.addObject("url", "WAG004SurveyTarget.jsp");
        mv.setViewName(".tiles.page.WAG004");
        return mv;
        
    }
    
    /**
     *
     * 
     * @param form      TargetDomain
     * @param request   HttpServletRequest
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = "forward:init.do")
    public ModelAndView search(@ModelAttribute("TargetDomainForm") TargetDomain form, HttpServletRequest request)  throws Exception {
        ModelAndView mv = new ModelAndView();
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String mode = ServletRequestUtils.getStringParameter(request, "mode");
        String view = ServletRequestUtils.getStringParameter(request, "view");
        
        
        if(mode != null && mode.equals("view")){
            form.setMode(mode);
        }

        form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        int count = 0;
        try {
            count = surveyService.searchEmployCount(form);
        } catch (Exception e) {
            System.out.println("보여줄 데이터가 없습니다.");
        }
//        domain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
//        List<EmpDomain> empList = empService.searchByCondition(domain);
        
        // paging process
        if(count > 0){
            PagingUtility.calcPaging(form, count);
            List<TargetDomain> empList = surveyService.searchByConditionEmployForPaging(form);
            mv.addObject("totCount", count);
            mv.addObject("empList", empList);
        }
        
        /*// 사업부, 사업장 세션에 담는걸로 변경 - 180626 김용균대리님 요청
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setUseYn("Y");
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
        */
//        UxisCmmUtil.getSessionCls(request, mv);
        
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setUseYn("Y");
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
//        if(form.getClsCode() != null) {
//            locDomain.setClsCode(form.getClsCode());
//        }
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
        
        RelationTeamDomain teamDomain = new RelationTeamDomain();
        teamDomain.setUseYn("Y");
        teamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        if(form.getLocCode() != null) {
            teamDomain.setLocCode(form.getLocCode());
        }
        List<RelationTeamDomain> teamList = relationTeamService.searchByCondition(teamDomain);
        
     
        mv.addObject("view", view);
        mv.addObject("mode", mode);
        mv.addObject("menu", menu);
        mv.addObject("srvCode", form.getSrvCode());
        
        //mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("paraEmp", form);
        mv.addObject("locList", locList);
        mv.addObject("teamList", teamList);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAG004SurveyTarget.jsp");
        mv.setViewName(".tiles.page.WAG004");
        
        return mv;
    }
    
    /**
     *
     * 
     * @param request   HttpServletRequest
     * @param response  HttpServletResponse
     * @throws Exception 
     */
    @RequestMapping(value = "/creat", method = { RequestMethod.GET, RequestMethod.POST })
    @Token(check = false, save = true)
    public void create(HttpServletRequest request, HttpServletResponse response)  throws Exception {
        String srvCode = ServletRequestUtils.getStringParameter(request, "srvCode");
        String mode = ServletRequestUtils.getStringParameter(request, "mode");
        String view = ServletRequestUtils.getStringParameter(request, "view");
        
        String[] empNumberList = ServletRequestUtils.getStringParameters(request, "empNumberList[]");
        
        JSONObject jsonObj = new JSONObject();
        TargetDomain form = new TargetDomain();
        form.setSrvCode(srvCode);
        
        if(mode.equals("insert")){
            int result = 0;
            if(view.equals("team")){
                System.out.println("team========");
                result = surveyService.createTeamTarget(form, empNumberList); 
            }else{
                result = surveyService.createEmpTarget(form, empNumberList);
            }
            
            if(result > 0){
                jsonObj.put("result", result + "명의 대상자 등록이 완료되었습니다.");
            }else{
                jsonObj.put("result", "대상자 등록에 실패하셨습니다.");
            }
        }else{
            int result = surveyService.deleteEmpTarget(form, empNumberList);

            if(result > 0){
                jsonObj.put("result", result + "명의 대상자를 삭제하였습니다..");
            }else{
                jsonObj.put("result", "대상자 삭제에 실패하셨습니다.");
            }
        }
        /*
        String maxSrvCode=surveyService.questionMaxCode();
        if(maxSrvCode == null){
            jsonObj.put("result", "작성된 설문이 없습니다.");
        }else if(maxSrvCode.equals(srvCode)){
            jsonObj.put("result", "현재작성된 문항이 이전문항입니다.");
        }else{
            boolean result = surveyService.questionPrev(srvCode, maxSrvCode);
            if(result){
                jsonObj.put("result", "이전의 문항을 불러왔습니다.");
            }else{
                jsonObj.put("result", "프로그램 오류입니다.");
            }
        }*/
        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
    
    /**
     *
     * 
     * @param request   HttpServletRequest
     * @param form      TargetDomain
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/teamList", method = {RequestMethod.GET, RequestMethod.POST} )
    public ModelAndView teamList(HttpServletRequest request, 
        @ModelAttribute("TargetDomainForm") TargetDomain form)  throws Exception {
        
        ModelAndView mv = new ModelAndView();  
        
        String srvCode = ServletRequestUtils.getStringParameter(request, "srvCode");
        String mode = ServletRequestUtils.getStringParameter(request, "mode");
        String view = ServletRequestUtils.getStringParameter(request, "view");
        
        form.setSrvCode(srvCode);
        form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        
        if(mode != null && mode.equals("view")){
            form.setMode(mode);
        }
        
      /*  int count = 0;
        try {
            count = surveyService.searchEmployCount(form);
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
        }*/
        
       /* if(count > 0) {
            // paging process
            PagingUtility.calcPaging(form, count);
            List<TargetDomain> empList = surveyService.searchByConditionEmployForPaging(form);
            mv.addObject("empList", empList);
        }*/
        
        /*// 사업부  사업장 세션에 담는걸로 변경 - 180626 김용균대리님 요청
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        clsDomain.setUseYn("Y");
        List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
        
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        locDomain.setUseYn("Y");
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
        */
//        UxisCmmUtil.getSessionCls(request, mv);
        UxisCmmUtil.getSessionLoc(request, mv);
        
        RelationTeamDomain teamDomain = new RelationTeamDomain();
        teamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        teamDomain.setUseYn("Y");
        List<RelationTeamDomain> teamList = relationTeamService.searchByCondition(teamDomain);
        
        
        List<TargetDomain> targetTeamList = surveyService.searchByTeamListCondition(form);
        
        
        //mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("targetTeamList", targetTeamList);
        mv.addObject("srvCode", srvCode);
        mv.addObject("view", view);
        mv.addObject("paraEmp", form);
        mv.addObject("mode", mode);
        mv.addObject("teamList", teamList);
        mv.addObject("url", "WAG010SurveyTeamTarget.jsp");
        mv.setViewName(".tiles.page.WAG010");
        return mv;
        
    }
}
