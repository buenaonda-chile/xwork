package com.denso.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.denso.common.util.DataConverter;
import com.denso.common.util.MiPlatformView;
import com.denso.service.intf.BudgetService;
import com.tobesoft.platform.PlatformRequest;

@Controller
@RequestMapping(value="/budget")//대소문자 구분함
public class BudgetController {
	
	@Autowired
	BudgetService budgetService;

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 공통사용
	 * @see
	 * 	- 2016-06-24	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getMIZZXXXList", method=RequestMethod.POST)
	public void getMIZZXXXList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZZXXXList = budgetService.getMIZZXXXList(pData);

		map.addAttribute("ds_MIZZXXX", mIZZXXXList);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 부서코드 공통사용
	 * @see
	 * 	- 2016-06-24	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getMST650PFList", method=RequestMethod.POST)
	public void getMST650PFList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mst650List = budgetService.getMST650PFList(pData);

		map.addAttribute("ds_MST650PF", mst650List);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 경비예산항목Master
	 * @see
	 * 	- 2016-06-24	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getCategoryList", method=RequestMethod.POST)
	public void getCategoryList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> categoryList = budgetService.getCategoryList(pData);

		map.addAttribute("ds_Category", categoryList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/getMIZZ220List", method=RequestMethod.POST)
	public void getMIZZ220List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZZ220List = budgetService.getMIZZ220List(pData);

		map.addAttribute("ds_MIZZ220", mIZZ220List);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setMIZZ220List", method=RequestMethod.POST)
	@Transactional
	public void setMIZZ220List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MIZZ220");
		List<HashMap<String, String>> errList =null;
		errList = budgetService.setMIZZ220List(pArg, pList);
		
		map.addAttribute("ds_MIZZ220_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 업체Master등록
	 * @see
	 * 	- 2016-06-24	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getMIZZ221List", method=RequestMethod.POST)
	public void getMIZZ221List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZZ221List = budgetService.getMIZZ221List(pData);

		map.addAttribute("ds_MIZZ221", mIZZ221List);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setMIZZ221List", method=RequestMethod.POST)
	@Transactional
	public void setMIZZ221List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MIZZ221");
		List<HashMap<String, String>> errList =null;
		errList = budgetService.setMIZZ221List(pArg, pList);
		
		map.addAttribute("ds_MIZZ221_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 계정Master등록
	 * @see
	 * 	- 2016-06-24	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getMIZZ222List", method=RequestMethod.POST)
	public void getMIZZ222List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> MIZZ222List = budgetService.getMIZZ222List(pData);

		map.addAttribute("ds_MIZZ222", MIZZ222List);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setMIZZ222List", method=RequestMethod.POST)
	@Transactional
	public void setMIZZ222List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MIZZ222");
		List<HashMap<String, String>> errList =null;
		errList = budgetService.setMIZZ222List(pArg, pList);
		
		map.addAttribute("ds_MIZZ222_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/getMIZZ222_KYList", method=RequestMethod.POST)
	public void getMIZZ222_KYList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> MIZZ222_KYList = budgetService.getMIZZ222_KYList(pData);

		map.addAttribute("ds_MIZZ222_KY", MIZZ222_KYList);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 경비예산 확정여부 조회 (공통 pgm)
	 * @see
	 * 	- 2016-06-24	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getMIZZ230List", method=RequestMethod.POST)
	public void getMIZZ230List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZZ230List = budgetService.getMIZZ230List(pData);

		map.addAttribute("ds_MIZ230", mIZZ230List);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 경비예산 항목생성
	 * @see
	 * 	- 2016-06-24	:	LSK
	***********************************************************************/
	@RequestMapping(value="/setMIZZ229UCList", method=RequestMethod.POST)
	@Transactional
	public void setMIZZ229UCList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_SEND");
		List<HashMap<String, String>> errList =null;
		errList = budgetService.setMIZZ229UCList(pArg, pList);
		
		map.addAttribute("ds_MIZZ229UC_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 경비예산 HOST UP
	 * @see
	 * 	- 2016-06-24	:	LSK
	***********************************************************************/
	@RequestMapping(value="/setMIZZ229UPList", method=RequestMethod.POST)
	@Transactional
	public void setMIZZ229UPList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_SEND");
		List<HashMap<String, String>> errList =null;
		errList = budgetService.setMIZZ229UPList(pArg, pList);
		
		map.addAttribute("ds_MIZZ229UP_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 경비예산TX 등록
	 * @see
	 * 	- 2016-06-24	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getMIZZ229List", method=RequestMethod.POST)
	public void getMIZZ229List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZZ229List = budgetService.getMIZZ229List(pData);

		map.addAttribute("ds_MIZZ229", mIZZ229List);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setMIZZ229List", method=RequestMethod.POST)
	@Transactional
	public void setMIZZ229List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MIZZ229");
		List<HashMap<String, String>> errList =null;
		errList = budgetService.setMIZZ229List(pArg, pList);
		
		map.addAttribute("ds_MIZZ229_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 기초예산 목표수립
	 * @see
	 * 	- 2016-06-24	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getMIZZ229UList", method=RequestMethod.POST)
	public void getMIZZ229UList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZZ229UList = budgetService.getMIZZ229UList(pData);

		map.addAttribute("ds_MIZZ229U", mIZZ229UList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setMIZZ229UList", method=RequestMethod.POST)
	@Transactional
	public void setMIZZ229UList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MIZZ229U");
		List<HashMap<String, String>> errList =null;
		errList = budgetService.setMIZZ229UList(pArg, pList);
		
		map.addAttribute("ds_MIZZ229U_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 경비확정
	 * @see
	 * 	- 2016-06-24	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getMIZZ229CList", method=RequestMethod.POST)
	public void getMIZZ229CList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZZ229CList = budgetService.getMIZZ229CList(pData);

		map.addAttribute("ds_MIZZ229C", mIZZ229CList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setMIZZ229CList", method=RequestMethod.POST)
	@Transactional
	public void setMIZZ229CList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MIZZ229C");
		List<HashMap<String, String>> errList =null;
		errList = budgetService.setMIZZ229CList(pArg, pList);
		
		map.addAttribute("ds_MIZZ229C_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 경비예산 실적 등록
	 * @see
	 * 	- 2016-06-24	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getMIZZ239List", method=RequestMethod.POST)
	public void getMIZZ239List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZZ239List = budgetService.getMIZZ239List(pData);

		map.addAttribute("ds_MIZZ239", mIZZ239List);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setMIZZ239List", method=RequestMethod.POST)
	@Transactional
	public void setMIZZ239List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MIZZ239");
		List<HashMap<String, String>> errList =null;
		errList = budgetService.setMIZZ239List(pArg, pList);
		
		map.addAttribute("ds_MIZZ239_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/getMIZZ239_occList", method=RequestMethod.POST)
	public void getMIZZ239_occList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZZ239_occList = budgetService.getMIZZ239_occList(pData);

		map.addAttribute("ds_MIZZ239_occ", mIZZ239_occList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 경비예산TX 증감현황
	 * @see
	 * 	- 2016-08-19	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getMIZZ229Q1List", method=RequestMethod.POST)
	public void getMIZZ229Q1List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZZ229Q1List = budgetService.getMIZZ229Q1List(pData);

		map.addAttribute("ds_MIZZ229Q1", mIZZ229Q1List);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 경비예산TX 상세조회
	 * @see
	 * 	- 2016-08-19	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getMIZZ229Q2List", method=RequestMethod.POST)
	public void getMIZZ229Q2List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZZ229Q2List = budgetService.getMIZZ229Q2List(pData);

		map.addAttribute("ds_MIZZ229Q2", mIZZ229Q2List);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 경비예산확정 증감현황
	 * @see
	 * 	- 2016-08-19	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getMIZZ239Q1List", method=RequestMethod.POST)
	public void getMIZZ239Q1List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZZ239Q1List = budgetService.getMIZZ239Q1List(pData);

		map.addAttribute("ds_MIZZ239Q1", mIZZ239Q1List);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  경비예산관리System: 경비예산확정 상세조회
	 * @see
	 * 	- 2016-08-19	:	LSK
	***********************************************************************/
	@RequestMapping(value="/getMIZZ239Q2List", method=RequestMethod.POST)
	public void getMIZZ239Q2List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZZ239Q2List = budgetService.getMIZZ239Q2List(pData);

		map.addAttribute("ds_MIZZ239Q2", mIZZ239Q2List);
		new MiPlatformView().render(map, request, response);
	}
}