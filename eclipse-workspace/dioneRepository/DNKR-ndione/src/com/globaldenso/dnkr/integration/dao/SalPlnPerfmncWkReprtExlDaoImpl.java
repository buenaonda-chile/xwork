package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.SalPlnPerfmncWkReprtExlDomain;

/**
 * 
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Repository("salPlnPerfmncWkReprtExlDao")
public class SalPlnPerfmncWkReprtExlDaoImpl implements SalPlnPerfmncWkReprtExlDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.SalPlnPerfmncWkReprtExlDao";
    
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
    public SalPlnPerfmncWkReprtExlDaoImpl() {
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
     * * @see com.globaldenso.dnkr.integration.dao.SalPlnPerfmncWkReprtExlDao#searchByCondition(SalPlnPerfmncWkReprtExlDomain)
     */
    public List<SalPlnPerfmncWkReprtExlDomain> searchByMaker(SalPlnPerfmncWkReprtExlDomain domain) throws ApplicationException {    	
	    try {    	
	    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMaker", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }

}
