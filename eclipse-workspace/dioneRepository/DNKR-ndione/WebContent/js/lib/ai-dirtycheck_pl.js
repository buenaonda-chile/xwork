/*
 * Project : ai-dirtycheck_pl
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */

var aiDirty = false;
/*
 * [EN]When the contents of the form was changed, display a confirmation dialog.
 * [JP]フォームが変更されている場合に確認ダイアログを表示する 
 *
 */
function aiConfirmDirtyData(msg){
    if(aiDirty){
        return window.confirm(msg);
    }
    return true;
}

/*
 * [EN]Confirm change of dirty check target.
 * [JP]ダーティチェック対象要素の変更を確認する
 *
 */
jQuery(document).ready(function($) {
    $(".dirtyCheck > *").change(function(e) {
        if (!$(e.target).hasClass("dirtyCheckOff")) {
            aiDirty = true;
        }
    });
});