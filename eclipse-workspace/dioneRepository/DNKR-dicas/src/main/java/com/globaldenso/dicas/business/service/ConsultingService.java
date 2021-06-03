/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.ConsultingDto;
import com.globaldenso.dicas.presentation.form.ConsultingSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface ConsultingService {

  ConsultingDto searchByKey(ConsultingDto consultingDto) throws ApplicationException;
  Page<ConsultingDto> searchByCondition(ConsultingSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<ConsultingDto> searchGrpCdByCondition(ConsultingSearchForm criteria) throws ApplicationException;
  List<ConsultingDto> searchConsultingByCondition(ConsultingSearchForm criteria) throws ApplicationException;

  void create(ConsultingDto consultingDto) throws ApplicationException;
  void update(ConsultingDto consultingDto) throws ApplicationException;
  void delete(ConsultingDto consultingDto) throws ApplicationException;
}
