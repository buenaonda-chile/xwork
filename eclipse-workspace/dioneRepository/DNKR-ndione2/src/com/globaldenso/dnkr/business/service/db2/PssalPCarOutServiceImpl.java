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
import com.globaldenso.dnkr.domain.db2.PssalPCarOutDomain;
import com.globaldenso.dnkr.integration.dao.db2.PssalPCarOutDao;

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
@Service("PssalPCarOutService")
public class PssalPCarOutServiceImpl implements PssalPCarOutService {

    /**
     * 
     */
    @Autowired
    private PssalPCarOutDao pssalPCarOutDao;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PssalPCarOutServiceImpl() {
        // no process
    }
    
    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public List<PssalPCarOutDomain> selectSMDE122Q_gridVal_Obj(PssalPCarOutDomain domain)
            throws ApplicationException {
        return pssalPCarOutDao.selectSMDE122Q_gridVal_Obj(domain);
    }
}
