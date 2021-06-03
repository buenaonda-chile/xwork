/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.ReceiptCDRepairReplacementDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReceiptCDRepairReplacementDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("receiptCDRepairReplacementDao")
public interface ReceiptCDRepairReplacementDao {

  ReceiptCDRepairReplacementDto searchByKey(ReceiptCDRepairReplacementDomain domain) throws SystemException;

  List<ReceiptCDRepairReplacementDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void createMst(ReceiptCDRepairReplacementDomain domain) throws SystemException;
  
  void createDtl(ReceiptCDRepairReplacementDomain domain) throws SystemException;

  void updateMst(ReceiptCDRepairReplacementDomain domain) throws SystemException;
  
  void updateDtl(ReceiptCDRepairReplacementDomain domain) throws SystemException;

  void deleteMst(ReceiptCDRepairReplacementDomain domain) throws SystemException;
  
  void deleteDtl(ReceiptCDRepairReplacementDomain domain) throws SystemException;

}
