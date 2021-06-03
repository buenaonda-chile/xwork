/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.MenuRoleDomain;
import com.globaldenso.dicas.business.dto.MenuRoleDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] MenuRole class of Menu information.<br>
 * [JP] MenuRole class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("menuroleDao")
public interface MenuRoleDao {

  List<MenuRoleDto> searchByCondition(Map<String, Object> params) throws SystemException;

  void create(MenuRoleDomain domain) throws SystemException;

  void delete(MenuRoleDomain domain) throws SystemException;
}
