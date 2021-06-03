package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.PrdPrfByItmNmbDomain;
import com.globaldenso.dnkr.integration.dao.PrdPrfByItmNmbDao;

/**
 * [KR] 생산성지표 기준정보(공정관리) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("prdPrfByItmNmbService")
public class PrdPrfByItmNmbServiceImpl implements PrdPrfByItmNmbService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private PrdPrfByItmNmbDao prdPrfByItmNmbDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PrdPrfByItmNmbServiceImpl() {
        // no process
    }

	@Override
	public List<PrdPrfByItmNmbDomain> searchByCondition(PrdPrfByItmNmbDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
        try {		
        	List<PrdPrfByItmNmbDomain> list = prdPrfByItmNmbDao.searchByCondition(domain);
        	return list;
        } catch (ApplicationException e) {		
        	e.printStackTrace();
        	 throw e;
        }
	}

	@Override
	public List<PrdPrfByItmNmbDomain> searchByConditionForPaging(PrdPrfByItmNmbDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return prdPrfByItmNmbDao.searchByConditionForPaging(domain);
	}
	
	@Override
	public int searchCount(PrdPrfByItmNmbDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prdPrfByItmNmbDao.searchCount(domain);
	}
	
	@Override
	public int searchCount2(PrdPrfByItmNmbDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prdPrfByItmNmbDao.searchCount2(domain);
	}
	
	@Override
	public int searchCount3(PrdPrfByItmNmbDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prdPrfByItmNmbDao.searchCount3(domain);
	}	

	@Override
	public void create(PrdPrfByItmNmbDomain domain) throws ApplicationException {
        try {
        	prdPrfByItmNmbDao.create(domain);
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
	public int update(PrdPrfByItmNmbDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return prdPrfByItmNmbDao.update(domain);
	}

	@Override
	public int delete(PrdPrfByItmNmbDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return prdPrfByItmNmbDao.delete(domain);
	}

	@Override
	public int delete(List<PrdPrfByItmNmbDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (PrdPrfByItmNmbDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

}
