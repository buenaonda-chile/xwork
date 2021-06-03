package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PaymentTypeBaseDomain;

/**
 * 
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Repository("paymentTypeBaseDao")
public class PaymentTypeBaseDaoImpl implements PaymentTypeBaseDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.PaymentTypeBaseDao";
    
    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate = null;
    
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
    public PaymentTypeBaseDaoImpl() {
        //no process
    }

    
    /**
     * [EN] It is a setter method of sqlSessionTemplate.<br>
     * [JP] sqlSessionTemplate のセッターメソッドです。<br>
     * 
     * @param sqlSessionTemplate sqlSessionTemplate に設定する
     */
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PaymentTypeBaseDao#searchByKey(PaymentTypeBaseDomain)
     */
    public PaymentTypeBaseDomain searchByKey(PaymentTypeBaseDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.PaymentTypeBaseDao#searchByCondition(PaymentTypeBaseDomain)
     */
    public List<PaymentTypeBaseDomain> searchByCondition(PaymentTypeBaseDomain domain) throws ApplicationException {    	
	    return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.PaymentTypeBaseDao#searchCount(PaymentTypeBaseDomain)
     */
    public List<PaymentTypeBaseDomain> searchByConditionForPaging(PaymentTypeBaseDomain domain) throws ApplicationException {    	
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PaymentTypeBaseDao#create(PaymentTypeBaseDomain)
     */
    public void create(PaymentTypeBaseDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".create", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PaymentTypeBaseDao#update(PaymentTypeBaseDomain)
     */
    public int update(PaymentTypeBaseDomain domain) throws ApplicationException {
    	try {    	
    		return sqlSessionTemplate4.update(NAMESPACE + ".update", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PaymentTypeBaseDao#update(PaymentTypeBaseDomain)
     */
    public int delete(PaymentTypeBaseDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".delete", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PaymentTypeBaseDao#searchCount(PaymentTypeBaseDomain)
     */
    public int searchCount(PaymentTypeBaseDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);        
        return cnt;
    }


	@Override
	public int searchCount2(PaymentTypeBaseDomain domain) throws ApplicationException {
		int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount2", domain);        
        return cnt;
	}
}
