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
====================================================================
[EN] Function: All clear
[EN] Argument: [1st argument] alert message
[EN] Summary : I clear all input items.
====================================================================
*/
function clearFormAll(msg) {
    if (window.confirm(msg)) {
        document.getElementById("empNo").value = "";
        document.getElementById("deptNo").value = "";
        document.getElementById("deptName").value = "";
        document.getElementById("lastName").value = "";
        document.getElementById("firstName").value = "";
        document.getElementById("position").value = "";
        document.getElementById("job").value = "";
        document.getElementById("tel").value = "";
        document.getElementById("email").value = "";
        document.getElementById("mgrEmpNo").value = "";
        document.getElementById("locationNo").value = "";
        document.getElementById("locationName").value = "";
        document.getElementById("hireDate").value = "";
        document.getElementById("salary").value = "";
        document.getElementById("supplementation").value = "";
        document.getElementById("language").value = "ja";
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

