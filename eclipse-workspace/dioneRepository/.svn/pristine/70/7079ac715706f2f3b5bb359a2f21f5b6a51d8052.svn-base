/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.PartNameDomain;
import com.globaldenso.dicas.business.dto.PartNameDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] PartName class of Menu information.<br>
 * [JP] PartName class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("partnameDao")
public interface PartNameDao {

  PartNameDto searchByKey(PartNameDomain domain) throws SystemException;

  List<PartNameDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(PartNameDomain domain) throws SystemException;

  void update(PartNameDomain domain) throws SystemException;

  void delete(PartNameDomain domain) throws SystemException;
}
