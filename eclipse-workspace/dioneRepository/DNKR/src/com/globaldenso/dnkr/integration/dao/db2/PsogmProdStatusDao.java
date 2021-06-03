package com.globaldenso.dnkr.integration.dao.db2;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.PsogmProdStatusDb2Domain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PsogmProdStatusDao {

    /**
     * [KO] 생산현황조회<br>
     * [EN] Search auth information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'PsogmProdStatusDb2Domain' class
     * @return 'PsogmProdStatusDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmProdStatusDb2Domain> selectOBSE01(PsogmProdStatusDb2Domain domain) throws ApplicationException;
    
    /**
     * [KR] 생산실적 합계조회<br> 
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmProdStatusDb2Domain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public PsogmProdStatusDb2Domain selectOBSE01_Sum(PsogmProdStatusDb2Domain domain) throws ApplicationException;

}
