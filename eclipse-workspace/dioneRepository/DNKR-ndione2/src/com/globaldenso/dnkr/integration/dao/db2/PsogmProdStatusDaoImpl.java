/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.integration.dao.db2;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.PsogmProdStatusDb2Domain;

/**
 * [KO] DAO 구현 클래스<br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("psogmProdStatusDao")
public class PsogmProdStatusDaoImpl implements PsogmProdStatusDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.db2.PsogmProdStatusDao";
    
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
    public PsogmProdStatusDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.PsogmProdStatusDao#selectOBSE01(PsogmProdStatusDb2Domain)
     */
    public List<PsogmProdStatusDb2Domain> selectOBSE01(PsogmProdStatusDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOBSE01", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.PsogmProdStatusDao#selectOBSE01_Sum(PsogmProdStatusDb2Domain)
     */
    public PsogmProdStatusDb2Domain selectOBSE01_Sum(PsogmProdStatusDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOBSE01_Sum", domain);
        
    }
   
}
