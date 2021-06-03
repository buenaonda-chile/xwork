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
public class TrainingAppRegistDomain extends BaseDomain {

    private static final long serialVersionUID = 32884142922088412L;

	private Long id;
//	private Long rgstrId;
//	private Date rgstDt;
//	private Long updtrId;
//	private Date updtDt;
	private Long applyId;
	private String eduDiv;
	private Long eduItem;
	private String custNm;
	private String officeNm;
	private String reprNm;
	private String officeTel;
	private String telNo;
	private String officePw;
	private String infoYn;
	private String rnkCd;
	private String traineeNm;
	private String moblphonNo;
	private String email;
	private String officePwConfirm;
	
	private String eduDt;
	private String receiptEndDate;
	private Long eduCnt;
	private Long traineeCnt;
	
	private String eduNm;
	
	private String searchEduDtFr;
	private String searchEduDtTo;

}
