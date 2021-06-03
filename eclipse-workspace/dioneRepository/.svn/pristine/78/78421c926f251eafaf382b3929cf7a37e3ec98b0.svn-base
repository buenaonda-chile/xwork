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
import com.globaldenso.dnkr.business.service.PrdctIndComBaseService;
import com.globaldenso.dnkr.business.service.PrdctSvcPsnlInputService;
import com.globaldenso.dnkr.business.service.WrkrInfoBaseService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.PrdctIndComBaseDomain;
import com.globaldenso.dnkr.domain.PrdctSvcPsnlInputDomain;
import com.globaldenso.dnkr.domain.WrkrInfoBaseDomain;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxWrkrInfoBase")
public class AjaxWrkrInfoBaseController {

    /**
     * [KR] 생산성지표 기준정보(작업자정보관리)서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private WrkrInfoBaseService wrkrInfoBaseService;

    
    /**
     * [KR] 생산성지표 기준정보(생산용역인원관리)서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private PrdctSvcPsnlInputService prdctSvcPsnlInputService;
    
    
    /**
     * [KR] 생산성지표 기준정보(공통마스타)서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private PrdctIndComBaseService prdctIndComBaseService;    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxWrkrInfoBaseController() {
        // no process
    }
    
    
    /**
     * [KO] 생산성지표 기준정보(작업자정보관리) 조회.<br>
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

        List<? extends WrkrInfoBaseDomain> domainlist = null;

        WrkrInfoBaseDomain criteria = new WrkrInfoBaseDomain();
        criteria.setClsCode(clsCode);
        criteria.setLocCode(locCode);    
           
        
        //더존 인사정보 취득하기
        PrdctIndComBaseDomain prdctIndComBaseDomain = new PrdctIndComBaseDomain();
        //생산용역인원관리
        PrdctSvcPsnlInputDomain prdctSvcPsnlInputDomain = new PrdctSvcPsnlInputDomain();
        
        String cdBizarea = null;
        if(clsCode.equals("E1")) {
        	cdBizarea = "1000";  //마산
        }else if(clsCode.equals("C1")) {
        	cdBizarea = "2000"; //창원       	
        }else if(clsCode.equals("S1")) {
        	cdBizarea = "3000"; //화성       	
        }        
        prdctIndComBaseDomain.setCdBizarea(cdBizarea);  //사업부
        prdctIndComBaseDomain.setDeptCdMap(locCode);  //부서       
        
        List<PrdctIndComBaseDomain> empMasterList = prdctIndComBaseService.searchEmpMaster(prdctIndComBaseDomain);
        
        prdctSvcPsnlInputDomain.setClsCode(clsCode);
        prdctSvcPsnlInputDomain.setLocCode(locCode);
        List<PrdctSvcPsnlInputDomain> prdctSvcPsnlInputList = prdctSvcPsnlInputService.searchByCondition(prdctSvcPsnlInputDomain);
        
		// 저장된 세션 데이터 불러오기
//		EmpDomain salarayInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        domainlist = wrkrInfoBaseService.searchByCondition(criteria);
        
        HashMap wrkrInfoBaseMap = new HashMap();
        for(int i = 0; i < domainlist.size(); i ++) {
        	WrkrInfoBaseDomain wrkrInfoBaseDomain = domainlist.get(i);
        	String empNumber = wrkrInfoBaseDomain.getEmpNumber();
        	String cpnCode = wrkrInfoBaseDomain.getCpnCode();        	
        	wrkrInfoBaseMap.put(empNumber, cpnCode);
        }

        List<WrkrInfoBaseDomain> reusltList = new ArrayList<WrkrInfoBaseDomain>();
        
        //더존사원정보
        for(int i = 0; i < empMasterList.size(); i ++) {
        	WrkrInfoBaseDomain resultDomain = new WrkrInfoBaseDomain();
        	
        	PrdctIndComBaseDomain domain = empMasterList.get(i);
        	String empClsCode = (String)domain.getCdBizarea(); //사업부
        	String noEmp = (String)domain.getNoEmp(); //사원번호
        	String deptCdMap = (String)domain.getDeptCdMap(); //부서코드
        	String nmKor = (String)domain.getNmKor(); //이름
        	
        	if(empClsCode.equals("1000")) {
            	empClsCode = "E1";  //마산
            }else if(empClsCode.equals("2000")) {
            	empClsCode = "C1"; //창원       	
            }else if(empClsCode.equals("3000")) {
            	empClsCode = "S1"; //화성       	
            }         	
        	
            //Table Column 이 Number 타입이서 앞자리 '0'없음
            int intNoEmp = Integer.parseInt(noEmp);
            noEmp = String.valueOf(intNoEmp);
            
            resultDomain.setClsCode(empClsCode);
            resultDomain.setEmpNumber(noEmp);
            resultDomain.setLocCode(deptCdMap);
            resultDomain.setFullNm(nmKor);
            
            if(wrkrInfoBaseMap.get(noEmp) != null ) {
            	String cpnCode = (String)wrkrInfoBaseMap.get(noEmp);
            	resultDomain.setCpnCode(cpnCode);
            }
            reusltList.add(resultDomain);
        }
        
        //용역사원정보
        for(int i = 0; i < prdctSvcPsnlInputList.size(); i++) {
        	WrkrInfoBaseDomain resultDomain = new WrkrInfoBaseDomain();
        	
        	PrdctSvcPsnlInputDomain domain = prdctSvcPsnlInputList.get(i);
        	String empClsCode = (String)domain.getClsCode(); //사업부
        	String noEmp = (String)domain.getServcNo(); //용역번호
            //Table Column 이 Number 타입이서 앞자리 '0'없음
            int intNoEmp = Integer.parseInt(noEmp);
            noEmp = String.valueOf(intNoEmp);
            
        	String deptCdMap = (String)domain.getLocCode(); //부서코드
        	String nm = (String)domain.getNm(); //이름
        	
            resultDomain.setClsCode(empClsCode);
            resultDomain.setEmpNumber(noEmp);
            resultDomain.setLocCode(deptCdMap);
            resultDomain.setFullNm(nm);            

            if(wrkrInfoBaseMap.get(noEmp) != null ) {
            	String cpnCode = (String)wrkrInfoBaseMap.get(noEmp);
            	resultDomain.setCpnCode(cpnCode);
            }            
            reusltList.add(resultDomain);    
        }
        
        if(reusltList != null) {
            jsonObj.put("list", reusltList);
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
        String empNumber = ServletRequestUtils.getStringParameter(request, "empNumber");           
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");        
        
        //존재하는지 체크
        WrkrInfoBaseDomain cntDomain = new WrkrInfoBaseDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setEmpNumber(empNumber);          
        cntDomain.setLocCode(locCode);
        int cnt = wrkrInfoBaseService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        WrkrInfoBaseDomain delDomain = new WrkrInfoBaseDomain();
        delDomain.setClsCode(clsCode);
        delDomain.setEmpNumber(empNumber);          
        delDomain.setLocCode(locCode);
        wrkrInfoBaseService.delete(delDomain);

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
    	if(clsCode.equals("1000")) {
    		clsCode = "E1";  //마산
        }else if(clsCode.equals("2000")) {
        	clsCode = "C1"; //창원       	
        }else if(clsCode.equals("3000")) {
        	clsCode = "S1"; //화성       	
        }           
        String reqEmpNumber = ServletRequestUtils.getStringParameter(request, "empNumber");           
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode"); 
        String cpnCode = ServletRequestUtils.getStringParameter(request, "cpnCode"); 
        //코드값이 있는경우만 저장환다.
        if(cpnCode == null) {
        	return;
        }

        //존재하는지 체크
        WrkrInfoBaseDomain cntDomain = new WrkrInfoBaseDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setEmpNumber(reqEmpNumber);          
        cntDomain.setLocCode(locCode);          

        int cnt = wrkrInfoBaseService.searchCount(cntDomain);
        
        if(cnt > 0) {
            //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;      
        }        
        
        WrkrInfoBaseDomain insDomain = new WrkrInfoBaseDomain();
        insDomain.setClsCode(clsCode);
        insDomain.setEmpNumber(reqEmpNumber);          
        insDomain.setLocCode(locCode);
        insDomain.setCpnCode(cpnCode);
        
        insDomain.setRegUser(empNumber);
        
        wrkrInfoBaseService.create(insDomain);

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
        String reqEmpNumber = ServletRequestUtils.getStringParameter(request, "empNumber");           
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode"); 
        String cpnCode = ServletRequestUtils.getStringParameter(request, "cpnCode"); 

    	if(clsCode.equals("1000")) {
    		clsCode = "E1";  //마산
        }else if(clsCode.equals("2000")) {
        	clsCode = "C1"; //창원       	
        }else if(clsCode.equals("3000")) {
        	clsCode = "S1"; //화성       	
        }   
    	
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();

        //존재하는지 체크
        WrkrInfoBaseDomain cntDomain = new WrkrInfoBaseDomain();        
    	
        cntDomain.setClsCode(clsCode);
        cntDomain.setEmpNumber(reqEmpNumber);          
        cntDomain.setLocCode(locCode);    
        
        int cntOld = wrkrInfoBaseService.searchCount(cntDomain);

        if(cntOld == 0) {
        	WrkrInfoBaseDomain insDomain = new WrkrInfoBaseDomain();
            if(!isEmpty(cpnCode)) {
            	
            	insDomain.setClsCode(clsCode);
            	insDomain.setEmpNumber(reqEmpNumber);          
            	insDomain.setLocCode(locCode);
            	insDomain.setCpnCode(cpnCode); 
            	insDomain.setRegUser(empNumber);
                wrkrInfoBaseService.create(insDomain);
                
                jsonObj.put("result", DnkrConstans.RESULT_OK);        
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print(jsonObj);             	
            }
           
        }else {
       	  if(!isEmpty(cpnCode)) {
        	WrkrInfoBaseDomain updDomain = new WrkrInfoBaseDomain();             	
        	updDomain.setClsCode(clsCode);
        	updDomain.setEmpNumber(reqEmpNumber);          
        	updDomain.setLocCode(locCode);
        	updDomain.setCpnCode(cpnCode); 
	        updDomain.setModUser(empNumber); 
	        wrkrInfoBaseService.update(updDomain);
	
	        jsonObj.put("result", DnkrConstans.RESULT_OK);        
	        response.setContentType("text/html;charset=utf-8");
	        response.getWriter().print(jsonObj);
       	  }else { //code 값이 없으면 삭제처리한다.
              WrkrInfoBaseDomain delDomain = new WrkrInfoBaseDomain();
              delDomain.setClsCode(clsCode);
              delDomain.setEmpNumber(reqEmpNumber);          
              delDomain.setLocCode(locCode);
              wrkrInfoBaseService.delete(delDomain); 
              
              jsonObj.put("result", DnkrConstans.RESULT_OK);        
              response.setContentType("text/html;charset=utf-8");
              response.getWriter().print(jsonObj);
              return;        		  
       	  }
        }
        return;
    }
    
    private boolean isEmpty(String val) {
    	if(val == null) {
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
