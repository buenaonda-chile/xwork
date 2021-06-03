package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PrdctSvcPsnlInputDomain;


/**
 * [KR] 생산성지표 기준정보(생산용역 인원관리) 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PrdctSvcPsnlInputService {


    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PrdctSvcPsnlInputDomain' class
     * @return List of 'PrdctSvcPsnlInputDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PrdctSvcPsnlInputDomain> searchByCondition(PrdctSvcPsnlInputDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PrdctSvcPsnlInputDomain' class
     * @return List of 'PrdctSvcPsnlInputDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PrdctSvcPsnlInputDomain> searchByConditionForPaging(PrdctSvcPsnlInputDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PrdctSvcPsnlInputDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(PrdctSvcPsnlInputDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PrdctSvcPsnlInputDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount2(PrdctSvcPsnlInputDomain domain) throws ApplicationException;
    
    
    
    /**
     * [KO] 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in table.<br>
     * [JP] <br>
     * 
     * @param domain 'PrdctSvcPsnlInputDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(PrdctSvcPsnlInputDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 데이터 수정하기<br>
     * [EN] Update a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'PrdctSvcPsnlInputDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(PrdctSvcPsnlInputDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'PrdctSvcPsnlInputDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(PrdctSvcPsnlInputDomain domain) throws ApplicationException;

    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domainList List of 'PrdctSvcPsnlInputDomain' class
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(List<PrdctSvcPsnlInputDomain> domainList) throws ApplicationException;
}
