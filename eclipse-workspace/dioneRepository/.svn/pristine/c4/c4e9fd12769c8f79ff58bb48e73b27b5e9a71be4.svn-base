package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CustomerDomain;
import com.globaldenso.dnkr.integration.dao.CustomerDao;

/**
* [KR] 거래처 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustomerDao.<br>
     */
    @Autowired
    private CustomerDao customerDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public CustomerServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set CustomerDao.<br>
     * [JP] <br>
     * 
     * @param customerDao 'CustomerDao' class
     */
    public void setCustomerDao(CustomerDao customertDao) {
        this.customerDao = customerDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustomerService#searchByKey(CustomerDomain)
     */
    public CustomerDomain searchByKey(CustomerDomain domain) throws ApplicationException {
        return customerDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustomerService#searchByCondition(CustomerDomain)
     */
    public List<CustomerDomain> searchByCondition(CustomerDomain domain) throws ApplicationException {
        return customerDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustomerService#searchByConditionForPaging(CustomerDomain)
     */
    public List<CustomerDomain> searchByConditionForPaging(CustomerDomain domain) throws ApplicationException {
        return customerDao.searchByConditionForPaging(domain);
    }
}
