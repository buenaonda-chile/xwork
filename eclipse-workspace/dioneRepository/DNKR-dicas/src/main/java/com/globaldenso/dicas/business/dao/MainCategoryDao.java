/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.MainCategoryDomain;
import com.globaldenso.dicas.business.dto.MainCategoryDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] MainCategory class of Menu information.<br>
 * [JP] MainCategory class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("maincategoryDao")
public interface MainCategoryDao {

  MainCategoryDto searchByKey(MainCategoryDomain domain) throws SystemException;

  List<MainCategoryDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(MainCategoryDomain domain) throws SystemException;

  void update(MainCategoryDomain domain) throws SystemException;

  void delete(MainCategoryDomain domain) throws SystemException;
}
