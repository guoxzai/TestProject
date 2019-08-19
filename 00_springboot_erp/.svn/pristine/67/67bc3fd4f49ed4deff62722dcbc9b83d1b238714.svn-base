package com.gxz.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxz.sys.domain.Notice;
import com.gxz.sys.mapper.NoticeMapper;
import com.gxz.sys.service.NoticeService;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.vo.NoticeVo;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public DataGridView queryAllNotice(NoticeVo noticeVo) {
		Page<Object> page = PageHelper.startPage(noticeVo.getPage(), noticeVo.getLimit());
		List<Notice> data = noticeMapper.queryAllNotice(noticeVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addNotice(NoticeVo noticeVo) {
		noticeMapper.insertSelective(noticeVo);
	}

	@Override
	public void updateNotice(NoticeVo noticeVo) {
		noticeMapper.updateByPrimaryKeyWithBLOBs(noticeVo);
	}

	@Override
	public void deleteNotice(Integer noticeId) {
		noticeMapper.deleteByPrimaryKey(noticeId);
	}

	@Override
	public Notice queryNoticeById(Integer noticeId) {
		return noticeMapper.selectByPrimaryKey(noticeId);
	}

	
	/**
	 * 前台首页全查询
	 */
	@Override
	public List<Notice> queryAllNewNotice(NoticeVo noticeVo) {
		return noticeMapper.queryAllNotice(noticeVo);
	}

}
