﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿//화면 이름 구하기
function getScrName(scrName){
	var screenName;
	//trace("Mi_screen scrName: " +scrName);
	max5250.ResetPopupRange();
	switch (scrName){
		case "FZHZ101FM":
			if(trim(max5250.GetString(6,1,80)) != null){
				screenName = "FZHZ101FM_1";
			}else{
				screenName = "FZHZ101FM";
			}
		break;
		case "FHDZ070FM":
			if(trim(max5250.GetString(6,1,80)) != null){
				screenName = "FHDZ070FM_1";
			}else{
				screenName = "FHDZ070FM";
			}
		break;
		case "FHDZ100FM":
			if(trim(max5250.GetString(6,1,80)) != null){
				screenName = "FHDZ100FM_1";
			}else{
				screenName = "FHDZ100FM";
			}
		break;
		case "SPYC904FM":
			if(trim(max5250.GetString(6,1,80)) != null){
				screenName = "SPYC904FM_1";
			}else{
				screenName = "SPYC904FM";
			}
		break;
		case "FHDC200FM":
			if(trim(max5250.GetString(6,1,10)) != null){
				max5250.CheckPopupWindow();
				screenName = "FHDC200FM_1";
			}else{
				screenName = "FHDC200FM";
			}
		break;
		case "B031000":
			if(trim(max5250.GetString(6,1,10)) != null){
				max5250.CheckPopupWindow();
				screenName = "B031000_1";
			}else{
				screenName = "B031000";
			}
		break;
		case "MSTZ100FM":
		trace(trim(max5250.GetString(6,1,12)));
			if(trim(max5250.GetString(6,1,12)) == "품　　　명"){
				screenName = "MSTZ100FM_1";
			}else if(trim(max5250.GetString(5,1,12)) == null){
				screenName = "MSTZ100FM";
			}else{
				screenName = "MSTZ100FM_2";
			}
		break;
		case "SJTZ210FM":
			if(trim(max5250.GetString(17,1,10)) != null){
				screenName = "SJTZ210FM_1";
			}else{
				screenName = "SJTZ210FM";
			}
		break;
		case "":
			screenName = "empty";
		break;
		default :
			screenName = scrName;
			break;
	}
	trace("screenName:::"+screenName);
	return screenName;
}
