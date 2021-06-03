package com.globaldenso.dnkr.presentation.controller.ajax;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.globaldenso.dnkr.business.service.LnPrsInpTmService;
import com.globaldenso.dnkr.business.service.PrdPrfrmRgsService;
import com.globaldenso.dnkr.business.service.PrdctIndComBaseService;
import com.globaldenso.dnkr.business.service.ProdctIndctBaseLineService;
import com.globaldenso.dnkr.business.service.StEmpAbsTrdService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.LnPrsInpTmDomain;
import com.globaldenso.dnkr.domain.MnhrCntrBaseBaseDomain;
import com.globaldenso.dnkr.domain.PrdPrfrmRgsDomain;
import com.globaldenso.dnkr.domain.PrdctIndComBaseDomain;
import com.globaldenso.dnkr.domain.ProdctIndctBaseLineDomain;
import com.globaldenso.dnkr.domain.StEmpAbsTrdDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxPrdPrfrmRgs")
public class AjaxPrdPrfrmRgsController {

    /**
     * [KR] 생산실적등록서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private PrdPrfrmRgsService prdPrfrmRgsService;
       
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
    public AjaxPrdPrfrmRgsController() {
        // no process
    }
    
    
    /**
     * [KO] 생산실적등록 조회.<br>
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
        String locCode = ServletRequestUtils.getStringParameter(request, "getLocId");          
        String getOpertDe = ServletRequestUtils.getStringParameter(request, "getOpertDe");  //작업일자
        String getIntType = ServletRequestUtils.getStringParameter(request, "getIntType");  //작업일자        
        
        List<? extends StEmpAbsTrdDomain> domainlist = null;

        StEmpAbsTrdDomain criteria = new StEmpAbsTrdDomain();
        criteria.setClsCode(clsCode);
        criteria.setLocCode(locCode);
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(clsCode);        
        
        List<? extends ProdctIndctBaseLineDomain> prodctIndctBaseLineDomainlist = null;
        ProdctIndctBaseLineDomain prodctIndctBaseLineDomain = new ProdctIndctBaseLineDomain();
        prodctIndctBaseLineDomain.setClsCode(clsCode);
        prodctIndctBaseLineDomain.setLocCode(locCode);        
        
        
        //생산실적등록
        PrdPrfrmRgsDomain prdPrfrmRgsDomain = new PrdPrfrmRgsDomain();

        prdPrfrmRgsDomain.setClsCode(clsCode);
        prdPrfrmRgsDomain.setLocCode(locCode);
        prdPrfrmRgsDomain.setIntType(getIntType);
        prdPrfrmRgsDomain.setOpertDe(getOpertDe);
        prdPrfrmRgsDomain.setLib1(empInfo.getLib1());
        prdPrfrmRgsDomain.setLib2(empInfo.getLib2());
        
        List<PrdPrfrmRgsDomain> prdPrfrmRgsDomainList = prdPrfrmRgsService.searchByCondition(prdPrfrmRgsDomain);
        if(prdPrfrmRgsDomainList != null) {
            jsonObj.put("list", prdPrfrmRgsDomainList);
        }
        
        //인터페이스 정보 취득
        String date = getOpertDe.replaceAll("-", "");
        List<PrdPrfrmRgsDomain> resultIfList = new ArrayList<PrdPrfrmRgsDomain>();
        prdPrfrmRgsDomain.setOpertDeMon(date.substring(0,6));
        prdPrfrmRgsDomain.setDay(date.substring(6,8));
        prdPrfrmRgsDomain.setOpertDe(date);
        //MES 정보 취득
        prodctIndctBaseLineDomain.setIfType("M");
        int countM = prodctIndctBaseLineService.searchCount3(prodctIndctBaseLineDomain);
        List<PrdPrfrmRgsDomain> prdPrfrmRgsDomainMesList = null;
        if(countM > 0) {
            HashMap locCodeMap = new HashMap();
            HashMap lineCodeMap = new HashMap();
            HashMap lineNmMap = new HashMap(); 
            HashMap ifType = new HashMap();             
        	prodctIndctBaseLineDomainlist = prodctIndctBaseLineService.searchByCondition(prodctIndctBaseLineDomain);
	        if(prodctIndctBaseLineService != null) {
	        	for(int i = 0; i < prodctIndctBaseLineDomainlist.size(); i++) {
	        		ProdctIndctBaseLineDomain prdtDomain = prodctIndctBaseLineDomainlist.get(i);
	        		String kClsCode = prdtDomain.getClsCode();  //사업부
	        		String kLocCode = prdtDomain.getLocCode();  //부서(반)
	        		String kIfCode = prdtDomain.getIfCode();
	        		String kLineCode = prdtDomain.getLineCode();   		
	        		String kLineNm = prdtDomain.getLineNm(); 
	        		String kIfType = prdtDomain.getIfType();     		
	        		
	        		// MES는 부서코드가 없어 라인기준정보에서 가져온다.
	        		if(kIfCode != null && kIfType != null && kIfCode.length() > 0 && kIfType.length() > 0  ) {
	        			locCodeMap.put(kIfCode,kLocCode);
	        			lineCodeMap.put(kIfCode,kLineCode);
	        			lineNmMap.put(kIfCode,kLineNm);        
	        		}
	        	}
	        }
	        


	        if(clsCode.equals("E1")) {
	        	prdPrfrmRgsDomainMesList = prdPrfrmRgsService.searchByConditionMesE1(prdPrfrmRgsDomain);
	        }else if(clsCode.equals("S1")) {
	        	prdPrfrmRgsDomainMesList = prdPrfrmRgsService.searchByConditionMesS1(prdPrfrmRgsDomain);        	
	        }else if(clsCode.equals("C1")) {
	        	prdPrfrmRgsDomainMesList = prdPrfrmRgsService.searchByConditionMesC1(prdPrfrmRgsDomain);        	
	        }
     
	        if(prdPrfrmRgsDomainMesList != null) {
	        	for(int i = 0; i < prdPrfrmRgsDomainMesList.size(); i++) {
	        		PrdPrfrmRgsDomain domain = prdPrfrmRgsDomainMesList.get(i);
	        		
	        		String ifCode = domain.getIfCode();
	        		if(null != ifCode) {
	        			String lineLocCode = (String)locCodeMap.get(ifCode);
	        			String lineCode = (String)lineCodeMap.get(ifCode); 
	        			String lineNm = (String)lineNmMap.get(ifCode);    
	        			
	        			//같은 부서정보만 표시
	        			if(null != lineCode && lineLocCode.equals(locCode)) {
	        				domain.setClsCode(clsCode);
	        				domain.setLineCode(lineCode);
	        				domain.setLocCode(lineLocCode);
	        				domain.setOpertDe(date);
	        				domain.setLineNm(lineNm);
	        				domain.setIntType("I");
	        				resultIfList.add(domain);
	        			}        			
	        		}
	        	}        	
	        }
        }

        //QR 정보 취득
        prodctIndctBaseLineDomain.setIfType("Q");
        int countQ = prodctIndctBaseLineService.searchCount3(prodctIndctBaseLineDomain);

        if(countQ > 0) {
	        List<PrdPrfrmRgsDomain> prdPrfrmRgsDomainQrList = prdPrfrmRgsService.searchByConditionQr(prdPrfrmRgsDomain);        
	        if(prdPrfrmRgsDomainQrList != null) {
		        for(int i =0; i < prdPrfrmRgsDomainQrList.size(); i ++) {
		        	PrdPrfrmRgsDomain domain = prdPrfrmRgsDomainQrList.get(i);
		        	domain.setOpertDe(date);
		        	domain.setIntType("I");
		        	resultIfList.add(domain);
		        }
	        }
        }
        
        jsonObj.put("listIf", resultIfList);
        
        
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
    @RequestMapping(value = "/search2", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void search2(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
    	JSONObject jsonObj = new JSONObject();
    	
        String clsCode = ServletRequestUtils.getStringParameter(request, "getComps");  
        String locCode = ServletRequestUtils.getStringParameter(request, "getLocId");          
        String getOpertDe = ServletRequestUtils.getStringParameter(request, "getOpertDe");  //작업일자
        String getIntType = ServletRequestUtils.getStringParameter(request, "getIntType");  //작업일자        
        
        StEmpAbsTrdDomain criteria = new StEmpAbsTrdDomain();
        criteria.setClsCode(clsCode);
        criteria.setLocCode(locCode);
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(clsCode);        
        
        //생산실적등록
        PrdPrfrmRgsDomain prdPrfrmRgsDomain = new PrdPrfrmRgsDomain();

        prdPrfrmRgsDomain.setClsCode(clsCode);
        prdPrfrmRgsDomain.setLocCode(locCode);
        prdPrfrmRgsDomain.setIntType(getIntType);
        prdPrfrmRgsDomain.setOpertDe(getOpertDe);
        prdPrfrmRgsDomain.setLib1(empInfo.getLib1());
        prdPrfrmRgsDomain.setLib2(empInfo.getLib2());        
        
        List<PrdPrfrmRgsDomain> prdPrfrmRgsDomainList = prdPrfrmRgsService.searchByCondition(prdPrfrmRgsDomain);
        
        if(prdPrfrmRgsDomainList != null) {
            jsonObj.put("list", prdPrfrmRgsDomainList);
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

        String opertDe = ServletRequestUtils.getStringParameter(request, "opertDe");
        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");     
        String lineCode = ServletRequestUtils.getStringParameter(request, "lineCode");           
        String productNo = ServletRequestUtils.getStringParameter(request, "productNo");  
        String intType = ServletRequestUtils.getStringParameter(request, "intType");
 
        //존재하는지 체크
        PrdPrfrmRgsDomain cntDomain = new PrdPrfrmRgsDomain();
        cntDomain.setOpertDe(opertDe);
        cntDomain.setClsCode(clsCode);
        cntDomain.setLocCode(locCode);
        cntDomain.setLineCode(lineCode);
        cntDomain.setProductNo(productNo);
        cntDomain.setIntType(intType);

        int cnt = prdPrfrmRgsService.searchCount(cntDomain);
        
        if(cnt == 0) {
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        PrdPrfrmRgsDomain delDomain = new PrdPrfrmRgsDomain();
        delDomain.setOpertDe(opertDe);
        delDomain.setClsCode(clsCode);
        delDomain.setLocCode(locCode);
        delDomain.setLineCode(lineCode);
        delDomain.setProductNo(productNo);   
        delDomain.setIntType(intType);        
        prdPrfrmRgsService.delete(delDomain);

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
        String opertDe = ServletRequestUtils.getStringParameter(request, "opertDe");      	
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");        
        String lineCode = ServletRequestUtils.getStringParameter(request, "lineCode");
        String productNo = ServletRequestUtils.getStringParameter(request, "productNo");  
        String intType = ServletRequestUtils.getStringParameter(request, "intType");
        String qy = ServletRequestUtils.getStringParameter(request, "qy");       
        
        //존재하는지 체크
        PrdPrfrmRgsDomain cntDomain = new PrdPrfrmRgsDomain();
        opertDe = opertDe.replaceAll("-","");
        cntDomain.setOpertDe(opertDe); //작업일자     
        cntDomain.setClsCode(clsCode); 
        cntDomain.setLocCode(locCode); 
        cntDomain.setLineCode(lineCode);
        cntDomain.setProductNo(productNo);
        cntDomain.setIntType("M");
        
        int cnt = prdPrfrmRgsService.searchCount(cntDomain);
        
        if(cnt > 0) {
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;  
        } 
        
        PrdPrfrmRgsDomain insDomain = new PrdPrfrmRgsDomain();
        insDomain.setOpertDe(opertDe); //작업일자     
        insDomain.setClsCode(clsCode); 
        insDomain.setLocCode(locCode); 
        insDomain.setLineCode(lineCode);
        insDomain.setProductNo(productNo);
        insDomain.setIntType("M");
        insDomain.setQy(qy);
        insDomain.setRegUser(empNumber);
        prdPrfrmRgsService.create(insDomain);

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
		JSONObject jsonObj = new JSONObject();

		String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
		String opertDe = ServletRequestUtils.getStringParameter(request, "opertDe");
		String locCode = ServletRequestUtils.getStringParameter(request, "locCode");
		String lineCode = ServletRequestUtils.getStringParameter(request, "lineCode");
		String productNo = ServletRequestUtils.getStringParameter(request, "productNo");
		String intType = ServletRequestUtils.getStringParameter(request, "intType");
		String qy = ServletRequestUtils.getStringParameter(request, "qy");
		
		String oldLineCode = ServletRequestUtils.getStringParameter(request, "oldLineCode");
		String oldProductNo = ServletRequestUtils.getStringParameter(request, "oldProductNo");		

		EmpDomain empInfo = (EmpDomain) request.getSession().getAttribute("EMP_DOMAIN");
		String userId = empInfo.getEmpId();
		String empNumber = empInfo.getEmpNumber();
		String userName = empInfo.getEmpName();

		// 존재하는지 체크
		PrdPrfrmRgsDomain cntDomain = new PrdPrfrmRgsDomain();
		cntDomain.setOpertDe(opertDe); // 작업일자
		cntDomain.setClsCode(clsCode);
		cntDomain.setLocCode(locCode);
		cntDomain.setLineCode(lineCode);
		cntDomain.setProductNo(productNo);
		
		cntDomain.setOldLineCode(oldLineCode);
		cntDomain.setOldProductNo(oldProductNo);		
		cntDomain.setIntType(intType);

		int cnt2 = prdPrfrmRgsService.searchCount2(cntDomain);

		if (cnt2 == 0) {
			// jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.)");
			jsonObj.put("errMsg", "LN_UPD_CHK1");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(jsonObj);
			return;
		} else {
			// 키값 수정 불가능
			if (!lineCode.equals(oldLineCode) || !productNo.equals(oldProductNo)) {
        		int cnt = prdPrfrmRgsService.searchCount(cntDomain); 
 	        	if(cnt > 0) {
	                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
	        		jsonObj.put("errMsg", "LN_UPD_CHK2");
	                response.setContentType("text/html;charset=utf-8");
	                response.getWriter().print(jsonObj);
	                return;
	            }  				
			}
		}

		PrdPrfrmRgsDomain updDomain = new PrdPrfrmRgsDomain();
		updDomain.setOpertDe(opertDe); //작업일자     
		updDomain.setClsCode(clsCode); 
		updDomain.setLocCode(locCode); 
		updDomain.setLineCode(lineCode);
		updDomain.setProductNo(productNo);
		updDomain.setIntType(intType);
		updDomain.setQy(qy);
		
		updDomain.setOldLineCode(oldLineCode);
		updDomain.setOldProductNo(oldProductNo);		
		
		updDomain.setModUser(empNumber);

		prdPrfrmRgsService.update(updDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        
        return;       
    }

    /**
     * [KO] I/F 수정.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update2", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAN000")
    public void update2(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {
		JSONObject jsonObj = new JSONObject();

		String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
		String opertDe = ServletRequestUtils.getStringParameter(request, "opertDe");
		String locCode = ServletRequestUtils.getStringParameter(request, "locCode");
		String lineCode = ServletRequestUtils.getStringParameter(request, "lineCode");
		String productNo = ServletRequestUtils.getStringParameter(request, "productNo");
		String intType = ServletRequestUtils.getStringParameter(request, "intType");
		String qy = ServletRequestUtils.getStringParameter(request, "qy");
		
		String oldLineCode = ServletRequestUtils.getStringParameter(request, "oldLineCode");
		String oldProductNo = ServletRequestUtils.getStringParameter(request, "oldProductNo");		

		EmpDomain empInfo = (EmpDomain) request.getSession().getAttribute("EMP_DOMAIN");
		String userId = empInfo.getEmpId();
		String empNumber = empInfo.getEmpNumber();
		String userName = empInfo.getEmpName();

		// 존재하는지 체크
		PrdPrfrmRgsDomain cntDomain = new PrdPrfrmRgsDomain();
		cntDomain.setOpertDe(opertDe); // 작업일자
		cntDomain.setClsCode(clsCode);
		cntDomain.setLocCode(locCode);
		cntDomain.setLineCode(lineCode);
		cntDomain.setProductNo(productNo);
        cntDomain.setIntType("I");		

		int cntOld = prdPrfrmRgsService.searchCount(cntDomain);

		if (cntOld == 0) {
	        PrdPrfrmRgsDomain insDomain = new PrdPrfrmRgsDomain();
	        insDomain.setOpertDe(opertDe); //작업일자     
	        insDomain.setClsCode(clsCode); 
	        insDomain.setLocCode(locCode); 
	        insDomain.setLineCode(lineCode);
	        insDomain.setProductNo(productNo);
	        insDomain.setIntType("I");
	        insDomain.setQy(qy);
	        insDomain.setRegUser(empNumber);
	        prdPrfrmRgsService.create(insDomain);

            jsonObj.put("result", DnkrConstans.RESULT_OK);        
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);  	        
		} else {
			PrdPrfrmRgsDomain updDomain = new PrdPrfrmRgsDomain();
			updDomain.setOpertDe(opertDe); //작업일자     
			updDomain.setClsCode(clsCode); 
			updDomain.setLocCode(locCode); 
			updDomain.setLineCode(lineCode);
			updDomain.setProductNo(productNo);
			updDomain.setIntType(intType);
			updDomain.setQy(qy);
			
			updDomain.setOldLineCode(oldLineCode);
			updDomain.setOldProductNo(oldProductNo);		
			
			updDomain.setModUser(empNumber);

	        jsonObj.put("result", DnkrConstans.RESULT_OK);        
	        response.setContentType("text/html;charset=utf-8");
	        response.getWriter().print(jsonObj);			
		}

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
    
    private String isEmptyToZero(String val) {
    	if(isEmpty(val)) {
    		return "0";
    	}else {
    		return val;
    	}
    }    
    
}
