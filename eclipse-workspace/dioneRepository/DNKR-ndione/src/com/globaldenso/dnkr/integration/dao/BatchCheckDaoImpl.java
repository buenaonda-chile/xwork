package com.globaldenso.dnkr.integration.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.BatchDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("batchCheckDao")
public class BatchCheckDaoImpl implements BatchCheckDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.BatchCheckDao";
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
     * [EN] SqlSessionTemplate4.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate5")
    private SqlSessionTemplate sqlSessionTemplate5 = null;
   
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public BatchCheckDaoImpl() {
        //no process
    }

    
    /**
     * [EN] It is a setter method of sqlSessionTemplate.<br>
     * [JP] sqlSessionTemplate のセッターメソッドです。<br>
     * 
     * @param sqlSessionTemplate sqlSessionTemplate に設定する
     */
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate4) {
        this.sqlSessionTemplate4 = sqlSessionTemplate4;
    }
    

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.NonOrderDayTransferWorkDao#searchCigmaDate(NonOrderDayTransferWorkDomain)
     */
	@Override
    public List<BatchDomain> selectBatchInfo(String string) throws ApplicationException {
    	return sqlSessionTemplate4.selectList(NAMESPACE + ".selectBatchInfo", string);
    }


	@Override
	public int searchBatchCheckError(BatchDomain batchDomain) throws ApplicationException {
		return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchBatchCheckError", batchDomain);
	}


	@Override
	public int searchBatchCheckMassage() throws ApplicationException {
		return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchBatchCheckMassage");
		
	}

	@Override
	public void insertSmsSendData(Map<String, String> map) throws ApplicationException {
       sqlSessionTemplate5.insert(NAMESPACE + ".insertSmsSendData", map);
	}


	@Override
	public List<BatchDomain> searchSMSuserList() throws ApplicationException {
		return sqlSessionTemplate.selectList(NAMESPACE + ".searchSMSuserList", "");
	}


	@Override
	public void updateSMSsendCount(Map<String, String> map) throws ApplicationException {
		sqlSessionTemplate.update(NAMESPACE + ".updateSMSsendCount", map);
	}


}
