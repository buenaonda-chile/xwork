/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.RepairCDInfoDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.RepairCDInfoDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("repairCDInfoDao")
public interface RepairCDInfoDao {

	RepairCDInfoDto searchByKey(RepairCDInfoDomain domain) throws SystemException;

  List<RepairCDInfoDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(RepairCDInfoDomain domain) throws SystemException;
  
  void update(RepairCDInfoDomain domain) throws SystemException;
  
  void delete(RepairCDInfoDomain domain) throws SystemException;

}
