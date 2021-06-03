/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.DeliveryCDRepairItemDomain;
import com.globaldenso.dicas.business.domain.DeliveryDNKRRepairPartDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.DeliveryDNKRRepairPartDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("deliveryDNKRRepairPartDao")
public interface DeliveryDNKRRepairPartDao {

  DeliveryDNKRRepairPartDto searchByKey(DeliveryDNKRRepairPartDomain domain) throws SystemException;

  List<DeliveryDNKRRepairPartDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void createMst(DeliveryDNKRRepairPartDomain domain) throws SystemException;
  
  void createDtl(DeliveryDNKRRepairPartDomain domain) throws SystemException;

  void updateMst(DeliveryDNKRRepairPartDomain domain) throws SystemException;
  
  void updateDtl(DeliveryDNKRRepairPartDomain domain) throws SystemException;

  void deleteMst(DeliveryDNKRRepairPartDomain domain) throws SystemException;
  
  void deleteDtl(DeliveryDNKRRepairPartDomain domain) throws SystemException;

}
