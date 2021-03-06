/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ReceiptCDBrkPartAdmissDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReceiptCDBrkPartAdmissDto;
import com.globaldenso.dicas.business.service.ReceiptCDBrkPartAdmissService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ReceiptCDBrkPartAdmissSearchForm;
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
@Service("receiptCDBrkPartAdmissService")
public class ReceiptCDBrkPartAdmissServiceImpl implements ReceiptCDBrkPartAdmissService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiptCDBrkPartAdmissServiceImpl.class);

  @Autowired
  private ReceiptCDBrkPartAdmissDao receiptCDBrkPartAdmissDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ReceiptCDBrkPartAdmissServiceImpl() {
    // no process
  }

  public void setReceiptCDBrkPartAdmissDao(ReceiptCDBrkPartAdmissDao receiptCDBrkPartAdmissDao) {
    this.receiptCDBrkPartAdmissDao = receiptCDBrkPartAdmissDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param receiptCDBrkPartAdmissDto ReceiptCDBrkPartAdmissDto
   */
  @Override
  public ReceiptCDBrkPartAdmissDto searchByKey(ReceiptCDBrkPartAdmissDto receiptCDBrkPartAdmissDto) throws ApplicationException {
    return receiptCDBrkPartAdmissDao.searchByKey(receiptCDBrkPartAdmissDto);
  }

  @Override
  public Page<ReceiptCDBrkPartAdmissDto> searchByCondition(ReceiptCDBrkPartAdmissSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = receiptCDBrkPartAdmissDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<ReceiptCDBrkPartAdmissDto> receiptCDBrkPartAdmissDtos = receiptCDBrkPartAdmissDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = receiptCDBrkPartAdmissDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(receiptCDBrkPartAdmissDtos, pageable, totalCount);
  }

  /**
   * ????????????
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void update(ReceiptCDBrkPartAdmissDto ReceiptCDBrkPartAdmissDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    ReceiptCDBrkPartAdmissDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptCDBrkPartAdmissDao.update(ReceiptCDBrkPartAdmissDto);
  }
}
