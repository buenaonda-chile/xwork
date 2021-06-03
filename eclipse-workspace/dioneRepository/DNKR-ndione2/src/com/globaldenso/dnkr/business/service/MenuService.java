package com.globaldenso.dnkr.business.service;

import java.util.List;
import java.util.Map;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.MenuDomain;

/**
 * [KR] 메뉴관리 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface MenuService {

    /**
     * [KR] 새로운 메뉴를 생성한다.<br>     
     * 
     * @param domain 'CodeDomain' class
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(MenuDomain domain, List<String> langList) throws ApplicationException;

    /**
     * [KR] 메뉴를 수정한다.<br>
     * 
     * @param domain 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     * @return int of update(MenuDomain)
     */
    public int update(MenuDomain domain) throws ApplicationException;

    /**
     * [KR] 메뉴코드 테이블을 수정한다.<br>
     * 
     * @param domain 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     * @return int of updateCode (MenuDomain)
     */
    public int updateCode(MenuDomain domain) throws ApplicationException;

    /**
     * [KR] 메뉴명 테이블을 수정한다.<br>
     * 
     * @param domain 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     * @return int of updateName(MenuDomain)
     */
    public int updateName(MenuDomain domain) throws ApplicationException;

    /**
     * [KR] 메뉴의 위치변경 시 삽입될 위치의 같은 Depth메뉴의 MCD_SORT를 수정한다.<br>
     * 
     * @param domain 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     * @return int of updateSortUp(MenuDomain)
     */
    public int updateSortUp(MenuDomain domain) throws ApplicationException;

    /**
     * [KR] 메뉴의 위치변경 시 변경전 위치의 같은 Depth메뉴의 MCD_SORT를 수정한다.<br>
     * 
     * @param domain 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     * @return updateSortDown(MenuDomain)
     */
    public int updateSortDown(MenuDomain domain) throws ApplicationException;

    /**
     * [KR] 메뉴의 MCD_DEPTH를 수정한다.<br>
     * 
     * @param domain 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     * @return updateDepth(MenuDomain)
     */
    public int updateDepth(MenuDomain domain) throws ApplicationException;

    /**
     * [KR] 메뉴를 삭제한다.<br>     
     * 
     * @param domainList List of 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     * @return delete(List<MenuDomain>)
     */
    public int delete(List<MenuDomain> domainList) throws ApplicationException;

    /**
     * [KR] 메뉴를 삭제한다.<br>     
     * 
     * @param domain 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     * @return delete(MenuDomain)
     */
    public int delete(MenuDomain domain) throws ApplicationException;

    /**
     * [KO] 기본키로 메뉴코드 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in common code information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'MenuDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteCode(MenuDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 메뉴코드명의 테이블의 레코드를 삭제한다.<br>
     * [EN] Delete a record in common code name information table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'MenuDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteName(MenuDomain domain) throws ApplicationException;

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
     * @return mcdSort of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchMaxMcdSort(MenuDomain domain) throws ApplicationException;
    
    /**
     * [KO] 최상위코드의 max(MCD_SORT)를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @return mcdSort of search results
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
    
    /**
     * [EN] Search menu information from DB table, and return the search results in a list.<br>     
     * 
     * @param domain 'MenuDomain' class
     * @return List of 'MenuDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
     public List<MenuDomain> getMenuList(Map<String, Integer> map) throws ApplicationException;
}
