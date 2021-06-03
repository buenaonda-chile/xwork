/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ResultMasterDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.service.ResultMasterService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.rte.fdl.string.EgovStringUtil;
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
@Service("resultmasterService")
public class ResultMasterServiceImpl implements ResultMasterService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ResultMasterServiceImpl.class);

  @Autowired
  private ResultMasterDao resultmasterDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ResultMasterServiceImpl() {
    // no process
  }

  public void setResultMasterDao(ResultMasterDao resultmasterDao) {
    this.resultmasterDao = resultmasterDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param resultmasterDto ResultMasterDto
   */
  @Override
  public ResultMasterDto searchByKey(ResultMasterDto resultmasterDto) throws ApplicationException {
    return resultmasterDao.searchByKey(resultmasterDto);
  }

  @Override
  public Page<ResultMasterDto> searchByCondition(ResultMasterSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = resultmasterDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<ResultMasterDto> resultmasterDtos = resultmasterDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = resultmasterDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(resultmasterDtos, pageable, totalCount);
  }


  @Override
  public List<ResultMasterDto> searchGrpCdByCondition(ResultMasterSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<ResultMasterDto> searchResultMasterByCondition(ResultMasterSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public Page<ResultMasterDto> searchByCondition2(ResultMasterSearchForm criteria, Pageable pageable)
          throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = resultmasterDao.searchCount2(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<ResultMasterDto> resultmasterDtos = resultmasterDao.searchByCondition2(searchMap);
    if (totalCount == 0) totalCount = resultmasterDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(resultmasterDtos, pageable, totalCount);
  }

  @Override
  public Page<ResultMasterDto> searchListByCondition(ResultMasterSearchForm criteria, Pageable pageable) throws ApplicationException {
    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

    if (!EgovStringUtil.isNull(loginVO.getOfficeNm())){
      criteria.setSdAppoint(loginVO.getUsername());
    }

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;

    if(pageable != null)
     totalCount = resultmasterDao.searchListByCount(searchMap);


    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis();

    List<ResultMasterDto> resultmasterDtos = resultmasterDao.searchListByCondition(searchMap);
    if (totalCount == 0) totalCount = resultmasterDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(resultmasterDtos, pageable, totalCount);
  }

  @Override
  public Page<ResultMasterDto> searchListByCondition2(ResultMasterSearchForm criteria, Pageable pageable) throws ApplicationException {
    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

    if (!EgovStringUtil.isNull(loginVO.getOfficeNm())){
      criteria.setSdAppoint(loginVO.getUsername());
    }

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;

    if(pageable != null)
      totalCount = resultmasterDao.searchListByCount2(searchMap);


    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis();

    List<ResultMasterDto> resultmasterDtos = resultmasterDao.searchListByCondition2(searchMap);
    if (totalCount == 0) totalCount = resultmasterDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(resultmasterDtos, pageable, totalCount);
  }

  @Override
  public Page<ResultMasterDto> searchListByConditionDownload(ResultMasterSearchForm criteria, Pageable pageable) throws ApplicationException {
    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;

    if(pageable != null)
      totalCount = resultmasterDao.searchListByCount(searchMap);


    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis();

    List<ResultMasterDto> resultmasterDtos = resultmasterDao.searchListByConditionDownload(searchMap);
    if (totalCount == 0) totalCount = resultmasterDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(resultmasterDtos, pageable, totalCount);
  }

  @Override
  public List<ResultMasterDto> searchMainListByCondition() throws ApplicationException {
    return  resultmasterDao.searchMainListByCondition();
  }

  @Override
  public List<ResultMasterDto> searchMainListByUser() throws ApplicationException {
    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    String id = null;
    if (!loginVO.getUsername().equals("system")){
      id = loginVO.getUsername();
    }
    return resultmasterDao.searchMainListByUser(id);
  }

  @Override
  public void create(ResultMasterDto resultmasterDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    resultmasterDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    resultmasterDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    resultmasterDao.create(resultmasterDto);
  }

  @Override
  public void update(ResultMasterDto resultmasterDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    resultmasterDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    int totalCount = 0;
    Map<String, Object> searchMap = new HashMap<>();

    JSONObject jsonObject = new JSONObject();
    jsonObject.put("manageNo", resultmasterDto.getManageNo());

    searchMap.put(ParamAttribute.CRITERIA, jsonObject);
    totalCount = resultmasterDao.searchCount(searchMap);

    if(totalCount > 0){
      resultmasterDao.update(resultmasterDto);
    }else{
      resultmasterDao.create(resultmasterDto);
    }

  }

    @Override
    public void updateManageNo(ResultMasterDto resultmasterDto) throws ApplicationException {

        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        resultmasterDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

        int totalCount = 0;
        Map<String, Object> searchMap = new HashMap<>();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("manageNo", resultmasterDto.getManageNo());

        searchMap.put(ParamAttribute.CRITERIA, jsonObject);
        totalCount = resultmasterDao.searchCount(searchMap);

        if(totalCount > 0){
            resultmasterDao.updateManageNo(resultmasterDto);
        }else{
            resultmasterDao.create(resultmasterDto);
        }

      if (!EgovStringUtil.isEmpty(resultmasterDto.getFiles())) {
        transactAtchmnfl(resultmasterDto);
      }

    }


  @Override
  public void gridUpdate(ResultMasterDto resultmasterDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    resultmasterDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    resultmasterDao.gridUpdate(resultmasterDto);

  }

  @Override
  public void delete(ResultMasterDto resultmasterDto) throws ApplicationException {
    resultmasterDao.delete(resultmasterDto);
  }

  @Override
  public void update2(ResultMasterDto resultmasterDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    resultmasterDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    resultmasterDao.update2(resultmasterDto);

  }

  @Override
  public void update3(ResultMasterDto resultmasterDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    resultmasterDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    resultmasterDao.update3(resultmasterDto);

  }

  @Override
  public void update4(ResultMasterDto resultmasterDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    resultmasterDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    resultmasterDao.update4(resultmasterDto);

  }

  @Override
  public void deleteManageNo(ResultMasterDto resultmasterDto) throws ApplicationException {
    resultmasterDao.deleteManageNo(resultmasterDto);
  }

  private void transactAtchmnfl(ResultMasterDto resultmasterDto) throws ApplicationException {
    List<String> files = Arrays.asList(resultmasterDto.getFiles().split(","));
    for(String str: files) {
      resultmasterDto.setAtchmnflId(Long.parseLong(str));
      if (resultmasterDao.searchCountByKey(resultmasterDto) == 0) {
        resultmasterDao.fileCreate(resultmasterDto);
      }
    }
  }

  @Override
  public void update5(ResultMasterDto resultmasterDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    resultmasterDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    resultmasterDao.update5(resultmasterDto);

  }

  @Override
  public void mobileUpdate(ResultMasterDto resultmasterDto) throws ApplicationException {
    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    resultmasterDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    resultmasterDao.mobileUpdate(resultmasterDto);
  }

  @Override
  public Page<ResultMasterDto> selectMstInfo(ResultMasterSearchForm criteria, Pageable pageable)
          throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = resultmasterDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<ResultMasterDto> resultmasterDtos = resultmasterDao.selectMstInfo(searchMap);
    if (totalCount == 0) totalCount = resultmasterDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(resultmasterDtos, pageable, totalCount);
  }
}
