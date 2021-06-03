package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.BkmkDomain;

/**
 * [KO] 코드 관리 DAO 구현
 * [EN] DAO implementation of code information.<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("bkmkDao")
public class BkmkDaoImpl implements BkmkDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.BkmkDao";

    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate = null;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public BkmkDaoImpl() {
        // no process
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
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#searchByKey(BkmkDomain)
     */
    @Override 
    public BkmkDomain searchByKey(BkmkDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CodeDao#searchByCondition(BkmkDomain)
     */
    @Override
    public List<BkmkDomain> searchByCondition(BkmkDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc} 
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CodeDao#searchCount(BkmkDomain)
     */
    @Override
    public int bkmkCount(BkmkDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".bkmkCount", domain);
    }

    /**
     * {@inheritDoc} 
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CodeDao#searchCount(BkmkDomain)
     */
    @Override
    public int searchCount(BkmkDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#create(BkmkDomain)
     */
    public void create(BkmkDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".create", domain);
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#updateCnm(BkmkDomain)
     */
    public int update(BkmkDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".update", domain);
    }
    

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#deleteCmc(BkmkDomain)
     */
    public int delete(BkmkDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".delete", domain);
    }
}
