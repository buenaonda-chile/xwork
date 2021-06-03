/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.ResultSubDomain;
import com.globaldenso.dicas.business.dto.ResultSubDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] ResultSub class of Menu information.<br>
 * [JP] ResultSub class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("resultsubDao")
public interface ResultSubDao {

  ResultSubDto searchByKey(ResultSubDomain domain) throws SystemException;

  List<ResultSubDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(ResultSubDomain domain) throws SystemException;

  void update(ResultSubDomain domain) throws SystemException;

  void delete(ResultSubDomain domain) throws SystemException;
}
