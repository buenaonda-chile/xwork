package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.KiaHyundaiVANCompanyCodeMstDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("kiaHyundaiVANCompanyCodeMstDao")
public class KiaHyundaiVANCompanyCodeMstDaoImpl implements KiaHyundaiVANCompanyCodeMstDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.KiaHyundaiVANCompanyCodeMstDao";
    
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
    public KiaHyundaiVANCompanyCodeMstDaoImpl() {
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
     * * @see com.globaldenso.dnkr.integration.dao.KiaHyundaiVANCompanyCodeMstDao#searchByCondition(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public List<KiaHyundaiVANCompanyCodeMstDomain> searchByCondition(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
	    return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.KiaHyundaiVANCompanyCodeMstDao#searchCount(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public int searchCount(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);        
        return cnt;
    }

    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.KiaHyundaiVANCompanyCodeMstDao#create(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public void create(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".create", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.KiaHyundaiVANCompanyCodeMstDao#update(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public int update(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.update(NAMESPACE + ".update", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.KiaHyundaiVANCompanyCodeMstDao#update(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public int delete(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".delete", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.KiaHyundaiVANCompanyCodeMstDao#searchByCondition(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public List<KiaHyundaiVANCompanyCodeMstDomain> searchByCondition030(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
	    return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition030", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.KiaHyundaiVANCompanyCodeMstDao#searchCount(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public int searchCount030(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount030", domain);        
        return cnt;
    }

    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.KiaHyundaiVANCompanyCodeMstDao#create(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public void create030(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".create030", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.KiaHyundaiVANCompanyCodeMstDao#update(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public int update030(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.update(NAMESPACE + ".update030", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.KiaHyundaiVANCompanyCodeMstDao#update(KiaHyundaiVANCompanyCodeMstDomain)
     */
    public int delete030(KiaHyundaiVANCompanyCodeMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".delete030", domain);
    }
}
