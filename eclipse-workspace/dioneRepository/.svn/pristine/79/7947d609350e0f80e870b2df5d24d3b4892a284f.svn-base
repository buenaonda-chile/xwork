package com.denso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.denso.common.intf.Page;
import com.denso.common.intf.Pageable;
import com.denso.dao.NoticeDao;
import com.denso.model.TblBoard;
import com.denso.param.NoticeParam;
import com.denso.service.intf.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;

	@Transactional
	@Override
	public void noticeProc(TblBoard tblBoard, String type) {
		if("regist".equals(type)){
			noticeDao.save(tblBoard);	
		} else if("update".equals(type)){
			noticeDao.update(tblBoard);
		} else if("delete".equals(type)){
			noticeDao.delete(tblBoard);
		}
	}

	@Override
	public Page<TblBoard> getNoticePage(NoticeParam noticeParam,
			Pageable pageable) {
		Page<TblBoard> noticePage =  noticeDao.findAllToPage(noticeParam, pageable);
		return noticePage;
	}

	@Override
	public TblBoard getNoticeInfo(String seq) {
		TblBoard noticeInfo = noticeDao.findOne(seq);
		
		return noticeInfo;
	}

}
