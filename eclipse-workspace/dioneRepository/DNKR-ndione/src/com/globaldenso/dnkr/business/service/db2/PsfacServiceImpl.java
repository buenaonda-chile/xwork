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
import com.globaldenso.dnkr.domain.db2.PsfacDb2Domain;
import com.globaldenso.dnkr.domain.db2.PsogmProdStatusDb2Domain;
import com.globaldenso.dnkr.integration.dao.db2.PsfacDao;

/**
 * [KR] 생산전광판 현황 구현.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("psfaclibService")
public class PsfacServiceImpl implements PsfacService {

    /**
     * [KR] 권한관리 Dao <br>
     */
    @Autowired
    private PsfacDao psfaclibDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PsfacServiceImpl() {
        // no process
    }
    
    /**
     * [EN] Set DAO of Employee information.<br>
     * [JP] 社員情報のDAOを設定します。<br>
     * 
     * @param psfaclibDao Dao of 'PsfaclibDao'
     */
    public void setPsfaclibDao(PsfacDao psfaclibDao) {
        this.psfaclibDao = psfaclibDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.PsogmProdStatusService#selectOBSE01(PsogmProdStatusDb2Domain)
     */
    public List<PsfacDb2Domain > selectFEP200PF(PsfacDb2Domain domain) throws ApplicationException {
        return psfaclibDao.selectFEP200PF(domain);
        
    }

}
