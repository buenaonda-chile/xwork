/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.UserDto;
import com.globaldenso.dicas.presentation.form.UserSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface UserService {

  UserDto searchByKey(UserDto userDto) throws ApplicationException;
  Page<UserDto> searchByCondition(UserSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<UserDto> searchGrpCdByCondition(UserSearchForm criteria) throws ApplicationException;
  List<UserDto> searchUserByCondition(UserSearchForm criteria) throws ApplicationException;

  void create(UserDto userDto) throws ApplicationException;
  void update(UserDto userDto) throws ApplicationException;
  void delete(UserDto userDto) throws ApplicationException;

  void updatePassword(UserDto userDto, String password) throws ApplicationException;

  void transactInitPassword(UserDto userDto) throws ApplicationException;
  void transactInitPasswordAll() throws ApplicationException;
}
