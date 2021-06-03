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
import com.globaldenso.dnkr.business.service.KiaHyundaiVANCompanyCodeMstService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.KiaHyundaiVANCompanyCodeMstDomain;
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
@RequestMapping(value = "/ajaxKiaHyundaiVANCompanyCodeMst")
public class AjaxKiaHyundaiVANCompanyCodeMstController {

    /**
     * [KR] 기아현대 VAN 업체코드마스타 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private KiaHyundaiVANCompanyCodeMstService kiaHyundaiVANCompanyCodeMstService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxKiaHyundaiVANCompanyCodeMstController() {
        // no process
    }
    
    
    /**
     * [KO] 초기 화면.<br>
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
     * [KO] 조회버큰 클릭.<br>
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

        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");

        List<? extends KiaHyundaiVANCompanyCodeMstDomain> domainlist = null;

        KiaHyundaiVANCompanyCodeMstDomain criteria = new KiaHyundaiVANCompanyCodeMstDomain();
        criteria.setComps(getComps);
        criteria.setPyvnd(getPyvnd);
        
        System.out.println("getComps : " + getComps);
        
        if(getComps.equals("E1") ) {
        	// 마산 
        	domainlist = kiaHyundaiVANCompanyCodeMstService.searchByCondition(criteria);
        	
        } else {
        	// 마산 외 창원,화성
        	domainlist = kiaHyundaiVANCompanyCodeMstService.searchByCondition030(criteria);
        }

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

  

    /**
     * [KO] 추가 등록.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAN019KiaHyundaiVANCompanyCodeMst/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonObj = new JSONObject();

        String insVndcd = ServletRequestUtils.getStringParameter(request, "vndcd");
        String insFaccd = ServletRequestUtils.getStringParameter(request, "faccd");
        String insFacnm = ServletRequestUtils.getStringParameter(request, "facnm");
        String insPscom = ServletRequestUtils.getStringParameter(request, "pscom");
        String insPsvnd1 = ServletRequestUtils.getStringParameter(request, "psvnd1");
        
        //존재하는지 체크
        KiaHyundaiVANCompanyCodeMstDomain cntDomain = new KiaHyundaiVANCompanyCodeMstDomain();

        cntDomain.setVndcd(insVndcd);
        cntDomain.setFaccd(insFaccd);
        cntDomain.setFacnm(insFacnm);
        cntDomain.setPscom(insPscom);
        cntDomain.setPsvnd1(insPsvnd1);
        
        int cnt = 0;
        
        if(insPscom.equals("E1") ) {
        	// 마산 
        	cnt = kiaHyundaiVANCompanyCodeMstService.searchCount(cntDomain);
        	
        } else {
        	// 마산 외 창원,화성
        	cnt = kiaHyundaiVANCompanyCodeMstService.searchCount030(cntDomain);
        }
        
        if(cnt > 0) {
            //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;      	
        }        

    	// 등록
        KiaHyundaiVANCompanyCodeMstDomain insDomain = new KiaHyundaiVANCompanyCodeMstDomain();
        insDomain.setVndcd(insVndcd);
        insDomain.setFaccd(insFaccd);
        insDomain.setFacnm(insFacnm);
        insDomain.setPscom(insPscom);
        insDomain.setPsvnd1(insPsvnd1);

        if(insPscom.equals("E1") ) {
        	// 마산 
        	kiaHyundaiVANCompanyCodeMstService.create(insDomain);

            jsonObj.put("result", DnkrConstans.RESULT_OK);        
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        	
        } else {
        	// 마산 외 창원,화성
        	kiaHyundaiVANCompanyCodeMstService.create030(insDomain);

            jsonObj.put("result", DnkrConstans.RESULT_OK);        
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
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
    @ErrorBack(viewName = ".tiles.page.WAN019")
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

        JSONObject jsonObj = new JSONObject();

        String updVndcd = ServletRequestUtils.getStringParameter(request, "vndcd");
        String updFaccd = ServletRequestUtils.getStringParameter(request, "faccd");
        String updFacnm = ServletRequestUtils.getStringParameter(request, "facnm");
        String updPscom = ServletRequestUtils.getStringParameter(request, "pscom");
        String updPsvnd1 = ServletRequestUtils.getStringParameter(request, "psvnd1");
        
        String updOldVndcd = ServletRequestUtils.getStringParameter(request, "oldVndcd");
        String updOldFaccd = ServletRequestUtils.getStringParameter(request, "oldFaccd");
        String updOldFacnm = ServletRequestUtils.getStringParameter(request, "oldFacnm");
        String updOldPscom = ServletRequestUtils.getStringParameter(request, "oldPscom");
        String updOldPsvnd1 = ServletRequestUtils.getStringParameter(request, "oldPsvnd1");
        

        //존재하는지 체크
        KiaHyundaiVANCompanyCodeMstDomain cntDomain = new KiaHyundaiVANCompanyCodeMstDomain();

        cntDomain.setVndcd(updOldVndcd);
        cntDomain.setFaccd(updOldFaccd);
        cntDomain.setFacnm(updOldFacnm);
        cntDomain.setPscom(updOldPscom);
        cntDomain.setPsvnd1(updOldPsvnd1);
        
        int cnt = 0;
        
        if(updOldPscom.equals("E1") ) {
        	// 마산 
        	cnt = kiaHyundaiVANCompanyCodeMstService.searchCount(cntDomain);
        	
        } else {
        	// 마산 외 창원,화성
        	cnt = kiaHyundaiVANCompanyCodeMstService.searchCount030(cntDomain);
        }
        
        if(cnt == 0) {
        	//jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;      	
        }        

       
        KiaHyundaiVANCompanyCodeMstDomain updDomain = new KiaHyundaiVANCompanyCodeMstDomain();
        
        updDomain.setVndcd(updVndcd);
        updDomain.setFaccd(updFaccd);
        updDomain.setFacnm(updFacnm);
        updDomain.setPscom(updPscom);
        updDomain.setPsvnd1(updPsvnd1);

        updDomain.setOldVndcd(updOldVndcd);
        updDomain.setOldFaccd(updOldFaccd);
        updDomain.setOldFacnm(updOldFacnm);
        updDomain.setOldPscom(updOldPscom);
        updDomain.setOldPsvnd1(updOldPsvnd1);
   
        if(updPscom.equals("E1") ) {
        	// 마산 
        	kiaHyundaiVANCompanyCodeMstService.update(updDomain);

            jsonObj.put("result", DnkrConstans.RESULT_OK);        
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        	
        } else {
        	// 마산 외 창원,화성
        	kiaHyundaiVANCompanyCodeMstService.update030(updDomain);

            jsonObj.put("result", DnkrConstans.RESULT_OK);        
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
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
    @ErrorBack(viewName = "forward:/WAN019KiaHyundaiVANCompanyCodeMst/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();

        String delVndcd = ServletRequestUtils.getStringParameter(request, "vndcd");
        String delFaccd = ServletRequestUtils.getStringParameter(request, "faccd");
        String delFacnm = ServletRequestUtils.getStringParameter(request, "facnm");
        String delPscom = ServletRequestUtils.getStringParameter(request, "pscom");
        String delPsvnd1 = ServletRequestUtils.getStringParameter(request, "psvnd1");
    
        
        //존재하는지 체크
        KiaHyundaiVANCompanyCodeMstDomain cntDomain = new KiaHyundaiVANCompanyCodeMstDomain();
        cntDomain.setVndcd(delVndcd);
        cntDomain.setFaccd(delFaccd);
        cntDomain.setFacnm(delFacnm);
        cntDomain.setPscom(delPscom);
        cntDomain.setPsvnd1(delPsvnd1);
        
        int cnt = 0;
        
        if(delPscom.equals("E1") ) {
        	// 마산 
        	cnt = kiaHyundaiVANCompanyCodeMstService.searchCount(cntDomain);
        	
        } else {
        	// 마산 외 창원,화성
        	cnt = kiaHyundaiVANCompanyCodeMstService.searchCount030(cntDomain);
        }
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        // 삭제
        KiaHyundaiVANCompanyCodeMstDomain delDomain = new KiaHyundaiVANCompanyCodeMstDomain();
        delDomain.setVndcd(delVndcd);
        delDomain.setFaccd(delFaccd);
        delDomain.setFacnm(delFacnm);
        delDomain.setPscom(delPscom);
        delDomain.setPsvnd1(delPsvnd1);

        if(delPscom.equals("E1") ) {
        	// 마산 
        	kiaHyundaiVANCompanyCodeMstService.delete(delDomain);

            jsonObj.put("result", DnkrConstans.RESULT_OK);        
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        	
        } else {
        	// 마산 외 창원,화성
        	kiaHyundaiVANCompanyCodeMstService.delete030(delDomain);

            jsonObj.put("result", DnkrConstans.RESULT_OK);        
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }
      
    }
}
