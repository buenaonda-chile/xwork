/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.PhenomenonSubDao;
import com.globaldenso.dicas.business.dto.PhenomenonSubDto;
import com.globaldenso.dicas.business.service.PhenomenonSubService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.PhenomenonSubSearchForm;
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
@Service("phenomenonsubService")
public class PhenomenonSubServiceImpl implements PhenomenonSubService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PhenomenonSubServiceImpl.class);

  @Autowired
  private PhenomenonSubDao phenomenonsubDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public PhenomenonSubServiceImpl() {
    // no process
  }

  public void setPhenomenonSubDao(PhenomenonSubDao phenomenonsubDao) {
    this.phenomenonsubDao = phenomenonsubDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param phenomenonsubDto PhenomenonSubDto
   */
  @Override
  public PhenomenonSubDto searchByKey(PhenomenonSubDto phenomenonsubDto) throws ApplicationException {
    return phenomenonsubDao.searchByKey(phenomenonsubDto);
  }

  @Override
  public Page<PhenomenonSubDto> searchByCondition(PhenomenonSubSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = phenomenonsubDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<PhenomenonSubDto> phenomenonsubDtos = phenomenonsubDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = phenomenonsubDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(phenomenonsubDtos, pageable, totalCount);
  }

  @Override
  public List<PhenomenonSubDto> searchGrpCdByCondition(PhenomenonSubSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<PhenomenonSubDto> searchPhenomenonSubByCondition(PhenomenonSubSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(PhenomenonSubDto phenomenonsubDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    phenomenonsubDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    phenomenonsubDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    phenomenonsubDao.create(phenomenonsubDto);
  }

  @Override
  public void update(PhenomenonSubDto phenomenonsubDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    phenomenonsubDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    phenomenonsubDao.update(phenomenonsubDto);
  }

  @Override
  public void delete(PhenomenonSubDto phenomenonsubDto) throws ApplicationException {
    phenomenonsubDao.delete(phenomenonsubDto);
  }
}
