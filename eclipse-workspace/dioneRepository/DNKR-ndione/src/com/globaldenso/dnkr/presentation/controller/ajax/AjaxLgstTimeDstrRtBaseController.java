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
import com.globaldenso.dnkr.business.service.LgstTimeDstrRtBaseService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.LgstTimeDstrRtBaseDomain;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxLgstTimeDstrRtBase")
public class AjaxLgstTimeDstrRtBaseController {

    /**
     * [KR] 생산성지표 기준정보(제품관리정보)서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private LgstTimeDstrRtBaseService lgstTimeDstrRtBaseService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxLgstTimeDstrRtBaseController() {
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
//    	String prdtCode = ServletRequestUtils.getStringParameter(request, "code");
 //       String prdtName = ServletRequestUtils.getStringParameter(request, "name");

        List<? extends LgstTimeDstrRtBaseDomain> domainlist = null;

        LgstTimeDstrRtBaseDomain criteria = new LgstTimeDstrRtBaseDomain();
        criteria.setClsCode(clsCode);
           
		// 저장된 세션 데이터 불러오기
//		EmpDomain salarayInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        domainlist = lgstTimeDstrRtBaseService.searchByCondition(criteria);

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
        LgstTimeDstrRtBaseDomain cntDomain = new LgstTimeDstrRtBaseDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setLineCode(lineCode);      
        int cnt = lgstTimeDstrRtBaseService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        LgstTimeDstrRtBaseDomain delDomain = new LgstTimeDstrRtBaseDomain();
        delDomain.setClsCode(clsCode);
        delDomain.setLineCode(lineCode);        
//        delDomain.setPyvnd(delPyvnd);
//        delDomain.setMcrcd(delMcrcd);
//        delDomain.setMsecd(delMsecd);
//        delDomain.setMcrc1(delMcrc1);
//        delDomain.setMsec1(delMsec1);
//        delDomain.setLib1(empInfo.getLib1());
//        delDomain.setLib2(empInfo.getLib2());
        lgstTimeDstrRtBaseService.delete(delDomain);

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
        String lgsDstRt = ServletRequestUtils.getStringParameter(request, "lgsDstRt");
        if(lgsDstRt == null) {
        	lgsDstRt = "0";
        }

        //존재하는지 체크
        LgstTimeDstrRtBaseDomain cntDomain = new LgstTimeDstrRtBaseDomain();
        cntDomain.setClsCode(clsCode);
        cntDomain.setLineCode(lineCode);          

        int cnt = lgstTimeDstrRtBaseService.searchCount(cntDomain);
        
        if(cnt > 0) {
            //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;      
        }          
        
        LgstTimeDstrRtBaseDomain insDomain = new LgstTimeDstrRtBaseDomain();
        
        insDomain.setClsCode(clsCode);
        insDomain.setLineCode(lineCode);        
        insDomain.setLgsDstRt(lgsDstRt);
        insDomain.setRegUser(userName);
        
        lgstTimeDstrRtBaseService.create(insDomain);

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
        String lgsDstRt = ServletRequestUtils.getStringParameter(request, "lgsDstRt");
        if(lgsDstRt == null) {
        	lgsDstRt = "0";
        }
        
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
        
        JSONObject jsonObj = new JSONObject();

        //존재하는지 체크
        LgstTimeDstrRtBaseDomain cntDomain = new LgstTimeDstrRtBaseDomain();        
        cntDomain.setClsCode(clsCode);
        cntDomain.setLineCode(lineCode);       
        
        int cntOld = lgstTimeDstrRtBaseService.searchCount(cntDomain);

        if(cntOld == 0) {
            LgstTimeDstrRtBaseDomain insDomain = new LgstTimeDstrRtBaseDomain();
            
            insDomain.setClsCode(clsCode);
            insDomain.setLineCode(lineCode);        
            insDomain.setLgsDstRt(lgsDstRt);
            insDomain.setRegUser(userName);
            lgstTimeDstrRtBaseService.create(insDomain);
            
            jsonObj.put("result", DnkrConstans.RESULT_OK);        
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);            
        }else {
	        LgstTimeDstrRtBaseDomain updDomain = new LgstTimeDstrRtBaseDomain();   
	        updDomain.setClsCode(clsCode);
	        updDomain.setLineCode(lineCode);        
	        updDomain.setLgsDstRt(lgsDstRt);
	        updDomain.setModUser(userName); 
	        lgstTimeDstrRtBaseService.update(updDomain);
	
	        jsonObj.put("result", DnkrConstans.RESULT_OK);        
	        response.setContentType("text/html;charset=utf-8");
	        response.getWriter().print(jsonObj);
        }
        return;
    }
}
