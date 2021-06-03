package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.SalAnlysComentDomain;
import com.globaldenso.dnkr.integration.dao.SalAnlysComentDao;

/**
* [KR]  <br>
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Service("salAnlysComentService")
public class SalAnlysComentServiceImpl implements SalAnlysComentService {
	
	/**
     * [KR] Dao 필드<br>
     * [EN] A field of SalAnlysComentDao.<br>
     */
    @Autowired
    private SalAnlysComentDao salAnlysComentDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public SalAnlysComentServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set PaymentTypeBaseDao.<br>
     * [JP] <br>
     * 
     */
    public void setSalAnlysComentDao(SalAnlysComentDao paymentTypeBaseDao) {
        this.salAnlysComentDao = salAnlysComentDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SalAnlysComentService#searchByKey(PaymentTypeBaseDomain)
     */
    public SalAnlysComentDomain searchByKey(SalAnlysComentDomain domain) throws ApplicationException {
        return salAnlysComentDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SalAnlysComentService#searchByCondition(PaymentTypeBaseDomain)
     */
    public List<SalAnlysComentDomain> searchByCondition(SalAnlysComentDomain domain) throws ApplicationException {
        return salAnlysComentDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SalAnlysComentService#searchByConditionForPaging(PaymentTypeBaseDomain)
     */
    public List<SalAnlysComentDomain> searchByConditionForPaging(SalAnlysComentDomain domain) throws ApplicationException {
        return salAnlysComentDao.searchByConditionForPaging(domain);
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SalAnlysComentService#create(PaymentTypeBaseDomain)
     */
    public void create(SalAnlysComentDomain domain) throws ApplicationException {
        try {
        	salAnlysComentDao.create(domain);
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
     * @see com.globaldenso.dnkr.business.service.SalAnlysComentService#update(PaymentTypeBaseDomain)
     */
    public int update(SalAnlysComentDomain domain) throws ApplicationException {
    	return salAnlysComentDao.update(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SalAnlysComentService#delete(PaymentTypeBaseDomain)
     */
    public int delete(SalAnlysComentDomain domain) throws ApplicationException {
    	return salAnlysComentDao.delete(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SalAnlysComentService#delete(List)
     */
    public int delete(List<SalAnlysComentDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (SalAnlysComentDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }


	@Override
	public int searchCount(SalAnlysComentDomain domain) throws ApplicationException {
		return salAnlysComentDao.searchCount(domain);
	}


	@Override
	public int searchCount2(SalAnlysComentDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return salAnlysComentDao.searchCount2(domain);
	}
    
    
	
}
