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
import com.globaldenso.dicas.business.dto.OrderCDRepairReplacementDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.OrderCDRepairReplacementSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface OrderCDRepairReplacementService {

  OrderCDRepairReplacementDto searchByKey(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException;
  Page<OrderCDRepairReplacementDto> searchByCondition(OrderCDRepairReplacementSearchForm criteria, Pageable pageable) throws ApplicationException;

  void createMst(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException;
  void createDtl(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException;
  void updateMst(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException;
  void updateDtl(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException;
  void deleteMst(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException;
  void deleteDtl(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException;
}
