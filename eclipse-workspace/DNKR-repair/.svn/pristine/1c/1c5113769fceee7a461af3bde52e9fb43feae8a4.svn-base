/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.GroupDomain;
import com.globaldenso.dicas.business.dto.GroupDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Group class of Menu information.<br>
 * [JP] Group class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("groupDao")
public interface GroupDao {

  GroupDto searchByKey(GroupDomain domain) throws SystemException;

  List<GroupDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(GroupDomain domain) throws SystemException;

  void update(GroupDomain domain) throws SystemException;

  void delete(GroupDomain domain) throws SystemException;
}
