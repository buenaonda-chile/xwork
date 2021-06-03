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

import com.globaldenso.ai.library.presentation.paging.utility.PagingUtility;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.LinkService;
import com.globaldenso.dnkr.domain.LinkDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAC020SsoSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] SSO조회  컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAC020SsoSearch")
@ViewId(value = "WAC020")
public class WAC020SsoSearchController {

    /** */
    private final String MENU_CODE = "761";
    
    /**
     * [KR] 링크 서비스 <br>     
     */
    @Autowired
    private LinkService linkService;
    

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAC020SsoSearchController() {
        // no process
    }
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      WAC020SsoSearchForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @Token(save = true)
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAC020SsoSearchForm") WAC020SsoSearchForm form)  throws Exception {
        
        //System.out.println("WAC020SsoSearchController SsolinkPageInit");
       
        ModelAndView mv = new ModelAndView();
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String pType= ""; 
        
        //세션 저장된 데이터 불러오기
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
   		String empNo 		= (String)empJsonObj.get("uid"); //사용자명
        String empId       	= (String)empJsonObj.get("empId");        //사용자ID
        String clsCode       = (String)empJsonObj.get("clsCode");        //사용자 사업부코드
        String locCode       = (String)empJsonObj.get("locCode");        //사용자 공장코드
     
        System.out.println(empInfo);   
        //EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
     	/*
        if(empId.substring(0,1).equals("E")){
        	pType="PE";
        }else{
        	pType="PS";
        }
       */
        form.setpCompany(clsCode);	//디폴트 : 사업부코드
        form.setType("SsolinkPageInit"); //임시사용  : SSO사이트조회와 SSO사이트관리메뉴 구분을 위해 사용
       /*
        if(empId.equals("E110290") || empId.equals("E030191") || empId.equals("E150046")){
            form.setpCompany("");	//TEST용
        }
        */
        if(empNo.equals("110290") || empNo.equals("030191") || empNo.equals("150046")|| empNo.equals("HELPDESK")){
            form.setpCompany("");	//TEST용
        }
        form.setpUseTf("Y");	//사용여부
        form.setpInOutType("O");	//2019.03.22추가
        //System.out.println("linkPage"+"=="+clsCode);
     
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
        mv.addObject("url", "WAC020SsoSearch.jsp");
        mv.setViewName(".tiles.page.WAC020");
        return mv;
        
    }
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      WAC020SsoSearchForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    @Token(save = true)
    public ModelAndView search(HttpServletRequest request, 
        @ModelAttribute("WAC020SsoSearchForm") WAC020SsoSearchForm form)  throws Exception {
        
        //System.out.println("WAC020SsoSearchController SsolinkPageSearch");
        //String pType= (String) request.getParameter("pType");
        //System.out.println("linkPage"+"=="+form.getpType()+form.getpCompany());
        
        ModelAndView mv = new ModelAndView();
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        form.setpUseTf("Y");     
        form.setpInOutType("O");	//2019.03.22추가
        form.setType("SsolinkPageInit"); //임시사용  : SSO사이트조회와 SSO사이트관리메뉴 구분을 위해 사용
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
        mv.addObject("url", "WAC020SsoSearch.jsp");
        mv.setViewName(".tiles.page.WAC020");
        return mv;
        
    }
}
