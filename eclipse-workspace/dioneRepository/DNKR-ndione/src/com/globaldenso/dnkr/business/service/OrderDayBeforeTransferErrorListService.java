package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderDayBeforeTransferErrorListDomain;

/**
 * [KR] 서열형 일일 수주이관전 ERROR LIST(HKMC) 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface OrderDayBeforeTransferErrorListService {

    /**
    * [KO] 기본키로  DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'OrderDayBeforeTransferErrorListDomain' class
    * @return 'OrderDayBeforeTransferErrorListDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public OrderDayBeforeTransferErrorListDomain searchByKey(OrderDayBeforeTransferErrorListDomain domain) throws ApplicationException;

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'OrderDayBeforeTransferErrorListDomain' class
     * @return List of 'OrderDayBeforeTransferErrorListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderDayBeforeTransferErrorListDomain> searchByCondition(OrderDayBeforeTransferErrorListDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'OrderDayBeforeTransferErrorListDomain' class
     * @return List of 'OrderDayBeforeTransferErrorListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderDayBeforeTransferErrorListDomain> searchByConditionForPaging(OrderDayBeforeTransferErrorListDomain domain) throws ApplicationException;
}
