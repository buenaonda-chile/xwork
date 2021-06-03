/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.EngineTypeDao;
import com.globaldenso.dicas.business.dto.EngineTypeDto;
import com.globaldenso.dicas.business.service.EngineTypeService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.EngineTypeSearchForm;
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
@Service("enginetypeService")
public class EngineTypeServiceImpl implements EngineTypeService {

  private static final Logger LOGGER = LoggerFactory.getLogger(EngineTypeServiceImpl.class);

  @Autowired
  private EngineTypeDao enginetypeDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public EngineTypeServiceImpl() {
    // no process
  }

  public void setEngineTypeDao(EngineTypeDao enginetypeDao) {
    this.enginetypeDao = enginetypeDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param enginetypeDto EngineTypeDto
   */
  @Override
  public EngineTypeDto searchByKey(EngineTypeDto enginetypeDto) throws ApplicationException {
    return enginetypeDao.searchByKey(enginetypeDto);
  }

  @Override
  public Page<EngineTypeDto> searchByCondition(EngineTypeSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = enginetypeDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<EngineTypeDto> enginetypeDtos = enginetypeDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = enginetypeDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(enginetypeDtos, pageable, totalCount);
  }

  @Override
  public List<EngineTypeDto> searchGrpCdByCondition(EngineTypeSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<EngineTypeDto> searchEngineTypeByCondition(EngineTypeSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(EngineTypeDto enginetypeDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    enginetypeDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    enginetypeDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    enginetypeDao.create(enginetypeDto);
  }

  @Override
  public void update(EngineTypeDto enginetypeDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    enginetypeDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    enginetypeDao.update(enginetypeDto);
  }

  @Override
  public void delete(EngineTypeDto enginetypeDto) throws ApplicationException {
    enginetypeDao.delete(enginetypeDto);
  }
}
