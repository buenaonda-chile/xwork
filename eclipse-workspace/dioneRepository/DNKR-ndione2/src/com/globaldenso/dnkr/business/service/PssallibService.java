package com.globaldenso.dnkr.business.service;
/**
 * @author $Author$
 * @version $Revision$
 */
import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PssallibDomain;

/**
 * [KR] 제품출고전표 관리 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PssallibService {

    /**
     * [KO] 제품출고전표 리스트<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param form 'PssallibDomain' class
     * @return 'EmpDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PssallibDomain> selectSMDZ123P(PssallibDomain form) throws ApplicationException;
    
    /**
     * [KO] 전표일자별 전표번호 리스트<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param form 'PssallibDomain' class
     * @return 'EmpDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PssallibDomain> selectSMDZ123P_CHK(PssallibDomain form) throws ApplicationException;

}
