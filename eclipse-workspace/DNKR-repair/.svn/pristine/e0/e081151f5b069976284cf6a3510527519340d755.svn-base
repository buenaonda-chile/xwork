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
import com.globaldenso.dicas.business.dto.SaleSDRepairItemDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.SaleSDRepairItemSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface SaleSDRepairItemService {

	SaleSDRepairItemDto searchByKey(SaleSDRepairItemDto saleSDRepairItemDto) throws ApplicationException;
  Page<SaleSDRepairItemDto> searchByCondition(SaleSDRepairItemSearchForm criteria, Pageable pageable) throws ApplicationException;

  void create(SaleSDRepairItemDto saleSDRepairItemDto) throws ApplicationException;
  void update(SaleSDRepairItemDto saleSDRepairItemDto) throws ApplicationException;
  void delete(SaleSDRepairItemDto saleSDRepairItemDto) throws ApplicationException;

}
