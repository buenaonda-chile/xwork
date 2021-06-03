package com.denso.psmstlib;

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
import com.ibm.as400.access.Trace;
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


public class PsmstlibController extends MultiActionController {
	
	CommonDAO dao = CommonDAO.getInstance(1);	
	protected Log log = LogFactory.getLog(this.getClass());
	public void selectMSTZ058(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ058", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ058", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectMSTZ058_dchk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ058", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ058_dchk", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveMSTZ058(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*CommonDAO dao = CommonDAO.getInstance(1);*/
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MSTZ058");
		List errList = new ArrayList();// error check list
		
		Map pArg = DataConverter.getMiPlatformData(pReq);
		String Scomps = (String)pArg.get("COMPS");
		String Sgrpcd = (String)pArg.get("GRPCD");
		String Sidnum = (String)pArg.get("ADUSR");
		String Slib2 = (String)pArg.get("LIB2");
		
		Iterator it_d = pList.iterator(); //delete용
		Iterator it_iu = pList.iterator(); //insert,update용
		
		String rowType = "";
		List deleteList = new ArrayList();
		dao.startTransaction(); //tr 시작	
		while (it_d.hasNext()) {
			Map pData = (Map) it_d.next();
			pData.put("COMPS", Scomps);
			pData.put("GRPCD", Sgrpcd);
			pData.put("ADUSR", Sidnum);
			pData.put("LIB2", Slib2);
			rowType = (String) pData.get("ROW_TYPE");
			if ("delete".equals(rowType)) {
				Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ058",pData);
				if(CheckCnt!=null && CheckCnt.get("MSTCD")!=null && !CheckCnt.get("MSTCD").equals("")){
					dao.deleteData("psmstlib.deleteMSTZ058", pData);
				}else{
					//삭제불가(대상이 없음)
					HashMap errMap = new HashMap();
					errMap.put("GRPCD", pData.get("GRPCD"));
					errMap.put("MSTCD", pData.get("MSTCD"));
					errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("COMPS", Scomps);
			pData.put("GRPCD", Sgrpcd);
			pData.put("ADUSR", Sidnum);
			pData.put("LIB2", Slib2);
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ058",pData);
				if(CheckCnt!=null && CheckCnt.get("MSTCD")!=null && !CheckCnt.get("MSTCD").equals("")){
					//insert 불가(이미등록된 자료)
					HashMap errMap = new HashMap();
					errMap.put("GRPCD", pData.get("GRPCD"));
					errMap.put("MSTCD", pData.get("MSTCD"));
					errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					dao.insertData("psmstlib.insertMSTZ058", pData);
				}
			} else if ("update".equals(rowType)) {
				Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ058",pData);
				if(CheckCnt!=null && CheckCnt.get("MSTCD")!=null && !CheckCnt.get("MSTCD").equals("")){
					dao.deleteData("psmstlib.updateMSTZ058", pData);
				}else{
					//update 불가(대상이 없음)
					HashMap errMap = new HashMap();
					errMap.put("GRPCD", pData.get("GRPCD"));
					errMap.put("MSTCD", pData.get("MSTCD"));
					errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}
			}
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ058_CHECK", errList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  마스터관리/PDM-Cigma품번 CHECK LIST
	 * @exception 
	 * @see 
	 * 	- 2012-04-26	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ302Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ302Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ302", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  마스터관리/PDM-Cigma품번 CHECK LIST
	 * @exception 
	 * @see 
	 * 	- 2012-09-18	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTE100(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTE100", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTE100", list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void selectSVM100PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectSVM100PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SVM100PF", list);
		new MiPlatformView().render(map, request, response);
	}
	public void insertMSTE100(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MSTE100");
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
			pData.put("COMPS", (String)pArg.get("SCOMPS"));
			pData.put("PRTNO", (String)pArg.get("SPRTNO"));
			emptyPN = (String) pData.get("PRTNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTE100_Check1",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("PRTNO"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("psmstlib.deleteMSTE100_MST100PF", pData);
							dao.deleteData("psmstlib.deleteMSTE100_MST200PF", pData);
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("SUSER", (String)pArg.get("SUSER"));
			emptyPN = (String) pData.get("PRTNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTE100_Check1",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();							
							errMap.put("PRTNO", pData.get("PRTNO"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							Map CheckCnt2 = (Map)dao.getReadData("psmstlib.selectMSTE100_Check2",pData);
							if(CheckCnt2!=null && CheckCnt2.get("CNT")!=null && !CheckCnt2.get("CNT").equals("")){
								if(CheckCnt2.get("CNT").equals(1)){
									dao.insertData("psmstlib.insertMSTE100_MST100PF", pData);
									dao.updateData("psmstlib.updateMSTE100_MST200PF", pData);

								}else{
									
									dao.insertData("psmstlib.insertMSTE100_MST100PF", pData);
									dao.insertData("psmstlib.insertMSTE100_MST200PF", pData);
								}
							}
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTE100_Check1",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PRTNO", pData.get("PRTNO"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							Map CheckCnt2 = (Map)dao.getReadData("psmstlib.selectMSTE100_Check2",pData);
							if(CheckCnt2!=null && CheckCnt2.get("CNT")!=null && !CheckCnt2.get("CNT").equals("")){
								if(CheckCnt2.get("CNT").equals(0)){
									dao.updateData("psmstlib.updateMSTE100_MST100PF", pData);
									dao.insertData("psmstlib.insertMSTE100_MST200PF", pData);

								}else{
									
									dao.updateData("psmstlib.updateMSTE100_MST100PF", pData);
									dao.updateData("psmstlib.updateMSTE100_MST200PF", pData);
								}
							}
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_MSTE100_CHECK", errList);//추가
		//new MiPlatformView().render(null, request, response);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  마스터관리/제품차종코드등록
	 * @exception 
	 * @see 
	 * 	- 2012-08-09	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ053(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq = new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ053", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ053", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void insertMSTZ053(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MSTZ053");
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
		Dataset ds = in_dl.getDataset("ds_MSTZ053");
		//////////////////////////////////////////////////////////////
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			emptyPN = (String) pData.get("MSTCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ053_Check1",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("psmstlib.deleteMSTZ053", pData);
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("SUSER", (String)pArg.get("SUSER"));
			emptyPN = (String) pData.get("MSTCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ053_Check1",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 없음)
							HashMap errMap = new HashMap();							
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psmstlib.insertMSTZ053", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					pData.put("OLD_MSTCD", ds.getOrgBuffColumn(0, "MSTCD").getString());
					
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ053_Check2",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("OLD_MSTCD"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psmstlib.updateMSTZ053", pData);
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_MSTZ053_CHECK", errList);//추가
		//new MiPlatformView().render(null, request, response);
		new MiPlatformView().render(map, request, response);
	}	
	public void selectMSTC410Q_12(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psmstlib.selectMSTC410Q_12", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_LEVEL1", list);

		new MiPlatformView().render(map, request, response);
	}
	public void selectMSTC410QSub_12(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psmstlib.selectMSTC410QSub_12", pData);

		ModelMap map = new ModelMap();

		map.addAttribute("ds_LEVEL1From", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectMSTC410Q_34(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psmstlib.selectMSTC410Q_34", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_LEVEL1", list);

		new MiPlatformView().render(map, request, response);
	}
	public void selectMSTC410QSub_34(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psmstlib.selectMSTC410QSub_34", pData);

		ModelMap map = new ModelMap();

		map.addAttribute("ds_LEVEL1From", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectMST300PF_ITNBR(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMST300PF_ITNBR", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_main", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectMSTC302Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psmstlib.selectMSTC302Q", pData);

		ModelMap map = new ModelMap();

		map.addAttribute("ds_MSTC302Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  정산관리/세금계산서관리MENU/검수관리/세금계산서번호조회
	 * @exception 
	 * @see 
	 * 	- 2012-12-18	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ042Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ042Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ042Q", list);
		new MiPlatformView().render(map, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  정산관리/세금계산서관리MENU/검수관리/세금계산서번호등록
	 * @exception 
	 * @see 
	 * 	- 2012-12-18	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ043(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ043", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ043", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveMSTZ043(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MSTZ043");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_MSTZ043");
		//////////////////////////////////////////////////////////////		
		String rowType="";
		String emptyPN="";
		String imajcd="";
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			imajcd=(String)pData.get("MAJC2")+(String)pData.get("MAJC3");
			pData.put("IMAJCD",imajcd);
			emptyPN = (String) pData.get("MAJC3");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ043_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MAJC3", pData.get("MAJC3"));
							errMap.put("MJCHR", pData.get("MJCHR"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("psmstlib.deleteMSTZ043", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			imajcd=(String)pData.get("MAJC2")+(String)pData.get("MAJC3");
			pData.put("IMAJCD",imajcd);
			emptyPN = (String) pData.get("MAJC3");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ043_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MAJC3", pData.get("MAJC3"));
							errMap.put("MJCHR", pData.get("MJCHR"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psmstlib.insertMSTZ043", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					pData.put("OLD_MAJC3", ds.getOrgBuffColumn(0, "MAJC3").getString());
					pData.put("OLD_MJCHR", ds.getOrgBuffColumn(0, "MJCHR").getString());
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ043_Check2",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MAJC3", pData.get("OLD_MAJC3"));
							errMap.put("MJCHR", pData.get("OLD_MJCHR"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psmstlib.updateMSTZ043", pData);
/*
							Map CheckCnt2 = (Map)dao.getReadData("psmstlib.selectMSTZ043_Check",pData);
							if(CheckCnt2!=null && CheckCnt2.get("CNT")!=null && !CheckCnt2.get("CNT").equals("")){
								if(CheckCnt2.get("CNT").equals(1)){
									//update 불가(대상이 등록됨.)
									HashMap errMap = new HashMap();
									errMap.put("MAJC3", pData.get("MAJC3"));
									errMap.put("MJCHR", pData.get("MJCHR"));
									errMap.put("RTMSG", "수정불가(이미  등록된 자료입니다.)");
									errList.add(errMap);
								}else{
									dao.updateData("psmstlib.updateMSTZ043", pData);
								}
							}
*/						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_MSTZ043_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  마스터관리/차륜코드등록
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ054(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ054", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ054", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveMSTZ054(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MSTZ054");
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
		Dataset ds = in_dl.getDataset("ds_MSTZ054");
		//////////////////////////////////////////////////////////////
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			emptyPN = (String) pData.get("MSTCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ054_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("psmstlib.deleteMSTZ054", pData);
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("SUSER", (String)pArg.get("SUSER"));
			emptyPN = (String) pData.get("MSTCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ054_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 없음)
							HashMap errMap = new HashMap();							
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psmstlib.insertMSTZ054", pData);
						}
					}
				} else if ("update".equals(rowType)) {				
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ054_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psmstlib.updateMSTZ054", pData);
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_MSTZ054_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  마스터관리/지역코드관리
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ056(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ056", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ056", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveMSTZ056(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MSTZ056");
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
		Dataset ds = in_dl.getDataset("ds_MSTZ056");
		//////////////////////////////////////////////////////////////
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			emptyPN = (String) pData.get("MSTCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ056_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("psmstlib.deleteMSTZ056", pData);
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("SUSER", (String)pArg.get("SUSER"));
			emptyPN = (String) pData.get("MSTCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ056_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 없음)
							HashMap errMap = new HashMap();							
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psmstlib.insertMSTZ056", pData);
						}
					}
				} else if ("update".equals(rowType)) {				
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ056_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psmstlib.updateMSTZ056", pData);
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_MSTZ056_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  마스터관리/색상코드관리
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ057(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ057", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ057", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveMSTZ057(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MSTZ057");
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
		Dataset ds = in_dl.getDataset("ds_MSTZ057");
		//////////////////////////////////////////////////////////////
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			emptyPN = (String) pData.get("MSTCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ057_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("psmstlib.deleteMSTZ057", pData);
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("SUSER", (String)pArg.get("SUSER"));
			emptyPN = (String) pData.get("MSTCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ057_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 없음)
							HashMap errMap = new HashMap();							
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psmstlib.insertMSTZ057", pData);
						}
					}
				} else if ("update".equals(rowType)) {				
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ057_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psmstlib.updateMSTZ057", pData);
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_MSTZ057_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  마스터관리/지역-색상코드관리(통합)
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ0567(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ0567", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ0567", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveMSTZ0567(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MSTZ0567");
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
		Dataset ds = in_dl.getDataset("ds_MSTZ0567");
		//////////////////////////////////////////////////////////////
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			emptyPN = (String) pData.get("MSTCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ0567_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("psmstlib.deleteMSTZ0567", pData);
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("SUSER", (String)pArg.get("SUSER"));
			emptyPN = (String) pData.get("MSTCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ0567_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 없음)
							HashMap errMap = new HashMap();							
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psmstlib.insertMSTZ0567", pData);
						}
					}
				} else if ("update".equals(rowType)) {				
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ0567_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psmstlib.updateMSTZ0567", pData);
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_MSTZ0567_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  마스터관리/코드마스타 현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ052Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ052Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ052Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  코드마스터 테이블조회
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMST050PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMST050PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST050PF", list);
		new MiPlatformView().render(map, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  마스터관리/작업공정마스타등록
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ060(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ060", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ060", list);
		new MiPlatformView().render(map, request, response);
	}	
	public void saveMSTZ060(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MSTZ060");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPROSM="";
		String emptyPRONM="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_MSTZ060");
		//////////////////////////////////////////////////////////////
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			emptyPROSM = (String) pData.get("PROSM");
			emptyPRONM = (String) pData.get("PRONM");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPROSM != "" || emptyPROSM!="") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ060_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PROCS", pData.get("PROCS"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("psmstlib.deleteMSTZ060", pData);
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			emptyPROSM = (String) pData.get("PROSM");
			emptyPRONM = (String) pData.get("PRONM");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPROSM != "" || emptyPROSM!="") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ060_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 없음)
							HashMap errMap = new HashMap();							
							errMap.put("PROCS", pData.get("PROCS"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psmstlib.insertMSTZ060", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ060_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PROCS", pData.get("PROCS"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psmstlib.updateMSTZ060", pData);
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_MSTZ060_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}	
	public void selectMSTZ061Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ061Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ061Q", list);
		new MiPlatformView().render(map, request, response);
	}		
	
/* lee sang keon 자재관리 작업  Start */
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  품목마스타현황
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	lsk
	***********************************************************************/ 
	//@SuppressWarnings("unchecked")
	public void selectMSTZ111Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = new ArrayList();
		String gub = (String)pData.get("GUBUN");
		if (gub.equals("1")){
			list = dao.getListData("psmstlib.selectMSTZ111Q_1", pData);
		}
		if (gub.equals("2")){
			list = dao.getListData("psmstlib.selectMSTZ111Q_2", pData);
		}
		if (gub.equals("3")){
			list = dao.getListData("psmstlib.selectMSTZ111Q_3", pData);
		}
		if (gub.equals("4")){
			list = dao.getListData("psmstlib.selectMSTZ111Q_4", pData);
		}
		if (gub.equals("5")){
			list = dao.getListData("psmstlib.selectMSTZ111Q_5", pData);
		}
		if (gub.equals("6")){
			list = dao.getListData("psmstlib.selectMSTZ111Q_6", pData);
		}
		if (gub.equals("7")){
			list = dao.getListData("psmstlib.selectMSTZ111Q_7", pData);
		}
		if (gub.equals("8")){
			list = dao.getListData("psmstlib.selectMSTZ111Q_8", pData);
		}
		if (gub.equals("9")){
			list = dao.getListData("psmstlib.selectMSTZ111Q_9", pData);
		}
		if (gub.equals("0")){
			list = dao.getListData("psmstlib.selectMSTZ111Q_0", pData);
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ111Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  이름별 주소록 조회
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	lsk
	***********************************************************************/ 
	public void selectMSTZ603Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ603Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ603Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  업체 지불조건 마스타 조회
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	lsk
	***********************************************************************/ 
	public void selectACCZ901Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectACCZ901Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ACCZ901Q", list);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  업체 지불조건 마스타 조회 상세
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	lsk
	***********************************************************************/ 
	public void selectACCZ901QD(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectACCZ901QD", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ACCZ901QD", list);
		new MiPlatformView().render(map, request, response);
	}
	
	
	
	
	
/* lee sang keon 자재관리 작업  End */
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  마스터관리/작업공정마스타등록
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTE044Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTE044Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTE044Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  생산관리/마스터관리/품목정보마스타(PS)
	 * @exception 
	 * @see 
	 * 	- 2013-05-08	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ100(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ100", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ100", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectMSTZ100_NEW(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ100_NEW", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ100", list);
		new MiPlatformView().render(map, request, response);
	}	
	public void saveMSTZ100(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MSTZ100");
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
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ100_Check1",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PRTNO", pData.get("PRTNO"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							System.out.println("없음");
							errList.add(errMap);
						}else{
							dao.deleteData("psmstlib.deleteMSTZ100_MST100PF", pData);
							dao.deleteData("psmstlib.deleteMSTZ100_MST250PF", pData);
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
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ100_Check1",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();							
							errMap.put("PRTNO", pData.get("PRTNO"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							Map CheckCnt2 = (Map)dao.getReadData("psmstlib.selectMSTZ100_Check2",pData);
							if(CheckCnt2!=null && CheckCnt2.get("CNT")!=null && !CheckCnt2.get("CNT").equals("")){
								if(CheckCnt2.get("CNT").equals(1)){
									dao.insertData("psmstlib.insertMSTZ100_MST100PF", pData);
									dao.updateData("psmstlib.updateMSTZ100_MST250PF", pData);

								}else{
									
									dao.insertData("psmstlib.insertMSTZ100_MST100PF", pData);
									dao.insertData("psmstlib.insertMSTZ100_MST250PF", pData);
								}
							}
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ100_Check1",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PRTNO", pData.get("PRTNO"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							Map CheckCnt2 = (Map)dao.getReadData("psmstlib.selectMSTZ100_Check2",pData);
							if(CheckCnt2!=null && CheckCnt2.get("CNT")!=null && !CheckCnt2.get("CNT").equals("")){
								if(CheckCnt2.get("CNT").equals(0)){
									dao.updateData("psmstlib.updateMSTZ100_MST100PF", pData);
									dao.insertData("psmstlib.insertMSTZ100_MST250PF", pData);

								}else{
									
									dao.updateData("psmstlib.updateMSTZ100_MST100PF", pData);
									dao.updateData("psmstlib.updateMSTZ100_MST250PF", pData);
								}
							}
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_MSTZ100_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  생산관리/마스터관리/품목정보마스타 CHECK LIST(PE)
	 * @exception 
	 * @see 
	 * 	- 2013-06-04	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTE101Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTE101Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTE101Q", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  초품관리마스터등록
	 * @exception 
	 * @see 
	 * 	- 2013-12-27	:	MMK
	***********************************************************************/ 
	public void selectMSTZ100Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ100Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ100Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void insertMSTZ100(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MSTZ100Q");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		List errList = new ArrayList();//추가
		
		dao.startTransaction(); //tr 시작		
		dao.insertData("psmstlib.insertMSTZ100", pArg);
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_MSTZ100Q_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  생산관리/작업일보관리/작업일보(생산)관리/달력마스타 수정
	 * @exception 
	 * @see 
	 * 	- 2014-06-10	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ090(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ090", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ090", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveMSTZ090(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MSTZ090");
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
		Dataset ds = in_dl.getDataset("ds_MSTZ090");
		//////////////////////////////////////////////////////////////
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			emptyPN = (String) pData.get("PRCDT");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ090_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PRCDT", pData.get("PRCDT"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psmstlib.deleteMSTZ090", pData);
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			emptyPN = (String) pData.get("PRCDT");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ090_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();							
							errMap.put("PRCDT", pData.get("PRCDT"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psmstlib.insertMSTZ090", pData);
						}
					}
				} else if ("update".equals(rowType)) {				
					Map CheckCnt = (Map)dao.getReadData("psmstlib.selectMSTZ090_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PRCDT", pData.get("PRCDT"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psmstlib.updateMSTZ090", pData);
						}
					}
				}
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_MSTZ090_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  생산관리/제품기술BOM/품목마스타조회
	 * @exception 
	 * @see 
	 * 	- 2014-06-10	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTC301Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		long heapSize=Runtime.getRuntime().totalMemory();
		String heapSizeMB=(heapSize/(1024*1024))+"MB";
		System.out.println(heapSizeMB);
		
		List list = dao.getListData("psmstlib.selectMSTC301Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTC301Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  정보관리 KA OCEANS 기적상개시 자료제공
	 * @exception 
	 * @see 
	 * 	- 2015-04-16	:	LSK
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOCAZ200C_tab1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		//List list = dao.getListData("psmstlib.selectOCAZ200C_tab1", pData);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		HashMap tempMap = new HashMap();
		Map CheckCnt1 = (Map)dao.getReadData("psmstlib.selectOCAZ200C_tab1_1",pData); /* 자재마감 data조회 */
		tempMap.put("C1", CheckCnt1.get("C1"));
		Map CheckCnt2 = (Map)dao.getReadData("psmstlib.selectOCAZ200C_tab1_2",pData); /* 유상사급마감 data조회 */
		tempMap.put("C2", CheckCnt2.get("C2"));
		Map CheckCnt3 = (Map)dao.getReadData("psmstlib.selectOCAZ200C_tab1_3",pData); /* 가매상 data조회 */
		tempMap.put("C3", CheckCnt3.get("C3"));
		list.add(tempMap);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ200C_tab1", list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void selectOCAZ200C_tab4(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ200C_tab4", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ200C_tab4", list);
		new MiPlatformView().render(map, request, response);
	}	
	@SuppressWarnings("unchecked")
	public void selectOCAZ200C_tab4_1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ200C_tab4_1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ200C_tab4_1", list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void selectOCAZ200C_tab4_2(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ200C_tab4_2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ200C_tab4_2", list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void selectOCAZ200C_tab4_3(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ200C_tab4_3", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ200C_tab4_3", list);
		new MiPlatformView().render(map, request, response);
	}
	
	@SuppressWarnings("unchecked")
	public void selectOCAZ200C_tab6(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		String qSEQ = (String) pData.get("SEQ");
		List list = dao.getListData("psmstlib.selectOCAZ200C_tab6", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ200C_tab6_"+qSEQ, list);
		new MiPlatformView().render(map, request, response);
	}

	@SuppressWarnings("unchecked")
	public void selectOCAZ400C_tab2(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab2", list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void selectOCAZ400C_tab3(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab3", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab3", list);
		new MiPlatformView().render(map, request, response);
	}	
	@SuppressWarnings("unchecked")
	public void selectOCAZ400C_tab4(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab4", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab4", list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void selectOCAZ400C_tab5(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab5", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab5", list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void selectOCAZ400C_tab6(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab6", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab6", list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void selectOCAZ400C_tab7(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab7", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab7", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOCAZ400C_tab8cnt(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab8cnt", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab8cnt", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOCAZ400C_tab8(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String querySTEP = (String) pData.get("STEP");
		String compsGB = (String) pData.get("COMPS");
		if ("E1".equals(compsGB)){
			System.out.println(compsGB);
			List list = dao.getListData("psmstlib.selectOCAE400C_tab8", pData);
			ModelMap map = new ModelMap();
			map.addAttribute("ds_OCAZ400C_tab8_"+querySTEP, list);
			new MiPlatformView().render(map, request, response);
		}else{
			List list = dao.getListData("psmstlib.selectOCAZ400C_tab8", pData);
			ModelMap map = new ModelMap();
			map.addAttribute("ds_OCAZ400C_tab8_"+querySTEP, list);
			new MiPlatformView().render(map, request, response);
		}	
	}
	public void selectOCAZ400C_tab9cnt(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab9cnt", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab9cnt", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOCAZ400C_tab9(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String querySTEP = (String) pData.get("STEP");
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab9", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab9_"+querySTEP, list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void selectOCAZ400C_tab11(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab11", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab11", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void saveOCAZ400C_tab12(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.startTransaction(); //tr 시작
		dao.deleteData("psmstlib.deleteOCAZ400C_tab12", pData);
		dao.insertData("psmstlib.insertOCAZ400C_tab12", pData);
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);	
	}
	public void selectOCAZ400C_tab12cnt(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab12cnt", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab12cnt", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOCAZ400C_tab12_1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1 = dao.getListData("psmstlib.selectOCAZ400C_tab12_1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab12_1", list1);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOCAZ400C_tab12_2(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		String querySTEP = (String) pData.get("STEP");
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab12_2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab12_2_"+querySTEP, list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOCAZ400C_tab12_3(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String querySTEP = (String) pData.get("STEP");
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab12_3", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab12_3_"+querySTEP, list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOCAZ400C_tab13(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String querySTEP = (String) pData.get("STEP");
		List list = dao.getListData("psmstlib.selectOCAZ400C_tab13", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab13_"+querySTEP, list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  정보관리 KE OCEANS 기적상개시 자료제공
	 * @exception 
	 * @see 
	 * 	- 2016-04-16	:	LSK
	***********************************************************************/
	@SuppressWarnings("unchecked")
	public void selectOCAE400C_tab2(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAE400C_tab2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAE400C_tab2", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  생산관리/[생산]QR제품Tag 관리/품목마스타 자유항목10 과 OEM품번 비교
	 * @exception 
	 * @see 
	 * 	- 2015-11-19	:	LSK
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ119Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ119Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ119Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  생산관리/제품기술BOM/품목마스타조회
	 * @exception 
	 * @see 
	 * 	- 2015-07-10	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMST600(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMST600", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MST600", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  인사급여/인사정보/MRP부서코드조회
	 * @exception 
	 * @see 
	 * 	- 2018-04-04	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectMSTZ650Q(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectMSTZ650Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTZ650Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  OCEANS 기적상 CHECK자료 조회
	 * @exception 
	 * @see 
	 * 	- 2020-09-17	:	LSK
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOCAZ401Q_tab3cnt(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ401Q_tab3cnt", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab3cnt", list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void selectOCAZ401Q_tab3(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String querySTEP = (String) pData.get("STEP");
		List list = dao.getListData("psmstlib.selectOCAZ401Q_tab3", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab3_"+querySTEP, list);
		new MiPlatformView().render(map, request, response);
	}
	
	@SuppressWarnings("unchecked")
	public void selectOCAZ401Q_tab4(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ401Q_tab4", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab4", list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void selectOCAZ401Q_tab5(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ401Q_tab5", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab5", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOCAZ401Q_tab6(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ401Q_tab6", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab6", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOCAZ401Q_tab7(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ401Q_tab7", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab7", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOCAZ401Q_tab8cnt(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ401Q_tab8cnt", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab8cnt", list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void selectOCAZ401Q_tab8(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String querySTEP = (String) pData.get("STEP");
		String compsGB = (String) pData.get("COMPS");
		if ("E1".equals(compsGB)){
			System.out.println(compsGB);
			List list = dao.getListData("psmstlib.selectOCAZ401Q_tab8", pData);
			ModelMap map = new ModelMap();
			map.addAttribute("ds_OCAZ400C_tab8_"+querySTEP, list);
			new MiPlatformView().render(map, request, response);
		}else{
			List list = dao.getListData("psmstlib.selectOCAZ401Q_tab8", pData);
			ModelMap map = new ModelMap();
			map.addAttribute("ds_OCAZ400C_tab8_"+querySTEP, list);
			new MiPlatformView().render(map, request, response);
		}	
	}
	@SuppressWarnings("unchecked")
	public void selectOCAZ401Q_tab9cnt(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ401Q_tab9cnt", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab9cnt", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOCAZ401Q_tab9(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String querySTEP = (String) pData.get("STEP");
		List list = dao.getListData("psmstlib.selectOCAZ401Q_tab9", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab9_"+querySTEP, list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void selectOCAZ401Q_tab11(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ401Q_tab11", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab11", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOCAZ401Q_tab13cnt(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psmstlib.selectOCAZ401Q_tab13cnt", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab12cnt", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOCAZ401Q_tab13(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String querySTEP = (String) pData.get("STEP");
		List list = dao.getListData("psmstlib.selectOCAZ401Q_tab13", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OCAZ400C_tab13_"+querySTEP, list);
		new MiPlatformView().render(map, request, response);
	}
}