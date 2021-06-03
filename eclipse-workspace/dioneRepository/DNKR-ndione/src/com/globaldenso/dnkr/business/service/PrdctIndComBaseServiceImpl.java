package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.library.presentation.paging.exception.PagingJspException;
import com.globaldenso.dnkr.domain.PrdctIndComBaseDomain;
import com.globaldenso.dnkr.integration.dao.PrdctIndComBaseDao;

/**
 * [KR] 생산성지표 기준정보(공통) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("prdctIndComBaseService")
public class PrdctIndComBaseServiceImpl implements PrdctIndComBaseService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstDao.<br>
     */
    @Autowired
    private PrdctIndComBaseDao prdctIndComBaseDao;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PrdctIndComBaseServiceImpl() {
        // no process
    }

	@Override
	public List<PrdctIndComBaseDomain> searchItemMaster(PrdctIndComBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		List<PrdctIndComBaseDomain> list = prdctIndComBaseDao.searchItemMaster(domain);
		return list;
	}

	@Override
	public List<PrdctIndComBaseDomain> searchDeptMaster(PrdctIndComBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		try {
		List<PrdctIndComBaseDomain> list = prdctIndComBaseDao.searchDeptMaster(domain);
		return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        
	}	
	
	@Override
	public List<PrdctIndComBaseDomain> searchEmpMaster(PrdctIndComBaseDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		try {
		List<PrdctIndComBaseDomain> list = prdctIndComBaseDao.searchEmpMaster(domain);
		return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        
	}		

}
