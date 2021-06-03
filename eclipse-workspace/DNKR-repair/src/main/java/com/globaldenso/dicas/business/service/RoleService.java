/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.RoleDto;
import com.globaldenso.dicas.presentation.form.RoleSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface RoleService {

  RoleDto searchByKey(RoleDto roleDto) throws ApplicationException;
  Page<RoleDto> searchByCondition(RoleSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<RoleDto> searchGrpCdByCondition(RoleSearchForm criteria) throws ApplicationException;
  List<RoleDto> searchRoleByCondition(RoleSearchForm criteria) throws ApplicationException;

  void create(RoleDto roleDto) throws ApplicationException;
  void update(RoleDto roleDto) throws ApplicationException;
  void delete(RoleDto roleDto) throws ApplicationException;

  List<RoleDto> searchByCondition2(RoleSearchForm criteria) throws ApplicationException;
}
