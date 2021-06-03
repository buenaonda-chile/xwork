package com.globaldenso.dnkr.integration.dao;

import java.util.List;
import java.util.Map;

import com.globaldenso.ai.core.exception.ApplicationException;

/**
 * 
 * @파일명		: EduUserDao.java 
 * @프로젝트	: DNKR
 * @날짜		: 2019. 9. 20. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		사용자 교육 Dao
 * </pre>
 */
public interface EduUserDao {

	// 사용자 교육화면 정보
	Map<String, Object> getEduUser(Map<String, Object> map) throws ApplicationException;

	// 교육에 따른 문제 리스트
	List<Map<String, Object>> userQueList(Map<String, Object> map) throws ApplicationException;
	
	// 교육에 따른 문제 리스트 - 답안지 리스트
	List<Map<String, Object>> userAnsList(Map<String, Object> map) throws ApplicationException;

	// 교육이수 답안지 제출	
	int eduUserInsert(Map<String, Object> map) throws ApplicationException;

	// 동의서 내용 
	Map<String, Object> getEduAgree(Map<String, Object> map) throws ApplicationException;

	// 동의서 확인
	int agreeConfirm(Map<String, Object> map) throws ApplicationException;

	// 이미지 첨부파일
	int eduUserAttchInsert(Map<String, Object> map) throws ApplicationException;

	// 사용자 교육화면 정보
	Map<String, Object> getEduUserInfo(Map<String, Object> map) throws ApplicationException;

	List<Map<String, Object>> getEduSelectList(Map<String, Object> map) throws ApplicationException;
}
