/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ReceiptCDRepairPartDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReceiptCDRepairPartDto;
import com.globaldenso.dicas.business.service.ReceiptCDRepairPartService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ReceiptCDRepairPartSearchForm;
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
@Service("receiptCDRepairPartService")
public class ReceiptCDRepairPartServiceImpl implements ReceiptCDRepairPartService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiptCDRepairPartServiceImpl.class);

  @Autowired
  private ReceiptCDRepairPartDao receiptCDRepairPartDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ReceiptCDRepairPartServiceImpl() {
    // no process
  }

  public void setReceiptCDRepairPartDao(ReceiptCDRepairPartDao receiptCDRepairPartDao) {
    this.receiptCDRepairPartDao = receiptCDRepairPartDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param receiptCDRepairPartDto ReceiptCDRepairPartDto
   */
  @Override
  public ReceiptCDRepairPartDto searchByKey(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException {
    return receiptCDRepairPartDao.searchByKey(receiptCDRepairPartDto);
  }

  @Override
  public Page<ReceiptCDRepairPartDto> searchByCondition(ReceiptCDRepairPartSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = receiptCDRepairPartDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<ReceiptCDRepairPartDto> receiptCDRepairPartDtos = receiptCDRepairPartDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = receiptCDRepairPartDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(receiptCDRepairPartDtos, pageable, totalCount);
  }

  /**
   * ???????????????
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void createMst(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptCDRepairPartDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    receiptCDRepairPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptCDRepairPartDao.createMst(receiptCDRepairPartDto);
  }
  
  @Override
  public void createDtl(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptCDRepairPartDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    receiptCDRepairPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptCDRepairPartDao.createDtl(receiptCDRepairPartDto);
  }

  @Override
  public void updateMst(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptCDRepairPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptCDRepairPartDao.updateMst(receiptCDRepairPartDto);
  }
  
  @Override
  public void updateDtl(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptCDRepairPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptCDRepairPartDao.updateDtl(receiptCDRepairPartDto);
  }


  @Override
  public void deleteMst(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException {
	  receiptCDRepairPartDao.deleteMst(receiptCDRepairPartDto);
  }
  
  @Override
  public void deleteDtl(ReceiptCDRepairPartDto receiptCDRepairPartDto) throws ApplicationException {
	  receiptCDRepairPartDao.deleteDtl(receiptCDRepairPartDto);
  }

}
