package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.NonOrderHostUpListDomain;
import com.globaldenso.dnkr.integration.dao.NonOrderHostUpListDao;

/**
* [KR] 비서열/확정오더형 산출물 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("nonOrderHostUpListService")
public class NonOrderHostUpListServiceImpl implements NonOrderHostUpListService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstchDao.<br>
     */
    @Autowired
    private NonOrderHostUpListDao nonOrderHostUpListDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public NonOrderHostUpListServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set NonOrderHostUpListDao.<br>
     * [JP] <br>
     * 
     * @param NonOrderHostUpListDao 'NonOrderHostUpListDao' class
     */
    public void setCustOrderTypeMstDao(NonOrderHostUpListDao nonOrderHostUpListDao) {
        this.nonOrderHostUpListDao = nonOrderHostUpListDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpListService#searchByKey(NonOrderHostUpListDomain)
     */
    public NonOrderHostUpListDomain searchByKey(NonOrderHostUpListDomain domain) throws ApplicationException {
        return nonOrderHostUpListDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpListService#searchByCondition(NonOrderHostUpListDomain)
     */
    public List<NonOrderHostUpListDomain> searchByCondition(NonOrderHostUpListDomain domain) throws ApplicationException {
        return nonOrderHostUpListDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.NonOrderHostUpListService#searchByConditionForPaging(NonOrderHostUpListDomain)
     */
    public List<NonOrderHostUpListDomain> searchByConditionForPaging(NonOrderHostUpListDomain domain) throws ApplicationException {
        return nonOrderHostUpListDao.searchByConditionForPaging(domain);
    }
}
