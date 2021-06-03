/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.RepairSDBrkVehicleDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.RepairSDBrkVehicleSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface RepairSDBrkVehicleService {

  RepairSDBrkVehicleDto searchByKey(RepairSDBrkVehicleDto repairSDBrkVehicleDto) throws ApplicationException;
  Page<RepairSDBrkVehicleDto> searchByCondition(RepairSDBrkVehicleSearchForm criteria, Pageable pageable) throws ApplicationException;

  void create(RepairSDBrkVehicleDto repairSDBrkVehicleDto) throws ApplicationException;
  void update(RepairSDBrkVehicleDto repairSDBrkVehicleDto) throws ApplicationException;
  void delete(RepairSDBrkVehicleDto repairSDBrkVehicleDto) throws ApplicationException;
}
