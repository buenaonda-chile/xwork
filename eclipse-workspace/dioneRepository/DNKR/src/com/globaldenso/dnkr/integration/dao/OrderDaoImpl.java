package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderDomain;
import com.globaldenso.dnkr.domain.OrderQtyDomain;
import com.globaldenso.dnkr.domain.db2.OrderDb2Domain;

/**
 * [KO] 수주업로드 DAO 구현
 * [EN] DAO implementation of contract information.<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.OrderDao";

    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate = null;
    
    /**
     * 
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate4")
    private SqlSessionTemplate sqlSessionTemplate4 = null;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public OrderDaoImpl() {
        // no process
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
     * * @see com.globaldenso.dnkr.integration.dao.ContractDao#searchByCondition(OrderDomain)
     */
    @Override
    public int searchCount(OrderDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.ContractDao#searchByCondition(OrderDomain)
     */
    @Override
    public int searchQtyCount(OrderQtyDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchQtyCount", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.ContractDao#searchByCondition(OrderDomain)
     */
    @Override
    public OrderDomain searchById(OrderDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchById", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.ContractDao#searchByCondition(OrderDomain)
     */
    @Override
    public List<OrderDomain> searchByCondition(OrderDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.ContractDao#searchByCondition(OrderDomain)
     */
    @Override
    public List<OrderDomain> getReleaseDate(OrderDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".getReleaseDate", domain);
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.ContractDao#searchByCondition(OrderDomain)
     */
    @Override
    public String OrderNextIdx(OrderDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".OrderNextIdx", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.ContractDao#searchByCondition(OrderDomain)
     */
    @Override
    public List<OrderQtyDomain> searchByConditionQty(OrderQtyDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionQty", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#create(OrderDomain)
     */
    public void create(OrderDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".create", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#create(OrderDomain)
     */
    public void createQty(OrderQtyDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createQty", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.ContractDao#delete(OrderDomain)
     */
    public int orderUpdate(OrderDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".update", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.ContractDao#delete(OrderDomain)
     */
    public int orderQtyUpdate(OrderQtyDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateQty", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.ContractDao#delete(OrderDomain)
     */
    public int orderDelete(OrderDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".delete", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.ContractDao#delete(OrderDomain)
     */
    public int qtyDelete(OrderQtyDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteQty", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.ContractDao#delete(OrderDomain)
     */
    public OrderDb2Domain getDensoNumber(OrderDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".getDensoNumber", domain);
    }
}
