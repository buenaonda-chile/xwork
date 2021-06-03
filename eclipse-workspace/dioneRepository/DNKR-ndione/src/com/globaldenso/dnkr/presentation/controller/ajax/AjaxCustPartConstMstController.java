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
import com.globaldenso.dnkr.business.service.CustPartConstMstService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.CustOrderTypeMstDomain;
import com.globaldenso.dnkr.domain.CustPartConstMstDomain;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
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
@RequestMapping(value = "/ajaxCustPartConstMst")
public class AjaxCustPartConstMstController {

    /**
     * [KR] 업체서열차종마스타 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private CustPartConstMstService custPartConstMstService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxCustPartConstMstController() {
        // no process
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
    @RequestMapping(value = "/init", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void init(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

        JSONObject jsonObj = new JSONObject();
        
        /*
        List<? extends CustPartConstMstDomain> domainlist = null;

        CustPartConstMstDomain criteria = new CustPartConstMstDomain();
        
        domainlist = custPartConstMstService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }
        */
        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

    /**
     * [KO] 자료확인.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/check", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void check(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();
        
        String chkPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String chkPspno = ServletRequestUtils.getStringParameter(request, "pspno");
                
        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);
        
        //존재하는지 체크
        CustPartConstMstDomain cntDomain = new CustPartConstMstDomain();
        cntDomain.setPyvnd(chkPyvnd);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        
        cntDomain.setPspno(chkPspno);
        int cntEM000PR = custPartConstMstService.searchCountEM000PR(cntDomain);
        
        if(cntEM000PR == 0) {        	 
            //jsonObj.put("errMsg", "[확인] Part Number Cross Ref MA에 미등록된 득의선,품번입니다.");
        	jsonObj.put("errMsg", "LN_CHK2");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
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
    	
        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        String getSelchk = ServletRequestUtils.getStringParameter(request, "getSelchk");
        String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");        
        String getPspno = ServletRequestUtils.getStringParameter(request, "getPspno");

        List<? extends CustPartConstMstDomain> domainlist = null;
        List<? extends CustPartConstMstDomain> domainlist2 = null;

        CustPartConstMstDomain criteria = new CustPartConstMstDomain();
        criteria.setComps(getComps);
        criteria.setSelchk(getSelchk);
        criteria.setPyvnd(getPyvnd);
        criteria.setPspno(getPspno);

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);

        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        domainlist = custPartConstMstService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }

        domainlist2 = custPartConstMstService.searchByCondition2(criteria);

        if(domainlist2 != null) {
            jsonObj.put("list2", domainlist2);
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
    @ErrorBack(viewName = "forward:/WAN003CustPartConstMst/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();
        
        String delComps = ServletRequestUtils.getStringParameter(request, "comps");
        String delPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String delPspno = ServletRequestUtils.getStringParameter(request, "pspno");
        String delCinbr = ServletRequestUtils.getStringParameter(request, "cinbr");

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(delComps);
        
        //존재하는지 체크
        CustPartConstMstDomain cntDomain = new CustPartConstMstDomain();
        cntDomain.setComps(delComps);
        cntDomain.setPyvnd(delPyvnd);
        cntDomain.setPspno(delPspno);
        cntDomain.setCinbr(delCinbr);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        int cnt = custPartConstMstService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        
        CustPartConstMstDomain delDomain = new CustPartConstMstDomain();
        delDomain.setComps(delComps);
        delDomain.setPyvnd(delPyvnd);
        delDomain.setPspno(delPspno);
        delDomain.setCinbr(delCinbr);
        delDomain.setLib1(empInfo.getLib1());
        delDomain.setLib2(empInfo.getLib2());
        
        custPartConstMstService.delete(delDomain);
        
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
    @ErrorBack(viewName = "forward:/WAN003CustPartConstMst/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonObj = new JSONObject();

        String insComps = ServletRequestUtils.getStringParameter(request, "comps");
        String insPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String insPspno = ServletRequestUtils.getStringParameter(request, "pspno");
        String insCinbr = ServletRequestUtils.getStringParameter(request, "cinbr");
        String insQtypr = ServletRequestUtils.getStringParameter(request, "qtypr");
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(insComps);
        
        
        //존재하는지 체크
        CustPartConstMstDomain cntDomain = new CustPartConstMstDomain();
        cntDomain.setComps(insComps);
        cntDomain.setPyvnd(insPyvnd);
        cntDomain.setPspno(insPspno);
        cntDomain.setCinbr(insCinbr);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        int cnt = custPartConstMstService.searchCount(cntDomain);

        if(cnt > 0) {
            //jsonObj.put("errMsg", "등록불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }      
        
        
        CustPartConstMstDomain insDomain = new CustPartConstMstDomain();
        insDomain.setComps(insComps);
        insDomain.setPyvnd(insPyvnd);
        insDomain.setPspno(insPspno);
        insDomain.setCinbr(insCinbr);
        insDomain.setQtypr(insQtypr);
        insDomain.setLib1(empInfo.getLib1());
        insDomain.setLib2(empInfo.getLib2());  
        custPartConstMstService.create(insDomain);
        
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
    @ErrorBack(viewName = ".tiles.page.WAN003")
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

        JSONObject jsonObj = new JSONObject();

        String updComps = ServletRequestUtils.getStringParameter(request, "comps");
        String updPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String updPspno = ServletRequestUtils.getStringParameter(request, "pspno");
        String updCinbr = ServletRequestUtils.getStringParameter(request, "cinbr");
        String updQtypr = ServletRequestUtils.getStringParameter(request, "qtypr");

        String updOldCinbr = ServletRequestUtils.getStringParameter(request, "oldCinbr");
        String updOldQtypr = ServletRequestUtils.getStringParameter(request, "oldQtypr");
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(updComps);
        
        
        //존재하는지 체크
        CustPartConstMstDomain cntDomain = new CustPartConstMstDomain();
        cntDomain.setComps(updComps);
        cntDomain.setPyvnd(updPyvnd);
        cntDomain.setPspno(updPspno);        
        cntDomain.setOldCinbr(updOldCinbr);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        int cnt2 = custPartConstMstService.searchCount2(cntDomain);
        
        if(cnt2 == 0) {
            //jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.");
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } else {
        	// 구성수량 수정이 안되 처리.
        	if(updQtypr.equals(updOldQtypr)) {
	        	cntDomain.setCinbr(updCinbr);
	        	int cnt = custPartConstMstService.searchCount(cntDomain);
	        	
	        	if(cnt > 0) {
	                //jsonObj.put("errMsg", "수정불가(이미 등록된 자료입니다.)");
	        		jsonObj.put("errMsg", "LN_UPD_CHK2");
	                response.setContentType("text/html;charset=utf-8");
	                response.getWriter().print(jsonObj);
	                return;
	        	}
        	}
        }       


        CustPartConstMstDomain updDomain = new CustPartConstMstDomain();
        updDomain.setComps(updComps);
        updDomain.setPyvnd(updPyvnd);
        updDomain.setPspno(updPspno);
        updDomain.setCinbr(updCinbr);
        updDomain.setQtypr(updQtypr);
        updDomain.setOldCinbr(updOldCinbr);
        updDomain.setLib1(empInfo.getLib1());
        updDomain.setLib2(empInfo.getLib2());    
        custPartConstMstService.update(updDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}