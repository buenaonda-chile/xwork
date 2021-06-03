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
import com.globaldenso.dnkr.domain.PrivateAuthDomain;
import com.globaldenso.dnkr.domain.SsoAuthDomain;

/**
 * [KO] 권한관리 정보의 dao 인터페이스.<br>
 * [EN] <br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PrivateAuthDao {

    /**
     * [KO] 기본키로 DB 테이블에서 권한 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search auth information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return 'PrivateAuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public PrivateAuthDomain searchByKey(PrivateAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search auth information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return List of 'PrivateAuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PrivateAuthDomain> searchByCondition(PrivateAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search auth information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return List of 'PrivateAuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PrivateAuthDomain> searchAuthDetail(PrivateAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search auth information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return List of 'PrivateAuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PrivateAuthDomain> searchMenuList(PrivateAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] (페이징 처리)검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] (For paging processing) Search auth information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] (ページング処理用)<br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return List of 'PrivateAuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PrivateAuthDomain> searchByConditionForPaging(PrivateAuthDomain domain) throws ApplicationException;
        
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] Search auth information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(PrivateAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 DB 테이블에서 권한 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search auth information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return 'PrivateAuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public PrivateAuthDomain searchPrivateAuthDetail(PrivateAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 권한 테이블과 권한 명칭테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in auth information table.<br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int create(PrivateAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 권한 테이블의 데이터 수정하기<br>
     * [EN] Update a record in auth information table with the primary key.<br>
     * [JP] <br>
     * <p>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(PrivateAuthDomain domain) throws ApplicationException;
    
    
    
    /**
     * [EN] Delete a record in employee information table with the primary key.
     * [JP] 主キーを条件に、社員情報テーブルのレコードを1件物理削除します。
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(PrivateAuthDomain domain) throws ApplicationException;
        
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search auth information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'SsoAuthDomain' class
     * @return List of 'SsoAuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<SsoAuthDomain> searchByConditionSsoAuth(SsoAuthDomain domain) throws ApplicationException;
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchCountSsoAuth(SsoAuthDomain)
     */
    public int searchCountSsoAuth(SsoAuthDomain domain) throws ApplicationException;
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#createSsoAuth(SsoAuthDomain)
     */
    public int createSsoAuth(SsoAuthDomain domain) throws ApplicationException;
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#updateSsoAuth(SsoAuthDomain)
     */
    public int updateSsoAuth(SsoAuthDomain domain) throws ApplicationException;

}
