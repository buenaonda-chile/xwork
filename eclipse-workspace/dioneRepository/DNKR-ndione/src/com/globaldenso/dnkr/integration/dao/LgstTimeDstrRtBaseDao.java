package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.LgstTimeDstrRtBaseDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface LgstTimeDstrRtBaseDao {

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LgstTimeDstrRtBaseDomain' class
     * @return List of 'LgstTimeDstrRtBaseDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<LgstTimeDstrRtBaseDomain> searchByCondition(LgstTimeDstrRtBaseDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LgstTimeDstrRtBaseDomain' class
     * @return List of 'LgstTimeDstrRtBaseDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<LgstTimeDstrRtBaseDomain> searchByConditionForPaging(LgstTimeDstrRtBaseDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'LgstTimeDstrRtBaseDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(LgstTimeDstrRtBaseDomain domain) throws ApplicationException;
       

    /**
     * [KO] 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in table.<br>
     * [JP] <br>
     * 
     * @param domain 'LgstTimeDstrRtBaseDomain' class<br>
     * @param langList List<String><br> 
     * @throws ApplicationException Application exception of 'Application Infrastructure'<br>
     */
    public void create(LgstTimeDstrRtBaseDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 데이터 수정하기<br>
     * [EN] Update a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'LgstTimeDstrRtBaseDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(LgstTimeDstrRtBaseDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain of 'LgstTimeDstrRtBaseDomain' class
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(LgstTimeDstrRtBaseDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domainList List of 'LgstTimeDstrRtBaseDomain' class
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(List<LgstTimeDstrRtBaseDomain> domainList) throws ApplicationException;    
}
