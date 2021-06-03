/*
 * Project : DICAS
 *
 * ryan.lee
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.DtcDto;
import com.globaldenso.dicas.presentation.form.DtcSearchForm;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface DtcService {

  DtcDto searchByKey(DtcDto dtcDto) throws ApplicationException;
  Page<DtcDto> searchByCondition(DtcSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<DtcDto> searchGrpCdByCondition(DtcSearchForm criteria) throws ApplicationException;
  List<DtcDto> searchModelsByCondition(DtcSearchForm criteria) throws ApplicationException;
  List<DtcDto> searchDtcByCondition2(DtcSearchForm criteria) throws ApplicationException;

  void create(DtcDto dtcDto) throws ApplicationException;
  void update(DtcDto dtcDto) throws ApplicationException;
  void delete(DtcDto dtcDto) throws ApplicationException;
}
