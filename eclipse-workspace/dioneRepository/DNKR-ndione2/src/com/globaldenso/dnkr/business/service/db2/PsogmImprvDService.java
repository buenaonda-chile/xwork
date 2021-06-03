/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.business.service.db2;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.PsogmImprvDDomain;


/**
 * [KR] 개선상세 정보 서비스 인터페이스. <br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PsogmImprvDService {

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
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int insertOgm204_obj210pf(PsogmImprvDDomain domain) throws ApplicationException;
    
    /**
     * [KO] 개선상세 정보 테이블에 레코드를 업데이트 한다.<br>
     * [EN] Update a record in improvement detail information table.<br>
     * [JP] <br>
     * 
     * @param domain 'PsogmImprvDDomain' class
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateOgm204_obj210pf(PsogmImprvDDomain domain) throws ApplicationException;
    
    /**
     * [KO] 개선상세 정보 테이블(LIB2.OBJ210PF)에 도면이미지 정보를 업데이트한다.
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmImprvDDomain' class
     * @param multiRequest MultipartHttpServletRequest
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void updateImg(PsogmImprvDDomain domain, MultipartHttpServletRequest multiRequest) throws ApplicationException;
    
    /**
     * [KO] 기본키로  개선상세테이블(LIB2.OBJ210PF)의 img정보를 삭제한다.<br>
     * [EN] Delete a record in LIB2.OBJ230PF table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'PsogmImprvDDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteImg(PsogmImprvDDomain domain) throws ApplicationException;
}
 