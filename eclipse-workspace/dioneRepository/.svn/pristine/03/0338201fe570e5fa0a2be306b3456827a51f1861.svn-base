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
import com.globaldenso.dnkr.business.service.WorkCodeBaseService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.WorkCodeBaseDomain;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxWorkCodeBase")
public class AjaxWorkCodeBaseController {

    /**
     * [KR] 생산성지표 기준정보(작업코드관리)서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private WorkCodeBaseService workCodeBaseService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxWorkCodeBaseController() {
        // no process
    }
    
    
    /**
     * [KO] 생산성지표 기준정보(작업코드관리) 조회.<br>
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

        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");

        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
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
    	String se = ServletRequestUtils.getStringParameter(request, "getSe");

        List<? extends WorkCodeBaseDomain> domainlist = null;

        WorkCodeBaseDomain criteria = new WorkCodeBaseDomain();
        criteria.setClsCode(clsCode);
        criteria.setSe(se);        
 
   
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        //EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        //CommonDb2Domain empInfo = UxisUtil.getDB2Lib(comps);

//        criteria.setLib1(empInfo.getLib1());
 //       criteria.setLib2(empInfo.getLib2());
        
		// 저장된 세션 데이터 불러오기
//		EmpDomain salarayInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        domainlist = workCodeBaseService.searchByCondition(criteria);

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
        String se = ServletRequestUtils.getStringParameter(request, "se");        
        String code = ServletRequestUtils.getStringParameter(request, "code"); 
      
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        //EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
 //       CommonDb2Domain empInfo = UxisUtil.getDB2Lib(delComps);
        
        //존재하는지 체크
        WorkCodeBaseDomain cntDomain = new WorkCodeBaseDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setSe(se);
        cntDomain.setCode(code); 
        int cnt = workCodeBaseService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        WorkCodeBaseDomain delDomain = new WorkCodeBaseDomain();
        delDomain.setClsCode(clsCode);
        delDomain.setSe(se);  
        delDomain.setCode(code);               

        workCodeBaseService.delete(delDomain);

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
        String se = ServletRequestUtils.getStringParameter(request, "se");   
        String code = ServletRequestUtils.getStringParameter(request, "code");

        String codeNm = ServletRequestUtils.getStringParameter(request, "codeNm");
        String startTime = ServletRequestUtils.getStringParameter(request, "startTime");
        String endTime = ServletRequestUtils.getStringParameter(request, "endTime"); 
        String overTimeM = ServletRequestUtils.getStringParameter(request, "overtimeM");  
        String overTimeH = ServletRequestUtils.getStringParameter(request, "overtimeH");          
        
        if(se != null && se.equals("A")) {        
	        if(startTime == null) {
	        	startTime = "0";
	        }else {
	        	String subA = startTime.substring(0, 2);
	        	String subB = startTime.substring(3, 5);         	
	        	startTime = subA+subB;
	        }
	        if(endTime == null) {
	        	endTime = "0";
	        }else {
	        	String subA = endTime.substring(0, 2);
	        	String subB = endTime.substring(3, 5);         	
	        	endTime = subA+subB;
	        }
	        if(overTimeM == null) {
	        	overTimeM = "0";
	        }
	        if(overTimeH == null) {
	        	overTimeH = "0";
	        }       
        }else {
            startTime = "0";
            endTime = "0";            
            overTimeH = "0";     
            overTimeM = "0";      	
        }

        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        //EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
//        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(insComps);
        
        //존재하는지 체크
        WorkCodeBaseDomain cntDomain = new WorkCodeBaseDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setSe(se);          
        cntDomain.setCode(code);  
        
        int cnt = workCodeBaseService.searchCount(cntDomain);
        
        if(cnt > 0) {
            //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;      
        }        
        
        WorkCodeBaseDomain insDomain = new WorkCodeBaseDomain();
        
        insDomain.setClsCode(clsCode);
        insDomain.setSe(se);        
        insDomain.setCode(code);
        insDomain.setCodeNm(codeNm); 
        
        insDomain.setStartTime(startTime);
        insDomain.setEndTime(endTime);             
        insDomain.setOvertimeM(overTimeM);             
        insDomain.setOvertimeH(overTimeH);                      
        
        insDomain.setRegUser(empNumber);
        
        workCodeBaseService.create(insDomain);

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
        String se = ServletRequestUtils.getStringParameter(request, "se");   
        String code = ServletRequestUtils.getStringParameter(request, "code");

        String codeNm = ServletRequestUtils.getStringParameter(request, "codeNm");
        String startTime = ServletRequestUtils.getStringParameter(request, "startTime");
        String endTime = ServletRequestUtils.getStringParameter(request, "endTime"); 
        String overTimeM = ServletRequestUtils.getStringParameter(request, "overtimeM");  
        String overTimeH = ServletRequestUtils.getStringParameter(request, "overtimeH");          
        
        String oldSe = ServletRequestUtils.getStringParameter(request, "oldSe");   
        String oldCode = ServletRequestUtils.getStringParameter(request, "oldCode");        
        
        if(se != null && se.equals("A")) {
	        if(isEmpty(startTime)) {
	        	startTime = "0";
	        }else {
	        	String subA = startTime.substring(0, 2);
	        	String subB = startTime.substring(3, 5);         	
	        	startTime = subA+subB;
	        }
	        if(isEmpty(endTime)) {
	        	endTime = "0";
	        }else {
	        	String subA = endTime.substring(0, 2);
	        	String subB = endTime.substring(3, 5);         	
	        	endTime = subA+subB;
	        }
	        if(overTimeM == null) {
	        	overTimeM = "0";
	        }
	        if(overTimeH == null) {
	        	overTimeH = "0";
	        }   
        }else {
            startTime = "0";
            endTime = "0";            
            overTimeH = "0";     
            overTimeM = "0";        	
        }
        
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
        
        JSONObject jsonObj = new JSONObject();

        
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        //EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
//        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(updComps);
        
        //존재하는지 체크
        WorkCodeBaseDomain cntDomain = new WorkCodeBaseDomain();        

        cntDomain.setClsCode(clsCode);
        cntDomain.setSe(se);        
        cntDomain.setCode(code);
        cntDomain.setOldSe(oldSe);  
        cntDomain.setOldCode(oldCode);
              
        
        int cnt2 = workCodeBaseService.searchCount2(cntDomain);          
        
        if(cnt2 == 0) {
            //jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } else {        
        	//키값 수정 불가능
        	if(!oldSe.equals(se) || !oldCode.equals(code)) {
        		int cnt = workCodeBaseService.searchCount(cntDomain); 
 	        	if(cnt > 0) {
	                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
	        		jsonObj.put("errMsg", "LN_UPD_CHK2");
	                response.setContentType("text/html;charset=utf-8");
	                response.getWriter().print(jsonObj);
	                return;
	            }         		
        		
        		
                //jsonObj.put("errMsg", "키값은 수정이 안 됩니다.");
//        		jsonObj.put("errMsg", "LN_UPD_CHK4");
//                response.setContentType("text/html;charset=utf-8");
//                response.getWriter().print(jsonObj);
//                return;        		
        	}
        }        
        
        
        WorkCodeBaseDomain updDomain = new WorkCodeBaseDomain();
        updDomain.setClsCode(clsCode);
        updDomain.setSe(se);        
        updDomain.setCode(code);
        updDomain.setCodeNm(codeNm); 
        
        updDomain.setStartTime(startTime);
        updDomain.setEndTime(endTime);             
        updDomain.setOvertimeH(overTimeH);        
        updDomain.setOvertimeM(overTimeM);        
        updDomain.setModUser(empNumber); 
        
        updDomain.setOldSe(oldSe);  
        updDomain.setOldCode(oldCode);
        
        workCodeBaseService.update(updDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
    
    private boolean isEmpty(String val) {
    	if(val == null) {
    		return true;
    	}else if(val.equals("0")) { 
    		return true;
    	}else {
    		val = val.trim();
    		if(val.length() == 0) {
    			return true;
    		}
    	}
    	return false;
    }
}
