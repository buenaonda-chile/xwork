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
import com.globaldenso.dnkr.domain.db2.FileDb2Domain;

/**
 * [KO] DAO 구현 클래스<br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("psogmAttachedFileDao")
public class PsogmAttachedFileDaoImpl implements PsogmAttachedFileDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.db2.PsogmAttachedFileDao";
    
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
    public PsogmAttachedFileDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.PsogmAttachedFileService#searchById(FileDb2Domain)
     */
    public FileDb2Domain searchById(FileDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchById", domain);
    }
       
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmAttachedFileService#selectOgm219_obj230pf(FileDb2Domain)
     */
    public List<FileDb2Domain> selectOgm219_obj230pf(FileDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm219_obj230pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmAttachedFileService#selectOgm219_obj230pf(FileDb2Domain)
     */
    public int selectOgm206_maxSeq(FileDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOgm206_maxSeq", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmAttachedFileService#insertOgm206_sFile(FileDb2Domain)
     */
    public int insertOgm206_sFile(FileDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.insert(NAMESPACE + ".insertOgm206_sFile", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmAttachedFileService#deleteCmc(FileDb2Domain)
     */
    public int deleteOgm206(FileDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteOgm206", domain);
    }
}
