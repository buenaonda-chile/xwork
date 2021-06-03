/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.business.service.db2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.PsogmMonPerformDb2Domain;
import com.globaldenso.dnkr.integration.dao.db2.PsogmMonPerformDao;

/**
 * [KR] 권한관리 서비스 구현.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("psogmMonPerformService")
public class PsogmMonPerformServiceImpl implements PsogmMonPerformService {

    /**
     * [KR] 권한관리 Dao <br>
     */
    @Autowired
    private PsogmMonPerformDao psogmMonPerformDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PsogmMonPerformServiceImpl() {
        // no process
    }
    
    /**
     * [EN] Set DAO of Employee information.<br>
     * [JP] 社員情報のDAOを設定します。<br>
     * 
     * @param psogmMonPerformDao Dao of 'PsogmMonPerformDao'
     */
    public void setPsogmMonPerformDao(PsogmMonPerformDao psogmMonPerformDao) {
        this.psogmMonPerformDao = psogmMonPerformDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.PsogmMonPerformService#selectOgm401(PsogmMonPerformDb2Domain)
     */
    public List<PsogmMonPerformDb2Domain> selectOgm401(PsogmMonPerformDb2Domain domain) throws ApplicationException {
        return psogmMonPerformDao.selectOgm401(domain);
        
    }
//    
//    /**
//     * {@inheritDoc}
//     * 
//     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOgm200_pop(MachineDb2Domain)
//     */
//    public List<MachineDb2Domain> selectOgm200_pop(MachineDb2Domain domain) throws ApplicationException {
//        return psogmDao.selectOgm200_pop(domain);
//        
//    }
//    
//    /**
//     * {@inheritDoc}
//     * 
//     * @see com.globaldenso.dnkr.business.service.PsogmService#selectOGM200_chk(MachineDb2Domain)
//     */
//    public MachineDb2Domain selectOGM200_chk(MachineDb2Domain domain) throws ApplicationException {
//        return psogmDao.selectOGM200_chk(domain);
//        
//    }
}
