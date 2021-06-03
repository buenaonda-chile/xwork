/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.GroupDao;
import com.globaldenso.dicas.business.dto.DeptTreeDto;
import com.globaldenso.dicas.business.dto.GroupDto;
import com.globaldenso.dicas.business.dto.MenuDto;
import com.globaldenso.dicas.business.service.GroupService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.GroupSearchForm;
import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.string.EgovStringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
@Service("groupService")
public class GroupServiceImpl implements GroupService {

  private static final Logger LOGGER = LoggerFactory.getLogger(GroupServiceImpl.class);

  @Autowired
  private GroupDao groupDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public GroupServiceImpl() {
    // no process
  }

  public void setGroupDao(GroupDao groupDao) {
    this.groupDao = groupDao;
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param groupDto GroupDto
   */
  @Override
  public GroupDto searchByKey(GroupDto groupDto) throws ApplicationException {
    return groupDao.searchByKey(groupDto);
  }

  @Override
  public List<GroupDto> searchByCondition(GroupSearchForm criteria)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);

    long start = System.currentTimeMillis(); //시작하는 시점 계산

    List<GroupDto> groupDtos = groupDao.searchByCondition(searchMap);

    long end = System.currentTimeMillis(); // 프로그램이 끝나는 시점 계산
    LOGGER.info("목록 실행 시간 : " + (end - start) / 1000.0 + "초");

//    List<GroupDto> rootGroupItems = groupDtos.stream()
//        .filter(item -> (item.getUpperDeptCd() == null
//            && (EgovStringUtil.isEmpty(criteria.getGroupId()) ? true : criteria.getGroupId().equals(item.getGroupId()))
//            && (EgovStringUtil.isEmpty(criteria.getUseYn()) ? true : criteria.getUseYn().equals(item.getUseYn()))))
//        .collect(Collectors.toList());
//
//    for (GroupDto item : rootGroupItems) {
//      item.setSubGroupItems(generatedGroupItems(groupDtos, item, criteria.getUseYn()));
//    }

    return groupDtos;
  }

  @Override
  public List<DeptTreeDto> searchGroupTreeByCondition(GroupSearchForm criteria)
      throws ApplicationException {

    List<GroupDto> groupDtos = searchByCondition(criteria);

    List<DeptTreeDto> treeList = new ArrayList<>();
    for (GroupDto item: groupDtos) {
      DeptTreeDto newItem = new DeptTreeDto() {{
        setDeptCd(item.getDeptCd());
        setDeptNm(item.getDeptNm());
        setUpperDeptCd(item.getUpperDeptCd());
        setGroupId(item.getGroupId());
        setUseYn(item.getUseYn());
      }};
      treeList.add(newItem);
    }

    List<DeptTreeDto> rootGroupItems = treeList.stream()
        .filter(item -> (item.getUpperDeptCd() == null
            && (EgovStringUtil.isEmpty(criteria.getGroupId()) ? true : criteria.getGroupId().equals(item.getGroupId()))
            && (EgovStringUtil.isEmpty(criteria.getUseYn()) ? true : criteria.getUseYn().equals(item.getUseYn()))))
        .collect(Collectors.toList());

    for (DeptTreeDto item : rootGroupItems) {
      item.setItems(generatedGroupItems(treeList, item, criteria.getUseYn()));
    }

    return rootGroupItems;
  }


  @Override
  public void create(GroupDto groupDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    groupDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
    groupDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    groupDao.create(groupDto);
  }

  @Override
  public void update(GroupDto groupDto) throws ApplicationException {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    groupDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

    groupDao.update(groupDto);
  }

  @Override
  public void delete(GroupDto groupDto) throws ApplicationException {

    groupDto = searchByKey(groupDto);
    groupDto.setUseYn("N");
    update(groupDto);

    //groupDao.delete(groupDto);
  }

  private List<DeptTreeDto> generatedGroupItems(List<DeptTreeDto> groupItems, DeptTreeDto groupItem, String useYn) {

    List<DeptTreeDto> groupList = new ArrayList<>();

    if (groupItems.size() > 0) {
      if (groupItem != null) {
        List<DeptTreeDto> subGroupItems = null;

        if (!EgovStringUtil.isEmpty(useYn)) {
          subGroupItems = groupItems.stream()
              .filter(item -> groupItem.getDeptCd().equals(item.getUpperDeptCd())
                  && useYn.equals(item.getUseYn()))
              .collect(Collectors.toList());
        } else {
          subGroupItems = groupItems.stream()
              .filter(item -> groupItem.getDeptCd().equals(item.getUpperDeptCd()))
              .collect(Collectors.toList());
        }

        for(DeptTreeDto item: subGroupItems) {
          item.setItems(generatedGroupItems(groupItems, item, useYn));
        }

        groupList.addAll(subGroupItems);
      }
    }

    return groupList;
  }
}
