/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.TotalAlnalysisDto;
import com.globaldenso.dicas.presentation.form.TotalAlnalysisSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface TotalAlnalysisService {

  TotalAlnalysisDto searchByKey(TotalAlnalysisDto totalalnalysisDto) throws ApplicationException;
  Page<TotalAlnalysisDto> searchByCondition(TotalAlnalysisSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<TotalAlnalysisDto> searchGrpCdByCondition(TotalAlnalysisSearchForm criteria) throws ApplicationException;
  List<TotalAlnalysisDto> searchTotalAlnalysisByCondition(TotalAlnalysisSearchForm criteria) throws ApplicationException;


  List<TotalAlnalysisDto> searchByCondition2(TotalAlnalysisSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<TotalAlnalysisDto> searchByCondition3(TotalAlnalysisSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<TotalAlnalysisDto> searchByCondition4(TotalAlnalysisSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<TotalAlnalysisDto> searchByCondition5(TotalAlnalysisSearchForm criteria, Pageable pageable) throws ApplicationException;

  /* 종합분석 차트 데이터 처리 */
  Page<TotalAlnalysisDto> searchChartData(TotalAlnalysisSearchForm criteria, Pageable pageable) throws ApplicationException;

}
