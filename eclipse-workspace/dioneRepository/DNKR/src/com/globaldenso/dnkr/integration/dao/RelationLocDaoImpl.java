/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;

/**
 * [KO] 사업부 관리 DAO 구현
 * [EN] It is DAO implementation class of RelationClsDao.<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("RelationLocDao")
public class RelationLocDaoImpl implements RelationLocDao {
    
    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.RelationLocDao";
    
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
    public RelationLocDaoImpl() {
        //no process
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
     * @see com.globaldenso.dnkr.integration.dao.RelationLocDao#searchByKey(RelationLocDomain)
     */
    public RelationLocDomain searchByKey(RelationLocDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.RelationLocDao#searchByCondition(RelationLocDomain)
     */
    public List<RelationLocDomain> searchByCondition(RelationLocDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.RelationLocDao#searchCount(RelationLocDomain)
     */
    public List<RelationLocDomain> searchByConditionForPaging(RelationLocDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.RelationLocDao#searchCount(RelationLocDomain)
     */
    public int searchCount(RelationLocDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CodeDao#searchCount(CodeDomain)
     */
    public int searchLocCount(RelationLocDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchLocCount", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationLocDao#create(RelationLocDomain)
     */
    public void create(RelationLocDomain domain, List<String> langList) throws ApplicationException {
        createCode(domain);

         //언어별 조직도  명칭 레코드 추가
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
     * @see com.globaldenso.dnkr.integration.dao.RelationLocDao#createCode(RelationLocDomain)
     */
    public void createCode(RelationLocDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createCode", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationLocDao#createName(RelationLocDomain)
     */
    public void createName(RelationLocDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createName", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationLocDao#update(RelationLocDomain)
     */
    public int update(RelationLocDomain domain) throws ApplicationException {
        int resultCnt = 0;
        resultCnt += updateCode(domain);
        resultCnt += updateName(domain);
        return resultCnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationLocDao#updateCode(RelationLocDomain)
     */
    public int updateCode(RelationLocDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateCode", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationLocDao#updateName(RelationLocDomain)
     */
    public int updateName(RelationLocDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateName", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationLocDao#update(RelationLocDomain)
     */
    public int delete(RelationLocDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".delete", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#deleteCmc(CodeDomain)
     */
    public int deleteCode(RelationLocDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteCode", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#deleteCnm(CodeDomain)
     */
    public int deleteName(RelationLocDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteName", domain);
    }

}
