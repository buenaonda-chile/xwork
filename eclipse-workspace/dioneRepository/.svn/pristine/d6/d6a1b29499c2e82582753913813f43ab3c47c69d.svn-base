/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.RoleDao;
import com.globaldenso.dicas.business.dto.RoleDto;
import com.globaldenso.dicas.business.service.RoleService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.RoleSearchForm;
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

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

  @Autowired
  private RoleDao roleDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public RoleServiceImpl() {
    // no process
  }

  public void setRoleDao(RoleDao roleDao) {
    this.roleDao = roleDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param roleDto RoleDto
   */
  @Override
  public RoleDto searchByKey(RoleDto roleDto) throws ApplicationException {
    return roleDao.searchByKey(roleDto);
  }

  @Override
  public Page<RoleDto> searchByCondition(RoleSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;
    if (pageable != null)
      totalCount = roleDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<RoleDto> roleDtos = roleDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = roleDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return new PageImpl<>(roleDtos, pageable, totalCount);
  }

  @Override
  public List<RoleDto> searchGrpCdByCondition(RoleSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<RoleDto> searchRoleByCondition(RoleSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(RoleDto roleDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    roleDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    roleDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    roleDao.create(roleDto);
  }

  @Override
  public void update(RoleDto roleDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    roleDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    roleDao.update(roleDto);
  }

  @Override
  public void delete(RoleDto roleDto) throws ApplicationException {
    roleDao.delete(roleDto);
  }

  @Override
  public List<RoleDto> searchByCondition2(RoleSearchForm criteria)
          throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);

    long start = System.currentTimeMillis(); //???? ?? ??

    int totalCount = 0;

    long end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("??? ?? ?? : " + (end - start) / 1000.0 + "?");

    start = System.currentTimeMillis(); //???? ?? ??

    List<RoleDto> roleDtos = roleDao.searchByCondition2(searchMap);
    if (totalCount == 0) totalCount = roleDtos.size();

    end = System.currentTimeMillis(); //????? ??? ?? ??
    LOGGER.info("?? ?? ?? : " + (end - start) / 1000.0 + "?");

    return roleDtos;
  }
}
