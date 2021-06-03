package com.globaldenso.dnkr.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 품번별생산성실적 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAT021PrdPrfByItmNmb")
@ViewId(value = "WAT021")
public class WAT021PrdPrfByItmNmbController {
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAT021PrdPrfByItmNmbController() {
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
        
//        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
//      mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("tabId", tabId);
        mv.addObject("url", "PrdPrfByItmNmb.jsp");
        mv.setViewName(".tiles.page.WAT021");
        return mv;
        
    }
}
