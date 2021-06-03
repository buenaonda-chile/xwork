/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ResultMasterCostDao;
import com.globaldenso.dicas.business.dto.ResultMasterCostDto;
import com.globaldenso.dicas.business.service.ResultMasterCostService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterCostSearchForm;
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
@Service("resultmastercostService")
public class ResultMasterCostServiceImpl implements ResultMasterCostService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResultMasterCostServiceImpl.class);

  @Autowired
  private ResultMasterCostDao resultmastercostDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ResultMasterCostServiceImpl() {
    // no process
  }

  public void setResultMasterCostDao(ResultMasterCostDao resultmastercostDao) {
    this.resultmastercostDao = resultmastercostDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param resultmastercostDto ResultMasterCostDto
   */
  @Override
  public ResultMasterCostDto searchByKey(ResultMasterCostDto resultmastercostDto) throws ApplicationException {
    return resultmastercostDao.searchByKey(resultmastercostDto);
  }

  @Override
  public Page<ResultMasterCostDto> searchByCondition(ResultMasterCostSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = resultmastercostDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<ResultMasterCostDto> resultmastercostDtos = resultmastercostDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = resultmastercostDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(resultmastercostDtos, pageable, totalCount);
  }

  @Override
  public List<ResultMasterCostDto> searchGrpCdByCondition(ResultMasterCostSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<ResultMasterCostDto> searchResultMasterCostByCondition(ResultMasterCostSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(ResultMasterCostDto resultmastercostDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    resultmastercostDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    resultmastercostDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
    resultmastercostDto.setUpdUserId(loginVO.getUniqId());

    resultmastercostDao.create(resultmastercostDto);
  }

  @Override
  public void update(ResultMasterCostDto resultmastercostDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    resultmastercostDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
    resultmastercostDto.setUpdUserId(loginVO.getUniqId());

    resultmastercostDao.update(resultmastercostDto);
  }

  @Override
  public void delete(ResultMasterCostDto resultmastercostDto) throws ApplicationException {
    resultmastercostDao.delete(resultmastercostDto);
  }

  @Override
  public void delete2(ResultMasterCostDto resultmastercostDto) throws ApplicationException {
    resultmastercostDao.delete2(resultmastercostDto);
  }
}
