package com.globaldenso.dnkr.presentation.controller.ajax;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.message.MessageManager;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.MenuDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAD011MenuCreateForm;
import com.globaldenso.dnkr.presentation.form.basic.WAD011MenuSearchForm;

/**
 * [KO] 메뉴코드의  ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing of menu code (WAD010).<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxMenu")
public class AjaxMenuController {

    /**
     * [KR] 메뉴관리 서비스 <br> 
     * [EN] Field of MenuService.<br>
     * [JP] <br>    
     */
    @Autowired
    private MenuService menuService;

    /**
     * [KR] 코드관리 서비스 <br> 
     * [EN] Field of CodeService.<br>
     * [JP] <br>    
     */
    @Autowired
    private CodeService codeService;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxMenuController() {
        // no process
    }

    /**
     * [KO] 메뉴코드 조회.<br>
     * [EN] Menu code select.<br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.POST, RequestMethod.GET})
    public void init(HttpServletRequest request, HttpServletResponse response) 
        throws Exception{

        /**
         * [KO] 메뉴코드 조회.<br>
         * [EN] Menu code select.<br>
         * [JP] <br>
         * 
         * @return ModelAndView
         * @throws Exception Exception
         */

        JSONObject jsonObj = new JSONObject();

        MenuDomain domain = new MenuDomain();

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        domain.setLangCmc(DensoContext.get().getLocale().getLanguage());
        ModelAndView mv = new ModelAndView();
        try {
            List<MenuDomain> menuList = new ArrayList<MenuDomain>();
            List<MenuDomain> subMenuList = new ArrayList<MenuDomain>(); 
            List<MenuDomain> tempMenuList = menuService.searchByCondition(domain);
            List<MenuDomain> superMenuList = menuService.searchSuperMenuList(domain);

            int countSuper = 0;

            if(!superMenuList.isEmpty()){
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

                            if(subDomain.getMcdSort() != 0){//슈퍼도메인이 아니면
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

                    //슈퍼도메인이면
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
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
    
    /**
     * [KO] 메뉴코드 조회.<br>
     * [EN] Menu code select.<br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/getGridVal", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView getGridVal(HttpServletRequest request, @ModelAttribute("WAD011MenuSearchForm") WAD011MenuSearchForm form, HttpServletResponse response) 
        throws Exception{

        /**
         * [KO] 메뉴코드 조회.<br>
         * [EN] Menu code select.<br>
         * [JP] <br>
         * 
         * @return ModelAndView
         * @throws Exception Exception
         */
    	
    	System.out.println("AjaxMenu/getGridVal.do");
    	ModelAndView model = new ModelAndView(new JsonView());
        
    	JSONObject jsonObj = new JSONObject();
        
        String result = DnkrConstans.RESULT_N;
        
        List<MenuDomain> menuList = null;
        try {
        	form.setLangCmc(DensoContext.get().getLocale().getLanguage());
        	menuList = menuService.searchByCondition(form);
        } catch (Exception e) {
        	//e.printStackTrace();
        	System.out.println("데이터가 없습니다.");
        }
        
        if(menuList != null){
            result = DnkrConstans.RESULT_Y;
        }
        
        jsonObj.put("result", result);
        jsonObj.put("list", menuList);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }

    /**
     * [KO] 주 처리과정.<br>
     * [KO] 메뉴코드 등록.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] I register and handle it.<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param menuDomain MenuDomain
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAD010")
    public void create(MenuDomain menuDomain, HttpServletResponse response) throws Exception {

        /**
         * <pre>
         * 1.[KO] 메뉴코드 등록 처리.
         *   [KO]   입력한 내용으로 메뉴코드를 등록한다.
         * 1.[EN] Menu code register process.
         *   [EN]   I register an Menu code with DB by input contents.
         *   [JP] 
         *   [JP] 
         * </pre>
         */

        //System.out.println("AjaxMenu/create.do");
        JSONObject jsonObj = new JSONObject();

        if(menuDomain.getMcdCode().equals("new_item")){
            //언어조회
            //System.out.println("언어조회");
            CodeDomain langDomain = new CodeDomain();
            langDomain.setCmcParentCode(DnkrConstans.CMC_SUPER_LANG_CODE);
            List<CodeDomain> domainList = codeService.searchByCondition(langDomain);
            List<String> langList = new ArrayList<String>();
            if(! domainList.isEmpty()) {
                for(CodeDomain domain: domainList) {
                    langList.add(domain.getCmcCode());
                }
            }
            
            int maxSortOfSuperCode = menuService.searchSupetMenuMcdSort();
            menuDomain.setMcdSort(maxSortOfSuperCode + 1);
            menuService.create(menuDomain, langList);
        } else {
            MessageManager.setError("DNKR-E1-0000", new Object[] {
                    MessageSources.getInstance().value("info.menu")});
        }
        jsonObj.put("result", "OK");
        response.getWriter().print(jsonObj);
        return;
    }
    
    /**
     * [KO] 주 처리과정.<br>
     * [KO] 메뉴코드 등록.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] I register and handle it.<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param menuDomain MenuDomain
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/gridCreate", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView gridCreate(@ModelAttribute("WAD011MenuCreateForm") WAD011MenuCreateForm form, HttpServletResponse response) throws Exception {

        /**
         * <pre>
         * 1.[KO] 메뉴코드 등록 처리.
         *   [KO]   입력한 내용으로 메뉴코드를 등록한다.
         * 1.[EN] Menu code register process.
         *   [EN]   I register an Menu code with DB by input contents.
         *   [JP] 
         *   [JP] 
         * </pre>
         */

        System.out.println("AjaxMenu/gridCreate.do");
    	ModelAndView model = new ModelAndView(new JsonView());
        
    	JSONObject jsonObj = new JSONObject();
        
        String result = DnkrConstans.RESULT_N;
        
        //언어조회
        //System.out.println("언어조회");
        CodeDomain langDomain = new CodeDomain();
        langDomain.setCmcParentCode(DnkrConstans.CMC_SUPER_LANG_CODE);
        List<CodeDomain> domainList = codeService.searchByCondition(langDomain);
        List<String> langList = new ArrayList<String>();
        if(! domainList.isEmpty()) {
            for(CodeDomain domain: domainList) {
                langList.add(domain.getCmcCode());
            }
        }
        
        //sort가 빈값이면 max sort 셋팅하기
        if (form.getMcdSort() == 0) {
	        int maxMcdSort = 0;
	        	try {
	        		maxMcdSort = menuService.searchMaxMcdSort(form);
	        	} catch (Exception e) {
	        		System.out.println("데이터가 없습니다.");
	        	}
	        form.setMcdSort(maxMcdSort + 1);
	        System.out.println(form.getMcdSort());
        }
        
        try {
        	menuService.create(form, langList);
        	result = DnkrConstans.RESULT_Y;
        } catch (Exception e) {
        	System.out.println("저장되지 않았습니다.");
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }

    /**
     * [KO] 주 처리과정.<br>
     * [KO] 메뉴코드 위치이동.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] Register to DB information you have modified the screen.<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/updateMove", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAD010")
    public void update(HttpServletRequest request, HttpServletResponse response) throws
        Exception {
        /**
         * <pre>
         * 1.[KO] 메뉴코드 위치수정 처리.
         *   [KO]   입력한 내용으로 메뉴코드를 수정한다.
         * 1.[EN] Menu code update process.
         *   [EN]   I update an Menu code with DB by input contents.
         *   [JP] 
         *   [JP] 
         * </pre>
         */

        JSONObject jsonObj = new JSONObject();

        String mcdCode = ServletRequestUtils.getStringParameter(request, "mcdCode");
        int countChild = ServletRequestUtils.getIntParameter(request, "countChild");
        int newMcdSort = ServletRequestUtils.getIntParameter(request, "newMcdSort");
        String newRefMcd = ServletRequestUtils.getStringParameter(request, "newRefMcd");
        int newMcdDepth = 1;
        String sortDownDomainRef = null;

        //update Menu 
        MenuDomain criteria = new MenuDomain();
        criteria.setMcdCode(mcdCode);
        MenuDomain updateMenuCriteria = menuService.searchByKey(criteria);

        //새상위메뉴의 하위메뉴에서 이동시킬 메뉴와 같은 depth의 sort up 시킬 도메인
        MenuDomain sortUpDomain = new MenuDomain();

        //이동할 메뉴에 새상위메뉴가 존재
        if(!newRefMcd.equals("0")) {
            //새 상위메뉴 
            MenuDomain refCriteria = new MenuDomain();
            refCriteria.setMcdCode(newRefMcd);
            MenuDomain refMenuDomain = menuService.searchByKey(refCriteria);
            newMcdDepth = refMenuDomain.getMcdDepth() + 1;
            
            //새 상위메뉴의 변경할메뉴와 같은 depth 메뉴의 sort(+1) 변경할 도메인
            sortUpDomain.setMcdRef(newRefMcd);
        }
        //변경할 메뉴에 하위메뉴가 존재
        if(countChild > 0) {
            //이동할 메뉴의 하위메뉴의 depth(+1) 변경
            try {
                MenuDomain depthUpdateDomain = new MenuDomain();
                depthUpdateDomain.setMcdRef(mcdCode);
                depthUpdateDomain.setMcdDepth(newMcdDepth + 1);
                menuService.updateDepth(depthUpdateDomain);
            } catch (Exception e) {
            }
        }
        
      //기존 ref안에  변경메뉴와 같은 depth의 sort(-1)변경
        try{
            MenuDomain sortDownDomain = new MenuDomain();

            //위치이동할 메뉴가 최상위메뉴이고 첫번째 위치의 메뉴일경우
            if(updateMenuCriteria.getMcdRef().equals("0") && updateMenuCriteria.getMcdDepth() == 1){
                sortDownDomainRef = null;
            } else {
                sortDownDomainRef = updateMenuCriteria.getMcdRef();
            }
            sortDownDomain.setMcdRef(sortDownDomainRef);
            sortDownDomain.setMcdSort(updateMenuCriteria.getMcdSort());
            sortDownDomain.setMcdDepth(updateMenuCriteria.getMcdDepth());
            menuService.updateSortDown(sortDownDomain);
        } catch (Exception e) {
        }
        
        //새 상위메뉴의 변경할메뉴와 같은 depth 메뉴의 sort(+1) 변경
        sortUpDomain.setMcdSort(newMcdSort);
        sortUpDomain.setMcdDepth(newMcdDepth);
        try {
            menuService.updateSortUp(sortUpDomain);
        } catch (Exception e) {
        }
        
        //이동한 메뉴  update
        MenuDomain updateMenuDomain = new MenuDomain();
        updateMenuDomain.setMcdCode(mcdCode);
        updateMenuDomain.setMcdRef(newRefMcd);
        updateMenuDomain.setMcdSort(newMcdSort);
        updateMenuDomain.setMcdDepth(newMcdDepth);
        menuService.updateCode(updateMenuDomain);       
        
            
        jsonObj.put("result", "OK");
        response.getWriter().print(jsonObj);
        return;
    }
    
    /**
     * [KO] 주 처리과정.<br>
     * [KO] 메뉴코드 수정처리.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] Register to DB information you have modified the screen.<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param menuDomain MenuDomain
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAD010")
    public void update(MenuDomain menuDomain, HttpServletResponse response) throws
        Exception {

        /**
         * <pre>
         * 1.[KO] 메뉴코드 수정 처리.
         *   [KO]   입력한 내용으로 메뉴코드를 수정한다.
         * 1.[EN] Menu code update process.
         *   [EN]   I update an Menu code with DB by input contents.
         *   [JP] 
         *   [JP] 
         * </pre>
         */

        JSONObject jsonObj = new JSONObject();
        menuDomain.setLangCmc(DensoContext.get().getLocale().getLanguage());

        int result = menuService.update(menuDomain);
        if (result > 0) {
        	jsonObj.put("result", "OK");
        } else {
        	jsonObj.put("errMsg", "오류가 발생했습니다.<br>잠시 후 시도해 주세요");
        }
        response.getWriter().print(jsonObj);
        return;
    }

    /**
     * [KO] 메뉴코드 삭제.<br>
     * [EN] Main processing<br>
     * [EN] Delete from the DB the information displayed on the screen.<br>
     * [JP] 社員削除処理<br>
     * [JP] 画面上で選択された社員情報をDBから削除します。<br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
//    @ErrorBack(viewName = "forward:/WAD010Menu/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception{

        /**
         * <pre>
         * 1.[KO] 공통코드 삭제 처리
         *   [KO]   화면에서 선택된 공통코드를 DB에서 삭제합니다.
         * 1.[EN] Common code deleate processing.
         *   [EN]   I delete the Common code information chosen on a screen from DB.
         *   [JP]
         * </pre>
         */

        JSONObject jsonObj = new JSONObject();
        String delMcdCode = ServletRequestUtils.getStringParameter(request, "mcdCode");
        String delMcdDepth = ServletRequestUtils.getStringParameter(request, "mcdDepth");

        MenuDomain criteria = new MenuDomain();
        response.setContentType("text/html;charset=utf-8");

        //메뉴코드가 3depth가 아니면 하위메뉴가 존재하는지 체크
        if(Integer.parseInt(delMcdDepth) != 3){
            criteria.setMcdRef(delMcdCode);
            int subMenuCount = menuService.searchMcdCount(criteria);
            if(subMenuCount > 0) {
                jsonObj.put("errMsg", "하위메뉴가 존재합니다.");
                response.getWriter().print(jsonObj);
                return;
            }
        }

        MenuDomain delMcdDomain = new MenuDomain();
        delMcdDomain.setMcdCode(delMcdCode);
        int count = menuService.delete(delMcdDomain);
        jsonObj.put("result", "OK");
        MessageManager.setInformation("SMPL-I0-0002", new Object[] {
                MessageSources.getInstance().value("info.menu"), 
                String.valueOf(count)});
    
        response.getWriter().print(jsonObj);
        return;
    }

}
