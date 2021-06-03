package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.OrderHostUpCheckListDomain;

/**
 * [KR] 서열형 HOST UP CHECK LIST 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface OrderHostUpCheckListService {

    /**
    * [KO] 기본키로  DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'OrderHostUpCheckListDomain' class
    * @return 'OrderHostUpCheckListDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public OrderHostUpCheckListDomain searchByKey(OrderHostUpCheckListDomain domain) throws ApplicationException;

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'OrderHostUpCheckListDomain' class
     * @return List of 'OrderHostUpCheckListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderHostUpCheckListDomain> searchByCondition(OrderHostUpCheckListDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'OrderHostUpCheckListDomain' class
     * @return List of 'OrderHostUpCheckListDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderHostUpCheckListDomain> searchByConditionForPaging(OrderHostUpCheckListDomain domain) throws ApplicationException;
}
