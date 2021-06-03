package com.globaldenso.dnkr.integration.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.NonOrderHostUpDomain;
import com.globaldenso.dnkr.domain.TopCustTypeMstDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("nonOrderHostUpDao")
public class NonOrderHostUpDaoImpl implements NonOrderHostUpDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao";
    
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
    public NonOrderHostUpDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#selectSVM020PF(NonOrderHostUpDomain)
     */
    public NonOrderHostUpDomain selectSVM020PF(NonOrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectSVM020PF", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#selectEM000PR(NonOrderHostUpDomain)
     */
    public NonOrderHostUpDomain selectEM000PR(NonOrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectEM000PR", domain);  	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#countMST100PF(NonOrderHostUpDomain)
     */
    public int countMST100PF(NonOrderHostUpDomain domain) throws ApplicationException {
    	int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countMST100PF", domain);
    	return cnt;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#countSVZ60PF(NonOrderHostUpDomain)
     */
    public int countSVZ60PF(NonOrderHostUpDomain domain) throws ApplicationException {
    	int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countSVZ60PF", domain);
    	return cnt;  	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#deleteSVZ60PF(NonOrderHostUpDomain)
     */
    public int deleteSVZ60PF(NonOrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteSVZ60PF", domain);   	
    } 
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#selectPERIOD(NonOrderHostUpDomain)
     */
    public NonOrderHostUpDomain selectPERIOD(NonOrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectPERIOD", domain);  	
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#createSVZ60PF(NonOrderHostUpDomain)
     */
    public void createSVZ60PF(NonOrderHostUpDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".createSVZ60PF", domain);      	
    }
  
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#updateSVZ602PF(NonOrderHostUpDomain)
     */
    public int updateSVZ602PF(NonOrderHostUpDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.update(NAMESPACE + ".updateSVZ602PF", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#countSVZ600PF(NonOrderHostUpDomain)
     */
    public int countSVZ600PF(NonOrderHostUpDomain domain) throws ApplicationException {
    	int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countSVZ600PF", domain);
    	return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#deleteSVZ600PF(NonOrderHostUpDomain)
     */
    public int deleteSVZ600PF(NonOrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteSVZ600PF", domain);   	
    } 
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#createSVZ600PF(NonOrderHostUpDomain)
     */
    public void createSVZ600PF(NonOrderHostUpDomain domain) throws ApplicationException {	
    	sqlSessionTemplate4.insert(NAMESPACE + ".createSVZ600PF", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#countSVZ603PF(NonOrderHostUpDomain)
     */
    public int countSVZ603PF(NonOrderHostUpDomain domain) throws ApplicationException {
    	int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".countSVZ603PF", domain);
    	return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#deleteSVZ603PF(NonOrderHostUpDomain)
     */
    public int deleteSVZ603PF(NonOrderHostUpDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".deleteSVZ603PF", domain);   	
    } 
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao#createSVZ600PF(NonOrderHostUpDomain)
     */
    public void createSVZ603PF(NonOrderHostUpDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".createSVZ603PF", domain);
    }
}
