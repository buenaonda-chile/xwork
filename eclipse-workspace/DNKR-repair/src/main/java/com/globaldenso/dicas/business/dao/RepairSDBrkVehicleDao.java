/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.RepairSDBrkVehicleDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.RepairSDBrkVehicleDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("repairSDBrkVehicleDao")
public interface RepairSDBrkVehicleDao {

  RepairSDBrkVehicleDto searchByKey(RepairSDBrkVehicleDomain domain) throws SystemException;

  List<RepairSDBrkVehicleDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(RepairSDBrkVehicleDomain domain) throws SystemException;

  void update(RepairSDBrkVehicleDomain domain) throws SystemException;

  void delete(RepairSDBrkVehicleDomain domain) throws SystemException;

}
