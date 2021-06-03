/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.VehicleDomain;
import com.globaldenso.dicas.business.dto.VehicleDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Vehicle class of Menu information.<br>
 * [JP] Vehicle class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("vehicleDao")
public interface VehicleDao {

  VehicleDto searchByKey(VehicleDomain domain) throws SystemException;

  List<VehicleDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(VehicleDomain domain) throws SystemException;

  void update(VehicleDomain domain) throws SystemException;

  void delete(VehicleDomain domain) throws SystemException;
}
