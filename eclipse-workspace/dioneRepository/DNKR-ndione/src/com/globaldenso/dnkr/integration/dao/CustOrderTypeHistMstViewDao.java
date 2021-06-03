package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CustOrderTypeHistMstViewDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface CustOrderTypeHistMstViewDao {

    /**
     * [KO] 기본키로  DB table 에서 정보를 검색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'CustOrderTypeHistMstViewDomain' class
     * @return 'CustOrderTypeHistMstViewDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public CustOrderTypeHistMstViewDomain searchByKey(CustOrderTypeHistMstViewDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'CustOrderTypeHistMstViewDomain' class
     * @return List of 'CustOrderTypeHistMstViewDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<CustOrderTypeHistMstViewDomain> searchByCondition(CustOrderTypeHistMstViewDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'CustOrderTypeHistMstViewDomain' class
     * @return List of 'CustOrderTypeHistMstViewDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<CustOrderTypeHistMstViewDomain> searchByConditionForPaging(CustOrderTypeHistMstViewDomain domain) throws ApplicationException;
}
