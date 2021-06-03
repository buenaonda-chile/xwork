/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.ResultMasterCostDomain;
import com.globaldenso.dicas.business.dto.ResultMasterCostDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] ResultMasterCost class of Menu information.<br>
 * [JP] ResultMasterCost class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("resultmastercostDao")
public interface ResultMasterCostDao {

  ResultMasterCostDto searchByKey(ResultMasterCostDomain domain) throws SystemException;

  List<ResultMasterCostDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(ResultMasterCostDomain domain) throws SystemException;

  void update(ResultMasterCostDomain domain) throws SystemException;

  void delete(ResultMasterCostDomain domain) throws SystemException;

  void delete2(ResultMasterCostDomain domain) throws SystemException;
}
