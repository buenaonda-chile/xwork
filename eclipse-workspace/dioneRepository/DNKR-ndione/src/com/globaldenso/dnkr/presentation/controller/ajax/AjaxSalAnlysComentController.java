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
import com.globaldenso.dnkr.business.service.SalAnlysComentService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.SalAnlysComentDomain;
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
@RequestMapping(value = "/ajaxSalAnlysComent")
public class AjaxSalAnlysComentController {

    /**
     * [KR]  판매계획 매출입력(매출분석코멘트)서비스 <br>
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private SalAnlysComentService salAnlysComentService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxSalAnlysComentController() {
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
		
		String comps = ServletRequestUtils.getStringParameter(request, "getComps");
		String repym = ServletRequestUtils.getStringParameter(request, "getRepym");
		String reprtNm = ServletRequestUtils.getStringParameter(request, "getReprtNm");
		
        List<? extends SalAnlysComentDomain> domainlist = null;
        SalAnlysComentDomain criteria = new SalAnlysComentDomain();
        criteria.setComps(comps);
        criteria.setRepym(repym);
        criteria.setReprtse(reprtNm);
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(comps);
        
//        criteria.setLib1(empInfo.getLib1());
//        criteria.setLib2(empInfo.getLib2());
        
        domainlist = salAnlysComentService.searchByCondition(criteria);

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
		String repym = ServletRequestUtils.getStringParameter(request, "repym");
		String reprtse = ServletRequestUtils.getStringParameter(request, "reprtse");
		String cmnitm = ServletRequestUtils.getStringParameter(request, "cmnitm");
		String cmncn = ServletRequestUtils.getStringParameter(request, "cmncn");
        
		//존재하는지 체크
		SalAnlysComentDomain cntDomain = new SalAnlysComentDomain();
		cntDomain.setComps(comps);
        cntDomain.setRepym(repym);
        cntDomain.setReprtse(reprtse);
        cntDomain.setCmnitm(cmnitm);
		        
		int cnt = salAnlysComentService.searchCount(cntDomain);
		
		if(cnt == 0) {
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }
		
		SalAnlysComentDomain delDomain = new SalAnlysComentDomain();
		delDomain.setComps(comps);
		delDomain.setRepym(repym);
		delDomain.setReprtse(reprtse);
		delDomain.setCmnitm(cmnitm);
		
        salAnlysComentService.delete(delDomain);
        
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
		String repym = ServletRequestUtils.getStringParameter(request, "repym");
		String reprtse = ServletRequestUtils.getStringParameter(request, "reprtse");
		String cmnitm = ServletRequestUtils.getStringParameter(request, "cmnitm");
		String cmncn = ServletRequestUtils.getStringParameter(request, "cmncn");
		if(cmncn == null) {
			cmncn = "";
        }
		//존재하는지 체크
		SalAnlysComentDomain cntDomain = new SalAnlysComentDomain();
        cntDomain.setComps(comps);
        cntDomain.setRepym(repym);
        cntDomain.setReprtse(reprtse);
        cntDomain.setCmnitm(cmnitm);
        
        int cnt = salAnlysComentService.searchCount(cntDomain);

        if(cnt > 0) {
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } 
		
        SalAnlysComentDomain insDomain = new SalAnlysComentDomain();
        insDomain.setComps(comps);
        insDomain.setRepym(repym);
        insDomain.setReprtse(reprtse);
        insDomain.setCmnitm(cmnitm);
        insDomain.setCmncn(cmncn);
        insDomain.setRegu(empNumber);
        salAnlysComentService.create(insDomain);
        
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
		String repym = ServletRequestUtils.getStringParameter(request, "repym");
		String reprtse = ServletRequestUtils.getStringParameter(request, "reprtse");
		String cmnitm = ServletRequestUtils.getStringParameter(request, "cmnitm");
		String cmncn = ServletRequestUtils.getStringParameter(request, "cmncn");
		
		String oldComps = ServletRequestUtils.getStringParameter(request, "oldComps");
		String oldRepym = ServletRequestUtils.getStringParameter(request, "oldRepym");
		String oldReprtse = ServletRequestUtils.getStringParameter(request, "oldReprtse");
		String oldCmnitm = ServletRequestUtils.getStringParameter(request, "oldCmnitm");
		String oldCmncn = ServletRequestUtils.getStringParameter(request, "oldCmncn");
    	
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
		
        JSONObject jsonObj = new JSONObject();
        
      //존재하는지 체크
        SalAnlysComentDomain cntDomain = new SalAnlysComentDomain();        
        cntDomain.setComps(comps);
        cntDomain.setRepym(repym);
        cntDomain.setReprtse(reprtse);
        cntDomain.setCmnitm(cmnitm);
        
        cntDomain.setOldComps(oldComps);
        cntDomain.setOldRepym(oldRepym);
        cntDomain.setOldReprtse(oldReprtse);
        cntDomain.setOldCmnitm(oldCmnitm);
        
        int cnt2 = salAnlysComentService.searchCount2(cntDomain); 
        
        if(cnt2 == 0) {
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;        
        } else {
        	//코드값 수정 불가능
        	if(!oldComps.equals(comps) || !oldRepym.equals(repym) || !oldReprtse.equals(reprtse) || !oldCmnitm.equals(cmnitm) ) {
        		int cnt = salAnlysComentService.searchCount(cntDomain);  
 	        	if(cnt > 0) {
	        		jsonObj.put("errMsg", "LN_UPD_CHK2");
	                response.setContentType("text/html;charset=utf-8");
	                response.getWriter().print(jsonObj);
	                return;
	            }       		
        	}
        }
        
        SalAnlysComentDomain updDomain = new SalAnlysComentDomain();
        updDomain.setComps(comps);
        updDomain.setRepym(repym);
        updDomain.setReprtse(reprtse);
        updDomain.setCmnitm(cmnitm);
        updDomain.setCmncn(cmncn);
        updDomain.setModu(empNumber);
        
        updDomain.setOldComps(oldComps);
        updDomain.setOldRepym(oldRepym);
        updDomain.setOldReprtse(oldReprtse);
        updDomain.setOldCmnitm(oldCmnitm);
        updDomain.setOldCmncn(oldCmncn);
        
        salAnlysComentService.update(updDomain);
        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}
