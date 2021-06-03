/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PsogmMachineDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;

/**
 * [KO] DAO 구현 클래스<br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("psogmMachineDao")
public class PsogmMachineDaoImpl implements PsogmMachineDao {
    
    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.PsogmMachineDao";
    
    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate4")
    private SqlSessionTemplate sqlSessionTemplate4 = null;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PsogmMachineDaoImpl() {
        // no process
    }
    
    /**
     * [EN] It is a setter method of sqlSessionTemplate.<br>
     * [JP] sqlSessionTemplate のセッターメソッドです。<br>
     * 
     * @param sqlSessionTemplate sqlSessionTemplate に設定する
     */
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate4 = sqlSessionTemplate;
    }
    
       
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmMachineDao#selectogm411(PsogmMachineDomain)
     */
    public List<PsogmMachineDomain> selectogm411(PsogmMachineDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectogm411", domain);
    } 

    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.EmpDao#searchByConditionForPaging(PsogmMachineDomain)
     */
    public List<PsogmMachineDomain> selectogm411ForPaging(PsogmMachineDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectogm411ForPaging", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.PsogmMachineDao#searchCount(PsogmMachineDomain)
     */
    public int searchCount(PsogmMachineDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmMachineDao#selectOgm411_cmbsel(CommonDb2Domain)
     */
    public List<CommonDb2Domain> selectOgm411_cmbsel(CommonDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm411_cmbsel", domain);
    } 
}
