/*
 * Project : DICAS
 *
 * ryan.lee
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * [EN] DTC class of Menu information.<br>
 * [JP] DTC class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class DtcDomain extends BaseDomain {

    private static final long serialVersionUID = 725088447132526208L;

	private Long id;
	/**
	 * [EN] 배기규제형식.<br/>
	 * [JP] 배기규제형식.<br/>
	 * [KO] 배기규제형식.<br/>
	 */
	private String exhaustReg;
	/**
	 * 엔진타입
	 */
	private String engineType;
	/**
	 * DTC 코드값
	 */
	private String dtcCode;
	/**
	 * DTC 영문명
	 */
	private String dtcEnNm;
	/**
	 * DTC 한글명
	 */
	private String dtcKrNm;


}
