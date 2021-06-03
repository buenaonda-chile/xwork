package com.globaldenso.dnkr.presentation.controller.sal;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
import com.globaldenso.dnkr.business.service.SalPlnPerfmncWkReprtExlService;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 
 * 
 * @author K-DATALAB
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/WAS006SalPlnPerfmncWkReprtExl")
@ViewId(value = "WAS006")
public class WAS006SalPlnPerfmncWkReprtExlController {
    
    @Autowired
    private SalPlnPerfmncWkReprtExlService salPlnPerfmncWkReprtExlService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAS006SalPlnPerfmncWkReprtExlController() {
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

       // UxisCmmUtil.getSessionComCode(request, mv);
        UxisCmmUtil.getSessionLocToCls(request, mv);// 사업부

        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
        
        String getDumcb = ServletRequestUtils.getStringParameter(request, "getDumcb"); 
        if(getDumcb == null) {
            SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM");
            Calendar calendar = Calendar.getInstance();
            String today = datafmt.format(calendar.getTime());
            getDumcb = today;
        }
        mv.addObject("dumcb", getDumcb);
        
        // wijmo LicenseKey
        String wijmoLicenseKey = UxisCmmUtil.getProperty("wijmo.setLicenseKey");
        mv.addObject("wijmoLicenseKey", wijmoLicenseKey); 
        
//      mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAS006SalPlnPerfmncWkReprtExl.jsp");
        mv.setViewName(".tiles.page.WAS006");
        return mv;
        
    }
}
