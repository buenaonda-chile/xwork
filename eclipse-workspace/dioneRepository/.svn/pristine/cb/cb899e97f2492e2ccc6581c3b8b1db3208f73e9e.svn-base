package com.globaldenso.dnkr.presentation.controller.sal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

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
import com.globaldenso.dnkr.business.service.OrderDaySaleCreateService;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 서열형 일일판매생성  컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAN010OrderDaySaleCreate")
@ViewId(value = "WAN010")
public class WAN010OrderDaySaleCreateController {

    /**
     * [KR] 서열형 일일판매생성 작업 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private OrderDaySaleCreateService orderDaySaleCreateService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAN010OrderDaySaleCreateController() {
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

        SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        String today = datafmt.format(calendar.getTime());
        mv.addObject("today", today);
    
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        mv.addObject("userId", empInfo.getEmpNumber());
        
//      mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("tabId", tabId);
        mv.addObject("url", "OrderDaySaleCreate.jsp");
        mv.setViewName(".tiles.page.WAN010");
        return mv;
        
    }
    
    /**
     * [KO] 생성.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void create(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

    	JSONObject jsonObj = new JSONObject();
    	
        String getParam = ServletRequestUtils.getStringParameter(request, "getParam");        

        HashMap<String, String> param = new HashMap<String, String>();
    	param.put("param", getParam);
        
    	boolean rtn = false;
    	
    	try {
    		
    		rtn = orderDaySaleCreateService.procCreate(param, request);
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	if(rtn) jsonObj.put("rtnMsg", "일일판매생성 success");
    	else jsonObj.put("rtnMsg", "일일판매생성 error");
    	
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
    
}
