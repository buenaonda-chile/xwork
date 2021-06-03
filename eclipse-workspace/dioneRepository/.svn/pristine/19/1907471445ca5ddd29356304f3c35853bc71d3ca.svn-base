package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CustOrderTypeMstDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("custOrderTypeMstDao")
public class CustOrderTypeMstDaoImpl implements CustOrderTypeMstDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao";
    
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
    public CustOrderTypeMstDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao#searchByKey(CustOrderTypeMstDomain)
     */
    public CustOrderTypeMstDomain searchByKey(CustOrderTypeMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao#searchByCondition(CustOrderTypeMstDomain)
     */
    public List<CustOrderTypeMstDomain> searchByCondition(CustOrderTypeMstDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao#searchCount(CustOrderTypeMstDomain)
     */
    public List<CustOrderTypeMstDomain> searchByConditionForPaging(CustOrderTypeMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao#searchCount(CustOrderTypeMstDomain)
     */
    public int searchCount(CustOrderTypeMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);        
        return cnt;
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao#searchCount2(CustOrderTypeMstDomain)
     */
    public int searchCount2(CustOrderTypeMstDomain domain) throws ApplicationException {  	
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount2", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao#searchCheck(CustOrderTypeMstDomain)
     */
    public int searchCheck(CustOrderTypeMstDomain domain) throws ApplicationException {	    	
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCheck", domain);
        return cnt;
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao#searchCheck2(CustOrderTypeMstDomain)
     */
    public int searchCheck2(CustOrderTypeMstDomain domain) throws ApplicationException { 	    	
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCheck2", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao#searchCheck3(CustOrderTypeMstDomain)
     */
    public int searchCheck3(CustOrderTypeMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCheck3", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao#createSVM200(CustOrderTypeMstDomain)
     */
    public void createSVM200(CustOrderTypeMstDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".createSVM200", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao#create(CustOrderTypeMstDomain)
     */
    public void create(CustOrderTypeMstDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".create", domain);      	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao#update(CustOrderTypeMstDomain)
     */
    public int update(CustOrderTypeMstDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.update(NAMESPACE + ".update", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstDao#update(CustOrderTypeMstDomain)
     */
    public int delete(CustOrderTypeMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".delete", domain);   	
    }
}
