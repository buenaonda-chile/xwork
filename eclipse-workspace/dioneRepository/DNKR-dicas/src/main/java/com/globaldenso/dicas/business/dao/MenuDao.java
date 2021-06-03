/*
 * Project : DICAS
 *
 * $Id$
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.domain.MenuDomain;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.MenuDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository("menuDao")
public interface MenuDao {

  /**
   * [KO] 기본키로 DB 테이블에서 권한 정보를 탐색하고 결과를 반환한다.<br>
   * [EN] Search auth information from DB table by the primary key, and return the search results.<br>
   * [JP] <br>
   * @param domain 'MenuDomain' class
   * @return 'MenuDto' class
   * @throws com.globaldenso.ai.core.exception.ApplicationException Application exception of 'Application Infrastructure'
   */
  MenuDto searchByKey(MenuDomain domain) throws ApplicationException;

  /**
   * [KO] 검색옵션값으로 DB 테이블에서 권한 정보를 탐색하고 결과를 리스트로 반환한다.<br>
   * [EN] Search auth information from DB table by any conditions, and return the search results in a list.<br>
   * [JP] <br>
   * @param  params 'Map' class
   * @return List of 'MenuDto' class
   * @throws com.globaldenso.ai.core.exception.ApplicationException Application exception of'Application Infrastructure'
   */
  List<MenuDto> searchByCondition(Map<String, Object> params) throws ApplicationException;

  /**
   * [KO] 검색옵션값으로 DB 테이블에서 메뉴코드 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
   * [EN] Search Menu code information from DB table by any conditions, and return the count of the search result.<br>
   * [JP] <br>
   * @param params 'Map' class
   * @return Count of search results
   * @throws ApplicationException Application exception of 'Application Infrastructure'
   */
   int searchCount(Map<String, Object> params) throws ApplicationException;

  /**
   * [KR] 메뉴를 생성한다.<br>
   * @param domain 'MenuDomain' class
   * @throws ApplicationException Application exception of 'Application Infrastructure'
   */
  void create(MenuDomain domain) throws ApplicationException;

  /**
   * [kr] 메뉴를 수정한다.<br>
   * @param domain 'MenuDomain' class
   * @throws ApplicationException application exception of 'application infrastructure'
   */
  void update(MenuDomain domain) throws ApplicationException;

  /**
   * [kr] 메뉴를 삭제한다.<br>
   * @param domain 'MenuDomain' class
   * @throws ApplicationException application exception of 'application infrastructure'
   */
  void delete(MenuDomain domain) throws ApplicationException;

  /**
   * [KO] 검색옵션값으로 DB 테이블에서 메뉴카테고리를 반화한다.<br>
   * [EN] Search menu category information from DB table by any conditions, and return the search results in a list.<br>
   * [JP] <br>
   * @return List of 'MenuDto' class
   * @throws com.globaldenso.ai.core.exception.ApplicationException Application exception of'Application Infrastructure'
   */
  List<MenuDto> searchMenuCategoryByCondition() throws ApplicationException;

  /**
   * [KO] 검색옵션값으로 DB 테이블에서 하위메뉴 갯수를 반화한다.<br>
   * [EN] Search child menu count from DB table by any conditions, and return count.<br>
   * [JP] <br>
   * @param menuId
   * @return
   * @throws ApplicationException
   */
  int searchChildMenuCountByCondition(Long menuId) throws ApplicationException;
}
