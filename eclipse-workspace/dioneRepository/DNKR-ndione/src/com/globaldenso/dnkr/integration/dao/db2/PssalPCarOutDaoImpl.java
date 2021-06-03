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
import com.globaldenso.dnkr.domain.db2.PssalPCarOutDomain;

/**
 * 
 * Describe the outline of this class.
 * 
 * <p>
 * Describe the detail of this class.
 * </p>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("PssalPCarOutDao")
public class PssalPCarOutDaoImpl implements PssalPCarOutDao {

    /** 
     * sql str 
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.db2.PssalPCarOutDao";
    
    /**
     * sqlSessionTemplate
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate4")
    private SqlSessionTemplate sqlSessionTemplate4;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PssalPCarOutDaoImpl() {
        // no process
    }
    
    /**
     * set SqlSessionTemplate
     * @param sqlSessionTemplate SqlSessionTemplate
     */
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate4 = sqlSessionTemplate;
    }
    
    
    @Override
    public List<PssalPCarOutDomain> selectSMDE122Q_gridVal_Obj(PssalPCarOutDomain domain)
            throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSMDE122Q_gridVal_Obj", domain);
    }
}
