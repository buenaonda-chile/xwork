package com.globaldenso.dnkr.presentation.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.ItemMasterService;
import com.globaldenso.dnkr.domain.ItemMasterDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxItemMaster")
@ViewId(value = "WANITEM")
public class AjaxItemMasterController {

    /**
     * [KR] 품목 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private ItemMasterService itemMasterService;  
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxItemMasterController() {
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

        UxisCmmUtil.getSessionComCode(request, mv);
        
        mv.addObject("url", "ItemMasterPopSelect.jsp");
        mv.setViewName(".tiles.page.WANITEM");
        return mv;
    }
    
    /**
     * [KO] 조회.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void search(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

    	JSONObject jsonObj = new JSONObject();
    	
    	String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        String getItnbr = ServletRequestUtils.getStringParameter(request, "getItnbr");
        String getGbn = ServletRequestUtils.getStringParameter(request, "getGbn");

        //System.out.println("사업부 : " + getComps);
        
        List<? extends ItemMasterDomain> domainlist = null;

        ItemMasterDomain criteria = new ItemMasterDomain();
        criteria.setItnbr(getItnbr);
        criteria.setGbn(getGbn);

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);

        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        domainlist = itemMasterService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
}