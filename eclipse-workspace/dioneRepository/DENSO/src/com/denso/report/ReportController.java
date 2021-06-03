package com.denso.report;

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

public class ReportController extends MultiActionController {

	CommonDAO dao = CommonDAO.getInstance(1);	

	public void selectReport01(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);		
		Map guserInfo =(Map)session.getAttribute("userInfo");
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	

		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("report.selectReport01", pData);
		//마이플랫폼으로 전송.			
		ModelMap map = new ModelMap();
		map.addAttribute("ds_report", list);

		new MiPlatformView().render(map, request, response);		
	}
	
	public void selectReport02(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);		
		Map guserInfo =(Map)session.getAttribute("userInfo");
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	

		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("report.selectReport02", pData);
		//마이플랫폼으로 전송.			
		ModelMap map = new ModelMap();
		map.addAttribute("ds_report", list);

		new MiPlatformView().render(map, request, response);		
	}
	
	public void selectReport02_1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);		
		Map guserInfo =(Map)session.getAttribute("userInfo");
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	

		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		String [] tableArr = {"HMD150PF","HMD160PF","HMD170PF","HMD180PF","HMD190PF","HMD200PF","HMD210PF","HMD250PF"};
		List list = null;
		ModelMap map = new ModelMap();
		for(String table:tableArr){
			pData.put("TABLE", table);
			list = dao.getListData("report.selectReport02_1", pData);
			map.addAttribute("ds_"+table, list);			
		}	
		list = dao.getListData("report.selectReport02_2", pData);
		map.addAttribute("ds_HMD230PF", list);
		
		int lastBsdat = dao.getIntValue("report.selectReport02_3", pData);
		map.addAttribute("lastBsdat", ""+lastBsdat);
		
		//마이플랫폼으로 전송.
		new MiPlatformView().render(map, request, response);		
	}
	
	public void selectReport03(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);		
		Map guserInfo =(Map)session.getAttribute("userInfo");
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	

		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("report.selectReport03", pData);		
		List list1 = dao.getListData("report.selectReport03_1");	//공급자정보
		//마이플랫폼으로 전송.			
		ModelMap map = new ModelMap();
		map.addAttribute("ds_report", list);
		map.addAttribute("ds_provider", list1);

		new MiPlatformView().render(map, request, response);		
	}
	
	public void selectReport04(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);		
		Map guserInfo =(Map)session.getAttribute("userInfo");
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	

		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("report.selectReport04", pData);
		
		Iterator it = list.iterator();
		double totalPrice = 0;
		while(it.hasNext()){
			Map map = (Map)it.next();
			double silPrice = Double.parseDouble(""+map.get("SIL_PRICE"));
			totalPrice +=silPrice;
		}
		it = list.iterator();
		while(it.hasNext()){
			Map map = (Map)it.next();
			double silPrice = Double.parseDouble(""+map.get("SIL_PRICE"));
			double pricePer = silPrice /totalPrice * 100;			
			pricePer = Double.parseDouble(String.format("%.2f", pricePer));
			map.put("PRT_PRICE", ""+Math.round(Double.parseDouble(""+map.get("PRT_PRICE"))));
			map.put("SIL_PRICE", ""+Math.round(Double.parseDouble(""+map.get("SIL_PRICE"))));			
			map.put("PRICE_PER", pricePer);
		}		
		
		//마이플랫폼으로 전송.			
		ModelMap map = new ModelMap();
		map.addAttribute("ds_report", list);

		new MiPlatformView().render(map, request, response);		
	}
	
	public void selectReport05(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);		
		Map guserInfo =(Map)session.getAttribute("userInfo");
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	

		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("report.selectReport05", pData);
		//마이플랫폼으로 전송.			
		ModelMap map = new ModelMap();
		map.addAttribute("ds_report", list);

		new MiPlatformView().render(map, request, response);		
	}

}
