/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.OrderSDRepairItemDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.OrderSDRepairItemDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("orderSDRepairItemDao")
public interface OrderSDRepairItemDao {

  OrderSDRepairItemDto searchByKey(OrderSDRepairItemDomain domain) throws SystemException;

  List<OrderSDRepairItemDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void createMst(OrderSDRepairItemDomain domain) throws SystemException;
  
  void createDtl(OrderSDRepairItemDomain domain) throws SystemException;

  void updateMst(OrderSDRepairItemDomain domain) throws SystemException;
  
  void updateDtl(OrderSDRepairItemDomain domain) throws SystemException;

  void deleteMst(OrderSDRepairItemDomain domain) throws SystemException;
  
  void deleteDtl(OrderSDRepairItemDomain domain) throws SystemException;

}
