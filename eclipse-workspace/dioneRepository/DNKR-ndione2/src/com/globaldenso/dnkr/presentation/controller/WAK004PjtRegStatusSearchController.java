package com.globaldenso.dnkr.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.business.service.PjtService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.PjtDomain;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KR] 로그관리 리스트 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAK004PjtRegStatusSearch")
@ViewId(value = "WAK004")
public class WAK004PjtRegStatusSearchController {

    /**
     * [KR] 프로젝트서비스 <br>     
     */
    @Autowired
    private PjtService pjtService;

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
     * [KR] 메뉴서비스 <br>     
     */
    @Autowired
    private MenuService menuService;
    
    /** */
    private final String MENU_CODE = "381";
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAK004PjtRegStatusSearchController() {
        // no process
    }
    
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request)  throws Exception {

        /**
         * <pre>
         * 1.[JP]
         *   [EN] Screen initialization processing.
         *   [EN]   I acquire Log information and display it to a screen 
         * </pre>
         */
        
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
        EmpDomain empDomain = new EmpDomain();
        empDomain.setEmpUse("Y");
        List<EmpDomain> empList = empService.searchByCondition(empDomain);
        
        if(empList.get(0).getAuthCode() != null){
        	String authCode = empList.get(0).getAuthCode();
        	empDomain.setAuthCode(authCode);
        	System.out.println(authCode);
        }
      
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setUseYn("Y");
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
      
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setUseYn("Y");
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
      
        RelationTeamDomain teamDomain = new RelationTeamDomain();
        teamDomain.setUseYn("Y");
        teamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationTeamDomain> teamList = relationTeamService.searchByCondition(teamDomain);
        
        PjtDomain pjtDomain = new PjtDomain();
        
        int count = 0;
        try{
            count = pjtService.searchCount(pjtDomain);
        }catch(Exception e) {
            System.out.println("데이터가 없습니다.");
        }
        
        SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        String today = datafmt.format(calendar.getTime());

//        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("searchDate", today);
        mv.addObject("pjtCount", count);
        mv.addObject("empList", empList);
        mv.addObject("clsList", clsList);
        mv.addObject("locList", locList);
        mv.addObject("teamList", teamList);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAK004PjtRegStatusSearch.jsp");
        
        if(UxisUtil.isMobile(request)) {
        	Map<String, Integer> menuMap = (Map)request.getSession().getAttribute("menuMap");
        	
        	mv.addObject("empName", UxisCmmUtil.getSessionData(request, "empName"));
            mv.addObject("menuList", menuService.getMenuList(menuMap));
            mv.setViewName(".tiles.page.WAK004M");
        } else {
        	mv.setViewName(".tiles.page.WAK004");
        }
        return mv;   
    }
    
    /**
     * [KR] <br>     
     * 
     * @param request       HttpServletRequest
     * @param empDomain     EmpDomain
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView research(HttpServletRequest request, 
        @ModelAttribute("empDomain") EmpDomain empDomain)  throws Exception {

        /**
         * <pre>
         * 1.[JP]
         *   [EN] Screen initialization processing.
         *   [EN]   I acquire Log information and display it to a screen 
         * </pre>
         */
        
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String searchDate = ServletRequestUtils.getStringParameter(request, "searchDate");
        
        String teamCode = (String)request.getSession().getAttribute("teamCode");
        List<EmpDomain> empList = null;
        if(teamCode != null) {
            empDomain.setTeamCode(teamCode);
            empList = empService.searchByCondition(empDomain);
        }
        
        List<PjtDomain> pjtList = new ArrayList<PjtDomain>();
        PjtDomain pjtDomain = new PjtDomain();
        if(searchDate != null & !Strings.isEmpty(searchDate)){
            pjtDomain.setWorkDate(searchDate);
        } else {
            SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            String today = datafmt.format(calendar.getTime());
            pjtDomain.setWorkDate(today);
        }
        
        if (empList != null) {
            for (EmpDomain emp : empList) {
                //System.out.println(emp.getEmpNumber());
                pjtDomain.setEmpNumber(emp.getEmpNumber());
                pjtList.addAll(pjtService.searchPjtRegStatus(pjtDomain));
            }
        } else {
            System.out.println("사원이 없습니다.");
        }
       /* 
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
      
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
      
        RelationTeamDomain teamDomain = new RelationTeamDomain();
        teamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationTeamDomain> teamList = relationTeamService.searchByCondition(teamDomain);
    */
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("pjtList", pjtList);
//        mv.addObject("clsList", clsList);
//        mv.addObject("locList", locList);
//        mv.addObject("teamList", teamList);
//        mv.addObject("empDomain", empDomain);
        mv.addObject("searchDate", searchDate);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAK004PjtRegStatusSearch.jsp");
        if(UxisUtil.isMobile(request)) {
        	Map<String, Integer> menuMap = (Map)request.getSession().getAttribute("menuMap");
        	
        	mv.addObject("empName", UxisCmmUtil.getSessionData(request, "empName"));
            mv.addObject("menuList", menuService.getMenuList(menuMap));
            mv.setViewName(".tiles.page.WAK004M");
        } else {
        	mv.setViewName(".tiles.page.WAK004");
        }
        return mv;   
    }
    
}
