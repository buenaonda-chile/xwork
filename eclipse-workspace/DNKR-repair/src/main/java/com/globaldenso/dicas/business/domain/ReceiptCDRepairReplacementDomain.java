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
public class ReceiptCDRepairReplacementDomain extends BaseDomain {

    private static final long serialVersionUID = 32884142922088412L;

//	private Long id;
//	private Long rgstrId;
//	private Date rgstDt;
//	private Long updtrId;
//	private Date updtDt;
	private String rectNo;
	private String rectDt;
	private String status;
	private String remark;
	private String chk;
	private String rectDiv;
	private String custNm;
	private Long custId;
	private String custEmpNm;
	private Long custEmpId;
	private String partNo;
	private String partNm;
	private String admissStatus;
	
	private String searchRecDtFr;
	private String searchRecDtTo;

}
