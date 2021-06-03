/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.MenuRoleDto;
import com.globaldenso.dicas.presentation.form.MenuRoleSearchForm;
import java.util.List;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface MenuRoleService {

  List<MenuRoleDto> searchByCondition(MenuRoleSearchForm criteria) throws ApplicationException;

  void create(MenuRoleDto menuroleDto) throws ApplicationException;
  void delete(MenuRoleDto menuroleDto) throws ApplicationException;
}