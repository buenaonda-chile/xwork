package com.denso.service.intf;

import com.denso.common.intf.Page;
import com.denso.common.intf.Pageable;
import com.denso.model.TblBoard;
import com.denso.param.NoticeParam;

public interface NoticeService {

	Page<TblBoard> getNoticePage(NoticeParam noticeParam, Pageable pageable);

	void noticeProc(TblBoard convertToTblBoard, String type);

	TblBoard getNoticeInfo(String seq);
}
