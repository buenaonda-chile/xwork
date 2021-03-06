/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.DeliveryCDRepairItemDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.DeliveryCDRepairItemDto;
import com.globaldenso.dicas.business.service.DeliveryCDRepairItemService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.DeliveryCDRepairItemSearchForm;
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
@Service("deliveryCDRepairItemService")
public class DeliveryCDRepairItemServiceImpl implements DeliveryCDRepairItemService {

  private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryCDRepairItemServiceImpl.class);

  @Autowired
  private DeliveryCDRepairItemDao deliveryCDRepairItemDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public DeliveryCDRepairItemServiceImpl() {
    // no process
  }

  public void setDeliveryCDRepairItemDao(DeliveryCDRepairItemDao deliveryCDRepairItemDao) {
    this.deliveryCDRepairItemDao = deliveryCDRepairItemDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param deliveryCDRepairItemDto DeliveryCDRepairItemDto
   */
  @Override
  public DeliveryCDRepairItemDto searchByKey(DeliveryCDRepairItemDto deliveryCDRepairItemDto) throws ApplicationException {
    return deliveryCDRepairItemDao.searchByKey(deliveryCDRepairItemDto);
  }

  @Override
  public Page<DeliveryCDRepairItemDto> searchByCondition(DeliveryCDRepairItemSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = deliveryCDRepairItemDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<DeliveryCDRepairItemDto> deliveryCDRepairItemDtos = deliveryCDRepairItemDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = deliveryCDRepairItemDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(deliveryCDRepairItemDtos, pageable, totalCount);
  }

  /**
   * ????????? ??????
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void createMst(DeliveryCDRepairItemDto deliveryCDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    deliveryCDRepairItemDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    deliveryCDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    deliveryCDRepairItemDao.createMst(deliveryCDRepairItemDto);
  }
  
  @Override
  public void createDtl(DeliveryCDRepairItemDto deliveryCDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    deliveryCDRepairItemDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    deliveryCDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    deliveryCDRepairItemDao.createDtl(deliveryCDRepairItemDto);
  }

  @Override
  public void updateMst(DeliveryCDRepairItemDto deliveryCDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    deliveryCDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    deliveryCDRepairItemDao.updateMst(deliveryCDRepairItemDto);
  }
  
  @Override
  public void updateDtl(DeliveryCDRepairItemDto deliveryCDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    deliveryCDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    deliveryCDRepairItemDao.updateDtl(deliveryCDRepairItemDto);
  }

  @Override
  public void deleteMst(DeliveryCDRepairItemDto deliveryCDRepairItemDto) throws ApplicationException {
	  deliveryCDRepairItemDao.deleteMst(deliveryCDRepairItemDto);
  }
  
  @Override
  public void deleteDtl(DeliveryCDRepairItemDto deliveryCDRepairItemDto) throws ApplicationException {
	  deliveryCDRepairItemDao.deleteDtl(deliveryCDRepairItemDto);
  }

}
