package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderHostUpDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("orderHostUpDao")
public class OrderHostUpDaoImpl implements OrderHostUpDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.OrderHostUpDao";
    
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
    public OrderHostUpDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#selectSVM020PF(OrderHostUpDomain)
     */
    public OrderHostUpDomain selectSVM020PF(OrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectSVM020PF", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#selectSVZ080PF(OrderHostUpDomain)
     */
    public OrderHostUpDomain selectSVZ080PF(OrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectSVZ080PF", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#selectSVM100PF(OrderHostUpDomain)
     */
    public List<OrderHostUpDomain> selectSVM100PF(OrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSVM100PF", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#selectSVM300PF(OrderHostUpDomain)
     */
    public OrderHostUpDomain selectSVM300PF(OrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectSVM300PF", domain);   	
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#countSVH310PF_Temp(OrderHostUpDomain)
     */
    public int countSVH310PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countSVH310PF_Temp", domain);        
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#deleteSVH310PF_Temp(OrderHostUpDomain)
     */
    public int deleteSVH310PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteSVH310PF_Temp", domain);   	
    } 
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#createSVH310PF_Temp(OrderHostUpDomain)
     */
    public void createSVH310PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".createSVH310PF_Temp", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#selectSVH310PF_Temp(OrderHostUpDomain)
     */
    public List<OrderHostUpDomain> selectSVH310PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSVH310PF_Temp", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#selectSVH310PF_TempSum(OrderHostUpDomain)
     */
    public OrderHostUpDomain selectSVH310PF_TempSum(OrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectSVH310PF_TempSum", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#countSVH310PF1(OrderHostUpDomain)
     */
    public int countSVH310PF1(OrderHostUpDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countSVH310PF1", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#deleteSVH310PF(OrderHostUpDomain)
     */
    public int deleteSVH310PF(OrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteSVH310PF", domain);   	
    }    
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#countSVH310PF2(OrderHostUpDomain)
     */
    public int countSVH310PF2(OrderHostUpDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countSVH310PF2", domain);        
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#createSVH310PF(OrderHostUpDomain)
     */
    public void createSVH310PF(OrderHostUpDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".createSVH310PF", domain);      	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#createSVH310PF_ADD(OrderHostUpDomain)
     */
    public void createSVH310PF_ADD(OrderHostUpDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".createSVH310PF_ADD", domain);    	
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#countSVH320PF_Temp(OrderHostUpDomain)
     */
    public int countSVH320PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countSVH320PF_Temp", domain);        
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#deleteSVH320PF_Temp(OrderHostUpDomain)
     */
    public int deleteSVH320PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteSVH320PF_Temp", domain);   	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#createSVH320PF_Temp(OrderHostUpDomain)
     */
    public void createSVH320PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".createSVH320PF_Temp", domain);      	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#selectSVH320PF_Temp(OrderHostUpDomain)
     */
    public List<OrderHostUpDomain> selectSVH320PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSVH320PF_Temp", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#selectSVH320PF_TempSum(OrderHostUpDomain)
     */
    public OrderHostUpDomain selectSVH320PF_TempSum(OrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectSVH320PF_TempSum", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#countSVH320PF1(OrderHostUpDomain)
     */
    public int countSVH320PF1(OrderHostUpDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countSVH320PF1", domain);        
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#deleteSVH320PF(OrderHostUpDomain)
     */
    public int deleteSVH320PF(OrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteSVH320PF", domain);   	
    }    
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#countSVH320PF2(OrderHostUpDomain)
     */
    public int countSVH320PF2(OrderHostUpDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countSVH320PF2", domain);        
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#createSVH320PF(OrderHostUpDomain)
     */
    public void createSVH320PF(OrderHostUpDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".createSVH320PF", domain);      	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.OrderHostUpDao#createSVH320PF_ADD(OrderHostUpDomain)
     */
    public void createSVH320PF_ADD(OrderHostUpDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".createSVH320PF_ADD", domain);      	
    }    
}
