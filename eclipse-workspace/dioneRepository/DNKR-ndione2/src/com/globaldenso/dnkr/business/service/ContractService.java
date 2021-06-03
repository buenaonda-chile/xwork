package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.ContractDomain;

/**
 * [KR] 수주업로드 서비스 인터페이스.<br>
 * [EN] Service interface of Contract information.<br>
 * [JP] 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface ContractService {

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Common code information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'ContractDomain' class
     * @return List of 'ContractDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<ContractDomain> searchByCondition(ContractDomain domain) throws ApplicationException;
    
    /**
     * [KO] 수주업로드 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in Contract information table.<br>
     * [JP] <br>
     * 
     * @param domain 'ContractDomain' class, langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(ContractDomain domain) throws ApplicationException;
    
    /**
     * [KO] 수주업로드 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in Contract information table 
     * with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'ContractDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(ContractDomain domain) throws ApplicationException;
   
}
