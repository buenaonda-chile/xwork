package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CustPartConstMstViewDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("custPartConstMstViewDao")
public class CustPartConstMstViewDaoImpl implements CustPartConstMstViewDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.CustPartConstMstViewDao";
    
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
    public CustPartConstMstViewDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.CustPartConstMstViewDao#searchByKey(CustPartConstMstViewDomain)
     */
    public CustPartConstMstViewDomain searchByKey(CustPartConstMstViewDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustPartConstMstViewDao#searchByCondition(CustPartConstMstViewDomain)
     */
    public List<CustPartConstMstViewDomain> searchByCondition(CustPartConstMstViewDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustPartConstMstViewDao#searchByConditionForPaging(CustPartConstMstViewDomain)
     */
    public List<CustPartConstMstViewDomain> searchByConditionForPaging(CustPartConstMstViewDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }
}
