package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CustOrderDataMngDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface CustomerOrderDao {

    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'CustOrderDataMngDomain' class
     * @return List of 'CustOrderDataMngDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<CustOrderDataMngDomain> searchByCustOrderDataMng(CustOrderDataMngDomain domain)  throws ApplicationException;
   
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'CustOrderDataMngDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCountCustOrderDataMng(CustOrderDataMngDomain domain) throws ApplicationException;
     
    /**
     * [KO] 기본키로 테이블의 데이터 수정하기<br>
     * [EN] Update a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'CustOrderDataMngDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateCustOrderDataMng(CustOrderDataMngDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'CustOrderDataMngDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteCustOrderDataMng(CustOrderDataMngDomain domain) throws ApplicationException;
    
}
