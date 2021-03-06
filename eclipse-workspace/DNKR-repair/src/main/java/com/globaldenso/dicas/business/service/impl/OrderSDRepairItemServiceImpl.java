/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.OrderSDRepairItemDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.OrderSDRepairItemDto;
import com.globaldenso.dicas.business.service.OrderSDRepairItemService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.OrderSDRepairItemSearchForm;
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
@Service("orderSDRepairItemService")
public class OrderSDRepairItemServiceImpl implements OrderSDRepairItemService {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderSDRepairItemServiceImpl.class);

  @Autowired
  private OrderSDRepairItemDao orderSDRepairItemDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public OrderSDRepairItemServiceImpl() {
    // no process
  }

  public void setOrderRepairItemDao(OrderSDRepairItemDao orderSDRepairItemDao) {
    this.orderSDRepairItemDao = orderSDRepairItemDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param orderRepairItemDto OrderRepairItemDto
   */
  @Override
  public OrderSDRepairItemDto searchByKey(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException {
    return orderSDRepairItemDao.searchByKey(orderSDRepairItemDto);
  }

  @Override
  public Page<OrderSDRepairItemDto> searchByCondition(OrderSDRepairItemSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = orderSDRepairItemDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<OrderSDRepairItemDto> orderSDRepairItemDtos = orderSDRepairItemDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = orderSDRepairItemDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(orderSDRepairItemDtos, pageable, totalCount);
  }

  /**
   * ???????????????
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void createMst(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderSDRepairItemDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    orderSDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
//    trainingInfoBaseDto.setReceiptNm(loginVO.getUsername());

//    if ("SDAC".equals(loginVO.getDeptCd())) {
//    	trainingInfoBaseDto.setPrefix("SD_");
//    } else {
//    	trainingInfoBaseDto.setPrefix("KR_");
//    }

    orderSDRepairItemDao.createMst(orderSDRepairItemDto);
  }
  
  @Override
  public void createDtl(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderSDRepairItemDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    orderSDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    orderSDRepairItemDao.createDtl(orderSDRepairItemDto);
  }

  @Override
  public void updateMst(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderSDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    orderSDRepairItemDao.updateMst(orderSDRepairItemDto);
  }
  
  @Override
  public void updateDtl(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    orderSDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    orderSDRepairItemDao.updateDtl(orderSDRepairItemDto);
  }

  @Override
  public void deleteMst(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException {
	  orderSDRepairItemDao.deleteMst(orderSDRepairItemDto);
  }
  
  @Override
  public void deleteDtl(OrderSDRepairItemDto orderSDRepairItemDto) throws ApplicationException {
	  orderSDRepairItemDao.deleteDtl(orderSDRepairItemDto);
  }

}
