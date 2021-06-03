package com.globaldenso.dnkr.integration.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.CaseInsensitiveMap;

import com.globaldenso.ai.core.exception.ApplicationException;

/**
 * 
 * @파일명		: SalaryDao.java 
 * @프로젝트	: DNKR
 * @날짜		: 2019. 9. 20. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		관리자 교육 Dao
 * </pre>
 */
public interface SalaryDao {

	// 교육목록 리스트
	List<Map<String, Object>> getSalaryList(Map<String, Object> map) throws ApplicationException;

	// 교육상세 정보
	Map<String, Object> getSalary(Map<String, Object> map) throws ApplicationException;
	
	// 교육상세 수정을 위한 PK정보
	int getSalaryPk(Map<String, Object> map) throws ApplicationException;
	
	// 선택한 팀의 코드로 사번 취득
	//List<Map<String, Object>> getEmpNumber(Map<String, Object> map) throws ApplicationException;
	List<Map<String, Object>> getEmpNumber(CaseInsensitiveMap empDomain) throws ApplicationException;
	
	// 교육상세 정보 입력
	int salaryInsert(Map<String, Object> map) throws ApplicationException;
	
	// 교육상세 첨부파일 입력
	int salaryAttchInsert(Map<String, Object> map) throws ApplicationException;

	// 교육상세 수정
	int salaryUpdate(Map<String, Object> map) throws ApplicationException;
	
	// 교육상세 첨부파일 수정
	//int salaryAttachUpdate(Map<String, Object> map) throws ApplicationException;
    
	// 교육상세 첨부파일 List로 취득
	List<Map<String, Object>> getFileDataList(String salary_pk) throws ApplicationException;

	// 교육상세 첨부파일 전체 삭제
	int salaryAttachAllDel(Map<String, Object> map) throws ApplicationException;
	
	// 교육상세 첨부파일 1건 삭제
	int salaryAttachDel(Map<String, Object> map) throws ApplicationException;
	
	// 교육상세 삭제
	int salaryDel(Map<String, Object> map) throws ApplicationException;
	

	// 문제목록 리스트
	List<Map<String, Object>> getQueList(Map<String, Object> map) throws ApplicationException;

	// 문제상세 입력
	int queInsert(Map<String, Object> map) throws ApplicationException;

	// 문제상세 수정
	int queUpdate(Map<String, Object> map) throws ApplicationException;
	
	// 문제상세 수정을 위한 PK정보
	int getQuePk(Map<String, Object> map) throws ApplicationException;
	
	// 답안지 입력
	int ansInsert(Map<String, Object> map) throws ApplicationException;

	// 문제상세 정보
	Map<String, Object> getQue(Map<String, Object> map) throws ApplicationException;

	// 문제에 따른 답안지 리스트
	List<Map<String, Object>> getAnsList(Map<String, Object> map) throws ApplicationException;

	// 문제상세 삭제
	int queDel(Map<String, Object> map) throws ApplicationException;

	// 답안지 리스트 삭제
	int ansDel(Map<String, Object> map) throws ApplicationException;
	
	// 문제에 따른 답안지 삭제
	int queToAnsDel(Map<String, Object> map) throws ApplicationException;

	// 문제에 따른 문제 삭제
	int queToQueDel(Map<String, Object> map) throws ApplicationException;

	// 교육대상 사업부 리스트
	List<Map<String, Object>> getClsCodeList(Map<String, Object> map) throws ApplicationException;

	// 교육대상 사업장 리스트
	List<Map<String, Object>> getLocCodeList(Map<String, Object> map) throws ApplicationException;

	// 교육대상 부서(팀) 리스트
	List<Map<String, Object>> getTeamCodeList(Map<String, Object> map) throws ApplicationException;

	// 교육목록 리스트
	List<Map<String, Object>> getSalaryRltList(Map<String, Object> map) throws ApplicationException;

	// 교육대상자 현환 리스트
	List<Map<String, Object>> getSalaryRltDtlList(Map<String, Object> map) throws ApplicationException;

	// 교육대상자중 미완료자 메일 취득
	List<Map<String, Object>> getNoSalaryMailList(String salary_pk) throws ApplicationException;

}
