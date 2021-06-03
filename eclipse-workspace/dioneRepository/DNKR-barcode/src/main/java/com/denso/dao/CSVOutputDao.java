package com.denso.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.denso.mapper.CSVOutputMapper;
import com.denso.model.TblSJT;

@Repository
public class CSVOutputDao {

	@Autowired
	private CSVOutputMapper CSVOutputMapper;
	
	public List<HashMap<String, String>> test() {
		return CSVOutputMapper.test();
	}
	public List<TblSJT> testGroup() {
		return CSVOutputMapper.testGroup();
	}
}
