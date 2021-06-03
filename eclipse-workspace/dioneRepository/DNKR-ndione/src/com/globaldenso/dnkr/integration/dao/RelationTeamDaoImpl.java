/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.integration.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.MaDeptDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;

/**
 * [KO] 사업부서(팀) 관리 DAO 구현
 * [EN] It is DAO implementation class of RelationTeamDao.<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("RelationTeamDao")
public class RelationTeamDaoImpl implements RelationTeamDao {
    
    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.RelationTeamDao";
    
    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate = null;
    
    /**
     * [EN] SqlSessionTemplate2.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate2")
    private SqlSessionTemplate sqlSessionTemplate2 = null;
    
   
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public RelationTeamDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.RelationTeamDao#searchByKey(RelationTeamDomain)
     */
    public RelationTeamDomain searchByKey(RelationTeamDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.RelationTeamDao#searchByCondition(RelationTeamDomain)
     */
    public List<RelationTeamDomain> searchByCondition(RelationTeamDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.RelationTeamDao#searchCount(RelationTeamDomain)
     */
    public List<RelationTeamDomain> searchByConditionForPaging(RelationTeamDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.RelationTeamDao#searchCount(RelationTeamDomain)
     */
    public int searchCount(RelationTeamDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CodeDao#searchCount(CodeDomain)
     */
    public int searchTeamCount(RelationTeamDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchTeamCount", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationTeamDao#create(RelationTeamDomain)
     */
    public void create(RelationTeamDomain domain, List<String> langList) throws ApplicationException {
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
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#createCode(RelationTeamDomain)
     */
    public void createCode(RelationTeamDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createCode", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#createName(RelationTeamDomain)
     */
    public void createName(RelationTeamDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createName", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationTeamDao#update(RelationTeamDomain)
     */
    public int update(RelationTeamDomain domain) throws ApplicationException {
        int resultCnt = 0;
        resultCnt += updateCode(domain);
        resultCnt += updateName(domain);
        return resultCnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationTeamDao#updateCode(RelationTeamDomain)
     */
    public int updateCode(RelationTeamDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateCode", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationTeamDao#updateAuth(RelationTeamDomain)
     */
    public int updateAuth(RelationTeamDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateAuth", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationTeamDao#updateName(RelationTeamDomain)
     */
    public int updateName(RelationTeamDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateName", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationTeamDao#update(RelationTeamDomain)
     */
    public int delete(RelationTeamDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".delete", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#deleteCmc(RelationTeamDomain)
     */
    public int deleteCode(RelationTeamDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteCode", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#deleteCnm(RelationTeamDomain)
     */
    public int deleteName(RelationTeamDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteName", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#createName(RelationTeamDomain)
     */
    public void insertDeptTmpData() throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".insertDeptTmpData");
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#deleteCnm(RelationTeamDomain)
     */
    public int deleteTmp() throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteTmp");
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.RelationTeamDao#searchByCondition(RelationTeamDomain)
     */
    public List<MaDeptDomain> searchMaDeptList() throws ApplicationException {
        return sqlSessionTemplate2.selectList(NAMESPACE + ".searchMaDeptList");
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#createName(RelationTeamDomain)
     */
    public int insertDept(List<MaDeptDomain> list) throws ApplicationException {
        return sqlSessionTemplate.insert(NAMESPACE + ".insertDept", list);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.RelationClsDao#createName(RelationTeamDomain)
     */
    public HashMap procMergeTeam(HashMap map) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".procMergeTeam", map);
    }
    
    /**
     * [KO] 과거부서코드 미사용으로 전환<br>
     * [EN] Select PROC_MERGE_TEAM procedure.<br>
     * [JP] <br>
     * @auth  JHB(2019.04.17)
     * @param map HashMap
     * @return HashMap
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<RelationTeamDomain> searchByClsLocCode() throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByClsLocCode");
    }
	
	public int updateTeamLatestYearUse(RelationTeamDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateTeamLatestYearUse", domain);
	}
	
	 /**
     * [KO] 과거부서코드 미사용으로 전환<br>
     * [EN] Select PROC_MERGE_TEAM procedure.<br>
     * [JP] <br>
     * @auth  JHB(2020.09.11)
     * @param map HashMap
     * @return HashMap
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateDeptUseTf() throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateDeptUseTf");
    }
}
