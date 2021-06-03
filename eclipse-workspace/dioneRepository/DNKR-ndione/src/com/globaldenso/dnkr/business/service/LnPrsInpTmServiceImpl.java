package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.LnPrsInpTmDomain;
import com.globaldenso.dnkr.integration.dao.LnPrsInpTmDao;

/**
 * [KR] 라인인원투입시간등록 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("lnPrsInpTmService")
public class LnPrsInpTmServiceImpl implements LnPrsInpTmService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of LnPrsInpTmDao.<br>
     */
    @Autowired
    private LnPrsInpTmDao lnPrsInpTmDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public LnPrsInpTmServiceImpl() {
        // no process
    }

	@Override
	public List<LnPrsInpTmDomain> searchByCondition(LnPrsInpTmDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
        try {		
		List<LnPrsInpTmDomain> list = lnPrsInpTmDao.searchByCondition(domain);
		return list;
        } catch (ApplicationException e) {		
        	e.printStackTrace();
        	throw e;
        }
		
	}

	@Override
	public List<LnPrsInpTmDomain> searchByConditionForPaging(LnPrsInpTmDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return lnPrsInpTmDao.searchByConditionForPaging(domain);
	}

	@Override
	public int searchCount(LnPrsInpTmDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return lnPrsInpTmDao.searchCount(domain);
	}

	@Override
	public void create(LnPrsInpTmDomain domain) throws ApplicationException {
        try {
        	lnPrsInpTmDao.create(domain);
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
	public int update(LnPrsInpTmDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return lnPrsInpTmDao.update(domain);
	}

	@Override
	public int delete(LnPrsInpTmDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return lnPrsInpTmDao.delete(domain);
	}

	@Override
	public int delete(List<LnPrsInpTmDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (LnPrsInpTmDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

	@Override
	public int searchPrSnlSum(LnPrsInpTmDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return lnPrsInpTmDao.searchPrSnlSum(domain);
	}	
	
}
