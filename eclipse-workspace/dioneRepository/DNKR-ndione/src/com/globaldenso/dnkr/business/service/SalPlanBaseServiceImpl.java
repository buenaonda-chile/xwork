package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.library.presentation.paging.exception.PagingJspException;
import com.globaldenso.dnkr.domain.SalPlanBaseDomain;
import com.globaldenso.dnkr.integration.dao.SalPlanBaseDao;

/**
 * [KR] 생산성지표 기준정보(공통) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("salPlanBaseService")
public class SalPlanBaseServiceImpl implements SalPlanBaseService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private SalPlanBaseDao salPlanBaseDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public SalPlanBaseServiceImpl() {
        // no process
    }

	@Override
	public List<SalPlanBaseDomain> searchInfoMaster(SalPlanBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<SalPlanBaseDomain> list = salPlanBaseDao.searchInfoMaster(domain);
		return list;
	}

		

}
