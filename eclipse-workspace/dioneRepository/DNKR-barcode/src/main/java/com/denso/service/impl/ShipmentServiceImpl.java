package com.denso.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.denso.dao.ShipmentDao;
import com.denso.service.intf.ShipmentService;

@Service
public class ShipmentServiceImpl implements ShipmentService{

	@Autowired
	private ShipmentDao shipmentDao;

	@Override
	public List<HashMap<String, String>> getFSAZ100List(HashMap<String, String> reqMap) {
		return shipmentDao.selectFSAZ100List(reqMap);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setFSAZ100List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		Iterator<HashMap<String, String>> it_d = reqParam.iterator();
		Iterator<HashMap<String, String>> it_iu = reqParam.iterator();
		
		//commit, rollback처리필요
		//삭제기능 미사용
		while (it_d.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_d.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("delete".equals(rowType)) {
				//System.out.println("delete");
				HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ100Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("삭제불가(대상이 없음)");
					//삭제불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("GATCD", pData.get("GATCD"));
					errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					shipmentDao.setFSAZ100ListDelete(pData);
				}
			}
		}
		while (it_iu.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_iu.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("insert".equals(rowType)) {
				//System.out.println("insert");
				HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ100Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}
				//if(cnt.equals("1")){
				if(!cnt.equals("0")){
					//System.out.println("insert 불가(대상이 있음)");
					//insert 불가(대상이 있음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("GATCD", pData.get("GATCD"));
					errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					shipmentDao.setFSAZ100ListInsert(pData);
				}
			} else if ("update".equals(rowType)) {
				//System.out.println("update");
				HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ100Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("update 불가(대상이 없음)");
					//update 불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("GATCD", pData.get("GATCD"));
					errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					shipmentDao.setFSAZ100ListUpdate(pData);
				}
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}

	@Override
	public List<HashMap<String, String>> getFSAZ110List(HashMap<String, String> reqMap) {
		return shipmentDao.selectFSAZ110List(reqMap);
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setFSAZ110List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		Iterator<HashMap<String, String>> it_d = reqParam.iterator();
		Iterator<HashMap<String, String>> it_iu = reqParam.iterator();
		
		//commit, rollback처리필요
		while (it_d.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_d.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("delete".equals(rowType)) {
				//System.out.println("delete");
				HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ110Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("삭제불가(대상이 없음)");
					//삭제불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("TRACD", pData.get("TRACD"));
					errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					shipmentDao.setFSAZ110ListDelete(pData);
				}
			}
		}
		while (it_iu.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_iu.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("insert".equals(rowType)) {
				//System.out.println("insert");
				HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ110Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}
				//if(cnt.equals("1")){
				if(!cnt.equals("0")){
					//System.out.println("insert 불가(대상이 있음)");
					//insert 불가(대상이 있음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("TRACD", pData.get("TRACD"));
					errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					shipmentDao.setFSAZ110ListInsert(pData);
				}
			} else if ("update".equals(rowType)) {
				//System.out.println("update");
				HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ110Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("update 불가(대상이 없음)");
					//update 불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("TRACD", pData.get("TRACD"));
					errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					shipmentDao.setFSAZ110ListUpdate(pData);
				}
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	@Override
	public List<HashMap<String, String>> getFSAZ120List(HashMap<String, String> reqMap) {
		return shipmentDao.selectFSAZ120List(reqMap);
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setFSAZ120List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		Iterator<HashMap<String, String>> it_d = reqParam.iterator();
		Iterator<HashMap<String, String>> it_iu = reqParam.iterator();
		
		//commit, rollback처리필요
		while (it_d.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_d.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("delete".equals(rowType)) {
				//System.out.println("delete");
				HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ120Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("삭제불가(대상이 없음)");
					//삭제불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("TRUCD", pData.get("TRUCD"));
					errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					shipmentDao.setFSAZ120ListDelete(pData);
				}
			}
		}
		while (it_iu.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_iu.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("insert".equals(rowType)) {
				//System.out.println("insert");
				HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ120Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}
				//System.out.println(cnt);

				//if(cnt.equals("1")){
				if(!cnt.equals("0")){
					//System.out.println("insert 불가(대상이 있음)");
					//insert 불가(대상이 있음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("TRUCD", pData.get("TRUCD"));
					errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					shipmentDao.setFSAZ120ListInsert(pData);
				}
			} else if ("update".equals(rowType)) {
				//System.out.println("update");
				HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ120Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("update 불가(대상이 없음)");
					//update 불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("TRUCD", pData.get("TRUCD"));
					errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					shipmentDao.setFSAZ120ListUpdate(pData);
				}
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	@Override
	public List<HashMap<String, String>> getFSAZ130List(HashMap<String, String> reqMap) {
		return shipmentDao.selectFSAZ130List(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getFSAZ130ListAll(HashMap<String, String> reqMap) {
		return shipmentDao.selectFSAZ130ListAll(reqMap);
	}
/*	
	@Override
	public List<HashMap<String, String>>  setFSAZ130List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		String INPMN = (String)reqMap.get("SUSER");
		Iterator<HashMap<String, String>> it_d = reqParam.iterator();
		Iterator<HashMap<String, String>> it_iu = reqParam.iterator();
		
		//commit, rollback처리필요
		while (it_d.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_d.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			pData.put("INPMN", INPMN);
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("delete".equals(rowType)) {
				System.out.println("delete");
				HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ130Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					System.out.println("삭제불가(대상이 없음)");
					//삭제불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("STYMD", pData.get("STYMD"));
					errMap.put("GATCD", pData.get("GATCD"));
					errMap.put("TRACD", pData.get("TRACD"));
					errMap.put("DAYCD", pData.get("DAYCD"));
					errMap.put("CHASU", pData.get("CHASU"));
					errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					shipmentDao.setFSAZ130ListDelete(pData);
				}
			}
		}
		while (it_iu.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_iu.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			pData.put("INPMN", INPMN);
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("insert".equals(rowType)) {
				System.out.println("insert");
				HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ130Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}
				System.out.println(cnt);

				//if(cnt.equals("1")){
				if(!cnt.equals("0")){
					System.out.println("insert 불가(대상이 있음)");
					//insert 불가(대상이 있음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("STYMD", pData.get("STYMD"));
					errMap.put("GATCD", pData.get("GATCD"));
					errMap.put("TRACD", pData.get("TRACD"));
					errMap.put("DAYCD", pData.get("DAYCD"));
					errMap.put("CHASU", pData.get("CHASU"));
					errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					shipmentDao.setFSAZ130ListInsert(pData);
				}
			} else if ("update".equals(rowType)) {
				System.out.println("update");
				HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ130Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					System.out.println("update 불가(대상이 없음)");
					//update 불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("STYMD", pData.get("STYMD"));
					errMap.put("GATCD", pData.get("GATCD"));
					errMap.put("TRACD", pData.get("TRACD"));
					errMap.put("DAYCD", pData.get("DAYCD"));
					errMap.put("CHASU", pData.get("CHASU"));
					errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					shipmentDao.setFSAZ130ListUpdate(pData);
				}
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
*/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setFSAZ130List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		String INPMN = (String)reqMap.get("SUSER");
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		//System.out.println("신규");
		//commit, rollback처리필요
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			pData.put("INPMN", INPMN);
			String rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				System.out.println("insert");
				shipmentDao.setFSAZ130ListInsert(pData);
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	/*
	@Override
	public List<HashMap<String, String>>  setFSAZ130List2(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		String INPMN = (String)reqMap.get("SUSER");
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		//System.out.println("업데이트");
		//commit, rollback처리필요
		shipmentDao.setFSAZ130ListDelete(reqMap);
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			pData.put("INPMN", INPMN);
			String rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				System.out.println("delete");
				shipmentDao.setFSAZ130ListInsert(pData);
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	*/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setFSAZ130List2(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		//String INPMN = (String)reqMap.get("SUSER");
		Iterator<HashMap<String, String>> it_d = reqParam.iterator();
		Iterator<HashMap<String, String>> it_iu = reqParam.iterator();
		//System.out.println("업데이트");
		//commit, rollback처리필요
		while (it_d.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_d.next();
			pData.put("LIB2", reqMap.get("LIB2"));
			pData.put("INPMN", reqMap.get("SUSER"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("delete".equals(rowType)) {
				//System.out.println("delete");
				HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ130Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("삭제불가(대상이 없음)");
					//삭제불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("STYMD", pData.get("STYMD"));
					errMap.put("GATCD", pData.get("GATCD"));
					errMap.put("TRACD", pData.get("TRACD"));
					errMap.put("DAYCD", pData.get("DAYCD"));
					errMap.put("CHASU", pData.get("CHASU"));
					errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					//shipmentDao.setFSAZ130ListDeleteAll(pData); //미사용
					shipmentDao.setFSAZ130ListDelete(pData);
				}
			}
		}
		
		while (it_iu.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_iu.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			pData.put("INPMN", reqMap.get("SUSER"));
			String rowType = (String) pData.get("ROW_TYPE");
			String pTIMES = (String) pData.get("TIMES");
			String pTIMEE = (String) pData.get("TIMEE");
			String cnt="0";
			if ("insert".equals(rowType)) {
				if(!pTIMES.equals("")&&!pTIMEE.equals("")){
					//System.out.println("insert");
					HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ130Check(pData);
					if(CheckCnt != null){
						cnt =String.valueOf(CheckCnt.get("CNT"));
					}
					//System.out.println(cnt);

					//if(cnt.equals("1")){
					if(!cnt.equals("0")){
						//System.out.println("insert 불가(대상이 있음)");
						//insert 불가(대상이 있음)
						HashMap<String, String> errMap = new HashMap<String, String>();
						errMap.put("STYMD", pData.get("STYMD"));
						errMap.put("GATCD", pData.get("GATCD"));
						errMap.put("TRACD", pData.get("TRACD"));
						errMap.put("DAYCD", pData.get("DAYCD"));
						errMap.put("CHASU", pData.get("CHASU"));
						errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						shipmentDao.setFSAZ130ListInsert(pData);
					}
				}

			} else if ("update".equals(rowType)) {
				if(pTIMES.equals("")&&pTIMEE.equals("")){
					HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ130Check(pData);
					if(CheckCnt != null){
						cnt =String.valueOf(CheckCnt.get("CNT"));
					}
					if(cnt.equals("0")){
						//System.out.println("삭제불가(대상이 없음)");
						//삭제불가(대상이 없음)
						HashMap<String, String> errMap = new HashMap<String, String>();
						errMap.put("STYMD", pData.get("STYMD"));
						errMap.put("GATCD", pData.get("GATCD"));
						errMap.put("TRACD", pData.get("TRACD"));
						errMap.put("DAYCD", pData.get("DAYCD"));
						errMap.put("CHASU", pData.get("CHASU"));
						errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						shipmentDao.setFSAZ130ListDelete(pData);
					}
				}else{
					//System.out.println("update");
					HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ130Check(pData);
					if(CheckCnt != null){
						cnt =String.valueOf(CheckCnt.get("CNT"));
					}				
					if(cnt.equals("0")){
						//System.out.println("update 불가(대상이 없음)");
						//update 불가(대상이 없음)
						HashMap<String, String> errMap = new HashMap<String, String>();
						errMap.put("STYMD", pData.get("STYMD"));
						errMap.put("GATCD", pData.get("GATCD"));
						errMap.put("TRACD", pData.get("TRACD"));
						errMap.put("DAYCD", pData.get("DAYCD"));
						errMap.put("CHASU", pData.get("CHASU"));
						errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						shipmentDao.setFSAZ130ListUpdate(pData);
					}
				}
			}
		}		
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	
	@Override
	public List<HashMap<String, String>> getFSAZ140List(HashMap<String, String> reqMap) {
		return shipmentDao.selectFSAZ140List(reqMap);
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setFSAZ140List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		Iterator<HashMap<String, String>> it_iu = reqParam.iterator();
		String INPMN = (String)reqMap.get("SUSER");
		//commit, rollback처리필요
		while (it_iu.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_iu.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			pData.put("INPMN", INPMN);
			String rowType = (String) pData.get("ROW_TYPE");
			String pTRUCD = (String) pData.get("TRUCD");
			String cnt="0";
			if ("insert".equals(rowType)) {
				if(!pTRUCD.equals("")){
					//System.out.println("insert");
					HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ140Check(pData);
					if(CheckCnt != null){
						cnt =String.valueOf(CheckCnt.get("CNT"));
					}
					//System.out.println(cnt);

					//if(cnt.equals("1")){
					if(!cnt.equals("0")){
						//System.out.println("insert 불가(대상이 있음)");
						//insert 불가(대상이 있음)
						HashMap<String, String> errMap = new HashMap<String, String>();
						errMap.put("TRACD", pData.get("TRACD"));
						errMap.put("CHASU", pData.get("CHASU"));
						errMap.put("TRUCD", pData.get("TRUCD"));
						errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						shipmentDao.setFSAZ140ListInsert(pData);
					}
				}

			} else if ("update".equals(rowType)) {
				if(pTRUCD.equals("")){
					HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ140Check(pData);
					if(CheckCnt != null){
						cnt =String.valueOf(CheckCnt.get("CNT"));
					}
					if(cnt.equals("0")){
						//System.out.println("삭제불가(대상이 없음)");
						//삭제불가(대상이 없음)
						HashMap<String, String> errMap = new HashMap<String, String>();
						errMap.put("TRACD", pData.get("TRACD"));
						errMap.put("CHASU", pData.get("CHASU"));
						errMap.put("TRUCD", pData.get("TRUCD"));
						errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						shipmentDao.setFSAZ140ListDelete(pData);
					}
				}else{
					//System.out.println("update");
					HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ140Check(pData);
					if(CheckCnt != null){
						cnt =String.valueOf(CheckCnt.get("CNT"));
					}				
					if(cnt.equals("0")){
						//System.out.println("update 불가(대상이 없음)");
						//update 불가(대상이 없음)
						HashMap<String, String> errMap = new HashMap<String, String>();
						errMap.put("TRACD", pData.get("TRACD"));
						errMap.put("CHASU", pData.get("CHASU"));
						errMap.put("TRUCD", pData.get("TRUCD"));
						errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						shipmentDao.setFSAZ140ListUpdate(pData);
					}
				}
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	@Override
	public List<HashMap<String, String>> getFSAZ150List(HashMap<String, String> reqMap) {
		return shipmentDao.selectFSAZ150List(reqMap);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setFSAZ150List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
			List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
			Iterator<HashMap<String, String>> it_d = reqParam.iterator();
			Iterator<HashMap<String, String>> it_iu = reqParam.iterator();
			//System.out.println("업데이트");
			//commit, rollback처리필요
			while (it_d.hasNext()) {
				HashMap<String, String> pData = (HashMap<String, String>) it_d.next();
				pData.put("LIB2", reqMap.get("LIB2"));
				pData.put("COMPS", reqMap.get("COMPS"));
				pData.put("INPMN", reqMap.get("SUSER"));
				pData.put("TRAGB", reqMap.get("TRAGB"));
				String rowType = (String) pData.get("ROW_TYPE");
				String cnt="0";
				if ("delete".equals(rowType)) {
					//System.out.println("delete");
					HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ150Check(pData);
					if(CheckCnt != null){
						cnt =String.valueOf(CheckCnt.get("CNT"));
					}				
					if(cnt.equals("0")){
						//System.out.println("삭제불가(대상이 없음)");
						//삭제불가(대상이 없음)
						HashMap<String, String> errMap = new HashMap<String, String>();
						errMap.put("TRKNO", pData.get("TRKNO"));
						errMap.put("CUSNO", pData.get("CUSNO"));
						errMap.put("SHPNO", pData.get("SHPNO"));
						errMap.put("PRTNO", pData.get("PRTNO"));
						errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						shipmentDao.setFSAZ150ListDelete(pData);
					}
				}
			}
			
			while (it_iu.hasNext()) {
				HashMap<String, String> pData = (HashMap<String, String>) it_iu.next();
				//pData.put("LIB1", reqMap.get("LIB1"));
				pData.put("LIB2", reqMap.get("LIB2"));
				pData.put("COMPS", reqMap.get("COMPS"));
				pData.put("INPMN", reqMap.get("SUSER"));
				pData.put("TRAGB", reqMap.get("TRAGB"));
				String rowType = (String) pData.get("ROW_TYPE");
				String pGATCD = (String) pData.get("GATCD");
				String pTRACD = (String) pData.get("TRACD");
				String pCHASU = (String) pData.get("CHASU");
				String cnt="0";
				/*
				if ("insert".equals(rowType)) {
					if(!pGATCD.equals("")&&!pTRACD.equals("")&&!pCHASU.equals("")){
						//System.out.println("insert");
						HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ150Check(pData);
						if(CheckCnt != null){
							cnt =String.valueOf(CheckCnt.get("CNT"));
						}
						//System.out.println(cnt);

						//if(cnt.equals("1")){
						if(!cnt.equals("0")){
							//insert 불가(대상이 있음)
							HashMap<String, String> errMap = new HashMap<String, String>();
							errMap.put("TRKNO", pData.get("TRKNO"));
							errMap.put("CUSNO", pData.get("CUSNO"));
							errMap.put("SHPNO", pData.get("SHPNO"));
							errMap.put("PRTNO", pData.get("PRTNO"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							shipmentDao.setFSAZ150ListInsert(pData);
						}
					}

				} else if ("update".equals(rowType)) {
					HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ150Check(pData);
					if(CheckCnt != null){
						cnt =String.valueOf(CheckCnt.get("CNT"));
					}
					if(cnt.equals("0")){
						//삭제불가(대상이 없음)
						HashMap<String, String> errMap = new HashMap<String, String>();
						errMap.put("TRKNO", pData.get("TRKNO"));
						errMap.put("CUSNO", pData.get("CUSNO"));
						errMap.put("SHPNO", pData.get("SHPNO"));
						errMap.put("PRTNO", pData.get("PRTNO"));
						errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
						errList.add(errMap);
					}else{
						shipmentDao.setFSAZ150ListDelete(pData);
					}
				}
			}
			*/
			if ("update".equals(rowType)) {
				if(!pGATCD.equals("")&&!pTRACD.equals("")&&!pCHASU.equals("")){
					//System.out.println("insert");
					HashMap<String, String> CheckCnt = shipmentDao.selectFSAZ150Check(pData);
					if(CheckCnt != null){
						cnt =String.valueOf(CheckCnt.get("CNT"));
					}
					//System.out.println(cnt);

					if(!cnt.equals("0")){
						//insert 불가(대상이 있음)
						shipmentDao.setFSAZ150ListUpdate(pData);
					}else{
						shipmentDao.setFSAZ150ListInsert(pData);
					}
				}

			}
		}		
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	@Override
	public List<HashMap<String, String>> getFSAZ150ListView(HashMap<String, String> reqMap) {
		return shipmentDao.selectFSAZ150ListView(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getFSAZ151List(HashMap<String, String> reqMap) {
		return shipmentDao.selectFSAZ151List(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getFSAZ160QList(HashMap<String, String> reqMap) {
		return shipmentDao.selectFSAZ160QList(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getFSAZ160Q_PList(HashMap<String, String> reqMap) {
		return shipmentDao.selectFSAZ160Q_PList(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getFSAZ170QList(HashMap<String, String> reqMap) {
		return shipmentDao.selectFSAZ170QList(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getSC008PRList(HashMap<String, String> reqMap) {
		return shipmentDao.selectSC008PRList(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getFSAZ180QList(HashMap<String, String> reqMap) {
		return shipmentDao.selectFSAZ180QList(reqMap);
	}
}
