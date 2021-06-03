package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.SalPlnPerfmncWkReprtExlDomain;
import com.globaldenso.dnkr.integration.dao.SalPlnPerfmncWkReprtExlDao;

/**
* [KR]  <br>
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Service("salPlnPerfmncWkReprtExlService")
public class SalPlnPerfmncWkReprtExlServiceImpl implements SalPlnPerfmncWkReprtExlService {
	
	/**
     * [KR] Dao 필드<br>
     * [EN] A field of SalPlnPerfmncWkReprtExlDao.<br>
     */
    @Autowired
    private SalPlnPerfmncWkReprtExlDao salPlnPerfmncWkReprtExlDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public SalPlnPerfmncWkReprtExlServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set SalPlnPerfmncWkReprtExlDao.<br>
     * [JP] <br>
     * 
     */
    public void setSalPlnPerfmncWkReprtExlDao(SalPlnPerfmncWkReprtExlDao salPlnPerfmncWkReprtExlDao) {
        this.salPlnPerfmncWkReprtExlDao = salPlnPerfmncWkReprtExlDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SalPlnPerfmncWkReprtExlService#searchByCondition(SalPlnPerfmncWkReprtExlDomain)
     */
    public List<SalPlnPerfmncWkReprtExlDomain> searchByMaker(SalPlnPerfmncWkReprtExlDomain domain) throws ApplicationException {
        return salPlnPerfmncWkReprtExlDao.searchByMaker(domain);
    }
	
}
