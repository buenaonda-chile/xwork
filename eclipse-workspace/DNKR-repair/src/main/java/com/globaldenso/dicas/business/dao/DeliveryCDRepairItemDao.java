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
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.DeliveryCDRepairItemDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("deliveryCDRepairItemDao")
public interface DeliveryCDRepairItemDao {

  DeliveryCDRepairItemDto searchByKey(DeliveryCDRepairItemDomain domain) throws SystemException;

  List<DeliveryCDRepairItemDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void createMst(DeliveryCDRepairItemDomain domain) throws SystemException;
  
  void createDtl(DeliveryCDRepairItemDomain domain) throws SystemException;

  void updateMst(DeliveryCDRepairItemDomain domain) throws SystemException;
  
  void updateDtl(DeliveryCDRepairItemDomain domain) throws SystemException;

  void deleteMst(DeliveryCDRepairItemDomain domain) throws SystemException;
  
  void deleteDtl(DeliveryCDRepairItemDomain domain) throws SystemException;

}
