/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.OrderCDRepairPartDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.OrderCDRepairPartDto;
import com.globaldenso.dicas.business.service.OrderCDRepairPartService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.OrderCDRepairPartSearchForm;
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
@Service("orderCDRepairPartService")
public class OrderCDRepairPartServiceImpl implements OrderCDRepairPartService {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderCDRepairPartServiceImpl.class);

  @Autowired
  private OrderCDRepairPartDao orderCDRepairPartDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public OrderCDRepairPartServiceImpl() {
    // no process
  }

  public void setOrderCDRepairPartDao(OrderCDRepairPartDao orderCDRepairPartDao) {
    this.orderCDRepairPartDao = orderCDRepairPartDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param orderCDRepairPartDto OrderCDRepairPartDto
   */
  @Override
  public OrderCDRepairPartDto searchByKey(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException {
    return orderCDRepairPartDao.searchByKey(orderCDRepairPartDto);
  }

  @Override
  public Page<OrderCDRepairPartDto> searchByCondition(OrderCDRepairPartSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = orderCDRepairPartDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<OrderCDRepairPartDto> orderCDRepairPartDtos = orderCDRepairPartDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = orderCDRepairPartDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(orderCDRepairPartDtos, pageable, totalCount);
  }

  /**
   * ??????????????????
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void createMst(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderCDRepairPartDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    orderCDRepairPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    orderCDRepairPartDao.createMst(orderCDRepairPartDto);
  }
  
  @Override
  public void createDtl(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderCDRepairPartDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    orderCDRepairPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    orderCDRepairPartDao.createDtl(orderCDRepairPartDto);
  }

  @Override
  public void updateMst(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderCDRepairPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    orderCDRepairPartDao.updateMst(orderCDRepairPartDto);
  }
  
  @Override
  public void updateDtl(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderCDRepairPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    orderCDRepairPartDao.updateDtl(orderCDRepairPartDto);
  }

  @Override
  public void deleteMst(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException {
	  orderCDRepairPartDao.deleteMst(orderCDRepairPartDto);
  }
  
  @Override
  public void deleteDtl(OrderCDRepairPartDto orderCDRepairPartDto) throws ApplicationException {
	  orderCDRepairPartDao.deleteDtl(orderCDRepairPartDto);
  }

}
