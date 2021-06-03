/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ConsultingDao;
import com.globaldenso.dicas.business.dto.ConsultingDto;
import com.globaldenso.dicas.business.service.ConsultingService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ConsultingSearchForm;
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
@Service("consultingService")
public class ConsultingServiceImpl implements ConsultingService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConsultingServiceImpl.class);

  @Autowired
  private ConsultingDao consultingDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ConsultingServiceImpl() {
    // no process
  }

  public void setConsultingDao(ConsultingDao consultingDao) {
    this.consultingDao = consultingDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param consultingDto ConsultingDto
   */
  @Override
  public ConsultingDto searchByKey(ConsultingDto consultingDto) throws ApplicationException {
    return consultingDao.searchByKey(consultingDto);
  }

  @Override
  public Page<ConsultingDto> searchByCondition(ConsultingSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = consultingDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<ConsultingDto> consultingDtos = consultingDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = consultingDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(consultingDtos, pageable, totalCount);
  }

  @Override
  public List<ConsultingDto> searchGrpCdByCondition(ConsultingSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<ConsultingDto> searchConsultingByCondition(ConsultingSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(ConsultingDto consultingDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    consultingDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    consultingDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    consultingDao.create(consultingDto);
  }

  @Override
  public void update(ConsultingDto consultingDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    consultingDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    consultingDao.update(consultingDto);
  }

  @Override
  public void delete(ConsultingDto consultingDto) throws ApplicationException {
    consultingDao.delete(consultingDto);
  }
}
