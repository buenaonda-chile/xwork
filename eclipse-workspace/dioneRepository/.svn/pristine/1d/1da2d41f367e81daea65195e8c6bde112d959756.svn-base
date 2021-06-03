/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.PartNameDao;
import com.globaldenso.dicas.business.dto.PartNameDto;
import com.globaldenso.dicas.business.service.PartNameService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.PartNameSearchForm;
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
@Service("partnameService")
public class PartNameServiceImpl implements PartNameService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PartNameServiceImpl.class);

  @Autowired
  private PartNameDao partnameDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public PartNameServiceImpl() {
    // no process
  }

  public void setPartNameDao(PartNameDao partnameDao) {
    this.partnameDao = partnameDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param partnameDto PartNameDto
   */
  @Override
  public PartNameDto searchByKey(PartNameDto partnameDto) throws ApplicationException {
    return partnameDao.searchByKey(partnameDto);
  }

  @Override
  public Page<PartNameDto> searchByCondition(PartNameSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = partnameDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<PartNameDto> partnameDtos = partnameDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = partnameDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(partnameDtos, pageable, totalCount);
  }

  @Override
  public List<PartNameDto> searchGrpCdByCondition(PartNameSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<PartNameDto> searchPartNameByCondition(PartNameSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(PartNameDto partnameDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    partnameDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    partnameDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    partnameDao.create(partnameDto);
  }

  @Override
  public void update(PartNameDto partnameDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    partnameDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    partnameDao.update(partnameDto);
  }

  @Override
  public void delete(PartNameDto partnameDto) throws ApplicationException {
    partnameDao.delete(partnameDto);
  }
}
