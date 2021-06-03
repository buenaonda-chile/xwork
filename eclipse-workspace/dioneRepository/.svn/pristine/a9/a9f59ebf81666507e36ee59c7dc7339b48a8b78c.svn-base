package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.ProdctIndctBaseLineDomain;

/**
 * [KR] 생산성지표 기준정보(라인정보) 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("prodctIndctBaseLineDao")
public class ProdctIndctBaseLineDaoImpl implements ProdctIndctBaseLineDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.ProdctIndctBaseLineDao";
    
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
    public ProdctIndctBaseLineDaoImpl() {
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
    public List<ProdctIndctBaseLineDomain> searchByCondition(ProdctIndctBaseLineDomain domain) throws ApplicationException {    
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
    public List<ProdctIndctBaseLineDomain> searchByConditionForPaging(ProdctIndctBaseLineDomain domain) throws ApplicationException {    	
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public int searchCount(ProdctIndctBaseLineDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);        
        return cnt;
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public int searchCount2(ProdctIndctBaseLineDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount2", domain);        
        return cnt;
    }   
       
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public int searchCount3(ProdctIndctBaseLineDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount3", domain);        
        return cnt;
    }       
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#create(SalesPlanBaseInfoPaymentDomain)
     */
    public void create(ProdctIndctBaseLineDomain domain) throws ApplicationException {
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
    public int update(ProdctIndctBaseLineDomain domain) throws ApplicationException {
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
    public int delete(ProdctIndctBaseLineDomain domain) throws ApplicationException {
    	try {       	
    		return sqlSessionTemplate4.delete(NAMESPACE + ".delete", domain);
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    }


	@Override
	public int delete(List<ProdctIndctBaseLineDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
		return 0;
	}
}
