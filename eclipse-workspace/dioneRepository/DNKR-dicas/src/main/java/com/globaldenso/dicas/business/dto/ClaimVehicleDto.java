/*
 * Project : DICAS
 *
 * ryan.lee
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dto;

import com.globaldenso.dicas.business.domain.ClaimVehicleDomain;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [EN] ClaimVehicleDao class of Menu information.<br>
 * [JP] ClaimVehicleDao class of Menu information.<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class ClaimVehicleDto extends ClaimVehicleDomain {

    private static final long serialVersionUID = -6025855641084202633L;

    /**
     * 승상용구분명
     */
    private String tireStdNm;

    /**
     * [KR] 정비소명 <br/>
     */
    private String officeCodeNm;
    /**
     * [KR] 메이커명 <br/>
     */
    private String makerNm;
    /**
     * [KR] 엔진타입명 <br/>
     */
    private String engineTypeNm;
    /**
     * [KR] 배기형식<br/>
     */
    private String exhaustRegNm;
    /**
     * [KR] 차종명 <br/>
     */
    private String modelNm;
    /**
     * [KR] 메인카테고리명 <br/>
     */
    private String mainCategoryNm;
    /**
     * [KR] 진행상태 <br/>
     */
    private String status;
    /**
     * [KR] 주원인품명 <br/>8
     */
    private String replacePartNm;
    /**
     * [KR] 부품구분명 <br/>
     */
    private String inquiryGubunNm;
    /**
     * [KR] 소재지명 <br/>
     */
    private String officeCityNm;

    /**
     * ro 구분
     */
    private String roGubun;

    private String searchResultDateFr ;

    private String searchResultDateTo;
    /**
     * 주행거리
     */
    private Long mileage;

    /**
     *  클레임구분
     */
    // private String inquiryGubun;

    private String inquiry;

    /**
     * 클레임접수자
     */
    private String receiptNm;

}
