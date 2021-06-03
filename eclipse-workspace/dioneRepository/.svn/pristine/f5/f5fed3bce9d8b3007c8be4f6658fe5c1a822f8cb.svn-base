/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.SubCategoryDomain;
import com.globaldenso.dicas.business.dto.SubCategoryDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] SubCategory class of Menu information.<br>
 * [JP] SubCategory class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("subcategoryDao")
public interface SubCategoryDao {

  SubCategoryDto searchByKey(SubCategoryDomain domain) throws SystemException;

  List<SubCategoryDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(SubCategoryDomain domain) throws SystemException;

  void update(SubCategoryDomain domain) throws SystemException;

  void delete(SubCategoryDomain domain) throws SystemException;
}
