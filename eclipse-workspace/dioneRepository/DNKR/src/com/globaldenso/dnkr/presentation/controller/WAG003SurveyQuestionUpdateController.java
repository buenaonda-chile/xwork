package com.globaldenso.dnkr.presentation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
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
import com.globaldenso.dnkr.business.service.SurveyService;
import com.globaldenso.dnkr.domain.QuestionDomain;

/**
 * [KR] 설문관리 질문 수정 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAG003SurveyQuestionUpdate")
@ViewId(value = "WAG003")
public class WAG003SurveyQuestionUpdateController {
    /**
     * [KR] 설문조사 서비스 <br>     
     */
    @Autowired
    private SurveyService surveyService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAG003SurveyQuestionUpdateController() {
        // no process
    }
    /**
     * [KR] <br>     
     * 
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request)  throws Exception {
        
        ModelAndView mv = new ModelAndView();     
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAG003SurveyQuestionUpdate.jsp");
        mv.setViewName(".tiles.page.WAG003");
        return mv;
        
    }
    
    /**
     * [KR]수정
     * 
     * @param request   HttpServletRequest
     * @param form      QuestionDomain
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
    @ErrorBack(viewName = ".tiles.page.WAG003")
    @Token(check = false, save = true)
    public ModelAndView create(HttpServletRequest request, 
        @ModelAttribute("WAG002SurveyQuestionCreate") @Validated QuestionDomain form)  throws Exception {
        
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String[] aswTitle = ServletRequestUtils.getStringParameters(request, "answerTitle[]");
        form.setCmcCode(DensoContext.get().getLocale().getLanguage());

        ModelAndView mv = new ModelAndView();
        
        int result = surveyService.questionUpdate(form, aswTitle);
        
        mv.addObject("menu", menu);
        mv.addObject("srvCode", form.getSrvCode());
        mv.addObject("url", "WAG002SurveyQuestionCreate.jsp");
        mv.setViewName("redirect:/WAG002SurveyQuestionCreate/init.do");
        return mv;
    }
    
    /**
     * [KR]삭제
     * 
     * @param request   HttpServletRequest
     * @param form      QuestionDomain
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
    @ErrorBack(viewName = ".tiles.page.WAG003")
    @Token(check = false, save = true)
    public ModelAndView delete(HttpServletRequest request, 
        @ModelAttribute("WAG002SurveyQuestionCreate") @Validated QuestionDomain form)  throws Exception {
        
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String mode = ServletRequestUtils.getStringParameter(request, "mode");
        
        ModelAndView mv = new ModelAndView();
        
        int result = surveyService.delete(form, mode); 
        
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("srvCode", form.getSrvCode());
        mv.addObject("url", "WAG002SurveyQuestionCreate.jsp");
        mv.setViewName("redirect:/WAG002SurveyQuestionCreate/init.do");
        return mv;
    }
    
    /**
     * 
     * 
     * @param request       HttpServletRequest
     * @param response      HttpServletResponse
     * @throws Exception 
     */
    @RequestMapping(value = "/prevData", method = { RequestMethod.GET, RequestMethod.POST })
    @Token(check = false, save = true)
    public void prevData(HttpServletRequest request, HttpServletResponse response)  throws Exception {
        String srvCode = ServletRequestUtils.getStringParameter(request, "srvCode");
        
        JSONObject jsonObj = new JSONObject();
        
        String maxSrvCode = surveyService.questionMaxCode();
        
        if(maxSrvCode == null){
            jsonObj.put("result", "작성된 설문이 없습니다.");
        }else if(maxSrvCode.equals(srvCode)){
            jsonObj.put("result", "현재작성된 문항이 이전문항입니다.");
        }else{
            boolean result = surveyService.questionPrev(srvCode, maxSrvCode);
            if(result){
                jsonObj.put("result", "이전의 문항을 불러왔습니다.");
            }else{
                jsonObj.put("result", "프로그램 오류입니다.");
            }
        }
        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
}
