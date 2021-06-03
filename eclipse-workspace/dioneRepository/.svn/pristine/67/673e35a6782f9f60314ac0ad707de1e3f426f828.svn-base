package com.denso.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.denso.common.intf.Page;
import com.denso.common.intf.Pageable;
import com.denso.common.util.ModelUtil;
import com.denso.mapper.NoticeMapper;
import com.denso.model.PageImpl;
import com.denso.model.TblBoard;
import com.denso.param.NoticeParam;

@Repository
public class NoticeDao {

	@Autowired
	private NoticeMapper noticeMapper;

	public Page<TblBoard> findAllToPage(NoticeParam inqueryParam,
			Pageable pageable) {
		
		int startRow = (pageable!=null ? pageable.getPageNumber()*pageable.getPageSize() : 0);
		int endRow = (pageable!=null ? startRow + pageable.getPageSize() : 0);
		
		Map<String, Object> parameterMap = null;
		if(inqueryParam == null) {
			parameterMap = new HashMap<String, Object>();
		} else {
			parameterMap = ModelUtil.getParameterMap(NoticeParam.class, inqueryParam);
		}
		parameterMap.put("_sort", pageable.getSort());
		parameterMap.put("_startRow", startRow);
		parameterMap.put("_endRow", endRow);
		
		long count = noticeMapper.count(inqueryParam);
		List<TblBoard> resultList = noticeMapper.findAllToPage(parameterMap);
		
		return new PageImpl<TblBoard>(resultList, pageable, count);
		
	}
	
	public int save(TblBoard tblBoard) {
		return noticeMapper.save(tblBoard);
	}

	public int update(TblBoard tblBoard) {
		return noticeMapper.update(tblBoard);
	}

	public TblBoard findOne(String seq) {
		return noticeMapper.findOne(seq);
	}

	public void delete(TblBoard tblBoard) {
		noticeMapper.delete(tblBoard.getSeq());
	}
	
}
