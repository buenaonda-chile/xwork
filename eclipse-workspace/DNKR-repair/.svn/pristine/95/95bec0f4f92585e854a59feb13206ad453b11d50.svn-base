/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.CustomerPopUpDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.CustomerPopUpDto;
import com.globaldenso.dicas.business.service.CustomerPopUpService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.CustomerPopUpSearchForm;
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
@Service("customerPopUpService")
public class CustomerPopUpServiceImpl implements CustomerPopUpService {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerPopUpServiceImpl.class);

  @Autowired
  private CustomerPopUpDao customerPopUpDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public CustomerPopUpServiceImpl() {
    // no process
  }

  public void setCustomerPopUpDao(CustomerPopUpDao customerPopUpDao) {
    this.customerPopUpDao = customerPopUpDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param customerPopUpDto CustomerPopUpDto
   */
  @Override
  public CustomerPopUpDto searchByKey(CustomerPopUpDto customerPopUpDto) throws ApplicationException {
    return customerPopUpDao.searchByKey(customerPopUpDto);
  }

  @Override
  public Page<CustomerPopUpDto> searchByCondition(CustomerPopUpSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = customerPopUpDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<CustomerPopUpDto> CustomerPopUpDtos = customerPopUpDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = CustomerPopUpDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(CustomerPopUpDtos, pageable, totalCount);
  }

}
