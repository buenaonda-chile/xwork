/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.QualityProblemDao;
import com.globaldenso.dicas.business.dto.QualityProblemDto;
import com.globaldenso.dicas.business.service.QualityProblemService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.QualityProblemSearchForm;
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
@Service("qualityproblemService")
public class QualityProblemServiceImpl implements QualityProblemService {

  private static final Logger LOGGER = LoggerFactory.getLogger(QualityProblemServiceImpl.class);

  @Autowired
  private QualityProblemDao qualityproblemDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public QualityProblemServiceImpl() {
    // no process
  }

  public void setQualityProblemDao(QualityProblemDao qualityproblemDao) {
    this.qualityproblemDao = qualityproblemDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param qualityproblemDto QualityProblemDto
   */
  @Override
  public QualityProblemDto searchByKey(QualityProblemDto qualityproblemDto) throws ApplicationException {
    return qualityproblemDao.searchByKey(qualityproblemDto);
  }

  @Override
  public Page<QualityProblemDto> searchByCondition(QualityProblemSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = qualityproblemDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<QualityProblemDto> qualityproblemDtos = qualityproblemDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = qualityproblemDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(qualityproblemDtos, pageable, totalCount);
  }

  @Override
  public List<QualityProblemDto> searchGrpCdByCondition(QualityProblemSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<QualityProblemDto> searchQualityProblemByCondition(QualityProblemSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(QualityProblemDto qualityproblemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    qualityproblemDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    qualityproblemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    qualityproblemDao.create(qualityproblemDto);
  }

  @Override
  public void update(QualityProblemDto qualityproblemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    qualityproblemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    qualityproblemDao.update(qualityproblemDto);
  }

  @Override
  public void delete(QualityProblemDto qualityproblemDto) throws ApplicationException {
    qualityproblemDao.delete(qualityproblemDto);
  }
}
