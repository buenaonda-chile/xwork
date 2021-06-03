package com.globaldenso.dnkr.presentation.controller.sal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.BatchHistService;
import com.globaldenso.dnkr.business.service.OrderDayITEMMstService;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 배치실행이력 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAN022BatchHist")
@ViewId(value = "WAN022")
public class WAN022BatchHistController {
    /**
     * [KR] 배치실행이력 서비스 <br>     
     */
    @Autowired
    private BatchHistService batchHistService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAN022BatchHistController() {
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
        
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        mv.addObject("company", empInfo.getClsCode());
        
//      mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("tabId", tabId);
        mv.addObject("url", "BatchHist.jsp");
        mv.setViewName(".tiles.page.WAN022");
        return mv;
        
    }
}
