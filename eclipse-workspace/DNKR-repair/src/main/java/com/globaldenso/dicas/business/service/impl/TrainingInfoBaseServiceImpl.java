/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.TrainingInfoBaseDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.TrainingInfoBaseDto;
import com.globaldenso.dicas.business.service.TrainingInfoBaseService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.TrainingInfoBaseSearchForm;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * [KR] 
 *
 * @author TWOGOMS
 * @version 1.0
 */
@Service("trainingInfoBaseService")
public class TrainingInfoBaseServiceImpl implements TrainingInfoBaseService {

  private static final Logger LOGGER = LoggerFactory.getLogger(TrainingInfoBaseServiceImpl.class);

  @Autowired
  private TrainingInfoBaseDao trainingInfoBaseDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public TrainingInfoBaseServiceImpl() {
    // no process
  }

  public void setTrainingInfoBaseDao(TrainingInfoBaseDao trainingInfoBaseDao) {
    this.trainingInfoBaseDao = trainingInfoBaseDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param trainingInfoBaseDto TrainingInfoBaseDto
   */
  @Override
  public TrainingInfoBaseDto searchByKey(TrainingInfoBaseDto trainingInfoBaseDto) throws ApplicationException {
    return trainingInfoBaseDao.searchByKey(trainingInfoBaseDto);
  }

  @Override
  public Page<TrainingInfoBaseDto> searchByCondition(TrainingInfoBaseSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = trainingInfoBaseDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<TrainingInfoBaseDto> trainingInfoBaseDtos = trainingInfoBaseDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = trainingInfoBaseDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(trainingInfoBaseDtos, pageable, totalCount);
  }

  /**
   * 교육정보관리
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */
  @Override
  public Page<TrainingInfoBaseDto> searchBySdCondition(TrainingInfoBaseSearchForm criteria, Pageable pageable) throws ApplicationException {

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
      totalCount = trainingInfoBaseDao.searchSdCount(searchMap);

    long end = System.currentTimeMillis();

    start = System.currentTimeMillis();

    List<TrainingInfoBaseDto> trainingInfoBaseDtos = trainingInfoBaseDao.searchBySdCondition(searchMap);
    if (totalCount == 0) totalCount = trainingInfoBaseDtos.size();

    end = System.currentTimeMillis();

    return new PageImpl<>(trainingInfoBaseDtos, pageable, totalCount);
  }

  @Override
  public List<TrainingInfoBaseDto> searchGrpCdByCondition(TrainingInfoBaseSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<TrainingInfoBaseDto> searchServiceByCondition(TrainingInfoBaseSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }
  
  @Override
  public Page<TrainingInfoBaseDto> searchListByConditionDownload(TrainingInfoBaseSearchForm criteria, Pageable pageable) throws ApplicationException {
    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;

    if(pageable != null)
      totalCount = trainingInfoBaseDao.searchCount(searchMap);


    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis();

    List<TrainingInfoBaseDto> trainingInfoBaseDtos = trainingInfoBaseDao.searchListByConditionDownload(searchMap);
    if (totalCount == 0) totalCount = trainingInfoBaseDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(trainingInfoBaseDtos, pageable, totalCount);
  }

  @Override
  public void create(TrainingInfoBaseDto trainingInfoBaseDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    trainingInfoBaseDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    trainingInfoBaseDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
//    trainingInfoBaseDto.setReceiptNm(loginVO.getUsername());

//    if ("SDAC".equals(loginVO.getDeptCd())) {
//    	trainingInfoBaseDto.setPrefix("SD_");
//    } else {
//    	trainingInfoBaseDto.setPrefix("KR_");
//    }

    trainingInfoBaseDao.create(trainingInfoBaseDto);
  }

  @Override
  public void update(TrainingInfoBaseDto trainingInfoBaseDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    trainingInfoBaseDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    trainingInfoBaseDao.update(trainingInfoBaseDto);
  }

  @Override
  public void delete(TrainingInfoBaseDto trainingInfoBaseDto) throws ApplicationException {
	  trainingInfoBaseDao.delete(trainingInfoBaseDto);
  }

  @Override
  public void update2(TrainingInfoBaseDto trainingInfoBaseDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    trainingInfoBaseDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    trainingInfoBaseDao.update2(trainingInfoBaseDto);
  }
}
