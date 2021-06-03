package com.globaldenso.dnkr.integration.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.KiaHyundaiVANCompanyCodeMstDomain;
import com.globaldenso.dnkr.domain.NonOrderHostUpDomain;
import com.globaldenso.dnkr.domain.OrderDayTransferWorkDomain;
import com.globaldenso.dnkr.domain.OrderHostUpDomain;
import com.globaldenso.dnkr.domain.OrderTransferMngDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("orderDayTransferWorkDao")
public class OrderDayTransferWorkDaoImpl implements OrderDayTransferWorkDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.OrderDayTransferWorkDao";
    
    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate")
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
    public OrderDayTransferWorkDaoImpl() {
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
     * * @see com.globaldenso.dnkr.integration.dao.OrderDayTransferWorkDao#searchCigmaDate(OrderDayTransferWorkDomain)
     */
    public List<OrderDayTransferWorkDomain> searchCigmaDate(OrderDayTransferWorkDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchCigmaDate", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderDayTransferWorkDao#countMST040PF(OrderDayTransferWorkDomain)
     */
    public int countMST040PF(OrderDayTransferWorkDomain domain) throws ApplicationException {
    	int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countMST040PF", domain);
    	return cnt;
    }
    
    public boolean procTrans(HashMap map) throws ApplicationException {
    	boolean rtn = true;
    	try {
    		sqlSessionTemplate4.selectOne(NAMESPACE + ".procTrans", map);
	    } catch (Exception e) {
	    	rtn = false;
	    	
	        // Unexpected exception
	    	System.out.println(e.toString());
	    }
	    
	    return rtn;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderDayTransferWorkDao#countHISTORY(OrderDayTransferWorkDomain)
     */
    public int countHISTORY(OrderDayTransferWorkDomain domain) throws ApplicationException {
    	int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countHISTORY", domain);
    	return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderDayTransferWorkDao#deleteHISTORY(OrderDayTransferWorkDomain)
     */
    public int deleteHISTORY(OrderDayTransferWorkDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteHISTORY", domain);   	
    } 
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderDayTransferWorkDao#createHISTORY(OrderDayTransferWorkDomain)
     */
    public void createHISTORY(OrderDayTransferWorkDomain domain) throws ApplicationException {
    	try {
    		sqlSessionTemplate4.insert(NAMESPACE + ".createHISTORY", domain);
	    } catch (Exception e) {
	        // Unexpected exception
	    	System.out.println(e.toString());
	    }
	    
    	//sqlSessionTemplate4.insert(NAMESPACE + ".createHISTORY", domain);
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderDayTransferWorkDao#cigmaDataSearch(OrderDayTransferWorkDomain)
     */
    public List<OrderDayTransferWorkDomain> cigmaDataSearch(OrderDayTransferWorkDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".cigmaDataSearch", domain);
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderDayTransferWorkDao#selectSVZ600PF(OrderDayTransferWorkDomain)
     */
    public List<NonOrderHostUpDomain> selectSVZ600PF(OrderDayTransferWorkDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSVZ600PF", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderDayTransferWorkDao#selectSVZ600PF_2(OrderDayTransferWorkDomain)
     */
    public List<NonOrderHostUpDomain> selectSVZ600PF_2(OrderDayTransferWorkDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSVZ600PF_2", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderDayTransferWorkDao#searchSVZ613PF(OrderTransferMngDomain)
     */
    public int searchSVZ613PF(OrderTransferMngDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchSVZ613PF", domain);        
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderDayTransferWorkDao#updateSVZ613PF(OrderTransferMngDomain)
     */
    public int updateSVZ613PF(OrderTransferMngDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.update(NAMESPACE + ".updateSVZ613PF", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderDayTransferWorkDao#createSVZ613PF(OrderTransferMngDomain)
     */
    public void createSVZ613PF(OrderTransferMngDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".createSVZ613PF", domain);
    }
}
