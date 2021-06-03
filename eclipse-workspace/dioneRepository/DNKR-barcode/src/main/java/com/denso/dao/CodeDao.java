package com.denso.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.denso.mapper.CodeMapper;
import com.denso.model.CodeCategory;
import com.denso.model.CodeDetail;
import com.denso.model.TblProduct;
import com.denso.param.CodeInqueryParam;

@Repository
public class CodeDao {
	@Autowired
	private CodeMapper codeMapper;
	
	public List<CodeCategory> findAll(CodeInqueryParam param){
		return codeMapper.findAll(param);
	}
	
	public CodeDetail findOne(String code) {
		return codeMapper.findOne(code);
	}
	
	public List<CodeDetail> categoryfindAll(CodeInqueryParam param){
		return codeMapper.categoryfindAll(param);
	}
	
	public List<TblProduct> productfindAll(String code){
		return codeMapper.productfindAll(code);
	}


}
