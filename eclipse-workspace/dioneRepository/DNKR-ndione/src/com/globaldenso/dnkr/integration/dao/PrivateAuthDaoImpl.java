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
import com.globaldenso.dnkr.domain.PrivateAuthDomain;
import com.globaldenso.dnkr.domain.SsoAuthDomain;

/**
 * [KO] 권한 관리 DAO 구현 클래스<br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("privateAuthDao")
public class PrivateAuthDaoImpl implements PrivateAuthDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.PrivateAuthDao";
    
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
    public PrivateAuthDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchByKey(PrivateAuthDomain)
     */
    public PrivateAuthDomain searchByKey(PrivateAuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchByKey", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchByCondition(PrivateAuthDomain)
     */
    public List<PrivateAuthDomain> searchByCondition(PrivateAuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchAuthDetail(PrivateAuthDomain)
     */
    public List<PrivateAuthDomain> searchAuthDetail(PrivateAuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchAuthDetail", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchMenuList(PrivateAuthDomain)
     */
    public List<PrivateAuthDomain> searchMenuList(PrivateAuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchMenuList", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchByConditionForPaging(PrivateAuthDomain)
     */
    public List<PrivateAuthDomain> searchByConditionForPaging(PrivateAuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchCount(PrivateAuthDomain)
     */
    public int searchCount(PrivateAuthDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchByKey(PrivateAuthDomain)
     */
    public PrivateAuthDomain searchPrivateAuthDetail(PrivateAuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchPrivateAuthDetail", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#create(PrivateAuthDomain)
     */
    public int create(PrivateAuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.insert(NAMESPACE + ".create", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#update(PrivateAuthDomain)
     */
    public int update(PrivateAuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".update", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#delete(PrivateAuthDomain)
     */
    public int delete(PrivateAuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".delete", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchByConditionSsoAuth(SsoAuthDomain)
     */
    public List<SsoAuthDomain> searchByConditionSsoAuth(SsoAuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionSsoAuth", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchCountSsoAuth(SsoAuthDomain)
     */
    public int searchCountSsoAuth(SsoAuthDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCountSsoAuth", domain);
        return cnt;
    }
        
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#createSsoAuth(SsoAuthDomain)
     */
    public int createSsoAuth(SsoAuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".createSsoAuth", domain);
    }    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#updateSsoAuth(SsoAuthDomain)
     */
    public int updateSsoAuth(SsoAuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateSsoAuth", domain);
    }
    
}
