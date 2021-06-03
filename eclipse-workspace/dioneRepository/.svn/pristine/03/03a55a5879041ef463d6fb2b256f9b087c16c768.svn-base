package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderDayShipQtyCheckListDomain;
import com.globaldenso.dnkr.integration.dao.OrderDayShipQtyCheckListDao;

/**
* [KR] 서열형 일일출하및수주량 CHECK LIST 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("orderDayShipQtyCheckListService")
public class OrderDayShipQtyCheckListServiceImpl implements OrderDayShipQtyCheckListService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of orderDayShipQtyCheckListDao.<br>
     */
    @Autowired
    private OrderDayShipQtyCheckListDao orderDayShipQtyCheckListDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public OrderDayShipQtyCheckListServiceImpl() {
        // no process
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayShipQtyCheckListService#selectMST040PF_HOUSE(OrderDayShipQtyCheckListDomain)
     */
    public List<OrderDayShipQtyCheckListDomain> selectMST040PF_HOUSE(OrderDayShipQtyCheckListDomain domain) throws ApplicationException {
        return orderDayShipQtyCheckListDao.selectMST040PF_HOUSE(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayShipQtyCheckListService#selectSPDE141Q_142PF(OrderDayShipQtyCheckListDomain)
     */
    public List<OrderDayShipQtyCheckListDomain> selectSPDE141Q_142PF(OrderDayShipQtyCheckListDomain domain) throws ApplicationException {
        return orderDayShipQtyCheckListDao.selectSPDE141Q_142PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayShipQtyCheckListService#selectSPDE141Q_148PF(OrderDayShipQtyCheckListDomain)
     */
    public List<OrderDayShipQtyCheckListDomain> selectSPDE141Q_148PF(OrderDayShipQtyCheckListDomain domain) throws ApplicationException {
        return orderDayShipQtyCheckListDao.selectSPDE141Q_148PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayShipQtyCheckListService#selectSAL100_SE(OrderDayShipQtyCheckListDomain)
     */
    public List<OrderDayShipQtyCheckListDomain> selectSAL100_SE(OrderDayShipQtyCheckListDomain domain) throws ApplicationException {
        return orderDayShipQtyCheckListDao.selectSAL100_SE(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayShipQtyCheckListService#selectMST090PF(OrderDayShipQtyCheckListDomain)
     */
    public List<OrderDayShipQtyCheckListDomain> selectMST090PF(OrderDayShipQtyCheckListDomain domain) throws ApplicationException {
        return orderDayShipQtyCheckListDao.selectMST090PF(domain);
    }
}
