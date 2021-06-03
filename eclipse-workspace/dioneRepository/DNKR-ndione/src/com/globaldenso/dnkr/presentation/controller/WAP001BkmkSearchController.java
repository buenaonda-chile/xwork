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
import com.globaldenso.dnkr.business.service.BkmkService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.domain.BkmkDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAP001BkmkSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 메뉴관리 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAP001Bkmk")
@ViewId(value = "WAP001")
public class WAP001BkmkSearchController {
    /**
     * [KR] 즐겨찾기서비스 <br>     
     */
    @Autowired
    private BkmkService bkmkService;
    
    /**
     * [KR] 메뉴서비스 <br>     
     */
    @Autowired
    private MenuService menuService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAP001BkmkSearchController() {
        // no process
    }
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      WAP001BkmkSearchForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAP001")
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAP001BkmkSearchForm") WAP001BkmkSearchForm form)  throws Exception {
        ModelAndView mv = new ModelAndView();
        //System.out.println("WAP001Bkmk/init.do");

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        BkmkDomain domain = new BkmkDomain();
        domain.setEmpNumber(UxisCmmUtil.getSessionData(request, "uid"));
        domain.setLangCmc(DensoContext.get().getLocale().getLanguage());
        List<BkmkDomain> bkmkList = bkmkService.searchByCondition(domain);

        mv.addObject("bkmkList", bkmkList);
        mv.addObject("url", "WAP001Bkmk.jsp");
        mv.setViewName(".tiles.page.WAP001");
        return mv;
    }
}
