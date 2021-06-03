package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.WrkrInfoBaseDomain;
import com.globaldenso.dnkr.integration.dao.WrkrInfoBaseDao;

/**
 * [KR] 생산성지표 기준정보(작업자정보관리) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("wrkrInfoBaseService")
public class WrkrInfoBaseServiceImpl implements WrkrInfoBaseService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private WrkrInfoBaseDao wrkrInfoBaseDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WrkrInfoBaseServiceImpl() {
        // no process
    }

	@Override
	public List<WrkrInfoBaseDomain> searchByCondition(WrkrInfoBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<WrkrInfoBaseDomain> list = wrkrInfoBaseDao.searchByCondition(domain);
		return list;
	}

	@Override
	public List<WrkrInfoBaseDomain> searchByConditionForPaging(WrkrInfoBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return wrkrInfoBaseDao.searchByConditionForPaging(domain);
	}

	@Override
	public int searchCount(WrkrInfoBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
        try {		
		 return wrkrInfoBaseDao.searchCount(domain);
        } catch (ApplicationException e) {
        	e.printStackTrace();
        	 throw e;
        }		 
	}
	
	@Override
	public int searchCount2(WrkrInfoBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
        try {		
		 return wrkrInfoBaseDao.searchCount2(domain);
        } catch (ApplicationException e) {
        	e.printStackTrace();
        	 throw e;
        }		 
	}	

	@Override
	public void create(WrkrInfoBaseDomain domain) throws ApplicationException {
        try {
        	wrkrInfoBaseDao.create(domain);
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
	public int update(WrkrInfoBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return wrkrInfoBaseDao.update(domain);
	}

	@Override
	public int delete(WrkrInfoBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return wrkrInfoBaseDao.delete(domain);
	}

	@Override
	public int delete(List<WrkrInfoBaseDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (WrkrInfoBaseDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

}
