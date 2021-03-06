/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ReceiptSDRepairItemDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReceiptSDRepairItemDto;
import com.globaldenso.dicas.business.service.ReceiptSDRepairItemService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ReceiptSDRepairItemSearchForm;
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
@Service("receiptSDRepairItemService")
public class ReceiptSDRepairItemServiceImpl implements ReceiptSDRepairItemService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiptSDRepairItemServiceImpl.class);

  @Autowired
  private ReceiptSDRepairItemDao receiptSDRepairItemDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ReceiptSDRepairItemServiceImpl() {
    // no process
  }

  public void setReceiptSDBrkPartDao(ReceiptSDRepairItemDao receiptSDRepairItemDao) {
    this.receiptSDRepairItemDao = receiptSDRepairItemDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param receiptSDRepairItemDto ReceiptSDRepairItemDto
   */
  @Override
  public ReceiptSDRepairItemDto searchByKey(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException {
    return receiptSDRepairItemDao.searchByKey(receiptSDRepairItemDto);
  }

  @Override
  public Page<ReceiptSDRepairItemDto> searchByCondition(ReceiptSDRepairItemSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = receiptSDRepairItemDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<ReceiptSDRepairItemDto> receiptSDRepairItemDtos = receiptSDRepairItemDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = receiptSDRepairItemDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(receiptSDRepairItemDtos, pageable, totalCount);
  }

  /**
   * ???????????????
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void createMst(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptSDRepairItemDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    receiptSDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
//    trainingInfoBaseDto.setReceiptNm(loginVO.getUsername());

//    if ("SDAC".equals(loginVO.getDeptCd())) {
//    	trainingInfoBaseDto.setPrefix("SD_");
//    } else {
//    	trainingInfoBaseDto.setPrefix("KR_");
//    }

    receiptSDRepairItemDao.createMst(receiptSDRepairItemDto);
  }
  
  @Override
  public void createDtl(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptSDRepairItemDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    receiptSDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptSDRepairItemDao.createDtl(receiptSDRepairItemDto);
  }

  @Override
  public void updateMst(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptSDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptSDRepairItemDao.updateMst(receiptSDRepairItemDto);
  }
  
  @Override
  public void updateDtl(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptSDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptSDRepairItemDao.updateDtl(receiptSDRepairItemDto);
  }


  @Override
  public void deleteMst(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException {
	  receiptSDRepairItemDao.deleteMst(receiptSDRepairItemDto);
  }
  
  @Override
  public void deleteDtl(ReceiptSDRepairItemDto receiptSDRepairItemDto) throws ApplicationException {
	  receiptSDRepairItemDao.deleteDtl(receiptSDRepairItemDto);
  }

}
