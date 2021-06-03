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
import com.globaldenso.dnkr.business.service.OrderHostUpCheckListService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.OrderHostUpCheckListDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisUtil;
import com.globaldenso.dnkr.domain.EmpDb2Domain;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxOrderHostUpCheckList")
public class AjaxOrderHostUpCheckListController {

    /**
     * [KR] 서열형 HOST UP CHECK LIST 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private OrderHostUpCheckListService orderHostUpCheckListService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxOrderHostUpCheckListController() {
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
        List<? extends OrderHostUpCheckListDomain> domainlist = null;

        OrderHostUpCheckListDomain criteria = new OrderHostUpCheckListDomain();
        
        domainlist = orderHostUpCheckListService.searchByCondition(criteria);

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

        String getSelchk = ServletRequestUtils.getStringParameter(request, "getSelchk");
        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");        
        String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");        
        String getDumym = ServletRequestUtils.getStringParameter(request, "getDumym");
        String getDumcb = ServletRequestUtils.getStringParameter(request, "getDumcb");
        String getGubcd = ServletRequestUtils.getStringParameter(request, "getGubcd");

        List<? extends OrderHostUpCheckListDomain> domainlist = null;

        OrderHostUpCheckListDomain criteria = new OrderHostUpCheckListDomain();
        criteria.setSelchk(getSelchk);
        criteria.setComps(getComps);
        criteria.setPyvnd(getPyvnd);
        criteria.setDumym(getDumym);
        criteria.setDumcb(getDumcb);
        criteria.setGubcd(getGubcd);
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);

        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());

        domainlist = orderHostUpCheckListService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
}