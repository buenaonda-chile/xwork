package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.BatchHistDomain;
import com.globaldenso.dnkr.integration.dao.BatchHistDao;

/**
* [KR] 배치실행이력 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("batchHistService")
public class BatchHistServiceImpl implements BatchHistService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of BatchHistDao.<br>
     */
    @Autowired
    private BatchHistDao batchHistDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public BatchHistServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set BatchHistDao.<br>
     * [JP] <br>
     * 
     * @param batchHistDao 'BatchHistDao' class
     */
    public void setBatchHistDao(BatchHistDao batchHistDao) {
        this.batchHistDao = batchHistDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.BatchHistService#searchByCondition(BatchHistDomain)
     */
    public List<BatchHistDomain> searchByCondition(BatchHistDomain domain) throws ApplicationException {
        return batchHistDao.searchByCondition(domain);
    }
}
