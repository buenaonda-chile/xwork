package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.SalPlnPerfmncMtReprtPptDomain;

/**
 * [KR]  
 *
 * @author K-DATALAB
 * @version 1.0
 */
 
public interface SalPlnPerfmncMtReprtPptService {
	
	/**
    * [KO] 기본키로  DB table 에서 정보를 검색하고 결과를 반환한다.<br>
    * [EN] <br>
    * [JP] <br>
    * 
    * @param domain 'SalPlnPerfmncMtReprtPptDomain' class
    * @return 'SalPlnPerfmncMtReprtPptDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
	public SalPlnPerfmncMtReprtPptDomain searchByKey(SalPlnPerfmncMtReprtPptDomain domain) throws ApplicationException;
	
	
	/**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SalPlnPerfmncMtReprtPptDomain' class
     * @return List of 'SalPlnPerfmncMtReprtPptDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
	public List<SalPlnPerfmncMtReprtPptDomain> searchByMaker(SalPlnPerfmncMtReprtPptDomain domain) throws ApplicationException;
	
	public List<SalPlnPerfmncMtReprtPptDomain> searchByMakerComps(SalPlnPerfmncMtReprtPptDomain domain) throws ApplicationException;
	
	public List<SalPlnPerfmncMtReprtPptDomain> searchByMakerCompsSum(SalPlnPerfmncMtReprtPptDomain domain) throws ApplicationException;
	
	public List<SalPlnPerfmncMtReprtPptDomain> searchByITME(SalPlnPerfmncMtReprtPptDomain domain) throws ApplicationException;
	
	public List<SalPlnPerfmncMtReprtPptDomain> searchByITMEComps(SalPlnPerfmncMtReprtPptDomain domain) throws ApplicationException;
	
	public List<SalPlnPerfmncMtReprtPptDomain> searchByITMECompsSum(SalPlnPerfmncMtReprtPptDomain domain) throws ApplicationException;

	

	
	
}
