/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationDb2Domain;

/**
 * [KO] 사업부 관리 DAO 구현
 * [EN] It is DAO implementation class of RelationClsDao.<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("RelationClsDao")
public class RelationClsDaoImpl implements RelationClsDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.RelationClsDao";
    
    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate = null;
    
    /**
     * [EN] SqlSessionTemplate4.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate4")
    private SqlSessionTemplate sqlSessionTemplate4 = null;
   
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public RelationClsDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#searchByKey(RelationClsDomain)
     */
    public RelationClsDomain searchByKey(RelationClsDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#searchByCondition(RelationClsDomain)
     */
    public List<RelationClsDomain> searchByCondition(RelationClsDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#searchCount(RelationClsDomain)
     */
    public List<RelationClsDomain> searchByConditionForPaging(RelationClsDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#searchCount(RelationClsDomain)
     */
    public int searchCount(RelationClsDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);
        return cnt;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#create(RelationClsDomain)
     */
    public void create(RelationClsDomain domain, List<String> langList) throws ApplicationException {
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
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#createCode(RelationClsDomain)
     */
    public void createCode(RelationClsDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createCode", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#createName(RelationClsDomain)
     */
    public void createName(RelationClsDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createName", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#update(RelationClsDomain)
     */
    public int update(RelationClsDomain domain) throws ApplicationException {
        int resultCnt = 0;
        resultCnt += updateCode(domain);
        resultCnt += updateName(domain);
        return resultCnt;
    }
    
     /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#updateCode(RelationClsDomain)
     */
    public int updateCode(RelationClsDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateCode", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#updateName(RelationClsDomain)
     */
    public int updateName(RelationClsDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateName", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#update(RelationClsDomain)
     */
    public int delete(RelationClsDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".delete", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#deleteCmc(CodeDomain)
     */
    public int deleteCode(RelationClsDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteCode", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#deleteCnm(CodeDomain)
     */
    public int deleteName(RelationClsDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteName", domain);
    }

    /*============================== DB2 ===========================================*/
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#selectOgm411_cmbsel(RelationClsDomain)
     */
    public List<RelationDb2Domain> selectOGMgauge_Mst650pf(RelationDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOGMgauge_Mst650pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#searchByConditionForPart(RelationClsDomain)
     */
    public List<RelationDb2Domain> searchByConditionForPart(RelationDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPart", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#searchByConditionForLine(RelationClsDomain)
     */
    public List<RelationDb2Domain> searchByConditionForLine(RelationDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForLine", domain);
    }
    /*============================== //DB2 ===========================================*/
}
