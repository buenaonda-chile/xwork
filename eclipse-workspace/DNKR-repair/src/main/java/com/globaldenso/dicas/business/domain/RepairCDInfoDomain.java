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
public class RepairCDInfoDomain extends BaseDomain {

    private static final long serialVersionUID = 32884142922088412L;

//	private Long id;
//	private Long rgstrId;
//	private Date rgstDt;
//	private Long updtrId;
//	private Date updtDt;
	private String repNo;
	private String repDt;
	private String remark;
	private String chk;
	private String repEmpSeq;
	private String brkPartNo;
	private String brkPartNm;
	private String repPartNo;
	private String repPartNm;
	private String custNm;
	private Long custId;
	private String custEmpNm;
	private Long custEmpId;
	private String ngType;
	private String ngCn;
	private String status;
	private String qty;
	private String repCar;
	
	private String searchRepDtFr;
	private String searchRepDtTo;

}
