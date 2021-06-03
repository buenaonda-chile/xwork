package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CustPartConstMstDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("custPartConstMstDao")
public class CustPartConstMstDaoImpl implements CustPartConstMstDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.CustPartConstMstDao";
    
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
    public CustPartConstMstDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.CustPartConstMstDao#searchByKey(CustPartConstMstDomain)
     */
    public CustPartConstMstDomain searchByKey(CustPartConstMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustPartConstMstDao#searchByCondition(CustPartConstMstDomain)
     */
    public List<CustPartConstMstDomain> searchByCondition(CustPartConstMstDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustPartConstMstDao#searchByCondition2(CustPartConstMstDomain)
     */
    public List<CustPartConstMstDomain> searchByCondition2(CustPartConstMstDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition2", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustPartConstMstDao#searchByConditionForPaging(CustPartConstMstDomain)
     */
    public List<CustPartConstMstDomain> searchByConditionForPaging(CustPartConstMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustPartConstMstDao#searchCountEM000PR(CustPartConstMstDomain)
     */
    public int searchCountEM000PR(CustPartConstMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCountEM000PR", domain);        
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustPartConstMstDao#searchCount(CustPartConstMstDomain)
     */
    public int searchCount(CustPartConstMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);        
        return cnt;
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustPartConstMstDao#searchCount2(CustPartConstMstDomain)
     */
    public int searchCount2(CustPartConstMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount2", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CustPartConstMstDao#create(CustPartConstMstDomain)
     */
    public void create(CustPartConstMstDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".create", domain);      	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CustPartConstMstDao#update(CustPartConstMstDomain)
     */
    public int update(CustPartConstMstDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.update(NAMESPACE + ".update", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CustPartConstMstDao#update(CustPartConstMstDomain)
     */
    public int delete(CustPartConstMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".delete", domain);   	
    }
}
