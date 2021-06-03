package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.MenuDto;
import com.globaldenso.dicas.presentation.form.MenuSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] 메뉴관리 서비스 인터페이스.
 *
 * @author $Author$
 * @version $Revision$
 */
public interface MenuService {

  MenuDto searchByKey(MenuDto menuDto) throws ApplicationException;
  Page<MenuDto> searchByCondition(MenuSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<MenuDto> searchByLoginUser(Long userId) throws ApplicationException;

  void create(MenuDto menuDto) throws ApplicationException;
  void update(MenuDto menuDto) throws ApplicationException;
  void delete(MenuDto menuDto) throws ApplicationException;

  List<MenuDto> searchMenuCategoryByCondition() throws ApplicationException;
}
