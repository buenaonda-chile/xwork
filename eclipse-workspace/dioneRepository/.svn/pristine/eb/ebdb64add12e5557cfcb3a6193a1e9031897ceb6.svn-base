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

import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.business.service.CustOrderTypeMstViewService;
import com.globaldenso.dnkr.domain.CustOrderTypeMstViewDomain;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
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
@RequestMapping(value = "/ajaxCustOrderTypeMstView")
public class AjaxCustOrderTypeMstViewController {

    /**
     * [KR] 업체서열차종마스타차종별조회 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private CustOrderTypeMstViewService custOrderTypeMstViewService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxCustOrderTypeMstViewController() {
        // no process
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
    @RequestMapping(value = "/init", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void init(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

        JSONObject jsonObj = new JSONObject();
        
        /*
        List<? extends CustOrderTypeMstViewDomain> domainlist = null;

        CustOrderTypeMstViewDomain criteria = new CustOrderTypeMstViewDomain();
       
        domainlist = custOrderTypeMstViewService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }
        */
        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
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
        String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");        
        String getMcrcd = ServletRequestUtils.getStringParameter(request, "getMcrcd");
        
        List<? extends CustOrderTypeMstViewDomain> domainlist = null;

        CustOrderTypeMstViewDomain criteria = new CustOrderTypeMstViewDomain();
        criteria.setComps(getComps);
        criteria.setPyvnd(getPyvnd);
        criteria.setMcrcd(getMcrcd);
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);

        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());

        domainlist = custOrderTypeMstViewService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
}