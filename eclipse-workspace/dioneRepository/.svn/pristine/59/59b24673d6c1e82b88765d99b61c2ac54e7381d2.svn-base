/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.ResultMasterCostDto;
import com.globaldenso.dicas.presentation.form.ResultMasterCostSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface ResultMasterCostService {

  ResultMasterCostDto searchByKey(ResultMasterCostDto resultmastercostDto) throws ApplicationException;
  Page<ResultMasterCostDto> searchByCondition(ResultMasterCostSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<ResultMasterCostDto> searchGrpCdByCondition(ResultMasterCostSearchForm criteria) throws ApplicationException;
  List<ResultMasterCostDto> searchResultMasterCostByCondition(ResultMasterCostSearchForm criteria) throws ApplicationException;

  void create(ResultMasterCostDto resultmastercostDto) throws ApplicationException;
  void update(ResultMasterCostDto resultmastercostDto) throws ApplicationException;
  void delete(ResultMasterCostDto resultmastercostDto) throws ApplicationException;
  void delete2(ResultMasterCostDto resultmastercostDto) throws ApplicationException;
}
