package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.StEmpAbsTrdDomain;
import com.globaldenso.dnkr.integration.dao.StEmpAbsTrdDao;

/**
 * [KR] 생산성지표 현장사원일일근태등록 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("stEmpAbsTrdService")
public class StEmpAbsTrdServiceImpl implements StEmpAbsTrdService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private StEmpAbsTrdDao stEmpAbsTrdDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public StEmpAbsTrdServiceImpl() {
        // no process
    }

	@Override
	public List<StEmpAbsTrdDomain> searchByCondition(StEmpAbsTrdDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<StEmpAbsTrdDomain> list = stEmpAbsTrdDao.searchByCondition(domain);
		return list;
	}
	
	@Override
	public List<StEmpAbsTrdDomain> searchByConditionSt(StEmpAbsTrdDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<StEmpAbsTrdDomain> list = stEmpAbsTrdDao.searchByConditionSt(domain);
		return list;
	}
		
	
	@Override
	public List<StEmpAbsTrdDomain> searchByCondition1(StEmpAbsTrdDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<StEmpAbsTrdDomain> list = stEmpAbsTrdDao.searchByCondition1(domain);
		return list;
	}	
	
	@Override
	public List<StEmpAbsTrdDomain> searchByOverTimeSum(StEmpAbsTrdDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<StEmpAbsTrdDomain> list = stEmpAbsTrdDao.searchByOverTimeSum(domain);
		return list;
	}	

	@Override
	public List<StEmpAbsTrdDomain> searchByMinusSum(StEmpAbsTrdDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<StEmpAbsTrdDomain> list = stEmpAbsTrdDao.searchByMinusSum(domain);
		return list;
	}		
	
	@Override
	public List<StEmpAbsTrdDomain> searchByConditionForPaging(StEmpAbsTrdDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return stEmpAbsTrdDao.searchByConditionForPaging(domain);
	}
	
	@Override
	public List<StEmpAbsTrdDomain> searchByDayWorkTimeSum(StEmpAbsTrdDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return stEmpAbsTrdDao.searchByDayWorkTimeSum(domain);
	}	
	

	@Override
	public int searchCount(StEmpAbsTrdDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
        try {		
		 return stEmpAbsTrdDao.searchCount(domain);
        } catch (ApplicationException e) {
        	e.printStackTrace();
        	 throw e;
        }		 
	}

	@Override
	public int searchCountSt(StEmpAbsTrdDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
        try {		
		 return stEmpAbsTrdDao.searchCountSt(domain);
        } catch (ApplicationException e) {
        	e.printStackTrace();
        	 throw e;
        }		 
	}
	
	@Override
	public void create(StEmpAbsTrdDomain domain) throws ApplicationException {
        try {
        	stEmpAbsTrdDao.create(domain);
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
	public int update(StEmpAbsTrdDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return stEmpAbsTrdDao.update(domain);
	}
	
	@Override
	public void createSt(StEmpAbsTrdDomain domain) throws ApplicationException {
        try {
        	stEmpAbsTrdDao.createSt(domain);
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
	public void createLgstTm(StEmpAbsTrdDomain domain) throws ApplicationException {
        try {
        	stEmpAbsTrdDao.createLgstTm(domain);
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
	public int updateSt(StEmpAbsTrdDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return stEmpAbsTrdDao.updateSt(domain);
	}	
	
	@Override
	public int updateLgstTm(StEmpAbsTrdDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return stEmpAbsTrdDao.updateLgstTm(domain);
	}		

	@Override
	public int delete(StEmpAbsTrdDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return stEmpAbsTrdDao.delete(domain);
	}

	@Override
	public int delete(List<StEmpAbsTrdDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (StEmpAbsTrdDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

	@Override
	public int searchLgstCount(StEmpAbsTrdDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
        try {		
		 return stEmpAbsTrdDao.searchLgstCount(domain);
        } catch (ApplicationException e) {
        	e.printStackTrace();
        	 throw e;
        }		 
	}	
	
	@Override
	public List<StEmpAbsTrdDomain> searchLgstTm(StEmpAbsTrdDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return stEmpAbsTrdDao.searchLgstTm(domain);
	}		
	
	
}
