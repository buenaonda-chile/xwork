/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.OrderCDRepairItemAdmissDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.OrderCDRepairItemAdmissDto;
import com.globaldenso.dicas.business.service.OrderCDRepairItemAdmissService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.OrderCDRepairItemAdmissSearchForm;
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
@Service("orderCDRepairItemAdmissService")
public class OrderCDRepairItemAdmissServiceImpl implements OrderCDRepairItemAdmissService {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderCDRepairItemAdmissServiceImpl.class);

  @Autowired
  private OrderCDRepairItemAdmissDao orderCDRepairItemAdmissDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public OrderCDRepairItemAdmissServiceImpl() {
    // no process
  }

  public void setOrderCDRepairItemAdmissDao(OrderCDRepairItemAdmissDao orderCDRepairItemAdmissDao) {
    this.orderCDRepairItemAdmissDao = orderCDRepairItemAdmissDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param orderCDRepairItemAdmissDto OrderCDRepairItemAdmissDto
   */
  @Override
  public OrderCDRepairItemAdmissDto searchByKey(OrderCDRepairItemAdmissDto orderCDRepairItemAdmissDto) throws ApplicationException {
    return orderCDRepairItemAdmissDao.searchByKey(orderCDRepairItemAdmissDto);
  }

  @Override
  public Page<OrderCDRepairItemAdmissDto> searchByCondition(OrderCDRepairItemAdmissSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = orderCDRepairItemAdmissDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<OrderCDRepairItemAdmissDto> orderCDRepairItemAdmissDtos = orderCDRepairItemAdmissDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = orderCDRepairItemAdmissDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(orderCDRepairItemAdmissDtos, pageable, totalCount);
  }

  /**
   * ?????????????????????
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void update(OrderCDRepairItemAdmissDto orderCDRepairItemAdmissDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderCDRepairItemAdmissDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    orderCDRepairItemAdmissDao.update(orderCDRepairItemAdmissDto);
  }
}
