/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * [EN] User class of Menu information.<br>
 * [JP] User class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class UserDomain extends BaseDomain {

	private static final long serialVersionUID = 503551215546996416L;

	private String acctId;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String acctPw;
	private String email;
	private String telNo;
	private String moblphonNo;
	private String fstNm;
	private String mdlNm;
	private String lstNm;
	private String useYn;
	private String roleCd;
	private String officeCd;
	private String deptCd;

}
