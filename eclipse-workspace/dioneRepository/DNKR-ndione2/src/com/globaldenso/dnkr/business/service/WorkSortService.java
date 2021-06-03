/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.WorkSortDomain;

/**
 * [KR] 업무분류 관리 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface WorkSortService {

    /**
     * [KO] 기본키로 DB 테이블에서 업무 분류 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'WorkSortDomain' class
     * @return 'WorkSortDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public WorkSortDomain searchByKey(WorkSortDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 업무분류 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'WorkSortDomain' class
     * @return List of 'WorkSortDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<WorkSortDomain> searchByCondition(WorkSortDomain domain) throws ApplicationException;
    
    /**
     * [KO] (페이징처리)검색옵션값으로 DB 테이블에서 업무분류 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] (For paging processing)<br>
     * [JP] (ページング処理用)<br>
     * 
     * @param domain 'WorkSortDomain' class
     * @return List of 'WorkSortDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<WorkSortDomain> searchByConditionForPaging(WorkSortDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 업무분류(중)와 승인사원 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'WorkSortDomain' class
     * @return List of 'WorkSortDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public WorkSortDomain searchWorkConfirm(WorkSortDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 업무분류 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'WorkSortDomain' class
     * @return List of 'WorkSortDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<WorkSortDomain> searchWorkConfirmList(WorkSortDomain domain) throws ApplicationException;
    
    /**
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'WorkSortDomain' class
     * @return String
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public String searchMaxWorkCodeNum(WorkSortDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 업무분류 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'WorkSortDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(WorkSortDomain domain) throws ApplicationException;
    
    /**
     * [KO] 업무분류 테이블에 데이터를 추가한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'WorkSortDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(WorkSortDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 업무분류 테이블의 데이터 수정하기<br>
     * [EN] Update a record in DNKR_WORK_TYPE table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'WorkSortDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(WorkSortDomain domain) throws ApplicationException;
    
    /**
     * [KO] 업무승인관리자 테이블에 데이터를 추가한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'WorkSortDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createSetAprvEmp(WorkSortDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 업무승인관리자 테이블의 데이터 수정하기<br>
     * [EN] Update a record in DNKR_WORK_TYPE table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'WorkSortDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateSetAprvEmp(WorkSortDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 업무분류 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in DNKR_WORK_TYPE table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'WorkSortDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(WorkSortDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 업무승인관리자 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in DNKR_WORK_TYPE table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'WorkSortDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteAprvEmp(WorkSortDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 업무분류 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete records in DNKR_WORK_TYPE table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domainList List of 'WorkSortDomain' class
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(List<WorkSortDomain> domainList) throws ApplicationException;

}
