package com.globaldenso.dnkr.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.library.presentation.paging.utility.PagingUtility;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.business.service.SurveyService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.QuestionDomain;
import com.globaldenso.dnkr.domain.SurveyDomain;
import com.globaldenso.dnkr.domain.TargetDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAG001SurveySearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KR] 설문 진행 페이지 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAG005SurveyPaper")
@ViewId(value = "WAG005")
public class WAG005SurveyPaperController {
    /**
     * [KR] 설문조사 서비스 <br>     
     */
    @Autowired
    private SurveyService surveyService;
    
    /**
     * [KR] 메뉴서비스 <br>     
     */
    @Autowired
    private MenuService menuService;    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAG005SurveyPaperController() {
        // no process
    }
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      WAG001SurveySearchForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAG001SurveySearchForm") WAG001SurveySearchForm form)  throws Exception {
        
        ModelAndView mv = new ModelAndView();  
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        form.setCmcCode(DensoContext.get().getLocale().getLanguage());
        String logEmpNum = (String)request.getSession().getAttribute("logEmpNum");
        form.setEmpNumber(logEmpNum);
        form.setSrvUse("Y");
        int count = 0;
      
        if(form.getStartY() != null){
            form.setSrvStart( createDateString( form.getStartY(), form.getStartM(), form.getStartD()/*, form.getStartH(), form.getStartI()*/ ) );
            form.setSrvEnd( createDateString( form.getEndY(), form.getEndM(), form.getEndD()/*, form.getEndH(), form.getEndI()*/ ) );
        }
        
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
    
        mv.addObject("year", year);
        mv.addObject("month", month);
        mv.addObject("day", day);

        mv.addObject("form", form);
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAG005SurveyPaper.jsp");
        if(UxisUtil.isMobile(request)) {
        	Map<String, Integer> menuMap = (Map)request.getSession().getAttribute("menuMap");
        	
        	mv.addObject("empName", UxisCmmUtil.getSessionData(request, "empName"));
            mv.addObject("menuList", menuService.getMenuList(menuMap));
            mv.setViewName(".tiles.page.WAG005M");
        } else {
            mv.setViewName(".tiles.page.WAG005");
        }
        return mv;
        
    }
    
    /**
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param locale Optional
     * @param form QuestionDomain
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/paperView", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView papgerView(HttpServletRequest request, HttpServletResponse response, 
    		@CookieValue("locallocale") Optional<String> locale,  @ModelAttribute("WAG002SurveyQuestionCreate") QuestionDomain form)  throws Exception {
    	
    	localeSet(locale, request, response); //익명으로 설문참여시 언어셋팅
    	
        ModelAndView mv = new ModelAndView();  

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");

        form.setCmcCode(DensoContext.get().getLocale().getLanguage());
        //해당 설문의 질문을 출력
        String aswTitle = "";
        String aswCode = "";
        if(form.getQstCode() != null && !form.getQstCode().equals("")){
            QuestionDomain domain = new QuestionDomain();
            domain = surveyService.questionModi(form);

            List<QuestionDomain> answerModiList = new ArrayList<QuestionDomain>();
            answerModiList = surveyService.answerView(form);
            for(int i = 0; i < answerModiList.size(); i++){
                aswTitle += answerModiList.get(i).getAswTitle() + "|";
                aswCode += answerModiList.get(i).getAswCode() + "|";
            }
            domain.setAswCode(aswCode);
            domain.setAswTitle(aswTitle);
            mv.addObject("domain", domain);
        }
           
        SurveyDomain surDomain = new SurveyDomain();
        surDomain.setCmcCode(form.getCmcCode());
        surDomain.setSrvCode(form.getSrvCode());
        SurveyDomain surveyDomain = surveyService.view(surDomain);
        
        //미사용 설문지체크
        if(surveyDomain.getSrvUse() != null && surveyDomain.getSrvUse().equals(DnkrConstans.RESULT_N)) {
            if(request.getSession().getAttribute("logEmpNum") == null) {
                mv.setViewName("redirect:main.do");
            } else {
                mv.setViewName("redirect:init.do");
            }
            return mv;
        }
        
        mv.addObject("surveyDomain", surveyDomain);
        mv.addObject("isAnonymous", surveyDomain.getSrvAnonymous());
        mv.addObject("SELECT_TEAM_TITLE", DnkrConstans.SURVEY_SELECT_TEAM_QST);
        
        //익명 설문지가 아니고 로그인정보가 없을때
    	if(! surveyDomain.getSrvAnonymous().equals(DnkrConstans.RESULT_Y) && request.getSession().getAttribute("logEmpNum") == null) {
            mv.setViewName("redirect:login.do");
            return mv;
    	}
        
        
        List<QuestionDomain> questionList = surveyService.questionView(form);
        if(questionList != null && questionList.size() > 0){
            for(int i = 0; i < questionList.size(); i++){
                aswTitle = "";
                aswCode = "";
                //타입이 text를 제외한 질문문항을 찾는다
                if(!questionList.get(i).getQstType().equals("text")){
                    form.setQstCode(questionList.get(i).getQstCode());
                    List<QuestionDomain> answerList = new ArrayList<QuestionDomain>();
                    answerList = surveyService.answerView(form);
                    //qstCode 및 srvCode 에 해당하는 질문타이틀을 가져온다
                    if(answerList != null && answerList.size() > 0){
                        for(int j = 0; j < answerList.size(); j++){
                            aswTitle += answerList.get(j).getAswTitle() + "|";
                            aswCode += answerList.get(j).getAswCode() + "|";
                        }
                    }
                    //qstCode 및 srvCode 에 해당하는 질문타이틀을 가져온다 끝!!
                }
                //타입이 text를 제외한 질문문항을 찾는다 끝!!

                questionList.get(i).setAswCode(aswCode);
                questionList.get(i).setAswTitle(aswTitle);
            }
        }
        mv.addObject("questionList", questionList);
       
        mv.addObject("menu", menu);
        mv.addObject("srvCode", form.getSrvCode());
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAG008SurveyPaperView.jsp");
        if(UxisUtil.isMobile(request)) {
        	Map<String, Integer> menuMap = (Map)request.getSession().getAttribute("menuMap");
        	
        	mv.addObject("empName", UxisCmmUtil.getSessionData(request, "empName"));
            mv.addObject("menuList", menuService.getMenuList(menuMap));
            mv.setViewName(".tiles.page.WAG008M");
        } else {
            mv.setViewName(".tiles.page.WAG008");
        }
        return mv;
    }
    
    /**
     *
     * 
     * @param request   HttpServletRequest
     * @param response   HttpServletResponse
     * @param locale   String
     * @param form      TargetDomain
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/create", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView create(HttpServletRequest request, HttpServletResponse response,
    		@CookieValue("locallocale") Optional<String> locale, @ModelAttribute("WAG008SurveyPaperViewForm") TargetDomain form)  throws Exception {
        
    	localeSet(locale, request, response); //익명으로 설문참여시 언어셋팅
    	
        ModelAndView mv = new ModelAndView();  
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String[] drAns = ServletRequestUtils.getStringParameters(request, "drAns[]");
        String[] drQstCode = ServletRequestUtils.getStringParameters(request, "drQstCode[]");
        
        SurveyDomain surDomain = new SurveyDomain();
        surDomain.setCmcCode(DensoContext.get().getLocale().getLanguage());
        surDomain.setSrvCode(form.getSrvCode());
        SurveyDomain surveyDomain = surveyService.view(surDomain);
        //System.out.println(surveyDomain.getSrvAnonymous());
        if(surveyDomain.getSrvAnonymous().equals(DnkrConstans.RESULT_Y)) {
            form.setEmpNumber(getMaxAnonyEmpNum(surveyDomain.getSrvCode())); //Anonimous
            mv.setViewName("redirect:/main.do");
        } else {
            String logEmpNum = (String)request.getSession().getAttribute("logEmpNum");
            form.setEmpNumber(logEmpNum);
            mv.setViewName("redirect:init.do");
        }
        
        String[] qstCodeStrArray = ServletRequestUtils.getStringParameters(request, "qstCodeStr[]");
        int result = 0;
        
        for(int i = 0; i < qstCodeStrArray.length; i++){
            String[] aswList = ServletRequestUtils.getStringParameters(request, "asw_" + qstCodeStrArray[i]);

            for(String asw2 : aswList){
                String[] aswList2 = asw2.split("§");
                form.setQstCode(aswList2[0]);
                form.setAswCode(aswList2[1]);
                result = surveyService.targetMulCreate(form);
            }
        }
        
        if(drQstCode != null && drAns != null){
            for(int i = 0; i < drQstCode.length; i++){
                form.setQstCode(drQstCode[i]);
                form.setDrAnswer(drAns[i]);
                result = surveyService.targetDesCreate(form);
            }
        }
        
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAG008SurveyPaperView_End.jsp");
        mv.setViewName(".tiles.page.WAG999");
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
    private String createDateString(String _year, String _month, String _day){
        StringBuffer bf = new StringBuffer();
        bf.append(_year).append("-").append(dateformat(_month)).append("-").append(dateformat(_day));
        /*bf.append(" ").append(dateformat(_hour)).append(":").append(dateformat(_minute)).append(":00");*/
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
    
    /**
     * [KO] 로그인 과정 없이 다이렉트로 설문참여시 언어 셋팅
     * 
     * @param locale Optional
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    private void localeSet(Optional<String> locale , HttpServletRequest request, HttpServletResponse response) {
    	Locale newLocale;
        String paraLocale = request.getParameter("locale");
    	try{
            if (paraLocale == null) {
                if((locale.orElse(DensoContext.get().getLocale().getLanguage())) != null 
                    && (locale.orElse(DensoContext.get().getLocale().getLanguage())).equals("ko")){
                    newLocale = new Locale("kr");
                    paraLocale = "kr";
                }else {
                    newLocale = new Locale(locale.orElse(DensoContext.get().getLocale().getLanguage()));
                    paraLocale = locale.orElse(DensoContext.get().getLocale().getLanguage());
                }
            } else {
                newLocale = new Locale(paraLocale);
            }
            DensoContext.get().setLocale(newLocale);
        }catch(Exception e){
            newLocale = new Locale("kr");
        }

        DensoContext.get().setLocale(newLocale);
        
        //세션이 있으면 쿠키굽기
        HttpSession session = request.getSession(false);
        if (session != null) {
//        System.out.println("cookie 굽기 : " + paraLocale);
            response.addCookie(UxisCmmUtil.makeCookie(request, "locallocale", paraLocale));
        }
    }
    
    /**
     * [KO] 익명성 설문조사시 사번에 들어갈 maxNum
     * 
     * @param srvCode String
     * @return String
     * @throws Exception Exception
     */
    private String getMaxAnonyEmpNum(String srvCode) throws Exception {
    	TargetDomain domain = new TargetDomain();
    	String maxAnonyEmpNum = surveyService.searchMaxAnonyEmpNum(domain);
        if( maxAnonyEmpNum == null) {
            return "AN00000001";
        } else {
            return maxAnonyEmpNum;
        }
    }
    
}
