package com.globaldenso.dnkr.presentation.controller.sal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 판매계획 기준정보관리(최종고객구분관리) 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAS002FinlCustTypeBase")
@ViewId(value = "WAS002")
public class WAS002FinlCustTypeBaseController {
    /**
     * [KR] 판매계획 기준정보관리(최종고객구분관리) 서비스 <br>     
     */
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAS002FinlCustTypeBaseController() {
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
        String menu = ServletRequestUtils.getStringParameter(request, "menu");

        UxisCmmUtil.getSessionComCode(request, mv);
        
        // wijmo LicenseKey
        String wijmoLicenseKey = UxisCmmUtil.getProperty("wijmo.setLicenseKey");
        mv.addObject("wijmoLicenseKey", wijmoLicenseKey); 
        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAS002FinlCustTypeBase.jsp");
        mv.setViewName(".tiles.page.WAS002");
        return mv;
        
    }
}
