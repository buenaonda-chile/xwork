/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.EngineTypeDto;
import com.globaldenso.dicas.presentation.form.EngineTypeSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface EngineTypeService {

  EngineTypeDto searchByKey(EngineTypeDto enginetypeDto) throws ApplicationException;
  Page<EngineTypeDto> searchByCondition(EngineTypeSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<EngineTypeDto> searchGrpCdByCondition(EngineTypeSearchForm criteria) throws ApplicationException;
  List<EngineTypeDto> searchEngineTypeByCondition(EngineTypeSearchForm criteria) throws ApplicationException;

  void create(EngineTypeDto enginetypeDto) throws ApplicationException;
  void update(EngineTypeDto enginetypeDto) throws ApplicationException;
  void delete(EngineTypeDto enginetypeDto) throws ApplicationException;
}
