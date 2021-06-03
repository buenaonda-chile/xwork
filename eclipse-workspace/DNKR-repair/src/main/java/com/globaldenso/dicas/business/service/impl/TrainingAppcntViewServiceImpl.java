/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.TrainingAppcntViewDao;
import com.globaldenso.dicas.business.dto.TrainingAppcntViewDto;
import com.globaldenso.dicas.business.service.TrainingAppcntViewService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.TrainingAppcntViewSearchForm;
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
@Service("trainingAppcntViewService")
public class TrainingAppcntViewServiceImpl implements TrainingAppcntViewService {

  private static final Logger LOGGER = LoggerFactory.getLogger(TrainingAppcntViewServiceImpl.class);

  @Autowired
  private TrainingAppcntViewDao trainingAppcntViewDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public TrainingAppcntViewServiceImpl() {
    // no process
  }

  public void setTrainingAppcntViewDao(TrainingAppcntViewDao TrainingAppcntViewDao) {
    this.trainingAppcntViewDao = TrainingAppcntViewDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param TrainingAppcntViewDto TrainingAppcntViewDto
   */
  @Override
  public TrainingAppcntViewDto searchByKey(TrainingAppcntViewDto TrainingAppcntViewDto) throws ApplicationException {
    return trainingAppcntViewDao.searchByKey(TrainingAppcntViewDto);
  }

  @Override
  public Page<TrainingAppcntViewDto> searchByCondition(TrainingAppcntViewSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = trainingAppcntViewDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<TrainingAppcntViewDto> trainingAppcntViewDtos = trainingAppcntViewDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = trainingAppcntViewDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(trainingAppcntViewDtos, pageable, totalCount);
  }

  /**
   * 교육정보관리
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */
  @Override
  public Page<TrainingAppcntViewDto> searchBySdCondition(TrainingAppcntViewSearchForm criteria, Pageable pageable) throws ApplicationException {

		/* LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser(); */

    String statusUsr = null;
	/*
	 * if (loginVO.getOfficeCd()!= null){ statusUsr = loginVO.getUsername(); //
	 * criteria.setOfficeCode(statusUsr); }
	 */

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis();

    int totalCount = 0;
    if (pageable != null)
      totalCount = trainingAppcntViewDao.searchSdCount(searchMap);

    long end = System.currentTimeMillis();

    start = System.currentTimeMillis();

    List<TrainingAppcntViewDto> TrainingAppcntViewDtos = trainingAppcntViewDao.searchBySdCondition(searchMap);
    if (totalCount == 0) totalCount = TrainingAppcntViewDtos.size();

    end = System.currentTimeMillis();

    return new PageImpl<>(TrainingAppcntViewDtos, pageable, totalCount);
  }

  @Override
  public List<TrainingAppcntViewDto> searchGrpCdByCondition(TrainingAppcntViewSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<TrainingAppcntViewDto> searchServiceByCondition(TrainingAppcntViewSearchForm criteria) throws ApplicationException {
    return searchBySdCondition(criteria, null).getContent();
  }

  @Override
  public void create(TrainingAppcntViewDto trainingAppcntViewDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    trainingAppcntViewDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    trainingAppcntViewDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
//    TrainingAppcntViewDto.setReceiptNm(loginVO.getUsername());

//    if ("SDAC".equals(loginVO.getDeptCd())) {
//    	TrainingAppcntViewDto.setPrefix("SD_");
//    } else {
//    	TrainingAppcntViewDto.setPrefix("KR_");
//    }

    trainingAppcntViewDao.create(trainingAppcntViewDto);
  }

  @Override
  public void update(TrainingAppcntViewDto trainingAppcntViewDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    trainingAppcntViewDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    trainingAppcntViewDao.update(trainingAppcntViewDto);
  }

  @Override
  public void delete(TrainingAppcntViewDto trainingAppcntViewDto) throws ApplicationException {
	  trainingAppcntViewDao.delete(trainingAppcntViewDto);
  }

  @Override
  public void update2(TrainingAppcntViewDto trainingAppcntViewDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    trainingAppcntViewDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    trainingAppcntViewDao.update2(trainingAppcntViewDto);
  }
}
