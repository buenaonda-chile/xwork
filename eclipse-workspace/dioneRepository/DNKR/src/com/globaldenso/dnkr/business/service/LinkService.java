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
import com.globaldenso.dnkr.domain.LinkDomain;
import com.globaldenso.dnkr.domain.SessionDomain;
import com.globaldenso.dnkr.domain.SsoAccountDomain;

/**
 * [KR] Link관리 서비스 인터페이스. <br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface LinkService {

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 링크 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LinkDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCountLink(LinkDomain domain) throws ApplicationException;
    
    
    /**
     * [KO] (페이징 처리)검색옵션값으로 DB 테이블에서 링크 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LinkDomain' class
     * @return List of 'LinkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<LinkDomain> searchByConditionForPagingLink(LinkDomain domain) throws ApplicationException;
   
    /**
     * [KO] DB 테이블에서 링크 정보를 저장한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LinkDomain' class
     * @return List of 'LinkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    
    public int createLink(LinkDomain domain) throws ApplicationException;
    
    /**
     * [KO] DB 테이블에서 링크 정보를 저장한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LinkDomain' class
     * @return List of 'LinkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateLink(LinkDomain domain) throws ApplicationException;
    
    /**
     * [KO] DB 테이블에서 링크 정보를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LinkDomain' class
     * @return List of 'LinkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteLink(LinkDomain domain) throws ApplicationException;
    
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 링크 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LinkDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCountSso(LinkDomain domain) throws ApplicationException;
    
    
    /**
     * [KO] (페이징 처리)검색옵션값으로 DB 테이블에서 링크 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LinkDomain' class
     * @return List of 'LinkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<LinkDomain> searchByConditionForPagingSso(LinkDomain domain) throws ApplicationException;
   
    /**
     * [KO] DB 테이블에서 링크 정보를 저장한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LinkDomain' class
     * @return List of 'LinkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    
    public int createSso(LinkDomain domain) throws ApplicationException;
    
    /**
     * [KO] DB 테이블에서 링크 정보를 저장한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LinkDomain' class
     * @return List of 'LinkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateSso(LinkDomain domain) throws ApplicationException;
    
    /**
     * [KO] DB 테이블에서 링크 정보를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LinkDomain' class
     * @return List of 'LinkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteSso(LinkDomain domain) throws ApplicationException;
    
    
    /**
     * [KO] (페이징 처리)검색옵션값으로 DB 테이블에서 링크 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LinkDomain' class
     * @return List of 'LinkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public LinkDomain searchSsoUrl(LinkDomain domain) throws ApplicationException;
    
    
    
    /**
     * [KO] (페이징 처리)검색옵션값으로 DB 테이블에서 링크 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SsoAccountDomain' class
     * @return List of 'SsoAccountDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<SsoAccountDomain> searchBySsoAccount(SsoAccountDomain domain) throws ApplicationException;	//WAC021, WAC022, WAC023
   
    /**
     * [KO] (페이징 처리)검색옵션값으로 DB 테이블에서 링크 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SsoAccountDomain' class
     * @return List of 'SsoAccountDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<SsoAccountDomain> searchBySsoDeviceId(SsoAccountDomain domain) throws ApplicationException;	//WAC021

    public List<SsoAccountDomain> searchBySsoSystem(SsoAccountDomain domain) throws ApplicationException;	//WAC021, //WAC022

    public int searchBySsoSystemCount(SsoAccountDomain domain) throws ApplicationException;	//WAC021
    
    public int insertSsoSystemUser(SsoAccountDomain domain) throws ApplicationException;	//WAC021
    
    public int updateSsoSystemUser(SsoAccountDomain domain) throws ApplicationException;	//WAC021
    
    public int deleteSsoSystemUser(SsoAccountDomain domain) throws ApplicationException;	//WAC021

    /**
     * [KO] (페이징 처리)검색옵션값으로 DB 테이블에서 링크 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SsoAccountDomain' class
     * @return List of 'SsoAccountDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     * @relationPgm WAC022
     */    
    public List<SsoAccountDomain> searchBySsoSystemCompany(SsoAccountDomain domain) throws ApplicationException;		//WAC022
  
    /**
     * [KO] (페이징 처리)검색옵션값으로 DB 테이블에서 링크 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SsoAccountDomain' class
     * @return List of 'SsoAccountDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     * @relationPgm WAC023
     */    
    public List<SsoAccountDomain> searchBySsoDeviceCompany(SsoAccountDomain domain) throws ApplicationException;		//WAC023

    public List<SsoAccountDomain> searchBySsoDevice(SsoAccountDomain domain) throws ApplicationException;		//WAC023
    
    public int searchBySsoDeviceCount(SsoAccountDomain domain) throws ApplicationException;		//WAC023
 
    public int insertSsoDeviceUser(SsoAccountDomain domain) throws ApplicationException;		//WAC023
    
    public int updateSsoDeviceUser(SsoAccountDomain domain) throws ApplicationException;		//WAC023

  	/**
       * {@inheritDoc}
       * 
       * @see com.globaldenso.dnkr.business.service.LinkService#ssoUrlAccounts(SsoAccountDomain)
    */
  	//sso url 조회
    public LinkDomain ssoUrlAccounts(LinkDomain domain) throws ApplicationException;	//WAA000Main

    //sso url + 사용자 조회
    public LinkDomain ssoUrlAccountsAuth(LinkDomain domain) throws ApplicationException;	//WAA000Main

    //Display session count
    public List<SessionDomain> searchDioneAccountCnt(SessionDomain domain) throws ApplicationException;	//WAA000Main

    //Display session 사용자 죠회
    public List<SessionDomain> searchSsoDspSessionAccount(SessionDomain domain) throws ApplicationException;//WAA000Main
    
    //Print session 사용자 죠회
    public SessionDomain searchSsoPrtSessionAccount(SessionDomain domain) throws ApplicationException;	//WAA000Main
    
}
