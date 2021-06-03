/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.ReceiptCDRepairPartDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReceiptCDRepairPartDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("receiptCDRepairPartDao")
public interface ReceiptCDRepairPartDao {

  ReceiptCDRepairPartDto searchByKey(ReceiptCDRepairPartDomain domain) throws SystemException;

  List<ReceiptCDRepairPartDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void createMst(ReceiptCDRepairPartDomain domain) throws SystemException;

  void createDtl(ReceiptCDRepairPartDomain domain) throws SystemException;
  
  void updateMst(ReceiptCDRepairPartDomain domain) throws SystemException;

  void updateDtl(ReceiptCDRepairPartDomain domain) throws SystemException;
  
  void deleteMst(ReceiptCDRepairPartDomain domain) throws SystemException;
  
  void deleteDtl(ReceiptCDRepairPartDomain domain) throws SystemException;

}
