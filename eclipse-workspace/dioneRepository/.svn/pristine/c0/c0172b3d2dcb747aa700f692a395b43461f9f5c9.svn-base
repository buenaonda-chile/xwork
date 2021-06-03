package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CustOrderTypeHistMstViewDomain;
import com.globaldenso.dnkr.integration.dao.CustOrderTypeHistMstViewDao;

/**
* [KR] 업체서열차종이력마스타조회 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("custOrderTypeHistMstViewService")
public class CustOrderTypeHistMstViewServiceImpl implements CustOrderTypeHistMstViewService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstchDao.<br>
     */
    @Autowired
    private CustOrderTypeHistMstViewDao custOrderTypeHistMstViewDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public CustOrderTypeHistMstViewServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set CustOrderTypeHistMstViewDao.<br>
     * [JP] <br>
     * 
     * @param CustOrderTypeHistMstViewDao 'CustOrderTypeHistMstViewDao' class
     */
    public void setCustOrderTypeMstDao(CustOrderTypeHistMstViewDao custOrderTypeHistMstViewDao) {
        this.custOrderTypeHistMstViewDao = custOrderTypeHistMstViewDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeHistMstViewService#searchByKey(CustOrderTypeHistMstViewDomain)
     */
    public CustOrderTypeHistMstViewDomain searchByKey(CustOrderTypeHistMstViewDomain domain) throws ApplicationException {
        return custOrderTypeHistMstViewDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeHistMstViewService#searchByCondition(CustOrderTypeHistMstViewDomain)
     */
    public List<CustOrderTypeHistMstViewDomain> searchByCondition(CustOrderTypeHistMstViewDomain domain) throws ApplicationException {
        return custOrderTypeHistMstViewDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CustOrderTypeHistMstViewService#searchByConditionForPaging(CustOrderTypeHistMstViewDomain)
     */
    public List<CustOrderTypeHistMstViewDomain> searchByConditionForPaging(CustOrderTypeHistMstViewDomain domain) throws ApplicationException {
        return custOrderTypeHistMstViewDao.searchByConditionForPaging(domain);
    }
}
