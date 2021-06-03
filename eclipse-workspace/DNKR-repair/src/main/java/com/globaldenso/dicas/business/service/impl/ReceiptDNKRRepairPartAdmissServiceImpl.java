/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ReceiptDNKRRepairPartAdmissDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReceiptDNKRRepairPartAdmissDto;
import com.globaldenso.dicas.business.service.ReceiptDNKRRepairPartAdmissService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ReceiptDNKRRepairPartAdmissSearchForm;
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
@Service("receiptDNKRRepairPartAdmissService")
public class ReceiptDNKRRepairPartAdmissServiceImpl implements ReceiptDNKRRepairPartAdmissService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiptDNKRRepairPartAdmissServiceImpl.class);

  @Autowired
  private ReceiptDNKRRepairPartAdmissDao receiptDNKRRepairPartAdmissDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ReceiptDNKRRepairPartAdmissServiceImpl() {
    // no process
  }

  public void setOrderDNKRRepairPartAdmissDao(ReceiptDNKRRepairPartAdmissDao receiptDNKRRepairPartAdmissDao) {
    this.receiptDNKRRepairPartAdmissDao = receiptDNKRRepairPartAdmissDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param receiptDNKRRepairPartAdmissDto ReceiptDNKRRepairPartAdmissDto
   */
  @Override
  public ReceiptDNKRRepairPartAdmissDto searchByKey(ReceiptDNKRRepairPartAdmissDto receiptDNKRRepairPartAdmissDto) throws ApplicationException {
    return receiptDNKRRepairPartAdmissDao.searchByKey(receiptDNKRRepairPartAdmissDto);
  }

  @Override
  public Page<ReceiptDNKRRepairPartAdmissDto> searchByCondition(ReceiptDNKRRepairPartAdmissSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = receiptDNKRRepairPartAdmissDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<ReceiptDNKRRepairPartAdmissDto> receiptDNKRRepairPartAdmissDtos = receiptDNKRRepairPartAdmissDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = receiptDNKRRepairPartAdmissDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(receiptDNKRRepairPartAdmissDtos, pageable, totalCount);
  }

  /**
   * 수리품발주
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */


  @Override
  public void update(ReceiptDNKRRepairPartAdmissDto receiptDNKRRepairPartAdmissDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    receiptDNKRRepairPartAdmissDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    receiptDNKRRepairPartAdmissDao.update(receiptDNKRRepairPartAdmissDto);
  }

}
