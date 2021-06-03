/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.PhenomenonSubDomain;
import com.globaldenso.dicas.business.dto.PhenomenonSubDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] PhenomenonSub class of Menu information.<br>
 * [JP] PhenomenonSub class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("phenomenonsubDao")
public interface PhenomenonSubDao {

  PhenomenonSubDto searchByKey(PhenomenonSubDomain domain) throws SystemException;

  List<PhenomenonSubDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(PhenomenonSubDomain domain) throws SystemException;

  void update(PhenomenonSubDomain domain) throws SystemException;

  void delete(PhenomenonSubDomain domain) throws SystemException;
}
