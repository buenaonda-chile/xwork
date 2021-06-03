package com.globaldenso.dnkr.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.OrderService;
import com.globaldenso.dnkr.business.service.SheetService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.domain.OrderDomain;
import com.globaldenso.dnkr.domain.SheetDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAM002SheetSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 메뉴관리 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAM002Sheet")
@ViewId(value = "WAM002")
public class WAM002SheetSearchController {
    /**
     * [KR] 즐겨찾기서비스 <br>     
     */
    @Autowired
    private SheetService sheetService;
    
    /**
     * [KR] 메뉴서비스 <br>     
     */
    @Autowired
    private OrderService orderService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAM002SheetSearchController() {
        // no process
    }
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      WAP001SheetSearchForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAM002")
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAM002SheetSearchForm") WAM002SheetSearchForm form)  throws Exception {
        ModelAndView mv = new ModelAndView();
        //System.out.println("WAP001Sheet/init.do");

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        //SheetDomain domain = new SheetDomain();
        //List<SheetDomain> SheetList = sheetService.searchByCondition(domain);
        OrderDomain domain = new OrderDomain();
        
        List<OrderDomain> dateList = orderService.getReleaseDate(domain);
        
        
        mv.addObject("dateList", dateList);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAM002Sheet.jsp");
        mv.setViewName(".tiles.page.WAM002");
        
        
        return mv;
    }
}
