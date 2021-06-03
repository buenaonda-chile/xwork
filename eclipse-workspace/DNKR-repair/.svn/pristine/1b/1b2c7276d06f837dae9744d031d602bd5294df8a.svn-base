/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.ReceiptSDBrkPartDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReceiptSDBrkPartDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("receiptSDBrkPartDao")
public interface ReceiptSDBrkPartDao {

  ReceiptSDBrkPartDto searchByKey(ReceiptSDBrkPartDomain domain) throws SystemException;

  List<ReceiptSDBrkPartDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void createMst(ReceiptSDBrkPartDomain domain) throws SystemException;
  
  void createDtl(ReceiptSDBrkPartDomain domain) throws SystemException;

  void updateMst(ReceiptSDBrkPartDomain domain) throws SystemException;
  
  void updateDtl(ReceiptSDBrkPartDomain domain) throws SystemException;

  void deleteMst(ReceiptSDBrkPartDomain domain) throws SystemException;
  
  void deleteDtl(ReceiptSDBrkPartDomain domain) throws SystemException;

}
