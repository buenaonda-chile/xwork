package com.denso.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denso.dao.LoginDao;
import com.denso.service.intf.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;

	@Override
	public HashMap<String, String> checkLogin(String seq) {
		return loginDao.checkLogin(seq);
	}
	/*
	@Override
	public HashMap<String, String> checkLoginHUM(HashMap<String, String> reqMap) {
		return loginDao.checkLoginHUM(reqMap);
	}
	*/
	@Override
	public int insertLoginHistory(HashMap<String, String> reqMap) {
		return loginDao.insertLoginHistory(reqMap);
	}
	
	@Override
	public String getLibraryCode(String tempSt) {
		String lib = "PSEDBLIB";
		if (tempSt != null) {
			if (tempSt.substring(0, 1).equals("C")) {
				lib = "PSCDBLIB";
			} else if (tempSt.substring(0, 1).equals("H")) {
				lib = "PSHDBLIB";
			} else if (tempSt.substring(0, 1).equals("S")) {
				lib = "PSSDBLIB";
			}
		}
		return lib;
	}
	@Override
	public List<HashMap<String, String>> getMenuList(HashMap<String, String> reqMap) {
		return loginDao.selectMenuList(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getComMsgList(HashMap<String, String> reqMap) {
		return loginDao.selectComMsgList(reqMap);
	}
	/* System으로 이동
	@Override
	public List<HashMap<String, String>> getMenuAuthList(HashMap<String, String> reqMap) {
		return loginDao.selectMenuAuthList(reqMap);
	}
	*/
	@Override
	public List<HashMap<String, String>> getLeftTopMenuList(HashMap<String, String> reqMap) {
		return loginDao.selectLeftTopMenuList(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getBookMarkList(HashMap<String, String> reqMap) {
		return loginDao.selectBookMarkList(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getComCodeList(HashMap<String, String> reqMap) {
		return loginDao.selectComCodeList(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getBtnAuthList(HashMap<String, String> reqMap) {
		return loginDao.selectBtnAuthList(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getPassWordChange(HashMap<String, String> reqMap) {
		return loginDao.selectPassWordChange(reqMap);
	}
	@Override
	public void setPassWordChang1(List<HashMap<String, String>> reqMap){
		Iterator<HashMap<String, String>> it = reqMap.iterator();
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			loginDao.setPassWordChange1Update(pData);
		}
	}
	@Override
	public void setPassWordChang2(List<HashMap<String, String>> reqMap){
		Iterator<HashMap<String, String>> it = reqMap.iterator();
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			loginDao.setPassWordChange2Update(pData);
		}
	}
	@Override
	public List<HashMap<String, String>> getUserNotice(HashMap<String, String> reqMap) {
		return loginDao.selectUserNotice(reqMap);
	}
}