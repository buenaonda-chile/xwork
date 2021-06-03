package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.ProdctCodeBaseDomain;
import com.globaldenso.dnkr.domain.WorkCodeBaseDomain;
import com.globaldenso.dnkr.integration.dao.ProdctCodeBaseDao;
import com.globaldenso.dnkr.integration.dao.WorkCodeBaseDao;

/**
 * [KR] 생산성지표 기준정보(작업코드관리) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("workCodeBaseService")
public class WorkCodeBaseServiceImpl implements WorkCodeBaseService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private WorkCodeBaseDao workCodeBaseDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WorkCodeBaseServiceImpl() {
        // no process
    }

	@Override
	public List<WorkCodeBaseDomain> searchByCondition(WorkCodeBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<WorkCodeBaseDomain> list = workCodeBaseDao.searchByCondition(domain);
		return list;
	}

	@Override
	public List<WorkCodeBaseDomain> searchByConditionForPaging(WorkCodeBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return workCodeBaseDao.searchByConditionForPaging(domain);
	}

	@Override
	public int searchCount(WorkCodeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return workCodeBaseDao.searchCount(domain);
	}

	@Override
	public int searchCount2(WorkCodeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return workCodeBaseDao.searchCount2(domain);
	}
	
	@Override
	public void create(WorkCodeBaseDomain domain) throws ApplicationException {
        try {
        	workCodeBaseDao.create(domain);
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
	public int update(WorkCodeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return workCodeBaseDao.update(domain);
	}

	@Override
	public int delete(WorkCodeBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return workCodeBaseDao.delete(domain);
	}

	@Override
	public int delete(List<WorkCodeBaseDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (WorkCodeBaseDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

}
