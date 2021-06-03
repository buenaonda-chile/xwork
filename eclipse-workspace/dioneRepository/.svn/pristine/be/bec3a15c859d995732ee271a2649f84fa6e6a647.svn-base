package com.denso.mapper;

import java.util.HashMap;
import java.util.List;


public interface LoginMapper {
	
	HashMap<String, String> checkLogin(String seq);

	//HashMap<String, String> checkLoginHUM(HashMap<String, String> reqMap);

	int insertLoginHistory(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> selectMenuList(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectComMsgList(HashMap<String, String> reqMap);
	/* System으로 이동
	List<HashMap<String, String>> selectMenuAuthList(HashMap<String, String> reqMap);
	*/
	List<HashMap<String, String>> selectLeftTopMenuList(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectBookMarkList(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectComCodeList(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectBtnAuthList(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectPassWordChange(HashMap<String, String> reqMap);

	void updatePassWordChange1(HashMap<String, String> reqMap);

	void updatePassWordChange2(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectUserNotice(HashMap<String, String> reqMap);

}
