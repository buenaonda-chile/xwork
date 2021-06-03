/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.integration.dao.db2;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.PsogmImprvDDomain;

/**
 * [KO] DAO 구현 클래스<br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("psogmImprvDDao")
public class PsogmImprvDDaoImpl implements PsogmImprvDDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.db2.PsogmImprvDDao";
    
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
    public PsogmImprvDDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.db2.PsogmImprvDService#selectOgm204_obj210pf_01(PsogmImprvDDomain)
     */
    public PsogmImprvDDomain selectOgm204_obj210pf_01(PsogmImprvDDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOgm204_obj210pf_01", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.db2.PsogmImprvDService#selectOgm220_rep(PsogmImprvDDomain)
     */
    public PsogmImprvDDomain selectOgm220_rep(PsogmImprvDDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOgm220_rep", domain);
    }    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.db2.PsogmImprvDService#insertOgm204_obj210pf(PsogmImprvDDomain)
     */
    public int insertOgm204_obj210pf(PsogmImprvDDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.insert(NAMESPACE + ".insertOgm204_obj210pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.db2.PsogmImprvDService#updateOgm204_obj210pf(PsogmImprvDDomain)
     */
    public int updateOgm204_obj210pf(PsogmImprvDDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.update(NAMESPACE + ".updateOgm204_obj210pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.db2.PsogmImprvDService#updateOgm204_obj210pf_addImg(PsogmImprvDDomain)
     */
    public int updateOgm204_obj210pf_addImg(PsogmImprvDDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.update(NAMESPACE + ".updateOgm204_obj210pf_addImg", domain);
    }
}
