/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.EngineTypeDomain;
import com.globaldenso.dicas.business.dto.EngineTypeDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] EngineType class of Menu information.<br>
 * [JP] EngineType class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("enginetypeDao")
public interface EngineTypeDao {

  EngineTypeDto searchByKey(EngineTypeDomain domain) throws SystemException;

  List<EngineTypeDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(EngineTypeDomain domain) throws SystemException;

  void update(EngineTypeDomain domain) throws SystemException;

  void delete(EngineTypeDomain domain) throws SystemException;
}
