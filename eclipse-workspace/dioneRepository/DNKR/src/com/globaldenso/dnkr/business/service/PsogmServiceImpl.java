/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.RelationDb2Domain;
import com.globaldenso.dnkr.domain.db2.FileDb2Domain;
import com.globaldenso.dnkr.domain.db2.MachineDb2Domain;
import com.globaldenso.dnkr.domain.db2.PsogmDomain;
import com.globaldenso.dnkr.domain.db2.SpareUnitDb2Domain;
import com.globaldenso.dnkr.integration.dao.PsogmDao;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 권한관리 서비스 구현.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("psogmService")
public class PsogmServiceImpl implements PsogmService {

    /**
     * 첨부파일 저장소 
     */
    final String ROOTPATH = UxisCmmUtil.getProperty("system.uploadpath");
    
    
    /**
     * [KR] 권한관리 Dao <br>
     */
    @Autowired
    private PsogmDao psogmDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PsogmServiceImpl() {
        // no process
    }
    
    /**
     * [EN] Set DAO of Employee information.<br>
     * [JP] 社員情報のDAOを設定します。<br>
     * 
     * @param psogmDao Dao of 'PsogmDao'
     */
    public void setPsogmDao(PsogmDao psogmDao) {
        this.psogmDao = psogmDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOGM200_chk(MachineDb2Domain)
     */
    public MachineDb2Domain selectOGM200_chk(MachineDb2Domain domain) throws ApplicationException {
        return psogmDao.selectOGM200_chk(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm313_gms219(PsogmDomain)
     */
    public PsogmDomain selectOgm313_gms219(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm313_gms219(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_rep(PsogmDomain)
     */
    public PsogmDomain selectOgm203_rep(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_rep(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#select_obj220pf_InqParts(PsogmDomain)
     */
    public List<PsogmDomain> select_obj220pf_InqParts(PsogmDomain domain) throws ApplicationException {
        return psogmDao.select_obj220pf_InqParts(domain);
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_pepcdChk(PsogmDomain)
     */
    public PsogmDomain selectOgm203_pepcdChk(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_pepcdChk(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#getogm313_cmbprtcd(PsogmDomain)
     */
    public List<PsogmDomain> getogm313_cmbprtcd(RelationDb2Domain domain) throws ApplicationException {
        return psogmDao.getogm313_cmbprtcd(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm200_pop(MachineDb2Domain)
     */
    public List<MachineDb2Domain> selectOgm200_pop(MachineDb2Domain domain) throws ApplicationException {
        return psogmDao.selectOgm200_pop(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm200_method(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm200_method(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm200_method(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm313_obc250pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm313_obc250pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm313_obc250pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc230pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc230pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc230pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc220pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc220pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc220pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc160pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc160pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc160pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc060pf_01(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc060pf_01(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc060pf_01(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc060pf_02(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc060pf_02(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc060pf_02(domain);
        
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc070pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc070pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc070pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc050pf_01(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc050pf_01(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc050pf_01(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc190pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc190pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc190pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc120pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc120pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc120pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc100pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc100pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc100pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc100pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc180pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc180pf(domain);
        
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc110pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc110pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc110pf(domain);
        
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc110pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc090pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc090pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm314_onload(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm314_onload(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm314_onload(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc020pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc020pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc020pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc010pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc010pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc010pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc170pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc170pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc170pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc210pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc210pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc210pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc200pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc200pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc200pf(domain);
        
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_obc150pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm203_obc150pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_obc150pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm205_obj220pf(PsogmDomain)
     */
    public List<PsogmDomain> selectOgm205_obj220pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm205_obj220pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOGMPrtno(SpareUnitDb2Domain)
     */
    public List<SpareUnitDb2Domain> selectOGMPrtno(SpareUnitDb2Domain domain) throws ApplicationException {
        return psogmDao.selectOGMPrtno(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOGMVndnr(PsogmDomain)
     */
    public List<SpareUnitDb2Domain> selectOGMVndnr(SpareUnitDb2Domain domain) throws ApplicationException {
        return psogmDao.selectOGMVndnr(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOGMMaker(SpareUnitDb2Domain)
     */
    public List<SpareUnitDb2Domain> selectOGMMaker(SpareUnitDb2Domain domain) throws ApplicationException {
        return psogmDao.selectOGMMaker(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm219_obj230pf(FileDb2Domain)
     */
    public List<FileDb2Domain> selectOgm219_obj230pf(FileDb2Domain domain) throws ApplicationException {
        return psogmDao.selectOgm219_obj230pf(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOGM116(SpareUnitDb2Domain)
     */
    public List<SpareUnitDb2Domain> selectOGM116(SpareUnitDb2Domain domain) throws ApplicationException {
        return psogmDao.selectOGM116(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm205_pop(SpareUnitDb2Domain)
     */
    public List<SpareUnitDb2Domain> selectOgm205_pop(SpareUnitDb2Domain domain) throws ApplicationException {
        return psogmDao.selectOgm205_pop(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOGM116_JG(SpareUnitDb2Domain)
     */
    public SpareUnitDb2Domain selectOGM116_JG(SpareUnitDb2Domain domain) throws ApplicationException {
        return psogmDao.selectOGM116_JG(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm010pf(PsogmDomain)
     */
    public SpareUnitDb2Domain selectOgm010pf(SpareUnitDb2Domain domain) throws ApplicationException {
        return psogmDao.selectOgm010pf(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectmanagerYN(SpareUnitDb2Domain)
     */
    public SpareUnitDb2Domain selectmanagerYN(SpareUnitDb2Domain domain) throws ApplicationException {
        return psogmDao.selectmanagerYN(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectcloseYN(SpareUnitDb2Domain)
     */
    public SpareUnitDb2Domain selectcloseYN(SpareUnitDb2Domain domain) throws ApplicationException {
        return psogmDao.selectcloseYN(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm203_cmplt(PsogmDomain)
     */
    public String selectOgm203_cmplt(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm203_cmplt(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOGM115_maxNumber(SpareUnitDb2Domain)
     */
    public SpareUnitDb2Domain selectOGM115_maxNumber(SpareUnitDb2Domain domain) throws ApplicationException {
        return psogmDao.selectOGM115_maxNumber(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm_maxJisiNum(String)
     */
    public String selectOgm_maxJisiNum(PsogmDomain domain) throws ApplicationException {
        return psogmDao.selectOgm_maxJisiNum(domain);
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#insertOGM115(SpareUnitDb2Domain)
     */
    public void insertOGM115(SpareUnitDb2Domain domain) throws ApplicationException {
        try {
            psogmDao.insertOGM115(domain);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.employee"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#insertOgm203(PsogmDomain)
     */
    public void insertOgm203(PsogmDomain domain, String plantCd) throws ApplicationException {
        try {           
            psogmDao.insertOgm203(domain);
            
            domain.setComps(plantCd);
          //max jisno 테이블 update
            psogmDao.updateOgm_maxJisiNum(domain);
            
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.employee"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#insertOgm203_pepcd(PsogmDomain)
     */
    public void insertOgm203_pepcd(PsogmDomain domain) throws ApplicationException {
        try {           
            psogmDao.insertOgm203_pepcd(domain);
            
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.employee"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#insertOgm205_obj220pf(PsogmDomain)
     */
    public void insertOgm205_obj220pf(PsogmDomain domain) throws ApplicationException {
        try {           
            psogmDao.insertOgm205_obj220pf(domain);
            
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.employee"));
            } else {
                throw e;
            }
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#updateOGM115_1(SpareUnitDb2Domain)
     */
    public int updateOGM115_1(SpareUnitDb2Domain domain) throws ApplicationException {
        try {
            return psogmDao.updateOGM115_1(domain);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.board"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#updateOgm_maxJisiNum(PsogmDomain)
     */
    public int updateOgm_maxJisiNum(PsogmDomain domain) throws ApplicationException {
        try {
            return psogmDao.updateOgm_maxJisiNum(domain);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.board"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#updateOgm203(PsogmDomain)
     */
    public int updateOgm203(PsogmDomain domain) throws ApplicationException {
        try {
            return psogmDao.updateOgm203(domain);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.board"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#updateOgm203_pepcd(PsogmDomain)
     */
    public int updateOgm203_pepcd(PsogmDomain domain) throws ApplicationException {
        try {
            return psogmDao.updateOgm203_pepcd(domain);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.board"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#updateOgm205_obj220pf(PsogmDomain)
     */
    public int updateOgm205_obj220pf(PsogmDomain domain) throws ApplicationException {
        try {
            return psogmDao.updateOgm205_obj220pf(domain);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.board"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmService#deleteOgm205_obj220pf(PsogmDomain)
     */
    public int deleteOgm205_obj220pf(PsogmDomain domain) throws ApplicationException {
        return psogmDao.deleteOgm205_obj220pf(domain);
    }
}
