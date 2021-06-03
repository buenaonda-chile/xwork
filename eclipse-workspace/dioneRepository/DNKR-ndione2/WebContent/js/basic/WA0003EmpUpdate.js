/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */


/*
====================================================================
[EN] Function: Show Department select screen process
[EN] Argument: 
[EN] Summary : I Show Department select screen.
====================================================================
*/
function showDepartmentSelect() {
    var childWindowObject = window.open(
            getCurrent() + '/WA0099DeptSelect/init.do', 'deptselect', 
            "width=800px, height=480px, scrollbars=yes");
}

/*
====================================================================
[EN] Function: Clear department name.
[EN] Argument: 
[EN] Summary : I clear department name.
====================================================================
*/
function clearDeptName(){
    document.getElementById("deptName").value = "";
}

/*
====================================================================
[EN] Function: Show Location select screen process
[EN] Argument: 
[EN] Summary : I Show Location select screen.
====================================================================
*/
function showLocationSelect() {
    var childWindowObject = window.open(
            getCurrent() + '/WA0098LocationSelect/init.do', 'locationselect', 
            "width=800px, height=480px, scrollbars=yes");
}

/*
====================================================================
[EN] Function: Clear location name.
[EN] Argument: 
[EN] Summary : I clear location name.
====================================================================
*/
function clearLocationName(){
    document.getElementById("locationName").value = "";
}

/*
===============================================================================
Function: Delete process
Argument: [1st argument] target form
          [2nd argument] Deletion confirmation message.
Summary : Check statuses of check box, if all check boxes are not checked, 
          display error message.
          If checked, display confirm message, and execute delete process.
===============================================================================
*/
function deleteEmp(form, confirmMsg) {
    if (window.confirm(confirmMsg)) {
        submit(form, '/WA0003EmpUpdate/delete');
    }
}

/*
===============================================================================
Function: Back process
Argument: [1st argument] target form
          [2nd argument] Deletion confirmation message.
Summary : Check statuses of check box, if all check boxes are not checked, 
          display error message.
          If checked, display confirm message, and execute delete process.
===============================================================================
*/
function backToSearch(form, confirmMsg) {
    if (aiConfirmDirtyData(confirmMsg)) {
        submit(form, '/WA0003EmpUpdate/back');
    }
}



/*
====================================================================
[EN] Function: Calendar function.
[EN] Argument: 
[EN] Summary : I use "datepicker" for calendar function.
====================================================================
*/
$(document).ready(function(){
    // スラッシュ
    $( "#hireDate" ).datepicker({
        dateFormat:'yy-mm-dd',
        showButtonPanel: true,
        closeText:"Close"
    });

});

