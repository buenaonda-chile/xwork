/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.KPIManagementDNKRDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.KPIManagementDNKRDto;
import com.globaldenso.dicas.business.service.KPIManagementDNKRService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.KPIManagementDNKRSearchForm;
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
@Service("kpiManagementDNKRService")
public class KPIManagementDNKRServiceImpl implements KPIManagementDNKRService {

  private static final Logger LOGGER = LoggerFactory.getLogger(KPIManagementDNKRServiceImpl.class);

  @Autowired
  private KPIManagementDNKRDao kpiManagementDNKRDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public KPIManagementDNKRServiceImpl() {
    // no process
  }

  public void setKPIManagementDNKRDao(KPIManagementDNKRDao kpiManagementDNKRDao) {
    this.kpiManagementDNKRDao = kpiManagementDNKRDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param kpiManagementDNKRDto KPIManagementDNKRDto
   */
  @Override
  public KPIManagementDNKRDto searchByKey(KPIManagementDNKRDto kpiManagementDNKRDto) throws ApplicationException {
    return kpiManagementDNKRDao.searchByKey(kpiManagementDNKRDto);
  }

  @Override
  public Page<KPIManagementDNKRDto> searchByCondition(KPIManagementDNKRSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = kpiManagementDNKRDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<KPIManagementDNKRDto> kpiManagementDNKRDtos = kpiManagementDNKRDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = kpiManagementDNKRDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(kpiManagementDNKRDtos, pageable, totalCount);
  }

}
