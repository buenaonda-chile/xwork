package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.SalAnlysComentDomain;
import com.globaldenso.dnkr.domain.SalAnlysViewDomain;

/**
 * [KR]  
 *
 * @author K-DATALAB
 * @version 1.0
 */
 
public interface SalAnlysViewService {
	
	/**
	    * [KO] 기본키로  DB table 에서 정보를 검색하고 결과를 반환한다.<br>
	    * [EN] <br>
	    * [JP] <br>
	    * 
	    * @param domain 'SalAnlysViewDomain' class
	    * @return 'SalAnlysViewDomain' class
	    * @throws ApplicationException Application exception of 'Application Infrastructure'
	    */
		public SalAnlysViewDomain searchByKey(SalAnlysViewDomain domain) throws ApplicationException;
		
		
		/**
	     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
	     * [EN] <br>
	     * [JP] <br>
	     * 
	     * @param domain 'SalAnlysViewDomain' class
	     * @return List of 'SalAnlysViewDomain' class
	     * @throws ApplicationException Application exception of 'Application Infrastructure'
	     */
		public List<SalAnlysViewDomain> searchByCondition(SalAnlysViewDomain domain) throws ApplicationException;
		
		/**
	     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다(페이징 처리).<br>
	     * [EN] <br>
	     * [JP] <br>
	     * 
	     * @param domain 'SalAnlysViewDomain' class
	     * @return List of 'SalAnlysViewDomain' class
	     * @throws ApplicationException Application exception of 'Application Infrastructure'
	     */
		public List<SalAnlysViewDomain> searchByConditionForPaging(SalAnlysViewDomain domain) throws ApplicationException;
	
}
