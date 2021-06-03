package com.globaldenso.dnkr.presentation.controller.ajax;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.business.service.OrderTransferMngService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.OrderTransferMngDomain;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/ajaxOrderTransferMng")
public class AjaxOrderTransferMngController {

    /**
     * [KR]  
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private OrderTransferMngService orderTransferMngService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxOrderTransferMngController() {
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
		String getPlndt = ServletRequestUtils.getStringParameter(request, "getPlndt");
		
		
		// yyy-mm-dd -> yyymmdd
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date plndt = null;
		try {
			plndt = sdf.parse(getPlndt);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
		SimpleDateFormat newsdf = new SimpleDateFormat("yyyyMMdd");
		
		
        List<? extends OrderTransferMngDomain> domainlist = null;
        OrderTransferMngDomain criteria = new OrderTransferMngDomain();
        criteria.setComps(getComps);
        criteria.setPyvnd(getPyvnd);
        criteria.setPlndt(newsdf.format(plndt));
                        
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);
        
        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        domainlist = orderTransferMngService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }
        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

}
