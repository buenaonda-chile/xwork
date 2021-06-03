package com.globaldenso.dnkr.presentation.controller;


import java.util.ArrayList;
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
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.message.MessageManager;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.AuthService;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.business.service.PrivateAuthService;
import com.globaldenso.dnkr.domain.AuthDomain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.PrivateAuthDomain;

/**
 * [KR] 개인권한수정 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAD006PrivateAuthConfig")
@ViewId(value = "WAD006")
public class WAD006PrivateAuthConfigController {

    /**
     * [KR] 사원정보 서비스 <br>     
     */
    @Autowired
    private EmpService empService;

    /**
     * [KR] 권한 서비스 <br>     
     */
    @Autowired
    private AuthService authService;
    
    /**
     * [KR] 개인권한 서비스 <br>     
     */
    @Autowired
    private PrivateAuthService privateAuthService;
    
    /**
     * [KR] 메뉴서비스 <br>     
     */
    @Autowired
    private MenuService menuService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAD006PrivateAuthConfigController() {
        // no process
    }
    /**
     * [KR] <br>     
     * 
     * @param privateAuthDomain PrivateAuthDomain
     * @param request           HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAJ001")
    /*public ModelAndView init(HttpServletRequest request)  throws Exception {*/
    public ModelAndView init(@ModelAttribute("privateAuthDomain") PrivateAuthDomain privateAuthDomain, HttpServletRequest request)  throws Exception {
        
        //System.out.println("PrivateAuthConfig/init.do");
        ModelAndView mv = new ModelAndView(); 
        
        String empNumber = ServletRequestUtils.getStringParameter(request, "empNumber");
        String researchCode = ServletRequestUtils.getStringParameter(request, "researchCode");
        String authCode = ServletRequestUtils.getStringParameter(request, "authCode");
        
        //System.out.println("empNumber:" + empNumber);
        EmpDomain setEmpDomain = new EmpDomain();
        setEmpDomain.setEmpNumber(empNumber);
        setEmpDomain.setAuthCode(authCode);
        EmpDomain getEmpDomain = empService.searchByKey(setEmpDomain);
        
        if(getEmpDomain == null) {
            MessageManager.setMessagelessFieldError("PrivateAuthDomain", "empNumber", privateAuthDomain.getEmpNumber());
            throw new ApplicationException("DNKR-E1-0003");
        }
        
        PrivateAuthDomain searchdomain = new PrivateAuthDomain();
        //PrivateAuthDomain resultdomain = new PrivateAuthDomain();
        searchdomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        privateAuthDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());

        List<PrivateAuthDomain> privateAuthList = null;

        AuthDomain authDomain = new AuthDomain();
        authDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());

        if(researchCode != null){
            //System.out.println("if(researchCode != null){");
            privateAuthDomain.setAuthCode(researchCode);
            privateAuthList = privateAuthService.searchAuthDetail(privateAuthDomain);
        }else {
            //System.out.println("else");
            privateAuthList = privateAuthService.searchByCondition(privateAuthDomain);
        }

        //검색에 사용될 권한리스트
        List<AuthDomain> authList = authService.searchByCondition(authDomain);

        mv.addObject("authList", authList);
        mv.addObject("privateAuthList", privateAuthList);
        mv.addObject("empNumber", empNumber);
        mv.addObject("empName", getEmpDomain.getEmpName());
        mv.addObject("url", "WAD006PrivateAuthPopConfig.jsp");
        mv.setViewName(".tiles.page.WAD006");
        return mv;
        
    }
    
    /**
     * [KO] 개인권한 등록하기
     * 
     * @param privateAuthDomain PrivateAuthDomain
     * @param request           HttpServletRequest
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/privateAuthConfig", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView authConfig(HttpServletRequest request)  throws Exception {
        String empNumber = ServletRequestUtils.getStringParameter(request, "empNumber");
        int menuListCnt = ServletRequestUtils.getIntParameter(request, "menuListCnt", 0);
        
        ModelAndView mv = new ModelAndView();
        
        EmpDomain empDomain = new EmpDomain();
        empDomain.setEmpNumber(empNumber);

        EmpDomain getEmpDomain = empService.searchByKey(empDomain);
        if(getEmpDomain == null) {
            MessageManager.setMessagelessFieldError(
                    "PrivateAuthDomain", "empNumber", empNumber);
            throw new ApplicationException("DNKR-E1-0003");
        }

        List<PrivateAuthDomain> privateAuthList = new ArrayList<PrivateAuthDomain>();
        String menuCode = "";
        int authNum = 0; 
        PrivateAuthDomain domain = null;
        
        if(menuListCnt > 0) {
        	for(int i = 0; i < menuListCnt; i++) {
        		menuCode = ServletRequestUtils.getStringParameter(request, "privateAuthList["+i+"].menuCode", null);
        		authNum = ServletRequestUtils.getIntParameter(request, "privateAuthList["+i+"].authNum", 0);
        		
        		if(menuCode != null) {
	        		domain = new PrivateAuthDomain();
	        		domain.setEmpNumber(empNumber);
	        		domain.setMenuCode(menuCode);
	        		domain.setAuthNum(authNum);
	        		privateAuthList.add(domain);
        		}
        	}
        }

        if(!privateAuthList.isEmpty()){
            for(PrivateAuthDomain privateAuthTarget: privateAuthList){
                int detailCnt = 0;
                try {
                    detailCnt =  privateAuthService.searchCount(privateAuthTarget);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                
                if(detailCnt > 0){
                    privateAuthService.update(privateAuthTarget);
                } else { 
                    privateAuthService.create(privateAuthTarget);
                }
            }
            empDomain.setEmpPrivateAuth("Y");
            empService.update(empDomain);
        }

        mv.addObject("empNumber", empNumber);
        mv.addObject("url", "WAD006PrivateAuthPopConfig.jsp");
        mv.setViewName("redirect:init.do");
        return mv;
    }
    /*@RequestMapping(value = "/privateAuthConfig", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView authConfig(@ModelAttribute("privateAuthDomain") PrivateAuthDomain privateAuthDomain, 
        HttpServletRequest request)  throws Exception {
        String empNumber = ServletRequestUtils.getStringParameter(request, "empNumber");
        ModelAndView mv = new ModelAndView();
        EmpDomain empDomain = new EmpDomain();
        empDomain.setEmpNumber(empNumber);

        EmpDomain getEmpDomain = empService.searchByKey(empDomain);
        if(getEmpDomain == null) {
            MessageManager.setMessagelessFieldError(
                    "PrivateAuthDomain", "empNumber", privateAuthDomain.getEmpNumber());
            throw new ApplicationException("DNKR-E1-0003");
        }

        List<PrivateAuthDomain> privateAuthList = privateAuthDomain.getPrivateAuthList();

        if(!privateAuthList.isEmpty()){
            for(PrivateAuthDomain privateAuthTarget: privateAuthList){
                int detailCnt = 0;
                try {
                    detailCnt =  privateAuthService.searchCount(privateAuthTarget);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                
                if(detailCnt > 0){
                    privateAuthService.update(privateAuthTarget);
                } else { 
                    privateAuthService.create(privateAuthTarget);
                }
            }
            empDomain.setEmpPrivateAuth("Y");
            empService.update(empDomain);
        }

        mv.addObject("empNumber", empNumber);
        mv.addObject("url", "WAD006PrivateAuthPopConfig.jsp");
        mv.setViewName("redirect:init.do");
        return mv;
    }*/
}
