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
import com.globaldenso.dnkr.business.service.OrderService;
import com.globaldenso.dnkr.domain.ContractDomain;

/**
 * [KO] 공통코드의  ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing of common code .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxOrder")
public class AjaxOrderController {

    /**
     * [KR] 즐겨찾기서비스 <br>     
     */
    @Autowired
    private OrderService orderService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxOrderController() {
        // no process
    }
    
    
    /**
     * [KO] 데이터 조회.<br>
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

        System.out.println("ajaxContract/init.do");

        JSONObject jsonObj = new JSONObject();

        String type = ServletRequestUtils.getStringParameter(request, "type");

        List<? extends ContractDomain> contractlist = null;
        ContractDomain contractDomain = new ContractDomain();
        //contractlist = contractService.searchByCondition(contractDomain);
        

        if(contractlist != null) {
        	jsonObj.put("cnt", contractlist.size());
            jsonObj.put("list", contractlist);
        }else{
        	jsonObj.put("cnt", 0);
        }
//
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
}
