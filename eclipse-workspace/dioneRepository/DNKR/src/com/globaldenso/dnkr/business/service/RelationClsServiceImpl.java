package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationDb2Domain;
import com.globaldenso.dnkr.integration.dao.RelationClsDao;

/**
 * [KR] 사업부 관리 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("relationClsService")
public class RelationClsServiceImpl implements RelationClsService {

    /**
     * [KR] 사업부 Dao 필드<br>
     * [EN] A field of RelationClsDao.<br>
     */
    @Autowired
    private RelationClsDao relationClsDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public RelationClsServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set RelationClsDao.<br>
     * [JP] <br>
     * 
     * @param relationClsDao 'RelationClsDao' class
     */
    public void setRelationClsDao(RelationClsDao relationClsDao) {
        this.relationClsDao = relationClsDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#searchByKey(RelationClsDomain)
     */
    public RelationClsDomain searchByKey(RelationClsDomain domain) throws ApplicationException {
        return relationClsDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#searchByCondition(RelationClsDomain)
     */
    public List<RelationClsDomain> searchByCondition(RelationClsDomain domain) throws ApplicationException {
        return relationClsDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#searchByConditionForPaging(RelationClsDomain)
     */
    public List<RelationClsDomain> searchByConditionForPaging(RelationClsDomain domain) throws ApplicationException {
        return relationClsDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#searchCount(RelationClsDomain)
     */
    public int searchCount(RelationClsDomain domain) throws ApplicationException {
        return relationClsDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#create(RelationClsDomain)
     */
    public void create(RelationClsDomain domain, List<String> langList) throws ApplicationException {
        try {
            relationClsDao.create(domain, langList);
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
     * @see com.globaldenso.dnkr.business.service.RelationClsService#update(RelationClsDomain)
     */
    public int update(RelationClsDomain domain) throws ApplicationException {
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
    public int updateCode(RelationClsDomain domain) throws ApplicationException {
        return relationClsDao.updateCode(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#updateName(RelationClsDomain)
     */
    public int updateName(RelationClsDomain domain) throws ApplicationException {
        return relationClsDao.updateName(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#delete(RelationClsDomain)
     */
    public int delete(RelationClsDomain domain) throws ApplicationException {
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
     * @see com.globaldenso.dnkr.business.service.RelationClsService#deleteCode(RelationClsDomain)
     */
    public int deleteCode(RelationClsDomain domain) throws ApplicationException {
        return relationClsDao.deleteCode(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#deleteName(RelationClsDomain)
     */
    public int deleteName(RelationClsDomain domain) throws ApplicationException {
        return relationClsDao.deleteName(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#delete(List)
     */
    public int delete(List<RelationClsDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (RelationClsDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }
    
    /*===================================== Db2 ==========================================*/
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#selectOgm411_cmbsel(RelationDb2Domain)
     */
    public List<RelationDb2Domain> selectOGMgauge_Mst650pf(RelationDb2Domain domain) throws ApplicationException {
        return relationClsDao.selectOGMgauge_Mst650pf(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#searchByConditionForPart(RelationDb2Domain)
     */
    public List<RelationDb2Domain> searchByConditionForPart(RelationDb2Domain domain) throws ApplicationException {
        return relationClsDao.searchByConditionForPart(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#searchByConditionForLine(RelationDb2Domain)
     */
    public List<RelationDb2Domain> searchByConditionForLine(RelationDb2Domain domain) throws ApplicationException {
        return relationClsDao.searchByConditionForLine(domain);
    }
    /*===================================== //Db2 ==========================================*/
}
