package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.NonOrderDayAfterTransferErrorListDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface NonOrderDayAfterTransferErrorListDao {

    /**
     * [KO] 기본키로  DB table 에서 정보를 검색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'NonOrderDayAfterTransferErrorListDomain' class
     * @return 'NonOrderDayAfterTransferErrorListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public NonOrderDayAfterTransferErrorListDomain searchByKey(NonOrderDayAfterTransferErrorListDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'OrderDayAfterTransferErrorListDomain' class
     * @return List of 'OrderDayAfterTransferErrorListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<NonOrderDayAfterTransferErrorListDomain> searchByCondition(NonOrderDayAfterTransferErrorListDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'OrderDayAfterTransferErrorListDomain' class
     * @return List of 'OrderDayAfterTransferErrorListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<NonOrderDayAfterTransferErrorListDomain> searchByConditionForPaging(NonOrderDayAfterTransferErrorListDomain domain) throws ApplicationException;
}
