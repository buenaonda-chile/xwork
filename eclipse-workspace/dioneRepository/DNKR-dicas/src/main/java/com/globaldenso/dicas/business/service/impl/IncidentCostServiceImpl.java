/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.IncidentCostDao;
import com.globaldenso.dicas.business.dto.IncidentCostDto;
import com.globaldenso.dicas.business.service.IncidentCostService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.IncidentCostSearchForm;
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
@Service("incidentcostService")
public class IncidentCostServiceImpl implements IncidentCostService {

  private static final Logger LOGGER = LoggerFactory.getLogger(IncidentCostServiceImpl.class);

  @Autowired
  private IncidentCostDao incidentcostDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public IncidentCostServiceImpl() {
    // no process
  }

  public void setIncidentCostDao(IncidentCostDao incidentcostDao) {
    this.incidentcostDao = incidentcostDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param incidentcostDto IncidentCostDto
   */
  @Override
  public IncidentCostDto searchByKey(IncidentCostDto incidentcostDto) throws ApplicationException {
    return incidentcostDao.searchByKey(incidentcostDto);
  }

  @Override
  public Page<IncidentCostDto> searchByCondition(IncidentCostSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = incidentcostDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<IncidentCostDto> incidentcostDtos = incidentcostDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = incidentcostDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(incidentcostDtos, pageable, totalCount);
  }

  @Override
  public List<IncidentCostDto> searchGrpCdByCondition(IncidentCostSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<IncidentCostDto> searchIncidentCostByCondition(IncidentCostSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(IncidentCostDto incidentcostDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    incidentcostDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    incidentcostDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    incidentcostDao.create(incidentcostDto);
  }

  @Override
  public void update(IncidentCostDto incidentcostDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    incidentcostDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    incidentcostDao.update(incidentcostDto);
  }

  @Override
  public void delete(IncidentCostDto incidentcostDto) throws ApplicationException {
    incidentcostDao.delete(incidentcostDto);
  }
}
