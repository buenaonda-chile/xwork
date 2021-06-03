/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.SaleSDRepairItemDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.SaleSDRepairItemDto;
import com.globaldenso.dicas.business.service.SaleSDRepairItemService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.SaleSDRepairItemSearchForm;
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
@Service("saleSDRepairItemService")
public class SaleSDRepairItemServiceImpl implements SaleSDRepairItemService {

  private static final Logger LOGGER = LoggerFactory.getLogger(SaleSDRepairItemServiceImpl.class);

  @Autowired
  private SaleSDRepairItemDao saleSDRepairItemDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public SaleSDRepairItemServiceImpl() {
    // no process
  }

  public void setSaleSDRepairItemDao(SaleSDRepairItemDao saleSDRepairItemDao) {
    this.saleSDRepairItemDao = saleSDRepairItemDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param saleSDRepairItemDto SaleSDRepairItemDto
   */
  @Override
  public SaleSDRepairItemDto searchByKey(SaleSDRepairItemDto saleSDRepairItemDto) throws ApplicationException {
    return saleSDRepairItemDao.searchByKey(saleSDRepairItemDto);
  }

  @Override
  public Page<SaleSDRepairItemDto> searchByCondition(SaleSDRepairItemSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = saleSDRepairItemDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<SaleSDRepairItemDto> saleSDRepairItemDtos = saleSDRepairItemDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = saleSDRepairItemDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(saleSDRepairItemDtos, pageable, totalCount);
  }

  /**
   * 수리품판매
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void create(SaleSDRepairItemDto saleSDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    saleSDRepairItemDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    saleSDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
    
    saleSDRepairItemDao.create(saleSDRepairItemDto);
  }


  @Override
  public void update(SaleSDRepairItemDto saleSDRepairItemDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    saleSDRepairItemDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    saleSDRepairItemDao.update(saleSDRepairItemDto);
  }


  @Override
  public void delete(SaleSDRepairItemDto saleSDRepairItemDto) throws ApplicationException {
	  saleSDRepairItemDao.delete(saleSDRepairItemDto);
  }
  
}
