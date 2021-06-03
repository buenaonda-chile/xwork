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
import com.globaldenso.dnkr.domain.AuthDomain;

/**
 * [KO] 권한 관리 DAO 구현 클래스<br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("authDao")
public class AuthDaoImpl implements AuthDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.AuthDao";
    
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
    public AuthDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchByKey(AuthDomain)
     */
    public AuthDomain searchByKey(AuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchByKey", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchByCondition(AuthDomain)
     */
    public List<AuthDomain> searchByCondition(AuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchTeamMenuList(AuthDomain)
     */
    public List<AuthDomain> searchTeamMenuList(AuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchTeamMenuList", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchByConditionForPaging(AuthDomain)
     */
    public List<AuthDomain> searchByConditionForPaging(AuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchAuthDetail(AuthDomain)
     */
    public List<AuthDomain> searchAuthDetail(AuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchAuthDetail", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchCount(AuthDomain)
     */
    public int searchCount(AuthDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#searchAuthDetailCount(AuthDomain)
     */
    public int searchAuthDetailCount(AuthDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchAuthDetailCount", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#create(AuthDomain)
     */
    public void create(AuthDomain domain, List<String> langList) throws ApplicationException {
        createCode(domain);
        
        //언어별 Menu code name 레코드 추가
        if (langList.size() > 0) {
            for (String langCode : langList) {
                domain.setCmcLangCode(langCode);
                createName(domain);
            }
        }
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#createCode(AuthDomain)
     */
    public void createCode(AuthDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createCode", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#createName(AuthDomain)
     */
    public void createName(AuthDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createName", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#createDetail(AuthDomain)
     */
    public void createDetail(AuthDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createDetail", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#update(AuthDomain)
     */
    public int update(AuthDomain domain) throws ApplicationException {
        int resultCnt = 0;
        resultCnt += updateCode(domain);
        resultCnt += updateName(domain);
        return resultCnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#updateCode(AuthDomain)
     */
    public int updateCode(AuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateCode", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#updateName(AuthDomain)
     */
    public int updateName(AuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateName", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#updateDetail(AuthDomain)
     */
    public int updateDetail(AuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateDetail", domain);
    }
    
    /*
    *//**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#delete(AuthDomain)
     *//*
    public int delete(AuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".delete", domain);
    }
    */
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#deleteCode(AuthDomain)
     */
    public int deleteCode(AuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteCode", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#deleteName(AuthDomain)
     */
    public int deleteName(AuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteName", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.AuthDao#deleteDetail(AuthDomain)
     */
    public int deleteDetail(AuthDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteDetail", domain);
    }
}
