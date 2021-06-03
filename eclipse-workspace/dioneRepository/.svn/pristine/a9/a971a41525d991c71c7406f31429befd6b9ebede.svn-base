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

import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.business.service.PaymentTypeBaseService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.PaymentTypeBaseDomain;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
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
@RequestMapping(value = "/ajaxPaymentTypeBase")
public class AjaxPaymentTypeBaseController {

    /**
     * [KR]  판매계획 기준정보(납입구분관리)서비스 <br>
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private PaymentTypeBaseService paymentTypeBaseService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxPaymentTypeBaseController() {
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
		String pyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");
		
        List<? extends PaymentTypeBaseDomain> domainlist = null;
        PaymentTypeBaseDomain criteria = new PaymentTypeBaseDomain();
        criteria.setComps(getComps);
        criteria.setPyvnd(pyvnd);
         
        domainlist = paymentTypeBaseService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }
        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

    /**
     * [KO] 삭제.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAS003PaymentTypeBase/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();
        
        String comps = ServletRequestUtils.getStringParameter(request, "comps");
		String pyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        
		//존재하는지 체크
		PaymentTypeBaseDomain cntDomain = new PaymentTypeBaseDomain();
		cntDomain.setComps(comps);
		cntDomain.setPyvnd(pyvnd);
		        
		int cnt = paymentTypeBaseService.searchCount(cntDomain);
		
		if(cnt == 0) {
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }
		
        PaymentTypeBaseDomain delDomain = new PaymentTypeBaseDomain();
        delDomain.setComps(comps);
        delDomain.setPyvnd(pyvnd);
        paymentTypeBaseService.delete(delDomain);
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }

    /**
     * [KO] 추가.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAS003PaymentTypeBase/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonObj = new JSONObject();
        EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
        
        String comps = ServletRequestUtils.getStringParameter(request, "comps");
		String pyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
		
		//존재하는지 체크
		PaymentTypeBaseDomain cntDomain = new PaymentTypeBaseDomain();
        cntDomain.setComps(comps);
        cntDomain.setPyvnd(pyvnd);
        
        int cnt = paymentTypeBaseService.searchCount(cntDomain);

        if(cnt > 0) {
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } 
		
        PaymentTypeBaseDomain insDomain = new PaymentTypeBaseDomain();
        
        insDomain.setComps(comps);
        insDomain.setPyvnd(pyvnd);
        insDomain.setRegu(empNumber);
        paymentTypeBaseService.create(insDomain);
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
        
    }
    
    /**
     * [KO] 수정.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAS003")
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {
    	
    	String comps = ServletRequestUtils.getStringParameter(request, "comps");
		String pyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
    	
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
		
        JSONObject jsonObj = new JSONObject();
        
        String oldPyvnd = ServletRequestUtils.getStringParameter(request, "oldPyvnd");
        
      //존재하는지 체크
        PaymentTypeBaseDomain cntDomain = new PaymentTypeBaseDomain();        
        cntDomain.setComps(comps);
        cntDomain.setPyvnd(pyvnd);      
        cntDomain.setOldPyvnd(oldPyvnd);
       	
        int cnt2 = paymentTypeBaseService.searchCount2(cntDomain); 
        
        if(cnt2 == 0) {
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;        
        } else {
        	//코드값 수정 불가능
        	if(!oldPyvnd.equals(pyvnd)) {
        		int cnt = paymentTypeBaseService.searchCount(cntDomain);  
 	        	if(cnt > 0) {
	        		jsonObj.put("errMsg", "LN_UPD_CHK2");
	                response.setContentType("text/html;charset=utf-8");
	                response.getWriter().print(jsonObj);
	                return;
	            }       		
        	}
        }
        
        PaymentTypeBaseDomain updDomain = new PaymentTypeBaseDomain();
        updDomain.setComps(comps);
        updDomain.setPyvnd(pyvnd);      
        updDomain.setOldPyvnd(oldPyvnd);
        updDomain.setModu(empNumber);

        
        paymentTypeBaseService.update(updDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}
