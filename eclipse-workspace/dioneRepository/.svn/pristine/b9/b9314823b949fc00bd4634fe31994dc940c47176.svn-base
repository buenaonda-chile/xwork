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
import com.globaldenso.dnkr.business.service.PrdctSvcPsnlInputService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.PrdctSvcPsnlInputDomain;


/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxPrdctSvcPsnlInput")
public class AjaxPrdctSvcPsnlInputController {

    /**
     * [KR] 생산성지표 기준정보(생산용역인원관리)서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private PrdctSvcPsnlInputService prdctSvcPsnlInputService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxPrdctSvcPsnlInputController() {
        // no process
    }
    
    
    /**
     * [KO] 생산성지표 기준정보(라인기준정보) 조회.<br>
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
    	
        String clsCode = ServletRequestUtils.getStringParameter(request, "getComps"); 
        String servcNo = ServletRequestUtils.getStringParameter(request, "servcNo");
        List<? extends PrdctSvcPsnlInputDomain> domainlist = null;

        PrdctSvcPsnlInputDomain criteria = new PrdctSvcPsnlInputDomain();
        criteria.setClsCode(clsCode);
        criteria.setServcNo(servcNo);
        
		// 저장된 세션 데이터 불러오기
//		EmpDomain salarayInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        domainlist = prdctSvcPsnlInputService.searchByCondition(criteria);

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
    @ErrorBack(viewName = "forward:/WAN000DuplTypeOrderCodeMst/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();
        
        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
        String servcNo = ServletRequestUtils.getStringParameter(request, "servcNo");
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");
        String startDe = ServletRequestUtils.getStringParameter(request, "startDe");
        String endDe = ServletRequestUtils.getStringParameter(request, "endDe");
        
        //존재하는지 체크
        PrdctSvcPsnlInputDomain cntDomain = new PrdctSvcPsnlInputDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setServcNo(servcNo);
        cntDomain.setLocCode(locCode);
        cntDomain.setStartDe(startDe);
        cntDomain.setEndDe(endDe); 
        
        int cnt = prdctSvcPsnlInputService.searchCount(cntDomain);

        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        PrdctSvcPsnlInputDomain delDomain = new PrdctSvcPsnlInputDomain();
        delDomain.setClsCode(clsCode);
        delDomain.setServcNo(servcNo); 
        delDomain.setLocCode(locCode);
        delDomain.setStartDe(startDe);
        prdctSvcPsnlInputService.delete(delDomain);
        
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
    @ErrorBack(viewName = "forward:/WAN000DuplTypeOrderCodeMst/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonObj = new JSONObject();

		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
        
        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
        String servcNo = ServletRequestUtils.getStringParameter(request, "servcNo");
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");
        String startDe = ServletRequestUtils.getStringParameter(request, "startDe");
        String endDe = ServletRequestUtils.getStringParameter(request, "endDe");
        String nm = ServletRequestUtils.getStringParameter(request, "nm");
        String refrn = ServletRequestUtils.getStringParameter(request, "refrn");
        if(refrn == null) {
        	refrn = " ";
        }
        
    	startDe = startDe.replaceAll("-", "");     
    	endDe = endDe.replaceAll("-", "");          
        
        //존재하는지 체크
        PrdctSvcPsnlInputDomain cntDomain = new PrdctSvcPsnlInputDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setServcNo(servcNo);
        cntDomain.setLocCode(locCode);
        cntDomain.setStartDe(startDe); 
        cntDomain.setEndDe(endDe); 
        
        int cnt = prdctSvcPsnlInputService.searchCount(cntDomain);

        if(cnt > 0) {
 //         jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }      
        
        PrdctSvcPsnlInputDomain insDomain = new PrdctSvcPsnlInputDomain();
        
        insDomain.setClsCode(clsCode);
        insDomain.setServcNo(servcNo);        
        insDomain.setLocCode(locCode);
        insDomain.setStartDe(startDe);         
        insDomain.setEndDe(endDe);
        insDomain.setNm(nm);        
        insDomain.setRefrn(refrn);
        insDomain.setRegUser(empNumber);
        prdctSvcPsnlInputService.create(insDomain);
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
    @ErrorBack(viewName = ".tiles.page.WAN000")
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

    	String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
        String servcNo = ServletRequestUtils.getStringParameter(request, "servcNo");
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");
        String startDe = ServletRequestUtils.getStringParameter(request, "startDe");
        String endDe = ServletRequestUtils.getStringParameter(request, "endDe");
        String nm = ServletRequestUtils.getStringParameter(request, "nm");
        String refrn = ServletRequestUtils.getStringParameter(request, "refrn");
        String regUser = ServletRequestUtils.getStringParameter(request, "regUser");
        String regDate = ServletRequestUtils.getStringParameter(request, "regDate");
        String oldServcNo = ServletRequestUtils.getStringParameter(request, "oldServcNo");        

    	startDe = startDe.replaceAll("-", "");     
    	endDe = endDe.replaceAll("-", "");        
        
        if(refrn == null) {
        	refrn = " ";
        }
        
        
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
        
        JSONObject jsonObj = new JSONObject();
       
        //존재하는지 체크
        PrdctSvcPsnlInputDomain cntDomain = new PrdctSvcPsnlInputDomain();       
        	cntDomain.setClsCode(clsCode);
        	cntDomain.setServcNo(servcNo);
        	cntDomain.setLocCode(locCode);
        	cntDomain.setStartDe(startDe);
        	cntDomain.setEndDe(endDe);
        	cntDomain.setOldServcNo(oldServcNo);
            int cnt2 = prdctSvcPsnlInputService.searchCount2(cntDomain); 
            if(cnt2 == 0) {
                //jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.)");
            	jsonObj.put("errMsg", "LN_UPD_CHK1");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print(jsonObj);
                return;        
            } else {
            	//코드값 수정 불가능
            	if(!oldServcNo.equals(servcNo)) {
            		int cnt = prdctSvcPsnlInputService.searchCount(cntDomain);  
     	        	if(cnt > 0) {
    	                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
    	        		jsonObj.put("errMsg", "LN_UPD_CHK2");
    	                response.setContentType("text/html;charset=utf-8");
    	                response.getWriter().print(jsonObj);
    	                return;
    	            }
            	}
            }                
        	

       	
        	PrdctSvcPsnlInputDomain updDomain = new PrdctSvcPsnlInputDomain();   
        	updDomain.setClsCode(clsCode);
        	updDomain.setServcNo(servcNo);
        	updDomain.setLocCode(locCode);   
        	updDomain.setStartDe(startDe);            
        	updDomain.setEndDe(endDe);
        	updDomain.setNm(nm);        
        	updDomain.setRefrn(refrn); 
        	updDomain.setOldServcNo(oldServcNo);        	
        	updDomain.setModUser(empNumber);      
        	prdctSvcPsnlInputService.update(updDomain);
	        jsonObj.put("result", DnkrConstans.RESULT_OK);  
	        response.setContentType("text/html;charset=utf-8");
	        response.getWriter().print(jsonObj);    
	        return;
    }
    
}
