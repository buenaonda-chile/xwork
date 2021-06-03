package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PssallibDomain;

/**
 * [EN] DAO interface of PssallibDao.<br>
 * [JP] 社員情報のDAOインタフェース。<br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PssallibDao {

    /**
     * [KO] 제품출고전표 리스트<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param form 'PssallibDomain' class
     * @return 'PssallibDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PssallibDomain> selectSMDZ123P(PssallibDomain form) throws ApplicationException;
    
    /**
     * [KO] 전표일자별 전표번호 리스트<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param form PssallibDomain
     * @return PssallibDomain List
     * @throws ApplicationException Exception
     */
    public List<PssallibDomain> selectSMDZ123P_CHK(PssallibDomain form) throws ApplicationException;

}
