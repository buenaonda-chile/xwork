package com.globaldenso.dnkr.business.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.constant.CommandMap;

/**
 * 
 * @파일명		: EduService.java 
 * @프로젝트	: DNKR
 * @날짜		: 2019. 9. 20. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		관리자 교육 Service
 * </pre>
 */
public interface EduService {

	// 문제목록 리스트
	Map<String, Object> getEduList(CommandMap commandMap) throws ApplicationException;

	// 교육에 대한 상세 정보 호출
	Map<String, Object> getEdu(CommandMap commandMap) throws ApplicationException, Exception;
		
	// 교육상세 첨부파일 List로 취득
	List<Map<String, Object>> getFileDataList(String edu_pk) throws ApplicationException;
	
	//첨부파일 저장
	Map<String, Object> saveAttachFile(MultipartFile file, MultipartHttpServletRequest request, CommandMap commandMap) throws Exception;
	
	// 교육 정보 저장
	Map<String, String> eduSave(CommandMap commandMap, MultipartHttpServletRequest request, HttpServletResponse response) throws ApplicationException, Exception;

	// 첨부파일 DB논리삭제
	Map<String, String> eduAttachDel(CommandMap commandMap) throws Exception;
	
	// 교육 정보 삭제
	Map<String, String> eduDel(CommandMap commandMap) throws ApplicationException, Exception;

	// 문제목록 리스트
	Map<String, Object> getQueList(CommandMap commandMap) throws ApplicationException;

	// 문제상세 저장
	Map<String, String> queSave(CommandMap commandMap) throws ApplicationException, Exception;

	// 문제상세 정보
	Map<String, Object> getQue(CommandMap commandMap) throws ApplicationException, Exception;

	// 문제에 따른 답안지 리스트
	List<Map<String, Object>> getAnsList(CommandMap commandMap) throws ApplicationException, Exception;

	// 문제 삭제
	Map<String, String> queDel(CommandMap commandMap) throws ApplicationException, Exception;

	// 교육대상 사업부 리스트
	Map<String, Object> getClsCodeList(CommandMap commandMap) throws ApplicationException, Exception;

	// 교육대상 사업장 리스트
	Map<String, Object> getLocCodeList(CommandMap commandMap) throws ApplicationException, Exception;

	// 교육대상 부서(팀) 리스트
	Map<String, Object> getTeamCodeList(CommandMap commandMap) throws ApplicationException, Exception;
	
	// 교육 현황 리스트// 교육 현황 리스트
	Map<String, Object> getEduRltList(com.globaldenso.dnkr.constant.CommandMap commandMap) throws ApplicationException;

	// 교육 현황 상세 목록
	Map<String, Object> getEduDtlRltList(com.globaldenso.dnkr.constant.CommandMap commandMap) throws ApplicationException;

	// 교육대상자중 미완료자 메일 취득
	List<Map<String, Object>> getNoEduMailList(String edu_pk) throws ApplicationException;
}
