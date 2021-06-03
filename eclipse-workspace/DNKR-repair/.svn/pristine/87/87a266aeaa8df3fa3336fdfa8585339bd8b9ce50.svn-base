/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.OfficeDetailDao;
import com.globaldenso.dicas.business.dto.OfficeDetailDto;
import com.globaldenso.dicas.business.service.OfficeDetailService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.OfficeDetailSearchForm;
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
@Service("officedetailService")
public class OfficeDetailServiceImpl implements OfficeDetailService {

  private static final Logger LOGGER = LoggerFactory.getLogger(OfficeDetailServiceImpl.class);

  @Autowired
  private OfficeDetailDao officedetailDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public OfficeDetailServiceImpl() {
    // no process
  }

  public void setOfficeDetailDao(OfficeDetailDao officedetailDao) {
    this.officedetailDao = officedetailDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param officedetailDto OfficeDetailDto
   */
  @Override
  public OfficeDetailDto searchByKey(OfficeDetailDto officedetailDto) throws ApplicationException {
    return officedetailDao.searchByKey(officedetailDto);
  }

  @Override
  public Page<OfficeDetailDto> searchByCondition(OfficeDetailSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = officedetailDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<OfficeDetailDto> officedetailDtos = officedetailDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = officedetailDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(officedetailDtos, pageable, totalCount);
  }

  @Override
  public List<OfficeDetailDto> searchGrpCdByCondition(OfficeDetailSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<OfficeDetailDto> searchOfficeDetailByCondition(OfficeDetailSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(OfficeDetailDto officedetailDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    officedetailDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    officedetailDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    officedetailDao.create(officedetailDto);
  }

  @Override
  public void update(OfficeDetailDto officedetailDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    officedetailDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    officedetailDao.update(officedetailDto);
  }

  @Override
  public void delete(OfficeDetailDto officedetailDto) throws ApplicationException {
    officedetailDao.delete(officedetailDto);
  }
}
