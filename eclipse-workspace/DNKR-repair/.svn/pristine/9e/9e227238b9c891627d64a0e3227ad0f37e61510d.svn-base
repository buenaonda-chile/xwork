/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.TrainingAppRegistDomain;
import com.globaldenso.dicas.business.dto.TrainingAppRegistDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("trainingAppRegistDao")
public interface TrainingAppRegistDao {

	TrainingAppRegistDto searchByKey(TrainingAppRegistDomain domain) throws SystemException;

  List<TrainingAppRegistDto> searchByCondition(Map<String, Object> params) throws SystemException;

  List<TrainingAppRegistDto> searchBySdCondition(Map<String, Object> params) throws SystemException;
  
  List<TrainingAppRegistDto> searchBySdCondition2(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  int searchSdCount(Map<String, Object> params) throws SystemException;

  void create(TrainingAppRegistDomain domain) throws SystemException;
  
  void create2(TrainingAppRegistDomain domain) throws SystemException;

  void update(TrainingAppRegistDomain domain) throws SystemException;

  void delete(TrainingAppRegistDomain domain) throws SystemException;

  void update2(TrainingAppRegistDomain domain) throws SystemException;
}
