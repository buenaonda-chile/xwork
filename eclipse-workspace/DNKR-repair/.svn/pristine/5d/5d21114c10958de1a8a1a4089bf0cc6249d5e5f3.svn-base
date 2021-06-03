/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.RoleDomain;
import com.globaldenso.dicas.business.dto.RoleDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Role class of Menu information.<br>
 * [JP] Role class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("roleDao")
public interface RoleDao {

  RoleDto searchByKey(RoleDomain domain) throws SystemException;

  List<RoleDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(RoleDomain domain) throws SystemException;

  void update(RoleDomain domain) throws SystemException;

  void delete(RoleDomain domain) throws SystemException;

  List<RoleDto> searchByCondition2(Map<String, Object> params) throws SystemException;
}
