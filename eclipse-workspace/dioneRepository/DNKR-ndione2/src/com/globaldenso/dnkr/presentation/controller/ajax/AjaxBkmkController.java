package com.globaldenso.dnkr.presentation.controller.ajax;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.business.service.AuthService;
import com.globaldenso.dnkr.business.service.BkmkService;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.business.service.PrivateAuthService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.AuthDomain;
import com.globaldenso.dnkr.domain.BkmkDomain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.MenuDomain;
import com.globaldenso.dnkr.domain.PrivateAuthDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;
import com.globaldenso.dnkr.presentation.controller.WAA000MainController;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 공통코드의  ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing of common code (WAF001).<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxBkmk")
public class AjaxBkmkController {

	/**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;
    
	/**
    * [KR] 개인권한 서비스 <br>     
    */
   @Autowired
   private PrivateAuthService privateAuthService;
   
   /**
    * [KR] 그룹권한서비스 <br>     
    */
   @Autowired
   private AuthService authService;
   
   /**
    * [KR] 그룹권한서비스  TEAM<br>     
    */
   @Autowired
   private RelationTeamService relationTeamService;
   
    /**
     * [KR] 메뉴서비스 <br>     
     */
    @Autowired
    private MenuService menuService;
    
    /**
     * [KR] 즐겨찾기서비스 <br>     
     */
    @Autowired
    private BkmkService bkmkService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxBkmkController() {
        // no process
    }
    
    
    /**
     * [KO] 메뉴 조회.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest 
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @SuppressWarnings("null")
	@RequestMapping(value = "/init", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void init(HttpServletRequest request, HttpServletResponse response) 
        throws Exception{

        //System.out.println("ajaxBkmk/init.do");

        JSONObject jsonObj = new JSONObject();

        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
        String empNumber        = (String)empJsonObj.get("uid");        //사용자 사번
        
        //System.out.println("empNumber >>> " + empNumber);
        
        String type = ServletRequestUtils.getStringParameter(request, "type");

        List<MenuDomain> menuDomainlist = new ArrayList<MenuDomain>();
        //List<MenuDomain> menuDomainResultlist = null;
        MenuDomain menuDomain = new MenuDomain();
        menuDomain.setMcdDepth(1);
        menuDomain.setLangCmc(DensoContext.get().getLocale().getLanguage());
        menuDomain.setEmpNumber(empNumber);
        //menuDomainlist = menuService.searchAuthMenuList(menuDomain);

        
        /**
         * 
         */
        //ModelAndView mv = new ModelAndView();
        List<MenuDomain> menuList = null;
        Map<String, Integer> map = new HashMap<String, Integer>();
        
       
        if(empNumber.equals(DnkrConstans.SYSTEM_MANAGER)){
        	MenuDomain domain = new MenuDomain();
        	List<MenuDomain> adminMenuList = menuService.searchByCondition(domain);
        	
        	for(MenuDomain adminMenu : adminMenuList) {
                map.put(adminMenu.getMcdCode(), 15);
            }
    	} else if(empJsonObj.get("empPrivateAuth").equals("Y")){
            //메뉴 + 개인권한
            PrivateAuthDomain setPrivateAuthDomain = new PrivateAuthDomain();
            setPrivateAuthDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            setPrivateAuthDomain.setEmpNumber(empNumber);

            //map에 개인권한에 설정된 권한에 있는 메뉴코드와 권한값 설정하기
            List<PrivateAuthDomain> privateMenuList = privateAuthService.searchMenuList(setPrivateAuthDomain);
            for(PrivateAuthDomain domain : privateMenuList) {
                map.put(domain.getMenuCode(), domain.getAuthNum());
            }
        } else if(empJsonObj.get("teamCode") != null){

            AuthDomain setAuthDomain = new AuthDomain();

            //메뉴 + 그룹권한
            if(empJsonObj.get("authCode") != null ) {
                setAuthDomain.setAuthCode((String)empJsonObj.get("authCode"));
                //map에 팀에 설정된 권한에 있는 메뉴코드와 권한값 설정하기
                List<AuthDomain> authMenuList = authService.searchTeamMenuList(setAuthDomain);
                for(AuthDomain domain : authMenuList) {
                    //System.out.println(domain.getAuthCode());
                    map.put(domain.getMenuCode(), domain.getAuthNum());
                }
            } else {
                //team에 권한이 설정되어있는지 확인
                RelationTeamDomain setTeamDomain = new RelationTeamDomain();
                setTeamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
                setTeamDomain.setRelationCode((String)empJsonObj.get("teamCode"));
                RelationTeamDomain getTeamDomain = relationTeamService.searchByKey(setTeamDomain);
                //System.out.println(" getAuthCode : " + getTeamDomain.getAuthCode());
                //team에 권한이 설정되어 있으면
                if(getTeamDomain != null && getTeamDomain.getAuthCode() != null){
                    String authCode = getTeamDomain.getAuthCode();

                    //사원정보에 authCode 정보업데이트
                    EmpDomain empDomain = new EmpDomain();
                    empDomain.setEmpNumber(empNumber);
                    empDomain.setAuthCode(authCode);
                    empService.update(empDomain);

                    //팀에 설정된 권한가져오기
                    setAuthDomain.setAuthCode(authCode);

                    //map에 팀에 설정된 권한에 있는 메뉴코드와 권한값 설정하기
                    List<AuthDomain> authMenuList = authService.searchTeamMenuList(setAuthDomain);
                    for(AuthDomain domain : authMenuList) {
                        //System.out.println(domain.getAuthCode());
                        map.put(domain.getMenuCode(), domain.getAuthNum());
                    }
                } else if(getTeamDomain != null && getTeamDomain.getAuthCode() == null) {
                    System.out.println("팀권한이 존재하지 않습니다.");
                }
            }
        }  
       
        List<MenuDomain> md3 = null;
        menuList = getMenuList(map);
        int menuListCnt = menuList.size();
        if(menuListCnt > 0){
        	
        	//MenuDomain menuDomain2 = new MenuDomain();
        	/*subCnt >> [{"mcdCode":"2042","mcdUrl":null,"mcdName":"마스타관리","mcdMobile":"N","mcdRef":"1206","mcdNewWindow":"N","depthFullName":null,
        	 * "className":"com.globaldenso.dnkr.domain.MenuDomain@f2defd","rowNumTo":0,"rowNumFrom":0,"mcdDepth":2,"langCmc":null,"mcdSort":1,
        	 * "useYn":null,"mcdUse":"Y","mcdAddCert":"N","mcdRefName":null,"mcdIcon":null}]
        	 */
        	int index = 0;
        	for(MenuDomain md : menuList){
        		 //menuDomainlist.add(md);
				 
        		 int sub1Cnt = md.getSubList().size();
        		 List<MenuDomain> md2   = md.getSubList();
        		 if(sub1Cnt > 0){
        			 //com.globaldenso.dnkr.domain.MenuDomain
        			 for(MenuDomain sb : md2){
        				 int sub2Cnt = sb.getSubList().size();
        				 if(sub2Cnt == 0){
        					  
        					 menuDomainlist.add(sb);
        				 }else if(sub2Cnt > 0){
        					 md3   = sb.getSubList();
        					 for(MenuDomain sb2 : md3){
        						 menuDomainlist.add(sb2);
        					 }
        				 }else{
        					 
        				 }
        			 }
        		 }
        	}
        	
        }
        //System.out.println("menuList >> " + menuList.size());
        /**
         * 
         */
        
        
        BkmkDomain bkmkDomain = new BkmkDomain();
        bkmkDomain.setEmpNumber(empNumber);
        //즐겨찾기 저장된 메뉴가 있으면 해당 메뉴는 체크박스 선택
        int bkmkCount = bkmkService.bkmkCount(bkmkDomain);
        if(bkmkCount > 0){
            List<BkmkDomain> bkmkList = bkmkService.searchByCondition(bkmkDomain);

            for(int i = 0; i < menuDomainlist.size() ; i++){
                MenuDomain tmpMenuDomain = menuDomainlist.get(i);
                String mcdCode = tmpMenuDomain.getMcdCode();
                String mcdName = tmpMenuDomain.getMcdName();
                //System.out.println("mcdName : " + mcdName);
                boolean flag = true;
                //tmpMenuDomain.setUseYn("N");
                for(int j = 0 ; j < bkmkList.size() ; j++){
                    BkmkDomain tmpbkmkDomain = bkmkList.get(j);
                    String bkmkMcdCode = tmpbkmkDomain.getMenuCode();
                    
                    if(mcdCode.equals(bkmkMcdCode)){
                        tmpMenuDomain.setUseYn("Y");
                    }
                   
                }
                menuDomainlist.set(i, tmpMenuDomain);
            }
        }
        
        
        if(menuDomainlist != null) {
            jsonObj.put("list", menuDomainlist);
        }

//
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

    /**
     * 
     * @param map           Map<String,Integer>
     * @return              List<MenuDomain>
     * @throws Exception 
     */
    public List<MenuDomain> getMenuList(Map<String, Integer> map)  throws Exception {
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
        List<MenuDomain> superMenuList = menuService.searchSuperMenuList(domain);
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
                                tempSubMenuDomain.setMcdUse("Y");   //사용하는 메뉴만 가져오기
                                if(mcdMobile > 0){      //모바일의 경우
                                    tempSubMenuDomain.setMcdMobile("Y");
                                }
                                tempSubMenuList = menuService.searchByCondition(tempSubMenuDomain); //라스트서브 도메인리스트

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
    /**
     * [KO] 주 처리과정.<br>
     * [KO] 즐겨찾기 추가.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] .<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest 
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAP001Bkmk/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /**
         * <pre>
         * 1.[KO] 즐겨찾기 등록 처리.<br>
         *   [KO]   입력한 내용으로 즐겨찾기를 등록한다.<br>
         * 1.[EN] BookMark code registration processing.<br>
         *   [EN]   I register an BookMark with DB by input contents.<br>
         *   [JP] 
         *   [JP] 
         * </pre>
         */

        response.setContentType("text/html;charset=utf-8");
        JSONObject jsonObj = new JSONObject();
        System.out.println("ajaxBkmk/create.do");

        String mcdCode = ServletRequestUtils.getStringParameter(request, "mcdCode");

        BkmkDomain domain = new BkmkDomain();
        domain.setEmpNumber(UxisCmmUtil.getSessionData(request, "uid"));
        domain.setMenuCode(mcdCode);
        bkmkService.create(domain);
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.getWriter().print(jsonObj);
        return;
    }
    
    /**
     * [KO] 주 처리과정.<br>
     * [KO] 즐겨찾기 수정.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] BookMark to DB information you have modified the screen.<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest 
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAP001")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /**
         * <pre>
         * 1.[KO] 즐겨찾기 수정 처리.
         *   [KO]   입력한 내용으로 공통코드를 수정한다.
         * 1.[EN] BookMark update process.
         *   [EN]   I update an BookMark with DB by input contents.
         *   [JP] 
         *   [JP] 
         * </pre>
         */

        JSONObject jsonObj = new JSONObject();

        String mcdCode = ServletRequestUtils.getStringParameter(request, "mcdCode");
        String menuSort = ServletRequestUtils.getStringParameter(request, "menuSort");
        
        BkmkDomain domain = new BkmkDomain();
        
        domain.setEmpNumber(UxisCmmUtil.getSessionData(request, "uid"));
        domain.setMenuCode(mcdCode);
        domain.setMenuSort(menuSort);
        
        bkmkService.update(domain);
        
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.getWriter().print(jsonObj);
        return;
    }

    /**
     * [KO] 즐겨찾기 삭제.<br>
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
    @ErrorBack(viewName = "forward:/WAP001Bkmk/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        /**
         * <pre>
         * 1.[KO] 즐겨찾기 삭제 처리<br>
         *   [KO]   화면에서 선택된 조직도를 DB에서 삭제합니다.<br>
         * 1.[EN] <br>
         *   [JP] <br>
         * </pre>
         */

        System.out.println("delete start");
        JSONObject jsonObj = new JSONObject();
        String mcdCode = ServletRequestUtils.getStringParameter(request, "mcdCode");

        response.setContentType("text/html;charset=utf-8");

        BkmkDomain domain = new BkmkDomain();
        domain.setEmpNumber(UxisCmmUtil.getSessionData(request, "uid"));
        domain.setMenuCode(mcdCode);
        
        bkmkService.delete(domain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.getWriter().print(jsonObj);
        return;
    }
    
    /**
     * [KO] 주 처리과정.<br>
     * [KO] 즐겨찾기 수정.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] BookMark to DB information you have modified the screen.<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest 
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/sortUpdate", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAP001")
    public void sortUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /**
         * <pre>
         * 1.[KO] 즐겨찾기 수정 처리.
         *   [KO]   입력한 내용으로 공통코드를 수정한다.
         * 1.[EN] BookMark update process.
         *   [EN]   I update an BookMark with DB by input contents.
         *   [JP] 
         *   [JP] 
         * </pre>
         */
        System.out.println("ajaxBkmk/sortUpdate.do");
        JSONObject jsonObj = new JSONObject();

        String mcdCode = ServletRequestUtils.getStringParameter(request, "mcdCode");
        String[] mcdCodeArr = mcdCode.split(",");
        if(mcdCodeArr.length > 0){
            for(int i = 0 ; i < mcdCodeArr.length ; i++){
                BkmkDomain domain = new BkmkDomain();
                domain.setEmpNumber(UxisCmmUtil.getSessionData(request, "uid"));
                domain.setMenuCode(mcdCodeArr[i]);
                domain.setMenuSort(String.valueOf(i + 1));
                System.out.println(String.valueOf(i + 1) + " code : " + mcdCodeArr[i]);
                bkmkService.update(domain);
            }
        }
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.getWriter().print(jsonObj);
        return;
    }
}
