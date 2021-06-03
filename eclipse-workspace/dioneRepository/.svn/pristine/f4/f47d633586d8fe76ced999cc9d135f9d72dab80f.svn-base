package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.NonOrderDayAfterTransferErrorListDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("nonOrderDayAfterTransferErrorListDao")
public class NonOrderDayAfterTransferErrorListDaoImpl implements NonOrderDayAfterTransferErrorListDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.NonOrderDayAfterTransferErrorListDao";
    
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
    public NonOrderDayAfterTransferErrorListDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.NonOrderDayAfterTransferErrorListDao#searchByKey(NonOrderDayAfterTransferErrorListDomain)
     */
    public NonOrderDayAfterTransferErrorListDomain searchByKey(NonOrderDayAfterTransferErrorListDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.NonOrderDayAfterTransferErrorListDao#searchByCondition(NonOrderDayAfterTransferErrorListDomain)
     */
    public List<NonOrderDayAfterTransferErrorListDomain> searchByCondition(NonOrderDayAfterTransferErrorListDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.NonOrderDayAfterTransferErrorListDao#searchByConditionForPaging(NonOrderDayAfterTransferErrorListDomain)
     */
    public List<NonOrderDayAfterTransferErrorListDomain> searchByConditionForPaging(NonOrderDayAfterTransferErrorListDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }
}
