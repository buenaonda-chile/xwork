package com.denso.psimmlib;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.denso.common.converter.DataConverter;
import com.denso.common.converter.MiPlatformView;
import com.denso.common.dao.CommonDAO;
import com.denso.model.BJIZ100C;
import com.denso.model.BJIZ110C;
import com.denso.model.BJOZ110C;
import com.tobesoft.platform.PlatformRequest;

public class PsimmlibController extends MultiActionController {
	
	CommonDAO dao = CommonDAO.getInstance(1);	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	- request로 입력받은 데이터셋명을 파리미터에 따라 변경하여 데이터셋명을 리턴한다.
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectBHZE204CP(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE204CP", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE204CP", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectBHZE204CPD(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE204CPD", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE204CPD", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectBHZE206CP(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE206CP", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE206CP", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectBHZE206CPD(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE206CPD", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE206CPD", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectBHZE208Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE208Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE208Q", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectBHZE210CP(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE210CP", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE210CP", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBHZE210CPD(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE210CPD", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE210CPD", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBHZZ208Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZZ208Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZZ208Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBZZ501CP(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZZ501CP", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZZ501CP", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBZZ501CPD(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZZ501CPD", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZZ501CPD", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBZZ501CPD1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZZ501CPD1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZZ501CPD1", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBHZC101Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZC101Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZC101Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBHZC101Q1(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZC101Q1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZC101Q", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectBHZC102Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZC102Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZC102Q", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectBHZC201Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZC201Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZC201Q", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectBHZC203Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZC203Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZC203Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBHZC301Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZC301Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZC301Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBJMZ111Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJMZ111Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJMZ111Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBJMZ111QD(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJMZ111QD", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJMZ111QD", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectBJMZ101Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJMZ101Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJMZ101Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBJMZ102Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJMZ102Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJMZ102Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBJMZ103CP(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJMZ103CP", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJMZ103CP", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBJMZ011Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJMZ011Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJMZ011Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBJMZ051Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJMZ051Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJMZ051Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBIDZ500(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDZ500", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDZ500", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectBIDZ501(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDZ501", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDZ501", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectBSME153Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBSME153Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BSME153Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBUYZ150Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBUYZ150Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BUYZ150Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/* lee sang keon 자재관리 작업  Start -----------------------------------------------------------------------------------------*/
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  외주품 단가마스타 현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	lsk
	***********************************************************************/ 
	public void selectBUYZ103Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBUYZ103Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BUYZ103Q", list);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  외주품 단가 배분율 현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	lsk
	***********************************************************************/ 
	public void selectBUYZ105Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBUYZ105Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BUYZ105Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  유상사급 단가마스타현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBUYZ106Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBUYZ106Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BUYZ106Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  무상사급 단가마스타현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBUYZ107Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBUYZ107Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BUYZ107Q", list);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  사급 모품번구성 마스타현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBSME154Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBSME154Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BSME154Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  국내품사입내역서(마감전)
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDZ211Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String queryGUB = (String) pData.get("QGUB");
		List list = new ArrayList();
		if(queryGUB.equals("1")){
			list = dao.getListData("psimmlib.selectBIDZ211Q_DETAIL", pData);
		}
		if(queryGUB.equals("2")){
			list = dao.getListData("psimmlib.selectBIDZ211Q_SUMMARY", pData);
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDZ211Q", list);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  국내품사입내역서(마감후)
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDZ212Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String queryGUB = (String) pData.get("QGUB");
		List list = new ArrayList();
		if(queryGUB.equals("1")){
			list = dao.getListData("psimmlib.selectBIDZ212Q_DETAIL", pData);
		}
		if(queryGUB.equals("2")){
			list = dao.getListData("psimmlib.selectBIDZ212Q_SUMMARY", pData);
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDZ212Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  현조수입품사입내역서(마감전)
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDZ251Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String queryGUB = (String) pData.get("QGUB");
		List list = new ArrayList();
		if(queryGUB.equals("1")){
			list = dao.getListData("psimmlib.selectBIDZ251Q_DETAIL", pData);
		}
		if(queryGUB.equals("2")){
			list = dao.getListData("psimmlib.selectBIDZ251Q_SUMMARY", pData);
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDZ251Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  현조수입품사입내역서(마감후)
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDZ252Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String queryGUB = (String) pData.get("QGUB");
		List list = new ArrayList();
		if(queryGUB.equals("1")){
			list = dao.getListData("psimmlib.selectBIDZ252Q_DETAIL", pData);
		}
		if(queryGUB.equals("2")){
			list = dao.getListData("psimmlib.selectBIDZ252Q_SUMMARY", pData);
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDZ252Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  담당자별 일일부품입고현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDE111Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDE111Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDE111Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  가단가 집행분 소급 예상금액현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDZ217Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDZ217Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDZ217Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  국내품사입내역서(단가차이)
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDZ215Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String queryGUB = (String) pData.get("QGUB");
		List list = new ArrayList();
		if(queryGUB.equals("1")){
			list = dao.getListData("psimmlib.selectBIDZ215Q_DETAIL", pData);
		}
		if(queryGUB.equals("2")){
			list = dao.getListData("psimmlib.selectBIDZ215Q_SUMMARY", pData);
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDZ215Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  년 업체별 사입마감금액 현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDZ301Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDZ301Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDZ301Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 국내품사입 단가소급TX등록
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDC210(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDC210", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDC210", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectBIDC210_DCHK(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDC210_Check", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDC210_DCHK", list);
		new MiPlatformView().render(map, request, response);
	}
	public void insertBIDC210(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BIDC210");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String empty1="";

		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			empty1 = (String) pData.get("SGBPN");
			
			rowType = (String) pData.get("ROW_TYPE");
			
			System.out.println(rowType + "--->" + (String) pData.get("SGBPN") + "-----" + empty1);
			if (empty1 != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBIDC210_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("SGBPN", pData.get("SGBPN"));
							errMap.put("SGBJP", pData.get("SGBJP"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psimmlib.deleteBIDC210", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			empty1 = (String) pData.get("SGBPN");
			rowType = (String) pData.get("ROW_TYPE");
			if (empty1 != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBIDC210_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(이미등록된 자료)
							HashMap errMap = new HashMap();
							errMap.put("SGBPN", pData.get("SGBPN"));
							errMap.put("SGBJP", pData.get("SGBJP"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							//전표저장
							dao.insertData("psimmlib.insertBIDC210", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBIDC210_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("SGBPN", pData.get("SGBPN"));
							errMap.put("SGBJP", pData.get("SGBJP"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psimmlib.updateBIDC210", pData);
						}
					}
				}
			}
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_BIDC210_CHECK", errList);//추가
		//new MiPlatformView().render(null, request, response);
		new MiPlatformView().render(map, request, response);	
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 단가소급처리 품번등록
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDC251(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDC251", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDC251", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectBIDC251_DCHK(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDC251_Check", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDC251_DCHK", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectBIDC251_BID100(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDC251_BID100", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDC251_BID100", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveBIDC251(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BIDC251");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String empty1="";

		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("ADDID", (String)pArg.get("ADDID"));
			empty1 = (String) pData.get("SGPNO");
			
			rowType = (String) pData.get("ROW_TYPE");
			
			System.out.println(rowType + "--->" + (String) pData.get("SGBPN") + "-----" + empty1);
			if (empty1 != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBIDC251_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("SGPNO", pData.get("SGPNO"));
							errMap.put("SGJNO", pData.get("SGJNO"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psimmlib.deleteBIDC251", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("ADDID", (String)pArg.get("ADDID"));
			empty1 = (String) pData.get("SGPNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (empty1 != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBIDC251_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(이미등록된 자료)
							HashMap errMap = new HashMap();
							errMap.put("SGPNO", pData.get("SGPNO"));
							errMap.put("SGJNO", pData.get("SGJNO"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							//전표저장
							dao.insertData("psimmlib.insertBIDC251", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBIDC251_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("SGPNO", pData.get("SGPNO"));
							errMap.put("SGJNO", pData.get("SGJNO"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psimmlib.updateBIDC251", pData);
						}
					}
				}
			}
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_BIDC251_CHECK", errList);//추가
		//new MiPlatformView().render(null, request, response);
		new MiPlatformView().render(map, request, response);	
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 국내품사입 단가소급TX CHECK LIST
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDC221Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDC221Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDC221Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 국내품사입 단가소급 가마감 작업 (data존재유무check)
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDC259C(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDC259C", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDC259C", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 국내품사입 단가소급 마감 작업 (data존재유무check)
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDC250C(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDC250C", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDC250C", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 단가소급 가마감 현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDC257Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDC257Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDC257Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 단가소급 마감 현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDC252Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDC252Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDC252Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  일일부품입고현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBIDC111Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBIDC111Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BIDC111Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  협력업체 발주현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBODE401Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBODE401Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BODE401Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  채산개선 품목마스타 조회
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBICE101Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBICE101Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BICE101Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  채산인상 품목마스타 조회
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBICE201Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBICE201Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BICE201Q", list);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  가단가리스트 조회
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBHZC111Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZC111Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZC111Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  월분류별 집행ITEM및업체수 생성
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void saveBZZE220C(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.startTransaction(); //tr 시작
		dao.deleteData("psimmlib.deleteBZZE220C", pArg);
		dao.insertData("psimmlib.insertBZZE220C", pArg);
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  유무상사급출고현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBODZ107Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBODZ107Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BODZ107Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  일일사급품생산실적현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBSME250Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBSME250Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BSME250Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  유무상사급출고현황_분류별
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBODZ108Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBODZ108Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BODZ108Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  무상사급입고현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBSME159Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBSME159Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BSME159Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  무상사급입고현황_상세
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBSME159QD(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBSME159QD", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BSME159QD", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  무상사급 재고현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBSME155Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBSME155Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BSME155Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  무상사급 재고조사 리스트
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBSME158R(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBSME158R", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BSME158R", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  무상사급 정산서
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBSME205R(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBSME205R", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BSME205R", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  유상사급출고마감내역서
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBODZ203Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String queryGUB = (String) pData.get("QGUB");
		List list = new ArrayList();
		if(queryGUB.equals("1")){
			list = dao.getListData("psimmlib.selectBODZ203Q_DETAIL", pData);
		}
		if(queryGUB.equals("2")){
			list = dao.getListData("psimmlib.selectBODZ203Q_SUMMARY", pData);
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BODZ203Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  유상사급출고마감_단가차이
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBODZ204Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String queryGUB = (String) pData.get("QGUB");
		List list = new ArrayList();
		if(queryGUB.equals("1")){
			list = dao.getListData("psimmlib.selectBODZ204Q_DETAIL", pData);
		}
		if(queryGUB.equals("2")){
			list = dao.getListData("psimmlib.selectBODZ204Q_SUMMARY", pData);
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BODZ204Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  유상사급출고 마감전 내역서
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBODZ207Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String queryGUB = (String) pData.get("QGUB");
		List list = new ArrayList();
		if(queryGUB.equals("1")){
			list = dao.getListData("psimmlib.selectBODZ207Q_DETAIL", pData);
		}
		if(queryGUB.equals("2")){
			list = dao.getListData("psimmlib.selectBODZ207Q_SUMMARY", pData);
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BODZ207Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  년 업체별 사급마감금액 현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBODZ301Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = new ArrayList();
		list = dao.getListData("psimmlib.selectBODZ301Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BODZ301Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  년월 품목별 입출고 조회
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBHZZ508Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = new ArrayList();
		list = dao.getListData("psimmlib.selectBHZZ508Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZZ508Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  월 무상사급 수불현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBHZZ501Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = new ArrayList();
		list = dao.getListData("psimmlib.selectBHZZ501Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZZ501Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  월 유상사급 수불현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBUUZ122Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = new ArrayList();
		list = dao.getListData("psimmlib.selectBUUZ122Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BUUZ122Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  월 자재 수불현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBHZZ101Q(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		List list = new ArrayList();
		
		String prtnoGubun = (String)pArg.get("CLSGU");
		System.out.println(prtnoGubun);
		String priceGubun = (String)pArg.get("PRCGUB");
		System.out.println(priceGubun);
		// 단가생성 --------------------------------------------------------
		String dangaSelectGUB = "" ;
		if (prtnoGubun.equals("1") && priceGubun.equals("1")){
			dangaSelectGUB ="M_PRICE";
		}else if (prtnoGubun.equals("1") && priceGubun.equals("2")){
			dangaSelectGUB ="S_PRICE";
		}else if (prtnoGubun.equals("1") && priceGubun.equals("3")){
			dangaSelectGUB ="S_PRICE";
		}else if (!(prtnoGubun.equals("1")) && priceGubun.equals("1")){
			dangaSelectGUB ="M_PRICE";
		}else if (!(prtnoGubun.equals("1")) && priceGubun.equals("2")){
			dangaSelectGUB ="C_PRICE";
		}else if (!(prtnoGubun.equals("1")) && priceGubun.equals("3")){
			dangaSelectGUB ="S_PRICE";
		}
		System.out.println(dangaSelectGUB);
		if (dangaSelectGUB == "M_PRICE"){  //제조원가
			list = dao.getListData("psimmlib.selectBHZZ101Q_Mprice", pArg);
		}
		if (dangaSelectGUB == "C_PRICE"){  //구매단가
			list = dao.getListData("psimmlib.selectBHZZ101Q_Pprice", pArg);
		}
		if (dangaSelectGUB == "S_PRICE"){  //판매단가
			list = dao.getListData("psimmlib.selectBHZZ101Q_Sprice", pArg);
		}
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZZ101Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/*
	public void selectBHZZ101Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		List list = new ArrayList();
		list = dao.getListData("psimmlib.selectBHZZ101Q", pArg);
		List pricelist = new ArrayList();
		Iterator it = list.iterator();
		String prtnoGubun = (String)pArg.get("CLSGU");
		String priceGubun = (String)pArg.get("PRCGUB");
		while (it.hasNext()){
			Map pData = (Map) it.next();
			double befQy = Double.parseDouble(""+pData.get("BEFQY"));
			double inpQy = Double.parseDouble(""+pData.get("INPQY"));
			double outQy = Double.parseDouble(""+pData.get("OUTQY"));
			double jegQy = Double.parseDouble(""+pData.get("JEGQY"));
			double cucQy = Double.parseDouble(""+pData.get("CUCQY"));
			double mnfcs = Double.parseDouble(""+pData.get("PRICE"));
			double befAm = 0;
			double inpAm = 0;
			double outAm = 0;
			double jegAm = 0;
			double cucAm = 0;
			// 단가생성 --------------------------------------------------------
			String dangaSelectGUB = "" ;
			if (prtnoGubun == "1" && priceGubun.equals("1")){
				dangaSelectGUB ="M_PRICE";
			}else if (prtnoGubun == "1" && priceGubun.equals("2")){
				dangaSelectGUB ="S_PRICE";
			}else if (prtnoGubun == "1" && priceGubun.equals("3")){
				dangaSelectGUB ="S_PRICE";
			}else if (prtnoGubun != "1" && priceGubun.equals("1")){
				dangaSelectGUB ="M_PRICE";
			}else if (prtnoGubun != "1" && priceGubun.equals("2")){
				dangaSelectGUB ="C_PRICE";
			}else if (prtnoGubun != "1" && priceGubun.equals("3")){
				dangaSelectGUB ="S_PRICE";
			}
			System.out.println(dangaSelectGUB);
			if (dangaSelectGUB == "M_PRICE"){  //제조원가
				befAm = befQy*mnfcs;
				inpAm = inpQy*mnfcs;
				outAm = outQy*mnfcs;
				jegAm = jegQy*mnfcs;
				cucAm = cucQy*mnfcs;
				System.out.println(befAm);
				System.out.println(inpAm);
			}
			if (dangaSelectGUB == "C_PRICE"){  //구매단가
				HashMap keyData = new HashMap();
				keyData.put("LIB1", (String)pArg.get("LIB1"));
				keyData.put("PSPNO", (String)pData.get("PSPNO"));
				keyData.put("YMD", (String)pArg.get("YMD"));
				double selectedPrice = 0;
				String selectedCrcy ="";
				Map priceData = (Map) dao.getReadData("pscomlib.selectCM001PR_ZA",keyData);
				if (priceData!=null && priceData.get("PRCE") !=null){
					selectedPrice = Double.parseDouble(""+priceData.get("PRCE"));
					selectedCrcy = (String) priceData.get("PRCE");
				}
				if (selectedCrcy == "KW"){
					befAm = Double.parseDouble(String.format("%.0f", befQy*selectedPrice));
					inpAm = inpQy*selectedPrice;
					outAm = outQy*selectedPrice;
					jegAm = jegQy*selectedPrice;
					cucAm = cucQy*selectedPrice;
				}else{
					befAm = befQy*mnfcs;
					inpAm = inpQy*mnfcs;
					outAm = outQy*mnfcs;
					jegAm = jegQy*mnfcs;
					cucAm = cucQy*mnfcs;
				}
			}
			if (dangaSelectGUB == "S_PRICE"){  //판매단가
				HashMap keyData = new HashMap();
				keyData.put("LIB1", (String)pArg.get("LIB1"));
				keyData.put("PSPNO", (String)pData.get("PSPNO"));
				keyData.put("YMD", (String)pArg.get("YMD"));
				double selectedPrice = 0;
				Map priceData = (Map) dao.getReadData("pscomlib.selectEM001PR_ZA",keyData);
				if (priceData!=null && priceData.get("PRICE") !=null){
					selectedPrice = Double.parseDouble(""+priceData.get("PRICE"));
				}
				befAm = Double.parseDouble(String.format("%.0f", befQy*selectedPrice));
				inpAm = inpQy*selectedPrice;
				outAm = outQy*selectedPrice;
				jegAm = jegQy*selectedPrice;
				cucAm = cucQy*selectedPrice;
			}
			pData.put("BEFAM", befAm);
			pData.put("INPAM", inpAm);
			pData.put("OUTAM", outAm);
			pData.put("JEGAM", jegAm);
			pData.put("CUCAM", cucAm);

			pricelist.add(pData);
		}
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZZ101Q", pricelist);
		new MiPlatformView().render(map, request, response);
	}

	public void selectBHZZ101Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = new ArrayList();
		list = dao.getListData("psimmlib.selectBHZZ101Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZZ101Q", list);
		new MiPlatformView().render(map, request, response);
	}
	*/
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  사급전표발행(야간배치전)
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBODC109R(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = new ArrayList();
		list = dao.getListData("psimmlib.selectBODC109R", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BODC109R", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  유상사급 현재고 조회
	 * @exception 
	 * @see 
	 * 	- 2013-11-01	:	lsk
	***********************************************************************/ 
	public void selectBUUZ101Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = new ArrayList();
		list = dao.getListData("psimmlib.selectBUUZ101Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BUUZ101Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  유상사급 거래이력 조회
	 * @exception 
	 * @see 
	 * 	- 2013-11-01	:	lsk
	***********************************************************************/ 
	public void selectBUUZ111Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = new ArrayList();
		list = dao.getListData("psimmlib.selectBUUZ111Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BUUZ111Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  자동출고마스타 등록
	 * @exception 
	 * @see 
	 * 	- 2013-11-01	:	lsk
	***********************************************************************/ 	
	public void selectBCOE100(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBCOE100", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BCOE100", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveBCOE100(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BCOE100");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
	
		String rowType="";
		String emptyPN="";
		String p_COMPS="";
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			//pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			p_COMPS=(String)pArg.get("COMPS");
			pData.put("COMPS",p_COMPS);
			
			emptyPN = (String) pData.get("PSPNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBCOE100_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("COMPS", pData.get("COMPS"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("psimmlib.deleteBCOE100", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			//pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			System.out.println((String)pArg.get("COMPS"));
			p_COMPS=(String)pArg.get("COMPS");
			pData.put("COMPS",p_COMPS);
			
			emptyPN = (String) pData.get("PSPNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBCOE100_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("COMPS", pData.get("COMPS"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psimmlib.saveBCOE100", pData);
						}
					}
				} 			
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_BCOE100_Check", errList);//추가
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 월구매집행현황
	 * @exception 
	 * @see 
	 * 	- 2013-06-17	:	mmk
	***********************************************************************/ 
	public void selectBZZE222Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZZE222Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZZE222Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 외주부품 납입지시서 조회
	 * @exception 
	 * @see 
	 * 	- 2013-11-17	:	LSK
	***********************************************************************/ 
	public void selectBVVE205Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBVVE205Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BVVE205Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  유상사급 재고조정TX 등록
	 * @exception 
	 * @see 
	 * 	- 2013-11-01	:	lsk
	***********************************************************************/ 	
	public void selectBUUZ150(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBUUZ150", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BUUZ150", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveBUUZ150(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BUUZ150");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
	
		String rowType="";
		String emptyPN="";
		String p_COMPS="";
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("JPNNO", (String)pArg.get("JPNNO"));
			pData.put("CONNO", (String)pArg.get("CONNO"));
			pData.put("TRNDT", (String)pArg.get("TRNDT"));
			pData.put("HOUSE", (String)pArg.get("HOUSE"));
			
			emptyPN = (String) pData.get("PSPNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBUUZ150_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("psimmlib.deleteBUUZ150", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("JPNNO", (String)pArg.get("JPNNO"));
			pData.put("CONNO", (String)pArg.get("CONNO"));
			pData.put("TRNDT", (String)pArg.get("TRNDT"));
			pData.put("HOUSE", (String)pArg.get("HOUSE"));
			
			emptyPN = (String) pData.get("PSPNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBUUZ150_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psimmlib.insertBUUZ150", pData);
						}
					}
				}
				if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBUUZ150_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psimmlib.updateBUUZ150", pData);
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_BUUZ150_Check", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  유상사급 실사재고TX 등록
	 * @exception 
	 * @see 
	 * 	- 2013-11-01	:	lsk
	***********************************************************************/ 	
	public void selectBUUZ160(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBUUZ160", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BUUZ160", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveBUUZ160(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BUUZ160");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
	
		String rowType="";
		String emptyPN="";
		String p_COMPS="";
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("JPNNO", (String)pArg.get("JPNNO"));
			pData.put("CONNO", (String)pArg.get("CONNO"));
			pData.put("TRNDT", (String)pArg.get("TRNDT"));
			pData.put("HOUSE", (String)pArg.get("HOUSE"));
			
			emptyPN = (String) pData.get("PSPNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBUUZ160_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("psimmlib.deleteBUUZ160", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("JPNNO", (String)pArg.get("JPNNO"));
			pData.put("CONNO", (String)pArg.get("CONNO"));
			pData.put("TRNDT", (String)pArg.get("TRNDT"));
			pData.put("HOUSE", (String)pArg.get("HOUSE"));
			
			emptyPN = (String) pData.get("PSPNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBUUZ160_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psimmlib.insertBUUZ160", pData);
						}
					}
				}
				if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBUUZ160_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psimmlib.updateBUUZ160", pData);
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_BUUZ160_Check", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  외주부품 소요계획 조회
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBODE123Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBODE123Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BODE123Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  외주부품 소요량 산출금액 조회
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBZZE401Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZZE401Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZZE401Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  외주부품 소요량 산출금액 현황_업체코드별
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBHZE216Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE216Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE216Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  외주부품 소요량 산출금액 집계_업체코드별
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBHZE217Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE217Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE217Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  자재재고보유현황_업체코드별
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBHZE215Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE215Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE215Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  담당자업체별 소요재고금액 현황
	 * @exception 
	 * @see 
	 * 	- 2014-02-01	:	lsk
	***********************************************************************/ 	
	public void selectBHZE213Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE213Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE213Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  외주부품 로케이션별 재고현황   
	 * @exception 
	 * @see 
	 * 	- 2014-02-01	:	lsk
	***********************************************************************/ 	
	public void selectBHZE212Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE212Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE212Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  외주부품 현재고현황 
	 * @exception 
	 * @see 
	 * 	- 2014-02-01	:	lsk
	***********************************************************************/ 	
	public void selectBHZZ201Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZZ201Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZZ201Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  월물류담당별입출고및재고금액현황 
	 * @exception 
	 * @see 
	 * 	- 2014-02-01	:	lsk
	***********************************************************************/ 	
	public void selectBZZE201Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZZE201Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZZE201Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  협력업체 주간소요량 현황
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBODE124Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBODE124Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BODE124Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  협력업체 월소요량 현황
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBODE125Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBODE125Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BODE125Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  협력업체 주간소요량 과부족 현황
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBODE126Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBODE126Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BODE126Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  제품 현재고 조회(득의선/차종별)
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBHZE201Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String queryGUB = (String) pData.get("G_GUB");
		List list = new ArrayList();
		if(queryGUB.equals("1")){
			list = dao.getListData("psimmlib.selectBHZE201Q_DETAIL", pData);
		}
		if(queryGUB.equals("2")){
			list = dao.getListData("psimmlib.selectBHZE201Q_SUMMARY", pData);
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE201Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  제품 현재고 조회(득의선/품번별)
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void selectBHZE203Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String queryGUB = (String) pData.get("G_GUB");
		List list = new ArrayList();
		if(queryGUB.equals("1")){
			list = dao.getListData("psimmlib.selectBHZE203Q_DETAIL", pData);
		}
		if(queryGUB.equals("2")){
			list = dao.getListData("psimmlib.selectBHZE203Q_SUMMARY", pData);
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE203Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  자재 실사후 재고 집계표
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBSSE101Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBSSE101Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BSSE101Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  수입품 재고 조회
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBOM521Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBOM521Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BOM521Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  수입현조품 진도관리현황
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBOMZ561Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBOMZ561Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BOMZ561Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  수입현조품 진도관리현황
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBOMZ562Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBOMZ562Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BOMZ562Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  장기체화현황
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBHZZ301Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZZ301Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZZ301Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  부품재고보유현황
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBHZE209Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE209Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE209Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  내제부품 현재고 현황
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBHZE301Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE301Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE301Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  실사재고 현황
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBSSE103Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBSSE103Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BSSE103Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  수입품 소요량 조회
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBZE509Q_BASDT(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZE509Q_BASDT", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZE509Q_BASDT", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectBZE509Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZE509Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZE509Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  월 자재수불 집계현황
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 	
	public void selectBHZZ105Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZZ105Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZZ105Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  
	 * @exception 
	 * @see 
	 * 	- 2014-07-01	:	lsk
	***********************************************************************/ 	
	public void selectBZZE301Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZZE301Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZZE301Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  
	 * @exception 
	 * @see 
	 * 	- 2014-07-01	:	lsk
	***********************************************************************/ 	
	public void selectBZZE311Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String queryGUB = (String) pData.get("QGUB");
		List list = new ArrayList();
		if(queryGUB.equals("1")){
			list = dao.getListData("psimmlib.selectBZZE311Q_1", pData);
		}
		if(queryGUB.equals("2")){
			list = dao.getListData("psimmlib.selectBZZE311Q_2", pData);
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZZE311Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  
	 * @exception 
	 * @see 
	 * 	- 2014-07-01	:	lsk
	***********************************************************************/ 	
	public void selectBZZE314Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZZE314Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZZE314Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  
	 * @exception 
	 * @see 
	 * 	- 2014-08-18	:	lsk
	***********************************************************************/ 	
	public void selectBRRE100(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBRRE100", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BRRE100", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveBRRE100(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BRRE100");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
	
		String rowType="";
		String emptyPN="";
		String emptyPV="";
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			
			emptyPN = (String) pData.get("MODNO");
			emptyPV = (String) pData.get("MODPY");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "" && emptyPV != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBRRE100_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MODNO", pData.get("MODNO"));
							errMap.put("MODPY", pData.get("MODPY"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psimmlib.deleteBRRE100", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			
			emptyPN = (String) pData.get("MODNO");
			emptyPV = (String) pData.get("MODPY");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "" && emptyPV != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBRRE100_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MODNO", pData.get("MODNO"));
							errMap.put("MODPY", pData.get("MODPY"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psimmlib.insertBRRE100", pData);
						}
					}
				}
				if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBRRE100_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MODNO", pData.get("MODNO"));
							errMap.put("MODPY", pData.get("MODPY"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psimmlib.updateBRRE100", pData);
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_BRRE100_Check", errList);//추가
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  
	 * @exception 
	 * @see 
	 * 	- 2014-08-18	:	lsk
	***********************************************************************/ 	
	public void selectBRRE110(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBRRE110", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BRRE110", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectBRRE110_History(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBRRE110_History", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BRRE110_History", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectBRRE110_MaxDate(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBRRE110_MaxDate", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BRRE110_MaxDate", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectBRRE100_Check(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBRRE100_Check", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BRRE100_Check", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveBRRE110(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BRRE110");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
	
		String rowType="";
		String emptyPN="";
		String emptyPV="";
		String emptyDT="";
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			
			emptyPN = (String) pData.get("MODNO");
			emptyPV = (String) pData.get("MODPY");
			emptyDT = (String) pData.get("MDATE");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "" && emptyPV != "" && emptyDT != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBRRE110_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MODNO", pData.get("MODNO"));
							errMap.put("MODPY", pData.get("MODPY"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psimmlib.deleteBRRE110", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			
			emptyPN = (String) pData.get("MODNO");
			emptyPV = (String) pData.get("MODPY");
			emptyDT = (String) pData.get("MDATE");
			rowType = (String) pData.get("ROW_TYPE");
			String nullMCOST = (String) pData.get("MCOST");
			System.out.println("aaaaaaaaa");
			System.out.println(nullMCOST);
			if( nullMCOST == null || nullMCOST.length() == 0){
				pData.put("MCOST", "0");
			}
			if (emptyPN != "" && emptyPV != "" && emptyDT != "") {
				if ("insert".equals(rowType)) {
					Map CheckMaxDate = (Map)dao.getReadData("psimmlib.selectBRRE110_MaxDate",pData);
					String s_maxdt;
					if(CheckMaxDate.get("MAXDATE") != ""){
						s_maxdt = CheckMaxDate.get("MAXDATE").toString();
					}else{
						s_maxdt = "0";
					}
					int i_maxdt = Integer.parseInt(s_maxdt);
										
					System.out.println(s_maxdt);
					System.out.println(i_maxdt);
					int i_dt = Integer.parseInt(emptyDT);
					if(i_maxdt >= i_dt){
						//insert 불가(기존 적용년월일보다 적거나 같을수는 없습니다.)
						HashMap errMap = new HashMap();
						errMap.put("MODNO", pData.get("MODNO"));
						errMap.put("MODPY", pData.get("MODPY"));
						errMap.put("RTMSG", "추가불가(기존 적용년월일보다 적거나 같을수는 없습니다.)");
						errList.add(errMap);
					}else{
						Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBRRE110_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(1)){
								//insert 불가(대상이 없음)
								HashMap errMap = new HashMap();
								errMap.put("MODNO", pData.get("MODNO"));
								errMap.put("MODPY", pData.get("MODPY"));
								errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.insertData("psimmlib.insertBRRE110", pData);
							}
						}
					}
				}
				if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBRRE110_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MODNO", pData.get("MODNO"));
							errMap.put("MODPY", pData.get("MODPY"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psimmlib.updateBRRE110", pData);
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_BRRE110_Check", errList);//추가
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  
	 * @exception 
	 * @see 
	 * 	- 2014-09-01	:	lsk
	***********************************************************************/ 	
	public void selectBZZE250(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZZE250", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZZE250", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveBZZE250(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BZZE250");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
	
		String rowType="";
		String emptyPN="";
		String emptyYY="";
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			
			emptyPN = (String) pData.get("PSPNO");
			emptyYY = (String) pData.get("CHKYY");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "" && emptyYY != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBZZE250_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("CHKYY", pData.get("CHKYY"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psimmlib.deleteBZZE250", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("CHKYY", (String)pArg.get("CHKYY"));
			pData.put("MM", (String)pArg.get("MM"));
			emptyPN = (String) pData.get("PSPNO");
			emptyYY = (String) pData.get("CHKYY");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "" && emptyYY != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBZZE250_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("CHKYY", pData.get("CHKYY"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psimmlib.insertBZZE250", pData);
						}
					}
				}
				if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBZZE250_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("CHKYY", pData.get("CHKYY"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psimmlib.updateBZZE250", pData);
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_BZZE250_Check", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  자재관리/
	 * @exception 
	 * @see 
	 * 	- 2014-09-01	:	lsk
	***********************************************************************/ 	
	public void selectBZOE010(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZOE010", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZOE010", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveBZOE010(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BZOE010");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		
		Iterator it_iu = pList.iterator();
	
		String rowType="";
		String emptyCO="";
		String emptyPR="";
		dao.startTransaction(); //tr 시작		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			emptyCO = (String) pData.get("COMPS");
			emptyPR = (String) pData.get("PROCS");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyCO != "" && emptyPR != "") {
				if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBZOE010_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PROCS", pData.get("PROCS"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psimmlib.updateBZOE010", pData);
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_BZOE010_Check", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	public void saveBZOE210U(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();

		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		dao.startTransaction(); //tr 시작	
		//부품출고확정마스타 전일자료 CLEAR
		dao.insertData("psimmlib.insertBZOE210U_backup", pArg);
		dao.deleteData("psimmlib.deleteBZOE210U_1", pArg);
		dao.deleteData("psimmlib.deleteBZOE210U_9", pArg);
		
		List pList = dao.getListData("psimmlib.selectBZOE210U", pArg);
		
		Iterator it = pList.iterator();
		String procs="";
		double re1=0;
		double re2=0;
		double re3=0;
		double re4=0;
		double re5=0;
		double re6=0;
			
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("MVMAN", (String)pArg.get("MVMAN"));
			re1 = Double.parseDouble(""+pData.get("RE1QY"));
			re2 = Double.parseDouble(""+pData.get("RE2QY"));
			re3 = Double.parseDouble(""+pData.get("RE3QY"));
			re4 = Double.parseDouble(""+pData.get("RE4QY"));
			re5 = Double.parseDouble(""+pData.get("RE5QY"));
			re6 = Double.parseDouble(""+pData.get("RE6QY"));
			if (re1 != 0) {   // 08:00 ~ 10:00
				pData.put("REQGU", "10");
				pData.put("REQQY", re1);
				dao.insertData("psimmlib.insertBZOE210U", pData);
				dao.insertData("psimmlib.insertBZOE210U_9", pData);
			}
			if (re2 != 0) {   // 10:10 ~ 12:00
				pData.put("REQGU", "20");
				pData.put("REQQY", re2);
				dao.insertData("psimmlib.insertBZOE210U", pData);
				dao.insertData("psimmlib.insertBZOE210U_9", pData);
			}
			if (re3 != 0) {   // 13:00 ~ 15:00
				pData.put("REQGU", "30");
				pData.put("REQQY", re3);
				dao.insertData("psimmlib.insertBZOE210U", pData);
				dao.insertData("psimmlib.insertBZOE210U_9", pData);
			}
			if (re4 != 0) {   // 15:10 ~ 17:00
				pData.put("REQGU", "40");
				pData.put("REQQY", re4);
				dao.insertData("psimmlib.insertBZOE210U", pData);
				dao.insertData("psimmlib.insertBZOE210U_9", pData);
			}
			if (re5 != 0) {   // 17:10 ~ 19:00
				pData.put("REQGU", "50");
				pData.put("REQQY", re5);
				dao.insertData("psimmlib.insertBZOE210U", pData);
				dao.insertData("psimmlib.insertBZOE210U_9", pData);
			}
			if (re6 != 0) {   // 19:10 ~
				pData.put("REQGU", "60");
				pData.put("REQQY", re6);
				dao.insertData("psimmlib.insertBZOE210U", pData);
				dao.insertData("psimmlib.insertBZOE210U_9", pData);
			}
			dao.updateData("psimmlib.updateBZOE210U_1", pData);
			if (procs!="" && !(procs.equals((String) pData.get("PROCS")))){
				//요구이동시간 Update
				dao.updateData("psimmlib.updateBZOE210U_2", pData);
			}
			procs = (String) pData.get("PROCS");
		}
		pArg.put("BUCOD", "GAMOV");
		Map CheckYN = (Map)dao.getReadData("pscomlib.selectBUY040PF",pArg);
		if(CheckYN!=null && CheckYN.get("BUINT")!=null && !CheckYN.get("BUINT").equals("")){
			if(Double.parseDouble(""+CheckYN.get("BUINT")) == 0){
				//Double.parseDouble(""+pData.get("RE1QY"))
				dao.updateData("pscomlib.updateBUY040PF_1", pArg);
			}
		}else{
			dao.insertData("pscomlib.insertBUY040PF_1", pArg);
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.put("SUCCES", "Y");
		//map.addAttribute("ds_BZOE010_Check", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  자재관리/
	 * @exception 
	 * @see 
	 * 	- 2014-09-01	:	lsk
	***********************************************************************/ 	
	public void selectBZOE211Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZOE211Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZOE211Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  자재관리/
	 * @exception 
	 * @see 
	 * 	- 2014-09-01	:	lsk
	***********************************************************************/ 	
	public void selectBZOE210(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZOE210", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZOE210", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectBZOE210_duCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZOE210_duCheck", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZOE210_duCheck", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectFinishBZO210PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectFinishBZO210PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZO210PF", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveBZOE210(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BZOE210");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
	
		String rowType="";
		dao.startTransaction(); //tr 시작
		
		while (it_d.hasNext()) {
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("PLANN", (String)pArg.get("PLANN"));
			pData.put("CHLDT", (String)pArg.get("CHLDT"));
			pData.put("DPTCD", (String)pArg.get("DPTCD"));
			rowType = (String) pData.get("ROW_TYPE");
			if ("delete".equals(rowType)) {
				Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBZOE210_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(CheckCnt.get("CNT").equals(0)){
						//삭제불가(대상이 없음)
						HashMap errMap = new HashMap();
						errMap.put("PROCS", pData.get("PROCS"));
						errMap.put("PSPNO", pData.get("PSPNO"));
						errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						dao.deleteData("psimmlib.deleteBZOE210", pData);
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("PLANN", (String)pArg.get("PLANN"));
			pData.put("CHLDT", (String)pArg.get("CHLDT"));
			pData.put("DPTCD", (String)pArg.get("DPTCD"));
			pData.put("USRNM", (String)pArg.get("USRNM"));
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBZOE210_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(CheckCnt.get("CNT").equals(1)){
						//insert 불가(대상이 없음)
						HashMap errMap = new HashMap();
						errMap.put("PROCS", pData.get("PROCS"));
						errMap.put("PSPNO", pData.get("PSPNO"));
						errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						dao.insertData("psimmlib.insertBZOE210", pData);
					}
				}
			}
			if ("update".equals(rowType)) {
				Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBZOE210_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(CheckCnt.get("CNT").equals(0)){
						//update 불가(대상이 없음)
						HashMap errMap = new HashMap();
						errMap.put("PROCS", pData.get("PROCS"));
						errMap.put("PSPNO", pData.get("PSPNO"));
						errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						dao.updateData("psimmlib.updateBZOE210", pData);
					}
				}
			}
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_BZOE210_Check", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  자재관리/입하관리MENU/부품출고요구 현황
	 * @exception 
	 * @see 
	 * 	- 2014-09-01	:	lsk
	***********************************************************************/ 	
	public void selectBZOE212Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZOE212Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZOE212Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  자재관리/입하관리MENU/입하출고요구대 출고조회    
	 * @exception 
	 * @see 
	 * 	- 2014-09-01	:	lsk
	***********************************************************************/ 	
	public void selectBZOE222Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZOE222Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZOE222Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  자재관리/ FTA SYSTEM 관리 / OCS<->MRP Interface 관리
	 * @exception 
	 * @see 
	 * 	- 2015-07-22	:	lsk
	***********************************************************************/ 	
	public void selectDFTZ001(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectDFTZ001", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_DFTZ001", list);
		new MiPlatformView().render(map, request, response);
	}	
	/* lee sang keon 자재관리 작업  End----------------------------------------------------------------------------------------- */
	
	/* jae hwan bok 자재관리 작업  Start---------------------------------------------------------------------------------------- */
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  생산관리/소요량관리/협력업체 주간소요량 부족분조회(PE)
	 * @see
	 * 	- 2013-11-22	:	제환복
	***********************************************************************/
/*중복삭제
	public void selectBODE126Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBODE126Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BODE126Q", list);				
		new MiPlatformView().render(map, request, response);
	}
*/	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  생산관리/소요량관리/수입품 소요량 조회(PE)
	 * @see
	 * 	- 2013-11-22	:	제환복
	***********************************************************************/
/*중복삭제	
	public void selectBZE509Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZE509Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZE509Q", list);				
		new MiPlatformView().render(map, request, response);
	}
	public void selectBZE509QD(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZE509QD", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZE509QD", list);				
		new MiPlatformView().render(map, request, response);
	}
*/
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  생산관리/CIGMA자료관리/창고이동관리/사외창고 이동 재고현황(PE)
	 * @see
	 * 	- 2013-12-24	:	제환복
	***********************************************************************/
	public void selectBHZE601Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE601Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE601Q", list);				
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  생산관리/CIGMA자료관리/창고이동관리/사외창고 이동 재고LIST(PE)
	 * @see
	 * 	- 2013-12-24	:	제환복
	***********************************************************************/
	public void selectBHZE602Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBHZE602Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZE602Q", list);				
		new MiPlatformView().render(map, request, response);
	}
	/* jae hwan bok 자재관리 작업  End------------------------------------------------------------------------------------------- */
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  저장품 분류 마스타등록
	 * @see
	 * 	- 2014-08-11	:	민명규
	***********************************************************************/
	public void selectBJMZ010(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJMZ010", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJMZ010", list);				
		new MiPlatformView().render(map, request, response);
	}
	
	public void saveBJMZ010(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BJMZ010");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
	
		String rowType="";		
		String p_CLSCD="";
		String p_COMPS="";
		
		dao.startTransaction(); //tr 시작		

		while (it_d.hasNext()) {  //
			Map pData = (Map) it_d.next();
			//pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			p_COMPS=(String)pArg.get("COMPS");
			pData.put("COMPS",p_COMPS);
		
			p_CLSCD = (String) pData.get("CLSCD");
			rowType = (String) pData.get("ROW_TYPE");
						
			if (p_CLSCD != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBJMZ010",pData);
					System.out.println(CheckCnt);
					if(CheckCnt!=null){
						dao.deleteData("psimmlib.deleteBJMZ010", pData);
					}else{
						//삭제불가(대상이 없음)
						HashMap errMap = new HashMap();
						errMap.put("CLSCD", pData.get("CLSCD"));
						errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
						errList.add(errMap);
					}
				}else if ("insert".equals(rowType)) {
					dao.insertData("psimmlib.saveBJMZ010", pData);
				}else if ("update".equals(rowType)){
					dao.updateData("psimmlib.updateBJMZ010", pData);
				}
			}
		}	
		
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_BJMZ010_Check", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  저장품 단위 마스타등록
	 * @see
	 * 	- 2014-08-13	:	민명규
	***********************************************************************/
	public void selectBJMZ050(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJMZ050", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJMZ050", list);				
		new MiPlatformView().render(map, request, response);
	}
	
	public void saveBJMZ050(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BJMZ050");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
	
		String rowType="";		
		String p_UMSNM="";
		String p_COMPS="";
		
		dao.startTransaction(); //tr 시작		

		while (it_d.hasNext()) {  //
			Map pData = (Map) it_d.next();
			//pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			p_COMPS=(String)pArg.get("COMPS");
			pData.put("COMPS",p_COMPS);
		
			p_UMSNM = (String) pData.get("CLSCD");
			rowType = (String) pData.get("ROW_TYPE");
						
			if (p_UMSNM != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBJMZ050",pData);
					System.out.println(CheckCnt);
					if(CheckCnt!=null){
						dao.deleteData("psimmlib.deleteBJMZ050", pData);
					}else{
						//삭제불가(대상이 없음)
						HashMap errMap = new HashMap();
						errMap.put("UMSNM", pData.get("UMSNM"));
						errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
						errList.add(errMap);
					}
				}else if ("insert".equals(rowType)) {
					dao.insertData("psimmlib.saveBJMZ050", pData);
				}else if ("update".equals(rowType)){
					dao.updateData("psimmlib.updateBJMZ050", pData);
				}
			}
		}	
		
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_BJMZ050_Check", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  생산관리/현장관리/부품출고확인관리/부품출고확인(제조)_PS
	 * @see
	 * 	- 2014-11-25	:	제환복
	***********************************************************************/
	public void selectBZOC500(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZOC500", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZOC500", list);				
		new MiPlatformView().render(map, request, response);
	}
	public void selectBZOC500D(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBZOC500D", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZOC500D", list);				
		new MiPlatformView().render(map, request, response);
	}
	public void saveBZOC500(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pArg = DataConverter.getMiPlatformData(pReq);
System.out.print((String) pArg.get("BSPRCD"));
		
		String emptyPRCD="";
		emptyPRCD = (String) pArg.get("BSPRCD");
		dao.startTransaction(); //tr 시작		
		if(emptyPRCD.equals("Y")) {
			Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBZOC500_Check",pArg);
			if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
				if(CheckCnt.get("CNT").equals(0)){
					dao.insertData("psimmlib.insertBZOC500", pArg);
				}else{
					dao.updateData("psimmlib.updateBZOC500", pArg);
				}
			}
		}
		dao.endTransaction(); //commit	
		new MiPlatformView().render(null, request, response);
	}
	public void selectBJMZ114Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJMZ114Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJMZ114Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBJMZ110(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJMZ110", pData);
		
		ModelMap map = new ModelMap();
		/*List oneList = list.subList(0, 0);
		map.addAttribute("ds_BJMZ100", oneList);*/
		map.addAttribute("ds_BJMZ110", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void saveBJMZ110(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*CommonDAO dao = CommonDAO.getInstance(1);*/
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BJMZ110");
		List errList = new ArrayList();// error check list
		
		Map pArg = DataConverter.getMiPlatformData(pReq);

		String Slib2 = (String)pArg.get("LIB2");
		
		Iterator it_iu = pList.iterator(); //insert,update용
		
		String rowType = "";
		List deleteList = new ArrayList();
		dao.startTransaction(); //tr 시작	
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", Slib2);
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBJMZ110Check",pData);
				if(!(CheckCnt.get("CNT").equals(0))){
					//insert 불가(이미등록된 자료)
					HashMap errMap = new HashMap();
					errMap.put("COMPS", pData.get("COMPS"));
					errMap.put("SMOCL", pData.get("SMOCL"));
					errMap.put("SMOPN", pData.get("SMOPN"));
					errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					dao.insertData("psimmlib.insertBJMZ110", pData);
				}
			} else if ("update".equals(rowType)) {
				Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBJMZ110Check",pData);
				if(!(CheckCnt.get("CNT").equals(0))){
					dao.updateData("psimmlib.updateBJMZ110", pData);
				}else{
					//update 불가(대상이 없음)
					HashMap errMap = new HashMap();
					errMap.put("COMPS", pData.get("COMPS"));
					errMap.put("SMOCL", pData.get("SMOCL"));
					errMap.put("SMOPN", pData.get("SMOPN"));
					errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}
			}
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJMZ110_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	
	@SuppressWarnings("unchecked")
	public void saveBJIZ110C(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.startTransaction(); //tr 시작
	
		// 데이터를 저장 할 객체 생성.
		List<BJIZ110C> bjiz110cModel = new ArrayList<BJIZ110C>();
		
		// 저장품입고TX DATA 조회 (테이블 :BJI110PF)
		bjiz110cModel = (List<BJIZ110C>)dao.getListDataModel("psimmlib.selectBJIZ110Q",pArg); 
			
		for (BJIZ110C bjiz110c : bjiz110cModel) {
			bjiz110c.setLIB1(pArg.get("LIB1").toString());
			bjiz110c.setLIB2(pArg.get("LIB2").toString());
			// 저장품입고마스타 DATA 존재 유무 확인 (테이블 :BJI100PF)
			int cnt = (Integer)dao.getReadData("psimmlib.selectBJIZ100Check", bjiz110c);       
			// 존재하지 않을 경우 BJI100PF 테이블 INSERT 처리 후 BJI110PF 테이블 테이터 삭제 
			if( cnt == 0){																    
				dao.insertData("psimmlib.insertBJIZ100C", bjiz110c);
			}
			dao.deleteData("psimmlib.deleteBJIZ110C", bjiz110c);
		}
		
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);
	}
	
	/**
	 * 저장품 년월별 입고 조회
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void selectBJIZ101Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJIZ101Q", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJIZ101Q", list);
		new MiPlatformView().render(map, request, response);
	}

	/**
	 * 저장품 업체별 입고금액 조회
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void selectBJIZ103Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJIZ103Q", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJIZ103Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	- request로 입력받은 데이터셋명을 파리미터에 따라 변경하여 데이터셋명을 리턴한다.
	 * @see
	 * 	- 2016-02-05	:	LSK
	***********************************************************************/ 	
	public void selectR_BHZE208Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectR_BHZE208Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_R_BHZE208Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  자재관리/저장품/출고관리/저장품 부서별 출고집계 현황
	 * @exception 
	 * 	- request로 입력받은 데이터셋명을 파리미터에 따라 변경하여 데이터셋명을 리턴한다.
	 * @see
	 * 	- 2016-02-05	:	LSK
	***********************************************************************/ 	
	public void selectBJOZ112Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJOZ112Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJOZ112Q", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectBJOZ112QD(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJOZ112QD", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJOZ112QD", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  자재관리/저장품/출고관리/저장품 부서별 출고상세 현황
	 * @exception 
	 * 	- request로 입력받은 데이터셋명을 파리미터에 따라 변경하여 데이터셋명을 리턴한다.
	 * @see
	 * 	- 2016-02-05	:	LSK
	***********************************************************************/ 	
	public void selectBJOZ118Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psimmlib.selectBJOZ118Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJOZ118Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		    :	데이터셋
	 * @exception 
	 * 	- request로 입력받은 데이터셋명을 파리미터에 따라 변경하여 데이터셋명을 리턴한다.
	 * @see
	 * 	- 2016-02-05	:	LSK
	***********************************************************************/ 	
	public void selectBJIZ110(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);	
		
		String sqlId = pData.get("SQLID").toString(); 
		String sqlMapId = "psimmlib.";
		String addAttributeName = "ds_BJIZ110";
		
		if(sqlId.equals("getMaxRpijp")){
			// Find max slip number
			sqlMapId += "selectMST040PF";
			addAttributeName = "ds_BJIZ110_CHECK";
			
		} else if(sqlId.equals("getBJIZ110")){
			// Find All
			sqlMapId += "selectBJIZ110";
			
		} else if(sqlId.equals("getBJIZ121")){
			// Find All
			sqlMapId += "selectBJIZ121";
			
		} 		
		
		ModelMap map = new ModelMap();
		List list = dao.getListData(sqlMapId, pData);
		map.addAttribute(addAttributeName, list);
		
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectBJIZ100(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);	
		
		String sqlId = pData.get("SQLID").toString(); 
		String sqlMapId = "psimmlib.";
		String addAttributeName = "ds_BJIZ100";
		
		if(sqlId.equals("getBJIZ100")){
			sqlMapId += "selectBJIZ100Q";
			addAttributeName = "ds_BJIZ100";
			
		} else if(sqlId.equals("getBjiz100q")){
			addAttributeName = "ds_BJIZ124P";
			sqlMapId += "selectBJIZ100Q";
			
		} else if(sqlId.equals("getBjiz125q")){
			addAttributeName = "ds_BJIZ125P";
			sqlMapId += "selectBJIZ125Q";
			
		} else if (sqlId.equals("getBjiz102qd")){
			addAttributeName = "ds_BJMZ111QD";
			sqlMapId += "selectBJIZ102QD";
			
		}else if (sqlId.equals("getBjiz107q")){
			addAttributeName = "ds_BJIZ107Q";
			sqlMapId += "selectBJIZ107Q";
			
		} else if (sqlId.equals("getBJIZ126")){
			addAttributeName = "ds_BJIZ126";
			sqlMapId += "selectBJIZ126Q";
			this.setMonthMap(pData, "RPJYM");
		}
		
		ModelMap map = new ModelMap();
		List list = dao.getListData(sqlMapId, pData);
		map.addAttribute(addAttributeName, list);
		
		new MiPlatformView().render(map, request, response);
	}
	
	private void setMonthMap(Map pData, String initKey){

		String rpjym=  pData.get(initKey).toString();
		
		for (int mon = 1; mon < 13; mon++) {
			if(mon < 10){
				String key = "MON" + "0" +mon;
				String value = rpjym + "0" +mon;
				pData.put(key, value);	
			} else{
				String key = "MON" + mon;
				String value = rpjym + mon;
				pData.put(key, value);	
			}
		}
	}
	
	public void saveBJIZ110Modify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();

		List<Map> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BJIZ100");
		Map pArg = DataConverter.getMiPlatformData(pReq);

		List errList = new ArrayList();
		HashMap errMap = new HashMap();
		
		dao.startTransaction();
		for (int i=0; i < pList.size();i++) {
			Map pData = (Map)pList.get(i);
			pData.put("LIB2", pArg.get("LIB2").toString());			
			String rowType = pData.get("ROW_TYPE").toString();
			
			if ("update".equals(rowType)) {
				if(pData.get("RPIQY").toString().equals("0") || pData.get("RPIQY").toString().equals("")){
					dao.deleteData("psimmlib.deleteBJIZ100", pData);
				}else {
					dao.updateData("psimmlib.updateBJIZ100RPIQY", pData);	
				}				
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psimmlib.deleteBJIZ100", pData);
			}	
				// E: process
		}
		
		dao.endTransaction();

		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJIZ100_CHECK", errList);		
		new MiPlatformView().render(map, request, response);
	}
	
	public void saveBJIZ110(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();

		List<Map> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BJIZ110");
		Map pArg = DataConverter.getMiPlatformData(pReq);

		List errList = new ArrayList();
		HashMap errMap = new HashMap();

		Map pData = null;
		dao.startTransaction();
		boolean checkInsert = false;
		for (int i=0; i < pList.size();i++) {
			pData = (Map)pList.get(i);
			pData.put("LIB2", pArg.get("LIB2").toString());
			if(!pData.get("RPIPN").toString().trim().equals("")){
				String rowType = pData.get("ROW_TYPE").toString();
				
				// S: 필요 데이터 취득
				//int cnt = dao.getIntValue("psimmlib.selectBJIZ110Cnt", pData);								
				Map bjm100Map = (Map)dao.getReadData("psimmlib.selectBJM100", pData);			  // 등록시 필요 데이터
				
				if(bjm100Map != null){
					pData.putAll(bjm100Map);
					String rpist = (String)dao.getReadData("psimmlib.selectBJM110PFICOST", pData);  // 최종 단가
					pData.put("RPIST", rpist);
				}	
				
				if ("insert".equals(rowType)) {
					dao.insertData("psimmlib.insertBJIZ110", pData);
					checkInsert = true;
				} else if ("update".equals(rowType)) {
					dao.updateData("psimmlib.updateBJIZ110", pData);
				} else if ("delete".equals(rowType)) {
					dao.deleteData("psimmlib.deleteBJIZ110", pData);
				}	
				// E: process
			}
		}
		
		// 최종 전표가 같을 경우는 업데이트 실시.
		if(checkInsert){						
			Map map = (Map)dao.getReadData("psimmlib.selectMST040PF", pArg);
			if(map != null){
				Integer mjintplus = plusMjint(map);
				if(mjintplus > 0){
					//전표번호 업데이트
					pArg.put("MJINTPLUS", mjintplus);					
					dao.updateData("psimmlib.updateMST040PF", pArg);
				}
			}
		}
		
		dao.endTransaction();

		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJIZ110_CHECK", errList);		
		new MiPlatformView().render(map, request, response);
	}
	
	private Integer plusMjint(Map map){
		if(map.get("MJINT") != null){
			return (Integer.parseInt(map.get("MJINT").toString()) + 1);	
		}
		return 0; 
	}
	
	@SuppressWarnings("unchecked")
	public void saveBJZZ101C(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.startTransaction(); // tr 시작
	
		// 데이터를 저장 할 객체 생성.
		List<BJIZ100C> bjiz100cModel = new ArrayList<BJIZ100C>();
		
		// 저장품입고TX DATA 조회 (테이블 :BJI110PF)
		bjiz100cModel = (List<BJIZ100C>)dao.getListDataModel("psimmlib.selectBJIZ100",pArg); 
			
		String rpgub = pArg.get("GUBUN").toString();
		for (BJIZ100C bjiz100c : bjiz100cModel) {
			// Data Setting
			bjiz100c.setRpjym(pArg.get("YYYYMM").toString());
			bjiz100c.setRpgub(rpgub);
			
			if(rpgub.equals("A") && Integer.parseInt(bjiz100c.getRpidt().substring(6,7)) < 15){ 
				dao.updateData("psimmlib.updateBJZZ100", bjiz100c);
			} else if(rpgub.equals("B")){
				// 존재하지 않을 경우 BJI100PF 테이블 INSERT 처리 후 BJI110PF 테이블 테이터 삭제 
				dao.updateData("psimmlib.updateBJZZ100", bjiz100c);				
			}
		}
		
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);	
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		    :	데이터셋
	 * @exception 
	 * 	- request로 입력받은 데이터셋명을 파리미터에 따라 변경하여 데이터셋명을 리턴한다.
	 * @see
	 * 	- 2016-02-05	:	LSK
	***********************************************************************/ 	
	public void selectBJOZ110(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		if(pData != null & pData.get("ISICL") != null){
			pData.put("ISICL", pData.get("ISICL").toString().toUpperCase());		// 분류코드 대문자로 변환	
		}		
		
		String sqlId = pData.get("SQLID").toString(); 
		String addAttributeName = "ds_BJOZ110";
		
		if(sqlId.equals("selectMST040PF") || sqlId.equals("selectBJM100")){
			// Find max slip number
			addAttributeName = "ds_BJOZ110_CHECK";
			
		} else if(sqlId.equals("selectBJOZ115")){
			// Find max slip number
			addAttributeName = "ds_BJOZ110";
		} else if (sqlId.equals("selectBJOZ110")){
			// Find max slip number
			addAttributeName = "ds_BJO100";
		}

		ModelMap map = new ModelMap();
		List list = dao.getListData(("psimmlib."+sqlId), pData);
		map.addAttribute(addAttributeName, list);
		
		new MiPlatformView().render(map, request, response);
	}

	public void saveBJOZ110(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();

		List<Map> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BJO100");
		Map pArg = DataConverter.getMiPlatformData(pReq);

		List errList = new ArrayList();
		HashMap errMap = new HashMap();

		Map pData = null;
		dao.startTransaction();
		boolean checkInsert = false;
		for (int i=0; i < pList.size();i++) {
			pData = (Map)pList.get(i);
			pData.put("LIB2", (String)pArg.get("LIB2"));			
			
			if(!pData.get("ISIPN").toString().trim().equals("")){
				String rowType = pData.get("ROW_TYPE").toString();
				String rpipn = pData.get("ISIPN").toString();			// 전표 번호
												
				Map bjm100Map = (Map)dao.getReadData("psimmlib.selectBJM100", pData);			  //
				
				if(bjm100Map != null){
					pData.putAll(bjm100Map);
					String rpist = (String)dao.getReadData("psimmlib.selectBJM110PFICOST", pData);  // 최종 단가
					pData.put("ISIST", rpist);
				}
				
				if ("insert".equals(rowType)) {
					
					dao.insertData("psimmlib.insertBJOZ110", pData);
					checkInsert = true;
				} else if ("update".equals(rowType)) {
					
					dao.updateData("psimmlib.updateBJOZ110", pData);
				} else if ("delete".equals(rowType)) {
					dao.deleteData("psimmlib.deleteBJOZ110", pData);
				}	
				// E: process
			}
		}
		
		// 최종 전표가 같을 경우는 업데이트 실시.
		if(checkInsert){						
			Map map = (Map)dao.getReadData("psimmlib.selectMST040PF", pArg);
			if(map != null){
				Integer mjintplus = plusMjint(map);
				if(mjintplus > 0){
					//전표번호 업데이트
					pArg.put("MJINTPLUS", mjintplus);					
					dao.updateData("psimmlib.updateMST040PF", pArg);
				}
			}
		}
		
		dao.endTransaction();

		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJOZ110_CHECK", errList);		
		new MiPlatformView().render(map, request, response);
	}
	
	@SuppressWarnings("unchecked")
	public void saveBJOZ110C(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		Map pArg = DataConverter.getMiPlatformData(pReq);
	
		// 데이터를 저장 할 객체 생성.
		List<BJOZ110C> bjoz110cModel = new ArrayList<BJOZ110C>();
		
		dao.startTransaction(); //tr 시작
		// 저장품입고TX DATA 조회 (테이블 :BJI110PF)
		bjoz110cModel = (List<BJOZ110C>)dao.getListDataModel("psimmlib.selectBJOZ110Q",pArg); 
			
		for (BJOZ110C bjoz110c : bjoz110cModel) {
			// 저장품입고마스타 DATA 존재 유무 확인 (테이블 :BJO100PF)
			int cnt = (Integer)dao.getReadData("psimmlib.selectBJOZ100Check", bjoz110c);       
			// 존재하지 않을 경우 BJI100PF 테이블 INSERT 처리 후 BJI110PF 테이블 테이터 삭제			
			if( cnt == 0){																    
				dao.insertData("psimmlib.insertBJOZ100C", bjoz110c);
			}
			dao.deleteData("psimmlib.deleteBJOZ110C", bjoz110c);
		}
		
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);
	}
	
	public void selectBJOZ(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);	
		
		String sqlId = pData.get("SQLID").toString(); 
		String sqlMapId = "psimmlib.";
		String addAttributeName = "ds_BJOZ122Q";
		
		if(sqlId.equals("selectBJOZ1221Q")){
			addAttributeName = "ds_BJOZ122Q";
			
		} else if(sqlId.equals("selectBJOZ1222Q")){
			addAttributeName = "ds_BJOZ122Q";
			
		} else if(sqlId.equals("selectBJOZ101Q")){			
			addAttributeName = "ds_BJOZ101Q";
			
		} else if(sqlId.equals("selectBJOZ103Q")){
			addAttributeName = "ds_BJOZ103Q";
			sqlId = "selectBJOZ1222Q";
			
		} else if(sqlId.equals("selectBJOZ104Q")){
			addAttributeName = "ds_BJMZ111QD";
			sqlId = "selectBJIZ102QD";
			
		}  else if(sqlId.equals("selectBJOZ105Q")){
			addAttributeName = "ds_BJOZ105Q";
			
		}  else if(sqlId.equals("selectBJOZ106Q")){
			addAttributeName = "ds_BJOZ106Q";
			
		} else if(sqlId.equals("selectBJOZ107Q")){
			addAttributeName = "ds_BJOZ107Q";
			sqlId = "selectBJOZ1222Q";
			
		} else if(sqlId.equals("selectBJM060PF")){
			addAttributeName = "ds_BJOZ110_CHECK";
			sqlId = "selectBJM060PF";
			
		} else if(sqlId.equals("selectBJOZ116Q")){
			addAttributeName = "ds_BJOZ116Q";		
			
		} else if(sqlId.equals("selectBJOZ108Q")){
			addAttributeName = "ds_BJOZ108Q";		
			
		} else if(sqlId.equals("selectBJOZ109Q")){
			addAttributeName = "ds_BJOZ109Q";		
			
		} else if(sqlId.equals("selectBJOZ121Q")){
			addAttributeName = "ds_BJOZ121Q";	
			
		}  else if(sqlId.equals("selectBJOZ120Q")){
			addAttributeName = "ds_BJOZ120";		

			this.setMonthMap(pData, "ISJYM");
		} 
		
		ModelMap map = new ModelMap();
		List list = dao.getListData(sqlMapId + sqlId, pData);
		map.addAttribute(addAttributeName, list);
		
		new MiPlatformView().render(map, request, response);
	}
	
	
	public void selectBJHZ(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);	
		
		String sqlId = pData.get("SQLID").toString(); 
		String sqlMapId = "psimmlib.";
		String addAttributeName = "ds_BJHZ101Q";
		
		if(sqlId.equals("selectBJHZ101Q")){
			addAttributeName = "ds_BJHZ101Q";
			
		} else if(sqlId.equals("selectBJHZ106Q")){
			addAttributeName = "ds_BJHZ106Q";
			
		} else if(sqlId.equals("selectBJIZ122Q")){
			addAttributeName = "ds_BJIZ122Q";
			
		} else if(sqlId.equals("selectBJZZ102Q")){
			addAttributeName = "ds_BJZZ102";
			this.setMonth(pData);
			
		}  else if(sqlId.equals("selectBJZZ103Q")){
			addAttributeName = "ds_BJZZ103";
			this.setMonth(pData);
		} 
		
		ModelMap map = new ModelMap();
		List list = dao.getListData(sqlMapId + sqlId, pData);
		map.addAttribute(addAttributeName, list);
		
		new MiPlatformView().render(map, request, response);
	}
	
	
	private void setMonth(Map pData){
		String monthSt = pData.get("MM").toString();
		int month = Integer.parseInt(monthSt);
		
		if( 1 <= month && month <= 3){
			pData.put("MONTH", numFmt(month + 9));
			pData.put("MONTH_FORWARD", numFmt(month + 8));
		} else { // 4월 ~ 12월
			pData.put("MONTH", numFmt(month - 3));
			pData.put("MONTH_FORWARD", numFmt(month - 4));
			
		}
	}
	
	private String numFmt(Integer temp){
		NumberFormat numFmt = NumberFormat.getInstance();
		numFmt.setMinimumIntegerDigits(2);
		if(temp == 0){
			temp = 12;
		}
		return numFmt.format(temp);
	}
	
	public void selectBJSZ(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);	
		
		String sqlId = pData.get("SQLID").toString(); 
		String sqlMapId = "psimmlib.";
		String addAttributeName = "ds_BJSZ110";
		
		if(sqlId.equals("selectBJSZ110Q")){
			addAttributeName = "ds_BJSZ110";
			
		} else if(sqlId.equals("selectBJM100")){
			addAttributeName = "ds_BJSZ110_CHECK";
			
		} else if(sqlId.equals("selectBJSZ100Q")){
			addAttributeName = "ds_BJSZ100";
			
		} else if(sqlId.equals("selectBJSZ112Q")){
			addAttributeName = "ds_BJSZ112";
		} 
		
		ModelMap map = new ModelMap();
		List list = dao.getListData(sqlMapId + sqlId, pData);
		map.addAttribute(addAttributeName, list);
		
		new MiPlatformView().render(map, request, response);
	}
	
	
	public void saveBJSZ110(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();

		List<Map> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BJSZ110");
		Map pArg = DataConverter.getMiPlatformData(pReq);

		List errList = new ArrayList();
		HashMap errMap = new HashMap();

		dao.startTransaction();
		
		for (int i=0; i < pList.size();i++) {
			Map pData = (Map)pList.get(i);
			// S: 필요 데이터 취득
			
			if(!pData.get("WSICL").toString().trim().equals("")){
				String rowType = pData.get("ROW_TYPE").toString();
				
				// 데이터 등록/수정/삭제
				if ("insert".equals(rowType)) {
					// S: process
					Map bjs100Map = (Map)dao.getReadData("psimmlib.selectBJSZ110Q", pData);			// 차수계산				
					// 차수 데이터 설정 ( 존재하는경우는 1증가)
					if(bjs100Map != null){
						pData.put("WSISQ", (Integer.parseInt(bjs100Map.get("WSISQ").toString())+1));					
					} else{
						pData.put("WSISQ", 1);
					}
					
					pData.put("WPIST", dao.getReadData("psimmlib.selectBJM110PFICOST", pData).toString());// 최종 단가
					dao.insertData("psimmlib.insertBJSZ110", pData);
					
				} else if ("update".equals(rowType)) {

					pData.put("WPIST", dao.getReadData("psimmlib.selectBJM110PFICOST", pData).toString());// 최종 단가
					dao.updateData("psimmlib.updateBJSZ110", pData);
					
				} else if ("delete".equals(rowType)) {
					dao.deleteData("psimmlib.deleteBJSZ110", pData);
				}	
				// E: process
			}
		}
		
		dao.endTransaction();

		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJSZ110_CHECK", errList);		
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void saveBJSZ119C(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		Map pArg = DataConverter.getMiPlatformData(pReq);
			
		dao.startTransaction(); //tr 시작
		dao.insertData("psimmlib.insertBJSZ119C", null);
		dao.deleteData("psimmlib.deleteBJSZ119C", null);
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  [KA]종합정보/[KA]자재마스터정보/차월자재소요량조회
	 * @exception 
	 * 	- request로 입력받은 데이터셋명을 파리미터에 따라 변경하여 데이터셋명을 리턴한다.
	 * @see
	 * 	- 2018-02-12	:	JHB
	***********************************************************************/ 	
	public void selectBZZZ900Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		dao.startTransaction(); //tr 시작
		//1. BOM파일 작업
		dao.deleteData("psimmlib.dropBZZZ900Q_A", null);
		dao.insertData("psimmlib.insertBZZZ900Q_B", null);
		dao.insertData("psimmlib.insertBZZZ900Q_C", null);
		//2.Purchase Price MA 최종단가생성
		dao.deleteData("psimmlib.deleteBZZZ900Q_SUB", pData);
		dao.insertData("psimmlib.insertBZZZ900Q_SUB", pData);
		dao.endTransaction(); //commit
				
		List list = dao.getListData("psimmlib.selectBZZZ900Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZZZ900Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  자재관리/단가소급/단가소급처리 대상품번업로드
	 * @exception 
	 * 	- request로 입력받은 데이터셋명을 파리미터에 따라 변경하여 데이터셋명을 리턴한다.
	 * @see
	 * 	- 2018-04-26	:	JHB
	***********************************************************************/ 		
	public void saveBIDC251UC(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_BIDC251UC");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String empty1="";

		dao.startTransaction(); //tr 시작				
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("ADDID", (String)pArg.get("ADDID"));
			empty1 = (String) pData.get("SGJNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (empty1 != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psimmlib.selectBIDC251UC_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(이미등록된 자료)
							HashMap errMap = new HashMap();
							errMap.put("SGJNO", pData.get("SGJNO"));
							errMap.put("SGVND", pData.get("SGVND"));
							errMap.put("SGPNO", pData.get("SGPNO"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							//전표저장
							dao.insertData("psimmlib.insertBIDC251", pData);
						}
					}
				}
			}
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_BIDC251_CHECK", errList);//추가
		//new MiPlatformView().render(null, request, response);
		new MiPlatformView().render(map, request, response);	
	}
}