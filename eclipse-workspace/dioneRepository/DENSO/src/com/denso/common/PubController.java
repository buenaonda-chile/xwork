package com.denso.common;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.denso.common.converter.DataConverter;
import com.denso.common.converter.MiPlatformView;
import com.denso.common.dao.CommonDAO;
import com.tobesoft.platform.PlatformRequest;

public class PubController extends MultiActionController  {
	private CommonDAO dao;
	public void setDao(CommonDAO dao) {
		this.dao = dao;
	}

	public void media_item(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		System.out.println(pData.toString());
		List list = dao.getListData("pub.media_item", pData);
		System.out.println(list);
		//마이플랫폼으로 전송.
		ModelMap map = new ModelMap();
		map.addAttribute("G_ds_code", list);

		
		new MiPlatformView().render(map, request, response);
	}

	
}
