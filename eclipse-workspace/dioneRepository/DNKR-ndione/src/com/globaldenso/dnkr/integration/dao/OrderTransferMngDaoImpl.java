package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderTransferMngDomain;

/**
 * 
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Repository("orderTransferMngDao")
public class OrderTransferMngDaoImpl implements OrderTransferMngDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.OrderTransferMngDao";
     
    /**
     * [EN] SqlSessionTemplate4.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate4")
    private SqlSessionTemplate sqlSessionTemplate4 = null;
   
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public OrderTransferMngDaoImpl() {
        //no process
    }

    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderTransferMngDao#searchByKey(OrderTransferMngDomain)
     */
    public OrderTransferMngDomain searchByKey(OrderTransferMngDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderTransferMngDao#searchByCondition(OrderTransferMngDomain)
     */
    public List<OrderTransferMngDomain> searchByCondition(OrderTransferMngDomain domain) throws ApplicationException {    	
	    return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderTransferMngDao#searchCount(OrderTransferMngDomain)
     */
    public List<OrderTransferMngDomain> searchByConditionForPaging(OrderTransferMngDomain domain) throws ApplicationException {    	
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

}
