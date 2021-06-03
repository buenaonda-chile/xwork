package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.LogDomain;

/**
 * [KO] 로그관리 DAO 인터페이스<br>
 * [EN] DAO interface of Log information.<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface LogDao {

    /**
     * [EN] Search log information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'LogDomain' class
     * @return 'LogDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public LogDomain searchByKey(LogDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search log information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'LogDomain' class
     * @return List of 'LogDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<LogDomain> searchByCondition(LogDomain domain) throws ApplicationException;
    
    /**
     * [EN] (For paging processing) Search log information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] <br>
     * 
     * @param domain 'LogDomain' class
     * @return List of 'LogDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<LogDomain> searchByConditionForPaging(LogDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search log information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] <br>
     * 
     * @param domain 'LogDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(LogDomain domain) throws ApplicationException;
    
    /**
     * [EN] Create a record in log information table.<br>
     * [JP] <br>
     * 
     * @param domain 'LogDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(LogDomain domain) throws ApplicationException;
    
}
