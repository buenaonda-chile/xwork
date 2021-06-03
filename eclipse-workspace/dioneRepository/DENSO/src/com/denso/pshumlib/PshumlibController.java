/********************************************************************** 
 * @version              		 			: 1.0 
 * @author               		 			: 황규철
 * @see 
 * ● SYSTEM NAME          			: DIONE
 * ● PROGRAM NO.          			: SampleController.java
 * ● PROGRAM DESCRIPTION  	: 샘플페이지 처리 컨트롤러
 * ● DATE WRITTEN        				: 2010.11.26
 ********************************************************************** 
 * ● REVISION HISTORY
 * ● 2010.11.10							:  황규철
 */ 
package com.denso.pshumlib;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
//import java.text.*;
//import java.util.*;

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
import com.ibatis.common.jdbc.SimpleDataSource;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;


//파일 입출력을 위한 패키지
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
//한글 출력을 위한 패키지
import java.net.URLDecoder;
//쿠키사용을 위한 패키지
import javax.servlet.http.Cookie;
//로그출력을 위한 패키지
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PshumlibController extends MultiActionController {

	CommonDAO dao = CommonDAO.getInstance(1);		

	protected Log log = LogFactory.getLog(this.getClass());
	
	public void selectGateAccessData(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		dao = CommonDAO.getInstance(5);
		
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectGateAccessData", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_MAIN", list);
		new MiPlatformView().render(map, request, response);
		
		dao = CommonDAO.getInstance(1);			
	}	

	public void selectInOutTime(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectINOUT_TIME", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_MAIN", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectHPIF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHPIF", pData);				
		ModelMap map = new ModelMap();
		map.addAttribute("DS_MAIN", list);
		new MiPlatformView().render(map, request, response);
	}
		
	public void selectHAY201_B(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY201_B", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_HAY201_B", list);
		new MiPlatformView().render(map, request, response);
	}		
	
	public void selectHAY201_B_MAGAM(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY201_B_MAGAM", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_HAY201_B", list);
		new MiPlatformView().render(map, request, response);
	}	
	public void selectHAY201_XJOB_CNT(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY201_XJOB_CNT", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_HAY201_XJOB_CNT", list);
		new MiPlatformView().render(map, request, response);
	}		
	
	public void selectHAY201_XJOB_CNT_MAGAM(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY201_XJOB_CNT_MAGAM", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_HAY201_XJOB_CNT", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectHAY201_C(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY201_C", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_HAY201_C", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHAY201_C_MAGAM(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY201_C_MAGAM", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_HAY201_C_MAGAM", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectHAY201_C_XJOB(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY201_C_XJOB", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_HAY201_C_XJOB", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectHAY201_C_MASTER(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY201_C_MASTER", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_HAY201_C_MASTER", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHAY201_E(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY201_E", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_HAY201_E", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	public void selectHAY201_F(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY201_F", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_HAY201_F", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  인사급여/인원관리현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-30	:	김재복
	***********************************************************************/ 	
	public void selectHMS000Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMS000Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMS000Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 급여 명세서
	 * @exception 
	 * @see 
	 * 	- 2013-08-30	:	민명규
	***********************************************************************/ 
	public void selectHTME04Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHTME04Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HTME04Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHPC030PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHPC030PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HPC030PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHPC010PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHPC010PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HPC010PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHTME04_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHTME04_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HTME04Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHPC030PF_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHPC030PF_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HPC030PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHPC010PF_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHPC010PF_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HPC010PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHASS01(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS01", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS01", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHASS01_dept(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS01_dept", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS01_dept", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHASS02(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS02", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS02", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHASS02_TAB1(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS02_TAB1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS02_TAB1", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHASS02_TAB2(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS02_TAB2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS02_TAB2", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHASS02_TAB3(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS02_TAB3", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS02_TAB3", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHASS02_TAB4(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS02_TAB4", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS02_TAB4", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHASS02_TAB5(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS02_TAB5", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS02_TAB5", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHASS02_TAB6(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS02_TAB6", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS02_TAB6", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHASS02_TAB7(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS02_TAB7", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS02_TAB7", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHASS02_TAB8(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS02_TAB8", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS02_TAB8", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHASS02_TAB9(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS02_TAB9", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS02_TAB9", list);
		new MiPlatformView().render(map, request, response);
	}
		
	public void selectHASS02_TAB10(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS02_TAB10", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS02_TAB10", list);
		new MiPlatformView().render(map, request, response);
	}
		
	public void selectHASS02_TAB11(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS02_TAB11", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS02_TAB11", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHASS02_TAB12(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS02_TAB12", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HASS02_TAB12", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHPM100_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHPM100_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HPM100_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHPM100_rep_insa(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHPM100_rep_insa", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HPM100_rep", list);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  생산관리/작업일보관리/작업일보(현장)관리/부서별트근시간조회(총무)_PE
	 * @exception 
	 * @see 
	 * 	- 2014-01-13	:	제환복
	***********************************************************************/ 
	//특근관리시간
	public void selectHUM020PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHUM020PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HUM020PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHWD075Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHWD075Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HWD075Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  생산관리/작업일보관리/작업일보(현장)관리/월 직접부문가동시간(총무)_PE
	 * @exception 
	 * @see 
	 * 	- 2014-01-13	:	제환복
	***********************************************************************/ 
	public void selectHWB253Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHWB253Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HWB253Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  원천징수영수증
	 * @exception 
	 * @see 
	 * 	- 2014-02-10	:	민명규
	***********************************************************************/ 
/*
	public void selectHAY081(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY081", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAY081", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHAY021(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY021", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAY021", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHAY200(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY200", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAY200", list);
		new MiPlatformView().render(map, request, response);
	}

	public void selectHAY081_1(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY081_1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAY081", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHAY021_1(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY021_1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAY021", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHAY200_1(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAY200_1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAY200", list);
		new MiPlatformView().render(map, request, response);
	}
*/	
	public void selectHMD020_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMD020_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD020_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHMD160_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMD160_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD160_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHMD150_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMD150_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD150_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHMD170_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMD170_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD170_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHMD180_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMD180_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD180_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHMD200_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMD200_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD200_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHMD230_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMD230_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD230_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHMD190_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMD190_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD190_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHMD220_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMD220_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD220_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHMD260_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMD260_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD260_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHMD270_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMD270_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD270_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHPC200_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHPC200_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HPC200_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHMP100(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMP100", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMP100", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectCode1(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectCODE1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Code1", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectCode2(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectCODE2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Code2", list);
		new MiPlatformView().render(map, request, response);
	}
	/*
	public void selectNewGateAccessData(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		dao = CommonDAO.getInstance(6);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectNewGateAccessData", pData);

		dao = CommonDAO.getInstance(1);

		Iterator it = list.iterator();
		dao.startTransaction(); //tr 시작
		while (it.hasNext()) {
			Map sData = (Map) it.next();
			
			String YYMMDD = sData.get("ACKTIME").toString().substring(0, 8);
			String HHMMSS = sData.get("ACKTIME").toString().substring(8, 10) + ":";
			HHMMSS += sData.get("ACKTIME").toString().substring(10, 12) + ":";
			HHMMSS += sData.get("ACKTIME").toString().substring(12, 14);
			
			String Flag = sData.get("FLAG1").toString();
			
			if(Flag.equals("4")){
				Flag = "6";			
			}else if(Flag.equals("1")){
				Flag = "1";			
			}
						
			String IDNBR = sData.get("SABUN").toString();
			Integer SABUNLEN = IDNBR.length();
				
			if(SABUNLEN == 1){
				IDNBR = "00000" + IDNBR;
			}else if(SABUNLEN == 2){
				IDNBR = "0000" + IDNBR;
			}else if(SABUNLEN == 3){
				IDNBR = "000" + IDNBR;
			}else if(SABUNLEN == 4){
				IDNBR = "00" + IDNBR;
			}else if(SABUNLEN == 5){
				IDNBR = "0" + IDNBR;
			}else{
				IDNBR = IDNBR;
			}			
			
			sData.put("IDNBR", IDNBR);			
			sData.put("TRF02", YYMMDD);
			sData.put("TRF03", HHMMSS);			
			sData.put("TRF06", Flag);
					
			Map CheckCnt = (Map)dao.getReadData("pshumlib.selectNewGateAccessData_Check",sData);
			if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
				if(CheckCnt.get("CNT").equals(1)){
					//DELETE 후 INSERT
					dao.deleteData("pshumlib.deleteNewGateAccessData", sData);
					dao.insertData("pshumlib.insertNewGateAccessData", sData);
				}else{
					dao.insertData("pshumlib.insertNewGateAccessData", sData);
				}
			}			
		}
		dao.endTransaction(); //commit
		
		//ModelMap map = new ModelMap();
		//map.addAttribute("DS_MAIN", list);	
		new MiPlatformView().render(null, request, response);
		
	}	
*/
public void selectNewGateAccessData(HttpServletRequest request, HttpServletResponse response) throws Exception {	
	
	dao = CommonDAO.getInstance(6);	//KE gate svr connection 연결
	PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
	pReq.receiveData();
	Map pData = DataConverter.getMiPlatformData(pReq);
	List list = dao.getListData("pshumlib.selectNewGateAccessData", pData);//gate서버 근태조회
	ModelMap map = new ModelMap();
	map.addAttribute("ds_GATE01", list);//data set에 근태저장
	new MiPlatformView().render(map, request, response);
	dao = CommonDAO.getInstance(1); //cimga connection연결
}/*
public void saveNewGateAccessData(HttpServletRequest request, HttpServletResponse response) throws Exception {	
	
	dao = CommonDAO.getInstance(7);
	PlatformRequest pReq = new PlatformRequest(request);
	pReq.receiveData();
	List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_GATE01");
	Map pArg = DataConverter.getMiPlatformData(pReq);
	
	Iterator it = pList.iterator();
	dao.startTransaction(); //tr 시작
	while (it.hasNext()) {
		Map sData = (Map) it.next();
		
		String YYMMDD = sData.get("ACKTIME").toString().substring(0, 8);
		String HHMMSS = sData.get("ACKTIME").toString().substring(8, 10) + ":";
		HHMMSS += sData.get("ACKTIME").toString().substring(10, 12) + ":";
		HHMMSS += sData.get("ACKTIME").toString().substring(12, 14);
		
		String Flag = sData.get("FLAG1").toString();
		
		if(Flag.equals("4")){
			Flag = "6";			
		}else if(Flag.equals("1")){
			Flag = "1";			
		}
					
		String IDNBR = sData.get("SABUN").toString();
		Integer SABUNLEN = IDNBR.length();
			
		if(SABUNLEN == 1){
			IDNBR = "00000" + IDNBR;
		}else if(SABUNLEN == 2){
			IDNBR = "0000" + IDNBR;
		}else if(SABUNLEN == 3){
			IDNBR = "000" + IDNBR;
		}else if(SABUNLEN == 4){
			IDNBR = "00" + IDNBR;
		}else if(SABUNLEN == 5){
			IDNBR = "0" + IDNBR;
		}else{
			IDNBR = IDNBR;
		}			
		
		sData.put("IDNBR", IDNBR);			
		sData.put("TRF02", YYMMDD);
		sData.put("TRF03", HHMMSS);			
		sData.put("TRF06", Flag);

		Map CheckCnt = (Map)dao.getReadData("pshumlib.selectNewGateAccessData_Check",sData);
		if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
			if(CheckCnt.get("CNT").equals(1)){
				//DELETE 후 INSERT
				dao.deleteData("pshumlib.deleteNewGateAccessData", sData);
				dao.insertData("pshumlib.insertNewGateAccessData", sData);
			}else{
				dao.insertData("pshumlib.insertNewGateAccessData", sData);
			}
		}			
	}
	dao.endTransaction(); //commit
	new MiPlatformView().render(null, request, response);
	dao = CommonDAO.getInstance(7);
}	
*/

//as400으로 근태전송시 connetion pool이용하면 objlock발생하여
//근태사용시 별도의 connetion을 생성하고 근태업로드 후 connetion을 종료함.

public Connection dbConnection() {
    Connection conn = null;
    String url = "jdbc:as400://cigma_db.dnke.kr;translate binary=true";
    String user = "DIONE";
    String password = "DIONEJDBC";
    // 1. Driver 
    try { 
        Class.forName("com.ibm.as400.access.AS400JDBCDriver");
    // 2. Connection DB (URL, ID, P/W)
        conn = DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return conn;
}
//근태자료등록
public void saveNewGateAccessData(HttpServletRequest request, HttpServletResponse response) throws Exception {	
	
	PlatformRequest pReq = new PlatformRequest(request);
	pReq.receiveData();
	List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_GATE01");
	Map pArg = DataConverter.getMiPlatformData(pReq);
	
	Iterator it = pList.iterator();
    Connection conn = dbConnection();
    Statement stmt = null; 
    ResultSet rs = null;
    
	List errList = new ArrayList();//추가
	ArrayList< String > al = new ArrayList< String >(); //arrayList객체생성(SQL저장)
	dao.startTransaction(); //tr 시작
	String eSABUN="";
	int errNm=0;
	try {
		stmt = conn.createStatement();
		String cRst="";
       	
		while (it.hasNext()) {
			Map sData = (Map) it.next();
    		
			String YYMMDD = sData.get("ACKTIME").toString().substring(0, 8);
    		String HHMMSS = sData.get("ACKTIME").toString().substring(8, 10) + ":";
    		HHMMSS += sData.get("ACKTIME").toString().substring(10, 12) + ":";
    		HHMMSS += sData.get("ACKTIME").toString().substring(12, 14);
    		
    		/* 수정 : 2015.07.06  Flag를 UI에서 수정가능하도록 처리
    		String Flag = sData.get("FLAG1").toString();
 
    		if(Flag.equals("4")){
    			Flag = "6";			
    		}else if(Flag.equals("1")){
    			Flag = "1";			
    		}
    		*/

    		String Flag = sData.get("FLAG_NEW").toString();

    		String IDNBR = sData.get("SABUN").toString();
    		String SABUN = sData.get("SABUN").toString();
    		Integer SABUNLEN = IDNBR.length();
    			
    		if(SABUNLEN == 1){
    			IDNBR = "00000" + IDNBR;
    		}else if(SABUNLEN == 2){
    			IDNBR = "0000" + IDNBR;
    		}else if(SABUNLEN == 3){
    			IDNBR = "000" + IDNBR;
    		}else if(SABUNLEN == 4){
    			IDNBR = "00" + IDNBR;
    		}else if(SABUNLEN == 5){
    			IDNBR = "0" + IDNBR;
    		}else{
    			IDNBR = IDNBR;
    		}			
    		//sData.put("IDNBR", IDNBR);			
    		//sData.put("TRF02", YYMMDD);
    		//sData.put("TRF03", HHMMSS);			
    		//sData.put("TRF06", Flag);
    		

    		String sqlSel = "SELECT COUNT(*) CNT FROM PSEDBLIB.HWB032PF WHERE IDNBR = "; // 조회쿼리문		
    		sqlSel = sqlSel + "'"+SABUN+ "' AND TRF02 = '"+YYMMDD +"' AND TRF06 = '"+Flag+"'"; 

    		String sqlDel = "DELETE FROM PSEDBLIB.HWB032PF WHERE IDNBR = "; // 삭제쿼리문		
    		sqlDel = sqlDel + "'"+SABUN+ "' AND TRF02 = '"+YYMMDD +"' AND TRF06 = '"+Flag+"'"; 

    		String sqlIns = "INSERT INTO PSEDBLIB.HWB032PF (IDNBR, TRF01, TRF02, TRF03, TRF04, TRF05, TRF06, TRF07, TRF08, TRF09, TRF10) VALUES ("; // 등록쿼리문		
    		sqlIns = sqlIns + "'"+IDNBR+ "', '0', '"+YYMMDD +"', '" + HHMMSS +"', '', '100', '"+Flag+"', "
    				+ "REPLACE(CHAR(DATE(current date), ISO), '-', ''), REPLACE(CHAR(time(current time), ISO), '.', ':'), '',"
    				+ "REPLACE(CHAR(DATE(current date), ISO), '-', ''))";
    		rs = stmt.executeQuery(sqlSel);
  		//System.out.println(sql);	
    		while (rs.next()) {//기존자료등록여부check
    			cRst=rs.getString("CNT");
    		}
        //System.out.println(cRst);	
	         if(!cRst.equals(0)){//기등록된 자료가 있으면, delete후 insert sql을 al객체에 저장
	        	 al.add(sqlDel);
	        	 al.add(sqlIns);
	         }else{//기존에 등록된 자료가 없으면 insert sql을 al객체에 저장
	        	al.add(sqlIns);
	        }
   		}
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("sql");
	} finally {
		try {
			// resultset 종료
			rs.close();
			// Statement 종료
			for(int i=0; i<al.size(); i++){
			    //System.out.println(al.get(i));
			    errNm=i;
			    stmt.executeUpdate(al.get(i)); //삭제,등록 sql수행
			}
			stmt.close();
			// Connection 종료
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			HashMap errMap = new HashMap();
			errMap.put("RTERR", e.getMessage()+al.get(errNm));
			errMap.put("RTMSG", "처리중오류발생!!");
			errList.add(errMap);
		}
	} 
	dao.endTransaction(); //commit
	ModelMap map = new ModelMap();//추가
	map.addAttribute("ds_ERROR", errList);//추가
	new MiPlatformView().render(map, request, response);
	dao = CommonDAO.getInstance(1); //cimga connection연결
}

/********************************************************************** 
 * @param 
 * 	- HttpServletRequest request			:   데이터셋, 파라미터
 * @return 
 * 	- HttpServletResponse response		:	데이터셋
 * @exception 
 * 	-  인사시스템/인사/일일개인별근태자료(KA)
 * @see
 * 	- 2017-10-27	:	제환복
***********************************************************************/
public void selectGATE02(HttpServletRequest request, HttpServletResponse response) throws Exception {	
	
	PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
	pReq.receiveData();
	Map pData = DataConverter.getMiPlatformData(pReq);
	
	String sComps=(String)pData.get("COMPS");
	if("C1".equals(sComps)){
		//System.out.println(sComps);
		dao = CommonDAO.getInstance(7);	//KAC gate svr connection 연결
	}else{
		//System.out.println(sComps+"8");
		dao = CommonDAO.getInstance(8);	//KAS gate svr connection 연결
	}		
	List list = dao.getListData("pshumlib.selectGATE02", pData);//gate서버 근태조회
	ModelMap map = new ModelMap();
	map.addAttribute("ds_GATE02", list);//data set에 근태저장
	new MiPlatformView().render(map, request, response);
	dao = CommonDAO.getInstance(1); //cimga connection연결
}
/********************************************************************** 
 * @param 
 * 	- HttpServletRequest request			:   데이터셋, 파라미터
 * @return 
 * 	- HttpServletResponse response		:	데이터셋
 * @exception 
 * 	-  KA종합정보/인사화상/교육훈련마스타
 * @see
 * 	- 2014-11-01	:	제환복
***********************************************************************/

public void selectHMDZ200(HttpServletRequest request, HttpServletResponse response) throws Exception {	
	PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
	pReq.receiveData();
	Map pData = DataConverter.getMiPlatformData(pReq);
	List list = dao.getListData("pshumlib.selectHMDZ200", pData);
	ModelMap map = new ModelMap();
	map.addAttribute("ds_HMDZ200", list);
	new MiPlatformView().render(map, request, response);
}

public void saveHMDZ200(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
	PlatformRequest pReq = new PlatformRequest(request);
	pReq.receiveData();
	List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HMDZ200");
	Map pArg = DataConverter.getMiPlatformData(pReq);
	
	List errList = new ArrayList();//추가
	Iterator it_d = pList.iterator();
	Iterator it_iu = pList.iterator();
	String rowType="";
	String emptyPN="";
	//////////////////////////////////////////////////////////////
	// OLD값 처리
	DatasetList in_dl = new DatasetList();
	in_dl = pReq.getDatasetList();
	Dataset ds = in_dl.getDataset("ds_HMDZ200");
	//////////////////////////////////////////////////////////////		
	int bufCnt=0;
	int bufSize=0;	//orginal dataset buffer size
		bufSize=ds.getRowCount();
		System.out.println("originalIndex 확인=="+bufSize);//syso
		
	dao.startTransaction(); //tr 시작		
	while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
		Map pData = (Map) it_d.next();
		pData.put("LIB1", (String)pArg.get("LIB1"));
		pData.put("LIB2", (String)pArg.get("LIB2"));
		pData.put("LIB3", (String)pArg.get("LIB3"));
		emptyPN = (String) pData.get("ESDAT");
		rowType = (String) pData.get("ROW_TYPE");
		if (emptyPN != "") {
			if ("delete".equals(rowType)) {
				/*
				pData.put("OLD_ESDAT", ds.getOrgBuffColumn(0, "ESDAT").getString());
				pData.put("OLD_EEDAT", ds.getOrgBuffColumn(0, "EEDAT").getString());
				pData.put("OLD_EDTCD", ds.getOrgBuffColumn(0, "EDTCD").getString());
				*/
				pData.put("OLD_ESDAT", (String) pData.get("ESDAT"));
				pData.put("OLD_EEDAT", (String) pData.get("EEDAT"));
				pData.put("OLD_EDTCD", (String) pData.get("EDTCD"));
				Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ200_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(CheckCnt.get("CNT").equals(0)){
						//삭제불가(대상이 없음)
						HashMap errMap = new HashMap();
						errMap.put("ESDAT", pData.get("OLD_EEDAT"));
						errMap.put("EEDAT", pData.get("OLD_EEDAT"));
						errMap.put("EDTCD", pData.get("OLD_EDTCD"));
						errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						dao.deleteData("pshumlib.deleteHMDZ200", pData);
					}
				}
			}
		}
	}
	bufCnt=0;
	while (it_iu.hasNext()) {
		Map pData = (Map) it_iu.next();
		pData.put("LIB1", (String)pArg.get("LIB1"));
		pData.put("LIB2", (String)pArg.get("LIB2"));
		pData.put("LIB3", (String)pArg.get("LIB3"));
		emptyPN = (String) pData.get("ESDAT");
		rowType = (String) pData.get("ROW_TYPE");
		if (emptyPN != "") {
			if(bufCnt < bufSize){
				if ("insert".equals(rowType)) {
					pData.put("OLD_ESDAT", (String) pData.get("ESDAT"));
					pData.put("OLD_EEDAT", (String) pData.get("EEDAT"));
					pData.put("OLD_EDTCD", (String) pData.get("EDTCD"));
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ200_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("ESDAT", pData.get("OLD_ESDAT"));
							errMap.put("EEDAT", pData.get("OLD_EEDAT"));
							errMap.put("EDTCD", pData.get("OLD_EDTCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("pshumlib.insertHMDZ200", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					pData.put("OLD_ESDAT", ds.getOrgBuffColumn(bufCnt, "ESDAT").getString());
					pData.put("OLD_EEDAT", ds.getOrgBuffColumn(bufCnt, "EEDAT").getString());
					pData.put("OLD_EDTCD", ds.getOrgBuffColumn(bufCnt, "EDTCD").getString());

					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ200_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("ESDAT", pData.get("OLD_ESDAT"));
							errMap.put("EEDAT", pData.get("OLD_EEDAT"));
							errMap.put("EDTCD", pData.get("OLD_EDTCD"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("pshumlib.updateHMDZ200", pData);
						}
					}
				}
			}
			bufCnt++;
		}       
	}      
	dao.endTransaction(); //commit
	ModelMap map = new ModelMap();//추가
	map.addAttribute("ds_HMDZ200_CHECK", errList);//추가
	new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  KA종합정보/인사화상/인사마스터+부서조회 +DIONE ID
	 * @see
	 * 	- 2014-12-02	:	제환복
	***********************************************************************/

	public void selectDIONEUSER(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectDIONEUSER", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_M_USR_TID", list);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  KA종합정보/인사화상/인사화상권한관리
	 * @see
	 * 	- 2014-11-01	:	제환복
	***********************************************************************/
	
	public void selectHASS04(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHASS04", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HUM090PF", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveHASS04(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HUM090PF");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_HUM090PF");
		//////////////////////////////////////////////////////////////		

		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("INPMN", (String)pArg.get("INPMN"));
			pData.put("CHGMN", (String)pArg.get("CHGMN"));
			pData.put("USER_ID", (String)pData.get("DIOID"));
			emptyPN = (String) pData.get("DIOID");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					pData.put("USER_YN", "0");
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHASS04_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("DIOID", pData.get("DIOID"));
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("KORNM", pData.get("KORNM"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							//dao.deleteData("pshumlib.deleteHASS04", pData);
							dao.updateData("pshumlib.updateHASS04", pData);
							dao.deleteData("user.deleteMenuAuth", pData);				
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("INPMN", (String)pArg.get("INPMN"));
			pData.put("CHGMN", (String)pArg.get("CHGMN"));
			pData.put("USER_ID", (String)pData.get("DIOID"));
			emptyPN = (String) pData.get("DIOID");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHASS04_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("DIOID", pData.get("DIOID"));
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("KORNM", pData.get("KORNM"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("pshumlib.insertHASS04", pData);
							dao.insertData("user.insertMenuAuth", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHASS04_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("DIOID", pData.get("DIOID"));
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("KORNM", pData.get("KORNM"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("pshumlib.updateHASS04", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HUM090PF_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
		}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  종합정보/연말정산/소득정산변동자료 HOST UP
	 * @see
	 * 	- 2015-01-12	:	제환복
	***********************************************************************/
	public void saveHAY011UC(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList1 = DataConverter.getMiPlatformMultiData(pReq, "ds_HAY011PF");
		List pList2 = DataConverter.getMiPlatformMultiData(pReq, "ds_HAY021PF");
		List pList3 = DataConverter.getMiPlatformMultiData(pReq, "ds_HAY041PF");
		//15년도추가(의료비,기부금)
		List pList4 = DataConverter.getMiPlatformMultiData(pReq, "ds_HAY061PF");
		List pList5 = DataConverter.getMiPlatformMultiData(pReq, "ds_HAY063PF");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_iu1 = pList1.iterator();//ds_HAY011PF
		Iterator it_iu2 = pList2.iterator();//ds_HAY021PF
		Iterator it_iu3 = pList3.iterator();//ds_HAY041PF
		Iterator it_iu4 = pList4.iterator();//ds_HAY061PF
		Iterator it_iu5 = pList5.iterator();//ds_HAY063PF
		String rowType="";
		String emptyPN="";
		String emptyBNKCD="";
		String emptyGJBNB="";
		String emptyHOPMON="";
		String emptyKIBMON="";
		
		dao.startTransaction(); //tr 시작
		pArg.put("SABUN", (String)pArg.get("SABUN"));
		dao.deleteData("pshumlib.deleteHAY011UC", pArg);//table삭제
		dao.deleteData("pshumlib.deleteHAY021UC", pArg);//table삭제
		dao.deleteData("pshumlib.deleteHAY041UC", pArg);//table삭제
		dao.deleteData("pshumlib.deleteHAY061UC", pArg);//table삭제
		dao.deleteData("pshumlib.deleteHAY063UC", pArg);//table삭제

		while (it_iu1.hasNext()) {
			Map pData = (Map) it_iu1.next();
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("PTJYM", (String)pArg.get("PTJYM"));
			emptyPN = (String) pData.get("SABUN");
			if (emptyPN != "") {
				dao.insertData("pshumlib.insertHAY011UC", pData);
			}       
		} 
		while (it_iu2.hasNext()) {
			Map pData = (Map) it_iu2.next();
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("PTJYM", (String)pArg.get("PTJYM"));
			emptyPN = (String) pData.get("KORNO");
			if (emptyPN != "") {
				dao.insertData("pshumlib.insertHAY021UC", pData);		 
			} 
		}
		while (it_iu3.hasNext()) {
			Map pData = (Map) it_iu3.next();
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("INCCD");
			emptyBNKCD = (String) pData.get("BNKCD");
			emptyGJBNB = (String) pData.get("GJBNB");
			if (emptyPN != "" && emptyBNKCD != "" && emptyGJBNB != "") {
				dao.insertData("pshumlib.insertHAY041UC", pData);
			}       
		}
		while (it_iu4.hasNext()) {
			Map pData = (Map) it_iu4.next();
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			emptyHOPMON = (String) pData.get("HOPMON");
			System.out.println(pData);
			if (emptyPN != "" && emptyHOPMON != "") {
				dao.insertData("pshumlib.insertHAY061UC", pData);
			}       
		}
		while (it_iu5.hasNext()) {
			Map pData = (Map) it_iu5.next();
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			emptyKIBMON = (String) pData.get("KIBMON");
			if (emptyPN != "" && emptyKIBMON != "") {
				dao.insertData("pshumlib.insertHAY063UC", pData);
			}       
		}
	/*	
		dao.startTransaction(); //tr 시작			
		while (it_iu1.hasNext()) {
			Map pData = (Map) it_iu1.next();
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("PTJYM", (String)pArg.get("PTJYM"));
			emptyPN = (String) pData.get("SABUN");
			//rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAY011UC_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(CheckCnt.get("CNT").equals(1)){
						//DELETE 후 INSERT
						dao.deleteData("pshumlib.deleteHAY011UC", pData);
						dao.insertData("pshumlib.insertHAY011UC", pData);
					}else{
						dao.insertData("pshumlib.insertHAY011UC", pData);
					}
				}				 
			}       
		} 
		while (it_iu2.hasNext()) {
			Map pData = (Map) it_iu2.next();
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("PTJYM", (String)pArg.get("PTJYM"));
			emptyPN = (String) pData.get("KORNO");
			//rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAY021UC_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(!CheckCnt.get("CNT").equals(0)){
						//DELETE 후 INSERT
						dao.deleteData("pshumlib.deleteHAY021UC", pData);
						dao.insertData("pshumlib.insertHAY021UC", pData);
					}else{
						dao.insertData("pshumlib.insertHAY021UC", pData);
					}
				}				 
			} 
		}
	
		while (it_iu3.hasNext()) {
			Map pData = (Map) it_iu3.next();
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("INCCD");
			emptyBNKCD = (String) pData.get("BNKCD");
			emptyGJBNB = (String) pData.get("GJBNB");
			
			//rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "" && emptyBNKCD != "" && emptyGJBNB != "") {
				Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAY041UC_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(!CheckCnt.get("CNT").equals(0)){
						//DELETE 후 INSERT
						dao.deleteData("pshumlib.deleteHAY041UC", pData);
						dao.insertData("pshumlib.insertHAY041UC", pData);
					}else{
						dao.insertData("pshumlib.insertHAY041UC", pData);
					}
				}				 
			}       
		}
*/
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HAY011_Check", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/*
	public void insertHAY011UC(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HAY011PF");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";

		dao.startTransaction(); //tr 시작			
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			//rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAY011UC_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(CheckCnt.get("CNT").equals(1)){
						//DELETE 후 INSERT
						dao.deleteData("pshumlib.deleteHAY011UC", pData);
						dao.insertData("pshumlib.insertHAY011UC", pData);
					}else{
						dao.insertData("pshumlib.insertHAY011UC", pData);
					}
				}				 
			}       
		} 		
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HAY011PF", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	public void insertHAY021UC(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HAY021PF");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";

		dao.startTransaction(); //tr 시작			
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("KORNO");
			//rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAY021UC_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(CheckCnt.get("CNT").equals(1)){
						//DELETE 후 INSERT
						dao.deleteData("pshumlib.deleteHAY021UC", pData);
						dao.insertData("pshumlib.insertHAY021UC", pData);
					}else{
						dao.insertData("pshumlib.insertHAY021UC", pData);
					}
				}				 
			}       
		} 		
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HAY021PF", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	public void insertHAY004UC(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HAY004PF");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		String emptyBNKCD="";
		String emptyGJBNB="";

		dao.startTransaction(); //tr 시작			
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("INCCD");
			emptyBNKCD = (String) pData.get("BNKCD");
			emptyGJBNB = (String) pData.get("GJBNB");
			
			//rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "" && emptyBNKCD != "" && emptyGJBNB != "") {
				Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAY004UC_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(CheckCnt.get("CNT").equals(1)){
						//DELETE 후 INSERT
						dao.deleteData("pshumlib.deleteHAY004UC", pData);
						dao.insertData("pshumlib.insertHAY004UC", pData);
					}else{
						dao.insertData("pshumlib.insertHAY004UC", pData);
					}
				}				 
			}       
		} 		
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HAY004PF", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
*/
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/연말정산/연말정산입력자료 조회
	 * @see
	 * 	- 2017-01-26	:	제환복
	***********************************************************************/
	public void selectHAYZ011Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		/*
		List list1 = dao.getListData("pshumlib.selectHAYZ011Q_A", pData);	//정산자료집계
		List list2 = dao.getListData("pshumlib.selectHAYZ011Q_B", pData);	//부양가족
		List list3 = dao.getListData("pshumlib.selectHAYZ011Q_C", pData);	//연금저축외
		List list4 = dao.getListData("pshumlib.selectHAYZ011Q_D", pData);	//비과세
		List list5 = dao.getListData("pshumlib.selectHAYZ011Q_E", pData);	//노조비
		List list6 = dao.getListData("pshumlib.selectHAYZ011Q_F", pData);	//의료비내역
		List list7 = dao.getListData("pshumlib.selectHAYZ011Q_G", pData);	//기부금
		List list8 = dao.getListData("pshumlib.selectHAYZ011Q_H", pData);	//월세액

		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ011Q_A", list1);
		map.addAttribute("ds_HAYZ011Q_B", list2);
		map.addAttribute("ds_HAYZ011Q_C", list3);
		map.addAttribute("ds_HAYZ011Q_D", list4);
		map.addAttribute("ds_HAYZ011Q_E", list5);
		map.addAttribute("ds_HAYZ011Q_F", list6);
		map.addAttribute("ds_HAYZ011Q_G", list7);
		map.addAttribute("ds_HAYZ011Q_H", list8);
		*/
		List list = dao.getListData("pshumlib."+(String)pData.get("p_SQLID"), pData);
		ModelMap map = new ModelMap();
		map.addAttribute((String)pData.get("p_DATASET"), list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/연말정산/소득정산변동자료 등록
	 * @see
	 * 	- 2015-01-06	:	제환복
	***********************************************************************/
	public void selectPCODE(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectPCODE", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_PCODE", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectHAYZ011(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String Flag;
/*
		Flag = (String)pData.get("BTNFLAG");
		List list1 = dao.getListData("pshumlib.selectHAYZ011_HAY011", pData);
		List list2 = dao.getListData("pshumlib.selectHAYZ011_HAY021", pData);		
		List list3 = dao.getListData("pshumlib.selectHAYZ011_HAY041", pData);
		if(Flag.equals("Search")){
			if(!list1.isEmpty()){
				list2.clear();
				list3.clear();
			}
		}
*/
		Flag = (String)pData.get("BTNFLAG");
		List list1 = null;
		List list2 = null;
		List list3 = null;
		if(Flag.equals("Search")){
			list1 = dao.getListData("pshumlib.selectHAYZ011_HAY011", pData);
			if(!list1.isEmpty()){
				list2 = dao.getListData("pshumlib.selectHAYZ011_HAY021", pData);		
				list3 = dao.getListData("pshumlib.selectHAYZ011_HAY041", pData);
			}else{
				list2=list1;//초기화
				list3=list1;//초기화
			}
		}
		else if(Flag.equals("Input")){
			list1 = dao.getListData("pshumlib.selectHAYZ011_HAY011", pData);
			list2 = dao.getListData("pshumlib.selectHAYZ011_HAY021", pData);		
			list3 = dao.getListData("pshumlib.selectHAYZ011_HAY041", pData);
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ011_HAY011PF", list1);
		map.addAttribute("ds_HAYZ011_HAY021PF", list2);
		map.addAttribute("ds_HAYZ011_HAY041PF", list3);
		new MiPlatformView().render(map, request, response);
	}
	public void saveHAYZ011(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList1 = DataConverter.getMiPlatformMultiData(pReq, "ds_HAYZ011_HAY011PF");
		List pList2 = DataConverter.getMiPlatformMultiData(pReq, "ds_HAYZ011_HAY021PF");
		List pList3 = DataConverter.getMiPlatformMultiData(pReq, "ds_HAYZ011_HAY041PF");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();
		Iterator it_d1 = pList1.iterator();//ds_HAYZ011_HAY011PF
		Iterator it_d2 = pList2.iterator();//ds_HAYZ011_HAY021PF
		Iterator it_d3 = pList3.iterator();//ds_HAYZ011_HAY041PF
		Iterator it_iu1 = pList1.iterator();//ds_HAYZ011_HAY011PF
		Iterator it_iu2 = pList2.iterator();//ds_HAYZ011_HAY021PF
		Iterator it_iu3 = pList3.iterator();//ds_HAYZ011_HAY041PF
		String rowType="";
		String emptyPN="";
		String emptyBNKCD="";
		String emptyGJBNB="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds1 = in_dl.getDataset("ds_HAYZ011_HAY011PF");
		Dataset ds2 = in_dl.getDataset("ds_HAYZ011_HAY021PF");
		Dataset ds3 = in_dl.getDataset("ds_HAYZ011_HAY041PF");
		//////////////////////////////////////////////////////////////		

		dao.startTransaction(); //tr 시작
		//소득공제신고서 HAY011PF
		while (it_d1.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d1.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ011_HAY011_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MENU", "소득공제신고서");
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("pshumlib.deleteHAYZ011_HAY011", pData);
						}
					}
				}
			}
		}
		while (it_iu1.hasNext()) {
			Map pData = (Map) it_iu1.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ011_HAY011_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("MENU", "소득공제신고서");
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("pshumlib.insertHAYZ011_HAY011", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ011_HAY011_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MENU", "소득공제신고서");
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("pshumlib.updateHAYZ011_HAY011", pData);
						}
					}
				}				
			}       
		}
		//부양가족 HAY021PF
		while (it_d2.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d2.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			emptyPN = (String) pData.get("KORNO");//주민등록번호
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ011_HAY021_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MENU", "부양가족 주민번호 : " + (String)pData.get("KORNO"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("pshumlib.deleteHAYZ011_HAY021", pData);
						}
					}
				}
			}
		}
		while (it_iu2.hasNext()) {
			Map pData = (Map) it_iu2.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			emptyPN = (String) pData.get("KORNO");//주민등록번호
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ011_HAY021_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("MENU", "부양가족 주민번호 : " + (String)pData.get("KORNO"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("pshumlib.insertHAYZ011_HAY021", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ011_HAY021_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MENU", "부양가족 주민번호 : " + (String)pData.get("KORNO"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("pshumlib.updateHAYZ011_HAY021", pData);
						}
					}
				}				
			}       
		}
		//연금저축 HAY041PF
		while (it_d3.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d3.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			emptyPN = (String) pData.get("INCCD");
			emptyBNKCD = (String) pData.get("BNKCD");
			emptyGJBNB = (String) pData.get("GJBNB");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "" && emptyBNKCD != "" && emptyGJBNB != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ011_HAY041_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MENU", "연금저축메뉴 계좌번호 " + (String) pData.get("GJBNB"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("pshumlib.deleteHAYZ011_HAY041", pData);
						}
					}
				}
			}
		}
		while (it_iu3.hasNext()) {
			Map pData = (Map) it_iu3.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			emptyPN = (String) pData.get("INCCD");
			emptyBNKCD = (String) pData.get("BNKCD");
			emptyGJBNB = (String) pData.get("GJBNB");
			
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "" && emptyBNKCD != "" && emptyGJBNB != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ011_HAY041_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("MENU", "연금저축메뉴 계좌번호 " + (String) pData.get("GJBNB"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("pshumlib.insertHAYZ011_HAY041", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ011_HAY041_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MENU", "연금저축메뉴 계좌번호 " + (String) pData.get("GJBNB"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("pshumlib.updateHAYZ011_HAY041", pData);
						}
					}
				}				
			}       
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HAYZ011_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/연말정산/소득정산변동자료생성(퇴사자)
	 * @see
	 * 	- 2017-04-07	:	제환복
	***********************************************************************/
	
	public void saveHAYZ012C(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.startTransaction(); //tr 시작
		dao.deleteData("pshumlib.deleteHAYZ012C_HAY011PF", pArg);//정산 변동자료TX Table삭제
		dao.deleteData("pshumlib.deleteHAYZ012C_HAY071PF", pArg);//정산 집계자료TX Table삭제
		dao.deleteData("pshumlib.deleteHAYZ012C_HAY081PF", pArg);//정산 명세TX Table삭제
		
		List pList = dao.getListData("pshumlib.selectHAYZ012C_HMD020PF", pArg);
		System.out.println(pList.size());
	
		List errList = new ArrayList();
		if(pList.size() > 0){
			dao.insertData("pshumlib.insertHAYZ012C_HAY011PF", pArg);//등록			
		}else{
			HashMap errMap = new HashMap();
			errMap.put("RTMSG", "[알림]처리할 내역이 없습니다.");
			errList.add(errMap);
		}
		dao.endTransaction();	//tr종료
		ModelMap map = new ModelMap();		
		map.addAttribute("ds_HAYZ012C_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/연말정산/정산집계자료수정
	 * @see
	 * 	- 2015-01-13	:	제환복
	***********************************************************************/
	public void selectHAYZ071(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ071", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ071", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveHAYZ071(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HAYZ071");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds1 = in_dl.getDataset("ds_HAYZ071");
		//////////////////////////////////////////////////////////////		

		dao.startTransaction(); //tr 시작
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ071_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							//errMap.put("MENU", "연금저축메뉴 계좌번호 " + (String) pData.get("GJBNB"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("pshumlib.deleteHAYZ071", pData);
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			emptyPN = (String) pData.get("SABUN");
			
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ071_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							//errMap.put("MENU", "연금저축메뉴 계좌번호 " + (String) pData.get("GJBNB"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("pshumlib.insertHAYZ071", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ071_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							//errMap.put("MENU", "연금저축메뉴 계좌번호 " + (String) pData.get("GJBNB"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("pshumlib.updateHAYZ071", pData);
						}
					}
				}				
			}       
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HAYZ071_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/연말정산/정산집계자료생성작업
	 * @see
	 * 	- 2015-01-12	:	제환복
	***********************************************************************/
	public void selectHAY011PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ011_HAY011", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ011PF", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveHAYZ072C(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.startTransaction(); //tr 시작
		dao.deleteData("pshumlib.deleteHAYZ072C", pArg);//table삭제
		List pList = dao.getListData("pshumlib.selectHAYZ072C", pArg);
		Iterator it_iu = pList.iterator();
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			//pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			dao.insertData("pshumlib.insertHAYZ072C", pData);//등록
		}		
		dao.endTransaction();	//tr종료
		ModelMap map = new ModelMap();		
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/연말정산/정산마감전 확인
	 * @see
	 * 	- 2015-01-16	:	제환복
	***********************************************************************/
	public void selectHAYZ081Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ081Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ081Q", list);
		new MiPlatformView().render(map, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/연말정산/정산내역조회
	 * @see
	 * 	- 2015-01-16	:	제환복
	***********************************************************************/
	public void selectHAYZ082Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ082Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ082Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/연말정산/신고자료생성
	 * @see
	 * 	- 2015-01-19	:	제환복
	***********************************************************************/
	public void selectHAYZ201C_C(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ201C_C", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ201C_C", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectHAYZ201C_D(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ201C_D", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ201C_D", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectHAYZ201C_E(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ201C_E", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ201C_E", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectHAYZ201C_F(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ201C_F", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ201C_F", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectHAYZ201C_G(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ201C_G", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ201C_G", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectHMD020PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMD020PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD020PF", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/연말정산/연말정산등록자 조회
	 * @see
	 * 	- 2015-01-29	:	제환복
	***********************************************************************/
	public void selectHAYZ010Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ010Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ010Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/연말정산/연말정산의료비명세서 조회
	 * @see
	 * 	- 2016-01-08	:	제환복
	***********************************************************************/
	public void selectHAYZ061Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ061Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ061Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/연말정산/연말정산기부금명세서 조회
	 * @see
	 * 	- 2016-01-08	:	제환복
	***********************************************************************/
	public void selectHAYZ063Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ063Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ063Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  종합정보/연말정산/월세액자료입력
	 * @see
	 * 	- 2017-02-08	:	제환복
	***********************************************************************/
	public void selectHAYZ051(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1 = dao.getListData("pshumlib.selectHAYZ051", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ051", list1);
		new MiPlatformView().render(map, request, response);
	}
	public void saveHAYZ051(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HAYZ051");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_HAYZ051");
		//////////////////////////////////////////////////////////////
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//syso
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					pData.put("OLD_LSECNT", (String) pData.get("LSECNT"));
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ051_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("LSECNT", pData.get("OLD_LSECNT"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("pshumlib.deleteHAYZ051", pData);
						}
					}
				}
			}
		}
		bufCnt=0;
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if(bufCnt < bufSize){
					System.out.println("bufCnt 확인=="+bufCnt);//syso
					if ("insert".equals(rowType)) {
						pData.put("OLD_LSECNT", (String) pData.get("LSECNT"));
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ051_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(1)){
								//insert 불가(대상이 있음)
								HashMap errMap = new HashMap();
								errMap.put("SABUN", pData.get("SABUN"));
								errMap.put("LSECNT", pData.get("OLD_LSECNT"));
								errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.insertData("pshumlib.insertHAYZ051", pData);
							}
						}
					} else if ("update".equals(rowType)) {
						System.out.println(ds.getOrgBuffColumn(bufCnt, "LSECNT"));
						pData.put("OLD_LSECNT", ds.getOrgBuffColumn(bufCnt, "LSECNT").getString());
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHAYZ051_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(0)){
								//update 불가(대상이 없음)
								HashMap errMap = new HashMap();
								errMap.put("SABUN", pData.get("SABUN"));
								errMap.put("LSECNT", pData.get("OLD_LSECNT"));
								errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.updateData("pshumlib.updateHAYZ051", pData);
							}
						}
					}				
				}
				bufCnt++;
				//System.out.println("bufCnt 합=="+bufCnt);//syso
			}
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HAYZ051_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  종합정보/연말정산/원천징수영수증조회
	 * @see
	 * 	- 2015-01-29	:	제환복
	***********************************************************************/
	public void selectHAYZ082R_1(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1 = dao.getListData("pshumlib.selectHAYZ082R_1", pData);
		//List list2 = dao.getListData("pshumlib.selectHAYZ082R_2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ082R_1", list1);
		//map.addAttribute("ds_HAYZ082R_2", list2);
		new MiPlatformView().render(map, request, response);
	}
	public void selectHAYZ082R_2(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ082R_2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ082R_2", list);
		new MiPlatformView().render(map, request, response);
	}
//JHB 개별pgm
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/연말정산/보수총액신고(의료보험공단기준)
	 * @see
	 * 	- 2015-02-27	:	제환복
	***********************************************************************/
	public void selectHAYZ091Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHAYZ091Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ091Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/연말정산/보수총액신고
	 * @see
	 * 	- 2015-02-27	:	제환복
	***********************************************************************/
	public void selectHAYZ092Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHAYZ092Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ092Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/임단협보수총액
	 * @see
	 * 	- 2016-03-17	:	제환복
	***********************************************************************/
	public void selectHAYZ093Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHAYZ093Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ093Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/임단협보수총액(원천징수)
	 * @see
	 * 	- 2016-05-12	:	제환복
	***********************************************************************/
	public void selectHAYZ095Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHAYZ095Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ095Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/임단협보수총액(OT내역)
	 * @see
	 * 	- 2016-05-12	:	제환복
	***********************************************************************/
	public void selectHAYZ096Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHAYZ096Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ096Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/임단협-재입사일자 조회(퇴직금중간정산)-공통
	 * @see
	 * 	- 2015-07-08	:	제환복
	***********************************************************************/
	public void selectHMDZ001Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1= dao.getListData("pshumlib.selectHMDZ001Q_A", pData);
		List list2= dao.getListData("pshumlib.selectHMDZ001Q_B", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ001Q_A", list1);
		map.addAttribute("ds_HMDZ001Q_B", list2);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/개인별예산코드조회(KE)
	 * @see
	 * 	- 2015-07-08	:	제환복
	***********************************************************************/
	public void selectHMDZ002Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHMDZ002Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ002Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/사원명부조회(KA)
	 * @see
	 * 	- 2015-07-08	:	제환복
	***********************************************************************/
	public void selectHMDZ003Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHMDZ003Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ003Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/은행계좌관리(2계좌)(KA창원)
	 * @see
	 * 	- 2015-07-10	:	제환복
	***********************************************************************/
	public void selectHMDZ023B(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHMDZ023B", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ023B", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveHMDZ023B(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HMDZ023B");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_HMDZ023B");
		//////////////////////////////////////////////////////////////
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ023B_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("pshumlib.deleteHMDZ023B", pData);
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ023B_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("pshumlib.insertHMDZ023B", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ023B_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("pshumlib.updateHMDZ023B", pData);
						}
					}
				}				
			}       
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HMDZ023B_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/경리/기술연구소인건비(KA)
	 * @see
	 * 	- 2015-07-13	:	제환복
	***********************************************************************/
	public void selectHMDZ004Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHMDZ004Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ004Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/결근율조회(KA)
	 * @see
	 * 	- 2015-07-14	:	제환복
	***********************************************************************/
	public void selectHMDZ005Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHMDZ005Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ005Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/급여조회(KA)
	 * @see
	 * 	- 2015-07-14	:	제환복
	***********************************************************************/
	public void selectHMDZ006Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHMDZ006Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ006Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/급여조회(상세)(KA)
	 * @see
	 * 	- 2015-07-14	:	제환복
	***********************************************************************/
	public void selectHMDZ007Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHMDZ007Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ007Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/급여조회(상세)(KE)
	 * @see
	 * 	- 2015-07-17	:	제환복
	***********************************************************************/
	public void selectHMDZ008Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHMDZ008Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ008Q", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectHMDZ010Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHMDZ010Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ010Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/연말정산/연말정산대상자 조회
	 * @see
	 * 	- 2015-07-15	:	제환복
	***********************************************************************/
	public void selectHAYZ009Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAYZ009Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAYZ009Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/년차명세서조회
	 * @see
	 * 	- 2015-07-20	:	제환복
	***********************************************************************/
	public void selectHPMZ100Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHPMZ100Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HPMZ100Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/급여계산명세TX CHECK LIST
	 * @see
	 * 	- 2015-07-16	:	제환복
	***********************************************************************/
	public void selectHPCZ104Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHPCZ104Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HPCZ104Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/직급별개인별급여현황(KA)
	 * @see
	 * 	- 2015-07-22	:	제환복
	***********************************************************************/
	public void selectHMDZ100Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHMDZ100Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ100Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/상여은행별입금명세서(KA)
	 * @see
	 * 	- 2015-07-23	:	제환복
	***********************************************************************/
	public void selectHBMZ101Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHBMZ101Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HBMZ101Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/퇴직금충당기초자료(KE)
	 * @see
	 * 	- 2015-07-21	:	제환복
	***********************************************************************/
	public void selectHMDZ009Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1= dao.getListData("pshumlib.selectHMDZ009Q_A", pData);
		List list2= dao.getListData("pshumlib.selectHMDZ009Q_B", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ009Q_A", list1);
		map.addAttribute("ds_HMDZ009Q_B", list2);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/퇴직금충당기초자료(KA)
	 * @see
	 * 	- 2016-03-16	:	제환복
	***********************************************************************/
	public void selectHMDC009Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1= dao.getListData("pshumlib.selectHMDC009Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDC009Q", list1);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/종업원명부(KA)
	 * @see
	 * 	- 2016-03-22	:	제환복
	***********************************************************************/
	public void selectHMDZ012Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1= dao.getListData("pshumlib.selectHMDZ012Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ012Q", list1);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/입퇴사자명부(KA)
	 * @see
	 * 	- 2016-03-23	:	제환복
	***********************************************************************/
	public void selectHMDZ013Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1= dao.getListData("pshumlib.selectHMDZ013Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ013Q", list1);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/퇴직금추계액산출(KA)
	 * @see
	 * 	- 2016-03-23	:	제환복
	***********************************************************************/
	public void savePDC101C(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1= dao.getListData("pshumlib.selectPDC101C", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_PDC101C", list1);
		new MiPlatformView().render(map, request, response);
	}
	/*
	public void savePDC101C(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		String getTYS="";//TAG
		String getPYS="";//PL
		dao.startTransaction(); //tr 시작
		getTYS=(String) pArg.get("TYS");
		getPYS=(String) pArg.get("PYS");
		
		if(getTYS.equals("Y")){
			System.out.println("TYS");
			dao.updateData("psfaclib.updateFPWS895C_TYS", pArg);
		}
		if(getPYS.equals("Y")){
			System.out.println("PYS");
			dao.updateData("psfaclib.updateFPWS895C_PYS", pArg);
		}
		dao.endTransaction(); //commit
		//ModelMap map = new ModelMap();
		new MiPlatformView().render(null, request, response);
	}
	*/
	/*
	public void savePDC101C(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_PDC101C");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();

		
		dao.startTransaction(); //tr 시작		
		
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HMDZ023B_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	*/
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/인사기록카드 신규
	 * @see
	 * 	- 2016-04-26	:	제환복
	***********************************************************************/	
	public void selectHAEZ02Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHAEZ02Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAEZ02Q", list);
		new MiPlatformView().render(map, request, response);
	}
	//인사기록카드 메인페이지 1.학력사항 2.경력사항 3.자격면허 4.외국어 5.가족사항 6.승진사항
	public void selectHAEZ02Q_Main(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1 = dao.getListData("pshumlib.selectHAEZ02Q_HMD150PF", pData);	//1.학력사항
		List list2 = dao.getListData("pshumlib.selectHAEZ02Q_HMD170PF", pData);	//2.경력사항
		List list3 = dao.getListData("pshumlib.selectHAEZ02Q_HMD180PF", pData);	//3.자격면허
		List list4 = dao.getListData("pshumlib.selectHAEZ02Q_HMD190PF", pData);	//4.외국어
		List list5 = dao.getListData("pshumlib.selectHAEZ02Q_HMD160PF", pData);	//5.가족사항
		List list6 = dao.getListData("pshumlib.selectHAEZ02Q_HMD220PF", pData);	//6.승진사항
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD150PF", list1);
		map.addAttribute("ds_HMD170PF", list2);
		map.addAttribute("ds_HMD180PF", list3);
		map.addAttribute("ds_HMD190PF", list4);
		map.addAttribute("ds_HMD160PF", list5);
		map.addAttribute("ds_HMD220PF", list6);
		new MiPlatformView().render(map, request, response);
	}
/*	//인사기록카드 TAB메뉴
	1.인사발령이력 2.급여정보 3.인사고과 4.교육이수 5.병력사항 6.공상/산재이력
	7.상벌이력 8.해외근무이력  9.학자금지급이력 10.퇴직금중간정산이력*/
	public void selectHAEZ02Q_Tab(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list2 = dao.getListData("pshumlib.selectHAEZ02Q_TAB2", pData);	//1.인사발령이력
		List list3 = dao.getListData("pshumlib.selectHAEZ02Q_TAB3", pData);	//2.급여정보
		List list4 = dao.getListData("pshumlib.selectHAEZ02Q_TAB4", pData);	//3.인사고과
		List list5 = dao.getListData("pshumlib.selectHAEZ02Q_TAB5", pData);	//4.교육이수
		List list6 = dao.getListData("pshumlib.selectHAEZ02Q_TAB6", pData);	//5.병력사항
		List list7 = dao.getListData("pshumlib.selectHAEZ02Q_TAB7", pData);	//6.공상/산재이력
		List list8 = dao.getListData("pshumlib.selectHAEZ02Q_TAB8", pData);	//7.상벌이력
		List list9 = dao.getListData("pshumlib.selectHAEZ02Q_TAB9", pData);	//8.해외근무이력
		List list10 = dao.getListData("pshumlib.selectHAEZ02Q_TAB10", pData);	//9.학자금지급이력
		List list11 = dao.getListData("pshumlib.selectHAEZ02Q_TAB11", pData);	//10.퇴직금중간정산이력
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAEZ02Q_TAB2", list2);
		map.addAttribute("ds_HAEZ02Q_TAB3", list3);
		map.addAttribute("ds_HAEZ02Q_TAB4", list4);
		map.addAttribute("ds_HAEZ02Q_TAB5", list5);
		map.addAttribute("ds_HAEZ02Q_TAB6", list6);
		map.addAttribute("ds_HAEZ02Q_TAB7", list7);
		map.addAttribute("ds_HAEZ02Q_TAB8", list8);
		map.addAttribute("ds_HAEZ02Q_TAB9", list9);
		map.addAttribute("ds_HAEZ02Q_TAB10", list10);
		map.addAttribute("ds_HAEZ02Q_TAB11", list11);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사급여SYSTEM/인사정보/학력 마스타
	 * @see
	 * 	- 2016-06-16	:	제환복
	***********************************************************************/

	public void selectHMDZ150(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMDZ150", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ150", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveHMDZ150(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HMDZ150");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_HMDZ150");
		//////////////////////////////////////////////////////////////
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//syso
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					pData.put("OLD_SCHCD", (String) pData.get("SCHCD"));
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ150_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("SCHCD", pData.get("OLD_SCHCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("pshumlib.deleteHMDZ150", pData);
						}
					}
				}
			}
		}
		bufCnt=0;
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if(bufCnt < bufSize){
					System.out.println("bufCnt 확인=="+bufCnt);//syso
					if ("insert".equals(rowType)) {
						pData.put("OLD_SCHCD", (String) pData.get("SCHCD"));
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ150_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(1)){
								//insert 불가(대상이 있음)
								HashMap errMap = new HashMap();
								errMap.put("SCHCD", pData.get("OLD_SCHCD"));
								errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.insertData("pshumlib.insertHMDZ150", pData);
							}
						}
					} else if ("update".equals(rowType)) {
						pData.put("OLD_SCHCD", ds.getOrgBuffColumn(bufCnt, "SCHCD").getString());
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ150_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(0)){
								//update 불가(대상이 없음)
								HashMap errMap = new HashMap();
								errMap.put("SCHCD", pData.get("OLD_SCHCD"));
								errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.updateData("pshumlib.updateHMDZ150", pData);
							}
						}
					}				
				}
				bufCnt++;
				//System.out.println("bufCnt 합=="+bufCnt);//syso
			}
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HMDZ150_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사급여SYSTEM/인사정보/부양가족 마스타
	 * @see
	 * 	- 2016-05-10	:	제환복
	***********************************************************************/

	public void selectHMDZ160(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMDZ160", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ160", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveHMDZ160(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HMDZ160");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_HMDZ160");
		//////////////////////////////////////////////////////////////
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//syso
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					pData.put("OLD_RELSQ", (String) pData.get("RELSQ"));
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ160_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("ACDAT", pData.get("OLD_RELSQ"));
							errMap.put("RELNM", pData.get("RELNM"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("pshumlib.deleteHMDZ160", pData);
						}
					}
				}
			}
		}
		bufCnt=0;
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if(bufCnt < bufSize){
					System.out.println("bufCnt 확인=="+bufCnt);//syso
					if ("insert".equals(rowType)) {
						pData.put("OLD_RELSQ", (String) pData.get("RELSQ"));
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ160_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(1)){
								//insert 불가(대상이 있음)
								HashMap errMap = new HashMap();
								errMap.put("ACDAT", pData.get("OLD_RELSQ"));
								errMap.put("RELNM", pData.get("RELNM"));
								errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.insertData("pshumlib.insertHMDZ160", pData);
							}
						}
					} else if ("update".equals(rowType)) {
						pData.put("OLD_RELSQ", ds.getOrgBuffColumn(bufCnt, "RELSQ").getString());
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ160_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(0)){
								//update 불가(대상이 없음)
								HashMap errMap = new HashMap();
								errMap.put("ACDAT", pData.get("OLD_RELSQ"));
								errMap.put("RELNM", pData.get("RELNM"));
								errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.updateData("pshumlib.updateHMDZ160", pData);
							}
						}
					}				
				}
				bufCnt++;
				//System.out.println("bufCnt 합=="+bufCnt);//syso
			}
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HMDZ160_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사급여SYSTEM/인사정보/자격사항 마스타
	 * @see
	 * 	- 2016-05-23	:	제환복
	***********************************************************************/

	public void selectHMDZ180(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMDZ180", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ180", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveHMDZ180(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HMDZ180");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_HMDZ180");
		//////////////////////////////////////////////////////////////
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//syso
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					pData.put("OLD_LCSCD", (String) pData.get("LCSCD"));
					pData.put("OLD_LCSCL", (String) pData.get("LCSCL"));
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ180_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("LCSCD", pData.get("OLD_LCSCD"));
							errMap.put("LCSCL", pData.get("OLD_LCSCL"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("pshumlib.deleteHMDZ180", pData);
						}
					}
				}
			}
		}
		bufCnt=0;
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if(bufCnt < bufSize){
					System.out.println("bufCnt 확인=="+bufCnt);//syso
					if ("insert".equals(rowType)) {
						pData.put("OLD_LCSCD", (String) pData.get("LCSCD"));
						pData.put("OLD_LCSCL", (String) pData.get("LCSCL"));
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ180_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(1)){
								//insert 불가(대상이 있음)
								HashMap errMap = new HashMap();
								errMap.put("LCSCD", pData.get("OLD_LCSCD"));
								errMap.put("LCSCL", pData.get("OLD_LCSCL"));
								errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.insertData("pshumlib.insertHMDZ180", pData);
							}
						}
					} else if ("update".equals(rowType)) {
						pData.put("OLD_LCSCD", ds.getOrgBuffColumn(bufCnt, "LCSCD").getString());
						pData.put("OLD_LCSCL", ds.getOrgBuffColumn(bufCnt, "LCSCL").getString());
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ180_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(0)){
								//update 불가(대상이 없음)
								HashMap errMap = new HashMap();
								errMap.put("LCSCD", pData.get("OLD_LCSCD"));
								errMap.put("LCSCL", pData.get("OLD_LCSCL"));
								errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.updateData("pshumlib.updateHMDZ180", pData);
							}
						}
					}				
				}
				bufCnt++;
				//System.out.println("bufCnt 합=="+bufCnt);//syso
			}
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HMDZ180_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사급여SYSTEM/인사정보/외국어취득 마스타
	 * @see
	 * 	- 2016-05-24	:	제환복
	***********************************************************************/

	public void selectHMDZ190(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMDZ190", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ190", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveHMDZ190(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HMDZ190");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_HMDZ190");
		//////////////////////////////////////////////////////////////
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//syso
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					pData.put("OLD_LSDAT", (String) pData.get("LSDAT"));
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ190_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("LSDAT", pData.get("OLD_LSDAT"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("pshumlib.deleteHMDZ190", pData);
						}
					}
				}
			}
		}
		bufCnt=0;
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if(bufCnt < bufSize){
					System.out.println("bufCnt 확인=="+bufCnt);//syso
					if ("insert".equals(rowType)) {
						pData.put("OLD_LSDAT", (String) pData.get("LSDAT"));
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ190_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(1)){
								//insert 불가(대상이 있음)
								HashMap errMap = new HashMap();
								errMap.put("LSDAT", pData.get("OLD_LSDAT"));
								errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.insertData("pshumlib.insertHMDZ190", pData);
							}
						}
					} else if ("update".equals(rowType)) {
						pData.put("OLD_LSDAT", ds.getOrgBuffColumn(bufCnt, "LSDAT").getString());
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ190_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(0)){
								//update 불가(대상이 없음)
								HashMap errMap = new HashMap();
								errMap.put("LSDAT", pData.get("OLD_LSDAT"));
								errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.updateData("pshumlib.updateHMDZ190", pData);
							}
						}
					}				
				}
				bufCnt++;
				//System.out.println("bufCnt 합=="+bufCnt);//syso
			}
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HMDZ190_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사급여SYSTEM/인사정보/산재,공상 마스터
	 * @see
	 * 	- 2016-04-27	:	제환복
	***********************************************************************/

	public void selectHMDZ280(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMDZ280", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ280", list);
		new MiPlatformView().render(map, request, response);
	}

	public void saveHMDZ280(HttpServletRequest request, HttpServletResponse response) throws Exception {	
			
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HMDZ280");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_HMDZ280");
		//////////////////////////////////////////////////////////////
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//syso
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("ACDAT");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					pData.put("OLD_ACCYY", (String) pData.get("ACCYY"));
					pData.put("OLD_ACCCD", (String) pData.get("ACCCD"));
					pData.put("OLD_ACDAT", (String) pData.get("ACDAT"));
					pData.put("OLD_ESDAT", (String) pData.get("ESDAT"));
					pData.put("OLD_EEDAT", (String) pData.get("EEDAT"));
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ280_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("ACDAT", pData.get("OLD_ACDAT"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("pshumlib.deleteHMDZ280", pData);
						}
					}
				}
			}
		}
		bufCnt=0;
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("ACDAT");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if(bufCnt < bufSize){
					if ("insert".equals(rowType)) {
						pData.put("OLD_ACCYY", (String) pData.get("ACCYY"));
						pData.put("OLD_ACCCD", (String) pData.get("ACCCD"));
						pData.put("OLD_ACDAT", (String) pData.get("ACDAT"));
						pData.put("OLD_ESDAT", (String) pData.get("ESDAT"));
						pData.put("OLD_EEDAT", (String) pData.get("EEDAT"));
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ280_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(1)){
								//insert 불가(대상이 있음)
								HashMap errMap = new HashMap();
								errMap.put("ACDAT", pData.get("OLD_ACDAT"));

								errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.insertData("pshumlib.insertHMDZ280", pData);
							}
						}
					} else if ("update".equals(rowType)) {
						pData.put("OLD_ACCYY", ds.getOrgBuffColumn(bufCnt, "ACCYY").getString());
						pData.put("OLD_ACCCD", ds.getOrgBuffColumn(bufCnt, "ACCCD").getString());
						pData.put("OLD_ACDAT", ds.getOrgBuffColumn(bufCnt, "ACDAT").getString());
						pData.put("OLD_ESDAT", ds.getOrgBuffColumn(bufCnt, "ESDAT").getString());
						pData.put("OLD_EEDAT", ds.getOrgBuffColumn(bufCnt, "EEDAT").getString());
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ280_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(0)){
								//update 불가(대상이 없음)
								HashMap errMap = new HashMap();
								errMap.put("ACDAT", pData.get("OLD_ACDAT"));
								errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.updateData("pshumlib.updateHMDZ280", pData);
							}
						}
					}
				}
				bufCnt++;
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HMDZ280_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사급여SYSTEM/인사정보/해외파견마스터
	 * @see
	 * 	- 2016-04-28	:	제환복
	***********************************************************************/

	public void selectHMDZ290(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMDZ290", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ290", list);
		new MiPlatformView().render(map, request, response);
	}

	public void saveHMDZ290(HttpServletRequest request, HttpServletResponse response) throws Exception {	
			
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HMDZ290");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_HMDZ290");
		//////////////////////////////////////////////////////////////		
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//syso
			
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("CFDAT");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					pData.put("OLD_CFDAT", (String) pData.get("CFDAT"));
					pData.put("OLD_ESDAT", (String) pData.get("ESDAT"));
					pData.put("OLD_EEDAT", (String) pData.get("EEDAT"));
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ290_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("CFDAT", pData.get("OLD_CFDAT"));
							errMap.put("ESDAT", pData.get("OLD_ESDAT"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("pshumlib.deleteHMDZ290", pData);
						}
					}
				}
			}
		}
		bufCnt=0;
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("CFDAT");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if(bufCnt < bufSize){
					if ("insert".equals(rowType)) {
						pData.put("OLD_CFDAT", (String) pData.get("CFDAT"));
						pData.put("OLD_ESDAT", (String) pData.get("ESDAT"));
						pData.put("OLD_EEDAT", (String) pData.get("EEDAT"));
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ290_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(1)){
								//insert 불가(대상이 있음)
								HashMap errMap = new HashMap();
								errMap.put("CFDAT", pData.get("OLD_CFDAT"));
								errMap.put("ESDAT", pData.get("OLD_ESDAT"));
								errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.insertData("pshumlib.insertHMDZ290", pData);
							}
						}
					} else if ("update".equals(rowType)) {
						pData.put("OLD_CFDAT", ds.getOrgBuffColumn(bufCnt, "CFDAT").getString());
						pData.put("OLD_ESDAT", ds.getOrgBuffColumn(bufCnt, "ESDAT").getString());
						pData.put("OLD_EEDAT", ds.getOrgBuffColumn(bufCnt, "EEDAT").getString());
						Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ290_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(0)){
								//update 불가(대상이 없음)
								HashMap errMap = new HashMap();
								errMap.put("CFDAT", pData.get("OLD_CFDAT"));
								errMap.put("ESDAT", pData.get("OLD_ESDAT"));
								errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.updateData("pshumlib.updateHMDZ290", pData);
							}
						}
					}
				}
				bufCnt++;
			}       
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HMDZ290_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사급여SYSTEM/인사정보/사원영문명 마스타
	 * @see
	 * 	- 2016-05-04	:	제환복
	***********************************************************************/

	public void selectHMDZ300(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMDZ300", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ300", list);
		new MiPlatformView().render(map, request, response);
	}

	public void saveHMDZ300(HttpServletRequest request, HttpServletResponse response) throws Exception {	
			
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_HMDZ300");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_HMDZ300");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("pshumlib.selectHMDZ300_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							dao.insertData("pshumlib.insertHMDZ300", pData);
						}else{
							dao.deleteData("pshumlib.updateHMDZ300", pData);
						}
					}
				}
			}
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HMDZ300_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사급여SYSTEM/인사정보/보훈&산재 대상자조회
	 * @see
	 * 	- 2016-07-04	:	제환복
	***********************************************************************/

	public void selectHMDZ310Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHMDZ310Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ310Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사급여SYSTEM/인사정보/퇴직금정산이력조회
	 * @see
	 * 	- 2016-06-01	:	제환복
	***********************************************************************/

	public void selectHARZ203Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHARZ203Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HARZ203Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/인사마스터-급여현황
	 * @see
	 * 	- 2016-05-17	:	제환복
	***********************************************************************/
	public void selectHMDZ014Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHMDZ014Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMDZ014Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사급여SYSTEM/인사정보/동호회비 조회
	 * @see
	 * 	- 2016-05-24	:	제환복
	***********************************************************************/

	public void selectHPCZ030Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHPCZ030Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HPCZ030Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사급여/인사정보/관리직 성과급기초자료  HOST UP
	 * @see
	 * 	- 2016-10-18	:	제환복
	***********************************************************************/
	public void selectHBSZ051UC_HBS071(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHBSZ051UC_HBS071", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HBS071PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void saveHBSZ051UC(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList1 = DataConverter.getMiPlatformMultiData(pReq, "ds_HBSZ051UC");
	
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_iu1 = pList1.iterator();//ds_HAY011PF
		String rowType="";
		String emptyPN="";

		dao.startTransaction(); //tr 시작
		//pArg.put("SABUN", (String)pArg.get("SABUN"));
		dao.deleteData("pshumlib.deleteHBSZ051UC_HZM101PF", pArg);//table삭제
		dao.deleteData("pshumlib.deleteHBSZ051UC_HZM100PF", pArg);//table삭제
		dao.deleteData("pshumlib.deleteHBSZ051UC_HBS051PF", pArg);//table삭제


		while (it_iu1.hasNext()) {
			Map pData = (Map) it_iu1.next();
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("PTJYM", (String)pArg.get("PTJYM"));
			pData.put("PTYPE", (String)pArg.get("PTYPE"));
			pData.put("SCODE", (String)pArg.get("SCODE"));
			pData.put("SPDAT", (String)pArg.get("PTJYMD"));
			emptyPN = (String) pData.get("SABUN");
			if (emptyPN != "") {
				dao.insertData("pshumlib.insertHBSZ051UC_HBS051PF", pData);
			} 
		}
		dao.insertData("pshumlib.insertHBSZ051UC_HZM101PF", pArg);
	
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_HBSZ051UC_Check", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사급여/인사정보/관리직 성과급자료생성 체크
	 * @see
	 * 	- 2016-10-18	:	제환복
	***********************************************************************/
	public void selectHBSZ051C_CHK(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pshumlib.selectHBSZ051C_CHK", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HBSZ051C", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  인사시스템/인사/월간개인별근태자료(KE)
	 * @see
	 * 	- 2017-03-24	:	제환복
	***********************************************************************/
	public void selectHWBZ200Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list= dao.getListData("pshumlib.selectHWBZ200Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HWBZ200Q", list);
		new MiPlatformView().render(map, request, response);
	}
}
