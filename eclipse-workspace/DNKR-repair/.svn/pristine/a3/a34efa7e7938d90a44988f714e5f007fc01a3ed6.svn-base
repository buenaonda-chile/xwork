/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.ModelsDomain;
import com.globaldenso.dicas.business.dto.ModelsDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Models class of Menu information.<br>
 * [JP] Models class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("modelsDao")
public interface ModelsDao {

  ModelsDto searchByKey(ModelsDomain domain) throws SystemException;

  List<ModelsDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(ModelsDomain domain) throws SystemException;

  void update(ModelsDomain domain) throws SystemException;

  void delete(ModelsDomain domain) throws SystemException;
}
