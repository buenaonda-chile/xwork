package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CustOrderDataMngDomain;
import com.globaldenso.dnkr.integration.dao.CustomerOrderDao;

/**
* [KR] 수주시스템 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("customerOrderService")
public class CustomerOrderServiceImpl implements CustomerOrderService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustomerOrderDao.<br>
     */
    @Autowired
    private CustomerOrderDao customerOrderDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public CustomerOrderServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set CustomerDao.<br>
     * [JP] <br>
     * 
     * @param customerDao 'CustomerDao' class
     */
    
    public void setCustomerOrderDao(CustomerOrderDao customerOrderDao) {
        this.customerOrderDao = customerOrderDao;
    }
  
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustomerOrderService#searchByCustOrderDataMng(CustOrderDataMngDomain)
     */
    public List<CustOrderDataMngDomain> searchByCustOrderDataMng(CustOrderDataMngDomain domain)  throws ApplicationException {
        return customerOrderDao.searchByCustOrderDataMng(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustomerOrderService#searchCountCustOrderDataMng(CustOrderDataMngDomain)
     */
    public int searchCountCustOrderDataMng(CustOrderDataMngDomain domain) throws ApplicationException {
        return customerOrderDao.searchCountCustOrderDataMng(domain);
    }
     
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustomerOrderService#updateCustOrderDataMng(CustOrderDataMngDomain)
     */
    public int updateCustOrderDataMng(CustOrderDataMngDomain domain) throws ApplicationException {
        return customerOrderDao.updateCustOrderDataMng(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustomerOrderService#deleteCustOrderDataMng(CustOrderDataMngDomain)
     */
    public int deleteCustOrderDataMng(CustOrderDataMngDomain domain) throws ApplicationException {
        return customerOrderDao.deleteCustOrderDataMng(domain);
    }
}
