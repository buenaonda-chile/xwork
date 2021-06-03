package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.OrderDayITEMMstDomain;
import com.globaldenso.dnkr.integration.dao.OrderDayITEMMstDao;

/**
* [KR] 일일수주갱신 ITEM 제어마스타 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("orderDayITEMMstService")
public class OrderDayITEMMstServiceImpl implements OrderDayITEMMstService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of OrderDayITEMMstDao.<br>
     */
    @Autowired
    private OrderDayITEMMstDao orderDayITEMMstDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public OrderDayITEMMstServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set OrderDayITEMMstDao.<br>
     * [JP] <br>
     * 
     * @param orderDayITEMMstDao 'OrderDayITEMMstDao' class
     */
    public void setOrderDayITEMMstDao(OrderDayITEMMstDao orderDayITEMMstDao) {
        this.orderDayITEMMstDao = orderDayITEMMstDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayITEMMstService#searchByCondition(OrderDayITEMMstDomain)
     */
    public List<OrderDayITEMMstDomain> searchByCondition(OrderDayITEMMstDomain domain) throws ApplicationException {
        return orderDayITEMMstDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayITEMMstService#searchCount(OrderDayITEMMstDomain)
     */
    public int pspnoSearchCount(OrderDayITEMMstDomain domain) throws ApplicationException {
        return orderDayITEMMstDao.pspnoSearchCount(domain);
    }
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayITEMMstService#searchCount(OrderDayITEMMstDomain)
     */
    public int searchCount(OrderDayITEMMstDomain domain) throws ApplicationException {
        return orderDayITEMMstDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayITEMMstService#create(OrderDayITEMMstDomain)
     */
    public void create(OrderDayITEMMstDomain domain) throws ApplicationException {
        try {
        	orderDayITEMMstDao.create(domain);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.employee"));
            } else {
                throw e;
            }
        }
    }
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayITEMMstService#delete(OrderDayITEMMstDomain)
     */
    public int delete(OrderDayITEMMstDomain domain) throws ApplicationException {
    	return orderDayITEMMstDao.delete(domain);
    }
}
