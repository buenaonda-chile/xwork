/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.business.service;

import java.util.HashMap;
import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.RelationTeamDomain;

/**
 * [KR] 조직도(사업부서)관리 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface RelationTeamService {

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
     * [EN] Create a record in DNKR_RELATION_TEAM table.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(RelationTeamDomain domain, List<String> langList) throws ApplicationException;
    
    /**
     * [KO] 기본키로 사업부서(팀) 테이블의 데이터 수정하기<br>
     * [EN] Update a record in DNKR_RELATION_TEAM table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 사업부서(팀) 테이블의 데이터 수정하기<br>
     * [EN] Update a record in DNKR_RELATION_TEAM table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateAuth(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 사업부서(팀)테이블과 사업부명 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in DNKR_RELATION_TEAM and DNKR_RELATION_NM table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationTeamDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(RelationTeamDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도코드테이블의 레코드를 삭제한다.<br>
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
     * [KO] 기본키로 사업부서(팀) 테이블과 사업부명 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in DNKR_RELATION_TEAM and DNKR_RELATION_NM table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domainList List of 'RelationTeamDomain' class
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(List<RelationTeamDomain> domainList) throws ApplicationException;
    
    /**
     * [KO] 덴소 MA_DEPT 테이블을 받아와 세팅한다.<br>
     * [EN] Delete a record in DNKR_RELATION_TEAM_TMP table.<br>
     * [JP] <br>
     * 
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public HashMap procMergeDept() throws ApplicationException;
    
    
    /**
     * [KO] 덴소 DNKR_RELATION_CLASS  테이블을 받아와 세팅한다.<br>
     * [JP] <br>
     * 
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void searchByClsLocCode() throws ApplicationException;

}
