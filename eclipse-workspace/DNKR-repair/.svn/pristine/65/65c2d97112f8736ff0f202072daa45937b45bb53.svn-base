/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.SubCategoryDao;
import com.globaldenso.dicas.business.dto.SubCategoryDto;
import com.globaldenso.dicas.business.service.SubCategoryService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.SubCategorySearchForm;
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
@Service("subcategoryService")
public class SubCategoryServiceImpl implements SubCategoryService {

  private static final Logger LOGGER = LoggerFactory.getLogger(SubCategoryServiceImpl.class);

  @Autowired
  private SubCategoryDao subcategoryDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public SubCategoryServiceImpl() {
    // no process
  }

  public void setSubCategoryDao(SubCategoryDao subcategoryDao) {
    this.subcategoryDao = subcategoryDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param subcategoryDto SubCategoryDto
   */
  @Override
  public SubCategoryDto searchByKey(SubCategoryDto subcategoryDto) throws ApplicationException {
    return subcategoryDao.searchByKey(subcategoryDto);
  }

  @Override
  public Page<SubCategoryDto> searchByCondition(SubCategorySearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = subcategoryDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<SubCategoryDto> subcategoryDtos = subcategoryDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = subcategoryDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(subcategoryDtos, pageable, totalCount);
  }

  @Override
  public List<SubCategoryDto> searchGrpCdByCondition(SubCategorySearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<SubCategoryDto> searchSubCategoryByCondition(SubCategorySearchForm criteria) throws ApplicationException {
    criteria.setUseYn("Y");
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(SubCategoryDto subcategoryDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    subcategoryDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    subcategoryDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    subcategoryDao.create(subcategoryDto);
  }

  @Override
  public void update(SubCategoryDto subcategoryDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    subcategoryDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    subcategoryDao.update(subcategoryDto);
  }

  @Override
  public void delete(SubCategoryDto subcategoryDto) throws ApplicationException {
    subcategoryDao.delete(subcategoryDto);
  }
}
