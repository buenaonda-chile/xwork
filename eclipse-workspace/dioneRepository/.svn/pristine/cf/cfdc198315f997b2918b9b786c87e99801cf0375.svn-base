package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PrdctIndComBaseDomain;

/**
 * [KR] 생산성지표 기준정보(공정관리) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("prdctIndComBaseDaoImpl")
public class PrdctIndComBaseDaoImpl implements PrdctIndComBaseDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.PrdctIndComBaseDao";
    

    /**
     * [EN] SqlSessionTemplate.(더존)<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate2")
    private SqlSessionTemplate sqlSessionTemplate2 = null;
    
    
    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate4")
    private SqlSessionTemplate sqlSessionTemplate4 = null;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PrdctIndComBaseDaoImpl() {
        // no process
    }
    
    /**
     * [EN] It is a setter method of sqlSessionTemplate.<br>
     * [JP] sqlSessionTemplate のセッターメソッドです。<br>
     * 
     * @param sqlSessionTemplate sqlSessionTemplate に設定する
     */
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate4 = sqlSessionTemplate;
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.PrdctIndComBaseDao#searchItemMaster(PrdctIndComBaseDomain)
     */
    public List<PrdctIndComBaseDomain> searchItemMaster(PrdctIndComBaseDomain domain) throws ApplicationException {    
    	try {
    		return sqlSessionTemplate4.selectList(NAMESPACE + ".searchItemMaster", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.PrdctIndComBaseDao#searchItemMaster(PrdctIndComBaseDomain)
     */
    public List<PrdctIndComBaseDomain> searchDeptMaster(PrdctIndComBaseDomain domain) throws ApplicationException {    
    	try {
    		return sqlSessionTemplate2.selectList(NAMESPACE + ".searchDeptMaster", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.PrdctIndComBaseDao#searchItemMaster(PrdctIndComBaseDomain)
     */
    public List<PrdctIndComBaseDomain> searchEmpMaster(PrdctIndComBaseDomain domain) throws ApplicationException {    
    	try {
    		return sqlSessionTemplate2.selectList(NAMESPACE + ".searchEmpMaster", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }      
    
}
