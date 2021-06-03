/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.VehicleViewDomain;
import com.globaldenso.dicas.business.dto.VehicleViewDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] VehicleView class of Menu information.<br>
 * [JP] VehicleView class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("vehicleviewDao")
public interface VehicleViewDao {

  VehicleViewDto searchByKey(VehicleViewDomain domain) throws SystemException;

  List<VehicleViewDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(VehicleViewDomain domain) throws SystemException;

  void update(VehicleViewDomain domain) throws SystemException;

  void delete(VehicleViewDomain domain) throws SystemException;
}
