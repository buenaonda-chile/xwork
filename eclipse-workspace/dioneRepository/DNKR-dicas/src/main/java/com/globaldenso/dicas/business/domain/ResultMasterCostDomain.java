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
import java.util.HashMap;
import java.util.Map;

/**
 * [EN] ResultMasterCost class of Menu information.<br>
 * [JP] ResultMasterCost class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class ResultMasterCostDomain extends BaseDomain {

    private static final long serialVersionUID = 536043770179667840L;

	private String vinno;
	private String mngNo;
	private Long serviceSeq;
	private String div;
	private Long seq;
	private String costCd;
	private Double costValue;
	private String regUserId;
	private Date regDt;
	private String updUserId;
	private Date updDt;

	private Long id;
	private String costNm;

	private Map<String, String> costMap;
}
