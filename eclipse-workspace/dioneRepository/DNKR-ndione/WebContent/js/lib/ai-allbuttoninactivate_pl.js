/*=============================================
 * Common Library   ai-allbuttoninactivate
 * Version          1.0.1
 * FirstAuthor      DNITS YOSHIFUMI KITAGAWA
 * FirstRelease     2013/01/11
 * LastAuthor       DNITS KOJI YAMAMOTO
 * LastRelease      2013/04/26
  =============================================*/

/*
==========================================================
 Function Name : inactivateButton
 Overview      : inactivate all button on the Web Screen.
==========================================================
*/
function inactivateButton(){
    
    var inputElements = document.getElementsByTagName("input");
    for (i = 0; i < inputElements.length; i = i + 1) {
        var elementType = inputElements[i].type;
        if (elementType == "submit") {
            inputElements[i].disabled = true;
        } else if (elementType == "button") {
            inputElements[i].disabled = true;
        } else if (elementType == "image") {
            inputElements[i].disabled = true;
        } else if (elementType == "reset") {
            inputElements[i].disabled = true;
        }
    }
    
    var buttonElements = document.getElementsByTagName("button");
    for (i = 0; i < buttonElements.length; i = i + 1) {
        buttonElements[i].disabled = true;
    }
    
}