package com.denso.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denso.dao.SystemDao;
import com.denso.service.intf.SystemService;

@Service
public class SystemServiceImpl implements SystemService{

	@Autowired
	private SystemDao systemDao;

	@Override
	public List<HashMap<String, String>> getMenuAuthList(HashMap<String, String> reqMap) {
		return systemDao.selectMenuAuthList(reqMap);
	}
	@Override
	public void setMenuAuth(List<HashMap<String, String>> reqMap){
		Iterator<HashMap<String, String>> it = reqMap.iterator();
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			systemDao.setMenuAuthDelete(pData);
			systemDao.setMenuAuthInsert(pData);
		}
	}
	@Override
	public void setMenuLog(List<HashMap<String, String>> reqMap){
		Iterator<HashMap<String, String>> it = reqMap.iterator();
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			systemDao.setMenuLogInsert(pData);
		}
	}
	@Override
	public void setBookMark(List<HashMap<String, String>> reqMap){
		Iterator<HashMap<String, String>> it = reqMap.iterator();
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			String rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				System.out.println("insert");
				systemDao.setBookMarkDelete(pData);
				systemDao.setBookMarkInsert(pData);
			} else if ("update".equals(rowType)) {
				System.out.println("update");
			} else if ("delete".equals(rowType)) {
				systemDao.setBookMarkDelete(pData);
				System.out.println("delete");
			}
		}
	}	
	
	@Override
	public List<HashMap<String, String>> getUserList(HashMap<String, String> reqMap) {
		return systemDao.selectUserList(reqMap);
	}
	@Override
	public void setUserList(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		String modifyUser = (String)reqMap.get("CREATE_USER");
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			pData.put("CREATE_USER", modifyUser);
			String rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				System.out.println("insert");
				systemDao.setUserListInsert(pData);
			} else if ("update".equals(rowType)) {
				systemDao.setUserListUpdate(pData);
				System.out.println("update");
			} else if ("delete".equals(rowType)) {
				systemDao.setUserListDelete(pData);
				System.out.println("delete");
			}
		}
	}
	/*
	@Override
	public void setUserList(HashMap<String, String> reqMap) {
		String rowType = (String) reqMap.get("ROW_TYPE");
		if ("insert".equals(rowType)) {
			System.out.println("insert");
			//dao.insertData("user.insertUser", pData);
		} else if ("update".equals(rowType)) {
			//dao.updateData("user.updateUser", pData);
			//systemService.setUserListUpdate(pData);
			System.out.println("update");
		} else if ("delete".equals(rowType)) {
			//dao.deleteData("user.deleteUser", pData);
			System.out.println("delete");
		}
	}
	*/
	@Override
	public List<HashMap<String, String>> getButtonAuthList(HashMap<String, String> reqMap) {
		return systemDao.selectButtonAuthList(reqMap);
	}
	@Override
	public void setButtonAuth(List<HashMap<String, String>> reqMap){
		Iterator<HashMap<String, String>> it = reqMap.iterator();
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			for(int i=1; i<=7; i++){
				pData.put("BUTTON_ID",Integer.toString(i));
				pData.put("BTN_AUTH", (String)pData.get("BTN" + i ));
				systemDao.setButtonAuthDelete(pData);
				systemDao.setButtonAuthInsert(pData);
			}
		}
	}
	@Override
	public List<HashMap<String, String>> getFavoriteAuthList(HashMap<String, String> reqMap) {
		return systemDao.selectFavoriteAuthList(reqMap);
	}
	@Override
	public void setFavoriteAuth(List<HashMap<String, String>> reqMap){
		Iterator<HashMap<String, String>> it = reqMap.iterator();
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			if ("1".equals(pData.get("USER_YN"))) {
				systemDao.setBookMarkDelete(pData);
				systemDao.setBookMarkInsert(pData);
			}	else {
				systemDao.setBookMarkDelete(pData);
			}	
		}		
	}
	@Override
	public List<HashMap<String, String>> getEmployList(HashMap<String, String> reqMap) {
		return systemDao.selectEmployList(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getMenuAuthGroupList(HashMap<String, String> reqMap) {
		return systemDao.selectMenuAuthGroupList(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getUpMenuCodeList(HashMap<String, String> reqMap) {
		return systemDao.selectUpMenuCodeList(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getTopMenuCodeList(HashMap<String, String> reqMap) {
		return systemDao.selectTopMenuCodeList(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getMenuList(HashMap<String, String> reqMap) {
		return systemDao.selectMenuList(reqMap);
	}
	@Override
	public void setMenuList(List<HashMap<String, String>> reqMap){
		Iterator<HashMap<String, String>> it = reqMap.iterator();
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			String rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				System.out.println("insert");
				systemDao.setMenuListInsert(pData);
			} else if ("update".equals(rowType)) {
				systemDao.setMenuListUpdate(pData);
				System.out.println("update");
			} else if ("delete".equals(rowType)) {
				systemDao.setMenuListDelete(pData);
				System.out.println("delete");
			}
		}
	}	
	@Override
	public List<HashMap<String, String>> getComCodeClass(
			HashMap<String, String> reqMap) {
		return systemDao.selectComCodeClass(reqMap);
	}

	@Override
	public List<HashMap<String, String>> getComCode(
			HashMap<String, String> reqMap) {
		return systemDao.selectComCode(reqMap);
	}

	@Override
	public void saveComCode(List<HashMap<String, String>> pList) {
		
		for (HashMap<String, String> reqMap : pList) {
			String rowType = reqMap.get("ROW_TYPE");

			if ("insert".equals(rowType)) {
				systemDao.insertComCode(reqMap);
			} else if ("update".equals(rowType)) {
				systemDao.updateComCode(reqMap);
			} else if ("delete".equals(rowType)) {
				systemDao.deleteComCode(reqMap);
			}
		}

	}
	
	@Override
	public List<HashMap<String, String>> getMessage(
			HashMap<String, String> reqMap) {
		return systemDao.selectMessage(reqMap);
	}
	
	@Override
	public void saveMessage(List<HashMap<String, String>> pList) {
		
		for (HashMap<String, String> reqMap : pList) {
			String rowType = reqMap.get("ROW_TYPE");

			if ("insert".equals(rowType)) {
				systemDao.insertMessage(reqMap);
			} else if ("update".equals(rowType)) {
				systemDao.updateMessage(reqMap);
			} else if ("delete".equals(rowType)) {
				systemDao.deleteMessage(reqMap);
			}
		}
	}
	@Override
	public List<HashMap<String, String>> getMenuLog(
			HashMap<String, String> reqMap) {
		return systemDao.selectMenuLog(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getNoticeList(HashMap<String, String> reqMap) {
		return systemDao.selectNoticeList(reqMap);
	}
	@Override
	public void setNoticeList(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam){
		String modifyUser = (String)reqMap.get("CREATE_USER");
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			pData.put("CREATE_USER", modifyUser);
			String rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				//System.out.println("insert");
				systemDao.setNoticeListInsert(pData);
			} else if ("update".equals(rowType)) {
				//System.out.println("update");
				systemDao.setNoticeListUpdate(pData);
			} else if ("delete".equals(rowType)) {
				//System.out.println("delete");
				systemDao.setNoticeListDelete(pData);
			}
		}
	}
	@Override
	public List<HashMap<String, String>> getFSA120PF(HashMap<String, String> reqMap) {
		return systemDao.selectFSA120PF(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getMIZ221PF(HashMap<String, String> reqMap) {
		return systemDao.selectMIZ221PF(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getMIZ220PF(HashMap<String, String> reqMap) {
		return systemDao.selectMIZ220PF(reqMap);
	}
}