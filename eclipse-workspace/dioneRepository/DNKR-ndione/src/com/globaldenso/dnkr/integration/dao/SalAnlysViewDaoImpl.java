package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.SalAnlysViewDomain;

/**
 * 
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Repository("salAnlysViewDao")
public class SalAnlysViewDaoImpl implements SalAnlysViewDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.SalAnlysViewDao";
    
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
    public SalAnlysViewDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.SalAnlysViewDao#searchByKey(SalAnlysViewDomain)
     */
    public SalAnlysViewDomain searchByKey(SalAnlysViewDomain domain) throws ApplicationException {
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
     * * @see com.globaldenso.dnkr.integration.dao.SalAnlysViewDao#searchByCondition(SalAnlysViewDomain)
     */
    public List<SalAnlysViewDomain> searchByCondition(SalAnlysViewDomain domain) throws ApplicationException {    	
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
     * * @see com.globaldenso.dnkr.integration.dao.SalAnlysViewDao#searchCount(SalAnlysViewDomain)
     */
    public List<SalAnlysViewDomain> searchByConditionForPaging(SalAnlysViewDomain domain) throws ApplicationException {    	
    	try {    	
        	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }
}
