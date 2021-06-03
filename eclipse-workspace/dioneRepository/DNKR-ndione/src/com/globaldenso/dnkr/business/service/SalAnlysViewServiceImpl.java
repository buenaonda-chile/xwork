package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.SalAnlysComentDomain;
import com.globaldenso.dnkr.domain.SalAnlysViewDomain;
import com.globaldenso.dnkr.integration.dao.SalAnlysViewDao;

/**
* [KR]  <br>
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Service("salAnlysViewService")
public class SalAnlysViewServiceImpl implements SalAnlysViewService {
	
	/**
     * [KR] Dao 필드<br>
     * [EN] A field of SalAnlysViewDao.<br>
     */
    @Autowired
    private SalAnlysViewDao salAnlysViewDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public SalAnlysViewServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set SalAnlysViewDao.<br>
     * [JP] <br>
     * 
     */
    public void setSalAnlysViewDao(SalAnlysViewDao salAnlysViewDao) {
        this.salAnlysViewDao = salAnlysViewDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SalAnlysViewService#searchByKey(SalAnlysViewDomain)
     */
    public SalAnlysViewDomain searchByKey(SalAnlysViewDomain domain) throws ApplicationException {
        return salAnlysViewDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SalAnlysViewService#searchByCondition(SalAnlysViewDomain)
     */
    public List<SalAnlysViewDomain> searchByCondition(SalAnlysViewDomain domain) throws ApplicationException {
        return salAnlysViewDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SalAnlysViewService#searchByConditionForPaging(SalAnlysViewDomain)
     */
    public List<SalAnlysViewDomain> searchByConditionForPaging(SalAnlysViewDomain domain) throws ApplicationException {
        return salAnlysViewDao.searchByConditionForPaging(domain);
    }
    
    
	
}
