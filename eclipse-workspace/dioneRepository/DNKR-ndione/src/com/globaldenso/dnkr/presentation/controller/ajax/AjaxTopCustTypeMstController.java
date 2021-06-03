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
import com.globaldenso.dnkr.business.service.TopCustTypeMstService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.TopCustTypeMstDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisUtil;
import com.globaldenso.dnkr.domain.EmpDb2Domain;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxTopCustTypeMst")
public class AjaxTopCustTypeMstController {

    /**
     * [KR] 대표업체차종마스타 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private TopCustTypeMstService topCustTypeMstService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxTopCustTypeMstController() {
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
        List<? extends TopCustTypeMstDomain> domainlist = null;

        TopCustTypeMstDomain criteria = new TopCustTypeMstDomain();
        
        domainlist = topCustTypeMstService.searchByCondition(criteria);

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
    @RequestMapping(value = "/schnm", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void schnm(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

    	JSONObject jsonObj = new JSONObject();

        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        String getTflag = ServletRequestUtils.getStringParameter(request, "getTflag");
        String getTval = ServletRequestUtils.getStringParameter(request, "getTval");

        TopCustTypeMstDomain domainlist = null;

        TopCustTypeMstDomain criteria = new TopCustTypeMstDomain();
        criteria.setComps(getComps);
        criteria.setTflag(getTflag);
        criteria.setTval(getTval);
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);

        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        domainlist = topCustTypeMstService.searchCountMST050(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }

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
        String getCarcd = ServletRequestUtils.getStringParameter(request, "getCarcd");
        String getBdycd = ServletRequestUtils.getStringParameter(request, "getBdycd");

        List<? extends TopCustTypeMstDomain> domainlist = null;

        TopCustTypeMstDomain criteria = new TopCustTypeMstDomain();
        criteria.setComps(getComps);
        criteria.setPyvnd(getPyvnd);
        criteria.setCarcd(getCarcd);
        criteria.setBdycd(getBdycd);

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);
        
        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        domainlist = topCustTypeMstService.searchByCondition(criteria);

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
    @ErrorBack(viewName = "forward:/WAN002TopCustTypeMst/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();
        
        String delComps1 = ServletRequestUtils.getStringParameter(request, "comps1");
        String delPyvnd1 = ServletRequestUtils.getStringParameter(request, "pyvnd1");
        String delCarcd1 = ServletRequestUtils.getStringParameter(request, "carcd1");
        String delBdycd1 = ServletRequestUtils.getStringParameter(request, "bdycd1");
        String delComps2 = ServletRequestUtils.getStringParameter(request, "comps2");
        String delPyvnd2 = ServletRequestUtils.getStringParameter(request, "pyvnd2");
        String delCarcd2 = ServletRequestUtils.getStringParameter(request, "carcd2");
        String delBdycd2 = ServletRequestUtils.getStringParameter(request, "bdycd2");
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(delComps1);
        
        //존재하는지 체크
        TopCustTypeMstDomain cntDomain = new TopCustTypeMstDomain();
        cntDomain.setComps1(delComps1);
        cntDomain.setPyvnd1(delPyvnd1);
        cntDomain.setCarcd1(delCarcd1);
        cntDomain.setBdycd1(delBdycd1);
        cntDomain.setComps2(delComps2);
        cntDomain.setPyvnd2(delPyvnd2);
        cntDomain.setCarcd2(delCarcd2);
        cntDomain.setBdycd2(delBdycd2);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        int cnt = topCustTypeMstService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        
        TopCustTypeMstDomain delDomain = new TopCustTypeMstDomain();
        delDomain.setComps1(delComps1);
        delDomain.setPyvnd1(delPyvnd1);
        delDomain.setCarcd1(delCarcd1);
        delDomain.setBdycd1(delBdycd1);
        delDomain.setComps2(delComps2);
        delDomain.setPyvnd2(delPyvnd2);
        delDomain.setCarcd2(delCarcd2);
        delDomain.setBdycd2(delBdycd2);
        delDomain.setLib1(empInfo.getLib1());
        delDomain.setLib2(empInfo.getLib2());
        topCustTypeMstService.delete(delDomain);

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
    @ErrorBack(viewName = "forward:/WAN002TopCustTypeMst/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonObj = new JSONObject();

        String insComps1 = ServletRequestUtils.getStringParameter(request, "comps1");
        String insPyvnd1 = ServletRequestUtils.getStringParameter(request, "pyvnd1");
        String insCarcd1 = ServletRequestUtils.getStringParameter(request, "carcd1");
        String insBdycd1 = ServletRequestUtils.getStringParameter(request, "bdycd1");
        String insComps2 = ServletRequestUtils.getStringParameter(request, "comps2");
        String insPyvnd2 = ServletRequestUtils.getStringParameter(request, "pyvnd2");
        String insCarcd2 = ServletRequestUtils.getStringParameter(request, "carcd2");
        String insBdycd2 = ServletRequestUtils.getStringParameter(request, "bdycd2");

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(insComps2);
        
        //존재하는지 체크
        TopCustTypeMstDomain cntDomain = new TopCustTypeMstDomain();

        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        

        cntDomain.setPyvnd(insPyvnd2);
    	int cntCUSNO = topCustTypeMstService.searchCountCUSNO(cntDomain);    	
    	if(cntCUSNO == 0) {
            //jsonObj.put("errMsg", "[확인] 업체 확인바랍니다.");
    		jsonObj.put("errMsg", "LN_CHK3");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        cntDomain.setComps(insComps2);
        cntDomain.setTflag("CAR");
        cntDomain.setTval(insCarcd2);
        TopCustTypeMstDomain cntMST050_CAR = topCustTypeMstService.searchCountMST050(cntDomain);
        if(cntMST050_CAR == null) {
            //jsonObj.put("errMsg", "[확인]차종이 존재하지 않습니다.");
    		jsonObj.put("errMsg", "LN_CHK4");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } 
    	
        cntDomain.setTflag("BDY");
        cntDomain.setTval(insBdycd2);    	
        TopCustTypeMstDomain cntMST050_BDY = topCustTypeMstService.searchCountMST050(cntDomain);
        if(cntMST050_BDY == null) {
            //jsonObj.put("errMsg", "[확인]규격이 존재하지 않습니다.");
    		jsonObj.put("errMsg", "LN_CHK5");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }
    	
    	
        cntDomain.setComps1(insComps1);
        cntDomain.setPyvnd1(insPyvnd1);
        cntDomain.setCarcd1(insCarcd1);
        cntDomain.setBdycd1(insBdycd1);
        cntDomain.setComps2(insComps2);
        cntDomain.setPyvnd2(insPyvnd2);
        cntDomain.setCarcd2(insCarcd2);
        cntDomain.setBdycd2(insBdycd2);

        int cnt = topCustTypeMstService.searchCount(cntDomain);
        
        if(cnt > 0) {
            //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;      	
        }        

    	
        TopCustTypeMstDomain insDomain = new TopCustTypeMstDomain();
        insDomain.setComps1(insComps1);
        insDomain.setPyvnd1(insPyvnd1);
        insDomain.setCarcd1(insCarcd1);
        insDomain.setBdycd1(insBdycd1);
        insDomain.setComps2(insComps2);
        insDomain.setPyvnd2(insPyvnd2);
        insDomain.setCarcd2(insCarcd2);
        insDomain.setBdycd2(insBdycd2);
        insDomain.setLib1(empInfo.getLib1());
        insDomain.setLib2(empInfo.getLib2());
        topCustTypeMstService.create(insDomain);

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
    @ErrorBack(viewName = ".tiles.page.WAN002")
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

        JSONObject jsonObj = new JSONObject();

        String updComps1 = ServletRequestUtils.getStringParameter(request, "comps1");
        String updPyvnd1 = ServletRequestUtils.getStringParameter(request, "pyvnd1");
        String updCarcd1 = ServletRequestUtils.getStringParameter(request, "carcd1");
        String updBdycd1 = ServletRequestUtils.getStringParameter(request, "bdycd1");
        String updComps2 = ServletRequestUtils.getStringParameter(request, "comps2");
        String updPyvnd2 = ServletRequestUtils.getStringParameter(request, "pyvnd2");
        String updCarcd2 = ServletRequestUtils.getStringParameter(request, "carcd2");
        String updBdycd2 = ServletRequestUtils.getStringParameter(request, "bdycd2");

        String updOldComps2 = ServletRequestUtils.getStringParameter(request, "oldComps2");
        String updOldPyvnd2 = ServletRequestUtils.getStringParameter(request, "oldPyvnd2");
        String updOldCarcd2 = ServletRequestUtils.getStringParameter(request, "oldCarcd2");
        String updOldBdycd2 = ServletRequestUtils.getStringParameter(request, "oldBdycd2");
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(updComps1);
               
        //존재하는지 체크
        TopCustTypeMstDomain cntDomain = new TopCustTypeMstDomain();

        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());  
        
        
        cntDomain.setPyvnd(updPyvnd2);
    	int cntCUSNO = topCustTypeMstService.searchCountCUSNO(cntDomain);    	
    	if(cntCUSNO == 0) {
            //jsonObj.put("errMsg", "[확인] 업체 확인바랍니다.");
    		jsonObj.put("errMsg", "LN_CHK3");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } 
    	
        cntDomain.setComps(updComps2);
        cntDomain.setTflag("CAR");
        cntDomain.setTval(updCarcd2);
        TopCustTypeMstDomain cntMST050_CAR = topCustTypeMstService.searchCountMST050(cntDomain);    	
        if(cntMST050_CAR == null) {
            //jsonObj.put("errMsg", "[확인]차종이 존재하지 않습니다.");
    		jsonObj.put("errMsg", "LN_CHK4");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } 
    	
        cntDomain.setTflag("BDY");
        cntDomain.setTval(updBdycd2);    	
        TopCustTypeMstDomain cntMST050_BDY = topCustTypeMstService.searchCountMST050(cntDomain);    	
        if(cntMST050_BDY == null) {
            //jsonObj.put("errMsg", "[확인]규격이 존재하지 않습니다.");
    		jsonObj.put("errMsg", "LN_CHK5");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }
    	
    	
        cntDomain.setComps1(updComps1);
        cntDomain.setPyvnd1(updPyvnd1);
        cntDomain.setCarcd1(updCarcd1);
        cntDomain.setBdycd1(updBdycd1);
        cntDomain.setComps2(updComps2);
        cntDomain.setPyvnd2(updPyvnd2);
        cntDomain.setCarcd2(updCarcd2);
        cntDomain.setBdycd2(updBdycd2);        
        cntDomain.setOldComps2(updOldComps2);
        cntDomain.setOldPyvnd2(updOldPyvnd2);
        cntDomain.setOldCarcd2(updOldCarcd2);
        cntDomain.setOldBdycd2(updOldBdycd2);
        
        int cnt2 = topCustTypeMstService.searchCount2(cntDomain);        
        if(cnt2 == 0) {
            //jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } else {
        	int cnt = topCustTypeMstService.searchCount(cntDomain);        	
        	if(cnt > 0) {
                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        		jsonObj.put("errMsg", "LN_UPD_CHK2");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print(jsonObj);
                return;
            }
        }   

    	
        TopCustTypeMstDomain updDomain = new TopCustTypeMstDomain();
        updDomain.setComps1(updComps1);
        updDomain.setPyvnd1(updPyvnd1);
        updDomain.setCarcd1(updCarcd1);
        updDomain.setBdycd1(updBdycd1);
        updDomain.setComps2(updComps2);
        updDomain.setPyvnd2(updPyvnd2);
        updDomain.setCarcd2(updCarcd2);
        updDomain.setBdycd2(updBdycd2);
        updDomain.setOldComps2(updOldComps2);
        updDomain.setOldPyvnd2(updOldPyvnd2);
        updDomain.setOldCarcd2(updOldCarcd2);
        updDomain.setOldBdycd2(updOldBdycd2);
        updDomain.setLib1(empInfo.getLib1());
        updDomain.setLib2(empInfo.getLib2());    
        topCustTypeMstService.update(updDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}
