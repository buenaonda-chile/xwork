package com.globaldenso.dnkr.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.SurveyService;
import com.globaldenso.dnkr.domain.QuestionDomain;
import com.globaldenso.dnkr.domain.TargetDomain;

/**
 * [KR] 설문조사 개인별결과 조회 페이지 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAG006SurveyPrivateSelect")
@ViewId(value = "WAG006")
public class WAG006SurveyPrivateSelectController {
    /**
     * [KR] 설문조사 서비스 <br>     
     */
    @Autowired
    private SurveyService surveyService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAG006SurveyPrivateSelectController() {
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
        ModelAndView mv = new ModelAndView();  

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String srvCode = ServletRequestUtils.getStringParameter(request, "srvCode");
        String qstCode = ServletRequestUtils.getStringParameter(request, "qstCode");
        String logEmpNum = ServletRequestUtils.getStringParameter(request, "empNumber");
         
        QuestionDomain form = new QuestionDomain();
        form.setCmcCode(DensoContext.get().getLocale().getLanguage());
        form.setSrvCode(srvCode);
        //해당 설문의 질문을 출력
        String aswTitle = "";
        String aswCode = "";
        if(qstCode != null && !qstCode.equals("")){
            QuestionDomain domain = new QuestionDomain();
            form.setQstCode(qstCode);
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
            TargetDomain target = new TargetDomain();
            target.setEmpNumber(logEmpNum);
            for(int i = 0; i < questionList.size(); i++){
                aswTitle = "";
                aswCode = "";
                String mulCheck = "";
                if(questionList.get(i).getQstType().equals("text")){
                    target.setQstCode(questionList.get(i).getQstCode());
                    questionList.get(i).setDrAnswer(surveyService.answerDesView(target));
                }

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

                            target.setAswCode(answerList.get(j).getAswCode());

                            String mulList = surveyService.answerTotalMulView(target);
                            if(mulList == null){
                                mulList = "0";
                            }
                            mulCheck += mulList + "|";
                        }
                    }
                    //qstCode 및 srvCode 에 해당하는 질문타이틀을 가져온다 끝!!
                }
                //타입이 text를 제외한 질문문항을 찾는다 끝!!

                questionList.get(i).setAswCode(aswCode);
                questionList.get(i).setAswTitle(aswTitle);
                questionList.get(i).setMulCheck(mulCheck);
            }
        }
         
        mv.addObject("questionList", questionList);
     
        mv.addObject("menu", menu);
        mv.addObject("srvCode", srvCode);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAG006SurveyPrivateSelect.jsp");
        mv.setViewName(".tiles.page.WAG006");
        return mv;
        
    }
}
