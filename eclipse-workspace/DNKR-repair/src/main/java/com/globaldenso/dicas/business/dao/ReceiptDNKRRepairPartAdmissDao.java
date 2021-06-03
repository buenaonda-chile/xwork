/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.ReceiptDNKRRepairPartAdmissDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReceiptDNKRRepairPartAdmissDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("receiptDNKRRepairPartAdmissDao")
public interface ReceiptDNKRRepairPartAdmissDao {

  ReceiptDNKRRepairPartAdmissDto searchByKey(ReceiptDNKRRepairPartAdmissDomain domain) throws SystemException;

  List<ReceiptDNKRRepairPartAdmissDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void update(ReceiptDNKRRepairPartAdmissDomain domain) throws SystemException;

}
