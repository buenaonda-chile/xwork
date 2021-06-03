/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.TrainingAppcntViewDto;
import com.globaldenso.dicas.presentation.form.TrainingAppcntViewSearchForm;
import com.globaldenso.dicas.presentation.form.TrainingInfoBaseSearchForm;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface TrainingAppcntViewService {

  TrainingAppcntViewDto searchByKey(TrainingAppcntViewDto trainingAppcntViewDto) throws ApplicationException;
  Page<TrainingAppcntViewDto> searchByCondition(TrainingAppcntViewSearchForm criteria, Pageable pageable) throws ApplicationException;
  Page<TrainingAppcntViewDto> searchBySdCondition(TrainingAppcntViewSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<TrainingAppcntViewDto> searchGrpCdByCondition(TrainingAppcntViewSearchForm criteria) throws ApplicationException;
  List<TrainingAppcntViewDto> searchServiceByCondition(TrainingAppcntViewSearchForm criteria) throws ApplicationException;

  void create(TrainingAppcntViewDto trainingAppcntViewDto) throws ApplicationException;
  void update(TrainingAppcntViewDto trainingAppcntViewDto) throws ApplicationException;
  void delete(TrainingAppcntViewDto trainingAppcntViewDto) throws ApplicationException;
  void update2(TrainingAppcntViewDto trainingAppcntViewDto) throws ApplicationException;
}
