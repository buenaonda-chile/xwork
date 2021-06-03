/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller;

import java.util.ArrayList;
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

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.BkmkService;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.constant.AiSampleConstants;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.constant.DnkrDb2Constans;
import com.globaldenso.dnkr.domain.BkmkDomain;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.MenuDomain;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.presentation.filter.SiteMinderFilter;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [EN] The class defines the controls of Menu (WA0000).<br>
 * [JP] WA0000 基本機能メニュー画面の制御を定義するクラス。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAA000Sub")
@ViewId(value = "WAA000")
public class WAA000SubController {
    
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
     * [KR] 공통코드관리 서비스 <br>          
     */
    @Autowired
    private CodeService codeService;
    
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
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAA000SubController() {
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
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request, HttpServletResponse response, 
        @CookieValue("locallocale") Optional<String> locale)  throws Exception {
        Locale newLocale;
        String paraLocale;
        
      //세션 저장된 데이터 불러오기
        request.getSession().getAttribute("ACCOUNT");
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();

        JSONParser parser = new JSONParser();
        Object empInfoObj = parser.parse(empInfo);
        JSONObject empJsonObj = (JSONObject)empInfoObj;
        String empName = (String)empJsonObj.get("empName"); //사용자명

        paraLocale = request.getParameter("locale");
        
        try{
            if (paraLocale == null) {
                if((locale.orElse(DensoContext.get().getLocale().getLanguage())) != null && (locale.orElse(DensoContext.get().getLocale().getLanguage())).equals("ko")){
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

        //세션이 없으면 쿠키굽기
        HttpSession session = request.getSession(false);
        if (session != null) {
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
        
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String pType = ServletRequestUtils.getStringParameter(request, "pType");
        //System.out.println("menu:" + menu);
        
        Map<String, Integer> map = (Map)request.getSession().getAttribute("menuMap");
        
        List<MenuDomain> menuList = getMenuList(map);
        
        mv.addObject("menuList", menuList);
        mv.addObject("empName", empName);
        mv.addObject("menu", menu);
        mv.addObject("pType", pType);
        
        
      //즐겨찾기 불러오기
        BkmkDomain domain = new BkmkDomain();
        domain.setEmpNumber(UxisCmmUtil.getSessionData(request, "uid"));
        domain.setLangCmc(DensoContext.get().getLocale().getLanguage());
        List<BkmkDomain> bkmkList = bkmkService.searchByCondition(domain);

        mv.addObject("bkmkList", bkmkList);
        mv.setViewName(".tiles.page.WAA000");
        return mv;
        
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
    @RequestMapping(value = "/addCert", method = RequestMethod.GET)
    public ModelAndView addCert(HttpServletRequest request, HttpServletResponse response, 
        @CookieValue("locallocale") Optional<String> locale)  throws Exception {
        Locale newLocale;
        String paraLocale;
        
      //세션 저장된 데이터 불러오기
        request.getSession().getAttribute("ACCOUNT");
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();

        JSONParser parser = new JSONParser();
        Object empInfoObj = parser.parse(empInfo);
        JSONObject empJsonObj = (JSONObject)empInfoObj;
        String empName = (String)empJsonObj.get("empName"); //사용자명

        paraLocale = request.getParameter("locale");
        
        try{
            if (paraLocale == null) {
                if((locale.orElse(DensoContext.get().getLocale().getLanguage())) != null && (locale.orElse(DensoContext.get().getLocale().getLanguage())).equals("ko")){
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

        //세션이 없으면 쿠키굽기
        HttpSession session = request.getSession(false);
        if (session != null) {
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
        
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String pType = ServletRequestUtils.getStringParameter(request, "pType");
       
        //System.out.println("menu:" + menu);
        
        Map<String, Integer> map = (Map)request.getSession().getAttribute("menuMap");
        
        List<MenuDomain> menuList = getMenuList(map);
        
        String menunum = request.getParameter("menu");
        
        mv.addObject("menuList", menuList);
        mv.addObject("empName", empName);
        mv.addObject("menu", menu);
        mv.addObject("pType", pType);
        mv.addObject("menunum",menunum);
        
        
      //즐겨찾기 불러오기
        BkmkDomain domain = new BkmkDomain();
        domain.setEmpNumber(UxisCmmUtil.getSessionData(request, "uid"));
        domain.setLangCmc(DensoContext.get().getLocale().getLanguage());
        List<BkmkDomain> bkmkList = bkmkService.searchByCondition(domain);

        mv.addObject("bkmkList", bkmkList);
        mv.setViewName(".tiles.page.addCert");
        return mv;
        
    }
    
    @RequestMapping(value = "/addCert", method = RequestMethod.POST)
    public ModelAndView addCertCheck(HttpServletRequest request, HttpServletResponse response)  throws Exception {
    	
    	
    	EmpDomain emp = new EmpDomain();        
    	emp.setEmpId(request.getParameter("userid"));
        emp.setEmpPwd(request.getParameter("userpass"));
        
        SiteMinderFilter filter= new SiteMinderFilter();
        String result = filter.checkLoginLdap(request,emp);
        
        ModelAndView mv = new ModelAndView();
        
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String pType = ServletRequestUtils.getStringParameter(request, "pType");
        //System.out.println("menu:" + menu);
        
        Map<String, Integer> map = (Map)request.getSession().getAttribute("menuMap");
        
        List<MenuDomain> menuList = getMenuList(map);
        
        mv.addObject("menuList", menuList);
        mv.addObject("menu", menu);
        mv.addObject("pType", pType);
        
        if(result.equals("Y")){
        	 mv.setViewName("redirect:init.do");
        }else{
        	mv.setViewName("redirect:addCert.do");
        }
 
        return mv;
    }
    
    
    
    /**
     * [EN] I will create a Cookie .
     * [JP] 指定された名前、値のCookieを作成します。
     * 
     * @param request [EN] HTTP request [JP] HTTPリクエスト
     * @param name [EN] The name of the Cookie [JP] Cookieの名前
     * @param newvalue [EN] The value of the Cookie [JP] Cookieの値
     * @return [EN] Cookie object you created [JP] 作成したCookieオブジェクト
     *//*
    private Cookie makeCookie(
            HttpServletRequest request, 
            String name, 
            String newvalue) {
        
        Cookie cookie = null;
        
        *//**
         * <pre>
         * 1.[EN] Cookie making processing.
         *   [EN]   I make a cookie with the appointed name, value. 
         *   [JP] クッキー作成処理
         *   [JP]   ・指定された名前、値でクッキーを作成する
         *   [JP]   ・作成したクッキーに有効期限を設定する
         *   [JP]   ・作成したクッキーのパスを設定する
         * </pre>
         *//*
        
        try {
            cookie = new Cookie(name, URLEncoder.encode(newvalue, request.getCharacterEncoding()));
            cookie.setMaxAge(COOKIE_EXPIRATION_DATE3);
            //System.out.println(" cookie path  : " + request.getContextPath());
            cookie.setPath("/");
        } catch (UnsupportedEncodingException e) {
            throw new SystemException(e);
        }
        
        return cookie;
        
    }*/
    
    /**
     * 
     * @param map           Map<String,Integer>
     * @return              List<MenuDomain>
     * @throws Exception 
     */
    public List<MenuDomain> getMenuList(Map<String, Integer> map)  throws Exception {
        MenuDomain domain = new MenuDomain();

        domain.setLangCmc(DensoContext.get().getLocale().getLanguage());
        domain.setMcdUse("Y");  //사용하는 메뉴만 가져오기
        //System.out.println("AjaxMenu/init.do");
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
                                tempSubMenuList = menuService.searchByCondition(tempSubMenuDomain); //라스트서브 도메인리스트

                                //last sub메뉴 도메인 추가
                                for(MenuDomain lastSubDomain:tempSubMenuList) {//서브도메인에 라스트서브도메인 추가
                                    if(map.containsKey(lastSubDomain.getMcdCode())){
                                        subDomain.setSubList(lastSubDomain);
                                    }
                                }
                            }

                            //슈퍼도메인이 아니면 슈퍼도메인에 서브도메인 추가
                            if(subDomain.getMcdDepth() != 1  && map.containsKey(subDomain.getMcdCode())){
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
