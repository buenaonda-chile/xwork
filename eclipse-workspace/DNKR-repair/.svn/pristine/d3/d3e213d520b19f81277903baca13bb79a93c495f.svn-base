/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.TrainingAppcntStatDao;
import com.globaldenso.dicas.business.dto.TrainingAppcntStatDto;
import com.globaldenso.dicas.business.service.TrainingAppcntStatService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.TrainingAppcntStatSearchForm;
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
 * [KR] 
 *
 * @author TWOGOMS
 * @version 1.0
 */
@Service("trainingAppcntStatService")
public class TrainingAppcntStatServiceImpl implements TrainingAppcntStatService {

  private static final Logger LOGGER = LoggerFactory.getLogger(TrainingAppcntStatServiceImpl.class);

  @Autowired
  private TrainingAppcntStatDao trainingAppcntStatDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public TrainingAppcntStatServiceImpl() {
    // no process
  }

  public void setTrainingAppcntViewDao(TrainingAppcntStatDao trainingAppcntStatDao) {
    this.trainingAppcntStatDao = trainingAppcntStatDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param TrainingAppcntViewDto TrainingAppcntViewDto
   */
  @Override
  public TrainingAppcntStatDto searchByKey(TrainingAppcntStatDto trainingAppcntStatDto) throws ApplicationException {
    return trainingAppcntStatDao.searchByKey(trainingAppcntStatDto);
  }

  @Override
  public Page<TrainingAppcntStatDto> searchByCondition(TrainingAppcntStatSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = trainingAppcntStatDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<TrainingAppcntStatDto> trainingAppcntStatDtos = trainingAppcntStatDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = trainingAppcntStatDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(trainingAppcntStatDtos, pageable, totalCount);
  }

  /**
   * 교육정보관리
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */
  @Override
  public Page<TrainingAppcntStatDto> searchBySdCondition(TrainingAppcntStatSearchForm criteria, Pageable pageable) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

    String statusUsr = null;
    if (loginVO.getOfficeCd()!= null){
      statusUsr = loginVO.getUsername();
//      criteria.setOfficeCode(statusUsr);
    }

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis();

    int totalCount = 0;
    if (pageable != null)
      totalCount = trainingAppcntStatDao.searchSdCount(searchMap);

    long end = System.currentTimeMillis();

    start = System.currentTimeMillis();

    List<TrainingAppcntStatDto> trainingAppcntStatDtos = trainingAppcntStatDao.searchBySdCondition(searchMap);
    if (totalCount == 0) totalCount = trainingAppcntStatDtos.size();

    end = System.currentTimeMillis();

    return new PageImpl<>(trainingAppcntStatDtos, pageable, totalCount);
  }

  @Override
  public List<TrainingAppcntStatDto> searchGrpCdByCondition(TrainingAppcntStatSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<TrainingAppcntStatDto> searchServiceByCondition(TrainingAppcntStatSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(TrainingAppcntStatDto trainingAppcntStatDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    trainingAppcntStatDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    trainingAppcntStatDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
//    TrainingAppcntViewDto.setReceiptNm(loginVO.getUsername());

//    if ("SDAC".equals(loginVO.getDeptCd())) {
//    	TrainingAppcntViewDto.setPrefix("SD_");
//    } else {
//    	TrainingAppcntViewDto.setPrefix("KR_");
//    }

    trainingAppcntStatDao.create(trainingAppcntStatDto);
  }

  @Override
  public void update(TrainingAppcntStatDto trainingAppcntStatDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    trainingAppcntStatDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    trainingAppcntStatDao.update(trainingAppcntStatDto);
  }

  @Override
  public void delete(TrainingAppcntStatDto trainingAppcntStatDto) throws ApplicationException {
	  trainingAppcntStatDao.delete(trainingAppcntStatDto);
  }

  @Override
  public void update2(TrainingAppcntStatDto trainingAppcntStatDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    trainingAppcntStatDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    trainingAppcntStatDao.update2(trainingAppcntStatDto);
  }
}
