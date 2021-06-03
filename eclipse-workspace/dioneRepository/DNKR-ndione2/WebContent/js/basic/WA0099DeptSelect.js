/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */


/*
====================================================================
[EN] Function: Return selected department information to Parent Screen.
[EN] Argument: [1st argument] department number
[EN]           [2nd argument] department name
[EN] Summary : I return selected department information to Parent Screen.
====================================================================
*/
function returnValue(dnum, dname) {
    window.opener.document.getElementById("deptNo").value = dnum;
    window.opener.document.getElementById("deptName").value = dname;
    window.close();
}

