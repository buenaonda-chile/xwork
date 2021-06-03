/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.RepairSDBrkVehicleDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.RepairSDBrkVehicleDto;
import com.globaldenso.dicas.business.service.RepairSDBrkVehicleService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.RepairSDBrkVehicleSearchForm;
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
@Service("repairSDBrkVehicleService")
public class RepairSDBrkVehicleServiceImpl implements RepairSDBrkVehicleService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RepairSDBrkVehicleServiceImpl.class);

  @Autowired
  private RepairSDBrkVehicleDao repairSDBrkVehicleDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public RepairSDBrkVehicleServiceImpl() {
    // no process
  }

  public void setRepairSDBrkVehicleDao(RepairSDBrkVehicleDao repairSDBrkVehicleDao) {
    this.repairSDBrkVehicleDao = repairSDBrkVehicleDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param repairSDBrkVehicleDto RepairSDBrkVehicleDto
   */
  @Override
  public RepairSDBrkVehicleDto searchByKey(RepairSDBrkVehicleDto repairSDBrkVehicleDto) throws ApplicationException {
    return repairSDBrkVehicleDao.searchByKey(repairSDBrkVehicleDto);
  }

  @Override
  public Page<RepairSDBrkVehicleDto> searchByCondition(RepairSDBrkVehicleSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = repairSDBrkVehicleDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<RepairSDBrkVehicleDto> repairSDBrkVehicleDtos = repairSDBrkVehicleDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = repairSDBrkVehicleDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(repairSDBrkVehicleDtos, pageable, totalCount);
  }

  /**
   * 고품접수
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void create(RepairSDBrkVehicleDto repairSDBrkVehicleDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    repairSDBrkVehicleDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    repairSDBrkVehicleDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
//    trainingInfoBaseDto.setReceiptNm(loginVO.getUsername());

//    if ("SDAC".equals(loginVO.getDeptCd())) {
//    	trainingInfoBaseDto.setPrefix("SD_");
//    } else {
//    	trainingInfoBaseDto.setPrefix("KR_");
//    }

    repairSDBrkVehicleDao.create(repairSDBrkVehicleDto);
  }

  @Override
  public void update(RepairSDBrkVehicleDto repairSDBrkVehicleDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    repairSDBrkVehicleDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    repairSDBrkVehicleDao.update(repairSDBrkVehicleDto);
  }

  @Override
  public void delete(RepairSDBrkVehicleDto repairSDBrkVehicleDto) throws ApplicationException {
	  repairSDBrkVehicleDao.delete(repairSDBrkVehicleDto);
  }

}
