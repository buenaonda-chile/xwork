/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.RelationLocDomain;

/**
 * [KO] 사업장 정보의 DAO interface.<br>
 * [EN] <br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface RelationLocDao {

    /**
     * [KO] 기본키로  DB table 에서 사업장 정보를 검색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationLocDomain' class
     * @return 'RelationLocDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public RelationLocDomain searchByKey(RelationLocDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 사업장 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationLocDomain' class
     * @return List of 'RelationLocDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<RelationLocDomain> searchByCondition(RelationLocDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 사업장 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationLocDomain' class
     * @return List of 'RelationLocDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<RelationLocDomain> searchByConditionForPaging(RelationLocDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 사업장 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationLocDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(RelationLocDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 조직도 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] Search Common code information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchLocCount(RelationLocDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in DNKR_RELATION_LOCATION table.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationLocDomain' class
     * @param langList List<String><br> 
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(RelationLocDomain domain, List<String> langList) throws ApplicationException;
    
    /**
     * [KO] 사업장 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in DNKR_RELATION_LOCATION table.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationLocDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createCode(RelationLocDomain domain) throws ApplicationException;
    
    /**
     * [KO] 조직도 명칭 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in DNKR_RELATION_NM table.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationLocDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createName(RelationLocDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 사업장 테이블의 데이터 수정하기<br>
     * [EN] Update a record in DNKR_RELATION_LOCATION table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationLocDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(RelationLocDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도 테이블의 데이터 수정하기.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationLocDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateCode(RelationLocDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도 명칭 테이블의 데이터 수정하기.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationLocDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateName(RelationLocDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 사업장 테이블과 사업부명 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in DNKR_RELATION_LOCATION and DNKR_RELATION_NM table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain of 'RelationLocDomain' class
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(RelationLocDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도 코드테이블의 레코드를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationLocDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteCode(RelationLocDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도 명칭의 테이블의 레코드를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationLocDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteName(RelationLocDomain domain) throws ApplicationException;
}
