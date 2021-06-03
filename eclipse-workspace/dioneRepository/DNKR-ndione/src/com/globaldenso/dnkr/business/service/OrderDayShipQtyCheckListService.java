package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderDayShipQtyCheckListDomain;

/**
 * [KR] 서열형 일일출하및수주량 CHECK LIST 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface OrderDayShipQtyCheckListService {

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'OrderDayShipQtyCheckListDomain' class
     * @return List of 'OrderDayShipQtyCheckListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderDayShipQtyCheckListDomain> selectMST040PF_HOUSE(OrderDayShipQtyCheckListDomain domain) throws ApplicationException;
    
    public List<OrderDayShipQtyCheckListDomain> selectSPDE141Q_142PF(OrderDayShipQtyCheckListDomain domain) throws ApplicationException;
    
    public List<OrderDayShipQtyCheckListDomain> selectSPDE141Q_148PF(OrderDayShipQtyCheckListDomain domain) throws ApplicationException;
    
    public List<OrderDayShipQtyCheckListDomain> selectSAL100_SE(OrderDayShipQtyCheckListDomain domain) throws ApplicationException;
    
    public List<OrderDayShipQtyCheckListDomain> selectMST090PF(OrderDayShipQtyCheckListDomain domain) throws ApplicationException;

}
