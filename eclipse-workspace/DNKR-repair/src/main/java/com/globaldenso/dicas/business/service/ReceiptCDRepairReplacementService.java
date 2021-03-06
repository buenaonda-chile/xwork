/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReceiptCDRepairReplacementDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ReceiptCDRepairReplacementSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface ReceiptCDRepairReplacementService {

	ReceiptCDRepairReplacementDto searchByKey(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException;
  Page<ReceiptCDRepairReplacementDto> searchByCondition(ReceiptCDRepairReplacementSearchForm criteria, Pageable pageable) throws ApplicationException;

  void createMst(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException;
  void createDtl(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException;
  void updateMst(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException;
  void updateDtl(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException;
  void deleteMst(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException;
  void deleteDtl(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException;
}
