/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.ResultSubDto;
import com.globaldenso.dicas.presentation.form.ResultSubSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface ResultSubService {

  ResultSubDto searchByKey(ResultSubDto resultsubDto) throws ApplicationException;
  Page<ResultSubDto> searchByCondition(ResultSubSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<ResultSubDto> searchGrpCdByCondition(ResultSubSearchForm criteria) throws ApplicationException;
  List<ResultSubDto> searchResultSubByCondition(ResultSubSearchForm criteria) throws ApplicationException;

  void create(ResultSubDto resultsubDto) throws ApplicationException;
  void update(ResultSubDto resultsubDto) throws ApplicationException;
  void delete(ResultSubDto resultsubDto) throws ApplicationException;
}
