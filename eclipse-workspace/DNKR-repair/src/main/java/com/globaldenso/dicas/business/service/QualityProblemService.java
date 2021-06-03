/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.QualityProblemDto;
import com.globaldenso.dicas.presentation.form.QualityProblemSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface QualityProblemService {

  QualityProblemDto searchByKey(QualityProblemDto qualityproblemDto) throws ApplicationException;
  Page<QualityProblemDto> searchByCondition(QualityProblemSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<QualityProblemDto> searchGrpCdByCondition(QualityProblemSearchForm criteria) throws ApplicationException;
  List<QualityProblemDto> searchQualityProblemByCondition(QualityProblemSearchForm criteria) throws ApplicationException;

  void create(QualityProblemDto qualityproblemDto) throws ApplicationException;
  void update(QualityProblemDto qualityproblemDto) throws ApplicationException;
  void delete(QualityProblemDto qualityproblemDto) throws ApplicationException;
}
