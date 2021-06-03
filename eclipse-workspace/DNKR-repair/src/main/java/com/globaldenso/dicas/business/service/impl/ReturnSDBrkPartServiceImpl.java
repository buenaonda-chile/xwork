/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ReturnSDBrkPartDao;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.business.dto.ReturnSDBrkPartDto;
import com.globaldenso.dicas.business.service.ReturnSDBrkPartService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import com.globaldenso.dicas.presentation.form.ReturnSDBrkPartSearchForm;
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
@Service("returnSDBrkPartService")
public class ReturnSDBrkPartServiceImpl implements ReturnSDBrkPartService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReturnSDBrkPartServiceImpl.class);

  @Autowired
  private ReturnSDBrkPartDao returnSDBrkPartDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public ReturnSDBrkPartServiceImpl() {
    // no process
  }

  public void setReturnSDBrkPartDao(ReturnSDBrkPartDao returnSDBrkPartDao) {
    this.returnSDBrkPartDao = returnSDBrkPartDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param returnSDBrkPartDto ReturnSDBrkPartDto
   */
  @Override
  public ReturnSDBrkPartDto searchByKey(ReturnSDBrkPartDto returnSDBrkPartDto) throws ApplicationException {
    return returnSDBrkPartDao.searchByKey(returnSDBrkPartDto);
  }

  @Override
  public Page<ReturnSDBrkPartDto> searchByCondition(ReturnSDBrkPartSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //

    int totalCount = 0;
    if (pageable != null)
      totalCount = returnSDBrkPartDao.searchCount(searchMap);

    long end = System.currentTimeMillis();
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); 

    List<ReturnSDBrkPartDto> returnSDBrkPartDtos = returnSDBrkPartDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = returnSDBrkPartDtos.size();

    end = System.currentTimeMillis();
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(returnSDBrkPartDtos, pageable, totalCount);
  }

  /**
   * 고품반납
   * @param criteria
   * @param pageable
   * @return
   * @throws ApplicationException
   */

  @Override
  public void updateMst(ReturnSDBrkPartDto returnSDBrkPartDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    returnSDBrkPartDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    returnSDBrkPartDao.updateMst(returnSDBrkPartDto);
  }
  
}
