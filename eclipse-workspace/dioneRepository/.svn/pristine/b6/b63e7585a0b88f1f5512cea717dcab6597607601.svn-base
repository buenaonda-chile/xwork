package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.PrdYrPlnCrtRgsDomain;
import com.globaldenso.dnkr.integration.dao.PrdYrPlnCrtRgsDao;

/**
 * [KR] 라인인원투입시간등록 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("PrdYrPlnCrtRgsService")
public class PrdYrPlnCrtRgsServiceImpl implements PrdYrPlnCrtRgsService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of LnPrsInpTmDao.<br>
     */
    @Autowired
    private PrdYrPlnCrtRgsDao prdYrPlnCrtRgsDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PrdYrPlnCrtRgsServiceImpl() {
        // no process
    }

	@Override
	public List<PrdYrPlnCrtRgsDomain> searchByCondition(PrdYrPlnCrtRgsDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
        try {		
		List<PrdYrPlnCrtRgsDomain> list = prdYrPlnCrtRgsDao.searchByCondition(domain);
		return list;
        } catch (ApplicationException e) {		
        	e.printStackTrace();
        	throw e;
        }
		
	}

	@Override
	public List<PrdYrPlnCrtRgsDomain> searchByConditionForPaging(PrdYrPlnCrtRgsDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return prdYrPlnCrtRgsDao.searchByConditionForPaging(domain);
	}

	@Override
	public int searchCount(PrdYrPlnCrtRgsDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prdYrPlnCrtRgsDao.searchCount(domain);
	}

	@Override
	public void create(PrdYrPlnCrtRgsDomain domain) throws ApplicationException {
        try {
        	prdYrPlnCrtRgsDao.create(domain);
        } catch (ApplicationException e) {
        	e.printStackTrace();
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.employee"));
            } else {
                throw e;
            }
        }
	}

	@Override
	public int update(PrdYrPlnCrtRgsDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return prdYrPlnCrtRgsDao.update(domain);
	}

	@Override
	public int delete(PrdYrPlnCrtRgsDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return prdYrPlnCrtRgsDao.delete(domain);
	}

	@Override
	public int delete(List<PrdYrPlnCrtRgsDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (PrdYrPlnCrtRgsDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

	@Override
	public int searchPrSnlSum(PrdYrPlnCrtRgsDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prdYrPlnCrtRgsDao.searchPrSnlSum(domain);
	}	
	
}
