package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CustOrderTypeMstViewDomain;
import com.globaldenso.dnkr.integration.dao.CustOrderTypeMstViewDao;

/**
* [KR] 업체서열차종마스타차종별조회 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("custOrderTypeMstViewService")
public class CustOrderTypeMstViewServiceImpl implements CustOrderTypeMstViewService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstchDao.<br>
     */
    @Autowired
    private CustOrderTypeMstViewDao custOrderTypeMstViewDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public CustOrderTypeMstViewServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set CustOrderTypeMstViewDao.<br>
     * [JP] <br>
     * 
     * @param CustOrderTypeMstViewDao 'CustOrderTypeMstViewDao' class
     */
    public void setCustOrderTypeMstDao(CustOrderTypeMstViewDao custOrderTypeMstViewDao) {
        this.custOrderTypeMstViewDao = custOrderTypeMstViewDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstViewService#searchByKey(CustOrderTypeMstViewDomain)
     */
    public CustOrderTypeMstViewDomain searchByKey(CustOrderTypeMstViewDomain domain) throws ApplicationException {
        return custOrderTypeMstViewDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstViewService#searchByCondition(CustOrderTypeMstViewDomain)
     */
    public List<CustOrderTypeMstViewDomain> searchByCondition(CustOrderTypeMstViewDomain domain) throws ApplicationException {
        return custOrderTypeMstViewDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeMstViewService#searchByConditionForPaging(CustOrderTypeMstViewDomain)
     */
    public List<CustOrderTypeMstViewDomain> searchByConditionForPaging(CustOrderTypeMstViewDomain domain) throws ApplicationException {
        return custOrderTypeMstViewDao.searchByConditionForPaging(domain);
    }
}
