package com.gxz.sys.service;

import java.util.List;

import com.gxz.sys.domain.Notice;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.vo.NoticeVo;

public interface NoticeService {
	
	DataGridView queryAllNotice(NoticeVo noticeVo);
	
	Notice queryNoticeById(Integer noticeId);
	
	void addNotice(NoticeVo noticeVo);
	
	void updateNotice(NoticeVo noticeVo);
	
	void deleteNotice(Integer noticeId);

	List<Notice> queryAllNewNotice(NoticeVo noticeVo);
	
}
