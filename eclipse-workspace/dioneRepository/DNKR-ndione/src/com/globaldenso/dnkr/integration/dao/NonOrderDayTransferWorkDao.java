package com.globaldenso.dnkr.integration.dao;

import java.util.HashMap;
import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.NonOrderDayTransferWorkDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface NonOrderDayTransferWorkDao {

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'NonOrderDayTransferWorkDomain' class
     * @return List of 'NonOrderDayTransferWorkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<NonOrderDayTransferWorkDomain> searchCigmaDate(NonOrderDayTransferWorkDomain domain) throws ApplicationException;
    
    
    public boolean procTrans(HashMap parm) throws ApplicationException;

}
