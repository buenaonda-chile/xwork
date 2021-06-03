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
import com.globaldenso.dnkr.business.service.SalAnlysComentService;
import com.globaldenso.dnkr.business.service.SalPlnPerfmncMtReprtExlService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.SalPlnPerfmncMtReprtExlDomain;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.SalAnlysComentDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/ajaxSalPlnPerfmncMtReprtExl")
public class AjaxSalPlnPerfmncMtReprtExlController {

    /**
     * [KR]  
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private SalPlnPerfmncMtReprtExlService salPlnPerfmncMtReprtExlService;
    
    /**
     * [KR]  판매계획 매출입력(매출분석코멘트)서비스 <br>
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private SalAnlysComentService salAnlysComentService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxSalPlnPerfmncMtReprtExlController() {
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
		
		String getComps = ServletRequestUtils.getStringParameter(request, "getLocCode");
		String getDumcb = ServletRequestUtils.getStringParameter(request, "getDumcb");
		/*
		 * 추가파라미터 존재할경우 추가해야함.			
		 */
        
		List<? extends SalPlnPerfmncMtReprtExlDomain> salPlnList = null;
        List<? extends SalPlnPerfmncMtReprtExlDomain> chartList = null;
        SalPlnPerfmncMtReprtExlDomain criteria = new SalPlnPerfmncMtReprtExlDomain();
//        criteria.setComps(getComps);
                        
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);
        
        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        criteria.setDumcb(getDumcb);
        
        // 판매현황 계획실적
        salPlnList = salPlnPerfmncMtReprtExlService.searchBySalPlnList(criteria);
        
        // 주요상품별 사업계획 대비 증감수량
        chartList = salPlnPerfmncMtReprtExlService.searchByCondition(criteria);
        
        
        // 코멘트
        SalAnlysComentDomain criteria2 = new SalAnlysComentDomain();
        
        criteria2.setComps(getComps);
        criteria2.setRepym(getDumcb);
        criteria2.setReprtse("R2");
        
        List<SalAnlysComentDomain> comentList = salAnlysComentService.searchByCondition(criteria2);
        
        
        if(salPlnList != null) {
            jsonObj.put("salPlnList", salPlnList);
        }
        
        if(chartList != null) {
            jsonObj.put("chartList", chartList);
        }
        
        if(comentList != null) {
            jsonObj.put("comentList", comentList);
        }
        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

  
}
