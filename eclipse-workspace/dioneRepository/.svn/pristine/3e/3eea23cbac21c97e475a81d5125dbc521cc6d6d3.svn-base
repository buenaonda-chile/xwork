/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.VehicleViewDao;
import com.globaldenso.dicas.business.dto.VehicleViewDto;
import com.globaldenso.dicas.business.service.VehicleViewService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.VehicleViewSearchForm;
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
@Service("vehicleviewService")
public class VehicleViewServiceImpl implements VehicleViewService {

  private static final Logger LOGGER = LoggerFactory.getLogger(VehicleViewServiceImpl.class);

  @Autowired
  private VehicleViewDao vehicleviewDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public VehicleViewServiceImpl() {
    // no process
  }

  public void setVehicleViewDao(VehicleViewDao vehicleviewDao) {
    this.vehicleviewDao = vehicleviewDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param vehicleviewDto VehicleViewDto
   */
  @Override
  public VehicleViewDto searchByKey(VehicleViewDto vehicleviewDto) throws ApplicationException {
    return vehicleviewDao.searchByKey(vehicleviewDto);
  }

  @Override
  public Page<VehicleViewDto> searchByCondition(VehicleViewSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = vehicleviewDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<VehicleViewDto> vehicleviewDtos = vehicleviewDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = vehicleviewDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(vehicleviewDtos, pageable, totalCount);
  }

  @Override
  public List<VehicleViewDto> searchGrpCdByCondition(VehicleViewSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<VehicleViewDto> searchVehicleViewByCondition(VehicleViewSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(VehicleViewDto vehicleviewDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    vehicleviewDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    vehicleviewDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    vehicleviewDao.create(vehicleviewDto);
  }

  @Override
  public void update(VehicleViewDto vehicleviewDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    vehicleviewDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    vehicleviewDao.update(vehicleviewDto);
  }

  @Override
  public void delete(VehicleViewDto vehicleviewDto) throws ApplicationException {
    vehicleviewDao.delete(vehicleviewDto);
  }
}
