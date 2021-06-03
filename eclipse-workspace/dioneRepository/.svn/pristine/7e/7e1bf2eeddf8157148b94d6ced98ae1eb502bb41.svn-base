/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.MainCategoryDto;
import com.globaldenso.dicas.presentation.form.MainCategorySearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface MainCategoryService {

  MainCategoryDto searchByKey(MainCategoryDto maincategoryDto) throws ApplicationException;
  Page<MainCategoryDto> searchByCondition(MainCategorySearchForm criteria, Pageable pageable) throws ApplicationException;
  List<MainCategoryDto> searchGrpCdByCondition(MainCategorySearchForm criteria) throws ApplicationException;
  List<MainCategoryDto> searchMainCategoryByCondition(MainCategorySearchForm criteria) throws ApplicationException;

  void create(MainCategoryDto maincategoryDto) throws ApplicationException;
  void update(MainCategoryDto maincategoryDto) throws ApplicationException;
  void delete(MainCategoryDto maincategoryDto) throws ApplicationException;
}
