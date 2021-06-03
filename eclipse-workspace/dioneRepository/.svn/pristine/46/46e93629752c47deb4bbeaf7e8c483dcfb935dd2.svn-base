package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.ContractDomain;
import com.globaldenso.dnkr.integration.dao.ContractDao;

/**
 * [KR] 수주업로드 서비스 구현 <br>
 * [EN] Service implementation of contract information.
 * [JP] 
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("ContractService")
public class ContractServiceImpl implements ContractService {

    /**
     * [KR] 수주업로드 Dao <br>
     * [EN] A field of ContractDao.<br>
     * [JP] ContractDaoのフィールド。<br>
     */
    @Autowired
    private ContractDao ContractDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public ContractServiceImpl() {
        // no process
    }
    
    /**
     * [KO] 수주업로드 Dao 의 setter 메소드
     * [EN] Set DAO of contract information.<br>
     * [JP] 。<br>
     *
     * @param contractDao 'contractDao' class 
     */
    public void setContractDao(ContractDao contractDao) {
        this.ContractDao = contractDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ContractService#searchByCondition(ContractDomain)
     */
    @Override
    public List<ContractDomain> searchByCondition(ContractDomain domain) throws ApplicationException {
        return ContractDao.searchByCondition(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ContractService#create(ContractDomain)
     */
    public void create(ContractDomain domain) throws ApplicationException {
        try {
            ContractDao.create(domain);
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
     * @see com.globaldenso.dnkr.business.service.ContractService#delete(ContractDomain)
     */
    public int delete(ContractDomain domain) throws ApplicationException {
        
        return ContractDao.delete(domain);
    }
    
}
