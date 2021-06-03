/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.MainCategoryDao;
import com.globaldenso.dicas.business.dto.MainCategoryDto;
import com.globaldenso.dicas.business.service.MainCategoryService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.MainCategorySearchForm;
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
@Service("maincategoryService")
public class MainCategoryServiceImpl implements MainCategoryService {

  private static final Logger LOGGER = LoggerFactory.getLogger(MainCategoryServiceImpl.class);

  @Autowired
  private MainCategoryDao maincategoryDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public MainCategoryServiceImpl() {
    // no process
  }

  public void setMainCategoryDao(MainCategoryDao maincategoryDao) {
    this.maincategoryDao = maincategoryDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param maincategoryDto MainCategoryDto
   */
  @Override
  public MainCategoryDto searchByKey(MainCategoryDto maincategoryDto) throws ApplicationException {
    return maincategoryDao.searchByKey(maincategoryDto);
  }

  @Override
  public Page<MainCategoryDto> searchByCondition(MainCategorySearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = maincategoryDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<MainCategoryDto> maincategoryDtos = maincategoryDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = maincategoryDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(maincategoryDtos, pageable, totalCount);
  }

  @Override
  public List<MainCategoryDto> searchGrpCdByCondition(MainCategorySearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<MainCategoryDto> searchMainCategoryByCondition(MainCategorySearchForm criteria) throws ApplicationException {
    criteria.setUseYn("Y");
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(MainCategoryDto maincategoryDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    maincategoryDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    maincategoryDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    maincategoryDao.create(maincategoryDto);
  }

  @Override
  public void update(MainCategoryDto maincategoryDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    maincategoryDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    maincategoryDao.update(maincategoryDto);
  }

  @Override
  public void delete(MainCategoryDto maincategoryDto) throws ApplicationException {
    maincategoryDao.delete(maincategoryDto);
  }
}
