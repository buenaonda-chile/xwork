/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.UserDomain;
import com.globaldenso.dicas.business.dto.UserDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] User class of Menu information.<br>
 * [JP] User class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("userDao")
public interface UserDao {

  UserDto searchByKey(UserDomain domain) throws SystemException;

  List<UserDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(UserDomain domain) throws SystemException;

  void update(UserDomain domain) throws SystemException;

  void updatePassword(UserDomain domain) throws SystemException;

  void delete(UserDomain domain) throws SystemException;
}
