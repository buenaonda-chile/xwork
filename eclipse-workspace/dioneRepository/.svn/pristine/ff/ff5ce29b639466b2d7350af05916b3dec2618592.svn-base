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
import com.globaldenso.dnkr.business.service.BatchHistService;
import com.globaldenso.dnkr.business.service.KiaHyundaiVANCompanyCodeMstService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.BatchHistDomain;
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
@RequestMapping(value = "/ajaxBatchHist")
public class AjaxBatchHistController {

    /**
     * [KR] 배치실행이력 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private BatchHistService batchHistService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxBatchHistController() {
        // no process
    }
    

    /**
     * [KO] 조회버튼 클릭.<br>
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

       // String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
       // String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");

        List<? extends BatchHistDomain> domainlist = null;

        BatchHistDomain criteria = new BatchHistDomain();
        //criteria.setComps(getComps);
        //criteria.setPyvnd(getPyvnd);
        
        //System.out.println("getComps : " + getComps);
        

        domainlist = batchHistService.searchByCondition(criteria);
        	

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
}
