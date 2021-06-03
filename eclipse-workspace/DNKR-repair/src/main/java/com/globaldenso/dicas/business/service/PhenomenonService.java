/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.PhenomenonDto;
import com.globaldenso.dicas.presentation.form.PhenomenonSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface PhenomenonService {

  PhenomenonDto searchByKey(PhenomenonDto phenomenonDto) throws ApplicationException;
  Page<PhenomenonDto> searchByCondition(PhenomenonSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<PhenomenonDto> searchGrpCdByCondition(PhenomenonSearchForm criteria) throws ApplicationException;
  List<PhenomenonDto> searchPhenomenonByCondition(PhenomenonSearchForm criteria) throws ApplicationException;

  void create(PhenomenonDto phenomenonDto) throws ApplicationException;
  void update(PhenomenonDto phenomenonDto) throws ApplicationException;
  void delete(PhenomenonDto phenomenonDto) throws ApplicationException;
}
