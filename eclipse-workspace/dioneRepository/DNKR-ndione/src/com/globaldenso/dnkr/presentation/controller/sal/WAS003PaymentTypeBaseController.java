package com.globaldenso.dnkr.presentation.controller.sal;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.PaymentTypeBaseService;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 
 * 
 * @author K-DATALAB
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/WAS003PaymentTypeBase")
@ViewId(value = "WAS003")
public class WAS003PaymentTypeBaseController {
    
//    @Autowired
//    private PaymentTypeBaseService paymentTypeBaseService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAS003PaymentTypeBaseController() {
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

        //UxisCmmUtil.getSessionComCode(request, mv);
        UxisCmmUtil.getSessionLocToCls(request, mv);// 사업부

        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
//        String empLoc        = UxisCmmUtil.getChangeCom((String)empJsonObj.get("locCode")); 
        
        // wijmo LicenseKey
        String wijmoLicenseKey = UxisCmmUtil.getProperty("wijmo.setLicenseKey");
        mv.addObject("wijmoLicenseKey", wijmoLicenseKey); 
        mv.addObject("tabId", tabId);
//        mv.addObject("empLoc", empLoc);
//        mv.addObject("empLoc", empLoc);  //사용자 공장  
        mv.addObject("url", "WAS003PaymentTypeBase.jsp");
        mv.setViewName(".tiles.page.WAS003");
        return mv;
        
    }
}
