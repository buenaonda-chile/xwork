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
 * [EN] PartName class of Menu information.<br>
 * [JP] PartName class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class PartNameDomain extends BaseDomain {

    private static final long serialVersionUID = 531685945294637952L;

	private Long id;
	private String maker;
	private String exchangeNm;
	private Date autoinsert;
	private String useYn;


}
