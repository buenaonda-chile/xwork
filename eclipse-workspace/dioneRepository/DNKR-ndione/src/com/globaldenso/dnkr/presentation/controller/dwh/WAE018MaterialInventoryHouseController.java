/*
 * Project : NEW DIONE PROJECT
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller.dwh;

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
import com.globaldenso.dnkr.domain.db2.MaterialInventoryDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE019MaterialInventoryForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 자재입출고 재고현황 조회 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE018MaterialInventoryHouseSearch")
@ViewId(value = "WAE018")
public class WAE018MaterialInventoryHouseController {

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
	public WAE018MaterialInventoryHouseController() {
		// no process
	}

	/**
	 * 자재입출고 재고현황 초기화면[KR] <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE019MaterialInventoryForm
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initMaterialInventory(HttpServletRequest request,
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

		UxisCmmUtil.getSessionLoc(request, mv);	// 사업부

		//창고코드
		CodeDb2Domain codeHouseDomain = new CodeDb2Domain();
		codeHouseDomain.setDb2class("HSCD");
		codeHouseDomain.setCoded1("PS");	//구KA전용
		//codeHouseDomain.setCoded1(empInfo.getCompany());

		List<CodeDb2Domain> codeHouseList = null;
		try {
			codeHouseList = codeService.comCode(codeHouseDomain);	
			//창고코드 전체 추가
			CodeDb2Domain codeHouseAddDomain = new CodeDb2Domain();			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
				
		//제품코드
		CodeDb2Domain codePrdcdDomain = new CodeDb2Domain();
		codePrdcdDomain.setComps("C1"); //구KA전용
		codePrdcdDomain.setLib2("PSCDBLIB");	//TEST용
		//codePrdcdDomain.setLib2(empInfo.getLib2());
		//codePrdcdDomain.setComps(empInfo.getPlantCd());
		codePrdcdDomain.setGrpcd("PRD");//제풐
		codePrdcdDomain.setMstgu("$");//제외코드
		List<CodeDb2Domain> codePrdcdList = null;
		try {
			codePrdcdList = codeService.comCodeMst050(codePrdcdDomain);	
			//제품코드 전체 추가
			CodeDb2Domain codePrdcdAddDomain = new CodeDb2Domain();
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		mv.addObject("codeHouseList", codeHouseList);
		mv.addObject("codePrdcdList", codePrdcdList);
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAE018MaterialInventoryHouse.jsp");
		mv.setViewName(".tiles.page.WAE018MaterialInventoryHouse");
		return mv;
	}

	/**
	 * 자재입출고 재고현황 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE019MaterialInventoryForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView materialInventoryHouseSearch(HttpServletRequest request,
			@ModelAttribute("WAE019MaterialInventoryForm") WAE019MaterialInventoryForm form)
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
		
		//System.out.println(form.getComps()+form.getHouse()+form.getPrdcd()+form.getPlann()+form.getGubun());
		
		// 라이브러리 comps 셋팅
		UxisCmmUtil.getCompsLib(form);
		
		if("E1".equals(form.getComps())){
			form.setCompany("PE");
		}else{
			form.setCompany("PS");
		}
		
		List<MaterialInventoryDomain> materialInventoryHouseList = null;
		try {
			materialInventoryHouseList = mifService.searchByMaterialInventoryHouse(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (materialInventoryHouseList != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", materialInventoryHouseList);
		}

		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;

	}
	
}
