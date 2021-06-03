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
import com.globaldenso.dicas.business.dto.ReceiptSDBrkPartDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ReceiptSDBrkPartSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface ReceiptSDBrkPartService {

  ReceiptSDBrkPartDto searchByKey(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException;
  Page<ReceiptSDBrkPartDto> searchByCondition(ReceiptSDBrkPartSearchForm criteria, Pageable pageable) throws ApplicationException;

  void createMst(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException;
  void createDtl(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException;
  void updateMst(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException;
  void updateDtl(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException;
  void deleteMst(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException;
  void deleteDtl(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException;
}
