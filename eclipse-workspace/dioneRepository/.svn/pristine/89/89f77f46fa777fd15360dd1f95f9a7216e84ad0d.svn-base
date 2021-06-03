package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.PrdPrfrmRgsDomain;
import com.globaldenso.dnkr.integration.dao.PrdPrfrmRgsDao;

/**
 * [KR] 생산실적등록 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("prdPrfrmRgsMesService")
public class PrdPrfrmRgsMesServiceImpl implements PrdPrfrmRgsMesService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of PrdPrfrmRgsDao.<br>
     */
    @Autowired
    private PrdPrfrmRgsDao prdPrfrmRgsDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PrdPrfrmRgsMesServiceImpl() {
        // no process
    }

	@Override
	public List<PrdPrfrmRgsDomain> searchByCondition(PrdPrfrmRgsDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
        try {		
		List<PrdPrfrmRgsDomain> list = prdPrfrmRgsDao.searchByCondition(domain);
		return list;
        } catch (ApplicationException e) {		
        	e.printStackTrace();
        	throw e;
        }
		
	}

	@Override
	public List<PrdPrfrmRgsDomain> searchByConditionForPaging(PrdPrfrmRgsDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return prdPrfrmRgsDao.searchByConditionForPaging(domain);
	}

	@Override
	public int searchCount(PrdPrfrmRgsDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prdPrfrmRgsDao.searchCount(domain);
	}

	@Override
	public int searchCount2(PrdPrfrmRgsDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prdPrfrmRgsDao.searchCount2(domain);
	}
	
	@Override
	public void create(PrdPrfrmRgsDomain domain) throws ApplicationException {
        try {
        	prdPrfrmRgsDao.create(domain);
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
	public int update(PrdPrfrmRgsDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return prdPrfrmRgsDao.update(domain);
	}

	@Override
	public int delete(PrdPrfrmRgsDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return prdPrfrmRgsDao.delete(domain);
	}

	@Override
	public int delete(List<PrdPrfrmRgsDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (PrdPrfrmRgsDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

	@Override
	public int searchPrSnlSum(PrdPrfrmRgsDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prdPrfrmRgsDao.searchPrSnlSum(domain);
	}	
	
}
