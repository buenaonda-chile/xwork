/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.OfficeDomain;
import com.globaldenso.dicas.business.dto.OfficeDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Office class of Menu information.<br>
 * [JP] Office class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("officeDao")
public interface OfficeDao {

  OfficeDto searchByKey(OfficeDomain domain) throws SystemException;

  List<OfficeDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(OfficeDomain domain) throws SystemException;

  void update(OfficeDomain domain) throws SystemException;

  void delete(OfficeDomain domain) throws SystemException;
}
