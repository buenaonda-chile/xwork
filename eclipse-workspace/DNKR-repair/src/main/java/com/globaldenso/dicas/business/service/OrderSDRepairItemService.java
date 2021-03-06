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
import com.globaldenso.dicas.business.dto.OrderSDRepairItemDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.OrderSDRepairItemSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface OrderSDRepairItemService {

  OrderSDRepairItemDto searchByKey(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException;
  Page<OrderSDRepairItemDto> searchByCondition(OrderSDRepairItemSearchForm criteria, Pageable pageable) throws ApplicationException;

  void createMst(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException;
  void createDtl(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException;
  void updateMst(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException;
  void updateDtl(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException;
  void deleteMst(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException;
  void deleteDtl(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException;
}
