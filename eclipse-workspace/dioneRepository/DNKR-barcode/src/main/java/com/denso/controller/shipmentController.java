package com.denso.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.denso.common.util.DataConverter;
import com.denso.common.util.MiPlatformView;
import com.denso.service.intf.ShipmentService;
import com.tobesoft.platform.PlatformRequest;

@Controller
@RequestMapping(value="/shipment")//대소문자 구분함
public class shipmentController {
	
	@Autowired
	ShipmentService shipmentService;

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  출하진척시스템: GATE마스타
	 * @see
	 * 	- 2015-08-13	:	JAB
	***********************************************************************/
	@RequestMapping(value="/getFSAZ100List", method=RequestMethod.POST)
	public void getFSAZ100List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSAZ100List = shipmentService.getFSAZ100List(pData);

		map.addAttribute("ds_FSAZ100", fSAZ100List);
		new MiPlatformView().render(map, request, response);
	}
	
	@RequestMapping(value="/setFSAZ100List", method=RequestMethod.POST)
	@Transactional
	public void setFSAZ100List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_FSAZ100");
		List<HashMap<String, String>> errList =null;
		errList = shipmentService.setFSAZ100List(pArg, pList);
		
		map.addAttribute("ds_FSAZ100_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  출하진척시스템: 행선지마스타
	 * @see
	 * 	- 2015-08-13	:	JAB
	***********************************************************************/
	@RequestMapping(value="/getFSAZ110List", method=RequestMethod.POST)
	public void getFSAZ110List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSAZ110List = shipmentService.getFSAZ110List(pData);

		map.addAttribute("ds_FSAZ110", fSAZ110List);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setFSAZ110List", method=RequestMethod.POST)
	@Transactional
	public void setFSAZ110List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_FSAZ110");
		List<HashMap<String, String>> errList =null;
		errList = shipmentService.setFSAZ110List(pArg, pList);
		
		map.addAttribute("ds_FSAZ110_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  출하진척시스템: 차량마스타
	 * @see
	 * 	- 2015-08-13	:	JAB
	***********************************************************************/
	@RequestMapping(value="/getFSAZ120List", method=RequestMethod.POST)
	public void getFSAZ120List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSAZ120List = shipmentService.getFSAZ120List(pData);

		map.addAttribute("ds_FSAZ120", fSAZ120List);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setFSAZ120List", method=RequestMethod.POST)
	@Transactional
	public void setFSAZ120List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_FSAZ120");
		List<HashMap<String, String>> errList =null;
		errList = shipmentService.setFSAZ120List(pArg, pList);
		
		map.addAttribute("ds_FSAZ120_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  출하진척시스템: 트럭운영계획관리
	 * @see
	 * 	- 2015-08-13	:	JAB
	***********************************************************************/
	@RequestMapping(value="/getFSAZ130List", method=RequestMethod.POST)
	public void getFSAZ130List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSAZ130List = shipmentService.getFSAZ130List(pData);

		map.addAttribute("ds_FSAZ130", fSAZ130List);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/getFSAZ130ListAll", method=RequestMethod.POST)
	public void getFSAZ130ListAll(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSAZ130ListAll = shipmentService.getFSAZ130ListAll(pData);

		map.addAttribute("ds_FSAZ130_ALL", fSAZ130ListAll);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setFSAZ130List/{type}", method = {RequestMethod.GET, RequestMethod.POST})
	@Transactional
	public void setFSAZ130List(@PathVariable String type, HttpServletRequest request,HttpServletResponse response, ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		//List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_FSAZ130");
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_FSAZ130_Cal");
		List<HashMap<String, String>> errList =null;
		//errList = shipmentService.setFSAZ130List(pArg, pList);
		System.out.println(type);
		if ("new".equals(type)) {	//신규data생성
			errList = shipmentService.setFSAZ130List(pArg, pList);
		} else if ("update".equals(type)) {	//data update
			errList = shipmentService.setFSAZ130List2(pArg, pList);
		}
		map.addAttribute("ds_FSAZ130_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  출하진척시스템: 트럭상차입력관리
	 * @see
	 * 	- 2015-08-18	:	JAB
	***********************************************************************/
	@RequestMapping(value="/getFSAZ140List", method=RequestMethod.POST)
	public void getFSAZ140List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSAZ140List = shipmentService.getFSAZ140List(pData);

		map.addAttribute("ds_FSAZ140", fSAZ140List);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setFSAZ140List", method=RequestMethod.POST)
	@Transactional
	public void setFSAZ140List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_FSAZ140_Cal");
		List<HashMap<String, String>> errList =null;
		errList = shipmentService.setFSAZ140List(pArg, pList);
		
		map.addAttribute("ds_FSAZ140_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  출하진척시스템: 출하지시정의
	 * @see
	 * 	- 2015-11-23	:	JAB
	***********************************************************************/
	@RequestMapping(value="/getFSAZ150List", method=RequestMethod.POST)
	public void getFSAZ150List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSAZ150List = shipmentService.getFSAZ150List(pData);

		map.addAttribute("ds_FSAZ150", fSAZ150List);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setFSAZ150List", method=RequestMethod.POST)
	@Transactional
	public void setFSAZ150List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_FSAZ150");
		List<HashMap<String, String>> errList =null;
		errList = shipmentService.setFSAZ150List(pArg, pList);
		
		map.addAttribute("ds_FSAZ150_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/getFSAZ150ListView", method=RequestMethod.POST)
	public void getFSAZ150ListView(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSAZ150ListView = shipmentService.getFSAZ150ListView(pData);

		map.addAttribute("ds_FSAZ150View", fSAZ150ListView);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  출하진척시스템: 이동지시정의
	 * @see
	 * 	- 2016-09-05	:	lsk
	***********************************************************************/
	@RequestMapping(value="/getFSAZ151List", method=RequestMethod.POST)
	public void getFSAZ151List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSAZ150List = shipmentService.getFSAZ151List(pData);

		map.addAttribute("ds_FSAZ151", fSAZ150List);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setFSAZ151List", method=RequestMethod.POST)
	@Transactional
	public void setFSAZ151List(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_FSAZ151");
		List<HashMap<String, String>> errList =null;
		errList = shipmentService.setFSAZ150List(pArg, pList);  //출하지시정의와 동일
		
		map.addAttribute("ds_FSAZ151_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  출하진척시스템: 트럭진척현황
	 * @see
	 * 	- 2015-12-03	:	JAB
	***********************************************************************/
	@RequestMapping(value="/getFSAZ160QList", method=RequestMethod.POST)
	public void getFSAZ160QList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSAZ160QList = shipmentService.getFSAZ160QList(pData);

		map.addAttribute("ds_FSAZ160Q", fSAZ160QList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/getFSAZ160Q_PList", method=RequestMethod.POST)
	public void getFSAZ160Q_PList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSAZ160Q_pList = shipmentService.getFSAZ160Q_PList(pData);

		map.addAttribute("ds_FSAZ160Q_P", fSAZ160Q_pList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  출하진척시스템: 재고현황
	 * @see
	 * 	- 2015-11-23	:	JAB
	***********************************************************************/
	@RequestMapping(value="/getFSAZ170QList", method=RequestMethod.POST)
	public void getFSAZ170QList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSAZ170QList = shipmentService.getFSAZ170QList(pData);

		map.addAttribute("ds_FSAZ170Q", fSAZ170QList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/getSC008PR", method=RequestMethod.POST)
	public void getSC008PR(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> sC008PRList = shipmentService.getSC008PRList(pData);

		map.addAttribute("ds_SC008PR", sC008PRList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  출하진척시스템: 출하지시정의조회
	 * @see
	 * 	- 2016-03-22	:	JHB
	***********************************************************************/
	@RequestMapping(value="/getFSAZ180QList", method=RequestMethod.POST)
	public void getFSAZ180QList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSAZ180QList = shipmentService.getFSAZ180QList(pData);

		map.addAttribute("ds_FSAZ180Q", fSAZ180QList);
		new MiPlatformView().render(map, request, response);
	}
}