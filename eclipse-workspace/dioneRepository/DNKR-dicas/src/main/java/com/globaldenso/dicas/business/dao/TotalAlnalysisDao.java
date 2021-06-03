/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.TotalAlnalysisDomain;
import com.globaldenso.dicas.business.dto.TotalAlnalysisDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] TotalAlnalysis class of Menu information.<br>
 * [JP] TotalAlnalysis class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("totalalnalysisDao")
public interface TotalAlnalysisDao {

  TotalAlnalysisDto searchByKey(TotalAlnalysisDomain domain) throws SystemException;

  List<TotalAlnalysisDto> searchByCondition(Map<String, Object> params) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  List<TotalAlnalysisDto> searchByCondition2(Map<String, Object> params) throws SystemException;
  List<TotalAlnalysisDto> searchByCondition3(Map<String, Object> params) throws SystemException;
  List<TotalAlnalysisDto> searchByCondition4(Map<String, Object> params) throws SystemException;
  List<TotalAlnalysisDto> searchByCondition5(Map<String, Object> params) throws SystemException;

  /* 종합분석 차트 데이터 */
  List<TotalAlnalysisDto> searchChartData(Map<String, Object> params) throws SystemException;
}
