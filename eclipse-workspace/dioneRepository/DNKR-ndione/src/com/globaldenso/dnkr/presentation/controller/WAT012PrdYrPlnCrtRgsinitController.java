package com.globaldenso.dnkr.presentation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 생산성 지수 년계획 등록 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAT012PrdYrPlnCrtRgs")
@ViewId(value = "WAT012")
public class WAT012PrdYrPlnCrtRgsinitController {
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAT012PrdYrPlnCrtRgsinitController() {
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
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
		String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
		String menu = ServletRequestUtils.getStringParameter(request, "menu");
		String locCode = empInfo.getLocCode();
		UxisCmmUtil.getSessionComCode(request, mv);

		// wijmo LicenseKey
		String wijmoLicenseKey = UxisCmmUtil.getProperty("wijmo.setLicenseKey");
		mv.addObject("wijmoLicenseKey", wijmoLicenseKey);

//		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
		// mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		
		mv.addObject("url", "PrdYrPlnCrtRgs.jsp");
		mv.setViewName(".tiles.page.WAT012");

		return mv;
        
    }
}
