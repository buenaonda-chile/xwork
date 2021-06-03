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
 * [EN] ResultSub class of Menu information.<br>
 * [JP] ResultSub class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class ResultSubDomain extends BaseDomain {

    private static final long serialVersionUID = 980951756712760576L;

	private Long id;
	private String vinno;
	private String manageNo;
	private Long serviceDegree;
	private Long resultDegree;
	private String actionType;
	private Long callCenterApproval;
	private Date repairDate;
	private String roNo;
	private Date roConfirmDate;
	private String roSpecialFeature;
	private String lotNo;
	private String hmcPartNo;
	private String replacePartNo;
	private String replacePartNm;
	private Long replacePartCnt;
	private String usage;
	private String recallType;
	private Date recallReqDate;
	private Date receiveDate;
	private Long qirIssueYn;
	private Date autoinsert;
	private String reprYn;
	private String IU;
	private String D;

}
