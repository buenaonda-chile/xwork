package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderDayAfterTransferErrorListDomain;
import com.globaldenso.dnkr.integration.dao.OrderDayAfterTransferErrorListDao;

/**
* [KR] 서열형 일일 수주이관후 ERROR LIST 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("orderDayAfterTransferErrorListService")
public class OrderDayAfterTransferErrorListServiceImpl implements OrderDayAfterTransferErrorListService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of OrderDayAfterTransferErrorListDao.<br>
     */
    @Autowired
    private OrderDayAfterTransferErrorListDao orderDayAfterTransferErrorListDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public OrderDayAfterTransferErrorListServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set OrderDayAfterTransferErrorListDao.<br>
     * [JP] <br>
     * 
     * @param OrderDayAfterTransferErrorListDao 'OrderDayAfterTransferErrorListDao' class
     */
    public void setOrderDayAfterTransferErrorListDao(OrderDayAfterTransferErrorListDao orderDayAfterTransferErrorListDao) {
        this.orderDayAfterTransferErrorListDao = orderDayAfterTransferErrorListDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayAfterTransferErrorListService#searchByKey(OrderDayAfterTransferErrorListDomain)
     */
    public OrderDayAfterTransferErrorListDomain searchByKey(OrderDayAfterTransferErrorListDomain domain) throws ApplicationException {
        return orderDayAfterTransferErrorListDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayAfterTransferErrorListService#searchByCondition(OrderDayAfterTransferErrorListDomain)
     */
    public List<OrderDayAfterTransferErrorListDomain> searchByCondition(OrderDayAfterTransferErrorListDomain domain) throws ApplicationException {
        return orderDayAfterTransferErrorListDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayAfterTransferErrorListService#searchByConditionForPaging(OrderDayAfterTransferErrorListDomain)
     */
    public List<OrderDayAfterTransferErrorListDomain> searchByConditionForPaging(OrderDayAfterTransferErrorListDomain domain) throws ApplicationException {
        return orderDayAfterTransferErrorListDao.searchByConditionForPaging(domain);
    }
}
