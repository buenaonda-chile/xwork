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
import com.globaldenso.dnkr.business.service.PrdPrfByItmNmbService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.MnhrCntrBaseBaseDomain;
import com.globaldenso.dnkr.domain.PrdPrfByItmNmbDomain;
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
@RequestMapping(value = "/ajaxPrdPrfByItmNmb")
public class AjaxPrdPrfByItmNmbController {

    /**
     * [KR] 생산성지표 기준정보(공정관리)서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private PrdPrfByItmNmbService prdPrfByItmNmbService;
        
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxPrdPrfByItmNmbController() {
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
    	
        String comps = ServletRequestUtils.getStringParameter(request, "getComps");  
        String repym = ServletRequestUtils.getStringParameter(request, "getRepym");
        String locCode = ServletRequestUtils.getStringParameter(request, "getLocId");
        
        List<? extends PrdPrfByItmNmbDomain> domainlist = null;

        PrdPrfByItmNmbDomain criteria = new PrdPrfByItmNmbDomain();
        criteria.setClsCode(comps);        
        criteria.setRepym(repym);
        criteria.setLocCode(locCode);              
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(comps);
        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
		// 저장된 세션 데이터 불러오기
//		EmpDomain salarayInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        domainlist = prdPrfByItmNmbService.searchByCondition(criteria);
        
//        ItemMasterDomain itemMasterDomain = new ItemMasterDomain();
//        itemMasterDomain.setLib1(empInfo.getLib1());
//        itemMasterDomain.setLib2(empInfo.getLib2());             
//       List<ItemMasterDomain> itemMasterList = itemMasterService.searchByCondition(itemMasterDomain);
        
        if(domainlist != null) {
            jsonObj.put("list", domainlist);
//            jsonObj.put("itemMasterDomainList", itemMasterList);            
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
        String prdtNo = ServletRequestUtils.getStringParameter(request, "prdtNo");  
        
    	String year = ServletRequestUtils.getStringParameter(request, "year");
        String fsHalf = ServletRequestUtils.getStringParameter(request, "fsHalf");        
        
        //존재하는지 체크
        PrdPrfByItmNmbDomain cntDomain = new PrdPrfByItmNmbDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setYear(year);
        cntDomain.setFsHalf(fsHalf);
        
        cntDomain.setLineCode(lineCode);   
        cntDomain.setPrdtNo(prdtNo);       
        int cnt = prdPrfByItmNmbService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        PrdPrfByItmNmbDomain delDomain = new PrdPrfByItmNmbDomain();
        delDomain.setClsCode(clsCode);
        delDomain.setYear(year);
        delDomain.setFsHalf(fsHalf);
        delDomain.setLineCode(lineCode);        
        delDomain.setPrdtNo(prdtNo);                
        prdPrfByItmNmbService.delete(delDomain);

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
    	try {
        JSONObject jsonObj = new JSONObject();

		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
        
        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
        String lineCode = ServletRequestUtils.getStringParameter(request, "lineCode");   
        String prdtNo = ServletRequestUtils.getStringParameter(request, "prdtNo");
        String drctHdcn = ServletRequestUtils.getStringParameter(request, "drctHdcn");  
        String indrHdcn = ServletRequestUtils.getStringParameter(request, "indrHdcn");          
        String jmLabor = ServletRequestUtils.getStringParameter(request, "jmLabor");   
        String prfrTime = ServletRequestUtils.getStringParameter(request, "prfrTime");   
        String excTmRt = ServletRequestUtils.getStringParameter(request, "excTmRt");          
        String indTmRt = ServletRequestUtils.getStringParameter(request, "indTmRt");          
        String excIndRt = ServletRequestUtils.getStringParameter(request, "excIndRt");  
        String stdrLabor = ServletRequestUtils.getStringParameter(request, "stdrLabor");
        String cycleTime = ServletRequestUtils.getStringParameter(request, "cycleTime");               
        String uph = ServletRequestUtils.getStringParameter(request, "uph"); 
    	String year = ServletRequestUtils.getStringParameter(request, "year");
        String fsHalf = ServletRequestUtils.getStringParameter(request, "fsHalf");          
        
        if(isEmpty(drctHdcn)) {
        	drctHdcn = "0";
        }
        if(isEmpty(jmLabor)) {
        	jmLabor = "0";
        }
        if(isEmpty(indrHdcn)) {
        	indrHdcn = "0";
        }
        if(isEmpty(prfrTime)) {
        	prfrTime = "0";
        }
        if(isEmpty(excTmRt)) {
        	excTmRt = "0";
        }
        if(isEmpty(indTmRt)) {
        	indTmRt = "0";
        }
        if(isEmpty(excIndRt)) {
        	excIndRt = "0";
        }
        if(isEmpty(stdrLabor)) {
        	stdrLabor = "0";
        }
        if(isEmpty(cycleTime)) {
        	cycleTime = "0";
        }        
        if(isEmpty(uph)) {
        	uph = "0";
        }         

        //존재하는지 체크
        PrdPrfByItmNmbDomain cntDomain = new PrdPrfByItmNmbDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setLineCode(lineCode);  
        cntDomain.setPrdtNo(prdtNo);   
        cntDomain.setYear(year);           
        cntDomain.setFsHalf(fsHalf);

        int cnt = prdPrfByItmNmbService.searchCount(cntDomain);
        
        if(cnt > 0) {
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;  
        }      
        
        PrdPrfByItmNmbDomain insDomain = new PrdPrfByItmNmbDomain();
        
        insDomain.setClsCode(clsCode);
        insDomain.setYear(year);        
        insDomain.setFsHalf(fsHalf);
        insDomain.setLineCode(lineCode);  
        insDomain.setLineCode(lineCode);
        insDomain.setPrdtNo(prdtNo);  
        insDomain.setLocCode("");     
        insDomain.setDrctHdcn(drctHdcn);            
        insDomain.setIndrHdcn(indrHdcn); 
        insDomain.setJmLabor(jmLabor);             
        insDomain.setPrfrTime(prfrTime);   
        insDomain.setExcTmRt(excTmRt);         
        insDomain.setIndTmRt(indTmRt);          
        insDomain.setExcIndRt(excIndRt);  
        insDomain.setStdrLabor(stdrLabor);  
        insDomain.setCycleTime(cycleTime);         
        insDomain.setUph(uph);                  
        
        insDomain.setRegUser(empNumber);
        
        prdPrfByItmNmbService.create(insDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
	} catch (Exception e) {
		e.printStackTrace();
	    throw e;
	}
       
        
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
        String prdtNo = ServletRequestUtils.getStringParameter(request, "prdtNo");
        String drctHdcn = ServletRequestUtils.getStringParameter(request, "drctHdcn");  
        String indrHdcn = ServletRequestUtils.getStringParameter(request, "indrHdcn");          
        String jmLabor = ServletRequestUtils.getStringParameter(request, "jmLabor");   
        String prfrTime = ServletRequestUtils.getStringParameter(request, "prfrTime");   
        String excTmRt = ServletRequestUtils.getStringParameter(request, "excTmRt");          
        String indTmRt = ServletRequestUtils.getStringParameter(request, "indTmRt");          
        String excIndRt = ServletRequestUtils.getStringParameter(request, "excIndRt");  
        String stdrLabor = ServletRequestUtils.getStringParameter(request, "stdrLabor");
        String cycleTime = ServletRequestUtils.getStringParameter(request, "cycleTime");               
        String uph = ServletRequestUtils.getStringParameter(request, "uph");
        
        String oldLineCode = ServletRequestUtils.getStringParameter(request, "oldLineCode");   
        String oldPrdtNo = ServletRequestUtils.getStringParameter(request, "oldPrdtNo");
        
    	String year = ServletRequestUtils.getStringParameter(request, "year");
        String fsHalf = ServletRequestUtils.getStringParameter(request, "fsHalf");          
    	String oldYear = ServletRequestUtils.getStringParameter(request, "oldYear");
        String oldFsHalf = ServletRequestUtils.getStringParameter(request, "oldFsHalf");           

        
        if(isEmpty(drctHdcn)) {
        	drctHdcn = "0";
        }
        if(isEmpty(jmLabor)) {
        	jmLabor = "0";
        }
        if(isEmpty(indrHdcn)) {
        	indrHdcn = "0";
        }
        if(isEmpty(prfrTime)) {
        	prfrTime = "0";
        }
        if(isEmpty(excTmRt)) {
        	excTmRt = "0";
        }
        if(isEmpty(indTmRt)) {
        	indTmRt = "0";
        }
        if(isEmpty(excIndRt)) {
        	excIndRt = "0";
        }
        if(isEmpty(stdrLabor)) {
        	stdrLabor = "0";
        }
        if(isEmpty(cycleTime)) {
        	cycleTime = "0";
        }        
        if(isEmpty(uph)) {
        	uph = "0";
        }      
        
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
        
        JSONObject jsonObj = new JSONObject();

        //존재하는지 체크
        PrdPrfByItmNmbDomain cntDomain = new PrdPrfByItmNmbDomain();        
        cntDomain.setClsCode(clsCode);
        cntDomain.setLineCode(lineCode);
        cntDomain.setPrdtNo(prdtNo);  
        
        cntDomain.setYear(year);
        cntDomain.setFsHalf(fsHalf);
        
        cntDomain.setOldLineCode(oldLineCode);  
        cntDomain.setOldPrdtNo(oldPrdtNo);  
        cntDomain.setOldYear(oldYear);
        cntDomain.setOldFsHalf(oldFsHalf);        
        
        int cnt2 = prdPrfByItmNmbService.searchCount2(cntDomain);   
        if(cnt2 == 0) {
            //jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } else {         
        	//키값 수정 불가능
        	if(!lineCode.equals(oldLineCode) || !prdtNo.equals(oldPrdtNo)) {
        		int cnt = prdPrfByItmNmbService.searchCount(cntDomain);  
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
  
        PrdPrfByItmNmbDomain updDomain = new PrdPrfByItmNmbDomain();   
    	updDomain.setClsCode(clsCode);

    	updDomain.setYear(year);
    	updDomain.setFsHalf(fsHalf);    	
    	
    	updDomain.setLineCode(lineCode);
    	updDomain.setPrdtNo(prdtNo);    
    	updDomain.setDrctHdcn(drctHdcn);            
    	updDomain.setIndrHdcn(indrHdcn);          
    	updDomain.setPrfrTime(prfrTime);   
    	updDomain.setExcTmRt(excTmRt);         
    	updDomain.setIndTmRt(indTmRt);          
    	updDomain.setExcIndRt(excIndRt);  
    	updDomain.setStdrLabor(stdrLabor);  
    	updDomain.setCycleTime(cycleTime);   
    	updDomain.setJmLabor(jmLabor);           	
    	updDomain.setUph(uph);   
    	updDomain.setModUser(empNumber); 
    	
    	updDomain.setOldLineCode(oldLineCode);  
    	updDomain.setOldPrdtNo(oldPrdtNo);  
    	updDomain.setOldYear(oldYear);
    	updDomain.setOldFsHalf(oldFsHalf);     	
    	
    	prdPrfByItmNmbService.update(updDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);       
        
        return;
    }
    
    private boolean isEmpty(Object obj) {
        if (obj == null) { return true; }
        if ((obj instanceof String) && (((String)obj).trim().length() == 0)) { return true; } 
        if (obj instanceof List) { return ((List<?>)obj).isEmpty(); }
        if (obj instanceof Object[]) { return (((Object[])obj).length == 0); } 

        return false;
    }
}
