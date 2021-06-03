package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.PrdctSvcPsnlInputDomain;
import com.globaldenso.dnkr.integration.dao.PrdctSvcPsnlInputDao;


/**
 * [KR] 생산성지표 기준정보(생산용역인원관리) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("prdctSvcPsnlInputService")
public class PrdctSvcPsnlInputServiceImpl implements PrdctSvcPsnlInputService {
	
	@Autowired
	private PrdctSvcPsnlInputDao prdctSvcPsnlInput;
	
	/**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
	public PrdctSvcPsnlInputServiceImpl() {
		// no process
	}
	
	@Override
	public List<PrdctSvcPsnlInputDomain> searchByCondition(PrdctSvcPsnlInputDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		List<PrdctSvcPsnlInputDomain> list = prdctSvcPsnlInput.searchByCondition(domain);
		return list;
	}

	@Override
	public List<PrdctSvcPsnlInputDomain> searchByConditionForPaging(PrdctSvcPsnlInputDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return prdctSvcPsnlInput.searchByConditionForPaging(domain);
	}

	@Override
	public int searchCount(PrdctSvcPsnlInputDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return prdctSvcPsnlInput.searchCount(domain);
	}

	@Override
	public int searchCount2(PrdctSvcPsnlInputDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return prdctSvcPsnlInput.searchCount2(domain);
	}

	@Override
	public void create(PrdctSvcPsnlInputDomain domain) throws ApplicationException {
		try {
			prdctSvcPsnlInput.create(domain);
		} catch (ApplicationException e) {
			e.printStackTrace();
			if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
				throw new ApplicationException("SMPL-E8-0004", MessageSources.getInstance().value("info.employee"));
			} else {
				throw e;
			}
		}
	}

	@Override
	public int update(PrdctSvcPsnlInputDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return prdctSvcPsnlInput.update(domain);
	}

	@Override
	public int delete(PrdctSvcPsnlInputDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return prdctSvcPsnlInput.delete(domain);
	}

	@Override
	public int delete(List<PrdctSvcPsnlInputDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
		int deleteCount = 0;
        for (PrdctSvcPsnlInputDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

}
