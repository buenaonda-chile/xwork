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
import com.globaldenso.dnkr.domain.AuthDomain;

/**
 * [KO] 권한관리 정보의 dao 인터페이스.<br>
 * [EN] <br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface AuthDao {

    /**
     * [KO] 기본키로 DB 테이블에서 권한 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search auth information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @return 'AuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public AuthDomain searchByKey(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search auth information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @return List of 'AuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<AuthDomain> searchByCondition(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search auth information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @return List of 'AuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<AuthDomain> searchTeamMenuList(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] (페이징 처리)검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] (For paging processing) Search auth information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] (ページング処理用)<br>
     * 
     * @param domain 'AuthDomain' class
     * @return List of 'AuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<AuthDomain> searchByConditionForPaging(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 권한코드로 DB 테이블에서 권한 상세 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @return 'AuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<AuthDomain> searchAuthDetail(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] Search auth information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 상세 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchAuthDetailCount(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 권한 테이블과 권한 명칭테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in auth information table.<br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(AuthDomain domain, List<String> langList) throws ApplicationException;
    
    /**
     * [KO] 권한 코드 테이블에 데이터를 추가한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createCode(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 권한 명칭테이블에 데이터를 추가한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createName(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 권한 상세테이블에 데이터를 추가한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createDetail(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 권한 테이블의 데이터 수정하기<br>
     * [EN] Update a record in auth information table with the primary key.<br>
     * [JP] <br>
     * <p>
     * 
     * @param domain 'AuthDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 권한 코드 테이블의 데이터 수정하기.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateCode(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 권한 명칭 테이블의 데이터 수정하기.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateName(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 권한 상세 테이블의 데이터 수정하기.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateDetail(AuthDomain domain) throws ApplicationException;
    
    /*
    *//**
     * [EN] Delete a record in employee information table with the primary key.
     * [JP] 主キーを条件に、社員情報テーブルのレコードを1件物理削除します。
     * 
     * @param domain 'AuthDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     *//*
    public int delete(AuthDomain domain) throws ApplicationException;
    */
    
    /**
     * [KO] 기본키로 권한 코드테이블의 레코드를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteCode(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 권한 명칭의 테이블의 레코드를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteName(AuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 권한 상세의 테이블의 레코드를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'AuthDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteDetail(AuthDomain domain) throws ApplicationException;

}
