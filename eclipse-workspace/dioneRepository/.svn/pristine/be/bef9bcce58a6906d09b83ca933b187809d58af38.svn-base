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
import com.globaldenso.dnkr.business.service.OrderDayBeforeTransferErrorListService;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 서열형 일일 수주이관전 ERROR LIST(HKMC) 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAN012OrderDayBeforeTransferErrorList")
@ViewId(value = "WAN012")
public class WAN012OrderDayBeforeTransferErrorListController {
    /**
     * [KR] 서열형 일일 수주이관전 ERROR LIST(HKMC) 서비스 <br>     
     */
    @Autowired
    private OrderDayBeforeTransferErrorListService orderDayBeforeTransferErrorListService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAN012OrderDayBeforeTransferErrorListController() {
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
        mv.addObject("today", today);
        
//      mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("tabId", tabId);
        mv.addObject("url", "OrderDayBeforeTransferErrorList.jsp");
        mv.setViewName(".tiles.page.WAN012");
        return mv;
        
    }
}
