package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.BkmkDomain;
import com.globaldenso.dnkr.integration.dao.BkmkDao;

/**
 * [KR] 코드관리 서비스 구현 <br>
 * [EN] Service implementation of code information.
 * [JP] 
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("bkmkService")
public class BkmkServiceImpl implements BkmkService {

    /**
     * [KR] 코드관리 Dao <br>
     * [EN] A field of CommonCodeDao.<br>
     * [JP] CommonCodeDaoのフィールド。<br>
     */
    @Autowired
    private BkmkDao bkmkDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public BkmkServiceImpl() {
        // no process
    }
    
    /**
     * [KO] 공통코드 Dao 의 setter 메소드
     * [EN] Set DAO of Common code information.<br>
     * [JP] 。<br>
     *
     * @param commonCodeDao 'CommonCodeDao' class 
     */
    public void setBkmkDao(BkmkDao commonCodeDao) {
        this.bkmkDao = commonCodeDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#searchByKey(BkmkDomain)
     */
    @Override
    public BkmkDomain searchByKey(BkmkDomain domain) throws ApplicationException {
        return bkmkDao.searchByKey(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#searchByCondition(BkmkDomain)
     */
    @Override
    public List<BkmkDomain> searchByCondition(BkmkDomain domain) throws ApplicationException {
        return bkmkDao.searchByCondition(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#searchCount(BkmkDomain)
     */
    @Override
    public int bkmkCount(BkmkDomain domain) throws ApplicationException {
        return bkmkDao.bkmkCount(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#searchCount(BkmkDomain)
     */
    @Override
    public int searchCount(BkmkDomain domain) throws ApplicationException {
        return bkmkDao.searchCount(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#create(BkmkDomain)
     */
    public void create(BkmkDomain domain) throws ApplicationException {
        try {
            bkmkDao.create(domain);
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
     * @see com.globaldenso.dnkr.business.service.CodeService#updateCmc(BkmkDomain)
     */
    public int update(BkmkDomain domain) throws ApplicationException {
        return bkmkDao.update(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#delete(BkmkDomain)
     */
    public int delete(BkmkDomain domain) throws ApplicationException {
        
        return bkmkDao.delete(domain);
    }
    
}
