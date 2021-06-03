/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.TrainingAppViewDomain;
import com.globaldenso.dicas.business.dto.TrainingAppViewDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("trainingAppViewDao")
public interface TrainingAppViewDao {

	TrainingAppViewDto searchByKey(TrainingAppViewDomain domain) throws SystemException;

  List<TrainingAppViewDto> searchByCondition(Map<String, Object> params) throws SystemException;

  List<TrainingAppViewDto> searchBySdCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  int searchSdCount(Map<String, Object> params) throws SystemException;

  void create(TrainingAppViewDomain domain) throws SystemException;
  
  void create2(TrainingAppViewDomain domain) throws SystemException;

  void update(TrainingAppViewDomain domain) throws SystemException;

  void delete(TrainingAppViewDomain domain) throws SystemException;

  void update2(TrainingAppViewDomain domain) throws SystemException;
}
