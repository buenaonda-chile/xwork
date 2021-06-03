package com.globaldenso.dnkr.integration.dao.db2;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.PsogmMonPerformDb2Domain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PsogmMonPerformDao {

    /**
     * [KO] 기본키로 DB 테이블에서 권한 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search auth information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmMonPerformDb2Domain> selectOgm401(PsogmMonPerformDb2Domain domain) throws ApplicationException;
    
//    /**
//     * [KO] 기본키로 DB 테이블에서 설비 정보를 탐색하고 결과를 반환한다.<br>
//     * [EN] Search auth information from DB table by the primary key, and return the search results.<br>
//     * [JP] <br>
//     * 
//     * @param domain 'MachineDb2Domain' class
//     * @return 'MachineDb2Domain' class
//     * @throws ApplicationException Application exception of 'Application Infrastructure'
//     */
//    public List<MachineDb2Domain> selectOgm200_pop(MachineDb2Domain domain) throws ApplicationException;
//    
//    /**
//     * [KO] 사업부 코드와 설비번호로  DB table 에서 설비 정보를 검색하고 결과를 반환한다<br>
//     * [EN] Search auth information from DB table by the primary key, and return the search results.<br>
//     * [JP] <br>
//     * 
//     * @param domain 'MachineDb2Domain' class
//     * @return 'MachineDb2Domain' class
//     * @throws ApplicationException Application exception of 'Application Infrastructure'
//     */
//    public MachineDb2Domain selectOGM200_chk(MachineDb2Domain domain) throws ApplicationException;
}
