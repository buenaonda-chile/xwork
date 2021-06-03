package com.globaldenso.dnkr.business.service;

import java.util.HashMap;
import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.NonOrderDayTransferWorkDomain;

/**
 * [KR] 비서열/확정오더형 일일 수주이관 작업 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface NonOrderDayTransferWorkService {

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
