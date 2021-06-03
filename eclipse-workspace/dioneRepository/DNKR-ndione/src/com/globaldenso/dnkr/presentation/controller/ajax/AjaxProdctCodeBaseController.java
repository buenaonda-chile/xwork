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
import com.globaldenso.dnkr.business.service.ProdctCodeBaseService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.ProdctCodeBaseDomain;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxProdctCodeBase")
public class AjaxProdctCodeBaseController {

    /**
     * [KR] 생산성지표 기준정보(제품관리정보)서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private ProdctCodeBaseService prodctCodeBaseService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxProdctCodeBaseController() {
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
    	
//        String clsCode = ServletRequestUtils.getStringParameter(request, "getComps");  
    	String prdtCode = ServletRequestUtils.getStringParameter(request, "code");
        String prdtName = ServletRequestUtils.getStringParameter(request, "name");
        String startDe = ServletRequestUtils.getStringParameter(request, "startDe");
        
        List<? extends ProdctCodeBaseDomain> domainlist = null;

        ProdctCodeBaseDomain criteria = new ProdctCodeBaseDomain();
//        criteria.setClsCode(clsCode);
        criteria.setPrdtCode(prdtCode);        
        criteria.setPrdtNm(prdtName); 
        criteria.setStartDe(startDe);          
        
		// 저장된 세션 데이터 불러오기
//		EmpDomain salarayInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        domainlist = prodctCodeBaseService.searchByCondition(criteria);

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
        
//        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
        String prdtCode = ServletRequestUtils.getStringParameter(request, "prdtCode");        
        String startDe = ServletRequestUtils.getStringParameter(request, "startDe");  
        String endDe = ServletRequestUtils.getStringParameter(request, "endDe");  
        
    	startDe = startDe.replaceAll("-", "");     
    	endDe = endDe.replaceAll("-", "");         	
        //존재하는지 체크
        ProdctCodeBaseDomain cntDomain = new ProdctCodeBaseDomain();
//        cntDomain.setClsCode(clsCode);
        cntDomain.setPrdtCode(prdtCode);
        cntDomain.setStartDe(startDe);
//        cntDomain.setEndDe(endDe);             
        int cnt = prodctCodeBaseService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        ProdctCodeBaseDomain delDomain = new ProdctCodeBaseDomain();
//        delDomain.setClsCode(clsCode);
        delDomain.setPrdtCode(prdtCode);  
        delDomain.setStartDe(startDe);          
        
//        delDomain.setPyvnd(delPyvnd);
//        delDomain.setMcrcd(delMcrcd);
//        delDomain.setMsecd(delMsecd);
//        delDomain.setMcrc1(delMcrc1);
//        delDomain.setMsec1(delMsec1);
//        delDomain.setLib1(empInfo.getLib1());
//        delDomain.setLib2(empInfo.getLib2());
        prodctCodeBaseService.delete(delDomain);

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
        
//        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
        String prdtCode = ServletRequestUtils.getStringParameter(request, "prdtCode");   
        
        String prdtNm = ServletRequestUtils.getStringParameter(request, "prdtNm");
        String startDe = ServletRequestUtils.getStringParameter(request, "startDe");
        String endDe = ServletRequestUtils.getStringParameter(request, "endDe");
        
        String refrn = ServletRequestUtils.getStringParameter(request, "refrn");
        
        if(startDe == null) {
        	startDe = "0";
        }else {
        	startDe = startDe.replaceAll("-", "");
        }

        if(endDe == null) {
        	endDe = "99991231";
        }else {
        	endDe = endDe.replaceAll("-", "");      	
        }
        
        if(refrn == null) {
        	refrn = "";
        }

        if(prdtCode.length() != 1) {
        	 jsonObj.put("errMsg", "문자열 길이를 확인하세요!");   
             response.setContentType("text/html;charset=utf-8");
             response.getWriter().print(jsonObj);
             return;        	 
        }
        
        //존재하는지 체크
        ProdctCodeBaseDomain cntDomain = new ProdctCodeBaseDomain();
//        cntDomain.setClsCode(clsCode);
        cntDomain.setPrdtCode(prdtCode);          
        cntDomain.setStartDe(startDe);
        cntDomain.setEndDe(endDe);        
        int cnt3 = prodctCodeBaseService.searchCount3(cntDomain);
        
        if(cnt3 > 0) {
            //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;      
        } 
        
        int cnt4 = prodctCodeBaseService.searchCount4(cntDomain);
        
        if(cnt4 > 0) {
            //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;      
        }          
        
        ProdctCodeBaseDomain insDomain = new ProdctCodeBaseDomain();
        
//        insDomain.setClsCode(clsCode);
        insDomain.setPrdtCode(prdtCode);        
        insDomain.setPrdtNm(prdtNm);
        insDomain.setStartDe(startDe);
        insDomain.setEndDe(endDe);
        insDomain.setRefrn(refrn);
        insDomain.setRegUser(empNumber);
        
        prodctCodeBaseService.create(insDomain);

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

//      String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
        String prdtCode = ServletRequestUtils.getStringParameter(request, "prdtCode");   
        
        String prdtNm = ServletRequestUtils.getStringParameter(request, "prdtNm");
        String startDe = ServletRequestUtils.getStringParameter(request, "startDe");
        String endDe = ServletRequestUtils.getStringParameter(request, "endDe");
        String refrn = ServletRequestUtils.getStringParameter(request, "refrn");
       
        if(startDe == null) {
        	startDe = "0";
        }else {
        	startDe = startDe.replaceAll("-", "");        	
        }

        if(endDe == null) {
        	endDe = "99991231";
        }else {
        	endDe = endDe.replaceAll("-", "");        	
        }
        
        if(refrn == null) {
        	refrn = "";
        }
        String oldPrdtCode = ServletRequestUtils.getStringParameter(request, "oldPrdtCode");   
        String oldStartDe = ServletRequestUtils.getStringParameter(request, "oldStartDe");  
        String oldEndDe = ServletRequestUtils.getStringParameter(request, "oldEndDe");            

        EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
        
        JSONObject jsonObj = new JSONObject();
        
        //존재하는지 체크
        ProdctCodeBaseDomain cntDomain = new ProdctCodeBaseDomain();        
//        cntDomain.setClsCode(clsCode);
        cntDomain.setPrdtCode(prdtCode);     
        cntDomain.setOldPrdtCode(oldPrdtCode);  
        cntDomain.setOldStartDe(oldStartDe);
        cntDomain.setOldEndDe(oldEndDe);        
        cntDomain.setStartDe(startDe); 
        cntDomain.setEndDe(endDe);              
        
        int cnt2 = prodctCodeBaseService.searchCount2(cntDomain);         
        
        if(cnt2 == 0) {
            //jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } else {
        	//키값 수정 불가능
//        	if(!oldPrdtCode.equals(prdtCode)) {
       		if(!oldPrdtCode.equals(prdtCode) || !oldStartDe.equals(startDe) || !oldEndDe.equals(endDe)) {  
       			if(!oldPrdtCode.equals(prdtCode)) {
	        		int cnt3 = prodctCodeBaseService.searchCount3(cntDomain);  //기간에 포함 검색
	 	        	if(cnt3 > 0) {
		                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
		        		jsonObj.put("errMsg", "LN_UPD_CHK2");
		                response.setContentType("text/html;charset=utf-8");
		                response.getWriter().print(jsonObj);
		                return;
		            }  
	 	        	
	        		int cnt4 = prodctCodeBaseService.searchCount4(cntDomain);  //기간에 포함 검색
	 	        	if(cnt4 > 0) {
		                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
		        		jsonObj.put("errMsg", "LN_UPD_CHK2");
		                response.setContentType("text/html;charset=utf-8");
		                response.getWriter().print(jsonObj);
		                return;
		            }   
       			}else if(!oldStartDe.equals(startDe) || !oldEndDe.equals(endDe)) {  
	        		int cnt5 = prodctCodeBaseService.searchCount5(cntDomain);  //기간에 포함 검색
	 	        	if(cnt5 > 0) {
		                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
		        		jsonObj.put("errMsg", "LN_UPD_CHK2");
		                response.setContentType("text/html;charset=utf-8");
		                response.getWriter().print(jsonObj);
		                return;
		            }  
	 	        	
	        		int cnt6 = prodctCodeBaseService.searchCount6(cntDomain);  //기간에 포함 검색
	 	        	if(cnt6 > 0) {
		                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
		        		jsonObj.put("errMsg", "LN_UPD_CHK2");
		                response.setContentType("text/html;charset=utf-8");
		                response.getWriter().print(jsonObj);
		                return;
		            }         				
       			}
        	}
        }
        
        ProdctCodeBaseDomain updDomain = new ProdctCodeBaseDomain();   
        updDomain.setPrdtCode(prdtCode);        
        updDomain.setPrdtNm(prdtNm);
        updDomain.setStartDe(startDe);
        updDomain.setEndDe(endDe);
        updDomain.setRefrn(refrn);
        updDomain.setModUser(empNumber); 
        updDomain.setOldPrdtCode(oldPrdtCode);  
        updDomain.setOldStartDe(oldStartDe);          
        
        prodctCodeBaseService.update(updDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}
