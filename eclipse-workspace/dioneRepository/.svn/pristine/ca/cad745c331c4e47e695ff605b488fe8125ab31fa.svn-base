package com.denso.service.intf;

import java.util.HashMap;
import java.util.List;

public interface LoginService {
	
	String getLibraryCode(String tempSt);
	
	HashMap<String, String> checkLogin(String seq);

	//HashMap<String, String> checkLoginHUM(HashMap<String, String> reqMap);
	
	int insertLoginHistory(HashMap<String, String> reqMap);

	List<HashMap<String, String>> getMenuList(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> getComMsgList(HashMap<String, String> reqMap);
	/* System으로 이동
	List<HashMap<String, String>> getMenuAuthList(HashMap<String, String> reqMap);
	*/
	List<HashMap<String, String>> getLeftTopMenuList(HashMap<String, String> reqMap);

	List<HashMap<String, String>> getBookMarkList(HashMap<String, String> reqMap);

	List<HashMap<String, String>> getComCodeList(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> getBtnAuthList(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> getPassWordChange(HashMap<String, String> reqMap);
	
	void setPassWordChang1(List<HashMap<String, String>> reqMap);

	void setPassWordChang2(List<HashMap<String, String>> reqMap);

	List<HashMap<String, String>> getUserNotice(HashMap<String, String> reqMap);

}
