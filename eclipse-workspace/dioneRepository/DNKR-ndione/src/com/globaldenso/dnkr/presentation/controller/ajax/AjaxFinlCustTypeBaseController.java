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
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CustomerService;
import com.globaldenso.dnkr.business.service.FinlCustTypeBaseService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.CustomerDomain;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.FinlCustTypeBaseDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisUtil;
import com.google.gson.Gson;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxFinlCustTypeBase")
public class AjaxFinlCustTypeBaseController {

    /**
     * [KR] 최종고객구분 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private FinlCustTypeBaseService finlCustTypeBaseService;
    
    @Autowired
    private CustomerService customerService;  
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxFinlCustTypeBaseController() {
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
        List<? extends DuplTypeOrderCodeMstDomain> domainlist = null;

        DuplTypeOrderCodeMstDomain criteria = new DuplTypeOrderCodeMstDomain();
        
        domainlist = duplTypeOrderCodeMstService.searchByCondition(criteria);

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
    	
        String endccd = ServletRequestUtils.getStringParameter(request, "endccd");
        String endcnm = ServletRequestUtils.getStringParameter(request, "endcnm");

        List<? extends FinlCustTypeBaseDomain> domainlist = null;

        FinlCustTypeBaseDomain criteria = new FinlCustTypeBaseDomain();
        
        criteria.setEndccd(endccd);
        criteria.setEndcnm(endcnm);
                
		// 저장된 세션 데이터 불러오기
//		EmpDomain salarayInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        

        try {
        	domainlist = finlCustTypeBaseService.searchByCondition(criteria);
        	for(int ii=0;ii<domainlist.size();ii++) {
        	//for(FinlCustTypeBaseDomain domain:domainlist) {
        		
	        	List<? extends CustomerDomain> customerlist = null;
	
	            CustomerDomain customerDomain = new CustomerDomain();
	            customerDomain.setCusno(domainlist.get(ii).getPyvnd());
	
	            CommonDb2Domain empInfo = UxisUtil.getDB2Lib(domainlist.get(ii).getComps());
	            
	            customerDomain.setLib1(empInfo.getLib1());
	            customerDomain.setLib2(empInfo.getLib2());
	            
	            customerlist = customerService.searchByCondition(customerDomain);
	            if(customerlist.size()>0) {
	            	domainlist.get(ii).setPyvndnm(customerlist.get(0).getCusnm());
	            }
	            
        	}
        	
        	
        } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
        
        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
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
    @ErrorBack(viewName = "forward:/WAS002FinlCustTypeBase/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonObj = new JSONObject();

		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        //String empNumber = empInfo.getEmpNumber();
        //String userName = empInfo.getEmpName();
          
    	String endccd = ServletRequestUtils.getStringParameter(request, "endccd");
    	String comps = ServletRequestUtils.getStringParameter(request, "comps");
    	String pyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
    	String brnnm = ServletRequestUtils.getStringParameter(request, "brnnm");
    	String desc = ServletRequestUtils.getStringParameter(request, "desc");
    	if(desc == null) {
    		desc = "";
        }
    	//존재하는지 체크
    	FinlCustTypeBaseDomain cntDomain = new FinlCustTypeBaseDomain();
    	cntDomain.setEndccd(endccd);
    	cntDomain.setComps(comps);
    	cntDomain.setPyvnd(pyvnd);
    	
    	int cnt = finlCustTypeBaseService.searchCount(cntDomain);
        if(cnt > 0) {
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } 
    	
        FinlCustTypeBaseDomain insDomain = new FinlCustTypeBaseDomain();
    	insDomain.setEndccd(endccd);
    	insDomain.setComps(comps);
    	insDomain.setPyvnd(pyvnd);
    	insDomain.setBrnnm(brnnm);
    	insDomain.setDesc(desc);
        insDomain.setRegu(userId);
        
        try {
        	finlCustTypeBaseService.create(insDomain);
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
			throw e;
		}
        
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
    @ErrorBack(viewName = "forward:/WAS002FinlCustTypeBase/init.do")
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

    	JSONObject jsonObj = new JSONObject();

		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        //String empNumber = empInfo.getEmpNumber();
        //String userName = empInfo.getEmpName();
          
    	String endccd = ServletRequestUtils.getStringParameter(request, "endccd");
    	String comps = ServletRequestUtils.getStringParameter(request, "comps");
    	String pyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
    	String brnnm = ServletRequestUtils.getStringParameter(request, "brnnm");
    	String desc = ServletRequestUtils.getStringParameter(request, "desc");
    	
    	String oldComps = ServletRequestUtils.getStringParameter(request, "oldComps");
    	String oldPyvnd = ServletRequestUtils.getStringParameter(request, "oldPyvnd");
    	String oldEndccd = ServletRequestUtils.getStringParameter(request, "oldEndccd");
    	
    	//존재하는지 체크
    	FinlCustTypeBaseDomain cntDomain = new FinlCustTypeBaseDomain();
    	cntDomain.setEndccd(endccd);
    	cntDomain.setComps(comps);
    	cntDomain.setPyvnd(pyvnd);
    	
    	cntDomain.setOldEndccd(oldEndccd);
    	cntDomain.setOldComps(oldComps);
    	cntDomain.setOldPyvnd(oldPyvnd);
    	
    	int cnt2 = finlCustTypeBaseService.searchCount2(cntDomain); 
    	
    	if(cnt2 == 0) {
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;        
        } else {
        	//코드값 수정 불가능
        	if(!oldComps.equals(comps) || !oldEndccd.equals(endccd) || !oldPyvnd.equals(pyvnd)) {
        		int cnt = finlCustTypeBaseService.searchCount(cntDomain);  
 	        	if(cnt > 0) {
	        		jsonObj.put("errMsg", "LN_UPD_CHK2");
	                response.setContentType("text/html;charset=utf-8");
	                response.getWriter().print(jsonObj);
	                return;
	            }       		
        	}
        }
    	
        FinlCustTypeBaseDomain updDomain = new FinlCustTypeBaseDomain();
        updDomain.setEndccd(endccd);
        updDomain.setComps(comps);
        updDomain.setPyvnd(pyvnd);
    	updDomain.setBrnnm(brnnm);
    	updDomain.setDesc(desc);
    	updDomain.setModu(userId);
        
    	updDomain.setOldEndccd(oldEndccd);
    	updDomain.setOldComps(oldComps);
    	updDomain.setOldPyvnd(oldPyvnd);
        
        try {
        	finlCustTypeBaseService.update(updDomain);
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
			throw e;
		}
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
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
    @ErrorBack(viewName = "forward:/WAS002FinlCustTypeBase/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();
        
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        //String empNumber = empInfo.getEmpNumber();
        //String userName = empInfo.getEmpName();
          
    	String endccd = ServletRequestUtils.getStringParameter(request, "endccd");
    	String comps = ServletRequestUtils.getStringParameter(request, "comps");
    	String pyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
    	
    	//존재하는지 체크
    	FinlCustTypeBaseDomain cntDomain = new FinlCustTypeBaseDomain();
    	cntDomain.setEndccd(endccd);
    	cntDomain.setComps(comps);
    	cntDomain.setPyvnd(pyvnd);
    	
    	int cnt = finlCustTypeBaseService.searchCount(cntDomain);
		
		if(cnt == 0) {
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }
    	
        FinlCustTypeBaseDomain updDomain = new FinlCustTypeBaseDomain();
        updDomain.setEndccd(endccd);
        updDomain.setComps(comps);
        updDomain.setPyvnd(pyvnd);
    	
        try {
        	finlCustTypeBaseService.delete(updDomain);
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
			throw e;
		}
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
    
    
}
