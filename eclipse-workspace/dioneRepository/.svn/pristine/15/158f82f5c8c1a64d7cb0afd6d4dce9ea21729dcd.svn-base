package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderTransferMngDomain;

/**
 * 
 *
 * @author K-DATALAB
 * @version 1.0
 */
public interface OrderTransferMngDao {

    /**
     * [KO] 기본키로  DB table 에서 정보를 검색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'OrderTransferMngDomain' class
     * @return 'OrderTransferMngDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public OrderTransferMngDomain searchByKey(OrderTransferMngDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'OrderTransferMngDomain' class
     * @return List of 'OrderTransferMngDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderTransferMngDomain> searchByCondition(OrderTransferMngDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'OrderTransferMngDomain' class
     * @return List of 'OrderTransferMngDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderTransferMngDomain> searchByConditionForPaging(OrderTransferMngDomain domain) throws ApplicationException;
    
}
