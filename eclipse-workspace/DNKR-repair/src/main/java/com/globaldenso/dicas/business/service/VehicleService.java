/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.VehicleDto;
import com.globaldenso.dicas.presentation.form.VehicleSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface VehicleService {

  VehicleDto searchByKey(VehicleDto vehicleDto) throws ApplicationException;
  Page<VehicleDto> searchByCondition(VehicleSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<VehicleDto> searchGrpCdByCondition(VehicleSearchForm criteria) throws ApplicationException;
  List<VehicleDto> searchVehicleByCondition(VehicleSearchForm criteria) throws ApplicationException;

  void create(VehicleDto vehicleDto) throws ApplicationException;
  void update(VehicleDto vehicleDto) throws ApplicationException;
  void delete(VehicleDto vehicleDto) throws ApplicationException;
}
