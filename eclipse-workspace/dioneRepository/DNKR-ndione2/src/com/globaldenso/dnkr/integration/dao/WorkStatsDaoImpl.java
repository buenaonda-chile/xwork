package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PjtDomain;

/**
 * [KO] 업무별 통계 관리 DAO 구현
 * [EN] <br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("workStatsDao")
public class WorkStatsDaoImpl implements WorkStatsDao {
    
    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.WorkStatsDao";
    
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
    public WorkStatsDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForTeamL(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForTeamL(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForTeamL", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForTeamM(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForTeamM(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForTeamM", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForTeamS(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForTeamS(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForTeamS", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForTeamRelSys(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForTeamRelSys(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForTeamRelSys", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForL(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForL(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForL", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForL(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForM(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForM", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForL(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForS(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForS", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForL(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForRelSys(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForRelSys", domain);
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
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForPagingWorkL(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForPagingWorkL(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPagingWorkL", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForPagingWorkM(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForPagingWorkM(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPagingWorkM", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForPagingWorkS(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForPagingWorkS(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPagingWorkS", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForPagingTeamL(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForPagingTeamL(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPagingTeamL", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForPagingTeamM(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForPagingTeamM(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPagingTeamM", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForPagingTeamS(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForPagingTeamS(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPagingTeamS", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchByConditionForPagingRelSys(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForPagingRelSys(PjtDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPagingRelSys", domain);
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
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchCountWorkL(PjtDomain)
     */
    public int searchCountWorkL(PjtDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCountWorkL", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchCountWorkM(PjtDomain)
     */
    public int searchCountWorkM(PjtDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCountWorkM", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchCountWorkS(PjtDomain)
     */
    public int searchCountWorkS(PjtDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCountWorkS", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchCountTeamL(PjtDomain)
     */
    public int searchCountTeamL(PjtDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCountTeamL", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchCountTeamM(PjtDomain)
     */
    public int searchCountTeamM(PjtDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCountTeamM", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchCountTeamS(PjtDomain)
     */
    public int searchCountTeamS(PjtDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCountTeamS", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PjtDao#searchCountRelSys(PjtDomain)
     */
    public int searchCountRelSys(PjtDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCountRelSys", domain);
        return cnt;
    }
    
}
