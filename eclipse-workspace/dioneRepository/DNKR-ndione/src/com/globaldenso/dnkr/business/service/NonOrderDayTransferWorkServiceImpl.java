package com.globaldenso.dnkr.business.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.NonOrderDayTransferWorkDomain;
import com.globaldenso.dnkr.integration.dao.NonOrderDayTransferWorkDao;

/**
* [KR] 비서열/확정오더형 일일 수주이관 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("nonOrderDayTransferWorkService")
public class NonOrderDayTransferWorkServiceImpl implements NonOrderDayTransferWorkService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of NonOrderDayTransferWorkDao.<br>
     */
    @Autowired
    private NonOrderDayTransferWorkDao nonOrderDayTransferWorkDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public NonOrderDayTransferWorkServiceImpl() {
        // no process
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderDayTransferWorkService#searchCigmaDate(NonOrderDayTransferWorkDomain)
     */
    public List<NonOrderDayTransferWorkDomain> searchCigmaDate(NonOrderDayTransferWorkDomain domain) throws ApplicationException {
        return nonOrderDayTransferWorkDao.searchCigmaDate(domain);
    }

    
    public boolean procTrans(HashMap parm) throws ApplicationException {
    	return nonOrderDayTransferWorkDao.procTrans(parm);
    }
    
}
