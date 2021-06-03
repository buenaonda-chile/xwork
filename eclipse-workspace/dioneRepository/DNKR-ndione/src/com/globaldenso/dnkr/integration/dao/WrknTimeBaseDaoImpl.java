package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.WrknTimeBaseDomain;

/**
 * [KR] 생산성지표 기준정보(제품코드관리) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("wrknTimeBaseDao")
public class WrknTimeBaseDaoImpl implements WrknTimeBaseDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.WrknTimeBaseDao";
    
    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate4")
    private SqlSessionTemplate sqlSessionTemplate4 = null;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WrknTimeBaseDaoImpl() {
        // no process
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

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchByCondition(SalesPlanBaseInfoPaymentDomain)
     */
    public List<WrknTimeBaseDomain> searchByCondition(WrknTimeBaseDomain domain) throws ApplicationException {    
    	try {
    		return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public List<WrknTimeBaseDomain> searchByConditionForPaging(WrknTimeBaseDomain domain) throws ApplicationException {    	
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public int searchCount(WrknTimeBaseDomain domain) throws ApplicationException {
    	int cnt = 0;
    	try {    	
    		cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);    
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}        
        return cnt;
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public int searchCount2(WrknTimeBaseDomain domain) throws ApplicationException {
    	int cnt = 0;
    	try {    	
    		cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount2", domain);    
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}        
        return cnt;
    }    
       
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public int searchCount3(WrknTimeBaseDomain domain) throws ApplicationException {
    	int cnt = 0;
    	try {    	
    		cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount3", domain);    
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}        
        return cnt;
    }  
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public int searchCount4(WrknTimeBaseDomain domain) throws ApplicationException {
    	int cnt = 0;
    	try {    	
    		cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount4", domain);    
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}        
        return cnt;
    }  
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public int searchCount5(WrknTimeBaseDomain domain) throws ApplicationException {
    	int cnt = 0;
    	try {    	
    		cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount5", domain);    
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}        
        return cnt;
    }  
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public int searchCount6(WrknTimeBaseDomain domain) throws ApplicationException {
    	int cnt = 0;
    	try {    	
    		cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount6", domain);    
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}        
        return cnt;
    }      
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#create(SalesPlanBaseInfoPaymentDomain)
     */
    public void create(WrknTimeBaseDomain domain) throws ApplicationException {
    	try {        	
    		sqlSessionTemplate4.insert(NAMESPACE + ".create", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#update(SalesPlanBaseInfoPaymentDomain)
     */
    public int update(WrknTimeBaseDomain domain) throws ApplicationException {
    	try {    	
    		return sqlSessionTemplate4.update(NAMESPACE + ".update", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#update(SalesPlanBaseInfoPaymentDomain)
     */
    public int delete(WrknTimeBaseDomain domain) throws ApplicationException {
    	try {       	
    		return sqlSessionTemplate4.delete(NAMESPACE + ".delete", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }


	@Override
	public int delete(List<WrknTimeBaseDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
		return 0;
	}
}
