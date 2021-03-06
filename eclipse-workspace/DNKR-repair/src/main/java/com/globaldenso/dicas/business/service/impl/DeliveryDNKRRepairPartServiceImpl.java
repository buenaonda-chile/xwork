/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.DeliveryDNKRRepairPartDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.DeliveryCDRepairItemDto;
import com.globaldenso.dicas.business.dto.DeliveryDNKRRepairPartDto;
import com.globaldenso.dicas.business.service.DeliveryDNKRRepairPartService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.DeliveryDNKRRepairPartSearchForm;
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
@Service("deliveryDNKRRepairPartService")
public class DeliveryDNKRRepairPartServiceImpl implements DeliveryDNKRRepairPartService {

  private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryDNKRRepairPartServiceImpl.class);

  @Autowired
  private DeliveryDNKRRepairPartDao deliveryDNKRRepairPartDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public DeliveryDNKRRepairPartServiceImpl() {
    // no process
  }

  public void setReceiptSDBrkPartDao(DeliveryDNKRRepairPartDao deliveryDNKRRepairPartDao) {
    this.deliveryDNKRRepairPartDao = deliveryDNKRRepairPartDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param deliveryDNKRRepairPartDto DeliveryDNKRRepairPartDto
   */
  @Override
  public DeliveryDNKRRepairPartDto searchByKey(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException {
    return deliveryDNKRRepairPartDao.searchByKey(deliveryDNKRRepairPartDto);
  }

  @Override
  public Page<DeliveryDNKRRepairPartDto> searchByCondition(DeliveryDNKRRepairPartSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = deliveryDNKRRepairPartDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<DeliveryDNKRRepairPartDto> deliveryDNKRRepairPartDtos = deliveryDNKRRepairPartDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = deliveryDNKRRepairPartDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(deliveryDNKRRepairPartDtos, pageable, totalCount);
  }

  /**
   * ??????????????????
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void createMst(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    deliveryDNKRRepairPartDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    deliveryDNKRRepairPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    deliveryDNKRRepairPartDao.createMst(deliveryDNKRRepairPartDto);
  }
  
  
  @Override
  public void createDtl(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException {
	// TODO Auto-generated method stub
	  LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	  deliveryDNKRRepairPartDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
	  deliveryDNKRRepairPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

	  deliveryDNKRRepairPartDao.createDtl(deliveryDNKRRepairPartDto);

  }
	
@Override
  public void updateMst(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    deliveryDNKRRepairPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    deliveryDNKRRepairPartDao.updateMst(deliveryDNKRRepairPartDto);
  }

  @Override
  public void updateDtl(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException {
	// TODO Auto-generated method stub
	 LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	 deliveryDNKRRepairPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

	 deliveryDNKRRepairPartDao.updateDtl(deliveryDNKRRepairPartDto);
  }

@Override
  public void deleteMst(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException {
	  deliveryDNKRRepairPartDao.deleteMst(deliveryDNKRRepairPartDto);
  }

@Override
public void deleteDtl(DeliveryDNKRRepairPartDto deliveryDNKRRepairPartDto) throws ApplicationException {
	// TODO Auto-generated method stub
	deliveryDNKRRepairPartDao.deleteDtl(deliveryDNKRRepairPartDto);
}


}
