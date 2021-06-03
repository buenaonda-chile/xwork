package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.TopCustTypeMstDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("topCustTypeMstDao")
public class TopCustTypeMstDaoImpl implements TopCustTypeMstDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.TopCustTypeMstDao";
    
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
    public TopCustTypeMstDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.TopCustTypeMstDao#searchByKey(TopCustTypeMstDomain)
     */
    public TopCustTypeMstDomain searchByKey(TopCustTypeMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.TopCustTypeMstDao#searchByCondition(TopCustTypeMstDomain)
     */
    public List<TopCustTypeMstDomain> searchByCondition(TopCustTypeMstDomain domain) throws ApplicationException {
	    return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.TopCustTypeMstDao#searchCount(TopCustTypeMstDomain)
     */
    public List<TopCustTypeMstDomain> searchByConditionForPaging(TopCustTypeMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.TopCustTypeMstDao#searchCount(TopCustTypeMstDomain)
     */
    public int searchCount(TopCustTypeMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);        
        return cnt;
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.TopCustTypeMstDao#searchCount2(TopCustTypeMstDomain)
     */
    public int searchCount2(TopCustTypeMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount2", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.TopCustTypeMstDao#searchCountCUSNO(TopCustTypeMstDomain)
     */
    public int searchCountCUSNO(TopCustTypeMstDomain domain) throws ApplicationException {
    	int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCountCUSNO", domain);
    	return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.TopCustTypeMstDao#searchCountMST050(TopCustTypeMstDomain)
     */
    public TopCustTypeMstDomain searchCountMST050(TopCustTypeMstDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCountMST050", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.TopCustTypeMstDao#create(TopCustTypeMstDomain)
     */
    public void create(TopCustTypeMstDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".create", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.TopCustTypeMstDao#update(TopCustTypeMstDomain)
     */
    public int update(TopCustTypeMstDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.update(NAMESPACE + ".update", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.TopCustTypeMstDao#update(TopCustTypeMstDomain)
     */
    public int delete(TopCustTypeMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".delete", domain);
    }
}
