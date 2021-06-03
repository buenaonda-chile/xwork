package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.LogDomain;

/**
 * [KR] 로그관리 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface LogService {
    /**
     * [EN] Search Log information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'LogDomain' class
     * @return 'LogDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public LogDomain searchByKey(LogDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search Log information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'LogDomain' class
     * @return List of 'LogDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<LogDomain> searchByCondition(LogDomain domain) throws ApplicationException;
    
    /**
     * [EN] (For paging processing) Search Log information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'LogDomain' class
     * @return List of 'LogDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<LogDomain> searchByConditionForPaging(LogDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search Log information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] <br>
     * 
     * @param domain 'LogDomain' class
     * @return int Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(LogDomain domain) throws ApplicationException;
    
    /**
     * [EN] Create a record in Log information table.<br>
     * [JP] <br>
     * 
     * @param domain 'LogDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(LogDomain domain) throws ApplicationException;
    
    
}
