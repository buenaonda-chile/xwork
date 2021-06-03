package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.ProdctIndctBaseLineDomain;
import com.globaldenso.dnkr.integration.dao.ProdctIndctBaseLineDao;

/**
 * [KR] 생산성지표 기준정보(라인정보) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("prodctIndctBaseLineService")
public class ProdctIndctBaseLineServiceImpl implements ProdctIndctBaseLineService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private ProdctIndctBaseLineDao prodctIndctBaseLineDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public ProdctIndctBaseLineServiceImpl() {
        // no process
    }

	@Override
	public List<ProdctIndctBaseLineDomain> searchByCondition(ProdctIndctBaseLineDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<ProdctIndctBaseLineDomain> list = prodctIndctBaseLineDao.searchByCondition(domain);
		return list;
	}

	@Override
	public List<ProdctIndctBaseLineDomain> searchByConditionForPaging(ProdctIndctBaseLineDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return prodctIndctBaseLineDao.searchByConditionForPaging(domain);
	}

	@Override
	public int searchCount(ProdctIndctBaseLineDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prodctIndctBaseLineDao.searchCount(domain);
	}
	
	@Override
	public int searchCount2(ProdctIndctBaseLineDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prodctIndctBaseLineDao.searchCount2(domain);
	}	
	
	@Override
	public int searchCount3(ProdctIndctBaseLineDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prodctIndctBaseLineDao.searchCount3(domain);
	}		

	@Override
	public void create(ProdctIndctBaseLineDomain domain) throws ApplicationException {
        try {
        	prodctIndctBaseLineDao.create(domain);
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
	public int update(ProdctIndctBaseLineDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return prodctIndctBaseLineDao.update(domain);
	}

	@Override
	public int delete(ProdctIndctBaseLineDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return prodctIndctBaseLineDao.delete(domain);
	}

	@Override
	public int delete(List<ProdctIndctBaseLineDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (ProdctIndctBaseLineDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

}
