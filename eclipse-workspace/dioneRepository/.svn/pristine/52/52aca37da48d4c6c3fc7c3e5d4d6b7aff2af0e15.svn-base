package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderDayBeforeTransferErrorListDomain;
import com.globaldenso.dnkr.integration.dao.OrderDayBeforeTransferErrorListDao;

/**
* [KR] 서열형 일일 수주이관전 ERROR LIST(HKMC) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("orderDayBeforeTransferErrorListService")
public class OrderDayBeforeTransferErrorListServiceImpl implements OrderDayBeforeTransferErrorListService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstchDao.<br>
     */
    @Autowired
    private OrderDayBeforeTransferErrorListDao orderDayBeforeTransferErrorListDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public OrderDayBeforeTransferErrorListServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set OrderDayBeforeTransferErrorListDao.<br>
     * [JP] <br>
     * 
     * @param OrderDayBeforeTransferErrorListDao 'OrderDayBeforeTransferErrorListDao' class
     */
    public void setOrderDayBeforeTransferErrorListDao(OrderDayBeforeTransferErrorListDao orderDayBeforeTransferErrorListDao) {
        this.orderDayBeforeTransferErrorListDao = orderDayBeforeTransferErrorListDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayBeforeTransferErrorListService#searchByKey(OrderDayBeforeTransferErrorListDomain)
     */
    public OrderDayBeforeTransferErrorListDomain searchByKey(OrderDayBeforeTransferErrorListDomain domain) throws ApplicationException {
        return orderDayBeforeTransferErrorListDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayBeforeTransferErrorListService#searchByCondition(OrderDayBeforeTransferErrorListDomain)
     */
    public List<OrderDayBeforeTransferErrorListDomain> searchByCondition(OrderDayBeforeTransferErrorListDomain domain) throws ApplicationException {
        return orderDayBeforeTransferErrorListDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayBeforeTransferErrorListService#searchByConditionForPaging(OrderDayBeforeTransferErrorListDomain)
     */
    public List<OrderDayBeforeTransferErrorListDomain> searchByConditionForPaging(OrderDayBeforeTransferErrorListDomain domain) throws ApplicationException {
        return orderDayBeforeTransferErrorListDao.searchByConditionForPaging(domain);
    }
}
