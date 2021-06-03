package com.globaldenso.dnkr.presentation.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.AuthService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.domain.AuthDomain;

/**
 * [KR] 권한수정 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAD005AuthConfig")
@ViewId(value = "WAD005")
public class WAD005AuthConfigController{
    /**
     * [KR] 권한 서비스 <br>     
     */
    @Autowired
    private AuthService authService;
    
    /**
     * [KR] 메뉴서비스 <br>     
     */
    @Autowired
    private MenuService menuService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAD005AuthConfigController() {
        // no process
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // this will allow 500 size of array.
        dataBinder.setAutoGrowCollectionLimit(1024);
    }
    
    /**
     * [KR] <br>     
     * 
     * @param authDomain    AuthDomain
     * @param request       HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init(@ModelAttribute("authDomain") AuthDomain authDomain, HttpServletRequest request)  throws Exception {
        
        //System.out.println("AuthConfig/init.do");
        ModelAndView mv = new ModelAndView(); 
        
        String authCode = ServletRequestUtils.getStringParameter(request, "authCode");
        String researchCode = ServletRequestUtils.getStringParameter(request, "researchCode");
        
        AuthDomain searchdomain = new AuthDomain();
        AuthDomain resultdomain = new AuthDomain();
        searchdomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        searchdomain.setAuthCode(authCode);
        resultdomain = authService.searchByKey(searchdomain);
        
        AuthDomain domain = new AuthDomain();
        domain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());

        //검색에 사용될 권한리스트
        List<AuthDomain> authList = authService.searchByCondition(domain);

        if(researchCode != null){
            domain.setAuthCode(researchCode);
        } else {
            domain.setAuthCode(authCode);
        }

        //뎁스에 관련된 화면에 뿌려질 풀메뉴리스트 + 메뉴권한
        List<AuthDomain> menuList = authService.searchAuthDetail(domain);

        mv.addObject("authList", authList);
        mv.addObject("menuList", menuList);
        mv.addObject("authCode", authCode);
        mv.addObject("authName", resultdomain.getAuthName());
        mv.addObject("url", "WAD005AuthPopConfig.jsp");
        mv.setViewName(".tiles.page.WAD005");
        return mv;
        
    }
    
    /**
     * 
     * @param authDomain    AuthDomain
     * @param request       HttpServletRequest
     * @return  ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/authConfig", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView authConfig(HttpServletRequest request)  throws Exception {
    	//public ModelAndView authConfig(@ModelAttribute("authDomain") AuthDomain authDomain, HttpServletRequest request)  throws Exception {
        //System.out.println("authConfig/authConfig");
        String pAuthCode = ServletRequestUtils.getStringParameter(request, "authCode");
        int menuListCnt = ServletRequestUtils.getIntParameter(request, "menuListCnt", 0);
        ModelAndView mv = new ModelAndView();
        
        List<AuthDomain> authList = new ArrayList<AuthDomain>();
        String authCode = "";
        String menuCode = "";
        AuthDomain domain = null;
        int authNum = 0;
        if(menuListCnt > 0) {
        	for(int i = 0; i < menuListCnt; i++) {
        		authCode = ServletRequestUtils.getStringParameter(request, "authList["+i+"].authCode", null);
        		menuCode = ServletRequestUtils.getStringParameter(request, "authList["+i+"].menuCode", null);
        		authNum = ServletRequestUtils.getIntParameter(request, "authList["+i+"].authNum", 0);
        		
        		if(menuCode != null) {
	        		domain = new AuthDomain();
	        		domain.setAuthCode(authCode);
	        		domain.setMenuCode(menuCode);
	        		domain.setAuthNum(authNum);
	        		authList.add(domain);
        		}
        	}
        }

        if(!authList.isEmpty()){
            for(AuthDomain authTarget: authList){
                int detailCnt =  authService.searchAuthDetailCount(authTarget);
                if(detailCnt > 0){
                    //System.out.println("authTarget.authCode:" + authTarget.getAuthCode());
                    authService.updateDetail(authTarget);
                } else {
                    //System.out.println("authTarget.authCode:" + authTarget.getAuthCode());
                    authService.createDetail(authTarget);
                }
            }
        }

        mv.addObject("authCode", pAuthCode);
        mv.addObject("url", "WAD005AuthPopConfig.jsp");
        mv.setViewName("redirect:init.do");
        return mv;
    }
    
    /**
     * 
     * @param authDomain    AuthDomain
     * @param request       HttpServletRequest
     * @return  ModelAndView
     * @throws Exception 
     */
    /*@RequestMapping(value = "/authConfig", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView authConfig(@ModelAttribute("authDomain") AuthDomain authDomain, HttpServletRequest request)  throws Exception {
        //System.out.println("authConfig/authConfig");
        String authCode = ServletRequestUtils.getStringParameter(request, "authCode");
        ModelAndView mv = new ModelAndView();
        List<AuthDomain> authList = authDomain.getAuthList();

        if(!authList.isEmpty()){
            for(AuthDomain authTarget: authList){
                int detailCnt =  authService.searchAuthDetailCount(authTarget);
                if(detailCnt > 0){
                    //System.out.println("authTarget.authCode:" + authTarget.getAuthCode());
                    authService.updateDetail(authTarget);
                } else {
                    //System.out.println("authTarget.authCode:" + authTarget.getAuthCode());
                    authService.createDetail(authTarget);
                }
            }
        }

        mv.addObject("authCode", authCode);
        mv.addObject("url", "WAD005AuthPopConfig.jsp");
        mv.setViewName("redirect:init.do");
        return mv;
    }*/
}
