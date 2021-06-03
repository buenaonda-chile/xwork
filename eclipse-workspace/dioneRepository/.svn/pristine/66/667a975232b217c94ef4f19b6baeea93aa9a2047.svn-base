package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.TopCustTypeMstDomain;
import com.globaldenso.dnkr.integration.dao.TopCustTypeMstDao;

/**
* [KR] 대표업체차종마스타 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("topCustTypeMstService")
public class TopCustTypeMstServiceImpl implements TopCustTypeMstService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of TopCustTypeMstDao.<br>
     */
    @Autowired
    private TopCustTypeMstDao topCustTypeMstDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public TopCustTypeMstServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set TopCustTypeMstDao.<br>
     * [JP] <br>
     * 
     * @param topCustTypeMstDao 'TopCustTypeMstDao' class
     */
    public void setTopCustTypeMstDao(TopCustTypeMstDao topCustTypeMstDao) {
        this.topCustTypeMstDao = topCustTypeMstDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.TopCustTypeMstService#searchByKey(TopCustTypeMstDomain)
     */
    public TopCustTypeMstDomain searchByKey(TopCustTypeMstDomain domain) throws ApplicationException {
        return topCustTypeMstDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.TopCustTypeMstService#searchByCondition(TopCustTypeMstDomain)
     */
    public List<TopCustTypeMstDomain> searchByCondition(TopCustTypeMstDomain domain) throws ApplicationException {
        return topCustTypeMstDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.TopCustTypeMstService#searchByConditionForPaging(TopCustTypeMstDomain)
     */
    public List<TopCustTypeMstDomain> searchByConditionForPaging(TopCustTypeMstDomain domain) throws ApplicationException {
        return topCustTypeMstDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.TopCustTypeMstService#searchCount(TopCustTypeMstDomain)
     */
    public int searchCount(TopCustTypeMstDomain domain) throws ApplicationException {
        return topCustTypeMstDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.TopCustTypeMstService#searchCount2(TopCustTypeMstDomain)
     */
    public int searchCount2(TopCustTypeMstDomain domain) throws ApplicationException {
        return topCustTypeMstDao.searchCount2(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.TopCustTypeMstService#searchCountCUSNO(TopCustTypeMstDomain)
     */
    public int searchCountCUSNO(TopCustTypeMstDomain domain) throws ApplicationException {
        return topCustTypeMstDao.searchCountCUSNO(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.TopCustTypeMstService#searchCountMST050(TopCustTypeMstDomain)
     */
    public TopCustTypeMstDomain searchCountMST050(TopCustTypeMstDomain domain) throws ApplicationException {
        return topCustTypeMstDao.searchCountMST050(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.TopCustTypeMstService#create(TopCustTypeMstDomain)
     */
    public void create(TopCustTypeMstDomain domain) throws ApplicationException {
        try {
        	topCustTypeMstDao.create(domain);
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
     * @see com.globaldenso.dnkr.business.service.TopCustTypeMstService#update(TopCustTypeMstDomain)
     */
    public int update(TopCustTypeMstDomain domain) throws ApplicationException {
    	return topCustTypeMstDao.update(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.TopCustTypeMstService#delete(TopCustTypeMstDomain)
     */
    public int delete(TopCustTypeMstDomain domain) throws ApplicationException {
    	return topCustTypeMstDao.delete(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.TopCustTypeMstService#delete(List)
     */
    public int delete(List<TopCustTypeMstDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (TopCustTypeMstDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }
}
