/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ResearchDao;
import com.globaldenso.dicas.business.dto.ResearchDto;
import com.globaldenso.dicas.business.service.ResearchService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResearchSearchForm;
import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
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
@Service("researchService")
public class ResearchServiceImpl implements ResearchService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResearchServiceImpl.class);

  @Autowired
  private ResearchDao researchDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ResearchServiceImpl() {
    // no process
  }

  public void setResearchDao(ResearchDao researchDao) {
    this.researchDao = researchDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param researchDto ResearchDto
   */
  @Override
  public ResearchDto searchByKey(ResearchDto researchDto) throws ApplicationException {
    return researchDao.searchByKey(researchDto);
  }

  @Override
  public Page<ResearchDto> searchByCondition(ResearchSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = researchDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<ResearchDto> researchDtos = researchDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = researchDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(researchDtos, pageable, totalCount);
  }

  @Override
  public List<ResearchDto> searchGrpCdByCondition(ResearchSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<ResearchDto> searchResearchByCondition(ResearchSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<ResearchDto> searchByConditionFile(String manageNo) throws ApplicationException {
    return  researchDao.searchByConditionFile(manageNo);
  }

  @Override
  public void create(ResearchDto researchDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    researchDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    researchDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    researchDao.create(researchDto);
  }

  @Override
  public void update(ResearchDto researchDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    researchDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    int totalCount = 0;
    Map<String, Object> searchMap = new HashMap<>();

    JSONObject jsonObject = new JSONObject();
    jsonObject.put("manageNo", researchDto.getManageNo());

    searchMap.put(ParamAttribute.CRITERIA, jsonObject);
    totalCount = researchDao.searchCount(searchMap);

    if(totalCount > 0){
      researchDao.update(researchDto);
    }else{
      researchDao.create(researchDto);
    }

  }

  @Override
  public void delete(ResearchDto researchDto) throws ApplicationException {
    researchDao.delete(researchDto);
  }

  @Override
  public List<ResearchDto> searchByConditionCostApprInfo(String manageNo) throws ApplicationException {
    return  researchDao.searchByConditionCostApprInfo(manageNo);
  }
}
