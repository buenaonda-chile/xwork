package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.KiaHyundaiVANCompanyCodeMstDomain;
import com.globaldenso.dnkr.integration.dao.KiaHyundaiVANCompanyCodeMstDao;

/**
* [KR] 기아현대 VAN 업체코드마스타 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("kiaHyundaiVANCompanyCodeMstService")
public class KiaHyundaiVANCompanyCodeMstServiceImpl implements KiaHyundaiVANCompanyCodeMstService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of KiaHyundaiVANCompanyCodeMstDao.<br>
     */
    @Autowired
    private KiaHyundaiVANCompanyCodeMstDao kiaHyundaiVANCompanyCodeMstDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public KiaHyundaiVANCompanyCodeMstServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set KiaHyundaiVANCompanyCodeMstDao.<br>
     * [JP] <br>
     * 
     * @param kiaHyundaiVANCompanyCodeMstDao 'KiaHyundaiVANCompanyCodeMstDao' class
     */
    public void setKiaHyundaiVANCompanyCodeMstDao(KiaHyundaiVANCompanyCodeMstDao kiaHyundaiVANCompanyCodeMstDao) {
        this.kiaHyundaiVANCompanyCodeMstDao = kiaHyundaiVANCompanyCodeMstDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.KiaHyundaiVANCompanyCodeMstService#searchByCondition(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public List<KiaHyundaiVANCompanyCodeMstDomain> searchByCondition(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
        return kiaHyundaiVANCompanyCodeMstDao.searchByCondition(domain);
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.KiaHyundaiVANCompanyCodeMstService#searchCount(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public int searchCount(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
        return kiaHyundaiVANCompanyCodeMstDao.searchCount(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.KiaHyundaiVANCompanyCodeMstService#create(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public void create(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
        try {
        	kiaHyundaiVANCompanyCodeMstDao.create(domain);
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
     * @see com.globaldenso.dnkr.business.service.KiaHyundaiVANCompanyCodeMstService#update(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public int update(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
    	return kiaHyundaiVANCompanyCodeMstDao.update(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.KiaHyundaiVANCompanyCodeMstService#delete(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public int delete(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
    	return kiaHyundaiVANCompanyCodeMstDao.delete(domain);
    }

    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.KiaHyundaiVANCompanyCodeMstService#searchByCondition(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public List<KiaHyundaiVANCompanyCodeMstDomain> searchByCondition030(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
        return kiaHyundaiVANCompanyCodeMstDao.searchByCondition030(domain);
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.KiaHyundaiVANCompanyCodeMstService#searchCount(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public int searchCount030(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
        return kiaHyundaiVANCompanyCodeMstDao.searchCount030(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.KiaHyundaiVANCompanyCodeMstService#create(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public void create030(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
        try {
        	kiaHyundaiVANCompanyCodeMstDao.create030(domain);
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
     * @see com.globaldenso.dnkr.business.service.KiaHyundaiVANCompanyCodeMstService#update(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public int update030(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
    	return kiaHyundaiVANCompanyCodeMstDao.update030(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.KiaHyundaiVANCompanyCodeMstService#delete(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public int delete030(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
    	return kiaHyundaiVANCompanyCodeMstDao.delete030(domain);
    }

}
