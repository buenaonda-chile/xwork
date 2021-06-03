package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.DuplTypeOrderCodeMstDomain;

/**
 * [KR] 중복차종서열코드마스타 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface DuplTypeOrderCodeMstService {

    /**
    * [KO] 기본키로  DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'DuplTypeOrderCodeMstDomain' class
    * @return 'DuplTypeOrderCodeMstDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public DuplTypeOrderCodeMstDomain searchByKey(DuplTypeOrderCodeMstDomain domain) throws ApplicationException;

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'DuplTypeOrderCodeMstDomain' class
     * @return List of 'DuplTypeOrderCodeMstDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<DuplTypeOrderCodeMstDomain> searchByCondition(DuplTypeOrderCodeMstDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'DuplTypeOrderCodeMstDomain' class
     * @return List of 'DuplTypeOrderCodeMstDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<DuplTypeOrderCodeMstDomain> searchByConditionForPaging(DuplTypeOrderCodeMstDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'DuplTypeOrderCodeMstDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(DuplTypeOrderCodeMstDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'DuplTypeOrderCodeMstDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount2(DuplTypeOrderCodeMstDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'DuplTypeOrderCodeMstDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCountSVM100(DuplTypeOrderCodeMstDomain domain) throws ApplicationException;
    
    /**
     * [KO] 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in table.<br>
     * [JP] <br>
     * 
     * @param domain 'DuplTypeOrderCodeMstDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(DuplTypeOrderCodeMstDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 데이터 수정하기<br>
     * [EN] Update a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'DuplTypeOrderCodeMstDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(DuplTypeOrderCodeMstDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'DuplTypeOrderCodeMstDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(DuplTypeOrderCodeMstDomain domain) throws ApplicationException;

    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domainList List of 'DuplTypeOrderCodeMstDomain' class
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(List<DuplTypeOrderCodeMstDomain> domainList) throws ApplicationException;
}
