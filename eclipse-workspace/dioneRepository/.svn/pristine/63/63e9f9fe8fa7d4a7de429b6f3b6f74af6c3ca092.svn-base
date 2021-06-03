/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.business.service.db2;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.FileDb2Domain;


/**
 * [KR] 생산전광판 현황 서비스 인터페이스. <br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PsogmAttachedFileService {

    /**
     * [KO] 첨부파일 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'FileDb2Domain' class
     * @return 'FileDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<FileDb2Domain> selectOgm219_obj230pf(FileDb2Domain domain) throws ApplicationException;
   
    /**
     * [KO] 첨부파일 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'FileDb2Domain' class
     * @return 'FileDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public FileDb2Domain searchById(FileDb2Domain domain) throws ApplicationException;
   
    /**
     * [EN] Create a record in boardInfo information table.<br>
     * [JP] 社員情報テーブルに1件のデータを登録します。<br>
     * 
     * @param domain 'FileDb2Domain' class
     * @param multiRequest MultipartHttpServletRequest
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(FileDb2Domain domain, MultipartHttpServletRequest multiRequest) throws ApplicationException;
   
    /**
     * [KO] 기본키로  첨부파일정보－설비보전테이블(LIB2.OBJ230PF)의 레코드를 삭제한다.<br>
     * [EN] Delete a record in LIB2.OBJ230PF table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'FileDb2Domain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(FileDb2Domain domain) throws ApplicationException;
    
}
 