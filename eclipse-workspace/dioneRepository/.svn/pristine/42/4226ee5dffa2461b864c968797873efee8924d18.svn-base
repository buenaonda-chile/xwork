package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.SalPlnPerfmncMtReprtPptDomain;

/**
 * 
 *
 * @author K-DATALAB
 * @version 1.0
 */
@Repository("salPlnPerfmncMtReprtPptDao")
public class SalPlnPerfmncMtReprtPptDaoImpl implements SalPlnPerfmncMtReprtPptDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.SalPlnPerfmncMtReprtPptDao";
    
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
    public SalPlnPerfmncMtReprtPptDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.SalPlnPerfmncMtReprtPptDao#searchByKey(SalPlnPerfmncMtReprtPptDomain)
     */
    public SalPlnPerfmncMtReprtPptDomain searchByKey(SalPlnPerfmncMtReprtPptDomain domain) throws ApplicationException {
        try {    	
        	return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByKey", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }


    public List<SalPlnPerfmncMtReprtPptDomain> searchByMaker(SalPlnPerfmncMtReprtPptDomain domain) throws ApplicationException {    	
	    try {    	
	    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMaker", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }


	@Override
	public List<SalPlnPerfmncMtReprtPptDomain> searchByMakerComps(SalPlnPerfmncMtReprtPptDomain domain)
			throws ApplicationException {
		
		try {    	
	    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMakerComps", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
		
	}


	@Override
	public List<SalPlnPerfmncMtReprtPptDomain> searchByMakerCompsSum(SalPlnPerfmncMtReprtPptDomain domain)
			throws ApplicationException {
		// TODO Auto-generated method stub
		try {    	
	    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByMakerCompsSum", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
		
	}
	
	   public List<SalPlnPerfmncMtReprtPptDomain> searchByITME(SalPlnPerfmncMtReprtPptDomain domain) throws ApplicationException {    	
		    try {    	
		    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByITME", domain);
	    	}catch (Exception e){
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	
	
		@Override
		public List<SalPlnPerfmncMtReprtPptDomain> searchByITMEComps(SalPlnPerfmncMtReprtPptDomain domain)
				throws ApplicationException {
			
			try {    	
		    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByITMEComps", domain);
	    	}catch (Exception e){
	    		e.printStackTrace();
	    		throw e;
	    	}
			
		}
	
	
		@Override
		public List<SalPlnPerfmncMtReprtPptDomain> searchByITMECompsSum(SalPlnPerfmncMtReprtPptDomain domain)
				throws ApplicationException {
			// TODO Auto-generated method stub
			try {    	
		    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByITMECompsSum", domain);
	    	}catch (Exception e){
	    		e.printStackTrace();
	    		throw e;
	    	}
			
		}

}
