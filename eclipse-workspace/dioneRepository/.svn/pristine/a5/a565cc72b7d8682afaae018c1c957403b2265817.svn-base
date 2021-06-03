/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.IncidentCostDomain;
import com.globaldenso.dicas.business.dto.IncidentCostDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] IncidentCost class of Menu information.<br>
 * [JP] IncidentCost class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("incidentcostDao")
public interface IncidentCostDao {

  IncidentCostDto searchByKey(IncidentCostDomain domain) throws SystemException;

  List<IncidentCostDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(IncidentCostDomain domain) throws SystemException;

  void update(IncidentCostDomain domain) throws SystemException;

  void delete(IncidentCostDomain domain) throws SystemException;
}
