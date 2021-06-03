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
import com.globaldenso.dnkr.domain.db2.PsfacDb2Domain;

/**
 * [KO] DAO 구현 클래스<br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("psfaclibDao")
public class PsfacDaoImpl implements PsfacDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.db2.PsfacDao";
    
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
    public PsfacDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.PsogmMonPerformDao#selectOgm401(PsfacDb2Domain)
     */
    public List<PsfacDb2Domain> selectFEP200PF(PsfacDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectFEP200PF", domain);
    }
    
   
}
