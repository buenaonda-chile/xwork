package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.MenuDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface MenuDao {

    /**
     * [KR] 새로운 메뉴를 생성한다.<br>     
     * 
     * @param domain 'MenuDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(MenuDomain domain, List<String> langList) throws ApplicationException;

    /**
     * [KR] 새로운 메뉴를 생성한다.<br>     
     * 
     * @param domain 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createMenu(MenuDomain domain) throws ApplicationException;

    /**
     * [KR] 새로운 메뉴의 명칭을 생성한다.<br>     
     * 
     * @param domain 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void createName(MenuDomain domain) throws ApplicationException;

    /**
     * [KR] 메뉴 기본정보를 수정한다.<br>
     * 
     * @param domain 'MenuDomain' class
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateCode(MenuDomain domain) throws ApplicationException;

    /**
     * [KR] 메뉴의 위치변경 시 삽입될 위치의 같은 Depth메뉴의 MCD_SORT를 수정한다.<br>
     * 
     * @param domain 'MenuDomain' class
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateSortUp(MenuDomain domain) throws ApplicationException;

    /**
     * [KR] 메뉴의 위치변경 시 변경전 위치의 같은 Depth메뉴의 MCD_SORT를 수정한다.<br>
     * 
     * @param domain 'MenuDomain' class
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateSortDown(MenuDomain domain) throws ApplicationException;

    /**
     * [KR] 메뉴 DEPTH를 수정한다.<br>
     * 
     * @param domain 'MenuDomain' class
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateDepth(MenuDomain domain) throws ApplicationException;
    
    /**
     * [KR] 메뉴 명칭을 수정한다.<br>
     * 
     * @param domain 'MenuDomain' class
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateName(MenuDomain domain) throws ApplicationException;

    /**
     * [KR] 메뉴 명칭 정보를 삭제한다.<br>     
     * 
     * @param domain 'MenuDomain' class
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteName(MenuDomain domain) throws ApplicationException;

    /**
     * [KR] 메뉴 코드정보를 삭제한다.<br>     
     * 
     * @param domain 'MenuDomain' class
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteCode(MenuDomain domain) throws ApplicationException;

    /**
     * [EN] Search menu information from DB table by the primary key, and return the search results.<br>     
     * 
     * @param domain 'MenuDomain' class
     * @return 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public MenuDomain searchByKey(MenuDomain domain) throws ApplicationException;

    /**
     * [EN] Search menu information from DB table by any conditions, and return the search results in a list.<br>     
     * 
     * @param domain 'MenuDomain' class
     * @return List of 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<MenuDomain> searchByCondition(MenuDomain domain) throws ApplicationException;

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 메뉴코드 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] Search Menu code information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] <br>
     * 
     * @param domain 'MenuDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(MenuDomain domain) throws ApplicationException;

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 메뉴코드 정보를 탐색하고 결과의 데이터 갯수를 반환한다.<br>
     * [EN] Search Menu code information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] <br>
     * 
     * @param domain 'MenuDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchMcdCount(MenuDomain domain) throws ApplicationException;

    /**
     * [KO] 메뉴코드의 max(MCD_SORT)를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @return McdSort of search result
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchMaxMcdSort(MenuDomain domain) throws ApplicationException;
    
    /**
     * [KO] 최상위코드의 max(MCD_SORT)를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @return McdSort of search result
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchSupetMenuMcdSort() throws ApplicationException;
    
    /**
     * [EN] Search menu information from DB table, and return the search results in a list.<br>     
     * 
     * @param domain 'MenuDomain' class
     * @return List of 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<MenuDomain> searchSuperMenuList(MenuDomain domain) throws ApplicationException;

    /**
     * [EN] Search menu information from DB table, and return the search results in a list.<br>     
     * 
     * @return List of 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<MenuDomain> searchAuthMenuList() throws ApplicationException;

    /**
     * [EN] Search menu information from DB table, and return the search results in a list.<br>     
     * 
     * @param domain 'MenuDomain' class
     * @return List of 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<MenuDomain> searchAuthMenuList(MenuDomain domain) throws ApplicationException;
}
