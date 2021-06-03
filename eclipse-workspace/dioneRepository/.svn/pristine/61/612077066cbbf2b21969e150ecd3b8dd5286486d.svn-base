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
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.RelationDb2Domain;
import com.globaldenso.dnkr.domain.db2.FileDb2Domain;
import com.globaldenso.dnkr.domain.db2.MachineDb2Domain;
import com.globaldenso.dnkr.domain.db2.PsogmDomain;
import com.globaldenso.dnkr.domain.db2.SpareUnitDb2Domain;

/**
 * [KO] DAO 구현 클래스<br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("psogmDao")
public class PsogmDaoImpl implements PsogmDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.PsogmDao";
    
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
    public PsogmDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOGM200_chk(MachineDb2Domain)
     */
    public MachineDb2Domain selectOGM200_chk(MachineDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOGM200_chk", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm313_gms219(PsogmDomain)
     */
    public PsogmDomain selectOgm313_gms219(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOgm313_gms219", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_rep(PsogmDomain)
     */
    public PsogmDomain selectOgm203_rep(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOgm203_rep", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#select_obj220pf_InqParts(PsogmDomain)
     */
    public List<PsogmDomain> select_obj220pf_InqParts(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".select_obj220pf_InqParts", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_pepcdChk(PsogmDomain)
     */
    public PsogmDomain selectOgm203_pepcdChk(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOgm203_pepcdChk", domain);
    }
       
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#getogm313_cmbprtcd(PsogmDomain)
     */
    public List<PsogmDomain> getogm313_cmbprtcd(RelationDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".getogm313_cmbprtcd", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm200_pop(MachineDb2Domain)
     */
    public List<MachineDb2Domain> selectOgm200_pop(MachineDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm200_pop", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm200_method(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm200_method(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm200_method", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm313_obc250pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm313_obc250pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm313_obc250pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc230pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc230pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc230pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc220pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc220pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc220pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc160pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc160pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc160pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc060pf_01(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc060pf_01(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc060pf_01", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc060pf_02(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc060pf_02(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc060pf_02", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc070pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc070pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc070pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc050pf_01(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc050pf_01(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc050pf_01", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc190pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc190pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc190pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc120pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc120pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc120pf", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc100pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc100pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc100pf", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc180pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc180pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc180pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc110pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc110pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc110pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc090pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc090pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc090pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm314_onload(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm314_onload(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm314_onload", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc020pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc020pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc020pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc010pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc010pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc010pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc170pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc170pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc170pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc210pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc210pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc210pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc200pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc200pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc200pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_obc150pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc150pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm203_obc150pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm205_obj220pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm205_obj220pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm205_obj220pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOGMPrtno(SpareUnitDb2Domain)
     */
    public List<SpareUnitDb2Domain> selectOGMPrtno(SpareUnitDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOGMPrtno", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOGMVndnr(SpareUnitDb2Domain)
     */
    public List<SpareUnitDb2Domain> selectOGMVndnr(SpareUnitDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOGMVndnr", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOGMMaker(SpareUnitDb2Domain)
     */
    public List<SpareUnitDb2Domain> selectOGMMaker(SpareUnitDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOGMMaker", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOGM116(SpareUnitDb2Domain)
     */
    public List<SpareUnitDb2Domain> selectOGM116(SpareUnitDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOGM116", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm219_obj230pf(FileDb2Domain)
     */
    public List<FileDb2Domain> selectOgm219_obj230pf(FileDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm219_obj230pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm205_pop(SpareUnitDb2Domain)
     */
    public List<SpareUnitDb2Domain> selectOgm205_pop(SpareUnitDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm205_pop", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOGM116(SpareUnitDb2Domain)
     */
    public SpareUnitDb2Domain selectOGM116_JG(SpareUnitDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOGM116_JG", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm010pf(SpareUnitDb2Domain)
     */
    public SpareUnitDb2Domain selectOgm010pf(SpareUnitDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOgm010pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectmanagerYN(SpareUnitDb2Domain)
     */
    public SpareUnitDb2Domain selectmanagerYN(SpareUnitDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectmanagerYN", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectcloseYN(SpareUnitDb2Domain)
     */
    public SpareUnitDb2Domain selectcloseYN(SpareUnitDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectcloseYN", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm203_cmplt(PsogmDomain)
     */
    public String selectOgm203_cmplt(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOgm203_cmplt", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOGM115_maxNumber(SpareUnitDb2Domain)
     */
    public SpareUnitDb2Domain selectOGM115_maxNumber(SpareUnitDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOGM115_maxNumber", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#selectOgm_maxJisiNum(PsogmDomain)
     */
    public String selectOgm_maxJisiNum(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOgm_maxJisiNum", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao.BoardDao#insertOGM115(SpareUnitDb2Domain)
     */
    public void insertOGM115(SpareUnitDb2Domain domain) throws ApplicationException {
        sqlSessionTemplate4.insert(NAMESPACE + ".insertOGM115", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao.BoardDao#insertOgm203(PsogmDomain)
     */
    public void insertOgm203(PsogmDomain domain) throws ApplicationException {
        sqlSessionTemplate4.insert(NAMESPACE + ".insertOgm203", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao.BoardDao#insertOgm203_pepcd(PsogmDomain)
     */
    public void insertOgm203_pepcd(PsogmDomain domain) throws ApplicationException {
        sqlSessionTemplate4.insert(NAMESPACE + ".insertOgm203_pepcd", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao.BoardDao#insertOgm205_obj220pf(PsogmDomain)
     */
    public void insertOgm205_obj220pf(PsogmDomain domain) throws ApplicationException {
        sqlSessionTemplate4.insert(NAMESPACE + ".insertOgm205_obj220pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#updateOGM115_1(EmpDomain)
     */
    public int updateOGM115_1(SpareUnitDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.update(NAMESPACE + ".updateOGM115_1", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#updateOgm_maxJisiNum(PsogmDomain)
     */
    public int updateOgm_maxJisiNum(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.update(NAMESPACE + ".updateOgm_maxJisiNum", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#updateOgm203(PsogmDomain)
     */
    public int updateOgm203(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.update(NAMESPACE + ".updateOgm203", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#updateOgm203_pepcd(PsogmDomain)
     */
    public int updateOgm203_pepcd(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.update(NAMESPACE + ".updateOgm203_pepcd", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#updateOgm205_obj220pf(PsogmDomain)
     */
    public int updateOgm205_obj220pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.update(NAMESPACE + ".updateOgm205_obj220pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PsogmDao#updateOgm205_obj220pf(PsogmDomain)
     */
    public int deleteOgm205_obj220pf(PsogmDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteOgm205_obj220pf", domain);
    }
}
