
var L_DELETE = "D"; // 다중 레코드 트랜잭션 처리 플래그 : 삭제
var L_UPDATE = "U"; // 다중 레코드 트랜잭션 처리 플래그 : 수정
var L_INSERT = "I"; // 다중 레코드 트랜잭션 처리 플래그 : 입력


/*
 * 인자로 받은 문자열의 Null 여부를 체크하여 그 결과를 돌려준다.
 *
 * param sValue - 문자열 값
 *
 * return true/false - NULL / NOT NULL
 */
function lFcIsNull(sValue)
{
	var bRtn = false;

	if(length(trim(sValue))<1) bRtn = true;
	else bRtn = false;

	return bRtn;
}


/*
 * 인자로 받은 문자열의 Null 여부를 체크하여 그 결과를 돌려준다.
 *
 * param sValue - 문자열 값
 *
 * return true/false - Not Null / Null
 */
function lFcIsNotNull(sValue)
{
	var bRtn = false;

	if(length(trim(sValue))>0) bRtn = true;
	else bRtn = false;

	return bRtn;
}

