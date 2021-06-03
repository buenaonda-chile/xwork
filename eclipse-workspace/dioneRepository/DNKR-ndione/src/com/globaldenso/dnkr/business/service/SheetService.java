package com.globaldenso.dnkr.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.SheetDomain;

/**
 * [KR] 과부족시트 서비스 인터페이스.<br>
 * [EN] Service interface of Common code information.<br>
 * [JP] 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface SheetService {

    /**
     * [KO] 과부족시트 테이블에 데이터를 추가한다.<br>
     * [EN] Create a record in Common code information table.<br>
     * [JP] <br>
     * 
     * @param domain 'SheetDomain' class, langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(SheetDomain domain) throws ApplicationException;
    
    /**
     * [KO] 과부족시트 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in sheet information table 
     * with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'SheetDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(SheetDomain domain) throws ApplicationException;
   
}
