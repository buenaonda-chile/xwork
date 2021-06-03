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
import com.globaldenso.dnkr.business.service.WrknTimeBaseService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.WrknTimeBaseDomain;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxWrknTimeBase")
public class AjaxWrknTimeBaseController {

    /**
     * [KR] 생산성지표 기준정보(근무조시간관리)서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private WrknTimeBaseService wrknTimeBaseService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxWrknTimeBaseController() {
        // no process
    }
    
    
    /**
     * [KO] 생산성지표 기준정보(근무조시간관리) 조회.<br>
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
    	String workStle = ServletRequestUtils.getStringParameter(request, "workStle");
    	String group = ServletRequestUtils.getStringParameter(request, "group");
    	
        List<? extends WrknTimeBaseDomain> domainlist = null;

        WrknTimeBaseDomain criteria = new WrknTimeBaseDomain();
        criteria.setClsCode(clsCode);
        criteria.setWorkStle(workStle);        
        criteria.setGroup(group);
   
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        //EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        //CommonDb2Domain empInfo = UxisUtil.getDB2Lib(comps);

//        criteria.setLib1(empInfo.getLib1());
 //       criteria.setLib2(empInfo.getLib2());
        
		// 저장된 세션 데이터 불러오기
//		EmpDomain salarayInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        domainlist = wrknTimeBaseService.searchByCondition(criteria);

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
    	String workStle = ServletRequestUtils.getStringParameter(request, "workStle");
    	String group = ServletRequestUtils.getStringParameter(request, "group"); 
        String appstaDe = ServletRequestUtils.getStringParameter(request, "appstaDe");  
        String appendDe = ServletRequestUtils.getStringParameter(request, "appendDe");   
        appstaDe = appstaDe.replaceAll("-", "");    
        
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        //EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
 //       CommonDb2Domain empInfo = UxisUtil.getDB2Lib(delComps);
        
        //존재하는지 체크
        WrknTimeBaseDomain cntDomain = new WrknTimeBaseDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setWorkStle(workStle);
        cntDomain.setGroup(group);
        cntDomain.setAppstaDe(appstaDe);         
        int cnt = wrknTimeBaseService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        WrknTimeBaseDomain delDomain = new WrknTimeBaseDomain();
        delDomain.setClsCode(clsCode);
        delDomain.setWorkStle(workStle);  
        delDomain.setGroup(group); 
        delDomain.setAppstaDe(appstaDe);;            

        wrknTimeBaseService.delete(delDomain);

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
    	String workStle = ServletRequestUtils.getStringParameter(request, "workStle");
    	String group = ServletRequestUtils.getStringParameter(request, "group");

        String startTime = ServletRequestUtils.getStringParameter(request, "startTime");
        String endTime = ServletRequestUtils.getStringParameter(request, "endTime"); 
        String appstaDe = ServletRequestUtils.getStringParameter(request, "appstaDe");  
        String appendDe = ServletRequestUtils.getStringParameter(request, "appendDe"); 
        String refrn = ServletRequestUtils.getStringParameter(request, "refrn");             
        
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
        if(appstaDe == null) {
        	appstaDe = "0";
        }else {
        	appstaDe = appstaDe.replaceAll("-", "");    
        }

        if(appendDe == null) {
        	appendDe = "99991231";
        }else {
        	appendDe = appendDe.replaceAll("-", "");   
        }
        
        if(refrn == null) {
        	refrn = "";
        }        
        

        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        //EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
//        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(insComps);
        
        //존재하는지 체크
        WrknTimeBaseDomain cntDomain = new WrknTimeBaseDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setWorkStle(workStle); 
        cntDomain.setAppstaDe(appstaDe);
        cntDomain.setAppendDe(appendDe);
        cntDomain.setGroup(group);
        
        int cnt3 = wrknTimeBaseService.searchCount3(cntDomain);
        
        if(cnt3 > 0) {
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;  
        } 
        
        int cnt4 = wrknTimeBaseService.searchCount4(cntDomain);
        
        if(cnt4 > 0) {
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;  
        }          
        
        WrknTimeBaseDomain insDomain = new WrknTimeBaseDomain();
        
        insDomain.setClsCode(clsCode);
        insDomain.setWorkStle(workStle);          
        insDomain.setGroup(group);
        insDomain.setStartTime(startTime);  
        insDomain.setEndTime(endTime);          
        insDomain.setAppstaDe(appstaDe);
        insDomain.setAppendDe(appendDe);       
        insDomain.setRefrn(refrn); 
        
        insDomain.setRegUser(empNumber);
        
        wrknTimeBaseService.create(insDomain);

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
    	String workStle = ServletRequestUtils.getStringParameter(request, "workStle");
    	String group = ServletRequestUtils.getStringParameter(request, "group");

        String startTime = ServletRequestUtils.getStringParameter(request, "startTime");
        String endTime = ServletRequestUtils.getStringParameter(request, "endTime"); 
        String appstaDe = ServletRequestUtils.getStringParameter(request, "appstaDe");  
        String appendDe = ServletRequestUtils.getStringParameter(request, "appendDe"); 
        String refrn = ServletRequestUtils.getStringParameter(request, "refrn");    
        
    	String oldWorkStle = ServletRequestUtils.getStringParameter(request, "oldWorkStle");
    	String oldGroup = ServletRequestUtils.getStringParameter(request, "oldGroup"); 
    	
        String oldAppstaDe = ServletRequestUtils.getStringParameter(request, "oldAppstaDe");  
        String oldAppendDe = ServletRequestUtils.getStringParameter(request, "oldAppendDe");     	
        
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
        if(appstaDe == null) {
        	appstaDe = "0";
        }else {
        	appstaDe = appstaDe.replaceAll("-", "");       	
        }

        if(appendDe == null) {
        	appendDe = "99991231";
        }else {
        	appendDe = appendDe.replaceAll("-", "");           	
        }
        if(refrn == null) {
        	refrn = "";
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
        WrknTimeBaseDomain cntDomain = new WrknTimeBaseDomain();        

        cntDomain.setClsCode(clsCode);
        cntDomain.setWorkStle(workStle);          
        cntDomain.setGroup(group);
        
        cntDomain.setAppstaDe(appstaDe);
        cntDomain.setAppendDe(appendDe);
        
        cntDomain.setOldWorkStle(oldWorkStle);          
        cntDomain.setOldGroup(oldGroup);
        
        cntDomain.setOldAppstaDe(oldAppstaDe);
        cntDomain.setOldAppendDe(oldAppendDe);
        
        
        
        int cnt2 = wrknTimeBaseService.searchCount2(cntDomain);          
        
        if(cnt2 == 0) {
            //jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } else {
        	//키값 수정 불가능
        	if(!oldWorkStle.equals(workStle) || !oldGroup.equals(group)) {
        		int cnt3 = wrknTimeBaseService.searchCount3(cntDomain);
 	        	if(cnt3 > 0) {
	                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
	        		jsonObj.put("errMsg", "LN_UPD_CHK2");
	                response.setContentType("text/html;charset=utf-8");
	                response.getWriter().print(jsonObj);
	                return;
	            }
 	        	
        		int cnt4 = wrknTimeBaseService.searchCount4(cntDomain);
 	        	if(cnt4 > 0) {
	                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
	        		jsonObj.put("errMsg", "LN_UPD_CHK2");
	                response.setContentType("text/html;charset=utf-8");
	                response.getWriter().print(jsonObj);
	                return;
	            } 	        	
      		
   			}else if(!oldAppstaDe.equals(appstaDe) || !oldAppendDe.equals(appendDe)) {  
        		int cnt5 = wrknTimeBaseService.searchCount5(cntDomain);  //기간에 포함 검색
 	        	if(cnt5 > 0) {
	                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
	        		jsonObj.put("errMsg", "LN_UPD_CHK2");
	                response.setContentType("text/html;charset=utf-8");
	                response.getWriter().print(jsonObj);
	                return;
	            }  
 	        	
        		int cnt6 = wrknTimeBaseService.searchCount6(cntDomain);  //기간에 포함 검색
 	        	if(cnt6 > 0) {
	                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
	        		jsonObj.put("errMsg", "LN_UPD_CHK2");
	                response.setContentType("text/html;charset=utf-8");
	                response.getWriter().print(jsonObj);
	                return;
	            }         				
   			}
        }      
        
        WrknTimeBaseDomain updDomain = new WrknTimeBaseDomain();
        updDomain.setClsCode(clsCode);
        updDomain.setWorkStle(workStle);          
        updDomain.setGroup(group);
        updDomain.setStartTime(startTime);  
        updDomain.setEndTime(endTime);          
        updDomain.setAppstaDe(appstaDe);
        updDomain.setAppendDe(appendDe);       
        updDomain.setRefrn(refrn);     
        updDomain.setModUser(empNumber); 
        updDomain.setOldWorkStle(oldWorkStle);          
        updDomain.setOldGroup(oldGroup);    
        updDomain.setOldAppstaDe(oldAppstaDe);
        updDomain.setOldAppendDe(oldAppendDe);         
        
        
        wrknTimeBaseService.update(updDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}
