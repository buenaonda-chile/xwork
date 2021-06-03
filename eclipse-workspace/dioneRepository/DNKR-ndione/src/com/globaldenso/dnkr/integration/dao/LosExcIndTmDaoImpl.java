package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.LosExcIndTmDomain;


/**
 * [KR] 생산성지표 라인인원투입시간등록 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("losExcIndTmDao")
public class LosExcIndTmDaoImpl implements LosExcIndTmDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.LosExcIndTmDao";
    
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
    public LosExcIndTmDaoImpl() {
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
    public List<LosExcIndTmDomain> searchByCondition(LosExcIndTmDomain domain) throws ApplicationException {    
    	try {
    		return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }

    public List<LosExcIndTmDomain> searchLineList(LosExcIndTmDomain domain) throws ApplicationException {    
    	try {
    		return sqlSessionTemplate4.selectList(NAMESPACE + ".searchLineList", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    public List<LosExcIndTmDomain> searchLineValues(LosExcIndTmDomain domain) throws ApplicationException {    
    	try {
    		return sqlSessionTemplate4.selectList(NAMESPACE + ".searchLineValues", domain);
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
    public List<LosExcIndTmDomain> searchByConditionForPaging(LosExcIndTmDomain domain) throws ApplicationException {    	
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public int searchCount(LosExcIndTmDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);        
        return cnt;
    }

       
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#create(SalesPlanBaseInfoPaymentDomain)
     */
    public void create(LosExcIndTmDomain domain) throws ApplicationException {
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
    public int update(LosExcIndTmDomain domain) throws ApplicationException {
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
    public int delete(LosExcIndTmDomain domain) throws ApplicationException {
    	try {       	
    		return sqlSessionTemplate4.delete(NAMESPACE + ".delete", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }


	@Override
	public int delete(List<LosExcIndTmDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
		return 0;
	}
	
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public int searchPrSnlSum(LosExcIndTmDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchPrSnlSum", domain);        
        return cnt;
    }	
	
	
}
