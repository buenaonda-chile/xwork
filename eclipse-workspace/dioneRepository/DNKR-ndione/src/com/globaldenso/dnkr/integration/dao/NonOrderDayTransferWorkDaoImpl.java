package com.globaldenso.dnkr.integration.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.NonOrderDayTransferWorkDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("nonOrderDayTransferWorkDao")
public class NonOrderDayTransferWorkDaoImpl implements NonOrderDayTransferWorkDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.NonOrderDayTransferWorkDao";
    
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
    public NonOrderDayTransferWorkDaoImpl() {
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
     * * @see com.globaldenso.dnkr.integration.dao.NonOrderDayTransferWorkDao#searchCigmaDate(NonOrderDayTransferWorkDomain)
     */
    public List<NonOrderDayTransferWorkDomain> searchCigmaDate(NonOrderDayTransferWorkDomain domain) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".searchCigmaDate", domain);
    }

    
    public boolean procTrans(HashMap map) throws ApplicationException {
    	boolean rtn = true;
    	try {
    		sqlSessionTemplate4.selectOne(NAMESPACE + ".procTrans", map);
	    } catch (Exception e) {
	    	rtn = false;
	    	
	        // Unexpected exception
	    	System.out.println(e.toString());
	    }
	    
	    return rtn;
    }
}
