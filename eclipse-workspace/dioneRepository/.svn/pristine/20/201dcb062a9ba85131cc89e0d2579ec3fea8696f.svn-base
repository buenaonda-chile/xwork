package com.globaldenso.dnkr.presentation.controller.sal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.OrderTransferMngService;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 
 * 
 * @author K-DATALAB
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/WAN023OrderTransferMng")
@ViewId(value = "WAN023")
public class WAN023OrderTransferMngController {
    
    @Autowired
    private OrderTransferMngService orderTransferMngService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAN023OrderTransferMngController() {
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
        
//      mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("tabId", tabId);
        mv.addObject("url", "OrderTransferMng.jsp");
        mv.setViewName(".tiles.page.WAN023");
        return mv;
        
    }
}
