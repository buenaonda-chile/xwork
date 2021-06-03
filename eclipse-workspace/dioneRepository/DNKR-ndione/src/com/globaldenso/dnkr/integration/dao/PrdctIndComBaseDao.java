package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PrdctIndComBaseDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PrdctIndComBaseDao {

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LgstTimeDstrRtBaseDomain' class
     * @return List of 'LgstTimeDstrRtBaseDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */    
    public List<PrdctIndComBaseDomain> searchItemMaster(PrdctIndComBaseDomain domain) throws ApplicationException;    
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LgstTimeDstrRtBaseDomain' class
     * @return List of 'LgstTimeDstrRtBaseDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */    
    public List<PrdctIndComBaseDomain> searchDeptMaster(PrdctIndComBaseDomain domain) throws ApplicationException;    

    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LgstTimeDstrRtBaseDomain' class
     * @return List of 'LgstTimeDstrRtBaseDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */    
    public List<PrdctIndComBaseDomain> searchEmpMaster(PrdctIndComBaseDomain domain) throws ApplicationException;    
    
    
 
}
