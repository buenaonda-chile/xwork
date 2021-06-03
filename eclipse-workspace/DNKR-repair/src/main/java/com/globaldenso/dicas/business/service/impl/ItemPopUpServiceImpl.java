/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ItemPopUpDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ItemPopUpDto;
import com.globaldenso.dicas.business.service.ItemPopUpService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ItemPopUpSearchForm;
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
@Service("itemPopUpService")
public class ItemPopUpServiceImpl implements ItemPopUpService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ItemPopUpServiceImpl.class);

  @Autowired
  private ItemPopUpDao itemPopUpDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ItemPopUpServiceImpl() {
    // no process
  }

  public void setCustomerPopUpDao(ItemPopUpDao itemPopUpDao) {
    this.itemPopUpDao = itemPopUpDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param itemPopUpDto ItemPopUpDto
   */
  @Override
  public ItemPopUpDto searchByKey(ItemPopUpDto itemPopUpDto) throws ApplicationException {
    return itemPopUpDao.searchByKey(itemPopUpDto);
  }

  @Override
  public Page<ItemPopUpDto> searchByCondition(ItemPopUpSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = itemPopUpDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<ItemPopUpDto> ItemPopUpDtos = itemPopUpDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = ItemPopUpDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(ItemPopUpDtos, pageable, totalCount);
  }

}
