package com.denso.service.intf;

import java.util.HashMap;
import java.util.List;

public interface BarcodeService {
	
	List<HashMap<String, String>> getFPQZ100Qlist_type1(HashMap<String, String> reqMap);

	List<HashMap<String, String>> getFPQZ100Qlist_type4(HashMap<String, String> reqMap);

	List<HashMap<String, String>> getFPQZ100Qlist_detail(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam);

	List<HashMap<String, String>> getFPQC100Qlist_report(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam);

	List<HashMap<String, String>> getFPQE110Qlist_report(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam);

	
	List<HashMap<String, String>> getFPQE140Qlist_type4(HashMap<String, String> reqMap);

	List<HashMap<String, String>> getFPQE140Qlist_seq(HashMap<String, String> reqMap);

	
	List<HashMap<String, String>> getFPQE150Qlist_type1(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> getFPQE150Qlist_type4(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> getFPQE150Qlist_seq(HashMap<String, String> reqMap) throws Exception;


	List<HashMap<String, String>> getFPQC140Qlist_type4(HashMap<String, String> reqMap);

	List<HashMap<String, String>> getFPQC140Qlist_seq(HashMap<String, String> reqMap);
	
}

