/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.TrainingAppcntStatDto;
import com.globaldenso.dicas.presentation.form.TrainingAppcntStatSearchForm;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface TrainingAppcntStatService {

  TrainingAppcntStatDto searchByKey(TrainingAppcntStatDto trainingAppcntStatDto) throws ApplicationException;
  Page<TrainingAppcntStatDto> searchByCondition(TrainingAppcntStatSearchForm criteria, Pageable pageable) throws ApplicationException;
  Page<TrainingAppcntStatDto> searchBySdCondition(TrainingAppcntStatSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<TrainingAppcntStatDto> searchGrpCdByCondition(TrainingAppcntStatSearchForm criteria) throws ApplicationException;
  List<TrainingAppcntStatDto> searchServiceByCondition(TrainingAppcntStatSearchForm criteria) throws ApplicationException;

  void create(TrainingAppcntStatDto trainingAppcntStatDto) throws ApplicationException;
  void update(TrainingAppcntStatDto trainingAppcntStatDto) throws ApplicationException;
  void delete(TrainingAppcntStatDto trainingAppcntStatDto) throws ApplicationException;
  void update2(TrainingAppcntStatDto trainingAppcntStatDto) throws ApplicationException;
}
