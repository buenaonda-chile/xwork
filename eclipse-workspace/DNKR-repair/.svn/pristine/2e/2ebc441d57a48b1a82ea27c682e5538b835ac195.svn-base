/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.PhenomenonSubDto;
import com.globaldenso.dicas.presentation.form.PhenomenonSubSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface PhenomenonSubService {

  PhenomenonSubDto searchByKey(PhenomenonSubDto phenomenonsubDto) throws ApplicationException;
  Page<PhenomenonSubDto> searchByCondition(PhenomenonSubSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<PhenomenonSubDto> searchGrpCdByCondition(PhenomenonSubSearchForm criteria) throws ApplicationException;
  List<PhenomenonSubDto> searchPhenomenonSubByCondition(PhenomenonSubSearchForm criteria) throws ApplicationException;

  void create(PhenomenonSubDto phenomenonsubDto) throws ApplicationException;
  void update(PhenomenonSubDto phenomenonsubDto) throws ApplicationException;
  void delete(PhenomenonSubDto phenomenonsubDto) throws ApplicationException;
}
