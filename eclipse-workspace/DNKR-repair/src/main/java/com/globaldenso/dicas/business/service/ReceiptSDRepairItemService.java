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
import com.globaldenso.dicas.business.dto.ReceiptSDRepairItemDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ReceiptSDRepairItemSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface ReceiptSDRepairItemService {

	ReceiptSDRepairItemDto searchByKey(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException;
  Page<ReceiptSDRepairItemDto> searchByCondition(ReceiptSDRepairItemSearchForm criteria, Pageable pageable) throws ApplicationException;

  void createMst(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException;
  void createDtl(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException;
  void updateMst(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException;
  void updateDtl(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException;
  void deleteMst(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException;
  void deleteDtl(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException;
}
