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
import com.globaldenso.dnkr.business.service.LosExcIndTmService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.LosExcIndTmDomain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.Enumeration;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxLosExcIndTm")
public class AjaxLosExcIndTmController {

    /**
     * [KR] 생산성지표 라인인원투입시간등록서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private LosExcIndTmService losExcIndTmService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxLosExcIndTmController() {
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
    	
    	try{
    		List<Object> makeLineValueList = new ArrayList<Object>();
    		JSONObject jsonObj = new JSONObject();
        	
            String clsCode = ServletRequestUtils.getStringParameter(request, "getComps");  
            String locCode = ServletRequestUtils.getStringParameter(request, "getLocId");     
            int opertDe = ServletRequestUtils.getIntParameter(request, "getOpertDe");      
                        
            LosExcIndTmDomain losExcIndTmDomain = new LosExcIndTmDomain();

            losExcIndTmDomain.setClsCode(clsCode);
            losExcIndTmDomain.setLocCode(locCode);
            losExcIndTmDomain.setOpertDe(opertDe);
            
            
            List<LosExcIndTmDomain> reusltList = new ArrayList<LosExcIndTmDomain>();
            
            List<LosExcIndTmDomain> PrdYrPlnCrtRgsDomainList = losExcIndTmService.searchByCondition(losExcIndTmDomain);
            for(int i=0; i<PrdYrPlnCrtRgsDomainList.size(); i++){
            	HashMap gridValue = new HashMap();
            	
            	String Se = PrdYrPlnCrtRgsDomainList.get(i).getSe();
            	String code = PrdYrPlnCrtRgsDomainList.get(i).getCode();
            	            	
            	gridValue.put("opertDe", opertDe);
            	gridValue.put("clsCode", PrdYrPlnCrtRgsDomainList.get(i).getClsCode());
            	gridValue.put("se", PrdYrPlnCrtRgsDomainList.get(i).getSe());
            	gridValue.put("seNm", PrdYrPlnCrtRgsDomainList.get(i).getSeNm());
            	gridValue.put("code", PrdYrPlnCrtRgsDomainList.get(i).getCode());
            	gridValue.put("codeNm", PrdYrPlnCrtRgsDomainList.get(i).getCodeNm());
            	
            	List<LosExcIndTmDomain> searchLineValues = losExcIndTmService.searchLineValues(losExcIndTmDomain);
            	if(searchLineValues != null){
            		for(int j=0; j<searchLineValues.size(); j++ ){
            			
                		if(Se.equals(searchLineValues.get(j).getSe()) && code.equals(searchLineValues.get(j).getCode())){
                			
                			gridValue.put("locCode", searchLineValues.get(j).getLocCode());
                			gridValue.put("line_"+searchLineValues.get(j).getLocCode()+"_"+searchLineValues.get(j).getLineCode(), searchLineValues.get(j).getHrMnt());
                			
                		}
                		
                	}
            	}
            	
            	
            	makeLineValueList.add(gridValue);	
            	
            }

            if(makeLineValueList != null) {
                jsonObj.put("list", makeLineValueList);
            }

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj.toJSONString());
            return;
    	
    	}catch(Exception e){
    		System.out.println("ERR : "+e.getMessage());
    	}
    	
    }
    
    @RequestMapping(value = "/searchLine", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void searchLine(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
    	
    	try{
    	
    		JSONObject jsonObj = new JSONObject();
    	        	
            String clsCode = ServletRequestUtils.getStringParameter(request, "getComps");  
            String locCode = ServletRequestUtils.getStringParameter(request, "getLocId");
                        
            LosExcIndTmDomain losExcIndTmDomain = new LosExcIndTmDomain();

            losExcIndTmDomain.setClsCode(clsCode);
            losExcIndTmDomain.setLocCode(locCode);
            
            List<LosExcIndTmDomain> lineList = losExcIndTmService.searchLineList(losExcIndTmDomain);
            
            if(lineList != null) {
                jsonObj.put("lineList", lineList);
            }

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj.toJSONString());
            return;
    	
    	}catch(Exception e){
    		System.out.println("search Line Err : "+e.getMessage());
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
    	// update에서 CUD 로직 처리
    	JSONObject jsonObj = new JSONObject();
    	try{
	    	
	    	LosExcIndTmDomain dataDomain = new LosExcIndTmDomain();
		   
	    	//Key Setting
	    	int opertDe = ServletRequestUtils.getIntParameter(request, "opertDe");  	  // 작업일자
			String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");  // 사업부 코드
	        String se = ServletRequestUtils.getStringParameter(request, "se");  		  // 손실,제외,간접 구분
	        String code = ServletRequestUtils.getStringParameter(request, "code");  	  // 구분별 상세 코드
	        
	        EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
	        String userId = empInfo.getEmpId();
	        String empNumber = empInfo.getEmpNumber();
	        String userName = empInfo.getEmpName();
	        
	        dataDomain.setOpertDe(opertDe);
	        dataDomain.setClsCode(clsCode);
	        dataDomain.setSe(se);
	        dataDomain.setCode(code);
	        dataDomain.setRegUser(empNumber);
	        dataDomain.setModUser(empNumber);
	        Enumeration<String> paramKeys = request.getParameterNames();
	        while (paramKeys.hasMoreElements()) {
	        	
	        	String key = paramKeys.nextElement();
	        	
	        	if(key.contains("line_")){
   		    	
	        		String[] lineInfo = key.split("_");
	        		dataDomain.setLocCode(lineInfo[1]);
	        		dataDomain.setLineCode(lineInfo[2]);
	        		dataDomain.setHrMnt(Integer.parseInt(request.getParameter(key)));
   		    	 
	        		int rowCnt = losExcIndTmService.searchCount(dataDomain);
   		        
	        		if(rowCnt == 0){
	        			
	        			// 생성된 row Count가 0일 경우엔 
	   		        	if(dataDomain.getHrMnt() != 0){
	   		        		// 시간입력이 0이 아닐 경우 데이터를 신규 생성
	   		            	losExcIndTmService.create(dataDomain);
	   		        	}
   		        
	        		}else{
	   		        	// 기존에 row Count가 존재할 경우에는
	   		        	if(dataDomain.getHrMnt() != 0){
	   		        		// hmMnt가 0이 아닐 경우 업데이트
	   		        		losExcIndTmService.update(dataDomain);
	   		        	}else{
	   		        		// hrMnt 0일 경우에는 기존 데이터 삭제
	   		        		losExcIndTmService.delete(dataDomain);
	   		        	}
	        		}
	        	}
	        }
	        
	        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        	response.setContentType("text/html;charset=utf-8");
        	response.getWriter().print(jsonObj);
	        //기존에 해당 데이터에 대하여 Row가 존재하는지 체크
	        
	    }catch(Exception e){
	    	System.out.println("=============");
	    	System.out.println("Exception : "+e.getMessage());
	    	System.out.println("=============");
	    	jsonObj.put("errMsg", e.getMessage());        
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
