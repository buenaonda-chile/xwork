/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.OfficeDetailDto;
import com.globaldenso.dicas.presentation.form.OfficeDetailSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface OfficeDetailService {

  OfficeDetailDto searchByKey(OfficeDetailDto officedetailDto) throws ApplicationException;
  Page<OfficeDetailDto> searchByCondition(OfficeDetailSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<OfficeDetailDto> searchGrpCdByCondition(OfficeDetailSearchForm criteria) throws ApplicationException;
  List<OfficeDetailDto> searchOfficeDetailByCondition(OfficeDetailSearchForm criteria) throws ApplicationException;

  void create(OfficeDetailDto officedetailDto) throws ApplicationException;
  void update(OfficeDetailDto officedetailDto) throws ApplicationException;
  void delete(OfficeDetailDto officedetailDto) throws ApplicationException;
}
