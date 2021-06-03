/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.business.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PrivateAuthDomain;
import com.globaldenso.dnkr.domain.SsoAuthDomain;

/**
 * [KR] 권한관리 서비스 인터페이스. <br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PrivateAuthService {

    /**
    * [KO] 기본키로 DB 테이블에서 권한 정보를 탐색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'PrivateAuthDomain' class
    * @return 'PrivateAuthDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public PrivateAuthDomain searchByKey(PrivateAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return List of 'PrivateAuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PrivateAuthDomain> searchByCondition(PrivateAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return List of 'PrivateAuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PrivateAuthDomain> searchMenuList(PrivateAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return List of 'PrivateAuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PrivateAuthDomain> searchAuthDetail(PrivateAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] (페이징 처리)검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return List of 'PrivateAuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PrivateAuthDomain> searchByConditionForPaging(PrivateAuthDomain domain) throws ApplicationException;
        
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(PrivateAuthDomain domain) throws ApplicationException;
        
    /**
    * [KO] 기본키로 DB 테이블에서 권한 정보를 탐색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'PrivateAuthDomain' class
    * @return 'PrivateAuthDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public PrivateAuthDomain searchPrivateAuthDetail(PrivateAuthDomain domain) throws ApplicationException;
    
    
    /**
     * [KO] 권한 테이블과 권한 명칭테이블에 데이터를 추가한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain PrivateAuthDomain
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     * @return create(PrivateAuthDomain)
     */
    public int create(PrivateAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 권한 테이블의 데이터 수정하기<br> 
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(PrivateAuthDomain domain) throws ApplicationException;
        
    /**
     * [KO] 기본키로 권한 테이블과 권한 명칭 테이블의 레코드를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(PrivateAuthDomain domain) throws ApplicationException;
        
    /**
     * [KO] 기본키로 권한 테이블과 권한 명칭 테이블의 레코드를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domainList List of 'PrivateAuthDomain' class
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(List<PrivateAuthDomain> domainList) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 SSO권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SsoAuthDomain' class
     * @return List of 'SsoAuthDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<SsoAuthDomain> searchByConditionSsoAuth(SsoAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PrivateAuthDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCountSsoAuth(SsoAuthDomain domain) throws ApplicationException;
    
    
    /**
     * [KO] 권한 테이블과 권한 명칭테이블에 데이터를 추가한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain SsoAuthDomain
     * @return create(SsoAuthDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int createSsoAuth(SsoAuthDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 권한 테이블의 데이터 수정하기<br> 
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SsoAuthDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateSsoAuth(SsoAuthDomain domain) throws ApplicationException;
}
