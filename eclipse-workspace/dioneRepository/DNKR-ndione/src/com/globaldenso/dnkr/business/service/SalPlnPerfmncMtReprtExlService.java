package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.SalPlnPerfmncMtReprtExlDomain;

/**
 * [KR]  
 *
 * @author K-DATALAB
 * @version 1.0
 */
 
public interface SalPlnPerfmncMtReprtExlService {
	
	/**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SalPlnPerfmncMtReprtExlDomain' class
     * @return List of 'SalPlnPerfmncMtReprtExlDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<SalPlnPerfmncMtReprtExlDomain> searchBySalPlnList(SalPlnPerfmncMtReprtExlDomain domain) throws ApplicationException;
	
	/**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SalPlnPerfmncMtReprtExlDomain' class
     * @return List of 'SalPlnPerfmncMtReprtExlDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<SalPlnPerfmncMtReprtExlDomain> searchByCondition(SalPlnPerfmncMtReprtExlDomain domain) throws ApplicationException;
	

	
}
