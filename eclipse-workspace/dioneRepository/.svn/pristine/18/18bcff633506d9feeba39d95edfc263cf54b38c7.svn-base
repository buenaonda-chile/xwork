package com.denso.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.denso.dao.BudgetDao;
import com.denso.service.intf.BudgetService;

@Service
public class BudgetServiceImpl implements BudgetService{

	@Autowired
	private BudgetDao budgetDao;

	@Override
	public List<HashMap<String, String>> getMIZZXXXList(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZXXXList(reqMap);
	}
	
	@Override
	public List<HashMap<String, String>> getMST650PFList(HashMap<String, String> reqMap) {
		return budgetDao.selectMST650PFList(reqMap);
	}
	
	@Override
	public List<HashMap<String, String>> getCategoryList(HashMap<String, String> reqMap) {
		return budgetDao.selectCategoryList(reqMap);
	}
	
	@Override
	public List<HashMap<String, String>> getMIZZ220List(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ220List(reqMap);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setMIZZ220List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		Iterator<HashMap<String, String>> it_d = reqParam.iterator();
		Iterator<HashMap<String, String>> it_iu = reqParam.iterator();
		
		//삭제기능 미사용
		while (it_d.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_d.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("delete".equals(rowType)) {
				//System.out.println("delete");
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ220Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("삭제불가(대상이 없음)");
					//삭제불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("CATNO", pData.get("CATNO"));
					errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					budgetDao.setFSAZ100ListDelete(pData);
				}
			}
		}
		while (it_iu.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_iu.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			//pData.put("LIB2", reqMap.get("LIB2"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("insert".equals(rowType)) {
				//System.out.println("insert");
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ220Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}
				if(!cnt.equals("0")){
					//System.out.println("insert 불가(대상이 있음)");
					//insert 불가(대상이 있음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("CATNO", pData.get("CATNO"));
					errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					String t_CATNO = (String) pData.get("CATNO");
					pData.put("SEQNO", t_CATNO.substring(1, 6));
					budgetDao.setMIZZ220ListInsert(pData);
				}
			} else if ("update".equals(rowType)) {
				//System.out.println("update");
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ220Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("update 불가(대상이 없음)");
					//update 불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("CATNO", pData.get("CATNO"));
					errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					budgetDao.setMIZZ220ListUpdate(pData);
				}
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	
	/********************************************************************** 
	 * @exception : 경비예산관리System 	   - 경비예산 업체 등록 MIZZ221.XML
	***********************************************************************/
	@Override
	public List<HashMap<String, String>> getMIZZ221List(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ221List(reqMap);
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setMIZZ221List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		Iterator<HashMap<String, String>> it_d = reqParam.iterator();
		Iterator<HashMap<String, String>> it_iu = reqParam.iterator();
		
		//삭제기능 미사용
		while (it_d.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_d.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("delete".equals(rowType)) {
				//System.out.println("delete");
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ221Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("삭제불가(대상이 없음)");
					//삭제불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("VNDNR", pData.get("VNDNR"));
					errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					budgetDao.setFSAZ100ListDelete(pData);
				}
			}
		}
		while (it_iu.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_iu.next();
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("insert".equals(rowType)) {
				//System.out.println("insert");
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ221Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}
				if(!cnt.equals("0")){
					//System.out.println("insert 불가(대상이 있음)");
					//insert 불가(대상이 있음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("VNDNR", pData.get("VNDNR"));
					errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					budgetDao.setMIZZ221ListInsert(pData);
				}
			} else if ("update".equals(rowType)) {
				//System.out.println("update");
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ221Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("update 불가(대상이 없음)");
					//update 불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("VNDNR", pData.get("VNDNR"));
					errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					budgetDao.setMIZZ221ListUpdate(pData);
				}
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	
	/********************************************************************** 
	 * @exception : 경비예산관리System 	   - 경비예산 계정 등록 MIZZ222.XML
	***********************************************************************/
	@Override
	public List<HashMap<String, String>> getMIZZ222List(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ222List(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getMIZZ222_KYList(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ222_KYList(reqMap);
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setMIZZ222List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		Iterator<HashMap<String, String>> it_d = reqParam.iterator();
		Iterator<HashMap<String, String>> it_iu = reqParam.iterator();
		
		//삭제기능 미사용
		while (it_d.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_d.next();
			//pData.put("LIB1", reqMap.get("LIB1"));
			pData.put("LIB2", reqMap.get("LIB2"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("delete".equals(rowType)) {
				//System.out.println("delete");
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ222Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("삭제불가(대상이 없음)");
					//삭제불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("VNDNR", pData.get("VNDNR"));
					errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					budgetDao.setFSAZ100ListDelete(pData);
				}
			}
		}
		while (it_iu.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_iu.next();
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("insert".equals(rowType)) {
				//System.out.println("insert");
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ222Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}
				if(!cnt.equals("0")){
					//System.out.println("insert 불가(대상이 있음)");
					//insert 불가(대상이 있음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("VNDNR", pData.get("VNDNR"));
					errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					budgetDao.setMIZZ222ListInsert(pData);
				}
			} else if ("update".equals(rowType)) {
				//System.out.println("update");
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ222Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("update 불가(대상이 없음)");
					//update 불가(대상이 없음)
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("VNDNR", pData.get("VNDNR"));
					errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					budgetDao.setMIZZ222ListUpdate(pData);
				}
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	
	@Override
	public List<HashMap<String, String>> getMIZZ230List(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ230List(reqMap);
	}
	
	@Override
	public List<HashMap<String, String>> getMIZZ229List(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ229List(reqMap);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>> setMIZZ229UCList(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		
		HashMap<String, String> pDataD = new HashMap<String, String>();
		pDataD.put("COMPS", reqMap.get("COMPS"));
		pDataD.put("CATYY", reqMap.get("CATYY"));
		pDataD.put("CATGB", reqMap.get("CATGB"));
		pDataD.put("DPTCD", reqMap.get("DPTCD"));
		pDataD.put("USERID", reqMap.get("USERID"));
		pDataD.put("CATGB_YYYY", reqMap.get("CATGB_YYYY"));
		pDataD.put("CATGB_TARGET", reqMap.get("CATGB_TARGET"));
		budgetDao.setMIZZ229UPListDelete(pDataD);
		if (reqMap.get("CATGB").equals("P0")){
			budgetDao.setMIZZ229UCListInsert(pDataD);
		}
		if (reqMap.get("CATGB").equals("P1")){
			budgetDao.setMIZZ229UC_P1_ListInsert(pDataD);
		}
		
		/*
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			pData.put("COMPS", reqMap.get("COMPS"));
			pData.put("CATYY", reqMap.get("CATYY"));
			pData.put("CATGB", reqMap.get("CATGB"));
			pData.put("DPTCD", reqMap.get("DPTCD"));
			pData.put("USERID", reqMap.get("USERID"));
			budgetDao.setMIZZ229UPListInsert(pData);
		}
		*/
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>> setMIZZ229UPList(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		
		HashMap<String, String> pDataD = new HashMap<String, String>();
		pDataD.put("COMPS", reqMap.get("COMPS"));
		pDataD.put("CATYY", reqMap.get("CATYY"));
		pDataD.put("CATGB", reqMap.get("CATGB"));
		pDataD.put("DPTCD", reqMap.get("DPTCD"));
		budgetDao.setMIZZ229UPListDelete(pDataD);
		
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			pData.put("COMPS", reqMap.get("COMPS"));
			pData.put("CATYY", reqMap.get("CATYY"));
			pData.put("CATGB", reqMap.get("CATGB"));
			pData.put("DPTCD", reqMap.get("DPTCD"));
			pData.put("USERID", reqMap.get("USERID"));
			budgetDao.setMIZZ229UPListInsert(pData);
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
		
		
		
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setMIZZ229List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		Iterator<HashMap<String, String>> it_d = reqParam.iterator();
		Iterator<HashMap<String, String>> it_iu = reqParam.iterator();
		
		//삭제기능
		while (it_d.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_d.next();
			pData.put("COMPS", reqMap.get("COMPS"));
			pData.put("CATYY", reqMap.get("CATYY"));
			pData.put("CATGB", reqMap.get("CATGB"));
			pData.put("DPTCD", reqMap.get("DPTCD"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if (pData.get("VNDNR").equals(null) || pData.get("VNDNR").equals("") ){
				HashMap<String, String> errMap = new HashMap<String, String>();
				errMap.put("CATNO", pData.get("CATNO"));
				errMap.put("RTMSG", "업체코드는 필수입력..");
				errList.add(errMap);
				List<HashMap<String, String>> elist = errList;
				return elist;
			}
			if ("delete".equals(rowType)) {
				//System.out.println("delete");
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ229Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}
				if(cnt.equals("0")){
					//System.out.println("삭제불가(대상이 없음)");
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("CATNO", pData.get("CATNO"));
					errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					budgetDao.setMIZZ229ListDelete(pData);
				}
			}
		}
		//추가,수정 기능
		while (it_iu.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_iu.next();
			pData.put("COMPS", reqMap.get("COMPS"));
			pData.put("CATYY", reqMap.get("CATYY"));
			pData.put("CATGB", reqMap.get("CATGB"));
			pData.put("DPTCD", reqMap.get("DPTCD"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("insert".equals(rowType)) {
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ229Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}
				if(!cnt.equals("0")){
					//System.out.println("insert 불가(대상이 있음)");
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("CATNO", pData.get("CATNO"));
					errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					//String t_CATNO = (String) pData.get("CATNO");
					//pData.put("SEQNO", t_CATNO.substring(1, 6));
					budgetDao.setMIZZ229ListInsert(pData);
				}
			} else if ("update".equals(rowType)) {
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ229Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("update 불가(대상이 없음)");
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("CATNO", pData.get("CATNO"));
					errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					budgetDao.setMIZZ229ListUpdate(pData);
				}
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	
	@Override
	public List<HashMap<String, String>> getMIZZ229UList(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ229UList(reqMap);
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setMIZZ229UList(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		
		HashMap<String, String> pDataD = new HashMap<String, String>();
		pDataD.put("COMPS", reqMap.get("COMPS"));
		pDataD.put("CATYY", reqMap.get("CATYY"));
		pDataD.put("CATGB_SOURCE", reqMap.get("CATGB_SOURCE"));
		pDataD.put("CATGB_TARGET", reqMap.get("CATGB_TARGET"));
		budgetDao.setMIZZ229UListDelete(pDataD);
		
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			pData.put("CATYY", reqMap.get("CATYY"));
			pData.put("CATGB_SOURCE", reqMap.get("CATGB_SOURCE"));
			pData.put("CATGB_TARGET", reqMap.get("CATGB_TARGET"));
			String allCompsCheck = (String)reqMap.get("COMPS");
			if(allCompsCheck.equals("")){
				pData.put("COMPS", "E1");
				budgetDao.setMIZZ229U225ListInsert(pData);
				pData.put("COMPS", "C1");
				budgetDao.setMIZZ229U225ListInsert(pData);
				pData.put("COMPS", "H1");
				budgetDao.setMIZZ229U225ListInsert(pData);
				pData.put("COMPS", "S1");
				budgetDao.setMIZZ229U225ListInsert(pData);
				pData.put("COMPS", "K1");
				budgetDao.setMIZZ229U225ListInsert(pData);
			}else{
				pData.put("COMPS", reqMap.get("COMPS"));
				budgetDao.setMIZZ229U225ListInsert(pData);
			}
		}
		budgetDao.setMIZZ229U229ListInsert(pDataD);
		
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	
	@Override
	public List<HashMap<String, String>> getMIZZ229CList(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ229CList(reqMap);
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setMIZZ229CList(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		
		HashMap<String, String> pData = new HashMap<String, String>();
		pData.put("COMPS", reqMap.get("COMPS"));
		pData.put("CATYY", reqMap.get("CATYY"));
		pData.put("CATGB", reqMap.get("CATGB"));
		pData.put("USERID", reqMap.get("USERID"));
		//HashMap<String, String> CheckCnt = budgetDao.selectMIZZ229Check(pData);
		List<HashMap<String, String>> CheckCnt = budgetDao.selectMIZZ230List(pData);
		if(CheckCnt == null){
			HashMap<String, String> errMap = new HashMap<String, String>();
			errMap.put("RTMSG", "System Error.");
			errList.add(errMap);
		}else{
			if(CheckCnt.size() == 0){
				budgetDao.setMIZZ230ListInsert(pData);
				budgetDao.setMIZZ229CListInsert(pData);
			}else{
				HashMap<String, String> errMap = new HashMap<String, String>();
				errMap.put("RTMSG", "이미 경비예산 확정되어 진행불가.");
				errList.add(errMap);
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	
	/********************************************************************** 
	 * @exception : 경비예산관리System 	   - 경비실적 등록 MIZZ239.XML
	***********************************************************************/
	@Override
	public List<HashMap<String, String>> getMIZZ239List(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ239List(reqMap);
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>>  setMIZZ239List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		List<HashMap<String, String>> errList = new ArrayList<HashMap<String, String>>();
		Iterator<HashMap<String, String>> it_d = reqParam.iterator();
		Iterator<HashMap<String, String>> it_iu = reqParam.iterator();
		
		//삭제기능
		while (it_d.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_d.next();
			pData.put("COMPS", reqMap.get("COMPS"));
			pData.put("CATYY", reqMap.get("CATYY"));
			pData.put("CATGB", reqMap.get("CATGB"));
			pData.put("DPTCD", reqMap.get("DPTCD"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if (pData.get("VNDNR").equals(null) || pData.get("VNDNR").equals("") ){
				HashMap<String, String> errMap = new HashMap<String, String>();
				errMap.put("CATNO", pData.get("CATNO"));
				errMap.put("RTMSG", "업체코드는 필수입력..");
				errList.add(errMap);
				List<HashMap<String, String>> elist = errList;
				return elist;
			}
			if ("delete".equals(rowType)) {
				//System.out.println("delete");
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ239Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}
				if(cnt.equals("0")){
					//System.out.println("삭제불가(대상이 없음)");
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("CATNO", pData.get("CATNO"));
					errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					budgetDao.setMIZZ239ListDelete(pData);
				}
			}
		}
		//추가,수정 기능
		while (it_iu.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it_iu.next();
			pData.put("COMPS", reqMap.get("COMPS"));
			pData.put("CATYY", reqMap.get("CATYY"));
			pData.put("CATGB", reqMap.get("CATGB"));
			pData.put("DPTCD", reqMap.get("DPTCD"));
			String rowType = (String) pData.get("ROW_TYPE");
			String cnt="0";
			if ("insert".equals(rowType)) {
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ239Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}
				if(!cnt.equals("0")){
					//System.out.println("insert 불가(대상이 있음)");
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("CATNO", pData.get("CATNO"));
					errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					//String t_CATNO = (String) pData.get("CATNO");
					//pData.put("SEQNO", t_CATNO.substring(1, 6));
					budgetDao.setMIZZ239ListInsert(pData);
				}
			} else if ("update".equals(rowType)) {
				HashMap<String, String> CheckCnt = budgetDao.selectMIZZ239Check(pData);
				if(CheckCnt != null){
					cnt =String.valueOf(CheckCnt.get("CNT"));
				}				
				if(cnt.equals("0")){
					//System.out.println("update 불가(대상이 없음)");
					HashMap<String, String> errMap = new HashMap<String, String>();
					errMap.put("CATNO", pData.get("CATNO"));
					errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
					errList.add(errMap);
				}else{
					budgetDao.setMIZZ239ListUpdate(pData);
				}
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
	@Override
	public List<HashMap<String, String>> getMIZZ239_occList(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ239_occList(reqMap);
	}
	
	@Override
	public List<HashMap<String, String>> getMIZZ229Q1List(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ229Q1List(reqMap);
	}
	
	@Override
	public List<HashMap<String, String>> getMIZZ229Q2List(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ229Q2List(reqMap);
	}
	
	@Override
	public List<HashMap<String, String>> getMIZZ239Q1List(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ239Q1List(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getMIZZ239Q2List(HashMap<String, String> reqMap) {
		return budgetDao.selectMIZZ239Q2List(reqMap);
	}
	
	
	@Override
	public List<HashMap<String, String>> getFSAZ100List(HashMap<String, String> reqMap) {
		return budgetDao.selectFSAZ100List(reqMap);
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
				HashMap<String, String> CheckCnt = budgetDao.selectFSAZ100Check(pData);
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
					budgetDao.setFSAZ100ListDelete(pData);
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
				HashMap<String, String> CheckCnt = budgetDao.selectFSAZ100Check(pData);
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
					budgetDao.setFSAZ100ListInsert(pData);
				}
			} else if ("update".equals(rowType)) {
				//System.out.println("update");
				HashMap<String, String> CheckCnt = budgetDao.selectFSAZ100Check(pData);
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
					budgetDao.setFSAZ100ListUpdate(pData);
				}
			}
		}
		List<HashMap<String, String>> elist = errList;
		return elist;
	}
}
