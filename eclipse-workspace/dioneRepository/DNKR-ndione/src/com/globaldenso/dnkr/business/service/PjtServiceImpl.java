package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.PjtDomain;
import com.globaldenso.dnkr.integration.dao.PjtDao;

/**
 * [KR] 프로젝트 관리 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("pjtService")
public class PjtServiceImpl implements PjtService {
    
    /**
     * [KO] 프로젝트 관리 Dao <br>
     */
    @Autowired
    private PjtDao pjtDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PjtServiceImpl() {
        // no process
    }
    
    
    /**
     * [KO] 업무분류관리 Dao의 setter 메소드
     * [EN] <br>
     * [JP] <br>
     * 
     * @param pjtDao 'PjtDao'
     */
    public void setPjtDao(PjtDao pjtDao) {
        this.pjtDao = pjtDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#searchByKey(PjtDomain)
     */
    public PjtDomain searchByKey(PjtDomain domain) throws ApplicationException {
        return pjtDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#searchByCondition(PjtDomain)
     */
    public List<PjtDomain> searchByCondition(PjtDomain domain) throws ApplicationException {
        return pjtDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#relSysList(PjtDomain)
     */
    public List<String> relSysList(PjtDomain domain) throws ApplicationException {
        return pjtDao.relSysList(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#searchPjtRegStatus(PjtDomain)
     */
    public List<PjtDomain> searchPjtRegStatus(PjtDomain domain) throws ApplicationException {
        return pjtDao.searchPjtRegStatus(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#searchByConditionForPaging(PjtDomain)
     */
    public List<PjtDomain> searchByConditionForPaging(PjtDomain domain) throws ApplicationException {
        return pjtDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.EmpService#searchMaxWorkCodeNum(PjtDomain)
     */
    public int searchMaxPjtNum(PjtDomain domain) throws ApplicationException {
        return pjtDao.searchMaxPjtNum(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#searchCount(PjtDomain)
     */
    public int searchCount(PjtDomain domain) throws ApplicationException {
        return pjtDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#create(PjtDomain)
     */
    public void create(PjtDomain domain) throws ApplicationException {
        try {
            pjtDao.create(domain);
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
     * @see com.globaldenso.dnkr.business.service.WorkSortService#update(PjtDomain)
     */
    public int update(PjtDomain domain) throws ApplicationException {
        return pjtDao.update(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#delete(PjtDomain)
     */
    public int delete(PjtDomain domain) throws ApplicationException {
        return pjtDao.delete(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.WorkSortService#delete(List)
     */
    public int delete(List<PjtDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (PjtDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }
}
