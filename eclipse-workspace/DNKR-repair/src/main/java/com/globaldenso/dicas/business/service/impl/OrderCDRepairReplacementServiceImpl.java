/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.OrderCDRepairReplacementDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.OrderCDRepairReplacementDto;
import com.globaldenso.dicas.business.service.OrderCDRepairReplacementService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.OrderCDRepairReplacementSearchForm;
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
@Service("orderCDRepairReplacementService")
public class OrderCDRepairReplacementServiceImpl implements OrderCDRepairReplacementService {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderCDRepairReplacementServiceImpl.class);

  @Autowired
  private OrderCDRepairReplacementDao orderCDRepairReplacementDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public OrderCDRepairReplacementServiceImpl() {
    // no process
  }

  public void setOrderCDRepairReplacementDao(OrderCDRepairReplacementDao orderCDRepairReplacementDao) {
    this.orderCDRepairReplacementDao = orderCDRepairReplacementDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param orderCDRepairReplacementDto OrderCDRepairReplacementDto
   */
  @Override
  public OrderCDRepairReplacementDto searchByKey(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException {
    return orderCDRepairReplacementDao.searchByKey(orderCDRepairReplacementDto);
  }

  @Override
  public Page<OrderCDRepairReplacementDto> searchByCondition(OrderCDRepairReplacementSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = orderCDRepairReplacementDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<OrderCDRepairReplacementDto> orderCDRepairReplacementDtos = orderCDRepairReplacementDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = orderCDRepairReplacementDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(orderCDRepairReplacementDtos, pageable, totalCount);
  }

  /**
   * ?????????????????????
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void createMst(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderCDRepairReplacementDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    orderCDRepairReplacementDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    orderCDRepairReplacementDao.createMst(orderCDRepairReplacementDto);
  }
  
  @Override
  public void createDtl(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderCDRepairReplacementDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    orderCDRepairReplacementDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    orderCDRepairReplacementDao.createDtl(orderCDRepairReplacementDto);
  }

  @Override
  public void updateMst(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderCDRepairReplacementDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    orderCDRepairReplacementDao.updateMst(orderCDRepairReplacementDto);
  }
  
  @Override
  public void updateDtl(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderCDRepairReplacementDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    orderCDRepairReplacementDao.updateDtl(orderCDRepairReplacementDto);
  }

  @Override
  public void deleteMst(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException {
	  orderCDRepairReplacementDao.deleteMst(orderCDRepairReplacementDto);
  }
  
  @Override
  public void deleteDtl(OrderCDRepairReplacementDto orderCDRepairReplacementDto) throws ApplicationException {
	  orderCDRepairReplacementDao.deleteDtl(orderCDRepairReplacementDto);
  }

}
