/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PsogmMachineDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;


/**
 * [KR] 측정기관리 서비스 인터페이스. <br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PsogmMachineService {
    
    /**
     * [KO] 측정기관리 장비조회<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmMachineDomain' class
     * @return 'PsogmMachineDomain' class List
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmMachineDomain> selectogm411(PsogmMachineDomain domain) throws ApplicationException;
    
    /**
     * [EN] (For paging processing) <br>
     * [JP] (ページング処理用) <br>
     * 
     * @param domain 'PsogmMachineDomain' class
     * @return List of 'PsogmMachineDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmMachineDomain> selectogm411ForPaging(PsogmMachineDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search employee information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
     * 
     * @param domain 'PsogmMachineDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(PsogmMachineDomain domain) throws ApplicationException;
    
    /**
     * [KO] 폐기사유<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'CommonDb2Domain' class
     * @return 'CommonDb2Domain' class List
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<CommonDb2Domain> selectOgm411_cmbsel(CommonDb2Domain domain) throws ApplicationException;
}
