package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.FinlCustInfoBaseDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("finlCustInfoBaseDao")
public class FinlCustInfoBaseDaoImpl implements FinlCustInfoBaseDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.FinlCustInfoBaseDao";
    
    /**
     * [EN] SqlSessionTemplate4.<br>
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
    public FinlCustInfoBaseDaoImpl() {
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
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchByCondition(SalesPlanBaseInfoPaymentDomain)
     */
    public List<FinlCustInfoBaseDomain> searchByCondition(FinlCustInfoBaseDomain domain) throws ApplicationException {    	
	    return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public List<FinlCustInfoBaseDomain> searchByConditionForPaging(FinlCustInfoBaseDomain domain) throws ApplicationException {    	
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#searchCount(SalesPlanBaseInfoPaymentDomain)
     */
    public int searchCount(FinlCustInfoBaseDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);        
        return cnt;
    }

       
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#create(SalesPlanBaseInfoPaymentDomain)
     */
    public void create(FinlCustInfoBaseDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".create", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#update(SalesPlanBaseInfoPaymentDomain)
     */
    public int update(FinlCustInfoBaseDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.update(NAMESPACE + ".update", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.SalesPlanBaseInfoPaymentDao#update(SalesPlanBaseInfoPaymentDomain)
     */
    public int delete(FinlCustInfoBaseDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".delete", domain);
    }


	@Override
	public int delete(List<FinlCustInfoBaseDomain> domainList) throws ApplicationException {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String codeGenarator() throws ApplicationException {
		// TODO Auto-generated method stub
		return sqlSessionTemplate4.selectOne(NAMESPACE + ".codeGenarator");
	}
}
