package com.globaldenso.dnkr.integration.dao.db2;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.PsogmImprvDDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PsogmImprvDDao {
    /**
     * [KO] 기본키로 DB 테이블에서 개선상세 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmImprvDDb2Domain' class
     * @return 'PsogmImprvDDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public PsogmImprvDDomain selectOgm204_obj210pf_01(PsogmImprvDDomain domain) throws ApplicationException;    
    
    /**
     * [KO] 기본키로 DB 테이블에서 개선상세 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmImprvDDb2Domain' class
     * @return 'PsogmImprvDDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public PsogmImprvDDomain selectOgm220_rep(PsogmImprvDDomain domain) throws ApplicationException;    
    
    /**
     * [KO] 개선상세 정보 테이블에 레코드를 등록한다.<br>
     * [EN] Create a record in improvement detail information table.<br>
     * [JP] <br>
     * 
     * @param domain 'PsogmImprvDDomain' class
     * @return int int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int insertOgm204_obj210pf(PsogmImprvDDomain domain) throws ApplicationException;
    
    /**
     * [KO] 개선상세 정보 테이블에 레코드를 업데이트 한다.<br>
     * [EN] Update record in improvement detail information table.<br>
     * [JP] <br>
     * 
     * @param domain 'PsogmImprvDDomain' class
     * @return int int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateOgm204_obj210pf(PsogmImprvDDomain domain) throws ApplicationException;
    
    /**
     * [KO] 개선상세 정보 테이블에 도면등록변경 레코드를 업데이트 한다.<br>
     * [EN] Update record in improvement detail information table.<br>
     * [JP] 社員情報テーブルに1件のデータを登録します。<br>
     * 
     * @param domain 'PsogmImprvDDomain' class
     * @return int int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateOgm204_obj210pf_addImg(PsogmImprvDDomain domain) throws ApplicationException;
}
