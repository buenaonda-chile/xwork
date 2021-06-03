package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderHostUpCheckListDomain;
import com.globaldenso.dnkr.integration.dao.OrderHostUpCheckListDao;

/**
* [KR] 서열형 HOST UP CHECK LIST 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("orderHostUpCheckListService")
public class OrderHostUpCheckListServiceImpl implements OrderHostUpCheckListService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of OrderHostUpCheckListDao.<br>
     */
    @Autowired
    private OrderHostUpCheckListDao orderHostUpCheckListDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public OrderHostUpCheckListServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set OrderHostUpCheckListDao.<br>
     * [JP] <br>
     * 
     * @param OrderHostUpCheckListDao 'OrderHostUpCheckListDao' class
     */
    public void setOrderHostUpCheckListDao(OrderHostUpCheckListDao orderHostUpCheckListDao) {
        this.orderHostUpCheckListDao = orderHostUpCheckListDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderHostUpCheckListService#searchByKey(OrderHostUpCheckListDomain)
     */
    public OrderHostUpCheckListDomain searchByKey(OrderHostUpCheckListDomain domain) throws ApplicationException {
        return orderHostUpCheckListDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderHostUpCheckListService#searchByCondition(OrderHostUpCheckListDomain)
     */
    public List<OrderHostUpCheckListDomain> searchByCondition(OrderHostUpCheckListDomain domain) throws ApplicationException {
        return orderHostUpCheckListDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderHostUpCheckListService#searchByConditionForPaging(CustOrderTypeHistMstViewDomain)
     */
    public List<OrderHostUpCheckListDomain> searchByConditionForPaging(OrderHostUpCheckListDomain domain) throws ApplicationException {
        return orderHostUpCheckListDao.searchByConditionForPaging(domain);
    }
}
