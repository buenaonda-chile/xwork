/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class ServiceDomain extends BaseDomain {

    private static final long serialVersionUID = 32884142922088412L;

	private Long id;
	private String masterId;
	private String manageNo;
	private Long serviceDegree;
	private String condition;
	private String maker;
	private String vinno;
	private String carNo;
	private String exhaustReg;
	private String engineType;
	private String model;
	private String consultingExp;
	private String div;
	private Long manageNoId;
	private Long approvalNoId;
	private String approvalNo;
	private String receiptDate;
	private String receiptNm;
	private String inquiry;
	private String country;
	private Long mileage;
	private String unit;
	private Date occurDate;
	private Date relapseDate;
	private String reappearance;
	private String officeCode;
	private String officeCity;
	private String officeNm;
	private String officeTel;
	private String officeFax;
	private String officeAddr;
	private String expatNm;
	private String expatTel;
	private String mechanic1Nm;
	private String mechanic1Tel;
	private String mechanic2Nm;
	private String mechanic2Tel;
	private Date wearingDate;
	private Long cs1000;
	private Long warranty;
	private Long officeFix;
	private Date autoinsert;
	private Long rs1000;
	private String inquiryGubun;
	private String prodBase;

	private String qualityIndex;
	private String useMonth;
	private String sdAppoint;
	private String receiptNm2;

	/** 모바일_소재지 */
	private String officeCityNm;
	/** 모바일_상태명 */
	private String conditionNm;
	/** 모바일_서치옵션 */
	private String popSearchOption;
	/** 모바일_서치키워드 */
	private String searchKeyword;

	private String prefix;
}
