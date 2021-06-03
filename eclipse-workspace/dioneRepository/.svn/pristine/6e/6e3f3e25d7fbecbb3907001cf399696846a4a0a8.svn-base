package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.UserRoleDomain;
import com.globaldenso.dicas.business.dto.UserRoleDto;
import org.springframework.stereotype.Repository;

@Repository("userRoleDao")
public interface UserRoleDao {

  UserRoleDto searchByKey(UserRoleDto userRoleDto) throws SystemException;

  void create(UserRoleDomain userRoleDomain) throws SystemException;
  void delete(UserRoleDomain userRoleDomain) throws SystemException;
}
