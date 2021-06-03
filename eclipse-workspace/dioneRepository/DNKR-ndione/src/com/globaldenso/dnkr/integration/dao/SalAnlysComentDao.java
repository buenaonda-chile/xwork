package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.SalAnlysComentDomain;

/**
 * 
 *
 * @author K-DATALAB
 * @version 1.0
 */
public interface SalAnlysComentDao {

    /**
     * [KO] 기본키로  DB table 에서 정보를 검색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SalAnlysComentDomain' class
     * @return 'SalAnlysComentDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public SalAnlysComentDomain searchByKey(SalAnlysComentDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SalAnlysComentDomain' class
     * @return List of 'SalAnlysComentDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<SalAnlysComentDomain> searchByCondition(SalAnlysComentDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SalAnlysComentDomain' class
     * @return List of 'SalAnlysComentDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<SalAnlysComentDomain> searchByConditionForPaging(SalAnlysComentDomain domain) throws ApplicationException;
    
    
    /**
     * [KO] 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in table.<br>
     * [JP] <br>
     * 
     * @param domain 'SalAnlysComentDomain' class<br>
     * @param langList List<String><br> 
     * @throws ApplicationException Application exception of 'Application Infrastructure'<br>
     */
    public void create(SalAnlysComentDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 데이터 수정하기<br>
     * [EN] Update a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'SalAnlysComentDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(SalAnlysComentDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain of 'SalAnlysComentDomain' class
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(SalAnlysComentDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SalAnlysComentDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(SalAnlysComentDomain domain) throws ApplicationException;
    public int searchCount2(SalAnlysComentDomain domain) throws ApplicationException;
}
