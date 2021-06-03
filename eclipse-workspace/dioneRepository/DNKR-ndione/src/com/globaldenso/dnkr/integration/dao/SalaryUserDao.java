package com.globaldenso.dnkr.integration.dao;

import java.util.List;
import java.util.Map;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.PsogmDomain;

/**
 * 
 * @파일명		: SalaryUserDao.java 
 * @프로젝트	: DNKR
 * @날짜		: 2019. 9. 20. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		사용자 교육 Dao
 * </pre>
 */
public interface SalaryUserDao {

	// 사용자 교육화면 정보
	Map<String, Object> getSalaryUser(Map<String, Object> map) throws ApplicationException;

	// 사용자교육 첨부파일 List로 취득
	List<Map<String, Object>> getFileDataList(String edu_pk) throws ApplicationException;
		
	// 교육에 따른 문제 리스트
	List<Map<String, Object>> userQueList(Map<String, Object> map) throws ApplicationException;
	
	// 교육에 따른 문제 리스트 - 답안지 리스트
	List<Map<String, Object>> userAnsList(Map<String, Object> map) throws ApplicationException;

	// 교육이수 답안지 제출	
	int salaryUserUpdate(Map<String, Object> map) throws ApplicationException;

	// 최초 등록 (연봉 등록)
	int setSalaryUserInfoInsert(Map<String, Object> map) throws ApplicationException;

	// 액셀 업로드(업데이트 등록)
	int setSalaryUserInfoUpdate(Map<String, Object> map) throws ApplicationException;
	
	// 연봉 파일명 가져오기
	public String getSalaryAttFileName(String edu_pk) throws ApplicationException; 

	// 동의서 내용 
	Map<String, Object> getSalaryAgree(Map<String, Object> map) throws ApplicationException;

	// 동의서 확인
	int agreeConfirm(Map<String, Object> map) throws ApplicationException;

	// 이미지 첨부파일
	int salaryUserAttchInsert(Map<String, Object> map) throws ApplicationException;

	// 사용자 교육화면 정보
	Map<String, Object> getSalaryUserInfo(Map<String, Object> map) throws ApplicationException;

	List<Map<String, Object>> getSalarySelectList(Map<String, Object> map) throws ApplicationException;
}
