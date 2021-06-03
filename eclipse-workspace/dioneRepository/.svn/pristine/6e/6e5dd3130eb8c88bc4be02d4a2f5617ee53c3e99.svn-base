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
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationDb2Domain;

/**
 * [KO] 사업부 정보의 DAO interface.<br>
 * [EN] <br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface RelationClsDao {

    /**
     * [KO] 기본키로  DB table 에서 사업부 정보를 검색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class
     * @return 'RelationClsDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public RelationClsDomain searchByKey(RelationClsDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 사업부 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class
     * @return List of 'RelationClsDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<RelationClsDomain> searchByCondition(RelationClsDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 사업부 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class
     * @return List of 'RelationClsDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<RelationClsDomain> searchByConditionForPaging(RelationClsDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 사업부 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(RelationClsDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업부 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in DNKR_RELATION_CLASS table.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class<br>
     * @param langList List<String><br> 
     * @throws ApplicationException Application exception of 'Application Infrastructure'<br>
     */
    public void create(RelationClsDomain domain, List<String> langList) throws ApplicationException;
    
    /**
     * [KO] 사업부 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in DNKR_RELATION_CLASS table.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createCode(RelationClsDomain domain) throws ApplicationException;
    
    /**
     * [KO] 조직도 명칭 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in DNKR_RELATION_NM table.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createName(RelationClsDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 사업부 테이블의 데이터 수정하기<br>
     * [EN] Update a record in DNKR_RELATION_CLASS table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(RelationClsDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도 테이블의 데이터 수정하기.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateCode(RelationClsDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도 명칭 테이블의 데이터 수정하기.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateName(RelationClsDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 사업부 테이블과 사업부명 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in DNKR_RELATION_CLASS and DNKR_RELATION_NM table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain of 'RelationClsDomain' class
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(RelationClsDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도 코드테이블의 레코드를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteCode(RelationClsDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 조직도 명칭의 테이블의 레코드를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationClsDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteName(RelationClsDomain domain) throws ApplicationException;
    
    /*========================== DB2 ===================================================*/
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 사업부 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationDb2Domain' class
     * @return List of 'RelationDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<RelationDb2Domain> selectOGMgauge_Mst650pf(RelationDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 파트 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationDb2Domain' class
     * @return List of 'RelationDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<RelationDb2Domain> searchByConditionForPart(RelationDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 라인 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'RelationDb2Domain' class
     * @return List of 'RelationDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<RelationDb2Domain> searchByConditionForLine(RelationDb2Domain domain) throws ApplicationException;
    /*========================== //DB2 ===================================================*/
}
