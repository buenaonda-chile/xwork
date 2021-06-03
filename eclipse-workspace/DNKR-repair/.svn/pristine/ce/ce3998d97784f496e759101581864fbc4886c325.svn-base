/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.OrderCDRepairReplacementDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.OrderCDRepairReplacementDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("orderCDRepairReplacementDao")
public interface OrderCDRepairReplacementDao {

  OrderCDRepairReplacementDto searchByKey(OrderCDRepairReplacementDomain domain) throws SystemException;

  List<OrderCDRepairReplacementDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void createMst(OrderCDRepairReplacementDomain domain) throws SystemException;
  
  void createDtl(OrderCDRepairReplacementDomain domain) throws SystemException;

  void updateMst(OrderCDRepairReplacementDomain domain) throws SystemException;
  
  void updateDtl(OrderCDRepairReplacementDomain domain) throws SystemException;

  void deleteMst(OrderCDRepairReplacementDomain domain) throws SystemException;
  
  void deleteDtl(OrderCDRepairReplacementDomain domain) throws SystemException;

}
