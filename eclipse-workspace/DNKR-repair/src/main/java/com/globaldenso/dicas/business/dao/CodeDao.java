/*
 * Project : DICAS
 *
 * $Id$
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.CodeDomain;
import com.globaldenso.dicas.business.dto.CodeDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository("codeDao")
public interface CodeDao {

  CodeDto searchByKey(CodeDomain domain) throws SystemException;

  List<CodeDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(CodeDomain domain) throws SystemException;

  void update(CodeDomain domain) throws SystemException;

  void delete(CodeDomain domain) throws SystemException;
}
