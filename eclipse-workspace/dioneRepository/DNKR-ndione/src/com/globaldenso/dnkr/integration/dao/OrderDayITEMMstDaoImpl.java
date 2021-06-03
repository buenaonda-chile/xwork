package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderDayITEMMstDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("orderDayITEMMstDao")
public class OrderDayITEMMstDaoImpl implements OrderDayITEMMstDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.OrderDayITEMMstDao";
    
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
    public OrderDayITEMMstDaoImpl() {
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
     * * @see com.globaldenso.dnkr.integration.dao.OrderDayITEMMstDao#searchByCondition(OrderDayITEMMstDomain)
     */
    public List<OrderDayITEMMstDomain> searchByCondition(OrderDayITEMMstDomain domain) throws ApplicationException {
	    return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderDayITEMMstDao#searchCount(OrderDayITEMMstDomain)
     */
    public int pspnoSearchCount(OrderDayITEMMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".pspnoSearchCount", domain);        
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderDayITEMMstDao#searchCount(OrderDayITEMMstDomain)
     */
    public int searchCount(OrderDayITEMMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);        
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderDayITEMMstDao#create(OrderDayITEMMstDomain)
     */
    public void create(OrderDayITEMMstDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".create", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderDayITEMMstDao#update(OrderDayITEMMstDomain)
     */
    public int delete(OrderDayITEMMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".delete", domain);
    }
}
