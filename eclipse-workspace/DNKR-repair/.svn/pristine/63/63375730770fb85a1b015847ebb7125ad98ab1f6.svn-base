/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.OfficeDao;
import com.globaldenso.dicas.business.dto.OfficeDto;
import com.globaldenso.dicas.business.service.OfficeService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.OfficeSearchForm;
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
@Service("officeService")
public class OfficeServiceImpl implements OfficeService {

  private static final Logger LOGGER = LoggerFactory.getLogger(OfficeServiceImpl.class);

  @Autowired
  private OfficeDao officeDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public OfficeServiceImpl() {
    // no process
  }

  public void setOfficeDao(OfficeDao officeDao) {
    this.officeDao = officeDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param officeDto OfficeDto
   */
  @Override
  public OfficeDto searchByKey(OfficeDto officeDto) throws ApplicationException {
    return officeDao.searchByKey(officeDto);
  }

  @Override
  public Page<OfficeDto> searchByCondition(OfficeSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = officeDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<OfficeDto> officeDtos = officeDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = officeDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(officeDtos, pageable, totalCount);
  }

  @Override
  public List<OfficeDto> searchGrpCdByCondition(OfficeSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<OfficeDto> searchOfficeByCondition(OfficeSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(OfficeDto officeDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    officeDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    officeDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    officeDao.create(officeDto);
  }

  @Override
  public void update(OfficeDto officeDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    officeDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    officeDao.update(officeDto);
  }

  @Override
  public void delete(OfficeDto officeDto) throws ApplicationException {
    officeDao.delete(officeDto);
  }
}
