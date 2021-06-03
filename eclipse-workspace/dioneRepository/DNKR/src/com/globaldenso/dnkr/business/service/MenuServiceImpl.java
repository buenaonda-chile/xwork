package com.globaldenso.dnkr.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.MenuDomain;
import com.globaldenso.dnkr.integration.dao.MenuDao;

/**
* [KR] 메뉴관리 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    /**
     * [KR] 메뉴 관리 Dao <br>
     */
    @Autowired
    private MenuDao menuDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
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
     * @see com.globaldenso.dnkr.business.service.MenuService#create(CodeDomain)
     */
    public void create(MenuDomain domain, List<String> langList) throws ApplicationException {
        menuDao.create(domain, langList);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.MenuService#update(MenuDomain)
     */
    public int update(MenuDomain domain) throws ApplicationException {
        int upResult = 0;
        upResult += updateCode(domain);
        upResult += updateName(domain);
        return upResult;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.MenuService#updateCode(MenuDomain)
     */
    public int updateCode(MenuDomain domain) throws ApplicationException {
        return menuDao.updateCode(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.MenuService#updateMenu(MenuDomain)
     */
    public int updateName(MenuDomain domain) throws ApplicationException {
        return menuDao.updateName(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.MenuService#updateSort(MenuDomain)
     */
    public int updateSortUp(MenuDomain domain) throws ApplicationException {
        return menuDao.updateSortUp(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.MenuService#updateSort(MenuDomain)
     */
    public int updateSortDown(MenuDomain domain) throws ApplicationException {
        return menuDao.updateSortDown(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.MenuService#updateDepth(MenuDomain)
     */
    public int updateDepth(MenuDomain domain) throws ApplicationException {
        return menuDao.updateDepth(domain);
    }

    @Override
    public int delete(List<MenuDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (MenuDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.MenuService#searchByKey(MenuDomain)
     */
    public MenuDomain searchByKey(MenuDomain domain)
        throws ApplicationException {
        return menuDao.searchByKey(domain);
    }

    @Override
    public List<MenuDomain> searchByCondition(MenuDomain domain)
        throws ApplicationException {
        return menuDao.searchByCondition(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.MenuService#searchCount(MenuDomain)
     */
    public int searchCount(MenuDomain domain) throws ApplicationException {
        return menuDao.searchCount(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.MenuService#searchMcdCount(MenuDomain)
     */
    public int searchMcdCount(MenuDomain domain) throws ApplicationException {
        return menuDao.searchMcdCount(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.MenuService#searchMaxMcdSort(MenuDomain domain)
     */
    public int searchMaxMcdSort(MenuDomain domain) throws ApplicationException {
        return menuDao.searchMaxMcdSort(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.MenuService#searchSupetMenuMcdSort()
     */
    public int searchSupetMenuMcdSort() throws ApplicationException {
        return menuDao.searchSupetMenuMcdSort();
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.MenuService#searchByCondition(CodeDomain)
     */
    public List<MenuDomain> searchSuperMenuList(MenuDomain domain) throws ApplicationException {
        return menuDao.searchSuperMenuList(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.MenuService#searchAuthMenuList()
     */
    public List<MenuDomain> searchAuthMenuList() throws ApplicationException {
        return menuDao.searchAuthMenuList();
    }

    /**
    * {@inheritDoc}
    * 
    * @see com.globaldenso.dnkr.business.service.MenuService#searchAuthMenuList()
    */
    public List<MenuDomain> searchAuthMenuList(MenuDomain domain) throws ApplicationException {
        return menuDao.searchAuthMenuList(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.MenuService#delete(MenuDomain)
     */
    public int delete(MenuDomain domain) throws ApplicationException {
        int delResult = 0;
        //메뉴코드명 삭제
        delResult += deleteName(domain);
        
        //메뉴코드 삭제
        delResult += deleteCode(domain);
        
//  menuDao.deleteName(domain);
//  menuDao.deleteCode(domain);
        return delResult;
    }
    
    /**
    * {@inheritDoc}
    * 
    * @see com.globaldenso.dnkr.business.service.CodeService#deleteCmc(CodeDomain)
    */
    public int deleteCode(MenuDomain domain) throws ApplicationException {
        return menuDao.deleteCode(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#deleteCnm(CodeDomain)
     */
    public int deleteName(MenuDomain domain) throws ApplicationException {
        return menuDao.deleteName(domain);
    }
    
    public List<MenuDomain> getMenuList(Map<String, Integer> map) throws ApplicationException{
    	MenuDomain domain = new MenuDomain();

        int mcdMobile = 0;
        
        //모바일 여부 확인 main.do 에서 모바일일 경우 1로 넘어온다
        if(map.get("mcdMobile") != null){
        	mcdMobile = map.get("mcdMobile");
        }

        if(mcdMobile > 0){
        	domain.setMcdMobile("Y");
        }
        
        domain.setLangCmc(DensoContext.get().getLocale().getLanguage());
        domain.setMcdUse("Y");  //사용하는 메뉴만 가져오기
        //System.out.println("WAA000Main/getMenuList");
        List<MenuDomain> menuList = new ArrayList<MenuDomain>();
        List<MenuDomain> subMenuList = new ArrayList<MenuDomain>(); 
        List<MenuDomain> superMenuList = menuDao.searchSuperMenuList(domain);
        int countSuper = 0;
        
        try {

            if(!superMenuList.isEmpty()){
                for(MenuDomain superMenuDomain: superMenuList){ //메뉴리스트에 슈퍼도메인 추가
                    MenuDomain tempMenuDomain = new MenuDomain();   //sublist를 불러오기위한 임시도메인
                    tempMenuDomain.setMcdRef(superMenuDomain.getMcdCode());
                    tempMenuDomain.setLangCmc(DensoContext.get().getLocale().getLanguage());
                    tempMenuDomain.setMcdUse("Y");  //사용하는 메뉴만 가져오기
                    if(mcdMobile > 0){
                    	tempMenuDomain.setMcdMobile("Y");  //모바일에서 사용하는 메뉴만 가져오기
                    }
                    subMenuList = menuDao.searchByCondition(tempMenuDomain);
                    if(! subMenuList.isEmpty()){
                        //sub메뉴 도메인 추가
                        int count = 0;
                        for(MenuDomain subDomain:subMenuList){//슈퍼도메인에 서브도메인 추가
                            MenuDomain tempSubMenuDomain = new MenuDomain();    //라스트서브 도메인리스트를 불러오기위한 임시도메인
                            List<MenuDomain> tempSubMenuList = new ArrayList<MenuDomain>();

                            if(subDomain.getMcdDepth() != 1){//슈퍼도메인이 아니면
                                tempSubMenuDomain.setMcdRef(subDomain.getMcdCode());
                                tempSubMenuDomain.setLangCmc(DensoContext.get().getLocale().getLanguage());
                                tempSubMenuDomain.setMcdUse("Y");   //사용하는 메뉴만 가져오기
                                if(mcdMobile > 0){		//모바일의 경우
                                	tempSubMenuDomain.setMcdMobile("Y");
                                }
                                tempSubMenuList = menuDao.searchByCondition(tempSubMenuDomain); //라스트서브 도메인리스트

                                //last sub메뉴 도메인 추가
                                for(MenuDomain lastSubDomain:tempSubMenuList) {//서브도메인에 라스트서브도메인 추가
                                    if(map.containsKey(lastSubDomain.getMcdCode())){
                                        subDomain.setSubList(lastSubDomain);
                                    }
                                }
                            }

                            //슈퍼도메인이 아니면 슈퍼도메인에 서브도메인 추가
                            if(subDomain.getMcdDepth() != 1 && map.containsKey(subDomain.getMcdCode())){
                                //메인메뉴에 sub도메인 추가
                                superMenuDomain.setSubList(subDomain);
                            }
                            count++;
                        }
                    }

                    if(superMenuDomain.getMcdDepth() == 1 && map.containsKey(superMenuDomain.getMcdCode())){
                        menuList.add(superMenuDomain);
                    }
                    countSuper++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
    }
}
