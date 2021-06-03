package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.SalPlnPerfmncMtReprtPptDomain;
import com.globaldenso.dnkr.integration.dao.SalPlnPerfmncMtReprtPptDao;

/**
* [KR]  <br>
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Service("salPlnPerfmncMtReprtPptService")
public class SalPlnPerfmncMtReprtPptServiceImpl implements SalPlnPerfmncMtReprtPptService {
	
	/**
     * [KR] Dao 필드<br>
     * [EN] A field of SalPlnPerfmncMtReprtPptDao.<br>
     */
    @Autowired
    private SalPlnPerfmncMtReprtPptDao salPlnPerfmncMtReprtPptDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public SalPlnPerfmncMtReprtPptServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set SalPlnPerfmncMtReprtPptDao.<br>
     * [JP] <br>
     * 
     */
    public void setSalPlnPerfmncMtReprtPptDao(SalPlnPerfmncMtReprtPptDao salPlnPerfmncMtReprtPptDao) {
        this.salPlnPerfmncMtReprtPptDao = salPlnPerfmncMtReprtPptDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SalPlnPerfmncMtReprtPptService#searchByKey(SalPlnPerfmncMtReprtPptDomain)
     */
    public SalPlnPerfmncMtReprtPptDomain searchByKey(SalPlnPerfmncMtReprtPptDomain domain) throws ApplicationException {
        return salPlnPerfmncMtReprtPptDao.searchByKey(domain);
    }
    

    public List<SalPlnPerfmncMtReprtPptDomain> searchByMaker(SalPlnPerfmncMtReprtPptDomain domain) throws ApplicationException {
        return salPlnPerfmncMtReprtPptDao.searchByMaker(domain);
    }


	@Override
	public List<SalPlnPerfmncMtReprtPptDomain> searchByMakerComps(SalPlnPerfmncMtReprtPptDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return salPlnPerfmncMtReprtPptDao.searchByMakerComps(domain);
	}


	@Override
	public List<SalPlnPerfmncMtReprtPptDomain> searchByMakerCompsSum(SalPlnPerfmncMtReprtPptDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return salPlnPerfmncMtReprtPptDao.searchByMakerCompsSum(domain);
	}
    

    public List<SalPlnPerfmncMtReprtPptDomain> searchByITME(SalPlnPerfmncMtReprtPptDomain domain) throws ApplicationException {
        return salPlnPerfmncMtReprtPptDao.searchByITME(domain);
    }


	@Override
	public List<SalPlnPerfmncMtReprtPptDomain> searchByITMEComps(SalPlnPerfmncMtReprtPptDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return salPlnPerfmncMtReprtPptDao.searchByITMEComps(domain);
	}


	@Override
	public List<SalPlnPerfmncMtReprtPptDomain> searchByITMECompsSum(SalPlnPerfmncMtReprtPptDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return salPlnPerfmncMtReprtPptDao.searchByITMECompsSum(domain);
	} 
    
	
}
