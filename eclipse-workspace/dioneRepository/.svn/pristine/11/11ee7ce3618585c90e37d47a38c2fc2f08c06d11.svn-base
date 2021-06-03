package com.denso.pscstlib;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.denso.common.converter.DataConverter;
import com.denso.common.converter.MiPlatformView;
import com.denso.common.dao.CommonDAO;
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


public class PscstlibController extends MultiActionController {
	
	CommonDAO dao = CommonDAO.getInstance(1);	
	protected Log log = LogFactory.getLog(this.getClass());

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  생산관리/마스터관리/MAN,MACHINE HOUR MODFY
	 * @exception 
	 * @see 
	 * 	- 2013-07-01	:	제환복
	***********************************************************************/ 		
	public void selectCZZZ100(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscstlib.selectCZZZ100", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CZZZ100", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveCZZZ100(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CZZZ100");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		String rowType="";
		String emptyPRTNO="";
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			emptyPRTNO = (String) pData.get("PRTNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPRTNO != "") {
				if ("update".equals(rowType)) {			
					Map CheckCnt = (Map)dao.getReadData("pscstlib.selectCZZZ100_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PRTNO", pData.get("PRTNO"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("pscstlib.updateCZZZ100", pData);
						}	
					}
				}
			}
		}     
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_CZZZ100_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  자재관리/소요량관리/년 재료비 현황
	 * @exception 
	 * @see 
	 * 	- 2013-12-01	:	lsk
	***********************************************************************/ 		
	public void selectCYJC101Q_XX(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscstlib.selectCYJC101Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CYJC101Q", list);
		new MiPlatformView().render(map, request, response);
	}
	// 2019.07.15 JHB 수정 - 속도저하  4.46분 - UI에서 처리하도록 수정
	public void selectCYJC101Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscstlib.selectCYJC101Q", pData);
		List list2 = dao.getListData("pscstlib.selectCYJC101Q_PRICE", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CYJC101Q_LIST", list);
		map.addAttribute("ds_CYJC101Q_PRICE", list2);

		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  년판매계획대 예정원가현황
	 * @exception 
	 * @see 
	 * 	- 2014-12-01	:	lsk
	***********************************************************************/ 		
	public void selectCJJZ530Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscstlib.selectCJJZ530Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CJJZ530Q", list);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  년판매계획대 재료비 현황
	 * @exception 
	 * @see 
	 * 	- 2014-12-01	:	lsk
	***********************************************************************/ 		
	public void selectCJJZ501Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscstlib.selectCJJZ501Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CJJZ501Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  월 생산실적대 재료비현황
	 * @exception 
	 * @see 
	 * 	- 2014-12-01	:	lsk
	***********************************************************************/ 		
	public void selectCJJZ741Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		if(pData.get("SELGB").equals("1")){
			if(pData.get("QTYGB").equals("A")){
				List list1 = dao.getListData("pscstlib.selectCJJZ741Q_1", pData);
				ModelMap map = new ModelMap();
				map.addAttribute("ds_CJJZ741Q", list1);
				new MiPlatformView().render(map, request, response);
			}
			if(pData.get("QTYGB").equals("B")){
				List list1 = dao.getListData("pscstlib.selectCJJZ741Q_A", pData);
				ModelMap map = new ModelMap();
				map.addAttribute("ds_CJJZ741Q", list1);
				new MiPlatformView().render(map, request, response);
			}
		}
		if(pData.get("SELGB").equals("2")){
			if(pData.get("QTYGB").equals("A")){
				List list1 = dao.getListData("pscstlib.selectCJJZ741Q_2", pData);
				ModelMap map = new ModelMap();
				map.addAttribute("ds_CJJZ741Q", list1);
				new MiPlatformView().render(map, request, response);
			}
			if(pData.get("QTYGB").equals("B")){
				List list1 = dao.getListData("pscstlib.selectCJJZ741Q_B", pData);
				ModelMap map = new ModelMap();
				map.addAttribute("ds_CJJZ741Q", list1);
				new MiPlatformView().render(map, request, response);
			}
		}
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  Standard Cost History 현황
	 * @exception 
	 * @see 
	 * 	- 2015-06-04	:	lsk
	***********************************************************************/ 		
	public void selectCJJZ301Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String querySTEP = (String) pData.get("STEP");
		List list = dao.getListData("pscstlib.selectCJJZ301Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CJJZ301Q_"+querySTEP, list);
		new MiPlatformView().render(map, request, response);
	}
}