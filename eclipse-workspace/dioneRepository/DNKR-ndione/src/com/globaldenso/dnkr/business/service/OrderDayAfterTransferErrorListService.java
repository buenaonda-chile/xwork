package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderDayAfterTransferErrorListDomain;

/**
 * [KR] 서열형 일일 수주이관후 ERROR LIST 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface OrderDayAfterTransferErrorListService {

    /**
    * [KO] 기본키로  DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'OrderDayAfterTransferErrorListDomain' class
    * @return 'OrderDayAfterTransferErrorListDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public OrderDayAfterTransferErrorListDomain searchByKey(OrderDayAfterTransferErrorListDomain domain) throws ApplicationException;

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'OrderDayAfterTransferErrorListDomain' class
     * @return List of 'OrderDayAfterTransferErrorListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderDayAfterTransferErrorListDomain> searchByCondition(OrderDayAfterTransferErrorListDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'OrderDayAfterTransferErrorListDomain' class
     * @return List of 'OrderDayAfterTransferErrorListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderDayAfterTransferErrorListDomain> searchByConditionForPaging(OrderDayAfterTransferErrorListDomain domain) throws ApplicationException;
}
