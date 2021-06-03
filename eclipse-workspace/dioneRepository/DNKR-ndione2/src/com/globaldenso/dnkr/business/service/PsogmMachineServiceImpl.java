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

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PsogmMachineDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.integration.dao.PsogmMachineDao;

/**
 * [KR] 권한관리 서비스 구현.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("psogmMachineService")
public class PsogmMachineServiceImpl implements PsogmMachineService {
    
    /**
     * [KR] 권한관리 Dao <br>
     */
    @Autowired
    private PsogmMachineDao psogmMachineDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PsogmMachineServiceImpl() {
        // no process
    }
    
    /**
     * [EN] Set DAO of Machine information.<br>
     * [JP] <br>
     * 
     * @param psogmMachineDao Dao of 'psogmMachineDao'
     */
    public void setPsogmMachineDao(PsogmMachineDao psogmMachineDao) {
        this.psogmMachineDao = psogmMachineDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmMachineService#getogm313_cmbprtcd(PsogmMachineDomain)
     */
    public List<PsogmMachineDomain> selectogm411(PsogmMachineDomain domain) throws ApplicationException {
        return psogmMachineDao.selectogm411(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.PsogmMachineService#searchByConditionForPaging(PsogmMachineDomain)
     */
    public List<PsogmMachineDomain> selectogm411ForPaging(PsogmMachineDomain domain) throws ApplicationException {
        return psogmMachineDao.selectogm411ForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.PsogmMachineService#searchCount(PsogmMachineDomain)
     */
    public int searchCount(PsogmMachineDomain domain) throws ApplicationException {
        return psogmMachineDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmMachineService#selectOgm411_cmbsel(CommonDb2Domain)
     */
    public List<CommonDb2Domain> selectOgm411_cmbsel(CommonDb2Domain domain) throws ApplicationException {
        return psogmMachineDao.selectOgm411_cmbsel(domain);
    }
}
