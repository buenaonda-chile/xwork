/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.PartNumberDomain;
import com.globaldenso.dicas.business.dto.PartNumberDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] PartNumber class of Menu information.<br>
 * [JP] PartNumber class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("partnumberDao")
public interface PartNumberDao {

  PartNumberDto searchByKey(PartNumberDomain domain) throws SystemException;

  List<PartNumberDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(PartNumberDomain domain) throws SystemException;

  void update(PartNumberDomain domain) throws SystemException;

  void delete(PartNumberDomain domain) throws SystemException;
}
