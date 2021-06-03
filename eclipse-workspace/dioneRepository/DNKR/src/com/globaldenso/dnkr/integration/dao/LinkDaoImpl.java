/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.LinkDomain;
import com.globaldenso.dnkr.domain.SessionDomain;
import com.globaldenso.dnkr.domain.SsoAccountDomain;

/**
 * [KO] 링크관리 DAO 구현 클래스<br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("linkDao")
public class LinkDaoImpl implements LinkDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.LinkDao";
    
    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate = null;
    

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public LinkDaoImpl() {
        // no process
    }
    
    /**
     * [EN] It is a setter method of sqlSessionTemplate.<br>
     * [JP] sqlSessionTemplate のセッターメソッドです。<br>
     * 
     * @param sqlSessionTemplate sqlSessionTemplate に設定する
     */
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#searchCount(LinkDomain)
     */
    public int searchCountLink(LinkDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCountLink", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#searchByConditionForPaging(LinkDomain)
     */
    public List<LinkDomain> searchByConditionForPagingLink(LinkDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPagingLink", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#createLink(LinkDomain)
     */
    public int createLink(LinkDomain domain) throws ApplicationException{      
        int cnt = sqlSessionTemplate.insert(NAMESPACE + ".createLink", domain);
        return cnt;
    }
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#deleteLink(LinkDomain)
     */
    public int deleteLink(LinkDomain domain) throws ApplicationException{
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteLink", domain);
    }  
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#updateLink(LinkDomain)
     */
    public int updateLink(LinkDomain domain) throws ApplicationException{
        return sqlSessionTemplate.update(NAMESPACE + ".updateLink", domain);
    }
    
    public int searchCountSso(LinkDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCountSso", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#searchByConditionForPaging(LinkDomain)
     */
    public List<LinkDomain> searchByConditionForPagingSso(LinkDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPagingSso", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#createLink(LinkDomain)
     */
    public int createSso(LinkDomain domain) throws ApplicationException{      
        int cnt = sqlSessionTemplate.insert(NAMESPACE + ".createSso", domain);
        return cnt;
    }
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#deleteLink(LinkDomain)
     */
    public int deleteSso(LinkDomain domain) throws ApplicationException{
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteSso", domain);
    }  
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#updateLink(LinkDomain)
     */
    public int updateSso(LinkDomain domain) throws ApplicationException{
        return sqlSessionTemplate.update(NAMESPACE + ".updateSso", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#searchByConditionForPaging(LinkDomain)
     */
    public LinkDomain searchSsoUrl(LinkDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchSsoUrl", domain);
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#searchBySsoAccount(SsoAccountDomain)
     */
    public List<SsoAccountDomain> searchBySsoAccount(SsoAccountDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchBySsoAccount", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#searchBySsoDeviceId(SsoAccountDomain)
     */
    public List<SsoAccountDomain> searchBySsoDeviceId(SsoAccountDomain domain) throws ApplicationException {
     	 return sqlSessionTemplate.selectList(NAMESPACE + ".searchBySsoDeviceId", domain);
  	}
    
    public List<SsoAccountDomain> searchBySsoSystem(SsoAccountDomain domain) throws ApplicationException {
   	 return sqlSessionTemplate.selectList(NAMESPACE + ".searchBySsoSystem", domain);
	}
    
    public int searchBySsoSystemCount(SsoAccountDomain domain) throws ApplicationException{
    	  int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchBySsoSystemCount", domain);
          return cnt;
  	}
    
    public int insertSsoSystemUser(SsoAccountDomain domain) throws ApplicationException{
    	  int cnt = sqlSessionTemplate.insert(NAMESPACE + ".insertSsoSystemUser", domain);
          return cnt;
  	}
    
    public int updateSsoSystemUser(SsoAccountDomain domain) throws ApplicationException{
  	  int cnt = sqlSessionTemplate.update(NAMESPACE + ".updateSsoSystemUser", domain);
      return cnt;
	}
    
    public int deleteSsoSystemUser(SsoAccountDomain domain) throws ApplicationException{
    	int cnt = sqlSessionTemplate.delete(NAMESPACE + ".deleteSsoSystemUser", domain);
    	return cnt;
	}
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#searchBySsoDeviceCompany(SsoAccountDomain)
     */
    public List<SsoAccountDomain> searchBySsoSystemCompany(SsoAccountDomain domain) throws ApplicationException {
    	 return sqlSessionTemplate.selectList(NAMESPACE + ".searchBySsoSystemCompany", domain);
 	}
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.LinkDao#searchBySsoDeviceCompany(SsoAccountDomain)
     */
    public List<SsoAccountDomain> searchBySsoDeviceCompany(SsoAccountDomain domain) throws ApplicationException {
     	 return sqlSessionTemplate.selectList(NAMESPACE + ".searchBySsoDeviceCompany", domain);
  	} 
    
    public List<SsoAccountDomain> searchBySsoDevice(SsoAccountDomain domain) throws ApplicationException {
      	 return sqlSessionTemplate.selectList(NAMESPACE + ".searchBySsoDevice", domain);
   	}
    //체크
    public int searchBySsoDeviceCount(SsoAccountDomain domain) throws ApplicationException {
  	  int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchBySsoDeviceCount", domain);
        return cnt;
	}
    public int insertSsoDeviceUser(SsoAccountDomain domain) throws ApplicationException {
    	  int cnt = sqlSessionTemplate.insert(NAMESPACE + ".insertSsoDeviceUser", domain);
          return cnt;
  	}
    
    public int updateSsoDeviceUser(SsoAccountDomain domain) throws ApplicationException {
    	  int cnt = sqlSessionTemplate.update(NAMESPACE + ".updateSsoDeviceUser", domain);
          return cnt;
  	}
    //WAA000Main에서 사용
    public LinkDomain ssoUrlAccounts(LinkDomain domain) throws ApplicationException  {
     	 return sqlSessionTemplate.selectOne(NAMESPACE + ".ssoUrlAccounts", domain);
  	}
    public LinkDomain ssoUrlAccountsAuth(LinkDomain domain) throws ApplicationException  {
    	 return sqlSessionTemplate.selectOne(NAMESPACE + ".ssoUrlAccountsAuth", domain);
 	}
    
    //Display session count
    public List<SessionDomain> searchDioneAccountCnt(SessionDomain domain) throws ApplicationException  {
    	return sqlSessionTemplate.selectList(NAMESPACE + ".searchDioneAccountCnt", domain);
	}
    //Display session 사용자 죠회
    public List<SessionDomain> searchSsoDspSessionAccount(SessionDomain domain) throws ApplicationException  {
    	return sqlSessionTemplate.selectList(NAMESPACE + ".searchSsoDspSessionAccount", domain);
	}
    //Print session 사용자 죠회
    public SessionDomain searchSsoPrtSessionAccount(SessionDomain domain) throws ApplicationException  {
    	return sqlSessionTemplate.selectOne(NAMESPACE + ".searchSsoPrtSessionAccount", domain);
	}
}
