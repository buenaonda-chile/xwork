/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */


/*
===============================================================================
Function: Delete process
Argument: [1st argument] target form
          [2nd argument] Check error message.
          [3rd argument] Deletion confirmation message.
Summary : Check statuses of check box, if all check boxes are not checked, 
          display error message.
          If checked, display confirm message, and execute delete process.
===============================================================================
*/
function deleteSelectedEmp(form, noSelectMsg, confirmMsg) {
    
    selectNum = 0;
    if (document.WA0001EmpSearchForm.selectedEmp.length) {
        for (var i = 0; i < document.WA0001EmpSearchForm.selectedEmp.length; i++) {
            if (document.WA0001EmpSearchForm.selectedEmp[i].checked) {
                selectNum = selectNum + 1;
            }
        }
    } else {
        if (document.WA0001EmpSearchForm.selectedEmp.checked) {
            selectNum = selectNum + 1;
        }
    }
    
    if (selectNum == 0) {
        alert(noSelectMsg);
    } else {
        if (window.confirm(confirmMsg)) {
            submit(form, '/WA0001EmpSearch/delete');
        }
    }
    
}

/*
===============================================================================
Function: All check box choice
Argument: 
Summary : To a state of all choice check box, 
          I make all other check box a choice state.
===============================================================================
*/
function selectAllCheckbox() {
    
    var check = document.WA0001EmpSearchForm.selectAll.checked;
    
    if (document.WA0001EmpSearchForm.selectedEmp.length) {
        for (var i = 0; i < document.WA0001EmpSearchForm.selectedEmp.length; i++) {
            document.WA0001EmpSearchForm.selectedEmp[i].checked = check;
        }
    } else {
        document.WA0001EmpSearchForm.selectedEmp.checked = check;
    }
    
}



/*
===============================================================================
Function: Table header fixation
Argument: 
Summary : I set the header of the table for fixation. 
          I am called at the time of drawing end time and window resize.
===============================================================================
*/
function fixedTable() {
    var twidth = document.WA0001EmpSearchForm.offsetWidth;
    $(function() {
        $('#tablefix').tablefix({width: twidth, height: 220, fixRows: 1, fixCols: 3});
    });
}

// ウインドウリサイズイベント時
window.onresize = fixedTable;

// 描画終了時
$(document).ready(function() {
    fixedTable();
});


