/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.PartNumberDao;
import com.globaldenso.dicas.business.dto.PartNumberDto;
import com.globaldenso.dicas.business.service.PartNumberService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.PartNumberSearchForm;
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
@Service("partnumberService")
public class PartNumberServiceImpl implements PartNumberService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PartNumberServiceImpl.class);

  @Autowired
  private PartNumberDao partnumberDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public PartNumberServiceImpl() {
    // no process
  }

  public void setPartNumberDao(PartNumberDao partnumberDao) {
    this.partnumberDao = partnumberDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param partnumberDto PartNumberDto
   */
  @Override
  public PartNumberDto searchByKey(PartNumberDto partnumberDto) throws ApplicationException {
    return partnumberDao.searchByKey(partnumberDto);
  }

  @Override
  public Page<PartNumberDto> searchByCondition(PartNumberSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = partnumberDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<PartNumberDto> partnumberDtos = partnumberDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = partnumberDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(partnumberDtos, pageable, totalCount);
  }

  @Override
  public List<PartNumberDto> searchGrpCdByCondition(PartNumberSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<PartNumberDto> searchPartNumberByCondition(PartNumberSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(PartNumberDto partnumberDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    partnumberDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    partnumberDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    partnumberDao.create(partnumberDto);
  }

  @Override
  public void update(PartNumberDto partnumberDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    partnumberDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    partnumberDao.update(partnumberDto);
  }

  @Override
  public void delete(PartNumberDto partnumberDto) throws ApplicationException {
    partnumberDao.delete(partnumberDto);
  }
}
