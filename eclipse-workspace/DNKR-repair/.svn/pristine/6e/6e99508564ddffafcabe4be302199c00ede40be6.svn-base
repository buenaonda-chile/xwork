/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.TrainingAppcntViewDomain;
import com.globaldenso.dicas.business.dto.TrainingAppcntViewDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] Service class of Menu information.<br>
 * [JP] Service class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("trainingAppcntViewDao")
public interface TrainingAppcntViewDao {

  TrainingAppcntViewDto searchByKey(TrainingAppcntViewDomain domain) throws SystemException;

  List<TrainingAppcntViewDto> searchByCondition(Map<String, Object> params) throws SystemException;

  List<TrainingAppcntViewDto> searchBySdCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  int searchSdCount(Map<String, Object> params) throws SystemException;

  void create(TrainingAppcntViewDomain domain) throws SystemException;

  void update(TrainingAppcntViewDomain domain) throws SystemException;

  void delete(TrainingAppcntViewDomain domain) throws SystemException;

  void update2(TrainingAppcntViewDomain domain) throws SystemException;
}
