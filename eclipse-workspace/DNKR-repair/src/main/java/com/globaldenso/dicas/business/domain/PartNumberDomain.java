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
 * [EN] PartNumber class of Menu information.<br>
 * [JP] PartNumber class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class PartNumberDomain extends BaseDomain {

    private static final long serialVersionUID = 712569531501045120L;

	private Long id;
	private String maker;
	private String exhaustReg;
	private String engineType;
	private String exchangeNm;
	private String hmc;
	private String denso;
	private Date autoinsert;
	private String partDiv;
	private String useYn;
	private String groupId;
	private Long partsCost;
	private Long margin;
	private Double workHour;


}
