package com.denso.mapper;

import java.util.List;
import java.util.Map;

import com.denso.model.TblBoard;
import com.denso.param.NoticeParam;

public interface NoticeMapper {
	
	long count(NoticeParam inqueryParam);
	
	List<TblBoard> findAll(String noticeType);
	
	List<TblBoard> findAllToPage(Map<String, Object> parameterMap);
	
	int save(TblBoard tblBoard);

	int update(TblBoard tblBoard);

	TblBoard findOne(String seq);

	void delete(String seq);
	
}
