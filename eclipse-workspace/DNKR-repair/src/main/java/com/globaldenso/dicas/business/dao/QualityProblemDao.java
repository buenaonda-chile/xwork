/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.QualityProblemDomain;
import com.globaldenso.dicas.business.dto.QualityProblemDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] QualityProblem class of Menu information.<br>
 * [JP] QualityProblem class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("qualityproblemDao")
public interface QualityProblemDao {

  QualityProblemDto searchByKey(QualityProblemDomain domain) throws SystemException;

  List<QualityProblemDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  void create(QualityProblemDomain domain) throws SystemException;

  void update(QualityProblemDomain domain) throws SystemException;

  void delete(QualityProblemDomain domain) throws SystemException;
}
