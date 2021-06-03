package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.ItemMasterDomain;
import com.globaldenso.dnkr.integration.dao.ItemMasterDao;

/**
* [KR] 품목 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("itemMasterService")
public class ItemMasterServiceImpl implements ItemMasterService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of ItemMasterDao.<br>
     */
    @Autowired
    private ItemMasterDao itemMasterDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public ItemMasterServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set ItemMasterDao.<br>
     * [JP] <br>
     * 
     * @param itemMasterDao 'ItemMasterDao' class
     */
    public void setItemMasterDao(ItemMasterDao customertDao) {
        this.itemMasterDao = itemMasterDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ItemMasterService#searchByKey(ItemMasterDomain)
     */
    public ItemMasterDomain searchByKey(ItemMasterDomain domain) throws ApplicationException {
        return itemMasterDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ItemMasterService#searchByCondition(ItemMasterDomain)
     */
    public List<ItemMasterDomain> searchByCondition(ItemMasterDomain domain) throws ApplicationException {
        return itemMasterDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.ItemMasterService#searchByConditionForPaging(ItemMasterDomain)
     */
    public List<ItemMasterDomain> searchByConditionForPaging(ItemMasterDomain domain) throws ApplicationException {
        return itemMasterDao.searchByConditionForPaging(domain);
    }
}
