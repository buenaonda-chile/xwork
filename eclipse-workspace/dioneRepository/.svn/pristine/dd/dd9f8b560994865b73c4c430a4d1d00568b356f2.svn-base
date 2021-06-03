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
import com.globaldenso.dnkr.business.service.ProdctIndctBaseLineService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.ProdctIndctBaseLineDomain;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxProdctIndctBaseLine")
public class AjaxProdctIndctBaseLineController {

    /**
     * [KR] 생산성지표 기준정보(라인기준정보)서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private ProdctIndctBaseLineService prodctIndctBaseLineService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxProdctIndctBaseLineController() {
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
    	String lineCode = ServletRequestUtils.getStringParameter(request, "code");
        String lineNm = ServletRequestUtils.getStringParameter(request, "name");

        List<? extends ProdctIndctBaseLineDomain> domainlist = null;

        ProdctIndctBaseLineDomain criteria = new ProdctIndctBaseLineDomain();
        criteria.setClsCode(clsCode);
        criteria.setLineCode(lineCode);
        criteria.setLineNm(lineNm);
        
		// 저장된 세션 데이터 불러오기
//		EmpDomain salarayInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        domainlist = prodctIndctBaseLineService.searchByCondition(criteria);

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
        String lineCode = ServletRequestUtils.getStringParameter(request, "lineCode");        
        
        //존재하는지 체크
        ProdctIndctBaseLineDomain cntDomain = new ProdctIndctBaseLineDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setLineCode(lineCode);        
        int cnt = prodctIndctBaseLineService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        ProdctIndctBaseLineDomain delDomain = new ProdctIndctBaseLineDomain();
        delDomain.setClsCode(clsCode);
        delDomain.setLineCode(lineCode);        
//        delDomain.setPyvnd(delPyvnd);
//        delDomain.setMcrcd(delMcrcd);
//        delDomain.setMsecd(delMsecd);
//        delDomain.setMcrc1(delMcrc1);
//        delDomain.setMsec1(delMsec1);
//        delDomain.setLib1(empInfo.getLib1());
//        delDomain.setLib2(empInfo.getLib2());
        prodctIndctBaseLineService.delete(delDomain);

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
        String lineCode = ServletRequestUtils.getStringParameter(request, "lineCode");   
        
        String lineNm = ServletRequestUtils.getStringParameter(request, "lineNm");
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");
        String partCode = ServletRequestUtils.getStringParameter(request, "partCode");
        String teamCode = "";
        String lcodeGb = ServletRequestUtils.getStringParameter(request, "lcodeGb");         
        String workStle = ServletRequestUtils.getStringParameter(request, "workStle");
        String prdtCode1 = ServletRequestUtils.getStringParameter(request, "prdtCode1");
        String ifCode = ServletRequestUtils.getStringParameter(request, "ifCode");
        String ifType = ServletRequestUtils.getStringParameter(request, "ifType");        

        if(ifCode == null) {
        	ifCode = "";
        }        
        if(ifType == null) {
        	ifType = "";
        }        

        
        String prdtCode2 = ServletRequestUtils.getStringParameter(request, "prdtCode2");
        if(prdtCode2 == null) {
        	prdtCode2 = "";
        }
        String prdtCode3 = ServletRequestUtils.getStringParameter(request, "prdtCode3");
        if(prdtCode3 == null) {
        	prdtCode3 = "";
        }

        //존재하는지 체크
        ProdctIndctBaseLineDomain cntDomain = new ProdctIndctBaseLineDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setLineCode(lineCode);          

        int cnt = prodctIndctBaseLineService.searchCount(cntDomain);
        
        if(cnt > 0) {
            //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;               
        }      
        
        ProdctIndctBaseLineDomain insDomain = new ProdctIndctBaseLineDomain();
        
        insDomain.setClsCode(clsCode);
        insDomain.setLineCode(lineCode);        
        insDomain.setLineNm(lineNm);
        insDomain.setLocCode(locCode);
        insDomain.setPartCode(partCode);
        insDomain.setTeamCode(teamCode);
        insDomain.setLcodeGb(lcodeGb);        
        insDomain.setWorkStle(workStle);
        insDomain.setPrdtCode1(prdtCode1);
        insDomain.setPrdtCode2(prdtCode2);
        insDomain.setPrdtCode3(prdtCode3);
        insDomain.setIfCode(ifCode);
        insDomain.setIfType(ifType);        
        insDomain.setRegUser(empNumber);
        
        
        prodctIndctBaseLineService.create(insDomain);

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
        String lineCode = ServletRequestUtils.getStringParameter(request, "lineCode");   
        
        String lineNm = ServletRequestUtils.getStringParameter(request, "lineNm");
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");
        String partCode = ServletRequestUtils.getStringParameter(request, "partCode");
        String teamCode = "";
        String lcodeGb = ServletRequestUtils.getStringParameter(request, "lcodeGb");        
        String workStle = ServletRequestUtils.getStringParameter(request, "workStle");
        String prdtCode1 = ServletRequestUtils.getStringParameter(request, "prdtCode1");
        String prdtCode2 = ServletRequestUtils.getStringParameter(request, "prdtCode2");
        String prdtCode3 = ServletRequestUtils.getStringParameter(request, "prdtCode3");
        String ifCode = ServletRequestUtils.getStringParameter(request, "ifCode"); 
        String ifType = ServletRequestUtils.getStringParameter(request, "ifType");         
        
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
        
        JSONObject jsonObj = new JSONObject();

        String paymentCd = ServletRequestUtils.getStringParameter(request, "paymentCd");
        String paymentNm = ServletRequestUtils.getStringParameter(request, "paymentNm");
        String dscrp = ServletRequestUtils.getStringParameter(request, "dscrp");

        String oldLineCode = ServletRequestUtils.getStringParameter(request, "oldLineCode");
        
        //존재하는지 체크
        ProdctIndctBaseLineDomain cntDomain = new ProdctIndctBaseLineDomain();        
        cntDomain.setClsCode(clsCode);
        cntDomain.setLineCode(lineCode);       
        cntDomain.setOldLineCode(oldLineCode);          
        
        int cnt2 = prodctIndctBaseLineService.searchCount2(cntDomain); 
        if(cnt2 == 0) {
            //jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;        
        } else {
        	//코드값 수정 불가능
        	if(!oldLineCode.equals(lineCode)) {
        		int cnt = prodctIndctBaseLineService.searchCount(cntDomain);  
 	        	if(cnt > 0) {
	                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
	        		jsonObj.put("errMsg", "LN_UPD_CHK2");
	                response.setContentType("text/html;charset=utf-8");
	                response.getWriter().print(jsonObj);
	                return;
	            }
        		
//                //jsonObj.put("errMsg", "키값은 수정이 안 됩니다.");
//        		jsonObj.put("errMsg", "LN_UPD_CHK4");
//                response.setContentType("text/html;charset=utf-8");
//                response.getWriter().print(jsonObj);
//                return;        		
        	}
        }
        
        ProdctIndctBaseLineDomain updDomain = new ProdctIndctBaseLineDomain();   
        updDomain.setClsCode(clsCode);
        updDomain.setLineCode(lineCode);        
        updDomain.setLineNm(lineNm);
        updDomain.setLocCode(locCode);
        updDomain.setPartCode(partCode);
        updDomain.setTeamCode(teamCode);
        
        updDomain.setLcodeGb(lcodeGb);        
        updDomain.setWorkStle(workStle);
        updDomain.setPrdtCode1(prdtCode1);
        updDomain.setPrdtCode2(prdtCode2);
        updDomain.setPrdtCode3(prdtCode3);
        updDomain.setIfCode(ifCode);
        updDomain.setIfType(ifType);        
        updDomain.setModUser(empNumber); 
        updDomain.setOldLineCode(oldLineCode);         
        
        prodctIndctBaseLineService.update(updDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}
