/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.TrainingAppcntStatDomain;
import com.globaldenso.dicas.business.dto.TrainingAppcntStatDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("trainingAppcntStatDao")
public interface TrainingAppcntStatDao {

	TrainingAppcntStatDto searchByKey(TrainingAppcntStatDomain domain) throws SystemException;

  List<TrainingAppcntStatDto> searchByCondition(Map<String, Object> params) throws SystemException;

  List<TrainingAppcntStatDto> searchBySdCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  int searchSdCount(Map<String, Object> params) throws SystemException;

  void create(TrainingAppcntStatDomain domain) throws SystemException;

  void update(TrainingAppcntStatDomain domain) throws SystemException;

  void delete(TrainingAppcntStatDomain domain) throws SystemException;

  void update2(TrainingAppcntStatDomain domain) throws SystemException;
}
