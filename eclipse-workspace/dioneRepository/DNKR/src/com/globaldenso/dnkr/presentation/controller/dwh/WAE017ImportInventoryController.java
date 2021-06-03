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
import com.globaldenso.dnkr.domain.PsogmPerSearchDomain;
import com.globaldenso.dnkr.domain.RelationDb2Domain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.ImportInventoryDomain;
import com.globaldenso.dnkr.domain.db2.ImportInventoryPopDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE017ImportInventoryForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE017ImportInventoryPopForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 수입품 현재고 현황 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE017ImportInventorySearch")
@ViewId(value = "WAE017")
public class WAE017ImportInventoryController {

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
	public WAE017ImportInventoryController() {
		// no process
	}

	/**
	 * 수입품 현재고 현황 초기화면[KR] <br>
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
		codeDomain.setCoded1(empInfo.getCompany());

		List<CodeDb2Domain> codeList = null;	//사업부코드
		try {
			codeList = codeService.comCode(codeDomain);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
		*/
		// 사업부
		UxisCmmUtil.getSessionLoc(request, mv);
				
		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		//mv.addObject("codeList", codeList);
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAE017ImportInventory.jsp");
		mv.setViewName(".tiles.page.WAE017ImportInventory");
		return mv;
	}

	/**
	 * 수입품 현재고 현황 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE004ProductShippingReceivingSearchForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView importInventorySearch(HttpServletRequest request,
			@ModelAttribute("WAE017ImportInventoryForm") WAE017ImportInventoryForm form)
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
		//form.setComps(empInfo.getPlantCd());
		form.setLib1(empInfo.getLib1());
		form.setLib2(empInfo.getLib2());
		*/
		// 라이브러리 comps 셋팅
		UxisCmmUtil.getCompsLib(form);
		List<ImportInventoryDomain> importInventoryList = null;
		try {
			importInventoryList = mifService.searchByImportInventory(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (importInventoryList != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", importInventoryList);
		}

		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param request HttpServletRequest
     * @param domain PsogmPerSearchDomain
     * @return ModelAndView
     * @throws Exception excepiton
     */
    @RequestMapping(value = "/importInventoryPop", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView importInventoryPop(HttpServletRequest request,
			@ModelAttribute("WAE017ImportInventoryForm") WAE017ImportInventoryForm form)
			throws Exception {

        ModelAndView mv = new ModelAndView();
        		
		// 세션 저장된 데이터 불러오기
        ImportInventoryPopDomain domain = new ImportInventoryPopDomain();
      
        //System.out.println(form.getComps()+"=="+form.getExpno()+"=="+form.getpExpno());
        /*
		EmpDb2Domain empInfo = (EmpDb2Domain) request.getSession().getAttribute("ACCOUNT_DB2");
		//form.setComps(empInfo.getPlantCd());
		domain.setComps(form.getComps());
		domain.setExpno(form.getpExpno());
		domain.setLib1(empInfo.getLib1());
		domain.setLib2(empInfo.getLib2());
		*/
		// 라이브러리 comps 셋팅
		UxisCmmUtil.getCompsLib(form);
		
		domain.setComps(form.getComps());
		domain.setExpno(form.getpExpno());
		domain.setLib1(form.getLib1());
		domain.setLib2(form.getLib2());
		
		
		SimpleDateFormat datafmt = new SimpleDateFormat("yyyyMM");
		Calendar calendar = Calendar.getInstance();
		String thisYear = datafmt.format(calendar.getTime());
		System.out.println(thisYear);
		domain.setStartDate(thisYear);
		
		
        ImportInventoryPopDomain pop1List = null;
        try {
            pop1List = mifService.searchByImportInventoryPop1(domain);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("데이터가 없습니다.");
        }
        
        List<ImportInventoryPopDomain> pop2List = null;
        

        mv.addObject("pop1List", pop1List);
        mv.addObject("pop2List", pop2List);
        mv.addObject("url", "WAE017ImportInventoryPop.jsp");
		mv.setViewName(".tiles.page.WAE017ImportInventoryPop");
        return mv;
    }
	/**
	 * 수입품 현재고 현황 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE004ProductShippingReceivingSearchForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxImportInventoryPop", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView ajaxImportInventoryPop(HttpServletRequest request,
			@ModelAttribute("WAE017ImportInventoryPopForm") WAE017ImportInventoryPopForm form)
			throws Exception {

		ModelAndView model = new ModelAndView(new JsonView());
		JSONObject jsonObj = new JSONObject();
		String result = DnkrConstans.RESULT_N;
		
		// 세션 저장된 데이터 불러오기
		EmpDb2Domain empInfo = (EmpDb2Domain) request.getSession().getAttribute("ACCOUNT_DB2");
		//form.setComps(empInfo.getPlantCd());
		//domain.setComps(form.getComps());
		//domain.setExpno(form.getExpno());
		
		form.setLib1(empInfo.getLib1());
		form.setLib2(empInfo.getLib2());
				
		List<ImportInventoryPopDomain> pop2List = null;
		try {
			pop2List = mifService.searchByImportInventoryPop2(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (pop2List != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", pop2List);
		}

		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
	
}
