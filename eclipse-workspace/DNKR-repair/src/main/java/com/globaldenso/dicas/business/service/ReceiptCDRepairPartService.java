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
import com.globaldenso.dicas.business.dto.ReceiptCDRepairPartDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ReceiptCDRepairPartSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface ReceiptCDRepairPartService {

  ReceiptCDRepairPartDto searchByKey(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException;
  Page<ReceiptCDRepairPartDto> searchByCondition(ReceiptCDRepairPartSearchForm criteria, Pageable pageable) throws ApplicationException;

  void createMst(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException;
  void createDtl(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException;
  void updateMst(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException;
  void updateDtl(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException;
  void deleteMst(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException;
  void deleteDtl(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException;
}
