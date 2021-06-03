package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderDayShipQtyCheckListDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("orderDayShipQtyCheckListDao")
public class OrderDayShipQtyCheckListDaoImpl implements OrderDayShipQtyCheckListDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.OrderDayShipQtyCheckListDao";
    
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
    public OrderDayShipQtyCheckListDaoImpl() {
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
     * * @see com.globaldenso.dnkr.integration.dao.OrderDayShipQtyCheckListDao#selectMST040PF_HOUSE(OrderDayShipQtyCheckListDomain)
     */
    public List<OrderDayShipQtyCheckListDomain> selectMST040PF_HOUSE(OrderDayShipQtyCheckListDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectMST040PF_HOUSE", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderDayShipQtyCheckListDao#selectSPDE141Q_142PF(OrderDayShipQtyCheckListDomain)
     */
    public List<OrderDayShipQtyCheckListDomain> selectSPDE141Q_142PF(OrderDayShipQtyCheckListDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSPDE141Q_142PF", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderDayShipQtyCheckListDao#selectSPDE141Q_148PF(OrderDayShipQtyCheckListDomain)
     */
    public List<OrderDayShipQtyCheckListDomain> selectSPDE141Q_148PF(OrderDayShipQtyCheckListDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSPDE141Q_148PF", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderDayShipQtyCheckListDao#selectSAL100_SE(OrderDayShipQtyCheckListDomain)
     */
    public List<OrderDayShipQtyCheckListDomain> selectSAL100_SE(OrderDayShipQtyCheckListDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSAL100_SE", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderDayShipQtyCheckListDao#selectMST090PF(OrderDayShipQtyCheckListDomain)
     */
    public List<OrderDayShipQtyCheckListDomain> selectMST090PF(OrderDayShipQtyCheckListDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectMST090PF", domain);
    }
    
}
