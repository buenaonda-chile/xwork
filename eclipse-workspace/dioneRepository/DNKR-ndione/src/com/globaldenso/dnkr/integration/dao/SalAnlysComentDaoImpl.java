package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.SalAnlysComentDomain;

/**
 * 
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Repository("salAnlysComentDao")
public class SalAnlysComentDaoImpl implements SalAnlysComentDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.SalAnlysComentDao";
    
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
    public SalAnlysComentDaoImpl() {
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
    public SalAnlysComentDomain searchByKey(SalAnlysComentDomain domain) throws ApplicationException {
        try {    	
        	return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByKey", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.PaymentTypeBaseDao#searchByCondition(PaymentTypeBaseDomain)
     */
    public List<SalAnlysComentDomain> searchByCondition(SalAnlysComentDomain domain) throws ApplicationException {    	
	    try {    	
	    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.PaymentTypeBaseDao#searchCount(PaymentTypeBaseDomain)
     */
    public List<SalAnlysComentDomain> searchByConditionForPaging(SalAnlysComentDomain domain) throws ApplicationException {    	
        try {    	
        	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }

    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PaymentTypeBaseDao#create(PaymentTypeBaseDomain)
     */
    public void create(SalAnlysComentDomain domain) throws ApplicationException {
    	try {    	
    		sqlSessionTemplate4.insert(NAMESPACE + ".create", domain);
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
    public int update(SalAnlysComentDomain domain) throws ApplicationException {
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
    public int delete(SalAnlysComentDomain domain) throws ApplicationException {
        try {
        	return sqlSessionTemplate4.delete(NAMESPACE + ".delete", domain);
		} catch (Exception e) {
			e.printStackTrace();
    		throw e;
		}
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PaymentTypeBaseDao#searchCount(PaymentTypeBaseDomain)
     */
    public int searchCount(SalAnlysComentDomain domain) throws ApplicationException {
        try {
        	int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);        
            return cnt;
		} catch (Exception e) {
			e.printStackTrace();
    		throw e;
		}
    }


	@Override
	public int searchCount2(SalAnlysComentDomain domain) throws ApplicationException {
		try {
			int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount2", domain);        
	        return cnt;
		} catch (Exception e) {
			e.printStackTrace();
    		throw e;
		}
	}
}
