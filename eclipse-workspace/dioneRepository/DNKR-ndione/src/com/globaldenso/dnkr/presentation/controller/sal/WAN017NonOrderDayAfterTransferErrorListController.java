package com.globaldenso.dnkr.presentation.controller.sal;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.NonOrderDayAfterTransferErrorListService;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 비서열/확정오더형 일일 수주이관후 ERROR LIST 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAN017NonOrderDayAfterTransferErrorList")
@ViewId(value = "WAN017")
public class WAN017NonOrderDayAfterTransferErrorListController {
    /**
     * [KR] 비서열/확정오더형 일일 수주이관후 ERROR LIST 서비스 <br>     
     */
    @Autowired
    private NonOrderDayAfterTransferErrorListService nonOrderDayAfterTransferErrorListService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAN017NonOrderDayAfterTransferErrorListController() {
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
        
        SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        String today = datafmt.format(calendar.getTime());
        mv.addObject("plndt", today);

//      mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("tabId", tabId);
        mv.addObject("url", "NonOrderDayAfterTransferErrorList.jsp");
        mv.setViewName(".tiles.page.WAN017");
        return mv;
        
    }
}
