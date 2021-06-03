/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.MenuRoleDao;
import com.globaldenso.dicas.business.dto.MenuRoleDto;
import com.globaldenso.dicas.business.service.MenuRoleService;
import com.globaldenso.dicas.business.service.MenuService;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.MenuRoleSearchForm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * [KR] ??? ?????.
 *
 * @author TWOGOMS
 * @version 1.0
 */
@Service("menuroleService")
public class MenuRoleServiceImpl implements MenuRoleService {

  private static final Logger LOGGER = LoggerFactory.getLogger(MenuRoleServiceImpl.class);

  @Autowired
  private MenuRoleDao menuroleDao;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public MenuRoleServiceImpl() {
    // no process
  }

  @Override
  public List<MenuRoleDto> searchByCondition(MenuRoleSearchForm criteria)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);

    List<MenuRoleDto> menuRoleDtos = menuroleDao.searchByCondition(searchMap);

    return menuRoleDtos;
  }

  @Override
  public void create(MenuRoleDto menuroleDto) throws ApplicationException {

    menuroleDao.create(menuroleDto);

    // 상위/하위 메뉴 사용 업데이트
    MenuRoleSearchForm criteria = new MenuRoleSearchForm();
    criteria.setRoleCd(menuroleDto.getRoleCd());

    List<MenuRoleDto> menuroleDtos = searchByCondition(criteria);

    // 하위메뉴 사용 업데이트
    List<MenuRoleDto> relatedMenuRoleDtos = getRelatedChildMenuRoleList(menuroleDtos, menuroleDto);

    // 상위메뉴 사용 업데이트
    relatedMenuRoleDtos.addAll(getRelatedUpperMenuRoleList(menuroleDtos, menuroleDto));

    for (MenuRoleDto item : relatedMenuRoleDtos) {
      if (!item.isUse()) {
        item.setRgstrId(menuroleDto.getRgstrId());
        item.setUpdtrId(menuroleDto.getUpdtrId());
        item.setRgstDt(null);
        item.setUpdtDt(null);
        item.setRoleCd(menuroleDto.getRoleCd());

        menuroleDao.create(item);
      }
    }
  }

  @Override
  public void delete(MenuRoleDto menuroleDto) throws ApplicationException {

    menuroleDao.delete(menuroleDto);

    // 상위/하위 메뉴 미사용 업데이트
    MenuRoleSearchForm criteria = new MenuRoleSearchForm();
    criteria.setRoleCd(menuroleDto.getRoleCd());

    List<MenuRoleDto> menuroleDtos = searchByCondition(criteria);

    // 하위메뉴 미사용 업데이트
    List<MenuRoleDto> relatedMenuRoleDtos = getRelatedChildMenuRoleList(menuroleDtos, menuroleDto);
    if (relatedMenuRoleDtos.size() > 0) {
      for(MenuRoleDto item : relatedMenuRoleDtos) {
        if (item.isUse()) {
          item.setRoleCd(menuroleDto.getRoleCd());
          menuroleDao.delete(item);
        }
      }
    }

    // 상위메뉴 미사용 업데이트
    relatedMenuRoleDtos = getRelatedUpperMenuRoleList(menuroleDtos, menuroleDto);
    for (int i = relatedMenuRoleDtos.size(); i > 0; i--) {
      MenuRoleDto item = relatedMenuRoleDtos.get(i - 1);

      criteria.setUpperMenuId(item.getMenuId());
      menuroleDtos = searchByCondition(criteria);

      boolean isChecked = false;
      for (MenuRoleDto _item : menuroleDtos) {
        if (_item.isUse()) {
          isChecked = true;
          break;
        }
      }

      if (!isChecked) {
        item.setRoleCd(menuroleDto.getRoleCd());
        menuroleDao.delete(item);
      }
    }
  }

  List<MenuRoleDto> getRelatedChildMenuRoleList(List<MenuRoleDto> menuroleItems , MenuRoleDto menuroleItem) {

    List<MenuRoleDto> menuroleList = new ArrayList<>();

    if (menuroleItems.size() > 0) {
      if (menuroleItems != null) {
        List<MenuRoleDto> subMenuRoleItems = null;

        subMenuRoleItems = menuroleItems.stream()
            .filter(item -> menuroleItem.getMenuId().equals(item.getUpperMenuId()))
            .collect(Collectors.toList());
        for (MenuRoleDto item : subMenuRoleItems) {
          menuroleList.addAll(getRelatedChildMenuRoleList(menuroleItems, item));
        }

        menuroleList.addAll(subMenuRoleItems);
      }
    }

    return menuroleList;
  }

  List<MenuRoleDto> getRelatedUpperMenuRoleList(List<MenuRoleDto> menuroleItems, MenuRoleDto menuroleItem) {

    List<MenuRoleDto> menuRoleDtos = new ArrayList<>();

    if (menuroleItems.size() > 0) {
      if (menuroleItem != null) {

        Optional<MenuRoleDto> upperMenuRoleDto = menuroleItems.stream()
            .filter(item -> item.getMenuId().equals(menuroleItem.getUpperMenuId()))
            .findFirst();

        if (upperMenuRoleDto.isPresent()) {
          menuRoleDtos.addAll(getRelatedUpperMenuRoleList(menuroleItems, upperMenuRoleDto.get()));
          menuRoleDtos.add(upperMenuRoleDto.get());
        }
      }
    }

    return menuRoleDtos;
  }
}
