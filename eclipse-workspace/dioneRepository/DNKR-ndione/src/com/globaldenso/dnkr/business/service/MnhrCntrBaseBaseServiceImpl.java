package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.MnhrCntrBaseBaseDomain;
import com.globaldenso.dnkr.integration.dao.MnhrCntrBaseBaseDao;

/**
 * [KR] 생산성지표 기준정보(공정관리) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("mnhrCntrBaseBaseService")
public class MnhrCntrBaseBaseServiceImpl implements MnhrCntrBaseBaseService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private MnhrCntrBaseBaseDao mnhrCntrBaseBaseDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public MnhrCntrBaseBaseServiceImpl() {
        // no process
    }

	@Override
	public List<MnhrCntrBaseBaseDomain> searchByCondition(MnhrCntrBaseBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
        try {		
        	List<MnhrCntrBaseBaseDomain> list = mnhrCntrBaseBaseDao.searchByCondition(domain);
        	return list;
        } catch (ApplicationException e) {		
        	e.printStackTrace();
        	 throw e;
        }
	}

	@Override
	public List<MnhrCntrBaseBaseDomain> searchByConditionForPaging(MnhrCntrBaseBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return mnhrCntrBaseBaseDao.searchByConditionForPaging(domain);
	}
	
	@Override
	public int searchCount(MnhrCntrBaseBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return mnhrCntrBaseBaseDao.searchCount(domain);
	}
	
	@Override
	public int searchCount2(MnhrCntrBaseBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return mnhrCntrBaseBaseDao.searchCount2(domain);
	}
	
	@Override
	public int searchCount3(MnhrCntrBaseBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return mnhrCntrBaseBaseDao.searchCount3(domain);
	}	

	@Override
	public void create(MnhrCntrBaseBaseDomain domain) throws ApplicationException {
        try {
        	mnhrCntrBaseBaseDao.create(domain);
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
	public int update(MnhrCntrBaseBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return mnhrCntrBaseBaseDao.update(domain);
	}

	@Override
	public int delete(MnhrCntrBaseBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return mnhrCntrBaseBaseDao.delete(domain);
	}

	@Override
	public int delete(List<MnhrCntrBaseBaseDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (MnhrCntrBaseBaseDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

}
