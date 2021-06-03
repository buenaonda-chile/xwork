/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.TrainingInfoBaseDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
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
public interface TrainingInfoBaseService {

  TrainingInfoBaseDto searchByKey(TrainingInfoBaseDto trainingInfoBaseDto) throws ApplicationException;
  Page<TrainingInfoBaseDto> searchByCondition(TrainingInfoBaseSearchForm criteria, Pageable pageable) throws ApplicationException;
  Page<TrainingInfoBaseDto> searchBySdCondition(TrainingInfoBaseSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<TrainingInfoBaseDto> searchGrpCdByCondition(TrainingInfoBaseSearchForm criteria) throws ApplicationException;
  List<TrainingInfoBaseDto> searchServiceByCondition(TrainingInfoBaseSearchForm criteria) throws ApplicationException;
  Page<TrainingInfoBaseDto> searchListByConditionDownload(TrainingInfoBaseSearchForm criteria, Pageable pageable) throws ApplicationException;

  void create(TrainingInfoBaseDto trainingInfoBaseDto) throws ApplicationException;
  void update(TrainingInfoBaseDto trainingInfoBaseDto) throws ApplicationException;
  void delete(TrainingInfoBaseDto trainingInfoBaseDto) throws ApplicationException;
  void update2(TrainingInfoBaseDto trainingInfoBaseDto) throws ApplicationException;
}
