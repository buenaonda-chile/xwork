package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.FileUploadParameterMstDomain;

/**
 * [KR] 파일업로드파라메터관리 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface FileUploadParameterMstService {

    /**
    * [KO] 기본키로  DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'FileUploadParameterMstDomain' class
    * @return 'FileUploadParameterMstDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public FileUploadParameterMstDomain searchByKey(FileUploadParameterMstDomain domain) throws ApplicationException;

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'FileUploadParameterMstDomain' class
     * @return List of 'FileUploadParameterMstDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<FileUploadParameterMstDomain> searchByCondition(FileUploadParameterMstDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'FileUploadParameterMstDomain' class
     * @return List of 'FileUploadParameterMstDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<FileUploadParameterMstDomain> searchByConditionForPaging(FileUploadParameterMstDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'FileUploadParameterMstDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(FileUploadParameterMstDomain domain) throws ApplicationException;
    
    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'FileUploadParameterMstDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount2(FileUploadParameterMstDomain domain) throws ApplicationException;
    
    /**
     * [KO] 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in table.<br>
     * [JP] <br>
     * 
     * @param domain 'FileUploadParameterMstDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(FileUploadParameterMstDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 데이터 수정하기<br>
     * [EN] Update a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'FileUploadParameterMstDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(FileUploadParameterMstDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'FileUploadParameterMstDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(FileUploadParameterMstDomain domain) throws ApplicationException;

    
    /**
     * [KO] 기본키로 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domainList List of 'FileUploadParameterMstDomain' class
     * @return Count of the deleted records
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(List<FileUploadParameterMstDomain> domainList) throws ApplicationException;
}
