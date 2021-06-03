/*
 * Project : DICAS
 *
 * ryan.lee
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.DtcDomain;
import com.globaldenso.dicas.business.dto.DtcDto;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Models class of Menu information.<br>
 * [JP] Models class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("dtcDao")
public interface DtcDao {

  DtcDto searchByKey(DtcDomain domain) throws SystemException;

  List<DtcDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(DtcDomain domain) throws SystemException;

  void update(DtcDomain domain) throws SystemException;

  void delete(DtcDomain domain) throws SystemException;

  List<DtcDto> searchByCondition2(Map<String, Object> params) throws SystemException;
}
