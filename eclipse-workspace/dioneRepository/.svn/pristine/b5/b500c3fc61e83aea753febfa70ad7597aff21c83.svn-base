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

/**
 * [EN] It is AOP class giving up an application exception according to update, deletion,<br>
 * [EN] the number of invalid results.<br>
 * [JP] 更新、削除、無効結果の件数に応じアプリケーション例外を投げるAOPクラスです。<br>
 *
 * @author $Author$
 * @version $Revision$
 */
public class NoDataAffectedAdvice implements AfterReturningAdvice {
    
    // ------------------------------------------------------------ Constructors
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public NoDataAffectedAdvice() {
        super();
    }
    
    // ---------------------------------------------------------- Public Methods
    /**
     * [EN] I throw an application exception according to update, deletion,<br>
     * [EN] the number of invalid results.<br>
     * [JP] 更新、削除、無効結果の件数に応じアプリケーション例外を投げます。<br>
     * 
     * @param returnValue 戻り値
     * @param method 実行中のメソッド
     * @param args メソッドの引数
     * @param target メソッド呼び出しの対象オブジェクト
     * @throws Throwable
     * [EN]  In the case of 0 cases, update, deletion, an invalid result perform <br>
     * [EN]  a throw of {@link ScopeApplicationException}.<br>
     * [JP]  更新、削除、無効結果が 0 件の場合、{@link ApplicationException} をスローします。<br>
     */
    public void afterReturning(
            Object returnValue, 
            Method method, 
            Object[] args,
            Object target) throws 
            Throwable {
        
        /**
         * <pre>
         * 1.[EN] Update, deletion, number of invalid results check.
         *   [EN]     A value of returnValue gives up an application exception at the time of 0. 
         *   [JP] 更新・削除、無効結果件数チェック
         *   [JP]   ・returnValueの値をチェックする
         *   [JP]       ・0件のとき
         *   [JP]           ・アプリケーション例外を投げる
         * </pre>
         */
        
        int result  = ((Integer) returnValue).intValue();
        
        if (result == 0) {
            // [EN] The number is the processing at the age of 0
            // [EN] "I update it or I am deleted by other users."
            // [JP] 件数が0件の時の処理
            // [JP] "他のユーザによって更新、又は、削除されています。"
            throw new ApplicationException("SMPL-E8-0000");
        }
        
    }
    
}
