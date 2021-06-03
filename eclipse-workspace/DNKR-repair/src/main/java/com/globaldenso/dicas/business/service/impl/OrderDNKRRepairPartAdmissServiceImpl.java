/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.OrderDNKRRepairPartAdmissDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.OrderDNKRRepairPartAdmissDto;
import com.globaldenso.dicas.business.service.OrderDNKRRepairPartAdmissService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.OrderDNKRRepairPartAdmissSearchForm;
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
@Service("orderDNKRRepairPartAdmissService")
public class OrderDNKRRepairPartAdmissServiceImpl implements OrderDNKRRepairPartAdmissService {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderDNKRRepairPartAdmissServiceImpl.class);

  @Autowired
  private OrderDNKRRepairPartAdmissDao orderDNKRRepairPartAdmissDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public OrderDNKRRepairPartAdmissServiceImpl() {
    // no process
  }

  public void setOrderDNKRRepairPartAdmissDao(OrderDNKRRepairPartAdmissDao orderDNKRRepairPartAdmissDao) {
    this.orderDNKRRepairPartAdmissDao = orderDNKRRepairPartAdmissDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param orderDNKRRepairPartAdmissDto OrderDNKRRepairPartAdmissDto
   */
  @Override
  public OrderDNKRRepairPartAdmissDto searchByKey(OrderDNKRRepairPartAdmissDto orderDNKRRepairPartAdmissDto) throws ApplicationException {
    return orderDNKRRepairPartAdmissDao.searchByKey(orderDNKRRepairPartAdmissDto);
  }

  @Override
  public Page<OrderDNKRRepairPartAdmissDto> searchByCondition(OrderDNKRRepairPartAdmissSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = orderDNKRRepairPartAdmissDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<OrderDNKRRepairPartAdmissDto> orderDNKRRepairPartAdmissDtos = orderDNKRRepairPartAdmissDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = orderDNKRRepairPartAdmissDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(orderDNKRRepairPartAdmissDtos, pageable, totalCount);
  }

  /**
   * 수리품발주
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */


  @Override
  public void update(OrderDNKRRepairPartAdmissDto orderDNKRRepairPartAdmissDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderDNKRRepairPartAdmissDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    orderDNKRRepairPartAdmissDao.update(orderDNKRRepairPartAdmissDto);
  }

}
