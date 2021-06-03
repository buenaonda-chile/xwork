/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.dao.TrainingAppRegistDao;
import com.globaldenso.dicas.business.dto.TrainingAppRegistDto;
import com.globaldenso.dicas.business.service.TrainingAppRegistService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.TrainingAppRegistSearchForm;
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
@Service("trainingAppRegistService")
public class TrainingAppRegistServiceImpl implements TrainingAppRegistService {

  private static final Logger LOGGER = LoggerFactory.getLogger(TrainingAppRegistServiceImpl.class);

  @Autowired
  private TrainingAppRegistDao trainingAppRegistDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public TrainingAppRegistServiceImpl() {
    // no process
  }

  public void setTrainingInfoBaseDao(TrainingAppRegistDao trainingAppRegistDao) {
    this.trainingAppRegistDao = trainingAppRegistDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param trainingInfoBaseDto TrainingInfoBaseDto
   */
  @Override
  public TrainingAppRegistDto searchByKey(TrainingAppRegistDto trainingAppRegistDto) throws ApplicationException {
    return trainingAppRegistDao.searchByKey(trainingAppRegistDto);
  }

  @Override
  public Page<TrainingAppRegistDto> searchByCondition(TrainingAppRegistSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = trainingAppRegistDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<TrainingAppRegistDto> trainingAppRegistDtos = trainingAppRegistDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = trainingAppRegistDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(trainingAppRegistDtos, pageable, totalCount);
  }

  /**
   * 교육정보관리
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */
  @Override
  public Page<TrainingAppRegistDto> searchBySdCondition(TrainingAppRegistSearchForm criteria, Pageable pageable) throws ApplicationException {

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
      totalCount = trainingAppRegistDao.searchSdCount(searchMap);

    long end = System.currentTimeMillis();

    start = System.currentTimeMillis();

    List<TrainingAppRegistDto> trainingAppRegistDtos = trainingAppRegistDao.searchBySdCondition(searchMap);
    if (totalCount == 0) totalCount = trainingAppRegistDtos.size();

    end = System.currentTimeMillis();

    return new PageImpl<>(trainingAppRegistDtos, pageable, totalCount);
  }
 
  @Override
  public Page<TrainingAppRegistDto> searchBySdCondition2(TrainingAppRegistSearchForm criteria, Pageable pageable) throws ApplicationException {

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
      totalCount = trainingAppRegistDao.searchSdCount(searchMap);

    long end = System.currentTimeMillis();

    start = System.currentTimeMillis();

    List<TrainingAppRegistDto> trainingAppRegistDtos = trainingAppRegistDao.searchBySdCondition2(searchMap);
    if (totalCount == 0) totalCount = trainingAppRegistDtos.size();

    end = System.currentTimeMillis();

    return new PageImpl<>(trainingAppRegistDtos, pageable, totalCount);
  }
  

  @Override
  public List<TrainingAppRegistDto> searchGrpCdByCondition(TrainingAppRegistSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<TrainingAppRegistDto> searchServiceByCondition(TrainingAppRegistSearchForm criteria) throws ApplicationException {
    return searchBySdCondition(criteria, null).getContent();
  }
  
  @Override
  public List<TrainingAppRegistDto> searchServiceByCondition2(TrainingAppRegistSearchForm criteria) throws ApplicationException {
    return searchBySdCondition2(criteria, null).getContent();
  }

  @Override
  public Long create(TrainingAppRegistDto trainingAppRegistDto) throws ApplicationException {

		/* LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser(); */
    trainingAppRegistDto.setRgstrId(Long.parseLong("9999999999"));
    trainingAppRegistDto.setUpdtrId(Long.parseLong("9999999999"));
//    trainingInfoBaseDto.setReceiptNm(loginVO.getUsername());

//    if ("SDAC".equals(loginVO.getDeptCd())) {
//    	trainingInfoBaseDto.setPrefix("SD_");
//    } else {
//    	trainingInfoBaseDto.setPrefix("KR_");
//    }

    trainingAppRegistDao.create(trainingAppRegistDto);
    
	/* System.out.println("김준수3" + trainingAppRegistDto.getId()); */
    return trainingAppRegistDto.getId();
    
  }
  
  public void create2(TrainingAppRegistDto trainingAppRegistDto) throws ApplicationException {

		/* LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser(); */
	    trainingAppRegistDto.setRgstrId(Long.parseLong("9999999999"));
	    trainingAppRegistDto.setUpdtrId(Long.parseLong("9999999999"));
//	    trainingInfoBaseDto.setReceiptNm(loginVO.getUsername());

//	    if ("SDAC".equals(loginVO.getDeptCd())) {
//	    	trainingInfoBaseDto.setPrefix("SD_");
//	    } else {
//	    	trainingInfoBaseDto.setPrefix("KR_");
//	    }

	    trainingAppRegistDao.create2(trainingAppRegistDto);	    
	  }

  @Override
  public void update(TrainingAppRegistDto trainingAppRegistDto) throws ApplicationException {

		/* LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser(); */
    trainingAppRegistDto.setUpdtrId(Long.parseLong("9999999999"));

    trainingAppRegistDao.update(trainingAppRegistDto);
  }

  @Override
  public void delete(TrainingAppRegistDto trainingAppRegistDto) throws ApplicationException {
	  trainingAppRegistDao.delete(trainingAppRegistDto);
  }

  @Override
  public void update2(TrainingAppRegistDto trainingAppRegistDto) throws ApplicationException {

		/* LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser(); */
    trainingAppRegistDto.setUpdtrId(Long.parseLong("9999999999"));

    trainingAppRegistDao.update2(trainingAppRegistDto);
  }
}
