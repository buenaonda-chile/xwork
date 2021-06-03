package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CustOrderTypeMstViewDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("custOrderTypeMstViewDao")
public class CustOrderTypeMstViewDaoImpl implements CustOrderTypeMstViewDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.CustOrderTypeMstViewDao";
    
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
    public CustOrderTypeMstViewDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstViewDao#searchByKey(CustOrderTypeMstViewDomain)
     */
    public CustOrderTypeMstViewDomain searchByKey(CustOrderTypeMstViewDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstViewDao#searchByCondition(CustOrderTypeMstViewDomain)
     */
    public List<CustOrderTypeMstViewDomain> searchByCondition(CustOrderTypeMstViewDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CustOrderTypeMstViewDao#searchByConditionForPaging(CustOrderTypeMstViewDomain)
     */
    public List<CustOrderTypeMstViewDomain> searchByConditionForPaging(CustOrderTypeMstViewDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }
}
