package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.NonOrderDayAfterTransferErrorListDomain;
import com.globaldenso.dnkr.integration.dao.NonOrderDayAfterTransferErrorListDao;

/**
* [KR] 비서열/확정오더형 일일 수주이관후 ERROR LIST 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("nonOrderDayAfterTransferErrorListService")
public class NonOrderDayAfterTransferErrorListServiceImpl implements NonOrderDayAfterTransferErrorListService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of NonOrderDayAfterTransferErrorListDao.<br>
     */
    @Autowired
    private NonOrderDayAfterTransferErrorListDao nonOrderDayAfterTransferErrorListDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public NonOrderDayAfterTransferErrorListServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set NonOrderDayAfterTransferErrorListDao.<br>
     * [JP] <br>
     * 
     * @param NonOrderDayAfterTransferErrorListDao 'NonOrderDayAfterTransferErrorListDao' class
     */
    public void setNonOrderDayAfterTransferErrorListDao(NonOrderDayAfterTransferErrorListDao nonOrderDayAfterTransferErrorListDao) {
        this.nonOrderDayAfterTransferErrorListDao = nonOrderDayAfterTransferErrorListDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderDayAfterTransferErrorListService#searchByKey(NonOrderDayAfterTransferErrorListDomain)
     */
    public NonOrderDayAfterTransferErrorListDomain searchByKey(NonOrderDayAfterTransferErrorListDomain domain) throws ApplicationException {
        return nonOrderDayAfterTransferErrorListDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderDayAfterTransferErrorListService#searchByCondition(NonOrderDayAfterTransferErrorListDomain)
     */
    public List<NonOrderDayAfterTransferErrorListDomain> searchByCondition(NonOrderDayAfterTransferErrorListDomain domain) throws ApplicationException {
        return nonOrderDayAfterTransferErrorListDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderDayAfterTransferErrorListService#searchByConditionForPaging(NonOrderDayAfterTransferErrorListDomain)
     */
    public List<NonOrderDayAfterTransferErrorListDomain> searchByConditionForPaging(NonOrderDayAfterTransferErrorListDomain domain) throws ApplicationException {
        return nonOrderDayAfterTransferErrorListDao.searchByConditionForPaging(domain);
    }
}
