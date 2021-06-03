package com.globaldenso.dnkr.presentation.controller.sal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.NonOrderDayTransferWorkService;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.NonOrderDayTransferWorkDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KR] 비서열/확정오더형 일일 수주이관 작업  컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAN018NonOrderDayTransferWork")
@ViewId(value = "WAN018")
public class WAN018NonOrderDayTransferWorkController {

    /**
     * [KR] 비서열/확정오더형 일일 수주이관 작업 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private NonOrderDayTransferWorkService nonOrderDayTransferWorkService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAN018NonOrderDayTransferWorkController() {
        // no process
    }
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request)  throws Exception {

        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");

        UxisCmmUtil.getSessionComCode(request, mv);

        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        mv.addObject("userId", empInfo.getEmpNumber());
        
        SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        String today = datafmt.format(calendar.getTime());
        mv.addObject("today", today);
        
        List<? extends NonOrderDayTransferWorkDomain> domainlist = null;
	        
        CommonDb2Domain empInfo2 = UxisUtil.getDB2Lib(empInfo.getClsCode());
    	
        NonOrderDayTransferWorkDomain criteria = new NonOrderDayTransferWorkDomain();
        criteria.setLib1(empInfo2.getLib1());
        criteria.setLib2(empInfo2.getLib2());

        domainlist = nonOrderDayTransferWorkService.searchCigmaDate(criteria);
	
        if(domainlist != null) {
        	String cigmaDate = domainlist.get(0).getAdsdt();
        	mv.addObject("cigmaDate", cigmaDate.substring(0, 4) + "-" + cigmaDate.substring(4, 6) + "-" + cigmaDate.substring(6));
        }        
   
        
//      mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("tabId", tabId);
        mv.addObject("url", "NonOrderDayTransferWork.jsp");
        mv.setViewName(".tiles.page.WAN018");
        return mv;
        
    }
    
    /**
     * [KO] 이관.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/trans", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void search(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

    	JSONObject jsonObj = new JSONObject();
    	
        String getParam = ServletRequestUtils.getStringParameter(request, "getParam");        

    	HashMap map = new HashMap();
    	map.put("mi_parm", getParam);
        
    	boolean rtn = nonOrderDayTransferWorkService.procTrans(map);

    	if(rtn) jsonObj.put("rtnMsg", "수주이관 작업 success");
    	else jsonObj.put("rtnMsg", "수주이관 작업 error");

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }    

}
