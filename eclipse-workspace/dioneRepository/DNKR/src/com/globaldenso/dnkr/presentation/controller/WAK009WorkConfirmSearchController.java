package com.globaldenso.dnkr.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.business.service.PjtService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.business.service.WorkSortService;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.PjtDomain;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;
import com.globaldenso.dnkr.domain.WorkSortDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KO] 업무승인 컨트롤러를 정의하는 클래스.<br>
 * [EN] <br>
 * [JP] <br>
 * 
 * @author UXIS
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAK009WorkConfirmSearch")
@ViewId(value = "WAK009")
public class WAK009WorkConfirmSearchController {

    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;
    
    /**
     * [KR] 업무분류 서비스 <br>     
     */
    @Autowired
    private WorkSortService workSortService;
    
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
     * [KR] 사업장관리 서비스 <br>          
     */
    @Autowired
    private PjtService pjtService;
    
    /**
     * [KR] 메뉴서비스 <br>     
     */
    @Autowired
    private MenuService menuService;
    
    /** */
    private final String MENU_CODE = "265";

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAK009WorkConfirmSearchController() {
        // no process
    }
    
    /**
     * 
     * 
     * @param request       HttpServletRequest
     * @param pjtDomain     PjtDomain
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAK009")
    @Token(save = true)
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("pjtDomain") PjtDomain pjtDomain) throws Exception {

        /**
         * <pre>
         * [KO] 업무승인 정보를 화면에 뿌려준다.<br>
         * [EN] <br>  
         * [JP] 
         * </pre>
         */

        ModelAndView mv = new ModelAndView();
        
      //로그인한 사원정보
        //String loginEmpNum = (String)request.getSession().getAttribute("logEmpNum");        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String empNumber = (String)request.getSession().getAttribute("logEmpNum");
        
        EmpDomain setEmp = new EmpDomain();
        setEmp.setEmpNumber(empNumber);
        EmpDomain getEmp = empService.searchByKey(setEmp);
        
        //조회하는 날짜가 없으면(첫 로딩시)
        if(pjtDomain.getStartDate() == null) {
            SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            String today = datafmt.format(calendar.getTime());
            pjtDomain.setStartDate(today);
            pjtDomain.setEndDate(today);
        }
        
        EmpDomain empDomain = new EmpDomain();
        empDomain.setEmpUse("Y");
//        empDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<EmpDomain> empList = empService.searchByCondition(empDomain);
        
        /*// 사업부 세션에 담는걸로 변경 - 180626 김용균대리님 요청
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setUseYn("Y");
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
        
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setUseYn("Y");
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
        */
//        UxisCmmUtil.getSessionCls(request, mv);
        UxisCmmUtil.getSessionLoc(request, mv);
        
        RelationTeamDomain teamDomain = new RelationTeamDomain();
        teamDomain.setUseYn("Y");
        teamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationTeamDomain> teamList = relationTeamService.searchByCondition(teamDomain);
        
        int count = 0;
        try {
            count = pjtService.searchCount(pjtDomain);
        } catch (Exception e) {
            System.out.println("조회할 데이터가 없습니다.");
        }
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("pjtCount", count);
        mv.addObject("paraEmp", getEmp);
        mv.addObject("empList", empList);
        mv.addObject("teamList", teamList);
        mv.addObject("startDate", pjtDomain.getStartDate());
        mv.addObject("endDate", pjtDomain.getEndDate());
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAK009WorkConfirmSearch.jsp");

        if(UxisUtil.isMobile(request)) {
            Map<String, Integer> menuMap = (Map)request.getSession().getAttribute("menuMap");
            
            mv.addObject("empName", UxisCmmUtil.getSessionData(request, "empName"));
            mv.addObject("menuList", menuService.getMenuList(menuMap));
            mv.setViewName(".tiles.page.WAK009M");
        } else {
            mv.setViewName(".tiles.page.WAK009");
        }
        return mv;
        
    }
    
    /**
     * 
     * 
     * @param request           HttpServletRequest
     * @param searchPjtDomain   PjtDomain
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAK009")
    @Token(save = true)
    public ModelAndView search(HttpServletRequest request, 
        @ModelAttribute("searchPjtDomain") PjtDomain searchPjtDomain) throws Exception {

        /**
         * <pre>
         * [KO] 업무승인 정보를 화면에 뿌려준다.<br>
         * [EN] <br>  
         * [JP] 
         * </pre>
         */
        //System.out.println("WAK009WorkConfirmSearch/search.do");
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");
        String teamCode = ServletRequestUtils.getStringParameter(request, "teamCode");
        
        String empNumber = (String)request.getSession().getAttribute("logEmpNum");
        
        EmpDomain setEmp = new EmpDomain();
        setEmp.setEmpNumber(searchPjtDomain.getEmpNumber());
        EmpDomain getEmp = empService.searchByKey(setEmp);
        
        EmpDomain empDomain = new EmpDomain();
        empDomain.setEmpUse("Y");
        empDomain.setClsCode(clsCode);
        empDomain.setLocCode(locCode);
        empDomain.setTeamCode(teamCode);
        empDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<EmpDomain> empList = empService.searchByCondition(empDomain);
        
        /*// 사업부 세션에 담는걸로 변경 - 180626 김용균대리님 요청
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setUseYn("Y");
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
        */
//        UxisCmmUtil.getSessionCls(request, mv);
        
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setUseYn("Y");
        locDomain.setClsCode(clsCode);
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
        
        RelationTeamDomain teamDomain = new RelationTeamDomain();
        teamDomain.setUseYn("Y");
        teamDomain.setClsCode(clsCode);
        teamDomain.setLocCode(locCode);
        teamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationTeamDomain> teamList = relationTeamService.searchByCondition(teamDomain);
        
        WorkSortDomain workSortDomain = new WorkSortDomain();
        workSortDomain.setAprvEmpNum(empNumber);
        List<WorkSortDomain> workList = workSortService.searchWorkConfirmList(workSortDomain);
        
        //System.out.println("pjtDomain.getEmpNumber()" + searchPjtDomain.getEmpNumber());
        List<PjtDomain> pjtList = new ArrayList<PjtDomain>();
        
        searchPjtDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());

        //searchPjtDomain.setAprvType("S"); //덴소 김용균 대리:승인여부 상관없이 보이기
        
        if(workList != null){
            for(WorkSortDomain work :workList) {
                searchPjtDomain.setWorkMCode(work.getWorkCode());
                pjtList.addAll(pjtService.searchByCondition(searchPjtDomain));
            }
            mv.addObject("pjtList", pjtList);
        }
        
        //System.out.println("pjtList:" + pjtList.size());
        
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("paraEmp", getEmp);
        mv.addObject("startDate", searchPjtDomain.getStartDate());
        mv.addObject("endDate", searchPjtDomain.getEndDate());
        mv.addObject("paraEmp", getEmp);
        mv.addObject("empList", empList);
        mv.addObject("locList", locList);
        mv.addObject("teamList", teamList);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAK009WorkConfirmSearch.jsp");
        if(UxisUtil.isMobile(request)) {
            Map<String, Integer> menuMap = (Map)request.getSession().getAttribute("menuMap");  
            mv.addObject("empName", UxisCmmUtil.getSessionData(request, "empName"));
            mv.addObject("menuList", menuService.getMenuList(menuMap));
            mv.setViewName(".tiles.page.WAK009M");
        } else {
            mv.setViewName(".tiles.page.WAK009");
        }
        return mv;
        
    }
    
    /**
     * [EN] Main processing<br>
     * [EN] Register to DB information you have modified the screen.<br>
     * [JP] メイン処理<br>
     * [JP] 画面で変更した情報をDBに登録します。<br>
     * 
     * @param pjtDomain PjtDomain
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ErrorBack(viewName = ".tiles.page.WAK009")
    @Token(check = false, save = true)
    public ModelAndView update(
        @ModelAttribute("pjtDomainForm") PjtDomain pjtDomain, 
        HttpServletRequest request) throws Exception {
        
        /**
         * <pre>
         * 1.[KO]업무승인 처리
         * </pre>
         */
        //System.out.println("WAK009WorkConfirmSearch/update.do");
        ModelAndView mv = new ModelAndView();
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        
        String logEmpNum = (String)request.getSession().getAttribute("logEmpNum");
        
        List<PjtDomain> pjtList = pjtDomain.getPjtList();
        
        if(pjtList != null) {
            WorkSortDomain workDomain = new WorkSortDomain();
            for(PjtDomain pjt: pjtList) {
                //승인이거나 반려일때
                if(pjt.getAprvType() != null){

                    //승인할 프로젝트의 업무분류 중의 승인관리자가 맞는지 확인
                    workDomain.setAprvEmpNum(logEmpNum);
                    //System.out.println("pjt.getWorkMCode():" + pjt.getWorkMCode());
                    workDomain.setWorkCode(pjt.getWorkMCode());
                    WorkSortDomain setWorkConfirmDomain = workSortService.searchWorkConfirm(workDomain);
                    if(setWorkConfirmDomain == null){
                        //권한이 없습니다.
                        throw new ApplicationException("DNKR-E2-0000");
                    }

                    pjt.setAprvEmpNum(logEmpNum);
                    pjtService.update(pjt);
                }
            }
        }
        
        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAK009WorkConfirmSearch.jsp");
        mv.setViewName("redirect:init.do");
        return mv;
        
    }
}
