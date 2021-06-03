/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.OfficeDto;
import com.globaldenso.dicas.presentation.form.OfficeSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface OfficeService {

  OfficeDto searchByKey(OfficeDto officeDto) throws ApplicationException;
  Page<OfficeDto> searchByCondition(OfficeSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<OfficeDto> searchGrpCdByCondition(OfficeSearchForm criteria) throws ApplicationException;
  List<OfficeDto> searchOfficeByCondition(OfficeSearchForm criteria) throws ApplicationException;

  void create(OfficeDto officeDto) throws ApplicationException;
  void update(OfficeDto officeDto) throws ApplicationException;
  void delete(OfficeDto officeDto) throws ApplicationException;
}
