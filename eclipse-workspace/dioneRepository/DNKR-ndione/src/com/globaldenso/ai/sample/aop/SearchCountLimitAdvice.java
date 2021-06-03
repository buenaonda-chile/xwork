/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.ai.sample.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.constant.AiSampleConstants;

/**
 * [EN] It is AOP class giving up an application exception according to the number of search results.<br>
 * [JP] 検索結果の件数に応じアプリケーション例外を投げるAOPクラスです。<br>
 *
 * @author $Author$
 * @version $Revision$
 */
public class SearchCountLimitAdvice implements AfterReturningAdvice {
    
    // ------------------------------------------------------------ Constructors
    /**
     * デフォルトコンストラクタです。
     */
    public SearchCountLimitAdvice() {
        super();
    }
    
    // ---------------------------------------------------------- Public Methods
    /**
     * [EN] I throw an application exception according to the number of search results.<br>
     * [JP] 検索結果の件数に応じアプリケーション例外を投げます。<br>
     *
     * @param returnValue 戻り値
     * @param method 実行中のメソッド
     * @param args メソッドの引数
     * @param target メソッド呼び出しの対象オブジェクト
     * @throws Throwable
     * [EN] In the case of 0 cases, search results perform a throw of {@link ApplicationException}.<br>
     * [EN] When search results exceed the number of biggest searches,<br>
     * [EN] I perform a throw of {@link ApplicationException}.<br>
     * [JP] 検索結果が 0 件の場合、{@link ApplicationException} をスローします。<br>
     * [JP] 検索結果が最大検索件数を超えていた場合、{@link ApplicationException} をスローします。<br>
     */
    public void afterReturning(
            Object returnValue, 
            Method method, 
            Object[] args,
            Object target) throws 
            Throwable {
        
        /**
         * <pre>
         * 1.[EN] Set locale infomation.
         *   [EN]     I acquire language information from DensoContext 
         *   [EN]     and set it in a domain for the news acquisition.
         *   [JP] 検索結果件数チェック
         *   [JP]   ・returnValueの値をチェックする
         *   [JP]       ・0件のとき
         *   [JP]           ・0件のメッセージのアプリケーション例外を投げる
         *   [JP]       ・最大検索件数より多いとき
         *   [JP]           ・最大検索件数超過のメッセージのアプリケーション例外を投げる
         * </pre>
         */
        
        int result  = ((Integer) returnValue).intValue();
        
      /*  if (result == 0) {
            throw new ApplicationException("SMPL-E8-0001");
        } else if (AiSampleConstants.SEARCH_COUNT_LIMIT < result) {
            throw new ApplicationException("SMPL-E8-0002");
        }*/
        
    }
    
}
