package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CustPartConstMstViewDomain;
import com.globaldenso.dnkr.integration.dao.CustPartConstMstViewDao;

/**
* [KR] 업체부품구성마스타조회 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("custPartConstMstViewService")
public class CustPartConstMstViewServiceImpl implements CustPartConstMstViewService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstchDao.<br>
     */
    @Autowired
    private CustPartConstMstViewDao custPartConstMstViewDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public CustPartConstMstViewServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set CustPartConstMstViewDao.<br>
     * [JP] <br>
     * 
     * @param CustPartConstMstViewDao 'CustPartConstMstViewDao' class
     */
    public void setCustOrderTypeMstDao(CustPartConstMstViewDao custPartConstMstViewDao) {
        this.custPartConstMstViewDao = custPartConstMstViewDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstViewService#searchByKey(CustPartConstMstViewDomain)
     */
    public CustPartConstMstViewDomain searchByKey(CustPartConstMstViewDomain domain) throws ApplicationException {
        return custPartConstMstViewDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstViewService#searchByCondition(CustPartConstMstViewDomain)
     */
    public List<CustPartConstMstViewDomain> searchByCondition(CustPartConstMstViewDomain domain) throws ApplicationException {
        return custPartConstMstViewDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustPartConstMstViewService#searchByConditionForPaging(CustPartConstMstViewDomain)
     */
    public List<CustPartConstMstViewDomain> searchByConditionForPaging(CustPartConstMstViewDomain domain) throws ApplicationException {
        return custPartConstMstViewDao.searchByConditionForPaging(domain);
    }
}
