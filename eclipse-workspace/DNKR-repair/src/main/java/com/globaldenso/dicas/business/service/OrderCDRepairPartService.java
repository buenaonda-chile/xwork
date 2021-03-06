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
import com.globaldenso.dicas.business.dto.OrderCDRepairPartDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.OrderCDRepairPartSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface OrderCDRepairPartService {

  OrderCDRepairPartDto searchByKey(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException;
  Page<OrderCDRepairPartDto> searchByCondition(OrderCDRepairPartSearchForm criteria, Pageable pageable) throws ApplicationException;

  void createMst(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException;
  void createDtl(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException;
  void updateMst(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException;
  void updateDtl(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException;
  void deleteMst(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException;
  void deleteDtl(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException;
}
