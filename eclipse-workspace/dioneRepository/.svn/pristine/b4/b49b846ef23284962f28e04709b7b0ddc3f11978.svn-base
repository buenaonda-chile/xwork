package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.FinlCustTypeBaseDomain;
import com.globaldenso.dnkr.integration.dao.FinlCustTypeBaseDao;

/**
* [KR] 판매계획 기준정보 납입구분 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("finlCustTypeBaseService")
public class FinlCustTypeBaseServiceImpl implements FinlCustTypeBaseService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private FinlCustTypeBaseDao finlCustTypeBaseDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public FinlCustTypeBaseServiceImpl() {
        // no process
    }

	@Override
	public List<FinlCustTypeBaseDomain> searchByCondition(FinlCustTypeBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<FinlCustTypeBaseDomain> list = finlCustTypeBaseDao.searchByCondition(domain);
		return list;
	}

	@Override
	public List<FinlCustTypeBaseDomain> searchByConditionForPaging(FinlCustTypeBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return finlCustTypeBaseDao.searchByConditionForPaging(domain);
	}

	@Override
	public int searchCount(FinlCustTypeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return finlCustTypeBaseDao.searchCount(domain);
	}

	@Override
	public void create(FinlCustTypeBaseDomain domain) throws ApplicationException {
        try {
        	finlCustTypeBaseDao.create(domain);
        } catch (ApplicationException e) {
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
	public int update(FinlCustTypeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return finlCustTypeBaseDao.update(domain);
	}

	@Override
	public int delete(FinlCustTypeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return finlCustTypeBaseDao.delete(domain);
	}

	@Override
	public int delete(List<FinlCustTypeBaseDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (FinlCustTypeBaseDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}
	
	@Override
	public int searchCount2(FinlCustTypeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return finlCustTypeBaseDao.searchCount2(domain);
	}

	

}
