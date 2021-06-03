/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */


/* ================================================================ */
/* [JP] 全画面共通                                                  */
/* [EN] Common to all screens                                       */
/* ================================================================ */


/*
====================================================================
[EN] Function : Context root get
[EN] Argument : None
[EN] Summary  : I want to get the current context root of the screen transition.

[JP] 関数名 ：コンテキストルート取得
[JP] 引数   ：なし
[JP] 概要   ：画面遷移時のカレントコンテキストルートを取得する。
====================================================================
*/
function getCurrent() {
    var context = "/ai_sample";
    var current = window.location.pathname;
    if (current.charAt(0) != "/" ) {
        current = "/" + current;
    }
    var pos = current.indexOf("/", 1);
    if (1 < pos) {
        context = current.substring(1, pos);
    }
    return ("/" + context);
}

/*
====================================================================
[EN] Function : Screen transition process (specify path)
[EN] Argument : [1st argument] target form
[EN]            [2nd argument] path from context-root (exclude ".do", required)
[EN] Summary  : I do a screen transition(submit) with specified path.

[JP] 関数名 ： 画面遷移処理(パス指定)
[JP] 引数   ： [第1引数] 対象のform
[JP]           [第2引数] コンテキストルートからのパス(".do"除く, 必須)
[JP] 概要   ： パスを指定して画面遷移(サブミット)する。
====================================================================
*/
function submit(form, path) {
    // In order to prevent double transmission, deactivate all buttons
    inactivateButton();
    
    form.action = path + ".do";
    return form.submit();
}

/*
====================================================================
[EN] Function : Context root get
[EN] Argument : [1st argument] Help ID (required, usually @viewId)
[EN] Summary  : I want to display Help window.

[JP] 関数名 ：ヘルプ表示
[JP] 引数   ：[第1引数]  ヘルプID (必須 主に画面ID)
[JP] 概要   ：ヘルプ画面を表示する。
====================================================================
*/
function openHelp(helpId){
    window.open(
            getCurrent() + "/WZ0010Help/init.do?helpId=" + helpId, 
            "ai_sample_help", 
            "width=750, height=550, scrollbars=yes"
        );
}


