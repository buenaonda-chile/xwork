package com.globaldenso.dnkr.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.globaldenso.dnkr.presentation.form.basic.WAC018LinkSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 링크관리  컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAC018LinkSearch")
@ViewId(value = "WAC018")
public class WAC018LinkSearchController {

    /** */
    private final String MENU_CODE = "686";
    
    /**
     * [KR] 링크 서비스 <br>     
     */
    @Autowired
    private LinkService linkService;
    

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAC018LinkSearchController() {
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
        @ModelAttribute("WAC018LinkSearchForm") WAC018LinkSearchForm form)  throws Exception {
        
        System.out.println("linkPageInit");
                
        ModelAndView mv = new ModelAndView();
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String pType= ServletRequestUtils.getStringParameter(request, "pType"); 
        form.setpType(pType);
        form.setpUseTf("Y");
        System.out.println("linkPage"+"=="+pType);
     
        int count = 0;
        try {
            count = linkService.searchCountLink(form);
        } catch (Exception e) {
            System.out.println("조회할 데이터가 없습니다.");
        }
        if(count > 0) {
            // paging process
            PagingUtility.calcPaging(form, count);
            List<LinkDomain> linkList = linkService.searchByConditionForPagingLink(form);
            mv.addObject("linkList", linkList);
        }

        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("totCount", count);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAC018LinkSearch.jsp");
        mv.setViewName(".tiles.page.WAC018");
        return mv;
        
    }
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      WAC017LinkManagementForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    @Token(save = true)
    public ModelAndView search(HttpServletRequest request, 
        @ModelAttribute("WAC018LinkSearchForm") WAC018LinkSearchForm form)  throws Exception {
        
        //System.out.println("linkPage");
        String pType= (String) request.getParameter("pType");
        //System.out.println("linkPage"+"=="+form.getpType());
        
        ModelAndView mv = new ModelAndView();
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        form.setpUseTf("Y");     
        int count = 0;
        try {
            count = linkService.searchCountLink(form);
        } catch (Exception e) {
            System.out.println("조회할 데이터가 없습니다.");
        }
        if(count > 0) {
            // paging process
            PagingUtility.calcPaging(form, count);
            List<LinkDomain> linkList = linkService.searchByConditionForPagingLink(form);
            mv.addObject("linkList", linkList);
        }

        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("totCount", count);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAC018LinkSearch.jsp");
        mv.setViewName(".tiles.page.WAC018");
        return mv;
        
    }
}
