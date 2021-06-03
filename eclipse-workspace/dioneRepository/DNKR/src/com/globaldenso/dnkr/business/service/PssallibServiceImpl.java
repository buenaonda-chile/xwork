package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PssallibDomain;
import com.globaldenso.dnkr.integration.dao.PssallibDao;

/**
 * [KR] 제품출고전표 서비스 구현 <br>
 * [EN] <br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("pssallibService")
public class PssallibServiceImpl implements PssallibService{

    /**
     * [KR] 제품출고전표 관리 Dao <br>
      */
    @Autowired
    private PssallibDao pssallibDao;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PssallibServiceImpl () {
        //no process
    }

    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PssallibService#searchById(PssallibDomain)
     */
    @Override
    public List<PssallibDomain> selectSMDZ123P(PssallibDomain form)
            throws ApplicationException {
        return pssallibDao.selectSMDZ123P(form);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.PssallibService#selectSMDZ123P_CHK(PssallibDomain)
     */
    @Override
    public List<PssallibDomain> selectSMDZ123P_CHK(PssallibDomain form)
            throws ApplicationException {
        return pssallibDao.selectSMDZ123P_CHK(form);
    }
}
