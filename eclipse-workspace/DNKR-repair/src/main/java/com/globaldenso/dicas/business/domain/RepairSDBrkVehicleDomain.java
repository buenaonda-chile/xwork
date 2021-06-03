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
public class RepairSDBrkVehicleDomain extends BaseDomain {

    private static final long serialVersionUID = 32884142922088412L;

//	private Long id;
//	private Long rgstrId;
//	private Date rgstDt;
//	private Long updtrId;
//	private Date updtDt;
	private Long repNo; //수리번호
	private String repDt; //수리일자
	private String repCar; //차종
	private String brkPartNo; //고품품번
	private String brkPartNm; //고품명
	private String brkLotId; //고품 Lot ID
	private String repPartNo; //수리품번
	private String repPartNm; //수리명
	private String repLotId; //고품 Lot ID
	private String repCustId; //수리업체
	private String repEmpNm; //수리담당자
	private String ngType; //불량타입
	private String ngCn; //불량사유
	private Long qty; //수량
	private String remark; //비고
	
	private String searchRepDtFr; //수리일자
	private String searchRepDtTo; //수리일자

}
