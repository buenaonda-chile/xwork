package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.BkmkDomain;

/**
 * [KO] 공통코드 정보의 DAO interface.<br>
 * [EN] DAO interface of Common code information.<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface BkmkDao {

    /**
     * [KO] 기본키로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search Common code information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'BkmkDomain' class
     * @return 'BkmkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public BkmkDomain searchByKey(BkmkDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Common code information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'BkmkDomain' class
     * @return List of 'BkmkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<BkmkDomain> searchByCondition(BkmkDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] Search Common code information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] <br>
     * 
     * @param domain 'BkmkDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int bkmkCount(BkmkDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] Search Common code information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] <br>
     * 
     * @param domain 'BkmkDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(BkmkDomain domain) throws ApplicationException;
    
    /**
     * [KO] 공통코드 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in Common code information table.<br>
     * [JP] <br>
     * 
     * @param domain 'BkmkDomain' class, langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(BkmkDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 공통코드 테이블의 데이터 수정하기.<br>
     * [EN] Update a record in Common code information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'BkmkDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(BkmkDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 공통코드 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in common code information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'CommonBkmkDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(BkmkDomain domain) throws ApplicationException;
    
    
}
