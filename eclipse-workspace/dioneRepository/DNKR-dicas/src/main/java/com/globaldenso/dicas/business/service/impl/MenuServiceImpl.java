package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.MenuDao;
import com.globaldenso.dicas.business.domain.MenuDomain;
import com.globaldenso.dicas.business.dto.MenuDto;
import com.globaldenso.dicas.business.service.MenuService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import com.globaldenso.dicas.presentation.form.MenuSearchForm;
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

@Service("menuService")
public class MenuServiceImpl implements MenuService {

  private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);

  /**
   * [KR] 메뉴 관리 Dao <br>
   */
  @Autowired
  private MenuDao menuDao;

  /**
   * [EN] Default constructor.<br> [JP] デフォルトコンストラクタ。<br>
   */
  public MenuServiceImpl() {
    // no process
  }

  /**
   * [EN] Set DAO of menu information.<br>
   *
   * @param menuDao MenuDao
   */
  public void setMenuDao(MenuDao menuDao) {
    this.menuDao = menuDao;
  }

  /**
   * {@inheritDoc}
   *
   * @see com.globaldenso.dicas.business.service.MenuService#searchByKey(MenuDto)
   */
  @Override
  public MenuDto searchByKey(MenuDto menuDto) throws ApplicationException {
    return menuDao.searchByKey(menuDto);
  }

  /**
   * {@inheritDoc}
   *
   * @see com.globaldenso.dicas.business.service.MenuService#searchByCondition(MenuSearchForm, Pageable)
   */
  @Override
  public Page<MenuDto> searchByCondition(MenuSearchForm criteria, Pageable pageable)
      throws ApplicationException {

    Map<String, Object> searchMap = new HashMap<>();
    searchMap.put(ParamAttribute.CRITERIA, criteria);
    searchMap.put(ParamAttribute.PAGEABLE, pageable);

    long totalCount = menuDao.searchCount(searchMap);

    List<MenuDto> menuDtos = menuDao.searchByCondition(searchMap);

    return new PageImpl<>(menuDtos, pageable, totalCount);
  }

  @Override
  public List<MenuDto> searchByLoginUser(Long userId) throws ApplicationException {

    MenuSearchForm criteria = new MenuSearchForm();
    criteria.setUserId(userId);

    List<MenuDto> menuDtos = searchByCondition(criteria, null).getContent();

    List<MenuDto> rootMenuItems = menuDtos.stream()
        .filter(item -> item.getUpperMenuId() == null
            && "Y".equals(item.getPubYn()))
        .collect(Collectors.toList());

    for(MenuDto item : rootMenuItems) {
      item.setSubMenuItems(generateMenuItems(menuDtos, item, "Y"));
    }

    return rootMenuItems;
  }

  /**
   * {@inheritDoc}
   *
   * @see com.globaldenso.dicas.business.service.MenuService#create(MenuDto)
   */
  @Override
  public void create(MenuDto menuDto) throws ApplicationException {

    menuDto.setMenuCd(generateMenuCd(menuDto));
    menuDao.create(menuDto);
  }

  /**
   * {@inheritDoc}
   *
   * @see com.globaldenso.dicas.business.service.MenuService#update(MenuDto)
   */
  @Override
  public void update(MenuDto menuDto) throws ApplicationException {

    menuDto.setMenuCd(generateMenuCd(menuDto));
    menuDao.update(menuDto);

    MenuSearchForm criteria = new MenuSearchForm();
    criteria.set_id(menuDto.get_id());

    List<MenuDto> menuDtos = searchByCondition(criteria, null).getContent();

    for(MenuDto item : menuDtos) {
      if (!item.get_id().equals(menuDto.get_id())) {
        item.setUpdtrId(menuDto.getUpdtrId());
        item.setUpdtDt(null);

        item.setMenuCd(generateMenuCd(item));

        update(item);
      }
    }
  }

  /**
   * {@inheritDoc}
   *
   * @see com.globaldenso.dicas.business.service.MenuService#delete(MenuDto)
   */
  @Override
  public void delete(MenuDto menuDto) throws ApplicationException {

    int count = menuDao.searchChildMenuCountByCondition(menuDto.get_id());

    if (count > 0)
      throw new ApplicationException("하위 메뉴가 존재하여 삭제할 수 없습니다.");

    menuDao.delete(menuDto);
  }

  @Override
  public List<MenuDto> searchMenuCategoryByCondition() throws ApplicationException {
    return menuDao.searchMenuCategoryByCondition();
  }

  private List<MenuDto> generateMenuItems(List<MenuDto> menuItems, MenuDto menuItem, String pubYn) {

    List<MenuDto> menuList = new ArrayList<>();

    if (menuItems.size() > 0) {
      if (menuItem != null) {
        List<MenuDto> subMenuItems = null;

        if (!EgovStringUtil.isEmpty(pubYn)) {
          subMenuItems = menuItems.stream()
                  .filter(item -> menuItem.get_id().equals(item.getUpperMenuId())
                      && pubYn.equals(item.getPubYn()))
                  .collect(Collectors.toList());
        } else {
          subMenuItems = menuItems.stream()
              .filter(item -> menuItem.get_id().equals(item.getUpperMenuId()))
              .collect(Collectors.toList());
        }

        for(MenuDto item: subMenuItems) {
          item.setSubMenuItems(generateMenuItems(menuItems, item, pubYn));
        }
        menuList.addAll(subMenuItems);
      }
    }

    return menuList;
  }

  private String generateMenuCd(MenuDto menuDto) throws ApplicationException {

    // 메뉴CD 생성
    if (menuDto.getMenuOrdr() < 1)
      menuDto.setMenuOrdr(1);

    String menuOrdr = String.valueOf(menuDto.getMenuOrdr());
    String menuCd = null;

    if (menuDto.getUpperMenuId() == null) {
      menuCd = EgovStringUtil.rPad(menuOrdr, 10, '0');
    } else {
      MenuDto upperMenuDto = new MenuDto();
      upperMenuDto.set_id(menuDto.getUpperMenuId());
      upperMenuDto = searchByKey(upperMenuDto);
      if (upperMenuDto.getMenuLvl() == 1) {
        menuCd = upperMenuDto.getMenuCd().substring(0, 1);
        menuCd = menuCd + EgovStringUtil.lPad(menuOrdr, 2, '0')
            + EgovStringUtil.rPad("0", 7, '0');
      } else if (upperMenuDto.getMenuLvl() == 2) {
        menuCd = upperMenuDto.getMenuCd().substring(0, 3);
        menuCd = menuCd + EgovStringUtil.lPad(menuOrdr, 2, '0')
            + EgovStringUtil.rPad("0", 5, '0');
      } else
        throw new ApplicationException("하위 메뉴를 생성할 수 없습니다.");
    }

    return menuCd;
  }
}
