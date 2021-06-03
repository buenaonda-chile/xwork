package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.CustPartConstMstDomain;
import com.globaldenso.dnkr.integration.dao.CustPartConstMstDao;

/**
* [KR] 업체부품구성마스타 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("custPartConstMstService")
public class CustPartConstMstServiceImpl implements CustPartConstMstService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustPartConstMstDao.<br>
     */
    @Autowired
    private CustPartConstMstDao custPartConstMstDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public CustPartConstMstServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set CustPartConstMstDao.<br>
     * [JP] <br>
     * 
     * @param custPartConstMstDao 'CustPartConstMstDao' class
     */
    public void setCustPartConstMstDao(CustPartConstMstDao custPartConstMstDao) {
        this.custPartConstMstDao = custPartConstMstDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstService#searchByKey(CustPartConstMstDomain)
     */
    public CustPartConstMstDomain searchByKey(CustPartConstMstDomain domain) throws ApplicationException {
        return custPartConstMstDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstService#searchByCondition(CustPartConstMstDomain)
     */
    public List<CustPartConstMstDomain> searchByCondition(CustPartConstMstDomain domain) throws ApplicationException {
        return custPartConstMstDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstService#searchByCondition2(CustPartConstMstDomain)
     */
    public List<CustPartConstMstDomain> searchByCondition2(CustPartConstMstDomain domain) throws ApplicationException {
        return custPartConstMstDao.searchByCondition2(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstService#searchByConditionForPaging(CustPartConstMstDomain)
     */
    public List<CustPartConstMstDomain> searchByConditionForPaging(CustPartConstMstDomain domain) throws ApplicationException {
        return custPartConstMstDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstService#searchCountEM000PR(CustPartConstMstDomain)
     */
    public int searchCountEM000PR(CustPartConstMstDomain domain) throws ApplicationException {
        return custPartConstMstDao.searchCountEM000PR(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstService#searchCount(CustPartConstMstDomain)
     */
    public int searchCount(CustPartConstMstDomain domain) throws ApplicationException {
        return custPartConstMstDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstService#searchCount2(CustPartConstMstDomain)
     */
    public int searchCount2(CustPartConstMstDomain domain) throws ApplicationException {
        return custPartConstMstDao.searchCount2(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstService#create(CustPartConstMstDomain)
     */
    public void create(CustPartConstMstDomain domain) throws ApplicationException {
        try {
        	custPartConstMstDao.create(domain);
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
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstService#update(CustPartConstMstDomain)
     */
    public int update(CustPartConstMstDomain domain) throws ApplicationException {
    	return custPartConstMstDao.update(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstService#delete(CustPartConstMstDomain)
     */
    public int delete(CustPartConstMstDomain domain) throws ApplicationException {
    	return custPartConstMstDao.delete(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstService#delete(List)
     */
    public int delete(List<CustPartConstMstDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (CustPartConstMstDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }
}
