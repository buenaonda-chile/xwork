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
import com.globaldenso.dnkr.business.service.OrderDayITEMMstService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.OrderDayITEMMstDomain;
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
@RequestMapping(value = "/ajaxOrderDayITEMMst")
public class AjaxOrderDayITEMMstController {

    /**
     * [KR] 일일수주갱신 ITEM 제어마스타 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private OrderDayITEMMstService orderDayITEMMstService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxOrderDayITEMMstController() {
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

        List<? extends OrderDayITEMMstDomain> domainlist = null;

        OrderDayITEMMstDomain criteria = new OrderDayITEMMstDomain();
        criteria.setComps(getComps);
        criteria.setPyvnd(getPyvnd);
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);
        
        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        domainlist = orderDayITEMMstService.searchByCondition(criteria);

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
    @ErrorBack(viewName = "forward:/WAN020OrderDayITEMMst/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonObj = new JSONObject();
        String insComps = ServletRequestUtils.getStringParameter(request, "comps");
        String insPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String insPspno = ServletRequestUtils.getStringParameter(request, "pspno");
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(insComps);       
        
        // 품번 존재 체크
        OrderDayITEMMstDomain pspnoCntDomain = new OrderDayITEMMstDomain();
        
        pspnoCntDomain.setLib1(empInfo.getLib1());
        pspnoCntDomain.setLib2(empInfo.getLib2());
        
        pspnoCntDomain.setComps(insComps);
        pspnoCntDomain.setPyvnd(insPyvnd);
        pspnoCntDomain.setPspno(insPspno);
        
        int pspnoCnt = orderDayITEMMstService.pspnoSearchCount(pspnoCntDomain);
        
        if(pspnoCnt == 0) {
            //jsonObj.put("errMsg", "Part Number Cross Ref MA에 미등록된 득의선,품번입니다.");
        	jsonObj.put("errMsg", "LN_CHK7");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;      	
        }    
        
        
        //데이터 존재하는지 체크
        OrderDayITEMMstDomain cntDomain = new OrderDayITEMMstDomain();

        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        
        cntDomain.setComps(insComps);
        cntDomain.setPyvnd(insPyvnd);
        cntDomain.setPspno(insPspno);
        
        int cnt = orderDayITEMMstService.searchCount(cntDomain);
        
        if(cnt > 0) {
            //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;      	
        }        

    	// 등록
        OrderDayITEMMstDomain insDomain = new OrderDayITEMMstDomain();
        insDomain.setComps(insComps);
        insDomain.setPyvnd(insPyvnd);
        insDomain.setPspno(insPspno);
      
        insDomain.setLib1(empInfo.getLib1());
        insDomain.setLib2(empInfo.getLib2());
        orderDayITEMMstService.create(insDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
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
    @ErrorBack(viewName = "forward:/WAN020OrderDayITEMMst/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();
        
        String delComps = ServletRequestUtils.getStringParameter(request, "comps");
        String delPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");

        String delPspno = ServletRequestUtils.getStringParameter(request, "pspno");
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(delComps);
        
        //존재하는지 체크
        OrderDayITEMMstDomain cntDomain = new OrderDayITEMMstDomain();
        cntDomain.setComps(delComps);
        cntDomain.setPyvnd(delPyvnd);
        cntDomain.setPspno(delPspno);
        
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        int cnt = orderDayITEMMstService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        // 삭제
        OrderDayITEMMstDomain delDomain = new OrderDayITEMMstDomain();
        delDomain.setComps(delComps);
        delDomain.setPyvnd(delPyvnd);
        delDomain.setPspno(delPspno);

        delDomain.setLib1(empInfo.getLib1());
        delDomain.setLib2(empInfo.getLib2());
        orderDayITEMMstService.delete(delDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}
