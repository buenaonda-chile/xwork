package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.json.simple.parser.ParseException;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderDomain;
import com.globaldenso.dnkr.domain.OrderQtyDomain;
import com.globaldenso.dnkr.domain.db2.OrderDb2Domain;

/**
 * [KR] 수주업로드 서비스 인터페이스.<br>
 * [EN] Service interface of Contract information.<br>
 * [JP] 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface OrderService {

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Common code information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return List of 'OrderDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderDomain> searchByCondition(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Common code information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return List of 'OrderDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderQtyDomain> searchByQtyCondition(OrderQtyDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Common code information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return List of 'OrderDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderDomain> searchByTotalCondition(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Common code information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return List of 'OrderDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderDomain> getReleaseDate(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 수주업로드 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in Contract information table.<br>
     * [JP] <br>
     * 
     * @param domainList 'OrderDomain' class
     * @param stockQry String
     * @param stockDailyQry String
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     * @throws ParseException Application exception of 'ParseException'
     * @throws java.text.ParseException Application exception of 'java.text.ParseException'
     */
    public void orderCreateAll(List<OrderDomain> domainList, String stockQry, String stockDailyQry) throws ApplicationException, ParseException, java.text.ParseException;
    
    /**
     * [KO] 수주업로드 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in Contract information table.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class, langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void orderCreate(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 수주업로드 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in Contract information table 
     * with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 수주업로드 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in Contract information table 
     * with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateQty(OrderQtyDomain domain) throws ApplicationException;
    
    /**
     * [KO] 수주업로드 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in Contract information table 
     * with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] 수주업로드 테이블의 모든 레코드를 삭제한다.<br>
     * [EN] Delete a record in Contract information table 
     * with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int allDelete(OrderDomain domain) throws ApplicationException;
    
    /**
     * [KO] DB2 테이블의 덴소넘버 레코드를 받아온다.<br>
     * [EN] Delete a record in Contract information table 
     * with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public OrderDb2Domain getDensoNumber(OrderDb2Domain domain) throws ApplicationException;
   
}
