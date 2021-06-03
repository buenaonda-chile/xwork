package com.globaldenso.dnkr.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.PjtService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.business.service.WorkSortService;
import com.globaldenso.dnkr.business.service.WorkStatsService;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.PjtDomain;

/**
 * [KO] 프로젝트 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls of project (WAK001).<br>
 * [JP] <br>
 * 
 * @author UXIS
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAK003PjtStatsSearch")
@ViewId(value = "WAK003")
public class WAK003PjtStatsSearchController {

    /**
     * [KR] 프로젝트관리 서비스 <br> 
     * [EN] Field of CommonCodeService.<br>
     * [JP] <br>    
     */
    @Autowired
    private PjtService pjtService;
    
    /**
     * [KR] 코드관리 서비스 <br> 
     * [EN] Field of CommonCodeService.<br>
     * [JP] <br>    
     */
    @Autowired
    private WorkSortService workSortService;
    
    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;
        
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
    private WorkStatsService workStatsService;


/**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAK003PjtStatsSearchController() {
        // no process
    }
    
    /**
     * 
     * 
     * @param request   HttpServletRequest
     * @param pjtDomain PjtDomain
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAK003")
    @Token(save = true)
    public ModelAndView init(HttpServletRequest request,
        @ModelAttribute("pjtDomain") PjtDomain pjtDomain) throws Exception {

        /**
         * <pre>
         * 1.[EN] Screen initialization processing.
         *   [EN]    I acquire Common code information and display it to a screen  
         *   [JP] 
         * </pre>
         */

        //System.out.println("WAK003PjtStatsSearch/init.do");
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String workType = ServletRequestUtils.getStringParameter(request, "workType");
        
        //System.out.println("tabId:" + tabId);
        PjtDomain setTeamPjt = new PjtDomain();
        if(pjtDomain.getStartDate() == null) {
            SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            String today = datafmt.format(calendar.getTime());
            pjtDomain.setStartDate(today);
            pjtDomain.setEndDate(today);
            setTeamPjt.setStartDate(today);
            setTeamPjt.setEndDate(today);
        } else {
            setTeamPjt.setStartDate(pjtDomain.getStartDate());
            setTeamPjt.setEndDate(pjtDomain.getEndDate());
        }
        
        //로그인한 사용자 정보조회
        String empNumber = (String)request.getSession().getAttribute("logEmpNum");
        String teamCode = (String)request.getSession().getAttribute("teamCode");
        //System.out.println("teamCode:" + teamCode);

        pjtDomain.setEmpNumber(empNumber);        
        pjtDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        
        List<PjtDomain> pjtList = null;
        try {
            if(workType != null) {
                if(workType.equals("L")) {
                    pjtList = workStatsService.searchByConditionForL(pjtDomain);
                } else if(workType.equals("M")) {
                    pjtList = workStatsService.searchByConditionForM(pjtDomain);
                } else if(workType.equals("S")) {
                    pjtList = workStatsService.searchByConditionForS(pjtDomain);
                } else if(workType.equals("REL_SYS")) {
                    pjtList = workStatsService.searchByConditionForRelSys(pjtDomain);
                }
            } else {
                pjtList = workStatsService.searchByConditionForL(pjtDomain);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("조회할 데이터가 없습니다.");
        }
        
        
        
        
      //같은팀 사용자리스트 조회
        EmpDomain setTeamEmp = new EmpDomain();
        setTeamEmp.setTeamCode(teamCode);
        List<EmpDomain> teamEmpList = empService.searchByCondition(setTeamEmp);
        List<String> empNumList = new ArrayList<String>();
        if(teamEmpList != null) {
            for(EmpDomain emp :teamEmpList) {
                empNumList.add(emp.getEmpNumber());
            }
        }

        setTeamPjt.setEmpNumList(empNumList);
        setTeamPjt.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<PjtDomain> teamPjtList = null;
        try {
            if(workType != null) {
                if(workType.equals("L")) {
                    teamPjtList = workStatsService.searchByConditionForTeamL(setTeamPjt);
                } else if(workType.equals("M")) {
                    teamPjtList = workStatsService.searchByConditionForTeamM(setTeamPjt);
                } else if(workType.equals("S")) {
                    teamPjtList = workStatsService.searchByConditionForTeamS(setTeamPjt);
                } else if(workType.equals("REL_SYS")) {
                    teamPjtList = workStatsService.searchByConditionForTeamRelSys(setTeamPjt);
                }
            } else {
                teamPjtList = workStatsService.searchByConditionForTeamL(setTeamPjt);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("조회할 데이터가 없습니다.");
        }
        
        mv.addObject("menu", menu);
        mv.addObject("pjtList", pjtList);
        mv.addObject("teamPjtList", teamPjtList);
        mv.addObject("tabId", tabId);
        mv.addObject("workType", workType);
        mv.addObject("url", "WAK003PjtStatsSearch.jsp");
        mv.setViewName(".tiles.page.WAK003");
        return mv;
    }
    
}
