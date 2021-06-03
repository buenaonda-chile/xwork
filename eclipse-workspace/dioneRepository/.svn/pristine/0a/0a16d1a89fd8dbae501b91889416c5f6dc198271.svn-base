package com.globaldenso.dnkr.business.service;

import java.util.HashMap;
import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.NonOrderHostUpDomain;
import com.globaldenso.dnkr.domain.OrderDayTransferWorkDomain;
import com.globaldenso.dnkr.domain.OrderTransferMngDomain;

/**
 * [KR] 서열형 일일 수주이관 작업 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface OrderDayTransferWorkService {

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'OrderDayTransferWorkDomain' class
     * @return List of 'OrderDayTransferWorkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<OrderDayTransferWorkDomain> searchCigmaDate(OrderDayTransferWorkDomain domain) throws ApplicationException;
    
    /**
    * [KO] DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'OrderDayTransferWorkDomain' class
    * @return 'OrderDayTransferWorkDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int countMST040PF(OrderDayTransferWorkDomain domain) throws ApplicationException;
    
    public boolean procTrans(HashMap parm) throws ApplicationException;
    
    /**
    * [KO] DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'OrderDayTransferWorkDomain' class
    * @return 'OrderDayTransferWorkDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int countHISTORY(OrderDayTransferWorkDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDayTransferWorkDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteHISTORY(OrderDayTransferWorkDomain domain) throws ApplicationException; 
    
    /**
     * [KO] 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in table.<br>
     * [JP] <br>
     * 
     * @param domain 'OrderDayTransferWorkDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createHISTORY(OrderDayTransferWorkDomain domain) throws ApplicationException;
    
    
    public List<OrderDayTransferWorkDomain> cigmaDataSearch(OrderDayTransferWorkDomain domain) throws ApplicationException;
    
    public List<NonOrderHostUpDomain> selectSVZ600PF(OrderDayTransferWorkDomain domain) throws ApplicationException;
    
    public List<NonOrderHostUpDomain> selectSVZ600PF_2(OrderDayTransferWorkDomain domain) throws ApplicationException;
    
    
    // 수주이관처리 History - 존재체크
    public int searchSVZ613PF(OrderTransferMngDomain domain) throws ApplicationException;
    
    // 수주이관처리 History - update
    public int updateSVZ613PF(OrderTransferMngDomain domain) throws ApplicationException;
    
    // 수주이관처리 History - insert
    public void createSVZ613PF(OrderTransferMngDomain domain) throws ApplicationException;

}
