package com.denso.common.util;

import java.util.HashMap;

public abstract class Constants {

	// 바코드 프린터 상태 값
	static HashMap<String,HashMap<String,String>> staticMap = new HashMap<String, HashMap<String,String>>();
	
	// 바코드 프린터 정지 값
	static String printStop ="ING";
}
