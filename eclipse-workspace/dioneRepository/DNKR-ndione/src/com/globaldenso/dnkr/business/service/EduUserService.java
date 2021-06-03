package com.globaldenso.dnkr.business.service;

import java.util.List;
import java.util.Map;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.constant.CommandMap;

/**
 * 
 * @파일명		: EduUserService.java 
 * @프로젝트	: DNKR
 * @날짜		: 2019. 9. 20. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		사용자 교육 Service
 * </pre>
 */
public interface EduUserService {

	// 사용자 교육화면 정보
	Map<String, Object> getEduUser(CommandMap commandMap) throws ApplicationException;
	
	// 사용자 교육 첨부파일 List로 취득
	List<Map<String, Object>> getFileDataList(String edu_pk) throws ApplicationException;
		
	// 사용자 교육의 참여정보 
	Map<String, Object> getEduUserInfo(CommandMap commandMap) throws ApplicationException;

	// 교육에 따른 문제 리스트
	List<Map<String, Object>> userQueList(CommandMap commandMap) throws ApplicationException;

	// 교육에 따른 문제 리스트 - 답안지 리스트
	List<Map<String, Object>> userAnsList(CommandMap commandMap) throws ApplicationException;

	// 사용자 답안지 저장
	Map<String, String> eduUserSave(CommandMap commandMap) throws ApplicationException, Exception;

	// 사용자 동의서 내용
	Map<String, Object> getEduAgree(CommandMap commandMap) throws ApplicationException, Exception;

	// 사용자 동의서 확인
	Map<String, String> agreeConfirm(CommandMap commandMap) throws ApplicationException, Exception;

	Map<String, Object> getEduSelectList(CommandMap commandMap) throws ApplicationException;

}
