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
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.domain.MenuDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAD011MenuCreateForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 메뉴관리 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAD011Menu")
@ViewId(value = "WAD011")
public class WAD011MenuController {
    /**
     * [KR] 메뉴서비스 <br>     
     */
    @Autowired
    private MenuService menuService;
    
    /** */
    private final String MENU_CODE = "5";
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAD011MenuController() {
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
    @ErrorBack(viewName = ".tiles.page.WAD011")
    public ModelAndView init(@ModelAttribute("WAD011MenuCreateForm") WAD011MenuCreateForm form, HttpServletRequest request)  throws Exception {

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");

        ModelAndView mv = new ModelAndView();
        
        //System.out.println("권한체크" + UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAD011Menu.jsp");
        mv.setViewName(".tiles.page.WAD011");
        return mv;
        
    }
}
