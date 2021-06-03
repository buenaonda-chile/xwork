package com.globaldenso.dnkr.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.NonOrderHostUpDomain;

/**
 * [KR] 비서열형 HOST UP 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface NonOrderHostUpService {

    /**
    * [KO] DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'NonOrderHostUpDomain' class
    * @return 'NonOrderHostUpDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public NonOrderHostUpDomain selectSVM020PF(NonOrderHostUpDomain domain) throws ApplicationException;
    
    /**
    * [KO] DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'NonOrderHostUpDomain' class
    * @return 'NonOrderHostUpDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public NonOrderHostUpDomain selectEM000PR(NonOrderHostUpDomain domain) throws ApplicationException;
    
    /**
    * [KO] DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'NonOrderHostUpDomain' class
    * @return 'NonOrderHostUpDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int countMST100PF(NonOrderHostUpDomain domain) throws ApplicationException;


    /**
    * [KO] DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'NonOrderHostUpDomain' class
    * @return 'NonOrderHostUpDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int countSVZ60PF(NonOrderHostUpDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'NonOrderHostUpDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteSVZ60PF(NonOrderHostUpDomain domain) throws ApplicationException; 
    
    /**
    * [KO] DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'NonOrderHostUpDomain' class
    * @return 'NonOrderHostUpDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public NonOrderHostUpDomain selectPERIOD(NonOrderHostUpDomain domain) throws ApplicationException;
    
    /**
     * [KO] 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in table.<br>
     * [JP] <br>
     * 
     * @param domain 'NonOrderHostUpDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createSVZ60PF(NonOrderHostUpDomain domain) throws ApplicationException;
 
    /**
     * [KO] 기본키로 테이블의 데이터 수정하기<br>
     * [EN] Update a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'NonOrderHostUpDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateSVZ602PF(NonOrderHostUpDomain domain) throws ApplicationException;
    
    /**
    * [KO] DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'NonOrderHostUpDomain' class
    * @return 'NonOrderHostUpDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int countSVZ600PF(NonOrderHostUpDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'NonOrderHostUpDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteSVZ600PF(NonOrderHostUpDomain domain) throws ApplicationException; 
    
    /**
     * [KO] 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in table.<br>
     * [JP] <br>
     * 
     * @param domain 'NonOrderHostUpDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createSVZ600PF(NonOrderHostUpDomain domain) throws ApplicationException;
    
    
    /**
    * [KO] DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'NonOrderHostUpDomain' class
    * @return 'NonOrderHostUpDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int countSVZ603PF(NonOrderHostUpDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'NonOrderHostUpDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteSVZ603PF(NonOrderHostUpDomain domain) throws ApplicationException; 
    
    /**
     * [KO] 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in table.<br>
     * [JP] <br>
     * 
     * @param domain 'NonOrderHostUpDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createSVZ603PF(NonOrderHostUpDomain domain) throws ApplicationException;
}
