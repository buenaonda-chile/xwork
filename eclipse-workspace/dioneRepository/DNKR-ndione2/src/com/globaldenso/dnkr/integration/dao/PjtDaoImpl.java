package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PjtDomain;

/**
 * [KO] 프로젝트 관리 DAO 구현
 * [EN] DAO implementation of project information.<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("pjtDao")
public class PjtDaoImpl implements PjtDao {
    
    /**
    * [EN] Namespace of SQLMap.<br>
    * [JP] SQLMapの名前空間。<br>
    */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.PjtDao";
    
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
    public PjtDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByKey(PjtDomain)
     */
    public PjtDomain searchByKey(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchByKey", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByCondition(PjtDomain)
     */
    public List<PjtDomain> searchByCondition(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#relSysList(PjtDomain)
     */
    public List<String> relSysList(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".relSysList", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchPjtRegStatus(PjtDomain)
     */
    public List<PjtDomain> searchPjtRegStatus(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchPjtRegStatus", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForPaging(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForPaging(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchMaxPjtNum(PjtDomain)
     */
    public int searchMaxPjtNum(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchMaxPjtNum", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchCount(PjtDomain)
     */
    public int searchCount(PjtDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#create(PjtDomain)
     */
    public void create(PjtDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".create", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#update(PjtDomain)
     */
    public int update(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".update", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#delete(PjtDomain)
     */
    public int delete(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".delete", domain);
    }
}
