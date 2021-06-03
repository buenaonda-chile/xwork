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
import com.globaldenso.dicas.business.dto.DeliveryCDRepairItemDto;
import com.globaldenso.dicas.business.dto.DeliveryDNKRRepairPartDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.DeliveryDNKRRepairPartSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface DeliveryDNKRRepairPartService {

  DeliveryDNKRRepairPartDto searchByKey(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException;
  Page<DeliveryDNKRRepairPartDto> searchByCondition(DeliveryDNKRRepairPartSearchForm criteria, Pageable pageable) throws ApplicationException;

  void createMst(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException;
  void createDtl(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException;
  void updateMst(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException;
  void updateDtl(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException;
  void deleteMst(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException;
  void deleteDtl(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException;
}
