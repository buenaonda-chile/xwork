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
import com.globaldenso.dicas.business.dto.OrderCDRepairItemAdmissDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.OrderCDRepairItemAdmissSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface OrderCDRepairItemAdmissService {

	OrderCDRepairItemAdmissDto searchByKey(OrderCDRepairItemAdmissDto orderCDRepairItemAdmissDto) throws ApplicationException;
  Page<OrderCDRepairItemAdmissDto> searchByCondition(OrderCDRepairItemAdmissSearchForm criteria, Pageable pageable) throws ApplicationException;

  void update(OrderCDRepairItemAdmissDto orderCDRepairItemAdmissDto) throws ApplicationException;
}
