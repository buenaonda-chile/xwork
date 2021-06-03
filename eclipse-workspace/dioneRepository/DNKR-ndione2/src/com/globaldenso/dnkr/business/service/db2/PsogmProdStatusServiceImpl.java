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
import com.globaldenso.dnkr.domain.db2.PsogmProdStatusDb2Domain;
import com.globaldenso.dnkr.integration.dao.db2.PsogmProdStatusDao;

/**
 * [KR] 생산전광판 현황 구현.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("psogmProdStatusService")
public class PsogmProdStatusServiceImpl implements PsogmProdStatusService {

    /**
     * [KR] 권한관리 Dao <br>
     */
    @Autowired
    private PsogmProdStatusDao psogmProdStatusDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PsogmProdStatusServiceImpl() {
        // no process
    }
    
    /**
     * [EN] Set DAO of Employee information.<br>
     * [JP] 社員情報のDAOを設定します。<br>
     * 
     * @param psogmProdStatusDao Dao of 'PsogmProdStatusDao'
     */
    public void setPsogmMonPerformDao(PsogmProdStatusDao psogmProdStatusDao) {
        this.psogmProdStatusDao = psogmProdStatusDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.PsogmProdStatusService#selectOBSE01(PsogmProdStatusDb2Domain)
     */
    public List<PsogmProdStatusDb2Domain> selectOBSE01(PsogmProdStatusDb2Domain domain) throws ApplicationException {
        return psogmProdStatusDao.selectOBSE01(domain);
        
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PsogmProdStatusService#selectOBSE01_Sum(PsogmProdStatusDb2Domain)
     */
    public PsogmProdStatusDb2Domain selectOBSE01_Sum(PsogmProdStatusDb2Domain domain) throws ApplicationException {
        return psogmProdStatusDao.selectOBSE01_Sum(domain);
        
    }
}
