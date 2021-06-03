/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.PartNameDto;
import com.globaldenso.dicas.presentation.form.PartNameSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface PartNameService {

  PartNameDto searchByKey(PartNameDto partnameDto) throws ApplicationException;
  Page<PartNameDto> searchByCondition(PartNameSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<PartNameDto> searchGrpCdByCondition(PartNameSearchForm criteria) throws ApplicationException;
  List<PartNameDto> searchPartNameByCondition(PartNameSearchForm criteria) throws ApplicationException;

  void create(PartNameDto partnameDto) throws ApplicationException;
  void update(PartNameDto partnameDto) throws ApplicationException;
  void delete(PartNameDto partnameDto) throws ApplicationException;
}
