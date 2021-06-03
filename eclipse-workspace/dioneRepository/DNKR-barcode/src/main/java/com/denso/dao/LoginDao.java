package com.denso.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.denso.mapper.LoginMapper;

@Repository
public class LoginDao {

	@Autowired
	private LoginMapper LoginMapper;
	
	public HashMap<String, String> checkLogin(String seq) {
		return LoginMapper.checkLogin(seq);
	}
	public int insertLoginHistory(HashMap<String, String> reqMap) {
		return LoginMapper.insertLoginHistory(reqMap);
	}

/*	
	public HashMap<String, String> checkLoginHUM(HashMap<String,String> reqMap) {
		return LoginMapper.checkLoginHUM(reqMap);
	}
*/
	public List<HashMap<String, String>> selectMenuList(HashMap<String, String> reqMap) {
		return LoginMapper.selectMenuList(reqMap);
	}
	public List<HashMap<String, String>> selectComMsgList(HashMap<String, String> reqMap) {
		return LoginMapper.selectComMsgList(reqMap);
	}
	/* System으로 이동
	public List<HashMap<String, String>> selectMenuAuthList(HashMap<String, String> reqMap) {
		return LoginMapper.selectMenuAuthList(reqMap);
	}
	*/
	public List<HashMap<String, String>> selectLeftTopMenuList(HashMap<String, String> reqMap) {
		return LoginMapper.selectLeftTopMenuList(reqMap);
	}
	public List<HashMap<String, String>> selectBookMarkList(HashMap<String, String> reqMap) {
		return LoginMapper.selectBookMarkList(reqMap);
	}
	public List<HashMap<String, String>> selectComCodeList(HashMap<String, String> reqMap) {
		return LoginMapper.selectComCodeList(reqMap);
	}
	public List<HashMap<String, String>> selectBtnAuthList(HashMap<String, String> reqMap) {
		return LoginMapper.selectBtnAuthList(reqMap);
	}
	public List<HashMap<String, String>> selectPassWordChange(HashMap<String, String> reqMap) {
		return LoginMapper.selectPassWordChange(reqMap);
	}
	public void setPassWordChange1Update(HashMap<String, String> reqMap) {
		LoginMapper.updatePassWordChange1(reqMap);
	}
	public void setPassWordChange2Update(HashMap<String, String> reqMap) {
		LoginMapper.updatePassWordChange2(reqMap);
	}
	public List<HashMap<String, String>> selectUserNotice(HashMap<String, String> reqMap) {
		return LoginMapper.selectUserNotice(reqMap);
	}
}
