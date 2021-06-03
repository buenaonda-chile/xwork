/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.UserDao;
import com.globaldenso.dicas.business.dao.UserRoleDao;
import com.globaldenso.dicas.business.domain.UserDomain;
import com.globaldenso.dicas.business.dto.UserDto;
import com.globaldenso.dicas.business.dto.UserRoleDto;
import com.globaldenso.dicas.business.service.UserService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.UserSearchForm;
import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.string.EgovStringUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * [KR] 사용자 서비스
 *
 * @author TWOGOMS
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  private UserDao userDao;

  @Autowired
  private UserRoleDao userRoleDao;

  @Resource(name = "messageDigestPasswordEncoder")
  private MessageDigestPasswordEncoder messageDigestPasswordEncoder;

  @Resource(name = "propertiesService")
  protected EgovPropertyService propertiesService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public UserServiceImpl() {
    // no process
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param userDto UserDto
   */
  @Override
  public UserDto searchByKey(UserDto userDto) throws ApplicationException {
    return userDao.searchByKey(userDto);
  }

  @Override
  public Page<UserDto> searchByCondition(UserSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long start = System.currentTimeMillis(); //시작하는 시점 계산

    int totalCount = 0;
    if (pageable != null)
      totalCount = userDao.searchCount(searchMap);

    long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
    LOGGER.info("카운트 실행 시간 : " + (end - start) / 1000.0 + "초");

    start = System.currentTimeMillis(); //시작하는 시점 계산

    List<UserDto> userDtos = userDao.searchByCondition(searchMap);
    if (totalCount == 0) totalCount = userDtos.size();

    end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
    LOGGER.info("목록 실행 시간 : " + (end - start) / 1000.0 + "초");

    return new PageImpl<>(userDtos, pageable, totalCount);
  }

  @Override
  public List<UserDto> searchGrpCdByCondition(UserSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public List<UserDto> searchUserByCondition(UserSearchForm criteria) throws ApplicationException {
    return searchByCondition(criteria, null).getContent();
  }

  @Override
  public void create(UserDto userDto) throws ApplicationException {

    String initPassword = propertiesService.getString("initPassword");
    userDto.setAcctPw(
        messageDigestPasswordEncoder.encodePassword(initPassword, userDto.getAcctId())
    );

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    userDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    userDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    userDao.create(userDto);

    if (!EgovStringUtil.isEmpty(userDto.getRoleCd())) {
      UserRoleDto userRoleDto = new UserRoleDto();
      userRoleDto.setUserId(userDto.get_id());
      userRoleDto.setRoleCd(userDto.getRoleCd());
      userRoleDto.setRgstrId(userDto.getRgstrId());
      userRoleDto.setUpdtrId(userDto.getUpdtrId());

      userRoleDao.create(userRoleDto);
    }
  }

  @Override
  public void update(UserDto userDto) throws ApplicationException {

    UserDto oldUserDto = searchByKey(userDto);

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    userDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    userDao.update(userDto);

    if (EgovStringUtil.isEmpty(userDto.getRoleCd())) {
      if (EgovStringUtil.isEmpty(oldUserDto.getRoleCd())) {
        UserRoleDto userRoleDto = new UserRoleDto() {{
          setUserId(oldUserDto.get_id());
          setRoleCd(oldUserDto.getRoleCd());
        }};
        userRoleDao.delete(userRoleDto);
      }
    } else {
      if (!userDto.getRoleCd()
          .equals(EgovStringUtil.null2string(oldUserDto.getRoleCd(),""))) {
        UserRoleDto userRoleDto = new UserRoleDto() {{
          setUserId(oldUserDto.get_id());
          setRoleCd(EgovStringUtil.null2string(oldUserDto.getRoleCd(),""));
        }};
        userRoleDao.delete(userRoleDto);

        userRoleDto.setRoleCd(userDto.getRoleCd());
        userRoleDto.setRgstrId(userDto.getUpdtrId());
        userRoleDto.setUpdtrId(userDto.getUpdtrId());

        userRoleDao.create(userRoleDto);
      }
    }
  }

  @Override
  public void transactInitPassword(UserDto userDto) throws ApplicationException {

    String initPassword = propertiesService.getString("initPassword");
    updatePassword(userDto, initPassword);
  }

  @Override
  public void transactInitPasswordAll() throws ApplicationException {

    UserSearchForm criteria = new UserSearchForm() {{
      setUseYn("Y");
    }};

    List<UserDto> userDtos = searchByCondition(criteria, null).getContent();
    for(UserDto item: userDtos) {
      transactInitPassword(item);
    }
  }

  @Override
  public void updatePassword(UserDto userDto, String password) throws ApplicationException {

    userDto.setAcctPw(
        messageDigestPasswordEncoder.encodePassword(password, userDto.getAcctId())
    );

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    userDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));
    userDto.setUpdtDt(null);

    userDao.updatePassword(userDto);

  }

  @Override
  public void delete(UserDto userDto) throws ApplicationException {

    UserDto oldUserDto = searchByKey(userDto);
    oldUserDto.setUseYn("N");
    update(oldUserDto);

  }
}
