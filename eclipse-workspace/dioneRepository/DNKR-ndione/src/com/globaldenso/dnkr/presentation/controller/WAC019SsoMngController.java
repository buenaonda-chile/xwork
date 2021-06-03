package com.globaldenso.dnkr.presentation.controller;

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

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.library.presentation.paging.utility.PagingUtility;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.LinkService;
import com.globaldenso.dnkr.domain.LinkDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAC019SsoManagementForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] SSO관리  컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAC019SsoManagement")
@ViewId(value = "WAC019")
public class WAC019SsoMngController {

    /** */
    private final String MENU_CODE = "741";
    
    /**
     * [KR] 링크 서비스 <br>     
     */
    @Autowired
    private LinkService linkService;
    

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAC019SsoMngController() {
        // no process
    }
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      WAC017LinkManagementForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @Token(save = true)
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAC019SsoManagementForm") WAC019SsoManagementForm form)  throws Exception {
        
    	System.out.println("WAC019SsoManagement");
        ModelAndView mv = new ModelAndView();
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        //System.out.println(form.getCompany()+ form.getpCompany());
        //form.setpInOutType("O");
        //form.setpUseTf("Y");
        int count = 0;
        try {
            count = linkService.searchCountSso(form);
        } catch (Exception e) {
            System.out.println("조회할 데이터가 없습니다.");
        }
        if(count > 0) {
            // paging process
            PagingUtility.calcPaging(form, count);
            List<LinkDomain> ssoList = linkService.searchByConditionForPagingSso(form);
            mv.addObject("ssoList", ssoList);
        }

        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("totCount", count);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAC019SsoManagement.jsp");
        mv.setViewName(".tiles.page.WAC019");
        return mv;
        
    }
  
   
    /**
     * [EN] Main processing.<br>
     * [EN] I register and handle it.<br>
     * 
     * [JP] メイン処理。<br>
     * [JP] 登録処理をします。<br>
     * 
     * @param form WAC017LinkManagementForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    
    @RequestMapping(value = "/create", method = { RequestMethod.GET, RequestMethod.POST })
    @ErrorBack(viewName = ".tiles.page.WAC019")
    //@Token(check = false, save = true)
    public ModelAndView create(
    		HttpServletRequest request,
    		 @ModelAttribute("WAC019SsoManagementForm") @Validated WAC019SsoManagementForm form) throws Exception {
         // Add main processin
        	
        /**
         * <pre>
         * 1.[EN] Employee registration processing.
         *   [EN]   I register an employee with DB by input contents.

         * </pre>
         */
    	  System.out.println("create");
        //세션 저장된 데이터 불러오기
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
        String empNumber        = (String)empJsonObj.get("uid");        //사용자 사번
        String empId        = (String)empJsonObj.get("empId");        //사용자 ID
        
        form.setCreateUser(empId);
        
        LinkDomain domain = new LinkDomain();
        if(form.getPopupYn() == null || form.getPopupYn() == "") {	//팝업유무
        	form.setPopupYn("N");
    	}
        if(form.getLoginYn() == null ||form.getLoginYn() == "") {	//자동로그인
        	form.setLoginYn("N");
    	}
        if(form.getSubYn() == null || form.getSubYn() == "") {	//협력업체 사용여부
        	form.setSubYn("N");
    	}
        if(form.getUseTf() == null || form.getUseTf() == "") {	//사용여부
        	form.setUseTf("N");
    	}
        if(form.getSsoTf() == null || form.getSsoTf() == "") {	//사용여부
        	form.setSsoTf("N");
    	}
    	domain.setSysSeq(form.getSysSeq());
    	domain.setpCompany(form.getiCompany());
    		
        int count = 0;
        try {
    		count = linkService.searchCountSso(domain);
    	}catch (ApplicationException e) {
            count = 0;
            e.printStackTrace();
        } 

    	if (count == 0){
    		linkService.createSso(form);
            //MessageManager.setInformation("SMPL-I0-0001", new Object[] { "employee Infomation."});
            
        }else{
            //MessageManager.setError("SMPL-E8-0004", new Object[] { ""});            
        }
    	
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:init.do");
/*
        if (count == 0){
    		int count2 = 0;
            try {
            	count2 = linkService.searchCountSso(form);
            } catch (Exception e) {
                System.out.println("조회할 데이터가 없습니다.");
            }
            if(count2 > 0) {
                // paging process
                PagingUtility.calcPaging(form, count2);
                List<LinkDomain> linkList = linkService.searchByConditionForPagingSso(form);
                mv.addObject("linkList", linkList);
            } 
        }  	
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("totCount", count);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAC019SsoManagement.jsp");
        mv.setViewName(".tiles.page.WAC019");
  */
        return mv;
    }

}
