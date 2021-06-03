package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.WorkSortDomain;

/**
 * [KO] 업무분류 관리 DAO 구현
 * [EN] <br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("workSortDao")
public class WorkSortDaoImpl implements WorkSortDao {
    
    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.WorkSortDao";
    
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
    public WorkSortDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.WorkSortDao#searchByKey(WorkSortDomain)
     */
    public WorkSortDomain searchByKey(WorkSortDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchByKey", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.WorkSortDao#searchByCondition(WorkSortDomain)
     */
    public List<WorkSortDomain> searchByCondition(WorkSortDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.WorkSortDao#searchByConditionForPaging(WorkSortDomain)
     */
    public List<WorkSortDomain> searchByConditionForPaging(WorkSortDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.WorkSortDao#searchWorkConfirm(WorkSortDomain)
     */
    public WorkSortDomain searchWorkConfirm(WorkSortDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchWorkConfirm", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.WorkSortDao#searchWorkConfirmList(WorkSortDomain)
     */
    public List<WorkSortDomain> searchWorkConfirmList(WorkSortDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchWorkConfirmList", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#searchMaxWorkCodeNum(WorkSortDomain)
     */
    public String searchMaxWorkCodeNum(WorkSortDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchMaxWorkCodeNum", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.WorkSortDao#searchCount(WorkSortDomain)
     */
    public int searchCount(WorkSortDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.WorkSortDao#create(WorkSortDomain)
     */
    public void create(WorkSortDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".create", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.WorkSortDao#update(WorkSortDomain)
     */
    public int update(WorkSortDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".update", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.WorkSortDao#createSetAprvEmp(WorkSortDomain)
     */
    public void createSetAprvEmp(WorkSortDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createSetAprvEmp", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.WorkSortDao#updateSetAprvEmp(WorkSortDomain)
     */
    public int updateSetAprvEmp(WorkSortDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateSetAprvEmp", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.WorkSortDao#delete(WorkSortDomain)
     */
    public int delete(WorkSortDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".delete", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.WorkSortDao#deleteAprvEmp(WorkSortDomain)
     */
    public int deleteAprvEmp(WorkSortDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteAprvEmp", domain);
    }
}
