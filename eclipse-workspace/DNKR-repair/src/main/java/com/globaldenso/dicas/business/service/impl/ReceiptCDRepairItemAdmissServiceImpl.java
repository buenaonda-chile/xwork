/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ReceiptCDRepairItemAdmissDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReceiptCDRepairItemAdmissDto;
import com.globaldenso.dicas.business.service.ReceiptCDRepairItemAdmissService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ReceiptCDRepairItemAdmissSearchForm;
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
@Service("receiptCDRepairItemAdmissService")
public class ReceiptCDRepairItemAdmissServiceImpl implements ReceiptCDRepairItemAdmissService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiptCDRepairItemAdmissServiceImpl.class);

  @Autowired
  private ReceiptCDRepairItemAdmissDao receiptCDRepairItemAdmissDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ReceiptCDRepairItemAdmissServiceImpl() {
    // no process
  }

  public void setReceiptCDRepairItemAdmissDao(ReceiptCDRepairItemAdmissDao receiptCDRepairItemAdmissDao) {
    this.receiptCDRepairItemAdmissDao = receiptCDRepairItemAdmissDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param receiptCDRepairItemAdmissDto ReceiptCDRepairItemAdmissDto
   */
  @Override
  public ReceiptCDRepairItemAdmissDto searchByKey(ReceiptCDRepairItemAdmissDto receiptCDRepairItemAdmissDto) throws ApplicationException {
    return receiptCDRepairItemAdmissDao.searchByKey(receiptCDRepairItemAdmissDto);
  }

  @Override
  public Page<ReceiptCDRepairItemAdmissDto> searchByCondition(ReceiptCDRepairItemAdmissSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = receiptCDRepairItemAdmissDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<ReceiptCDRepairItemAdmissDto> receiptCDRepairItemAdmissDtos = receiptCDRepairItemAdmissDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = receiptCDRepairItemAdmissDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(receiptCDRepairItemAdmissDtos, pageable, totalCount);
  }

  /**
   * ?????????????????????
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void update(ReceiptCDRepairItemAdmissDto receiptCDRepairItemAdmissDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptCDRepairItemAdmissDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptCDRepairItemAdmissDao.update(receiptCDRepairItemAdmissDto);
  }
}
