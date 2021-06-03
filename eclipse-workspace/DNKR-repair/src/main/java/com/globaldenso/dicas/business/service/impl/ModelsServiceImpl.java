/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ModelsDao;
import com.globaldenso.dicas.business.dto.ModelsDto;
import com.globaldenso.dicas.business.service.ModelsService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ModelsSearchForm;
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
@Service("modelsService")
public class ModelsServiceImpl implements ModelsService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ModelsServiceImpl.class);

  @Autowired
  private ModelsDao modelsDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ModelsServiceImpl() {
    // no process
  }

  public void setModelsDao(ModelsDao modelsDao) {
    this.modelsDao = modelsDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param modelsDto ModelsDto
   */
  @Override
  public ModelsDto searchByKey(ModelsDto modelsDto) throws ApplicationException {
    return modelsDao.searchByKey(modelsDto);
  }

  @Override
  public Page<ModelsDto> searchByCondition(ModelsSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = modelsDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<ModelsDto> modelsDtos = modelsDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = modelsDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(modelsDtos, pageable, totalCount);
  }

  @Override
  public List<ModelsDto> searchGrpCdByCondition(ModelsSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<ModelsDto> searchModelsByCondition(ModelsSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(ModelsDto modelsDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    modelsDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    modelsDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    modelsDao.create(modelsDto);
  }

  @Override
  public void update(ModelsDto modelsDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    modelsDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    modelsDao.update(modelsDto);
  }

  @Override
  public void delete(ModelsDto modelsDto) throws ApplicationException {
    modelsDao.delete(modelsDto);
  }
}
