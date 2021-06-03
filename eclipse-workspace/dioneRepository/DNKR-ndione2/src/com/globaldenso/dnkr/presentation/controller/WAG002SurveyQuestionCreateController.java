package com.globaldenso.dnkr.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.SurveyService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.QuestionDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 설문관리 질문생성 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAG002SurveyQuestionCreate")
@ViewId(value = "WAG002")
public class WAG002SurveyQuestionCreateController {
    /**
     * [KR] 설문조사 서비스 <br>     
     */
    @Autowired
    private SurveyService surveyService;
    
    /**
     * [KR] 코드 서비스<br>
     */
    @Autowired
    private CodeService codeService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAG002SurveyQuestionCreateController() {
        // no process
    }
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form   QuestionDomain
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request,
        @ModelAttribute("WAG002SurveyQuestionCreate") QuestionDomain form)  throws Exception {
        
        ModelAndView mv = new ModelAndView();  
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
        form.setCmcCode(DensoContext.get().getLocale().getLanguage());
        
        //해당 설문의 질문을 출력
        String aswTitle = "";
        String aswCode = "";
        
        if(form.getQstCode() != null && !form.getQstCode().equals("")){	//문항수정시
            QuestionDomain domain = new QuestionDomain();
            domain = surveyService.questionModi(form);

            List<QuestionDomain> answerModiList = new ArrayList<QuestionDomain>();
            answerModiList = surveyService.answerView(form);
            System.out.println(answerModiList.size());
            for(int i = 0; i < answerModiList.size(); i++){
                aswTitle += answerModiList.get(i).getAswTitle() + "|";
                aswCode += answerModiList.get(i).getAswCode() + "|";
            }
            domain.setAswCode(aswCode);
            domain.setAswTitle(aswTitle);
            mv.addObject("domain", domain);
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
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("questionList", questionList);
        mv.addObject("srvCode", form.getSrvCode());
        mv.addObject("tabId", tabId);
        mv.addObject("menu", menu);
        mv.addObject("url", "WAG002SurveyQuestionCreate.jsp");
        mv.setViewName(".tiles.page.WAG002");
        return mv;
        
    }
    
    /**
     * [KR] 생성
     * 
     * @param request       HttpServletRequest
     * @param form          QuestionDomain
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/create", method = { RequestMethod.GET, RequestMethod.POST })
    @ErrorBack(viewName = ".tiles.page.WAG001")
    @Token(check = false, save = true)
    public ModelAndView create(HttpServletRequest request, 
        @ModelAttribute("WAG002SurveyQuestionCreate") @Validated QuestionDomain form)  throws Exception {
        
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String[] aswTitle = ServletRequestUtils.getStringParameters(request, "answerTitle[]");

        ModelAndView mv = new ModelAndView();
        
        CodeDomain langDomain = new CodeDomain();
        langDomain.setCmcParentCode(DnkrConstans.CMC_SUPER_LANG_CODE);
        List<CodeDomain> domainList = codeService.searchByCondition(langDomain);
        List<String> langList = new ArrayList<String>();
        if(! domainList.isEmpty()) {
            for(CodeDomain domain: domainList) {
                langList.add(domain.getCmcCode());
            }
        }
        if(surveyService.questionCreate(form, langList, aswTitle) > 0){

        }
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("srvCode", form.getSrvCode());
        mv.addObject("url", "WAG002SurveyQuestionCreate.jsp");
        mv.setViewName("redirect:/WAG002SurveyQuestionCreate/init.do");
        return mv;
    }
    
}
