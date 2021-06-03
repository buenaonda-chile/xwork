package com.denso.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denso.dao.CSVOutputDao;
import com.denso.model.TblSJT;
import com.denso.service.intf.CSVOutputService;

@Service
public class CSVOutputServiceImpl implements CSVOutputService{

	@Autowired
	private CSVOutputDao CSVOutputDao;

	@Override
	public List<HashMap<String, String>> test() {
		return CSVOutputDao.test();
	}
	@Override
	public List<TblSJT> testGroup() {
		return CSVOutputDao.testGroup();
	}
	
}