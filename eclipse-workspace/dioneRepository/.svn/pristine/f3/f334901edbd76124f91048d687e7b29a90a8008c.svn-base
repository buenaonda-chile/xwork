package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CustOrderDataMngDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("customerOrderDao")
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.CustomerOrderDao";
    
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
    public CustomerOrderDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.CustomerOrderDao#searchByCustOrderDataMng(CustOrderDataMngDomain)
     */
    public List<CustOrderDataMngDomain> searchByCustOrderDataMng(CustOrderDataMngDomain domain) throws ApplicationException {
	    return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCustOrderDataMng", domain);
    }

    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CustomerOrderDao#searchCountCustOrderDataMng(CustOrderDataMngDomain)
     */
    public int searchCountCustOrderDataMng(CustOrderDataMngDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCountCustOrderDataMng", domain);
    }
     
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CustomerOrderDao#updateCustOrderDataMng(CustOrderDataMngDomain)
     */
    public int updateCustOrderDataMng(CustOrderDataMngDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.update(NAMESPACE + ".updateCustOrderDataMng", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CustomerOrderDao#deleteCustOrderDataMng(CustOrderDataMngDomain)
     */
    public int deleteCustOrderDataMng(CustOrderDataMngDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.delete(NAMESPACE + ".deleteCustOrderDataMng", domain);
    }
    
   
}
