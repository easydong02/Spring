package com.koreait.springmvc1223.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc1223.domain.Notice;
import com.koreait.springmvc1223.model.service.notice.NoticeService;

public class UpdateController implements Controller{
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Notice notice = new Notice();
		notice.setTitle(request.getParameter("title"));
		notice.setWriter(request.getParameter("writer"));
		notice.setContent(request.getParameter("content"));
		notice.setNotice_id(Integer.parseInt(request.getParameter("notice_id")));
		
		
		
		int result =noticeService.update(notice);
		
		ModelAndView mav=  new ModelAndView();
		mav.setViewName("redirect:/notice/detail?notice_id="+notice.getNotice_id()); //forwarding이 디폴트, 요청 끊으려면 redirect
		// /notice/detail?notice_id=
		return mav;
	}

}
