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
import com.globaldenso.dnkr.business.service.DuplTypeOrderCodeMstService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.DuplTypeOrderCodeMstDomain;
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
@RequestMapping(value = "/ajaxDuplTypeOrderCodeMst")
public class AjaxDuplTypeOrderCodeMstController {

    /**
     * [KR] 중복차종서열코드마스타 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private DuplTypeOrderCodeMstService duplTypeOrderCodeMstService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxDuplTypeOrderCodeMstController() {
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

    	String getSelchk = ServletRequestUtils.getStringParameter(request, "getSelchk");
        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");
        String getMcrcd = ServletRequestUtils.getStringParameter(request, "getMcrcd");
        String getMsecd = ServletRequestUtils.getStringParameter(request, "getMsecd");

        List<? extends DuplTypeOrderCodeMstDomain> domainlist = null;

        DuplTypeOrderCodeMstDomain criteria = new DuplTypeOrderCodeMstDomain();
        criteria.setSelchk(getSelchk);
        criteria.setComps(getComps);
        criteria.setPyvnd(getPyvnd);
        criteria.setMcrcd(getMcrcd);
        criteria.setMsecd(getMsecd);

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);

        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        domainlist = duplTypeOrderCodeMstService.searchByCondition(criteria);

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
        
        String delComps = ServletRequestUtils.getStringParameter(request, "comps");
        String delPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String delMcrcd = ServletRequestUtils.getStringParameter(request, "mcrcd");
        String delMsecd = ServletRequestUtils.getStringParameter(request, "msecd");
        String delMcrc1 = ServletRequestUtils.getStringParameter(request, "mcrc1");
        String delMsec1 = ServletRequestUtils.getStringParameter(request, "msec1");        
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(delComps);
        
        //존재하는지 체크
        DuplTypeOrderCodeMstDomain cntDomain = new DuplTypeOrderCodeMstDomain();
        cntDomain.setComps(delComps);
        cntDomain.setPyvnd(delPyvnd);
        cntDomain.setMcrcd(delMcrcd);
        cntDomain.setMsecd(delMsecd);
        cntDomain.setMcrc1(delMcrc1);
        cntDomain.setMsec1(delMsec1);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        int cnt = duplTypeOrderCodeMstService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        
        DuplTypeOrderCodeMstDomain delDomain = new DuplTypeOrderCodeMstDomain();
        delDomain.setComps(delComps);
        delDomain.setPyvnd(delPyvnd);
        delDomain.setMcrcd(delMcrcd);
        delDomain.setMsecd(delMsecd);
        delDomain.setMcrc1(delMcrc1);
        delDomain.setMsec1(delMsec1);
        delDomain.setLib1(empInfo.getLib1());
        delDomain.setLib2(empInfo.getLib2());
        duplTypeOrderCodeMstService.delete(delDomain);

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

        String insComps = ServletRequestUtils.getStringParameter(request, "comps");
        String insPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String insMcrcd = ServletRequestUtils.getStringParameter(request, "mcrcd");
        String insMsecd = ServletRequestUtils.getStringParameter(request, "msecd");
        String insMcrc1 = ServletRequestUtils.getStringParameter(request, "mcrc1");
        String insMsec1 = ServletRequestUtils.getStringParameter(request, "msec1");
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(insComps);
        
        //존재하는지 체크
        DuplTypeOrderCodeMstDomain cntDomain = new DuplTypeOrderCodeMstDomain();
        cntDomain.setComps(insComps);
        cntDomain.setPyvnd(insPyvnd);
        cntDomain.setMcrcd(insMcrcd);
        cntDomain.setMsecd(insMsecd);
        cntDomain.setMcrc1(insMcrc1);
        cntDomain.setMsec1(insMsec1);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        int cnt = duplTypeOrderCodeMstService.searchCount(cntDomain);
        
        if(cnt > 0) {
            //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } else {
        	int cntSVM100 = duplTypeOrderCodeMstService.searchCountSVM100(cntDomain);
        	
        	if(cntSVM100 > 0) {
                //jsonObj.put("errMsg", "추가불가(업체서열차종마스터에 등록된 자료입니다.)");
        		jsonObj.put("errMsg", "LN_INS_CHK2");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print(jsonObj);
                return;
            }        	
        }        
        
        
        DuplTypeOrderCodeMstDomain insDomain = new DuplTypeOrderCodeMstDomain();
        insDomain.setComps(insComps);
        insDomain.setPyvnd(insPyvnd);
        insDomain.setMcrcd(insMcrcd);
        insDomain.setMsecd(insMsecd);
        insDomain.setMcrc1(insMcrc1);
        insDomain.setMsec1(insMsec1);
        insDomain.setLib1(empInfo.getLib1());
        insDomain.setLib2(empInfo.getLib2());
        duplTypeOrderCodeMstService.create(insDomain);

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

        String updComps = ServletRequestUtils.getStringParameter(request, "comps");
        String updPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String updMcrcd = ServletRequestUtils.getStringParameter(request, "mcrcd");
        String updMsecd = ServletRequestUtils.getStringParameter(request, "msecd");
        String updMcrc1 = ServletRequestUtils.getStringParameter(request, "mcrc1");
        String updMsec1 = ServletRequestUtils.getStringParameter(request, "msec1");

        String updOldMcrc1 = ServletRequestUtils.getStringParameter(request, "oldMcrc1");
        String updOldMsec1 = ServletRequestUtils.getStringParameter(request, "oldMsec1");
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(updComps);
        
        //존재하는지 체크
        DuplTypeOrderCodeMstDomain cntDomain = new DuplTypeOrderCodeMstDomain();
        cntDomain.setComps(updComps);
        cntDomain.setPyvnd(updPyvnd);
        cntDomain.setMcrcd(updMcrcd);
        cntDomain.setMsecd(updMsecd);
        cntDomain.setMcrc1(updMcrc1);
        cntDomain.setMsec1(updMsec1);
        cntDomain.setOldMcrc1(updOldMcrc1);
        cntDomain.setOldMsec1(updOldMsec1);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());        
        int cnt2 = duplTypeOrderCodeMstService.searchCount2(cntDomain);
        
        if(cnt2 == 0) {
            //jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } else {
        	int cnt = duplTypeOrderCodeMstService.searchCount(cntDomain);
        	
        	if(cnt > 0) {
                //jsonObj.put("errMsg", "수정불가(이미 등록된 자료입니다.)");
        		jsonObj.put("errMsg", "LN_UPD_CHK2");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print(jsonObj);
                return;
            } else {
            	int cntSVM100 = duplTypeOrderCodeMstService.searchCountSVM100(cntDomain);
            	
            	if(cntSVM100 > 0) {
                    //jsonObj.put("errMsg", "수정불가(업체서열차종마스터에 등록된 자료입니다.)");
            		jsonObj.put("errMsg", "LN_UPD_CHK3");
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().print(jsonObj);
                    return;
                }   
            }
        }   
     
        
        DuplTypeOrderCodeMstDomain updDomain = new DuplTypeOrderCodeMstDomain();
        updDomain.setComps(updComps);
        updDomain.setPyvnd(updPyvnd);
        updDomain.setMcrcd(updMcrcd);
        updDomain.setMsecd(updMsecd);
        updDomain.setMcrc1(updMcrc1);
        updDomain.setMsec1(updMsec1);
        updDomain.setOldMcrc1(updOldMcrc1);
        updDomain.setOldMsec1(updOldMsec1);
        updDomain.setLib1(empInfo.getLib1());
        updDomain.setLib2(empInfo.getLib2());    
        duplTypeOrderCodeMstService.update(updDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}
