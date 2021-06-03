package com.denso.mapper;

import java.util.HashMap;
import java.util.List;

public interface ShipmentMapper {
	
	//FSAZ100
	List<HashMap<String, String>> selectFSAZ100List(HashMap<String, String> reqMap);
	
	HashMap<String, String> selectFSAZ100Check(HashMap<String, String> reqMap);

	void insertFSAZ100List(HashMap<String, String> reqMap);

	void updateFSAZ100List(HashMap<String, String> reqMap);

	void deleteFSAZ100List(HashMap<String, String> reqMap);
	
	//FSAZ110
	List<HashMap<String, String>> selectFSAZ110List(HashMap<String, String> reqMap);
	
	HashMap<String, String> selectFSAZ110Check(HashMap<String, String> reqMap);

	void insertFSAZ110List(HashMap<String, String> reqMap);

	void updateFSAZ110List(HashMap<String, String> reqMap);

	void deleteFSAZ110List(HashMap<String, String> reqMap);
	
	//FSAZ120
	List<HashMap<String, String>> selectFSAZ120List(HashMap<String, String> reqMap);

	HashMap<String, String> selectFSAZ120Check(HashMap<String, String> reqMap);

	void insertFSAZ120List(HashMap<String, String> reqMap);

	void updateFSAZ120List(HashMap<String, String> reqMap);

	void deleteFSAZ120List(HashMap<String, String> reqMap);
	
	//FSAZ130
	List<HashMap<String, String>> selectFSAZ130List(HashMap<String, String> reqMap);

	List<HashMap<String, String>> selectFSAZ130ListAll(HashMap<String, String> reqMap);

	HashMap<String, String> selectFSAZ130Check(HashMap<String, String> reqMap);

	void insertFSAZ130List(HashMap<String, String> reqMap);

	void updateFSAZ130List(HashMap<String, String> reqMap);

	void deleteFSAZ130List(HashMap<String, String> reqMap);
	
	void deleteFSAZ130ListAll(HashMap<String, String> reqMap);

	//FSAZ140
	List<HashMap<String, String>> selectFSAZ140List(HashMap<String, String> reqMap);
	
	HashMap<String, String> selectFSAZ140Check(HashMap<String, String> reqMap);

	void insertFSAZ140List(HashMap<String, String> reqMap);

	void updateFSAZ140List(HashMap<String, String> reqMap);

	void deleteFSAZ140List(HashMap<String, String> reqMap);
	
	//FSAZ150
	List<HashMap<String, String>> selectFSAZ150List(HashMap<String, String> reqMap);
	
	HashMap<String, String> selectFSAZ150Check(HashMap<String, String> reqMap);

	void insertFSAZ150List(HashMap<String, String> reqMap);

	void updateFSAZ150List(HashMap<String, String> reqMap);

	void deleteFSAZ150List(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> selectFSAZ150ListView(HashMap<String, String> reqMap);

	//FSAZ151
	List<HashMap<String, String>> selectFSAZ151List(HashMap<String, String> reqMap);
	
	//FSAZ160
	List<HashMap<String, String>> selectFSAZ160QList(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> selectFSAZ160Q_PList(HashMap<String, String> reqMap);

	//FSAZ170
	List<HashMap<String, String>> selectFSAZ170QList(HashMap<String, String> reqMap);
	
	List<HashMap<String, String>> selectSC008PRList(HashMap<String, String> reqMap);

	//FSAZ180Q
	List<HashMap<String, String>> selectFSAZ180QList(HashMap<String, String> reqMap);

}
