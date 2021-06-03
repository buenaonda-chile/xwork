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
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.ProductInventoryDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE016ProductInventoryForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 제품입출고 조회 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE016ProductInventorySearch")
@ViewId(value = "WAE016")
public class WAE016ProductInventoryController {

	/**
	 * [KR] 경영관리 서비스 <br>
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
	public WAE016ProductInventoryController() {
		// no process
	}

	/**
	 * 제품입출고조회 초기화면[KR] <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE004ProductShippingReceivingSearchForm
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initProductShippingReceiving(HttpServletRequest request,
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
		codeDomain.setCoded1("PS");
		codeDomain.setCoded1(empInfo.getCompany());

		List<CodeDb2Domain> codeList = null;	//사업부코드
		try {
			codeList = codeService.comCode(codeDomain);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
		
		*/
		UxisCmmUtil.getSessionLoc(request, mv);	// 사업부		
		//창고코드
		CodeDb2Domain codeHouseDomain = new CodeDb2Domain();
		codeHouseDomain.setDb2class("HSCD");
		codeHouseDomain.setCoded1("PS");	//KA전용
		//codeHouseDomain.setCoded1(empInfo.getCompany());

		List<CodeDb2Domain> codeHouseList = null;
		try {
			codeHouseList = codeService.comCode(codeHouseDomain);
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
		//사업부 전체 추가
		if("PS".equals(codeHouseDomain.getCode1())){
			CodeDb2Domain codeHouseAddDomain = new CodeDb2Domain();
			//codeHouseAddDomain.setCode2("0");
			//codeHouseAddDomain.setCode_name("전체");
			//codeHouseList.add(codeHouseAddDomain);				
		}
		
		//제품코드
		CodeDb2Domain codePrdcdDomain = new CodeDb2Domain();
		codePrdcdDomain.setLib2("PSCDBLIB");	//TEST용
		//codePrdcdDomain.setLib2(empInfo.getLib2());
		codePrdcdDomain.setComps("C1");	//기존pgm에 C1으로 하드코딩되어있음.
		//codePrdcdDomain.setComps(empInfo.getPlantCd());
		codePrdcdDomain.setGrpcd("PRD");//제풐
		codePrdcdDomain.setMstgu("$");//제외코드
		List<CodeDb2Domain> codePrdcdList = null;
		try {
			codePrdcdList = codeService.comCodeMst050(codePrdcdDomain);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}		
		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		//mv.addObject("codeList", codeList);
		mv.addObject("codeHouseList", codeHouseList);
		mv.addObject("codePrdcdList", codePrdcdList);
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAE016ProductInventory.jsp");
		mv.setViewName(".tiles.page.WAE016ProductInventory");
		return mv;
	}

	/**
	 * 제품입출고 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE016ProductInventoryForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView productShippingReceivingSearch(HttpServletRequest request,
			@ModelAttribute("WAE016ProductInventoryForm") WAE016ProductInventoryForm form)
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

		// 라이브러리 comps 셋팅
		UxisCmmUtil.getCompsLib(form);
		
		String selectType=form.getJobName();
		String pPackc = form.getPackc();
		
		if("house".equals(selectType)){
			if(pPackc.equals("LOC000004")){	//마산
				form.setPackc("E1");
			}else if(pPackc.equals("LOC000001")){	//창원
				form.setPackc("C1");
			}else if(pPackc.equals("LOC000002")){	//홍성
				form.setPackc("H1");
			}else if(pPackc.equals("LOC000003")){	//화성
				form.setPackc("S1");
			}
		}
			
		System.out.println(form.getJobName()+form.getComps()+form.getPspno()+form.getHouse()+form.getPackc());
		
		SimpleDateFormat datafmt = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		String thisYear = datafmt.format(calendar.getTime());
		//System.out.println(thisYear);
		form.setStartDate(thisYear);
				
		List<ProductInventoryDomain> productInventoryList = null;
		try {
			productInventoryList = mifService.searchByProductInventory(form);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (productInventoryList != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", productInventoryList);
		}

		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
}
