package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderDomain;
import com.globaldenso.dnkr.domain.OrderQtyDomain;
import com.globaldenso.dnkr.domain.db2.OrderDb2Domain;

/**
 * [KO] 수주업로드 정보의 DAO interface.<br>
 * [EN] DAO interface of Contract information.<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface OrderDao {
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 갯수를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Contract information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return List of 'OrderDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 갯수를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Contract information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return List of 'OrderDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchQtyCount(OrderQtyDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Contract information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return List of 'OrderDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public OrderDomain searchById(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Contract information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return List of 'OrderDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderDomain> searchByCondition(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Contract information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return List of 'OrderDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderQtyDomain> searchByConditionQty(OrderQtyDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Contract information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return List of 'OrderDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderDomain> getReleaseDate(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Contract information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return List of 'OrderDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public String OrderNextIdx(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 수주업로드 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in Contract information table.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class, langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 수주업로드 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in Contract information table.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class, langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createQty(OrderQtyDomain domain) throws ApplicationException;
    
    /**
     * [KO] 수주업로드 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in Contract information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int orderUpdate(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 수주업로드 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in Contract information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int orderQtyUpdate(OrderQtyDomain domain) throws ApplicationException;
    
    /**
     * [KO] 수주업로드 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in Contract information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int orderDelete(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 수주업로드 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in Contract information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int qtyDelete(OrderQtyDomain domain) throws ApplicationException;
    
    /**
     * [KO] Db2 테이블 에서 덴소 번호를 받아온다.<br>
     * [EN] Delete a record in Contract information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public OrderDb2Domain getDensoNumber(OrderDb2Domain domain) throws ApplicationException;
    
}
