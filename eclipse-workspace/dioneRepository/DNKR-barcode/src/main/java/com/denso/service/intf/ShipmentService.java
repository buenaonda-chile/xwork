package com.denso.service.intf;

import java.util.HashMap;
import java.util.List;

public interface ShipmentService {
	
	List<HashMap<String, String>> getFSAZ100List(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> setFSAZ100List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam) throws Exception;

	List<HashMap<String, String>> getFSAZ110List(HashMap<String, String> reqMap);

	List<HashMap<String, String>> setFSAZ110List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam) throws Exception;

	List<HashMap<String, String>> getFSAZ120List(HashMap<String, String> reqMap);

	List<HashMap<String, String>> setFSAZ120List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam) throws Exception;

	List<HashMap<String, String>> getFSAZ130List(HashMap<String, String> reqMap);

	List<HashMap<String, String>> getFSAZ130ListAll(HashMap<String, String> reqMap);

	List<HashMap<String, String>> setFSAZ130List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam) throws Exception;

	List<HashMap<String, String>> setFSAZ130List2(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam) throws Exception;

	List<HashMap<String, String>> getFSAZ140List(HashMap<String, String> reqMap);

	List<HashMap<String, String>> setFSAZ140List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam) throws Exception;

	List<HashMap<String, String>> getFSAZ150List(HashMap<String, String> reqMap);

	List<HashMap<String, String>> setFSAZ150List(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam) throws Exception;

	List<HashMap<String, String>> getFSAZ150ListView(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> getFSAZ151List(HashMap<String, String> reqMap);

	List<HashMap<String, String>> getFSAZ160QList(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> getFSAZ160Q_PList(HashMap<String, String> reqMap);

	List<HashMap<String, String>> getFSAZ170QList(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> getSC008PRList(HashMap<String, String> reqMap);

	List<HashMap<String, String>> getFSAZ180QList(HashMap<String, String> reqMap);

}

