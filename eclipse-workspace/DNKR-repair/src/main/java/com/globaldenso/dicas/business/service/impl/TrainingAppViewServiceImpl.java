/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.TrainingAppViewDao;
import com.globaldenso.dicas.business.dto.TrainingAppViewDto;
import com.globaldenso.dicas.business.service.TrainingAppViewService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.TrainingAppViewSearchForm;
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
@Service("trainingAppViewService")
public class TrainingAppViewServiceImpl implements TrainingAppViewService {

  private static final Logger LOGGER = LoggerFactory.getLogger(TrainingAppViewServiceImpl.class);

  @Autowired
  private TrainingAppViewDao trainingAppViewDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public TrainingAppViewServiceImpl() {
    // no process
  }

  public void setTrainingInfoBaseDao(TrainingAppViewDao trainingAppViewDao) {
    this.trainingAppViewDao = trainingAppViewDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param trainingInfoBaseDto TrainingInfoBaseDto
   */
  @Override
  public TrainingAppViewDto searchByKey(TrainingAppViewDto trainingAppViewDto) throws ApplicationException {
    return trainingAppViewDao.searchByKey(trainingAppViewDto);
  }

  @Override
  public Page<TrainingAppViewDto> searchByCondition(TrainingAppViewSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = trainingAppViewDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<TrainingAppViewDto> trainingAppViewDtos = trainingAppViewDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = trainingAppViewDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(trainingAppViewDtos, pageable, totalCount);
  }

  /**
   * 교육정보관리
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */
  @Override
  public Page<TrainingAppViewDto> searchBySdCondition(TrainingAppViewSearchForm criteria, Pageable pageable) throws ApplicationException {

		/*
		 * LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		 * 
		 * String statusUsr = null; if (loginVO.getOfficeCd()!= null){ statusUsr =
		 * loginVO.getUsername(); // criteria.setOfficeCode(statusUsr); }
		 */

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis();

    int totalCount = 0;
    if (pageable != null)
      totalCount = trainingAppViewDao.searchSdCount(searchMap);

    long end = System.currentTimeMillis();

    start = System.currentTimeMillis();

    List<TrainingAppViewDto> trainingAppViewDtos = trainingAppViewDao.searchBySdCondition(searchMap);
    if (totalCount == 0) totalCount = trainingAppViewDtos.size();

    end = System.currentTimeMillis();

    return new PageImpl<>(trainingAppViewDtos, pageable, totalCount);
  }

  @Override
  public List<TrainingAppViewDto> searchGrpCdByCondition(TrainingAppViewSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<TrainingAppViewDto> searchServiceByCondition(TrainingAppViewSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public Long create(TrainingAppViewDto trainingAppViewDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    trainingAppViewDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    trainingAppViewDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
//    trainingInfoBaseDto.setReceiptNm(loginVO.getUsername());

//    if ("SDAC".equals(loginVO.getDeptCd())) {
//    	trainingInfoBaseDto.setPrefix("SD_");
//    } else {
//    	trainingInfoBaseDto.setPrefix("KR_");
//    }

    trainingAppViewDao.create(trainingAppViewDto);
    
	/* System.out.println("김준수3" + trainingAppViewDto.getId()); */
    return trainingAppViewDto.getId();
    
  }
  
  public void create2(TrainingAppViewDto trainingAppViewDto) throws ApplicationException {

	    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	    trainingAppViewDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
	    trainingAppViewDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
//	    trainingInfoBaseDto.setReceiptNm(loginVO.getUsername());

//	    if ("SDAC".equals(loginVO.getDeptCd())) {
//	    	trainingInfoBaseDto.setPrefix("SD_");
//	    } else {
//	    	trainingInfoBaseDto.setPrefix("KR_");
//	    }

	    trainingAppViewDao.create2(trainingAppViewDto);	    
	  }

  @Override
  public void update(TrainingAppViewDto trainingAppViewDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    trainingAppViewDto.setUpdtrId(Long.parseLong("9999999999"));

    trainingAppViewDao.update(trainingAppViewDto);
  }

  @Override
  public void delete(TrainingAppViewDto trainingAppViewDto) throws ApplicationException {
	  trainingAppViewDao.delete(trainingAppViewDto);
  }

  @Override
  public void update2(TrainingAppViewDto trainingAppViewDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    trainingAppViewDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    trainingAppViewDao.update2(trainingAppViewDto);
  }
}
