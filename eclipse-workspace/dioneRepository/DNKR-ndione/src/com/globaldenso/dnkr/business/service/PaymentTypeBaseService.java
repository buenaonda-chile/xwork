package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PaymentTypeBaseDomain;

/**
 * [KR]  
 *
 * @author K-DATALAB
 * @version 1.0
 */
 
public interface PaymentTypeBaseService {
	
	/**
    * [KO] 기본키로  DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'PaymentTypeBaseDomain' class
    * @return 'PaymentTypeBaseDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
	public PaymentTypeBaseDomain searchByKey(PaymentTypeBaseDomain domain) throws ApplicationException;
	
	
	/**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PaymentTypeBaseDomain' class
     * @return List of 'PaymentTypeBaseDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<PaymentTypeBaseDomain> searchByCondition(PaymentTypeBaseDomain domain) throws ApplicationException;
	
	/**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PaymentTypeBaseDomain' class
     * @return List of 'PaymentTypeBaseDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<PaymentTypeBaseDomain> searchByConditionForPaging(PaymentTypeBaseDomain domain) throws ApplicationException;
	
	/**
     * [KO] 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in table.<br>
     * [JP] <br>
     * 
     * @param domain 'PaymentTypeBaseDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */	  	
	public int searchCount(PaymentTypeBaseDomain domain) throws ApplicationException;
	
	public int searchCount2(PaymentTypeBaseDomain domain) throws ApplicationException;
	/**
     * [KO] 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in table.<br>
     * [JP] <br>
     * 
     * @param domain 'PaymentTypeBaseDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */	  	
	public void create(PaymentTypeBaseDomain domain) throws ApplicationException;
	
	/**
     * [KO] 기본키로 테이블의 데이터 수정하기<br>
     * [EN] Update a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'PaymentTypeBaseDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public int update(PaymentTypeBaseDomain domain) throws ApplicationException;
	
	
	/**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'PaymentTypeBaseDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public int delete(PaymentTypeBaseDomain domain) throws ApplicationException;
	
}
