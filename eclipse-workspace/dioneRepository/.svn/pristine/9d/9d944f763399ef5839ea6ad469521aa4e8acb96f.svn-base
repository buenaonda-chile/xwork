/*
 * Project : NEW DIONE PROJECT
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller.mrp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.presentation.filter.SiteMinderFilter;
import com.globaldenso.dnkr.presentation.form.basic.WAN001DioneViewForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 구 디오네 변환 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAN001MiPlatform")
@ViewId(value = "WAN001")
public class WAN001MiPlatformController {

	/**
	 * [EN] Default constructor.<br>
	 * [JP] デフォルトコンストラクタ。<br>
	 */
	public WAN001MiPlatformController() {
		// no process
	}

	/**
	 * 구디오네 변환 Viewing 로직 <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAN001MiPlatform
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/view", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView dioneEmbedde(HttpServletRequest request,
			@ModelAttribute("WAN001DioneViewForm") WAN001DioneViewForm form) throws Exception {

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
		
		//마이플렛폼 기본컨텐츠와 팝업컨텐츠 분계 - 2019.05.08 JHB
		String mode = ServletRequestUtils.getStringParameter(request, "mode");
		//System.out.println("controllModeType"+tabId+menu+mode);
		

		ModelAndView mv = new ModelAndView();

		EmpDomain thisEmpInfo = (EmpDomain) request.getSession().getAttribute("EMP_DOMAIN");
		
		// 세션 저장된 데이터 불러오기
		//EmpDb2Domain empInfo = (EmpDb2Domain) request.getSession().getAttribute("ACCOUNT_DB2");

		String gSessionIdValue = ""; // ex) PARAMETER = ::E110290::PS::C1::PSRESLIB::PSCDBLIB::PSCDBLIB::CLTDTAE
		
		String displayFlag = "none";
		
		
		//임시 대응 김석균 팀장님	 20190121 	
		if(form.getCompany() != null) {
			if(form.getCompany().length() > 2) {
				form.setCompany(form.getCompany().substring(0, 2));
			}
		}
		 
		// 구DNKA
		if("CLS000001".endsWith(thisEmpInfo.getClsCode())) {
			
			if(form.getCompany().equals("KE")) {
				gSessionIdValue = convertSeparator(thisEmpInfo.getEmpId(), DnkrConstans.COMPS_DNKE, DnkrConstans.COMPS_MASAN,
						DnkrConstans.DNKE_LIB1, DnkrConstans.DNKE_LIB2, DnkrConstans.DNKE_LIB3, DnkrConstans.DNKA_LIB4);
				
			} else if(form.getCompany().equals("KA")) {
				
				if("LOC000001".equals(thisEmpInfo.getLocCode())) {
					gSessionIdValue = convertSeparator(thisEmpInfo.getEmpId(), DnkrConstans.COMPS_DNKA,
							DnkrConstans.COMPS_CHANGWON, DnkrConstans.DNKA_LIB1, DnkrConstans.DNKA_LIB2,
							DnkrConstans.DNKA_LIB3_C, DnkrConstans.DNKA_LIB4);
					
					// select box 초기 셋팅
					form.setLocCode("C");
					
				} else if("LOC000002".equals(thisEmpInfo.getLocCode())) { //홍성 공장
					gSessionIdValue = convertSeparator(thisEmpInfo.getEmpId(), DnkrConstans.COMPS_DNKA,
							DnkrConstans.COMPS_HONGSUNG, DnkrConstans.DNKA_LIB1, DnkrConstans.DNKA_LIB2,
							DnkrConstans.DNKA_LIB3_H, DnkrConstans.DNKA_LIB4);
					
					// select box 초기 셋팅
					form.setLocCode("H");
					
				} else if("LOC000003".equals(thisEmpInfo.getLocCode())) { // 공장
					gSessionIdValue = convertSeparator(thisEmpInfo.getEmpId(), DnkrConstans.COMPS_DNKA,
							DnkrConstans.COMPS_HWASUNG, DnkrConstans.DNKA_LIB1, DnkrConstans.DNKA_LIB2,
							DnkrConstans.DNKA_LIB3_S, DnkrConstans.DNKA_LIB4);		

					// select box 초기 셋팅
					form.setLocCode("S");
				}
			}
						
		// 구 DNKE	
		} else if("CLS000002".endsWith(thisEmpInfo.getClsCode())) {
			
			if(form.getCompany().equals("KE")) {
				gSessionIdValue = convertSeparator(thisEmpInfo.getEmpId(), DnkrConstans.COMPS_DNKE, DnkrConstans.COMPS_MASAN,
						DnkrConstans.DNKE_LIB1, DnkrConstans.DNKE_LIB2, DnkrConstans.DNKE_LIB3, DnkrConstans.DNKA_LIB4);
				
			} else if(form.getCompany().equals("KA")) {
				
				// 화성공장 선택의 경우	
				if("S".equals(form.getLocCode())) {

					gSessionIdValue = convertSeparator(thisEmpInfo.getEmpId(), DnkrConstans.COMPS_DNKA,
							DnkrConstans.COMPS_HWASUNG, DnkrConstans.DNKA_LIB1, DnkrConstans.DNKA_LIB2,
							DnkrConstans.DNKA_LIB3_S, DnkrConstans.DNKA_LIB4);	

				// 홍성공장 선택의 경우	
				} else if("H".equals(form.getLocCode())) {
					
					gSessionIdValue = convertSeparator(thisEmpInfo.getEmpId(), DnkrConstans.COMPS_DNKA,
							DnkrConstans.COMPS_HONGSUNG, DnkrConstans.DNKA_LIB1, DnkrConstans.DNKA_LIB2,
							DnkrConstans.DNKA_LIB3_H, DnkrConstans.DNKA_LIB4);
					
				// 창원공장 선택 or 초기의 진입의 경우 (default = "value null"
				} else {
					
						gSessionIdValue = convertSeparator(thisEmpInfo.getEmpId(), DnkrConstans.COMPS_DNKA,
								DnkrConstans.COMPS_CHANGWON, DnkrConstans.DNKA_LIB1, DnkrConstans.DNKA_LIB2,
								DnkrConstans.DNKA_LIB3_C, DnkrConstans.DNKA_LIB4);
						// select box 초기 셋팅
						form.setLocCode("C");
				}
				
				// KE 마산 사람이 KA 프로그램 사용할 경우
				//displayFlag = "display";
			}
			
		}
		

		//mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		/*
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		mv.addObject("paraDomain", form);
		mv.addObject("displayFlag", displayFlag);
		mv.addObject("gSessionIdValue", gSessionIdValue);
		mv.addObject("url", "WAN001DioneView.jsp");
		mv.setViewName(".tiles.page.WAN001DioneView");
		*/
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		mv.addObject("paraDomain", form);
		mv.addObject("displayFlag", displayFlag);
		mv.addObject("gSessionIdValue", gSessionIdValue);
		mv.addObject("mode", mode);
		
		if("MI".equals(mode)){
			mv.addObject("url", "WAN001DioneView.jsp");
			mv.setViewName(".tiles.page.WAN001DioneView");
		}else{
			mv.addObject("url", "WAN004DioneView.jsp");
			mv.setViewName(".tiles.page.WAN004DioneView");
		}
		return mv;
	}

	/**
	 * DIONE 파라미터의 형식을 만들어주는 역활
	 * 
	 * @param args
	 * @return
	 */
	private String convertSeparator(String... args) {
		String result = "";
		for (int i = 0; i < args.length; i++) {
			result += "::" + args[i];
		}
		return result;
	}

}
