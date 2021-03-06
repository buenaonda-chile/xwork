/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.OrderCDRepairPartDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.OrderCDRepairPartDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("orderCDRepairPartDao")
public interface OrderCDRepairPartDao {

  OrderCDRepairPartDto searchByKey(OrderCDRepairPartDomain domain) throws SystemException;

  List<OrderCDRepairPartDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void createMst(OrderCDRepairPartDomain domain) throws SystemException;
  
  void createDtl(OrderCDRepairPartDomain domain) throws SystemException;

  void updateMst(OrderCDRepairPartDomain domain) throws SystemException;
  
  void updateDtl(OrderCDRepairPartDomain domain) throws SystemException;

  void deleteMst(OrderCDRepairPartDomain domain) throws SystemException;
  
  void deleteDtl(OrderCDRepairPartDomain domain) throws SystemException;

}
