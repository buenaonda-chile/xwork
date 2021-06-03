package com.globaldenso.dnkr.presentation.controller;

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
import com.globaldenso.ai.library.presentation.paging.utility.PagingUtility;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAK005WorkSort_teamSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 업무분류 컨트롤러를 정의하는 클래스.<br>
 * [EN] <br>
 * [JP] <br>
 * 
 * @author UXIS
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAK005WorkSortSearch")
@ViewId(value = "WAK005")
public class WAK005WorkSortSearchController {

    /** */
    private final String MENU_CODE = "262";

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
    public WAK005WorkSortSearchController() {
        // no process
    }
    
    /**
     * 
     * 
     * @param request           HttpServletRequest
     * @param teamSearchForm    WAK005WorkSort_teamSearchForm
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAK005")
    @Token(save = true)
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("teamSearchForm") WAK005WorkSort_teamSearchForm teamSearchForm) throws Exception {

        /**
         * <pre>
         * [KO] 업무분류 관리할 팀리스트를 화면에 뿌려준다.<br>
         * [EN] <br>  
         * [JP] <br>
         * </pre>
         */

        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        
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
        
        int count = 0;
        
        try {
            count = relationTeamService.searchCount(teamDomain);
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
        }
        
        //System.out.println("count:" + count);
        if(count > 0) {
            // paging process
            teamSearchForm.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            teamSearchForm.setUseYn("Y");
            PagingUtility.calcPaging(teamSearchForm, count);
            List<RelationTeamDomain> mainTeamList = relationTeamService.searchByConditionForPaging(teamSearchForm);
            mv.addObject("mainTeamList", mainTeamList);
        }
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("totCount", count);
        mv.addObject("teamList", teamList);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAK005WorkSortSearch.jsp");
        mv.setViewName(".tiles.page.WAK005");
        return mv;
        
    }
    
    /**
     * 
     * 
     * @param request           HttpServletRequest
     * @param teamSearchForm    WAK005WorkSort_teamSearchForm
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAK005")
    @Token(save = true)
    public ModelAndView search(HttpServletRequest request, 
        @ModelAttribute("teamSearchForm") WAK005WorkSort_teamSearchForm teamSearchForm) throws Exception {

        /**
         * <pre>
         * [KO] 업무분류 관리할 팀리스트를 화면에 뿌려준다.<br>
         * [EN] <br>  
         * [JP] <br>
         * </pre>
         */

        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
//        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
//        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");
        
        /*// 사업부, 세션에 담는걸로 변경 - 180626 김용균대리님 요청
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        clsDomain.setUseYn("Y");
        List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
        */
//        UxisCmmUtil.getSessionCls(request, mv);
        
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        locDomain.setUseYn("Y");
        if(teamSearchForm.getClsCode() != null) {
            locDomain.setClsCode(teamSearchForm.getClsCode());
        }
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
        
        RelationTeamDomain teamDomain = new RelationTeamDomain();
        teamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        teamDomain.setUseYn("Y");
        if(teamSearchForm.getLocCode() != null) {
            teamDomain.setLocCode(teamSearchForm.getLocCode());
        }
        List<RelationTeamDomain> teamList = relationTeamService.searchByCondition(teamDomain);
        
        int count = 0;
        
        teamSearchForm.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        teamSearchForm.setUseYn("Y");

        try {
            count = relationTeamService.searchCount(teamSearchForm);
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
        }
        
        //System.out.println("count:" + count);
        if(count > 0) {
            // paging process
            PagingUtility.calcPaging(teamSearchForm, count);
            List<RelationTeamDomain> mainTeamList = relationTeamService.searchByConditionForPaging(teamSearchForm);
            mv.addObject("mainTeamList", mainTeamList);
        }
        
        
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("paraDomain", teamSearchForm);
        mv.addObject("totCount", count);
        mv.addObject("locList", locList);
        mv.addObject("teamList", teamList);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAK005WorkSortSearch.jsp");
        mv.setViewName(".tiles.page.WAK005");
        return mv;
        
    }
    
    /**
     * 
     * 
     * @param request       HttpServletRequest
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/workSortSearchPop", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAK005")
    @Token(save = true)
    public ModelAndView workSortSearchPop(HttpServletRequest request) throws Exception {

        /**
         * <pre>
         * [KO] 업무분류 정보를 화면에 뿌려준다.<br>
         * [EN] <br>  
         * [JP] <br>
         * </pre>
         */

        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String teamCode = ServletRequestUtils.getStringParameter(request, "teamCode");
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("teamCode", teamCode);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAK006WorkSortSearchPop.jsp");
        mv.setViewName(".tiles.page.WAK006");
        return mv;
        
    }
}
