/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ReceiptCDRepairReplacementDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReceiptCDRepairReplacementDto;
import com.globaldenso.dicas.business.service.ReceiptCDRepairReplacementService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ReceiptCDRepairReplacementSearchForm;
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
@Service("receiptCDRepairReplacementService")
public class ReceiptCDRepairReplacementServiceImpl implements ReceiptCDRepairReplacementService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiptCDRepairReplacementServiceImpl.class);

  @Autowired
  private ReceiptCDRepairReplacementDao receiptCDRepairReplacementDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ReceiptCDRepairReplacementServiceImpl() {
    // no process
  }

  public void setReceiptCDRepairReplacementDao(ReceiptCDRepairReplacementDao receiptCDRepairReplacementDao) {
    this.receiptCDRepairReplacementDao = receiptCDRepairReplacementDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param receiptCDRepairReplacementDto ReceiptCDRepairReplacementDto
   */
  @Override
  public ReceiptCDRepairReplacementDto searchByKey(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException {
    return receiptCDRepairReplacementDao.searchByKey(receiptCDRepairReplacementDto);
  }

  @Override
  public Page<ReceiptCDRepairReplacementDto> searchByCondition(ReceiptCDRepairReplacementSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = receiptCDRepairReplacementDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<ReceiptCDRepairReplacementDto> receiptCDRepairReplacementDtos = receiptCDRepairReplacementDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = receiptCDRepairReplacementDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(receiptCDRepairReplacementDtos, pageable, totalCount);
  }

  /**
   * ?????????????????????
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void createMst(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptCDRepairReplacementDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    receiptCDRepairReplacementDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptCDRepairReplacementDao.createMst(receiptCDRepairReplacementDto);
  }
  
  @Override
  public void createDtl(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptCDRepairReplacementDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    receiptCDRepairReplacementDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptCDRepairReplacementDao.createDtl(receiptCDRepairReplacementDto);
  }

  @Override
  public void updateMst(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptCDRepairReplacementDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptCDRepairReplacementDao.updateMst(receiptCDRepairReplacementDto);
  }
  
  @Override
  public void updateDtl(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptCDRepairReplacementDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptCDRepairReplacementDao.updateDtl(receiptCDRepairReplacementDto);
  }

  @Override
  public void deleteMst(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException {
	  receiptCDRepairReplacementDao.deleteMst(receiptCDRepairReplacementDto);
  }
  
  @Override
  public void deleteDtl(ReceiptCDRepairReplacementDto receiptCDRepairReplacementDto) throws ApplicationException {
	  receiptCDRepairReplacementDao.deleteDtl(receiptCDRepairReplacementDto);
  }

}
