package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.CustOrderTypeMstDomain;
import com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao;

/**
* [KR] 중복차종서열코드마스타 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("custOrderTypeMstService")
public class CustOrderTypeMstServiceImpl implements CustOrderTypeMstService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private CustOrderTypeMstDao custOrderTypeMstDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public CustOrderTypeMstServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set CustOrderTypeMstDao.<br>
     * [JP] <br>
     * 
     * @param custOrderTypeMstDao 'CustOrderTypeMstDao' class
     */
    public void setCustOrderTypeMstDao(CustOrderTypeMstDao custOrderTypeMstDao) {
        this.custOrderTypeMstDao = custOrderTypeMstDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstService#searchByKey(CustOrderTypeMstDomain)
     */
    public CustOrderTypeMstDomain searchByKey(CustOrderTypeMstDomain domain) throws ApplicationException {
        return custOrderTypeMstDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstService#searchByCondition(CustOrderTypeMstDomain)
     */
    public List<CustOrderTypeMstDomain> searchByCondition(CustOrderTypeMstDomain domain) throws ApplicationException {
        return custOrderTypeMstDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstService#searchByConditionForPaging(CustOrderTypeMstDomain)
     */
    public List<CustOrderTypeMstDomain> searchByConditionForPaging(CustOrderTypeMstDomain domain) throws ApplicationException {
        return custOrderTypeMstDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstService#searchCount(CustOrderTypeMstDomain)
     */
    public int searchCount(CustOrderTypeMstDomain domain) throws ApplicationException {
        return custOrderTypeMstDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstService#searchCount2(CustOrderTypeMstDomain)
     */
    public int searchCount2(CustOrderTypeMstDomain domain) throws ApplicationException {
        return custOrderTypeMstDao.searchCount2(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstService#searchCheck(CustOrderTypeMstDomain)
     */
    public int searchCheck(CustOrderTypeMstDomain domain) throws ApplicationException {
        return custOrderTypeMstDao.searchCheck(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstService#searchCheck2(CustOrderTypeMstDomain)
     */
    public int searchCheck2(CustOrderTypeMstDomain domain) throws ApplicationException {
        return custOrderTypeMstDao.searchCheck2(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstService#searchCheck3(CustOrderTypeMstDomain)
     */
    public int searchCheck3(CustOrderTypeMstDomain domain) throws ApplicationException {
        return custOrderTypeMstDao.searchCheck3(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstService#create(CustOrderTypeMstDomain)
     */
    public void createSVM200(CustOrderTypeMstDomain domain) throws ApplicationException {
        try {
        	custOrderTypeMstDao.createSVM200(domain);
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
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstService#create(CustOrderTypeMstDomain)
     */
    public void create(CustOrderTypeMstDomain domain) throws ApplicationException {
        try {
        	custOrderTypeMstDao.create(domain);
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
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstService#update(CustOrderTypeMstDomain)
     */
    public int update(CustOrderTypeMstDomain domain) throws ApplicationException {
    	return custOrderTypeMstDao.update(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstService#delete(CustOrderTypeMstDomain)
     */
    public int delete(CustOrderTypeMstDomain domain) throws ApplicationException {
    	return custOrderTypeMstDao.delete(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstService#delete(List)
     */
    public int delete(List<CustOrderTypeMstDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (CustOrderTypeMstDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }
}
