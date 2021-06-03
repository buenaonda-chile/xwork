package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.DuplTypeOrderCodeMstDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("duplTypeOrderCodeMstDao")
public class DuplTypeOrderCodeMstDaoImpl implements DuplTypeOrderCodeMstDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.DuplTypeOrderCodeMstDao";
    
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
    public DuplTypeOrderCodeMstDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.DuplTypeOrderCodeMstDao#searchByKey(DuplTypeOrderCodeMstDomain)
     */
    public DuplTypeOrderCodeMstDomain searchByKey(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.DuplTypeOrderCodeMstDao#searchByCondition(DuplTypeOrderCodeMstDomain)
     */
    public List<DuplTypeOrderCodeMstDomain> searchByCondition(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
	    return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.DuplTypeOrderCodeMstDao#searchCount(DuplTypeOrderCodeMstDomain)
     */
    public List<DuplTypeOrderCodeMstDomain> searchByConditionForPaging(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.DuplTypeOrderCodeMstDao#searchCount(DuplTypeOrderCodeMstDomain)
     */
    public int searchCount(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount", domain);        
        return cnt;
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.DuplTypeOrderCodeMstDao#searchCount2(DuplTypeOrderCodeMstDomain)
     */
    public int searchCount2(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCount2", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.DuplTypeOrderCodeMstDao#searchCountSVM100(DuplTypeOrderCodeMstDomain)
     */
    public int searchCountSVM100(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate4.selectOne(NAMESPACE + ".searchCountSVM100", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DuplTypeOrderCodeMstDao#create(DuplTypeOrderCodeMstDomain)
     */
    public void create(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
    	sqlSessionTemplate4.insert(NAMESPACE + ".create", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DuplTypeOrderCodeMstDao#update(DuplTypeOrderCodeMstDomain)
     */
    public int update(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.update(NAMESPACE + ".update", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.DuplTypeOrderCodeMstDao#update(DuplTypeOrderCodeMstDomain)
     */
    public int delete(DuplTypeOrderCodeMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.delete(NAMESPACE + ".delete", domain);
    }
}
