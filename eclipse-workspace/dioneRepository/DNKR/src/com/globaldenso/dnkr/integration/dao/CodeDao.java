package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;

/**
 * [KO] 공통코드 정보의 DAO interface.<br>
 * [EN] DAO interface of Common code information.<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface CodeDao {

    /**
     * [KO] 기본키로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search Common code information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return 'CodeDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public CodeDomain searchByKey(CodeDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] Search Common code information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return List of 'CodeDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<CodeDomain> searchByCondition(CodeDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] Search Common code information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(CodeDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 공통코드 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] Search Common code information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCmcCount(CodeDomain domain) throws ApplicationException;
    
    /**
     * [KO] DB 테이블에서 가장 큰 공통코드 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search max Common code information from DB table, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return Common code String
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public String searchMaxCommonCode(CodeDomain domain) throws ApplicationException;
    
    /**
     * [KO] 공통코드 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in Common code information table.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(CodeDomain domain, List<String> langList) throws ApplicationException;
    
    /**
     * [KO] 공통코드 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in Common code information table.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createCmc(CodeDomain domain) throws ApplicationException;

    /**
     * [KO] 공통코드명 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in Common code name information table.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createCnm(CodeDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 공통코드 테이블의 데이터 수정하기.<br>
     * [EN] Update a record in Common code information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(CodeDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 공통코드 테이블의 데이터 수정하기.<br>
     * [EN] Update a record in Common code information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateCmc(CodeDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 공통코드명 테이블의 데이터 수정하기.<br>
     * [EN] Update a record in Common code name information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateCnm(CodeDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 공통코드 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in common code information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'CommonCodeDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteCmc(CodeDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 공통코드명의 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in common code name information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteCnm(CodeDomain domain) throws ApplicationException;

    /*========================= DB2 ============================================*/
    /**
     * [KO] 기본키로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search Common code information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return 'CodeDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<CodeDb2Domain> comCode(CodeDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 DB 테이블에서 공통코드 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search Common code information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return 'CodeDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<CodeDb2Domain> comCodeMst050(CodeDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 JDE-F0901 DB테이블에서 공통코드 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search Common code information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return 'CodeDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<CodeDb2Domain> comCodeJdeF0901(CodeDb2Domain domain) throws ApplicationException;

    /**
     * [KO] 기본키로 JDE-F0006LB DB테이블에서 공통코드 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search Common code information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return 'CodeDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<CodeDb2Domain> comCodeJdeF0006LB(CodeDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 MST650PF(부서코드) DB테이블에서 공통코드 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search Common code information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'CodeDomain' class
     * @return 'CodeDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<CodeDb2Domain> comCodeMst650PF(CodeDb2Domain domain) throws ApplicationException;
    /*========================= DB2 ============================================*/
}
