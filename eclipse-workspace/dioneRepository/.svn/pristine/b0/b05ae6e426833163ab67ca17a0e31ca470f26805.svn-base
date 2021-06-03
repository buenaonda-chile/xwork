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
import com.globaldenso.dnkr.business.service.SalPlnPerfmncMtReprtPptService;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 
 * 
 * @author K-DATALAB
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/WAS008SalPlnPerfmncMtReprtPpt")
@ViewId(value = "WAS008")
public class WAS008SalPlnPerfmncMtReprtPptController {
    
    @Autowired
    private SalPlnPerfmncMtReprtPptService salPlnPerfmncMtReprtPptService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAS008SalPlnPerfmncMtReprtPptController() {
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
        UxisCmmUtil.getSessionLoc(request, mv);// 사업부

        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
//        String empCls        = (String)empJsonObj.get("clsCode");        //사용자 사업부
        String empLoc        = UxisCmmUtil.getChangeCls((String)empJsonObj.get("locCode"));        //사용자 공장
        
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
        mv.addObject("empLoc", empLoc);  //사용자 공장  
        mv.addObject("url", "WAS008SalPlnPerfmncMtReprtPpt.jsp");
        mv.setViewName(".tiles.page.WAS008");
        return mv;
        
    }
}
