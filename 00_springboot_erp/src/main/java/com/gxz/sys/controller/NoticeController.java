package com.gxz.sys.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gxz.sys.constast.SYSConstast;
import com.gxz.sys.domain.Notice;
import com.gxz.sys.domain.User;
import com.gxz.sys.service.NoticeService;
import com.gxz.sys.utils.WebUtils;
import com.gxz.sys.utils.json.DataGridView;
import com.gxz.sys.utils.json.ResultObj;
import com.gxz.sys.vo.NoticeVo;

@RestController
@RequestMapping("notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("loadAllNotice")
	public DataGridView loadAllNotice(NoticeVo noticeVo) {
		return noticeService.queryAllNotice(noticeVo);
	}
	
	@RequestMapping("loadNoticeById")
	public Notice loadNoticeById(NoticeVo noticeVo) {
		return noticeService.queryNoticeById(noticeVo.getId());
	}
	
	@RequestMapping("addNotice")
	public ResultObj addNotice(NoticeVo noticeVo) {
		User user= (User) WebUtils.getCurrentSession().getAttribute("user");
		noticeVo.setCreatetime(new Date());
		noticeVo.setOpername(user.getName());
		ResultObj resultObj = null;
		try {
			noticeService.addNotice(noticeVo);
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_ADD_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_ADD_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("updateNotice")
	public ResultObj updateNotice(NoticeVo noticeVo) {
		User user= (User) WebUtils.getCurrentSession().getAttribute("user");
		noticeVo.setCreatetime(new Date());
		noticeVo.setOpername(user.getName());
		
		ResultObj resultObj = null;
		try {
			noticeService.updateNotice(noticeVo);
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_UPDATE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_UPDATE_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("deleteNotice")
	public ResultObj deleteNotice(NoticeVo noticeVo) {
		ResultObj resultObj = null;
		try {
			noticeService.deleteNotice(noticeVo.getId());
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		
		return resultObj;
	}
	
	@RequestMapping("batchDeleteNotice")
	public ResultObj batchDeleteNotice(NoticeVo noticeVo) {
		String[] ids = noticeVo.getBatchIds().split(",");
		ResultObj resultObj = null;
		try {
			for (String id : ids) {
				noticeService.deleteNotice(Integer.parseInt(id));
			}
			resultObj = new ResultObj(1,SYSConstast.SYS_OPTION_DELETE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			resultObj = new ResultObj(0,SYSConstast.SYS_OPTION_DELETE_ERROR);
		}
		
		return resultObj;
	}
	
	/**
	 * 首页的公告信息显示
	 */
	public List<Notice> queryAllNotice(NoticeVo noticeVo){
		return noticeService.queryAllNewNotice(noticeVo);
	}
}