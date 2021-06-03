/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.integration.dao;

import java.util.HashMap;
import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.MaDeptDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;

/**
 * [KO] 사업부서(팀) 정보의 DAO interface.<br>
 * [EN] <br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface RelationTeamDao {

    /**
     * [KO] 기본키로  DB table 에서 사업부서(팀) 정보를 검색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return 'RelationTeamDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public RelationTeamDomain searchByKey(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 사업부서(팀) 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return List of 'RelationTeamDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<RelationTeamDomain> searchByCondition(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 사업부서(팀) 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return List of 'RelationTeamDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<RelationTeamDomain> searchByConditionForPaging(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 사업부서(팀) 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 조직도 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] Search Common code information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchTeamCount(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업부서(팀) 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in DNKR_RELATION_CLASS table.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @param langList List<String><br> 
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(RelationTeamDomain domain, List<String> langList) throws ApplicationException;
    
    /**
     * [KO] 사업부 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in DNKR_RELATION_CLASS table.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createCode(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 조직도 명칭 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in DNKR_RELATION_NM table.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createName(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 사업부서(팀) 테이블의 데이터 수정하기<br>
     * [EN] Update a record in DNKR_RELATION_CLASS table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도 테이블의 데이터 수정하기.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateCode(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도 테이블의 데이터 수정하기.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateAuth(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도 명칭 테이블의 데이터 수정하기.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateName(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 사업부서(팀) 테이블과 사업부명 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in DNKR_RELATION_CLASS and DNKR_RELATION_NM table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain of 'RelationTeamDomain' class
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도 코드테이블의 레코드를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteCode(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도 명칭의 테이블의 레코드를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteName(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 데이터 전송전 임시 부서테이블 데이터를 삭제 한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void insertDeptTmpData() throws ApplicationException;
    
    /**
     * [KO] 데이터 전송전 임시 부서테이블 데이터를 삭제 한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param 
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteTmp() throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 사업부서(팀) 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @return List of 'MaDeptDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<MaDeptDomain> searchMaDeptList() throws ApplicationException;
    
    /**
     * [KO] 조직도 명칭 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in DNKR_RELATION_NM table.<br>
     * [JP] <br>
     * 
     * @param list List of 'MaDeptDomain' class
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int insertDept(List<MaDeptDomain> list) throws ApplicationException;
    
    /**
     * [KO] 부서를 받아오는 프로시저를 호출한다<br>
     * [EN] Select PROC_MERGE_TEAM procedure.<br>
     * [JP] <br>
     * 
     * @param map HashMap
     * @return HashMap
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public HashMap procMergeTeam(HashMap map) throws ApplicationException;
    
    
    /**
     * [KO] 과거부서코드 미사용으로 전환<br>
     * [EN] Select PROC_MERGE_TEAM procedure.<br>
     * [JP] <br>
     * @auth  JHB(2019.04.17)
     * @param map HashMap
     * @return HashMap
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<RelationTeamDomain> searchByClsLocCode() throws ApplicationException;
    public int updateTeamLatestYearUse(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 과거부서코드 미사용으로 전환<br>
     * [EN] Select PROC_MERGE_TEAM procedure.<br>
     * [JP] <br>
     * @auth  JHB(2020.09.11)
     * @param map HashMap
     * @return HashMap
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateDeptUseTf() throws ApplicationException;

}
