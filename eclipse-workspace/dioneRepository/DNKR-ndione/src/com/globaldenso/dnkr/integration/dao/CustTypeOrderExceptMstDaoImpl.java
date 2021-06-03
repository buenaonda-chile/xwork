package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CustTypeOrderExceptMstDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("custTypeOrderExceptMstDao")
public class CustTypeOrderExceptMstDaoImpl implements CustTypeOrderExceptMstDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.CustTypeOrderExceptMstDao";
    
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
    public CustTypeOrderExceptMstDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.CustTypeOrderExceptMstDao#searchByKey(CustTypeOrderExceptMstDomain)
     */
    public CustTypeOrderExceptMstDomain searchByKey(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustTypeOrderExceptMstDao#searchByCondition(CustTypeOrderExceptMstDomain)
     */
    public List<CustTypeOrderExceptMstDomain> searchByCondition(CustTypeOrderExceptMstDomain domain) throws ApplicationException {    	
	    return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustTypeOrderExceptMstDao#searchCount(CustTypeOrderExceptMstDomain)
     */
    public List<CustTypeOrderExceptMstDomain> searchByConditionForPaging(CustTypeOrderExceptMstDomain domain) throws ApplicationException {    	
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustTypeOrderExceptMstDao#searchCount(CustTypeOrderExceptMstDomain)
     */
    public int searchCount(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);        
        return cnt;
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustTypeOrderExceptMstDao#searchCount2(CustTypeOrderExceptMstDomain)
     */
    public int searchCount2(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount2", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustTypeOrderExceptMstDao#searchCountSVM101(CustTypeOrderExceptMstDomain)
     */
    public int searchCountSVM101(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
    	int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCountSVM101", domain);
    	return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CustTypeOrderExceptMstDao#create(CustTypeOrderExceptMstDomain)
     */
    public void create(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".create", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CustTypeOrderExceptMstDao#update(CustTypeOrderExceptMstDomain)
     */
    public int update(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.update(NAMESPACE + ".update", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CustTypeOrderExceptMstDao#update(CustTypeOrderExceptMstDomain)
     */
    public int delete(CustTypeOrderExceptMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".delete", domain);
    }
}
