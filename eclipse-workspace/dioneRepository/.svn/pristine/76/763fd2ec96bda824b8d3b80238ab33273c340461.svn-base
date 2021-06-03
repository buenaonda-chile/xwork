package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.OrderHostUpDomain;
import com.globaldenso.dnkr.integration.dao.OrderHostUpDao;

/**
* [KR] 서열형 HOST UP 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("orderHostUpService")
public class OrderHostUpServiceImpl implements OrderHostUpService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of OrderHostUpDao.<br>
     */
    @Autowired
    private OrderHostUpDao orderHostUpDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public OrderHostUpServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set OrderHostUpDao.<br>
     * [JP] <br>
     * 
     * @param HostUpDao 'OrderHostUpDao' class
     */
    public void setOrderHostUpDao(OrderHostUpDao orderHostUpDao) {
        this.orderHostUpDao = orderHostUpDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#selectSVM020PF(OrderHostUpDomain)
     */
    public OrderHostUpDomain selectSVM020PF(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.selectSVM020PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#selectSVZ080PF(OrderHostUpDomain)
     */
    public OrderHostUpDomain selectSVZ080PF(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.selectSVZ080PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#selectSVM100PF(OrderHostUpDomain)
     */
    public List<OrderHostUpDomain> selectSVM100PF(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.selectSVM100PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#selectSVM300PF(OrderHostUpDomain)
     */
    public OrderHostUpDomain selectSVM300PF(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.selectSVM300PF(domain);
    }


    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#countSVH310PF_Temp(OrderHostUpDomain)
     */
    public int countSVH310PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.countSVH310PF_Temp(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#deleteSVH310PF_Temp(OrderHostUpDomain)
     */
    public int deleteSVH310PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
    	return orderHostUpDao.deleteSVH310PF_Temp(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#createSVH310PF_Temp(OrderHostUpDomain)
     */
    public void createSVH310PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
        try {
        	orderHostUpDao.createSVH310PF_Temp(domain);
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
     * @see com.globaldenso.dnkr.business.service.HostUpService#selectSVH310PF_Temp(OrderHostUpDomain)
     */
    public List<OrderHostUpDomain> selectSVH310PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.selectSVH310PF_Temp(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#selectSVH310PF_TempSum(OrderHostUpDomain)
     */
    public OrderHostUpDomain selectSVH310PF_TempSum(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.selectSVH310PF_TempSum(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#countSVH310PF1(OrderHostUpDomain)
     */
    public int countSVH310PF1(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.countSVH310PF1(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#deleteSVH310PF(OrderHostUpDomain)
     */
    public int deleteSVH310PF(OrderHostUpDomain domain) throws ApplicationException {
    	return orderHostUpDao.deleteSVH310PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#countSVH310PF2(OrderHostUpDomain)
     */
    public int countSVH310PF2(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.countSVH310PF2(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#createSVH310PF(OrderHostUpDomain)
     */
    public void createSVH310PF(OrderHostUpDomain domain) throws ApplicationException {
        try {
        	orderHostUpDao.createSVH310PF(domain);
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
     * @see com.globaldenso.dnkr.business.service.HostUpService#createSVH310PF_ADD(OrderHostUpDomain)
     */
    public void createSVH310PF_ADD(OrderHostUpDomain domain) throws ApplicationException {
        try {
        	orderHostUpDao.createSVH310PF_ADD(domain);
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
     * @see com.globaldenso.dnkr.business.service.HostUpService#countSVH320PF_Temp(OrderHostUpDomain)
     */
    public int countSVH320PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.countSVH320PF_Temp(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#deleteSVH320PF_Temp(OrderHostUpDomain)
     */
    public int deleteSVH320PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
    	return orderHostUpDao.deleteSVH320PF_Temp(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#createSVH320PF_Temp(OrderHostUpDomain)
     */
    public void createSVH320PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
        try {
        	orderHostUpDao.createSVH320PF_Temp(domain);
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
     * @see com.globaldenso.dnkr.business.service.HostUpService#selectSVH320PF_Temp(OrderHostUpDomain)
     */
    public List<OrderHostUpDomain> selectSVH320PF_Temp(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.selectSVH320PF_Temp(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#selectSVH320PF_TempSum(OrderHostUpDomain)
     */
    public OrderHostUpDomain selectSVH320PF_TempSum(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.selectSVH320PF_TempSum(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#countSVH320PF1(OrderHostUpDomain)
     */
    public int countSVH320PF1(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.countSVH320PF1(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#deleteSVH320PF(OrderHostUpDomain)
     */
    public int deleteSVH320PF(OrderHostUpDomain domain) throws ApplicationException {
    	return orderHostUpDao.deleteSVH320PF(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#countSVH320PF2(OrderHostUpDomain)
     */
    public int countSVH320PF2(OrderHostUpDomain domain) throws ApplicationException {
        return orderHostUpDao.countSVH320PF2(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.HostUpService#createSVH320PF(OrderHostUpDomain)
     */
    public void createSVH320PF(OrderHostUpDomain domain) throws ApplicationException {
        try {
        	orderHostUpDao.createSVH320PF(domain);
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
     * @see com.globaldenso.dnkr.business.service.HostUpService#createSVH320PF_ADD(OrderHostUpDomain)
     */
    public void createSVH320PF_ADD(OrderHostUpDomain domain) throws ApplicationException {
        try {
        	orderHostUpDao.createSVH320PF_ADD(domain);
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
