/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.VehicleDao;
import com.globaldenso.dicas.business.dto.VehicleDto;
import com.globaldenso.dicas.business.service.VehicleService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.VehicleSearchForm;
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
@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

  private static final Logger LOGGER = LoggerFactory.getLogger(VehicleServiceImpl.class);

  @Autowired
  private VehicleDao vehicleDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public VehicleServiceImpl() {
    // no process
  }

  public void setVehicleDao(VehicleDao vehicleDao) {
    this.vehicleDao = vehicleDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param vehicleDto VehicleDto
   */
  @Override
  public VehicleDto searchByKey(VehicleDto vehicleDto) throws ApplicationException {
    return vehicleDao.searchByKey(vehicleDto);
  }

  @Override
  public Page<VehicleDto> searchByCondition(VehicleSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = vehicleDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<VehicleDto> vehicleDtos = vehicleDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = vehicleDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(vehicleDtos, pageable, totalCount);
  }

  @Override
  public List<VehicleDto> searchGrpCdByCondition(VehicleSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<VehicleDto> searchVehicleByCondition(VehicleSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(VehicleDto vehicleDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    vehicleDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    vehicleDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    vehicleDao.create(vehicleDto);
  }

  @Override
  public void update(VehicleDto vehicleDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    vehicleDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    vehicleDao.update(vehicleDto);
  }

  @Override
  public void delete(VehicleDto vehicleDto) throws ApplicationException {
    vehicleDao.delete(vehicleDto);
  }
}
