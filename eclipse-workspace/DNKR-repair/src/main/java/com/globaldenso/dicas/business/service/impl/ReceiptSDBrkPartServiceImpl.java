/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ReceiptSDBrkPartDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReceiptSDBrkPartDto;
import com.globaldenso.dicas.business.service.ReceiptSDBrkPartService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ReceiptSDBrkPartSearchForm;
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
@Service("receiptSDBrkPartService")
public class ReceiptSDBrkPartServiceImpl implements ReceiptSDBrkPartService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiptSDBrkPartServiceImpl.class);

  @Autowired
  private ReceiptSDBrkPartDao receiptSDBrkPartDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ReceiptSDBrkPartServiceImpl() {
    // no process
  }

  public void setReceiptSDBrkPartDao(ReceiptSDBrkPartDao receiptSDBrkPartDao) {
    this.receiptSDBrkPartDao = receiptSDBrkPartDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param receiptSDBrkPartDto ReceiptSDBrkPartDto
   */
  @Override
  public ReceiptSDBrkPartDto searchByKey(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException {
    return receiptSDBrkPartDao.searchByKey(receiptSDBrkPartDto);
  }

  @Override
  public Page<ReceiptSDBrkPartDto> searchByCondition(ReceiptSDBrkPartSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = receiptSDBrkPartDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<ReceiptSDBrkPartDto> receiptSDBrkPartDtos = receiptSDBrkPartDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = receiptSDBrkPartDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(receiptSDBrkPartDtos, pageable, totalCount);
  }

  /**
   * 고품접수
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void createMst(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptSDBrkPartDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    receiptSDBrkPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
//    trainingInfoBaseDto.setReceiptNm(loginVO.getUsername());

//    if ("SDAC".equals(loginVO.getDeptCd())) {
//    	trainingInfoBaseDto.setPrefix("SD_");
//    } else {
//    	trainingInfoBaseDto.setPrefix("KR_");
//    }

    receiptSDBrkPartDao.createMst(receiptSDBrkPartDto);
  }
  
  @Override
  public void createDtl(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptSDBrkPartDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    receiptSDBrkPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
//    trainingInfoBaseDto.setReceiptNm(loginVO.getUsername());

//    if ("SDAC".equals(loginVO.getDeptCd())) {
//    	trainingInfoBaseDto.setPrefix("SD_");
//    } else {
//    	trainingInfoBaseDto.setPrefix("KR_");
//    }

    receiptSDBrkPartDao.createDtl(receiptSDBrkPartDto);
  }

  @Override
  public void updateMst(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptSDBrkPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptSDBrkPartDao.updateMst(receiptSDBrkPartDto);
  }
  
  @Override
  public void updateDtl(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptSDBrkPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptSDBrkPartDao.updateDtl(receiptSDBrkPartDto);
  }

  @Override
  public void deleteMst(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException {
	  receiptSDBrkPartDao.deleteMst(receiptSDBrkPartDto);
  }
  
  @Override
  public void deleteDtl(ReceiptSDBrkPartDto receiptSDBrkPartDto) throws ApplicationException {
	  receiptSDBrkPartDao.deleteDtl(receiptSDBrkPartDto);
  }

}
