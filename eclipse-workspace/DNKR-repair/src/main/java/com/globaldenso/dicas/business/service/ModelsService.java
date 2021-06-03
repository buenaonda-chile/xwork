/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.ModelsDto;
import com.globaldenso.dicas.presentation.form.ModelsSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface ModelsService {

  ModelsDto searchByKey(ModelsDto modelsDto) throws ApplicationException;
  Page<ModelsDto> searchByCondition(ModelsSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<ModelsDto> searchGrpCdByCondition(ModelsSearchForm criteria) throws ApplicationException;
  List<ModelsDto> searchModelsByCondition(ModelsSearchForm criteria) throws ApplicationException;

  void create(ModelsDto modelsDto) throws ApplicationException;
  void update(ModelsDto modelsDto) throws ApplicationException;
  void delete(ModelsDto modelsDto) throws ApplicationException;
}
