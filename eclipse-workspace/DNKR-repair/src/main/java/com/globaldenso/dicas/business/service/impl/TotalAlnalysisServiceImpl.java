/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.TotalAlnalysisDao;
import com.globaldenso.dicas.business.dto.TotalAlnalysisDto;
import com.globaldenso.dicas.business.service.TotalAlnalysisService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.TotalAlnalysisSearchForm;
import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
@Service("totalalnalysisService")
public class TotalAlnalysisServiceImpl implements TotalAlnalysisService {

  private static final Logger LOGGER = LoggerFactory.getLogger(TotalAlnalysisServiceImpl.class);

  @Autowired
  private TotalAlnalysisDao totalalnalysisDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public TotalAlnalysisServiceImpl() {
    // no process
  }

  public void setTotalAlnalysisDao(TotalAlnalysisDao totalalnalysisDao) {
    this.totalalnalysisDao = totalalnalysisDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param totalalnalysisDto TotalAlnalysisDto
   */
  @Override
  public TotalAlnalysisDto searchByKey(TotalAlnalysisDto totalalnalysisDto) throws ApplicationException {
    return totalalnalysisDao.searchByKey(totalalnalysisDto);
  }

  @Override
  public Page<TotalAlnalysisDto> searchByCondition(TotalAlnalysisSearchForm criteria, Pageable pageable)
          throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = totalalnalysisDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<TotalAlnalysisDto> totalalnalysisDtos = totalalnalysisDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = totalalnalysisDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(totalalnalysisDtos, pageable, totalCount);
  }

  @Override
  public List<TotalAlnalysisDto> searchGrpCdByCondition(TotalAlnalysisSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<TotalAlnalysisDto> searchTotalAlnalysisByCondition(TotalAlnalysisSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<TotalAlnalysisDto> searchByCondition2(TotalAlnalysisSearchForm criteria, Pageable pageable)
          throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    List<TotalAlnalysisDto> totalalnalysisDtos = totalalnalysisDao.searchByCondition2(searchMap);

    return totalalnalysisDtos;
  }

  @Override
  public List<TotalAlnalysisDto> searchByCondition3(TotalAlnalysisSearchForm criteria, Pageable pageable)
          throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    List<TotalAlnalysisDto> totalalnalysisDtos = totalalnalysisDao.searchByCondition3(searchMap);

    return totalalnalysisDtos;
  }

  @Override
  public List<TotalAlnalysisDto> searchByCondition4(TotalAlnalysisSearchForm criteria, Pageable pageable)
          throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    List<TotalAlnalysisDto> totalalnalysisDtos = totalalnalysisDao.searchByCondition4(searchMap);

    return totalalnalysisDtos;
  }

  @Override
  public List<TotalAlnalysisDto> searchByCondition5(TotalAlnalysisSearchForm criteria, Pageable pageable)
          throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    List<TotalAlnalysisDto> totalalnalysisDtos = totalalnalysisDao.searchByCondition5(searchMap);

    return totalalnalysisDtos;
  }

  /* 종합분석 차트 데이터 처리 */
  @Override
  public Page<TotalAlnalysisDto> searchChartData(TotalAlnalysisSearchForm criteria, Pageable pageable)
            throws ApplicationException {

        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(ParamAttribute.CRITERIA, criteria);
        searchMap.put(ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis(); //???? ?? ??

        int totalCount = 0;
        if (pageable != null)
            totalCount = totalalnalysisDao.searchCount(searchMap);

        long end = System.currentTimeMillis(); //????? ??? ?? ??
        LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

        start = System.currentTimeMillis(); //???? ?? ??

        List<TotalAlnalysisDto> searchChartData = totalalnalysisDao.searchChartData(searchMap);
        if (totalCount == 0) totalCount = searchChartData.size();

        end = System.currentTimeMillis(); //????? ??? ?? ??
        LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

        return new PageImpl<>(searchChartData, pageable, totalCount);
  }

}
