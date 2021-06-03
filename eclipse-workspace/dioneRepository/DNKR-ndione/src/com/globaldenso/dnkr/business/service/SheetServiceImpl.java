package com.globaldenso.dnkr.business.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.SheetDomain;
import com.globaldenso.dnkr.integration.dao.SheetDao;

/**
 * [KR] 과부족시트 서비스 구현 <br>
 * [EN] Service implementation of Sheet information.
 * [JP] 
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("SheetService")
public class SheetServiceImpl implements SheetService {

    /**
     * [KR] 과부족시트 Dao <br>
     * [EN] A field of SheetDao.<br>
     * [JP] SheetDaoのフィールド。<br>
     */
    @Autowired
    private SheetDao sheetDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public SheetServiceImpl() {
        // no process
    }
    
    /**
     * [KO] 과부족시트 Dao 의 setter 메소드
     * [EN] Set DAO of Common code information.<br>
     * [JP] 。<br>
     *
     * @param commonCodeDao 'CommonCodeDao' class 
     */
    public void setSheetDao(SheetDao commonCodeDao) {
        this.sheetDao = commonCodeDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.SheetService#create(SheetDomain)
     */
    public void create(SheetDomain domain) throws ApplicationException {
        try {
            sheetDao.create(domain);
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
     * @see com.globaldenso.dnkr.business.service.SheetService#delete(SheetDomain)
     */
    public int delete(SheetDomain domain) throws ApplicationException {
        
        return sheetDao.delete(domain);
    }
    
}
