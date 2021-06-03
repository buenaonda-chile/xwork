package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.DuplTypeOrderCodeMstDomain;
import com.globaldenso.dnkr.integration.dao.DuplTypeOrderCodeMstDao;

/**
* [KR] 중복차종서열코드마스타 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("duplTypeOrderCodeMstService")
public class DuplTypeOrderCodeMstServiceImpl implements DuplTypeOrderCodeMstService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of DuplTypeOrderCodeMstDao.<br>
     */
    @Autowired
    private DuplTypeOrderCodeMstDao duplTypeOrderCodeMstDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public DuplTypeOrderCodeMstServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set DuplTypeOrderCodeMstDao.<br>
     * [JP] <br>
     * 
     * @param duplTypeOrderCodeMstDao 'DuplTypeOrderCodeMstDao' class
     */
    public void setDuplTypeOrderCodeMstDao(DuplTypeOrderCodeMstDao duplTypeOrderCodeMstDao) {
        this.duplTypeOrderCodeMstDao = duplTypeOrderCodeMstDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.DuplTypeOrderCodeMstService#searchByKey(DuplTypeOrderCodeMstDomain)
     */
    public DuplTypeOrderCodeMstDomain searchByKey(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
        return duplTypeOrderCodeMstDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.DuplTypeOrderCodeMstService#searchByCondition(DuplTypeOrderCodeMstDomain)
     */
    public List<DuplTypeOrderCodeMstDomain> searchByCondition(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
        return duplTypeOrderCodeMstDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.DuplTypeOrderCodeMstService#searchByConditionForPaging(DuplTypeOrderCodeMstDomain)
     */
    public List<DuplTypeOrderCodeMstDomain> searchByConditionForPaging(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
        return duplTypeOrderCodeMstDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.DuplTypeOrderCodeMstService#searchCount(DuplTypeOrderCodeMstDomain)
     */
    public int searchCount(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
        return duplTypeOrderCodeMstDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.DuplTypeOrderCodeMstService#searchCount2(DuplTypeOrderCodeMstDomain)
     */
    public int searchCount2(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
        return duplTypeOrderCodeMstDao.searchCount2(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.DuplTypeOrderCodeMstService#searchCountSVM100(DuplTypeOrderCodeMstDomain)
     */
    public int searchCountSVM100(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
        return duplTypeOrderCodeMstDao.searchCountSVM100(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.DuplTypeOrderCodeMstService#create(DuplTypeOrderCodeMstDomain)
     */
    public void create(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
        try {
        	duplTypeOrderCodeMstDao.create(domain);
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
     * @see com.globaldenso.dnkr.business.service.DuplTypeOrderCodeMstService#update(DuplTypeOrderCodeMstDomain)
     */
    public int update(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
    	return duplTypeOrderCodeMstDao.update(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.DuplTypeOrderCodeMstService#delete(DuplTypeOrderCodeMstDomain)
     */
    public int delete(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
    	return duplTypeOrderCodeMstDao.delete(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.DuplTypeOrderCodeMstService#delete(List)
     */
    public int delete(List<DuplTypeOrderCodeMstDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (DuplTypeOrderCodeMstDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }
}
