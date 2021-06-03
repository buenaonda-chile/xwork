package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.OrderTransferMngDomain;
import com.globaldenso.dnkr.integration.dao.OrderTransferMngDao;

/**
* [KR]  <br>
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Service("orderTransferMngService")
public class OrderTransferMngServiceImpl implements OrderTransferMngService {
	
	/**
     * [KR] Dao 필드<br>
     * [EN] A field of OrderTransferMngDao.<br>
     */
    @Autowired
    private OrderTransferMngDao orderTransferMngDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public OrderTransferMngServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set OrderTransferMngDao.<br>
     * [JP] <br>
     * 
     */
    public void setOrderTransferMngDao(OrderTransferMngDao orderTransferMngDao) {
        this.orderTransferMngDao = orderTransferMngDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderTransferMngService#searchByKey(OrderTransferMngDomain)
     */
    public OrderTransferMngDomain searchByKey(OrderTransferMngDomain domain) throws ApplicationException {
        return orderTransferMngDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderTransferMngService#searchByCondition(OrderTransferMngDomain)
     */
    public List<OrderTransferMngDomain> searchByCondition(OrderTransferMngDomain domain) throws ApplicationException {
        return orderTransferMngDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderTransferMngService#searchByConditionForPaging(OrderTransferMngDomain)
     */
    public List<OrderTransferMngDomain> searchByConditionForPaging(OrderTransferMngDomain domain) throws ApplicationException {
        return orderTransferMngDao.searchByConditionForPaging(domain);
    }
    
	
}
