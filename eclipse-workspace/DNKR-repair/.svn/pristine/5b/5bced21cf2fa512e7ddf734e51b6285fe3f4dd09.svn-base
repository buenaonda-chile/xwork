/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.TrainingInfoBaseDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.TrainingInfoBaseDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("trainingInfoBaseDao")
public interface TrainingInfoBaseDao {

  TrainingInfoBaseDto searchByKey(TrainingInfoBaseDomain domain) throws SystemException;

  List<TrainingInfoBaseDto> searchByCondition(Map<String, Object> params) throws SystemException;

  List<TrainingInfoBaseDto> searchBySdCondition(Map<String, Object> params) throws SystemException;
  
  List<TrainingInfoBaseDto> searchListByConditionDownload(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  int searchSdCount(Map<String, Object> params) throws SystemException;

  void create(TrainingInfoBaseDomain domain) throws SystemException;

  void update(TrainingInfoBaseDomain domain) throws SystemException;

  void delete(TrainingInfoBaseDomain domain) throws SystemException;

  void update2(TrainingInfoBaseDomain domain) throws SystemException;
}
