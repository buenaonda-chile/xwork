/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.ResearchDomain;
import com.globaldenso.dicas.business.dto.ResearchDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Research class of Menu information.<br>
 * [JP] Research class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("researchDao")
public interface ResearchDao {

  ResearchDto searchByKey(ResearchDomain domain) throws SystemException;

  List<ResearchDto> searchByCondition(Map<String, Object> params) throws SystemException;

  List<ResearchDto> searchByConditionFile(String manageNo) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(ResearchDomain domain) throws SystemException;

  void update(ResearchDomain domain) throws SystemException;

  void delete(ResearchDomain domain) throws SystemException;

  List<ResearchDto> searchByConditionCostApprInfo(String manageNo) throws SystemException;
}
