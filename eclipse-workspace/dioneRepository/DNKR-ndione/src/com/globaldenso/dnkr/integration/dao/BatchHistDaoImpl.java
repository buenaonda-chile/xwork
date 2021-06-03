package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.BatchHistDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("batchHistDao")
public class BatchHistDaoImpl implements BatchHistDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.BatchHistDao";
    
    
	@Autowired
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate = null;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
   

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.BatchHistDao#searchByCondition(BatchHistDomain)
     */
    public List<BatchHistDomain> searchByCondition(BatchHistDomain domain) throws ApplicationException {
	    return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    
    
    
}
