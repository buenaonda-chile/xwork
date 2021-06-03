/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.SaleSDRepairItemDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.SaleSDRepairItemDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("saleSDRepairItemDao")
public interface SaleSDRepairItemDao {

  SaleSDRepairItemDto searchByKey(SaleSDRepairItemDomain domain) throws SystemException;

  List<SaleSDRepairItemDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(SaleSDRepairItemDomain domain) throws SystemException;
  
  void update(SaleSDRepairItemDomain domain) throws SystemException;
  
  void delete(SaleSDRepairItemDomain domain) throws SystemException;
  
}
