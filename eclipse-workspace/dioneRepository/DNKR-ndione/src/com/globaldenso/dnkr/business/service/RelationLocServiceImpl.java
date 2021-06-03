package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.integration.dao.RelationLocDao;

/**
 * [KR] 사업장 관리 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("relationLocService")
public class RelationLocServiceImpl implements RelationLocService {

    /**
     * [KR] 사업장 Dao 필드<br>
     * [EN] A field of RelationLocDao.<br>
     */
    @Autowired
    private RelationLocDao relationLocDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public RelationLocServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set RelationLocDao.<br>
     * [JP] <br>
     * 
     * @param relationLocDao 'RelationLocDao' class
     */
    public void setRelationLocDao(RelationLocDao relationLocDao) {
        this.relationLocDao = relationLocDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationLocService#searchByKey(RelationLocDomain)
     */
    public RelationLocDomain searchByKey(RelationLocDomain domain) throws ApplicationException {
        return relationLocDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationLocService#searchByCondition(RelationLocDomain)
     */
    public List<RelationLocDomain> searchByCondition(RelationLocDomain domain) throws ApplicationException {
        return relationLocDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationLocService#searchByConditionForPaging(RelationLocDomain)
     */
    public List<RelationLocDomain> searchByConditionForPaging(RelationLocDomain domain) throws ApplicationException {
        return relationLocDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationLocService#searchCount(RelationClsDomain)
     */
    public int searchCount(RelationLocDomain domain) throws ApplicationException {
        return relationLocDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#searchCmcCount(CodeDomain)
     */
    public int searchLocCount(RelationLocDomain domain) throws ApplicationException {
        return relationLocDao.searchLocCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationLocService#create(RelationClsDomain)
     */
    public void create(RelationLocDomain domain, List<String> langList) throws ApplicationException {
        try {
            relationLocDao.create(domain, langList);
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
     * @see com.globaldenso.dnkr.business.service.RelationLocService#update(RelationLocDomain)
     */
    public int update(RelationLocDomain domain) throws ApplicationException {
        int upResult = 0;
        upResult += updateCode(domain);
        upResult += updateName(domain);
        return upResult;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#updateCode(RelationClsDomain)
     */
    public int updateCode(RelationLocDomain domain) throws ApplicationException {
        return relationLocDao.updateCode(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#updateName(RelationClsDomain)
     */
    public int updateName(RelationLocDomain domain) throws ApplicationException {
        return relationLocDao.updateName(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationLocService#delete(RelationLocDomain)
     */
    public int delete(RelationLocDomain domain) throws ApplicationException {
        int delResult = 0;
        //조직도 명칭 삭제
        delResult += deleteName(domain);
                
        //조직도 삭제
        delResult += deleteCode(domain);
        
        return delResult;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationLocService#deleteCode(RelationLocDomain)
     */
    public int deleteCode(RelationLocDomain domain) throws ApplicationException {
        return relationLocDao.deleteCode(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationLocService#deleteName(RelationLocDomain)
     */
    public int deleteName(RelationLocDomain domain) throws ApplicationException {
        return relationLocDao.deleteName(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationLocService#delete(List)
     */
    public int delete(List<RelationLocDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (RelationLocDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }
}
