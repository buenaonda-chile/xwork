/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.business.service.db2;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.PsogmProdStatusDb2Domain;


/**
 * [KR] 생산전광판 현황 서비스 인터페이스. <br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PsogmProdStatusService {

    /**
    * [KO] 생산현황 조회.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'PsogmProdStatusDb2Domain' class
    * @return 'PsogmMonPerformDb2Domain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public List<PsogmProdStatusDb2Domain> selectOBSE01(PsogmProdStatusDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 생산실적 합계<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmProdStatusDb2Domain' class
     * @return 'PsogmProdStatusDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public PsogmProdStatusDb2Domain selectOBSE01_Sum(PsogmProdStatusDb2Domain domain) throws ApplicationException;
}
