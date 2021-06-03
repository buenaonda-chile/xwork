package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.WrknTimeBaseDomain;
import com.globaldenso.dnkr.integration.dao.WrknTimeBaseDao;

/**
 * [KR] 생산성지표 기준정보(작업코드관리) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("wrknTimeBaseServiceImpl")
public class WrknTimeBaseServiceImpl implements WrknTimeBaseService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private WrknTimeBaseDao wrknTimeBaseDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WrknTimeBaseServiceImpl() {
        // no process
    }

	@Override
	public List<WrknTimeBaseDomain> searchByCondition(WrknTimeBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<WrknTimeBaseDomain> list = wrknTimeBaseDao.searchByCondition(domain);
		return list;
	}

	@Override
	public List<WrknTimeBaseDomain> searchByConditionForPaging(WrknTimeBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return wrknTimeBaseDao.searchByConditionForPaging(domain);
	}

	@Override
	public int searchCount(WrknTimeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return wrknTimeBaseDao.searchCount(domain);
	}

	@Override
	public int searchCount2(WrknTimeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return wrknTimeBaseDao.searchCount2(domain);
	}
	
	@Override
	public int searchCount3(WrknTimeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return wrknTimeBaseDao.searchCount3(domain);
	}
	
	@Override
	public int searchCount4(WrknTimeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return wrknTimeBaseDao.searchCount4(domain);
	}	
	
	@Override
	public int searchCount5(WrknTimeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return wrknTimeBaseDao.searchCount5(domain);
	}
	
	@Override
	public int searchCount6(WrknTimeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return wrknTimeBaseDao.searchCount6(domain);
	}	
	
	@Override
	public void create(WrknTimeBaseDomain domain) throws ApplicationException {
        try {
        	wrknTimeBaseDao.create(domain);
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
	public int update(WrknTimeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return wrknTimeBaseDao.update(domain);
	}

	@Override
	public int delete(WrknTimeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return wrknTimeBaseDao.delete(domain);
	}

	@Override
	public int delete(List<WrknTimeBaseDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (WrknTimeBaseDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

}
