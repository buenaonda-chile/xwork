/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.filter;

import static java.util.Arrays.asList;
import static org.springframework.web.context.WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.LogService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.LogDomain;
import com.globaldenso.dnkr.uxis.ShaEncryptUtils;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [EN] The filter used to authenticate users. It provides functionality similar <br>
 * [EN] to the SiteMinder artificially.<br>
 * [JP] ユーザ認証を行うためのフィルタです。擬似的に SiteMinder と同様の機能を提供します。<br>
 * 
 * 
 * <p>
 * [EN] This filter works as follows.
 * </p>
 * <ul>
 * <li>[EN] And SiteMinderFilter flag is enabled, if it is not the transition to the filter excluded
 * <ul>
 * <li>[EN] If authenticated
 * <p>
 * [EN] I will continue to subsequent processing.
 * </p>
 * <li>[EN] If an unauthenticated
 * <ul>
 * <li>[EN] For GET requests
 * <p>
 * [EN] I display the login screen.
 * </p>
 * <li>[EN] For POST requests
 * <p>
 * [EN] If it matches the account that exists in the user information management table DSC-ID, 
 * [EN] the password entered in the login screen, you can set the session authentication result, 
 * [EN] set in the request header DSC-ID, for the login process to force the word.
 * <p>
 * <p>
 * [EN] If they do not match, set to Cookie the number of attempts to re-display the login screen.
 * </p>
 * <p>
 * [EN] In addition, (for example, DSC-ID, password, even if correctly), 
 * [EN] to re-display the login screen if you have exceeded the maximum number of authentication.
 * </p>
 * </ul>
 * </ul>
 * <li>[EN] Otherwise
 * <p>
 * [EN] It does nothing, and continue processing subsequent. (Authentication, I leave to SiteMinder real)
 * </p>
 * </ul>
 * 
 * 
 * <p>
 * [JP] このフィルタは次のように動作します。
 * </p>
 * <ul>
 * <li>[JP] SiteMinderFilterフラグが有効でかつ、フィルタ対象外への遷移でない場合
 * <ul>
 * <li>[JP] 認証済みの場合
 * <p>
 * [JP] 後続の処理を継続する。
 * </p>
 * <li>[JP] 未認証の場合
 * <ul>
 * <li>[JP] GETリクエストの場合
 * <p>
 * [JP] ログイン画面を表示する。
 * </p>
 * <li>[JP] POSTリクエストの場合
 * <p>
 * [JP] ログイン画面で入力されたDSC-ID、パスワードがユーザ情報管理テーブルに存在するアカウントと一致すれば、 認証結果をセッションにセットし、
 * [JP] DSC-IDをリクエストヘッダにセットし、強制的にログイン処理へフォーワードする。
 * <p>
 * <p>
 * [JP] 一致しなければ、試行回数をCookieに設定して、ログイン画面を再表示する。
 * </p>
 * <p>
 * [JP] また、最大認証回数を超えていた場合は(たとえ、DSC-ID、パスワードが正しくても)、 ログイン画面を再表示する。
 * </p>
 * </ul>
 * </ul>
 * <li>[JP] 上記以外の場合
 * <p>
 * [JP] 何もせず、後続の処理を継続する。(認証は、本物のSiteMinderに任せる)
 * </p>
 * </ul>
 * 
 * 
 * <pre>
 * &lt;conetxt-param&gt;
 *   &lt;param-name&gt;siteMinderFilterEnabled&lt;/param-name&gt;
 *   &lt;param-value&gt;true&lt;/param-value&gt;
 * &lt;/context-param&gt;
 * </pre>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class SiteMinderFilter implements Filter {
    
    /**
     * [EN] SiteMinder FCC path of file to display on the login screen.<br>
     * [JP] ログイン画面で表示する SiteMinder FCC ファイルのパス。<br>
     */
    private static final String LOGIN_FCC_PATH = "/WEB-INF/login.fcc";
    
    /**
     * [EN] SiteMinder FCC path of file to display on the login screen.<br>
     * [JP] ログイン画面で表示する SiteMinder FCC ファイルのパス。<br>
     */
    private static final String LOGIN_FCC_M_PATH = "/WEB-INF/loginM.fcc";
    
    /**
     * [EN] URI of the login process.<br>
     * [JP] ログイン処理のURI。<br>
     */
    private static final String LOGIN_URI = "/index.jsp";
    
    /**
     * [EN] Default locale.<br>
     * [JP] デフォルトロケール。<br>
     */
    private static final String DEFAULT_LOCALE = "ja";
    
    /**
     * [EN] Maximum number of authentication.<br>
     * [JP] 最大認証回数。<br>
     */
    private static final int MAX_TRY_NO = 50000;
    
    /**
     * [EN] Context parameter key: filter enabled flag.<br>
     * [JP] コンテキストパラメータキー：フィルタ有効フラグ。<br>
     */
    private static final String PARAM_KEY_ENABLED = "siteMinderFilterEnabled";
    
    /**
     * [EN] Context parameter key: filter excluded URI.<br>
     * [JP] コンテキストパラメータキー：フィルタ処理対象外URI。<br>
     */
    private static final String PARAM_KEY_EXCEPTED_URI = "exceptedURI";
    
    /**
     * [EN] Session key: Authentication flag.<br>
     * [JP] セッションキー：認証済みフラグ。<br>
     */
    private static final String ATTRIB_KEY_AUTHENTICATED = "AUTHENTICATED";
    
    /**
     * [EN] Session key: account information.<br>
     * [JP] セッションキー：アカウント情報。<br>
     */
    private static final String ATTRIB_KEY_ACCOUNT = "ACCOUNT";
    
    private static final String ATTRIB_KEY_EMPDOMAIN = "EMP_DOMAIN";
    
    /**
     * [EN] Session key: account information.<br>
     * [JP] セッションキー：アカウント情報。<br>
     */
    private static final String ATTRIB_KEY_ACCOUNT_DB2 = "ACCOUNT_DB2";
    
    /**
     * [EN] SiteMinder key information: user ID.<br>
     * [JP] SiteMinder 情報キー：ユーザID。<br>
     */
    private static final String ATTRIB_KEY_USER = "USER";
    
    /**
     * [EN] SiteMinder key information: password.<br>
     * [JP] SiteMinder 情報キー：パスワード。<br>
     */
    private static final String ATTRIB_KEY_PASSWORD = "PASSWORD";
    
    /**
     * [EN] SiteMinder key information: browser locale.<br>
     * [JP] SiteMinder 情報キー：ブラウザロケール。<br>
     */
    private static final String ATTRIB_KEY_LOCALE = "LOCALE";
    
    /**
     * [EN] SiteMinder key information: login try count.<br>
     * [JP] SiteMinder 情報キー：ログイン試行回数。<br>
     */
    private static final String ATTRIB_KEY_TRY_NO = "SMTRYNO";
    
    /**
     * [EN] SiteMinder key information: ldap Check.  //JHB 2020.04.17<br>
     * [JP] SiteMinder 情報キー：ログイン試行回数。<br>
     */
    private static final String ATTRIB_KEY_LDAP_CHECK = "LDAP_CHECK";
    
    /**
     * [EN] Servlet context.<br>
     * [JP] サーブレット・コンテキスト。<br>
     */
    private ServletContext context = null;
    
    /**
     * [EN] User Information Service.<br>
     * [JP] ユーザ情報サービス。<br>
     */
//    private EmpService_ userInfoService = null;
    @Autowired
//    private EmpService userInfoService = null;
    private EmpService userInfoService;
    
    /**
     * [EN] Log Information Service.<br>
     * [JP] ユーザ情報サービス。<br>
     */
    @Autowired
    private LogService logService;
    
    /**
     * [EN] This is a flag whether or not to use the SiteMinderFilter. <br>
     * [JP] SiteMinderFilterを使用するかどうかのフラグです。<br>
     * <p>
     * [EN] I hold to enable/disable the filter. <br>
     * [EN] (true:I use. false:do not use.)<br>
     * [EN] In web.xml, I define as a context parameter <b>"siteMinderFilterEnabled"</b> setting.<br>
     * <br>
     * [JP] フィルタの有効／無効を保持します。<br>
     * [JP] (true:使用する。false:使用しない。)<br>
     * [JP] 設定は web.xml にコンテキストパラメータ <b>"siteMinderFilterEnabled"</b> として定義します。
     * </p>
     */
    private boolean siteMinderFilterEnabled = false;
    
    /**
     * [EN] This screen is used to exclude filtering.<br>
     * [JP] フィルター処理を除外する画面です。<br>
     * <p>
     * [EN] Keep a list of path names to get the servlet path( {@link HttpServletRequest#getServletPath() }, <br>
     * [EN] the path screen that you want to exclude the processing.<br>
     * [EN] Specifying the screen is defined as the initialization parameter <b>"exceptedURI"</b> in web.xml. <br>
     * [EN] If you want to specify more than one, specify a comma-separated list. <br>
     * <br>
     * [JP] 処理を除外したい画面パスを、サーブレットパス ( {@link HttpServletRequest#getServletPath() }で取得するパス名) でリストで保持します。<br>
     * [JP] 画面の指定は web.xml に初期化パラメータ <b>"exceptedURI"</b> として定義します。<br>
     * [JP] 複数指定する場合は、カンマ区切りで指定します。<br>
     * </p>
     */
    private List<String> exceptedURIList = new ArrayList<String>(asList(PARAM_KEY_EXCEPTED_URI));
    
    
    //private HashMap<String, String> ldapErrorMap
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public SiteMinderFilter() {
        // no process
    }
    
    
    
    /**
     * {@inheritDoc}
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
        
        //System.out.println("=====  siteMinderFilter init");

        // [EN] I to get each initial information.
        // [JP] 初期情報を取得。
        this.context = config.getServletContext();
        
        // [EN] siteMinderFilter valid flag
        // [JP] siteMinderFilter 有効フラグを取得
        String strEnabled = this.context.getInitParameter(PARAM_KEY_ENABLED);
        if ("true".equals(strEnabled)) {
            this.siteMinderFilterEnabled = true;
        } else {
            this.siteMinderFilterEnabled = false;
        }
        
        // [EN] Filtering excluded screen
        // [JP] フィルター対象の画面を取得
        String exceptedURI = config.getInitParameter(PARAM_KEY_EXCEPTED_URI);
        if (StringUtils.isNotEmpty(exceptedURI)) {
            exceptedURIList.addAll(asList(exceptedURI.split(",")));
        }
        
        // XXX:【If you want to modify the SiteMinderFilter to PJ for 1】
        // ========================================================================
        // [EN] Because using EmpService, and correct.
        // [JP] EmpServiceを使用しているので、修正します。
        // ========================================================================
        // [EN] Search user Bean
        // [JP] ユーザー検索Beanを取得
//        userInfoService = (EmpService_) getBean(config.getServletContext(), "empService_");
        userInfoService = (EmpService) getBean(config.getServletContext(), "empService");
        logService = (LogService) getBean(config.getServletContext(), "logService");
        
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        // no process
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
     * @see {@link #doFilter(HttpServletRequest, HttpServletResponse, FilterChain)}
     */
    public void doFilter(
            ServletRequest request, 
            ServletResponse response, 
            FilterChain chain) throws 
            IOException, ServletException {
        doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
    }
    
    /**
     * [EN] When authenticating control similar to the SiteMinder.<br>
     * [JP] SiteMinderと同様の認証制御を行います。<br>
     * 
     * @param request HTTP Request
     * @param response HTTP Response
     * @param chain Filter Chain
     * @throws IOException I/O Exception
     * @throws ServletException Servlet Exception
     */
    protected void doFilter(
            HttpServletRequest request, 
            HttpServletResponse response,
            FilterChain chain) throws 
            IOException, ServletException {

        // [EN] If you are using a SiteMinderFilter
        // [JP] SiteMinderFilterを使用しているか？
        //System.out.println("request getServletPath : "+request.getServletPath());
        //System.out.println(!isExceptedURI(request.getServletPath()));
        if (this.siteMinderFilterEnabled && !isExceptedURI(request.getServletPath())) {
            
            if (isAuthenticated(request)) {
                // [EN] If already authenticated, continue to process subsequent (development environment)
                // [JP] 認証済みのとき、処理を続行する(開発環境用)
            
                chain.doFilter(new SiteMinderRequestWrapper(request), response);
                
                //==== 로그 insert 부분 ==========
                String menu = request.getParameter("menu");
                String uri = request.getRequestURI();
                
                if(menu != null && !"".equals(menu) && uri.substring( uri.length() - 3, uri.length()).equals(".do")) {
                    try {
                        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
                        JSONParser parser = new JSONParser();
                        Object empInfoObj = parser.parse(empInfo);
                        JSONObject empJsonObj = (JSONObject)empInfoObj;
                        String empNumber = (String)empJsonObj.get("uid");   //사용자 아이디

                        
                        
                        EmpDomain setEmp = new EmpDomain();
                        EmpDomain getEmp = null;
                        setEmp.setEmpNumber(empNumber);
                        getEmp = userInfoService.searchByKey(setEmp);
                        
                        
                        LogDomain logDomain = new LogDomain();
                        logDomain.setLogId(getEmp.getEmpId());
                        logDomain.setEmpNumber(empNumber);
                        logDomain.setMcdCode(menu);
                        logDomain.setLogIp(request.getRemoteAddr());
                        logDomain.setLogUri(request.getRequestURI());

                        try{
                            logService.create(logDomain);
                        }catch(Exception e) {
                            e.printStackTrace();
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
/*
                if(uri != null) {
	                if(menu != null && uri.split("/")[1].equals("WAN001MiPlatform")) {
	                	String mInstallTf ="";
	                    System.out.println("여기다가 개발하시오~!!");
	                }
                }
*/
              //==== //로그 insert 끝  ==========
            } else {
                // [EN] If an unauthenticated
                // [JP] 未認証のとき
                if (request.getMethod().equals("GET")) {
                    // [EN] For GET requests, display the login screen
                    // [JP] リクエストがGETのとき、ログイン画面表示
                    renderLoginPage(request, response, chain, 0);
                } else if (!doAuthenticate(request)) {
                    // [EN] For authentication NG, display the login screen
                    // [JP] 認証がNGのとき、ログイン画面表示
                    renderLoginPage(request, response, chain, getTryNo(request) + 1);
                } else {
                    // [EN] For authentication OK, run the login process
                    // [JP] 認証がOKのとき、ログイン処理を実行
                    doForward(LOGIN_URI, request, response);
                }
                
            }
            
        } else {
            // [EN] If you do not want to use the SiteMinderFilter, continue to subsequent processing
            // [JP] SiteMinderFilterを使用しないとき、処理を続行する 
            chain.doFilter(request, response);
        }
        
    }
    
    /**
     * [EN] I authenticates user ID, ​​and password.<br>
     * [JP] ユーザID、パスワードを認証します。<br>
     * 
     * @param request HTTP Servlet Request
     * @return boolean (true: authenticated OK false: authenticated NG)
     */
    private boolean doAuthenticate(HttpServletRequest request) {

        // [EN] Exceeding the maximum number of authentication
        // [JP] リトライ回数が認証回数上限か？
        if (MAX_TRY_NO <= getTryNo(request)) {
            return false;
        }
        
        // XXX:【If you want to modify the SiteMinderFilter to PJ for 2】
        // ========================================================================
        // [EN] Because using EmpService, and correct.
        // [JP] EmpServiceを使用しているので、修正します。
        // ========================================================================
        // [EN] Get user ID, ​​and password
        // [JP] ユーザーID、パスワードを取得
       
        String empId = request.getParameter(ATTRIB_KEY_USER);
        String pass  = request.getParameter(ATTRIB_KEY_PASSWORD);
        String inOutType = request.getParameter("type");
//        String tempLocale = request.getParameter(ATTRIB_KEY_LOCALE);
        
        EmpDomain criteria = new EmpDomain();
        criteria.setEmpId(empId);
        //criteria.setEmpPwd(ShaEncryptUtils.encrypt(pass));
        criteria.setInOutType(inOutType);
 
        EmpDomain empDomain = null;
        EmpDb2Domain db2Domain = null;
        try {
            if("I".equals(inOutType)){
            	criteria.setEmpId(empId.toUpperCase());
                criteria.setEmpPwd(pass);
                String rtnFlag = "N";

                if(criteria.getEmpId().equals(DnkrConstans.SYSTEM_MANAGER.toUpperCase())){
                	criteria.setEmpPwd(ShaEncryptUtils.encrypt(pass));
                    rtnFlag = "Y";
                }else{
                    rtnFlag = checkLoginLdap(request, criteria);                	
                    //rtnFlag = "Y";	//개발자환경(실환경시 주석처리)
                }

                //ldap 로그인 성공일 시
                request.getSession().setAttribute(ATTRIB_KEY_LDAP_CHECK, rtnFlag);	//LDAP 상태체크 - 2020.04.17(JHB)
                //System.out.println("rtnFlag : "+rtnFlag);
                
				if(rtnFlag.equals("Y")){
                    //empDomain = userInfoService.searchById(criteria);	///GCI전환으로 로직변경필요 

					//Gci-AD Login ID 임시대응 Start : Login(empId → empNumber)
					//System.out.println("criteria==="+criteria);
					String tempEmpNumber = empId.substring(0,5);
			        if("40004".equals(tempEmpNumber)) {
			        	criteria.setEmpId("");
			        	criteria.setEmpNumber(empId.substring(5).toUpperCase());
			        }else {
			        	criteria.setEmpId("");
			        	criteria.setEmpNumber(empId.substring(1).toUpperCase());
			        }
			        System.out.println(criteria.getEmpNumber());
					//System.out.println("criteria==="+criteria);
                    empDomain = userInfoService.searchById(criteria);	///GCI전환으로 로직변경필요 
					//System.out.println("empDomain==="+empDomain);
					//Gci-AD Login ID 임시대응 End : Login(empId → empNumber)

                  //DB2 사원정보 가져오기
                    db2Domain = new EmpDb2Domain();
                    if(criteria.getEmpId().equals(DnkrConstans.SYSTEM_MANAGER.toUpperCase())){
                        empDomain.setInOutType("I");
                        db2Domain.setUserId(DnkrConstans.I_SYSTEM_MANAGER);
                    } else {
                        db2Domain.setUserId(empId.toUpperCase());
                    }
                    db2Domain = userInfoService.searchByDb2Id(db2Domain);
                } else {
                	//System.out.println("NG");
                	return false;
//                    System.out.println("데이터를 받아오지 못했습니다.");
                }
                
				 /*
                // JHB수정 - 사업부 이동자를 위한 ID재셋팅
                if(rtnFlag.equals("Y")){
                	int count = 0;
                		count  = userInfoService.searchCount(criteria);
                	if(count != 0){
                		empDomain = userInfoService.searchById(criteria);
                	}else{//Ldap에 성공한 경우 사업부이동으로 ID가 없는 경우 사번으로 조회하여 ID 재셋팅
                		criteria.setEmpNumber(empId.substring(1));
                		empDomain = userInfoService.searchByIdLdap(criteria);
                		
                        System.out.println(empId+"==="+empDomain.getEmpId()+"==="+criteria.getEmpId());                        
                		//empId=empDomain.getEmpId();
                        criteria.setEmpId(empId);
                	}
                	//System.out.println(criteria.getEmpId());
                  //DB2 사원정보 가져오기
                    db2Domain = new EmpDb2Domain();
                    if(criteria.getEmpId().equals(DnkrConstans.SYSTEM_MANAGER.toUpperCase())){
                        empDomain.setInOutType("I");
                        db2Domain.setUserId(DnkrConstans.I_SYSTEM_MANAGER);
                    } else {
                        db2Domain.setUserId(empId.toUpperCase());
                    }
                    db2Domain = userInfoService.searchByDb2Id(db2Domain);
                    System.out.println(db2Domain.getUserId());
                    //
                } else {
                	return false;
//                    System.out.println("데이터를 받아오지 못했습니다.");
                }
                */
            //외부직원
            }else if("O".equals(inOutType)){
                request.getSession().setAttribute(ATTRIB_KEY_LDAP_CHECK, "XX");	//LDAP 상태체크 - 2020.04.17(JHB)
                // [EN] User search
                // [JP] ユーザー検索
                criteria.setEmpPwd(ShaEncryptUtils.encrypt(pass));
                empDomain = userInfoService.searchById(criteria);
                if(empId.equals(DnkrConstans.SYSTEM_MANAGER)){
                    empDomain.setInOutType("O");
                }
                
                
            } 
            
            LogDomain logDomain = new LogDomain();
            logDomain.setLogId(empDomain.getEmpId());
            logDomain.setEmpNumber(empDomain.getEmpNumber());
            logDomain.setMcdCode(request.getParameter("menu"));
            logDomain.setLogIp(request.getRemoteAddr());
            logDomain.setLogUri(request.getRequestURI());

            try{
                logService.create(logDomain);
            }catch(Exception e) {
                e.printStackTrace();
            }
            
        } catch (ApplicationException e) {
            System.out.println(e.getMessage());
            // [EN] If an error occurs, authentication NG
            // [JP] 例外が発生した時は、後に認証NGとする。
            //e.printStackTrace();
        } catch (Exception e) {
            System.out.println("존재하지 않는 사번입니다." +empId+"=="+ e.getMessage());
            //e.printStackTrace();
        }
        
        // XXX:【If you want to modify the SiteMinderFilter to PJ for 3】
        // ========================================================================
        // And we have already done the password verification in place below, and correct it.
        // （I have checked with a fixed "password" currently）
        // ========================================================================
        // ex) String pass = domain.getPassword();
        
//        String pass = "password";
        
        // [EN] User authentication
        // [JP] ユーザー認証
        if (empDomain != null && empDomain.getInOutType().equals("O") || empDomain != null ) {
            
            // [EN] Get an account
            // [JP] アカウント情報を取得
            Account account = new Account(empDomain);
            
            // [EN] User ID, ​​password is correct, it is marked as authenticated
            // [JP] ユーザーIDとパスワードが正しければ、認証済みとしてマークする
            request.getSession().setAttribute(ATTRIB_KEY_AUTHENTICATED, true);
            request.getSession().setAttribute(ATTRIB_KEY_ACCOUNT, account);
            if (db2Domain != null) {
            	// DB2조회 로직 수정필요
                request.getSession().setAttribute(ATTRIB_KEY_ACCOUNT_DB2, db2Domain);
            }
            
            if (empDomain != null) {
                request.getSession().setAttribute(ATTRIB_KEY_EMPDOMAIN, empDomain);
            }
            return true;
            
        } else {
            return false;
        }
        
    }
    
    /**
     * [EN] I will output the login screen.<br>
     * [JP] ログイン画面を出力します。<br>
     * 
     * @param request HTTP Request
     * @param response HTTP Response
     * @param chain Filter Chain
     * @param tryNo Number of trials
     * @throws IOException I/O Exception
     * @throws ServletException Servlet Exception
     */
    private void renderLoginPage(
            HttpServletRequest request, 
            HttpServletResponse response,
            FilterChain chain, 
            int tryNo) throws 
            IOException, ServletException {
        
        //모바일 체크
        Boolean checkMobile = UxisUtil.isMobile(request);
        // [EN] Setting character code, the Content-Type
        // [JP] 文字コードを設定
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        // [EN] Setting the number of trials
        // [JP] 試行回数を設定
        if (0 < tryNo) {
            response.addCookie(new Cookie(ATTRIB_KEY_TRY_NO, Integer.toString(tryNo)));
            response.addCookie(new Cookie(ATTRIB_KEY_AUTHENTICATED, DnkrConstans.RESULT_N));
            response.addCookie(new Cookie(ATTRIB_KEY_LDAP_CHECK,  request.getSession().getAttribute("LDAP_CHECK").toString()));	//LDAP 상태체크 - 2020.04.17(JHB)      
        }
        
        BufferedReader reader = null;
        PrintWriter writer = null;
        
        try {
            
            // [EN] SiteMinder FCC file reading.
            // [JP] SiteMinder FCC ファイル読込
            if(checkMobile) {
                reader = new BufferedReader(
                    new InputStreamReader(context.getResourceAsStream(LOGIN_FCC_M_PATH), "UTF-8"));
            } else {
                reader = new BufferedReader(
                    new InputStreamReader(context.getResourceAsStream(LOGIN_FCC_PATH), "UTF-8"));
            }
            
            writer = response.getWriter();
            
            String line = null;
            boolean skip = true;
            
            // [EN] The output of the login screen
            // [JP] ログイン画面を出力
            while ((line = reader.readLine()) != null) {
                
                // [EN] No output for comments SiteMinder for the beginning of the file
                // [JP] ファイルの先頭部分はSiteMinder向けのコメントのため出力しない
                if (line.startsWith("<!DOCTYPE") || line.startsWith("<html>")) {
                    skip = false;
                }
                
                if (!skip) {
                    writer.println(line);
                }
                
            }
            
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
        
    }
    
    /**
     * [EN] The transition to a URI that is specified using the RequestDispatcher.<br>
     * [JP] RequestDispatcher を使用して指定されたURIへ遷移します。<br>
     * 
     * @param uri Context-relative path
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws IOException I/O Exception
     * @throws ServletException Servlet Exception
     */
    private void doForward(
            String uri, 
            HttpServletRequest request, 
            HttpServletResponse response) throws 
            IOException, ServletException {
        
        RequestDispatcher rd = this.context.getRequestDispatcher(uri);
        
        if (rd == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, uri);
            return;
        }
        rd.forward(request, response);
        
    }
    
    /**
     * [EN] I get from the Spring Bean with the specified name.<br>
     * [JP] 指定された名前のBeanをSpringから取得します。<br>
     * <p>
     * [EN] It is used when referring to Bean from a class that do not qualify,<br>
     * [EN] such as custom tags and filters, auto-wiring by Spring.<br>
     * <br>
     * [JP] フィルタやカスタムタグなど、Spring による自動ワイヤリングの対象とならないクラスから<br>
     * [JP] Bean を参照する場合に使用します。<br>
     * </p>
     * 
     * @param context Servlet Context
     * @param name Name of Bean
     * @return Bean that have the specified name
     */
    private static final Object getBean(ServletContext context, String name) {
        WebApplicationContext webctx = (WebApplicationContext) context
            .getAttribute(ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        return webctx.getBean(name);
    }
    
    /**
     * [EN] I get number of trials.<br>
     * [JP] 試行回数を取得します。<br>
     * 
     * @param request HTTP Request
     * @return Number of trials (0 for the first time)
     */
    private int getTryNo(HttpServletRequest request) {
        return Integer.parseInt(getCookie(request, ATTRIB_KEY_TRY_NO, "0"));
    }
    
    /**
     * [EN] I will return the value of the Cookie that you specify (decoded).<br>
     * [JP] 指定されたCookieの値(デコード済み)を返します。<br>
     * 
     * @param request HTTP Request
     * @param name Name of Cookie
     * @param alternative Value if Cookie does not exist
     * @return Cookie values(Use the value of the alternative if it does not exist yet)
     */
    public static String getCookie(HttpServletRequest request, String name, String alternative) {
        
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(name)) {
                    
                    String value = null; // alternative;
                    
                    try {
                        value = URLDecoder
                            .decode(cookie.getValue(), request.getCharacterEncoding());
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                    
                    return value;
                    
                }
            }
        }
        
        return alternative;
        
    }
    
    /**
     * [EN] I will determine whether or not authenticated.<br>
     * [JP] 認証済みかどうかを判定します。<br>
     * 
     * @param request HTTP Request
     * @return boolean (true: authenticated false: not verified)
     */
    private boolean isAuthenticated(HttpServletRequest request) {
        
        boolean isOK = false;
        
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(ATTRIB_KEY_AUTHENTICATED) != null) {
            isOK = true;
        }
        
        return isOK;
        
    }
    
    /**
     * [EN] I will determine whether the exclusion of the screen filter.<br>
     * [JP] フィルター処理の除外画面かどうかを判定します。<br>
     * 
     * @param path Servlet path of the requested
     * @return boolean (true: not excluded: excluded false)
     */
    private boolean isExceptedURI(String path) {
        return exceptedURIList.contains(path);
    }
    
    
    
    // ------------------------------------------------------- inner class
    
    /**
     * [EN] This is the class that summarizes the directory attributes provided by SiteMinder.<br>
     * [EN] It does Mase used only in this filter: Note. <br>
     * <br>
     * [JP] SiteMinderから提供されるディレクトリ属性をまとめたクラスです。<br>
     * [JP] 注：このフィルタでしか使用ません。<br>
     * 
     * @author DENSO CORPORATION
     */
    @SuppressWarnings("serial")
    private static class Account implements Serializable {
        
        /** 
         * DSC-ID.
         */
        public String uid;
        
        /** 
         * DSC-ID.
         */
        public String empId;
                
        /** 
         * teamCode.
         */
        public String teamCode;
        
        /** 
         * teamName.
         */
        public String teamName;
        
        /** 
         * authCode.
         */
        public String authCode;
        
        /** 
         * empName.
         */
        public String empName;
        
        /** 
         * empPrivateAuth.
         */
        public String empPrivateAuth;
        
        /** 
         * inOutType
         */
        public String inOutType;
        
        
        /** 
         * relationCopLoc
         */
        public String relationCopLoc;
        
        
        /** 
         * relationCopNo
         */
        public String relationCopNo;
        
        
        /** 
         * clsCode
         */
        public String clsCode;
        
        
        /** 
         * locCode
         */
        public String locCode;
        
        
        // XXX:【If you want to modify the SiteMinderFilter to PJ for 5】
        // ========================================================================
        // We are in a state that allows it to be used only UID, and then modify it as needed.
        // ========================================================================
        
        // /** Password */
        // public String password;
        //
        // /** First name, last name (Kanji)*/
        // public String cnKanji;
        //
        // /** First name, last name (English)*/
        // public String cn;
        //
        // /** DENSO position classification (remarks:ZZ if an officer ) */
        // public String postFlag;
        //
        // /** Company code (remarks：10001 if DNJP) */
        // public String companyCode;
        //
        // /** e-mail address 1 */
        // public String mail;
        
        /**
         * [EN] Constructor.<br>
         * [EN] I will generate the Account class in the state was copy the domain information. <br>
         * <br>
         * [JP] コンストラクタ。<br>
         * [JP] domain情報をコピーした状態でAccountクラスを生成します。<br>
         * 
         * @param domain Domain class which holds the account information
         */
        public Account(EmpDomain domain) {
            this.uid = domain.getEmpNumber();
            this.empId = domain.getEmpId();
            this.teamCode = domain.getTeamCode();
            this.teamName = domain.getTeamName();
            this.authCode = domain.getAuthCode();
            this.empName = domain.getEmpName();
            this.empPrivateAuth = domain.getEmpPrivateAuth();
            this.inOutType = domain.getInOutType();
            this.relationCopLoc = domain.getRelationCopLoc(); //jhb add:2018.08.16
            this.relationCopNo = domain.getRelationCopNo(); //jhb add:2018.08.16
            this.clsCode = domain.getClsCode(); //jhb add:2019.11.14
            this.locCode = domain.getLocCode(); //jhb add:2019.11.14
        }

        /**
         * [EN] I will return the string representation.<br>
         * [JP] 文字列表現を返します。<br>
         * 
         * @return String representation
         */
        public String toString() {
//            return format("{uid=%s, teamCode=%s, teamName=%s, authCode=%s, empName=%s, empPrivateAuth=%s}",
//            uid, teamCode, teamName, authCode, empName, empPrivateAuth);
//            return format("{\"uid\"=\"%s\", \"teamCode\"=\"%s\", \"teamName\"=\"%s\", \"authCode\"=\"%s\", \"empName\"=\"%s\", \"empPrivateAuth\"=\"%s\"}", 
//              uid, teamCode, teamName, authCode, empName, empPrivateAuth);
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("uid", uid);
            jsonObj.put("empId", empId);
            jsonObj.put("teamCode", teamCode);
            jsonObj.put("teamName", teamName);
            jsonObj.put("authCode", authCode);
            jsonObj.put("empName", empName);
            jsonObj.put("empPrivateAuth", empPrivateAuth);
            jsonObj.put("inOutType", inOutType);
            jsonObj.put("relationCopLoc", relationCopLoc); //jhb add:2018.08.16
            jsonObj.put("relationCopNo", relationCopNo); //jhb add:2018.08.16
            jsonObj.put("clsCode", clsCode); //jhb add:2019.11.14
            jsonObj.put("locCode", locCode); //jhb add:2019.11.14
            String rtnStr = jsonObj.toJSONString();
            return rtnStr;
        }
        
    }
    
    
    /**
     * [EN] It is the HttpServletRequestWrapper for publishing in the HTTP header via the user information.<br>
     * [EN] Do not implement treatment other than those related to SiteMinder.<br>
     * <br>
     * [JP] ユーザ情報をHTTPヘッダ経由で公開するためのHttpServletRequestWrapperクラスです。<br>
     * [JP] ※SiteMinderに関する処理以外は実装しないで下さい。<br>
     * 
     * @author DENSO CORPORATION
     */
    private static class SiteMinderRequestWrapper extends HttpServletRequestWrapper {
        
        /**
         * [EN] Header key: being filtered outside URI.
         * [JP] ヘッダキー：フィルタ処理対象外URI。
         */
        private static final String HEADER_KEY_UID = "UID";
        
        /** 
         * [EN] Account information of the authenticated user.
         * [JP] 認証されたユーザのアカウント情報。
         */
        private Account account;
        
        /**
         * [EN] Based on the information of the authenticated user and is constructor to create an object of that class.
         * <br>
         * [JP] 認証されたユーザの情報をもとに、 当該クラスのオブジェクトを生成するためのコンストラクタです。
         * 
         * @param request HTTP Request
         */
        public SiteMinderRequestWrapper(HttpServletRequest request) {
            
            super(request);
            
            // [EN] Get account information
            // [JP] アカウント情報の取得
            this.account = (Account) request.getSession().getAttribute(ATTRIB_KEY_ACCOUNT);
            
        }
        
        /**
         * {@inheritDoc}
         * 
         * @see javax.servlet.http.HttpServletRequestWrapper#getHeader(java.lang.String)
         */
        @Override
        public String getHeader(String name) {
            if (HEADER_KEY_UID.equals(name)) {
                return account.uid;
            } else {
                return super.getHeader(name);
            }
        }
        
    }
    
    /**
     * 
     * 
     * @param request HttpServletRequest
     * @param emp EmpDomain
     * @return String
     * @throws Exception 
     */
    public String checkLoginLdap(HttpServletRequest request, EmpDomain emp) throws Exception {
        //System.out.println("==== LoginController.java checkLoginLdap");

        Cookie[] cookies = request.getCookies();
        String resultPwfcReset = "";
        String resultPassYn = ""; 
        String resultMessage = "Window AD 등록되지 않은 사용자입니다. ID/Password확인바랍니다."; 
        String resultFlag = "N";

        Hashtable<String, String> ldapEnv = new Hashtable<String, String>();
        //String ldapHost = "10.73.254.30";
        String ldapHost = "";
        String domain = "";
        String ldapAdminUser = "";
        String ldapAdminPw = "";
        String port = ""; // default Port
        
        String ldapHostKr = "korea.asia.denso";
        String domainKr = "korea.asia.denso";
        String ldapAdminUserKr = "administrator";
        String ldapAdminPwKr = "Dnke$0627030";
        String portKr = "389"; // Korea default Port
        
        String ldapHostJp = "gci.denso.com";
        String domainJp = "gci.denso.com";
        //String ldapAdminUserJp = "SA40004DEVLDAP01";	//TEST용
        //String ldapAdminPwJp = "Rr=72555";
        String ldapAdminUserJp = "SA40004LDAP01";
        String ldapAdminPwJp = "Yh&56563";
        String portJp = "389"; // JP default Port

        //String ldapAdminUserJp = "40004DEV00005";
        //String ldapAdminPwJp = "Gr$33365";
        
        //GCI-AD 인증 분개
        String ldapDomainCheck = emp.getEmpId().substring(0,5);
        if("40004".equals(ldapDomainCheck)) {
        	System.out.println("JP AD");
        	ldapHost = ldapHostJp;
        	domain = domainJp;
        	ldapAdminUser = ldapAdminUserJp;
        	ldapAdminPw = ldapAdminPwJp;
        	port = portJp;
        }else {
        	System.out.println("KR AD");
        	ldapHost = ldapHostKr;
        	domain = domainKr;
        	ldapAdminUser = ldapAdminUserKr;
        	ldapAdminPw = ldapAdminPwKr;
        	port = portKr;
        }
        String ldapAdminName = ldapAdminUser + "@" + domain;
        System.out.println("ldapUser = "+emp.getEmpId());
        //System.out.println(ldapDomainCheck);
        //System.out.println("ldapHost: "+ldapHost +" domain: "+domain+" ldapAdminUser: "+ldapAdminUser+" ldapAdminPw: "+ldapAdminPw+" ldapAdminName: "+ldapAdminName);

        //String port = "389"; // default Port
        String urlDC = "ldap://" + ldapHost + ":" + port + "/"; // ldap://korea.asia.denso:389/
        String dcList = "";
        dcList = "DC=" + domain.replaceAll("\\.", ",DC="); // DC=korea,DC=asia,DC=denso
        //System.out.println(dcList);
        String ldapUser = emp.getEmpId();   //"xxxxxxx"
        if(ldapUser == null){
            //System.out.println("ldapUser null="+ ldapUser);
            ldapUser = "xxxxxxx";
        }
        String ldapPass = emp.getEmpPwd(); //"xxxxxxx"
        if(ldapPass == null){
            //System.out.println("ldapPass null="+ ldapPass);
            ldapPass = "xxxxxxx";
        }
        String userName = ldapUser + "@" + domain; // e030191@korea.asia.denso
        //System.out.println("userName : " + userName);
        //System.out.println("ldapPass : " + ldapPass);
        ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
        ldapEnv.put(Context.SECURITY_PRINCIPAL, userName);        // e030191@korea.asia.denso
        ldapEnv.put(Context.SECURITY_CREDENTIALS, ldapPass);      // blogspot
        ldapEnv.put(Context.PROVIDER_URL, urlDC);                 // ldap://korea.asia.denso:389/
        //ldapEnv.put("com.sun.jndi.ldap.read.timeout", "2000");    // Read Timeout 설정
        ldapEnv.put("com.sun.jndi.ldap.read.timeout", "5000");    // Read Timeout 설정
        ldapEnv.put("com.sun.jndi.ldap.connect.timeout", "2000"); // Connect Timeout 설정


        LdapContext ctx = null;
        //InitialDirContext ctx = null;
        //System.out.println("userLoginLog  세팅");
        HashMap<String, String> userLoginLog = new HashMap<String, String>();
        userLoginLog.put("USERID", ldapUser);
        userLoginLog.put("USERPASS", ldapPass);

        //신규추가 2017.12.20 jhb 

        try {
            //System.out.println("ctx   ctx = new InitialLdapContext(ldapEnv, null);");
            ctx = new InitialLdapContext(ldapEnv, null);
            //System.out.println("LDAP 접속에 성공 했습니다.");

            //ctx = new InitialDirContext(ldapEnv);
            //System.out.println("CTX=="+ctx);

            //String[] sAttribs = {"cn", "company", "department", "displayName", "name", "title", "mail", "lockoutTime", "badPwdCount"};
            String[] sAttribs = {"cn", "company", "department", "displayName", "name", "lockoutTime", "badPwdCount"};	//GCI임시 TEST : 20.07.10

            SearchControls sc = new SearchControls();
            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

            sc.setReturningAttributes(sAttribs);

            String searchFilter = "sAMAccountName=" + ldapUser; //조회대상

            NamingEnumeration lrlts = ctx.search(dcList, searchFilter, sc);
            while(lrlts.hasMoreElements()){
                SearchResult srd = (SearchResult) lrlts.next();
                Attributes attrs =  srd.getAttributes();
                //System.out.println("attrobute:"+attrs);
                //System.out.println("attrobute1:"+attrs.get("cn"));
                resultFlag = "Y";
                //System.out.println("");
            }

        }catch (Exception authEx) {
            System.out.println("LDAP 접속에 실패 했습니다."+authEx);
            String excMsg = authEx.getMessage();
            String ldapErrorKey = authEx.getMessage();
            //Ldap Error Properties 체크
            HashMap<String, String> ldapErrorMap = ldapErrorMap();	//ldapErrorMap 객체생성
			for (String key : ldapErrorMap.keySet()) { 
				if (excMsg.contains("data " + key)) { 
					ldapErrorKey = key;
					//System.out.println(ldapErrorMap.get(key)); 
				} 
			}
        	//계정존재 및 잠김체크
            DirContext ctx2 = null;
            Properties props = new Properties();

            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            props.setProperty(Context.SECURITY_AUTHENTICATION, "simple");
            //props.setProperty(Context.SECURITY_PRINCIPAL, "administrator@korea.asia.denso");        // administrator@korea.asia.denso
            //props.setProperty(Context.SECURITY_CREDENTIALS, "Dnke$0627030");      // Dnke$0627030
            props.setProperty(Context.SECURITY_PRINCIPAL, ldapAdminName);        // administrator@korea.asia.denso
            props.setProperty(Context.SECURITY_CREDENTIALS, ldapAdminPw);      // Dnke$0627030
            props.setProperty(Context.PROVIDER_URL, urlDC);                 // ldap://korea.asia.denso:389/
            //props.setProperty("com.sun.jndi.ldap.read.timeout", "2000");    // Read Timeout 설정
            props.setProperty("com.sun.jndi.ldap.read.timeout", "5000");    // Read Timeout 설정
            props.setProperty("com.sun.jndi.ldap.connect.timeout", "2000"); // Connect Timeout 설정
            props.setProperty(Context.REFERRAL, "follow");   // referral에러 방지

            ctx2 = new InitialDirContext(props);

            SearchControls sc = new SearchControls();
            sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
            //String[] sAttribs = {"cn", "company", "department", "displayName", "name", "title", "mail", "lockoutTime", "badPwdCount"};
            String[] sAttribs = {"cn", "company", "department", "displayName", "name", "lockoutTime", "badPwdCount"};	//GCI임시 TEST : 20.07.10
            sc.setReturningAttributes(sAttribs);
            String searchFilter = "cn=" + ldapUser; //조회대상
            String searchCn = "";
            //String searchLockoutTime = "0";
            //String searchBadpwdcount = "0";
            try {
                NamingEnumeration lrlts = ctx2.search(dcList, searchFilter, sc);
            	//GCI도입변경 Attribute set type 변경 : String → Map
                /*
                while (lrlts != null && lrlts.hasMore()) {
                    SearchResult dirObject = (SearchResult) lrlts.next();
                    Attributes attrs = dirObject.getAttributes();
                    if(attrs != null){
                        //System.out.println(attrs.get("cn"));
                        //System.out.println(attrs.get("lockoutTime"));
                        searchCn = attrs.get("cn").toString();
                        searchLock = attrs.get("lockoutTime").toString();
                        //System.out.println(searchLock.length());
                    }
                }
             	*/
                while (lrlts != null && lrlts.hasMore()) {
                    SearchResult dirObject = (SearchResult) lrlts.next();
                    Attributes attrs = dirObject.getAttributes();
                    //System.out.println("attrs ===== "+attrs);
                    HashMap<String, String> attribMap = new HashMap<String, String>();
                    if(attrs != null){
                        //System.out.println(sAttribs.length);
                        for(String str : sAttribs) {
                            //System.out.println(str);
                        	String attribOrg = attrs.get(str).toString();
                        	String[] attribSplit = attribOrg.split(":");
                            attribMap.put(attribSplit[0], attribSplit[1]);
                        }
                        searchCn = attribMap.get("cn").toString().trim();
                        //searchLockoutTime = attribMap.get("lockoutTime").toString().trim();
                        //searchBadpwdcount = attribMap.get("badPwdCount").toString().trim();
                        //System.out.println("attribMap ===== "+attribMap);
                        System.out.println("ldapErrorKey : "+ldapErrorKey + " searchCn : "+searchCn);
                        //System.out.println("ldapErrorKey : "+ldapErrorKey + " searchCn : "+searchCn+  " searchLockoutTime : "+searchLockoutTime+ " searchBadpwdcount : "+searchBadpwdcount);
                    }
                }
                //System.out.println("==end====");
            } catch (Exception e2) {
                System.out.println("Exc2===" + e2);
            }
            if(("").equals(searchCn) && ("52e").equals(ldapErrorKey)){   //계정이 없는 경우
                resultMessage = "Window AD 등록되지 않은 사용자입니다."; 
                resultFlag= "A"; //(ID Wrong)
            }else{
                if(("775").equals(ldapErrorKey)){   //계정이 잠긴 경우
                //if(!("0").equals(searchLockoutTime)){   //계정이 잠긴 경우
                    resultMessage = "계정이 잠겼습니다. 3분후 다시 시도하세요."; 
                    resultFlag= "B"; //(PW Lock)
                }else{
                    resultMessage = "잘못된 Password입니다.";
                    resultFlag= "C"; //(PW Wrong)
                    System.out.println(searchCn + ldapErrorMap.get(ldapErrorKey));	//Ldap Error 
                }
            }
            //System.out.println("resultFlag=="+resultMessage);
        }
        /*
        HashMap rtnMap = new HashMap();
        rtnMap.put("userId", emp.getEmpId());
        rtnMap.put("resultMessage", resultMessage);
        rtnMap.put("resultPwfcReset", resultPwfcReset);
        rtnMap.put("resultPassYn", resultPassYn);
         */
        /*
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login/login");
        mav.addObject("userId", emp.getEmpId());
        mav.addObject("resultMessage", resultMessage);
        mav.addObject("resultPwfcReset", resultPwfcReset);
        mav.addObject("resultPassYn", resultPassYn);
         */
        return resultFlag;
    }
    
	private HashMap<String, String> ldapErrorMap(){
    	HashMap<String, String> ldapErrorMap = new HashMap<String, String>();
		ldapErrorMap.put("525", "ERROR_NO_SUCH_USER (The specified account does not exist.)");                                                    
		ldapErrorMap.put("52e", "ERROR_LOGON_FAILURE (Logon failure: unknown user name or bad password.)");                          
		ldapErrorMap.put("530", "ERROR_INVALID_LOGON_HOURS (Logon failure: account logon time restriction violation.)");                          
		ldapErrorMap.put("531", "ERROR_INVALID_WORKSTATION (Logon failure: user not allowed to log on to this computer.)");                       
		ldapErrorMap.put("532", "ERROR_PASSWORD_EXPIRED (Logon failure: the specified account password has expired.)");                          
		ldapErrorMap.put("533", "ERROR_ACCOUNT_DISABLED (Logon failure: account currently disabled.)");                               
		ldapErrorMap.put("701", "ERROR_ACCOUNT_EXPIRED (The user's account has expired.)");
		ldapErrorMap.put("773", "ERROR_PASSWORD_MUST_CHANGE (The user's password must be changed before logging on the first time.)");            
		ldapErrorMap.put("775", "ERROR_ACCOUNT_LOCKED_OUT (The referenced account is currently locked out and may not be logged on to.)");
		return ldapErrorMap;
     } 
}
