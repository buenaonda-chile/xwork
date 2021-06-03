package com.globaldenso.dnkr.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.domain.MenuDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 메뉴관리 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAD010Menu")
@ViewId(value = "WAD010")
public class WAD010MenuController {
    /**
     * [KR] 메뉴서비스 <br>     
     */
    @Autowired
    private MenuService menuService;
    
    /** */
    private final String MENU_CODE = "5";
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAD010MenuController() {
        // no process
    }
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    @ErrorBack(viewName = ".tiles.page.WAD010")
    public ModelAndView init(HttpServletRequest request)  throws Exception {
        MenuDomain domain = new MenuDomain();

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");

        domain.setLangCmc(DensoContext.get().getLocale().getLanguage());
        ModelAndView mv = new ModelAndView();
        //System.out.println("WAD010Menu/init.do");
        
        try {
            List<MenuDomain> menuList = new ArrayList<MenuDomain>();
            List<MenuDomain> subMenuList = new ArrayList<MenuDomain>(); 
            List<MenuDomain> superMenuList = menuService.searchSuperMenuList(domain);
            int countSuper = 0;

            if(!superMenuList.isEmpty()){
                System.out.println("if(!superMenuList.isEmpty()){");
                for(MenuDomain superMenuDomain: superMenuList){ //메뉴리스트에 슈퍼도메인 추가
                    MenuDomain tempMenuDomain = new MenuDomain();   //sublist를 불러오기위한 임시도메인
                    tempMenuDomain.setMcdRef(superMenuDomain.getMcdCode());
                    tempMenuDomain.setLangCmc(DensoContext.get().getLocale().getLanguage());

                    subMenuList = menuService.searchByCondition(tempMenuDomain);
                    if(! subMenuList.isEmpty()){
                        //sub메뉴 도메인 추가
                        int count = 0;
                        for(MenuDomain subDomain:subMenuList){//슈퍼도메인에 서브도메인 추가
                            MenuDomain tempSubMenuDomain = new MenuDomain();    //라스트서브 도메인리스트를 불러오기위한 임시도메인
                            List<MenuDomain> tempSubMenuList = new ArrayList<MenuDomain>();

                            if(subDomain.getMcdDepth() != 1){//슈퍼도메인이 아니면
                                tempSubMenuDomain.setMcdRef(subDomain.getMcdCode());
                                tempSubMenuDomain.setLangCmc(DensoContext.get().getLocale().getLanguage());
                                tempSubMenuList = menuService.searchByCondition(tempSubMenuDomain); //라스트서브 도메인리스트

                                //last sub메뉴 도메인 추가
                                for(MenuDomain lastSubDomain:tempSubMenuList) {//서브도메인에 라스트서브도메인 추가
                                    subDomain.setSubList(lastSubDomain);
                                }
                            }
                            //슈퍼도메인이 아니면 슈퍼도메인에 서브도메인 추가
                            if(subDomain.getMcdDepth() != 1){
                                //메인메뉴에 sub도메인 추가
                                superMenuDomain.setSubList(subDomain);
                            }
                            count++;
                        }
                    }
                    if(superMenuDomain.getMcdDepth() == 1){
                        menuList.add(superMenuDomain);
                    }
                    countSuper++;
                }
            }
            mv.addObject("menuList", menuList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //System.out.println("권한체크" + UxisCmmUtil.getSessionAuthData(request, menu));
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAD010Menu.jsp");
        mv.setViewName(".tiles.page.WAD010");
        return mv;
        
    }
}
