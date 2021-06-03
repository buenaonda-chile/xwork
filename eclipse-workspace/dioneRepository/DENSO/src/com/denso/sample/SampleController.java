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


package com.denso.sample;

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


public class SampleController extends MultiActionController {

	CommonDAO dao = CommonDAO.getInstance(1);	

	protected Log log = LogFactory.getLog(this.getClass());

	public void testProc(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);

		dao.updateData("sample.testProc", pData);
		System.out.println(pData);
		new MiPlatformView().render(null, request, response);
	}	
	
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
	public void selectDownLoad(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		HttpSession session = request.getSession(true);		
		Map guserInfo =(Map)session.getAttribute("userInfo");
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	

		//miplatform 에서 전송한 파라메타 값
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("sample.selectDownLoad" + (String)pData.get("TABLENM") , pData);
		//마이플랫폼으로 전송.			
		ModelMap map = new ModelMap();
		map.addAttribute("ds_main", list);

		new MiPlatformView().render(map, request, response);		
	}

	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	- 비밀번호 변경일 조회
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		
	public void selectPassWordChangeDate(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectPassWordChangeDate", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_pwChangeDay", list);
		new MiPlatformView().render(map, request, response);
	}
		
	
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	- DWH000PF에서 작업별 MAX일자를 조회
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		
	public void selectMaxDate(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectMaxDate", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_maxDate", list);
		new MiPlatformView().render(map, request, response);
	}
		

		
	public void selectFPMC109MaxDate(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectFPMC109MaxDate", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_maxDate", list);
		new MiPlatformView().render(map, request, response);
	}
			
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	- sqlmap을 파라미터에 의해 변경한다.
	 * 	- upload 공통
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void saveUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//dao.startTransaction();
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_main");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		List deleteList = new ArrayList();
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB", (String)pArg.get("LIB"));
			pData.put("TABLENM", (String)pArg.get("TABLENM"));			
			rowType = (String)pData.get("ROW_TYPE");
			if("normal".equals(rowType)){
				dao.insertData("sample.insert" +(String)pArg.get("TABLENM") , pData);
			}
		}
		new MiPlatformView().render(null, request, response);
		//dao.endTransaction();
		
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void selectPpmi001M(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectPpmi001M", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi001m", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void selectPpmi001M_Sum(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectPpmi001M_Sum", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi001m_sum", list);
		new MiPlatformView().render(map, request, response);
	}
	
	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void selectPpmi001MCode(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectPpmi001MCode", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi001mCode", list);
		new MiPlatformView().render(map, request, response);
	}
	
	

	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 
	public void selectPpmi002M(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		System.out.println("================="+pData.get("LIB"));
		System.out.println("================="+pData.get("COMPS"));
		System.out.println("================="+pData.get("PROCS"));
		System.out.println("================="+pData.get("DAYGU"));
		System.out.println("================="+pData.get("ORDAT"));		
		
		List list = dao.getListData("sample.selectPpmi002M", pData);
		

		
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi002m", list);
		new MiPlatformView().render(map, request, response);
	}	
		
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi003MGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectPpmi003MGroup", pData);
		
		System.out.println("=======ROWGB==================" + pData.get("ROWGB"));
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi003mGroup", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi003M(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectPpmi003M", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi003m", list);
		new MiPlatformView().render(map, request, response);
	}	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi004M(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("sample.selectPpmi004M", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi004m", list);

		new MiPlatformView().render(map, request, response);
	}		
	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi004MSub(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("sample.selectPpmi004MSub", pData);

		ModelMap map = new ModelMap();

		map.addAttribute("ds_ppmi004mSub", list);
		new MiPlatformView().render(map, request, response);
	}		
		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi005M(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("sample.selectPpmi005M", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi005m", list);
		
		new MiPlatformView().render(map, request, response);
	}		
	
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi006MTab1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("sample.selectPpmi006MTab1", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi006mTab1", list);
		
		new MiPlatformView().render(map, request, response);
	}			
	
	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi006MTab1Sub(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("sample.selectPpmi006MTab1Sub", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi006mTab1Sub", list);
		
		new MiPlatformView().render(map, request, response);
	}			
		
	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi006MTab2Code(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("sample.selectPpmi006MTab2Code", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi006mTab2Code", list);
		
		new MiPlatformView().render(map, request, response);
	}			
			
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi006MTab2(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("sample.selectPpmi006MTab2", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi006mTab2", list);
		
		new MiPlatformView().render(map, request, response);
	}			
				
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 
	public void savePpmi006MTab1(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ppmi006mTab1");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		List deleteList = new ArrayList();
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB", (String)pArg.get("LIB"));

			rowType = (String)pData.get("ROW_TYPE");
			if("update".equals(rowType)){
				dao.updateData("sample.updatePpmi006MTab1"  , pData);
				
			
				
				System.out.println("======COMPS====="+pData.get("COMPS"));
				System.out.println("======ORDAT====="+pData.get("ORDAT"));
				System.out.println("======PROCS====="+pData.get("PROCS"));
				System.out.println("======SPLIT====="+pData.get("SPLIT"));
				System.out.println("======SEQNO====="+pData.get("SEQNO"));
				System.out.println("======SERNO====="+pData.get("SERNO"));
				System.out.println("======DAYGU====="+pData.get("DAYGU"));
				System.out.println("======PRTNO====="+pData.get("PRTNO"));
				
				
			} else if ("insert".equals(rowType)){
		
				dao.updateData("sample.insertPpmi006MTab1"  , pData);				
			} else if ("delete".equals(rowType)){
				dao.updateData("sample.deletePpmi006MTab1"  , pData);				
			}
		}
		new MiPlatformView().render(null, request, response);
	
	}		
		
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 
	public void savePpmi006MTab2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ppmi006mTab2");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		List deleteList = new ArrayList();
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB", (String)pArg.get("LIB"));
			rowType = (String)pData.get("ROW_TYPE");
			if("update".equals(rowType)){
				
				
				System.out.println("======COMPS====="+pData.get("COMPS"));
				System.out.println("======ORDAT====="+pData.get("ORDAT"));
				System.out.println("======PROCS====="+pData.get("PROCS"));
				System.out.println("======DAYGU====="+pData.get("DAYGU"));
				System.out.println("======BADTM====="+pData.get("BADTM"));
						
				dao.updateData("sample.updatePpmi006MTab2"  , pData);
				

				
				
			} else if ("insert".equals(rowType)){
				
				System.out.println("======COMPS====="+pData.get("COMPS"));
				System.out.println("======ORDAT====="+pData.get("ORDAT"));
				System.out.println("======PROCS====="+pData.get("PROCS"));
				System.out.println("======BADLG====="+pData.get("BADLG"));
				System.out.println("======BADMD====="+pData.get("BADMD"));
				System.out.println("======BADSM====="+pData.get("BADSM"));
		
				
				dao.updateData("sample.insertPpmi006MTab2"  , pData);				
			} else if ("delete".equals(rowType)){
				dao.updateData("sample.deletePpmi006MTab2"  , pData);				
			}
		}
		new MiPlatformView().render(null, request, response);
	
	}		
			
	
	
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi007M(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectPpmi007M", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi007m", list);
		new MiPlatformView().render(map, request, response);
	}	
		
		
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 
	public void savePpmi007M(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ppmi007m");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		List deleteList = new ArrayList();
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB", (String)pArg.get("LIB"));

			rowType = (String)pData.get("ROW_TYPE");
			if("update".equals(rowType)){
				dao.updateData("sample.updatePpmi007M"  , pData);
			} else if ("insert".equals(rowType)){
				dao.updateData("sample.insertPpmi007M"  , pData);				
			} else if ("delete".equals(rowType)){
				dao.updateData("sample.deletePpmi007M"  , pData);				
			}
		}
		new MiPlatformView().render(null, request, response);
	
	}		
	
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi008MGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectPpmi008MGroup", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi008mGroup", list);
		new MiPlatformView().render(map, request, response);
	}	
		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi008MCode(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectPpmi008MCode", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi008mCode_" + pData.get("CLASS"), list);
		new MiPlatformView().render(map, request, response);
	}	
			
			
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi008M(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectPpmi008M", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi008m", list);
		new MiPlatformView().render(map, request, response);
	}	
		
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 
	public void savePpmi008M(HttpServletRequest request, HttpServletResponse response) throws Exception {
		dao.startTransaction();
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ppmi008m");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		List deleteList = new ArrayList();
		while(it.hasNext()){
			Map pData = (Map)it.next();
			
			pData.put("LIB", (String)pArg.get("LIB"));
			pData.put("USER_ID", (String)pArg.get("USER_ID"));			
			System.out.println("=====aaaaa======");
			//dao.deleteData("sample.deletePpmi008M"  , pData);
			dao.insertData("sample.insertPpmi008M"  , pData);
			
			System.out.println("=====bbbb======");

		}
		new MiPlatformView().render(null, request, response);
		dao.endTransaction();
		
	}		
				
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 
	public void savePpmi009M(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//dao.startTransaction();
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ppmi003m");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		List deleteList = new ArrayList();
		while(it.hasNext()){
			Map pData = (Map)it.next();
			
			pData.put("LIB", (String)pArg.get("LIB"));

			rowType = (String)pData.get("ROW_TYPE");
			
			if("update".equals(rowType)){
				dao.updateData("sample.updatePpmi009M"  , pData);
			} else if ("insert".equals(rowType)){
				dao.updateData("sample.insertPpmi009M"  , pData);				
			} else if ("delete".equals(rowType)){
				dao.updateData("sample.deletePpmi009M"  , pData);				
			}

		}
		new MiPlatformView().render(null, request, response);
		
	}		
	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void selectPpmi010M(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);

		List list = dao.getListData("sample.selectPpmi010M", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi010m", list);
		new MiPlatformView().render(map, request, response);
	}	
			
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void savePpmi010M(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ppmi010m");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		List deleteList = new ArrayList();
		while(it.hasNext()){
			Map pData = (Map)it.next();
			
			pData.put("LIB", (String)pArg.get("LIB"));

			rowType = (String)pData.get("ROW_TYPE");
			if("update".equals(rowType)){
				dao.updateData("sample.updatePpmi010M"  , pData);
			} else if ("insert".equals(rowType)) {
				System.out.println("===insert=========");
				
				System.out.println("=====COMPS=====" + pData.get("COMPS"));
				System.out.println("=====JOBDT=====" + pData.get("JOBDT"));
				System.out.println("====CONTL======" + pData.get("CONTL"));
				System.out.println("====JDTFM======" + pData.get("JDTFM"));
				System.out.println("=====STRTM=====" + pData.get("STRTM"));
				System.out.println("====JDTTO======" + pData.get("JDTTO"));
				System.out.println("=====ENDTM=====" + pData.get("ENDTM"));
				System.out.println("======DAYGU====" + pData.get("DAYGU"));
				System.out.println("=====PROCS=====" + pData.get("PROCS"));				
				
				dao.updateData("sample.insertPpmi010M"  , pData);


				
			} else if ("delete".equals(rowType)){
				dao.updateData("sample.deletePpmi010M"  , pData);
			}
		}
		new MiPlatformView().render(null, request, response);
	}			
	
	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- file upload sample
	 * @exception 
	 * @see 
	 * 	- 2011-10-25	:	이상건
	***********************************************************************/
	public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		DatasetList inDl = pReq.getDatasetList();
		Dataset inDs = inDl.getDataset("ds_uploadFile");
		if(inDs!=null){
			//String uploadDir = request.getRealPath("/") + "upload/";
			String uploadDir = "C:/upload/";
			File upDir = new File(uploadDir);
			if(!upDir.exists()) upDir.mkdir();
			inDs.setColumn(0, "FILE_PATH", uploadDir);
			FileUpDown.setFileUp(inDs);	
		}else{
			throw new Exception("Dataset not found..");
		}
		new MiPlatformView().render(null, request, response);		
	}
	

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
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- commit sample
	 * @exception 
	 * @see 
	 * 	- 2011-12-29	:	이상건
	***********************************************************************/
	public void committest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "Dataset0");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";

		dao.startTransaction(); //tr 시작
		//dao.startBatch(); //배치작업 준비
		dao.deleteData("sample.deleteTest" , pArg);
		while(it.hasNext()){
			Map pData = (Map)it.next();
			rowType = (String)pData.get("ROW_TYPE");
			if("normal".equals(rowType)){
				dao.insertData("sample.insertTest" , pData);
			}
		}
		//System.out.println("-----------------executeBatch");
		//dao.executeBatch(); //배치작업실행
		System.out.println("-----------------endTransaction");
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);
	}
	
	
	public void TableLockTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "Dataset0");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		
		dao.startTransaction(); //tr 시작	
			//dao.startBatch(); //배치작업 준비
		dao.updateData("sample.TableLockTest" , pArg);
		//dao.updateData("sample.TableLockTestupdate" , pArg);
			//dao.executeBatch(); //배치작업실행
		dao.endTransaction(); //commit
		//dao.getInstance(2);
		
		//dao.updateData("sample.unTableLockTest" , pArg);
		new MiPlatformView().render(null, request, response);
	}
	public void TableunLockTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "Dataset0");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		
		//dao.startTransaction(); //tr 시작	
			//dao.startBatch(); //배치작업 준비
		dao.updateData("sample.TableunLockTest" , pArg);
		//dao.updateData("sample.TableLockTestupdate" , pArg);
			//dao.executeBatch(); //배치작업실행
		//dao.endTransaction(); //commit
		//dao.getInstance(2);
		
		//dao.updateData("sample.unTableLockTest" , pArg);
		new MiPlatformView().render(null, request, response);
	}
	public void TableLockTest_mst040pf(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "Dataset0");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		
		dao.startTransaction(); //tr 시작	
		dao.updateData("sample.TableLockTest_mst040pf" , pArg);
		//dao.endTransaction(); //commit

		new MiPlatformView().render(null, request, response);
	}
	public void selectinsabontoR(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectinsabontoR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_insabontoR", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectInOutTime(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectINOUT_TIME", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_MAIN", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 금형작업진쳑현황조회(PS창원)
	 * @exception 
	 * @see 
	 * 	- 2013-04-09	:	김진경
	***********************************************************************/ 		
	public void selectFEP200PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectFEP200PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_FEP200PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- case 1 조회 sample
	 * @exception 
	 * @see 
	 * 	- 2013-06-17	:	lsk
	***********************************************************************/ 
	public void selectBIDC257Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectBIDC257Q", pData);
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
	 * 	-  정산관리/세금계산서관리MENU/업체이월재고 등록
	 * @exception 
	 * @see 
	 * 	- 2012-11-15	:	제환복
	***********************************************************************/
	
	public void selectSJTZ230(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectSJTZ230", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SJTZ230", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveSJTZ230(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_SJTZ230");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		String STLWH="";

		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("STLWH", (String)pArg.get("STLWH"));
			emptyPN = (String) pData.get("PSPNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("sample.selectSJTZ230_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MKPNO", pData.get("MKPNO"));
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("sample.deleteSJTZ230", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("STLWH", (String)pArg.get("STLWH"));
			emptyPN = (String) pData.get("PSPNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("sample.selectSJTZ230_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("MKPNO", pData.get("MKPNO"));
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("sample.insertSJTZ230", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("sample.selectSJTZ230_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MKPNO", pData.get("MKPNO"));
							errMap.put("PSPNO", pData.get("PSPNO"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("sample.updateSJTZ230", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SJTZ230_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  case 3 처리 sample   (월분류별 집행ITEM및업체수 생성)
	 * @exception 
	 * @see 
	 * 	- 2013-05-16	:	lsk
	***********************************************************************/ 
	public void saveBZZE220C(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.startTransaction(); //tr 시작
		dao.deleteData("sample.deleteBZZE220C", pArg);
		dao.insertData("sample.insertBZZE220C", pArg);
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);
	}
	
	//TEST
	public void selectMST100PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("sample.selectMST100PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST100PF", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void saveMST100PF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MST100PF");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";

		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			rowType = (String) pData.get("ROW_TYPE");
			if ("delete".equals(rowType)) {
				Map CheckCnt = (Map)dao.getReadData("sample.selectMST100PF_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(CheckCnt.get("CNT").equals(0)){
						//삭제불가(대상이 없음)
						HashMap errMap = new HashMap();
						errMap.put("PRTNO", pData.get("PRTNO"));
						errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
						System.out.println("없음");
						errList.add(errMap);
					}else{
						dao.deleteData("sample.deleteMST100PF", pData);
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				Map CheckCnt = (Map)dao.getReadData("sample.selectMST100PF_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(CheckCnt.get("CNT").equals(1)){
						//insert 불가(대상이 있음)
						HashMap errMap = new HashMap();
						errMap.put("PRTNO", pData.get("PRTNO"));
						errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						dao.insertData("sample.insertMST100PF", pData);
					}
				}
			} else if ("update".equals(rowType)) {
				Map CheckCnt = (Map)dao.getReadData("sample.selectMST100PF_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(CheckCnt.get("CNT").equals(0)){
						//update 불가(대상이 없음)
						HashMap errMap = new HashMap();
						errMap.put("PRTNO", pData.get("PRTNO"));
						errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						dao.updateData("sample.updateMST100PF", pData);
					}
				}
			}				      
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST100PF_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}		
	/*
	public void saveMST100PF1(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MST100PF");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";

		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			emptyPN = (String) pData.get("PRTNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("sample.selectMST100PF_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PRTNO", pData.get("PRTNO"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("sample.deleteMST100PF", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			emptyPN = (String) pData.get("PRTNO");
			rowType = (String) pData.get("ROW_TYPE");
System.out.print(rowType+emptyPN);
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("sample.selectMST100PF_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("PRTNO", pData.get("PRTNO"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("sample.insertMST100PF", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("sample.selectMST100PF_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PRTNO", pData.get("PRTNO"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("sample.updateMST100PF", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST100PF_CHK", errList);
		new MiPlatformView().render(map, request, response);
	}	*/
}
