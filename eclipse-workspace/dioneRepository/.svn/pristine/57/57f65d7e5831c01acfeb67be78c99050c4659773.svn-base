package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.LgstTimeDstrRtBaseDomain;
import com.globaldenso.dnkr.integration.dao.LgstTimeDstrRtBaseDao;

/**
 * [KR] 생산성지표 기준정보(물류시간 배분 비율관리) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("lgstTimeDstrRtBaseService")
public class LgstTimeDstrRtBaseServiceImpl implements LgstTimeDstrRtBaseService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private LgstTimeDstrRtBaseDao lgstTimeDstrRtBase;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public LgstTimeDstrRtBaseServiceImpl() {
        // no process
    }

	@Override
	public List<LgstTimeDstrRtBaseDomain> searchByCondition(LgstTimeDstrRtBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<LgstTimeDstrRtBaseDomain> list = lgstTimeDstrRtBase.searchByCondition(domain);
		return list;
	}

	@Override
	public List<LgstTimeDstrRtBaseDomain> searchByConditionForPaging(LgstTimeDstrRtBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		 return lgstTimeDstrRtBase.searchByConditionForPaging(domain);
	}

	@Override
	public int searchCount(LgstTimeDstrRtBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		 return lgstTimeDstrRtBase.searchCount(domain);
	}

	@Override
	public void create(LgstTimeDstrRtBaseDomain domain) throws ApplicationException {
        try {
        	lgstTimeDstrRtBase.create(domain);
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
	public int update(LgstTimeDstrRtBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
	 	return lgstTimeDstrRtBase.update(domain);
	}

	@Override
	public int delete(LgstTimeDstrRtBaseDomain domain) throws ApplicationException {
		// TODO Auto-generated method stub
		return lgstTimeDstrRtBase.delete(domain);
	}

	@Override
	public int delete(List<LgstTimeDstrRtBaseDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
        int deleteCount = 0;
        for (LgstTimeDstrRtBaseDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
	}

}
