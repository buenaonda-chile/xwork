package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PsogmMachineDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;

/**
 * [KO] 측정기관리 장비 정보의 DAO interface.<br>
 * [EN] DAO interface of Common code information.<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PsogmMachineDao {

    /**
     * [KO] 장비조회 결과 레코드 반환<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmMachineDomain' class
     * @return 'PsogmMachineDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmMachineDomain> selectogm411(PsogmMachineDomain domain) throws ApplicationException;
    
    /**
     * [EN] (For paging processing)<br>
     * [JP] (ページング処理用)<br>
     * 
     * @param domain 'PsogmMachineDomain' class
     * @return List of 'PsogmMachineDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmMachineDomain> selectogm411ForPaging(PsogmMachineDomain domain) throws ApplicationException;

    /**
     * [KR] 장비조회 결과의 레코드수 반환<br> 
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmMachineDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(PsogmMachineDomain domain) throws ApplicationException;
    
    /**
     * [KO] 폐기사유 결과 레코드 반환<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'CommonDb2Domain' class
     * @return 'CommonDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<CommonDb2Domain> selectOgm411_cmbsel(CommonDb2Domain domain) throws ApplicationException;
}
