package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.LosExcIndTmDomain;
import com.globaldenso.dnkr.integration.dao.LosExcIndTmDao;

/**
 * [KR] 라인인원투입시간등록 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("LosExcIndTmService")
public class LosExcIndTmServiceImpl implements LosExcIndTmService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of LnPrsInpTmDao.<br>
     */
    @Autowired
    private LosExcIndTmDao losExcIndTmDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public LosExcIndTmServiceImpl() {
        // no process
    }

	@Override
	public List<LosExcIndTmDomain> searchByCondition(LosExcIndTmDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
        try {		
		List<LosExcIndTmDomain> list = losExcIndTmDao.searchByCondition(domain);
		return list;
        } catch (ApplicationException e) {		
        	e.printStackTrace();
        	throw e;
        }
		
	}
	
	@Override
	public List<LosExcIndTmDomain> searchLineValues(LosExcIndTmDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
        try {		
		List<LosExcIndTmDomain> list = losExcIndTmDao.searchLineValues(domain);
		return list;
        } catch (ApplicationException e) {		
        	e.printStackTrace();
        	throw e;
        }
		
	}
	
	@Override
	public List<LosExcIndTmDomain> searchLineList(LosExcIndTmDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
        try {		
		List<LosExcIndTmDomain> list = losExcIndTmDao.searchLineList(domain);
		return list;
        } catch (ApplicationException e) {		
        	e.printStackTrace();
        	throw e;
        }
		
	}

	@Override
	public List<LosExcIndTmDomain> searchByConditionForPaging(LosExcIndTmDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return losExcIndTmDao.searchByConditionForPaging(domain);
	}

	@Override
	public int searchCount(LosExcIndTmDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return losExcIndTmDao.searchCount(domain);
	}

	@Override
	public void create(LosExcIndTmDomain domain) throws ApplicationException {
        try {
        	losExcIndTmDao.create(domain);
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
	public int update(LosExcIndTmDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return losExcIndTmDao.update(domain);
	}

	@Override
	public int delete(LosExcIndTmDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return losExcIndTmDao.delete(domain);
	}

	@Override
	public int delete(List<LosExcIndTmDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (LosExcIndTmDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

	@Override
	public int searchPrSnlSum(LosExcIndTmDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return losExcIndTmDao.searchPrSnlSum(domain);
	}	
	
}
