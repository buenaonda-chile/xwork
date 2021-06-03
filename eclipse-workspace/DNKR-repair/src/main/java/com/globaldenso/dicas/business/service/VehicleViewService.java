/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.VehicleViewDto;
import com.globaldenso.dicas.presentation.form.VehicleViewSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface VehicleViewService {

  VehicleViewDto searchByKey(VehicleViewDto vehicleviewDto) throws ApplicationException;
  Page<VehicleViewDto> searchByCondition(VehicleViewSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<VehicleViewDto> searchGrpCdByCondition(VehicleViewSearchForm criteria) throws ApplicationException;
  List<VehicleViewDto> searchVehicleViewByCondition(VehicleViewSearchForm criteria) throws ApplicationException;

  void create(VehicleViewDto vehicleviewDto) throws ApplicationException;
  void update(VehicleViewDto vehicleviewDto) throws ApplicationException;
  void delete(VehicleViewDto vehicleviewDto) throws ApplicationException;
}
