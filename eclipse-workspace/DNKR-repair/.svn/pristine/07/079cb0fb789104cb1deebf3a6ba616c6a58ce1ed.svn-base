/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.TrainingAppViewDto;
import com.globaldenso.dicas.presentation.form.TrainingAppViewSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface TrainingAppViewService {

  TrainingAppViewDto searchByKey(TrainingAppViewDto trainingAppViewDto) throws ApplicationException;
  Page<TrainingAppViewDto> searchByCondition(TrainingAppViewSearchForm criteria, Pageable pageable) throws ApplicationException;
  Page<TrainingAppViewDto> searchBySdCondition(TrainingAppViewSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<TrainingAppViewDto> searchGrpCdByCondition(TrainingAppViewSearchForm criteria) throws ApplicationException;
  List<TrainingAppViewDto> searchServiceByCondition(TrainingAppViewSearchForm criteria) throws ApplicationException;

  Long create(TrainingAppViewDto trainingAppViewDto) throws ApplicationException;
  void create2(TrainingAppViewDto trainingAppViewDto) throws ApplicationException;
  void update(TrainingAppViewDto trainingAppViewDto) throws ApplicationException;
  void delete(TrainingAppViewDto trainingAppViewDto) throws ApplicationException;
  void update2(TrainingAppViewDto trainingAppViewDto) throws ApplicationException;
}
