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
import com.globaldenso.dicas.business.dto.ReceiptCDRepairItemAdmissDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ReceiptCDRepairItemAdmissSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface ReceiptCDRepairItemAdmissService {

  ReceiptCDRepairItemAdmissDto searchByKey(ReceiptCDRepairItemAdmissDto receiptCDRepairItemAdmissDto) throws ApplicationException;
  Page<ReceiptCDRepairItemAdmissDto> searchByCondition(ReceiptCDRepairItemAdmissSearchForm criteria, Pageable pageable) throws ApplicationException;

  void update(ReceiptCDRepairItemAdmissDto receiptCDRepairItemAdmissDto) throws ApplicationException;
}
