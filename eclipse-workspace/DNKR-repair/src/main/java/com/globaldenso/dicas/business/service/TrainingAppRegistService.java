/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.TrainingAppRegistDto;
import com.globaldenso.dicas.presentation.form.TrainingAppRegistSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface TrainingAppRegistService {

  TrainingAppRegistDto searchByKey(TrainingAppRegistDto trainingAppRegistDto) throws ApplicationException;
  Page<TrainingAppRegistDto> searchByCondition(TrainingAppRegistSearchForm criteria, Pageable pageable) throws ApplicationException;
  Page<TrainingAppRegistDto> searchBySdCondition(TrainingAppRegistSearchForm criteria, Pageable pageable) throws ApplicationException;
  Page<TrainingAppRegistDto> searchBySdCondition2(TrainingAppRegistSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<TrainingAppRegistDto> searchGrpCdByCondition(TrainingAppRegistSearchForm criteria) throws ApplicationException;
  List<TrainingAppRegistDto> searchServiceByCondition(TrainingAppRegistSearchForm criteria) throws ApplicationException;
  List<TrainingAppRegistDto> searchServiceByCondition2(TrainingAppRegistSearchForm criteria) throws ApplicationException;

  Long create(TrainingAppRegistDto trainingAppRegistDto) throws ApplicationException;
  void create2(TrainingAppRegistDto trainingAppRegistDto) throws ApplicationException;
  void update(TrainingAppRegistDto trainingAppRegistDto) throws ApplicationException;
  void delete(TrainingAppRegistDto trainingAppRegistDto) throws ApplicationException;
  void update2(TrainingAppRegistDto trainingAppRegistDto) throws ApplicationException;
}
