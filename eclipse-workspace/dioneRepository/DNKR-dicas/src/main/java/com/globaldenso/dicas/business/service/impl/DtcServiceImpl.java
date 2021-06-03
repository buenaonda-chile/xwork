/*
 * Project : DICAS
 *
 * ryan.lee
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.DtcDao;
import com.globaldenso.dicas.business.dto.DtcDto;
import com.globaldenso.dicas.business.service.DtcService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.DtcSearchForm;
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
@Service("dtcService")
public class DtcServiceImpl implements DtcService {

  private static final Logger LOGGER = LoggerFactory.getLogger(DtcServiceImpl.class);

  @Autowired
  private DtcDao dtcDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public DtcServiceImpl() {
    // no process
  }

  public void setDtcDao(DtcDao dtcDao) {
    this.dtcDao = dtcDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param dtcDto DtcDto
   */
  @Override
  public DtcDto searchByKey(DtcDto dtcDto) throws ApplicationException {
    return dtcDao.searchByKey(dtcDto);
  }

  @Override
  public Page<DtcDto> searchByCondition(DtcSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis();

    int totalCount = 0;
    if (pageable != null)
      totalCount = dtcDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis();

    List<DtcDto> dtcDtos = dtcDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = dtcDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(dtcDtos, pageable, totalCount);
  }

  @Override
  public List<DtcDto> searchGrpCdByCondition(DtcSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<DtcDto> searchModelsByCondition(DtcSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<DtcDto> searchDtcByCondition2(DtcSearchForm criteria) throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);

    long start = System.currentTimeMillis();

    List<DtcDto> dtcDtos = dtcDao.searchByCondition2(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return dtcDtos;
  }

  @Override
  public void create(DtcDto dtcDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    dtcDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    dtcDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    dtcDao.create(dtcDto);
  }

  @Override
  public void update(DtcDto dtcDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    dtcDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    dtcDao.update(dtcDto);
  }

  @Override
  public void delete(DtcDto dtcDto) throws ApplicationException {
    dtcDao.delete(dtcDto);
  }
}
