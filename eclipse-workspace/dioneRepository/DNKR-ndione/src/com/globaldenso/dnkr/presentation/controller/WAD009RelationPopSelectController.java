package com.globaldenso.dnkr.presentation.controller;

import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 조직도 리스트 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAD009RelationPopSelect")
@ViewId(value = "WAD009")
public class WAD009RelationPopSelectController {
    /**
     * [KR] 조직도 서비스 <br>     
     */
    @Autowired
    private RelationClsService relationService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAD009RelationPopSelectController() {
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
    public ModelAndView init(HttpServletRequest request, HttpServletResponse response,
    		@CookieValue("locallocale") Optional<String> locale)  throws Exception {
    	localeSet(locale, request, response); //익명으로 설문참여시 언어셋팅
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAD009RelationPopSelect.jsp");
        mv.setViewName(".tiles.page.WAD009");
        return mv;
        
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
}
