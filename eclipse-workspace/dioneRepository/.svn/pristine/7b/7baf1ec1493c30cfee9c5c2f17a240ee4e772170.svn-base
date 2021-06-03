package com.globaldenso.dnkr.presentation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.EmpService;

/**
 * [KR] 사원 정보 뷰페이지 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAB003EmpSelect")
@ViewId(value = "WAB003")
public class WAB003EmpSelectController {
    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAB003EmpSelectController() {
        // no process
    }
    /**
     * [KR] <br>     
     *
     * @param request               HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request)  throws Exception {
        
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAB003EmpSelect.jsp");
        mv.setViewName(".tiles.page.WAB003");
        return mv;
    }
}
