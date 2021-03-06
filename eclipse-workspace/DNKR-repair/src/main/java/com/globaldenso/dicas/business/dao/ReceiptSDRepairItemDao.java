/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.ReceiptSDRepairItemDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReceiptSDRepairItemDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("receiptSDRepairItemDao")
public interface ReceiptSDRepairItemDao {

  ReceiptSDRepairItemDto searchByKey(ReceiptSDRepairItemDomain domain) throws SystemException;

  List<ReceiptSDRepairItemDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void createMst(ReceiptSDRepairItemDomain domain) throws SystemException;

  void createDtl(ReceiptSDRepairItemDomain domain) throws SystemException;
  
  void updateMst(ReceiptSDRepairItemDomain domain) throws SystemException;

  void updateDtl(ReceiptSDRepairItemDomain domain) throws SystemException;
  
  void deleteMst(ReceiptSDRepairItemDomain domain) throws SystemException;
  
  void deleteDtl(ReceiptSDRepairItemDomain domain) throws SystemException;

}
