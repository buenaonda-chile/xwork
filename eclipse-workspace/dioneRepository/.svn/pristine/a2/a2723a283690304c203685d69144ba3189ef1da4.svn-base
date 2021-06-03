package com.globaldenso.dnkr.business.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.KiaHyundaiVANCompanyCodeMstDomain;
import com.globaldenso.dnkr.domain.NonOrderHostUpDomain;
import com.globaldenso.dnkr.domain.OrderDayTransferWorkDomain;
import com.globaldenso.dnkr.domain.OrderTransferMngDomain;
import com.globaldenso.dnkr.integration.dao.OrderDayTransferWorkDao;

/**
* [KR] 서열형 일일 수주이관 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("orderDayTransferWorkService")
public class OrderDayTransferWorkServiceImpl implements OrderDayTransferWorkService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of OrderDayTransferWorkDao.<br>
     */
    @Autowired
    private OrderDayTransferWorkDao orderDayTransferWorkDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public OrderDayTransferWorkServiceImpl() {
        // no process
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayTransferWorkService#searchCigmaDate(OrderDayTransferWorkDomain)
     */
    public List<OrderDayTransferWorkDomain> searchCigmaDate(OrderDayTransferWorkDomain domain) throws ApplicationException {
        return orderDayTransferWorkDao.searchCigmaDate(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayTransferWorkService#countMST040PF(OrderDayTransferWorkDomain)
     */
    public int countMST040PF(OrderDayTransferWorkDomain domain) throws ApplicationException {
        return orderDayTransferWorkDao.countMST040PF(domain);
    }
    
    public boolean procTrans(HashMap parm) throws ApplicationException {
    	return orderDayTransferWorkDao.procTrans(parm);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayTransferWorkService#countHISTORY(OrderDayTransferWorkDomain)
     */
    public int countHISTORY(OrderDayTransferWorkDomain domain) throws ApplicationException {
        return orderDayTransferWorkDao.countHISTORY(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayTransferWorkService#deleteHISTORY(OrderDayTransferWorkDomain)
     */
    public int deleteHISTORY(OrderDayTransferWorkDomain domain) throws ApplicationException {
    	return orderDayTransferWorkDao.deleteHISTORY(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayTransferWorkService#createHISTORY(OrderDayTransferWorkDomain)
     */
    public void createHISTORY(OrderDayTransferWorkDomain domain) throws ApplicationException {
        try {
        	orderDayTransferWorkDao.createHISTORY(domain);
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
     * @see com.globaldenso.dnkr.business.service.OrderDayTransferWorkService#cigmaDataSearch(OrderDayTransferWorkDomain)
     */
    public List<OrderDayTransferWorkDomain> cigmaDataSearch(OrderDayTransferWorkDomain domain) throws ApplicationException {
        return orderDayTransferWorkDao.cigmaDataSearch(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayTransferWorkService#selectSVZ600PF(OrderDayTransferWorkDomain)
     */
    public List<NonOrderHostUpDomain> selectSVZ600PF(OrderDayTransferWorkDomain domain) throws ApplicationException {
        return orderDayTransferWorkDao.selectSVZ600PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayTransferWorkService#selectSVZ600PF_2(OrderDayTransferWorkDomain)
     */
    public List<NonOrderHostUpDomain> selectSVZ600PF_2(OrderDayTransferWorkDomain domain) throws ApplicationException {
        return orderDayTransferWorkDao.selectSVZ600PF_2(domain);
    }

    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayTransferWorkService#searchSVZ613PF(OrderTransferMngDomain)
     */
    public int searchSVZ613PF(OrderTransferMngDomain domain) throws ApplicationException {
        return orderDayTransferWorkDao.searchSVZ613PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayTransferWorkService#updateSVZ613PF(OrderTransferMngDomain)
     */
    public int updateSVZ613PF(OrderTransferMngDomain domain) throws ApplicationException {
    	return orderDayTransferWorkDao.updateSVZ613PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.OrderDayTransferWorkService#createSVZ613PF(OrderTransferMngDomain)
     */
    public void createSVZ613PF(OrderTransferMngDomain domain) throws ApplicationException {
        try {
        	orderDayTransferWorkDao.createSVZ613PF(domain);
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
    

    
}
