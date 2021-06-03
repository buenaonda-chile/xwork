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
import com.globaldenso.dnkr.business.service.FinlCustInfoBaseService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.FinlCustInfoBaseDomain;
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
@RequestMapping(value = "/ajaxFinlCustInfoBase")
public class AjaxFinlCustInfoBaseController {

    /**
     * [KR] 중복차종서열코드마스타 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private FinlCustInfoBaseService finlCustInfoBaseService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxFinlCustInfoBaseController() {
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
        System.out.println(endcnm);

        List<? extends FinlCustInfoBaseDomain> domainlist = null;

        FinlCustInfoBaseDomain criteria = new FinlCustInfoBaseDomain();
        criteria.setEndccd(endccd);
        criteria.setEndcnm(endcnm);
                
		// 저장된 세션 데이터 불러오기
//		EmpDomain salarayInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        

        try {
        	domainlist = finlCustInfoBaseService.searchByCondition(criteria);
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
     * 최종고객명이 존재하는지 확인
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/isExist", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAS001FinlCustInfoBase/init.do")
    public void isExist(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	JSONObject jsonObj = new JSONObject();
    	
    	String endcnm = ServletRequestUtils.getStringParameter(request, "endcnm");
    	
    	List<? extends FinlCustInfoBaseDomain> domainlist = null;

        FinlCustInfoBaseDomain criteria = new FinlCustInfoBaseDomain();
        criteria.setEndcnm(endcnm);
        
        try {
        	
        	int cnt = finlCustInfoBaseService.searchCount(criteria);
        	
        	if(cnt<1) {        	 
        		
        		jsonObj.put("result", DnkrConstans.RESULT_N);
        		response.setContentType("text/html;charset=utf-8");
                response.getWriter().print(jsonObj);
                return;
            }
        	
        	jsonObj.put("result", DnkrConstans.RESULT_OK);        
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        	
        } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
        
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
    @ErrorBack(viewName = "forward:/WAS001FinlCustInfoBase/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonObj = new JSONObject();

		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        //String empNumber = empInfo.getEmpNumber();
        //String userName = empInfo.getEmpName();
          
    	String endcnm = ServletRequestUtils.getStringParameter(request, "endcnm");
        
        String endccd = finlCustInfoBaseService.codeGenarator();
        int seq = 1;
        if(endccd!=null) {
        	seq = Integer.parseInt(endccd.substring(1))+1;
        }
        endccd = "M"+String.format("%03d", seq);
    	
        FinlCustInfoBaseDomain insDomain = new FinlCustInfoBaseDomain();
        insDomain.setEndccd(endccd);
        insDomain.setEndcnm(endcnm);
        insDomain.setRegu(userId);
        
        try {
        	finlCustInfoBaseService.create(insDomain);
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
    @ErrorBack(viewName = "forward:/WAS001FinlCustInfoBase/init.do")
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

    	JSONObject jsonObj = new JSONObject();
		
    	EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
        
        
        String endccd = ServletRequestUtils.getStringParameter(request, "endccd");
        String endcnm = ServletRequestUtils.getStringParameter(request, "endcnm");
        
        
        FinlCustInfoBaseDomain updDomain = new FinlCustInfoBaseDomain();           
        updDomain.setEndccd(endccd);
        updDomain.setEndcnm(endcnm);
        updDomain.setRegu(userId);
        updDomain.setModu(userId);
        
        
        try {
        	finlCustInfoBaseService.update(updDomain);
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
    @ErrorBack(viewName = "forward:/WAS001FinlCustInfoBase/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();
        
        
        String endccd = ServletRequestUtils.getStringParameter(request, "endccd");
        
        
        FinlCustInfoBaseDomain delDomain = new FinlCustInfoBaseDomain();
        delDomain.setEndccd(endccd);
        
        
        try {
        	finlCustInfoBaseService.delete(delDomain);
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
