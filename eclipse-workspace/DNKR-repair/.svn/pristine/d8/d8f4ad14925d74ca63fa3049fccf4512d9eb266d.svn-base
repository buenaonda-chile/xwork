/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.RepairCDInfoDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.RepairCDInfoDto;
import com.globaldenso.dicas.business.service.RepairCDInfoService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.RepairCDInfoForm;
import com.globaldenso.dicas.presentation.form.RepairCDInfoSearchForm;
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
@Service("repairCDInfoService")
public class RepairCDInfoServiceImpl implements RepairCDInfoService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RepairCDInfoServiceImpl.class);

  @Autowired
  private RepairCDInfoDao repairCDInfoDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public RepairCDInfoServiceImpl() {
    // no process
  }

  public void setRepairCDInfoDao(RepairCDInfoDao repairCDInfoDao) {
    this.repairCDInfoDao = repairCDInfoDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param repairCDInfoDto RepairCDInfoDto
   */
  @Override
  public RepairCDInfoDto searchByKey(RepairCDInfoDto repairCDInfoDto) throws ApplicationException {
    return repairCDInfoDao.searchByKey(repairCDInfoDto);
  }

  @Override
  public Page<RepairCDInfoDto> searchByCondition(RepairCDInfoSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = repairCDInfoDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<RepairCDInfoDto> repairCDInfoDtos = repairCDInfoDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = repairCDInfoDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(repairCDInfoDtos, pageable, totalCount);
  }

  /**
   * 수리정보관리
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void create(RepairCDInfoDto repairCDInfoDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    repairCDInfoDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    repairCDInfoDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));


    repairCDInfoDao.create(repairCDInfoDto);
  }
  
  @Override
  public void update(RepairCDInfoDto repairCDInfoDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    repairCDInfoDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    repairCDInfoDao.update(repairCDInfoDto);
  }


  @Override
  public void delete(RepairCDInfoDto repairCDInfoDto) throws ApplicationException {
	  repairCDInfoDao.delete(repairCDInfoDto);
  }

}
