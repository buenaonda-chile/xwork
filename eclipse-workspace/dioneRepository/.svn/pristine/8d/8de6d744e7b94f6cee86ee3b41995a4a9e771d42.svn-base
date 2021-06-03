package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.WorkSortDomain;
import com.globaldenso.dnkr.integration.dao.WorkSortDao;

/**
 * [KO] 업무분류 관리 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("workSortService")
public class WorkSortServiceImpl implements WorkSortService {
    
    /**
     * [KO] 업무분류 관리 Dao <br>
     */
    @Autowired
    private WorkSortDao workSortDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WorkSortServiceImpl() {
        // no process
    }
    
    
    /**
     * [KO] 업무분류관리 Dao의 setter 메소드
     * [EN] <br>
     * [JP] <br>
     * 
     * @param workSortDao 'WorkSortDao'
     */
    public void setWorkSortDao(WorkSortDao workSortDao) {
        this.workSortDao = workSortDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#searchByKey(WorkSortDomain)
     */
    public WorkSortDomain searchByKey(WorkSortDomain domain) throws ApplicationException {
        return workSortDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#searchByCondition(WorkSortDomain)
     */
    public List<WorkSortDomain> searchByCondition(WorkSortDomain domain) throws ApplicationException {
        return workSortDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#searchByConditionForPaging(WorkSortDomain)
     */
    public List<WorkSortDomain> searchByConditionForPaging(WorkSortDomain domain) throws ApplicationException {
        return workSortDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#searchWorkConfirm(WorkSortDomain)
     */
    public WorkSortDomain searchWorkConfirm(WorkSortDomain domain) throws ApplicationException {
        return workSortDao.searchWorkConfirm(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.EmpService#searchMaxWorkCodeNum(WorkSortDomain)
     */
    public String searchMaxWorkCodeNum(WorkSortDomain domain) throws ApplicationException {
        return workSortDao.searchMaxWorkCodeNum(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#searchWorkConfirmList(WorkSortDomain)
     */
    public List<WorkSortDomain> searchWorkConfirmList(WorkSortDomain domain) throws ApplicationException {
        return workSortDao.searchWorkConfirmList(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#searchCount(WorkSortDomain)
     */
    public int searchCount(WorkSortDomain domain) throws ApplicationException {
        return workSortDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#create(WorkSortDomain)
     */
    public void create(WorkSortDomain domain) throws ApplicationException {
        try {
            workSortDao.create(domain);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.employee"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#update(WorkSortDomain)
     */
    public int update(WorkSortDomain domain) throws ApplicationException {
        return workSortDao.update(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#createSetAprvEmp(WorkSortDomain)
     */
    public void createSetAprvEmp(WorkSortDomain domain) throws ApplicationException {
        try {
            workSortDao.createSetAprvEmp(domain);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.employee"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#updateSetAprvEmp(WorkSortDomain)
     */
    public int updateSetAprvEmp(WorkSortDomain domain) throws ApplicationException {
        return workSortDao.updateSetAprvEmp(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#deleteAprvEmp(WorkSortDomain)
     */
    public int deleteAprvEmp(WorkSortDomain domain) throws ApplicationException {
        return workSortDao.deleteAprvEmp(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#delete(WorkSortDomain)
     */
    public int delete(WorkSortDomain domain) throws ApplicationException {
        return workSortDao.delete(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#delete(List)
     */
    public int delete(List<WorkSortDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (WorkSortDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }
}
