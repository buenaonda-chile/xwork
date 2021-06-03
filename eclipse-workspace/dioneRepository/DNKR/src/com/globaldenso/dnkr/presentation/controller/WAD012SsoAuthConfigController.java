package com.globaldenso.dnkr.presentation.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
import com.globaldenso.dnkr.domain.SsoAuthDomain;

/**
 * [KR] 개인권한수정 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAD012SsoAuthConfig")
@ViewId(value = "WAD012")
public class WAD012SsoAuthConfigController {

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
    public WAD012SsoAuthConfigController() {
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
    @SuppressWarnings("unused")
	@RequestMapping(value = "/init", method = {RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAD012")
    /*public ModelAndView init(HttpServletRequest request)  throws Exception {*/
    public ModelAndView init(@ModelAttribute("SsoAuthDomain") SsoAuthDomain ssoAuthDomain, HttpServletRequest request)  throws Exception {
        
        ModelAndView mv = new ModelAndView(); 
        
        String empNumber = ServletRequestUtils.getStringParameter(request, "empNumber");
        String company = ServletRequestUtils.getStringParameter(request, "company");
        String changeCompany = ServletRequestUtils.getStringParameter(request, "changeCompany");
  
        EmpDomain setEmpDomain = new EmpDomain();
        setEmpDomain.setEmpNumber(empNumber);
        EmpDomain getEmpDomain = empService.searchByKey(setEmpDomain);
        //System.out.println("empNumber:" + empNumber+" empId:"+getEmpDomain.getEmpId());
        
        if(getEmpDomain == null) {
            MessageManager.setMessagelessFieldError("SsoAuthDomain", "empNumber", ssoAuthDomain.getEmpNumber());
            throw new ApplicationException("DNKR-E1-0003");
        }
        ssoAuthDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        //ssoAuthDomain.setSysType("WEB");	//WEB버전만 조회
        ssoAuthDomain.setInoutType("O"); //외부 SSO만 조회
        
        List<SsoAuthDomain> ssoAuthList = null;
        /*
        if(company != null){
            //System.out.println("if(researchCode != null){");
        	ssoAuthDomain.setCompany(company);
        }
        */
   	 	ssoAuthList = privateAuthService.searchByConditionSsoAuth(ssoAuthDomain);
         
        mv.addObject("ssoAuthList", ssoAuthList);
        mv.addObject("empNumber", empNumber);
        mv.addObject("empId", getEmpDomain.getEmpId());
        mv.addObject("empName", getEmpDomain.getEmpName());
        mv.addObject("changeCompany", changeCompany);
        mv.addObject("url", "WAD012SsoAuthPopConfig.jsp");
        mv.setViewName(".tiles.page.WAD012");
        return mv;
        
    }
    
    /**
     * 
     * @param privateAuthDomain PrivateAuthDomain
     * @param request           HttpServletRequest
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/SsoAuthConfig", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView authConfig(@ModelAttribute("SsoAuthDomain") SsoAuthDomain ssoAuthDomain, 
        HttpServletRequest request)  throws Exception {
        String empNumber = ServletRequestUtils.getStringParameter(request, "empNumber");
        ModelAndView mv = new ModelAndView();
        EmpDomain empDomain = new EmpDomain();
        empDomain.setEmpNumber(empNumber);

        EmpDomain getEmpDomain = empService.searchByKey(empDomain);
        if(getEmpDomain == null) {
            MessageManager.setMessagelessFieldError(
                    "SsoAuthDomain", "empNumber", ssoAuthDomain.getEmpNumber());
            throw new ApplicationException("DNKR-E1-0003");
        }

        List<SsoAuthDomain> ssoAuthList = ssoAuthDomain.getSsoAuthList();
        System.out.println("SsoAuthConfig");

        //세션 저장된 데이터 불러오기
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
        String empId        = (String)empJsonObj.get("empId");        //사용자 ID
        
        if(!ssoAuthList.isEmpty()){
            for(SsoAuthDomain ssoAuthTarget: ssoAuthList){
            	if(!ssoAuthTarget.getTempUseTf().equals(ssoAuthTarget.getUseTf())){
	            	System.out.println("ssoAuthTarget==="+ssoAuthTarget.getEmpNumber()+"=="+ssoAuthTarget.getSysSeq()+"=="+ssoAuthTarget.getUseTf());
	                ssoAuthTarget.setCreateUser(empId);
	                int detailCnt = 0;
	                try {
	                	detailCnt =  privateAuthService.searchCountSsoAuth(ssoAuthTarget);
	                } catch(Exception e) {
	                    e.printStackTrace();
	                }
	                System.out.println(detailCnt);
	                if(detailCnt > 0){
	                	privateAuthService.updateSsoAuth(ssoAuthTarget);
	                } else { 
	                	privateAuthService.createSsoAuth(ssoAuthTarget);
	                }
            	}
            }
        }

        mv.addObject("empNumber", empNumber);
        mv.addObject("url", "WAD012SsoAuthPopConfig.jsp");
        mv.setViewName("redirect:init.do");
        return mv;
    }
}
