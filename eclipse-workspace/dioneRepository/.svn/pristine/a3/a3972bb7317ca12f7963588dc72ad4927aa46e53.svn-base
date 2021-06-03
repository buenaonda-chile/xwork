package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.SalPlnPerfmncMtReprtExlDomain;

/**
 * 
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Repository("salPlnPerfmncMtReprtExlDao")
public class SalPlnPerfmncMtReprtExlDaoImpl implements SalPlnPerfmncMtReprtExlDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.SalPlnPerfmncMtReprtExlDao";
    
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
    public SalPlnPerfmncMtReprtExlDaoImpl() {
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
     * * @see com.globaldenso.dnkr.integration.dao.SalPlnPerfmncMtReprtExlDao#searchByCondition(SalPlnPerfmncMtReprtExlDomain)
     */
    public List<SalPlnPerfmncMtReprtExlDomain> searchBySalPlnList(SalPlnPerfmncMtReprtExlDomain domain) throws ApplicationException {    	
	    try {    	
	    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchBySalPlnList", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }


    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalPlnPerfmncMtReprtExlDao#searchByCondition(SalPlnPerfmncMtReprtExlDomain)
     */
    public List<SalPlnPerfmncMtReprtExlDomain> searchByCondition(SalPlnPerfmncMtReprtExlDomain domain) throws ApplicationException {    	
	    try {    	
	    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }

}
