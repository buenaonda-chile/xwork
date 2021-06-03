package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.SalPlnPerfmncMtReprtExlDomain;
import com.globaldenso.dnkr.integration.dao.SalPlnPerfmncMtReprtExlDao;

/**
* [KR]  <br>
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Service("salPlnPerfmncMtReprtExlService")
public class SalPlnPerfmncMtReprtExlServiceImpl implements SalPlnPerfmncMtReprtExlService {
	
	/**
     * [KR] Dao 필드<br>
     * [EN] A field of SalPlnPerfmncMtReprtExlDao.<br>
     */
    @Autowired
    private SalPlnPerfmncMtReprtExlDao salPlnPerfmncMtReprtExlDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public SalPlnPerfmncMtReprtExlServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set SalPlnPerfmncMtReprtExlDao.<br>
     * [JP] <br>
     * 
     */
    public void setSalPlnPerfmncMtReprtExlDao(SalPlnPerfmncMtReprtExlDao salPlnPerfmncMtReprtExlDao) {
        this.salPlnPerfmncMtReprtExlDao = salPlnPerfmncMtReprtExlDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SalPlnPerfmncMtReprtExlService#searchByCondition(SalPlnPerfmncMtReprtExlDomain)
     */
    public List<SalPlnPerfmncMtReprtExlDomain> searchBySalPlnList(SalPlnPerfmncMtReprtExlDomain domain) throws ApplicationException {
        return salPlnPerfmncMtReprtExlDao.searchBySalPlnList(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SalPlnPerfmncMtReprtExlService#searchByCondition(SalPlnPerfmncMtReprtExlDomain)
     */
    public List<SalPlnPerfmncMtReprtExlDomain> searchByCondition(SalPlnPerfmncMtReprtExlDomain domain) throws ApplicationException {
        return salPlnPerfmncMtReprtExlDao.searchByCondition(domain);
    }
    
	
}
