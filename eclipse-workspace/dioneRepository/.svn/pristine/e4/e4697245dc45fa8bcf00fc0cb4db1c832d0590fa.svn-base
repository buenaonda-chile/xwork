/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ResultSubDao;
import com.globaldenso.dicas.business.dto.ResultSubDto;
import com.globaldenso.dicas.business.service.ResultSubService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultSubSearchForm;
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
@Service("resultsubService")
public class ResultSubServiceImpl implements ResultSubService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResultSubServiceImpl.class);

  @Autowired
  private ResultSubDao resultsubDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ResultSubServiceImpl() {
    // no process
  }

  public void setResultSubDao(ResultSubDao resultsubDao) {
    this.resultsubDao = resultsubDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param resultsubDto ResultSubDto
   */
  @Override
  public ResultSubDto searchByKey(ResultSubDto resultsubDto) throws ApplicationException {
    return resultsubDao.searchByKey(resultsubDto);
  }

  @Override
  public Page<ResultSubDto> searchByCondition(ResultSubSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = resultsubDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<ResultSubDto> resultsubDtos = resultsubDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = resultsubDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(resultsubDtos, pageable, totalCount);
  }

  @Override
  public List<ResultSubDto> searchGrpCdByCondition(ResultSubSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<ResultSubDto> searchResultSubByCondition(ResultSubSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(ResultSubDto resultsubDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    resultsubDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    resultsubDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    resultsubDao.create(resultsubDto);
  }

  @Override
  public void update(ResultSubDto resultsubDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    resultsubDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    resultsubDao.update(resultsubDto);
  }

  @Override
  public void delete(ResultSubDto resultsubDto) throws ApplicationException {
    resultsubDao.delete(resultsubDto);
  }
}
