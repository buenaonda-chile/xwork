/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ServiceDao;
import com.globaldenso.dicas.business.dto.ServiceDto;
import com.globaldenso.dicas.business.service.ServiceService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ServiceSearchForm;
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
@Service("serviceService")
public class ServiceServiceImpl implements ServiceService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ServiceServiceImpl.class);

  @Autowired
  private ServiceDao serviceDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ServiceServiceImpl() {
    // no process
  }

  public void setServiceDao(ServiceDao serviceDao) {
    this.serviceDao = serviceDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param serviceDto ServiceDto
   */
  @Override
  public ServiceDto searchByKey(ServiceDto serviceDto) throws ApplicationException {
    return serviceDao.searchByKey(serviceDto);
  }

  @Override
  public Page<ServiceDto> searchByCondition(ServiceSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = serviceDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<ServiceDto> serviceDtos = serviceDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = serviceDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(serviceDtos, pageable, totalCount);
  }

  /**
   * 모바일 SD추가
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */
  @Override
  public Page<ServiceDto> searchBySdCondition(ServiceSearchForm criteria, Pageable pageable) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

    String statusUsr = null;
    if (loginVO.getOfficeCd()!= null){
      statusUsr = loginVO.getUsername();
      criteria.setOfficeCode(statusUsr);
    }

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis();

    int totalCount = 0;
    if (pageable != null)
      totalCount = serviceDao.searchSdCount(searchMap);

    long end = System.currentTimeMillis();

    start = System.currentTimeMillis();

    List<ServiceDto> serviceDtos = serviceDao.searchBySdCondition(searchMap);
    if (totalCount == 0) totalCount = serviceDtos.size();

    end = System.currentTimeMillis();

    return new PageImpl<>(serviceDtos, pageable, totalCount);
  }

  @Override
  public List<ServiceDto> searchGrpCdByCondition(ServiceSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<ServiceDto> searchServiceByCondition(ServiceSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(ServiceDto serviceDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    serviceDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    serviceDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
    serviceDto.setReceiptNm(loginVO.getUsername());

    if ("SDAC".equals(loginVO.getDeptCd())) {
      serviceDto.setPrefix("SD_");
    } else {
      serviceDto.setPrefix("KR_");
    }

    serviceDao.create(serviceDto);
  }

  @Override
  public void update(ServiceDto serviceDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    serviceDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    serviceDao.update(serviceDto);
  }

  @Override
  public void delete(ServiceDto serviceDto) throws ApplicationException {
    serviceDao.delete(serviceDto);
  }

  @Override
  public void update2(ServiceDto serviceDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    serviceDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    serviceDao.update2(serviceDto);
  }
}
