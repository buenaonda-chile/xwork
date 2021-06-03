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
import com.globaldenso.dnkr.domain.PjtDomain;

/**
 * [KO] 프로젝트 정보의 DAO interface.<br>
 * [EN] DAO interface of project information.<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PjtDao {

    /**
     * [KO] 기본키로 DB 테이블에서  업무분류 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public PjtDomain searchByKey(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 업무분류 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchByCondition(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 업무분류 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<String> relSysList(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 업무분류 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return List of 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PjtDomain> searchPjtRegStatus(PjtDomain domain) throws ApplicationException;
    
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
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return String
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchMaxPjtNum(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 업무분류 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
     * 
     * @param domain 'PjtDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 업무분류 테이블에 데이터를 추가한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 업무분류 테이블의 데이터 수정하기<br>
     * [EN] Update a record in DNKR_PJT table with the primary key.<br>
     * [JP] <br>
     * <p>
     * [EN] We have adopted optimistic exclusive control by LAST_UPDATE_DATE in this method.<br>
     * [JP] このメソッドは、最終更新日時による楽観的排他制御を採用しています。
     * </p>
     * 
     * @param domain 'PjtDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(PjtDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 업무분류 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in DNKR_PJT table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'PjtDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(PjtDomain domain) throws ApplicationException;


}
