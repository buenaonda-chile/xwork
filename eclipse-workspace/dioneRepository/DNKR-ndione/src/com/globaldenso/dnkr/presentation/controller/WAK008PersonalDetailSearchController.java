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
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 개인별 업무 상세 통계 컨트롤러를 정의하는 클래스.<br>
 * [EN] <br>
 * [JP] <br>
 * 
 * @author UXIS
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAK008PersonalDetailSearch")
@ViewId(value = "WAK008")
public class WAK008PersonalDetailSearchController {

    /**
     * [KR] 프로젝트관리 서비스 <br> 
     * [EN] Field of CommonCodeService.<br>
     * [JP] <br>    
     */
    @Autowired
    private PjtService pjtService;
    
    /**
     * [KR] 업무분류 서비스 <br> 
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
    
    /** */
    private final String MENU_CODE = "264";

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAK008PersonalDetailSearchController() {
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
    @ErrorBack(viewName = ".tiles.page.WAK008")
    @Token(save = true)
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("pjtDomain") PjtDomain pjtDomain) throws Exception {

        /**
         * <pre>
         * [KO] 개인별 업무 상세 정보를 화면에 뿌려준다.<br>
         * [EN] <br>  
         * [JP] 
         * </pre>
         */

        //System.out.println("WAK008PersonalDetailSearch/init.do");
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String workType = ServletRequestUtils.getStringParameter(request, "workType");
        
        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");
        //로그인한 사원정보
        String loginEmpNum = (String)request.getSession().getAttribute("logEmpNum");
        String teamCode = (String)request.getSession().getAttribute("teamCode");

        //조회하는 날짜가 없으면(첫 로딩시)
        if(pjtDomain.getStartDate() == null) {
            SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            String today = datafmt.format(calendar.getTime());
            pjtDomain.setStartDate(today);
            pjtDomain.setEndDate(today);
        }
        
        //조회하는 사원정보
        EmpDomain setEmp = new EmpDomain(); //조회하는 사원의 정보를 조회하기 위한 도메인
        setEmp.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        EmpDomain getEmp = null;    //조회하는 사원의 정보도메인
        
        //팀조회용 도메인
        EmpDomain empDomain = new EmpDomain();
        empDomain.setEmpUse("Y");
        //조회하는 사원정보가 있으면
        
        List<EmpDomain> empList = new ArrayList<EmpDomain>();
        
        if(pjtDomain.getEmpNumber() != null && ! pjtDomain.getEmpNumber().equals("")){
            setEmp.setEmpNumber(pjtDomain.getEmpNumber());
            getEmp = empService.searchByKey(setEmp);
            empDomain.setTeamCode(getEmp.getTeamCode());
            pjtDomain.setEmpNumber(pjtDomain.getEmpNumber());
            empList = empService.searchByCondition(empDomain);
        
        //조회하는 사원정보가 없으면(첫 로딩시)
        } else {
            setEmp.setEmpNumber(loginEmpNum);
            getEmp = empService.searchByKey(setEmp);
            pjtDomain.setEmpNumber(loginEmpNum);
            if (teamCode != null) {
                empDomain.setTeamCode(teamCode);
                empList = empService.searchByCondition(empDomain);
            } else {
                empList.add(getEmp);
            }
        } 

        /*// 사업부  세션에 담는걸로 변경 - 180626 김용균대리님 요청
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
        
        //로그인된 사원의 팀코드가 있고 팀코드가 조회하는 팀과 같을 때 
        if ((teamCode != null && empDomain.getTeamCode() != null && teamCode.equals(empDomain.getTeamCode())) || loginEmpNum.equals("Admin")) {

            PjtDomain setTeamPjt = new PjtDomain();

            //조회하는 날짜가 없으면(첫 로딩시)
            if(pjtDomain.getStartDate() == null) {
                SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                String today = datafmt.format(calendar.getTime());
                pjtDomain.setStartDate(today);
                pjtDomain.setEndDate(today);
                setTeamPjt.setStartDate(today);
                setTeamPjt.setEndDate(today);

            //조회하는 날짜가 있으면
            } else {
                setTeamPjt.setStartDate(pjtDomain.getStartDate());
                setTeamPjt.setEndDate(pjtDomain.getEndDate());
            }

            pjtDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());

            List<PjtDomain> pjtList = null;
            try {
                if(workType != null) {
                    if(workType.equals("L")) {
                        //System.out.println("L");
                        pjtList = workStatsService.searchByConditionForL(pjtDomain);
                    } else if(workType.equals("M")) {
                        //System.out.println("M");
                        pjtList = workStatsService.searchByConditionForM(pjtDomain);
                    } else if(workType.equals("S")) {
                        //System.out.println("S");
                        pjtList = workStatsService.searchByConditionForS(pjtDomain);
                    } else if(workType.equals("REL_SYS")) {
                        //System.out.println("REL_SYS");
                        pjtList = workStatsService.searchByConditionForRelSys(pjtDomain);
                    }
                } else {
                    //System.out.println("O");
                    pjtList = workStatsService.searchByConditionForL(pjtDomain);
                }
                mv.addObject("pjtList", pjtList);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("조회할 데이터가 없습니다.");
            }

            //같은팀 사용자리스트 조회
            List<String> empNumList = new ArrayList<String>();
            if(empList != null) {
                for(EmpDomain emp :empList) {
                    empNumList.add(emp.getEmpNumber());
                }

                setTeamPjt.setEmpNumList(empNumList);
                setTeamPjt.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
                List<PjtDomain> teamPjtList = null;
                try {
                    if(workType != null) {
                        if(workType.equals("L")) {
                            //System.out.println("L");
                            teamPjtList = workStatsService.searchByConditionForTeamL(setTeamPjt);
                        } else if(workType.equals("M")) {
                            //System.out.println("M");
                            teamPjtList = workStatsService.searchByConditionForTeamM(setTeamPjt);
                        } else if(workType.equals("S")) {
                            //System.out.println("S");
                            teamPjtList = workStatsService.searchByConditionForTeamS(setTeamPjt);
                        } else if(workType.equals("REL_SYS")) {
                            //System.out.println("REL_SYS");
                            teamPjtList = workStatsService.searchByConditionForTeamRelSys(setTeamPjt);
                        }
                    } else {
                        //System.out.println("O");
                        teamPjtList = workStatsService.searchByConditionForL(pjtDomain);
                    }
                } catch (Exception e) { 
//                    e.printStackTrace();
                    System.out.println("조회할 데이터가 없습니다.");
                }
                mv.addObject("teamPjtList", teamPjtList);
            }
        } else {
            System.out.println("같은팀이 아닙니다.");
            mv.addObject("teamCheck", true);
        }
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("empList", empList);
        mv.addObject("locList", locList);
        mv.addObject("teamList", teamList);
        mv.addObject("workType", workType);
        mv.addObject("startDate", pjtDomain.getStartDate());
        mv.addObject("endDate", pjtDomain.getEndDate());
        mv.addObject("paraEmpDomain", getEmp);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAK008PersonalDetailSearch.jsp");
        mv.setViewName(".tiles.page.WAK008");
        return mv;
        
    }
}
