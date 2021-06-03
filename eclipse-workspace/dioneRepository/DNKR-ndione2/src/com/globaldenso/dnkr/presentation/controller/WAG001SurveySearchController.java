package com.globaldenso.dnkr.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.business.service.SurveyService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.QuestionDomain;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;
import com.globaldenso.dnkr.domain.SurveyDomain;
import com.globaldenso.dnkr.domain.TargetDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAG001SurveySearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 설문관리 리스트 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAG001SurveySearch")
@ViewId(value = "WAG001")
public class WAG001SurveySearchController {
    /**
     * [KR] 설문조사 서비스 <br>     
     */
    @Autowired
    private SurveyService surveyService;
    
    /**
     * 
     */
    @Autowired
    private CodeService codeService;
    
    /**
     * 
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
    public WAG001SurveySearchController() {
        // no process
    }
    
    /**
     * <p>
     * [KR] <br>
     * </p>
     * 
     * @param request       HttpServletRequest
     * @param form          WAG001SurveySearchForm
     * @return              ModelAndView
     * @throws Exception     a
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAG001SurveySearchForm") WAG001SurveySearchForm form)  throws Exception {
        
        ModelAndView mv = new ModelAndView();   
        
        //세션 저장된 데이터 불러오기
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();

        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
        String teamCode         = (String)empJsonObj.get("teamCode");   //사용자 팀코드
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
        
        form.setCmcCode(DensoContext.get().getLocale().getLanguage());
        int count = 0;
        try{
            count = surveyService.searchCount(form);
        }catch(Exception e){
            e.getMessage();
        }
        
        if(count > 0){
            PagingUtility.calcPaging(form, count);
            
            List<SurveyDomain> surveyList = surveyService.searchByConditionForPaging(form);
            mv.addObject("surveyList", surveyList);
            mv.addObject("totCount", count);
        }
        SimpleDateFormat simpleYFormat = new SimpleDateFormat("YYYY");
        SimpleDateFormat simpleMFormat = new SimpleDateFormat("MM");
        SimpleDateFormat simpleDFormat = new SimpleDateFormat("dd");
        Calendar cal = Calendar.getInstance();
        String year = simpleYFormat.format(cal.getTime());
        String month = simpleMFormat.format(cal.getTime());
        String day = simpleDFormat.format(cal.getTime());
        
        if(form.getSrvCode() != null && !form.getSrvCode().equals("")){
        
            SurveyDomain sdomain = new SurveyDomain();
            try{
                sdomain = surveyService.view(form);
            }catch(Exception e){
                e.getMessage();
            }
            mv.addObject("sdomain", sdomain);
        }
        
        mv.addObject("sessionteamCode", teamCode);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("paging", form);
        mv.addObject("year", year);
        mv.addObject("month", month);
        mv.addObject("day", day);
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAG001SurveySearch.jsp");
        mv.setViewName(".tiles.page.WAG001");
        return mv;
        
    }
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param request       HttpServletRequest
     * @param form          WAG001SurveySearchForm
     * @return              ModelAndView
     * @throws Exception    
     */
    @RequestMapping(value = "/create", method = { RequestMethod.GET, RequestMethod.POST })
    @ErrorBack(viewName = ".tiles.page.WAG001")
    @Token(check = false, save = true)
    public ModelAndView create(HttpServletRequest request, 
        @ModelAttribute("WAG001SurveySearchForm") @Validated WAG001SurveySearchForm form)  throws Exception {

    	//세션 저장된 데이터 불러오기
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();

        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
        String teamCode         = (String)empJsonObj.get("teamCode");   //사용자 팀코드
        
        form.setTeamCode(teamCode);
        	System.out.println(teamCode);
    
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        
        ModelAndView mv = new ModelAndView(); 
        form.setSrvStart( createDateString( form.getStartY(), form.getStartM(), form.getStartD(), form.getStartH(), form.getStartI() ) );
        form.setSrvEnd( createDateString( form.getEndY(), form.getEndM(), form.getEndD(), form.getEndH(), form.getEndI() ) );
        
        try{
            CodeDomain langDomain = new CodeDomain();
            langDomain.setCmcParentCode(DnkrConstans.CMC_SUPER_LANG_CODE);
            List<CodeDomain> domainList = codeService.searchByCondition(langDomain);
            List<String> langList = new ArrayList<String>();
            if(! domainList.isEmpty()) {
                for(CodeDomain domain: domainList) {
                    langList.add(domain.getCmcCode());
                }
            }
            
            //설문 수정
            if(form.getSrvCode() != null){
                form.setCmcCode(DensoContext.get().getLocale().getLanguage());
                int result = surveyService.update(form);
                //System.out.println(result);
            }
            //설문 신규생성
            else{
                surveyService.create(form, langList);
            }
        }catch(Exception e){
            e.getMessage();
        }
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAG001SurveySearch.jsp");
        mv.setViewName("redirect:/WAG001SurveySearch/init.do");
        return mv;
        
    }
    
    /**
     * [KR] 삭제 
     * 
     * @param request       HttpServletRequest
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
    @ErrorBack(viewName = ".tiles.page.WAG001")
    public ModelAndView delete(HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView();

        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String srvCode = ServletRequestUtils.getStringParameter(request, "srvCode");

        QuestionDomain form = new QuestionDomain();
        form.setSrvCode(srvCode);
        int result = 0;
        try{
            result = surveyService.delete(form, "ALL");
        }catch(Exception e){
            e.getMessage();
        }
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAG001SurveySearch.jsp");
        mv.setViewName("redirect:/WAG001SurveySearch/init.do");
        return mv;
    }
    
    /**
     * [KR]수정
     * 
     * @param request   HttpServletRequest
     * @param form      SurveyDomain
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
    @ErrorBack(viewName = ".tiles.page.WAG001")
    public ModelAndView update(HttpServletRequest request, 
        @ModelAttribute("WAG001SurveyCreateForm") @Validated SurveyDomain form) throws Exception{
        ModelAndView mv = new ModelAndView();

        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        if(form.getSrvUse().equals("N") && form.getSrvUse() != null){
            form.setSrvUse("Y");
        }else{
            form.setSrvUse("N");
        }

        int result = 0;
        try{
            result = surveyService.srvUseUpdate(form);
        }catch(Exception e){
            e.getMessage();
        }
        
        mv.addObject("tabId", tabId);
        mv.addObject("menu", menu);
        mv.addObject("url", "WAG001SurveySearch.jsp");
        mv.setViewName("redirect:/WAG001SurveySearch/init.do");
        return mv;
    }
    
    /**
     * [KR]참여
     * 
     * @param request   HttpServletRequest
     * @param form      TargetDomain
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/participation", method = { RequestMethod.GET, RequestMethod.POST })
    @ErrorBack(viewName = ".tiles.page.WAG001")
    public ModelAndView participation(HttpServletRequest request, 
        @ModelAttribute("TargetDomainForm") TargetDomain form) throws Exception{
        ModelAndView mv = new ModelAndView();

        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        int count = 0;
        try{
            count = surveyService.searchTargetCount(form);
        }catch(Exception e){
            e.getMessage();
        }
        if(count > 0){
            PagingUtility.calcPaging(form, count);

            List<TargetDomain> surveyList = surveyService.searchByTargetPaging(form);
            mv.addObject("surveyList", surveyList);
            mv.addObject("totCount", count);
        }

        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        clsDomain.setUseYn("Y");
        List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
           
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        locDomain.setUseYn("Y");
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);

        RelationTeamDomain teamDomain = new RelationTeamDomain();
        teamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        teamDomain.setUseYn("Y");
        List<RelationTeamDomain> teamList = relationTeamService.searchByCondition(teamDomain);

        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("clsList", clsList);
        mv.addObject("locList", locList);
        mv.addObject("teamList", teamList);
        mv.addObject("tabId", tabId);
        mv.addObject("paraEmp", form);
        mv.addObject("menu", menu);
        mv.addObject("url", "WAG009SurveyParticipation.jsp");
        mv.setViewName(".tiles.page.WAG009");
        //mv.setViewName("redirect:/WAG001SurveySearch/init.do");
        return mv;
    }
    
    /**
     * [KR]String Type의 년, 월, 일, 시간, 분 값을 받아서 yyyy-MM-dd kk:mm:00 형식의 문자열로 만들어서 되돌려준다.
     * 
     * @param _year     String
     * @param _month    String
     * @param _day      String
     * @param _hour     String
     * @param _minute   String
     * @return          String  yyyy-MM-dd kk:mm:00 형식의 문자열
     */
    private String createDateString(String _year, String _month, String _day, String _hour, String _minute){
        StringBuffer bf = new StringBuffer();
        bf.append(_year).append("-").append(dateformat(_month)).append("-").append(dateformat(_day));
        bf.append(" ").append(dateformat(_hour)).append(":").append(dateformat(_minute)).append(":00");
        return bf.toString();
    }
    
    /**
     * [KR]String 문자열의 길이가 2보다 작을 경우 해당 문자열 앞에 '0'문자를 붙인 값을 되돌려준다.
     * 
     * @param target    String
     * @return          String
     */
    private String dateformat(String target){
        if(target.length() < 2){
            target = "0" + target;
        }
        return target;
    }
}
