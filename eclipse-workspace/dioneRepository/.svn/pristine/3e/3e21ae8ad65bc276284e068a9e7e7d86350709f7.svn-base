package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.PaymentTypeBaseDomain;
import com.globaldenso.dnkr.integration.dao.PaymentTypeBaseDao;

/**
* [KR]  <br>
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Service("paymentTypeBaseService")
public class PaymentTypeBaseServiceImpl implements PaymentTypeBaseService {
	
	/**
     * [KR] Dao 필드<br>
     * [EN] A field of PaymentTypeBaseDao.<br>
     */
    @Autowired
    private PaymentTypeBaseDao paymentTypeBaseDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PaymentTypeBaseServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set PaymentTypeBaseDao.<br>
     * [JP] <br>
     * 
     */
    public void setPaymentTypeBaseDao(PaymentTypeBaseDao paymentTypeBaseDao) {
        this.paymentTypeBaseDao = paymentTypeBaseDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PaymentTypeBaseService#searchByKey(PaymentTypeBaseDomain)
     */
    public PaymentTypeBaseDomain searchByKey(PaymentTypeBaseDomain domain) throws ApplicationException {
        return paymentTypeBaseDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PaymentTypeBaseService#searchByCondition(PaymentTypeBaseDomain)
     */
    public List<PaymentTypeBaseDomain> searchByCondition(PaymentTypeBaseDomain domain) throws ApplicationException {
        return paymentTypeBaseDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PaymentTypeBaseService#searchByConditionForPaging(PaymentTypeBaseDomain)
     */
    public List<PaymentTypeBaseDomain> searchByConditionForPaging(PaymentTypeBaseDomain domain) throws ApplicationException {
        return paymentTypeBaseDao.searchByConditionForPaging(domain);
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PaymentTypeBaseService#create(PaymentTypeBaseDomain)
     */
    public void create(PaymentTypeBaseDomain domain) throws ApplicationException {
        try {
        	paymentTypeBaseDao.create(domain);
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
     * @see com.globaldenso.dnkr.business.service.PaymentTypeBaseService#update(PaymentTypeBaseDomain)
     */
    public int update(PaymentTypeBaseDomain domain) throws ApplicationException {
    	return paymentTypeBaseDao.update(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PaymentTypeBaseService#delete(PaymentTypeBaseDomain)
     */
    public int delete(PaymentTypeBaseDomain domain) throws ApplicationException {
    	return paymentTypeBaseDao.delete(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PaymentTypeBaseService#delete(List)
     */
    public int delete(List<PaymentTypeBaseDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (PaymentTypeBaseDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }


	@Override
	public int searchCount(PaymentTypeBaseDomain domain) throws ApplicationException {
		return paymentTypeBaseDao.searchCount(domain);
	}


	@Override
	public int searchCount2(PaymentTypeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return paymentTypeBaseDao.searchCount2(domain);
	}
    
    
	
}
