package com.denso.mapper;

import java.util.HashMap;
import java.util.List;


public interface SystemMapper {
	
	List<HashMap<String, String>> selectMenuAuthList(HashMap<String, String> reqMap);

	void insertMenuAuth(HashMap<String, String> reqMap);

	void deleteMenuAuth(HashMap<String, String> reqMap);
		
	void insertMenuLog(HashMap<String, String> reqMap);

	void insertBookMark(HashMap<String, String> reqMap);

	void deleteBookMark(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectUserList(HashMap<String, String> reqMap);
	
	void insertUserList(HashMap<String, String> reqMap);

	void updateUserList(HashMap<String, String> reqMap);

	void deleteUserList(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectButtonAuthList(HashMap<String, String> reqMap);
	
	void insertButtonAuth(HashMap<String, String> reqMap);

	void deleteButtonAuth(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> selectFavoriteAuthList(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> selectEmployList(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> selectMenuAuthGroupList(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectUpMenuCodeList(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectTopMenuCodeList(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectMenuList(HashMap<String, String> reqMap);

	void insertMenuList(HashMap<String, String> reqMap);

	void updateMenuList(HashMap<String, String> reqMap);

	void deleteMenuList(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> selectComCodeClass(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectComCode(HashMap<String, String> reqMap);

	void insertComCode(HashMap<String, String> reqMap);

	void updateComCode(HashMap<String, String> reqMap);

	void updateComCodeClassName(HashMap<String, String> reqMap);

	void deleteComCode(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectMessage(HashMap<String, String> reqMap);

	void insertMessage(HashMap<String, String> reqMap);

	void updateMessage(HashMap<String, String> reqMap);

	void deleteMessage(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectMenuLog(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> selectNoticeList(HashMap<String, String> reqMap);
	
	void insertNoticeList(HashMap<String, String> reqMap);

	void updateNoticeList(HashMap<String, String> reqMap);

	void deleteNoticeList(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> selectFSA120PF(HashMap<String, String> reqMap);
	List<HashMap<String, String>> selectMIZ221PF(HashMap<String, String> reqMap);
	List<HashMap<String, String>> selectMIZ220PF(HashMap<String, String> reqMap);
}
