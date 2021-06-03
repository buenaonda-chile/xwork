/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.duzon.ctd.sso.SingleSignOn;
import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.AuthService;
import com.globaldenso.dnkr.business.service.BkmkService;
import com.globaldenso.dnkr.business.service.BoardService;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.LinkService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.business.service.PrivateAuthService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.constant.DnkrDb2Constans;
import com.globaldenso.dnkr.domain.AuthDomain;
import com.globaldenso.dnkr.domain.BkmkDomain;
import com.globaldenso.dnkr.domain.BoardInfoDomain;
import com.globaldenso.dnkr.domain.BoardTextDomain;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.MaEmpDomain;
import com.globaldenso.dnkr.domain.LinkDomain;
import com.globaldenso.dnkr.domain.MenuDomain;
import com.globaldenso.dnkr.domain.PrivateAuthDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;
import com.globaldenso.dnkr.domain.SessionDomain;
import com.globaldenso.dnkr.domain.SsoAccountDomain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.SsoAccountDb2Domain;
import com.globaldenso.dnkr.presentation.form.basic.WAC001BoardInfoSearchForm;
import com.globaldenso.dnkr.presentation.form.basic.WAC001BoardSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisStringUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;
import kr.co.wizcore.enc.*;

/**
 * [EN] The class defines the controls of Menu (WA0000).<br>
 * [JP] WA0000 基本機能メニュー画面の制御を定義するクラス。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/")
@ViewId(value = "WAA000")
public class WAA000MainController {
    
    /**
     * [EN] Field of EmpService.<br>
     * [JP] EmpServiceのフィールド。<br>
     */
    @Autowired
    private EmpService ssoAccountService;
    
    /**
     * [KR] 메뉴서비스 <br>     
     */
    @Autowired
    private MenuService menuService;
    
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
     * [KR] 그룹권한서비스 CLS <br>     
     */
    @Autowired
    private RelationClsService relationClsService;
    
    /**
     * [KR] 그룹권한서비스 LOC<br>     
     */
    @Autowired
    private RelationLocService relationLocService;
    
    /**
     * [KR] 그룹권한서비스  TEAM<br>     
     */
    @Autowired
    private RelationTeamService relationTeamService;
    
    /**
     * [KR] 게시판 서비스 <br>     
     */
    @Autowired
    private BoardService boardService;
    
    /**
     * [KR] 즐겨찾기서비스 <br>     
     */
    @Autowired
    private BkmkService bkmkService;
    
    /**
     * [KR] 공통코드관리 서비스 <br>          
     */
    @Autowired
    private CodeService codeService;
    
    
    /**
     * [KR] 링크 서비스 <br>     
     */
    @Autowired
    private LinkService linkService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAA000MainController() {
        // no process
    }
    
    /**
     * [EN] Main processing<br>
     * [EN] Display the basic menu screen.<br>
     * [JP] メイン処理<br>
     * [JP] 基本機能メニュー画面を表示します。<br>
     * 
     * @param request               HttpServletRequest
     * @param response              HttpServletResponse
     * @param locale                Optional<String>
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request, HttpServletResponse response, 
        @CookieValue("locallocale") Optional<String> locale)  throws Exception {
        Locale newLocale;
        String paraLocale;

        //System.out.println("/main");

        //세션 저장된 데이터 불러오기
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
        paraLocale = request.getParameter("locale");

        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
        String empNumber        = (String)empJsonObj.get("uid");        //사용자 사번
        String teamCode         = (String)empJsonObj.get("teamCode");   //사용자 팀코드
        String inOutType        = (String)empJsonObj.get("inOutType");
        String empName          = (String)empJsonObj.get("empName");    //사용자명

        try{
            if (paraLocale == null) {
                if((locale.orElse(DensoContext.get().getLocale().getLanguage())) != null 
                    && (locale.orElse(DensoContext.get().getLocale().getLanguage())).equals("ko")){
                    newLocale = new Locale("kr");
                    paraLocale = "kr";
                }else {
                    newLocale = new Locale(locale.orElse(DensoContext.get().getLocale().getLanguage()));
                    paraLocale = locale.orElse(DensoContext.get().getLocale().getLanguage());
                }
            } else {
                newLocale = new Locale(paraLocale);
            }
            DensoContext.get().setLocale(newLocale);
        }catch(Exception e){
            newLocale = new Locale("kr");
        }

        DensoContext.get().setLocale(newLocale);
        
        //세션이 있으면 쿠키굽기
        HttpSession session = request.getSession(false);
        if (session != null) {
//        System.out.println("cookie 굽기 : " + paraLocale);
            response.addCookie(UxisCmmUtil.makeCookie(request, "locallocale", paraLocale));
            
            /*
            //사업부 리스트 세션저장
            if(session.getAttribute(DnkrConstans.CLS_TYPE) == null) {
                RelationClsDomain clsDomain = new RelationClsDomain();
                clsDomain.setCmcLangCode(paraLocale);
                clsDomain.setUseYn("Y");
                try {
                    List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
                    session.setAttribute(DnkrConstans.CLS_TYPE, clsList);
                } catch (Exception e) {
                    System.out.println("데이터가 없습니다.");
                }
            }
            */
            
            //사업장 리스트 세션저장
            if(session.getAttribute(DnkrConstans.LOC_TYPE) == null) {
                RelationLocDomain locDomain = new RelationLocDomain();
                locDomain.setCmcLangCode(paraLocale);
                locDomain.setUseYn("Y");
                try {
                    List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
                    
                    session.setAttribute(DnkrConstans.LOC_TYPE, locList);
                } catch (Exception e) {
                    System.out.println("데이터가 없습니다.");
                }
                
            }
            
          //세션 저장된 데이터 불러오기
            EmpDb2Domain empInfoDb2 = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
            
            if(empInfoDb2 != null) {
                //DB2 사업장 리스트 세션저장
                if(session.getAttribute(DnkrDb2Constans.COM_CODE) == null) {
                    CodeDb2Domain codeDomain = new CodeDb2Domain();
                    codeDomain.setDb2class("PLNT");
                    codeDomain.setCoded1(empInfoDb2.getCompany());
                    try {
                        List<CodeDb2Domain> codeList = codeService.comCode(codeDomain);
                        session.setAttribute(DnkrDb2Constans.COM_CODE, codeList);
                    } catch (Exception e) {
                        System.out.println("데이터가 없습니다.");
                    }
                }
            }
        }
        
        ModelAndView mv = new ModelAndView();
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

                //team에 권한이 설정되어 있으면
                if(getTeamDomain != null && getTeamDomain.getAuthCode() != null){
                    String authCode = getTeamDomain.getAuthCode();

                    //사원정보에 authCode 정보업데이트
                    //EmpDomain empDomain = new EmpDomain();
                    //empDomain.setEmpNumber(empNumber);
                    //empDomain.setAuthCode(authCode);
                    //empService.update(empDomain);

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
        } else {
            //메뉴 + 디폴트 권한?
        }
        
        //모바일의 경우 모바일 메뉴 불러오기
        if(UxisUtil.isMobile(request)) {
            map.put("mcdMobile", 1);
        }
        
        //메뉴 권한
        request.getSession().setAttribute("logEmpNum", empNumber);
        request.getSession().setAttribute("teamCode", teamCode);
        request.getSession().setAttribute("inOutType", inOutType);
        request.getSession().setAttribute("menuMap", map);
        
        menuList = getMenuList(map);
        
        mv.addObject("menuList", menuList);
        mv.addObject("main", true);
        mv.addObject("empName", empName);
        
        //즐겨찾기 불러오기
        BkmkDomain domain = new BkmkDomain();
        domain.setEmpNumber(UxisCmmUtil.getSessionData(request, "uid"));
        domain.setLangCmc(DensoContext.get().getLocale().getLanguage());
        List<BkmkDomain> bkmkList = bkmkService.searchByCondition(domain);

        mv.addObject("bkmkList", bkmkList);
        
    	//게시판명 가져오기
    	ArrayList<BoardInfoDomain> boardInfoList = new ArrayList<BoardInfoDomain>();
    	BoardInfoDomain boardInfoDomain = new WAC001BoardInfoSearchForm();
    	boardInfoDomain.setBoardId(DnkrConstans.MAIN_BOARD_ID_1);
    	boardInfoDomain = boardService.searchInfoById(boardInfoDomain);
    	boardInfoList.add(boardInfoDomain); 
    	
    	BoardInfoDomain boardInfo2Domain = new WAC001BoardInfoSearchForm();
    	boardInfo2Domain.setBoardId(DnkrConstans.MAIN_BOARD_ID_2);
    	boardInfo2Domain = boardService.searchInfoById(boardInfo2Domain);
    	boardInfoList.add(boardInfo2Domain);
    	mv.addObject("boardInfoList", boardInfoList);
    	
    	//카테고리 조회
        CodeDomain langDomain = new CodeDomain();
        langDomain.setCnmLangCode(DensoContext.get().getLocale().getLanguage());
        langDomain.setCmcParentCode(DnkrConstans.CMC_BOARD_CATEGORY);
        List<CodeDomain> categoryList = codeService.searchByCondition(langDomain);
        mv.addObject("categoryList", categoryList);
    	
        if("I".equals(inOutType)){
        	
            //게시글 받아오기
            WAC001BoardSearchForm boardForm = new WAC001BoardSearchForm();
            boardForm.setCirculation_Id_Team(UxisCmmUtil.getSessionData(request, "teamCode"));
            boardForm.setCirculation_Id(UxisCmmUtil.getSessionData(request, "uid"));
            boardForm.setBoardId(DnkrConstans.MAIN_BOARD_ID_1);
            boardForm.setRowNumFrom(1);
            boardForm.setRowNumTo(5);
            List<BoardTextDomain> boardList = boardService.searchByConditionForMain(boardForm);
            mv.addObject("boardList", boardList);

            boardForm.setBoardId(DnkrConstans.MAIN_BOARD_ID_2);
            boardForm.setCirculation_Id_Team(UxisCmmUtil.getSessionData(request, "teamCode"));
            boardForm.setCirculation_Id(UxisCmmUtil.getSessionData(request, "uid"));
            boardForm.setRowNumFrom(1);
            boardForm.setRowNumTo(5);
            List<BoardTextDomain> refList = boardService.searchByConditionForMain(boardForm);
            mv.addObject("refList", refList);
            mv.addObject("today", UxisStringUtil.getTodayYMDString());
            
            if(UxisUtil.isMobile(request)) {
                mv.setViewName(".tiles.page.WAJ002M");   //내부직원용 - 모바일
            } else {
                mv.setViewName(".tiles.page.WAJ002");   //내부직원용
            }
            
        }else{

            //게시글 받아오기
            WAC001BoardSearchForm boardForm = new WAC001BoardSearchForm();
            boardForm.setCirculation_Id(UxisCmmUtil.getSessionData(request, "uid"));
            boardForm.setBoardId(DnkrConstans.MAIN_BOARD_ID_1);
            boardForm.setRowNumFrom(1);
            boardForm.setRowNumTo(6);
            List<BoardTextDomain> boardList = boardService.searchByConditionForMain(boardForm);
            mv.addObject("boardList", boardList);
            mv.addObject("inOutType", inOutType);
            mv.setViewName(".tiles.page.WAJ001");   //외부업체용
        }        
        return mv;
        
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
     * [KO] 내부사원 메인 오른쪽 바로가기 링크연결<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
/*    
 	//초기 사용내역
    @RequestMapping(value = "/ssoAccounts", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ssoAccounts(HttpServletRequest request)  throws Exception {
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = "n";
        String url = "";
        
        String systemSeq = ServletRequestUtils.getStringParameter(request, "systemSeq");
        String appType = "web";	//Application type구분
        String rltParam = "";	//CS용  리턴 파라미터 
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        SsoAccountDb2Domain accounts = null;
        MaEmpDomain hrAccount = null; //HR System용
        
        if (systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_HR) || systemSeq.equals("21")|| systemSeq.equals("22")) {// HR SSO 추가
       		String sessionInfo = request.getSession().getAttribute("ACCOUNT").toString();
      		JSONParser parser = new JSONParser();
       		Object empInfoObj = parser.parse(sessionInfo);
       		JSONObject empJsonObj = (JSONObject)empInfoObj;
       		String empNo = (String)empJsonObj.get("uid"); //사용자명
       		MaEmpDomain hrDomain = new MaEmpDomain();
       		hrDomain.setNoEmp(empNo);
       		hrAccount = empService.searchEmpMaAccount(hrDomain);
       		System.out.println("getNoemp="+hrAccount.getNoEmp());
       		if(hrAccount == null){
       			result = "w";
       		}
        }else{
        	  if (empInfo != null) { 
                  SsoAccountDb2Domain domain = new SsoAccountDb2Domain();
                  domain.setSystemSeq(systemSeq);
                  domain.setUserId(empInfo.getUserId());
                  domain.setCompany(empInfo.getCompany());
                  try {
                      if (systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_ORDERPROD)) {
                          accounts = ssoAccountService.ssoAccounts_OrderProd(domain);
                      }else {
                          accounts = ssoAccountService.ssoAccounts(domain);
                      }
                  }catch (Exception e) {
                      System.out.println("데이터가 없습니다.");
//                    e.printStackTrace();
                  }
              } else {
                  result = "w";
              }
        }
        System.out.println("test=="+result);
        //======== KA TEST용
        //
        if(empInfo.getUserId().equals("E110290")){
            SsoAccountDb2Domain domainT = new SsoAccountDb2Domain();
            domainT.setSystemSeq(systemSeq);
            domainT.setUserId("H110290");            
            accounts = ssoAccountService.ssoAccounts(domainT);
            empInfo.setPlantCd("C1");
            empInfo.setCompany("PS");
            System.out.println(empInfo);      	        	
        }
    	//

       //=======
        if(accounts != null){
            result = "y";
            if(empInfo.getCompany().equals("PE")) {
                if(accounts.getLoginYn().equals("Y")) {
                    url = accounts.getSystemUrl();
                   
                    //SCM System(KE-IE8에서만 정상작동, 크롬에서 로그인페이지는 열리나 자동로그인이 안됨) - 완료
                    if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_SCM)){
                        url += "?comp=" + accounts.getSystemGru();
                        url += "&user_id=" + accounts.getSystemId();
                        url += "&pwd=" + accounts.getSystemPw();

                    //PDM System(KE) - 완료
                    } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_PDM)){
                        url += "?user_Id=" + accounts.getSystemId();
                        url += "&pwd=" + accounts.getSystemPw();   

                    //K-SOX System(공통)  - 완료
                    } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_K_SOX)){
                        url += "?userID=" + accounts.getSystemId();
                        url += "&userPW=" + accounts.getSystemPw();      
                        
                    //순서생산(IE에서만 정상작동) - 완료
                    } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_ORDERPROD)){
                        url += "?id=" + empInfo.getUserId();
                        appType = "cs";
                        
                    //공정누락(Prevention)(KE) - 완료
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_PREVENTION)){
	                    rltParam= accounts.getSystemGru();
	                    appType = "cs";

	                //MES(KE) - 완료
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_MES)){
	                	//rltParam=" -siteId:MPT1 -serverAddress:10.73.254.144 -factory:DNKE -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
	                	rltParam=" -siteId:MPP1 -serverAddress:mes-e1.dnke.kr -factory:DNKE -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
	                	appType = "cs";
	                	
                    //TQMS(공통) - 완료
                    } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_TQMS)){
                        url += "?gw=y&id=" + accounts.getSystemId();

                    //금형관리(공통) - 완료
                    } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_MOLD)){
                        url += "?Lid=" + accounts.getSystemId();

	                //FTA(공통) - 완료
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_FTA)){
	                	//url += "?userID=" + accounts.getSystemId()	+ "&userPW=" + accounts.getSystemPw();	//구버전
	                	//http://fta.densokorea.com/FTA_COM_MGMT/LogOnDenso?Corp_id=CORP_ID&UserName=ID&Password=PASSWORD	//신버전
	                	url =  "http://fta.densokorea.com/FTA_COM_MGMT/LogOnDenso";
	                	url += "?Corp_id=DNKE" + "&UserName=" + accounts.getSystemId()+"&Password=" + accounts.getSystemPw();    
	                }
                } else {
                    url = accounts.getSystemUrl2();
                }
                
            //KA
            } else {
                if(accounts.getLoginYn().equals("Y")) {
                    url = accounts.getSystemUrl();
                    
                    //SCM System(KA - IE에서만 정상작동) - 완료
                    //PGM설치 후 사용가능함. 설치주소 : http://10.72.149.81:8080/CWORKS/Setup/PGM 
                    if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_SCM)){
                        url += "?id=" + accounts.getSystemId();
                        appType = "cs";
                        
                    //K-SOX System(공통)  - 완료
                    } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_K_SOX)){
                        url += "?userID=" + accounts.getSystemId();
                        url += "&userPW=" + accounts.getSystemPw();

	                //MES(KA) - 완료(창원)
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_MES)){
	                	if(empInfo.getPlantCd().equals("C1")){
		                	//rltParam=" -siteId:MPT1 -serverAddress:10.72.149.98 -factory:DNP1 -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
		                	rltParam=" -siteId:MPT1 -serverAddress:mes-c1.dnka.kr -factory:DNP1 -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
	                	}else if(empInfo.getPlantCd().equals("H1")){
		                	//rltParam=" -siteId:DNH1 -serverAddress:10.74.139.16 -factory:DNH1 -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
		                	rltParam=" -siteId:DNH1 -serverAddress:mes-h1.dnka.kr -factory:DNH1 -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
	                	}
	                    appType = "cs";
	                    
	                //TQMS(공통) - 완료
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_TQMS)){
	                	url += "?gw=y&id=" + accounts.getSystemId();
	                	
	                //FTA(공통) - 완료
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_FTA)){
	                	//url += "?userID=" + accounts.getSystemId()	+ "&userPW=" + accounts.getSystemPw();	//구버전
	                	//http://fta.densokorea.com/FTA_COM_MGMT/LogOnDenso?Corp_id=CORP_ID&UserName=ID&Password=PASSWORD	//신버전
	                	url =  "http://fta.densokorea.com/FTA_COM_MGMT/LogOnDenso";
	                	url += "?Corp_id=DNKA" + "&UserName=" + accounts.getSystemId()+"&Password=" + accounts.getSystemPw();
	                //SPC(KA) - 진행중 완료(창원)------->
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_SPC)){
	                	rltParam=" "+accounts.getSystemId()+" "+ accounts.getSystemPw();
	                	rltParam+="||"+empInfo.getPlantCd();//공장별 설치파일이 다르기 때문에 공장파라미터를 브라우저에서 체크
	                    appType = "cs";
	                    
	                //PLM System(KA) - 완료 
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_PLM)){
	                	url += "?login_name=" + accounts.getSystemId();
	                	url += "&login_password=" + accounts.getSystemPw();	//사용자 default pw : 1
	                	
	                //금형관리(공통) - 완료
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_MOLD)){
	                	url += "?Lid=" + accounts.getSystemId();

	                //PDM System(KE) - 추가2019.03.31
                    } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_PDM)){
                        url += "?user_Id=" + accounts.getSystemId();
                        url += "&pwd=" + accounts.getSystemPw();
                    }
                    
                } else {
                    url = accounts.getSystemUrl2();
                }
            }
            
        }
         
        //20118.06.05 추가 IT.T 제혼복
        //HR System
        if(hrAccount != null){
        	//더존 회사코드변경시 수정필요
            result = "y";
            
            String company=hrAccount.getCdCompany();	//Company Code
    		String empNo=hrAccount.getNoEmp();	//Employee Number
    		//공통 : SSO날짜생성
    		Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String pDate = sdf.format(now);
            
            if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_HR)){
        		String group="web";	//Group Code
        		System.out.println(company+"==="+ empNo);
        		if(company.equals("2000")){
        			group ="9999";
        		}
        		//2019.04.01 Company : DENSO Group: WEB
        		
        		//if("DENSO".equals(company)){
        		//	group="WEB";
        		//}
                //END
                //2019.04.01 Company : DENSO Group: WEB
                if( Integer.parseInt(pDate.substring(0,8)) >=  Integer.parseInt("20190421")){
                	company="DENSO";
                	group="WEB";
                }
                //END
                String plainToken = pDate+"|"+company+"|"+group+"|"+empNo;
        		//String plainToken = "20130621152105|COMPANY|GROUP|사번";
        		SingleSignOn sso = new SingleSignOn();
        		String token = sso.encryptString(plainToken, "DUZONBIZONERPIU=");
        		String urlEncode =URLEncoder.encode(token, "UTF-8"); //base64오류발생으로 urlencoer추가
        		url ="http://hrs.densokorea.com:8090"+"/sso?token="+urlEncode;
        	}  else if(systemSeq.equals("21")){//NEXPOM
        		//String plainToken = pDate+"|"+company+"|19PA7000H|2208|"+empNo;
        		String plainToken = pDate+"| | |"+empNo;
        		Encrypt wizSso = new Encrypt();
        		String token = wizSso.Encryption(plainToken, "NEXPOM");	
        		url ="Http://10.73.207.14:8080/externalLogin.do?token="+token;
        	} else if(systemSeq.equals("22")){	//paperless
        		//String plainToken = pDate+"|"+company+"|19PA7000H|2208|"+empNo;
        		String plainToken = pDate+"| | |"+empNo;
        		Encrypt wizSso = new Encrypt();
        		String token = wizSso.Encryption(plainToken, "NEXPOM");	
        		url ="Http://10.73.207.15:8080/externalLogin.do?token="+token;
        	}
        }
        
        //System.out.println("url:" + url);
        jsonObj.put("result", result);
        jsonObj.put("url", url);
        jsonObj.put("appType", appType);	//application type
        jsonObj.put("rltParam", rltParam);	//Mes전용 파라미터
        
        model.addObject("jsonString", jsonObj.toString());
//        model.setViewName(".tiles.page.WAJ002");
        return model;
    }
    */
    
    //미사용 -2019.11.19
    @RequestMapping(value = "/ssoAccounts_org", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ssoAccounts_org(HttpServletRequest request)  throws Exception {
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = "n";
        String url = "";
        
        String systemSeq = ServletRequestUtils.getStringParameter(request, "systemSeq");
        String pSystemCompany = ServletRequestUtils.getStringParameter(request, "ssoCompany");
        String appType = "web";	//Application type구분
        String rltParam = "";	//CS용  리턴 파라미터 
        
        //세션 저장된 데이터 불러오기
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        SsoAccountDb2Domain accounts = null;	//DB2 SSO조회
        LinkDomain ssoUrlAccounts = null; //NewDion URL용 SSO조회
        MaEmpDomain hrAccount = null; //HR System용
        
        //아래 SSO는 사이트주소만 가져온다!
        //if (systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_HR) || systemSeq.equals("21")|| systemSeq.equals("22")) {// HR SSO 추가
        if (systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_HR) || systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_NEXPOM)||
        		systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_PAPERLESS)||systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_GROUPWARE)) {// HR SSO 추가
       		String sessionInfo = request.getSession().getAttribute("ACCOUNT").toString();
      		JSONParser parser = new JSONParser();
       		Object empInfoObj = parser.parse(sessionInfo);
       		JSONObject empJsonObj = (JSONObject)empInfoObj;
       		String empNo = (String)empJsonObj.get("uid"); //사용자명
       		MaEmpDomain hrDomain = new MaEmpDomain();
       		hrDomain.setNoEmp(empNo);
       		hrAccount = empService.searchEmpMaAccount(hrDomain);
       		//System.out.println("getNoemp="+hrAccount.getNoEmp());
       		if(hrAccount == null){
       			result = "w";
       		}else {
       			LinkDomain linkdomain = new LinkDomain();
       			linkdomain.setSysSeq(systemSeq);
	            
       			linkdomain.setCompany("PS");
	            if("2000".equals(hrAccount.getCdCompany())) {
	            	linkdomain.setCompany("PE");
	            }else if("4000".equals(hrAccount.getCdCompany())) {
	            	linkdomain.setCompany("KR");
	            }
	            //개발자용
	            if("110290".equals(empNo) || empNo.equals("030191") || empNo.equals("150046")){
	            	System.out.println(pSystemCompany);
	    	           if("".equals(pSystemCompany)|| pSystemCompany !=  null) {
	    	        	   linkdomain.setCompany(pSystemCompany);
	    	        	   System.out.println("개발자Test1 : "+pSystemCompany);
		            }
	            }
	            ssoUrlAccounts = linkService.ssoUrlAccounts(linkdomain);
	            //System.out.println("ssoUrlAccounts=="+ssoUrlAccounts+"ssoUrlAccounts=="+hrAccount.getCdCompany());
       		}
        }else{
        	  if (empInfo != null) { 
                  SsoAccountDb2Domain domain = new SsoAccountDb2Domain();
                  domain.setSystemSeq(systemSeq);
                  domain.setUserId(empInfo.getUserId());
                  domain.setCompany(empInfo.getCompany());
                  //개발자용
                  if("110290".equals(empInfo.getUserId()) || empInfo.getUserId().equals("030191") || empInfo.getUserId().equals("150046")){
                	  if("".equals(pSystemCompany)|| pSystemCompany !=  null) {
                		  domain.setCompany(pSystemCompany);
                		  System.out.println("개발자Test2 : "+pSystemCompany);
                	  }
                  }
                  try {
                      if (systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_ORDERPROD)) {
                          accounts = ssoAccountService.ssoAccounts_OrderProd(domain);
                      }else {
                          accounts = ssoAccountService.ssoAccounts(domain);
                      }
                  }catch (Exception e) {
                      System.out.println("데이터가 없습니다.");
//                    e.printStackTrace();
                  }
              } else {
                  result = "w";
              }
        }
        System.out.println("test=="+result);
       //=======
        if(accounts != null){
            result = "y";
            if(accounts.getLoginYn().equals("Y")) {
                url = accounts.getSystemUrl();
                /**
                 * 시스템 SEQ는 동일하지만 서버 APP가 다른경우는 구분하여 SSO적용
                 **/
                if(empInfo.getCompany().equals("PE")) {
                    //SCM System(KE-IE8에서만 정상작동, 크롬에서 로그인페이지는 열리나 자동로그인이 안됨) - 완료
                    if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_SCM)){
                        url += "?comp=" + accounts.getSystemGru();
                        url += "&user_id=" + accounts.getSystemId();
                        url += "&pwd=" + accounts.getSystemPw();                   
	                //MES(KE) - 완료
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_MES)){
	                	//rltParam=" -siteId:MPT1 -serverAddress:10.73.254.144 -factory:DNKE -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
	                	rltParam=" -siteId:MPP1 -serverAddress:mes-e1.dnke.kr -factory:DNKE -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
	                	appType = "cs";
	                //FTA(공통) - 완료
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_FTA)){
	                	//url += "?userID=" + accounts.getSystemId()	+ "&userPW=" + accounts.getSystemPw();	//구버전
	                	//http://fta.densokorea.com/FTA_COM_MGMT/LogOnDenso?Corp_id=CORP_ID&UserName=ID&Password=PASSWORD	//신버전
	                	url =  "http://fta.densokorea.com/FTA_COM_MGMT/LogOnDenso";
	                	url += "?Corp_id=DNKE" + "&UserName=" + accounts.getSystemId()+"&Password=" + accounts.getSystemPw();    
	                }
                }
                else  if(empInfo.getCompany().equals("PS")) {
                	//SCM System(KA - IE에서만 정상작동) - 완료
                    //PGM설치 후 사용가능함. 설치주소 : http://10.72.149.81:8080/CWORKS/Setup/PGM 
                    if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_SCM)){
                        url += "?id=" + accounts.getSystemId();
                        appType = "cs";
	                //MES(KA) - 완료(창원)
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_MES)){
	                	if(empInfo.getPlantCd().equals("C1")){
		                	//rltParam=" -siteId:MPT1 -serverAddress:10.72.149.98 -factory:DNP1 -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
		                	rltParam=" -siteId:MPT1 -serverAddress:mes-c1.dnka.kr -factory:DNP1 -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
	                	}else if(empInfo.getPlantCd().equals("H1")){
		                	//rltParam=" -siteId:DNH1 -serverAddress:10.74.139.16 -factory:DNH1 -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
		                	rltParam=" -siteId:DNH1 -serverAddress:mes-h1.dnka.kr -factory:DNH1 -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
	                	}else if(empInfo.getPlantCd().equals("S1")){
		                	//rltParam=" -siteId:DNH1 -serverAddress:10.73.207.11-factory:DNS1 -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
		                	rltParam=" -siteId:DNS1 -serverAddress:mes-h1.dnka.kr -factory:DNS1 -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
	                	}
	                    appType = "cs";	   
	                //SPC(KA) - 진행중 완료(창원)------->
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_SPC)){
	                	rltParam=" "+accounts.getSystemId()+" "+ accounts.getSystemPw();
	                	rltParam+="||"+empInfo.getPlantCd();//공장별 설치파일이 다르기 때문에 공장파라미터를 브라우저에서 체크
	                    appType = "cs";
	                //FTA(공통) - 완료
	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_FTA)){
	                	//url += "?userID=" + accounts.getSystemId()	+ "&userPW=" + accounts.getSystemPw();	//구버전
	                	//http://fta.densokorea.com/FTA_COM_MGMT/LogOnDenso?Corp_id=CORP_ID&UserName=ID&Password=PASSWORD	//신버전
	                	url =  "http://fta.densokorea.com/FTA_COM_MGMT/LogOnDenso";
	                	url += "?Corp_id=DNKA" + "&UserName=" + accounts.getSystemId()+"&Password=" + accounts.getSystemPw();
	                }
                }
                /**
                 * 공통 또는 공장 단독 시스템
                 **/
                //K-SOX System(공통)  - 완료
                if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_K_SOX)){	//구KE/KA 접속주소 다름.
                    url += "?userID=" + accounts.getSystemId();
                    url += "&userPW=" + accounts.getSystemPw();
                 //금형관리(공통) - 완료
                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_MOLD)){	//구KE/KA 접속주소 다름.
                    url += "?Lid=" + accounts.getSystemId();
                //순서생산(KE전용) -> IE에서만 정상작동 - 완료
                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_ORDERPROD)){
                    url += "?id=" + empInfo.getUserId();
                    appType = "cs";
                //공정누락(Prevention)(KE전용) - 완료
                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_PREVENTION)){
                    rltParam= accounts.getSystemGru();
                    appType = "cs";
                //PDM System(KE전용, KA도 사용) - 완료
                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_PDM)){
                    url += "?user_Id=" + accounts.getSystemId();
                    url += "&pwd=" + accounts.getSystemPw();	
                //PLM System(KA전용) - 완료 
                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_PLM)){
                	url += "?login_name=" + accounts.getSystemId();
                	url += "&login_password=" + accounts.getSystemPw();	//사용자 default pw : 1
                //TQMS(공통) - 완료
                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_TQMS)){
                    url += "?gw=y&id=" + accounts.getSystemId();
                }
            } else {	//자동로그인이 아닌 경우
            		url = accounts.getSystemUrl2();
            }
        }
        //20118.06.05 추가 IT.T 제혼복
        //HR System
        if(hrAccount != null){
        	//더존 회사코드변경시 수정필요
            result = "y";
            url = ssoUrlAccounts.getSysUrl();
            String company=hrAccount.getCdCompany();	//Company Code
    		String empNo=hrAccount.getNoEmp();	//Employee Number
            //System.out.println("hrAccount="+result+systemSeq+company+empNo);
    		//공통 : SSO날짜생성
    		Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String pDate = sdf.format(now);
            
            if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_HR)){
        		String group="web";	//Group Code
        		System.out.println(company+"==="+ empNo);
        		if(company.equals("2000")){
        			group ="9999";
        		}
        		//2019.04.01 Company : DENSO Group: WEB
        		
        		//if("DENSO".equals(company)){
        		//	group="WEB";
        		//}
                //END
                //2019.04.01 Company : DENSO Group: WEB
                if( Integer.parseInt(pDate.substring(0,8)) >=  Integer.parseInt("20190421")){
                	company="DENSO";
                	group="WEB";
                }
                //END
                String plainToken = pDate+"|"+company+"|"+group+"|"+empNo;
        		//String plainToken = "20130621152105|COMPANY|GROUP|사번";
        		SingleSignOn sso = new SingleSignOn();
        		String token = sso.encryptString(plainToken, "DUZONBIZONERPIU=");
        		String urlEncode =URLEncoder.encode(token, "UTF-8"); //base64오류발생으로 urlencoer추가
        		//url ="http://hrs.densokorea.com:8090/sso?token="+urlEncode;
        		url += "?token="+ urlEncode;
        	//}  else if(systemSeq.equals("21")){//NEXPOM
        	}  else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_NEXPOM)){//NEXPOM
        		//String plainToken = pDate+"|"+company+"|19PA7000H|2208|"+empNo;
        		String plainToken = pDate+"| | |"+empNo;
        		Encrypt wizSso = new Encrypt();
        		String token = wizSso.Encryption(plainToken, "NEXPOM");	
        		//url ="http://10.73.207.14:8080/externalLogin.do?token="+token;
        		url += "?token="+ token;
        	//} else if(systemSeq.equals("22")){	//paperless
        	} else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_PAPERLESS)){	//paperless
        		String plainToken = pDate+"| | |"+empNo;
        		Encrypt wizSso = new Encrypt();
        		String token = wizSso.Encryption(plainToken, "PAPERLESS");	
        		//url ="http://10.73.207.15:8080/externalLogin.do?token="+token;
        		url += "?token="+ token;
        	}else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_GROUPWARE)){	//GROUPWARE
        		//http://gw.densokorea.com/names.nsf?login&username=030230&password=030230&RedirectTo=/
	       		 url += "?login&username=" + empNo;
	    		 url += "&password=" + empNo;
	    		 url += "&RedirectTo=/";
        	}
        }
        
        //System.out.println("url:" + url);
        jsonObj.put("result", result);
        jsonObj.put("url", url);
        jsonObj.put("appType", appType);	//application type
        jsonObj.put("rltParam", rltParam);	//Mes전용 파라미터
        
        model.addObject("jsonString", jsonObj.toString());
//        model.setViewName(".tiles.page.WAJ002");
        return model;
    }
    
    @RequestMapping(value = "/ssoSessionAccounts_org", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ssoSessionAccounts_org(HttpServletRequest request)  throws Exception {
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = "n"; //권한이 없는 경우
        String url = "";
        String urlSetup = "";
        String sysId="";
        
        //System.out.println("ssoSessionAccounts.do");
        //세션 저장된 데이터 불러오기
        String systemNm = ServletRequestUtils.getStringParameter(request, "systemNm");
        String checkCode = ServletRequestUtils.getStringParameter(request, "checkCode");
        //System.out.println(systemNm);
        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        //System.out.println("empInfo==="+empInfo+ " userID="+empInfo.getUserId());
		String sessionInfo = request.getSession().getAttribute("ACCOUNT").toString();
		//System.out.println("sessionInfo==="+sessionInfo);
		
		JSONParser parser = new JSONParser();
		Object empInfoObj = parser.parse(sessionInfo);
		JSONObject empJsonObj = (JSONObject)empInfoObj;
		//String userId = (String)empJsonObj.get("empId"); //사용자ID(2018.12.18)
		String userId = empInfo.getUserId();	//추후 수정필요(empId->userID로 변경)
		String company = empInfo.getCompany(); //회사코드
		String plantCd = empInfo.getPlantCd(); //공장코드
		
        if("Y".equals(checkCode)){
        	//System.out.println("선택");
        	userId =  ServletRequestUtils.getStringParameter(request, "dioneId");//추후 수정필요(empId->userID로 변경)
    		company =  ServletRequestUtils.getStringParameter(request, "companyCd"); //회사코드
    		plantCd =  ServletRequestUtils.getStringParameter(request, "plantCd"); //공장코드
        }
		//System.out.println(userId);
		SsoAccountDb2Domain domain = new SsoAccountDb2Domain();
				 
		domain.setUserId(userId);
	  
    	if(systemNm.equals("disPlay")){
            //System.out.println("disPlay");
	        int count = 0;
	        try{	
	        	count = ssoAccountService.searchSsoDspSessionAccount(domain);
	        }catch (Exception e) {
	            System.out.println("데이터가 없습니다.");
	            e.printStackTrace();
	            //result = "n";
	        }
	        if(count != 0){
	        	count = ssoAccountService.searchSsoDspSessionAccount(domain);
	            result = "y";
	            //url ="http://dione.dnke.kr/sessionDisplayCheck.jsp?EmpNo='"+userId+"'&Company='"+company+"'&PlantCd='"+plantCd+"'&SessionCnt="+Integer.toString(count);
	            url ="http://dione.dnke.kr/sessionDisplay1.jsp?EmpNo='"+userId+"'&Company='"+company+"'&PlantCd='"+plantCd+"'&SessionCnt="+Integer.toString(count);
	            System.out.println("count===" + count);
	            if(count < 1){
		        	result = "w";	            	
	            }
	        } else {
	        	result = "w";
	        }
    	}else if(systemNm.equals("printer")){
            //System.out.println("printer");
            
    		String prtParam1="";
    		String prtParam2="";
    		String sessionCnt="";
               
    		SsoAccountDb2Domain prtDomain = new SsoAccountDb2Domain();
            prtDomain = ssoAccountService.searchSsoPrtSessionAccount(domain);
                        
            if(prtDomain != null){
            	String comps = empInfo.getPlantCd();
            	String compsDns="";
            	if(comps.equals("E1")){
            		compsDns = "/H cigma_db.dnke.kr /D ";
            	}else if(comps.equals("C1")){
            		compsDns = "/H cigma_c1.dnka.kr /D ";
            	}else if(comps.equals("H1")){
            		compsDns = "/H cigma_h1.dnka.kr /D ";
            	}else if(comps.equals("S1")){
            		compsDns = "/H cigma_s1.dnka.kr /D ";
            	}
            	System.out.println(comps);
            	prtParam1 = compsDns + prtDomain.getDevice1() + " /S";
            	prtParam2 = compsDns + prtDomain.getDevice2() + " /S";
            	sessionCnt = prtDomain.getDeviceCnt();
            	result = "y";
            	url ="http://dione.dnke.kr/sessionPrinterCheck.jsp?PrtSetup1='"+prtParam1+"'&PrtSetup2='"+prtParam2+"'&SessionCnt="+sessionCnt;
           }else {
            	result = "w";
            } 
   	 	}else if(systemNm.equals("dione")){
   	 		if(userId !=null){
   	 			System.out.println(userId);
            	url ="dione";
            	sysId = userId;
            	result = "y";
   	 		}else {
            	result = "w";
            }    
   	 	}
    	//마이플렛폼 설치여부 체크
    	System.out.println(request.getSession().getAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_SETUP));
    	System.out.println(result);
    	if("y".equals(result)){
    		if("SUCCESS" != request.getSession().getAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_SETUP)){
      			result = "i";
      			urlSetup ="/WAN003MiPlatform/install.do";
      		}
    	}
    	jsonObj.put("result", result);
        jsonObj.put("url", url);
        jsonObj.put("urlSetup", urlSetup);	//마이플렛폼 설치페이지경로
    	jsonObj.put("sysId", sysId);	//세션ID
        
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    // dione계정 count 2019.01.25
    // 구디오네→뉴디오네 전환으로 미사용 : 2019.11.21
    /*
    @RequestMapping(value = "/ssoSessionAccounts2_org", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ssoSessionAccounts2_org(HttpServletRequest request)  throws Exception {
            
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = "w"; //권한이 없는 경우
        String idPlant = "";
        
		int dioneAccount = 0;
        
        //System.out.println("ssoSessionAccounts2.do");
        //세션 저장된 데이터 불러오기
        String systemNm = ServletRequestUtils.getStringParameter(request, "systemNm");
		String sessionInfo = request.getSession().getAttribute("ACCOUNT").toString();
		
		JSONParser parser = new JSONParser();
		Object empInfoObj       = parser.parse(sessionInfo);
		JSONObject empJsonObj   = (JSONObject)empInfoObj;
		String empNumber        = (String)empJsonObj.get("uid");        //사용자 사번

		SsoAccountDb2Domain domain = new SsoAccountDb2Domain();
		List<SsoAccountDb2Domain> dioneAccountList = null;
		domain.setUserId(empNumber);	  

    	if(systemNm.equals("disPlay")){
    		dioneAccountList  = ssoAccountService.searchDioneAccountCnt(domain);
    		dioneAccount = dioneAccountList.size();
    		System.out.println("dioneAccount==="+dioneAccount);
    		if(dioneAccount != 0){
    			result = "y";
    			// DIONE ID 셋팅
    	    	for (SsoAccountDb2Domain dioneAccountDomain : dioneAccountList) {
    	    		idPlant +="dioneId::"+dioneAccountDomain.getUserId()+"!companyCd::"+dioneAccountDomain.getCompany()+"!plantCd::"+dioneAccountDomain.getPlantCd()+"||";    	    		
    			}
	        } else {
	        	result = "w";
	        }
    	}
    	
    	jsonObj.put("result", result);
    	jsonObj.put("idPlant", idPlant);	//구디오네 ID별 공장코드
    	jsonObj.put("dioneAccount", dioneAccount);	//구디오네 ID 수
        
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    */
    //로직변경TEST
    @RequestMapping(value = "/ssoAccounts", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ssoAccounts(HttpServletRequest request)  throws Exception {
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = "n";	// n: 링크없음. w: 권한없음, y:정상
        String url = "";
        
        String systemSeq = ServletRequestUtils.getStringParameter(request, "systemSeq");	//waj002.jsp, ShorcutMenu.jsp
        String sessionpageType = ServletRequestUtils.getStringParameter(request, "pageType");	//waj002.jsp, ShorcutMenu.jsp의 사용자 clscode
        String pSystemCompany = ServletRequestUtils.getStringParameter(request, "ssoCompany");	//wac020 PGM용
        String appType = "web";	//Application type구분
        String rltParam = "";	//CS용  리턴 파라미터 
        
        //세션 저장된 데이터 불러오기
        LinkDomain ssoUrlAccounts = null; //NewDion URL용 SSO조회
        LinkDomain ssoUrlAccountsAuth = null; //NewDion URL 및 권한 SSO조회
        MaEmpDomain hrAccount = null; //HR System용
        
        //세션 저장된 데이터 불러오기
        String sessionInfo = request.getSession().getAttribute("ACCOUNT").toString();
  		JSONParser parser = new JSONParser();
   		Object empInfoObj = parser.parse(sessionInfo);
   		JSONObject empJsonObj = (JSONObject)empInfoObj;
   		String empNo = (String)empJsonObj.get("uid"); //사용자명
   		String empId = (String)empJsonObj.get("empId"); //사용자ID
   		String empClsCode = (String)empJsonObj.get("clsCode"); //사업부코드
   		String empLocCode = (String)empJsonObj.get("locCode"); //사업장코드
   		
   		//System.out.println("sessionpageType: " +sessionpageType+" systemSeq: " +systemSeq+" pSystemCompany: " +pSystemCompany);
   		//System.out.println("empNo: "+empNo+" empId: "+empId+" empClsCode: "+empClsCode+" empLocCode: "+empLocCode);
   		
   		if (empNo != null) {	//세션계정이 있는 경우
   			LinkDomain domain = new LinkDomain();
            domain.setInOutType("O");	//시스템 내외구분
            domain.setSysSeq(systemSeq);	//시스템 seq
            domain.setEmpNumber(empNo);
            if(("main").equals(sessionpageType)) {	//호출구분 : 메인페이지
            	 domain.setCompany(empClsCode);	//세션의 cls코드
            }else {	//호출구분 : 링크페이지
            	 domain.setCompany(pSystemCompany);	//링크페이지의 cls코드
            }
            ssoUrlAccounts = linkService.ssoUrlAccounts(domain);	//SSO사이트 조회
            if(ssoUrlAccounts != null) {	//사이트가 있으면
            	result = "y";
            	if(ssoUrlAccounts.getLoginYn().equals("Y")) {	//자동로그인
                    url = ssoUrlAccounts.getSysUrl();	//자동로그인 URL
	            	if(("Y").equals(ssoUrlAccounts.getSsoTf())){	//SSO 계정관리를 하는 경우
	            		//=============================================================================
	                    /**
	                     * 시스템 SEQ는 동일하지만 서버 APP가 다른경우는 구분하여 SSO적용
	                     **/
	            		try {
	                        //계정이 없는 경우 오류발생?
	            			ssoUrlAccountsAuth = linkService.ssoUrlAccountsAuth(domain);	//SSO사이트 조회
	                   		//System.out.println("ssoUrlAccountsAuth : "+ssoUrlAccountsAuth);
	                    }catch (Exception e) {
	                        System.out.println("데이터가 없습니다.");
	                        result = "w";	//w: 권한없음
//	                      e.printStackTrace();
	                    }
	            		if (ssoUrlAccountsAuth !=null){
	            			 if(domain.getCompany().equals("CLS000002")) {
	 	                        //SCM System(KE-IE8에서만 정상작동, 크롬에서 로그인페이지는 열리나 자동로그인이 안됨) - 완료
	 	                        if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_SCM)){
	 	                            url += "?comp=" + ssoUrlAccountsAuth.getSystemGroup();
	 	                            url += "&user_id=" + ssoUrlAccountsAuth.getSystemId();
	 	                            url += "&pwd=" + ssoUrlAccountsAuth.getSystemPW();                   
	 	    	                //MES(KE) - 완료
	 	    	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_MES)){
	 	    	                	//rltParam=" -siteId:MPT1 -serverAddress:10.73.254.144 -factory:DNKE -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
	 	    	                	rltParam=" -siteId:MPP1 -serverAddress:mes-e1.dnke.kr -factory:DNKE -userId:"+ssoUrlAccountsAuth.getSystemId()+" -password:"+ ssoUrlAccountsAuth.getSystemPW();
	 	    	                	appType = "cs";
	 	    	                //FTA(공통) - 완료
	 	    	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_FTA)){
	 	    	                	//url += "?userID=" + ssoUrlAccountsAuth.getSystemId() + "&userPW=" + ssoUrlAccountsAuth.getSystemPW();	//구버전
	 	    	                	//http://fta.densokorea.com/FTA_COM_MGMT/LogOnDenso?Corp_id=CORP_ID&UserName=ID&Password=PASSWORD	//신버전
	 	    	                	//url =  "http://fta.densokorea.com/FTA_COM_MGMT/LogOnDenso";
	 	    	                	url += "?Corp_id=DNKE" + "&UserName=" + ssoUrlAccountsAuth.getSystemId()+"&Password=" + ssoUrlAccountsAuth.getSystemPW();    
	 	    	                }
	 	                    }else  if(domain.getCompany().equals("CLS000001")) {
	 	                    	//SCM System(KA - IE에서만 정상작동) - 완료
	 	                        //PGM설치 후 사용가능함. 설치주소 : http://10.72.149.81:8080/CWORKS/Setup/PGM 
	 	                        if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_SCM)){
	 	                            url += "?id=" + ssoUrlAccountsAuth.getSystemId();
	 	                            appType = "cs";
	 	    	                //MES(KA) - 완료(창원)
	 	    	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_MES)){
	 	    	                	if(("LOC000001").equals(empLocCode)){	//창원
	 	    		                	//rltParam=" -siteId:MPT1 -serverAddress:10.72.149.98 -factory:DNP1 -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
	 	    		                	rltParam=" -siteId:MPT1 -serverAddress:mes-c1.dnka.kr -factory:DNP1 -userId:"+ssoUrlAccountsAuth.getSystemId()+" -password:"+ ssoUrlAccountsAuth.getSystemPW();
	 	    	                	}else if(("LOC000002").equals(empLocCode)){	//홍성
	 	    		                	//rltParam=" -siteId:DNH1 -serverAddress:10.74.139.16 -factory:DNH1 -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
	 	    		                	rltParam=" -siteId:DNH1 -serverAddress:mes-h1.dnka.kr -factory:DNH1 -userId:"+ssoUrlAccountsAuth.getSystemId()+" -password:"+ ssoUrlAccountsAuth.getSystemPW();
	 	    	                	}else if(("LOC000003").equals(empLocCode)){	//화성
	 	    		                	//rltParam=" -siteId:DNH1 -serverAddress:10.73.207.11-factory:DNS1 -userId:"+accounts.getSystemId()+" -password:"+ accounts.getSystemPw();
	 	    		                	rltParam=" -siteId:DNS1 -serverAddress:mes-h1.dnka.kr -factory:DNS1 -userId:"+ssoUrlAccountsAuth.getSystemId()+" -password:"+ ssoUrlAccountsAuth.getSystemPW();
	 	    	                	}else if(("LOC000003").equals(empLocCode)){//TEST용 -IT
	 	    	                		rltParam=" -siteId:MPT1 -serverAddress:mes-c1.dnka.kr -factory:DNP1 -userId:"+ssoUrlAccountsAuth.getSystemId()+" -password:"+ ssoUrlAccountsAuth.getSystemPW();
	 	    	                	}
	 	    	                    appType = "cs";	   
	 	    	                //SPC(KA) - 완료(창원)------->
	 	    	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_SPC)){
	 	    	                	String getPlantCode="";
	 	    	                	if(("LOC000001").equals(empLocCode)){	//창원
	 	    	                		getPlantCode = "C1";
	 	    		                }else if(("LOC000002").equals(empLocCode)){	//홍성
	 	    		                	getPlantCode = "H1";
	 	    		                }else if(("LOC000003").equals(empLocCode)){	//화성
	 	    		                	getPlantCode = "S1";
	 	    		                }else{	//TEST용 -IT
	 	    		                	getPlantCode = "C1";
	 	    		                }
	 	    	                	rltParam=" "+ssoUrlAccountsAuth.getSystemId()+" "+ ssoUrlAccountsAuth.getSystemPW();
	 	    	                	rltParam+="||"+getPlantCode;//공장별 설치파일이 다르기 때문에 공장파라미터를 브라우저에서 체크
	 	    	                    appType = "cs";
	 	    	                //FTA(공통) - 완료
	 	    	                } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_FTA)){
	 	    	                	//url += "?userID=" + ssoUrlAccountsAuth.getSystemId() + "&userPW=" + ssoUrlAccountsAuth.getSystemPW();	//구버전
	 	    	                	//http://fta.densokorea.com/FTA_COM_MGMT/LogOnDenso?Corp_id=CORP_ID&UserName=ID&Password=PASSWORD	//신버전
	 	    	                	url += "?Corp_id=DNKA" + "&UserName=" + ssoUrlAccountsAuth.getSystemId()+"&Password=" + ssoUrlAccountsAuth.getSystemPW();
	 	    	                }
	 	                    }
	 	                    /**
	 	                     * 공통 또는 공장 단독 시스템
	 	                     **/
	 	                    //K-SOX System(공통)  - 완료
	 	                    if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_K_SOX)){	//구KE/KA 접속주소 다름.
	 	                        url += "?userID=" + ssoUrlAccountsAuth.getSystemId();
	 	                        url += "&userPW=" + ssoUrlAccountsAuth.getSystemPW();
	 	                     //금형관리(공통) - 완료
	 	                    } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_MOLD)){	//구KE/KA 접속주소 다름.
	 	                        url += "?Lid=" + ssoUrlAccountsAuth.getSystemId();
	 	                    //순서생산(KE전용) -> IE에서만 정상작동 - 완료
	 	                    } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_ORDERPROD)){
	 	                        //url += "?id=" + empInfo.getUserId();
	 	                        url += "?id=" +empId;
	 	                        appType = "cs"; 
	 	                    //공정누락(Prevention)(KE전용) - 완료
	 	                    } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_PREVENTION)){
	 	                        rltParam= ssoUrlAccountsAuth.getSystemGroup();
	 	                        appType = "cs";
	 	                    //PDM System(KE전용, KA도 사용) - 완료
	 	                    } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_PDM)){
	 	                        url += "?user_Id=" + ssoUrlAccountsAuth.getSystemId();
	 	                        url += "&pwd=" + ssoUrlAccountsAuth.getSystemPW();	
	 	                    //PLM System(KA전용) - 완료 
	 	                    } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_PLM)){
	 	                    	url += "?login_name=" + ssoUrlAccountsAuth.getSystemId();
	 	                    	url += "&login_password=" + ssoUrlAccountsAuth.getSystemPW();	//사용자 default pw : 1
	 	                    //TQMS(공통) - 완료
	 	                    } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_TQMS)){
	 	                        url += "&gw=y&id=" + ssoUrlAccountsAuth.getSystemId();
	 	                    }
	            		}else {	//계정이 없는 경우
	            			//result = "w";	//w: 권한없음
	            			url = ssoUrlAccounts.getSysUrl2();
	            			//CS버전은 url이 없으므로 권한 없음으로 처리
	            			if(("CS").equals(ssoUrlAccounts.getSysType())) {
	            				result = "w";	//w: 권한없음
	            			}
	            		}
	            	}else{	//SSO 계정관리를 안하는 경우
	            		//공통 : SSO파라미터생성(날짜)
	            		Date now = new Date();
	                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	                    String pDate = sdf.format(now);
	                    if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_HR)){
	                    	MaEmpDomain hrDomain = new MaEmpDomain();
	                   		hrDomain.setNoEmp(empNo);
	                   		hrAccount = empService.searchEmpMaAccount(hrDomain);
	                   		
		                    String hrCompany=hrAccount.getCdCompany();	//더존 시스템 회사코드
	                		String group="web";	//Group Code
	                		System.out.println(hrCompany+"==="+ empNo);
	                		if(hrCompany.equals("2000")){
	                			group ="9999";
	                		}
	                		//2019.04.01 Company : DENSO Group: WEB
	                		//if("DENSO".equals(company)){
	                		//	group="WEB";
	                		//}
	                        //END
	                        //2019.04.01 Company : DENSO Group: WEB
	                        if( Integer.parseInt(pDate.substring(0,8)) >=  Integer.parseInt("20190421")){
	                        	hrCompany="DENSO";
	                        	group="WEB";
	                        }
		                    //System.out.println("hrAccount="+result+systemSeq+company+empNo);
	                        //END
	                        String plainToken = pDate+"|"+hrCompany+"|"+group+"|"+empNo;
	                		//String plainToken = "20130621152105|COMPANY|GROUP|사번";
	                		SingleSignOn sso = new SingleSignOn();
	                		String token = sso.encryptString(plainToken, "DUZONBIZONERPIU=");
	                		String urlEncode =URLEncoder.encode(token, "UTF-8"); //base64오류발생으로 urlencoer추가
	                		//url ="http://hrs.densokorea.com:8090/sso?token="+urlEncode;
	                		url += "?token="+ urlEncode;
	                	}else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_NEXPOM)){//NEXPOM
	                		//String plainToken = pDate+"|"+company+"|19PA7000H|2208|"+empNo;
	                		String plainToken = pDate+"| | |"+empNo;
	                		Encrypt wizSso = new Encrypt();
	                		String token = wizSso.Encryption(plainToken, "NEXPOM");	
	                		//url ="http://10.73.207.14:8080/externalLogin.do?token="+token;
	                		url += "?token="+ token;
	                	}else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_PAPERLESS)){	//paperless
	                		String plainToken = pDate+"| | |"+empNo;
	                		Encrypt wizSso = new Encrypt();
	                		String token = wizSso.Encryption(plainToken, "PAPERLESS");	
	                		//url ="http://10.73.207.15:8080/externalLogin.do?token="+token;
	                		url += "?token="+ token;
	                	}else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_GROUPWARE)){	//GROUPWARE
	                		//http://gw.densokorea.com/names.nsf?login&username=030230&password=030230&RedirectTo=/
	        	       		 url += "?login&username=" + empNo;
	        	    		 url += "&password=" + empNo;
	        	    		 url += "&RedirectTo=/";
	                	}
 	                    //순서생산(KE전용) -> IE에서만 정상작동 - 완료
	                	else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_ORDERPROD)){
 	                        //url += "?id=" + empInfo.getUserId();
 	                        url += "?id=" +empId;
 	                        appType = "cs";
 	                    }   
	            	}
            	}else{	//자동로그인이 아닌 경우
            		url = ssoUrlAccounts.getSysUrl2();
            	}
            }
   		}else {
   			result = "n";	//n: 링크없음
   		}
   		//System.out.println("rltParam=="+rltParam);
        //System.out.println("test=="+result);
        //System.out.println("url:" + url);
        jsonObj.put("result", result);
        jsonObj.put("url", url);
        jsonObj.put("appType", appType);	//application type
        jsonObj.put("rltParam", rltParam);	//Mes전용 파라미터
        
        model.addObject("jsonString", jsonObj.toString());
//        model.setViewName(".tiles.page.WAJ002");
        return model;
    }
    @RequestMapping(value = "/ssoSessionAccounts", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ssoSessionAccounts(HttpServletRequest request)  throws Exception {
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = "n"; // n: 링크없음. w: 권한없음, y:정상
        String url = "";
        String urlSetup = "";	//마이플렛폼 설치여부
        String sysId="";	//구디오네ID
        String sysName="";	//rlt 시스템구분
        String sessionParam="";	//세션 파라미터
        //String sessionCount="";	//세션 카운트
        
        //System.out.println("ssoSessionAccounts.do");
        //세션 저장된 데이터 불러오기
        String systemNm = ServletRequestUtils.getStringParameter(request, "systemNm");
        String checkCode = ServletRequestUtils.getStringParameter(request, "checkCode");
        //System.out.println("systemNm=="+systemNm+"checkCode=="+checkCode);
		
		
		 //세션 저장된 데이터 불러오기
        String sessionInfo = request.getSession().getAttribute("ACCOUNT").toString();
  		JSONParser parser = new JSONParser();
   		Object empInfoObj = parser.parse(sessionInfo);
   		JSONObject empJsonObj = (JSONObject)empInfoObj;
   		String empNo = (String)empJsonObj.get("uid"); //사용자명
   		String empId = (String)empJsonObj.get("empId"); //사용자ID
   		String empClsCode = (String)empJsonObj.get("clsCode"); //사업부코드
   		String empLocCode = (String)empJsonObj.get("locCode"); //사업장코드
		
        if("Y".equals(checkCode)){		//세션계정이 여러개인 경우
        	//System.out.println("선택");
        	empNo =  ServletRequestUtils.getStringParameter(request, "dioneId");//추후 수정필요(empId->userID로 변경)
        	empClsCode =  ServletRequestUtils.getStringParameter(request, "companyCd"); //회사코드
        	empLocCode =  ServletRequestUtils.getStringParameter(request, "plantCd"); //공장코드
        }
        else {	//DIKR 사용자오류로 추가
    		SessionDomain getAccountInfo = new SessionDomain();
    		List<SessionDomain> dioneAccountList = null;
    		getAccountInfo.setEmpNumber(empNo);
    		dioneAccountList  = linkService.searchDioneAccountCnt(getAccountInfo);
    		for (SessionDomain dioneAccountDomain : dioneAccountList) {
    			empNo =  dioneAccountDomain.getEmpNumber();
    			empClsCode =  dioneAccountDomain.getCompany();
    			empLocCode =  dioneAccountDomain.getWorkPlace();
    		}
        }
		//System.out.println("empNo : "+empNo+" empClsCode : "+empClsCode+" empLocCode : "+empLocCode);
		SessionDomain domain = new SessionDomain();
				 
		domain.setEmpNumber(empNo);
		domain.setCompany(empClsCode);
		domain.setWorkPlace(empLocCode);
	  
    	if(systemNm.equals("disPlay")){
            //System.out.println("disPlay");
    		sysName = "disPlay";
    		List<SessionDomain> ssoDspSessionList = linkService.searchSsoDspSessionAccount(domain);
	        int count = ssoDspSessionList.size();
        	jsonObj.put("sessionCount", count);	//세션 카운트

	        //System.out.println("count : "+count);
	        if(count == 0) {
	            result = "w";
	            System.out.println("데이터가 없습니다.");
	        }else {
	            result = "y";
	        	for (SessionDomain ssoDspSessionDomain : ssoDspSessionList) {
	        		 //url ="http://dione.dnke.kr/sessionDisplay1.jsp?EmpNo='"+ssoDspSessionDomain.getSystemPW()+"'&Company='"+company+"'&PlantCd='"+plantCd+"'&SessionCnt="+Integer.toString(count);
	        		/*
	        		postParam +="empNo::"+ssoDspSessionDomain.getEmpNumber()+"!empID::"+empId+"!empComps::"+ssoDspSessionDomain.getOldCompany()+"!empPlace::"+ssoDspSessionDomain.getOldWorkPlace()+
	        				"!sysID::"+ssoDspSessionDomain.getSystemId()+"!sysPW::"+ssoDspSessionDomain.getSystemPW()+"!sysGroup::"+ssoDspSessionDomain.getSystemGroup()+"||";    	    		
    	    		*/
	        		sessionParam +="EmpNo='"+ssoDspSessionDomain.getEmpNumber()+"'&empID='"+empId+"'&empComps='"+ssoDspSessionDomain.getOldCompany()+
	        				 "'&empPlace='"+ssoDspSessionDomain.getOldWorkPlace()+"'&sysID='"+ssoDspSessionDomain.getSystemId()+ "'&sysPW='"+ssoDspSessionDomain.getSystemPW()+"'&sysGroup='"+ssoDspSessionDomain.getSystemGroup()+"'||";
    	    	}
        		//System.out.println(sessionParam);
	        }
    	}else if(systemNm.equals("printer")){
            //System.out.println("printer");
    		sysName = "printer";
    		String prtParam1="";
    		String prtParam2="";
    		String sessionCnt="";
               
    		SessionDomain prtDomain = new SessionDomain();
            prtDomain = linkService.searchSsoPrtSessionAccount(domain);
                        
            if(prtDomain != null){
            	result = "y";
            	String compsDns="";
            	
            	if(("LOC000001").equals(empLocCode)){	//창원
            		compsDns = "/H cigma_c1.dnka.kr /D ";
                }else if(("LOC000002").equals(empLocCode)){	//홍성
                	compsDns = "/H cigma_h1.dnka.kr /D ";
                }else if(("LOC000003").equals(empLocCode)){	//화성
                	compsDns = "/H cigma_s1.dnka.kr /D ";
                }else if(("LOC000004").equals(empLocCode)){	//마산
                	compsDns = "/H cigma_db.dnke.kr /D ";
                }
            	prtParam1 = compsDns + prtDomain.getDevice1() + " /S";
            	prtParam2 = compsDns + prtDomain.getDevice2() + " /S";
            	sessionCnt = prtDomain.getDeviceCnt();
            	url ="http://dione.dnke.kr/sessionPrinterCheck.jsp?PrtSetup1='"+prtParam1+"'&PrtSetup2='"+prtParam2+"'&SessionCnt="+sessionCnt;
            	
           }else {
            	result = "w";
            }
   	 	}else if(systemNm.equals("dione")){
    		sysName = "dione";
   	 		if(empId !=null){
   	 			//System.out.println(empId);
            	url ="dione";
            	sysId = empId;
            	result = "y";
   	 		}else {
            	result = "w";
            }
   	 	}
    	//마이플렛폼 설치여부 체크
    	//System.out.println(request.getSession().getAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_SETUP));
    	//System.out.println(result);
    	if("y".equals(result)){
    		if("SUCCESS" != request.getSession().getAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_SETUP)){
      			result = "i";
      			urlSetup ="/WAN003MiPlatform/install.do";
      		}
    	}
    	jsonObj.put("result", result);
        jsonObj.put("url", url);
        jsonObj.put("urlSetup", urlSetup);	//마이플렛폼 설치페이지경로
    	jsonObj.put("sysId", sysId);	//세션ID
    	jsonObj.put("sessionParam", sessionParam);	//세션 파라미터
    	jsonObj.put("sysName", sysName);	//rlt 시스템구분
        
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    
    // dione계정 count 2019.01.25
    @RequestMapping(value = "/ssoSessionAccounts2", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ssoSessionAccounts2(HttpServletRequest request)  throws Exception {
            
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = "w"; //권한이 없는 경우
        String idPlant = "";
        
		int dioneAccount = 0;
        
        //System.out.println("ssoSessionAccounts2.do");
        //세션 저장된 데이터 불러오기
        String systemNm = ServletRequestUtils.getStringParameter(request, "systemNm");
		String sessionInfo = request.getSession().getAttribute("ACCOUNT").toString();
		
		JSONParser parser = new JSONParser();
		Object empInfoObj       = parser.parse(sessionInfo);
		JSONObject empJsonObj   = (JSONObject)empInfoObj;
		String empNumber        = (String)empJsonObj.get("uid");        //사용자 사번

		//LinkDomain domain = new LinkDomain();
		SessionDomain domain = new SessionDomain();
		List<SessionDomain> dioneAccountList = null;
		domain.setEmpNumber(empNumber);
    	if(systemNm.equals("disPlay")){
    		dioneAccountList  = linkService.searchDioneAccountCnt(domain);
    		

    		dioneAccount = dioneAccountList.size();
    		//System.out.println("dioneAccount==="+dioneAccount);
    		if(dioneAccount != 0){
    			if(dioneAccount == 1) {
    				for (SessionDomain dioneAccountDomain : dioneAccountList) {
    					if(("0").equals(dioneAccountDomain.getDeviceCnt())){
    			        	result = "w";
    					}else {
    						result = "y";
    						//idPlant +="dioneId::"+dioneAccountDomain.getEmpNumber()+"!companyCd::"+dioneAccountDomain.getOldCompany()+"!plantCd::"+dioneAccountDomain.getOldWorkPlace()+"||";    	    		
            	    		idPlant +="dioneId::"+dioneAccountDomain.getEmpNumber()+"!companyCd::"+dioneAccountDomain.getCompany()+"!plantCd::"+dioneAccountDomain.getWorkPlace()+"||";    	    		
            	    		//System.out.println("dioneAccount 1 :"+idPlant);
    					}
        	    	}
    			}else {
    				result = "y";
        			// DIONE ID 셋팅
        	    	for (SessionDomain dioneAccountDomain : dioneAccountList) {
        	    		//idPlant +="dioneId::"+dioneAccountDomain.getEmpNumber()+"!companyCd::"+dioneAccountDomain.getOldCompany()+"!plantCd::"+dioneAccountDomain.getOldWorkPlace()+"||";    	    		
        	    		idPlant +="dioneId::"+dioneAccountDomain.getEmpNumber()+"!companyCd::"+dioneAccountDomain.getCompany()+"!plantCd::"+dioneAccountDomain.getWorkPlace()+"||";    	    		
        	    	}
    	    		//System.out.println("dioneAccount 1이상 :"+idPlant);
    			}
    			//System.out.println("dioneAccount idPlant:"+idPlant);
	        } else {
	        	result = "w";
	        }
    	}
    	
    	jsonObj.put("result", result);
    	jsonObj.put("idPlant", idPlant);	//구디오네 ID별 공장코드
    	jsonObj.put("dioneAccount", dioneAccount);	//구디오네 ID 수
        
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
    /**
     * [KO] 협력업체용포탈 SSO 링크연결<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/ssoAccountsExternal", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ssoAccountsExternal(HttpServletRequest request)  throws Exception {
        
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = "n";
        String url = "";
        String sysId = "";
        String appType = "web";	//Application type구분
        String rltParam = "";	//CS용  리턴 파라미터 
        
        String systemSeq = ServletRequestUtils.getStringParameter(request, "systemSeq");
        String relationCopLoc = ServletRequestUtils.getStringParameter(request, "relationCompany");
        
        //세션 저장된 데이터 불러오기        
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();

		//System.out.println("sessionempInfo==="+empInfo+"relationCopLoc=="+relationCopLoc);
		
        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
        String empId        = (String)empJsonObj.get("empId");        //사용자 ID
        String teamCode         = (String)empJsonObj.get("teamCode");   //사용자 팀코드
        //String relationCopLoc          = (String)empJsonObj.get("relationCopLoc");    //협력업체 업무사업부
        String relationCopNo          = (String)empJsonObj.get("relationCopNo");    //협력업체 사업자번호
		
        
        String relComps= empId.substring(3, 4); //협력업체 사용자 ID의 사업부 구분
        String ssoComps="";
        String ssoClsCode="";
        
        //System.out.println("relComps=="+relComps);
        
        if(relComps.equals("e")){
        	ssoComps="PE";
        	ssoClsCode="CLS000002";
        	//System.out.println("ssoComps=="+ssoComps);
        }else{
        	ssoComps="PS";
        	ssoClsCode="CLS000001";
        	//System.out.println("ssoComps=="+ssoComps);
        }
               
        //세션 저장된 데이터 불러오기
        LinkDomain accounts = null;
        
        if (empInfo != null) { 
        	LinkDomain domain = new LinkDomain();
            domain.setSysSeq(systemSeq);
            //domain.setCompany(ssoComps);
            domain.setCompany(ssoClsCode);
        	 try {
                 //System.out.println("ssaccounts==systemSeq : "+domain.getSysSeq()+" ssoClsCode : "+domain.getCompany()); 
        		  accounts =  linkService.searchSsoUrl(domain);
                 //System.out.println("ssaccounts=="+accounts); 
             }catch (Exception e) {
                 System.out.println("데이터가 없습니다.");
//               e.printStackTrace();
             }	
        }else {
            result = "w";
        } 
        if(accounts != null){
            result = "y";
            if(accounts.getLoginYn().equals("Y")){
            	  url = accounts.getSysUrl();
            	  //SCM System(IE8에서만 정상작동, IE11, 크롬에서 로그인페이지는 열리나 자동로그인이 안됨)
                  if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_SCM)){
                	  if(ssoComps.equals("PE")){
                		  sysId = empId.substring(4);	//vpn id의 업체코드
                          url += "?comp=" + empId.substring(4).toUpperCase();	//vpn id의 업체코드 대문자
                          url += "&user_id=" + empId.toUpperCase()+"1";	//대문자 vpn id + 1 or 2
                          url += "&pwd=" + "V" +empId.substring(3).toUpperCase();	//V+대문자업체코드
                	  }else if(ssoComps.equals("PS")){
                		  //협력업체용PGM설치 후 사용가능함. 설치주소 : http://10.72.149.81:8080/CWORKS/Setup/SCM
                 		  //sysId = empId.toUpperCase()+"SEQ";	// 대문자 vpn id +"SEQ" -- 문서와 다름 재확인필요
                 		  //sysId = empId.substring(4).toUpperCase();
                 		  sysId = empId.substring(4).toLowerCase();
                          url = "http://10.72.149.81:8080/DNPSSTART/Default2.aspx";
                          //url = "http://fta.dnka.kr:8080/DNPSSTART/Default2.aspx";
                          url += "?id=" + sysId;
                          appType = "cs";
                	  } 
                  //FTA System
                  } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_FTA)){
                	  //구 버전인 경우
                	  // http://fta.dnke.kr/fta/index_sso.jsp + "?userID=" + sys_id + "&userPW=" + sys_pw
                	  if(!relationCopNo.equals(null)){
                		  //http://fta.densokorea.com/FTA_COM_MGMT/LogOnDenso?Corp_id=CORP_ID&UserName=ID&Password=PASSWORD
                		  url =  "http://fta.densokorea.com/FTA_COM_MGMT/LogOnDenso";
                		  String corpId="";
                		  if(ssoComps.equals("PE")){
                			  corpId="DNKE";
                		  }else{
                			  corpId="DNKA";
                		  }
                		  url += "?Corp_id=" + corpId;	//마산본사(DNKE), 창원,홍성,화성공장(DNKA)
                          url += "&UserName=" + relationCopNo;	//협력사 로그인 ID-사업자등록번호
                          url += "&Password=" + relationCopNo;	//협력사 로그인 비밀번호-초기패스워드는 사업자등록번호 
                	  }else{
                		  url = accounts.getSysUrl2();
                	  }
                   //MES System
                  } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_MES)){
                      //url += "?comp=" + accounts.getSystemGru();
                      //url += "&user_id=" + accounts.getSystemId();
                     // url += "&pwd=" + accounts.getSystemPw();
                	  /*System.out.println(System.getProperty("os.name"));
                	  System.out.println(System.getProperty("user.home"));
                	  
                	  String agent = request.getHeader("User-agent");
                	  String agent1 = request.getHeader("user-agent");
                	  String brower = null;
                	  String os = null;
                	  System.out.println(agent);
                	  System.out.println(agent1);
                	  if(agent != null){
                		  if(agent.indexOf("Trident") > -1){
                			  brower = "MSIE";
                		  }else if (agent.indexOf("Chrome") > -1) {
                		      brower = "Chrome";
                		  }else if (agent.indexOf("Firefox") > -1) {
                		      brower = "Firefox";
                		  }              		  
                	  }
                	  if(agent.indexOf("NT 6.1") != -1){
                		  os = "Windows 7";
                	  } 
                	  else  if(agent.indexOf("NT 5.1") != -1){
                		  os = "Windows XP";
                	  } 
                	  System.out.println("brower=="+brower+"os=="+os);
                	  request.getPathInfo();
                	  
                	  File file = new File("C:\\aa.txt");
            		  System.out.println("error==="+file.exists());*/
                	  if(ssoComps.equals("PE")){
                		  sysId = empId.substring(4).toUpperCase();	//vpn id의 업체코드
                		  if(relationCopLoc.equals("LOC000004")){
                			 //url =  "http://scm-mes.dnke.kr";	//SSO구현필요
                     		 // url =  "http://scm-mes.dnke.kr/ssoLogin.html?SiteReturnType=SiteReturnType&nUrlSite=1&nUserId="+sysId;	//SSO구현필요
                     		  url =  "http://scm-mes.dnke.kr/ssoLogin.html?pUrl=SiteReturnType!SiteReturnType#nUrlSite!1#nUserId!"+sysId;	//SSO구현필요 =->!, &=#
                     		  rltParam="E1";
                     		 //url =  "http://scm-mes.dnke.kr/SmartWeb/Login.aspx?SiteReturnType=SiteReturnType&nUrlSite=DNKE&nUserId="+sysId;	//SSO구현필요
                    	  }else {
                              result = "w";
                          }
                	  }else if(ssoComps.equals("PS")){
                		  sysId = empId.substring(4).toUpperCase();	// vpn id의 업체코드
                		  if(relationCopLoc.equals("LOC000002")){
                    		  //url =  "http://mes-h1.dnka.kr";	//SSO구현필요
                    		  //url =  "http://mes-h1.dnka.kr/SmartWeb/Login.aspx?SiteReturnType=SiteReturnType&nUrlSite=1&nUserId="+sysId;	//SSO구현필요
                    		  //url =  "http://mes-h1.dnka.kr/ssoLogin.html?SiteReturnType=SiteReturnType&nUrlSite=1&nUserId="+sysId;	//SSO구현필요
                    		  url =  "http://mes-h1.dnka.kr/ssoLogin.html?pUrl=SiteReturnType!SiteReturnType#nUrlSite!1#nUserId!"+sysId;	//SSO구현필요 =->!, &=#
                    		  rltParam="H1";
                    	  }else if(relationCopLoc.equals("LOC000001")){
                        	  //mesParam=" -siteId:mes-c1.densops.co.kr -factory:DNP1 -userId:"+sysId+" -password:"+1;
                    		  //rltParam=" -siteId:MPT1 -serverAddress:10.72.149.98 -factory:DNP1 -userId:"+sysId+" -password:";
                    		  rltParam=" -siteId:OSP1 -serverAddress:10.72.149.98 -factory:DNP1 -userId:"+sysId+" -password:";
                        	  appType = "cs";
                    	  }else if(relationCopLoc.equals("LOC000003")){
                        	  //mesParam=" -siteId:mes-c1.densops.co.kr -factory:DNP1 -userId:"+sysId+" -password:"+1;
                    		  //rltParam=" -siteId:MPT1 -serverAddress:10.72.149.98 -factory:DNP1 -userId:"+sysId+" -password:";
                    		  rltParam=" -siteId:DNS1 -serverAddress:10.73.207.11 -factory:DNS1 -userId:"+sysId+" -password:";
                        	  appType = "cs";
                    	  }else {
                              result = "w";
                          }
                	  }else {
                          result = "w";
                      }
                   //TQMS System
                  } else if(systemSeq.equals(DnkrDb2Constans.SYSTEM_SEQ_TQMS)){	//초기패스워드 : 1
                	  if(ssoComps.equals("PE")){
                		  sysId = empId.substring(4);	//vpn id의 업체코드
                	  }else if(ssoComps.equals("PS")){
                		  sysId = empId.substring(3);	// c + vpn id의 업체코드
                	  }
                	  //1)디오네 SSO방식
                	  //http://tqms.dnke.kr/index.aspx?gw=y&id=g23	//주소보임
                	  //url += "?gw=y"+"&id=" + sysId; //주소보임
                	  //2)신방식
                	  //http://tqms.dnke.kr/Login.aspx?ReturnUrl=index.aspx&gw=y&id=g23//주소안보임
                     // url = "http://tqms.dnke.kr/Login.aspx?ReturnUrl=index.aspx"+"&gw=y"+"&id=" + sysId; //주소안보임                  
                      url += "&gw=y"+"&id=" + sysId; //주소안보임 
                  }
            }
            else {
                url = accounts.getSysUrl2();
            }
        } 
        //System.out.println("url:" + url);
        jsonObj.put("result", result);
        jsonObj.put("url", url);
        jsonObj.put("appType", appType);	//application type
        jsonObj.put("rltParam", rltParam);	//CS용  리턴 파라미터 
       
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
}
