package com.denso.pscomlib;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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


public class PscomlibController extends MultiActionController {
	
	CommonDAO dao = CommonDAO.getInstance(1);	
	protected Log log = LogFactory.getLog(this.getClass());
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
	public void selectMST040(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST040", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST040PF", list);
		new MiPlatformView().render(map, request, response);
	}
	public void updateMST040(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.startTransaction(); //tr 시작
		dao.updateData("pscomlib.updateMST040", pArg);
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);	
	}
	public void insertMST040(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.startTransaction(); //tr 시작
		dao.updateData("pscomlib.insertMST040", pArg);
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);	
	}
	public void saveMST049(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		InetAddress[] local = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
		String ipAddress = local[0].getHostAddress();
		pArg.put("JOBIP", (String)ipAddress);
		
		dao.startTransaction(); //tr 시작
		dao.insertData("pscomlib.insertMST049", pArg);
		dao.endTransaction(); //commit
		
		new MiPlatformView().render(null, request, response);	
	}
	public void selectMST050(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST050", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST050PF", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectSABUN(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSABUN", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HMD020PF", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectMST650(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST650", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST650PF", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectCGMPARMDA(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCGMPARMDA", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CGMPARMDA", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectCGMPARMAA(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCGMPARMAA", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CGMPARMAA", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectCGMPARMKA(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCGMPARMKA", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CGMPARMKA", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectCVTSPY200C0(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCVTSPY200C0", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CVTSPY200C0", list);
		new MiPlatformView().render(map, request, response);
	}
	public void deleteSPY200PF(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("pscomlib.deleteSPY200PF", pData);
		System.out.println(pData);
		new MiPlatformView().render(null, request, response);
	}
	
	public void insertSPYYMPRPF(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//dao.startTransaction();
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_main");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		List deleteList = new ArrayList();
		int rowNum = 1;   //
		
		dao.deleteData("pscomlib.deleteSPYYMPRPF" , pArg);
		
		dao.startTransaction(); //tr 시작
		//dao.startBatch(); //배치작업 준비
		
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("ROWNUM", rowNum);
			pData.put("PYYYY", (String)pArg.get("PYYYY"));
			pData.put("PLNGB", (String)pArg.get("PLNGB"));
			rowType = (String)pData.get("ROW_TYPE");
			if("normal".equals(rowType)){
				dao.insertData("pscomlib.insertSPYYMPRPF" , pData);
			}
			rowNum++;
		}
		//System.out.println("-----------------executeBatch");
		//dao.executeBatch(); //배치작업실행
		System.out.println("-----------------endTransaction");
		dao.endTransaction(); //commit
		
		//FLAG INSERT
		dao.deleteData("pscomlib.deleteCVTSPY200C0" , pArg);
		dao.insertData("pscomlib.insertCVTSPY200C0" , pArg);
		
		new MiPlatformView().render(null, request, response);
		//dao.endTransaction();
	}
	public void insertSPYYMPRPF_PE(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//dao.startTransaction();
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_main_PE");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		List deleteList = new ArrayList();
		int rowNum = 1;   //
		
		dao.deleteData("pscomlib.deleteSPYYMPRPF" , pArg);
		
		dao.startTransaction(); //tr 시작
		//dao.startBatch(); //배치작업 준비
		
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("ROWNUM", rowNum);
			pData.put("PYYYY", (String)pArg.get("PYYYY"));
			pData.put("PLNGB", (String)pArg.get("PLNGB"));
			rowType = (String)pData.get("ROW_TYPE");
			if("normal".equals(rowType)){
				dao.insertData("pscomlib.insertSPYYMPRPF" , pData);
			}
			rowNum++;
		}
		System.out.println("-----------------endTransaction");
		dao.endTransaction(); //commit
		
		//FLAG INSERT
		dao.deleteData("pscomlib.deleteCVTSPY200C0" , pArg);
		dao.insertData("pscomlib.insertCVTSPY200C0" , pArg);
		
		new MiPlatformView().render(null, request, response);
		//dao.endTransaction();
	}
	public void selectCVTSPY200C1(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCVTSPY200C1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CVTSPY200C1", list);
		new MiPlatformView().render(map, request, response);
	}	
	public void updateCVTSPY200C1(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C1");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		List deleteList = new ArrayList();
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("PYYYY", (String)pArg.get("PYYYY"));
			pData.put("PLNGB", (String)pArg.get("PLNGB"));
			rowType = (String)pData.get("ROW_TYPE");
			if("update".equals(rowType)){
				dao.updateData("pscomlib.updateCVTSPY200C1" , pData);
			}
		}
		new MiPlatformView().render(null, request, response);
	}
	public void selectCVTSPY200C2(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCVTSPY200C2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CVTSPY200C2", list);
		new MiPlatformView().render(map, request, response);
	}
	public void updateCVTSPY200C2(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C2");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		List deleteList = new ArrayList();
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("PYYYY", (String)pArg.get("PYYYY"));
			pData.put("PLNGB", (String)pArg.get("PLNGB"));
			rowType = (String)pData.get("ROW_TYPE");
			if("update".equals(rowType)){
				dao.updateData("pscomlib.updateCVTSPY200C2" , pData);
			}
		}
		new MiPlatformView().render(null, request, response);
	}
	public void selectCVTSPY200C3(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCVTSPY200C3", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CVTSPY200C3", list);
		new MiPlatformView().render(map, request, response);
	}
	public void updateCVTSPY200C3(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C3");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		List deleteList = new ArrayList();
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("PYYYY", (String)pArg.get("PYYYY"));
			pData.put("PLNGB", (String)pArg.get("PLNGB"));
			rowType = (String)pData.get("ROW_TYPE");
			if("update".equals(rowType)){
				dao.updateData("pscomlib.updateCVTSPY200C3" , pData);
			}
		}
		new MiPlatformView().render(null, request, response);
	}
	
	public void selectCVTSPY200C5(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCVTSPY200C5", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SPYDSKRPF", list);
		new MiPlatformView().render(map, request, response);
	}

	public void selectCVTSPY200C7(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCVTSPY200C7", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SPY200PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void insertSPYDSKRPF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C2");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.deleteData("pscomlib.deleteSPYDSKRPF" , pData);
		dao.updateData("pscomlib.insertSPYDSKRPF" , pData);
		//FLAG INSERT
		dao.insertData("pscomlib.updateCVTSPY200C0" , pArg);
		new MiPlatformView().render(null, request, response);
	}
	public void updateCVTSPY200C7(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C2");
		Map pData = DataConverter.getMiPlatformData(pReq);
		//FLAG INSERT
		dao.insertData("pscomlib.updateCVTSPY200C7" , pData);
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * 작성자 : LEE SK                                 * 작성일자 : 2012.06.31
	 * 처리내용 : 팝업시 사용
	***********************************************************************/ 	
	public void selectItemMasterPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectItemMaster", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectCustomerMasterPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCustomerMaster", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectCodeMasterPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCodeMaster", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectVendorMasterPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectVendorMaster", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectSaleCusMasterPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSaleCusMaster", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectManagerMasterPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectManagerMaster", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	//제조파트코드조회전용
	public void selectDPARTMasterPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectDPARTMaster", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	//인사마스터 조회
	public void selectINSAMasterPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectINSAMasterPopup", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	//인사마스터 조회(연말정산)
	public void selectINSAMasterPopup2(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectINSAMasterPopup2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	//작업코드 조회
	public void selectJOBCodePopup(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectJOBCodePopup", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	//잔업코드 조회
	public void selectOVERTIMEPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectOVERTIMEPopup", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	//부서 조회
	public void selectDEPARTPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectDEPARTPopup", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	//버스이용지역마스타
	public void selectFHD085PFPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectFHD085PFPopup", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	//작업공정정보마스타
	public void selectMST060PFPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST060PFPopup", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	//보전작업자마스타
	public void selectOBMZ160PFPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectOBMZ160PFPopup", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * 작성자 : LEE SK                                 * 작성일자 : 2012.05.31
	 * 처리내용 : 등록화면 1인 사용
	***********************************************************************/ 	
	public void selectM_MNU_KEY(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectM_MNU_KEY", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_M_MNU_KEY", list);
		new MiPlatformView().render(map, request, response);
	}
	public void insertM_MNU_KEY(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.startTransaction(); //tr 시작
		dao.deleteData("pscomlib.deleteM_MNU_KEY", pArg);
		dao.insertData("pscomlib.insertM_MNU_KEY", pArg);
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);	
	}
	public void deleteM_MNU_KEY(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.startTransaction(); //tr 시작
		dao.deleteData("pscomlib.deleteM_MNU_KEY", pArg);
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);	
	}
	
	/********************************************************************** 
	 * 작성자 : LEE SK                                 * 작성일자 : 2012.05.31
	 * 처리내용 : MRP 공통사용
	***********************************************************************/ 
	/*품명,공장구분,ittyp,itcls, OEM품번 ,  단가,이유,적용일 ,  거래처명 */
	public void selectSAL001(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSAL001", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SAL001", list);
		new MiPlatformView().render(map, request, response);
	}
	/*HKMC VAN 업체코드마스타*/
	public void selectSVM020PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSVM020PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SVM020PF", list);
		new MiPlatformView().render(map, request, response);
	}
	/*중복서열코드마스타 */
	public void selectSVZ080PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSVZ080PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SVZ080PF", list);
		new MiPlatformView().render(map, request, response);
	}
	/*업체서열차종마스타 */
	public void selectSVM100PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSVM100PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SVM100PF", list);
		new MiPlatformView().render(map, request, response);
	}
	/*Item MASTER*/
	public void selectBM008PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectBM008PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BM008PR", list);
		new MiPlatformView().render(map, request, response);
	}
	/*득의선MASTER*/
	public void selectCUSMAS1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCUSMAS1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CUSMAS1", list);
		new MiPlatformView().render(map, request, response);
	}
	/*협력업체MASTER*/
	public void selectVENNAM(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectVENNAM", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_VENNAM", list);
		new MiPlatformView().render(map, request, response);
	}
	/*OEM품번MASTER*/
	public void selectEM000PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectEM000PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_EM000PR", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectEM000PR_CPRTN(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectEM000PR_CPRTN", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_EM000PR", list);
		new MiPlatformView().render(map, request, response);
	}	
	public void selectEM000PR_CUSNO(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectEM000PR_CUSNO", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_EM000PR", list);
		new MiPlatformView().render(map, request, response);
	}
	/*판매단가MASTER*/
	public void selectEM001PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectEM001PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_EM001PR", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectEM001PR_CUSNO(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectEM001PR_CUSNO", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_EM001PR", list);
		new MiPlatformView().render(map, request, response);
	}
//제환복 추가	
	/*OEM품번MASTER*/
	public void selectEM000PR2(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectEM000PR2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_EM000PR", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectEM000PR3(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectEM000PR3", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_EM000PR", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectEM000PR_DETAIL(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectEM000PR_DETAIL", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_EM000PR_DETAIL", list);
		new MiPlatformView().render(map, request, response);
	}		
	/*판매단가MASTER*/
	public void selectEM001PR2(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectEM001PR2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_EM001PR", list);
		new MiPlatformView().render(map, request, response);
	}
	/*판매단가세율마스타*/
	public void selectSMD010PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSMD010PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SMD010PF", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectCGMPARMAA2(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCGMPARMAA2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CGMPARMAA", list);
		new MiPlatformView().render(map, request, response);
	}
//제환복 추가	 끝
	/*SUPPLIED GOODS MASTER*/
	public void selectBM030PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectBM030PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BM030PR", list);
		new MiPlatformView().render(map, request, response);
	}
	/*WAREHOUSE MASTER*/
	public void selectEM035PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectEM035PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_EM035PR", list);
		new MiPlatformView().render(map, request, response);
	}
	/*SUB CONTRACTOR MASTER*/
	public void selectEM040PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectEM040PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_EM040PR", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/*CIGMA일자 */
	public void selectSC000PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSC000PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SC000PR", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/*코드마스타 */
	public void selectMST040PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST040PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST040PF", list);
		new MiPlatformView().render(map, request, response);
	}
	/*코드마스타 HOUSE */
	public void selectMST040PF_HOUSE(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST040PF_HOUSE", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST040PF_HOUSE", list);
		new MiPlatformView().render(map, request, response);
	}
	/*코드마스타 */
	public void selectMST050PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST050PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST050PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/*라인코드 마스타 */
	public void selectMST060PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST060PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST060PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/*달력마스타 (생산코드,급여코드,재무코드)*/
	public void selectMST090PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST090PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST090PF", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectMST090PF_ROW(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST090PF_ROW", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST090PF", list);
		new MiPlatformView().render(map, request, response);
	}	
	public void selectMST091LF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST091LF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST091LF", list);
		new MiPlatformView().render(map, request, response);
	}	
	/*품목마스타 (차종코드,규격코드,제품코드)*/
	public void selectMST100PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST100PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST100PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/*품목식별표마스타 (acl코드,색상코드,라벨발행cd등등)*/
	public void selectMST200PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST200PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST200PF", list);
		new MiPlatformView().render(map, request, response);
	}
	/*거래처마스타 (영업에서 사용하는 운송업체관리 or .....)*/
	public void selectMST600PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST600PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST600PF", list);
		new MiPlatformView().render(map, request, response);
	}
	/*부서마스타 (영업에서 사용하는 Transfer Ticket .....)*/
	public void selectMST652LF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST652LF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST652LF", list);
		new MiPlatformView().render(map, request, response);
	}
	/*코드마스타 (차종명,규격명,제품명)*/
	public void selectMST050100PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST050100PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST050100PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/*SC000PR+SC003PR 오리지날일근거　당월　위치 RETURN*/
	public void selectSC000_003PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSC000_003PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SC000_003PR", list);
		new MiPlatformView().render(map, request, response);
	}
	//제환복추가 13.06.18
	public void selectSC003PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSC003PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SC003PR", list);
		new MiPlatformView().render(map, request, response);
	}	
	public void selectSC003PR_1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSC003PR_1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SC003PR", list);
		new MiPlatformView().render(map, request, response);
	}	
	public void selectSC003PR_2(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSC003PR_2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SC003PR", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectSC000_003PR_F(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List okList = new ArrayList();
		Map checkSC000 = (Map)dao.getReadData("pscomlib.selectSC000_003PR_F",pData);
		String befYMD="";
		String curYM = (String)checkSC000.get("YM").toString();
		String curYMD=(String)checkSC000.get("ADSDT").toString();
		String cd = (String)checkSC000.get("CALCD");
		String v="";
		if(checkSC000.get("FIFYN").equals("Y")){ //현재CIGMA일자가 제일가동일 경우 전월 마지막 가동일을 가지고 온다.
			Calendar cal = Calendar.getInstance();
		    cal.set(Integer.parseInt(curYMD.substring(0,4)),Integer.parseInt(curYMD.substring(4,6))-1,Integer.parseInt(curYMD.substring(6,8)));
			//cal.set(2016,0,13); 
			cal.add(Calendar.MONTH, -1); // 한달을 뺀다. 
		    pData.put("PRMNO", "ABS");
		    String jobyy= cal.get(Calendar.YEAR)+"";
		    String jobmm= Integer.toString((cal.get(Calendar.MONTH)+1));
		    String jobym = jobyy + ("00"+jobmm).substring(("00"+jobmm).length()-2);
			pData.put("YRMON", jobym);
			Map checkSC003 = (Map)dao.getReadData("pscomlib.selectSC003PR",pData);
			String cd003 = (String)checkSC003.get("CALCD");
			int lastindexof = cd003.lastIndexOf("1")+1; // index는 0부터 시작
			v= "00"+Integer.toString(lastindexof);
			befYMD = jobym + (v.substring(v.length()-2)); //현재CIGMA일자의 전일가동일(yymmdd) -> 전월 마지막 가동일
		}else{
			int curdd = Integer.parseInt((String)checkSC000.get("DD")); //현재 CIGMA일자
			
			int befdd = 0;
			int cnt = curdd-1;
			for (int i=cnt; i > 1 ; i--){
				String d = cd.substring(i,i+1);
				if(d.equals("1")){
					befdd = i; //현재CIGMA일자의 전일가동일(dd)
					i=0;
				}
			}
			v= "00"+Integer.toString(befdd);
			befYMD = curYM + (v.substring(v.length()-2)); //현재CIGMA일자의 전일가동일(yymmdd)
		}
		HashMap errMap = new HashMap();
		errMap.put("YMD_CUR",curYMD);
		errMap.put("YMD_BEF",befYMD);
		okList.add(errMap);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SC000_003PR", okList);
		new MiPlatformView().render(map, request, response);
	}
	
	/*제조원가 RETURN*/
	public void selectF_D30PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectF_D30PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_F_D30PR", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/*  RPG(CGMPARMKA)    Inventory Master RETURN */
	public void selectHM000PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectHM000PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HM000PR", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/*Inventory Master RETURN*/
	public void selectSC008PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSC008PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SC008PR", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void createAlias(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.updateData("pscomlib.createAlias", pArg);
		new MiPlatformView().render(null, request, response);	
	}

	public void dropAlias(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.updateData("pscomlib.dropAlias", pArg);
		new MiPlatformView().render(null, request, response);	
	}
	/********************************************************************** 
	 * 작성자 : JAE HB                              * 작성일자 : 2012.10.10
	 * 처리내용 : MRP 공통사용
	***********************************************************************/ 
	/*SYSMEM 날짜가져오기 */
	public void selectSYSDATE(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSYSDATE", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SYSDATE", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectSAL100(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSAL100", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SAL100", list);
		new MiPlatformView().render(map, request, response);
	}

	public void selectSAL100_SE(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSAL100_SE", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SAL100", list);
		new MiPlatformView().render(map, request, response);
	}
	/*	
	public void selectSAL100_SE(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_SPDE141Q_142PF_SUB");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List List = new ArrayList();		
		Iterator it = pList.iterator();
		ModelMap map = new ModelMap();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("PYVND", (String)pArg.get("PYVND"));
			pData.put("MAKDT", (String)pArg.get("MAKDT"));
			pData.put("CHKCNT", (String)pArg.get("CHKCNT"));
			List = dao.getListData("pscomlib.selectSAL100_SE",pData);
			map.addAttribute("ds_SAL100", List);
		}	
		new MiPlatformView().render(map, request, response);
	}
*	
/*	
	//반코드로 팀명가져오기.	
	public void selectMST650_SUB(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMST650_SUB", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST650PF", list);
		new MiPlatformView().render(map, request, response);
	}	
*/	
	/********************************************************************** 
	 * 화면명 : 파일업로드 Controller
	 * 작성자 : 김종진
	 * 작성일자 : 2011.11.10
	 * 처리내용 : 파일업로드(Httpfile 컨포넌트 이용 - 대용량)
	***********************************************************************/ 				
	public void bigFileUload(HttpServletRequest request, HttpServletResponse response) throws Exception {			
	
	log.info("bigFileUload process In");

	String _cookie = null;
    	Cookie theCookie = null;
    	
    	//넘겨받은 request객체에서 Cookie취득
    	Cookie cookies[] = request.getCookies();
    	
    	//취득값 유무
    	if (cookies != null) {
    		//배열로 받은 것을 루프처리
		    for(int i=0, n=cookies.length; i < n; i++) {
		    	
		    	theCookie = cookies[i];
		    	//해당 배열의 이름이 FileParam이라면
		    	if (theCookie.getName().equals("FileParam")) {
		    		
			        try {
			        	//해당배열의 값을 취득(파일명) - decode는 한글표시처리
			        	_cookie = URLDecoder.decode(theCookie.getValue().toString(), "EUC-KR");

			        	
			        
			        } catch (NumberFormatException ignored) {
			        
			        	_cookie = null;
			        }
			        	break;
		      	}
		    }
    	}
        
		log.info("_cookie --->[" + _cookie + "]");
    	
		String rtn_val = "";
    	
		//해당 파일의 데이터를 읽어들일  InputStream 객체 취득
		InputStream _istream = request.getInputStream();
		
		//String filePath = confPath + "/upload/" + _cookie;
		//업로드 할 경로와 파일
		//String filePath = "C:/eclipse/workspace/DENSO/WebContent/upload/" + _cookie;
		String filePath = _cookie;
		
		log.info("filePath --->[" + filePath + "]");	
		
		//읽어들일 데이터를 해당경로에 쓰기 위한 객체 생성 
		OutputStream s = new FileOutputStream(filePath);
		
		//배열객체 생성 
		byte[] buffer = new byte[8192];
		
		while (true) {
			// 데이터 읽기 - 배열(buffer)에 스트리밍객체(_istream)로 부터 읽은 것을 격납
			// 더 이상 데이터가 없다면 0 혹은 마이너스 값을 리턴할 것이라 추측
			int n = _istream.read(buffer);
			
			// 0보다 작거나 같으면 루프 나감
			if (n <= 0) {
				break;
			}
			//데이터 쓰기
			s.write(buffer, 0, n);
		}
		
		//닫기
		s.close();
		
    	theCookie = null;
    	rtn_val = "SUCC::" ;
    	
    	theCookie = new Cookie ("FileParam", rtn_val);
    	response.setContentType("text/html");
    	
    	//response 리턴(처리성공 여부를 이전단계인 JS스크립트 파일로 돌려준다
    	response.addCookie(theCookie);
    	
		log.info("bigFileUload process Out");
		
	}
	
	
	
	
	/********************************************************************** 
	 * 화면명 : 파일다운로드 Controller
	 * 작성자 : 김종진
	 * 작성일자 : 2011.11.21
	 * 처리내용 : 파일다운로드(Httpfile 컨포넌트 이용 - 대용량)
	***********************************************************************/ 				
	public void bigFileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception {			
	
	    log.info("bigFileDownload process In");

	    String _cookie = null;
	    Cookie theCookie = null;
	    Cookie cookies[] = request.getCookies();
	    
	    //파일 업로드 부분 참고 요망
	    if (cookies != null) {
		    for(int i=0, n=cookies.length; i < n; i++) {
		    	theCookie = cookies[i];
		    	if (theCookie.getName().equals("FileParam")) {
			        try {
			        	_cookie = URLDecoder.decode(theCookie.getValue().toString(), "EUC-KR");
			        } catch (NumberFormatException ignored) {
			        	_cookie = null;
			        }
		        	break;
		      	}
		    }
	    }
	    
	    int len;
	    
	    //다운로드 할 대상이 있는 경로(서버- 이미 이 단계는 서버로 넘어온 단계이기에 서버 로컬 경로를 기술)
	    //String filePath = "C:/eclipse/workspace/DENSO/WebContent/upload/" + _cookie;
	    String filePath = _cookie;
	    
	    // 위의 경로로 파일객체 생성
		File file = new File(filePath);
		
		log.info("파일 SIZE:" + file.length());
		log.info("다운로드 할 대상이 있는 경로[" + filePath + "]");

		byte b[] = new byte[4096];
		
	    theCookie = null;
	    String retval = "";
		int bFile;
		
	    log.info("파일존재 유무:" + file.isFile());		
		
	    //파일 존재 체크
		if (file.isFile()){
	    	retval = "SUCC::";
	    	bFile = 1;
		} else {
	    	retval = "FAIL::File Not Found!!";
	    	bFile = 0;
		}
	    theCookie = new Cookie ("FileParam", retval);
	    response.addCookie(theCookie);	
	    
	    if ( bFile == 1 )
	    {	
			response.setContentType("application/octet-stream");
			//out.clearBuffer();

			//입출력을 위한 객체 생성
			BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
			
		    int i = 0;
			int read = 0;
			try {
				//데이터가 없을 때 까지 파일의 데이터 읽기 처리(데이터가 없으면 -1을 반환)
				while ((read = fin.read(b)) != -1){
		  			//읽은 데이터를 쓰기
					outs.write(b,0,read);
		  		
		  			i++;
			}
				
			outs.close();
			fin.close();
			} catch (Exception e) {
			} finally {
				if(outs!=null) outs.close();
				if(fin!=null) fin.close();
			}
		}	
    	
		log.info("bigFileDownload Out");
		
	}
	//제환복추가 마감처리(2013.03.08추가)
	public void saveMST040(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.startTransaction(); //tr 시작
		Map CheckCnt = (Map)dao.getReadData("pscomlib.selectMST040",pArg);
		System.out.print("val==="+CheckCnt);		
		if(CheckCnt!=null){
//System.out.print("업데이트");				
				dao.updateData("pscomlib.updateMST040_fac", pArg);
		}else{
//System.out.print("등록");				
			dao.insertData("pscomlib.insertMST040_fac", pArg);
		}
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);	
	}
	
	/*작업공정Check      RPG(CGMPARMIA)*/
	public void selectBM001PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectBM001PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BM001PR", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/*배수량 LOTSZ, MULTIPLE QUANTITY      RPG(CGMPARMJA)*/
	public void selectBM009PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectBM009PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BM009PR", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/*구매단가MASTER      RPG(CGMPARMZB)*/
	public void selectCM001PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCM001PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CM001PR", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/*수입품코드MASTER      */
	public void selectBUY050PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectBUY050PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BUY050PR", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/*품번별 구매업체 배분율 MASTER      */
	public void selectBM400PR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectBM400PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BM400PR", list);
		new MiPlatformView().render(map, request, response);
	}
	/*mst040pf update TEST용      */
	public void updateMST040_PSDIOLIB(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.startTransaction(); //tr 시작
		dao.updateData("pscomlib.updateMST040_PSDIOLIB", pArg);
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);	
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  DWH FILE 생성 이력조회
	 * @exception 
	 * @see 
	 * 	- 2013-05-10	:	lsk
	***********************************************************************/ 
	public void selectDWHZ000Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectDWHZ000Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_DWHZ000Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  DWH FILE 조회
	 * @exception 
	 * @see 
	 * 	- 2013-05-10	:	lsk
	***********************************************************************/ 
	public void selectDWHXXXXQ(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectDWHXXXXQ", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_DWHXXXXQ", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  시그마일자, 생산계획, 월데이타 순번 RETURN
	 * @exception 
	 * @see 
	 * 	- 2013-09-30	:	jhb
	***********************************************************************/ 
	public void selectCGMPARMHC(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCGMPARMHC", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CGMPARMHC", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception 
	 * @see 
	 * 	- 2013-10-15	:	jhb
	***********************************************************************/ 
	public void selectBM010PR(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectBM010PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BM010PR", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception 
	 * @see 
	 * 	- 2013-12-12	:	jhb
	***********************************************************************/ 
	public void selectBC010PR(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectBC010PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BC010PR", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  환율 조회
	 * @exception 
	 * @see 
	 * 	- 2013-12-10	:	lsk
	***********************************************************************/ 
	public void selectEM006PR(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectEM006PR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_EM006PR", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception 
	 * @see 
	 * 	- 2013-12-12	:	jhb
	***********************************************************************/ 
	public void selectCGMPARMGB(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectCGMPARMGB", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_CGMPARMGB", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception 
	 *  - 사외창고이동　업체마스타 PF
	 * @see 
	 * 	- 2013-12-12	:	jhb
	***********************************************************************/ 
	public void selectBHZ600(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectBHZ600", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BHZ600PF", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception 
	 * @see 
	 * 	- 2014-01-03	:	jhb
	***********************************************************************/ 
	public void selectYJOBCHK(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectYJOBCHK", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_YJOBCHK", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - 사외창고이동　업체마스타 PF
	 * @see 
	 * 	- 2014-01-03	:	jhb
	***********************************************************************/ 
	public void selectXABENDM(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectXABENDM", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_XABENDM", list);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - FHD010 용역마스타 + MST650PF 부서 조회
	 * @see 
	 * 	- 2014-06-12	:	jhb
	***********************************************************************/ 
	public void selectSmanPopup(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectSmanPopup", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}	

	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - cigma 입고품번 check 
	 * @see 
	 * 	- 2014-01-03	:	lsk
	***********************************************************************/ 
	public void selectBZI100PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectBZI100PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZI100PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - 가입고품번 재고수량
	 * @see 
	 * 	- 2014-01-03	:	lsk
	***********************************************************************/ 
	public void selectBZI500PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectBZI500PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BZI500PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - 공정코드와인사부서코드MATCHING마스타
	 * @see 
	 * 	- 2014-01-03	:	lsk
	***********************************************************************/ 
	public void selectFHD000PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectFHD000PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_FHD000PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - 작업반
	 * @see 
	 * 	- 2014-01-03	:	lsk
	***********************************************************************/ 
	public void selectFHD100PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectFHD100PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_FHD100PF", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - 작업반
	 * @see 
	 * 	- 2014-11-10	:	저장품품번마스타
	***********************************************************************/ 
	public void selectBJM100PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectBJM100PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BJM100PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void setSleepTime(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		Integer sleepTime = 0;

		System.out.println("pData.get(SEELTIME) = " + pData.get("SLEEPTIME"));
		if(pData.get("SLEEPTIME") != null){
			sleepTime = Integer.parseInt((String)pData.get("SLEEPTIME"));
		}
		System.out.println("sleep time = " + sleepTime);
		System.out.println("Start time = " + System.currentTimeMillis());
		Thread.sleep(sleepTime);
		System.out.println("End time = " + System.currentTimeMillis());
		ModelMap map = new ModelMap();
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - 폴더의 파일List 가져오기
	 * @see 
	 * 	- 2017-02-10	:	JHB
	***********************************************************************/ 
	public void searchFileName(HttpServletRequest request, HttpServletResponse response) throws Exception {	
	
/*		List list = new ArrayList();//추가
		list = findFileName(new File("C:/"));
		System.out.println(list);*/
		
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		String path=(String) pData.get("p_PATH");
		List list = new ArrayList();//추가
		list = findFileName(new File(path));
		//System.out.println(list);
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_HAY012UC", list);
		new MiPlatformView().render(map, request, response);
			}
	public List<HashMap<String, String>> findFileName(File f){
		List list = new ArrayList();
		if(f.isDirectory()){
			String[] fList =f.list();
			for(int i=0; i<fList.length; i++){
				File f1 = new File(f.getPath()+"/"+fList[i]);
				if(!f1.isDirectory()){
					String fnm=f1.getName();
					//System.out.println(fnm.substring(fnm.indexOf(".")+1, fnm.length()));
					String fnmExc=fnm.substring(fnm.indexOf(".")+1, fnm.length());
					//확장자가 excel인 것만 처리
					if("xls".equals(fnmExc) || "xlsx".equals(fnmExc)){
						//System.out.println("file name = "+fnm);
						HashMap fMap = new HashMap();
						fMap.put("FNAME", fnm);
						fMap.put("RESULT", 'F');
						list.add(fMap);
					}
				}
			}
		}
		return list;
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - BM008PR + MST050PF
	 * @see 
	 * 	- 2014-11-10	:	품번 및 제품코드 조회
	***********************************************************************/ 
	public void selectBM008PR_PRD(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectBM008PR_PRD", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BM008PR_PRD", list);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - F0006LB
	 * @see 
	 * 	- 2019-10-08	:	JDE 계정코드
	***********************************************************************/ 
	public void selectJdeF0006LB(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectJdeF0006LB", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_F0006LB", list);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - MST650PF
	 * @see 
	 * 	- 2019-10-08	:	부서코드 구KE/KA
	***********************************************************************/ 
	public void selectMst650PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("pscomlib.selectMst650PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST650PF", list);
		new MiPlatformView().render(map, request, response);
	}

}
