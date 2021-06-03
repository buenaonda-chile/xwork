package com.globaldenso.dnkr.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.message.MessageManager;
import com.globaldenso.ai.library.presentation.paging.utility.PagingUtility;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.LogService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.LogDomain;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAC016LogSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 로그관리 리스트 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAC016Log")
@ViewId(value = "WAC016")
public class WAC016LogController {

    /**
     * [KR] 로그관리 서비스 <br>     
     */
    @Autowired
    private LogService logService;
    
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
    
    /** */
    private final String MENU_CODE = "152";
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAC016LogController() {
        // no process
    }
    
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form   WAC016LogSearchForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST} )
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAC016LogSearchForm") WAC016LogSearchForm form)  throws Exception {

        String nameId = ServletRequestUtils.getStringParameter(request, "nameId");
        if(nameId == null){
            nameId = "empName";
        }

        if(nameId.equals("empId")){
            form.setEmpId(form.getSearchData());
            form.setEmpName("");
        }else{
            form.setEmpId("");
            form.setEmpName(form.getSearchData());
        }

        /**
         * <pre>
         * 1.[JP]
         *   [EN] Screen initialization processing.
         *   [EN]   I acquire Log information and display it to a screen 
         * </pre>
         */
        String startDate = ServletRequestUtils.getStringParameter(request, "startDate");
        String endDate = ServletRequestUtils.getStringParameter(request, "endDate");

        ModelAndView mv = new ModelAndView();

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
        if(form.getStartDate() == null) {
            SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            String today = datafmt.format(calendar.getTime());
            startDate = today;
            endDate = today;
            form.setStartDate(startDate);
            form.setEndDate(endDate);
        }
        
        EmpDomain empDomain = new EmpDomain();
        empDomain.setEmpUse("Y");
        List<EmpDomain> empList = empService.searchByCondition(empDomain);
      
        /*// 사업부  세션에 담는걸로 변경 - 180626 김용균대리님 요청
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
        
        //LogDomain criteria = new LogDomain();
        form.setCmcCode(DensoContext.get().getLocale().getLanguage());
        
        int count = 0;
        try{
            count = logService.searchCount(form);
        }catch (Exception e) {
            System.out.println("데이터가 없습니다.");
            e.printStackTrace();
        }
        List<LogDomain> logList = null;
        if(count > 0){
            PagingUtility.calcPaging(form, count);
            logList = logService.searchByConditionForPaging(form);
            if (logList.isEmpty()) {
                MessageManager.setError("SMPL-E8-0003", new Object[] {
                    MessageSources.getInstance().value("info.log")});
            }
        }
       
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("paraDomain", form);
        mv.addObject("empList", empList);
        mv.addObject("locList", locList);
        mv.addObject("teamList", teamList);
        mv.addObject("logList", logList);
        mv.addObject("tabId", tabId);
        mv.addObject("menu", menu);
        mv.addObject("startDate", startDate);
        mv.addObject("endDate", endDate);
        mv.addObject("url", "WAC016Log.jsp");
        mv.setViewName(".tiles.page.WAC016");
        return mv;   
    }
    
    /**
     * [KO] 로그 정보를 등록한다.<br>
     * [EN] I register and handle it.<br>
     * 
     * [JP] <br>
     * 
     * @param logDomain LogDomain
     * @param response HttpServletResponse
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ErrorBack(viewName = ".tiles.page.WAC016")
//    @Token(check = true, save = true)
    public ModelAndView create(
//            @ModelAttribute("WAC016LogCreateForm") @Validated WAC016LogCreateForm form) throws
            LogDomain logDomain, HttpServletResponse response) throws
            Exception {
        
        /**
         * <pre>
         *   [KO] 로그 정보 등록처리
         * 1.[EN] Log registration processing.
         *   [EN]   I register an Log with DB by input contents.
         * </pre>
         */

        ModelAndView mv = new ModelAndView();

        logService.create(logDomain);
        mv.setViewName("redirect:init.do");
        return mv;
    }
}
