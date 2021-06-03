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
import com.globaldenso.dnkr.business.service.LnPrsInpTmService;
import com.globaldenso.dnkr.business.service.PrdctIndComBaseService;
import com.globaldenso.dnkr.business.service.ProdctIndctBaseLineService;
import com.globaldenso.dnkr.business.service.StEmpAbsTrdService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.LnPrsInpTmDomain;
import com.globaldenso.dnkr.domain.PrdctIndComBaseDomain;
import com.globaldenso.dnkr.domain.StEmpAbsTrdDomain;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxLnPrsInpTm")
public class AjaxLnPrsInpTmController {

    /**
     * [KR] 생산성지표 라인인원투입시간등록서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private LnPrsInpTmService lnPrsInpTmService;

    
    /**
     * [KR] 생산성지표 기준정보(라인기준정보)서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private ProdctIndctBaseLineService prodctIndctBaseLineService;
    
    
    /**
     * [KR] 생산성지표 근태정보 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private StEmpAbsTrdService stEmpAbsTrdService;    
    
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
    public AjaxLnPrsInpTmController() {
        // no process
    }
    
    
    /**
     * [KO] 생산성지표 라인인원투입시간등록 조회.<br>
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
        
        List<? extends StEmpAbsTrdDomain> domainlist = null;

        StEmpAbsTrdDomain criteria = new StEmpAbsTrdDomain();
        criteria.setClsCode(clsCode);
        criteria.setLocCode(locCode);
        
        //더존 인사정보 취득하기
        PrdctIndComBaseDomain prdctIndComBaseDomain = new PrdctIndComBaseDomain();
        
        //근태정보 물류시간 도메인
        StEmpAbsTrdDomain StEmpAbsTrdDomain = new StEmpAbsTrdDomain();
        StEmpAbsTrdDomain.setClsCode(clsCode);
        StEmpAbsTrdDomain.setLocCode(locCode); 
        StEmpAbsTrdDomain.setOpertDe(getOpertDe);
        //특근신청 물류시간 취득
        int baseLgstTime = stEmpAbsTrdService.searchLgstCount(StEmpAbsTrdDomain);
       
        //저장된 물류시간 취득
        List<? extends StEmpAbsTrdDomain> stEmpAbsTrdDomainList = null;        
        stEmpAbsTrdDomainList = stEmpAbsTrdService.searchLgstTm(StEmpAbsTrdDomain);
        String prSnlSum = "0";
        if(stEmpAbsTrdDomainList != null && stEmpAbsTrdDomainList.size() > 0) {
    		if(stEmpAbsTrdDomainList.get(0) != null) {
        		StEmpAbsTrdDomain domain = stEmpAbsTrdDomainList.get(0);
        		prSnlSum = domain.getLgstTm();
    		}
        }
        
        //라인인원투입시간
        LnPrsInpTmDomain lnPrsInpTmDomain = new LnPrsInpTmDomain();

        lnPrsInpTmDomain.setClsCode(clsCode);
        lnPrsInpTmDomain.setLocCode(locCode);
        lnPrsInpTmDomain.setOpertDe(getOpertDe);        
        
        List<LnPrsInpTmDomain> LnPrsInpTmDomainList = lnPrsInpTmService.searchByCondition(lnPrsInpTmDomain);
   
    	int hrMntSum = 0;
        for(int i = 0; i < LnPrsInpTmDomainList.size(); i ++) {
        	LnPrsInpTmDomain domain = LnPrsInpTmDomainList.get(i);
        	String type = domain.getType();
        	//작업일자 선택된날
        	if(type.equals("D") && domain.getHrMntSum() != null) {
        		int lintHhrMnt = Integer.parseInt(domain.getHrMntSum().toString());
        		hrMntSum = hrMntSum + lintHhrMnt;
        	}
//        	//라인총소계
//        	domain.setPrsnlSum(String.valueOf(hrMntSum));
        }
        List<? extends StEmpAbsTrdDomain> workDaySumList = null;
		String sumWorkTime = "0";
		//특근신청 총작업시간
		StEmpAbsTrdDomain.setLogiType(true);
		workDaySumList = stEmpAbsTrdService.searchByDayWorkTimeSum(StEmpAbsTrdDomain);
	
		if(workDaySumList != null && workDaySumList.size() > 0) {
			StEmpAbsTrdDomain stEmpAbsTrdDomain = workDaySumList.get(0);
    		if(stEmpAbsTrdDomain != null) {
    			sumWorkTime = stEmpAbsTrdDomain.getSumWorkTime();
    		}
		}
		int intSumWorkTime = Integer.parseInt(changeZero(sumWorkTime));
		
		
        if(LnPrsInpTmDomainList != null) {
            jsonObj.put("list", LnPrsInpTmDomainList);
            jsonObj.put("baseLgstTime", String.valueOf(baseLgstTime)); //특근신청 물류시간 취득
            jsonObj.put("baseHrMntSum", String.valueOf(hrMntSum));     //총작업시간
            jsonObj.put("prSnlSum", String.valueOf(prSnlSum));     //저장된 물류시간          
            jsonObj.put("reqWork", String.valueOf(intSumWorkTime));     //특근신청 총작업시간              

    		//일일근태등록에서 등록된 물류제외 총작업시간 비교
    		if(hrMntSum == intSumWorkTime) {
                jsonObj.put("ruling", "OK");     //판정    			
    		}else {
                jsonObj.put("ruling", "NG");     //판정    			    			
    		}
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
        
        String getOpertDe = ServletRequestUtils.getStringParameter(request, "getOpertDe");  //작업일자        
        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");     
        String lineCode = ServletRequestUtils.getStringParameter(request, "lineCode");           
        
        //존재하는지 체크
        LnPrsInpTmDomain cntDomain = new LnPrsInpTmDomain();
        cntDomain.setOpertDe(getOpertDe);
        cntDomain.setClsCode(clsCode);
        cntDomain.setLocCode(locCode);
        cntDomain.setLineCode(lineCode); 

        int cnt = lnPrsInpTmService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        LnPrsInpTmDomain delDomain = new LnPrsInpTmDomain();
        delDomain.setOpertDe(getOpertDe);
        delDomain.setClsCode(clsCode);
        delDomain.setLocCode(locCode);
        delDomain.setLineCode(lineCode);
        lnPrsInpTmService.delete(delDomain);

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
        String lgstTime = ServletRequestUtils.getStringParameter(request, "lgstTime"); //물류시간  

        String prsnl1 = ServletRequestUtils.getStringParameter(request, "prsnl1"); //인원1  
        String prsnl2 = ServletRequestUtils.getStringParameter(request, "prsnl2"); //인원2  
        String prsnl3 = ServletRequestUtils.getStringParameter(request, "prsnl3"); //인원3  
        String prsnl4 = ServletRequestUtils.getStringParameter(request, "prsnl4"); //인원4  
        String prsnl5 = ServletRequestUtils.getStringParameter(request, "prsnl5"); //인원5  
        String prsnl6 = ServletRequestUtils.getStringParameter(request, "prsnl6"); //인원6  
        String prsnl7 = ServletRequestUtils.getStringParameter(request, "prsnl7"); //인원7  
        String prsnl8 = ServletRequestUtils.getStringParameter(request, "prsnl8"); //인원8          
        
        String hrMnt1 = ServletRequestUtils.getStringParameter(request, "hrMnt1"); //시간1  
        String hrMnt2 = ServletRequestUtils.getStringParameter(request, "hrMnt2"); //시간2  
        String hrMnt3 = ServletRequestUtils.getStringParameter(request, "hrMnt3"); //시간3  
        String hrMnt4 = ServletRequestUtils.getStringParameter(request, "hrMnt4"); //시간4  
        String hrMnt5 = ServletRequestUtils.getStringParameter(request, "hrMnt5"); //시간5 
        String hrMnt6 = ServletRequestUtils.getStringParameter(request, "hrMnt6"); //시간6 
        String hrMnt7 = ServletRequestUtils.getStringParameter(request, "hrMnt7"); //시간7  
        String hrMnt8 = ServletRequestUtils.getStringParameter(request, "hrMnt8"); //시간8 
        
//        String hrMntSum = ServletRequestUtils.getStringParameter(request, "hrMntSum"); //라인별시간sum(분)   
        String prsnlSum = ServletRequestUtils.getStringParameter(request, "prsnlSum"); //라인별인원총     
        String type = ServletRequestUtils.getStringParameter(request, "type"); //DAY tYPE        
        
        //오늘 날짜만 해당한다.
        if(type != "D" ) {
        	return;
        }

        //존재하는지 체크
        LnPrsInpTmDomain cntDomain = new LnPrsInpTmDomain();
        cntDomain.setOpertDe(opertDe); //작업일자     
        cntDomain.setClsCode(clsCode); 
        cntDomain.setLocCode(locCode); 
        cntDomain.setLineCode(lineCode);
        
        int cnt = lnPrsInpTmService.searchCount(cntDomain);
        
        if(cnt > 0) {
            jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
//        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }      
        
        LnPrsInpTmDomain insDomain = new LnPrsInpTmDomain();
        insDomain.setOpertDe(opertDe); //작업일자     
        insDomain.setClsCode(clsCode); 
        insDomain.setLocCode(locCode); 
        insDomain.setLineCode(lineCode);
        insDomain.setPrsnl1(prsnl1);
        insDomain.setPrsnl2(prsnl2);
        insDomain.setPrsnl3(prsnl3);
        insDomain.setPrsnl4(prsnl4);
        insDomain.setPrsnl5(prsnl5);
        insDomain.setPrsnl6(prsnl6);
        insDomain.setPrsnl7(prsnl7);
        insDomain.setPrsnl8(prsnl8);
        insDomain.setHrMnt1(hrMnt1);
        insDomain.setHrMnt2(hrMnt2);
        insDomain.setHrMnt3(hrMnt3);
        insDomain.setHrMnt4(hrMnt4);
        insDomain.setHrMnt5(hrMnt5);
        insDomain.setHrMnt6(hrMnt6);
        insDomain.setHrMnt7(hrMnt7);
        insDomain.setHrMnt8(hrMnt8);        
        insDomain.setLgstTime(lgstTime);
        insDomain.setRegUser(empNumber);
        lnPrsInpTmService.create(insDomain);

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
    	String type = ServletRequestUtils.getStringParameter(request, "type"); //DAY tYPE    
        if(type.equals("D")) {

	        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
	        String opertDe = ServletRequestUtils.getStringParameter(request, "opertDe");      	
	        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");        
	        String lineCode = ServletRequestUtils.getStringParameter(request, "lineCode");
	        String lgstTime = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "lgstTime")); //물류시간  
	
	        String prsnl1 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "prsnl1")); //인원1  
	        String prsnl2 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "prsnl2")); //인원2  
	        String prsnl3 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "prsnl3")); //인원3  
	        String prsnl4 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "prsnl4")); //인원4  
	        String prsnl5 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "prsnl5")); //인원5  
	        String prsnl6 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "prsnl6")); //인원6  
	        String prsnl7 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "prsnl7")); //인원7  
	        String prsnl8 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "prsnl8")); //인원8          
	        
	        String hrMnt1 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "hrMnt1")); //시간1  
	        String hrMnt2 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "hrMnt2")); //시간2  
	        String hrMnt3 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "hrMnt3")); //시간3  
	        String hrMnt4 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "hrMnt4")); //시간4  
	        String hrMnt5 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "hrMnt5")); //시간5 
	        String hrMnt6 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "hrMnt6")); //시간6 
	        String hrMnt7 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "hrMnt7")); //시간7  
	        String hrMnt8 = isEmptyToZero(ServletRequestUtils.getStringParameter(request, "hrMnt8")); //시간8 
	        
	        String hrMntSum = ServletRequestUtils.getStringParameter(request, "hrMntSum"); //라인별시간sum(분)
			EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
	        String userId = empInfo.getEmpId();
	        String empNumber = empInfo.getEmpNumber();
	        String userName = empInfo.getEmpName();
	        
	        //존재하는지 체크
	        LnPrsInpTmDomain cntDomain = new LnPrsInpTmDomain();        
	        cntDomain.setOpertDe(opertDe); //작업일자     
	        cntDomain.setClsCode(clsCode); 
	        cntDomain.setLocCode(locCode); 
	        cntDomain.setLineCode(lineCode);
	 
	        int cntOld = lnPrsInpTmService.searchCount(cntDomain);
	
	        if(cntOld == 0) {
	             if(!isEmpty(hrMntSum)) {
	            	 LnPrsInpTmDomain insDomain = new LnPrsInpTmDomain();
	            	 insDomain.setOpertDe(opertDe);//작업일자     
	            	 insDomain.setClsCode(clsCode); 		
	            	 insDomain.setLocCode(locCode); 
	            	 insDomain.setLineCode(lineCode);
	            	 insDomain.setPrsnl1(prsnl1);
	            	 insDomain.setPrsnl2(prsnl2);
	            	 insDomain.setPrsnl3(prsnl3);
	            	 insDomain.setPrsnl4(prsnl4);
	            	 insDomain.setPrsnl5(prsnl5);
	            	 insDomain.setPrsnl6(prsnl6);
	            	 insDomain.setPrsnl7(prsnl7);
	            	 insDomain.setPrsnl8(prsnl8);
	            	 insDomain.setHrMnt1(hrMnt1);
	            	 insDomain.setHrMnt2(hrMnt2);
	            	 insDomain.setHrMnt3(hrMnt3);
	            	 insDomain.setHrMnt4(hrMnt4);
	            	 insDomain.setHrMnt5(hrMnt5);
	            	 insDomain.setHrMnt6(hrMnt6);
	            	 insDomain.setHrMnt7(hrMnt7);
	            	 insDomain.setHrMnt8(hrMnt8);
	            	 insDomain.setLgstTime(lgstTime);
	            	 insDomain.setRegUser(empNumber);              
	            	 lnPrsInpTmService.create(insDomain);
		            
	            	 jsonObj.put("result", DnkrConstans.RESULT_OK);        
	            	 response.setContentType("text/html;charset=utf-8");
	            	 response.getWriter().print(jsonObj);             	
	            }
			} else {
				if (!isEmpty(hrMntSum)) {
					LnPrsInpTmDomain updDomain = new LnPrsInpTmDomain();
					updDomain.setOpertDe(opertDe);// 작업일자
					updDomain.setClsCode(clsCode);
					updDomain.setLocCode(locCode);
					updDomain.setLineCode(lineCode);
					updDomain.setPrsnl1(prsnl1);
					updDomain.setPrsnl2(prsnl2);
					updDomain.setPrsnl3(prsnl3);
					updDomain.setPrsnl4(prsnl4);
					updDomain.setPrsnl5(prsnl5);
					updDomain.setPrsnl6(prsnl6);
					updDomain.setPrsnl7(prsnl7);
					updDomain.setPrsnl8(prsnl8);
					updDomain.setHrMnt1(hrMnt1);
					updDomain.setHrMnt2(hrMnt2);
					updDomain.setHrMnt3(hrMnt3);
					updDomain.setHrMnt4(hrMnt4);
					updDomain.setHrMnt5(hrMnt5);
					updDomain.setHrMnt6(hrMnt6);
					updDomain.setHrMnt7(hrMnt7);
					updDomain.setHrMnt8(hrMnt8);
					updDomain.setLgstTime(lgstTime);
	
					updDomain.setModUser(empNumber);
					lnPrsInpTmService.update(updDomain);
	
					jsonObj.put("result", DnkrConstans.RESULT_OK);
					response.setContentType("text/html;charset=utf-8");
					response.getWriter().print(jsonObj);
	
				} else { // code 값이 없으면 삭제처리한다.
					LnPrsInpTmDomain delDomain = new LnPrsInpTmDomain();
					delDomain.setOpertDe(opertDe); // 작업일자
					delDomain.setClsCode(clsCode);
					delDomain.setLocCode(locCode);
					delDomain.setLineCode(lineCode);
					lnPrsInpTmService.delete(delDomain);
	
					jsonObj.put("result", DnkrConstans.RESULT_OK);
					response.setContentType("text/html;charset=utf-8");
					response.getWriter().print(jsonObj);
					return;
				}
			}
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
    
    private String changeZero(String val) {
    	if(val == null) {
    		return "0";
    	}else {
    		val = val.trim();
    		if(val.length() == 0) {
    			return "0";
    		}else {
    			return val;
    		}
    	}
    }       
}
