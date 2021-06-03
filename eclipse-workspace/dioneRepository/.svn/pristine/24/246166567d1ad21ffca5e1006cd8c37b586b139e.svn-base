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
import com.globaldenso.dnkr.business.service.PrdYrPlnCrtRgsService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.PrdYrPlnCrtRgsDomain;


/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxPrdYrPlnCrtRgs")
public class AjaxPrdYrPlnCrtRgsController {

    /**
     * [KR] 생산성지표 라인인원투입시간등록서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private PrdYrPlnCrtRgsService prdYrPlnCrtRgsService;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxPrdYrPlnCrtRgsController() {
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
    	
    		JSONObject jsonObj = new JSONObject();
        	
            String clsCode = ServletRequestUtils.getStringParameter(request, "getComps");  
            String locCode = ServletRequestUtils.getStringParameter(request, "getLocId");          
            String year = ServletRequestUtils.getStringParameter(request, "getYear");  //작업일자
                        
            PrdYrPlnCrtRgsDomain prdYrPlnCrtRgsDomain = new PrdYrPlnCrtRgsDomain();

            prdYrPlnCrtRgsDomain.setClsCode(clsCode);
            prdYrPlnCrtRgsDomain.setLocCode(locCode);
            prdYrPlnCrtRgsDomain.setYear(Integer.parseInt(year));
            
            List<PrdYrPlnCrtRgsDomain> PrdYrPlnCrtRgsDomainList = prdYrPlnCrtRgsService.searchByCondition(prdYrPlnCrtRgsDomain);
            

            if(PrdYrPlnCrtRgsDomainList != null) {
                jsonObj.put("list", PrdYrPlnCrtRgsDomainList);
            }

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj.toJSONString());
            return;
    	
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	
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
        
        String getYear = ServletRequestUtils.getStringParameter(request, "getYear");  //작업일자        
        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");     
        String lineCode = ServletRequestUtils.getStringParameter(request, "lineCode");           
        
        //존재하는지 체크
        PrdYrPlnCrtRgsDomain cntDomain = new PrdYrPlnCrtRgsDomain();
        cntDomain.setYear(Integer.parseInt(getYear));
        cntDomain.setClsCode(clsCode);
        cntDomain.setLocCode(locCode);
        cntDomain.setLineCode(lineCode); 

        int cnt = prdYrPlnCrtRgsService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        PrdYrPlnCrtRgsDomain delDomain = new PrdYrPlnCrtRgsDomain();
        delDomain.setYear(Integer.parseInt(getYear));
        delDomain.setClsCode(clsCode);
        delDomain.setLocCode(locCode);
        delDomain.setLineCode(lineCode);
        prdYrPlnCrtRgsService.delete(delDomain);

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
    	try{
    	JSONObject jsonObj = new JSONObject();
	    
		String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");  // 사업부 코드
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");     //부서   
        String lineCode = ServletRequestUtils.getStringParameter(request, "lineCode");  //라인코드
        String iem =  ServletRequestUtils.getStringParameter(request, "code");		//항목
        int year = ServletRequestUtils.getIntParameter(request, "year"); //4월  
        
        float apr = ServletRequestUtils.getFloatParameter(request, "apr"); //4월  
        float may = ServletRequestUtils.getFloatParameter(request, "may"); //5월  
        float jun = ServletRequestUtils.getFloatParameter(request, "jun"); //6월  
        float july = ServletRequestUtils.getFloatParameter(request, "july"); //7월  
        float aug = ServletRequestUtils.getFloatParameter(request, "aug"); //8월  
        float sep = ServletRequestUtils.getFloatParameter(request, "sep"); //9월  
        float oct = ServletRequestUtils.getFloatParameter(request, "oct"); //10월  
        float nov = ServletRequestUtils.getFloatParameter(request, "nov"); //11월          
        float dec = ServletRequestUtils.getFloatParameter(request, "dec"); //12월  
        float jan = ServletRequestUtils.getFloatParameter(request, "jan"); //1월  
        float feb = ServletRequestUtils.getFloatParameter(request, "feb"); //2월  
        float mar = ServletRequestUtils.getFloatParameter(request, "mar"); //3월  
        
        float sumCnt = apr+may+jun+july+aug+sep+oct+nov+dec+jan+feb+mar;
        
        EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
        
		if (sumCnt == 0) {
			// 4월부터 3월까지 합이 0일 경우 해당 데이터 삭제
			PrdYrPlnCrtRgsDomain delDomain = new PrdYrPlnCrtRgsDomain();
			delDomain.setYear(year);
			delDomain.setClsCode(clsCode);
			delDomain.setLocCode(locCode);
			delDomain.setLineCode(lineCode);
			delDomain.setIem(iem);
			prdYrPlnCrtRgsService.delete(delDomain);

			jsonObj.put("result", DnkrConstans.RESULT_OK);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(jsonObj);

		} else {
			// 4월부터 3월까지 합이 0이 아닐 경우, 기존 데이터가 있으면 update 없으면 insert
			PrdYrPlnCrtRgsDomain cntDomain = new PrdYrPlnCrtRgsDomain();
			cntDomain.setYear(year); // 작업일자
			cntDomain.setClsCode(clsCode);
			cntDomain.setLocCode(locCode);
			cntDomain.setLineCode(lineCode);
			cntDomain.setIem(iem);

			int cnt = prdYrPlnCrtRgsService.searchCount(cntDomain);

			if (cnt == 0) {

				PrdYrPlnCrtRgsDomain insDomain = new PrdYrPlnCrtRgsDomain();
				insDomain.setYear(year); // 작업일자
				insDomain.setClsCode(clsCode);
				insDomain.setLocCode(locCode);
				insDomain.setLineCode(lineCode);
				insDomain.setIem(iem);
				insDomain.setApr(apr);
				insDomain.setMay(may);
				insDomain.setJun(jun);
				insDomain.setJuly(july);
				insDomain.setAug(aug);
				insDomain.setSep(sep);
				insDomain.setOct(oct);
				insDomain.setNov(nov);
				insDomain.setDec(dec);
				insDomain.setJan(jan);
				insDomain.setFeb(feb);
				insDomain.setMar(mar);
				insDomain.setRegUser(empNumber);

				prdYrPlnCrtRgsService.create(insDomain);

			} else {

				PrdYrPlnCrtRgsDomain updDomain = new PrdYrPlnCrtRgsDomain();
				updDomain.setYear(year); // 작업일자 자
				updDomain.setClsCode(clsCode);
				updDomain.setLocCode(locCode);
				updDomain.setLineCode(lineCode);
				updDomain.setIem(iem);
				updDomain.setApr(apr);
				updDomain.setMay(may);
				updDomain.setJun(jun);
				updDomain.setJuly(july);
				updDomain.setAug(aug);
				updDomain.setSep(sep);
				updDomain.setOct(oct);
				updDomain.setNov(nov);
				updDomain.setDec(dec);
				updDomain.setJan(jan);
				updDomain.setFeb(feb);
				updDomain.setMar(mar);
				updDomain.setModUser(empNumber);

				prdYrPlnCrtRgsService.update(updDomain);

			}

			jsonObj.put("result", DnkrConstans.RESULT_OK);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(jsonObj);

		}
        }catch(Exception e){
        	System.out.println("=============");
        	System.out.println("Exception : "+e.getMessage());
        	System.out.println("=============");
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
