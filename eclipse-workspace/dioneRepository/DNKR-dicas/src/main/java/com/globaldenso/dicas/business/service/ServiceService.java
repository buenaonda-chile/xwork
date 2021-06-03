/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.ServiceDto;
import com.globaldenso.dicas.presentation.form.ServiceSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface ServiceService {

  ServiceDto searchByKey(ServiceDto serviceDto) throws ApplicationException;
  Page<ServiceDto> searchByCondition(ServiceSearchForm criteria, Pageable pageable) throws ApplicationException;
  Page<ServiceDto> searchBySdCondition(ServiceSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<ServiceDto> searchGrpCdByCondition(ServiceSearchForm criteria) throws ApplicationException;
  List<ServiceDto> searchServiceByCondition(ServiceSearchForm criteria) throws ApplicationException;

  void create(ServiceDto serviceDto) throws ApplicationException;
  void update(ServiceDto serviceDto) throws ApplicationException;
  void delete(ServiceDto serviceDto) throws ApplicationException;
  void update2(ServiceDto serviceDto) throws ApplicationException;
}
