package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.FinlCustInfoBaseDomain;
import com.globaldenso.dnkr.integration.dao.FinlCustInfoBaseDao;

/**
* [KR] 판매계획 기준정보 납입구분 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("finlCustInfoBaseService")
public class FinlCustInfoBaseServiceImpl implements FinlCustInfoBaseService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private FinlCustInfoBaseDao finlCustInfoBaseDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public FinlCustInfoBaseServiceImpl() {
        // no process
    }

	@Override
	public List<FinlCustInfoBaseDomain> searchByCondition(FinlCustInfoBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<FinlCustInfoBaseDomain> list = finlCustInfoBaseDao.searchByCondition(domain);
		return list;
	}

	@Override
	public List<FinlCustInfoBaseDomain> searchByConditionForPaging(FinlCustInfoBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return finlCustInfoBaseDao.searchByConditionForPaging(domain);
	}

	@Override
	public int searchCount(FinlCustInfoBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return finlCustInfoBaseDao.searchCount(domain);
	}

	@Override
	public void create(FinlCustInfoBaseDomain domain) throws ApplicationException {
        try {
        	finlCustInfoBaseDao.create(domain);
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
	public int update(FinlCustInfoBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return finlCustInfoBaseDao.update(domain);
	}

	@Override
	public int delete(FinlCustInfoBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return finlCustInfoBaseDao.delete(domain);
	}

	@Override
	public int delete(List<FinlCustInfoBaseDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (FinlCustInfoBaseDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

	@Override
	public String codeGenarator() throws ApplicationException {
		// TODO Auto-generated method stub
		return finlCustInfoBaseDao.codeGenarator();
	}

}
