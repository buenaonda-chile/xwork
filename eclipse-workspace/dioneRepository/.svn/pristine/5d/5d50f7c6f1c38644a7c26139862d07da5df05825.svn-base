/********************************************************************** 
 * @version              		 			: 1.0 
 * @author               		 			: 황규철
 * @see 
 * ● SYSTEM NAME          			: DIONE
 * ● PROGRAM NO.          			: WorkdayController.java
 * ● PROGRAM DESCRIPTION  	: 근태자료 처리 컨트롤러
 * ● DATE WRITTEN        				: 2010.11.26
 ********************************************************************** 
 * ● REVISION HISTORY
 * ● 2010.11.26							:  황규철
 */ 


package com.denso.workday;

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

public class WorkdayController extends MultiActionController {

	CommonDAO dao = CommonDAO.getInstance(2);	

	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- MS_SQL 자료 조회
	 * 	- 커넥션이 다름
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void selectWorkDay(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		
		HttpSession session = request.getSession(true);		
		Map guserInfo =(Map)session.getAttribute("userInfo");
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		System.out.println("===================================================");
		List list = dao.getListData("workday.selectWorkDay", pData);
		//마이플랫폼으로 전송.			
		ModelMap map = new ModelMap();
		map.addAttribute("ds_main", list);
		new MiPlatformView().render(map, request, response);		
	}
}
