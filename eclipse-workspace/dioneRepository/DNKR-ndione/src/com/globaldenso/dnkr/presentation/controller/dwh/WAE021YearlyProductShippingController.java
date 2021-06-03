/*
 * Project : NEW DIONE PROJECT
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller.dwh;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.db2.ManagementInfomationService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.DataWarehouseFileDomain;
import com.globaldenso.dnkr.domain.db2.YearlyProductShippingDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE021YearlyProductShippingForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] [종합관리]-[판매정보]-년제품출하현황(월별) Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE021YearlyProductShippingSearch")
@ViewId(value = "WAE021")
public class WAE021YearlyProductShippingController {

	/**
	 * [KR] 종합관리 서비스 <br>
	 */
	@Autowired
	private ManagementInfomationService mifService;

	/**
	 * [KR] 공통코드관리 서비스 <br>
	 */
	@Autowired
	private CodeService codeService;

	/**
	 * [EN] Default constructor.<br>
	 * [JP] デフォルトコンストラクタ。<br>
	 */
	public WAE021YearlyProductShippingController() {
		// no process
	}

	/**
	 * [종합관리] - [판매정보] - 년제품출하현황(월별)  초기화면[KR] <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE022ShippingSalesForm
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initYearlyProductShipping(HttpServletRequest request,
			@ModelAttribute("WAE001MngSearchForm") WAE001MngSearchForm form)
			throws Exception {
		/**
		 * <pre>
		 *             
		 * 1.[JP]           
		 *   [EN] Screen initialization processing.         
		 *   [EN]   I acquire Log information and display it to a screen
		 * </pre>
		 */
		
		// Tab, 메뉴 기본 처리
		String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
		String menu = ServletRequestUtils.getStringParameter(request, "menu");

		ModelAndView mv = new ModelAndView();
		/*
		// 세션 저장된 데이터 불러오기
		EmpDb2Domain empInfo = (EmpDb2Domain) request.getSession().getAttribute("ACCOUNT_DB2");
		//사업부 코드
		CodeDb2Domain codeDomain = new CodeDb2Domain();
		codeDomain.setDb2class("PLNT");
		codeDomain.setCoded1(empInfo.getCompany());

		List<CodeDb2Domain> codeList = null;	//사업부코드
		try {
			codeList = codeService.comCode(codeDomain);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
 		*/
		UxisCmmUtil.getSessionLoc(request, mv);	// 사업부


		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		//mv.addObject("codeList", codeList);
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAE021YearlyProductShipping.jsp");
		mv.setViewName(".tiles.page.WAE021YearlyProductShipping");
		return mv;
	}

	/**
	 * [종합관리] - [판매정보] - 년제품출하현황(월별) 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE022ShippingSalesForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView yearlyProductShippingSearch(HttpServletRequest request,
			@ModelAttribute("WAE021YearlyProductShippingForm") WAE021YearlyProductShippingForm form)
			throws Exception {

		/**
		 * <pre>
		 *             
		 * 1.[JP]           
		 *   [EN] Screen initialization processing.         
		 *   [EN]   I acquire Log information and display it to a screen
		 * </pre>
		 */

		ModelAndView model = new ModelAndView(new JsonView());
		JSONObject jsonObj = new JSONObject();
		String result = DnkrConstans.RESULT_N;
		/*
		// 세션 저장된 데이터 불러오기
		EmpDb2Domain empInfo = (EmpDb2Domain) request.getSession().getAttribute("ACCOUNT_DB2");
		//form.setLib1(empInfo.getLib1());
		form.setLib2(empInfo.getLib2());
	
		String pComps=form.getComps();
		if("E1".equals(pComps)){
			form.setLib1("PERESLIB");
			form.setLib2("PSEDBLIB");
		}else{
			if(!"R1".equals(pComps)){
				form.setLib1("PSRESLIB");
				form.setLib2("PSCDBLIB");
			}else{
				//form.setLib1("");
				form.setLib2("");
			}
		}
		*/
		// 라이브러리 comps 셋팅
		UxisCmmUtil.getCompsLib(form);
		//System.out.println(form.getStartDate()+form.getEndDate());
		//개월수 계산 Start
		String strDt =form.getStartDate().replace("-", "");
		String endDt =form.getEndDate().replace("-", "");
		
		//System.out.println(strDt+endDt);
              
		int sYear= Integer.parseInt(strDt.substring(0,4));
		int sMonth = Integer.parseInt(strDt.substring(4,6));
		int eYear = Integer.parseInt(endDt.substring(0,4)); 
		int eMonth = Integer.parseInt(endDt.substring(4,6)); 

		int month_diff = (eYear - sYear)* 12 + (eMonth - sMonth);
		
		//개월수 계산 End
		//System.out.println(month_diff);
    	//년월 산출 및 SQL Code 작성 Start
    	Date checkDt = new SimpleDateFormat("yyyy-MM-dd").parse(form.getStartDate()+"-01");
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(checkDt);
    	
    	SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
    	
		HashMap<String, String> dayMap = new HashMap<String, String>();
	    String chageDate="";
	    
	    String sqlCode1="";
	    for(int i=0; i<=month_diff; i++){
	    	if (i != 0){
            	calendar.add(calendar.MONTH, 1);        		
        	}    	
        	chageDate= datafmt.format(calendar.getTime());
            dayMap.put("p_YM"+i, chageDate.replace("-","").substring(0,6));
            form.setSearchDate(dayMap);
            
            sqlCode1 += "SUM(CASE WHEN INT(a.jpsdt/100) = " +dayMap.get("p_YM"+i) +" AND a.satyp != '51' THEN a.jpsqy ELSE 0 END) AS JPSQY"+ i+ ", ";
            sqlCode1 += "SUM(CASE WHEN INT(a.jpsdt/100) = " +dayMap.get("p_YM"+i) +" THEN a.jpsam ELSE 0 END) AS JPSAM"+ i+ ", ";
            
	    }
        form.setSqlCode(sqlCode1);

		//System.out.println(form.getSearchDate()+"=="+form.getSearchDate().size()+"=="+form.getComps());
	   // System.out.println(form.getSqlCode());
    
    	//년월 산출 및 SQL Code 작성 End
	    
        form.setStartDate(strDt);
        form.setEndDate(endDt);	

		List<HashMap<String, String>> yearlyProductShippingList = null;
				
		try {
			yearlyProductShippingList = mifService.searchByYearlyProductShipping(form);	
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (yearlyProductShippingList != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", yearlyProductShippingList);
		}
			
		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
}
