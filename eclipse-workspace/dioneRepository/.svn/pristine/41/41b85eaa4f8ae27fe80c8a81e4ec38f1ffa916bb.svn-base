package com.globaldenso.dnkr.integration.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.NonOrderHostUpDomain;
import com.globaldenso.dnkr.domain.OrderCalendarDomain;
import com.globaldenso.dnkr.domain.OrderDaySaleCreateDomain;
import com.globaldenso.dnkr.domain.OrderDaySaleCreateDomain2;
import com.globaldenso.dnkr.domain.OrderHostUpDomain;
import com.globaldenso.dnkr.domain.PjtDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("orderDaySaleCreateDao")
public class OrderDaySaleCreateDaoImpl implements OrderDaySaleCreateDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.OrderDaySaleCreateDao";
    
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
    public OrderDaySaleCreateDaoImpl() {
        //no process
    }

    
    /**
     * [EN] It is a setter method of sqlSessionTemplate.<br>
     * [JP] sqlSessionTemplate のセッターメソッドです。<br>
     * 
     * @param sqlSessionTemplate sqlSessionTemplate に設定する
     */
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate4 = sqlSessionTemplate;
    }

    public boolean procCreate(HashMap<String, String> param) throws ApplicationException {
    	boolean rtn = true;
    	try {
    		System.out.println(param.get("param"));
    		sqlSessionTemplate4.selectOne(NAMESPACE + ".procCreate", param);
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
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#deleteSPD149PFX(OrderHostUpDomain)
     */
    public int deleteSPD149PFX(OrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteSPD149PFX", domain);   	
    } 
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#deleteSPD141PF(OrderHostUpDomain)
     */
    public int deleteSPD141PF(OrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteSPD141PF", domain);   	
    } 
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#deleteSPD142PF(OrderHostUpDomain)
     */
    public int deleteSPD142PF(OrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteSPD142PF", domain);   	
    } 
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#deleteSPD148PF(OrderHostUpDomain)
     */
    public int deleteSPD148PF(OrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteSPD148PF", domain);   	
    } 
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#deleteSPD148PF(OrderHostUpDomain)
     */
    public int deleteSHK200PF(OrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteSHK200PF", domain);   	
    } 
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#deleteSPD148PF(OrderHostUpDomain)
     */
    public int deleteSHK210PF(OrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteSHK210PF", domain);   	
    } 
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#insertSHK200PF(OrderHostUpDomain)
     */
    public void insertSHK200PF(OrderHostUpDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".insertSHK200PF", domain);      	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#insertSHK210PF(OrderHostUpDomain)
     */
    public void insertSHK210PF(OrderHostUpDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".insertSHK210PF", domain);      	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#insertSPD141PF(OrderHostUpDomain)
     */
    public void insertSPD141PF(OrderHostUpDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".insertSPD141PF", domain);      	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#insertSPD141PF_2(OrderHostUpDomain)
     */
    public void insertSPD141PF_2(OrderHostUpDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".insertSPD141PF_2", domain);      	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#selectSPD141PF(OrderDaySaleCreateDomain)
     */
    public List<OrderDaySaleCreateDomain> selectSPD141PF(OrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSPD141PF", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#insertSPD142PF(OrderDaySaleCreateDomain)
     */
    public void insertSPD142PF(OrderDaySaleCreateDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".insertSPD142PF", domain);      	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#insertSPD148PF(OrderDaySaleCreateDomain)
     */
    public void insertSPD148PF(OrderDaySaleCreateDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".insertSPD148PF", domain);      	
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#countSAL160PF(OrderDaySaleCreateDomain)
     */
    public int countSAL160PF(OrderDaySaleCreateDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countSAL160PF", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#countSVZ040PF(OrderDaySaleCreateDomain)
     */
    public int countSVZ040PF(OrderDaySaleCreateDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countSVZ040PF", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#countBM009PR(OrderDaySaleCreateDomain)
     */
    public int countBM009PR(OrderDaySaleCreateDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countBM009PR", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#selectSPD142PF(OrderDaySaleCreateDomain)
     */
    public List<OrderDaySaleCreateDomain2> selectSPD142PF(OrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSPD142PF", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#updateSPD142PF(OrderDaySaleCreateDomain2)
     */
    public int updateSPD142PF(OrderDaySaleCreateDomain2 domain) throws ApplicationException {
        return sqlSessionTemplate4.update(NAMESPACE + ".updateSPD142PF", domain);
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#updateSPD142PF_2(OrderDaySaleCreateDomain2)
     */
    public int updateSPD142PF_2(OrderDaySaleCreateDomain2 domain) throws ApplicationException {
        return sqlSessionTemplate4.update(NAMESPACE + ".updateSPD142PF_2", domain);
    }
    

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#selectSPD142PF(OrderDaySaleCreateDomain)
     */
    public List<OrderCalendarDomain> selectSAL100PF(NonOrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSAL100PF", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#insertSPD148PF(OrderDaySaleCreateDomain)
     */
    public void insertSVZ600PF_2(NonOrderHostUpDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".insertSVZ600PF_2", domain);      	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#selectSHK210PF(OrderHostUpDomain)
     */
    public List<OrderDaySaleCreateDomain> selectSHK210PF(OrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSHK210PF", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#insertSPD141PF_3(OrderHostUpDomain)
     */
    public void insertSPD141PF_3(OrderDaySaleCreateDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".insertSPD141PF_3", domain);      	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#updateSPD141PF(OrderDaySaleCreateDomain2)
     */
    public int updateSPD141PF(OrderDaySaleCreateDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.update(NAMESPACE + ".updateSPD141PF", domain);
    }
    
    /**
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#getPlnM(OrderDaySaleCreateDomain)
     */
    public List<OrderDaySaleCreateDomain> getPlnM(OrderDaySaleCreateDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".getPlnM", domain);
    }
    
    /**
     * 
     * @see com.globaldenso.dnkr.integration.dao.orderDaySaleCreateDao#getWorkDays(OrderDaySaleCreateDomain)
     */
    public List<OrderDaySaleCreateDomain> getWorkDays(OrderDaySaleCreateDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".getWorkDays", domain);
    }
}
