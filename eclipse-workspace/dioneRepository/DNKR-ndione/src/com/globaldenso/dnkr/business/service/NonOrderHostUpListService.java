package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.NonOrderHostUpListDomain;

/**
 * [KR] 비서열/확정오더형 산출물 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface NonOrderHostUpListService {

    /**
    * [KO] 기본키로  DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'NonOrderHostUpListDomain' class
    * @return 'NonOrderHostUpListDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public NonOrderHostUpListDomain searchByKey(NonOrderHostUpListDomain domain) throws ApplicationException;

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'NonOrderHostUpListDomain' class
     * @return List of 'NonOrderHostUpListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<NonOrderHostUpListDomain> searchByCondition(NonOrderHostUpListDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'NonOrderHostUpListDomain' class
     * @return List of 'NonOrderHostUpListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<NonOrderHostUpListDomain> searchByConditionForPaging(NonOrderHostUpListDomain domain) throws ApplicationException;
}
