package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.CustTypeOrderExceptMstDomain;
import com.globaldenso.dnkr.integration.dao.CustTypeOrderExceptMstDao;

/**
* [KR] 업체차종서열제외마스타 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("custTypeOrderExceptMstService")
public class CustTypeOrderExceptMstServiceImpl implements CustTypeOrderExceptMstService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustTypeOrderExceptMstDao.<br>
     */
    @Autowired
    private CustTypeOrderExceptMstDao custTypeOrderExceptMstDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public CustTypeOrderExceptMstServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set TopCustTypeMstDao.<br>
     * [JP] <br>
     * 
     * @param topCustTypeMstDao 'TopCustTypeMstDao' class
     */
    public void setCustTypeOrderExceptMstDao(CustTypeOrderExceptMstDao custTypeOrderExceptMstDao) {
        this.custTypeOrderExceptMstDao = custTypeOrderExceptMstDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustTypeOrderExceptMstService#searchByKey(CustTypeOrderExceptMstDomain)
     */
    public CustTypeOrderExceptMstDomain searchByKey(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
        return custTypeOrderExceptMstDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustTypeOrderExceptMstService#searchByCondition(CustTypeOrderExceptMstDomain)
     */
    public List<CustTypeOrderExceptMstDomain> searchByCondition(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
        return custTypeOrderExceptMstDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustTypeOrderExceptMstService#searchByConditionForPaging(CustTypeOrderExceptMstDomain)
     */
    public List<CustTypeOrderExceptMstDomain> searchByConditionForPaging(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
        return custTypeOrderExceptMstDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustTypeOrderExceptMstService#searchCount(CustTypeOrderExceptMstDomain)
     */
    public int searchCount(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
        return custTypeOrderExceptMstDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustTypeOrderExceptMstService#searchCount2(CustTypeOrderExceptMstDomain)
     */
    public int searchCount2(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
        return custTypeOrderExceptMstDao.searchCount2(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustTypeOrderExceptMstService#searchCountSVM101(CustTypeOrderExceptMstDomain)
     */
    public int searchCountSVM101(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
        return custTypeOrderExceptMstDao.searchCountSVM101(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustTypeOrderExceptMstService#create(CustTypeOrderExceptMstDomain)
     */
    public void create(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
        try {
        	custTypeOrderExceptMstDao.create(domain);
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
     * @see com.globaldenso.dnkr.business.service.CustTypeOrderExceptMstService#update(CustTypeOrderExceptMstDomain)
     */
    public int update(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
    	return custTypeOrderExceptMstDao.update(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustTypeOrderExceptMstService#delete(CustTypeOrderExceptMstDomain)
     */
    public int delete(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
    	return custTypeOrderExceptMstDao.delete(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustTypeOrderExceptMstService#delete(List)
     */
    public int delete(List<CustTypeOrderExceptMstDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (CustTypeOrderExceptMstDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }
}
