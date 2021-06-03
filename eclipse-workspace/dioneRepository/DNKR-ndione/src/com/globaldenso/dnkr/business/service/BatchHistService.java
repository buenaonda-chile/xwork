package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.BatchHistDomain;

/**
 * [KR] 배치실행이력 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface BatchHistService {

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'BatchHistDomain' class
     * @return List of 'BatchHistDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<BatchHistDomain> searchByCondition(BatchHistDomain domain) throws ApplicationException;
 

}
