/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.ResearchDto;
import com.globaldenso.dicas.presentation.form.ResearchSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface ResearchService {

  ResearchDto searchByKey(ResearchDto researchDto) throws ApplicationException;
  Page<ResearchDto> searchByCondition(ResearchSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<ResearchDto> searchGrpCdByCondition(ResearchSearchForm criteria) throws ApplicationException;
  List<ResearchDto> searchResearchByCondition(ResearchSearchForm criteria) throws ApplicationException;
  List<ResearchDto> searchByConditionFile(String manageNo) throws ApplicationException;

  void create(ResearchDto researchDto) throws ApplicationException;
  void update(ResearchDto researchDto) throws ApplicationException;
  void delete(ResearchDto researchDto) throws ApplicationException;

  List<ResearchDto> searchByConditionCostApprInfo(String manageNo) throws ApplicationException;
}
