/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.PhenomenonDao;
import com.globaldenso.dicas.business.dto.PhenomenonDto;
import com.globaldenso.dicas.business.service.PhenomenonService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.PhenomenonSearchForm;
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
@Service("phenomenonService")
public class PhenomenonServiceImpl implements PhenomenonService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PhenomenonServiceImpl.class);

  @Autowired
  private PhenomenonDao phenomenonDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public PhenomenonServiceImpl() {
    // no process
  }

  public void setPhenomenonDao(PhenomenonDao phenomenonDao) {
    this.phenomenonDao = phenomenonDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param phenomenonDto PhenomenonDto
   */
  @Override
  public PhenomenonDto searchByKey(PhenomenonDto phenomenonDto) throws ApplicationException {
    return phenomenonDao.searchByKey(phenomenonDto);
  }

  @Override
  public Page<PhenomenonDto> searchByCondition(PhenomenonSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = phenomenonDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<PhenomenonDto> phenomenonDtos = phenomenonDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = phenomenonDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(phenomenonDtos, pageable, totalCount);
  }

  @Override
  public List<PhenomenonDto> searchGrpCdByCondition(PhenomenonSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<PhenomenonDto> searchPhenomenonByCondition(PhenomenonSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(PhenomenonDto phenomenonDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    phenomenonDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    phenomenonDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    phenomenonDao.create(phenomenonDto);
  }

  @Override
  public void update(PhenomenonDto phenomenonDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    phenomenonDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    phenomenonDao.update(phenomenonDto);
  }

  @Override
  public void delete(PhenomenonDto phenomenonDto) throws ApplicationException {
    phenomenonDao.delete(phenomenonDto);
  }
}
