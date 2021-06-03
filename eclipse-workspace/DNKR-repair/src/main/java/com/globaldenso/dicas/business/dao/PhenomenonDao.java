/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.PhenomenonDomain;
import com.globaldenso.dicas.business.dto.PhenomenonDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Phenomenon class of Menu information.<br>
 * [JP] Phenomenon class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("phenomenonDao")
public interface PhenomenonDao {

  PhenomenonDto searchByKey(PhenomenonDomain domain) throws SystemException;

  List<PhenomenonDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(PhenomenonDomain domain) throws SystemException;

  void update(PhenomenonDomain domain) throws SystemException;

  void delete(PhenomenonDomain domain) throws SystemException;
}
