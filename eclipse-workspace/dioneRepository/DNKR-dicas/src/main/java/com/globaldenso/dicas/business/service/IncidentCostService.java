/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.IncidentCostDto;
import com.globaldenso.dicas.presentation.form.IncidentCostSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface IncidentCostService {

  IncidentCostDto searchByKey(IncidentCostDto incidentcostDto) throws ApplicationException;
  Page<IncidentCostDto> searchByCondition(IncidentCostSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<IncidentCostDto> searchGrpCdByCondition(IncidentCostSearchForm criteria) throws ApplicationException;
  List<IncidentCostDto> searchIncidentCostByCondition(IncidentCostSearchForm criteria) throws ApplicationException;

  void create(IncidentCostDto incidentcostDto) throws ApplicationException;
  void update(IncidentCostDto incidentcostDto) throws ApplicationException;
  void delete(IncidentCostDto incidentcostDto) throws ApplicationException;
}
