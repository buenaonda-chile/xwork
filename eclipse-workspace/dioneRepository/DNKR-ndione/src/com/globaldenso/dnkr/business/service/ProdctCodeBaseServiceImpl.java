package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.ProdctCodeBaseDomain;
import com.globaldenso.dnkr.integration.dao.ProdctCodeBaseDao;

/**
 * [KR] 생산성지표 기준정보(제품코드관리) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("prodctCodeBaseService")
public class ProdctCodeBaseServiceImpl implements ProdctCodeBaseService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private ProdctCodeBaseDao prodctCodeBaseDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public ProdctCodeBaseServiceImpl() {
        // no process
    }

	@Override
	public List<ProdctCodeBaseDomain> searchByCondition(ProdctCodeBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<ProdctCodeBaseDomain> list = prodctCodeBaseDao.searchByCondition(domain);
		return list;
	}

	@Override
	public List<ProdctCodeBaseDomain> searchByConditionForPaging(ProdctCodeBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return prodctCodeBaseDao.searchByConditionForPaging(domain);
	}

	@Override
	public int searchCount(ProdctCodeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prodctCodeBaseDao.searchCount(domain);
	}
	
	@Override
	public int searchCount2(ProdctCodeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prodctCodeBaseDao.searchCount2(domain);
	}	

	@Override
	public int searchCount3(ProdctCodeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prodctCodeBaseDao.searchCount3(domain);
	}	
	
	@Override
	public int searchCount4(ProdctCodeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prodctCodeBaseDao.searchCount4(domain);
	}
	
	@Override
	public int searchCount5(ProdctCodeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prodctCodeBaseDao.searchCount5(domain);
	}	
	
	@Override
	public int searchCount6(ProdctCodeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return prodctCodeBaseDao.searchCount6(domain);
	}		
	
	@Override
	public void create(ProdctCodeBaseDomain domain) throws ApplicationException {
        try {
        	prodctCodeBaseDao.create(domain);
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
	public int update(ProdctCodeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return prodctCodeBaseDao.update(domain);
	}

	@Override
	public int delete(ProdctCodeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return prodctCodeBaseDao.delete(domain);
	}

	@Override
	public int delete(List<ProdctCodeBaseDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (ProdctCodeBaseDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

}
