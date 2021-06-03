/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.ServiceDomain;
import com.globaldenso.dicas.business.dto.ServiceDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("serviceDao")
public interface ServiceDao {

  ServiceDto searchByKey(ServiceDomain domain) throws SystemException;

  List<ServiceDto> searchByCondition(Map<String, Object> params) throws SystemException;

  List<ServiceDto> searchBySdCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  int searchSdCount(Map<String, Object> params) throws SystemException;

  void create(ServiceDomain domain) throws SystemException;

  void update(ServiceDomain domain) throws SystemException;

  void delete(ServiceDomain domain) throws SystemException;

  void update2(ServiceDomain domain) throws SystemException;
}
