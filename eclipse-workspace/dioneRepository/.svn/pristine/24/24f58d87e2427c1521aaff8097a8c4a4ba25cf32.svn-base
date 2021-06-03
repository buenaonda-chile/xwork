/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.ConsultingDomain;
import com.globaldenso.dicas.business.dto.ConsultingDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Consulting class of Menu information.<br>
 * [JP] Consulting class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("consultingDao")
public interface ConsultingDao {

  ConsultingDto searchByKey(ConsultingDomain domain) throws SystemException;

  List<ConsultingDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(ConsultingDomain domain) throws SystemException;

  void update(ConsultingDomain domain) throws SystemException;

  void delete(ConsultingDomain domain) throws SystemException;
}
