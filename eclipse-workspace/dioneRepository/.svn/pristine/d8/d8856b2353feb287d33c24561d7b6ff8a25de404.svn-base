/*
 * Project : ai-paging_pl_sample
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
/*
   function of Paging Library
 */

/*
====================================================================
    move to the page that was clicked
====================================================================
*/
function pageClick(formId, num, actionPath){
    document.getElementById(formId).pages.value = 'click';
    
    document.getElementById(formId).pageNo.value = num;
    
    if(actionPath != ''){
        document.getElementById(formId).action = actionPath;
    }
    
    document.getElementById(formId).submit();
}

/*
====================================================================
    move to the page that was input
====================================================================
*/
function pageJump(formId, num, actionPath, pageMax){
    
    if(event.keyCode == 13){
        var str = num.value;
        
        if(1 <= num.value && num.value <= pageMax && str.match(/^[1-9]{1}[0-9]{0,5}$/)){
            document.getElementById(formId).pages.value = 'click';
            
            document.getElementById(formId).pageNo.value = num.value;
            
            if(actionPath != ''){
                document.getElementById(formId).action = actionPath;
            }
            
            document.getElementById(formId).submit();
        }else{
            
            alert("This input value is invalid. The value must be page No. which is exist in results of search.");
            
            return false;
        }
    }else{
        // noop
    }
}