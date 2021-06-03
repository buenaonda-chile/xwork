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
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.db2.ManagementInfomationService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.WorkSortDomain;
import com.globaldenso.dnkr.domain.db2.AccountingJournalDomain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE039AccountingJournalForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 월적상 CheckList 조회 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE039AccountingJournalSearch")
@ViewId(value = "WAE039")
public class WAE039AccountingJournalController {

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
	public WAE039AccountingJournalController() {
		// no process
	}

	/**
	 * 월적상 CheckList 초기화면[KR] <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE019MaterialInventoryForm
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initAccountingJournal(HttpServletRequest request,
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
		
		//계정과목
		CodeDb2Domain codeF0901Domain = new CodeDb2Domain();
		codeF0901Domain.setLib4("CLTDTA");	//통합JDE라이브러리
		List<CodeDb2Domain> codeF0901List = null;
		try {
			codeF0901List = codeService.comCodeJdeF0901(codeF0901Domain);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}		

		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		mv.addObject("paraDomain", form);
		mv.addObject("codeF0901List", codeF0901List);
		mv.addObject("url", "WAE039AccountingJournal.jsp");
		mv.setViewName(".tiles.page.WAE039AccountingJournal");
		return mv;
	}

	/**
	 * 월적상 CheckList 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE035MonthlyShipmentCheckListForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView accountingJournalsSearch(HttpServletRequest request,
			@ModelAttribute("/WAE039AccountingJournalForm") WAE039AccountingJournalForm form)
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
		String rltmsg = "NG";

		// 라이브러리 comps 셋팅
		//UxisCmmUtil.getCompsLib(form);		
		//System.out.println(form.getLocCode()+"=="+form.getpStartDate()+"=="+form.getpEndDate()+"=="+form.getpGlobj());
		String locCode = form.getLocCode();
		if("LOC000001".equals(locCode)){	//구KA환경
			form.setLib4("CLTDTAS");
		}else if("LOC000004".equals(locCode)){	//구KE환경
			form.setLib4("CLTDTAE");
		}else if("LOC000000".equals(locCode)){	//통합JDE라이브러리
			form.setLib4("CLTDTA");
		}
						
		int count = 0;
		try {
            count = mifService.searchByAccountingJournalCnt(form);
			//System.out.println(count);
        } catch (Exception e) {
            System.out.println("조회할 데이터가 없습니다.");
        }
		
		List<AccountingJournalDomain> accountingJournalList = null;
		// -XX:MaxPermSize=512M -Xms1024m -Xmx1024m 추가시 56000건 가능
		// 56000건 가능 196932 오류발생 176376 오류발생  154711 오류발생  146469 오류발생 146206,135107 까지가능함. 
		if(count < 65000){ //135000 // -XX:MaxPermSize=512M -Xms1024m -Xmx1024m 추가시 135000건 가능하지만 ax5의 엑셀은 65000 row만 가능함.
			try {
				accountingJournalList = mifService.searchByAccountingJournal(form);
				//System.out.println(accountingJournalList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (accountingJournalList != null) {
				rltmsg = "OK";
				result = DnkrConstans.RESULT_Y;
				jsonObj.put("list", accountingJournalList);
			}
		}

		jsonObj.put("rltmsg", rltmsg);
		jsonObj.put("rltCnt", count);
		jsonObj.put("result", result);
		model.addObject("jsonString", jsonObj.toString());
		return model;
	}

	@RequestMapping(value = "/ajaxCodeSearch", method = {RequestMethod.POST, RequestMethod.GET})
	@Token(save = true)
	public void ajaxCodeSearch(HttpServletRequest request, HttpServletResponse response) throws Exception{
		/**
         * [KO] 업무분류 조회.<br>
         * [EN] <br>
         * [JP] <br>
         * 
         * @throws Exception Exception
         */

        //System.out.println("ajaxWorkSort/init.do");


        JSONObject jsonObj = new JSONObject();
		String result = DnkrConstans.RESULT_N;
		
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");
		//System.out.println(locCode);

		CodeDb2Domain criteria = new CodeDb2Domain();
		if("LOC000001".equals(locCode)){	//구KA환경
			criteria.setLib4("CLTDTAS");
		}else if("LOC000004".equals(locCode)){	//구KE환경
			criteria.setLib4("CLTDTAE");
		}else if("LOC000000".equals(locCode)){	//통합JDE라이브러리
			criteria.setLib4("CLTDTA");
		}
		List<CodeDb2Domain> codeF0901List = null;
		try {
			codeF0901List = codeService.comCodeJdeF0901(criteria);
			//System.out.println(codeF0901List);
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}			
		if (codeF0901List != null) {
			result = DnkrConstans.RESULT_Y;
			//jsonObj.put("result", result);
			jsonObj.put("list", codeF0901List);
		}
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
}
