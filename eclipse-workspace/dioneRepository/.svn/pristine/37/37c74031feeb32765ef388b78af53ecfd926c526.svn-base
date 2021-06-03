package com.denso.chart;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.denso.common.converter.DataConverter;
import com.denso.common.converter.MiPlatformView;
import com.denso.common.dao.CommonDAO;
import com.denso.common.util.FileUpDown;
import com.denso.common.util.Function;
import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;

public class ChartController extends MultiActionController {

	CommonDAO dao = CommonDAO.getInstance(1);	

	public void selectChart01(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);		
		Map guserInfo =(Map)session.getAttribute("userInfo");
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	

		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("chart.selectChart01", pData);
		//마이플랫폼으로 전송.			
		ModelMap map = new ModelMap();
		map.addAttribute("ds_chart", list);

		new MiPlatformView().render(map, request, response);		
	}
	
	public void selectChart02(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);		
		Map guserInfo =(Map)session.getAttribute("userInfo");
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	

		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list0 = dao.getListData("chart.selectChart02_0", pData);
		List list1 = dao.getListData("chart.selectChart02_1", pData);
		//마이플랫폼으로 전송.			
		ModelMap map = new ModelMap();
		map.addAttribute("ds_chart0", list0);
		map.addAttribute("ds_chart1", list1);

		new MiPlatformView().render(map, request, response);		
	}
	
	public void selectChart03(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);		
		Map guserInfo =(Map)session.getAttribute("userInfo");
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	

		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("chart.selectChart03", pData);
		//마이플랫폼으로 전송.			
		ModelMap map = new ModelMap();
		map.addAttribute("ds_chart", list);

		new MiPlatformView().render(map, request, response);		
	}
	
	public void selectChart04(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);		
		Map guserInfo =(Map)session.getAttribute("userInfo");
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	

		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("chart.selectChart04", pData);
		//마이플랫폼으로 전송.			
		ModelMap map = new ModelMap();
		map.addAttribute("ds_chart", list);

		new MiPlatformView().render(map, request, response);		
	}
	
	public void selectChart05(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);		
		Map guserInfo =(Map)session.getAttribute("userInfo");
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	

		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("chart.selectChart05", pData);
		
		//마이플랫폼으로 전송.			
		ModelMap map = new ModelMap();
		map.addAttribute("ds_chart", list);		

		new MiPlatformView().render(map, request, response);		
	}
}
