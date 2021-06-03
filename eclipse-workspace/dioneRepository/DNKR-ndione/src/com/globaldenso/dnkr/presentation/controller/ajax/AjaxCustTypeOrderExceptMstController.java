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
import com.globaldenso.dnkr.business.service.CustTypeOrderExceptMstService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.CustTypeOrderExceptMstDomain;
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
@RequestMapping(value = "/ajaxCustTypeOrderExceptMst")
public class AjaxCustTypeOrderExceptMstController {

    /**
     * [KR] 업체차종서열제외마스타 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private CustTypeOrderExceptMstService custTypeOrderExceptMstService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxCustTypeOrderExceptMstController() {
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
        List<? extends CustTypeOrderExceptMstDomain> domainlist = null;

        CustTypeOrderExceptMstDomain criteria = new CustTypeOrderExceptMstDomain();

        domainlist = custTypeOrderExceptMstService.searchByCondition(criteria);

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

        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");

        List<? extends CustTypeOrderExceptMstDomain> domainlist = null;

        CustTypeOrderExceptMstDomain criteria = new CustTypeOrderExceptMstDomain();
        criteria.setComps(getComps);
        criteria.setPyvnd(getPyvnd);

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);
        
        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        domainlist = custTypeOrderExceptMstService.searchByCondition(criteria);

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
    @ErrorBack(viewName = "forward:/WAN004CustTypeOrderExceptMst/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();
        
        String delComps = ServletRequestUtils.getStringParameter(request, "comps");
        String delPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String delMkcar = ServletRequestUtils.getStringParameter(request, "mkcar");
        String delSeyno = ServletRequestUtils.getStringParameter(request, "seyno");
        String delSeycd = ServletRequestUtils.getStringParameter(request, "seycd");

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(delComps);
        
        //존재하는지 체크
        CustTypeOrderExceptMstDomain cntDomain = new CustTypeOrderExceptMstDomain();
        cntDomain.setComps(delComps);
        cntDomain.setPyvnd(delPyvnd);
        cntDomain.setMkcar(delMkcar);
        cntDomain.setSeyno(delSeyno);
        cntDomain.setSeycd(delSeycd);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        int cnt = custTypeOrderExceptMstService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        
        CustTypeOrderExceptMstDomain delDomain = new CustTypeOrderExceptMstDomain();
        delDomain.setComps(delComps);
        delDomain.setPyvnd(delPyvnd);
        delDomain.setMkcar(delMkcar);
        delDomain.setSeyno(delSeyno);
        delDomain.setSeycd(delSeycd);
        delDomain.setLib1(empInfo.getLib1());
        delDomain.setLib2(empInfo.getLib2());
        custTypeOrderExceptMstService.delete(delDomain);

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
    @ErrorBack(viewName = "forward:/WAN004CustTypeOrderExceptMst/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonObj = new JSONObject();

        String insComps = ServletRequestUtils.getStringParameter(request, "comps");
        String insPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String insMkcar = ServletRequestUtils.getStringParameter(request, "mkcar");
        String insSeyno = ServletRequestUtils.getStringParameter(request, "seyno");
        String insSeycd = ServletRequestUtils.getStringParameter(request, "seycd");
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(insComps);
                
        //존재하는지 체크
        CustTypeOrderExceptMstDomain cntDomain = new CustTypeOrderExceptMstDomain();
        cntDomain.setComps(insComps);
        cntDomain.setPyvnd(insPyvnd);
        cntDomain.setMkcar(insMkcar);
        cntDomain.setSeyno(insSeyno);
        cntDomain.setSeycd(insSeycd);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());

        int cnt = custTypeOrderExceptMstService.searchCount(cntDomain);
        
        if(cnt > 0) {
            //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;      	
        } else {
        	int cntSVM101 = custTypeOrderExceptMstService.searchCountSVM101(cntDomain);
        	
        	if(cntSVM101 > 0) {
                //jsonObj.put("errMsg", "추가불가(업체서열차종마스터에 등록된 자료입니다.)");
        		jsonObj.put("errMsg", "LN_INS_CHK2");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print(jsonObj);
                return;
            }        	
        }  


        CustTypeOrderExceptMstDomain insDomain = new CustTypeOrderExceptMstDomain();
        insDomain.setComps(insComps);
        insDomain.setPyvnd(insPyvnd);
        insDomain.setMkcar(insMkcar);
        insDomain.setSeyno(insSeyno);
        insDomain.setSeycd(insSeycd);
        insDomain.setLib1(empInfo.getLib1());
        insDomain.setLib2(empInfo.getLib2());
        custTypeOrderExceptMstService.create(insDomain);

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
    @ErrorBack(viewName = ".tiles.page.WAN004")
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

        JSONObject jsonObj = new JSONObject();

        String updComps = ServletRequestUtils.getStringParameter(request, "comps");
        String updPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String updMkcar = ServletRequestUtils.getStringParameter(request, "mkcar");
        String updSeyno = ServletRequestUtils.getStringParameter(request, "seyno");
        String updSeycd = ServletRequestUtils.getStringParameter(request, "seycd");

        String updOldMkcar = ServletRequestUtils.getStringParameter(request, "oldMkcar");
        String updOldSeyno = ServletRequestUtils.getStringParameter(request, "oldSeyno");
        String updOldSeycd = ServletRequestUtils.getStringParameter(request, "oldSeycd");

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(updComps);
                       
        //존재하는지 체크
        CustTypeOrderExceptMstDomain cntDomain = new CustTypeOrderExceptMstDomain();
        cntDomain.setComps(updComps);
        cntDomain.setPyvnd(updPyvnd);
        cntDomain.setMkcar(updMkcar);
        cntDomain.setSeyno(updSeyno);
        cntDomain.setSeycd(updSeycd);       
        cntDomain.setOldMkcar(updOldMkcar);
        cntDomain.setOldSeyno(updOldSeyno);
        cntDomain.setOldSeycd(updOldSeycd);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());  

        int cnt2 = custTypeOrderExceptMstService.searchCount2(cntDomain); 
        
        if(cnt2 == 0) {
            //jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } else {
        	int cnt = custTypeOrderExceptMstService.searchCount(cntDomain);
        	
        	if(cnt > 0) {
                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        		jsonObj.put("errMsg", "LN_UPD_CHK2");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print(jsonObj);
                return;
            } else {
            	int cntSVM101 = custTypeOrderExceptMstService.searchCountSVM101(cntDomain);
            	
            	if(cntSVM101 > 0) {
                    //jsonObj.put("errMsg", "수정불가(업체서열차종마스터에 등록된 자료입니다.)");
            		jsonObj.put("errMsg", "LN_UPD_CHK3");
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().print(jsonObj);
                    return;
                }   
            }
        }   

    	
        CustTypeOrderExceptMstDomain updDomain = new CustTypeOrderExceptMstDomain();
        updDomain.setComps(updComps);
        updDomain.setPyvnd(updPyvnd);
        updDomain.setMkcar(updMkcar);
        updDomain.setSeyno(updSeyno);
        updDomain.setSeycd(updSeycd);       
        updDomain.setOldMkcar(updOldMkcar);
        updDomain.setOldSeyno(updOldSeyno);
        updDomain.setOldSeycd(updOldSeycd);
        updDomain.setLib1(empInfo.getLib1());
        updDomain.setLib2(empInfo.getLib2());    
        custTypeOrderExceptMstService.update(updDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}
