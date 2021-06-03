package com.globaldenso.dnkr.presentation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.AuthService;

/**
 * [KR] 권한관리 상세정보 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAD002AuthSelect")
@ViewId(value = "WAD002")
public class WAD002AuthSelectController {
    /**
     * [KR] 권한 서비스 <br>     
     */
    @Autowired
    private AuthService authService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAD002AuthSelectController() {
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
        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAD002AuthSelect.jsp");
        mv.setViewName(".tiles.page.WAD002");
        return mv;
        
    }
}
