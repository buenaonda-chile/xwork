package com.globaldenso.dnkr.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.NonOrderHostUpDomain;
import com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao;

/**
* [KR] 비서열형 HOST UP 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("nonOrderHostUpService")
public class NonOrderHostUpServiceImpl implements NonOrderHostUpService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of NonOrderHostUpDao.<br>
     */
    @Autowired
    private NonOrderHostUpDao nonOrderHostUpDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public NonOrderHostUpServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set NonOrderHostUpDao.<br>
     * [JP] <br>
     * 
     * @param HostUpDao 'NonOrderHostUpDao' class
     */
    public void setNonOrderHostUpDao(NonOrderHostUpDao nonOrderHostUpDao) {
        this.nonOrderHostUpDao = nonOrderHostUpDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#selectSVM020PF(NonOrderHostUpDomain)
     */
    public NonOrderHostUpDomain selectSVM020PF(NonOrderHostUpDomain domain) throws ApplicationException {
        return nonOrderHostUpDao.selectSVM020PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#selectEM000PR(NonOrderHostUpDomain)
     */
    public NonOrderHostUpDomain selectEM000PR(NonOrderHostUpDomain domain) throws ApplicationException {
        return nonOrderHostUpDao.selectEM000PR(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#countMST100PF(NonOrderHostUpDomain)
     */
    public int countMST100PF(NonOrderHostUpDomain domain) throws ApplicationException {
        return nonOrderHostUpDao.countMST100PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#countSVZ60PF(NonOrderHostUpDomain)
     */
    public int countSVZ60PF(NonOrderHostUpDomain domain) throws ApplicationException {
        return nonOrderHostUpDao.countSVZ60PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#deleteSVZ60PF(NonOrderHostUpDomain)
     */
    public int deleteSVZ60PF(NonOrderHostUpDomain domain) throws ApplicationException {
    	return nonOrderHostUpDao.deleteSVZ60PF(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#selectPERIOD(NonOrderHostUpDomain)
     */
    public NonOrderHostUpDomain selectPERIOD(NonOrderHostUpDomain domain) throws ApplicationException {
        return nonOrderHostUpDao.selectPERIOD(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#createSVZ60PF(NonOrderHostUpDomain)
     */
    public void createSVZ60PF(NonOrderHostUpDomain domain) throws ApplicationException {
        try {
        	nonOrderHostUpDao.createSVZ60PF(domain);
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
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#updateSVZ602PF(NonOrderHostUpDomain)
     */
    public int updateSVZ602PF(NonOrderHostUpDomain domain) throws ApplicationException {
    	return nonOrderHostUpDao.updateSVZ602PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#countSVZ600PF(NonOrderHostUpDomain)
     */
    public int countSVZ600PF(NonOrderHostUpDomain domain) throws ApplicationException {
        return nonOrderHostUpDao.countSVZ600PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#deleteSVZ600PF(NonOrderHostUpDomain)
     */
    public int deleteSVZ600PF(NonOrderHostUpDomain domain) throws ApplicationException {
    	return nonOrderHostUpDao.deleteSVZ600PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#createSVZ600PF(NonOrderHostUpDomain)
     */
    public void createSVZ600PF(NonOrderHostUpDomain domain) throws ApplicationException {
        try {
        	nonOrderHostUpDao.createSVZ600PF(domain);
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
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#countSVZ603PF(NonOrderHostUpDomain)
     */
    public int countSVZ603PF(NonOrderHostUpDomain domain) throws ApplicationException {
        return nonOrderHostUpDao.countSVZ603PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#deleteSVZ603PF(NonOrderHostUpDomain)
     */
    public int deleteSVZ603PF(NonOrderHostUpDomain domain) throws ApplicationException {
    	return nonOrderHostUpDao.deleteSVZ603PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpService#createSVZ603PF(NonOrderHostUpDomain)
     */
    public void createSVZ603PF(NonOrderHostUpDomain domain) throws ApplicationException {
        try {
        	nonOrderHostUpDao.createSVZ603PF(domain);
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
}
