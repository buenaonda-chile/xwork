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
import com.globaldenso.dnkr.domain.PjtDomain;

/**
 * [KR] 업무별 통계 관리 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface WorkStatsService {

    /**
     * [KO] 기본키로 DB 테이블에서 프로젝트 관리 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public PjtDomain searchByKey(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForTeamL(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForTeamM(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForTeamS(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForTeamRelSys(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForL(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForM(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForS(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForRelSys(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] (페이징처리)검색옵션값으로 DB 테이블에서 업무분류 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] (For paging processing)<br>
     * [JP] (ページング処理用)<br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForPaging(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] (페이징처리)검색옵션값으로 DB 테이블에서 업무분류 정보를 탐색하고 결과를  업무분류(대) 순서로 리스트로 반환한다.<br>
     * [EN] (For paging processing)<br>
     * [JP] (ページング処理用)<br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForPagingWorkL(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] (페이징처리)검색옵션값으로 DB 테이블에서 업무분류 정보를 탐색하고 결과를  업무분류(중) 순서로 리스트로 반환한다.<br>
     * [EN] (For paging processing)<br>
     * [JP] (ページング処理用)<br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForPagingWorkM(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] (페이징처리)검색옵션값으로 DB 테이블에서 업무분류 정보를 탐색하고 결과를 업무분류(소) 순서로 리스트로 반환한다.<br>
     * [EN] (For paging processing)<br>
     * [JP] (ページング処理用)<br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForPagingWorkS(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForPagingTeamL(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForPagingTeamM(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForPagingTeamS(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByConditionForPagingRelSys(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCountWorkL(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCountWorkM(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCountWorkS(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCountTeamL(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCountTeamM(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCountTeamS(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 프로젝트 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCountRelSys(PjtDomain domain) throws ApplicationException;
}
