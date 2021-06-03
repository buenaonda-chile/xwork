/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.SubCategoryDto;
import com.globaldenso.dicas.presentation.form.SubCategorySearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface SubCategoryService {

  SubCategoryDto searchByKey(SubCategoryDto subcategoryDto) throws ApplicationException;
  Page<SubCategoryDto> searchByCondition(SubCategorySearchForm criteria, Pageable pageable) throws ApplicationException;
  List<SubCategoryDto> searchGrpCdByCondition(SubCategorySearchForm criteria) throws ApplicationException;
  List<SubCategoryDto> searchSubCategoryByCondition(SubCategorySearchForm criteria) throws ApplicationException;

  void create(SubCategoryDto subcategoryDto) throws ApplicationException;
  void update(SubCategoryDto subcategoryDto) throws ApplicationException;
  void delete(SubCategoryDto subcategoryDto) throws ApplicationException;
}
