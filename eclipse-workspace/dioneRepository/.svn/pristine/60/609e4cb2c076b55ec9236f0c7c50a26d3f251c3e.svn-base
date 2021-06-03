package com.globaldenso.dnkr.presentation.controller.sal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.TopCustTypeMstService;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 대표업체차종마스타 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAN002TopCustTypeMst")
@ViewId(value = "WAN002")
public class WAN002TopCustTypeMstController {
    /**
     * [KR] 중복차종서열코드마스타 서비스 <br>     
     */
    @Autowired
    private TopCustTypeMstService topCustTypeMstService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAN002TopCustTypeMstController() {
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
        mv.addObject("url", "TopCustTypeMst.jsp");
        mv.setViewName(".tiles.page.WAN002");
        return mv;
        
    }
}
