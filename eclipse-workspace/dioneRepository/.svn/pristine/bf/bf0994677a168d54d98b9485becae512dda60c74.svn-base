package com.globaldenso.dnkr.presentation.controller.ajax;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.business.service.NonOrderHostUpListService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.NonOrderHostUpListDomain;
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
@RequestMapping(value = "/ajaxNonOrderHostUpList")
public class AjaxNonOrderHostUpListController {

    /**
     * [KR] 업체서열차종이력마스타조회 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private NonOrderHostUpListService nonOrderHostUpListService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxNonOrderHostUpListController() {
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
        List<? extends NonOrderHostUpListDomain> domainlist = null;

        NonOrderHostUpListDomain criteria = new NonOrderHostUpListDomain();

        domainlist = nonOrderHostUpListService.searchByCondition(criteria);

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
        String getTypcd = ServletRequestUtils.getStringParameter(request, "getTypcd");
        String getPlndt = ServletRequestUtils.getStringParameter(request, "getPlndt");                
        
        List<? extends NonOrderHostUpListDomain> domainlist = null;

        NonOrderHostUpListDomain criteria = new NonOrderHostUpListDomain();
        criteria.setComps(getComps);
        criteria.setPyvnd(getPyvnd);
        criteria.setTypcd(getTypcd);
        criteria.setPlndt(getPlndt);

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);
        
        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        // 기준일자부터 말일까지
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();

        Date today = null;
		Date plndt = null;
		try {
			today = sdf.parse(sdf.format(cal.getTime()));
			plndt = sdf.parse(getPlndt);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// 기준일자가 당일보다 이전인지 확인
		int compare = plndt.compareTo(today); // plndt < today
		
		if(compare < 0) criteria.setHistory("Y");
		else criteria.setHistory("N");
			
		// 달의 마지막일자
		cal.setTime(plndt);
		
		int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		List dayList = new ArrayList();
		dayList.add(sdf.format(plndt));
		
		// 일수 차이 구하기
		Date stDate = null;
		Date enDate = null;
		try {
			stDate = sdf.parse(getPlndt);
			enDate = sdf.parse(getPlndt.substring(0, 6) + endDay);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		long diff = enDate.getTime() - stDate.getTime();
    	long period = diff / (24 * 60 * 60 * 1000);
		
		for (int i=1; i<=period; i++) {
			cal.add(cal.DATE, 1);
			dayList.add(sdf.format(cal.getTime()));
		}			
		
		//System.out.println("dayList :  " + dayList.toString());
				
		criteria.setStPlndt(sdf.format(stDate));
		criteria.setEnPlndt(sdf.format(enDate));
		criteria.setDayList(dayList);

        domainlist = nonOrderHostUpListService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
}