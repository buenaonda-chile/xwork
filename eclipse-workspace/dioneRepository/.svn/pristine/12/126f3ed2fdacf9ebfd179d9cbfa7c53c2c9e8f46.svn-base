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
import com.globaldenso.dnkr.business.service.db2.PsogmMonPerformService;
import com.globaldenso.dnkr.domain.db2.PsogmMonPerformDb2Domain;

/**
 * [KO] DAO 구현 클래스<br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("psogmMonPerformDao")
public class PsogmMonPerformDaoImpl implements PsogmMonPerformDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.db2.PsogmMonPerformDao";
    
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
    public PsogmMonPerformDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.PsogmMonPerformDao#selectOgm401(PsogmMonPerformService)
     */
    public List<PsogmMonPerformDb2Domain> selectOgm401(PsogmMonPerformDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm401", domain);
    }
    
//    /**
//     * {@inheritDoc}
//     * 
//     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm200_pop(MachineDb2Domain)
//     */
//    public List<MachineDb2Domain> selectOgm200_pop(MachineDb2Domain domain) throws ApplicationException {
//        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm200_pop", domain);
//    }
//    
//    /**
//     * {@inheritDoc}
//     * 
//     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOGM200_chk(MachineDb2Domain)
//     */
//    public MachineDb2Domain selectOGM200_chk(MachineDb2Domain domain) throws ApplicationException {
//        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOGM200_chk", domain);
//    }
   
}
