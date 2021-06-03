/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.OfficeDetailDomain;
import com.globaldenso.dicas.business.dto.OfficeDetailDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] OfficeDetail class of Menu information.<br>
 * [JP] OfficeDetail class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("officedetailDao")
public interface OfficeDetailDao {

  OfficeDetailDto searchByKey(OfficeDetailDomain domain) throws SystemException;

  List<OfficeDetailDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(OfficeDetailDomain domain) throws SystemException;

  void update(OfficeDetailDomain domain) throws SystemException;

  void delete(OfficeDetailDomain domain) throws SystemException;
}
