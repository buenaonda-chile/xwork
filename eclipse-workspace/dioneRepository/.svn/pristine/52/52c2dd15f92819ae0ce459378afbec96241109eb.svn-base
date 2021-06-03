package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.LogDomain;
import com.globaldenso.dnkr.integration.dao.LogDao;

/**
 * [KR] 로그관리 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("logService")
public class LogServiceImpl implements LogService {
    /**
     * [KR] 로그 관리 Dao <br>
     */
    @Autowired
    private LogDao logDao;
   
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public LogServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set DAO of Employee information.<br>
     * [JP] 社員情報のDAOを設定します。<br>
     * 
     * @param empDao Dao of 'EMP_INFO'
     */
    public void setEmpDao(LogDao empDao) {
        this.logDao = empDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LogService#searchByKey(LogDomain)
     */
    public LogDomain searchByKey(LogDomain domain) throws ApplicationException {
        return logDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LogService#searchByCondition(LogDomain)
     */
    public List<LogDomain> searchByCondition(LogDomain domain) throws ApplicationException {
        return logDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LogService#searchByConditionForPaging(LogDomain)
     */
    public List<LogDomain> searchByConditionForPaging(LogDomain domain) throws ApplicationException {
        return logDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LogService#searchCount(LogDomain)
     */
    public int searchCount(LogDomain domain) throws ApplicationException {
        return logDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LogService#create(LogDomain)
     */
    public void create(LogDomain domain) throws ApplicationException {
        try {
            logDao.create(domain);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.log"));
            } else {
                throw e;
            }
        }
    }
}
