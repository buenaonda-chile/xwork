/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.filter;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.exception.SystemException;

/**
 * [EN] The filter used to change locale.<br>
 * [JP] ロケール切替のフィルタです。<br>
 * 
 * <p>
 * [EN] If it is not the transition to the filter excluded, this filter rewrite DensoContext's locale.<br>
 * [JP] フィルタ対象外への遷移でない場合、このフィルタは指定されたロケールでDensoContextのロケールを書き換えます。<br>
 * </p>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class LocaleChangeFilter implements Filter {
    
    /**
     * [EN] Context parameter key: filter target URI.<br>
     * [JP] コンテキストパラメータキー：フィルタ処理対象URI。<br>
     */
    private static final String PARAM_KEY_TARGET_URI = "targetURI";
    
    /**
     * [EN] Cookie expiration date. (60s * 60m * 24h * 30d)<br>
     * [JP] クッキー有効期限。(60秒*60分*24時間*30日)<br>
     */
    private static final int COOKIE_EXPIRATION_DATE = 60 * 60 * 24 * 30;
    
    /**
     * [EN] This is the screen to run the filter processing.<br>
     * [JP] フィルター処理を実行する画面です。<br>
     * <p>
     * [EN] Keep a list of path names to get the servlet path( {@link HttpServletRequest#getServletPath() }, <br>
     * [EN] the path screen that you want to run the processing.<br>
     * [EN] Specifying the screen is defined as the initialization parameter <b>"targetURI"</b> in web.xml. <br>
     * [EN] If you want to specify more than one, specify a comma-separated list. <br>
     * [JP] 処理の対象としたい画面パスを、サーブレットパス( {@link HttpServletRequest#getServletPath() } <br>
     * [JP] で取得するパス名)でリストで保持します。<br>
     * [JP] 画面の指定は web.xml に初期化パラメータ <b>"targetURI"</b> として定義します。<br>
     * [JP] 複数指定する場合は、カンマ区切りで指定します。<br>
     * </p>
     */
    private List<String> targetURIList = new ArrayList<String>(asList(PARAM_KEY_TARGET_URI));
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public LocaleChangeFilter() {
        // no process
    }
    
    
    
    /**
     * {@inheritDoc}
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
        
        /**
         * <pre>
         * 1.[EN] Filtering excluded screen
         *   [JP] フィルター対象の画面を取得
         * </pre>
         */
        String targetURI = config.getInitParameter(PARAM_KEY_TARGET_URI);
        if (StringUtils.isNotEmpty(targetURI)) {
            targetURIList.addAll(asList(targetURI.split(",")));
        }
        
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
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
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
     * [EN] Change Locale.<br>
     * [JP] ロケールの切り替えを行います。<br>
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
        
        /**
         * <pre>
         * 1.[EN] Locale change processing
         *   [EN]   When locale was appointed in a request parameter at the time of URI for the filter,
         *   [EN]   I update DensoContext by appointed locale and record the locale on a cookie. 
         *   [JP] ロケール切り替え処理
         *   [JP]   ・フィルタ対象のURIかをチェックする。
         *   [JP]       ・対象のURIのとき
         *   [JP]           ・リクエストパラメータにロケールが指定されているときは、
         *   [JP]             指定されたロケールで、DensoContextのロケールを更新する。
         *   [JP]           ・更新したロケールをクッキーに記録する。
         *   [JP]   ・後続の処理を継続する。
         * </pre>
         */

        /*if (isTargetURI(request.getServletPath())) { 
            String newlocaleStr = request.getParameter("locale");
            if(newlocaleStr==null || "".equals(newlocaleStr)){
                newlocaleStr = "kr";
            }else{
                if(newlocaleStr!="kr" && newlocaleStr!="en" && newlocaleStr!="jp"){
                    newlocaleStr = "kr";
                }
            }

            Locale newLocale = new Locale(newlocaleStr);
            DensoContext.get().setLocale(newLocale);
            HttpSession session = request.getSession(false);
            if (session != null) {
                response.addCookie(this.makeCookie(request, "locallocale", newlocaleStr));
            }
        }*/
        
        chain.doFilter(request, response);        
    }
    
    
    
    /**
     * [EN] I will create a Cookie .
     * [JP] 指定された名前、値のCookieを作成します。
     * 
     * @param request [EN] HTTP request [JP] HTTPリクエスト
     * @param name [EN] The name of the Cookie [JP] Cookieの名前
     * @param newvalue [EN] The value of the Cookie [JP] Cookieの値
     * @return [EN] Cookie object you created [JP] 作成したCookieオブジェクト
     */
    private Cookie makeCookie(
            HttpServletRequest request, 
            String name, 
            String newvalue) {
        
        Cookie cookie = null;
        
        /**
         * <pre>
         * 1.[EN] Cookie making processing.
         *   [EN]   I make a cookie with the appointed name, value. 
         *   [JP] クッキー作成処理
         *   [JP]   ・指定された名前、値でクッキーを作成する
         *   [JP]   ・作成したクッキーに有効期限を設定する
         *   [JP]   ・作成したクッキーのパスを設定する
         * </pre>
         */
        
        try {
            cookie = new Cookie(name, URLEncoder.encode(newvalue, request.getCharacterEncoding()));
            cookie.setMaxAge(COOKIE_EXPIRATION_DATE);
            cookie.setPath(request.getContextPath());
        } catch (UnsupportedEncodingException e) {
            throw new SystemException(e);
        }
        
        return cookie;
        
    }

    /**
     * [EN] I will determine whether the exclusion of the screen filter.
     * [JP] フィルター処理の対象画面かどうかを判定します。
     * 
     * @param path [EN] Servlet path of the requested [JP] リクエストされたservletのパス
     * @return [EN] boolean (true: not excluded: excluded false) [JP] boolean (true:処理対象 false:除外対象)
     */
    private boolean isTargetURI(String path) {
        
        /**
         * <pre>
         * 1.[EN] The check processing that is targeted for a filter.
         *   [EN]    I will determine whether the exclusion of the screen filter.
         *   [JP] フィルター対象チェック処理
         *   [JP]   ・フィルタ対象URIリストに指定されたURIが含まれているかチェック
         *   [JP]   ・含まれているときはtrue、そうでないときはfalseを返す
         * </pre>
         */
        
        for (String target : targetURIList) {
            if (path.indexOf(target) > -1) {
                return true;
            }
        }
        
        return false;
        
    }
}
